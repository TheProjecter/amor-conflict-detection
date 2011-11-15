/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelversioning.conflictreport.conflict.ConditionViolation;
import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.ViolatedPrecondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Violated Precondition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.ViolatedPreconditionImpl#getConditionViolations <em>Condition Violations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViolatedPreconditionImpl extends OperationContractDiagnosticsImpl implements ViolatedPrecondition {
	/**
	 * The cached value of the '{@link #getConditionViolations() <em>Condition Violations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionViolations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionViolation> conditionViolations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViolatedPreconditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.VIOLATED_PRECONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionViolation> getConditionViolations() {
		if (conditionViolations == null) {
			conditionViolations = new EObjectContainmentEList<ConditionViolation>(ConditionViolation.class, this, ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS);
		}
		return conditionViolations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS:
				return ((InternalEList<?>)getConditionViolations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS:
				return getConditionViolations();
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
			case ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS:
				getConditionViolations().clear();
				getConditionViolations().addAll((Collection<? extends ConditionViolation>)newValue);
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
			case ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS:
				getConditionViolations().clear();
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
			case ConflictPackage.VIOLATED_PRECONDITION__CONDITION_VIOLATIONS:
				return conditionViolations != null && !conditionViolations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViolatedPreconditionImpl
