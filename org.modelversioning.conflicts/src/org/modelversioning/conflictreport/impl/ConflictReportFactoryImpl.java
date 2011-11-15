/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelversioning.conflictreport.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConflictReportFactoryImpl extends EFactoryImpl implements ConflictReportFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConflictReportFactory init() {
		try {
			ConflictReportFactory theConflictReportFactory = (ConflictReportFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelversioning.org/conflictreport/1.0"); 
			if (theConflictReportFactory != null) {
				return theConflictReportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConflictReportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConflictReportPackage.CONFLICT_REPORT: return createConflictReport();
			case ConflictReportPackage.EQUIVALENT_CHANGE: return createEquivalentChange();
			case ConflictReportPackage.CONFLICT_DEPENDENCY: return createConflictDependency();
			case ConflictReportPackage.DEPENDENT_DIAGRAM_CHANGE: return createDependentDiagramChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReport createConflictReport() {
		ConflictReportImpl conflictReport = new ConflictReportImpl();
		return conflictReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentChange createEquivalentChange() {
		EquivalentChangeImpl equivalentChange = new EquivalentChangeImpl();
		return equivalentChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictDependency createConflictDependency() {
		ConflictDependencyImpl conflictDependency = new ConflictDependencyImpl();
		return conflictDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependentDiagramChange createDependentDiagramChange() {
		DependentDiagramChangeImpl dependentDiagramChange = new DependentDiagramChangeImpl();
		return dependentDiagramChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportPackage getConflictReportPackage() {
		return (ConflictReportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConflictReportPackage getPackage() {
		return ConflictReportPackage.eINSTANCE;
	}

} //ConflictReportFactoryImpl
