/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.Conflict#getLeftChange <em>Left Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.Conflict#getRightChange <em>Right Change</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConflict()
 * @model abstract="true"
 * @generated
 */
public interface Conflict extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Change</em>' reference.
	 * @see #setLeftChange(DiffElement)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConflict_LeftChange()
	 * @model
	 * @generated
	 */
	DiffElement getLeftChange();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.Conflict#getLeftChange <em>Left Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Change</em>' reference.
	 * @see #getLeftChange()
	 * @generated
	 */
	void setLeftChange(DiffElement value);

	/**
	 * Returns the value of the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Change</em>' reference.
	 * @see #setRightChange(DiffElement)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getConflict_RightChange()
	 * @model
	 * @generated
	 */
	DiffElement getRightChange();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.Conflict#getRightChange <em>Right Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Change</em>' reference.
	 * @see #getRightChange()
	 * @generated
	 */
	void setRightChange(DiffElement value);

} // Conflict
