/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equivalent Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.EquivalentChange#getLeftChange <em>Left Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.EquivalentChange#getRightChange <em>Right Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.EquivalentChange#getPreferSide <em>Prefer Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelversioning.conflictreport.ConflictReportPackage#getEquivalentChange()
 * @model
 * @generated
 */
public interface EquivalentChange extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Change</em>' reference.
	 * @see #setLeftChange(DiffElement)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getEquivalentChange_LeftChange()
	 * @model
	 * @generated
	 */
	DiffElement getLeftChange();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.EquivalentChange#getLeftChange <em>Left Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Change</em>' reference.
	 * @see #getLeftChange()
	 * @generated
	 */
	void setLeftChange(DiffElement value);

	/**
	 * Returns the value of the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Change</em>' reference.
	 * @see #setRightChange(DiffElement)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getEquivalentChange_RightChange()
	 * @model
	 * @generated
	 */
	DiffElement getRightChange();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.EquivalentChange#getRightChange <em>Right Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Change</em>' reference.
	 * @see #getRightChange()
	 * @generated
	 */
	void setRightChange(DiffElement value);

	/**
	 * Returns the value of the '<em><b>Prefer Side</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.compare.match.metamodel.Side}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefer Side</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefer Side</em>' attribute.
	 * @see org.eclipse.emf.compare.match.metamodel.Side
	 * @see #setPreferSide(Side)
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#getEquivalentChange_PreferSide()
	 * @model required="true"
	 * @generated
	 */
	Side getPreferSide();

	/**
	 * Sets the value of the '{@link org.modelversioning.conflictreport.EquivalentChange#getPreferSide <em>Prefer Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefer Side</em>' attribute.
	 * @see org.eclipse.emf.compare.match.metamodel.Side
	 * @see #getPreferSide()
	 * @generated
	 */
	void setPreferSide(Side value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DiffElement getPreferredChange();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DiffElement getSubChange();

} // EquivalentChange
