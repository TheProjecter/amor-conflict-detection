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
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DeleteMove;
import org.modelversioning.conflictreport.conflict.DeleteUse;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;

/**
 * {@link IOperationConflictDetector} for detecting {@link DeleteUse} conflicts.
 * 
 * <p>
 * This detector detects a {@link DeleteUse} conflict which are caused by an
 * addition of a reference value which has been concurrently deleted. A special
 * type of {@link DeleteUse} conflicts are {@link DeleteMove} conflicts which
 * are caused by the deletion of the moved element itself, i.e., the addition of
 * the containment reference value at the target container element cannot be
 * performed since the value is concurrently deleted.
 * </p>
 * 
 * <p>
 * Subclasses may override {@link #shouldIgnore(DiffElement)} and
 * {@link #shouldIgnore(DiffElement, DiffElement)} to adapt this detector for
 * specific cases.
 * </p>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class DeleteUseConflictDetector implements IOperationConflictDetector {

	private static final String DIFF_HASH_SEP = "|";

	private static final String NAME = "Delete Use Conflict Detector";

	/**
	 * Saves a set of reported conflicts to avoid double report.
	 */
	private Set<String> reportedConflictHashes = new HashSet<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modelversioning.conflicts.detection.engine.IConflictDetector#getId()
	 */
	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.deleteUse";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modelversioning.conflicts.detection.engine.IConflictDetector#getName
	 * ()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Detects concurrent update and delete of the same {@link EObject}.
	 */
	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {
		monitor.beginTask("Searching for Delete Use conflicts", 2);
		reportedConflictHashes.clear();
		try {
			findConflicts(threeWayDiff, conflicts, equivalentChanges,
					new SubProgressMonitor(monitor, 1), Side.LEFT);
			findConflicts(threeWayDiff, conflicts, equivalentChanges,
					new SubProgressMonitor(monitor, 1), Side.RIGHT);
		} finally {
			monitor.done();
		}
	}

	private void findConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges,
			IProgressMonitor monitor, Side side) {
		Side opposite = Side.LEFT.equals(side) ? Side.RIGHT : Side.LEFT;

		// elements that have been added as reference target
		EList<EObject> newReferencedEObjects = threeWayDiff
				.getAddReferencedEObjects(side);
		// elements that have been moved
		EList<EObject> movedEObjects = threeWayDiff
				.getMovedEObjects(side, true);
		monitor.beginTask("Examining " + side
				+ " added reference values and moves",
				newReferencedEObjects.size() + movedEObjects.size());

		try {
			// check whether elements added as reference target have been
			// concurrently deleted
			for (EObject newReferencedObject : newReferencedEObjects) {
				if (threeWayDiff.isDeleted(newReferencedObject, opposite, true)) {
					Set<DiffElement> addReferencedElements = threeWayDiff
							.getAddReferenceElements(newReferencedObject, side);
					ModelElementChange deleteElement = threeWayDiff
							.getDeleteElement(newReferencedObject, opposite);
					for (DiffElement addReferenceElement : addReferencedElements) {
						if (!haveAlreadyReported(deleteElement,
								addReferenceElement)
								&& !shouldIgnore(addReferenceElement)
								&& !shouldIgnore(deleteElement)
								&& !shouldIgnore(addReferenceElement,
										deleteElement)) {
							DeleteUse deleteUse = CONFLICT_FACTORY
									.createDeleteUse();
							if (Side.LEFT.equals(side)) {
								deleteUse.setLeftChange(addReferenceElement);
								deleteUse.setRightChange(deleteElement);
							} else {
								deleteUse.setRightChange(addReferenceElement);
								deleteUse.setLeftChange(deleteElement);
							}
							addToReportedConflicts(addReferenceElement,
									deleteElement);
							conflicts.add(deleteUse);
						}
					}
				}
				monitor.worked(1);
			}

			// check whether moved objects have been deleted
			for (EObject movedObject : movedEObjects) {
				MoveModelElement moveElement = threeWayDiff.getMoveElement(
						movedObject, side);
				if (threeWayDiff.isDeleted(movedObject, opposite, true)) {
					ModelElementChange deleteElement = threeWayDiff
							.getDeleteElement(movedObject, opposite);
					if (!haveAlreadyReported(deleteElement, moveElement)
							&& !shouldIgnore(moveElement)
							&& !shouldIgnore(deleteElement)
							&& !shouldIgnore(moveElement, deleteElement)) {
						DeleteMove deleteMove = CONFLICT_FACTORY
								.createDeleteMove();
						if (Side.LEFT.equals(side)) {
							deleteMove.setLeftChange(moveElement);
							deleteMove.setRightChange(deleteElement);
						} else {
							deleteMove.setRightChange(moveElement);
							deleteMove.setLeftChange(deleteElement);
						}
						addToReportedConflicts(moveElement, deleteElement);
						conflicts.add(deleteMove);
					}
				}
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	private String toHash(DiffElement diffElement1, DiffElement diffElement2) {
		return diffElement1.hashCode() + DIFF_HASH_SEP
				+ diffElement2.hashCode();
	}

	private void addToReportedConflicts(DiffElement element1,
			DiffElement element2) {
		reportedConflictHashes.add(toHash(element1, element2));
		reportedConflictHashes.add(toHash(element2, element1));
	}

	private boolean haveAlreadyReported(DiffElement diffElement1,
			DiffElement diffElement2) {
		String hash = toHash(diffElement1, diffElement2);
		return reportedConflictHashes.contains(hash);
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
		return false;
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

	@Override
	public void initialize() {
		// noop
	}
}
