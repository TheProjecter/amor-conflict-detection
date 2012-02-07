package org.modelversioning.conflicts.detection.signifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.ecl.trace.Match;
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
	private Map<EObject, String> objectRuleMap;

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
		this.objectRuleMap = new HashMap<EObject, String>();
	}

	@Override
	public void detectOperationConflicts(IThreeWayDiffProvider threeWayDiff,
			EList<Conflict> conflicts,
			EList<EquivalentChange> equivalentChanges, IProgressMonitor monitor) {

		initModule(threeWayDiff);
		setMatchTraceFromMatchModelToModule(threeWayDiff);
		if (module != null) {
			computeSignifierChanges(threeWayDiff);
			checkForConcurrentSignifierChanges(conflicts, threeWayDiff);
		}
	}

	private void setMatchTraceFromMatchModelToModule(
			IThreeWayDiffProvider threeWayDiff) {
		// TODO build match trace for all model elements (i.e., the cross
		// product) and set it to the module context
	}

	private void computeSignifierChanges(IThreeWayDiffProvider threeWayDiff) {
		leftSignifierChanges = detectSignifierChanges(threeWayDiff
				.getComparisonSnapshot(Side.LEFT).getMatch());
		rightSignifierChanges = detectSignifierChanges(threeWayDiff
				.getComparisonSnapshot(Side.RIGHT).getMatch());
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
					objectRuleMap.put(originalElement, eclMatch.getRule()
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
		Match tempMatch = module.getContext().getMatchTrace()
				.getMatch(originalElement, revisedElement);
		module.getContext().getMatchTrace().getMatches().remove(tempMatch);

		Match eclMatch = module.match(originalElement, revisedElement, true);

		module.getContext().getMatchTrace().getMatches().add(tempMatch);
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
		return objectRuleMap.get(eObject);
	}

}
