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

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelversioning.conflictreport.ConflictReport;

/**
 * Merges two concurrently modified models having a common origin model based on
 * a {@link ConflictReport}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IMerger {

	/**
	 * Sets the {@link IMergeStrategy} to use for merging.
	 * 
	 * @param mergeStrategy
	 *            to set.
	 */
	public void setMergeStrategy(IMergeStrategy mergeStrategy);

	/**
	 * Returns the current {@link IMergeStrategy} in use.
	 * 
	 * @return the current {@link IMergeStrategy} in use.
	 */
	public IMergeStrategy getMergeStrategy();

	/**
	 * Merges the models accessible through the specified
	 * <code>conflictReport</code> and puts the resulting merged model into the
	 * specified <code>mergedModelResource</code>.
	 * 
	 * <p>
	 * Before calling this method, {@link #setMergeStrategy(IMergeStrategy) set}
	 * the intended {@link IMergeStrategy} to be used.
	 * </p>
	 * 
	 * @param conflictReport
	 *            referring to the models to merge and containing the conflicts
	 *            to regard.
	 * @param mergedModelResource
	 *            resource to which the merged model shall be added.
	 * @param monitor
	 *            to report progress.
	 */
	public void merge(ConflictReport conflictReport,
			Resource mergedModelResource, IProgressMonitor monitor);

	/**
	 * Merges the models given in <code>leftVersion</code> and <code>rightVersion</code>
	 * considering conflicts specified in the <code>conflictReport</code> and puts 
	 * the resulting merged model into the specified <code>mergedModelResource</code>.
	 * 
	 * <p>
	 * Before calling this method, {@link #setMergeStrategy(IMergeStrategy) set}
	 * the intended {@link IMergeStrategy} to be used.
	 * </p>
	 * 
	 * @param conflictReport
	 *            referring to the models to merge and containing the conflicts
	 *            to regard.
	 * @param leftVersion
	 * 			  containing the left model version to merge.
	 * @param rightVersion
	 * 			  containing the right model version to merge.
	 * @param mergedModelResource
	 *            resource to which the merged model shall be added.
	 * @param monitor
	 *            to report progress.
	 */
	public void merge(ConflictReport conflictReport,
			ComparisonResourceSnapshot leftVersion,
			ComparisonResourceSnapshot rightVersion,
			Resource mergedModelResource, IProgressMonitor monitor);

	/**
	 * Returns the {@link EObject} in the original model corresponding to the
	 * specified <code>eObject</code> from the merged model or <code>null</code>
	 * if there is no corresponding object.
	 * 
	 * <p>
	 * This method can only provide results after
	 * {@link #merge(ConflictReport, Resource) merge} has been called.
	 * </p>
	 * 
	 * @param eObject
	 *            to get corresponding original {@link EObject} for.
	 * @return the corresponding original {@link EObject} or <code>null</code>
	 *         if there is no corresponding object.
	 */
	public EObject getCorrespondingOriginalObject(EObject eObject);

	/**
	 * Returns the {@link EObject} in the merged model corresponding to the
	 * specified <code>eObject</code> from the original model or
	 * <code>null</code> if there is no corresponding object.
	 * 
	 * <p>
	 * This method can only provide results after
	 * {@link #merge(ConflictReport, Resource) merge} has been called.
	 * </p>
	 * 
	 * @param eObject
	 *            to get corresponding merged {@link EObject} for.
	 * @return the corresponding merged {@link EObject} or <code>null</code> if
	 *         there is no corresponding object.
	 */
	public EObject getCorrespondingMergedObject(EObject eObject);

	/**
	 * Returns a {@link Map} of correspondences between the original
	 * {@link EObject EObjects} and the merged {@link EObject EObjects}.
	 * 
	 * <p>
	 * This method can only provide results after
	 * {@link #merge(ConflictReport, Resource) merge} has been called.
	 * </p>
	 * 
	 * @return the correspondence map.
	 */
	public Map<EObject, EObject> getObjectCorrespondences();

}
