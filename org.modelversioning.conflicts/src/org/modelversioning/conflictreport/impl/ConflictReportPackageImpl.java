/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.impl;

import org.eclipse.emf.compare.diff.metamodel.DiffPackage;

import org.eclipse.emf.compare.match.metamodel.MatchPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.modelversioning.conflictreport.ConflictDependency;
import org.modelversioning.conflictreport.ConflictReport;
import org.modelversioning.conflictreport.ConflictReportFactory;
import org.modelversioning.conflictreport.ConflictReportPackage;

import org.modelversioning.conflictreport.DependentDiagramChange;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.ConflictPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConflictReportPackageImpl extends EPackageImpl implements ConflictReportPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependentDiagramChangeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.modelversioning.conflictreport.ConflictReportPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConflictReportPackageImpl() {
		super(eNS_URI, ConflictReportFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConflictReportPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConflictReportPackage init() {
		if (isInited) return (ConflictReportPackage)EPackage.Registry.INSTANCE.getEPackage(ConflictReportPackage.eNS_URI);

		// Obtain or create and register package
		ConflictReportPackageImpl theConflictReportPackage = (ConflictReportPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConflictReportPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConflictReportPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConflictPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConflictReportPackage.createPackageContents();

		// Initialize created meta-data
		theConflictReportPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConflictReportPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConflictReportPackage.eNS_URI, theConflictReportPackage);
		return theConflictReportPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConflictReport() {
		return conflictReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_Conflicts() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_EquivalentChanges() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_Dependencies() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_LeftVersion() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_RightVersion() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_LeftDiagrams() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_RightDiagrams() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConflictReport_LeftUser() {
		return (EAttribute)conflictReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConflictReport_RightUser() {
		return (EAttribute)conflictReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictReport_DiagramDependencies() {
		return (EReference)conflictReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentChange() {
		return equivalentChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquivalentChange_LeftChange() {
		return (EReference)equivalentChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquivalentChange_RightChange() {
		return (EReference)equivalentChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquivalentChange_PreferSide() {
		return (EAttribute)equivalentChangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConflictDependency() {
		return conflictDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflictDependency_DependentConflict() {
		return (EReference)conflictDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependentDiagramChange() {
		return dependentDiagramChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentDiagramChange_ModelChange() {
		return (EReference)dependentDiagramChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependentDiagramChange_DiagramChanges() {
		return (EReference)dependentDiagramChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportFactory getConflictReportFactory() {
		return (ConflictReportFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		conflictReportEClass = createEClass(CONFLICT_REPORT);
		createEReference(conflictReportEClass, CONFLICT_REPORT__CONFLICTS);
		createEReference(conflictReportEClass, CONFLICT_REPORT__EQUIVALENT_CHANGES);
		createEReference(conflictReportEClass, CONFLICT_REPORT__DEPENDENCIES);
		createEReference(conflictReportEClass, CONFLICT_REPORT__LEFT_VERSION);
		createEReference(conflictReportEClass, CONFLICT_REPORT__RIGHT_VERSION);
		createEReference(conflictReportEClass, CONFLICT_REPORT__LEFT_DIAGRAMS);
		createEReference(conflictReportEClass, CONFLICT_REPORT__RIGHT_DIAGRAMS);
		createEAttribute(conflictReportEClass, CONFLICT_REPORT__LEFT_USER);
		createEAttribute(conflictReportEClass, CONFLICT_REPORT__RIGHT_USER);
		createEReference(conflictReportEClass, CONFLICT_REPORT__DIAGRAM_DEPENDENCIES);

		equivalentChangeEClass = createEClass(EQUIVALENT_CHANGE);
		createEReference(equivalentChangeEClass, EQUIVALENT_CHANGE__LEFT_CHANGE);
		createEReference(equivalentChangeEClass, EQUIVALENT_CHANGE__RIGHT_CHANGE);
		createEAttribute(equivalentChangeEClass, EQUIVALENT_CHANGE__PREFER_SIDE);

		conflictDependencyEClass = createEClass(CONFLICT_DEPENDENCY);
		createEReference(conflictDependencyEClass, CONFLICT_DEPENDENCY__DEPENDENT_CONFLICT);

		dependentDiagramChangeEClass = createEClass(DEPENDENT_DIAGRAM_CHANGE);
		createEReference(dependentDiagramChangeEClass, DEPENDENT_DIAGRAM_CHANGE__MODEL_CHANGE);
		createEReference(dependentDiagramChangeEClass, DEPENDENT_DIAGRAM_CHANGE__DIAGRAM_CHANGES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConflictPackage theConflictPackage = (ConflictPackage)EPackage.Registry.INSTANCE.getEPackage(ConflictPackage.eNS_URI);
		DiffPackage theDiffPackage = (DiffPackage)EPackage.Registry.INSTANCE.getEPackage(DiffPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		MatchPackage theMatchPackage = (MatchPackage)EPackage.Registry.INSTANCE.getEPackage(MatchPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(conflictReportEClass, ConflictReport.class, "ConflictReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConflictReport_Conflicts(), theConflictPackage.getConflict(), null, "conflicts", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_EquivalentChanges(), this.getEquivalentChange(), null, "equivalentChanges", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_Dependencies(), this.getConflictDependency(), null, "dependencies", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_LeftVersion(), theDiffPackage.getComparisonResourceSnapshot(), null, "leftVersion", null, 0, 1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_RightVersion(), theDiffPackage.getComparisonResourceSnapshot(), null, "rightVersion", null, 0, 1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_LeftDiagrams(), theDiffPackage.getComparisonResourceSnapshot(), null, "leftDiagrams", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_RightDiagrams(), theDiffPackage.getComparisonResourceSnapshot(), null, "rightDiagrams", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflictReport_LeftUser(), theEcorePackage.getEString(), "leftUser", null, 0, 1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflictReport_RightUser(), theEcorePackage.getEString(), "rightUser", null, 0, 1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictReport_DiagramDependencies(), this.getDependentDiagramChange(), null, "diagramDependencies", null, 0, -1, ConflictReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(conflictReportEClass, ecorePackage.getEBoolean(), "hasConflictingChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diffElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getConflictingChanges", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diffElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theConflictPackage.getConflict(), "getConflicts", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diffElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, ecorePackage.getEBoolean(), "hasEquivalentChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diffElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getEquivalentChanges", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diffElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getEquivalentSubChanges", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getEquivalentPreferredChanges", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theEcorePackage.getEBoolean(), "isDependentDiagramChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diagramChange", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getDependentDiagramChanges", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "modelChange", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theDiffPackage.getDiffElement(), "getDependentModelChange", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "diagramChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(conflictReportEClass, theEcorePackage.getEBoolean(), "hasDependentDiagramChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDiffPackage.getDiffElement(), "modelChange", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equivalentChangeEClass, EquivalentChange.class, "EquivalentChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquivalentChange_LeftChange(), theDiffPackage.getDiffElement(), null, "leftChange", null, 0, 1, EquivalentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquivalentChange_RightChange(), theDiffPackage.getDiffElement(), null, "rightChange", null, 0, 1, EquivalentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquivalentChange_PreferSide(), theMatchPackage.getSide(), "preferSide", null, 1, 1, EquivalentChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(equivalentChangeEClass, theDiffPackage.getDiffElement(), "getPreferredChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(equivalentChangeEClass, theDiffPackage.getDiffElement(), "getSubChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conflictDependencyEClass, ConflictDependency.class, "ConflictDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConflictDependency_DependentConflict(), theConflictPackage.getConflict(), null, "dependentConflict", null, 2, 2, ConflictDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependentDiagramChangeEClass, DependentDiagramChange.class, "DependentDiagramChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependentDiagramChange_ModelChange(), theDiffPackage.getDiffElement(), null, "modelChange", null, 1, 1, DependentDiagramChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependentDiagramChange_DiagramChanges(), theDiffPackage.getDiffElement(), null, "diagramChanges", null, 0, -1, DependentDiagramChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ConflictReportPackageImpl
