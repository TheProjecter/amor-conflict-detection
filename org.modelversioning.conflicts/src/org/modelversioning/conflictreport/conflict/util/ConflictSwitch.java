/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.modelversioning.conflictreport.conflict.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage
 * @generated
 */
public class ConflictSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConflictPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictSwitch() {
		if (modelPackage == null) {
			modelPackage = ConflictPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConflictPackage.CONFLICT: {
				Conflict conflict = (Conflict)theEObject;
				T result = caseConflict(conflict);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.OVERLAPPING_CHANGE: {
				OverlappingChange overlappingChange = (OverlappingChange)theEObject;
				T result = caseOverlappingChange(overlappingChange);
				if (result == null) result = caseConflict(overlappingChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.METAMODEL_VIOLATION: {
				MetamodelViolation metamodelViolation = (MetamodelViolation)theEObject;
				T result = caseMetamodelViolation(metamodelViolation);
				if (result == null) result = caseViolation(metamodelViolation);
				if (result == null) result = caseConflict(metamodelViolation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.OPERATION_CONTRACT_VIOLATION: {
				OperationContractViolation operationContractViolation = (OperationContractViolation)theEObject;
				T result = caseOperationContractViolation(operationContractViolation);
				if (result == null) result = caseViolation(operationContractViolation);
				if (result == null) result = caseConflict(operationContractViolation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.UPDATE_UPDATE: {
				UpdateUpdate updateUpdate = (UpdateUpdate)theEObject;
				T result = caseUpdateUpdate(updateUpdate);
				if (result == null) result = caseOverlappingChange(updateUpdate);
				if (result == null) result = caseConflict(updateUpdate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.DELETE_UPDATE: {
				DeleteUpdate deleteUpdate = (DeleteUpdate)theEObject;
				T result = caseDeleteUpdate(deleteUpdate);
				if (result == null) result = caseOverlappingChange(deleteUpdate);
				if (result == null) result = caseConflict(deleteUpdate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.ADD_ADD: {
				AddAdd addAdd = (AddAdd)theEObject;
				T result = caseAddAdd(addAdd);
				if (result == null) result = caseOverlappingChange(addAdd);
				if (result == null) result = caseConflict(addAdd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.VIOLATION: {
				Violation violation = (Violation)theEObject;
				T result = caseViolation(violation);
				if (result == null) result = caseConflict(violation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.DELETE_USE: {
				DeleteUse deleteUse = (DeleteUse)theEObject;
				T result = caseDeleteUse(deleteUse);
				if (result == null) result = caseOverlappingChange(deleteUse);
				if (result == null) result = caseConflict(deleteUse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.DELETE_MOVE: {
				DeleteMove deleteMove = (DeleteMove)theEObject;
				T result = caseDeleteMove(deleteMove);
				if (result == null) result = caseDeleteUse(deleteMove);
				if (result == null) result = caseOverlappingChange(deleteMove);
				if (result == null) result = caseConflict(deleteMove);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.MOVE_MOVE: {
				MoveMove moveMove = (MoveMove)theEObject;
				T result = caseMoveMove(moveMove);
				if (result == null) result = caseUpdateUpdate(moveMove);
				if (result == null) result = caseOverlappingChange(moveMove);
				if (result == null) result = caseConflict(moveMove);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.DIAGRAM_VIOLATION: {
				DiagramViolation diagramViolation = (DiagramViolation)theEObject;
				T result = caseDiagramViolation(diagramViolation);
				if (result == null) result = caseViolation(diagramViolation);
				if (result == null) result = caseConflict(diagramViolation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.OPERATION_CONTRACT_DIAGNOSTICS: {
				OperationContractDiagnostics operationContractDiagnostics = (OperationContractDiagnostics)theEObject;
				T result = caseOperationContractDiagnostics(operationContractDiagnostics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.VIOLATED_PRECONDITION: {
				ViolatedPrecondition violatedPrecondition = (ViolatedPrecondition)theEObject;
				T result = caseViolatedPrecondition(violatedPrecondition);
				if (result == null) result = caseOperationContractDiagnostics(violatedPrecondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.MISSING_OBJECT: {
				MissingObject missingObject = (MissingObject)theEObject;
				T result = caseMissingObject(missingObject);
				if (result == null) result = caseOperationContractDiagnostics(missingObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.DIFFERENT_BINDING_SIZE: {
				DifferentBindingSize differentBindingSize = (DifferentBindingSize)theEObject;
				T result = caseDifferentBindingSize(differentBindingSize);
				if (result == null) result = caseOperationContractDiagnostics(differentBindingSize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.CONDITION_VIOLATION: {
				ConditionViolation conditionViolation = (ConditionViolation)theEObject;
				T result = caseConditionViolation(conditionViolation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.MATCHING_NEGATIVE_APPLICATION_CONDITION: {
				MatchingNegativeApplicationCondition matchingNegativeApplicationCondition = (MatchingNegativeApplicationCondition)theEObject;
				T result = caseMatchingNegativeApplicationCondition(matchingNegativeApplicationCondition);
				if (result == null) result = caseOperationContractDiagnostics(matchingNegativeApplicationCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.SIGNIFIER_WARNINGS: {
				SignifierWarnings signifierWarnings = (SignifierWarnings)theEObject;
				T result = caseSignifierWarnings(signifierWarnings);
				if (result == null) result = caseConflict(signifierWarnings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.UNEXPECTED_SIGNIFIER_MATCH: {
				UnexpectedSignifierMatch unexpectedSignifierMatch = (UnexpectedSignifierMatch)theEObject;
				T result = caseUnexpectedSignifierMatch(unexpectedSignifierMatch);
				if (result == null) result = caseSignifierWarnings(unexpectedSignifierMatch);
				if (result == null) result = caseConflict(unexpectedSignifierMatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConflictPackage.CONCURRENT_SIGNIFIER_CHANGE: {
				ConcurrentSignifierChange concurrentSignifierChange = (ConcurrentSignifierChange)theEObject;
				T result = caseConcurrentSignifierChange(concurrentSignifierChange);
				if (result == null) result = caseSignifierWarnings(concurrentSignifierChange);
				if (result == null) result = caseConflict(concurrentSignifierChange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conflict</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConflict(Conflict object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overlapping Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overlapping Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverlappingChange(OverlappingChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelViolation(MetamodelViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Contract Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Contract Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationContractViolation(OperationContractViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Update</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateUpdate(UpdateUpdate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Update</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteUpdate(DeleteUpdate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Add</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Add</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddAdd(AddAdd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViolation(Violation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteUse(DeleteUse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Move</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Move</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteMove(DeleteMove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Move Move</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move Move</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoveMove(MoveMove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramViolation(DiagramViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Contract Diagnostics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Contract Diagnostics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationContractDiagnostics(OperationContractDiagnostics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Violated Precondition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Violated Precondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViolatedPrecondition(ViolatedPrecondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Missing Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Missing Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMissingObject(MissingObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Different Binding Size</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Different Binding Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDifferentBindingSize(DifferentBindingSize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionViolation(ConditionViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matching Negative Application Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matching Negative Application Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchingNegativeApplicationCondition(MatchingNegativeApplicationCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signifier Warnings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signifier Warnings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignifierWarnings(SignifierWarnings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unexpected Signifier Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unexpected Signifier Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnexpectedSignifierMatch(UnexpectedSignifierMatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concurrent Signifier Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concurrent Signifier Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcurrentSignifierChange(ConcurrentSignifierChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ConflictSwitch
