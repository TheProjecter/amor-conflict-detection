package org.modelversioning.conflicts.detection.impl;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.core.diff.service.DiffService;
import org.modelversioning.core.match.service.MatchService;

public abstract class ConflictDetectorTestCase extends TestCase {

	ResourceSet resourceSet = new ResourceSetImpl();
	MatchService matchService = new MatchService();
	DiffService diffService = new DiffService();
	private XMLResource test1OriginResource;
	private XMLResource test1LeftResource;
	private XMLResource test1RightResource;
	protected ThreeWayDiffProvider threeWayDiffProvider_test1;
	private ComparisonResourceSnapshot leftCRS_test1;
	private ComparisonResourceSnapshot rightCRS_test1;
	private XMLResource test2OriginResource;
	private XMLResource test2LeftResource;
	private XMLResource test2RightResource;
	private ComparisonResourceSnapshot leftCRS_test2;
	private ComparisonResourceSnapshot rightCRS_test2;
	protected ThreeWayDiffProvider threeWayDiffProvider_test2;
	private XMLResource test3OriginResource;
	private XMLResource test3LeftResource;
	private XMLResource test3RightResource;
	private ComparisonResourceSnapshot leftCRS_test3;
	private ComparisonResourceSnapshot rightCRS_test3;
	protected ThreeWayDiffProvider threeWayDiffProvider_test3;
	private XMLResource test4OriginResource;
	private XMLResource test4LeftResource;
	private XMLResource test4RightResource;
	private ComparisonResourceSnapshot leftCRS_test4;
	private ComparisonResourceSnapshot rightCRS_test4;
	protected ThreeWayDiffProvider threeWayDiffProvider_test4;

	protected void setUp() throws Exception {
		super.setUp();
		// loading model resources test 1
		test1OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test1_origin_ids.ecore")
						.getAbsolutePath()), true);
		test1LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test1_left_ids.ecore")
						.getAbsolutePath()), true);
		test1RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test1_right_ids.ecore")
						.getAbsolutePath()), true);
		leftCRS_test1 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test1OriginResource,
								test1LeftResource));
		rightCRS_test1 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test1OriginResource,
								test1RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider_test1 = new ThreeWayDiffProvider(leftCRS_test1,
				rightCRS_test1);

		// loading model resources test 2
		test2OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test2_origin.xmi")
						.getAbsolutePath()), true);
		test2LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test2_left.xmi")
						.getAbsolutePath()), true);
		test2RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test2_right.xmi")
						.getAbsolutePath()), true);
		leftCRS_test2 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test2OriginResource,
								test2LeftResource));
		rightCRS_test2 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test2OriginResource,
								test2RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider_test2 = new ThreeWayDiffProvider(leftCRS_test2,
				rightCRS_test2);

		// loading model resources test 3
		test3OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test3_origin.ecore")
						.getAbsolutePath()), true);
		test3LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test3_left.ecore")
						.getAbsolutePath()), true);
		test3RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test3_right.ecore")
						.getAbsolutePath()), true);
		leftCRS_test3 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test3OriginResource,
								test3LeftResource));
		rightCRS_test3 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test3OriginResource,
								test3RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider_test3 = new ThreeWayDiffProvider(leftCRS_test3,
				rightCRS_test3);
		
		
		// loading model resources test 4
		test4OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test4_origin.ecore")
						.getAbsolutePath()), true);
		test4LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test4_left.ecore")
						.getAbsolutePath()), true);
		test4RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/conflict-detector_test4_right.ecore")
						.getAbsolutePath()), true);
		leftCRS_test4 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test4OriginResource,
								test4LeftResource));
		rightCRS_test4 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test4OriginResource,
								test4RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider_test4 = new ThreeWayDiffProvider(leftCRS_test4,
				rightCRS_test4);

		EcoreUtil.resolveAll(resourceSet);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		test1OriginResource.unload();
		test1LeftResource.unload();
		test1RightResource.unload();
		test2OriginResource.unload();
		test2LeftResource.unload();
		test2RightResource.unload();
		test3OriginResource.unload();
		test3LeftResource.unload();
		test3RightResource.unload();
		test4OriginResource.unload();
		test4LeftResource.unload();
		test4RightResource.unload();
	}

	protected EList<Conflict> getEmptyConflictList() {
		return new BasicEList<Conflict>();
	}

	protected EList<EquivalentChange> getEmptyEquivalentChangesList() {
		return new BasicEList<EquivalentChange>();
	}

	protected IProgressMonitor getProgressMonitor() {
		return new NullProgressMonitor();
	}

	abstract void testDetectConflicts();
}
