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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.core.diff.util.DiffUtil;

/**
 * Implementation of the {@link IThreeWayDiffProvider} working with lots of hash
 * maps for caching in order to speed up answering diff model queries.
 * 
 * <p>
 * This provider operates on two separate {@link ComparisonResourceSnapshot},
 * one for each side. In particular, there must be a left comparison snapshot
 * containing the match and the diff between origin and the modified model on
 * the left, and another comparison snapshot containing the match and the diff
 * between origin and the modified model on the right.
 * </p>
 * 
 * <p>
 * Please note, that the origin model (right side of each comparison snapshot)
 * must be the same in terms of object equivalence.
 * </p>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ThreeWayDiffProvider implements IThreeWayDiffProvider {

	/** the left comparison snapshot. */
	private ComparisonResourceSnapshot leftComparison;
	/** the right comparison snapshot. */
	private ComparisonResourceSnapshot rightComparison;

	/* *************************************************
	 * Effective Diff Elements
	 */
	/** A list of all effective diff elements of the left side. */
	private EList<DiffElement> leftEffectiveDiffs;
	/** A list of all effective diff elements of the right side. */
	private EList<DiffElement> rightEffectiveDiffs;

	/* *************************************************
	 * Updated Elements
	 */
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly updated on the left side.
	 */
	private EList<EObject> leftUpdatedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly updated on the left side.
	 */
	private EList<EObject> leftImplicitlyUpdatedEObjects;
	/**
	 * A map of updated {@link EObject EObjects} (contained by the origin model)
	 * to {@link FeatureUpdates} of the left side.
	 */
	private Map<EObject, FeatureUpdates> leftUpdatedFeatureMap;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly updated on the right side.
	 */
	private EList<EObject> rightUpdatedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly updated on the right side.
	 */
	private EList<EObject> rightImplicitlyUpdatedEObjects;
	/**
	 * A map of updated {@link EObject EObjects} (contained by the origin model)
	 * to {@link FeatureUpdates} of the right side.
	 */
	private Map<EObject, FeatureUpdates> rightUpdatedFeatureMap;
	/**
	 * A map of implicitly updated {@link EObject EObjects} (contained by the
	 * origin model) to {@link DiffElement DiffElements} of the left side.
	 */
	private Map<EObject, EList<DiffElement>> leftImplicitUpdateElements;
	/**
	 * A map of implicitly updated {@link EObject EObjects} (contained by the
	 * origin model) to {@link DiffElement DiffElements} of the right side.
	 */
	private Map<EObject, EList<DiffElement>> rightImplicitUpdateElements;

	/* *************************************************
	 * Add Referenced EObjects
	 */
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * added as a value to a reference in the left side.
	 */
	private EList<EObject> leftAddReferencedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * added as a value to a reference in the right side.
	 */
	private EList<EObject> rightAddReferencedEObjects;
	/**
	 * A map of newly referenced {@link EObject EObjects} (contained by the
	 * origin model) to the {@link DiffElement DiffElement} (either reference
	 * change or addition of a model element that contains cross references to
	 * existing model elements) that represent the reference value addition.
	 */
	private Map<EObject, Set<DiffElement>> leftAddReferenceElements;
	/**
	 * A map of newly referenced {@link EObject EObjects} (contained by the
	 * origin model) to the {@link DiffElement DiffElement} (either reference
	 * change or addition of a model element that contains cross references to
	 * existing model elements) that represent the reference value addition.
	 */
	private Map<EObject, Set<DiffElement>> rightAddReferenceElements;

	/* *************************************************
	 * Added Elements
	 */
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly added on the left side.
	 */
	private EList<EObject> leftAddedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly added on the left side.
	 */
	private EList<EObject> leftImplicitlyAddedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly added on the right side.
	 */
	private EList<EObject> rightAddedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly added on the right side.
	 */
	private EList<EObject> rightImplicitlyAddedEObjects;
	/**
	 * A map of added {@link EObject EObjects} (contained by the left revised
	 * model) to the {@link ModelElementChange} that represent the addition.
	 */
	private Map<EObject, ModelElementChange> leftAddElements;
	/**
	 * A map of added {@link EObject EObjects} (contained by the right revised
	 * model) to the {@link ModelElementChange} that represent the addition.
	 */
	private Map<EObject, ModelElementChange> rightAddElements;

	/* *************************************************
	 * Deleted Elements
	 */
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly deleted on the left side.
	 */
	private EList<EObject> leftDeletedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly deleted on the left side.
	 */
	private EList<EObject> leftImplicitlyDeletedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly deleted on the right side.
	 */
	private EList<EObject> rightDeletedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly deleted on the right side.
	 */
	private EList<EObject> rightImplicitlyDeletedEObjects;
	/**
	 * A map of {@link EObject EObjects} deleted on the left side and contained
	 * by the origin model) to the {@link ModelElementChange} that represents
	 * the deletion.
	 */
	private Map<EObject, ModelElementChange> leftDeleteElements;
	/**
	 * A map of {@link EObject EObjects} deleted on the right side and contained
	 * by the origin model) to the {@link ModelElementChange} that represents
	 * the deletion.
	 */
	private Map<EObject, ModelElementChange> rightDeleteElements;

	/* *************************************************
	 * Moved Elements
	 */
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly moved on the left side.
	 */
	private EList<EObject> leftMovedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly moved on the left side.
	 */
	private EList<EObject> leftImplicitlyMovedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * directly moved on the right side.
	 */
	private EList<EObject> rightMovedEObjects;
	/**
	 * A list of all objects (contained by the origin model) which have been
	 * implicitly moved on the right side.
	 */
	private EList<EObject> rightImplicitlyMovedEObjects;
	/**
	 * A map of {@link EObject EObjects} moved on the left side and contained by
	 * the origin model) to the {@link MoveModelElement} that represents the
	 * movement.
	 */
	private Map<EObject, MoveModelElement> leftMoveElements;
	/**
	 * A map of {@link EObject EObjects} moved on the right side and contained
	 * by the origin model) to the {@link MoveModelElement} that represents the
	 * movement.
	 */
	private Map<EObject, MoveModelElement> rightMoveElements;

	/* *************************************************
	 * Match Maps
	 */
	/** Contains a map of matching objects (left side) for both directions. */
	private Map<EObject, EObject> leftMatchMap;
	/** Contains a map of matching objects (right side) for both directions. */
	private Map<EObject, EObject> rightMatchMap;

	/**
	 * Creates and initializes this provider for the two specified
	 * {@link ComparisonResourceSnapshot}.
	 * 
	 * <p>
	 * It is assumed that the {@link MatchModel#getRightRoots() right side} in
	 * each specified {@link ComparisonResourceSnapshot} is the common origin
	 * model.
	 * </p>
	 * 
	 * @param leftComparison
	 *            left comparison report.
	 * @param rightComparison
	 *            right comparison report.
	 */
	public ThreeWayDiffProvider(ComparisonResourceSnapshot leftComparison,
			ComparisonResourceSnapshot rightComparison) {
		super();
		this.leftComparison = leftComparison;
		this.rightComparison = rightComparison;
		// check if origin is the same in both comparison snapshot
		for (EObject originObject : leftComparison.getMatch().getLeftRoots()) {
			Assert.isTrue(rightComparison.getMatch().getLeftRoots()
					.contains(originObject));
		}
		initialize();
	}

	/**
	 * Initializing this provider from scratch.
	 */
	private void initialize() {
		// compute effective diff elements of each side
		leftEffectiveDiffs = DiffUtil.getEffectiveDiffElements(leftComparison
				.getDiff());
		rightEffectiveDiffs = DiffUtil.getEffectiveDiffElements(rightComparison
				.getDiff());
		// fill match maps
		fillMatchMaps();

		// initialize all lists and maps
		initializeLeftListsAndMaps();
		initializeRightListsAndMaps();

		// sort in diff elements
		sortIn(leftEffectiveDiffs, Side.LEFT);
		sortIn(rightEffectiveDiffs, Side.RIGHT);
	}

	private void fillMatchMaps() {
		leftMatchMap = new HashMap<EObject, EObject>();
		rightMatchMap = new HashMap<EObject, EObject>();
		fillMatchMap(leftMatchMap, leftComparison.getMatch());
		fillMatchMap(rightMatchMap, rightComparison.getMatch());
	}

	private void fillMatchMap(Map<EObject, EObject> matchMap, MatchModel match) {
		fillMatchMap(matchMap, match.getMatchedElements());
	}

	private void fillMatchMap(Map<EObject, EObject> matchMap,
			EList<MatchElement> matchedElements) {
		for (MatchElement matchElement : matchedElements) {
			if (matchElement instanceof Match2Elements) {
				Match2Elements match2Elements = (Match2Elements) matchElement;
				matchMap.put(match2Elements.getLeftElement(),
						match2Elements.getRightElement());
				matchMap.put(match2Elements.getRightElement(),
						match2Elements.getLeftElement());
			}
			fillMatchMap(matchMap, matchElement.getSubMatchElements());
		}
	}

	private void initializeRightListsAndMaps() {
		rightAddedEObjects = new BasicEList<EObject>();
		rightAddElements = new HashMap<EObject, ModelElementChange>();
		rightAddReferencedEObjects = new BasicEList<EObject>();
		rightAddReferenceElements = new HashMap<EObject, Set<DiffElement>>();
		rightDeletedEObjects = new BasicEList<EObject>();
		rightDeleteElements = new HashMap<EObject, ModelElementChange>();
		rightImplicitlyAddedEObjects = new BasicEList<EObject>();
		rightImplicitlyDeletedEObjects = new BasicEList<EObject>();
		rightImplicitlyMovedEObjects = new BasicEList<EObject>();
		rightImplicitlyUpdatedEObjects = new BasicEList<EObject>();
		rightImplicitUpdateElements = new HashMap<EObject, EList<DiffElement>>();
		rightMovedEObjects = new BasicEList<EObject>();
		rightMoveElements = new HashMap<EObject, MoveModelElement>();
		rightUpdatedEObjects = new BasicEList<EObject>();
		rightUpdatedFeatureMap = new HashMap<EObject, FeatureUpdates>();
	}

	private void initializeLeftListsAndMaps() {
		leftAddedEObjects = new BasicEList<EObject>();
		leftAddElements = new HashMap<EObject, ModelElementChange>();
		leftAddReferencedEObjects = new BasicEList<EObject>();
		leftAddReferenceElements = new HashMap<EObject, Set<DiffElement>>();
		leftDeletedEObjects = new BasicEList<EObject>();
		leftDeleteElements = new HashMap<EObject, ModelElementChange>();
		leftImplicitlyAddedEObjects = new BasicEList<EObject>();
		leftImplicitlyDeletedEObjects = new BasicEList<EObject>();
		leftImplicitlyMovedEObjects = new BasicEList<EObject>();
		leftImplicitlyUpdatedEObjects = new BasicEList<EObject>();
		leftImplicitUpdateElements = new HashMap<EObject, EList<DiffElement>>();
		leftMovedEObjects = new BasicEList<EObject>();
		leftMoveElements = new HashMap<EObject, MoveModelElement>();
		leftUpdatedEObjects = new BasicEList<EObject>();
		leftUpdatedFeatureMap = new HashMap<EObject, FeatureUpdates>();
	}

	/**
	 * Walks through and sorts in the specified <code>diffElements</code> for
	 * the lists and maps containing the elements for the specified
	 * <code>side</code>.
	 * 
	 * @param diffElements
	 *            to sort in.
	 * @param side
	 *            to sort into.
	 */
	private void sortIn(EList<DiffElement> diffElements, Side side) {
		for (DiffElement diffElement : diffElements) {

			// Deletion
			// -- ModelElementChangeRightTarget
			// -- -- Regard implicitly removed elements (children)
			if (diffElement instanceof ModelElementChangeRightTarget) {
				ModelElementChangeRightTarget deleteElement = (ModelElementChangeRightTarget) diffElement;

				// fill in deleted objects
				EObject deletedObject = deleteElement.getRightElement();
				getDeletedEObjects(side).add(deletedObject);
				EList<EObject> implicitlyDeletedObjects = getAllChildren(deletedObject);
				getImplicitlyDeletedEObjects(side).addAll(
						implicitlyDeletedObjects);

				// fill in delete diff element
				getDeleteElements(side).put(deletedObject, deleteElement);
				for (EObject implicitlyDeletedObject : implicitlyDeletedObjects) {
					getDeleteElements(side).put(implicitlyDeletedObject,
							deleteElement);
				}

				// fill in containment feature update
				if (deletedObject.eContainmentFeature() != null) {
					fillInFeatureUpdate(deletedObject.eContainer(),
							deletedObject.eContainmentFeature(), diffElement,
							side);
				}
			} else
			// Addition
			// -- ModelElementChangeLeftTarget
			// -- -- Regard implicitly added elements (children)
			// -- -- Regard update of parent
			if (diffElement instanceof ModelElementChangeLeftTarget) {
				ModelElementChangeLeftTarget addElement = (ModelElementChangeLeftTarget) diffElement;

				// fill in added objects
				EObject addedObject = addElement.getLeftElement();
				getAddedEObjects(side).add(addedObject);
				EList<EObject> implicitlyAddedObjects = getAllChildren(addedObject);
				getImplicitlyAddedEObjects(side).addAll(implicitlyAddedObjects);

				// fill in implicitly added references to existing model
				// elements from the added model element
				fillInImplicitlyAddedReferences(side, addedObject, diffElement);

				// fill in add diff element
				getAddElements(side).put(addedObject, addElement);
				for (EObject implicitlyAddedObject : implicitlyAddedObjects) {
					getAddElements(side).put(implicitlyAddedObject, addElement);
					fillInImplicitlyAddedReferences(side,
							implicitlyAddedObject, diffElement);
				}

				// fill in containment feature update
				if (addedObject.eContainmentFeature() != null) {
					EObject matchingContainer = getMatchingEObject(
							addedObject.eContainer(), side, true);
					if (matchingContainer != null) {
						fillInFeatureUpdate(matchingContainer,
								addedObject.eContainmentFeature(), diffElement,
								side);
					}
				}

			} else
			// Movement
			// -- MoveModelElement
			// -- -- Regard implicitly moved elements (children)
			// -- -- Regard update of old and new parent
			if (diffElement instanceof MoveModelElement) {
				MoveModelElement moveElement = (MoveModelElement) diffElement;

				// fill in moved objects
				EObject movedObject = moveElement.getRightElement();
				getMovedEObjects(side).add(movedObject);
				EList<EObject> implicitlyMovedObjects = getAllChildren(movedObject);
				getImplicitlyMovedEObjects(side).addAll(implicitlyMovedObjects);

				// fill in move diff element
				getMoveElements(side).put(movedObject, moveElement);
				for (EObject implicitlyMovedObject : implicitlyMovedObjects) {
					getMoveElements(side).put(implicitlyMovedObject,
							moveElement);
				}

				// fill in containment feature update
				if (movedObject.eContainmentFeature() != null) {
					// source container
					fillInFeatureUpdate(movedObject.eContainer(),
							movedObject.eContainmentFeature(), diffElement,
							side);
					// target container
					EObject targetContainer = getMatchingEObject(moveElement
							.getLeftElement().eContainer(), side, true);
					if (targetContainer != null) {
						fillInFeatureUpdate(targetContainer,
								movedObject.eContainmentFeature(), diffElement,
								side);
					}
				}
			} else
			// AttributeChangeRightTarget
			// AttributeChangeLeftTarget
			// AttributeChange
			if (diffElement instanceof AttributeChange) {
				AttributeChange attributeChange = (AttributeChange) diffElement;
				fillInFeatureUpdate(attributeChange.getRightElement(),
						attributeChange.getAttribute(), diffElement, side);
			} else
			// ReferenceChange
			// ReferenceChangeRightTarget
			// ReferenceChangeLeftTarget
			if (diffElement instanceof ReferenceChange) {
				ReferenceChange referenceChange = (ReferenceChange) diffElement;
				fillInFeatureUpdate(referenceChange.getRightElement(),
						referenceChange.getReference(), diffElement, side);
				// check for add reference value elements
				if (referenceChange instanceof UpdateReference) {
					// single valued reference update
					UpdateReference updateReference = (UpdateReference) referenceChange;
					EObject referencedObject = getMatchingEObject(
							updateReference.getLeftTarget(), side, true);
					// We have to double-check if the set value (left side !=
					// origin) is not null since EMF Compare still sets a value
					// to getLeftTarget() although it has been set to null
					if (referencedObject != null
							&& updateReference.getLeftElement().eGet(
									updateReference.getReference()) != null) {
						getAddReferencedEObjectsSet(side).add(referencedObject);
						Set<DiffElement> referenceChanges = getAddReferenceElements(
								side).get(referencedObject);
						if (referenceChanges == null) {
							referenceChanges = new HashSet<DiffElement>();
							getAddReferenceElements(side).put(referencedObject,
									referenceChanges);
						}
						referenceChanges.add(referenceChange);
					}
				} else if (referenceChange instanceof ReferenceChangeLeftTarget) {
					ReferenceChangeLeftTarget addReferenceTarget = (ReferenceChangeLeftTarget) referenceChange;
					EObject referencedObject = getMatchingEObject(
							addReferenceTarget.getRightTarget(), side, true);
					if (referencedObject != null) {
						getAddReferencedEObjectsSet(side).add(referencedObject);
						Set<DiffElement> referenceChanges = getAddReferenceElements(
								side).get(referencedObject);
						if (referenceChanges == null) {
							referenceChanges = new HashSet<DiffElement>();
							getAddReferenceElements(side).put(referencedObject,
									referenceChanges);
						}
						referenceChanges.add(referenceChange);
					}
				}
			}
		}
	}

	private void fillInImplicitlyAddedReferences(Side side,
			EObject addedObject, DiffElement diffElement) {
		for (EObject referencedObjectInRevisedModel : addedObject
				.eCrossReferences()) {
			EObject referencedObject = getMatchingEObject(
					referencedObjectInRevisedModel, side, true);
			getAddReferencedEObjectsSet(side).add(referencedObject);
			Set<DiffElement> referenceChanges = getAddReferenceElements(side)
					.get(referencedObject);
			if (referenceChanges == null) {
				referenceChanges = new HashSet<DiffElement>();
				getAddReferenceElements(side).put(referencedObject,
						referenceChanges);
			}
			referenceChanges.add(diffElement);
		}
	}

	private EList<EObject> getAddReferencedEObjectsSet(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddReferencedEObjects;
		} else {
			return rightAddReferencedEObjects;
		}
	}

	private Map<EObject, Set<DiffElement>> getAddReferenceElements(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddReferenceElements;
		} else {
			return rightAddReferenceElements;
		}
	}

	private Map<EObject, MoveModelElement> getMoveElements(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftMoveElements;
		} else {
			return rightMoveElements;
		}
	}

	private List<EObject> getImplicitlyMovedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftImplicitlyMovedEObjects;
		} else {
			return rightImplicitlyMovedEObjects;
		}
	}

	private EList<EObject> getMovedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftMovedEObjects;
		} else {
			return rightMovedEObjects;
		}
	}

	private Map<EObject, ModelElementChange> getAddElements(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddElements;
		} else {
			return rightAddElements;
		}
	}

	private List<EObject> getImplicitlyAddedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftImplicitlyAddedEObjects;
		} else {
			return rightImplicitlyAddedEObjects;
		}
	}

	private EList<EObject> getAddedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddedEObjects;
		} else {
			return rightAddedEObjects;
		}
	}

	private void fillInFeatureUpdate(EObject eObject,
			EStructuralFeature feature, DiffElement diffElement, Side side) {
		// fill in explicit
		if (!getUpdatedEObjects(side).contains(eObject)) {
			getUpdatedEObjects(side).add(eObject);
		}
		addFeatureUpdate(eObject, feature, diffElement, side);
		// fill in implicit
		for (EObject parent : org.modelversioning.core.util.EcoreUtil
				.createParentList(eObject)) {
			if (!getImplicitlyUpdatedEObjects(side).contains(parent)) {
				getImplicitlyUpdatedEObjects(side).add(parent);
			}
			addImplicitUpdate(parent, diffElement, side);
		}
	}

	public void addImplicitUpdate(EObject eObject, DiffElement diffElement,
			Side side) {
		Map<EObject, EList<DiffElement>> implicitUpdateElements = getImplicitUpdateElements(side);
		EList<DiffElement> diffList = null;
		if (!implicitUpdateElements.containsKey(eObject)) {
			diffList = new BasicEList<DiffElement>();
			implicitUpdateElements.put(eObject, diffList);
		} else {
			diffList = implicitUpdateElements.get(eObject);
		}
		if (!diffList.contains(diffElement)) {
			diffList.add(diffElement);
		}
	}

	public Map<EObject, EList<DiffElement>> getImplicitUpdateElements(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftImplicitUpdateElements;
		} else {
			return rightImplicitUpdateElements;
		}
	}

	private void addFeatureUpdate(EObject eObject, EStructuralFeature feature,
			DiffElement diffElement, Side side) {
		FeatureUpdates featureUpdates = null;
		if (!getUpdatedFeatureMap(side).containsKey(eObject)) {
			featureUpdates = new FeatureUpdates();
			getUpdatedFeatureMap(side).put(eObject, featureUpdates);
		} else {
			featureUpdates = getUpdatedFeatureMap(side).get(eObject);
		}
		featureUpdates.add(feature, diffElement);
	}

	private EList<EObject> getUpdatedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftUpdatedEObjects;
		} else {
			return rightUpdatedEObjects;
		}
	}

	private EList<EObject> getImplicitlyUpdatedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftImplicitlyUpdatedEObjects;
		} else {
			return rightImplicitlyUpdatedEObjects;
		}
	}

	private Map<EObject, FeatureUpdates> getUpdatedFeatureMap(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftUpdatedFeatureMap;
		} else {
			return rightUpdatedFeatureMap;
		}
	}

	private EList<EObject> getImplicitlyDeletedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftImplicitlyDeletedEObjects;
		} else {
			return rightImplicitlyDeletedEObjects;
		}
	}

	private EList<EObject> getDeletedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftDeletedEObjects;
		} else {
			return rightDeletedEObjects;
		}
	}

	private Map<EObject, ModelElementChange> getDeleteElements(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftDeleteElements;
		} else {
			return rightDeleteElements;
		}
	}

	private EList<EObject> getAllChildren(EObject eObject) {
		EList<EObject> allChildren = new BasicEList<EObject>();
		TreeIterator<EObject> allContents = eObject.eAllContents();
		while (allContents.hasNext()) {
			allChildren.add(allContents.next());
		}
		return allChildren;
	}

	@Override
	public EList<EObject> getOriginModel() {
		return leftComparison.getMatch().getLeftRoots();
	}

	@Override
	public EList<EObject> getLeftModel() {
		return leftComparison.getMatch().getRightRoots();
	}

	@Override
	public EList<EObject> getRightModel() {
		return rightComparison.getMatch().getRightRoots();
	}

	@Override
	public ComparisonResourceSnapshot getComparisonSnapshot(Side side) {
		switch (side) {
		case LEFT:
			return leftComparison;
		case RIGHT:
			return rightComparison;
		}
		return null;
	}

	@Override
	public EList<DiffElement> getEffectiveDiffElements(Side side) {
		switch (side) {
		case LEFT:
			return leftEffectiveDiffs;
		case RIGHT:
			return rightEffectiveDiffs;
		}
		return null;
	}

	/**
	 * Joins the two specified {@link EList ELists}.
	 * 
	 * @param list1
	 *            to join.
	 * @param list2
	 *            to join.
	 * @return joined list.
	 */
	private EList<EObject> join(EList<EObject> list1, EList<EObject> list2) {
		EList<EObject> joinedList = new BasicEList<EObject>(list1);
		joinedList.addAll(list2);
		return joinedList;
	}

	@Override
	public EList<EObject> getUpdatedEObjects(Side side, boolean includeImplicit) {
		if (Side.LEFT.equals(side)) {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(leftUpdatedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(leftUpdatedEObjects,
						leftImplicitlyUpdatedEObjects));
			}
		} else {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(rightUpdatedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(
						rightUpdatedEObjects, rightImplicitlyUpdatedEObjects));
			}
		}
	}

	@Override
	public boolean isUpdated(EObject eObject, Side side, boolean includeImplicit) {
		return getUpdatedEObjects(side, includeImplicit).contains(eObject);
	}

	@Override
	public boolean isUpdated(EObject eObject, EStructuralFeature feature,
			Side side) {
		if (Side.LEFT.equals(side)) {
			if (leftUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = leftUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.contains(feature);
			}
		} else {
			if (rightUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = rightUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.contains(feature);
			}
		}
		return false;
	}

	@Override
	public Set<DiffElement> getUpdateElements(EObject eObject,
			EStructuralFeature feature, Side side) {
		if (Side.LEFT.equals(side)) {
			if (leftUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = leftUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.getDiffElements(feature);
			}
		} else {
			if (rightUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = rightUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.getDiffElements(feature);
			}
		}
		return Collections.emptySet();
	}

	@Override
	public Set<DiffElement> getUpdateElements(EObject eObject, Side side) {
		if (Side.LEFT.equals(side)) {
			if (leftUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = leftUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.getDiffElements();
			}
		} else {
			if (rightUpdatedFeatureMap.containsKey(eObject)) {
				FeatureUpdates featureUpdates = rightUpdatedFeatureMap
						.get(eObject);
				return featureUpdates.getDiffElements();
			}
		}
		return Collections.emptySet();
	}

	@Override
	public EList<DiffElement> getImplicitUpdateElements(EObject eObject,
			Side side) {
		if (Side.LEFT.equals(side)) {
			if (leftImplicitUpdateElements.containsKey(eObject)) {
				return leftImplicitUpdateElements.get(eObject);
			}
		} else {
			if (rightImplicitUpdateElements.containsKey(eObject)) {
				return rightImplicitUpdateElements.get(eObject);
			}
		}
		return ECollections.emptyEList();
	}

	@Override
	public EList<EObject> getAddReferencedEObjects(Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddReferencedEObjects;
		} else {
			return rightAddReferencedEObjects;
		}
	}

	@Override
	public Set<DiffElement> getAddReferenceElements(EObject eObject, Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddReferenceElements.get(eObject);
		} else {
			return rightAddReferenceElements.get(eObject);
		}
	}

	@Override
	public EList<EObject> getDeletedEObjects(Side side, boolean includeImplicit) {
		if (Side.LEFT.equals(side)) {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(leftDeletedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(leftDeletedEObjects,
						leftImplicitlyDeletedEObjects));
			}
		} else {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(rightDeletedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(
						rightDeletedEObjects, rightImplicitlyDeletedEObjects));
			}
		}
	}

	@Override
	public boolean isDeleted(EObject eObject, Side side, boolean includeImplicit) {
		return getDeletedEObjects(side, includeImplicit).contains(eObject);
	}

	@Override
	public ModelElementChange getDeleteElement(EObject eObject, Side side) {
		if (Side.LEFT.equals(side)) {
			return leftDeleteElements.get(eObject);
		} else {
			return rightDeleteElements.get(eObject);
		}
	}

	@Override
	public EList<EObject> getAddedEObjects(Side side, boolean includeImplicit) {
		if (Side.LEFT.equals(side)) {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(leftAddedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(leftAddedEObjects,
						leftImplicitlyAddedEObjects));
			}
		} else {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(rightAddedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(rightAddedEObjects,
						rightImplicitlyAddedEObjects));
			}
		}
	}

	@Override
	public ModelElementChange getAddElement(EObject eObject, Side side) {
		if (Side.LEFT.equals(side)) {
			return leftAddElements.get(eObject);
		} else {
			return rightAddElements.get(eObject);
		}
	}

	@Override
	public EList<EObject> getMovedEObjects(Side side, boolean includeImplicit) {
		if (Side.LEFT.equals(side)) {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(leftMovedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(leftMovedEObjects,
						leftImplicitlyMovedEObjects));
			}
		} else {
			if (!includeImplicit) {
				return ECollections.unmodifiableEList(rightMovedEObjects);
			} else {
				return ECollections.unmodifiableEList(join(rightMovedEObjects,
						rightImplicitlyMovedEObjects));
			}
		}
	}

	@Override
	public boolean isMoved(EObject eObject, Side side, boolean includeImplicit) {
		return getMovedEObjects(side, includeImplicit).contains(eObject);
	}

	@Override
	public MoveModelElement getMoveElement(EObject eObject, Side side) {
		if (Side.LEFT.equals(side)) {
			return leftMoveElements.get(eObject);
		} else {
			return rightMoveElements.get(eObject);
		}
	}

	@Override
	public EObject getMatchingEObject(EObject eObject, Side side,
			boolean retrieveOrigin) {
		if (eObject == null) {
			return null;
		}
		// check if already in origin
		boolean isInOrigin = false;
		if (eObject.eResource() != null
				&& getOriginModel().get(0).eResource() != null
				&& eObject.eResource().equals(
						getOriginModel().get(0).eResource())) {
			if (retrieveOrigin) {
				return eObject;
			}
			isInOrigin = true;
		}

		EObject directMatch = null;
		switch (side) {
		case LEFT:
			directMatch = leftMatchMap.get(eObject);
			break;
		case RIGHT:
			directMatch = rightMatchMap.get(eObject);
			break;
		}

		if (retrieveOrigin || isInOrigin) {
			return directMatch;
		} else if (directMatch != null) {
			switch (side) {
			case LEFT:
				return rightMatchMap.get(directMatch);
			case RIGHT:
				return leftMatchMap.get(directMatch);
			}
		}
		return null;
	}

	/*
	 * TODO regard Natural ID equality for additions of new objects
	 */
	@Override
	public boolean isEqual(DiffElement leftDiffElement,
			DiffElement rightDiffElement) {
		if (leftDiffElement.eClass().equals(rightDiffElement.eClass())) {
			if (leftDiffElement instanceof ModelElementChangeRightTarget) {
				ModelElementChangeRightTarget leftRemove = (ModelElementChangeRightTarget) leftDiffElement;
				ModelElementChangeRightTarget rightRemove = (ModelElementChangeRightTarget) rightDiffElement;
				if (leftRemove.getRightElement().equals(
						rightRemove.getRightElement())) {
					return true;
				}
			} else if (leftDiffElement instanceof MoveModelElement) {
				MoveModelElement leftMove = (MoveModelElement) leftDiffElement;
				MoveModelElement rightMove = (MoveModelElement) rightDiffElement;
				if (leftMove.getRightElement().equals(
						rightMove.getRightElement())
						&& getMatchingEObject(leftMove.getLeftTarget(),
								Side.LEFT, true).equals(
								getMatchingEObject(rightMove.getRightTarget(),
										Side.RIGHT, true))) {
					return true;
				}
			} else if (leftDiffElement instanceof AttributeChange) {
				if (leftDiffElement instanceof AttributeChangeRightTarget) {
					AttributeChangeRightTarget leftAttRemove = (AttributeChangeRightTarget) leftDiffElement;
					AttributeChangeRightTarget rightAttRemove = (AttributeChangeRightTarget) rightDiffElement;
					if (leftAttRemove.getRightElement().equals(
							rightAttRemove.getRightElement())
							&& leftAttRemove.getRightTarget().equals(
									rightAttRemove.getRightTarget())) {
						return true;
					}
				} else if (leftDiffElement instanceof UpdateAttribute) {
					UpdateAttribute leftUpdate = (UpdateAttribute) leftDiffElement;
					UpdateAttribute rightUpdate = (UpdateAttribute) rightDiffElement;
					if (leftUpdate.getAttribute().equals(
							rightUpdate.getAttribute())
							&& leftUpdate.getRightElement().equals(
									rightUpdate.getRightElement())
							&& leftUpdate
									.getLeftElement()
									.eGet(leftUpdate.getAttribute())
									.equals(rightUpdate.getLeftElement().eGet(
											rightUpdate.getAttribute()))) {
						return true;
					}
				}
			} else if (leftDiffElement instanceof ReferenceChange) {
				if (leftDiffElement instanceof ReferenceChangeRightTarget) {
					ReferenceChangeRightTarget leftAttRemove = (ReferenceChangeRightTarget) leftDiffElement;
					ReferenceChangeRightTarget rightAttRemove = (ReferenceChangeRightTarget) rightDiffElement;
					if (leftAttRemove.getRightElement().equals(
							rightAttRemove.getRightElement())
							&& leftAttRemove.getRightTarget().equals(
									rightAttRemove.getRightTarget())) {
						return true;
					}
				} else if (leftDiffElement instanceof ReferenceOrderChange) {
					ReferenceOrderChange leftOrderChange = (ReferenceOrderChange) leftDiffElement;
					ReferenceOrderChange rightOrderChange = (ReferenceOrderChange) rightDiffElement;
					if (leftOrderChange.getRightElement().equals(
							rightOrderChange.getRightElement())
							&& leftOrderChange.getRightTarget().equals(
									rightOrderChange.getRightTarget())) {
						// check for equivalent order in the revised models
						List<?> leftList = (List<?>) leftOrderChange
								.getLeftElement().eGet(
										leftOrderChange.getReference());
						List<?> rightList = (List<?>) rightOrderChange
								.getLeftElement().eGet(
										rightOrderChange.getReference());
						for (Object leftObject : leftList) {
							Object rightObject = leftObject;
							if (leftObject instanceof EObject) {
								// resolve from match
								rightObject = getMatchingEObject(
										(EObject) leftObject, Side.LEFT, false);
							}
							if (leftList.indexOf(leftObject) != rightList
									.indexOf(rightObject)) {
								return false;
							}
						}
						return true;
					}
				} else if (leftDiffElement instanceof UpdateReference) {
					UpdateReference leftUpdate = (UpdateReference) leftDiffElement;
					UpdateReference rightUpdate = (UpdateReference) rightDiffElement;
					if (leftUpdate.getReference().equals(
							rightUpdate.getReference())
							&& leftUpdate.getRightElement().equals(
									rightUpdate.getRightElement())) {
						Object leftValue = leftUpdate.getLeftElement().eGet(
								leftUpdate.getReference());
						Object rightValue = rightUpdate.getLeftElement().eGet(
								rightUpdate.getReference());
						if ((leftValue == null && rightValue == null)
								|| (leftValue != null && rightValue != null && leftValue
										.equals(rightValue))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
