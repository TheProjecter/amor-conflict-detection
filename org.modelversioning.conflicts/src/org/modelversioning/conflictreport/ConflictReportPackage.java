/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.ConflictReportFactory
 * @model kind="package"
 * @generated
 */
public interface ConflictReportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "conflictreport";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelversioning.org/conflictreport/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "conflictreport";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConflictReportPackage eINSTANCE = org.modelversioning.conflictreport.impl.ConflictReportPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.impl.ConflictReportImpl <em>Conflict Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.impl.ConflictReportImpl
	 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getConflictReport()
	 * @generated
	 */
	int CONFLICT_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__CONFLICTS = 0;

	/**
	 * The feature id for the '<em><b>Equivalent Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__EQUIVALENT_CHANGES = 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__DEPENDENCIES = 2;

	/**
	 * The feature id for the '<em><b>Left Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__LEFT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Right Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__RIGHT_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Left Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__LEFT_DIAGRAMS = 5;

	/**
	 * The feature id for the '<em><b>Right Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__RIGHT_DIAGRAMS = 6;

	/**
	 * The feature id for the '<em><b>Left User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__LEFT_USER = 7;

	/**
	 * The feature id for the '<em><b>Right User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__RIGHT_USER = 8;

	/**
	 * The feature id for the '<em><b>Diagram Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT__DIAGRAM_DEPENDENCIES = 9;

	/**
	 * The number of structural features of the '<em>Conflict Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_REPORT_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.impl.EquivalentChangeImpl <em>Equivalent Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.impl.EquivalentChangeImpl
	 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getEquivalentChange()
	 * @generated
	 */
	int EQUIVALENT_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_CHANGE__LEFT_CHANGE = 0;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_CHANGE__RIGHT_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Prefer Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_CHANGE__PREFER_SIDE = 2;

	/**
	 * The number of structural features of the '<em>Equivalent Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_CHANGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.impl.ConflictDependencyImpl <em>Conflict Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.impl.ConflictDependencyImpl
	 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getConflictDependency()
	 * @generated
	 */
	int CONFLICT_DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>Dependent Conflict</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT = 0;

	/**
	 * The number of structural features of the '<em>Conflict Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_DEPENDENCY_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl <em>Dependent Diagram Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl
	 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getDependentDiagramChange()
	 * @generated
	 */
	int DEPENDENT_DIAGRAM_CHANGE = 3;

	/**
	 * The feature id for the '<em><b>Model Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE = 0;

	/**
	 * The feature id for the '<em><b>Diagram Changes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES = 1;

	/**
	 * The number of structural features of the '<em>Dependent Diagram Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENT_DIAGRAM_CHANGE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.ConflictReport <em>Conflict Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict Report</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport
	 * @generated
	 */
	EClass getConflictReport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelversioning.conflictreport.ConflictReport#getConflicts <em>Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conflicts</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getConflicts()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_Conflicts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelversioning.conflictreport.ConflictReport#getEquivalentChanges <em>Equivalent Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equivalent Changes</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getEquivalentChanges()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_EquivalentChanges();

	/**
	 * Returns the meta object for the reference list '{@link org.modelversioning.conflictreport.ConflictReport#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getDependencies()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_Dependencies();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.ConflictReport#getLeftVersion <em>Left Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Version</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getLeftVersion()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_LeftVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.ConflictReport#getRightVersion <em>Right Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Version</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getRightVersion()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_RightVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelversioning.conflictreport.ConflictReport#getLeftDiagrams <em>Left Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Left Diagrams</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getLeftDiagrams()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_LeftDiagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelversioning.conflictreport.ConflictReport#getRightDiagrams <em>Right Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Right Diagrams</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getRightDiagrams()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_RightDiagrams();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.ConflictReport#getLeftUser <em>Left User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left User</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getLeftUser()
	 * @see #getConflictReport()
	 * @generated
	 */
	EAttribute getConflictReport_LeftUser();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.ConflictReport#getRightUser <em>Right User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right User</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getRightUser()
	 * @see #getConflictReport()
	 * @generated
	 */
	EAttribute getConflictReport_RightUser();

	/**
	 * Returns the meta object for the reference list '{@link org.modelversioning.conflictreport.ConflictReport#getDiagramDependencies <em>Diagram Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Diagram Dependencies</em>'.
	 * @see org.modelversioning.conflictreport.ConflictReport#getDiagramDependencies()
	 * @see #getConflictReport()
	 * @generated
	 */
	EReference getConflictReport_DiagramDependencies();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.EquivalentChange <em>Equivalent Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Change</em>'.
	 * @see org.modelversioning.conflictreport.EquivalentChange
	 * @generated
	 */
	EClass getEquivalentChange();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.EquivalentChange#getLeftChange <em>Left Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Change</em>'.
	 * @see org.modelversioning.conflictreport.EquivalentChange#getLeftChange()
	 * @see #getEquivalentChange()
	 * @generated
	 */
	EReference getEquivalentChange_LeftChange();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.EquivalentChange#getRightChange <em>Right Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Change</em>'.
	 * @see org.modelversioning.conflictreport.EquivalentChange#getRightChange()
	 * @see #getEquivalentChange()
	 * @generated
	 */
	EReference getEquivalentChange_RightChange();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.EquivalentChange#getPreferSide <em>Prefer Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefer Side</em>'.
	 * @see org.modelversioning.conflictreport.EquivalentChange#getPreferSide()
	 * @see #getEquivalentChange()
	 * @generated
	 */
	EAttribute getEquivalentChange_PreferSide();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.ConflictDependency <em>Conflict Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict Dependency</em>'.
	 * @see org.modelversioning.conflictreport.ConflictDependency
	 * @generated
	 */
	EClass getConflictDependency();

	/**
	 * Returns the meta object for the reference list '{@link org.modelversioning.conflictreport.ConflictDependency#getDependentConflict <em>Dependent Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependent Conflict</em>'.
	 * @see org.modelversioning.conflictreport.ConflictDependency#getDependentConflict()
	 * @see #getConflictDependency()
	 * @generated
	 */
	EReference getConflictDependency_DependentConflict();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.DependentDiagramChange <em>Dependent Diagram Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependent Diagram Change</em>'.
	 * @see org.modelversioning.conflictreport.DependentDiagramChange
	 * @generated
	 */
	EClass getDependentDiagramChange();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.DependentDiagramChange#getModelChange <em>Model Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Change</em>'.
	 * @see org.modelversioning.conflictreport.DependentDiagramChange#getModelChange()
	 * @see #getDependentDiagramChange()
	 * @generated
	 */
	EReference getDependentDiagramChange_ModelChange();

	/**
	 * Returns the meta object for the reference list '{@link org.modelversioning.conflictreport.DependentDiagramChange#getDiagramChanges <em>Diagram Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Diagram Changes</em>'.
	 * @see org.modelversioning.conflictreport.DependentDiagramChange#getDiagramChanges()
	 * @see #getDependentDiagramChange()
	 * @generated
	 */
	EReference getDependentDiagramChange_DiagramChanges();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConflictReportFactory getConflictReportFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.impl.ConflictReportImpl <em>Conflict Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.impl.ConflictReportImpl
		 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getConflictReport()
		 * @generated
		 */
		EClass CONFLICT_REPORT = eINSTANCE.getConflictReport();

		/**
		 * The meta object literal for the '<em><b>Conflicts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__CONFLICTS = eINSTANCE.getConflictReport_Conflicts();

		/**
		 * The meta object literal for the '<em><b>Equivalent Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__EQUIVALENT_CHANGES = eINSTANCE.getConflictReport_EquivalentChanges();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__DEPENDENCIES = eINSTANCE.getConflictReport_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Left Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__LEFT_VERSION = eINSTANCE.getConflictReport_LeftVersion();

		/**
		 * The meta object literal for the '<em><b>Right Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__RIGHT_VERSION = eINSTANCE.getConflictReport_RightVersion();

		/**
		 * The meta object literal for the '<em><b>Left Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__LEFT_DIAGRAMS = eINSTANCE.getConflictReport_LeftDiagrams();

		/**
		 * The meta object literal for the '<em><b>Right Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__RIGHT_DIAGRAMS = eINSTANCE.getConflictReport_RightDiagrams();

		/**
		 * The meta object literal for the '<em><b>Left User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_REPORT__LEFT_USER = eINSTANCE.getConflictReport_LeftUser();

		/**
		 * The meta object literal for the '<em><b>Right User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT_REPORT__RIGHT_USER = eINSTANCE.getConflictReport_RightUser();

		/**
		 * The meta object literal for the '<em><b>Diagram Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_REPORT__DIAGRAM_DEPENDENCIES = eINSTANCE.getConflictReport_DiagramDependencies();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.impl.EquivalentChangeImpl <em>Equivalent Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.impl.EquivalentChangeImpl
		 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getEquivalentChange()
		 * @generated
		 */
		EClass EQUIVALENT_CHANGE = eINSTANCE.getEquivalentChange();

		/**
		 * The meta object literal for the '<em><b>Left Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIVALENT_CHANGE__LEFT_CHANGE = eINSTANCE.getEquivalentChange_LeftChange();

		/**
		 * The meta object literal for the '<em><b>Right Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIVALENT_CHANGE__RIGHT_CHANGE = eINSTANCE.getEquivalentChange_RightChange();

		/**
		 * The meta object literal for the '<em><b>Prefer Side</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIVALENT_CHANGE__PREFER_SIDE = eINSTANCE.getEquivalentChange_PreferSide();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.impl.ConflictDependencyImpl <em>Conflict Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.impl.ConflictDependencyImpl
		 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getConflictDependency()
		 * @generated
		 */
		EClass CONFLICT_DEPENDENCY = eINSTANCE.getConflictDependency();

		/**
		 * The meta object literal for the '<em><b>Dependent Conflict</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT = eINSTANCE.getConflictDependency_DependentConflict();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl <em>Dependent Diagram Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.impl.DependentDiagramChangeImpl
		 * @see org.modelversioning.conflictreport.impl.ConflictReportPackageImpl#getDependentDiagramChange()
		 * @generated
		 */
		EClass DEPENDENT_DIAGRAM_CHANGE = eINSTANCE.getDependentDiagramChange();

		/**
		 * The meta object literal for the '<em><b>Model Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE = eINSTANCE.getDependentDiagramChange_ModelChange();

		/**
		 * The meta object literal for the '<em><b>Diagram Changes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES = eINSTANCE.getDependentDiagramChange_DiagramChanges();

	}

} //ConflictReportPackage
