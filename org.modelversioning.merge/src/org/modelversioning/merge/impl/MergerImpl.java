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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.core.diff.propagation.IDiffPropagationEngine;
import org.modelversioning.core.diff.propagation.IPropagationMappingProvider;
import org.modelversioning.core.diff.propagation.impl.DiffPropagationEngine;
import org.modelversioning.core.diff.util.DiffUtil;
import org.modelversioning.core.util.UUIDUtil;
import org.modelversioning.merge.IMergeStrategy;
import org.modelversioning.merge.IMerger;

/**
 * Default implementation of the {@link IMerger} interface.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 *   
 */
public class MergerImpl implements IMerger, IPropagationMappingProvider {

	/** The merge strategy to use. */
	private IMergeStrategy mergeStrategy = null;

	/**
	 * A map retaining the correspondences between the original {@link EObject
	 * EObjects} and the merged {@link EObject EObjects}.
	 */
	private Map<EObject, EObject> correspondenceMap = null;
	
	/** The conflict report to use for merging. */
	private ConflictReport conflictReport;

	/** The copier used for building the merged model from the original one. */
	private Copier copier = new Copier();
	
	/** The left version to merge. */
	ComparisonResourceSnapshot leftVersion;
	
	/** The right version to merge. */
	ComparisonResourceSnapshot rightVersion;

	@Override
	public void setMergeStrategy(IMergeStrategy mergeStrategy) {
		this.mergeStrategy = mergeStrategy;
	}

	@Override
	public IMergeStrategy getMergeStrategy() {
		return mergeStrategy;
	}
	
	@Override
	public void merge(ConflictReport conflictReport,
			Resource mergedModelResource, IProgressMonitor monitor) {
		
		leftVersion = conflictReport.getLeftVersion();
		rightVersion = conflictReport.getRightVersion();
		
		merge(conflictReport, leftVersion, rightVersion, mergedModelResource, monitor);
	}

	@Override
	public void merge(ConflictReport conflictReport, ComparisonResourceSnapshot leftVersion, ComparisonResourceSnapshot rightVersion,
			Resource mergedModelResource, IProgressMonitor monitor) {

		Assert.isNotNull(mergeStrategy,
				"A merge strategy must be set before merging.");

		this.conflictReport = conflictReport;
		this.leftVersion = leftVersion;
		this.rightVersion = rightVersion;
		
		// fetching the changes from report
		List<DiffElement> leftDiffElements = DiffUtil
			.getEffectiveDiffElements(leftVersion.getDiff());
		List<DiffElement> rightDiffElements = DiffUtil
			.getEffectiveDiffElements(rightVersion.getDiff());

		// remove equivalent sub changes
		leftDiffElements.removeAll(conflictReport.getEquivalentSubChanges());
		rightDiffElements.removeAll(conflictReport.getEquivalentSubChanges());

		monitor.beginTask("Merging all changes", 5);

		try {

			monitor.subTask("Copying the original model");
//			copier = new Copier();
			Collection<EObject> mergedModelRoots = copier
					.copyAll(leftVersion.getMatch()
							.getLeftRoots());
			copier.copyReferences();
			mergedModelResource.getContents().addAll(mergedModelRoots);
			for (Entry<EObject, EObject> entry : copier.entrySet()) {
				UUIDUtil.copyUUID(entry.getKey(), entry.getValue());
			}
			monitor.worked(1);

			monitor.subTask("Determining changes to merge");
			List<DiffElement> leftDiffElementsToPropagate = getDiffElementsToPropagate(
					conflictReport, leftDiffElements);
			List<DiffElement> rightDiffElementsToPropagate = getDiffElementsToPropagate(
					conflictReport, rightDiffElements);
			monitor.worked(1);

			// propagate changes
			monitor.subTask("Applying the changes");
			IDiffPropagationEngine leftPropagationEngine = new DiffPropagationEngine();
			leftPropagationEngine.propagate(leftDiffElementsToPropagate,
					leftVersion.getMatch(), this,
					new SubProgressMonitor(monitor, 1));
			monitor.worked(1);
			IDiffPropagationEngine rightPropagationEngine = new DiffPropagationEngine();
			rightPropagationEngine.propagate(rightDiffElementsToPropagate,
					rightVersion.getMatch(), this,
					new SubProgressMonitor(monitor, 1));
			monitor.worked(1);

			// save correspondences as trace
			monitor.subTask("Retrieving trace from merged model to original models");
			fillCorrespondenceMap(copier);
			monitor.worked(1);

		} finally {
			monitor.done();
		}
	}

	/**
	 * Returns the {@link DiffElement DiffElements} to propagate according to
	 * the <code>conflictReport</code> and the {@link #mergeStrategy}.
	 * 
	 * @param conflictReport
	 *            to determine whether to propagate.
	 * @param diffElements
	 *            to check.
	 * @return the list of elements to propagate.
	 */
	private List<DiffElement> getDiffElementsToPropagate(
			ConflictReport conflictReport, List<DiffElement> diffElements) {
		List<DiffElement> diffElementsToPropagate = new ArrayList<DiffElement>();
		for (DiffElement diffElement : diffElements) {
			if (mergeStrategy.shouldMerge(diffElement, conflictReport)) {
				diffElementsToPropagate.add(diffElement);
			}
		}
		return diffElementsToPropagate;
	}

	/**
	 * Extracts the correspondence map from the specified <code>copier</code>.
	 * 
	 * @param copier
	 *            to get correspondences from.
	 */
	private void fillCorrespondenceMap(Copier copier) {
		correspondenceMap = new HashMap<EObject, EObject>();
		for (Entry<EObject, EObject> entry : copier.entrySet()) {
			correspondenceMap.put(entry.getKey(), entry.getValue());
			correspondenceMap.put(entry.getValue(), entry.getKey());
		}
	}

	@Override
	public EObject getCorrespondingOriginalObject(EObject eObject) {
		return getCorrespondingObject(eObject);
	}

	@Override
	public EObject getCorrespondingMergedObject(EObject eObject) {
		return getCorrespondingObject(eObject);
	}

	/**
	 * Returns the corresponding {@link EObject} for the specified
	 * <code>eObject</code> irrespectively from whether it is in the original
	 * model or in the merged model since {@link #correspondenceMap} is
	 * bi-directional.
	 * 
	 * @param eObject
	 *            to get corresponding {@link EObject} for.
	 * @return {@link EObject} corresponding to <code>eObject</code> or
	 *         <code>null</code> if not available.
	 */
	private EObject getCorrespondingObject(EObject eObject) {
		if (eObject == null || correspondenceMap == null) {
			return null;
		}
		return correspondenceMap.get(eObject);
	}

	@Override
	public Map<EObject, EObject> getObjectCorrespondences() {
		return Collections.unmodifiableMap(correspondenceMap);
	}

	@Override
	public Collection<EObject> getCounterpartObjects(EObject eObject) {
		Collection<EObject> counterparts = new HashSet<EObject>();
		EObject counterpart = copier.get(eObject);
		counterparts.add(counterpart);
		return counterparts;
	}

	@Override
	public EObject getCounterpartObject(EObject eObject,
			DiffElement diffElement, EObject context) {
		EObject counterpart = copier.get(eObject);
		return counterpart;
	}

	@Override
	public boolean isInOriginModel(EObject object) {
		EObject rootContainer = org.eclipse.emf.ecore.util.EcoreUtil
				.getRootContainer(object);
		if (leftVersion.getMatch().getLeftRoots()
				.contains(rootContainer)) {
			return true;
		} else {
			return false;
		}
	}

}
