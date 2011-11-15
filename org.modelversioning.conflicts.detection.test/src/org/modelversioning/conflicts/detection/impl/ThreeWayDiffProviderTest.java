package org.modelversioning.conflicts.detection.impl;

import java.io.File;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.modelversioning.core.diff.service.DiffService;
import org.modelversioning.core.match.service.MatchService;
import org.modelversioning.core.util.UUIDUtil;

public class ThreeWayDiffProviderTest extends TestCase {

	ResourceSet resourceSet = new ResourceSetImpl();
	MatchService matchService = new MatchService();
	DiffService diffService = new DiffService();
	private XMLResource test1OriginResource;
	private XMLResource test1LeftResource;
	private XMLResource test1RightResource;
	private XMLResource test2OriginResource;
	private XMLResource test2LeftResource;
	private XMLResource test2RightResource;
	private ThreeWayDiffProvider threeWayDiffProvider1;
	private ComparisonResourceSnapshot leftCRS1;
	private ComparisonResourceSnapshot rightCRS1;
	private ThreeWayDiffProvider threeWayDiffProvider2;
	private ComparisonResourceSnapshot leftCRS2;
	private ComparisonResourceSnapshot rightCRS2;

	protected void setUp() throws Exception {
		super.setUp();
		// loading model resources
		test1OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test1_origin_ids.ecore")
						.getAbsolutePath()), true);
		test1LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test1_left_ids.ecore")
						.getAbsolutePath()), true);
		EcoreUtil.resolveAll(resourceSet);
		test1RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test1_right_ids.ecore")
						.getAbsolutePath()), true);
		leftCRS1 = diffService.generateComparisonResourceSnapshot(matchService
				.generateMatchModel(test1OriginResource, test1LeftResource));
		rightCRS1 = diffService.generateComparisonResourceSnapshot(matchService
				.generateMatchModel(test1OriginResource, test1RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider1 = new ThreeWayDiffProvider(leftCRS1, rightCRS1);

		// loading model resources
		test2OriginResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test2_origin_ids.ecore")
						.getAbsolutePath()), true);
		test2LeftResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test2_left_ids.ecore")
						.getAbsolutePath()), true);
		test2RightResource = (XMLResource) resourceSet.getResource(URI
				.createFileURI(new File(
						"model/diff-provider-test2_right_ids.ecore")
						.getAbsolutePath()), true);
		leftCRS2 = diffService.generateComparisonResourceSnapshot(matchService
				.generateMatchModel(test2OriginResource, test2LeftResource));
		rightCRS2 = diffService.generateComparisonResourceSnapshot(matchService
				.generateMatchModel(test2OriginResource, test2RightResource));
		// create ThreeWayDiffProvider instance
		threeWayDiffProvider2 = new ThreeWayDiffProvider(leftCRS2, rightCRS2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		test1OriginResource.unload();
		test1LeftResource.unload();
		test1RightResource.unload();
		test2OriginResource.unload();
		test2LeftResource.unload();
		test2RightResource.unload();
	}

	public void testGetOriginModel() {
		assertEquals(test1OriginResource.getContents(),
				threeWayDiffProvider1.getOriginModel());
	}

	public void testGetLeftModel() {
		assertEquals(test1LeftResource.getContents(),
				threeWayDiffProvider1.getLeftModel());
	}

	public void testGetRightModel() {
		assertEquals(test1RightResource.getContents(),
				threeWayDiffProvider1.getRightModel());
	}

	public void testGetComparisonSnapshot() {
		assertEquals(leftCRS1,
				threeWayDiffProvider1.getComparisonSnapshot(Side.LEFT));
		assertEquals(rightCRS1,
				threeWayDiffProvider1.getComparisonSnapshot(Side.RIGHT));
	}

	public void testGetUpdatedEObjects() {
		// LEFT: CarManufactor has been deleted --> package cars has been
		// updated
		EObject carsPackage = UUIDUtil.getObject(test1OriginResource,
				"_g1IqEjNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getUpdatedEObjects(Side.LEFT, true)
				.contains(carsPackage));

		// LEFT: Company has been moved to package cars --> root package test1
		// and car is updated
		// LEFT: Enum Status (and two literals) --> root package test1 has been
		// updated
		EObject test1Package = UUIDUtil.getObject(test1OriginResource,
				"_g1FmwTNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getUpdatedEObjects(Side.LEFT, true)
				.contains(test1Package));

		// LEFT: Upperbound of Person/firstName has been updated to -1
		// ---> LEFT: Implicit update of Person, persons, and test1
		EObject firstNameAtt = UUIDUtil.getObject(test1OriginResource,
				"_g1J4MDNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getUpdatedEObjects(Side.LEFT, true)
				.contains(firstNameAtt));
		assertTrue(threeWayDiffProvider1.getUpdatedEObjects(Side.LEFT, false)
				.contains(firstNameAtt));
	}

	public void testGetUpdateElementsEObjectEStructuralFeatureSide() {
		// LEFT: CarManufactor has been deleted --> package cars has been
		// changed
		EObject carsPackage = UUIDUtil.getObject(test1OriginResource,
				"_g1IqEjNdEeCDk6pqpI_fUg");
		Set<DiffElement> updateElements = threeWayDiffProvider1
				.getUpdateElements(carsPackage, EcoreFactory.eINSTANCE
						.getEcorePackage().getEPackage_EClassifiers(),
						Side.LEFT);
		assertTrue(updateElements.size() > 0);

		// LEFT: Company has been moved to package cars --> root package test1
		// and car is implicitly updated
		// LEFT: Enum Status (and two literals) --> root package test1 has been
		// updated
		EObject test1Package = UUIDUtil.getObject(test1OriginResource,
				"_g1FmwTNdEeCDk6pqpI_fUg");
		Set<DiffElement> updateElements2 = threeWayDiffProvider1
				.getUpdateElements(test1Package, EcoreFactory.eINSTANCE
						.getEcorePackage().getEPackage_EClassifiers(),
						Side.LEFT);
		assertEquals(3, updateElements2.size());

		// LEFT: Upperbound of Person/firstName has been updated to -1
		// ---> LEFT: Implicit update of Person, persons, and test1
		EObject firstNameAtt = UUIDUtil.getObject(test1OriginResource,
				"_g1J4MDNdEeCDk6pqpI_fUg");
		Set<DiffElement> updateElements3 = threeWayDiffProvider1
				.getUpdateElements(firstNameAtt, EcoreFactory.eINSTANCE
						.getEcorePackage().getETypedElement_UpperBound(),
						Side.LEFT);
		assertEquals(1, updateElements3.size());
		assertEquals(
				0,
				threeWayDiffProvider1.getUpdateElements(
						firstNameAtt,
						EcoreFactory.eINSTANCE.getEcorePackage()
								.getETypedElement_LowerBound(), Side.LEFT)
						.size());
		// RIGHT: Upperbound of Person/firstName has been updated to 10
		// -- and Lowerbound to 1
		Set<DiffElement> updateElements4 = threeWayDiffProvider1
				.getUpdateElements(firstNameAtt, EcoreFactory.eINSTANCE
						.getEcorePackage().getETypedElement_UpperBound(),
						Side.RIGHT);
		assertEquals(1, updateElements4.size());
		Set<DiffElement> updateElements5 = threeWayDiffProvider1
				.getUpdateElements(firstNameAtt, EcoreFactory.eINSTANCE
						.getEcorePackage().getETypedElement_LowerBound(),
						Side.RIGHT);
		assertEquals(1, updateElements5.size());

	}

	public void testGetUpdateElementsEObjectSide() {
		// LEFT: CarManufactor has been deleted --> package cars has been
		// changed
		EObject carsPackage = UUIDUtil.getObject(test1OriginResource,
				"_g1IqEjNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getUpdateElements(carsPackage,
				Side.LEFT).size() > 0);

		// LEFT: Upperbound of Person/firstName has been updated to -1
		// ---> LEFT: Implicit update of Person, persons, and test1
		EObject person = UUIDUtil.getObject(test1OriginResource,
				"_g1JRJTNdEeCDk6pqpI_fUg");
		assertEquals(
				1,
				threeWayDiffProvider1.getImplicitUpdateElements(person,
						Side.LEFT).size());
		assertEquals(0,
				threeWayDiffProvider1.getUpdateElements(person, Side.LEFT)
						.size());

		// TODO add following tests:
		// LEFT: Company has been moved to package cars --> root package test1
		// and car is updated
		// LEFT: Enum Status (and two literals) --> root package test1 has been
		// updated

	}

	public void testGetDeletedEObjects() {
		// LEFT: CarManufactor (and its children) have been deleted
		EObject carManufactor = UUIDUtil.getObject(test1OriginResource,
				"_g1IqGDNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getDeletedEObjects(Side.LEFT, false)
				.contains(carManufactor));
		assertTrue(threeWayDiffProvider1.getDeletedEObjects(Side.LEFT, true)
				.contains(carManufactor));
		for (EObject child : carManufactor.eContents()) {
			assertTrue(threeWayDiffProvider1
					.getDeletedEObjects(Side.LEFT, true).contains(child));
			assertFalse(threeWayDiffProvider1.getDeletedEObjects(Side.LEFT,
					false).contains(child));
		}
		// LEFT: Chain has been removed
	}

	public void testGetDeleteElement() {
		// LEFT: CarManufactor (and its children) have been deleted
		EObject carManufactor = UUIDUtil.getObject(test1OriginResource,
				"_g1IqGDNdEeCDk6pqpI_fUg");
		ModelElementChange deleteDiffElement = threeWayDiffProvider1
				.getDeleteElement(carManufactor, Side.LEFT);
		assertNotNull(deleteDiffElement);
		for (EObject child : carManufactor.eContents()) {
			assertEquals(deleteDiffElement,
					threeWayDiffProvider1.getDeleteElement(child, Side.LEFT));
		}
		assertNull(threeWayDiffProvider1.getDeleteElement(
				carManufactor.eContainer(), Side.LEFT));
	}

	public void testGetAddedEObjects() {
		// LEFT: Enum Status (and two literals) has been added to root package
		EObject addedEnum = UUIDUtil.getObject(test1LeftResource,
				"_g1JRJTNdEeCDk6pqpI_fUg_STATUS");
		assertTrue(threeWayDiffProvider1.getAddedEObjects(Side.LEFT, false)
				.contains(addedEnum));
		assertFalse(threeWayDiffProvider1.getAddedEObjects(Side.LEFT, false)
				.contains(addedEnum.eContents().get(0)));
		assertTrue(threeWayDiffProvider1.getAddedEObjects(Side.LEFT, true)
				.contains(addedEnum.eContents().get(0)));
	}

	public void testGetAddElement() {
		// LEFT: Enum Status (and two literals) has been added to root package
		EObject addedEnum = UUIDUtil.getObject(test1LeftResource,
				"_g1JRJTNdEeCDk6pqpI_fUg_STATUS");
		ModelElementChange addDiffElement = threeWayDiffProvider1
				.getAddElement(addedEnum, Side.LEFT);
		assertNotNull(addDiffElement);
		for (EObject child : addedEnum.eContents()) {
			assertEquals(addDiffElement,
					threeWayDiffProvider1.getAddElement(child, Side.LEFT));
		}
		assertNull(threeWayDiffProvider1.getAddElement(addedEnum.eContainer(),
				Side.LEFT));
	}

	public void testGetMovedEObjects() {
		// LEFT: Company (and its children) has been moved to package cars
		EObject company = UUIDUtil.getObject(test1OriginResource,
				"_g1IDADNdEeCDk6pqpI_fUg");
		assertTrue(threeWayDiffProvider1.getMovedEObjects(Side.LEFT, false)
				.contains(company));
		assertFalse(threeWayDiffProvider1.getMovedEObjects(Side.LEFT, false)
				.contains(company.eContents().get(0)));
		assertTrue(threeWayDiffProvider1.getMovedEObjects(Side.LEFT, true)
				.contains(company.eContents().get(0)));
	}

	public void testGetMoveElement() {
		// LEFT: Company (and its children) has been moved to package cars
		EObject company = UUIDUtil.getObject(test1OriginResource,
				"_g1IDADNdEeCDk6pqpI_fUg");
		MoveModelElement moveModelDiffElement = threeWayDiffProvider1
				.getMoveElement(company, Side.LEFT);
		assertNotNull(moveModelDiffElement);
		for (EObject child : company.eContents()) {
			assertEquals(moveModelDiffElement,
					threeWayDiffProvider1.getMoveElement(child, Side.LEFT));
		}
		assertNull(threeWayDiffProvider1.getMoveElement(company.eContainer(),
				Side.LEFT));
	}

	public void testGetAddReferencedEObjects() {
		// LEFT: Company has been set as type in partOf
		// LEFT: Car has been added as superclass of Chain
		EObject company = UUIDUtil.getObject(test2OriginResource,
				"_g1IDADNdEeCDk6pqpI_fUg");
		EObject car = UUIDUtil.getObject(test2OriginResource,
				"_g1IqEzNdEeCDk6pqpI_fUg");
		EList<EObject> referencedEObjects = threeWayDiffProvider2
				.getAddReferencedEObjects(Side.LEFT);
		assertEquals(2, referencedEObjects.size());
		assertTrue(referencedEObjects.contains(company));
		assertTrue(referencedEObjects.contains(car));
	}

	public void testGetMatchingEObject() {
		EObject originalPerson = UUIDUtil.getObject(test1OriginResource,
				"_g1JRJTNdEeCDk6pqpI_fUg");
		EObject leftPerson = UUIDUtil.getObject(test1LeftResource,
				"_g1JRJTNdEeCDk6pqpI_fUg");
		EObject rightPerson = UUIDUtil.getObject(test1RightResource,
				"_g1JRJTNdEeCDk6pqpI_fUg");
		assertEquals(originalPerson, threeWayDiffProvider1.getMatchingEObject(
				leftPerson, Side.LEFT, true));
		assertEquals(originalPerson, threeWayDiffProvider1.getMatchingEObject(
				rightPerson, Side.RIGHT, true));
		assertEquals(leftPerson, threeWayDiffProvider1.getMatchingEObject(
				rightPerson, Side.RIGHT, false));
		assertEquals(rightPerson, threeWayDiffProvider1.getMatchingEObject(
				leftPerson, Side.LEFT, false));
	}

}
