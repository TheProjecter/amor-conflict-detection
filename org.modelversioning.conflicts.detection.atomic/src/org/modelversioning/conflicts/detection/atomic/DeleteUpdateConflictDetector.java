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
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DeleteUpdate;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;

/**
 * {@link IOperationConflictDetector} for detecting Delete/Update Conflicts.
 * 
 * <p>
 * Delete/Update conflicts occur if an updated element has been concurrently
 * deleted.
 * </p>
 * 
 * <p>
 * This detector ignores equal {@link DiffElement DiffElements} (cf. #
 * {@link IThreeWayDiffProvider#isEqual(DiffElement, DiffElement)}) and once a
 * {@link DiffElement} is ignored, it will also be ignored for the future as
 * long as this instance of the UpdateUpdateConflictDetector exists (cf.
 * {@link #shouldIgnore(DiffElement)}).
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
public class DeleteUpdateConflictDetector implements IOperationConflictDetector {

	private static final String DIFF_HASH_SEP = "|";

	private static final String NAME = "Delete Update Conflict Detector";

	/**
	 * Saves all diff elements to ignore.
	 */
	private Set<DiffElement> ignoredDiffElements = new HashSet<DiffElement>();

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
		return "org.modelversioning.conflicts.detection.deleteUpdate";
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
		ignoredDiffElements.clear();
		reportedConflictHashes.clear();
		monitor.beginTask("Searching for Delete Update conflicts", 2);
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
		// updated objects
		EList<EObject> updatedEObjects = threeWayDiff.getUpdatedEObjects(side,
				true);

		monitor.beginTask("Examining " + side + " updates",
				updatedEObjects.size());
		try {
			// check updated objects
			for (EObject updatedObject : updatedEObjects) {
				if (threeWayDiff.isDeleted(updatedObject, opposite, true)) {
					Set<DiffElement> updateElements = threeWayDiff
							.getUpdateElements(updatedObject, side);
					ModelElementChange deleteElement = threeWayDiff
							.getDeleteElement(updatedObject, opposite);
					for (DiffElement updateElement : updateElements) {
						checkIfConflicting(conflicts, equivalentChanges, side,
								deleteElement, updateElement);
					}
				}
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	private void checkIfConflicting(EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, Side side,
			ModelElementChange deleteElement, DiffElement diffElement) {
		if (!_shouldIgnore(diffElement, deleteElement, equivalentChanges, side)
				&& !shouldIgnore(diffElement) && !shouldIgnore(deleteElement)
				&& !shouldIgnore(diffElement, deleteElement)) {
			DeleteUpdate deleteUpdate = CONFLICT_FACTORY.createDeleteUpdate();
			if (Side.LEFT.equals(side)) {
				deleteUpdate.setLeftChange(diffElement);
				deleteUpdate.setRightChange(deleteElement);
			} else {
				deleteUpdate.setRightChange(diffElement);
				deleteUpdate.setLeftChange(deleteElement);
			}
			addToReportedConflicts(deleteUpdate);
			conflicts.add(deleteUpdate);
		}
	}

	private String toHash(DiffElement diffElement1, DiffElement diffElement2) {
		return diffElement1.hashCode() + DIFF_HASH_SEP
				+ diffElement2.hashCode();
	}

	private void addToReportedConflicts(DeleteUpdate deleteUpdate) {
		reportedConflictHashes.add(toHash(deleteUpdate.getLeftChange(),
				deleteUpdate.getRightChange()));
		reportedConflictHashes.add(toHash(deleteUpdate.getRightChange(),
				deleteUpdate.getLeftChange()));
	}

	private boolean haveAlreadyReported(DiffElement diffElement1,
			DiffElement diffElement2) {
		String hash = toHash(diffElement1, diffElement2);
		return reportedConflictHashes.contains(hash);
	}

	/**
	 * Internal method to decide whether to ignore a specific combination of
	 * {@link DiffElement DiffElements}. In particular, this method avoids
	 * double reporting the same conflicting difference combination and
	 * reporting a conflict for an <code>updateElement</code> that is a deletion
	 * or move itself or just removing a reference value.
	 * 
	 * <p>
	 * In particular, this happens if the <code>updateElement</code> is
	 * </p>
	 * <ul>
	 * <li>a {@link MoveModelElement} moving an element away from the deleted
	 * container,</li>
	 * <li>a {@link ModelElementChangeRightTarget} deleting an element contained
	 * by the deleted container,</li>
	 * <li>a {@link ReferenceChangeRightTarget} deleting a reference value or</li>
	 * <li>a {@link UpdateReference} setting a single-valued reference value to
	 * <code>null</code>.</li>
	 * </ul>
	 * <p>
	 * In case, the <code>updateElement</code> is a deletion (
	 * {@link ModelElementChangeRightTarget}), this is also marked as equivalent
	 * change.
	 * </p>
	 * 
	 * @param updateElement
	 *            to check.
	 * @param modelElementChange
	 *            to check.
	 * @param equivalentChanges
	 *            list of equivalent changes to add found equivalent changes to.
	 * @param updateSide
	 *            side on which the <code>updateElement</code> has been
	 *            performed.
	 * @return <code>true</code> if it should be ignored, otherwise
	 *         <code>false</code>.
	 */
	private boolean _shouldIgnore(DiffElement updateElement,
			ModelElementChange modelElementChange,
			EList<EquivalentChange> equivalentChanges, Side updateSide) {
		// check if we already reported the change combination
		if (haveAlreadyReported(updateElement, modelElementChange)) {
			return true;
		}

		if (modelElementChange instanceof ModelElementChangeRightTarget) {
			ModelElementChangeRightTarget deleteElement = (ModelElementChangeRightTarget) modelElementChange;
			EObject deletedObject = deleteElement.getRightElement();

			// TODO make configurable
			// The following if realizes the liberal approach.
			// I.e., not reporting deletions and concurrent deletions reference
			// values (although they are updates).
			if (updateElement instanceof MoveModelElement
					|| updateElement instanceof ReferenceChangeRightTarget) {
				return true;
			} else if (updateElement instanceof UpdateReference) {
				UpdateReference updateReference = (UpdateReference) updateElement;
				if (updateReference.getLeftElement().eGet(
						updateReference.getReference()) == null) {
					return true;
				}
			}

			if (updateElement instanceof ModelElementChangeRightTarget) {
				ModelElementChangeRightTarget updateAsDeletion = (ModelElementChangeRightTarget) updateElement;
				// check if the updateElement is caused by a deletion of an
				// element contained by the deletion in modelElementChange
				EObject deletedObjectByUpdate = updateAsDeletion
						.getRightElement();
				if (deletedObjectByUpdate.equals(deletedObject)
						|| org.modelversioning.core.util.EcoreUtil
								.createParentList(deletedObjectByUpdate)
								.contains(deletedObject)) {
					EquivalentChange equivalentChange = CONFLICT_REPORT_FACTORY
							.createEquivalentChange();
					if (Side.LEFT.equals(updateSide)) {
						equivalentChange.setLeftChange(updateElement);
						equivalentChange.setRightChange(deleteElement);
						equivalentChange.setPreferSide(Side.RIGHT);
					} else {
						equivalentChange.setRightChange(updateElement);
						equivalentChange.setLeftChange(deleteElement);
						equivalentChange.setPreferSide(Side.LEFT);
					}
					equivalentChanges.add(equivalentChange);
					return true;
				}
			}
		}
		return false;
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

	@Override
	public void initialize() {
		// noop
	}
}
