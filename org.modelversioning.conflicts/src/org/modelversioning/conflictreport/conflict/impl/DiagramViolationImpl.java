/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.Constraint;
import org.modelversioning.conflictreport.conflict.DiagramViolation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Violation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.DiagramViolationImpl#getViolatedConstraint <em>Violated Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramViolationImpl extends ViolationImpl implements DiagramViolation {
	/**
	 * The cached value of the '{@link #getViolatedConstraint() <em>Violated Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViolatedConstraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint violatedConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramViolationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.DIAGRAM_VIOLATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getViolatedConstraint() {
		if (violatedConstraint != null && violatedConstraint.eIsProxy()) {
			InternalEObject oldViolatedConstraint = (InternalEObject)violatedConstraint;
			violatedConstraint = (Constraint)eResolveProxy(oldViolatedConstraint);
			if (violatedConstraint != oldViolatedConstraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT, oldViolatedConstraint, violatedConstraint));
			}
		}
		return violatedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetViolatedConstraint() {
		return violatedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViolatedConstraint(Constraint newViolatedConstraint) {
		Constraint oldViolatedConstraint = violatedConstraint;
		violatedConstraint = newViolatedConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT, oldViolatedConstraint, violatedConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT:
				if (resolve) return getViolatedConstraint();
				return basicGetViolatedConstraint();
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
			case ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT:
				setViolatedConstraint((Constraint)newValue);
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
			case ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT:
				setViolatedConstraint((Constraint)null);
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
			case ConflictPackage.DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT:
				return violatedConstraint != null;
		}
		return super.eIsSet(featureID);
	}

} //DiagramViolationImpl
