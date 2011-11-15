/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.ecore.EObject;

import org.modelversioning.core.conditions.Template;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Missing Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.MissingObject#getMissingObject <em>Missing Object</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.MissingObject#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMissingObject()
 * @model
 * @generated
 */
public interface MissingObject extends OperationContractDiagnostics {
	/**
	 * Returns the value of the '<em><b>Missing Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Missing Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Missing Object</em>' reference.
	 * @see #setMissingObject(EObject)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMissingObject_MissingObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getMissingObject();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.MissingObject#getMissingObject <em>Missing Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Missing Object</em>' reference.
	 * @see #getMissingObject()
	 * @generated
	 */
	void setMissingObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(Template)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMissingObject_Template()
	 * @model required="true"
	 * @generated
	 */
	Template getTemplate();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.MissingObject#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(Template value);

} // MissingObject
