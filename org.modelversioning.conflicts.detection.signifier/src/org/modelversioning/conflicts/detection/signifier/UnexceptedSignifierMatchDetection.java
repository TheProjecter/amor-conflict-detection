package org.modelversioning.conflicts.detection.signifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictFactory;
import org.modelversioning.conflictreport.conflict.UnexpectedSignifierMatch;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;

public class UnexceptedSignifierMatchDetection extends
		AbstractSignifierBasedConflictDetector implements
		IOperationConflictDetector {

	private Collection<EObject> leftElements;
	private Collection<EObject> rightElements;
	private Map<EObject, EObject> leftToRightElementMap;
	private Map<EObject, EObject> rightToLeftElementMap;
	private Collection<UnexpectedSignifierMatch> foundConflicts;

	public UnexceptedSignifierMatchDetection() {
	}

	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.unexpectedsignifiermatch";
	}

	@Override
	public String getTargetModelNsURI() {
		return "*";
	}

	@Override
	public String getName() {
		return "Unexpected Signifier Match Detection";
	}

	@Override
	public void initialize() {
	}

	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {

		initModule(threeWayDiff);
		foundConflicts = new ArrayList<UnexpectedSignifierMatch>();
		if (module != null) {
			createElementLists(threeWayDiff);
			deriveMapBetweenRevisedElements(threeWayDiff);
			setMatchTraceToModule(threeWayDiff);
			matchLeftWithRight();
		}
		conflicts.addAll(foundConflicts);
	}

	private void createElementLists(IThreeWayDiffProvider threeWayDiff) {
		leftElements = createFullElementCollection(threeWayDiff.getLeftModel());
		rightElements = createFullElementCollection(threeWayDiff
				.getRightModel());
	}

	private Collection<EObject> createFullElementCollection(
			EList<EObject> rootElements) {
		Collection<EObject> fullObjectList = new HashSet<EObject>();
		for (EObject rootElement : rootElements) {
			fullObjectList.add(rootElement);
			for (TreeIterator<EObject> contents = rootElement.eAllContents(); contents
					.hasNext();) {
				EObject next = contents.next();
				if (!(next instanceof EGenericType)) {
					fullObjectList.add(next);
				}
			}
		}
		return fullObjectList;
	}

	private void deriveMapBetweenRevisedElements(
			IThreeWayDiffProvider threeWayDiff) {
		leftToRightElementMap = new HashMap<EObject, EObject>();
		rightToLeftElementMap = new HashMap<EObject, EObject>();
		for (EObject leftElement : leftElements) {
			EObject matchingEObject = threeWayDiff.getMatchingEObject(
					leftElement, Side.LEFT, false);
			if (matchingEObject != null) {
				leftToRightElementMap.put(leftElement, matchingEObject);
				rightToLeftElementMap.put(matchingEObject, leftElement);
			}
		}
	}

	private void setMatchTraceToModule(IThreeWayDiffProvider threeWayDiff) {
		MatchTrace prevMatchTrace = (MatchTrace) module.getContext()
				.getFrameStack().get(PREV_MATCH_TRACE_VARIABLE_NAME).getValue();
		for (EObject leftElement : leftElements) {
			Collection<Object> rightElementsOfSameType = getElementsOfSameType(
					leftElement, rightElements);
			for (Object rightElement : rightElementsOfSameType) {
				EObject actualMatchingRightElement = leftToRightElementMap
						.get(leftElement);
				boolean matching = actualMatchingRightElement != null
						&& rightElement.equals(actualMatchingRightElement);
				Match match = new Match(leftElement, rightElement, matching);
				prevMatchTrace.getMatches().add(match);
			}
		}
	}

	private Collection<Object> getElementsOfSameType(EObject leftElement,
			Collection<EObject> rightElements2) {
		return EcoreUtil.getObjectsByType(rightElements2, leftElement.eClass());
	}

	private void matchLeftWithRight() {
		for (EObject leftElement : leftElements) {
			Collection<Object> rightElementsToMatchWith = EcoreUtil
					.getObjectsByType(rightElements, leftElement.eClass());
			for (Object rightObject : rightElementsToMatchWith) {
				if (rightObject instanceof EObject) {
					checkForUnexpectedMatch(leftElement, (EObject) rightObject);
				}
			}
		}
	}

	private void checkForUnexpectedMatch(EObject leftElement,
			EObject rightElement) {
		if (!isExpectedMatch(leftElement, rightElement)) {
			try {
				Match match = module.match(leftElement, rightElement, true);
				if (match.getRule() != null && match.isMatching()) {
					createUnexpectedSigniferMatch(match);
				}
			} catch (EolRuntimeException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isExpectedMatch(EObject leftElement, EObject rightElement) {
		EObject rightMatch = leftToRightElementMap.get(leftElement);
		return rightMatch != null && rightMatch.equals(rightElement);
	}

	private void createUnexpectedSigniferMatch(Match match) {
		UnexpectedSignifierMatch conflict = ConflictFactory.eINSTANCE
				.createUnexpectedSignifierMatch();
		conflict.setLeftObject((EObject) match.getLeft());
		conflict.setRightObject((EObject) match.getRight());
		conflict.setRuleName(match.getRule().getName());
		foundConflicts.add(conflict);
	}

}
