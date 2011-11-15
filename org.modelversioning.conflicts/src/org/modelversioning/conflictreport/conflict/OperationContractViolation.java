/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Contract Violation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.OperationContractViolation#getDiagnostics <em>Diagnostics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getOperationContractViolation()
 * @model
 * @generated
 */
public interface OperationContractViolation extends Violation {
	/**
	 * Returns the value of the '<em><b>Diagnostics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostics</em>' containment reference.
	 * @see #setDiagnostics(OperationContractDiagnostics)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getOperationContractViolation_Diagnostics()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OperationContractDiagnostics getDiagnostics();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.OperationContractViolation#getDiagnostics <em>Diagnostics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostics</em>' containment reference.
	 * @see #getDiagnostics()
	 * @generated
	 */
	void setDiagnostics(OperationContractDiagnostics value);

} // OperationContractViolation
