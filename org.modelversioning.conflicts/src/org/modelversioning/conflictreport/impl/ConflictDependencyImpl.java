/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.modelversioning.conflictreport.ConflictDependency;
import org.modelversioning.conflictreport.ConflictReportPackage;

import org.modelversioning.conflictreport.conflict.Conflict;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.impl.ConflictDependencyImpl#getDependentConflict <em>Dependent Conflict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConflictDependencyImpl extends EObjectImpl implements ConflictDependency {
	/**
	 * The cached value of the '{@link #getDependentConflict() <em>Dependent Conflict</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentConflict()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> dependentConflict;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictReportPackage.Literals.CONFLICT_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conflict> getDependentConflict() {
		if (dependentConflict == null) {
			dependentConflict = new EObjectResolvingEList<Conflict>(Conflict.class, this, ConflictReportPackage.CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT);
		}
		return dependentConflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT:
				return getDependentConflict();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT:
				getDependentConflict().clear();
				getDependentConflict().addAll((Collection<? extends Conflict>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT:
				getDependentConflict().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT:
				return dependentConflict != null && !dependentConflict.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConflictDependencyImpl
