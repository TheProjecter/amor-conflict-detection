/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage
 * @generated
 */
public interface ConflictFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConflictFactory eINSTANCE = org.modelversioning.conflictreport.conflict.impl.ConflictFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Metamodel Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel Violation</em>'.
	 * @generated
	 */
	MetamodelViolation createMetamodelViolation();

	/**
	 * Returns a new object of class '<em>Operation Contract Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Contract Violation</em>'.
	 * @generated
	 */
	OperationContractViolation createOperationContractViolation();

	/**
	 * Returns a new object of class '<em>Update Update</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Update</em>'.
	 * @generated
	 */
	UpdateUpdate createUpdateUpdate();

	/**
	 * Returns a new object of class '<em>Delete Update</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Update</em>'.
	 * @generated
	 */
	DeleteUpdate createDeleteUpdate();

	/**
	 * Returns a new object of class '<em>Add Add</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Add</em>'.
	 * @generated
	 */
	AddAdd createAddAdd();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Delete Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Use</em>'.
	 * @generated
	 */
	DeleteUse createDeleteUse();

	/**
	 * Returns a new object of class '<em>Delete Move</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Move</em>'.
	 * @generated
	 */
	DeleteMove createDeleteMove();

	/**
	 * Returns a new object of class '<em>Move Move</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move Move</em>'.
	 * @generated
	 */
	MoveMove createMoveMove();

	/**
	 * Returns a new object of class '<em>Diagram Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Violation</em>'.
	 * @generated
	 */
	DiagramViolation createDiagramViolation();

	/**
	 * Returns a new object of class '<em>Violated Precondition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Violated Precondition</em>'.
	 * @generated
	 */
	ViolatedPrecondition createViolatedPrecondition();

	/**
	 * Returns a new object of class '<em>Missing Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Missing Object</em>'.
	 * @generated
	 */
	MissingObject createMissingObject();

	/**
	 * Returns a new object of class '<em>Different Binding Size</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Different Binding Size</em>'.
	 * @generated
	 */
	DifferentBindingSize createDifferentBindingSize();

	/**
	 * Returns a new object of class '<em>Condition Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Violation</em>'.
	 * @generated
	 */
	ConditionViolation createConditionViolation();

	/**
	 * Returns a new object of class '<em>Matching Negative Application Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matching Negative Application Condition</em>'.
	 * @generated
	 */
	MatchingNegativeApplicationCondition createMatchingNegativeApplicationCondition();

	/**
	 * Returns a new object of class '<em>Unexpected Signifier Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unexpected Signifier Match</em>'.
	 * @generated
	 */
	UnexpectedSignifierMatch createUnexpectedSignifierMatch();

	/**
	 * Returns a new object of class '<em>Concurrent Signifier Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concurrent Signifier Change</em>'.
	 * @generated
	 */
	ConcurrentSignifierChange createConcurrentSignifierChange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConflictPackage getConflictPackage();

} //ConflictFactory
