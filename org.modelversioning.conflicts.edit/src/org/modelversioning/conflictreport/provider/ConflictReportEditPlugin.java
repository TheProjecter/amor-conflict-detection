/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.modelversioning.conflictreport.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.compare.diff.provider.DiffEditPlugin;
import org.eclipse.emf.compare.match.metamodel.provider.MatchEditPlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.ocl.ecore.edit.OCLEcoreEditPlugin;
import org.eclipse.ocl.edit.OCLEditPlugin;

/**
 * This is the central singleton for the ConflictReport edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ConflictReportEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ConflictReportEditPlugin INSTANCE = new ConflictReportEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictReportEditPlugin() {
		super
		  (new ResourceLocator [] {
		     DiffEditPlugin.INSTANCE,
		     EcoreEditPlugin.INSTANCE,
		     MatchEditPlugin.INSTANCE,
		     OCLEditPlugin.INSTANCE,
		     OCLEcoreEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
