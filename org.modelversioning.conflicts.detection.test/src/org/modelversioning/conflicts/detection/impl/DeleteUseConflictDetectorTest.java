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

package org.modelversioning.conflicts.detection.impl;

import org.eclipse.emf.common.util.EList;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.DeleteUse;

/**
 * Test case for {@link DeleteUseConflictDetector}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class DeleteUseConflictDetectorTest extends ConflictDetectorTestCase {

	@Override
	public void testDetectConflicts() {
		// TEST 4
		System.out.println("TEST 4");
		DeleteUseConflictDetector detector = new DeleteUseConflictDetector();
		EList<Conflict> conflictList = getEmptyConflictList();
		EList<EquivalentChange> equivalentChangesList = getEmptyEquivalentChangesList();
		detector.detectOverlappingChanges(threeWayDiffProvider_test4, conflictList,
				equivalentChangesList, getProgressMonitor());
		// TODO more sophisticated asserts
		for (Conflict conflict : conflictList) {
			DeleteUse delUse = (DeleteUse) conflict;
			System.out.println(delUse.getLeftChange() + " XXX "
					+ delUse.getRightChange());
		}
		assertEquals(3, conflictList.size());
	}

}
