/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.modelversioning.conflictreport.ConflictReportPackage;
import org.modelversioning.conflictreport.EquivalentChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equivalent Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.impl.EquivalentChangeImpl#getLeftChange <em>Left Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.EquivalentChangeImpl#getRightChange <em>Right Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.EquivalentChangeImpl#getPreferSide <em>Prefer Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquivalentChangeImpl extends EObjectImpl implements EquivalentChange {
	/**
	 * The cached value of the '{@link #getLeftChange() <em>Left Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftChange()
	 * @generated
	 * @ordered
	 */
	protected DiffElement leftChange;

	/**
	 * The cached value of the '{@link #getRightChange() <em>Right Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightChange()
	 * @generated
	 * @ordered
	 */
	protected DiffElement rightChange;

	/**
	 * The default value of the '{@link #getPreferSide() <em>Prefer Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferSide()
	 * @generated
	 * @ordered
	 */
	protected static final Side PREFER_SIDE_EDEFAULT = Side.LEFT;

	/**
	 * The cached value of the '{@link #getPreferSide() <em>Prefer Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferSide()
	 * @generated
	 * @ordered
	 */
	protected Side preferSide = PREFER_SIDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquivalentChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictReportPackage.Literals.EQUIVALENT_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getLeftChange() {
		if (leftChange != null && leftChange.eIsProxy()) {
			InternalEObject oldLeftChange = (InternalEObject)leftChange;
			leftChange = (DiffElement)eResolveProxy(oldLeftChange);
			if (leftChange != oldLeftChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE, oldLeftChange, leftChange));
			}
		}
		return leftChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement basicGetLeftChange() {
		return leftChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftChange(DiffElement newLeftChange) {
		DiffElement oldLeftChange = leftChange;
		leftChange = newLeftChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE, oldLeftChange, leftChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getRightChange() {
		if (rightChange != null && rightChange.eIsProxy()) {
			InternalEObject oldRightChange = (InternalEObject)rightChange;
			rightChange = (DiffElement)eResolveProxy(oldRightChange);
			if (rightChange != oldRightChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE, oldRightChange, rightChange));
			}
		}
		return rightChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement basicGetRightChange() {
		return rightChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightChange(DiffElement newRightChange) {
		DiffElement oldRightChange = rightChange;
		rightChange = newRightChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE, oldRightChange, rightChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Side getPreferSide() {
		return preferSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferSide(Side newPreferSide) {
		Side oldPreferSide = preferSide;
		preferSide = newPreferSide == null ? PREFER_SIDE_EDEFAULT : newPreferSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.EQUIVALENT_CHANGE__PREFER_SIDE, oldPreferSide, preferSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiffElement getPreferredChange() {
		if (Side.LEFT.equals(getPreferSide())) {
			return getLeftChange();
		} else {
			return getRightChange();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DiffElement getSubChange() {
		if (Side.LEFT.equals(getPreferSide())) {
			return getRightChange();
		} else {
			return getLeftChange();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE:
				if (resolve) return getLeftChange();
				return basicGetLeftChange();
			case ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE:
				if (resolve) return getRightChange();
				return basicGetRightChange();
			case ConflictReportPackage.EQUIVALENT_CHANGE__PREFER_SIDE:
				return getPreferSide();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE:
				setLeftChange((DiffElement)newValue);
				return;
			case ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE:
				setRightChange((DiffElement)newValue);
				return;
			case ConflictReportPackage.EQUIVALENT_CHANGE__PREFER_SIDE:
				setPreferSide((Side)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE:
				setLeftChange((DiffElement)null);
				return;
			case ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE:
				setRightChange((DiffElement)null);
				return;
			case ConflictReportPackage.EQUIVALENT_CHANGE__PREFER_SIDE:
				setPreferSide(PREFER_SIDE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConflictReportPackage.EQUIVALENT_CHANGE__LEFT_CHANGE:
				return leftChange != null;
			case ConflictReportPackage.EQUIVALENT_CHANGE__RIGHT_CHANGE:
				return rightChange != null;
			case ConflictReportPackage.EQUIVALENT_CHANGE__PREFER_SIDE:
				return preferSide != PREFER_SIDE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (preferSide: ");
		result.append(preferSide);
		result.append(')');
		return result.toString();
	}

} //EquivalentChangeImpl
