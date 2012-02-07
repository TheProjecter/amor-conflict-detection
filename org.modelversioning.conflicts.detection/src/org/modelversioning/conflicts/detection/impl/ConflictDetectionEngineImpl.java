/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.conflicts.detection.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.ConflictReportFactory;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IConflictDetectionEngine;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;
import org.modelversioning.conflicts.detection.engine.IViolationDetector;
import org.modelversioning.merge.IMerger;
import org.modelversioning.merge.impl.MergerImpl;

/**
 * A default implementation of the {@link IConflictDetectionEngine}, which uses
 * the registered conflict detectors via the extension points.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ConflictDetectionEngineImpl implements IConflictDetectionEngine {

	private static final String IOPERATIONCONFLICTDETECTOR_ID = "org.modelversioning.conflicts.detection.operationconflictdetector";

	/**
	 * The list of {@link IOperationConflictDetector
	 * IOverlappingChangeDetectors}
	 */
	private List<IOperationConflictDetector> operationConflictDetectors = new ArrayList<IOperationConflictDetector>();

	/**
	 * The list of {@link IViolationDetector IViolationDetectors}
	 */
	private List<IViolationDetector> violationDetectors = new ArrayList<IViolationDetector>();

	/**
	 * The merger used for creating a merged version to apply
	 * {@link IViolationDetector IViolationDetectors}.
	 */
	private IMerger merger = new MergerImpl();

	/**
	 * Default constructor creating a detector. Loads the conflict detections
	 * from extension points.
	 */
	public ConflictDetectionEngineImpl() {
		loadConflictDetectorsFromExtensionPoint();
	}

	private void loadConflictDetectorsFromExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IOPERATIONCONFLICTDETECTOR_ID);
		for (IConfigurationElement e : config) {
			try {
				Object o = e.createExecutableExtension("class");
				if (o instanceof IOperationConflictDetector) {
					this.operationConflictDetectors
							.add((IOperationConflictDetector) o);
				}
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Creates a conflict detection engine with the specified list of
	 * <code>overlappingChangeDetectors</code> and
	 * <code>violationDetectors</code>.
	 * 
	 * @param operationConflictDetectors
	 *            to set.
	 * @param violationDetectors
	 *            to set.
	 */
	public ConflictDetectionEngineImpl(
			List<IOperationConflictDetector> operationConflictDetectors,
			List<IViolationDetector> violationDetectors) {
		this.operationConflictDetectors.addAll(operationConflictDetectors);
		this.violationDetectors.addAll(violationDetectors);
	}

	@Override
	public ConflictReport detectConflicts(IThreeWayDiffProvider threeWayDiff,
			IProgressMonitor monitor) {
		ConflictReport report = ConflictReportFactory.eINSTANCE
				.createConflictReport();
		detectConflicts(threeWayDiff, report.getConflicts(),
				report.getEquivalentChanges(), monitor);
		report.setLeftVersion(threeWayDiff.getComparisonSnapshot(Side.LEFT));
		report.setRightVersion(threeWayDiff.getComparisonSnapshot(Side.RIGHT));
		return report;
	}

	/**
	 * Applies all currently set {@link #operationConflictDetectors} and
	 * {@link #violationDetectors} to find conflicts which will be added in the
	 * specified list of <code>conflicts</code>.
	 * 
	 * @param threeWayDiff
	 *            for which to detect conflicts.
	 * @param conflicts
	 *            to which to add found conflicts to.
	 * @param monitor
	 *            to report progress to.
	 */
	private void detectConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {

		monitor.beginTask("Detecting Conflicts",
				operationConflictDetectors.size() + violationDetectors.size());

		try {
			// perform overlapping change detection
			for (IOperationConflictDetector detector : operationConflictDetectors) {
				if (handlesNamespace(detector, threeWayDiff)) {
					monitor.subTask(detector.getName());
					detector.initialize();
					detector.detectOperationConflicts(threeWayDiff, conflicts,
							equivalentChanges, new SubProgressMonitor(monitor,
									1));
					monitor.worked(1);
				}
			}

			// perform general violation detection
			if (violationDetectors.size() > 0) {
				Resource mergedModel = null; // TODO create merged model
				for (IViolationDetector detector : violationDetectors) {
					monitor.subTask(detector.getName());
					detector.initialize();
					detector.detectViolations(mergedModel, threeWayDiff,
							conflicts, equivalentChanges,
							new SubProgressMonitor(monitor, 1));
					monitor.worked(1);
				}
			}

		} finally {
			monitor.done();
		}

	}

	private boolean handlesNamespace(IOperationConflictDetector detector,
			IThreeWayDiffProvider threeWayDiff) {
		if (detector.getTargetModelNsURI() == "*") {
			return true;
		} else {
			String nsURI = threeWayDiff.getLeftModel().get(0).eClass()
					.getEPackage().getNsURI();
			if (nsURI.equals(detector.getTargetModelNsURI())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IOperationConflictDetector> getOperationConflictDetectors() {
		return operationConflictDetectors;
	}

	@Override
	public List<IViolationDetector> getViolationDetectors() {
		return violationDetectors;
	}

}
