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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.ConflictReportFactory;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IConflictDetectionEngine;
import org.modelversioning.conflicts.detection.engine.IOverlappingChangeDetector;
import org.modelversioning.conflicts.detection.engine.IViolationDetector;
import org.modelversioning.merge.IMerger;
import org.modelversioning.merge.impl.MergerImpl;

/**
 * A basic implementation of the {@link IConflictDetectionEngine}.
 * 
 * <p>
 * By default, this detector uses the {@link UpdateUpdateConflictDetector}, the
 * {@link DeleteUpdateConflictDetector}, and {@link DeleteUseConflictDetector}.
 * </p>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ConflictDetectionEngineImpl implements IConflictDetectionEngine {

	/**
	 * The list of {@link IOverlappingChangeDetector
	 * IOverlappingChangeDetectors}
	 */
	private List<IOverlappingChangeDetector> overlappingChangeDetectors = new ArrayList<IOverlappingChangeDetector>();

	/**
	 * The list of {@link IViolationDetector IViolationDetectors}
	 */
	private List<IViolationDetector> violationDetectors = new ArrayList<IViolationDetector>();

	/**
	 * Indicates whether this engine searches also for
	 * {@link OperationContractViolation OperationContractViolations}.
	 */
	private boolean operationContractViolationAware = true;

	/** Detector for detecting operation contract violations. */
	private OperationContractViolationDetector operationContractViolationDetector = new OperationContractViolationDetector();

	/**
	 * The merger used for creating a merged version to apply
	 * {@link IViolationDetector IViolationDetectors}.
	 */
	private IMerger merger = new MergerImpl();

	/**
	 * Default constructor creating a detector. In this default settings this
	 * detector uses the {@link UpdateUpdateConflictDetector}, the
	 * {@link DeleteUpdateConflictDetector}, and the
	 * {@link DeleteUseConflictDetector}.
	 */
	public ConflictDetectionEngineImpl() {
		overlappingChangeDetectors.add(new UpdateUpdateConflictDetector());
		overlappingChangeDetectors.add(new DeleteUpdateConflictDetector());
		overlappingChangeDetectors.add(new DeleteUseConflictDetector());
		overlappingChangeDetectors.add(new MoveMoveConflictDetector());
	}

	/**
	 * Creates a conflict detection engine with the specified list of
	 * <code>overlappingChangeDetectors</code> and
	 * <code>violationDetectors</code>.
	 * 
	 * @param overlappingChangeDetectors
	 *            to set.
	 * @param violationDetectors
	 *            to set.
	 * @param merger
	 *            to set.
	 */
	public ConflictDetectionEngineImpl(
			List<IOverlappingChangeDetector> overlappingChangeDetectors,
			List<IViolationDetector> violationDetectors) {
		this.overlappingChangeDetectors.addAll(overlappingChangeDetectors);
		this.violationDetectors.addAll(violationDetectors);
	}

	/**
	 * Specifies whether this engine shall search for
	 * {@link OperationContractViolation OperationContractViolations}.
	 * 
	 * @return <code>true</code> if it shall search for
	 *         {@link OperationContractViolation OperationContractViolations},
	 *         <code>false</code> otherwise.
	 */
	public boolean isOperationContractViolationAware() {
		return operationContractViolationAware;
	}

	/**
	 * Sets whether this engine shall search for
	 * {@link OperationContractViolation OperationContractViolations}.
	 * 
	 * @param operationContractViolationAware
	 *            <code>true</code> if it shall search for
	 *            {@link OperationContractViolation OperationContractViolations}
	 *            , otherwise <code>false</code>.
	 */
	public void setOperationContractViolationAware(
			boolean operationContractViolationAware) {
		this.operationContractViolationAware = operationContractViolationAware;
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
	 * Applies all currently set {@link #overlappingChangeDetectors} and
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

		int additionalTicks = operationContractViolationAware ? 1 : 0;
		monitor.beginTask("Detecting Conflicts",
				overlappingChangeDetectors.size() + violationDetectors.size()
						+ additionalTicks);

		try {
			// perform overlapping change detection
			for (IOverlappingChangeDetector detector : overlappingChangeDetectors) {
				monitor.subTask(detector.getName());
				detector.initialize();
				detector.detectOverlappingChanges(threeWayDiff, conflicts,
						equivalentChanges, new SubProgressMonitor(monitor, 1));
				monitor.worked(1);
			}

			// perform operation contract violation detection
			if (operationContractViolationAware) {
				operationContractViolationDetector
						.detectOperationContractViolations(threeWayDiff,
								conflicts, equivalentChanges,
								new SubProgressMonitor(monitor, 1));
				monitor.worked(1);
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

	@Override
	public List<IOverlappingChangeDetector> getOverlappingChangeDetectors() {
		return overlappingChangeDetectors;
	}

	@Override
	public List<IViolationDetector> getViolationDetectors() {
		return violationDetectors;
	}

}
