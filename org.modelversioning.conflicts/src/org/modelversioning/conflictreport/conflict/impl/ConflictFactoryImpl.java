/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelversioning.conflictreport.conflict.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConflictFactoryImpl extends EFactoryImpl implements ConflictFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConflictFactory init() {
		try {
			ConflictFactory theConflictFactory = (ConflictFactory)EPackage.Registry.INSTANCE.getEFactory("http://modelversioning.org/conflict/1.0"); 
			if (theConflictFactory != null) {
				return theConflictFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConflictFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictFactoryImpl() {
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
			case ConflictPackage.METAMODEL_VIOLATION: return createMetamodelViolation();
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION: return createOperationContractViolation();
			case ConflictPackage.UPDATE_UPDATE: return createUpdateUpdate();
			case ConflictPackage.DELETE_UPDATE: return createDeleteUpdate();
			case ConflictPackage.ADD_ADD: return createAddAdd();
			case ConflictPackage.CONSTRAINT: return createConstraint();
			case ConflictPackage.DELETE_USE: return createDeleteUse();
			case ConflictPackage.DELETE_MOVE: return createDeleteMove();
			case ConflictPackage.MOVE_MOVE: return createMoveMove();
			case ConflictPackage.DIAGRAM_VIOLATION: return createDiagramViolation();
			case ConflictPackage.VIOLATED_PRECONDITION: return createViolatedPrecondition();
			case ConflictPackage.MISSING_OBJECT: return createMissingObject();
			case ConflictPackage.DIFFERENT_BINDING_SIZE: return createDifferentBindingSize();
			case ConflictPackage.CONDITION_VIOLATION: return createConditionViolation();
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION: return createMatchingNegativeApplicationCondition();
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH: return createUnexpectedSignifierMatch();
			case ConflictPackage.CONCURRENT_SIGNIFIER_CHANGE: return createConcurrentSignifierChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConflictPackage.VIOLATION_SEVERITY:
				return createViolationSeverityFromString(eDataType, initialValue);
			case ConflictPackage.BINDING_SIZE_DIFFERENCE:
				return createBindingSizeDifferenceFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ConflictPackage.VIOLATION_SEVERITY:
				return convertViolationSeverityToString(eDataType, instanceValue);
			case ConflictPackage.BINDING_SIZE_DIFFERENCE:
				return convertBindingSizeDifferenceToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelViolation createMetamodelViolation() {
		MetamodelViolationImpl metamodelViolation = new MetamodelViolationImpl();
		return metamodelViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContractViolation createOperationContractViolation() {
		OperationContractViolationImpl operationContractViolation = new OperationContractViolationImpl();
		return operationContractViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateUpdate createUpdateUpdate() {
		UpdateUpdateImpl updateUpdate = new UpdateUpdateImpl();
		return updateUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteUpdate createDeleteUpdate() {
		DeleteUpdateImpl deleteUpdate = new DeleteUpdateImpl();
		return deleteUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddAdd createAddAdd() {
		AddAddImpl addAdd = new AddAddImpl();
		return addAdd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteUse createDeleteUse() {
		DeleteUseImpl deleteUse = new DeleteUseImpl();
		return deleteUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteMove createDeleteMove() {
		DeleteMoveImpl deleteMove = new DeleteMoveImpl();
		return deleteMove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoveMove createMoveMove() {
		MoveMoveImpl moveMove = new MoveMoveImpl();
		return moveMove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramViolation createDiagramViolation() {
		DiagramViolationImpl diagramViolation = new DiagramViolationImpl();
		return diagramViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViolatedPrecondition createViolatedPrecondition() {
		ViolatedPreconditionImpl violatedPrecondition = new ViolatedPreconditionImpl();
		return violatedPrecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissingObject createMissingObject() {
		MissingObjectImpl missingObject = new MissingObjectImpl();
		return missingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferentBindingSize createDifferentBindingSize() {
		DifferentBindingSizeImpl differentBindingSize = new DifferentBindingSizeImpl();
		return differentBindingSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionViolation createConditionViolation() {
		ConditionViolationImpl conditionViolation = new ConditionViolationImpl();
		return conditionViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchingNegativeApplicationCondition createMatchingNegativeApplicationCondition() {
		MatchingNegativeApplicationConditionImpl matchingNegativeApplicationCondition = new MatchingNegativeApplicationConditionImpl();
		return matchingNegativeApplicationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnexpectedSignifierMatch createUnexpectedSignifierMatch() {
		UnexpectedSignifierMatchImpl unexpectedSignifierMatch = new UnexpectedSignifierMatchImpl();
		return unexpectedSignifierMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrentSignifierChange createConcurrentSignifierChange() {
		ConcurrentSignifierChangeImpl concurrentSignifierChange = new ConcurrentSignifierChangeImpl();
		return concurrentSignifierChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViolationSeverity createViolationSeverityFromString(EDataType eDataType, String initialValue) {
		ViolationSeverity result = ViolationSeverity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertViolationSeverityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingSizeDifference createBindingSizeDifferenceFromString(EDataType eDataType, String initialValue) {
		BindingSizeDifference result = BindingSizeDifference.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingSizeDifferenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictPackage getConflictPackage() {
		return (ConflictPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConflictPackage getPackage() {
		return ConflictPackage.eINSTANCE;
	}

} //ConflictFactoryImpl
