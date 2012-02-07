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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.MoveMove;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;
import org.modelversioning.core.util.EcoreUtil;

/**
 * {@link IOperationConflictDetector} for detecting {@link MoveMove} Conflicts.
 * 
 * <p>
 * {@link MoveMove} conflicts occur whenever the same object has been moved to
 * different new containers as well as if two moves would cause a containment
 * cycle in the merged model.
 * </p>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MoveMoveConflictDetector implements IOperationConflictDetector {

	private static final String NAME = "Move Move Conflict Detector";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modelversioning.conflicts.detection.engine.IConflictDetector#getId()
	 */
	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.moveMove";
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
		EList<EObject> movedEObjects = threeWayDiff.getMovedEObjects(Side.LEFT,
				false);
		monitor.beginTask("Searching for Move Move conflicts",
				movedEObjects.size());
		try {
			for (EObject movedObject : movedEObjects) {

				MoveModelElement leftMove = threeWayDiff.getMoveElement(
						movedObject, Side.LEFT);

				// check direct move-move conflicts
				if (threeWayDiff.isMoved(movedObject, Side.RIGHT, false)) {
					MoveModelElement rightMove = threeWayDiff.getMoveElement(
							movedObject, Side.RIGHT);
					// take care, EMF Compare mixed up sides again
					EObject leftTarget = threeWayDiff.getMatchingEObject(
							leftMove.getRightTarget(), Side.LEFT, true);
					EObject rightTarget = threeWayDiff.getMatchingEObject(
							rightMove.getRightTarget(), Side.RIGHT, true);
					if (leftTarget != null && rightTarget != null
							&& leftTarget.equals(rightTarget)) {
						// same target --> check containment reference
						if (leftMove
								.getLeftElement()
								.eContainmentFeature()
								.equals(rightMove.getLeftElement()
										.eContainmentFeature())) {
							// add equivalent change
							EquivalentChange equivalentChange = CONFLICT_REPORT_FACTORY
									.createEquivalentChange();
							equivalentChange.setLeftChange(leftMove);
							equivalentChange.setRightChange(rightMove);
							equivalentChange.setPreferSide(Side.LEFT);
							equivalentChanges.add(equivalentChange);
						} else {
							raiseConflict(leftMove, rightMove, conflicts);
						}
					} else {
						raiseConflict(leftMove, rightMove, conflicts);
					}

				} else

				// check for containment cycles
				{
					for (EObject rightMovedObject : threeWayDiff
							.getMovedEObjects(Side.RIGHT, false)) {
						MoveModelElement rightMove = threeWayDiff
								.getMoveElement(rightMovedObject, Side.RIGHT);
						// check direct move-move conflicts
						if (rightMove.getRightTarget() != null
								&& leftMove.getRightElement() != null
								&& rightMove.getRightTarget().equals(
										leftMove.getRightElement())) {
							raiseConflict(leftMove, rightMove, conflicts);
						} else
						// check indirect move-move conflicts
						{
							List<EObject> rightTargetParents = EcoreUtil
									.createParentList(rightMove
											.getRightTarget());
							if (rightTargetParents.contains(leftMove
									.getRightElement())) {
								raiseConflict(leftMove, rightMove, conflicts);
							}
						}
					}

				}
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}

	private void raiseConflict(MoveModelElement leftMove,
			MoveModelElement rightMove, EList<Conflict> conflicts) {
		MoveMove moveMove = CONFLICT_FACTORY.createMoveMove();
		moveMove.setLeftChange(leftMove);
		moveMove.setRightChange(rightMove);
		conflicts.add(moveMove);
	}

	@Override
	public void initialize() {
		// noop
	}
}
