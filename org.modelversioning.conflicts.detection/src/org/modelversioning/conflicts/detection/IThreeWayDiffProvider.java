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

package org.modelversioning.conflicts.detection;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Access provider for a 3-way difference reports for EMF models based on EMF
 * Compare's {@link ComparisonResourceSnapshot ComparisonResourceSnapshots}
 * offering some convenient query mechanisms.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IThreeWayDiffProvider {

	/**
	 * Returns the root elements of the common origin model.
	 * 
	 * @return the root elements of the common origin model.
	 */
	public EList<EObject> getOriginModel();

	/**
	 * Returns the root elements of the left model.
	 * 
	 * @return the root elements of the left model.
	 */
	public EList<EObject> getLeftModel();

	/**
	 * Returns the root elements of the right model.
	 * 
	 * @return the root elements of the right model.
	 */
	public EList<EObject> getRightModel();

	/**
	 * Returns the {@link ComparisonSnapshot} representing the changes performed
	 * on the specified <code>side</code>.
	 * 
	 * @return the {@link ComparisonSnapshot} performed on the specified
	 *         <code>side</code>.
	 */
	public ComparisonResourceSnapshot getComparisonSnapshot(Side side);

	/**
	 * Returns the effective diff elements (i.e., those which effectively modify
	 * elements in contrast to {@link DiffGroup DiffGroups}) of the specified
	 * <code>side</code>.
	 * 
	 * @param side
	 *            The {@link Side} in question.
	 * @return the effective {@link DiffElement DiffElements}.
	 */
	public EList<DiffElement> getEffectiveDiffElements(Side side);

	/**
	 * Get all {@link EObject EObjects} which have been updated in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * The returned list of {@link EObject EObjects} contains elements from the
	 * origin model.
	 * </p>
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, also implicitly
	 * updated {@link EObject EObjects} will be included in the returned list.
	 * Implicit updates are:
	 * <ul>
	 * <li>A grand child has been added, moved, or deleted.</li>
	 * <li>A child (or grand children) has been updated.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param side
	 *            the side in question.
	 * @param includeImplicit
	 *            whether to include implicitly updated {@link EObject EObjects}
	 *            .
	 * @return all updated {@link EObject EObjects}.
	 */
	public EList<EObject> getUpdatedEObjects(Side side, boolean includeImplicit);

	/**
	 * Specifies whether <code>eObject</code> has been updated in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, this method
	 * returns <code>true</code> also if <code>eObject</code> has been
	 * implicitly updated. Implicit updates are:
	 * <ul>
	 * <li>A grand child has been added, moved, or deleted.</li>
	 * <li>A child (or grand children) has been updated.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly updated objects.
	 * @return <code>true</code> if it has been updated, <code>false</code>
	 *         otherwise.
	 */
	public boolean isUpdated(EObject eObject, Side side, boolean includeImplicit);

	/**
	 * Specifies whether the specified <code>feature</code> has been updated in
	 * <code>eObject</code> in the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param feature
	 *            {@link EStructuralFeature} in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return <code>true</code> if it has been updated, <code>false</code>
	 *         otherwise.
	 */
	public boolean isUpdated(EObject eObject, EStructuralFeature feature,
			Side side);

	/**
	 * Returns the {@link DiffElement DiffElements} that update the specified
	 * <code>feature</code> of <code>eObject</code> on the specified
	 * <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param feature
	 *            {@link EStructuralFeature} in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the update {@link DiffElement DiffElements}.
	 */
	public Set<DiffElement> getUpdateElements(EObject eObject,
			EStructuralFeature feature, Side side);

	/**
	 * Returns all {@link DiffElement DiffElements} that update the specified
	 * <code>eObject</code> on the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the update {@link DiffElement DiffElements}.
	 */
	public Set<DiffElement> getUpdateElements(EObject eObject, Side side);

	/**
	 * Get all {@link EObject EObjects} which have been added as a value to a
	 * reference in the specified <code>side</code>.
	 * 
	 * <p>
	 * The returned list of {@link EObject EObjects} contains elements from the
	 * origin model.
	 * </p>
	 * 
	 * @param side
	 *            the side in question.
	 * @return all newly referenced {@link EObject EObjects}.
	 */
	public EList<EObject> getAddReferencedEObjects(Side side);

	/**
	 * Returns all {@link ReferenceChange ReferenceChanges} that added the
	 * specified <code>eObject</code> as referenced value on the specified
	 * <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the {@link DiffElement diff element} (either a reference change
	 *         or the addition of a model element having cross references to
	 *         existing model elements).
	 */
	public Set<DiffElement> getAddReferenceElements(EObject eObject, Side side);

	/**
	 * Get all {@link EObject EObjects} which have been deleted in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * The returned list of {@link EObject EObjects} contains elements from the
	 * origin model.
	 * </p>
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, also implicitly
	 * (i.e., its parent has been deleted) deleted {@link EObject EObjects} will
	 * be included in the returned list.
	 * </p>
	 * 
	 * @param side
	 *            the {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly deleted {@link EObject EObjects}
	 *            .
	 * @return all deleted {@link EObject EObjects}.
	 */
	public EList<EObject> getDeletedEObjects(Side side, boolean includeImplicit);

	/**
	 * Specifies whether <code>eObject</code> has been deleted in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, this method
	 * returns <code>true</code> also if <code>eObject</code> has been
	 * implicitly deleted (i.e., its parent has been deleted).
	 * </p>
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly deleted objects.
	 * @return <code>true</code> if it has been deleted, <code>false</code>
	 *         otherwise.
	 */
	public boolean isDeleted(EObject eObject, Side side, boolean includeImplicit);

	/**
	 * Returns the {@link ModelElementChange} that deletes the specified
	 * <code>eObject</code> on the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the delete {@link ModelElementChange}.
	 */
	public ModelElementChange getDeleteElement(EObject eObject, Side side);

	/**
	 * Get all {@link EObject EObjects} which have been added in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * The returned list of {@link EObject EObjects} contains elements from the
	 * revised model of the specified <code>side</code>.
	 * </p>
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, also implicitly
	 * (i.e., its parent has been added) added {@link EObject EObjects} will be
	 * included in the returned list.
	 * </p>
	 * 
	 * @param side
	 *            the {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly added {@link EObject EObjects}.
	 * @return all added {@link EObject EObjects}.
	 */
	public EList<EObject> getAddedEObjects(Side side, boolean includeImplicit);

	/**
	 * Returns the {@link ModelElementChange} that adds the specified
	 * <code>eObject</code> on the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the revised model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the add {@link ModelElementChange}.
	 */
	public ModelElementChange getAddElement(EObject eObject, Side side);

	/**
	 * Get all {@link EObject EObjects} which have been moved in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * The returned list of {@link EObject EObjects} contains elements from the
	 * origin model.
	 * </p>
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, also implicitly
	 * (i.e., its parent has been moved) moved {@link EObject EObjects} will be
	 * included in the returned list.
	 * </p>
	 * 
	 * @param side
	 *            the {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly moved {@link EObject EObjects}.
	 * @return all moved {@link EObject EObjects}.
	 */
	public EList<EObject> getMovedEObjects(Side side, boolean includeImplicit);

	/**
	 * Specifies whether <code>eObject</code> has been moved in the specified
	 * <code>side</code>.
	 * 
	 * <p>
	 * If <code>includeIimplicit</code> is <code>true</code>, this method
	 * returns <code>true</code> also if <code>eObject</code> has been
	 * implicitly moved (i.e., its parent has been moved).
	 * </p>
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @param includeImplicit
	 *            whether to include implicitly moved objects.
	 * @return <code>true</code> if it has been moved, <code>false</code>
	 *         otherwise.
	 */
	public boolean isMoved(EObject eObject, Side side, boolean includeImplicit);

	/**
	 * Returns the {@link MoveModelElement} that moved the specified
	 * <code>eObject</code> on the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            {@link EObject} (contained by the origin model) in question.
	 * @param side
	 *            {@link Side} in question.
	 * @return the add {@link MoveModelElement}.
	 */
	public MoveModelElement getMoveElement(EObject eObject, Side side);

	/**
	 * Returns an {@link EObject} that corresponds to the specified
	 * <code>eObject</code> on the specified <code>side</code>. If
	 * <code>retrieveOrigin</code> is <code>true</code>, the corresponding
	 * {@link EObject} from the original model will be returned. Otherwise, the
	 * corresponding {@link EObject} from the opposite side will be returned.
	 * 
	 * <p>
	 * For instance, if <code>eObject</code> is contained in the original model
	 * <code>getMatchingEObject(eObject, Side.LEFT, false)</code> will return
	 * the matching object from the left side. If <code>eObject</code> is
	 * contained by the left model, the same call will return the matching
	 * object in the right model. Accordingly,
	 * <code>getMatchingEObject(eObject, Side.LEFT, true)</code> will return the
	 * {@link EObject} contained by the original model which corresponds to
	 * <code>eObject</code> from the left model
	 * <p>
	 * 
	 * @param eObject
	 *            to get matching object for.
	 * @param side
	 *            the {@link Side} in which <code>eObject</code> resides.
	 * @param retrieveOrigin
	 *            whether to retrieve the object in the original model or in the
	 *            opposite model.
	 * @return the matching object or <code>null</code>.
	 */
	public EObject getMatchingEObject(EObject eObject, Side side,
			boolean retrieveOrigin);

	/**
	 * Returns the implicit update diff elements that implicitly updated the
	 * specified <code>eObject</code> on the specified <code>side</code>.
	 * 
	 * @param eObject
	 *            in question.
	 * @param side
	 *            in question.
	 * @return a list of update diff elements.
	 */
	public EList<DiffElement> getImplicitUpdateElements(EObject eObject,
			Side side);

	/**
	 * Returns <code>true</code> if both specified {@link DiffElement
	 * DiffElements} have an equal result on the model.
	 * 
	 * @param leftDiffElement
	 *            to compare with <code>rightDiffElement</code>.
	 * @param rightDiffElement
	 *            to compare with <code>leftDiffElement</code>
	 * @return <code>true</code> if both have the same result,
	 *         <code>false</code> otherwise.
	 */
	public boolean isEqual(DiffElement leftDiffElement,
			DiffElement rightDiffElement);

}
