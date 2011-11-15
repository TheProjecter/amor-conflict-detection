/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.modelversioning.conflictreport.ConflictReportPackage;
import org.modelversioning.conflictreport.DependentDiagramChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependent Diagram Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl#getModelChange <em>Model Change</em>}</li>
 *   <li>{@link org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl#getDiagramChanges <em>Diagram Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependentDiagramChangeImpl extends EObjectImpl implements DependentDiagramChange {
	/**
	 * The cached value of the '{@link #getModelChange() <em>Model Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelChange()
	 * @generated
	 * @ordered
	 */
	protected DiffElement modelChange;

	/**
	 * The cached value of the '{@link #getDiagramChanges() <em>Diagram Changes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> diagramChanges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependentDiagramChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConflictReportPackage.Literals.DEPENDENT_DIAGRAM_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement getModelChange() {
		if (modelChange != null && modelChange.eIsProxy()) {
			InternalEObject oldModelChange = (InternalEObject)modelChange;
			modelChange = (DiffElement)eResolveProxy(oldModelChange);
			if (modelChange != oldModelChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE, oldModelChange, modelChange));
			}
		}
		return modelChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiffElement basicGetModelChange() {
		return modelChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelChange(DiffElement newModelChange) {
		DiffElement oldModelChange = modelChange;
		modelChange = newModelChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE, oldModelChange, modelChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getDiagramChanges() {
		if (diagramChanges == null) {
			diagramChanges = new EObjectResolvingEList<DiffElement>(DiffElement.class, this, ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES);
		}
		return diagramChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE:
				if (resolve) return getModelChange();
				return basicGetModelChange();
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES:
				return getDiagramChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE:
				setModelChange((DiffElement)newValue);
				return;
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES:
				getDiagramChanges().clear();
				getDiagramChanges().addAll((Collection<? extends DiffElement>)newValue);
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
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE:
				setModelChange((DiffElement)null);
				return;
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES:
				getDiagramChanges().clear();
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
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE:
				return modelChange != null;
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES:
				return diagramChanges != null && !diagramChanges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DependentDiagramChangeImpl
