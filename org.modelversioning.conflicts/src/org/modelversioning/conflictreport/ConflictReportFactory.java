/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.ConflictReportPackage
 * @generated
 */
public interface ConflictReportFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConflictReportFactory eINSTANCE = org.modelversioning.conflictreport.impl.ConflictReportFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Conflict Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict Report</em>'.
	 * @generated
	 */
	ConflictReport createConflictReport();

	/**
	 * Returns a new object of class '<em>Equivalent Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equivalent Change</em>'.
	 * @generated
	 */
	EquivalentChange createEquivalentChange();

	/**
	 * Returns a new object of class '<em>Conflict Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict Dependency</em>'.
	 * @generated
	 */
	ConflictDependency createConflictDependency();

	/**
	 * Returns a new object of class '<em>Dependent Diagram Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependent Diagram Change</em>'.
	 * @generated
	 */
	DependentDiagramChange createDependentDiagramChange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConflictReportPackage getConflictReportPackage();

} //ConflictReportFactory
