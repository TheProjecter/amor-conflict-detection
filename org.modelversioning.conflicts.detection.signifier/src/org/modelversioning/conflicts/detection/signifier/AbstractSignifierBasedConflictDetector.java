package org.modelversioning.conflicts.detection.signifier;

import java.io.File;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.execute.EclOperationFactory;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolSystem;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.modelversioning.conflicts.detection.IThreeWayDiffProvider;
import org.modelversioning.conflicts.detection.signifier.preferences.PreferenceConstants;

public abstract class AbstractSignifierBasedConflictDetector {

	protected static final String PREV_MATCH_TRACE_VARIABLE_NAME = "prevMatchTrace";
	protected EclModule module;

	public AbstractSignifierBasedConflictDetector() {
		super();
	}

	protected void initModule(IThreeWayDiffProvider threeWayDiff) {
		parseModule();
		doInlinedStuffFromEolLibraryModulePrepareContext();
		addModelsToContext(threeWayDiff);

	}

	private void parseModule() {
		String eclFilePath = SignifierDetectionPlugin.getDefault()
				.getPreferenceStore().getString(PreferenceConstants.ECL_FILE);
		try {
			parseModule(eclFilePath);
		} catch (Exception e) {
			module = null;
			e.printStackTrace();
		}
	}

	private void parseModule(String path) throws Exception {
		module = new EclModule();
		// inlined from org.eclipse.epsilon.ecl.EclModule.execute()
		module.getContext().setOperationFactory(new EclOperationFactory());
		Variable matchTraceVariable = Variable.createReadOnlyVariable(
				"matchTrace", module.getContext().getMatchTrace());
		module.getContext().getFrameStack().put(matchTraceVariable);
		Variable contextVariable = Variable.createReadOnlyVariable("context",
				module.getContext());
		module.getContext().getFrameStack().put(contextVariable);
		Variable selfVariable = Variable.createReadOnlyVariable("self", module);
		module.getContext().getFrameStack().put(selfVariable);
		// add previous match trace
		// the previous match trace allows implementations to add their own
		// custom match trace
		Variable prevMatchTraceVariable = Variable.createReadOnlyVariable(
				PREV_MATCH_TRACE_VARIABLE_NAME, new MatchTrace());
		module.getContext().getFrameStack().put(prevMatchTraceVariable);
		module.parse(new File(path));
	}

	private void doInlinedStuffFromEolLibraryModulePrepareContext() {
		// inlined from
		// org.eclipse.epsilon.eol.EolLibraryModule.prepareContext(IEolContext)
		final EolSystem system = new EolSystem();
		system.setContext(module.getContext());
		module.getContext().setModule(module);
		module.getContext().getFrameStack()
				.put(Variable.createReadOnlyVariable("null", null));
		module.getContext().getFrameStack()
				.put(Variable.createReadOnlyVariable("System", system));
	}

	private void addModelsToContext(IThreeWayDiffProvider threeWayDiff) {
		InMemoryEmfModel leftModel = new InMemoryEmfModel(threeWayDiff
				.getLeftModel().get(0).eResource());
		leftModel.setName("Left");
		leftModel.getAliases().add("Source");

		InMemoryEmfModel rightModel = new InMemoryEmfModel(threeWayDiff
				.getRightModel().get(0).eResource());
		rightModel.setName("Right");
		rightModel.getAliases().add("Source");

		module.getContext().getModelRepository().addModel(leftModel);
		module.getContext().getModelRepository().addModel(rightModel);
	}

}