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

package org.modelversioning.merge.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.ecore.EObject;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DeleteUpdate;
import org.modelversioning.conflictreport.conflict.DeleteUse;
import org.modelversioning.core.util.EcoreUtil;
import org.modelversioning.merge.IMergeStrategy;

/**
 * A conflict-tolerant {@link IMergeStrategy} merging all non-conflicting
 * changes and prioritizing updates over deletes.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ConflictTolerantMergeStrategy implements IMergeStrategy {

	@Override
	public boolean shouldMerge(DiffElement diffElement,
			ConflictReport conflictReport) {
		// merge all non-conflicting
		if (!conflictReport.hasConflictingChange(diffElement)) {
			// do not apply deletions of reference values, if they are
			// conflicting caused by a contradictory deleted model element
			if (isRemoveReferenceTarget(diffElement)) {
				EObject deletedTargetValue = getDeletedTargetValue(diffElement);
				if (deletedTargetValue != null) {
					DiffElement deletion = getDeletion(deletedTargetValue,
							diffElement, conflictReport);
					if (!shouldMerge(deletion, conflictReport)) {
						return false;
					}
				}
			}
			return true;
		} else {
			EList<Conflict> conflicts = conflictReport
					.getConflicts(diffElement);
			for (Conflict conflict : conflicts) {
				// if delete-use or delete-update prioritize update or use over
				// delete --> return true for merging if it is not the delete
				// side.
				if (conflict instanceof DeleteUse
						|| conflict instanceof DeleteUpdate) {
					if (!(diffElement instanceof ModelElementChangeRightTarget)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private DiffModel getDiffModel(DiffElement diffElement,
			ConflictReport conflictReport) {
		DiffModel leftDiff = conflictReport.getLeftVersion().getDiff();
		DiffModel rightDiff = conflictReport.getRightVersion().getDiff();
		if (EcoreUtil.createParentList(diffElement).contains(leftDiff)) {
			return leftDiff;
		} else {
			return rightDiff;
		}
	}

	private EObject getDeletedTargetValue(DiffElement diffElement) {
		if (diffElement instanceof UpdateReference) {
			UpdateReference updateReference = (UpdateReference) diffElement;
			return updateReference.getLeftTarget();
		} else if (diffElement instanceof ReferenceChangeRightTarget) {
			ReferenceChangeRightTarget referenceChangeRightTarget = (ReferenceChangeRightTarget) diffElement;
			return referenceChangeRightTarget.getRightTarget();
		} else {
			return null;
		}
	}

	private boolean isRemoveReferenceTarget(DiffElement diffElement) {
		if (diffElement instanceof UpdateReference) {
			UpdateReference updateReference = (UpdateReference) diffElement;
			if (updateReference.getRightTarget() == null) {
				return true;
			}
		} else if (diffElement instanceof ReferenceChangeRightTarget) {
			return true;
		}
		return false;
	}

	private DiffElement getDeletion(EObject eObject,
			DiffElement removeRefValueDiffElement, ConflictReport conflictReport) {
		DiffModel diffModel = getDiffModel(removeRefValueDiffElement,
				conflictReport);
		TreeIterator<EObject> allContents = diffModel.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof ModelElementChangeRightTarget) {
				ModelElementChangeRightTarget deletion = (ModelElementChangeRightTarget) next;
				if (deletion.getRightElement().equals(eObject)) {
					return deletion;
				}

			}
		}
		return null;
	}

}
