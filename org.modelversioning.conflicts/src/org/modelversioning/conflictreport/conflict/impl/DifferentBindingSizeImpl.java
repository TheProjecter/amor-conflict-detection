/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.modelversioning.conflictreport.conflict.BindingSizeDifference;
import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.DifferentBindingSize;

import org.modelversioning.core.conditions.templatebindings.TemplateBindingCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Different Binding Size</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl#getOldBinding <em>Old Binding</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl#getNewBinding <em>New Binding</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl#getDifferenceKind <em>Difference Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DifferentBindingSizeImpl extends OperationContractDiagnosticsImpl implements DifferentBindingSize {
	/**
	 * The cached value of the '{@link #getOldBinding() <em>Old Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCollection oldBinding;

	/**
	 * The cached value of the '{@link #getNewBinding() <em>New Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCollection newBinding;

	/**
	 * The default value of the '{@link #getDifferenceKind() <em>Difference Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifferenceKind()
	 * @generated
	 * @ordered
	 */
	protected static final BindingSizeDifference DIFFERENCE_KIND_EDEFAULT = BindingSizeDifference.DECREASED;

	/**
	 * The cached value of the '{@link #getDifferenceKind() <em>Difference Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifferenceKind()
	 * @generated
	 * @ordered
	 */
	protected BindingSizeDifference differenceKind = DIFFERENCE_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DifferentBindingSizeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.DIFFERENT_BINDING_SIZE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCollection getOldBinding() {
		return oldBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOldBinding(TemplateBindingCollection newOldBinding, NotificationChain msgs) {
		TemplateBindingCollection oldOldBinding = oldBinding;
		oldBinding = newOldBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING, oldOldBinding, newOldBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldBinding(TemplateBindingCollection newOldBinding) {
		if (newOldBinding != oldBinding) {
			NotificationChain msgs = null;
			if (oldBinding != null)
				msgs = ((InternalEObject)oldBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING, null, msgs);
			if (newOldBinding != null)
				msgs = ((InternalEObject)newOldBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING, null, msgs);
			msgs = basicSetOldBinding(newOldBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING, newOldBinding, newOldBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCollection getNewBinding() {
		return newBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewBinding(TemplateBindingCollection newNewBinding, NotificationChain msgs) {
		TemplateBindingCollection oldNewBinding = newBinding;
		newBinding = newNewBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING, oldNewBinding, newNewBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewBinding(TemplateBindingCollection newNewBinding) {
		if (newNewBinding != newBinding) {
			NotificationChain msgs = null;
			if (newBinding != null)
				msgs = ((InternalEObject)newBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING, null, msgs);
			if (newNewBinding != null)
				msgs = ((InternalEObject)newNewBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING, null, msgs);
			msgs = basicSetNewBinding(newNewBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING, newNewBinding, newNewBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingSizeDifference getDifferenceKind() {
		return differenceKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifferenceKind(BindingSizeDifference newDifferenceKind) {
		BindingSizeDifference oldDifferenceKind = differenceKind;
		differenceKind = newDifferenceKind == null ? DIFFERENCE_KIND_EDEFAULT : newDifferenceKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND, oldDifferenceKind, differenceKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING:
				return basicSetOldBinding(null, msgs);
			case ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING:
				return basicSetNewBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING:
				return getOldBinding();
			case ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING:
				return getNewBinding();
			case ConflictPackage.DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND:
				return getDifferenceKind();
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
			case ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING:
				setOldBinding((TemplateBindingCollection)newValue);
				return;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING:
				setNewBinding((TemplateBindingCollection)newValue);
				return;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND:
				setDifferenceKind((BindingSizeDifference)newValue);
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
			case ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING:
				setOldBinding((TemplateBindingCollection)null);
				return;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING:
				setNewBinding((TemplateBindingCollection)null);
				return;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND:
				setDifferenceKind(DIFFERENCE_KIND_EDEFAULT);
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
			case ConflictPackage.DIFFERENT_BINDING_SIZE__OLD_BINDING:
				return oldBinding != null;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__NEW_BINDING:
				return newBinding != null;
			case ConflictPackage.DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND:
				return differenceKind != DIFFERENCE_KIND_EDEFAULT;
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
		result.append(" (differenceKind: ");
		result.append(differenceKind);
		result.append(')');
		return result.toString();
	}

} //DifferentBindingSizeImpl
