/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.OperationContractDiagnostics;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Contract Violation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.OperationContractViolationImpl#getDiagnostics <em>Diagnostics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContractViolationImpl extends ViolationImpl implements OperationContractViolation {
	/**
	 * The cached value of the '{@link #getDiagnostics() <em>Diagnostics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostics()
	 * @generated
	 * @ordered
	 */
	protected OperationContractDiagnostics diagnostics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationContractViolationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.OPERATION_CONTRACT_VIOLATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContractDiagnostics getDiagnostics() {
		return diagnostics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagnostics(OperationContractDiagnostics newDiagnostics, NotificationChain msgs) {
		OperationContractDiagnostics oldDiagnostics = diagnostics;
		diagnostics = newDiagnostics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS, oldDiagnostics, newDiagnostics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnostics(OperationContractDiagnostics newDiagnostics) {
		if (newDiagnostics != diagnostics) {
			NotificationChain msgs = null;
			if (diagnostics != null)
				msgs = ((InternalEObject)diagnostics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS, null, msgs);
			if (newDiagnostics != null)
				msgs = ((InternalEObject)newDiagnostics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS, null, msgs);
			msgs = basicSetDiagnostics(newDiagnostics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS, newDiagnostics, newDiagnostics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS:
				return basicSetDiagnostics(null, msgs);
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
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS:
				return getDiagnostics();
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
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS:
				setDiagnostics((OperationContractDiagnostics)newValue);
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
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS:
				setDiagnostics((OperationContractDiagnostics)null);
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
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS:
				return diagnostics != null;
		}
		return super.eIsSet(featureID);
	}

} //OperationContractViolationImpl
