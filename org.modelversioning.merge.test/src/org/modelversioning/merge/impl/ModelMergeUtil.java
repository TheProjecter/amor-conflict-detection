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

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.junit.Test;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflicts.detection.engine.IConflictDetectionEngine;
import org.modelversioning.conflicts.detection.impl.ConflictDetectionEngineImpl;
import org.modelversioning.conflicts.detection.impl.ThreeWayDiffProvider;
import org.modelversioning.core.diff.service.DiffService;
import org.modelversioning.core.impl.UUIDResourceFactoryImpl;
import org.modelversioning.core.match.MatchException;
import org.modelversioning.core.match.service.MatchService;
import org.modelversioning.merge.IMergeStrategy;

/**
 * Utility for merging models.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ModelMergeUtil {

	/* ********************************************************************
	 * CONFIGURATION FIELDS
	 * ********************************************************************
	 */

	/* INPUT MODELS */
	final String originalModelPath = "model/origin.ecore";
	final String leftModelPath = "model/left.ecore";
	final String rightModelPath = "model/right.ecore";

	/* OUTPUT MODELS */
	final String mergedModelPath = "model/merged-model.ecore";
	final String conflictReportPath = "model/my.conflictreport";

	/* MERGE STRATEGY */
	IMergeStrategy mergeStrategy = new ConflictTolerantMergeStrategy();
	// IMergeStrategy mergeStrategy = new MergeNonConflictingStrategy();

	/* ********************************************************************
	 * ********************************************************************
	 * ********************************************************************
	 * ******************* END CONFIGURATION ******************************
	 * ********************************************************************
	 * ********************************************************************
	 * ********************************************************************
	 */

	/** The common resource set */
	ResourceSet resourceSet = new ResourceSetImpl();

	/*
	 * Service instances.
	 */
	MatchService matchService = new MatchService();
	DiffService diffService = new DiffService();
	IConflictDetectionEngine conflictDetectionEngine = new ConflictDetectionEngineImpl();

	@Test
	public void testMerge() throws IOException, MatchException {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new UUIDResourceFactoryImpl());

		// load models
		Resource originModelResource = (XMLResource) resourceSet
				.getResource(URI.createFileURI(new File(originalModelPath)
						.getAbsolutePath()), true);
		Resource leftModelResource = (XMLResource) resourceSet.getResource(
				URI.createFileURI(new File(leftModelPath).getAbsolutePath()),
				true);
		Resource rightModelResource = (XMLResource) resourceSet.getResource(
				URI.createFileURI(new File(rightModelPath).getAbsolutePath()),
				true);

		// compute differences
		ComparisonResourceSnapshot leftCRS = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(originModelResource,
								leftModelResource));
		ComparisonResourceSnapshot rightCRS = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(originModelResource,
								rightModelResource));

		// create three way diff view
		ThreeWayDiffProvider threeWayDiff = new ThreeWayDiffProvider(leftCRS,
				rightCRS);

		// detect conflicts
		ConflictReport conflictReport = conflictDetectionEngine
				.detectConflicts(threeWayDiff, new NullProgressMonitor());

		// perform the merge
		MergerImpl merger = new MergerImpl();
		merger.setMergeStrategy(mergeStrategy);
		Resource mergedModelResource = resourceSet.createResource(URI
				.createFileURI(new File(mergedModelPath).getAbsolutePath()));
		merger.merge(conflictReport, mergedModelResource,
				new NullProgressMonitor());

		// save the merged model
		mergedModelResource.save(null);

		// save the conflict report
		Resource conflictReportResource = resourceSet.createResource(URI
				.createFileURI(new File(conflictReportPath).getAbsolutePath()));
		conflictReportResource.getContents().add(conflictReport);
		conflictReportResource.save(null);

		// unload all resources
		originModelResource.unload();
		leftModelResource.unload();
		rightModelResource.unload();
		conflictReportResource.unload();
		mergedModelResource.unload();
	}

}
