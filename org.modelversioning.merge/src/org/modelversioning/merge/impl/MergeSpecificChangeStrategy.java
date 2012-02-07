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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.merge.IMergeStrategy;

/**
 * A {@link IMergeStrategy} merging specific changes only.
 * 
 * @author <a href="mailto:brosch@big.tuwien.ac.at">Petra Brosch</a>
 * 
 */
public class MergeSpecificChangeStrategy implements IMergeStrategy {

	private EList<DiffElement> changesToMerge = new BasicEList<DiffElement>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.modelversioning.merge.IMergeStrategy#shouldMerge(org.eclipse.emf.
	 * compare.diff.metamodel.DiffElement,
	 * org.modelversioning.conflictreport.ConflictReport)
	 */
	@Override
	public boolean shouldMerge(DiffElement diffElement,
			ConflictReport conflictReport) {
		if (changesToMerge != null && changesToMerge.contains(diffElement)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the list of changes this {@link IMergeStrategy} accepts for
	 * merging.
	 * 
	 * @return the changes to merge.
	 */
	public EList<DiffElement> getChangesToMerge() {
		return changesToMerge;
	}

	/**
	 * Sets the list of changes this {@link IMergeStrategy} should accept for
	 * merging.
	 * 
	 * @param changesToMerge
	 */
	public void setChangesToMerge(EList<DiffElement> changesToMerge) {
		if (this.changesToMerge == null) {
			this.changesToMerge = new BasicEList<DiffElement>() {
				private static final long serialVersionUID = 8140243657197403839L;

				@Override
				public boolean contains(Object object) {
					if (object instanceof DiffElement) {
						for (int i = 0; i < size; ++i) {
							if (EcoreUtil
									.getURI((DiffElement) data[i])
									.toString()
									.equals(EcoreUtil.getURI(
											(DiffElement) object).toString())) {
								return true;
							}
						}
					}
					return false;
				};
			};
		}

		for (DiffElement diff : changesToMerge) {
			this.changesToMerge.add(diff);
		}
	}
}