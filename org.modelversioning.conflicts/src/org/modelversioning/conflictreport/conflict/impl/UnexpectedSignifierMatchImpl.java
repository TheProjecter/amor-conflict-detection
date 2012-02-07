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

import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unexpected Signifier Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.UnexpectedSignifierMatchImpl#getLeftObject <em>Left Object</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.UnexpectedSignifierMatchImpl#getRightObject <em>Right Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnexpectedSignifierMatchImpl extends SignifierWarningsImpl implements UnexpectedSignifierMatch {
	/**
	 * The cached value of the '{@link #getLeftObject() <em>Left Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftObject()
	 * @generated
	 * @ordered
	 */
	protected EObject leftObject;

	/**
	 * The cached value of the '{@link #getRightObject() <em>Right Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightObject()
	 * @generated
	 * @ordered
	 */
	protected EObject rightObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnexpectedSignifierMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.UNEXPECTED_SIGNIFIER_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftObject() {
		if (leftObject != null && leftObject.eIsProxy()) {
			InternalEObject oldLeftObject = (InternalEObject)leftObject;
			leftObject = eResolveProxy(oldLeftObject);
			if (leftObject != oldLeftObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT, oldLeftObject, leftObject));
			}
		}
		return leftObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetLeftObject() {
		return leftObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftObject(EObject newLeftObject) {
		EObject oldLeftObject = leftObject;
		leftObject = newLeftObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT, oldLeftObject, leftObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRightObject() {
		if (rightObject != null && rightObject.eIsProxy()) {
			InternalEObject oldRightObject = (InternalEObject)rightObject;
			rightObject = eResolveProxy(oldRightObject);
			if (rightObject != oldRightObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT, oldRightObject, rightObject));
			}
		}
		return rightObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRightObject() {
		return rightObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightObject(EObject newRightObject) {
		EObject oldRightObject = rightObject;
		rightObject = newRightObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT, oldRightObject, rightObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT:
				if (resolve) return getLeftObject();
				return basicGetLeftObject();
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT:
				if (resolve) return getRightObject();
				return basicGetRightObject();
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
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT:
				setLeftObject((EObject)newValue);
				return;
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT:
				setRightObject((EObject)newValue);
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
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT:
				setLeftObject((EObject)null);
				return;
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT:
				setRightObject((EObject)null);
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
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT:
				return leftObject != null;
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT:
				return rightObject != null;
		}
		return super.eIsSet(featureID);
	}

} //UnexpectedSignifierMatchImpl
