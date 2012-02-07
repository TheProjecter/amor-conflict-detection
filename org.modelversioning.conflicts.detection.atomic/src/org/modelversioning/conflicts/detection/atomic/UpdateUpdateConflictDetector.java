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

package org.modelversioning.conflicts.detection.atomic;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.MoveMove;
import org.modelversioning.conflictreport.conflict.UpdateUpdate;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;
import org.modelversioning.core.diff.util.DiffUtil;

/**
 * {@link IOperationConflictDetector} for detecting {@link UpdateUpdate} Conflicts.
 * 
 * <p>
 * {@link UpdateUpdate} conflicts occur if the same single-valued or ordered
 * multi-valued feature has been concurrently modified. This detector does not
 * regard {@link MoveMove} conflicts although they are a sub-class of
 * {@link UpdateUpdate}. For detecting {@link MoveMove} conflicts, use
 * {@link MoveMoveConflictDetector}.
 * </p>
 * 
 * <p>
 * This detector ignores equal {@link DiffElement DiffElements} (cf. #
 * {@link IThreeWayDiffProvider#isEqual(DiffElement, DiffElement)}) and once a
 * {@link DiffElement} is ignored, it will also be ignored for the future as
 * long as this instance of the UpdateUpdateConflictDetector exists (cf.
 * {@link #shouldIgnore(DiffElement)}). Therefore, for each run, create a new
 * instance of this class.
 * </p>
 * 
 * <p>
 * Subclasses may override {@link #shouldIgnore(DiffElement)},
 * {@link #shouldIgnore(DiffElement, DiffElement)}, and
 * {@link #shouldRaiseConflictForFeature(EStructuralFeature)} to adapt this
 * detector for specific cases.
 * </p>
 * 
 * FIXME due to the non-deterministic order of the update element set, we might
 * have different results for the same model caused by ingoreDiffElements. But
 * this only happens, if equivalent updates occurred.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class UpdateUpdateConflictDetector implements IOperationConflictDetector {

	private static final String NAME = "Update Update Conflict Detector";

	/**
	 * Saves all diff elements to ignore.
	 */
	private Set<DiffElement> ignoredDiffElements = new HashSet<DiffElement>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modelversioning.conflicts.detection.engine.IConflictDetector#getId()
	 */
	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.updateUpdate";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelversioning.conflicts.detection.engine.IConflictDetector#
	 * getTargetModelNsURI()
	 */
	@Override
	public String getTargetModelNsURI() {
		return "*";
	}

	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Detects concurrent update of the same {@link EObject} on the same
	 * {@link EStructuralFeature}.
	 */
	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {
		EList<EObject> updatedEObjects = threeWayDiff.getUpdatedEObjects(
				Side.LEFT, false);
		monitor.beginTask("Searching for Update Update conflicts", updatedEObjects.size());
		try {
			for (EObject updatedObject : updatedEObjects) {
				if (threeWayDiff.isUpdated(updatedObject, Side.RIGHT, false)) {
					Set<DiffElement> leftUpdates = threeWayDiff
							.getUpdateElements(updatedObject, Side.LEFT);
					for (DiffElement leftUpdate : leftUpdates) {
						EStructuralFeature feature = DiffUtil
								.getUpdatedFeature(leftUpdate);
						if (feature != null
								&& shouldRaiseConflictForFeature(feature)
								&& threeWayDiff.isUpdated(updatedObject,
										feature, Side.RIGHT)) {
							checkForConflict(threeWayDiff, conflicts,
									equivalentChanges, updatedObject,
									leftUpdate, feature);
						}
					}
				}
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	private void checkForConflict(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, EObject updatedObject,
			DiffElement leftUpdate, EStructuralFeature feature) {
		Set<DiffElement> rightUpdates = new HashSet<DiffElement>(
				threeWayDiff.getUpdateElements(updatedObject, feature,
						Side.RIGHT));
		if (rightUpdates != null) {
			for (DiffElement rightUpdate : rightUpdates) {
				if (!shouldIgnore(rightUpdate)
						&& !shouldIgnore(leftUpdate, rightUpdate)) {
					if (!threeWayDiff.isEqual(leftUpdate, rightUpdate)) {
						UpdateUpdate updateUpdate = CONFLICT_FACTORY
								.createUpdateUpdate();
						updateUpdate.setLeftChange(leftUpdate);
						updateUpdate.setRightChange(rightUpdate);
						conflicts.add(updateUpdate);
					} else {
						EquivalentChange equivalentChange = CONFLICT_REPORT_FACTORY
								.createEquivalentChange();
						// it doesn't matter which side is preferred
						equivalentChange.setPreferSide(Side.LEFT);
						equivalentChange.setLeftChange(leftUpdate);
						equivalentChange.setRightChange(rightUpdate);
						equivalentChanges.add(equivalentChange);
						ignoredDiffElements.add(rightUpdate);
					}
				} else {
					ignoredDiffElements.add(rightUpdate);
				}
			}
		}
	}

	/**
	 * Specifies whether to ignore the specified <code>diffElement</code>.
	 * 
	 * <p>
	 * This method may be overridden by subclasses.
	 * </p>
	 * 
	 * @param diffElement
	 *            to check.
	 * @return <code>true</code> if this detector should ignore the specified
	 *         <code>diffElement</code>, <code>false</code> otherwise.
	 */
	protected boolean shouldIgnore(DiffElement diffElement) {
		return ignoredDiffElements.contains(diffElement);
	}

	/**
	 * Specifies whether to ignore the specified <code>leftDiffElement</code> as
	 * conflict to the specified <code>rightDiffElement</code>.
	 * 
	 * <p>
	 * This method may be overridden by subclasses.
	 * </p>
	 * 
	 * @param diffElement
	 *            to check.
	 * @return <code>true</code> if this detector should ignore the specified
	 *         <code>diffElement</code>, <code>false</code> otherwise.
	 */
	protected boolean shouldIgnore(DiffElement leftDiffElement,
			DiffElement rightDiffElement) {
		return false;
	}

	/**
	 * Specifies whether to report a concurrent update of the specified
	 * <code>feature</code>.
	 * 
	 * @param feature
	 *            to check.
	 * @return <code>true</code> if this detector should report a concurrent
	 *         update, <code>false</code> if not.
	 */
	protected boolean shouldRaiseConflictForFeature(EStructuralFeature feature) {
		return !feature.isMany(); // FIXME don't report for ordered || feature.isOrdered();
	}

	@Override
	public void initialize() {
		// noop
	}
}
