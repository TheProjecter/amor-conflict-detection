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

package org.modelversioning.conflicts.detection.engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.Violation;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;

/**
 * Detector for {@link Violation Violations}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IViolationDetector extends IConflictDetector {

	/**
	 * Searches {@link Violation Violations} in the specified
	 * <code>mergedModel</code> using <code>threeWayDiff</code> and adds them to
	 * the specified list of <code>conflicts</code>.
	 * 
	 * @param mergedModel
	 *            in which to search for violations.
	 * @param threeWayDiff
	 *            used for change-based information.
	 * @param conflicts
	 *            list of conflicts to add found conflicts to.
	 * @param equivalentChanges
	 *            list of equivalent changes to add found equivalent changes to.
	 * @param monitor
	 *            to report the progress.
	 */
	public void detectViolations(Resource mergedModel,
			IThreeWayDiffProvider threeWayDiff, EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor);

}
