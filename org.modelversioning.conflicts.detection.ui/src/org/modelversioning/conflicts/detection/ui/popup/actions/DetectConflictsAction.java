package org.modelversioning.conflicts.detection.ui.popup.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.impl.ConflictDetectionEngineImpl;
import org.modelversioning.conflicts.detection.impl.ThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.ui.ConflictDetectionUIPlugin;
import org.modelversioning.core.impl.UUIDResourceFactoryImpl;
import org.modelversioning.core.match.MatchException;
import org.modelversioning.core.match.service.MatchService;
import org.modelversioning.operations.detection.service.OperationDetectionService;

/**
 * Action invoking the conflict detection for the selected {@link IFile IFiles}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class DetectConflictsAction implements IObjectActionDelegate {

	private Shell shell;
	private IFile file1;
	private IFile file2;
	private IFile file3;

	/**
	 * Constructor for this action.
	 */
	public DetectConflictsAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, new WorkbenchLabelProvider());
		dialog.setAllowDuplicates(false);
		dialog.setElements(new IFile[] { file1, file2, file3 });
		dialog.setMultipleSelection(false);
		dialog.setMessage("Select original model version");
		dialog.setTitle("Select original model");
		if (dialog.open() == ElementListSelectionDialog.OK) {

			// determine files
			IFile originFile = (IFile) dialog.getFirstResult();
			IFile otherFile1 = null;
			IFile otherFile2 = null;
			if (!originFile.equals(file1)) {
				otherFile1 = file1;
			}
			if (!originFile.equals(file2)) {
				if (otherFile1 == null) {
					otherFile1 = file2;
				} else {
					otherFile2 = file2;
				}
			}
			if (!originFile.equals(file3)) {
				if (otherFile1 == null) {
					otherFile1 = file3;
				} else {
					otherFile2 = file3;
				}
			}

			try {
				process(originFile, otherFile1, otherFile2);
			} catch (RuntimeException e) {
				reportConflictDetectionException(e);
			} catch (InvocationTargetException e) {
				reportConflictDetectionException(e);
			} catch (InterruptedException e) {
				reportConflictDetectionException(e);
			}

		}
	}

	/**
	 * @param e
	 */
	private void reportConflictDetectionException(Throwable e) {
		IStatus status = new Status(IStatus.ERROR,
				ConflictDetectionUIPlugin.PLUGIN_ID,
				"An error occurred while performing the conflict detection", e);
		ErrorDialog.openError(shell, "Error occurred", e.getMessage(), status,
				0);
		ConflictDetectionUIPlugin.getDefault().getLog().log(status);
	}

	private void process(final IFile originFile, final IFile otherFile1,
			final IFile otherFile2) throws InvocationTargetException,
			InterruptedException {
		ConflictDetectionUIPlugin.getDefault().getWorkbench()
				.getProgressService()
				.run(false, false, new IRunnableWithProgress() {
					@Override
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						try {
							doProcess(originFile, otherFile1, otherFile2,
									monitor);
						} catch (MatchException e) {
							throw new InvocationTargetException(e);
						} catch (IOException e) {
							throw new InvocationTargetException(e);
						}
					}
				});
	}

	private void doProcess(IFile originFile, IFile otherFile1,
			IFile otherFile2, IProgressMonitor monitor) throws MatchException,
			IOException {

		monitor.beginTask("Detecting Conflicts", 6);

		// reading files
		monitor.subTask("Reading files");
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new UUIDResourceFactoryImpl()); //$NON-NLS-1$
		Resource originResource = resourceSet.getResource(URI
				.createPlatformResourceURI(originFile.getFullPath().toString(),
						true), true);
		Resource otherResource1 = resourceSet.getResource(URI
				.createPlatformResourceURI(otherFile1.getFullPath().toString(),
						true), true);
		Resource otherResource2 = resourceSet.getResource(URI
				.createPlatformResourceURI(otherFile2.getFullPath().toString(),
						true), true);
		monitor.worked(1);

		// Matching
		monitor.subTask("Matching models");
		MatchService matchService = new MatchService();
		MatchModel match1 = matchService.generateMatchModel(originResource,
				otherResource1);
		MatchModel match2 = matchService.generateMatchModel(originResource,
				otherResource2);
		monitor.worked(1);

		// Diffing
		monitor.subTask("Diffing models");
		org.modelversioning.core.diff.service.DiffService diffService = new org.modelversioning.core.diff.service.DiffService();
		ComparisonResourceSnapshot crs1 = diffService
				.generateComparisonResourceSnapshot(match1);
		ComparisonResourceSnapshot crs2 = diffService
				.generateComparisonResourceSnapshot(match2);
		OperationDetectionService operationDetectionService = new OperationDetectionService();
		operationDetectionService.findAndAddOperationOccurrences(crs1);
		operationDetectionService.findAndAddOperationOccurrences(crs2);
		monitor.worked(1);

		// Creating DiffProvider
		monitor.subTask("Reading diffs");
		IThreeWayDiffProvider threeWayDiff = new ThreeWayDiffProvider(crs1,
				crs2);
		monitor.worked(1);

		// Detect Conflicts
		monitor.subTask("Detecting conflicts");
		ConflictDetectionEngineImpl engine = new ConflictDetectionEngineImpl();
		engine.setOperationContractViolationAware(true);
		ConflictReport conflictReport = engine.detectConflicts(threeWayDiff,
				new SubProgressMonitor(monitor, 1));
		monitor.worked(1);

		// Save Conflict Report
		monitor.subTask("Saving conflict report");
		SaveAsDialog saveAsDialog = new SaveAsDialog(shell) {
			@Override
			protected Control createContents(Composite parent) {
				Control contents2 = super.createContents(parent);
				setTitle("Save Conflict Report");
				setMessage("Select a file to save conflict report.");
				return contents2;
			}
		};
		IFile conflictReportFile = originFile.getParent().getFile(
				new Path(originFile.getName() + "." //$NON-NLS-1$
						+ ConflictDetectionUIPlugin.CONFLICT_REPORT_EXTENSION));
		saveAsDialog.setOriginalFile(conflictReportFile);
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				Resource conflictReportResource = resourceSet
						.createResource(URI.createPlatformResourceURI(file
								.getFullPath().toString(), true));
				conflictReportResource.getContents().add(conflictReport);
				conflictReportResource.save(Collections.emptyMap());
			}
		}
		monitor.worked(1);
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 3) {
				List<?> list = structuredSelection.toList();
				file1 = (IFile) list.get(0);
				file2 = (IFile) list.get(1);
				file3 = (IFile) list.get(2);
				action.setEnabled(true);
			}
		}
	}

}
