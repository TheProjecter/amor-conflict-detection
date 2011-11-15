/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Violated Precondition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.ViolatedPrecondition#getConditionViolations <em>Condition Violations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getViolatedPrecondition()
 * @model
 * @generated
 */
public interface ViolatedPrecondition extends OperationContractDiagnostics {
	/**
	 * Returns the value of the '<em><b>Condition Violations</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.conflict.ConditionViolation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Violations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Violations</em>' containment reference list.
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getViolatedPrecondition_ConditionViolations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConditionViolation> getConditionViolations();

} // ViolatedPrecondition
