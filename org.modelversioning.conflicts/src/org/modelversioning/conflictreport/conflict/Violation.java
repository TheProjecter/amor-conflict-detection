/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Violation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.Violation#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getViolation()
 * @model abstract="true"
 * @generated
 */
public interface Violation extends Conflict {
	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"ERROR"</code>.
	 * The literals are from the enumeration {@link org.modelversioning.conflictreport.conflict.ViolationSeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.modelversioning.conflictreport.conflict.ViolationSeverity
	 * @see #setSeverity(ViolationSeverity)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getViolation_Severity()
	 * @model default="ERROR" required="true"
	 * @generated
	 */
	ViolationSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.Violation#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.modelversioning.conflictreport.conflict.ViolationSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ViolationSeverity value);

} // Violation
