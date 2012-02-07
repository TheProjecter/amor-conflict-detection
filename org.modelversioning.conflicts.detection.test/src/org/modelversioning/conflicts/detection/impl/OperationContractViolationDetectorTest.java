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

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.BindingSizeDifference;
import org.modelversioning.conflictreport.conflict.ConditionViolation;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DifferentBindingSize;
import org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition;
import org.modelversioning.conflictreport.conflict.MissingObject;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;
import org.modelversioning.conflictreport.conflict.ViolatedPrecondition;
import org.modelversioning.conflicts.detection.composite.OperationContractViolationDetector;
import org.modelversioning.core.conditions.util.ConditionsUtil;
import org.modelversioning.core.diff.service.DiffService;
import org.modelversioning.core.diff.util.DiffUtil;
import org.modelversioning.core.impl.UUIDResourceFactoryImpl;
import org.modelversioning.core.match.MatchException;
import org.modelversioning.core.match.service.MatchService;
import org.modelversioning.operations.OperationSpecification;
import org.modelversioning.operations.detection.operationoccurrence.OperationOccurrence;
import org.modelversioning.operations.detection.service.OperationDetectionService;
import org.modelversioning.operations.repository.impl.OperationRepositoryImpl;

/**
 * 
 * <h2>Documentation of test scenarios</h2> <h3>Test 1</h3>
 * <p>
 * A new super class has been extracted from Client, Employer, and Employee and
 * their common attribute firstName has been pulled up.
 * </p>
 * <p>
 * Depending on the operation detection, an object (the name of an attribute),
 * originally bound to an iterated or non-iterated template, has been
 * concurrently changed so that it does not match any more.
 * </p>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class OperationContractViolationDetectorTest {

	ResourceSet resourceSet = new ResourceSetImpl();

	MatchService matchService = new MatchService();
	DiffService diffService = new DiffService();
	OperationDetectionService operationDetectionService = new OperationDetectionService();

	Set<OperationSpecification> operationSpecifications = new HashSet<OperationSpecification>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new UUIDResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("operation", new EcoreResourceFactoryImpl());

		// load operation specifications
		OperationSpecification extractSC = (OperationSpecification) resourceSet
				.getResource(
						URI.createFileURI(new File(
								"model/ecore_extractSuperClass.operation")
								.getAbsolutePath()), true).getContents().get(0);
		operationSpecifications.add(extractSC);
		OperationSpecification pullUpAtt = (OperationSpecification) resourceSet
				.getResource(
						URI.createFileURI(new File(
								"model/ecore_pullUpAttribute.operation")
								.getAbsolutePath()), true).getContents().get(0);
		operationSpecifications.add(pullUpAtt);

		// prepare operation repository
		OperationRepositoryImpl operationRepository = new OperationRepositoryImpl();
		for (OperationSpecification os : operationSpecifications) {
			operationRepository.register(os);
		}
		operationDetectionService
				.setModelOperationRepository(operationRepository);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

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

	@Test
	public void testViolatedConditionAgainstIteratedTemplate()
			throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test1_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test1_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test1_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getLeftChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getRightChange() instanceof UpdateAttribute);
		UpdateAttribute update = (UpdateAttribute) ocv.getRightChange();
		Assert.assertEquals("name", update.getAttribute().getName());
		Assert.assertTrue(ocv.getDiagnostics() instanceof ViolatedPrecondition);
		ViolatedPrecondition diagnostics = (ViolatedPrecondition) ocv
				.getDiagnostics();
		Assert.assertTrue(diagnostics.getConditionViolations().size() > 0);

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testMissingObject() throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test6_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test6_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test6_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getLeftChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getRightChange() instanceof ModelElementChangeRightTarget);
		Assert.assertTrue(ocv.getDiagnostics() instanceof MissingObject);

		MissingObject diagnostics = (MissingObject) ocv.getDiagnostics();
		Assert.assertEquals(diagnostics.getMissingObject(),
				DiffUtil.getRightElement(ocv.getRightChange()));

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testNoViolation() throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test2_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test2_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test2_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));
		Assert.assertEquals(0, conflicts.size());

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testBindingGotBigger() throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test3_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test3_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test3_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getLeftChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getDiagnostics() instanceof DifferentBindingSize);
		Assert.assertTrue(BindingSizeDifference.INCREASED
				.equals(((DifferentBindingSize) ocv.getDiagnostics())
						.getDifferenceKind()));

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testMatchingNAChavingNEx() throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test4_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test4_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test4_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getRightChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getLeftChange() instanceof ModelElementChangeLeftTarget);
		Assert.assertTrue(ocv.getDiagnostics() instanceof MatchingNegativeApplicationCondition);
		MatchingNegativeApplicationCondition matchingNAC = (MatchingNegativeApplicationCondition) ocv
				.getDiagnostics();
		Assert.assertEquals("No other sub-class not having the attribute",
				matchingNAC.getNegativeApplicationCondition().getName());

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testMatchingNAChavingNExByChangingAProperty()
			throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test7_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test7_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test7_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getRightChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getLeftChange() instanceof ReferenceChangeLeftTarget);
		Assert.assertTrue(ocv.getDiagnostics() instanceof MatchingNegativeApplicationCondition);
		MatchingNegativeApplicationCondition matchingNAC = (MatchingNegativeApplicationCondition) ocv
				.getDiagnostics();
		Assert.assertEquals("No other sub-class not having the attribute",
				matchingNAC.getNegativeApplicationCondition().getName());

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	@Test
	public void testNoBindingCanBeFoundAtAll() throws MatchException {
		Resource originResource = loadResource("model/ocv-detector_test5_origin_ids.ecore");
		Resource leftResource = loadResource("model/ocv-detector_test5_left_ids.ecore");
		Resource rightResource = loadResource("model/ocv-detector_test5_right_ids.ecore");

		ThreeWayDiffProvider diffProvider = getThreeWayDiffProvider(
				originResource, leftResource, rightResource);

		OperationContractViolationDetector detector = new OperationContractViolationDetector();
		EList<Conflict> conflicts = getEmptyConflictList();
		detector.detectOperationContractViolations(diffProvider, conflicts,
				getEmptyEquivalentChangesList(), new SubProgressMonitor(
						getProgressMonitor(), 1));

		Assert.assertEquals(1, conflicts.size());
		Assert.assertTrue(conflicts.get(0) instanceof OperationContractViolation);
		OperationContractViolation ocv = (OperationContractViolation) conflicts
				.get(0);
		Assert.assertTrue(ocv.getLeftChange() instanceof OperationOccurrence);
		Assert.assertTrue(ocv.getRightChange() instanceof UpdateAttribute);
		UpdateAttribute update = (UpdateAttribute) ocv.getRightChange();
		Assert.assertEquals("name", update.getAttribute().getName());

		Assert.assertTrue(ocv.getDiagnostics() instanceof ViolatedPrecondition);
		ViolatedPrecondition violatedPrecondition = (ViolatedPrecondition) ocv
				.getDiagnostics();
		for (ConditionViolation violation : violatedPrecondition
				.getConditionViolations()) {
			Assert.assertEquals(" = #{EAttribute_0}.name", ConditionsUtil
					.getExpression(violation.getViolatedCondition()));
		}

		originResource.unload();
		leftResource.unload();
		rightResource.unload();
	}

	private ThreeWayDiffProvider getThreeWayDiffProvider(
			Resource test1OriginResource, Resource test1LeftResource,
			Resource test1RightResource) throws MatchException {
		ComparisonResourceSnapshot leftCRS_test1 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test1OriginResource,
								test1LeftResource));
		ComparisonResourceSnapshot rightCRS_test1 = diffService
				.generateComparisonResourceSnapshot(matchService
						.generateMatchModel(test1OriginResource,
								test1RightResource));
		operationDetectionService.findAndAddOperationOccurrences(leftCRS_test1);
		operationDetectionService
				.findAndAddOperationOccurrences(rightCRS_test1);
		ThreeWayDiffProvider threeWayDiffProvider_test1 = new ThreeWayDiffProvider(
				leftCRS_test1, rightCRS_test1);
		return threeWayDiffProvider_test1;
	}

	private Resource loadResource(String path) {
		return resourceSet.getResource(
				URI.createFileURI(new File(path).getAbsolutePath()), true);
	}

}
