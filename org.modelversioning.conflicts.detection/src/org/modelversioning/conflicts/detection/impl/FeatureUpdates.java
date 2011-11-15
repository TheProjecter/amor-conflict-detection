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

package org.modelversioning.conflicts.detection.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Container for updates of {@link EStructuralFeature EStructuralFeatures}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class FeatureUpdates {

	/**
	 * A map containing updated {@link EStructuralFeature EStructuralFeatures}
	 * and the {@link DiffElement DiffElements} that updated the feature.
	 */
	private Map<EStructuralFeature, Set<DiffElement>> featureUpdateMap = new HashMap<EStructuralFeature, Set<DiffElement>>();

	/**
	 * A set of all diff elements.
	 */
	private Set<DiffElement> allDiffElements = new HashSet<DiffElement>();

	/**
	 * Adds the specified <code>feature</code> and <code>diffElement</code>.
	 * 
	 * @param feature
	 *            to add.
	 * @param diffElement
	 *            to add.
	 */
	public void add(EStructuralFeature feature, DiffElement diffElement) {
		Set<DiffElement> diffElements = null;
		if (featureUpdateMap.containsKey(feature)) {
			diffElements = featureUpdateMap.get(feature);
		} else {
			diffElements = new HashSet<DiffElement>();
			featureUpdateMap.put(feature, diffElements);
		}
		diffElements.add(diffElement);
		allDiffElements.add(diffElement);
	}

	/**
	 * Removes all entries for the specified <code>feature</code>.
	 * 
	 * @param feature
	 *            to remove.
	 */
	public void remove(EStructuralFeature feature) {
		allDiffElements.removeAll(featureUpdateMap.get(feature));
		featureUpdateMap.remove(feature);
	}

	/**
	 * Removes the specified <code>diffElement</code> which updated the
	 * <code>feature</code>.
	 * 
	 * @param feature
	 *            updated by the <code>diffElement</code> to remove.
	 * @param diffElement
	 *            to remove.
	 */
	public void remove(EStructuralFeature feature, DiffElement diffElement) {
		Set<DiffElement> diffElements = featureUpdateMap.get(feature);
		if (diffElements != null) {
			allDiffElements.remove(diffElement);
			diffElements.remove(diffElement);
			if (diffElements.size() == 0) {
				featureUpdateMap.remove(feature);
			}
		}
	}

	/**
	 * Returns all contained {@link DiffElement DiffElements}.
	 * 
	 * @return all contained {@link DiffElement DiffElements}.
	 */
	public Set<DiffElement> getDiffElements() {
		if (allDiffElements != null) {
			return allDiffElements;
		} else {
			return Collections.emptySet();
		}
	}

	/**
	 * Returns the {@link DiffElement DiffElements} updating the specified
	 * <code>feature</code>.
	 * 
	 * @param feature
	 *            to get {@link DiffElement DiffElements} for.
	 * @return the {@link DiffElement DiffElements}.
	 */
	public Set<DiffElement> getDiffElements(EStructuralFeature feature) {
		Set<DiffElement> set = featureUpdateMap.get(feature);
		if (set != null) {
			return set;
		} else {
			return Collections.emptySet();
		}
	}

	/**
	 * Returns <code>true</code> if the specified <code>feature</code> is
	 * contained in this list.
	 * 
	 * @param feature
	 *            feature in question.
	 * @return <code>true</code> if feature is contained, <code>false</code>
	 *         otherwise.
	 */
	public boolean contains(EStructuralFeature feature) {
		return featureUpdateMap.containsKey(feature);
	}

}
