package org.modelversioning.conflicts.detection.signifier.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.modelversioning.conflicts.detection.signifier.SignifierDetectionPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = SignifierDetectionPlugin.getDefault()
				.getPreferenceStore();
		store.setDefault(PreferenceConstants.ECL_FILE, "");
	}

}
