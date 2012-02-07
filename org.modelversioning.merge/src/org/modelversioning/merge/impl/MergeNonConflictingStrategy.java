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

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.merge.IMergeStrategy;

/**
 * A {@link IMergeStrategy} merging all non-conflicting changes.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MergeNonConflictingStrategy implements IMergeStrategy {

	@Override
	public boolean shouldMerge(DiffElement diffElement,
			ConflictReport conflictReport) {
		return !conflictReport.hasConflictingChange(diffElement);
	}

}
