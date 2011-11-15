/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.modelversioning.conflictreport.conflict.Conflict;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.ConflictDependency#getDependentConflict <em>Dependent Conflict</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictDependency()
 * @model
 * @generated
 */
public interface ConflictDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependent Conflict</b></em>' reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.conflict.Conflict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependent Conflict</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependent Conflict</em>' reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictDependency_DependentConflict()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Conflict> getDependentConflict();

} // ConflictDependency
