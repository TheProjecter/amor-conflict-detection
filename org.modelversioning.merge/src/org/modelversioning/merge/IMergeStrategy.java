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

package org.modelversioning.merge;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.modelversioning.conflictreport.ConflictReport;

/**
 * Provides a strategy for merging two models.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IMergeStrategy {

	/**
	 * Specifies whether the specified <code>diffElement</code> should be merged
	 * according to the specified <code>conflictReport</code> and this strategy.
	 * 
	 * @param diffElement
	 *            to check.
	 * @param conflictReport
	 *            used for decision.
	 */
	boolean shouldMerge(DiffElement diffElement, ConflictReport conflictReport);

}
