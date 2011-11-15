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

import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition;

import org.modelversioning.core.conditions.templatebindings.TemplateBindingCollection;
import org.modelversioning.operations.NegativeApplicationCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matching Negative Application Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl#getNegativeApplicationCondition <em>Negative Application Condition</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl#getNacBinding <em>Nac Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatchingNegativeApplicationConditionImpl extends OperationContractDiagnosticsImpl implements MatchingNegativeApplicationCondition {
	/**
	 * The cached value of the '{@link #getNegativeApplicationCondition() <em>Negative Application Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNegativeApplicationCondition()
	 * @generated
	 * @ordered
	 */
	protected NegativeApplicationCondition negativeApplicationCondition;

	/**
	 * The cached value of the '{@link #getNacBinding() <em>Nac Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNacBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCollection nacBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchingNegativeApplicationConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictPackage.Literals.MATCHING_NEGATIVE_APPLICATION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegativeApplicationCondition getNegativeApplicationCondition() {
		if (negativeApplicationCondition != null && negativeApplicationCondition.eIsProxy()) {
			InternalEObject oldNegativeApplicationCondition = (InternalEObject)negativeApplicationCondition;
			negativeApplicationCondition = (NegativeApplicationCondition)eResolveProxy(oldNegativeApplicationCondition);
			if (negativeApplicationCondition != oldNegativeApplicationCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION, oldNegativeApplicationCondition, negativeApplicationCondition));
			}
		}
		return negativeApplicationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegativeApplicationCondition basicGetNegativeApplicationCondition() {
		return negativeApplicationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNegativeApplicationCondition(NegativeApplicationCondition newNegativeApplicationCondition) {
		NegativeApplicationCondition oldNegativeApplicationCondition = negativeApplicationCondition;
		negativeApplicationCondition = newNegativeApplicationCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION, oldNegativeApplicationCondition, negativeApplicationCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCollection getNacBinding() {
		return nacBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNacBinding(TemplateBindingCollection newNacBinding, NotificationChain msgs) {
		TemplateBindingCollection oldNacBinding = nacBinding;
		nacBinding = newNacBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING, oldNacBinding, newNacBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNacBinding(TemplateBindingCollection newNacBinding) {
		if (newNacBinding != nacBinding) {
			NotificationChain msgs = null;
			if (nacBinding != null)
				msgs = ((InternalEObject)nacBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING, null, msgs);
			if (newNacBinding != null)
				msgs = ((InternalEObject)newNacBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING, null, msgs);
			msgs = basicSetNacBinding(newNacBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING, newNacBinding, newNacBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING:
				return basicSetNacBinding(null, msgs);
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
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION:
				if (resolve) return getNegativeApplicationCondition();
				return basicGetNegativeApplicationCondition();
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING:
				return getNacBinding();
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
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION:
				setNegativeApplicationCondition((NegativeApplicationCondition)newValue);
				return;
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING:
				setNacBinding((TemplateBindingCollection)newValue);
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
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION:
				setNegativeApplicationCondition((NegativeApplicationCondition)null);
				return;
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING:
				setNacBinding((TemplateBindingCollection)null);
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
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION:
				return negativeApplicationCondition != null;
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING:
				return nacBinding != null;
		}
		return super.eIsSet(featureID);
	}

} //MatchingNegativeApplicationConditionImpl
