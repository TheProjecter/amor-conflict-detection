/**
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.conflictreport.conflict.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelversioning.conflictreport.conflict.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelversioning.conflictreport.conflict.ConflictPackage
 * @generated
 */
public class ConflictAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConflictPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConflictPackage.eINSTANCE;
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
	protected ConflictSwitch<Adapter> modelSwitch =
		new ConflictSwitch<Adapter>() {
			@Override
			public Adapter caseConflict(Conflict object) {
				return createConflictAdapter();
			}
			@Override
			public Adapter caseOverlappingChange(OverlappingChange object) {
				return createOverlappingChangeAdapter();
			}
			@Override
			public Adapter caseMetamodelViolation(MetamodelViolation object) {
				return createMetamodelViolationAdapter();
			}
			@Override
			public Adapter caseOperationContractViolation(OperationContractViolation object) {
				return createOperationContractViolationAdapter();
			}
			@Override
			public Adapter caseUpdateUpdate(UpdateUpdate object) {
				return createUpdateUpdateAdapter();
			}
			@Override
			public Adapter caseDeleteUpdate(DeleteUpdate object) {
				return createDeleteUpdateAdapter();
			}
			@Override
			public Adapter caseAddAdd(AddAdd object) {
				return createAddAddAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseViolation(Violation object) {
				return createViolationAdapter();
			}
			@Override
			public Adapter caseDeleteUse(DeleteUse object) {
				return createDeleteUseAdapter();
			}
			@Override
			public Adapter caseDeleteMove(DeleteMove object) {
				return createDeleteMoveAdapter();
			}
			@Override
			public Adapter caseMoveMove(MoveMove object) {
				return createMoveMoveAdapter();
			}
			@Override
			public Adapter caseDiagramViolation(DiagramViolation object) {
				return createDiagramViolationAdapter();
			}
			@Override
			public Adapter caseOperationContractDiagnostics(OperationContractDiagnostics object) {
				return createOperationContractDiagnosticsAdapter();
			}
			@Override
			public Adapter caseViolatedPrecondition(ViolatedPrecondition object) {
				return createViolatedPreconditionAdapter();
			}
			@Override
			public Adapter caseMissingObject(MissingObject object) {
				return createMissingObjectAdapter();
			}
			@Override
			public Adapter caseDifferentBindingSize(DifferentBindingSize object) {
				return createDifferentBindingSizeAdapter();
			}
			@Override
			public Adapter caseConditionViolation(ConditionViolation object) {
				return createConditionViolationAdapter();
			}
			@Override
			public Adapter caseMatchingNegativeApplicationCondition(MatchingNegativeApplicationCondition object) {
				return createMatchingNegativeApplicationConditionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.Conflict
	 * @generated
	 */
	public Adapter createConflictAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.OverlappingChange <em>Overlapping Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.OverlappingChange
	 * @generated
	 */
	public Adapter createOverlappingChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.MetamodelViolation <em>Metamodel Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.MetamodelViolation
	 * @generated
	 */
	public Adapter createMetamodelViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.OperationContractViolation <em>Operation Contract Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.OperationContractViolation
	 * @generated
	 */
	public Adapter createOperationContractViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.UpdateUpdate <em>Update Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.UpdateUpdate
	 * @generated
	 */
	public Adapter createUpdateUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.DeleteUpdate <em>Delete Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.DeleteUpdate
	 * @generated
	 */
	public Adapter createDeleteUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.AddAdd <em>Add Add</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.AddAdd
	 * @generated
	 */
	public Adapter createAddAddAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.Violation <em>Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.Violation
	 * @generated
	 */
	public Adapter createViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.DeleteUse <em>Delete Use</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.DeleteUse
	 * @generated
	 */
	public Adapter createDeleteUseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.DeleteMove <em>Delete Move</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.DeleteMove
	 * @generated
	 */
	public Adapter createDeleteMoveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.MoveMove <em>Move Move</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.MoveMove
	 * @generated
	 */
	public Adapter createMoveMoveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.DiagramViolation <em>Diagram Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.DiagramViolation
	 * @generated
	 */
	public Adapter createDiagramViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.OperationContractDiagnostics <em>Operation Contract Diagnostics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.OperationContractDiagnostics
	 * @generated
	 */
	public Adapter createOperationContractDiagnosticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.ViolatedPrecondition <em>Violated Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.ViolatedPrecondition
	 * @generated
	 */
	public Adapter createViolatedPreconditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.MissingObject <em>Missing Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.MissingObject
	 * @generated
	 */
	public Adapter createMissingObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.DifferentBindingSize <em>Different Binding Size</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.DifferentBindingSize
	 * @generated
	 */
	public Adapter createDifferentBindingSizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.ConditionViolation <em>Condition Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.ConditionViolation
	 * @generated
	 */
	public Adapter createConditionViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition <em>Matching Negative Application Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition
	 * @generated
	 */
	public Adapter createMatchingNegativeApplicationConditionAdapter() {
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

} //ConflictAdapterFactory
