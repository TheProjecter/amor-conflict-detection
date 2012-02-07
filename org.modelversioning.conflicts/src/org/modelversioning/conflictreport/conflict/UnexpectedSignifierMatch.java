/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unexpected Signifier Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch#getLeftObject <em>Left Object</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch#getRightObject <em>Right Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getUnexpectedSignifierMatch()
 * @model
 * @generated
 */
public interface UnexpectedSignifierMatch extends SignifierWarnings {
	/**
	 * Returns the value of the '<em><b>Left Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Object</em>' reference.
	 * @see #setLeftObject(EObject)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getUnexpectedSignifierMatch_LeftObject()
	 * @model
	 * @generated
	 */
	EObject getLeftObject();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch#getLeftObject <em>Left Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Object</em>' reference.
	 * @see #getLeftObject()
	 * @generated
	 */
	void setLeftObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Right Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Object</em>' reference.
	 * @see #setRightObject(EObject)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getUnexpectedSignifierMatch_RightObject()
	 * @model
	 * @generated
	 */
	EObject getRightObject();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch#getRightObject <em>Right Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Object</em>' reference.
	 * @see #getRightObject()
	 * @generated
	 */
	void setRightObject(EObject value);

} // UnexpectedSignifierMatch
