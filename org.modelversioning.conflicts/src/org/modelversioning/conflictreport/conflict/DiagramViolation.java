/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Violation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.DiagramViolation#getViolatedConstraint <em>Violated Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDiagramViolation()
 * @model
 * @generated
 */
public interface DiagramViolation extends Violation {
	/**
	 * Returns the value of the '<em><b>Violated Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Violated Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violated Constraint</em>' reference.
	 * @see #setViolatedConstraint(Constraint)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDiagramViolation_ViolatedConstraint()
	 * @model required="true"
	 * @generated
	 */
	Constraint getViolatedConstraint();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.DiagramViolation#getViolatedConstraint <em>Violated Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Violated Constraint</em>' reference.
	 * @see #getViolatedConstraint()
	 * @generated
	 */
	void setViolatedConstraint(Constraint value);

} // DiagramViolation
