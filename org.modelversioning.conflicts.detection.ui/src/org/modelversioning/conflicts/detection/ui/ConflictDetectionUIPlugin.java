package org.modelversioning.conflicts.detection.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConflictDetectionUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.modelversioning.conflicts.detection.ui"; //$NON-NLS-1$
	
	public static final String CONFLICT_REPORT_EXTENSION = "conflictreport";

	// The shared instance
	private static ConflictDetectionUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ConflictDetectionUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ConflictDetectionUIPlugin getDefault() {
		return plugin;
	}

}
