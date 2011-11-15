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

package org.modelversioning.conflicts.detection.engine;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;

/**
 * Searches for {@link Conflict}s in {@link IThreeWayDiffProvider}s.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IConflictDetectionEngine {

	/**
	 * Detects conflicts in the specified <code>threeWayDiff</code>.
	 * 
	 * @param threeWayDiff
	 *            to search for conflicts.
	 * @param monitor
	 *            to report progress to.
	 * @return detected {@link Conflict}s.
	 */
	public ConflictReport detectConflicts(IThreeWayDiffProvider threeWayDiff,
			IProgressMonitor monitor);

	/**
	 * Returns currently set {@link IOverlappingChangeDetector
	 * IOverlappingChangeDetectors} conducted by this engine for conflict
	 * detection.
	 * 
	 * <p>
	 * This list is modifiable and may be used for adding, sorting, and removing
	 * {@link IOverlappingChangeDetector IOverlappingChangeDetectors}.
	 * </p>
	 * 
	 * @return list of currently set {@link IOverlappingChangeDetector}s.
	 */
	public List<IOverlappingChangeDetector> getOverlappingChangeDetectors();

	/**
	 * Returns currently set {@link IViolationDetector IViolationDetectors}
	 * conducted by this engine for conflict detection.
	 * 
	 * <p>
	 * This list is modifiable and may be used for adding, sorting, and removing
	 * {@link IViolationDetector IViolationDetectors}.
	 * </p>
	 * 
	 * @return list of currently set {@link IViolationDetector}s.
	 */
	public List<IViolationDetector> getViolationDetectors();

}
