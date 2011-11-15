/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependent Diagram Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.DependentDiagramChange#getModelChange <em>Model Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.DependentDiagramChange#getDiagramChanges <em>Diagram Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.ConflictReportPackage#getDependentDiagramChange()
 * @model
 * @generated
 */
public interface DependentDiagramChange extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Change</em>' reference.
	 * @see #setModelChange(DiffElement)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getDependentDiagramChange_ModelChange()
	 * @model required="true"
	 * @generated
	 */
	DiffElement getModelChange();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.DependentDiagramChange#getModelChange <em>Model Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Change</em>' reference.
	 * @see #getModelChange()
	 * @generated
	 */
	void setModelChange(DiffElement value);

	/**
	 * Returns the value of the '<em><b>Diagram Changes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.diff.metamodel.DiffElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Changes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Changes</em>' reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getDependentDiagramChange_DiagramChanges()
	 * @model
	 * @generated
	 */
	EList<DiffElement> getDiagramChanges();

} // DependentDiagramChange
