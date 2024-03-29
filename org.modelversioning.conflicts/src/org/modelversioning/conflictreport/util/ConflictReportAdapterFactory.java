/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelversioning.conflictreport.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.ConflictReportPackage
 * @generated
 */
public class ConflictReportAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConflictReportPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConflictReportPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictReportSwitch<Adapter> modelSwitch =
		new ConflictReportSwitch<Adapter>() {
			@Override
			public Adapter caseConflictReport(ConflictReport object) {
				return createConflictReportAdapter();
			}
			@Override
			public Adapter caseEquivalentChange(EquivalentChange object) {
				return createEquivalentChangeAdapter();
			}
			@Override
			public Adapter caseConflictDependency(ConflictDependency object) {
				return createConflictDependencyAdapter();
			}
			@Override
			public Adapter caseDependentDiagramChange(DependentDiagramChange object) {
				return createDependentDiagramChangeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.ConflictReport <em>Conflict Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.ConflictReport
	 * @generated
	 */
	public Adapter createConflictReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.EquivalentChange <em>Equivalent Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.EquivalentChange
	 * @generated
	 */
	public Adapter createEquivalentChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.ConflictDependency <em>Conflict Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.ConflictDependency
	 * @generated
	 */
	public Adapter createConflictDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.DependentDiagramChange <em>Dependent Diagram Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.DependentDiagramChange
	 * @generated
	 */
	public Adapter createDependentDiagramChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConflictReportAdapterFactory
