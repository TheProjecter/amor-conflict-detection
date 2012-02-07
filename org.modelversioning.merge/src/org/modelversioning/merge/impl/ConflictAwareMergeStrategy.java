/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.merge.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.conflict.AddAdd;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.OverlappingChange;
import org.modelversioning.conflictreport.conflict.Violation;
import org.modelversioning.conflictreport.conflict.ViolationSeverity;
import org.modelversioning.merge.IMergeStrategy;

/**
 * A {@link IMergeStrategy} merging all non-conflicting changes without
 * deletions.
 * 
 * @author <a href="mailto:brosch@big.tuwien.ac.at">Petra Brosch</a>
 * 
 */
public class ConflictAwareMergeStrategy implements IMergeStrategy {

	@Override
	public boolean shouldMerge(DiffElement diffElement,
			ConflictReport conflictReport) {

		if (!diffElement.getKind().equals(DifferenceKind.DELETION)
				&& !(diffElement instanceof UpdateReference)
		// && !conflictReport.hasConflictingChange(conflictReport
		// .getDependentModelChange(diffElement))
		) {

			// merge conflicting change?
			EList<Conflict> conflicts = conflictReport
					.getConflicts(diffElement);

			if (!shouldMergeConflict(conflicts)) {
				return false;
			}

			// merge conflict diagram change?
			conflicts = conflictReport.getConflicts(conflictReport
					.getDependentModelChange(diffElement));
			if (!shouldMergeConflict(conflicts)) {
				return false;
			}

			// merge equivalent change?
			EList<DiffElement> equivalentChanges = conflictReport
					.getEquivalentChanges(diffElement);
			if (!shouldMergeEquivalentChange(diffElement, equivalentChanges,
					conflictReport.getEquivalentPreferredChanges())) {
				return false;
			}

			// merge equivalent diagram change?
			equivalentChanges = conflictReport
					.getEquivalentChanges(conflictReport
							.getDependentModelChange(diffElement));
			if (!shouldMergeEquivalentChange(
					conflictReport.getDependentModelChange(diffElement),
					equivalentChanges,
					conflictReport.getEquivalentPreferredChanges())) {
				return false;
			}
			return true;
		}
		return false;
	}

	private boolean shouldMergeConflict(EList<Conflict> conflicts) {
		for (Conflict conflict : conflicts) {
			if ((conflict instanceof OverlappingChange && !(conflict instanceof AddAdd))
					|| conflict instanceof Violation
					&& !((Violation) conflict).getSeverity().equals(
							ViolationSeverity.WARNING)) {
				return false;
			}
		}
		return true;
	}

	private boolean shouldMergeEquivalentChange(DiffElement change,
			EList<DiffElement> equivalentChanges,
			EList<DiffElement> equivalentPreferredChanges) {
		if (equivalentChanges != null && equivalentChanges.size() > 0
				&& !equivalentPreferredChanges.contains(change)) {
			return false;
		}

		return true;
	}
}
