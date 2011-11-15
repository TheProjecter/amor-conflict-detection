/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;

import org.modelversioning.conflictreport.conflict.Conflict;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getEquivalentChanges <em>Equivalent Changes</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getLeftVersion <em>Left Version</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getRightVersion <em>Right Version</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getLeftDiagrams <em>Left Diagrams</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getRightDiagrams <em>Right Diagrams</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getLeftUser <em>Left User</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getRightUser <em>Right User</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.ConflictReport#getDiagramDependencies <em>Diagram Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport()
 * @model
 * @generated
 */
public interface ConflictReport extends EObject {
	/**
	 * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.conflict.Conflict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicts</em>' containment reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_Conflicts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Conflict> getConflicts();

	/**
	 * Returns the value of the '<em><b>Equivalent Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.EquivalentChange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equivalent Changes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equivalent Changes</em>' containment reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_EquivalentChanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<EquivalentChange> getEquivalentChanges();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.ConflictDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_Dependencies()
	 * @model
	 * @generated
	 */
	EList<ConflictDependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Left Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Version</em>' containment reference.
	 * @see #setLeftVersion(ComparisonResourceSnapshot)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_LeftVersion()
	 * @model containment="true"
	 * @generated
	 */
	ComparisonResourceSnapshot getLeftVersion();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.ConflictReport#getLeftVersion <em>Left Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Version</em>' containment reference.
	 * @see #getLeftVersion()
	 * @generated
	 */
	void setLeftVersion(ComparisonResourceSnapshot value);

	/**
	 * Returns the value of the '<em><b>Right Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Version</em>' containment reference.
	 * @see #setRightVersion(ComparisonResourceSnapshot)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_RightVersion()
	 * @model containment="true"
	 * @generated
	 */
	ComparisonResourceSnapshot getRightVersion();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.ConflictReport#getRightVersion <em>Right Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Version</em>' containment reference.
	 * @see #getRightVersion()
	 * @generated
	 */
	void setRightVersion(ComparisonResourceSnapshot value);

	/**
	 * Returns the value of the '<em><b>Left Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Diagrams</em>' containment reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_LeftDiagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComparisonResourceSnapshot> getLeftDiagrams();

	/**
	 * Returns the value of the '<em><b>Right Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Diagrams</em>' containment reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_RightDiagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComparisonResourceSnapshot> getRightDiagrams();

	/**
	 * Returns the value of the '<em><b>Left User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left User</em>' attribute.
	 * @see #setLeftUser(String)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_LeftUser()
	 * @model
	 * @generated
	 */
	String getLeftUser();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.ConflictReport#getLeftUser <em>Left User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left User</em>' attribute.
	 * @see #getLeftUser()
	 * @generated
	 */
	void setLeftUser(String value);

	/**
	 * Returns the value of the '<em><b>Right User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right User</em>' attribute.
	 * @see #setRightUser(String)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_RightUser()
	 * @model
	 * @generated
	 */
	String getRightUser();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.ConflictReport#getRightUser <em>Right User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right User</em>' attribute.
	 * @see #getRightUser()
	 * @generated
	 */
	void setRightUser(String value);

	/**
	 * Returns the value of the '<em><b>Diagram Dependencies</b></em>' reference list.
	 * The list contents are of type {@link org.modelversioning.conflictreport.DependentDiagramChange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Dependencies</em>' reference list.
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getConflictReport_DiagramDependencies()
	 * @model ordered="false"
	 * @generated
	 */
	EList<DependentDiagramChange> getDiagramDependencies();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasConflictingChange(DiffElement diffElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<DiffElement> getConflictingChanges(DiffElement diffElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Conflict> getConflicts(DiffElement diffElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasEquivalentChange(DiffElement diffElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<DiffElement> getEquivalentChanges(DiffElement diffElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DiffElement> getEquivalentSubChanges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DiffElement> getEquivalentPreferredChanges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model diagramChangeRequired="true"
	 * @generated
	 */
	boolean isDependentDiagramChange(DiffElement diagramChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model modelChangeRequired="true"
	 * @generated
	 */
	EList<DiffElement> getDependentDiagramChanges(DiffElement modelChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	DiffElement getDependentModelChange(DiffElement diagramChange);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model modelChangeRequired="true"
	 * @generated
	 */
	boolean hasDependentDiagramChange(DiffElement modelChange);

} // ConflictReport
