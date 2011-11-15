/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.modelversioning.conflictreport.conflict.ConditionViolation;
import org.modelversioning.conflictreport.conflict.ConflictPackage;

import org.modelversioning.core.conditions.Condition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Violation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl#getViolatedCondition <em>Violated Condition</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl#getViolatingObject <em>Violating Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionViolationImpl extends EObjectImpl implements ConditionViolation {
	/**
	 * The cached value of the '{@link #getViolatedCondition() <em>Violated Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViolatedCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition violatedCondition;

	/**
	 * The cached value of the '{@link #getViolatingObject() <em>Violating Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViolatingObject()
	 * @generated
	 * @ordered
	 */
	protected EObject violatingObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionViolationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.CONDITION_VIOLATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getViolatedCondition() {
		if (violatedCondition != null && violatedCondition.eIsProxy()) {
			InternalEObject oldViolatedCondition = (InternalEObject)violatedCondition;
			violatedCondition = (Condition)eResolveProxy(oldViolatedCondition);
			if (violatedCondition != oldViolatedCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION, oldViolatedCondition, violatedCondition));
			}
		}
		return violatedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetViolatedCondition() {
		return violatedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViolatedCondition(Condition newViolatedCondition) {
		Condition oldViolatedCondition = violatedCondition;
		violatedCondition = newViolatedCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION, oldViolatedCondition, violatedCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getViolatingObject() {
		if (violatingObject != null && violatingObject.eIsProxy()) {
			InternalEObject oldViolatingObject = (InternalEObject)violatingObject;
			violatingObject = eResolveProxy(oldViolatingObject);
			if (violatingObject != oldViolatingObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT, oldViolatingObject, violatingObject));
			}
		}
		return violatingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetViolatingObject() {
		return violatingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViolatingObject(EObject newViolatingObject) {
		EObject oldViolatingObject = violatingObject;
		violatingObject = newViolatingObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT, oldViolatingObject, violatingObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION:
				if (resolve) return getViolatedCondition();
				return basicGetViolatedCondition();
			case ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT:
				if (resolve) return getViolatingObject();
				return basicGetViolatingObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION:
				setViolatedCondition((Condition)newValue);
				return;
			case ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT:
				setViolatingObject((EObject)newValue);
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
			case ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION:
				setViolatedCondition((Condition)null);
				return;
			case ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT:
				setViolatingObject((EObject)null);
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
			case ConflictPackage.CONDITION_VIOLATION__VIOLATED_CONDITION:
				return violatedCondition != null;
			case ConflictPackage.CONDITION_VIOLATION__VIOLATING_OBJECT:
				return violatingObject != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionViolationImpl
