/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.modelversioning.core.conditions.templatebindings.TemplateBindingCollection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Different Binding Size</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getOldBinding <em>Old Binding</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getNewBinding <em>New Binding</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getDifferenceKind <em>Difference Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDifferentBindingSize()
 * @model
 * @generated
 */
public interface DifferentBindingSize extends OperationContractDiagnostics {
	/**
	 * Returns the value of the '<em><b>Old Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Binding</em>' containment reference.
	 * @see #setOldBinding(TemplateBindingCollection)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDifferentBindingSize_OldBinding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TemplateBindingCollection getOldBinding();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getOldBinding <em>Old Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Binding</em>' containment reference.
	 * @see #getOldBinding()
	 * @generated
	 */
	void setOldBinding(TemplateBindingCollection value);

	/**
	 * Returns the value of the '<em><b>New Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Binding</em>' containment reference.
	 * @see #setNewBinding(TemplateBindingCollection)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDifferentBindingSize_NewBinding()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TemplateBindingCollection getNewBinding();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getNewBinding <em>New Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Binding</em>' containment reference.
	 * @see #getNewBinding()
	 * @generated
	 */
	void setNewBinding(TemplateBindingCollection value);

	/**
	 * Returns the value of the '<em><b>Difference Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.modelversioning.conflictreport.conflict.BindingSizeDifference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difference Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difference Kind</em>' attribute.
	 * @see org.modelversioning.conflictreport.conflict.BindingSizeDifference
	 * @see #setDifferenceKind(BindingSizeDifference)
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#getDifferentBindingSize_DifferenceKind()
	 * @model required="true"
	 * @generated
	 */
	BindingSizeDifference getDifferenceKind();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getDifferenceKind <em>Difference Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difference Kind</em>' attribute.
	 * @see org.modelversioning.conflictreport.conflict.BindingSizeDifference
	 * @see #getDifferenceKind()
	 * @generated
	 */
	void setDifferenceKind(BindingSizeDifference value);

} // DifferentBindingSize
