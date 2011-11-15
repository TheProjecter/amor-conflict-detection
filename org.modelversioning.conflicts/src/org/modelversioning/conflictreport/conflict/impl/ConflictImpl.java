/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.ConflictImpl#getLeftChange <em>Left Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.ConflictImpl#getRightChange <em>Right Change</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConflictImpl extends EObjectImpl implements Conflict {
	/**
	 * The cached value of the '{@link #getLeftChange() <em>Left Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftChange()
	 * @generated
	 * @ordered
	 */
	protected DiffElement leftChange;

	/**
	 * The cached value of the '{@link #getRightChange() <em>Right Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightChange()
	 * @generated
	 * @ordered
	 */
	protected DiffElement rightChange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.CONFLICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getLeftChange() {
		if (leftChange != null && leftChange.eIsProxy()) {
			InternalEObject oldLeftChange = (InternalEObject)leftChange;
			leftChange = (DiffElement)eResolveProxy(oldLeftChange);
			if (leftChange != oldLeftChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.CONFLICT__LEFT_CHANGE, oldLeftChange, leftChange));
			}
		}
		return leftChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement basicGetLeftChange() {
		return leftChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftChange(DiffElement newLeftChange) {
		DiffElement oldLeftChange = leftChange;
		leftChange = newLeftChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.CONFLICT__LEFT_CHANGE, oldLeftChange, leftChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getRightChange() {
		if (rightChange != null && rightChange.eIsProxy()) {
			InternalEObject oldRightChange = (InternalEObject)rightChange;
			rightChange = (DiffElement)eResolveProxy(oldRightChange);
			if (rightChange != oldRightChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.CONFLICT__RIGHT_CHANGE, oldRightChange, rightChange));
			}
		}
		return rightChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement basicGetRightChange() {
		return rightChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightChange(DiffElement newRightChange) {
		DiffElement oldRightChange = rightChange;
		rightChange = newRightChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.CONFLICT__RIGHT_CHANGE, oldRightChange, rightChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.CONFLICT__LEFT_CHANGE:
				if (resolve) return getLeftChange();
				return basicGetLeftChange();
			case ConflictPackage.CONFLICT__RIGHT_CHANGE:
				if (resolve) return getRightChange();
				return basicGetRightChange();
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
			case ConflictPackage.CONFLICT__LEFT_CHANGE:
				setLeftChange((DiffElement)newValue);
				return;
			case ConflictPackage.CONFLICT__RIGHT_CHANGE:
				setRightChange((DiffElement)newValue);
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
			case ConflictPackage.CONFLICT__LEFT_CHANGE:
				setLeftChange((DiffElement)null);
				return;
			case ConflictPackage.CONFLICT__RIGHT_CHANGE:
				setRightChange((DiffElement)null);
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
			case ConflictPackage.CONFLICT__LEFT_CHANGE:
				return leftChange != null;
			case ConflictPackage.CONFLICT__RIGHT_CHANGE:
				return rightChange != null;
		}
		return super.eIsSet(featureID);
	}

} //ConflictImpl
