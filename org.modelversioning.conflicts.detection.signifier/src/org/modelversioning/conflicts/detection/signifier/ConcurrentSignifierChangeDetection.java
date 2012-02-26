package org.modelversioning.conflicts.detection.signifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.ConcurrentSignifierChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictFactory;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.engine.IOperationConflictDetector;

/*
 * TODO allow to configure more than one ECL Module (one for each namespace)
 */
public class ConcurrentSignifierChangeDetection extends
		AbstractSignifierBasedConflictDetector implements
		IOperationConflictDetector {

	private Collection<EObject> leftSignifierChanges;
	private Collection<EObject> rightSignifierChanges;
	private Map<EObject, String> elementRuleMap;

	public ConcurrentSignifierChangeDetection() {
	}

	@Override
	public String getId() {
		return "org.modelversioning.conflicts.detection.concurrentsignifierchange";
	}

	@Override
	public String getTargetModelNsURI() {
		return "*";
	}

	@Override
	public String getName() {
		return "Concurrent Signifier Change Detection";
	}

	@Override
	public void initialize() {
		clearTemporaryLists();
	}

	private void clearTemporaryLists() {
		this.leftSignifierChanges = null;
		this.rightSignifierChanges = null;
		this.elementRuleMap = new HashMap<EObject, String>();
	}

	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {

		initModule(threeWayDiff);
		if (module != null) {
			computeSignifierChanges(threeWayDiff);
			checkForConcurrentSignifierChanges(conflicts, threeWayDiff);
		}
	}

	private void computeSignifierChanges(IThreeWayDiffProvider threeWayDiff) {
		setMatchTraceFromMatchModelToModule(threeWayDiff, Side.LEFT);
		leftSignifierChanges = detectSignifierChanges(threeWayDiff
				.getComparisonSnapshot(Side.LEFT).getMatch());

		setMatchTraceFromMatchModelToModule(threeWayDiff, Side.RIGHT);
		rightSignifierChanges = detectSignifierChanges(threeWayDiff
				.getComparisonSnapshot(Side.RIGHT).getMatch());
	}

	private void setMatchTraceFromMatchModelToModule(
			IThreeWayDiffProvider threeWayDiff, Side side) {
		MatchTrace matchTrace = produceMatchTrace(threeWayDiff, side);
		MatchTrace prevMatchTrace = (MatchTrace) module.getContext()
				.getFrameStack().get(PREV_MATCH_TRACE_VARIABLE_NAME).getValue();
		prevMatchTrace.getMatches().addAll(matchTrace.getMatches());
	}

	private MatchTrace produceMatchTrace(IThreeWayDiffProvider threeWayDiff,
			Side side) {
		Collection<EObject> allOriginalElements = createFullElementCollection(threeWayDiff
				.getComparisonSnapshot(side).getMatch().getLeftRoots());
		Collection<EObject> allRevisedElements = createFullElementCollection(threeWayDiff
				.getComparisonSnapshot(side).getMatch().getRightRoots());

		MatchTrace matchTrace = new MatchTrace();
		for (EObject originalElement : allOriginalElements) {
			Collection<Object> correspondingRevisedElements = EcoreUtil
					.getObjectsByType(allRevisedElements,
							originalElement.eClass());
			matchTrace.getMatches().addAll(
					deriveMatches(originalElement,
							correspondingRevisedElements, threeWayDiff, side));
		}

		return matchTrace;
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

	private Collection<Match> deriveMatches(EObject originalElement,
			Collection<Object> correspondingRevisedElement,
			IThreeWayDiffProvider threeWayDiff, Side side) {
		Collection<Match> matches = new HashSet<Match>();
		for (Object revisedElement : correspondingRevisedElement) {
			if (revisedElement instanceof EObject) {
				EObject revisedEObject = (EObject) revisedElement;
				Match match = new Match();
				match.setLeft(originalElement);
				match.setRight(revisedEObject);
				EObject actualMatchingElement = threeWayDiff
						.getMatchingEObject(revisedEObject, side, true);
				match.setMatching(actualMatchingElement != null
						&& actualMatchingElement.equals(originalElement));
				matches.add(match);
			}
		}
		return matches;
	}

	private Collection<EObject> detectSignifierChanges(MatchModel match) {
		Collection<EObject> signifierChanges = new HashSet<EObject>();
		for (MatchElement matchElement : match.getMatchedElements()) {
			if (matchElement instanceof Match2Elements) {
				Match2Elements match2Elements = (Match2Elements) matchElement;
				detectSignifierChange(signifierChanges, match2Elements);
			}
		}
		return signifierChanges;
	}

	private void detectSignifierChange(Collection<EObject> signifierChanges,
			MatchElement matchElement) {
		try {
			if (matchElement instanceof Match2Elements) {
				Match2Elements match2Elements = (Match2Elements) matchElement;
				EObject originalElement = match2Elements.getRightElement();
				EObject revisedElement = match2Elements.getLeftElement();
				Match eclMatch = match(originalElement, revisedElement);
				if (!eclMatch.isMatching() && eclMatch.getRule() != null) {
					signifierChanges.add(originalElement);
					elementRuleMap.put(originalElement, eclMatch.getRule()
							.getName());
				}
			}
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}

		for (MatchElement subMatchElement : matchElement.getSubMatchElements()) {
			detectSignifierChange(signifierChanges, subMatchElement);
		}
	}

	private Match match(EObject originalElement, EObject revisedElement)
			throws EolRuntimeException {
		Match eclMatch = module.match(originalElement, revisedElement, true);
		return eclMatch;
	}

	private void checkForConcurrentSignifierChanges(EList<Conflict> conflicts,
			IThreeWayDiffProvider threeWayDiff) {
		for (EObject changedObject : leftSignifierChanges) {
			if (rightSignifierChanges.contains(changedObject)) {
				conflicts.add(createConcurrentSignifierChange(changedObject,
						threeWayDiff));
			}
		}
	}

	private Conflict createConcurrentSignifierChange(
			EObject concurrentlyChanged, IThreeWayDiffProvider threeWayDiff) {
		ConcurrentSignifierChange signifierChange = ConflictFactory.eINSTANCE
				.createConcurrentSignifierChange();
		signifierChange.setOriginalObject(concurrentlyChanged);
		signifierChange.setRuleName(getRuleNameForObject(concurrentlyChanged));
		guessCausingChanges(concurrentlyChanged, threeWayDiff, signifierChange);
		return signifierChange;
	}

	private void guessCausingChanges(EObject originalObject,
			IThreeWayDiffProvider threeWayDiff,
			ConcurrentSignifierChange signifierChange) {
		if (threeWayDiff.isUpdated(originalObject, Side.LEFT, true)) {
			signifierChange.setLeftChange(threeWayDiff
					.getUpdateElements(originalObject, Side.LEFT).iterator()
					.next());
		}
		if (threeWayDiff.isUpdated(originalObject, Side.RIGHT, true)) {
			signifierChange.setRightChange(threeWayDiff
					.getUpdateElements(originalObject, Side.RIGHT).iterator()
					.next());
		}
	}

	private String getRuleNameForObject(EObject eObject) {
		return elementRuleMap.get(eObject);
	}

}
