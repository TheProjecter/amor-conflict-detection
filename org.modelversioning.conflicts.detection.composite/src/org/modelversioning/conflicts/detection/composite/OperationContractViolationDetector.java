/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.conflicts.detection.composite;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.BindingSizeDifference;
import org.modelversioning.conflictreport.conflict.ConditionViolation;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictFactory;
import org.modelversioning.conflictreport.conflict.DifferentBindingSize;
import org.modelversioning.conflictreport.conflict.MatchingNegativeApplicationCondition;
import org.modelversioning.conflictreport.conflict.MissingObject;
import org.modelversioning.conflictreport.conflict.OperationContractDiagnostics;
import org.modelversioning.conflictreport.conflict.OperationContractViolation;
import org.modelversioning.conflictreport.conflict.ViolatedPrecondition;
import org.modelversioning.conflictreport.conflict.ViolationSeverity;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;
import org.modelversioning.core.conditions.Condition;
import org.modelversioning.core.conditions.ConditionsModel;
import org.modelversioning.core.conditions.EvaluationResult;
import org.modelversioning.core.conditions.FeatureCondition;
import org.modelversioning.core.conditions.RefinementTemplate;
import org.modelversioning.core.conditions.Template;
import org.modelversioning.core.conditions.engines.ITemplateBinding;
import org.modelversioning.core.conditions.engines.ITemplateBindings;
import org.modelversioning.core.conditions.engines.UnsupportedConditionLanguage;
import org.modelversioning.core.conditions.engines.impl.TemplateBindingImpl;
import org.modelversioning.core.conditions.engines.impl.TemplateBindingsImpl;
import org.modelversioning.core.conditions.templatebindings.TemplateBinding;
import org.modelversioning.core.conditions.templatebindings.TemplateBindingCollection;
import org.modelversioning.core.conditions.templatebindings.util.TemplateBindingsUtil;
import org.modelversioning.core.conditions.util.ConditionsUtil;
import org.modelversioning.operations.NegativeApplicationCondition;
import org.modelversioning.operations.NegativeApplicationConditionResult;
import org.modelversioning.operations.OperationSpecification;
import org.modelversioning.operations.detection.operationoccurrence.OperationOccurrence;
import org.modelversioning.operations.execution.IOperationBinding;
import org.modelversioning.operations.execution.engines.IOperationBindingGenerator;
import org.modelversioning.operations.execution.engines.impl.OperationBindingGeneratorImpl;
import org.modelversioning.operations.util.OperationsUtil;

/**
 * Detector for detecting {@link OperationContractViolation operation contract
 * violations}.
 * 
 * <p>
 * {@link OperationContractViolation Operation contract violations} occur if the
 * precondition binding of an applied operation ...
 * </p>
 * <ul>
 * <li>does not match anymore, that is, at least one object that was originally
 * bound to a template does either not match anymore or is missing (has been
 * deleted).</li>
 * <li>is bigger than the original one, that is, all originally bound objects
 * are valid, but objects that have not originally been unselected are now
 * matching to iterated templates.</li>
 * </ul>
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class OperationContractViolationDetector implements
		IOperationConflictDetector {

	/**
	 * Thrown if an object is missing for creating a complete binding.
	 * 
	 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
	 * 
	 */
	private class MissingObjectsForBindingException extends Exception {

		/** generated serial id. */
		private static final long serialVersionUID = -2252862119466955186L;

		/** The missing objects. */
		private Map<Template, EList<EObject>> missingObject = new HashMap<Template, EList<EObject>>();

		/**
		 * Creates a new exception for the specified {@code missingObjects}.
		 * 
		 * @param missingObjects
		 *            the missing object map.
		 */
		protected MissingObjectsForBindingException(
				Map<Template, EList<EObject>> missingObjects) {
			this.missingObject = missingObjects;
		}

		/**
		 * Returns the missing {@link EObject objects} map.
		 * 
		 * @return the missing objects map.
		 */
		protected Map<Template, EList<EObject>> getMissingObjects() {
			return missingObject;
		}
	}

	/**
	 * Thrown if an {@link IOperationBinding} is not valid.
	 * 
	 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
	 * 
	 */
	private class InvalidOperationBindingException extends Exception {

		/** generated serial id. */
		private static final long serialVersionUID = -1112982653808286644L;

		/** The invalid operation binding. */
		private IOperationBinding operationBinding;

		/**
		 * Creates a new exception for the specified invalid
		 * {@code operationBinding}.
		 * 
		 * @param operationBinding
		 *            the invalid operation binding.
		 */
		protected InvalidOperationBindingException(
				IOperationBinding operationBinding) {
			super();
			this.operationBinding = operationBinding;
		}

	}

	/**
	 * Thrown if actively unselected bindings could not been removed from all
	 * bindings.
	 * 
	 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
	 * 
	 */
	private class UnselectBindingsFailedException extends Exception {

		/** generated serial id. */
		private static final long serialVersionUID = 8813757100547429989L;

		/**
		 * Binding from which {@link #unselectedBindingMap} could not be
		 * removed.
		 */
		@SuppressWarnings("unused")
		private ITemplateBindings allBindings;

		/** Binding that could not be removed from {@link #allBindings}. */
		@SuppressWarnings("unused")
		private ITemplateBinding unselectedBinding;

		private ITemplateBindings originalRewiredBinding;

		/**
		 * Creates a new exception specifying {@code allBindings} from which
		 * {@code unselectedBinding} could not be removed.
		 * 
		 * @param allBindings
		 *            Binding from which {@link #unselectedBindingMap} could not
		 *            be removed.
		 * @param unselectedBinding
		 *            Binding that could not be removed from
		 *            {@link #allBindings}.
		 * @param originalRewiredBinding
		 *            the original rewired template binding.
		 */
		protected UnselectBindingsFailedException(
				ITemplateBindings allBindings,
				ITemplateBinding unselectedBinding,
				ITemplateBindings originalRewiredBinding) {
			super();
			this.allBindings = allBindings;
			this.unselectedBinding = unselectedBinding;
			this.originalRewiredBinding = originalRewiredBinding;
		}

		/**
		 * Returns the original rewired binding.
		 * 
		 * @return the original rewired binding
		 */
		protected ITemplateBindings getOriginalRewiredBinding() {
			return originalRewiredBinding;
		}

	}

	/** The operation binding generator to use. */
	IOperationBindingGenerator bindingGenerator;

	/**
	 * A map of operation occurrence to actively unselected bindings.
	 */
	private Map<OperationOccurrence, ITemplateBinding> unselectedBindingMap;

	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.deleteUse";
	}

	@Override
	public String getTargetModelNsURI() {
		return "*";
	}

	@Override
	public String getName() {
		return "Operation Contract Violation Detector";
	}

	@Override
	public void initialize() {
		// noop
	}

	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {
		detectOperationContractViolations(threeWayDiff, conflicts,
				equivalentChanges, monitor);
	}

	/**
	 * Returns the currently set {@link IOperationBindingGenerator}.
	 * 
	 * @return the currently set {@link IOperationBindingGenerator}.
	 */
	protected IOperationBindingGenerator getOperationBindingGenerator() {
		if (bindingGenerator == null) {
			bindingGenerator = new OperationBindingGeneratorImpl();
		}
		return bindingGenerator;
	}

	/**
	 * Sets the {@link IOperationBindingGenerator} to be used.
	 * 
	 * @param bindingGenerator
	 *            to use.
	 */
	protected void setOperationBindingGenerator(
			IOperationBindingGenerator bindingGenerator) {
		this.bindingGenerator = bindingGenerator;
	}

	/**
	 * Detects {@link OperationContractViolation operation contract violations}
	 * in the specified <code>threeWayDiff</code> and adds detected violations
	 * to the specified list of <code>conflicts</code>.
	 * 
	 * @param threeWayDiff
	 *            to search in for violations.
	 * @param conflicts
	 *            to add detected violations to.
	 * @param equivalentChanges
	 *            just for additional information.
	 * @param subProgressMonitor
	 *            to report progress to.
	 */
	public void detectOperationContractViolations(
			IThreeWayDiffProvider threeWayDiff, EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {

		// initialize map of unselected bindings
		unselectedBindingMap = new HashMap<OperationOccurrence, ITemplateBinding>();

		// retrieve operation occurrences
		Set<OperationOccurrence> leftOccurrences = getOperationOccurrences(threeWayDiff
				.getComparisonSnapshot(Side.LEFT));
		Set<OperationOccurrence> rightOccurrences = getOperationOccurrences(threeWayDiff
				.getComparisonSnapshot(Side.RIGHT));

		try {
			// derive binding that would be valid but that have been actively
			// unselected for each operation on both sides.
			fillUnselectedBindingMap(leftOccurrences);
			fillUnselectedBindingMap(rightOccurrences);

			// detect operation contract violations for occurrences left and
			// right
			doDetectOperationContractViolations(leftOccurrences, threeWayDiff,
					conflicts, Side.LEFT);
			doDetectOperationContractViolations(rightOccurrences, threeWayDiff,
					conflicts, Side.RIGHT);
		} catch (UnsupportedConditionLanguage e) {
			e.printStackTrace();
		}
	}

	/**
	 * Searches for {@link OperationContractViolation violations} and adds them
	 * to {@code conflicts}.
	 * 
	 * @param occurrences
	 *            to check.
	 * @param threeWayDiff
	 *            to use for matching and retrieving conflicting diff elements.
	 * @param conflicts
	 *            to add found violations to.
	 * @param side
	 *            the side to check.
	 * @throws UnsupportedConditionLanguage
	 *             if the condition evaluation could not be used due to unknown
	 *             condition language.
	 */
	private void doDetectOperationContractViolations(
			Set<OperationOccurrence> occurrences,
			IThreeWayDiffProvider threeWayDiff, EList<Conflict> conflicts,
			Side side) throws UnsupportedConditionLanguage {

		Side oppositeSide = getOppositeSide(side);

		for (OperationOccurrence occurrence : occurrences) {

			try {
				// rewire original binding to the opposite side
				ITemplateBindings rewiredTemplateBinding = rewireBinding(
						occurrence.getPreConditionBinding(), threeWayDiff,
						oppositeSide);

				// derive pre-binding from rewired binding
				ITemplateBinding preBinding = createFixedPreBinding(
						rewiredTemplateBinding,
						occurrence.getAppliedOperation());

				// generate operation binding from pre-binding
				IOperationBinding operationBinding = getOperationBindingGenerator()
						.generateOperationBinding(
								occurrence.getAppliedOperation(), preBinding);

				// check if binding is OK
				if (!operationBinding.validate().isOK()) {
					throw new InvalidOperationBindingException(operationBinding);
				}
				// note that it might only be OK because it contains originally
				// unselected bindings. these originally unselected bindings
				// will be removed and considered later.

				// remove originally unselected bindings from all possible
				// bindings so that only those are retained only those that were
				// originally selected and which are new.
				ITemplateBindings allPossibleBindings = operationBinding
						.getTemplateBinding();
				ITemplateBinding unselectedBinding = unselectedBindingMap
						.get(occurrence);
				removeUnselectedBindings(allPossibleBindings,
						unselectedBinding, rewiredTemplateBinding,
						threeWayDiff, oppositeSide);

				// compare original binding to new binding
				checkForDifferentBindingSize(allPossibleBindings,
						rewiredTemplateBinding, conflicts, occurrence, side);

			} catch (MissingObjectsForBindingException e) {
				handleMissingObjects(e.getMissingObjects(), occurrence,
						threeWayDiff, conflicts, side);
			} catch (InvalidOperationBindingException e) {
				handleInvalidOperationBinding(e.operationBinding, occurrence,
						threeWayDiff, conflicts, side);
			} catch (UnselectBindingsFailedException e) {
				// if it is not removable, the binding was
				// previously only ok because unselected
				// bindings made them ok. so we have a violated
				// precondition or matching NAC here.
				handleFailingUnselectionFromBinding(
						e.getOriginalRewiredBinding(), occurrence,
						threeWayDiff, conflicts, side);
			}
		}
	}

	/**
	 * Returns the opposite {@link Side} of the specified {@code side}.
	 * 
	 * @param side
	 *            to get opposite for.
	 * @return the opposite side.
	 */
	private Side getOppositeSide(Side side) {
		return Side.LEFT.equals(side) ? Side.RIGHT : Side.LEFT;
	}

	/**
	 * Handles cases in which the unselected bindings could not be removed from
	 * all possible binding due to matching {@link NegativeApplicationCondition}
	 * or failing pre-condition.
	 * 
	 * @param originalRewiredBinding
	 *            the original rewired template binding.
	 * @param occurrence
	 *            the operation occurrence.
	 * @param threeWayDiff
	 *            for guessing the causing opposite change.
	 * @param conflicts
	 *            the list of conflicts to add the violation to.
	 * @param side
	 *            the side on which the operation has been performed.
	 * @throws UnsupportedConditionLanguage
	 *             if the contition language is not supported.
	 */
	private void handleFailingUnselectionFromBinding(
			ITemplateBindings originalRewiredBinding,
			OperationOccurrence occurrence, IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts, Side side)
			throws UnsupportedConditionLanguage {
		IOperationBinding operationBinding = evaluateBindings(
				originalRewiredBinding, occurrence.getAppliedOperation());
		handleInvalidOperationBinding(operationBinding, occurrence,
				threeWayDiff, conflicts, side);
	}

	/**
	 * Handles cases of missing objects.
	 * 
	 * @param missingObjects
	 *            the missing objects.
	 * @param occurrence
	 *            the operation occurrence.
	 * @param threeWayDiff
	 *            for guessing the causing opposite change.
	 * @param conflicts
	 *            the list of conflicts to add the violation to.
	 * @param side
	 *            the side on which the operation has been performed.
	 */
	private void handleMissingObjects(
			Map<Template, EList<EObject>> missingObjects,
			OperationOccurrence occurrence, IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts, Side side) {
		MissingObject diagnostics = ConflictFactory.eINSTANCE
				.createMissingObject();
		Entry<Template, EList<EObject>> entry = missingObjects.entrySet()
				.iterator().next();
		diagnostics.setMissingObject(entry.getValue().get(0));
		diagnostics.setTemplate(entry.getKey());
		OperationContractViolation contractViolation = createOperationContractViolation(
				diagnostics, occurrence, side);

		Side oppositeSide = getOppositeSide(side);
		DiffElement diffElement = guessCausingChange(diagnostics, threeWayDiff,
				oppositeSide);
		if (diffElement != null) {
			if (Side.LEFT.equals(oppositeSide)) {
				contractViolation.setLeftChange(diffElement);
			} else {
				contractViolation.setRightChange(diffElement);
			}
		}
		conflicts.add(contractViolation);
	}

	/**
	 * Tries to guess the change for the specified {@link MissingObject}.
	 * 
	 * @param diagnostics
	 *            the missing objects diagnostics to guess for.
	 * @param threeWayDiff
	 *            the diff elements to search in.
	 * @param side
	 *            the side to search in.
	 * @return the causing change or <code>null</code> if it could not be found.
	 */
	private DiffElement guessCausingChange(MissingObject diagnostics,
			IThreeWayDiffProvider threeWayDiff, Side side) {
		return threeWayDiff.getDeleteElement(diagnostics.getMissingObject(),
				side);
	}

	/**
	 * Handles cases of invalid operation bindings.
	 * 
	 * <p>
	 * This method handles {@link IOperationBinding operation bindings} that are
	 * invalid due to a matching NAC or violated preconditions.
	 * </p>
	 * 
	 * @param operationBinding
	 *            the invalid binding to be handled.
	 * @param occurrence
	 *            the operation occurrence.
	 * @param threeWayDiff
	 *            for guessing the causing opposite change.
	 * @param conflicts
	 *            the list of conflicts to add the violation to.
	 * @param side
	 *            the side on which the operation has been performed.
	 */
	private void handleInvalidOperationBinding(
			IOperationBinding operationBinding, OperationOccurrence occurrence,
			IThreeWayDiffProvider threeWayDiff, EList<Conflict> conflicts,
			Side side) {
		// check if this binding is invalid due to NAC
		for (NegativeApplicationConditionResult nacResult : operationBinding
				.getNegativeApplicationConditionResults()) {
			if (!nacResult.isOK()) {
				conflicts.add(createMatchingNACDViolation(nacResult,
						occurrence, threeWayDiff, side));
				return;
			}
		}
		// since the operation binding is not invalid due to a matching NAC, it
		// must be that a precondition has been violated.
		EvaluationResult evaluationResult = operationBinding
				.getTemplateBinding().validate();
		conflicts.add(createViolatedPreconditionViolation(evaluationResult,
				occurrence, threeWayDiff, side));
	}

	/**
	 * Creates an {@link OperationContractViolation} for a failing precondition.
	 * The failing conditions are specified in the {@code evaluationResult}.
	 * 
	 * @param evaluationResult
	 *            containing the failing conditions.
	 * @param occurrence
	 *            the occurrence of the operation for which the preconditions
	 *            failed.
	 * @param threeWayDiff
	 *            the difference models.
	 * @param side
	 *            the side on which the operation has been performed.
	 * @return the created {@link OperationContractViolation}.
	 */
	private OperationContractViolation createViolatedPreconditionViolation(
			EvaluationResult evaluationResult, OperationOccurrence occurrence,
			IThreeWayDiffProvider threeWayDiff, Side side) {
		ViolatedPrecondition diagnostics = ConflictFactory.eINSTANCE
				.createViolatedPrecondition();
		for (EvaluationResult subResult : evaluationResult.getSubResults()) {
			if (subResult.getFailedCandidate() != null
					&& subResult.getFailedCondition() != null) {
				ConditionViolation conditionViolation = ConflictFactory.eINSTANCE
						.createConditionViolation();
				conditionViolation.setViolatedCondition(subResult
						.getFailedCondition());
				conditionViolation.setViolatingObject(subResult
						.getFailedCandidate());
				diagnostics.getConditionViolations().add(conditionViolation);
			}
		}
		OperationContractViolation contractViolation = createOperationContractViolation(
				diagnostics, occurrence, side);

		// try to guess causing change
		Side oppositeSide = getOppositeSide(side);
		DiffElement diffElement = guessCausingChange(diagnostics, occurrence,
				threeWayDiff, oppositeSide);
		if (diffElement != null) {
			if (Side.LEFT.equals(oppositeSide)) {
				contractViolation.setLeftChange(diffElement);
			} else {
				contractViolation.setRightChange(diffElement);
			}
		}

		return contractViolation;
	}

	/**
	 * Tries to guess the change for the specified {@link ViolatedPrecondition}.
	 * 
	 * @param diagnostics
	 *            to guess causing change for.
	 * @param occurrence
	 *            the occurrence.
	 * @param threeWayDiff
	 *            for searching causing diff element in.
	 * @param side
	 *            the side to search for.
	 * @return the found diff element or <code>null</code> if no causing diff
	 *         could be determined.
	 */
	private DiffElement guessCausingChange(ViolatedPrecondition diagnostics,
			OperationOccurrence occurrence, IThreeWayDiffProvider threeWayDiff,
			Side side) {
		for (ConditionViolation violation : diagnostics
				.getConditionViolations()) {
			Condition condition = violation.getViolatedCondition();
			EObject eObject = violation.getViolatingObject();
			EObject originalEObject = threeWayDiff.getMatchingEObject(eObject,
					side, true);
			if (originalEObject != null) {
				DiffElement causingDiff = guessCausingChangeForCondition(
						condition, originalEObject, occurrence, threeWayDiff,
						side);
				if (causingDiff != null) {
					return causingDiff;
				}
			}
		}
		return null;
	}

	/**
	 * Tries to guess the causing diff element for the specified
	 * {@code condition}.
	 * 
	 * @param condition
	 *            to check.
	 * @param originalEObject
	 *            the context object contained by the original model for the
	 *            condition.
	 * @param occurrence
	 *            the operation occurrence.
	 * @param threeWayDiff
	 *            the differences to search in.
	 * @param side
	 *            the side to search in.
	 * @return the guess for a causing diff or <code>null</code> if no good
	 *         guess is possible.
	 */
	private DiffElement guessCausingChangeForCondition(Condition condition,
			EObject originalEObject, OperationOccurrence occurrence,
			IThreeWayDiffProvider threeWayDiff, Side side) {
		// check if feature value of condition has been changed
		if (condition instanceof FeatureCondition) {
			FeatureCondition featureCondition = (FeatureCondition) condition;
			Set<DiffElement> updateElements = threeWayDiff.getUpdateElements(
					originalEObject, featureCondition.getFeature(), side);
			if (updateElements != null && updateElements.size() > 0) {
				return updateElements.iterator().next();
			}
		}

		// check referenced objects
		String expression = ConditionsUtil.getExpression(condition);
		Set<String> referencedTemplateNames = ConditionsUtil
				.getReferencedUnprefixedTemplateNames(expression);
		for (String referencedTemplateName : referencedTemplateNames) {
			List<EObject> boundObjects = getBoundObjects(
					referencedTemplateName, occurrence.getPreConditionBinding());
			Template referencedTemplate = ConditionsUtil.getTemplateByName(
					referencedTemplateName, occurrence.getAppliedOperation()
							.getPreconditions());
			Set<String> featureNames = ConditionsUtil
					.getReferencedFeatureNames(referencedTemplateName,
							expression);
			Set<EStructuralFeature> features = getFeaturesByName(featureNames,
					referencedTemplate);

			for (EObject boundObject : boundObjects) {
				// check if deleted
				ModelElementChange deleteElement = threeWayDiff
						.getDeleteElement(boundObject, side);
				if (deleteElement != null) {
					return deleteElement;
				}

				// check if changed
				for (EStructuralFeature feature : features) {
					Set<DiffElement> updateElements = threeWayDiff
							.getUpdateElements(boundObject, feature, side);
					if (updateElements != null && updateElements.size() > 0) {
						return updateElements.iterator().next();
					}

				}
			}

		}
		return null;
	}

	/**
	 * Returns a {@link Set} of {@link EStructuralFeature} for the specified
	 * {@code featureNames} in the context of the specified {@code template}.
	 * 
	 * @param featureNames
	 *            names of features to retrieve.
	 * @param template
	 *            the context.
	 * @return the set of found features.
	 */
	private Set<EStructuralFeature> getFeaturesByName(Set<String> featureNames,
			Template template) {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		for (String featureName : featureNames) {
			EStructuralFeature feature = getFeatureByName(featureName, template);
			if (feature != null) {
				features.add(feature);
			}
		}
		return features;
	}

	/**
	 * Returns the {@link EStructuralFeature} for the specified
	 * {@code featureName} in the context of the specified {@code template}.
	 * 
	 * @param featureName
	 *            name of features to retrieve.
	 * @param template
	 *            the context.
	 * @return the found feature or <code>null</code> if no corresponding
	 *         feature was found.
	 */
	private EStructuralFeature getFeatureByName(String featureName,
			Template template) {
		EList<EStructuralFeature> features = template.getRepresentative()
				.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (featureName.equals(feature.getName())) {
				return feature;
			}
		}
		return null;
	}

	/**
	 * Returns all objects bound to a template having the specified
	 * {@code templateName} in the specified {@code bindings}.
	 * 
	 * @param templateName
	 *            to search for.
	 * @param bindings
	 *            to search in.
	 * @return the bound objects or <code>null</code> if no object binding for
	 *         the specified template is available.
	 */
	private List<EObject> getBoundObjects(String templateName,
			TemplateBindingCollection bindings) {
		for (TemplateBinding binding : bindings.getBindings()) {
			if (templateName.equals(binding.getTemplateName())) {
				return binding.getEObjects();
			}
		}
		return null;
	}

	/**
	 * Creates an {@link OperationContractViolation} for a matching
	 * {@link NegativeApplicationCondition}.
	 * 
	 * @param nacResult
	 *            the {@link NegativeApplicationConditionResult} to create the
	 *            violation for.
	 * @param occurrence
	 *            the occurrence of the operation containing the matching
	 *            {@link NegativeApplicationCondition}.
	 * @param threeWayDiff
	 *            the difference models.
	 * @param side
	 *            the side on which the operation has been performed.
	 * @return the created {@link OperationContractViolation}.
	 */
	private OperationContractViolation createMatchingNACDViolation(
			NegativeApplicationConditionResult nacResult,
			OperationOccurrence occurrence, IThreeWayDiffProvider threeWayDiff,
			Side side) {
		MatchingNegativeApplicationCondition diagnostics = ConflictFactory.eINSTANCE
				.createMatchingNegativeApplicationCondition();
		diagnostics.setNegativeApplicationCondition(nacResult
				.getNegativeApplicationCondition());
		diagnostics.setNacBinding(nacResult.getBinding());
		OperationContractViolation contractViolation = createOperationContractViolation(
				diagnostics, occurrence, side);

		Side oppositeSide = getOppositeSide(side);
		DiffElement diffElement = guessCausingChange(diagnostics, occurrence,
				threeWayDiff, oppositeSide);
		if (diffElement != null) {
			if (Side.LEFT.equals(oppositeSide)) {
				contractViolation.setLeftChange(diffElement);
			} else {
				contractViolation.setRightChange(diffElement);
			}
		}
		return contractViolation;
	}

	/**
	 * Tries to guess the change for the specified {@link ViolatedPrecondition}.
	 * 
	 * @param diagnostics
	 *            to guess causing change for.
	 * @param occurrence
	 *            the occurrence.
	 * @param threeWayDiff
	 *            for searching causing diff element in.
	 * @param side
	 *            the side to search for.
	 * @return the found diff element or <code>null</code> if no causing diff
	 *         could be determined.
	 */
	private DiffElement guessCausingChange(
			MatchingNegativeApplicationCondition diagnostics,
			OperationOccurrence occurrence, IThreeWayDiffProvider threeWayDiff,
			Side side) {
		ConditionsModel nacConditionsModel = diagnostics
				.getNegativeApplicationCondition().getConditions();

		// find NAC templates and check if bound objects have been added
		for (Template nacTemplate : getNACTemplates(nacConditionsModel)) {
			List<EObject> boundObjects = getBoundObjects(nacTemplate.getName(),
					diagnostics.getNacBinding());
			if (boundObjects == null)
				continue;
			for (EObject boundObject : boundObjects) {
				ModelElementChange addElement = threeWayDiff.getAddElement(
						boundObject, side);
				if (addElement != null) {
					return addElement;
				}
			}
		}

		// check all other NAC conditions
		for (Template template : ConditionsUtil
				.getAllTemplates(nacConditionsModel)) {
			List<EObject> boundObjects = getBoundObjects(template.getName(),
					diagnostics.getNacBinding());
			for (Condition condition : template.getSpecifications()) {
				for (EObject boundObject : boundObjects) {
					EObject originalEObject = threeWayDiff.getMatchingEObject(
							boundObject, side, true);
					DiffElement causingDiff = guessCausingChangeForCondition(
							condition, originalEObject, occurrence,
							threeWayDiff, side);
					if (causingDiff != null) {
						return causingDiff;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Returns all NAC templates, i.e., templates which are not refinement
	 * templates.
	 * 
	 * @param nacConditionsModel
	 *            to search in.
	 * @return a set of all NAC templates.
	 */
	private Set<Template> getNACTemplates(ConditionsModel nacConditionsModel) {
		Set<Template> nacTemplates = new HashSet<Template>();
		for (Template template : ConditionsUtil
				.getAllTemplates(nacConditionsModel)) {
			if (!(template instanceof RefinementTemplate)) {
				nacTemplates.add(template);
			}
		}
		return nacTemplates;
	}

	/**
	 * Checks whether there is the need to raise a {@link DifferentBindingSize}
	 * violation for the {@code bindings} with respect to the
	 * {@code originalBindings}.
	 * 
	 * If such a violation is detected, this method will add a violation to
	 * {@code conflicts}.
	 * 
	 * @param bindings
	 *            to check.
	 * @param originalBindings
	 *            to check against.
	 * @param conflicts
	 *            to add violation to in case.
	 * @param side
	 *            in which the operation occurrence has been detected.
	 * @param occurrence
	 *            the occurrence is needed in case a violation is reported.
	 */
	private void checkForDifferentBindingSize(ITemplateBindings bindings,
			ITemplateBindings originalBindings, EList<Conflict> conflicts,
			OperationOccurrence occurrence, Side side) {
		boolean foundToBeBigger = false;
		boolean foundToBeSmaller = false;
		for (Template template : bindings.getTemplates()) {
			Set<EObject> originalObjects = new HashSet<EObject>(
					originalBindings.getBoundObjects(template));
			Set<EObject> newObjects = new HashSet<EObject>(
					bindings.getBoundObjects(template));
			for (EObject originalObject : originalObjects) {
				if (newObjects.contains(originalObject)) {
					newObjects.remove(originalObject);
				} else {
					foundToBeSmaller = true;
				}
			}
			if (newObjects.size() > 0) {
				foundToBeBigger = true;
			}
		}
		if (foundToBeBigger || foundToBeSmaller) {
			DifferentBindingSize differentBindingSize = ConflictFactory.eINSTANCE
					.createDifferentBindingSize();
			differentBindingSize.setNewBinding(TemplateBindingsUtil
					.convert(bindings));
			differentBindingSize.setOldBinding(TemplateBindingsUtil
					.convert(originalBindings));
			BindingSizeDifference differenceKind = foundToBeSmaller ? BindingSizeDifference.DECREASED
					: BindingSizeDifference.INCREASED;
			if (foundToBeBigger && foundToBeSmaller) {
				differenceKind = BindingSizeDifference.BOTH;
			}
			differentBindingSize.setDifferenceKind(differenceKind);
			OperationContractViolation contractViolation = createOperationContractViolation(
					differentBindingSize, occurrence, side);
			if (BindingSizeDifference.INCREASED.equals(differenceKind)) {
				contractViolation.setSeverity(ViolationSeverity.INFO);
			} else {
				contractViolation.setSeverity(ViolationSeverity.WARNING);
			}
			conflicts.add(contractViolation);
		}
	}

	/**
	 * Removes the {@code unselectedBinding} from {@code allBindings}.
	 * 
	 * @param allBindings
	 *            to remove {@code unselectedBinding} from.
	 * @param unselectedBinding
	 *            to be removed from {@code allBindings}.
	 * @param rewiredTemplateBinding
	 *            fall-back for finding out failing conditions if unselected
	 *            bindings could not be removed.
	 * @param threeWayDiff
	 *            for matching between model versions.
	 * @param oppositeSide
	 *            the side for matching.
	 * @throws UnselectBindingsFailedException
	 *             if the unselected binding could not be removed anymore
	 *             because the binding would be empty afterwards.
	 */
	private void removeUnselectedBindings(ITemplateBindings allBindings,
			ITemplateBinding unselectedBinding,
			ITemplateBindings rewiredTemplateBinding,
			IThreeWayDiffProvider threeWayDiff, Side oppositeSide)
			throws UnselectBindingsFailedException {
		for (Template template : unselectedBinding.getTemplates()) {
			for (EObject eObject : unselectedBinding.getBoundObjects(template)) {
				EObject matchingObject = threeWayDiff.getMatchingEObject(
						eObject, oppositeSide, false);
				if (matchingObject != null) {
					if (allBindings.isRemovable(matchingObject, template)) {
						allBindings.remove(matchingObject, template);
					} else {
						throw new UnselectBindingsFailedException(allBindings,
								unselectedBinding, rewiredTemplateBinding);
					}
				}
			}
		}
	}

	/**
	 * Evaluates the specified <code>binding</code> and returns the resulting
	 * operation binding.
	 * 
	 * @param bindings
	 *            to evaluate.
	 * @param operationSpecification
	 *            the specification of the operation.
	 * @return the resulting operation bindings.
	 * @throws UnsupportedConditionLanguage
	 */
	private IOperationBinding evaluateBindings(ITemplateBindings bindings,
			OperationSpecification operationSpecification)
			throws UnsupportedConditionLanguage {
		ITemplateBinding mergedTemplateBinding = ConditionsUtil
				.mergeTemplateBindings(bindings);
		Assert.isTrue(getOperationBindingGenerator().getEvaluationEngine()
				.isComplete(mergedTemplateBinding),
				"Template must be complete, otherwise a missing "
						+ "object exception would have been thrown");
		return getOperationBindingGenerator().generateOperationBinding(
				operationSpecification, mergedTemplateBinding);
	}

	/**
	 * Rewire the specified <code>preConditionBinding</code> using the match in
	 * <code>threeWayDiff</code> for the specified <code>side</code>.
	 * 
	 * <p>
	 * The returned bindings contain only complete sub-bindings that could be
	 * entirely matched and rewired.
	 * </p>
	 * 
	 * @param preConditionBinding
	 *            to rewire.
	 * @param threeWayDiff
	 *            to use for retrieving opposite.
	 * @param side
	 *            the {@link Side} to which we aim at rewireing to.
	 * @return the rewired template bindings.
	 * @throws MissingObjectsForBindingException
	 *             if there is not at least one complete rewired binding.
	 */
	private ITemplateBindings rewireBinding(
			TemplateBindingCollection preConditionBinding,
			IThreeWayDiffProvider threeWayDiff, Side side)
			throws MissingObjectsForBindingException {
		// convert model based binding to normal bindings
		ITemplateBindings originalBindings = TemplateBindingsUtil
				.convert(preConditionBinding);

		// create empty binding to be filled
		ITemplateBindings rewiredBindings = new TemplateBindingsImpl(
				originalBindings.getRootTemplate());

		Map<Template, EList<EObject>> missingObjects = new HashMap<Template, EList<EObject>>();

		// rewire each sub-binding to matching objects
		for (ITemplateBinding originalBinding : originalBindings
				.getAllPossibleBindings()) {
			ITemplateBinding rewiredBinding = new TemplateBindingImpl();
			boolean hadNoObjectForTemplate = false;
			for (Template template : originalBinding.getTemplates()) {
				for (EObject originalObject : originalBinding
						.getBoundObjects(template)) {
					EObject matchingObject = threeWayDiff.getMatchingEObject(
							originalObject, side, false);
					if (matchingObject != null) {
						rewiredBinding.add(template, matchingObject);
					}
				}
				// check whether there is at least one bound object
				if (rewiredBinding.getBoundObjects(template) == null
						|| rewiredBinding.getBoundObjects(template).size() == 0) {
					missingObjects.put(template, new BasicEList<EObject>(
							originalBinding.getBoundObjects(template)));
					hadNoObjectForTemplate = true;
				}
			}
			if (!hadNoObjectForTemplate) {
				rewiredBindings.getAllPossibleBindings().add(rewiredBinding);
			}
		}

		// if we have not at least one complete binding, throw exception
		if (rewiredBindings.getAllPossibleBindings().size() < 1) {
			throw new MissingObjectsForBindingException(missingObjects);
		}

		return rewiredBindings;
	}

	/**
	 * Fills the {@link #unselectedBindingMap} for the specified
	 * <code>comparisonSnapshot</code>.
	 * 
	 * @param occurrences
	 *            to fill {@link #unselectedBindingMap} for.
	 * @throws UnsupportedConditionLanguage
	 *             if the evaluation engine does not support the used condition
	 *             language.
	 */
	private void fillUnselectedBindingMap(Set<OperationOccurrence> occurrences)
			throws UnsupportedConditionLanguage {
		for (OperationOccurrence occurrence : occurrences) {
			// get actual binding from applied operation
			ITemplateBindings actualBinding = TemplateBindingsUtil
					.convert(occurrence.getPreConditionBinding());
			// retrieve fixed binding
			ITemplateBinding fixedPreBinding = createFixedPreBinding(
					actualBinding, occurrence.getAppliedOperation());
			// find all possible bindings
			ITemplateBindings allPossibleBindings = getOperationBindingGenerator()
					.generateOperationBinding(occurrence.getAppliedOperation(),
							fixedPreBinding).getTemplateBinding();
			// create binding representing actively unselected bindings
			ITemplateBinding unselectedBinding = new TemplateBindingImpl();
			for (Template template : new HashSet<Template>(
					allPossibleBindings.getTemplates())) {
				// get all possibly bound objects
				Set<EObject> boundObjects = new HashSet<EObject>(
						allPossibleBindings.getBoundObjects(template));
				// remove those that _have_ been selected
				boundObjects.removeAll(actualBinding.getBoundObjects(template));
				// remaining objects are those actively unselected
				if (boundObjects.size() > 0) {
					unselectedBinding.add(template, boundObjects);
				}
			}
			unselectedBindingMap.put(occurrence, unselectedBinding);
		}
	}

	/**
	 * Creates a {@link ITemplateBinding} containing only bindings for
	 * non-iterated templates.
	 * 
	 * @param inputBinding
	 *            to create binding from.
	 * @param operationSpecification
	 *            for retrieving iteration information.
	 * @return a new {@link ITemplateBinding} containing only bindings for
	 *         non-iterated templates.
	 */
	private ITemplateBinding createFixedPreBinding(
			ITemplateBindings inputBinding,
			OperationSpecification operationSpecification) {
		ITemplateBinding binding = new TemplateBindingImpl();
		for (Template template : new HashSet<Template>(
				inputBinding.getTemplates())) {
			if (isPartOfFixedPreBinding(template, operationSpecification)) {
				for (EObject boundObject : inputBinding
						.getBoundObjects(template)) {
					binding.add(template, boundObject);
				}
			}
		}
		return binding;
	}

	/**
	 * Specifies whether the specified <code>template</code> should be part of a
	 * fixed pre-binding. Basically, it is part of a fixed pre-binding if it is
	 * not iterated.
	 * 
	 * @param template
	 *            to check.
	 * @param operationSpecification
	 *            context to check within.
	 * @return <code>true</code> if it should be part, otherwise
	 *         <code>false</code>.
	 */
	private boolean isPartOfFixedPreBinding(Template template,
			OperationSpecification operationSpecification) {
		return !OperationsUtil.isIterated(template, operationSpecification)
				&& !OperationsUtil.isParentIterated(template,
						operationSpecification);
	}

	/**
	 * Retrieves all {@link OperationOccurrence operation occurrences} from the
	 * specified <code>comparisonSnapshot</code>.
	 * 
	 * @param comparisonSnapshot
	 *            to get operation occurrences from.
	 * @return all contained operation occurrences.
	 */
	private Set<OperationOccurrence> getOperationOccurrences(
			ComparisonResourceSnapshot comparisonSnapshot) {
		Set<OperationOccurrence> occurrences = new HashSet<OperationOccurrence>();
		occurrences.addAll(getOperationOccurrences(comparisonSnapshot.getDiff()
				.getOwnedElements()));
		return occurrences;
	}

	/**
	 * Retrieves all {@link OperationOccurrence operation occurrences} from the
	 * specified <code>diffElements</code>.
	 * 
	 * @param diffElements
	 *            to get operation occurrences from.
	 * @return all contained operation occurrences.
	 */
	private Collection<OperationOccurrence> getOperationOccurrences(
			EList<DiffElement> diffElements) {
		Set<OperationOccurrence> occurrences = new HashSet<OperationOccurrence>();
		for (DiffElement diffElement : diffElements) {
			if (diffElement instanceof OperationOccurrence) {
				occurrences.add((OperationOccurrence) diffElement);
			} else {
				occurrences.addAll(getOperationOccurrences(diffElement
						.getSubDiffElements()));
			}
		}
		return occurrences;
	}

	/**
	 * Creates a new {@link OperationContractViolation} and sets the specified
	 * {@code diagnostics}.
	 * 
	 * @param diagnostics
	 *            to set.
	 * @param side
	 *            on which the operation occurrence has been detected.
	 * @param occurrence
	 *            to be linked.
	 * @return the created operation contract violation.
	 */
	private OperationContractViolation createOperationContractViolation(
			OperationContractDiagnostics diagnostics,
			OperationOccurrence occurrence, Side side) {
		OperationContractViolation contractViolation = ConflictFactory.eINSTANCE
				.createOperationContractViolation();
		if (Side.LEFT.equals(side)) {
			contractViolation.setLeftChange(occurrence);
		} else {
			contractViolation.setRightChange(occurrence);
		}
		contractViolation.setSeverity(ViolationSeverity.ERROR);
		contractViolation.setDiagnostics(diagnostics);
		return contractViolation;
	}

}
