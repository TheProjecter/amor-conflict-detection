/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.compare.diff.metamodel.DiffPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.modelversioning.conflictreport.conflict.AddAdd;
import org.modelversioning.conflictreport.conflict.BindingSizeDifference;
import org.modelversioning.conflictreport.conflict.ConcurrentSignifierChange;
import org.modelversioning.conflictreport.conflict.ConditionViolation;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictFactory;
import org.modelversioning.conflictreport.conflict.ConflictPackage;
import org.modelversioning.conflictreport.conflict.Constraint;
import org.modelversioning.conflictreport.conflict.DeleteMove;
import org.modelversioning.conflictreport.conflict.DeleteUpdate;
import org.modelversioning.conflictreport.conflict.DeleteUse;
import org.modelversioning.conflictreport.conflict.DiagramViolation;
import org.modelversioning.conflictreport.conflict.DifferentBindingSize;
import org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition;
import org.modelversioning.conflictreport.conflict.MetamodelViolation;
import org.modelversioning.conflictreport.conflict.MissingObject;
import org.modelversioning.conflictreport.conflict.MoveMove;
import org.modelversioning.conflictreport.conflict.OperationContractDiagnostics;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;
import org.modelversioning.conflictreport.conflict.OverlappingChange;
import org.modelversioning.conflictreport.conflict.SignifierWarnings;
import org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch;
import org.modelversioning.conflictreport.conflict.UpdateUpdate;
import org.modelversioning.conflictreport.conflict.ViolatedPrecondition;
import org.modelversioning.conflictreport.conflict.Violation;
import org.modelversioning.conflictreport.conflict.ViolationSeverity;

import org.modelversioning.core.conditions.ConditionsPackage;

import org.modelversioning.core.conditions.templatebindings.TemplatebindingsPackage;

import org.modelversioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConflictPackageImpl extends EPackageImpl implements ConflictPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass overlappingChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationContractViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addAddEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass violationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteUseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteMoveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveMoveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationContractDiagnosticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass violatedPreconditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missingObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass differentBindingSizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchingNegativeApplicationConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signifierWarningsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unexpectedSignifierMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concurrentSignifierChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum violationSeverityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingSizeDifferenceEEnum = null;

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
	 * @see org.modelversioning.conflictreport.conflict.ConflictPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConflictPackageImpl() {
		super(eNS_URI, ConflictFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConflictPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConflictPackage init() {
		if (isInited) return (ConflictPackage)EPackage.Registry.INSTANCE.getEPackage(ConflictPackage.eNS_URI);

		// Obtain or create and register package
		ConflictPackageImpl theConflictPackage = (ConflictPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConflictPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConflictPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		OperationsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConflictPackage.createPackageContents();

		// Initialize created meta-data
		theConflictPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConflictPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConflictPackage.eNS_URI, theConflictPackage);
		return theConflictPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConflict() {
		return conflictEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflict_LeftChange() {
		return (EReference)conflictEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConflict_RightChange() {
		return (EReference)conflictEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOverlappingChange() {
		return overlappingChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelViolation() {
		return metamodelViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetamodelViolation_ViolatedConstraint() {
		return (EReference)metamodelViolationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationContractViolation() {
		return operationContractViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContractViolation_Diagnostics() {
		return (EReference)operationContractViolationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateUpdate() {
		return updateUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteUpdate() {
		return deleteUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddAdd() {
		return addAddEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_OclExpression() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViolation() {
		return violationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViolation_Severity() {
		return (EAttribute)violationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteUse() {
		return deleteUseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteMove() {
		return deleteMoveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoveMove() {
		return moveMoveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramViolation() {
		return diagramViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramViolation_ViolatedConstraint() {
		return (EReference)diagramViolationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationContractDiagnostics() {
		return operationContractDiagnosticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViolatedPrecondition() {
		return violatedPreconditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViolatedPrecondition_ConditionViolations() {
		return (EReference)violatedPreconditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMissingObject() {
		return missingObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMissingObject_MissingObject() {
		return (EReference)missingObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMissingObject_Template() {
		return (EReference)missingObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDifferentBindingSize() {
		return differentBindingSizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDifferentBindingSize_OldBinding() {
		return (EReference)differentBindingSizeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDifferentBindingSize_NewBinding() {
		return (EReference)differentBindingSizeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDifferentBindingSize_DifferenceKind() {
		return (EAttribute)differentBindingSizeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionViolation() {
		return conditionViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionViolation_ViolatedCondition() {
		return (EReference)conditionViolationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionViolation_ViolatingObject() {
		return (EReference)conditionViolationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchingNegativeApplicationCondition() {
		return matchingNegativeApplicationConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchingNegativeApplicationCondition_NegativeApplicationCondition() {
		return (EReference)matchingNegativeApplicationConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchingNegativeApplicationCondition_NacBinding() {
		return (EReference)matchingNegativeApplicationConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignifierWarnings() {
		return signifierWarningsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignifierWarnings_RuleName() {
		return (EAttribute)signifierWarningsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnexpectedSignifierMatch() {
		return unexpectedSignifierMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnexpectedSignifierMatch_LeftObject() {
		return (EReference)unexpectedSignifierMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnexpectedSignifierMatch_RightObject() {
		return (EReference)unexpectedSignifierMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcurrentSignifierChange() {
		return concurrentSignifierChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcurrentSignifierChange_OriginalObject() {
		return (EReference)concurrentSignifierChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getViolationSeverity() {
		return violationSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBindingSizeDifference() {
		return bindingSizeDifferenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictFactory getConflictFactory() {
		return (ConflictFactory)getEFactoryInstance();
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
		conflictEClass = createEClass(CONFLICT);
		createEReference(conflictEClass, CONFLICT__LEFT_CHANGE);
		createEReference(conflictEClass, CONFLICT__RIGHT_CHANGE);

		overlappingChangeEClass = createEClass(OVERLAPPING_CHANGE);

		metamodelViolationEClass = createEClass(METAMODEL_VIOLATION);
		createEReference(metamodelViolationEClass, METAMODEL_VIOLATION__VIOLATED_CONSTRAINT);

		operationContractViolationEClass = createEClass(OPERATION_CONTRACT_VIOLATION);
		createEReference(operationContractViolationEClass, OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS);

		updateUpdateEClass = createEClass(UPDATE_UPDATE);

		deleteUpdateEClass = createEClass(DELETE_UPDATE);

		addAddEClass = createEClass(ADD_ADD);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__OCL_EXPRESSION);

		violationEClass = createEClass(VIOLATION);
		createEAttribute(violationEClass, VIOLATION__SEVERITY);

		deleteUseEClass = createEClass(DELETE_USE);

		deleteMoveEClass = createEClass(DELETE_MOVE);

		moveMoveEClass = createEClass(MOVE_MOVE);

		diagramViolationEClass = createEClass(DIAGRAM_VIOLATION);
		createEReference(diagramViolationEClass, DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT);

		operationContractDiagnosticsEClass = createEClass(OPERATION_CONTRACT_DIAGNOSTICS);

		violatedPreconditionEClass = createEClass(VIOLATED_PRECONDITION);
		createEReference(violatedPreconditionEClass, VIOLATED_PRECONDITION__CONDITION_VIOLATIONS);

		missingObjectEClass = createEClass(MISSING_OBJECT);
		createEReference(missingObjectEClass, MISSING_OBJECT__MISSING_OBJECT);
		createEReference(missingObjectEClass, MISSING_OBJECT__TEMPLATE);

		differentBindingSizeEClass = createEClass(DIFFERENT_BINDING_SIZE);
		createEReference(differentBindingSizeEClass, DIFFERENT_BINDING_SIZE__OLD_BINDING);
		createEReference(differentBindingSizeEClass, DIFFERENT_BINDING_SIZE__NEW_BINDING);
		createEAttribute(differentBindingSizeEClass, DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND);

		conditionViolationEClass = createEClass(CONDITION_VIOLATION);
		createEReference(conditionViolationEClass, CONDITION_VIOLATION__VIOLATED_CONDITION);
		createEReference(conditionViolationEClass, CONDITION_VIOLATION__VIOLATING_OBJECT);

		matchingNegativeApplicationConditionEClass = createEClass(MATCHING_NEGATIVE_APPLICATION_CONDITION);
		createEReference(matchingNegativeApplicationConditionEClass, MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION);
		createEReference(matchingNegativeApplicationConditionEClass, MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING);

		signifierWarningsEClass = createEClass(SIGNIFIER_WARNINGS);
		createEAttribute(signifierWarningsEClass, SIGNIFIER_WARNINGS__RULE_NAME);

		unexpectedSignifierMatchEClass = createEClass(UNEXPECTED_SIGNIFIER_MATCH);
		createEReference(unexpectedSignifierMatchEClass, UNEXPECTED_SIGNIFIER_MATCH__LEFT_OBJECT);
		createEReference(unexpectedSignifierMatchEClass, UNEXPECTED_SIGNIFIER_MATCH__RIGHT_OBJECT);

		concurrentSignifierChangeEClass = createEClass(CONCURRENT_SIGNIFIER_CHANGE);
		createEReference(concurrentSignifierChangeEClass, CONCURRENT_SIGNIFIER_CHANGE__ORIGINAL_OBJECT);

		// Create enums
		violationSeverityEEnum = createEEnum(VIOLATION_SEVERITY);
		bindingSizeDifferenceEEnum = createEEnum(BINDING_SIZE_DIFFERENCE);
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
		DiffPackage theDiffPackage = (DiffPackage)EPackage.Registry.INSTANCE.getEPackage(DiffPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ConditionsPackage theConditionsPackage = (ConditionsPackage)EPackage.Registry.INSTANCE.getEPackage(ConditionsPackage.eNS_URI);
		TemplatebindingsPackage theTemplatebindingsPackage = (TemplatebindingsPackage)EPackage.Registry.INSTANCE.getEPackage(TemplatebindingsPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		overlappingChangeEClass.getESuperTypes().add(this.getConflict());
		metamodelViolationEClass.getESuperTypes().add(this.getViolation());
		operationContractViolationEClass.getESuperTypes().add(this.getViolation());
		updateUpdateEClass.getESuperTypes().add(this.getOverlappingChange());
		deleteUpdateEClass.getESuperTypes().add(this.getOverlappingChange());
		addAddEClass.getESuperTypes().add(this.getOverlappingChange());
		violationEClass.getESuperTypes().add(this.getConflict());
		deleteUseEClass.getESuperTypes().add(this.getOverlappingChange());
		deleteMoveEClass.getESuperTypes().add(this.getDeleteUse());
		moveMoveEClass.getESuperTypes().add(this.getUpdateUpdate());
		diagramViolationEClass.getESuperTypes().add(this.getViolation());
		violatedPreconditionEClass.getESuperTypes().add(this.getOperationContractDiagnostics());
		missingObjectEClass.getESuperTypes().add(this.getOperationContractDiagnostics());
		differentBindingSizeEClass.getESuperTypes().add(this.getOperationContractDiagnostics());
		matchingNegativeApplicationConditionEClass.getESuperTypes().add(this.getOperationContractDiagnostics());
		signifierWarningsEClass.getESuperTypes().add(this.getConflict());
		unexpectedSignifierMatchEClass.getESuperTypes().add(this.getSignifierWarnings());
		concurrentSignifierChangeEClass.getESuperTypes().add(this.getSignifierWarnings());

		// Initialize classes and features; add operations and parameters
		initEClass(conflictEClass, Conflict.class, "Conflict", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConflict_LeftChange(), theDiffPackage.getDiffElement(), null, "leftChange", null, 0, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflict_RightChange(), theDiffPackage.getDiffElement(), null, "rightChange", null, 0, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(overlappingChangeEClass, OverlappingChange.class, "OverlappingChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metamodelViolationEClass, MetamodelViolation.class, "MetamodelViolation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetamodelViolation_ViolatedConstraint(), this.getConstraint(), null, "violatedConstraint", null, 0, 1, MetamodelViolation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationContractViolationEClass, OperationContractViolation.class, "OperationContractViolation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContractViolation_Diagnostics(), this.getOperationContractDiagnostics(), null, "diagnostics", null, 1, 1, OperationContractViolation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateUpdateEClass, UpdateUpdate.class, "UpdateUpdate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteUpdateEClass, DeleteUpdate.class, "DeleteUpdate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addAddEClass, AddAdd.class, "AddAdd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_OclExpression(), theEcorePackage.getEString(), "oclExpression", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(violationEClass, Violation.class, "Violation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViolation_Severity(), this.getViolationSeverity(), "severity", "ERROR", 1, 1, Violation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteUseEClass, DeleteUse.class, "DeleteUse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteMoveEClass, DeleteMove.class, "DeleteMove", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moveMoveEClass, MoveMove.class, "MoveMove", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diagramViolationEClass, DiagramViolation.class, "DiagramViolation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramViolation_ViolatedConstraint(), this.getConstraint(), null, "violatedConstraint", null, 1, 1, DiagramViolation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationContractDiagnosticsEClass, OperationContractDiagnostics.class, "OperationContractDiagnostics", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(violatedPreconditionEClass, ViolatedPrecondition.class, "ViolatedPrecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViolatedPrecondition_ConditionViolations(), this.getConditionViolation(), null, "conditionViolations", null, 1, -1, ViolatedPrecondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(missingObjectEClass, MissingObject.class, "MissingObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMissingObject_MissingObject(), theEcorePackage.getEObject(), null, "missingObject", null, 1, 1, MissingObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMissingObject_Template(), theConditionsPackage.getTemplate(), null, "template", null, 1, 1, MissingObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(differentBindingSizeEClass, DifferentBindingSize.class, "DifferentBindingSize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDifferentBindingSize_OldBinding(), theTemplatebindingsPackage.getTemplateBindingCollection(), null, "oldBinding", null, 1, 1, DifferentBindingSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDifferentBindingSize_NewBinding(), theTemplatebindingsPackage.getTemplateBindingCollection(), null, "newBinding", null, 1, 1, DifferentBindingSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDifferentBindingSize_DifferenceKind(), this.getBindingSizeDifference(), "differenceKind", null, 1, 1, DifferentBindingSize.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionViolationEClass, ConditionViolation.class, "ConditionViolation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionViolation_ViolatedCondition(), theConditionsPackage.getCondition(), null, "violatedCondition", null, 1, 1, ConditionViolation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionViolation_ViolatingObject(), theEcorePackage.getEObject(), null, "violatingObject", null, 1, 1, ConditionViolation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchingNegativeApplicationConditionEClass, MatchingNegativeApplicationCondition.class, "MatchingNegativeApplicationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchingNegativeApplicationCondition_NegativeApplicationCondition(), theOperationsPackage.getNegativeApplicationCondition(), null, "negativeApplicationCondition", null, 1, 1, MatchingNegativeApplicationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchingNegativeApplicationCondition_NacBinding(), theTemplatebindingsPackage.getTemplateBindingCollection(), null, "nacBinding", null, 1, 1, MatchingNegativeApplicationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signifierWarningsEClass, SignifierWarnings.class, "SignifierWarnings", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignifierWarnings_RuleName(), ecorePackage.getEString(), "ruleName", null, 1, 1, SignifierWarnings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unexpectedSignifierMatchEClass, UnexpectedSignifierMatch.class, "UnexpectedSignifierMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnexpectedSignifierMatch_LeftObject(), theEcorePackage.getEObject(), null, "leftObject", null, 0, 1, UnexpectedSignifierMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnexpectedSignifierMatch_RightObject(), theEcorePackage.getEObject(), null, "rightObject", null, 0, 1, UnexpectedSignifierMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concurrentSignifierChangeEClass, ConcurrentSignifierChange.class, "ConcurrentSignifierChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConcurrentSignifierChange_OriginalObject(), theEcorePackage.getEObject(), null, "originalObject", null, 0, 1, ConcurrentSignifierChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(violationSeverityEEnum, ViolationSeverity.class, "ViolationSeverity");
		addEEnumLiteral(violationSeverityEEnum, ViolationSeverity.INFO);
		addEEnumLiteral(violationSeverityEEnum, ViolationSeverity.WARNING);
		addEEnumLiteral(violationSeverityEEnum, ViolationSeverity.ERROR);

		initEEnum(bindingSizeDifferenceEEnum, BindingSizeDifference.class, "BindingSizeDifference");
		addEEnumLiteral(bindingSizeDifferenceEEnum, BindingSizeDifference.DECREASED);
		addEEnumLiteral(bindingSizeDifferenceEEnum, BindingSizeDifference.INCREASED);
		addEEnumLiteral(bindingSizeDifferenceEEnum, BindingSizeDifference.BOTH);

		// Create resource
		createResource(eNS_URI);
	}

} //ConflictPackageImpl
