/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.modelversioning.conflictreport.conflict.ConflictFactory
 * @model kind="package"
 * @generated
 */
public interface ConflictPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "conflict";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modelversioning.org/conflict/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "conflict";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConflictPackage eINSTANCE = org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.ConflictImpl <em>Conflict</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConflict()
	 * @generated
	 */
	int CONFLICT = 0;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__LEFT_CHANGE = 0;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__RIGHT_CHANGE = 1;

	/**
	 * The number of structural features of the '<em>Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.OverlappingChangeImpl <em>Overlapping Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.OverlappingChangeImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOverlappingChange()
	 * @generated
	 */
	int OVERLAPPING_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLAPPING_CHANGE__LEFT_CHANGE = CONFLICT__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLAPPING_CHANGE__RIGHT_CHANGE = CONFLICT__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Overlapping Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLAPPING_CHANGE_FEATURE_COUNT = CONFLICT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.ViolationImpl <em>Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.ViolationImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolation()
	 * @generated
	 */
	int VIOLATION = 8;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__LEFT_CHANGE = CONFLICT__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__RIGHT_CHANGE = CONFLICT__RIGHT_CHANGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION__SEVERITY = CONFLICT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATION_FEATURE_COUNT = CONFLICT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.MetamodelViolationImpl <em>Metamodel Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.MetamodelViolationImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMetamodelViolation()
	 * @generated
	 */
	int METAMODEL_VIOLATION = 2;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_VIOLATION__LEFT_CHANGE = VIOLATION__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_VIOLATION__RIGHT_CHANGE = VIOLATION__RIGHT_CHANGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_VIOLATION__SEVERITY = VIOLATION__SEVERITY;

	/**
	 * The feature id for the '<em><b>Violated Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_VIOLATION__VIOLATED_CONSTRAINT = VIOLATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metamodel Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_VIOLATION_FEATURE_COUNT = VIOLATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.OperationContractViolationImpl <em>Operation Contract Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.OperationContractViolationImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOperationContractViolation()
	 * @generated
	 */
	int OPERATION_CONTRACT_VIOLATION = 3;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_VIOLATION__LEFT_CHANGE = VIOLATION__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_VIOLATION__RIGHT_CHANGE = VIOLATION__RIGHT_CHANGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_VIOLATION__SEVERITY = VIOLATION__SEVERITY;

	/**
	 * The feature id for the '<em><b>Diagnostics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS = VIOLATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Contract Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_VIOLATION_FEATURE_COUNT = VIOLATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.UpdateUpdateImpl <em>Update Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.UpdateUpdateImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getUpdateUpdate()
	 * @generated
	 */
	int UPDATE_UPDATE = 4;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_UPDATE__LEFT_CHANGE = OVERLAPPING_CHANGE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_UPDATE__RIGHT_CHANGE = OVERLAPPING_CHANGE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Update Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_UPDATE_FEATURE_COUNT = OVERLAPPING_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteUpdateImpl <em>Delete Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.DeleteUpdateImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteUpdate()
	 * @generated
	 */
	int DELETE_UPDATE = 5;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_UPDATE__LEFT_CHANGE = OVERLAPPING_CHANGE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_UPDATE__RIGHT_CHANGE = OVERLAPPING_CHANGE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Delete Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_UPDATE_FEATURE_COUNT = OVERLAPPING_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.AddAddImpl <em>Add Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.AddAddImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getAddAdd()
	 * @generated
	 */
	int ADD_ADD = 6;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ADD__LEFT_CHANGE = OVERLAPPING_CHANGE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ADD__RIGHT_CHANGE = OVERLAPPING_CHANGE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Add Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ADD_FEATURE_COUNT = OVERLAPPING_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.ConstraintImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OCL_EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteUseImpl <em>Delete Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.DeleteUseImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteUse()
	 * @generated
	 */
	int DELETE_USE = 9;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_USE__LEFT_CHANGE = OVERLAPPING_CHANGE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_USE__RIGHT_CHANGE = OVERLAPPING_CHANGE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Delete Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_USE_FEATURE_COUNT = OVERLAPPING_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteMoveImpl <em>Delete Move</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.DeleteMoveImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteMove()
	 * @generated
	 */
	int DELETE_MOVE = 10;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE__LEFT_CHANGE = DELETE_USE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE__RIGHT_CHANGE = DELETE_USE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Delete Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_MOVE_FEATURE_COUNT = DELETE_USE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.MoveMoveImpl <em>Move Move</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.MoveMoveImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMoveMove()
	 * @generated
	 */
	int MOVE_MOVE = 11;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_MOVE__LEFT_CHANGE = UPDATE_UPDATE__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_MOVE__RIGHT_CHANGE = UPDATE_UPDATE__RIGHT_CHANGE;

	/**
	 * The number of structural features of the '<em>Move Move</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_MOVE_FEATURE_COUNT = UPDATE_UPDATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.DiagramViolationImpl <em>Diagram Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.DiagramViolationImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDiagramViolation()
	 * @generated
	 */
	int DIAGRAM_VIOLATION = 12;

	/**
	 * The feature id for the '<em><b>Left Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_VIOLATION__LEFT_CHANGE = VIOLATION__LEFT_CHANGE;

	/**
	 * The feature id for the '<em><b>Right Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_VIOLATION__RIGHT_CHANGE = VIOLATION__RIGHT_CHANGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_VIOLATION__SEVERITY = VIOLATION__SEVERITY;

	/**
	 * The feature id for the '<em><b>Violated Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT = VIOLATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Diagram Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_VIOLATION_FEATURE_COUNT = VIOLATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.OperationContractDiagnosticsImpl <em>Operation Contract Diagnostics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.OperationContractDiagnosticsImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOperationContractDiagnostics()
	 * @generated
	 */
	int OPERATION_CONTRACT_DIAGNOSTICS = 13;

	/**
	 * The number of structural features of the '<em>Operation Contract Diagnostics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.ViolatedPreconditionImpl <em>Violated Precondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.ViolatedPreconditionImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolatedPrecondition()
	 * @generated
	 */
	int VIOLATED_PRECONDITION = 14;

	/**
	 * The feature id for the '<em><b>Condition Violations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATED_PRECONDITION__CONDITION_VIOLATIONS = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Violated Precondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIOLATED_PRECONDITION_FEATURE_COUNT = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.MissingObjectImpl <em>Missing Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.MissingObjectImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMissingObject()
	 * @generated
	 */
	int MISSING_OBJECT = 15;

	/**
	 * The feature id for the '<em><b>Missing Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_OBJECT__MISSING_OBJECT = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_OBJECT__TEMPLATE = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Missing Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_OBJECT_FEATURE_COUNT = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl <em>Different Binding Size</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDifferentBindingSize()
	 * @generated
	 */
	int DIFFERENT_BINDING_SIZE = 16;

	/**
	 * The feature id for the '<em><b>Old Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_BINDING_SIZE__OLD_BINDING = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_BINDING_SIZE__NEW_BINDING = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Difference Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Different Binding Size</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENT_BINDING_SIZE_FEATURE_COUNT = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl <em>Condition Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConditionViolation()
	 * @generated
	 */
	int CONDITION_VIOLATION = 17;

	/**
	 * The feature id for the '<em><b>Violated Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_VIOLATION__VIOLATED_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Violating Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_VIOLATION__VIOLATING_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Condition Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_VIOLATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl <em>Matching Negative Application Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMatchingNegativeApplicationCondition()
	 * @generated
	 */
	int MATCHING_NEGATIVE_APPLICATION_CONDITION = 18;

	/**
	 * The feature id for the '<em><b>Negative Application Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nac Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Matching Negative Application Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_NEGATIVE_APPLICATION_CONDITION_FEATURE_COUNT = OPERATION_CONTRACT_DIAGNOSTICS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.ViolationSeverity <em>Violation Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.ViolationSeverity
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolationSeverity()
	 * @generated
	 */
	int VIOLATION_SEVERITY = 19;

	/**
	 * The meta object id for the '{@link org.modelversioning.conflictreport.conflict.BindingSizeDifference <em>Binding Size Difference</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelversioning.conflictreport.conflict.BindingSizeDifference
	 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getBindingSizeDifference()
	 * @generated
	 */
	int BINDING_SIZE_DIFFERENCE = 20;


	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Conflict
	 * @generated
	 */
	EClass getConflict();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.Conflict#getLeftChange <em>Left Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Change</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Conflict#getLeftChange()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_LeftChange();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.Conflict#getRightChange <em>Right Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Change</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Conflict#getRightChange()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_RightChange();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.OverlappingChange <em>Overlapping Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Overlapping Change</em>'.
	 * @see org.modelversioning.conflictreport.conflict.OverlappingChange
	 * @generated
	 */
	EClass getOverlappingChange();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.MetamodelViolation <em>Metamodel Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel Violation</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MetamodelViolation
	 * @generated
	 */
	EClass getMetamodelViolation();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.MetamodelViolation#getViolatedConstraint <em>Violated Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Violated Constraint</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MetamodelViolation#getViolatedConstraint()
	 * @see #getMetamodelViolation()
	 * @generated
	 */
	EReference getMetamodelViolation_ViolatedConstraint();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.OperationContractViolation <em>Operation Contract Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Contract Violation</em>'.
	 * @see org.modelversioning.conflictreport.conflict.OperationContractViolation
	 * @generated
	 */
	EClass getOperationContractViolation();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.conflict.OperationContractViolation#getDiagnostics <em>Diagnostics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagnostics</em>'.
	 * @see org.modelversioning.conflictreport.conflict.OperationContractViolation#getDiagnostics()
	 * @see #getOperationContractViolation()
	 * @generated
	 */
	EReference getOperationContractViolation_Diagnostics();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.UpdateUpdate <em>Update Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Update</em>'.
	 * @see org.modelversioning.conflictreport.conflict.UpdateUpdate
	 * @generated
	 */
	EClass getUpdateUpdate();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.DeleteUpdate <em>Delete Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Update</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DeleteUpdate
	 * @generated
	 */
	EClass getDeleteUpdate();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.AddAdd <em>Add Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Add</em>'.
	 * @see org.modelversioning.conflictreport.conflict.AddAdd
	 * @generated
	 */
	EClass getAddAdd();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.conflict.Constraint#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl Expression</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Constraint#getOclExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_OclExpression();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.Violation <em>Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Violation</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Violation
	 * @generated
	 */
	EClass getViolation();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.conflict.Violation#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.modelversioning.conflictreport.conflict.Violation#getSeverity()
	 * @see #getViolation()
	 * @generated
	 */
	EAttribute getViolation_Severity();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.DeleteUse <em>Delete Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Use</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DeleteUse
	 * @generated
	 */
	EClass getDeleteUse();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.DeleteMove <em>Delete Move</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Move</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DeleteMove
	 * @generated
	 */
	EClass getDeleteMove();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.MoveMove <em>Move Move</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move Move</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MoveMove
	 * @generated
	 */
	EClass getMoveMove();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.DiagramViolation <em>Diagram Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Violation</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DiagramViolation
	 * @generated
	 */
	EClass getDiagramViolation();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.DiagramViolation#getViolatedConstraint <em>Violated Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Violated Constraint</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DiagramViolation#getViolatedConstraint()
	 * @see #getDiagramViolation()
	 * @generated
	 */
	EReference getDiagramViolation_ViolatedConstraint();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.OperationContractDiagnostics <em>Operation Contract Diagnostics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Contract Diagnostics</em>'.
	 * @see org.modelversioning.conflictreport.conflict.OperationContractDiagnostics
	 * @generated
	 */
	EClass getOperationContractDiagnostics();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.ViolatedPrecondition <em>Violated Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Violated Precondition</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ViolatedPrecondition
	 * @generated
	 */
	EClass getViolatedPrecondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelversioning.conflictreport.conflict.ViolatedPrecondition#getConditionViolations <em>Condition Violations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Condition Violations</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ViolatedPrecondition#getConditionViolations()
	 * @see #getViolatedPrecondition()
	 * @generated
	 */
	EReference getViolatedPrecondition_ConditionViolations();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.MissingObject <em>Missing Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Missing Object</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MissingObject
	 * @generated
	 */
	EClass getMissingObject();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.MissingObject#getMissingObject <em>Missing Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Missing Object</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MissingObject#getMissingObject()
	 * @see #getMissingObject()
	 * @generated
	 */
	EReference getMissingObject_MissingObject();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.MissingObject#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MissingObject#getTemplate()
	 * @see #getMissingObject()
	 * @generated
	 */
	EReference getMissingObject_Template();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize <em>Different Binding Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Different Binding Size</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DifferentBindingSize
	 * @generated
	 */
	EClass getDifferentBindingSize();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getOldBinding <em>Old Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Old Binding</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DifferentBindingSize#getOldBinding()
	 * @see #getDifferentBindingSize()
	 * @generated
	 */
	EReference getDifferentBindingSize_OldBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getNewBinding <em>New Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Binding</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DifferentBindingSize#getNewBinding()
	 * @see #getDifferentBindingSize()
	 * @generated
	 */
	EReference getDifferentBindingSize_NewBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize#getDifferenceKind <em>Difference Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Difference Kind</em>'.
	 * @see org.modelversioning.conflictreport.conflict.DifferentBindingSize#getDifferenceKind()
	 * @see #getDifferentBindingSize()
	 * @generated
	 */
	EAttribute getDifferentBindingSize_DifferenceKind();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.ConditionViolation <em>Condition Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Violation</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ConditionViolation
	 * @generated
	 */
	EClass getConditionViolation();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatedCondition <em>Violated Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Violated Condition</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatedCondition()
	 * @see #getConditionViolation()
	 * @generated
	 */
	EReference getConditionViolation_ViolatedCondition();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatingObject <em>Violating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Violating Object</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ConditionViolation#getViolatingObject()
	 * @see #getConditionViolation()
	 * @generated
	 */
	EReference getConditionViolation_ViolatingObject();

	/**
	 * Returns the meta object for class '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition <em>Matching Negative Application Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matching Negative Application Condition</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition
	 * @generated
	 */
	EClass getMatchingNegativeApplicationCondition();

	/**
	 * Returns the meta object for the reference '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNegativeApplicationCondition <em>Negative Application Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Negative Application Condition</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNegativeApplicationCondition()
	 * @see #getMatchingNegativeApplicationCondition()
	 * @generated
	 */
	EReference getMatchingNegativeApplicationCondition_NegativeApplicationCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNacBinding <em>Nac Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nac Binding</em>'.
	 * @see org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition#getNacBinding()
	 * @see #getMatchingNegativeApplicationCondition()
	 * @generated
	 */
	EReference getMatchingNegativeApplicationCondition_NacBinding();

	/**
	 * Returns the meta object for enum '{@link org.modelversioning.conflictreport.conflict.ViolationSeverity <em>Violation Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Violation Severity</em>'.
	 * @see org.modelversioning.conflictreport.conflict.ViolationSeverity
	 * @generated
	 */
	EEnum getViolationSeverity();

	/**
	 * Returns the meta object for enum '{@link org.modelversioning.conflictreport.conflict.BindingSizeDifference <em>Binding Size Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Size Difference</em>'.
	 * @see org.modelversioning.conflictreport.conflict.BindingSizeDifference
	 * @generated
	 */
	EEnum getBindingSizeDifference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConflictFactory getConflictFactory();

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
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.ConflictImpl <em>Conflict</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConflict()
		 * @generated
		 */
		EClass CONFLICT = eINSTANCE.getConflict();

		/**
		 * The meta object literal for the '<em><b>Left Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__LEFT_CHANGE = eINSTANCE.getConflict_LeftChange();

		/**
		 * The meta object literal for the '<em><b>Right Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__RIGHT_CHANGE = eINSTANCE.getConflict_RightChange();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.OverlappingChangeImpl <em>Overlapping Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.OverlappingChangeImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOverlappingChange()
		 * @generated
		 */
		EClass OVERLAPPING_CHANGE = eINSTANCE.getOverlappingChange();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.MetamodelViolationImpl <em>Metamodel Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.MetamodelViolationImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMetamodelViolation()
		 * @generated
		 */
		EClass METAMODEL_VIOLATION = eINSTANCE.getMetamodelViolation();

		/**
		 * The meta object literal for the '<em><b>Violated Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METAMODEL_VIOLATION__VIOLATED_CONSTRAINT = eINSTANCE.getMetamodelViolation_ViolatedConstraint();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.OperationContractViolationImpl <em>Operation Contract Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.OperationContractViolationImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOperationContractViolation()
		 * @generated
		 */
		EClass OPERATION_CONTRACT_VIOLATION = eINSTANCE.getOperationContractViolation();

		/**
		 * The meta object literal for the '<em><b>Diagnostics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CONTRACT_VIOLATION__DIAGNOSTICS = eINSTANCE.getOperationContractViolation_Diagnostics();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.UpdateUpdateImpl <em>Update Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.UpdateUpdateImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getUpdateUpdate()
		 * @generated
		 */
		EClass UPDATE_UPDATE = eINSTANCE.getUpdateUpdate();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteUpdateImpl <em>Delete Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.DeleteUpdateImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteUpdate()
		 * @generated
		 */
		EClass DELETE_UPDATE = eINSTANCE.getDeleteUpdate();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.AddAddImpl <em>Add Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.AddAddImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getAddAdd()
		 * @generated
		 */
		EClass ADD_ADD = eINSTANCE.getAddAdd();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.ConstraintImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__OCL_EXPRESSION = eINSTANCE.getConstraint_OclExpression();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.ViolationImpl <em>Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.ViolationImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolation()
		 * @generated
		 */
		EClass VIOLATION = eINSTANCE.getViolation();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIOLATION__SEVERITY = eINSTANCE.getViolation_Severity();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteUseImpl <em>Delete Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.DeleteUseImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteUse()
		 * @generated
		 */
		EClass DELETE_USE = eINSTANCE.getDeleteUse();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.DeleteMoveImpl <em>Delete Move</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.DeleteMoveImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDeleteMove()
		 * @generated
		 */
		EClass DELETE_MOVE = eINSTANCE.getDeleteMove();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.MoveMoveImpl <em>Move Move</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.MoveMoveImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMoveMove()
		 * @generated
		 */
		EClass MOVE_MOVE = eINSTANCE.getMoveMove();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.DiagramViolationImpl <em>Diagram Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.DiagramViolationImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDiagramViolation()
		 * @generated
		 */
		EClass DIAGRAM_VIOLATION = eINSTANCE.getDiagramViolation();

		/**
		 * The meta object literal for the '<em><b>Violated Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_VIOLATION__VIOLATED_CONSTRAINT = eINSTANCE.getDiagramViolation_ViolatedConstraint();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.OperationContractDiagnosticsImpl <em>Operation Contract Diagnostics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.OperationContractDiagnosticsImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getOperationContractDiagnostics()
		 * @generated
		 */
		EClass OPERATION_CONTRACT_DIAGNOSTICS = eINSTANCE.getOperationContractDiagnostics();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.ViolatedPreconditionImpl <em>Violated Precondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.ViolatedPreconditionImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolatedPrecondition()
		 * @generated
		 */
		EClass VIOLATED_PRECONDITION = eINSTANCE.getViolatedPrecondition();

		/**
		 * The meta object literal for the '<em><b>Condition Violations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIOLATED_PRECONDITION__CONDITION_VIOLATIONS = eINSTANCE.getViolatedPrecondition_ConditionViolations();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.MissingObjectImpl <em>Missing Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.MissingObjectImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMissingObject()
		 * @generated
		 */
		EClass MISSING_OBJECT = eINSTANCE.getMissingObject();

		/**
		 * The meta object literal for the '<em><b>Missing Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSING_OBJECT__MISSING_OBJECT = eINSTANCE.getMissingObject_MissingObject();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSING_OBJECT__TEMPLATE = eINSTANCE.getMissingObject_Template();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl <em>Different Binding Size</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.DifferentBindingSizeImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getDifferentBindingSize()
		 * @generated
		 */
		EClass DIFFERENT_BINDING_SIZE = eINSTANCE.getDifferentBindingSize();

		/**
		 * The meta object literal for the '<em><b>Old Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENT_BINDING_SIZE__OLD_BINDING = eINSTANCE.getDifferentBindingSize_OldBinding();

		/**
		 * The meta object literal for the '<em><b>New Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENT_BINDING_SIZE__NEW_BINDING = eINSTANCE.getDifferentBindingSize_NewBinding();

		/**
		 * The meta object literal for the '<em><b>Difference Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENT_BINDING_SIZE__DIFFERENCE_KIND = eINSTANCE.getDifferentBindingSize_DifferenceKind();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl <em>Condition Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.ConditionViolationImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getConditionViolation()
		 * @generated
		 */
		EClass CONDITION_VIOLATION = eINSTANCE.getConditionViolation();

		/**
		 * The meta object literal for the '<em><b>Violated Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_VIOLATION__VIOLATED_CONDITION = eINSTANCE.getConditionViolation_ViolatedCondition();

		/**
		 * The meta object literal for the '<em><b>Violating Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_VIOLATION__VIOLATING_OBJECT = eINSTANCE.getConditionViolation_ViolatingObject();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl <em>Matching Negative Application Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.impl.MatchingNegativeApplicationConditionImpl
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getMatchingNegativeApplicationCondition()
		 * @generated
		 */
		EClass MATCHING_NEGATIVE_APPLICATION_CONDITION = eINSTANCE.getMatchingNegativeApplicationCondition();

		/**
		 * The meta object literal for the '<em><b>Negative Application Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING_NEGATIVE_APPLICATION_CONDITION__NEGATIVE_APPLICATION_CONDITION = eINSTANCE.getMatchingNegativeApplicationCondition_NegativeApplicationCondition();

		/**
		 * The meta object literal for the '<em><b>Nac Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCHING_NEGATIVE_APPLICATION_CONDITION__NAC_BINDING = eINSTANCE.getMatchingNegativeApplicationCondition_NacBinding();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.ViolationSeverity <em>Violation Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.ViolationSeverity
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getViolationSeverity()
		 * @generated
		 */
		EEnum VIOLATION_SEVERITY = eINSTANCE.getViolationSeverity();

		/**
		 * The meta object literal for the '{@link org.modelversioning.conflictreport.conflict.BindingSizeDifference <em>Binding Size Difference</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelversioning.conflictreport.conflict.BindingSizeDifference
		 * @see org.modelversioning.conflictreport.conflict.impl.ConflictPackageImpl#getBindingSizeDifference()
		 * @generated
		 */
		EEnum BINDING_SIZE_DIFFERENCE = eINSTANCE.getBindingSizeDifference();

	}

} //ConflictPackage
