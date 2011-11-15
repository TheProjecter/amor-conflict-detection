/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.ecore.EObject;

import org.modelversioning.core.conditions.Condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Violation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatedCondition <em>Violated Condition</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatingObject <em>Violating Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConditionViolation()
 * @model
 * @generated
 */
public interface ConditionViolation extends EObject {
	/**
	 * Returns the value of the '<em><b>Violated Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Violated Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violated Condition</em>' reference.
	 * @see #setViolatedCondition(Condition)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConditionViolation_ViolatedCondition()
	 * @model required="true"
	 * @generated
	 */
	Condition getViolatedCondition();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatedCondition <em>Violated Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Violated Condition</em>' reference.
	 * @see #getViolatedCondition()
	 * @generated
	 */
	void setViolatedCondition(Condition value);

	/**
	 * Returns the value of the '<em><b>Violating Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Violating Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violating Object</em>' reference.
	 * @see #setViolatingObject(EObject)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConditionViolation_ViolatingObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getViolatingObject();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatingObject <em>Violating Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Violating Object</em>' reference.
	 * @see #getViolatingObject()
	 * @generated
	 */
	void setViolatingObject(EObject value);

} // ConditionViolation
