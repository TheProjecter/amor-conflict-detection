package org.modelversioning.conflicts.ui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DeleteUpdate;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;
import org.modelversioning.conflictreport.conflict.OverlappingChange;
import org.modelversioning.conflictreport.conflict.UpdateUpdate;
import org.modelversioning.conflicts.ui.ConflictsUIPlugin;
import org.modelversioning.core.impl.UUIDResourceFactoryImpl;
import org.modelversioning.operations.ui.diff.OperationDiffContentProvider;
import org.modelversioning.ui.commons.ILineDecorationProvider;
import org.modelversioning.ui.commons.ITreeConnectionProvider;
import org.modelversioning.ui.commons.ITreeView;
import org.modelversioning.ui.commons.parts.LineDrawingCenterPart;

/**
 * A basic editor showing a conflict report.
 * 
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ConflictReportEditor extends EditorPart implements
		ITreeConnectionProvider, ILineDecorationProvider {

	/**
	 * The file containing the conflict report.
	 */
	private IFile conflictReportFile;

	/**
	 * The resource set to use.
	 */
	private final ResourceSet resourceSet = new ResourceSetImpl();

	private Resource conflictReportResource;

	private ConflictReport conflictReport;

	private LineDrawingCenterPart centerPart;

	private TreeViewer leftDiffTreeViewer;

	private TreeViewer rightDiffTreeViewer;

	private TreeViewer conflictTreeViewer;

	private TreeItem selectedLeftDiffTreeItem;

	private TreeItem selectedRightDiffTreeItem;

	public ConflictReportEditor() {
		super();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new UUIDResourceFactoryImpl());
	}

	public void dispose() {
		super.dispose();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// we don't save anything
	}

	@Override
	public void doSaveAs() {
		// implement
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// guard wrong input
		if (!(input instanceof IFileEditorInput)) {
			throw new PartInitException(
					"Invalid Input: Must be IFileEditorInput");
		}

		conflictReportFile = ((IFileEditorInput) input).getFile();
		this.setPartName(((IFileEditorInput) input).getFile().getName());
		conflictReportResource = resourceSet.getResource(
				URI.createFileURI(conflictReportFile.getLocation().toString()),
				true);
		if (conflictReportResource != null
				&& conflictReportResource.getContents() != null
				&& conflictReportResource.getContents().size() > 0) {
			EObject eObject = conflictReportResource.getContents().get(0);
			if (eObject instanceof ConflictReport) {
				conflictReport = (ConflictReport) eObject;
			}
		}

		// Must not be null!
		if (conflictReport == null) {
			PartInitException e = new PartInitException(
					"Could not load conflict report");
			showError(e);
			throw e;
		}

		// set site and input
		this.setSite(site);
		this.setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			int spacing = 2;
			int margins = 2;
			layout.marginBottom = margins;
			layout.marginTop = margins;
			layout.marginLeft = margins;
			layout.marginRight = margins;
			layout.horizontalSpacing = spacing;
			layout.verticalSpacing = spacing;
			parent.setLayout(layout);
		}

		GridData gd = new GridData(GridData.FILL_BOTH);
		// gd.heightHint = 100;

		// left changes
		leftDiffTreeViewer = new TreeViewer(parent, SWT.MULTI
				| GridData.FILL_BOTH | GridData.GRAB_VERTICAL | SWT.BORDER);
		Tree leftTree = leftDiffTreeViewer.getTree();
		leftTree.addTreeListener(new TreeListener() {
			@Override
			public void treeExpanded(TreeEvent e) {
				refreshCenterPart();
			}

			@Override
			public void treeCollapsed(TreeEvent e) {
				refreshCenterPart();
			}
		});
		leftTree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.item instanceof TreeItem)
					setSelectedLeftDiffItem((TreeItem) e.item);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		leftTree.setHeaderVisible(false);
		leftTree.setLayoutData(gd);
		leftTree.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				refreshCenterPart();
			}

		});
		leftDiffTreeViewer
				.setContentProvider(new OperationDiffContentProvider());
		leftDiffTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				AdapterUtils.getAdapterFactory()));
		leftDiffTreeViewer.setInput(this.conflictReport.getLeftVersion()
				.getDiff());
		leftDiffTreeViewer.expandAll();

		// add center part container
		Composite centerPartContainer = new Composite(parent, SWT.NO_FOCUS
				| SWT.NO_SCROLL);
		centerPartContainer.setLayout(new FillLayout());
		centerPartContainer
				.setLayoutData(createCenterPartContainerGridData(100));

		// right changes
		rightDiffTreeViewer = new TreeViewer(parent, SWT.MULTI
				| GridData.FILL_BOTH | GridData.GRAB_VERTICAL | SWT.BORDER);
		Tree rightTree = rightDiffTreeViewer.getTree();
		rightTree.addTreeListener(new TreeListener() {
			@Override
			public void treeExpanded(TreeEvent e) {
				refreshCenterPart();
			}

			@Override
			public void treeCollapsed(TreeEvent e) {
				refreshCenterPart();
			}
		});
		rightTree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.item instanceof TreeItem)
					setSelectedRightDiffItem((TreeItem) e.item);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		rightTree.setHeaderVisible(false);
		rightTree.setLayoutData(gd);
		rightTree.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				refreshCenterPart();
			}

		});
		rightDiffTreeViewer
				.setContentProvider(new OperationDiffContentProvider());
		rightDiffTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				AdapterUtils.getAdapterFactory()));
		rightDiffTreeViewer.setInput(this.conflictReport.getRightVersion()
				.getDiff());
		rightDiffTreeViewer.expandAll();

		ITreeView leftTreeView = new ITreeView() {
			@Override
			public Tree getTree() {
				return leftDiffTreeViewer.getTree();
			}
		};

		ITreeView rightTreeView = new ITreeView() {
			@Override
			public Tree getTree() {
				return rightDiffTreeViewer.getTree();
			}
		};

		centerPart = new LineDrawingCenterPart(centerPartContainer,
				leftTreeView, rightTreeView, 100,
				(ITreeConnectionProvider) this, (ILineDecorationProvider) this);

		conflictTreeViewer = new TreeViewer(parent, SWT.MULTI
				| GridData.FILL_BOTH | GridData.GRAB_VERTICAL | SWT.BORDER);
		Tree conflictTree = conflictTreeViewer.getTree();
		conflictTree.setHeaderVisible(false);
		GridData conflictGridData = new GridData(GridData.FILL_BOTH);
		conflictGridData.horizontalSpan = 3;
		conflictGridData.heightHint = 10;
		conflictTree.setLayoutData(conflictGridData);
		conflictTreeViewer
				.setContentProvider(new AdapterFactoryContentProvider(
						AdapterUtils.getAdapterFactory()) {
					@Override
					public Object[] getChildren(Object object) {
						Object[] children = super.getChildren(object);
						ArrayList<Object> list = new ArrayList<Object>();
						for (Object child : children) {
							if (!(child instanceof ComparisonResourceSnapshot)) {
								list.add(child);
							}
						}
						if (object instanceof OverlappingChange) {
							OverlappingChange overlappingChange = (OverlappingChange) object;
							list.add(overlappingChange.getLeftChange());
							list.add(overlappingChange.getRightChange());

						}
						return list.toArray();
					}

					@Override
					public boolean hasChildren(Object object) {
						if (object instanceof OverlappingChange) {
							return true;
						}
						return super.hasChildren(object);
					}

					@Override
					public Object[] getElements(Object object) {
						Object[] elements = super.getElements(object);
						ArrayList<Object> list = new ArrayList<Object>();
						for (Object element : elements) {
							if (!(element instanceof ComparisonResourceSnapshot)) {
								list.add(element);
							}
						}
						return list.toArray();
					}
				});
		conflictTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				AdapterUtils.getAdapterFactory()));
		conflictTreeViewer.setInput(this.conflictReport);
		final Tree leftDiffTree = leftTree;
		final Tree rightDiffTree = rightTree;
		conflictTree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.item instanceof TreeItem) {
					if (((TreeItem) e.item).getData() instanceof Conflict) {
						Conflict conflict = (Conflict) ((TreeItem) e.item)
								.getData();
						selectedLeftDiffTreeItem = getTreeItem(
								conflict.getLeftChange(),
								leftDiffTree.getItems());
						selectedRightDiffTreeItem = getTreeItem(
								conflict.getRightChange(),
								rightDiffTree.getItems());
						notifyDiffSelection(Side.LEFT);
						notifyDiffSelection(Side.RIGHT);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		parent.layout(true);
		parent.setVisible(true);
	}

	private void setSelectedLeftDiffItem(TreeItem treeItem) {
		this.selectedLeftDiffTreeItem = treeItem;
		this.selectedRightDiffTreeItem = null;
		notifyDiffSelection(Side.LEFT);
	}

	private void setSelectedRightDiffItem(TreeItem treeItem) {
		this.selectedRightDiffTreeItem = treeItem;
		this.selectedLeftDiffTreeItem = null;
		notifyDiffSelection(Side.RIGHT);
	}

	public void notifyDiffSelection(Side side) {
		DiffElement selectedDiffElement = null;
		List<DiffElement> conflictingDiffElements = new ArrayList<DiffElement>();
		List<Conflict> conflictElements = new ArrayList<Conflict>();
		Tree oppositeTree = null;
		if (Side.LEFT.equals(side)) {
			selectedDiffElement = (DiffElement) selectedLeftDiffTreeItem
					.getData();
			oppositeTree = rightDiffTreeViewer.getTree();
		} else {
			selectedDiffElement = (DiffElement) selectedRightDiffTreeItem
					.getData();
			oppositeTree = leftDiffTreeViewer.getTree();
		}
		for (Conflict conflict : conflictReport.getConflicts()) {
			if (conflict.getLeftChange().equals(selectedDiffElement)) {
				conflictingDiffElements.add(conflict.getRightChange());
				conflictElements.add(conflict);
			}
			if (conflict.getRightChange().equals(selectedDiffElement)) {
				conflictingDiffElements.add(conflict.getLeftChange());
				conflictElements.add(conflict);
			}
		}
		// diff selection
		List<TreeItem> treeItemsToSelect = new ArrayList<TreeItem>();
		for (DiffElement conflictingDiffElement : conflictingDiffElements) {
			TreeItem treeItemToSelect = getTreeItem(conflictingDiffElement,
					oppositeTree.getItems());
			if (treeItemsToSelect != null) {
				treeItemsToSelect.add(treeItemToSelect);
			}
		}
		if (treeItemsToSelect.size() > 0) {
			oppositeTree.setSelection(treeItemsToSelect
					.toArray(new TreeItem[treeItemsToSelect.size()]));
		}
		refreshCenterPart();

		// conflict selection
		List<TreeItem> conflictTreeItemsToSelect = new ArrayList<TreeItem>();
		for (Conflict conflictElement : conflictElements) {
			TreeItem treeItemToSelect = getConflictTreeItem(conflictElement,
					conflictTreeViewer.getTree().getItems());
			if (conflictTreeItemsToSelect != null) {
				conflictTreeItemsToSelect.add(treeItemToSelect);
			}
		}
		if (conflictTreeItemsToSelect.size() > 0) {
			conflictTreeViewer.getTree().setSelection(
					conflictTreeItemsToSelect
							.toArray(new TreeItem[treeItemsToSelect.size()]));
		}
	}

	private void refreshCenterPart() {
		centerPart.redraw();
	}

	/**
	 * Creates the {@link GridData} for the center part.
	 * 
	 * @return the {@link GridData} for the tree view container.
	 */
	private GridData createCenterPartContainerGridData(int centerPartWidth) {
		GridData gridData = new GridData();
		gridData.widthHint = centerPartWidth;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		return gridData;
	}

	@Override
	public void setFocus() {
		this.leftDiffTreeViewer.getTree().setFocus();
		this.rightDiffTreeViewer.getTree().setFocus();
	}

	/**
	 * Displays an error dialog for the specified exception.
	 * 
	 * @param e
	 *            exception to display.
	 */
	private void showError(Exception e) {
		IStatus status = new Status(IStatus.ERROR, ConflictsUIPlugin.PLUGIN_ID,
				e.getLocalizedMessage(), e);
		// log error
		ConflictsUIPlugin.getDefault().getLog().log(status);
		// show error
		ErrorDialog
				.openError(getSite().getShell(),
						"Unhandled Exception Occurred",
						e.getLocalizedMessage(), status);
	}

	@Override
	public ILineDecoration getLineDecoration(TreeItem leftItem,
			TreeItem rightItem, boolean isOneHidden) {
		int lineStyle = SWT.LINE_SOLID;
		RGB color = new RGB(50, 50, 220);
		int width = 1;
		// make hidden thinner and lighter
		if (isOneHidden) {
			lineStyle = SWT.LINE_DOT;
			width = 1;
		}
		for (EquivalentChange equivalentChange : conflictReport
				.getEquivalentChanges()) {
			if (equivalentChange.getLeftChange().equals(leftItem.getData())
					&& equivalentChange.getRightChange().equals(
							rightItem.getData())) {
				lineStyle = SWT.LINE_DOT;
				width = 1;
				color = new RGB(200, 200, 200);
			}
		}
		for (Conflict conflict : conflictReport.getConflicts()) {
			if (conflict.getLeftChange().equals(leftItem.getData())
					&& conflict.getRightChange().equals(rightItem.getData())) {
				if (conflict instanceof UpdateUpdate) {
					color = new RGB(230, 45, 40);
				} else if (conflict instanceof DeleteUpdate) {
					color = new RGB(110, 145, 240);
				} else if (conflict instanceof OperationContractViolation) {
					color = new RGB(145, 110, 240);
				}
			}
		}
		if (leftItem.equals(selectedLeftDiffTreeItem)
				|| rightItem.equals(selectedRightDiffTreeItem)) {
			width = 2;
		}
		return new LineDecoration(color, lineStyle, width);
	}

	@Override
	public TreeItem[] getConnectedItems(TreeItem leftItem, Tree rightTree) {
		List<TreeItem> treeItems = new ArrayList<TreeItem>();
		if (leftItem.getData() instanceof DiffElement) {
			DiffElement diffElement = (DiffElement) leftItem.getData();
			for (Conflict conflict : this.conflictReport.getConflicts()) {
				if (conflict.getLeftChange().equals(diffElement)) {
					TreeItem rightItem = getTreeItem(conflict.getRightChange(),
							rightTree.getItems());
					if (rightItem != null) {
						treeItems.add(rightItem);
					}
				}
			}
			for (EquivalentChange equivalentChange : this.conflictReport
					.getEquivalentChanges()) {
				if (equivalentChange.getLeftChange().equals(diffElement)) {
					TreeItem rightItem = getTreeItem(
							equivalentChange.getRightChange(),
							rightTree.getItems());
					if (rightItem != null) {
						treeItems.add(rightItem);
					}
				}
			}
		}
		return treeItems.toArray(new TreeItem[treeItems.size()]);
	}

	private TreeItem getTreeItem(DiffElement diffElement, TreeItem[] treeItems) {
		for (TreeItem treeItem : treeItems) {
			if (treeItem.getData().equals(diffElement)) {
				return treeItem;
			}
			TreeItem i;
			if ((i = getTreeItem(diffElement, treeItem.getItems())) != null) {
				return i;
			}
		}
		return null;
	}

	private TreeItem getConflictTreeItem(Conflict conflictElement,
			TreeItem[] items) {
		for (TreeItem treeItem : items) {
			if (treeItem.getData().equals(conflictElement)) {
				return treeItem;
			}
			TreeItem i;
			if ((i = getConflictTreeItem(conflictElement, treeItem.getItems())) != null) {
				return i;
			}
		}
		return null;
	}

}
