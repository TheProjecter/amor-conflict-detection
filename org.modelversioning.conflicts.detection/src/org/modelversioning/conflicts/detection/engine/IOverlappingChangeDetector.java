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
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.OverlappingChange;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;

/**
 * Detector for {@link OverlappingChange OverlappingChanges}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IOverlappingChangeDetector extends IConflictDetector {

	/**
	 * Searches {@link OverlappingChange OverlappingChanges} in the specified
	 * <code>threeWayDiff</code> and adds them to the specified list of
	 * <code>conflicts</code>.
	 * 
	 * @param threeWayDiff
	 *            in which to search for conflicts.
	 * @param conflicts
	 *            list of conflicts to add found conflicts to.
	 * @param equivalentChanges
	 *            list of equivalent changes to add found equivalent changes to.
	 * @param monitor
	 *            to report the progress.
	 */
	public void detectOverlappingChanges(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor);

}
