package org.modelversioning.conflicts.detection.signifier.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.modelversioning.conflicts.detection.signifier.SignifierDetectionPlugin;

public class SignifierPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public SignifierPreferencePage() {
		super(GRID);
		setPreferenceStore(SignifierDetectionPlugin.getDefault()
				.getPreferenceStore());
		setDescription("The ECL comparison files to use for signifier matching.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		addField(new FileFieldEditor(PreferenceConstants.ECL_FILE,
				"&Path to ECL file:", getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}

}