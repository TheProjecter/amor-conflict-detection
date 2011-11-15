/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.modelversioning.core.conditions.templatebindings.TemplateBindingCollection;
import org.modelversioning.operations.NegativeApplicationCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matching Negative Application Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNegativeApplicationCondition <em>Negative Application Condition</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNacBinding <em>Nac Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMatchingNegativeApplicationCondition()
 * @model
 * @generated
 */
public interface MatchingNegativeApplicationCondition extends OperationContractDiagnostics {
	/**
	 * Returns the value of the '<em><b>Negative Application Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negative Application Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negative Application Condition</em>' reference.
	 * @see #setNegativeApplicationCondition(NegativeApplicationCondition)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMatchingNegativeApplicationCondition_NegativeApplicationCondition()
	 * @model required="true"
	 * @generated
	 */
	NegativeApplicationCondition getNegativeApplicationCondition();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNegativeApplicationCondition <em>Negative Application Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negative Application Condition</em>' reference.
	 * @see #getNegativeApplicationCondition()
	 * @generated
	 */
	void setNegativeApplicationCondition(NegativeApplicationCondition value);

	/**
	 * Returns the value of the '<em><b>Nac Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nac Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nac Binding</em>' containment reference.
	 * @see #setNacBinding(TemplateBindingCollection)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getMatchingNegativeApplicationCondition_NacBinding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TemplateBindingCollection getNacBinding();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNacBinding <em>Nac Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nac Binding</em>' containment reference.
	 * @see #getNacBinding()
	 * @generated
	 */
	void setNacBinding(TemplateBindingCollection value);

} // MatchingNegativeApplicationCondition
