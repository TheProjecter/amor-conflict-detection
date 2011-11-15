/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.conflicts.detection.engine;

import org.eclipse.emf.ecore.EcorePackage;
import org.modelversioning.conflictreport.ConflictReportFactory;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.ConflictFactory;

/**
 * Interface to be implemented by specific {@link Conflict} detectors.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public abstract interface IConflictDetector {

	/**
	 * The conflict factory to use for all conflict detectors.
	 */
	public static final ConflictFactory CONFLICT_FACTORY = ConflictFactory.eINSTANCE;

	/**
	 * The conflict report factory to use for all conflict detectors.
	 */
	public static final ConflictReportFactory CONFLICT_REPORT_FACTORY = ConflictReportFactory.eINSTANCE;

	/**
	 * The Id of this detector.
	 * 
	 * @return the id of this detector.
	 */
	public String getId();

	/**
	 * Returns the namespace URI of the metamodel for which this detector is
	 * designed for. If the URI is {@link EcorePackage#getNsURI()} it is
	 * applicable for all ecore-based models.
	 * 
	 * @return the target model namespace URI.
	 */
	public String getTargetModelNsURI();

	/**
	 * Returns the name of this detector.
	 * 
	 * @return the name.
	 */
	public String getName();

	/**
	 * Initializes the detector.
	 */
	public void initialize();

}
