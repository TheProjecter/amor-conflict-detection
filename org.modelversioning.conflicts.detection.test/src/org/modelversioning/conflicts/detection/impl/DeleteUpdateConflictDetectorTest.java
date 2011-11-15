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
import org.modelversioning.conflictreport.conflict.DeleteUpdate;

/**
 * Test case for {@link DeleteUpdateConflictDetector}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class DeleteUpdateConflictDetectorTest extends ConflictDetectorTestCase {

	@Override
	public void testDetectConflicts() {
		// TEST 3
		System.out.println("TEST 3");
		DeleteUpdateConflictDetector detector = new DeleteUpdateConflictDetector();
		EList<Conflict> conflictList = getEmptyConflictList();
		EList<EquivalentChange> equivalentChangesList = getEmptyEquivalentChangesList();
		detector.detectOverlappingChanges(threeWayDiffProvider_test3, conflictList,
				equivalentChangesList, getProgressMonitor());
		// TODO more sophisticated asserts
		for (Conflict conflict : conflictList) {
			DeleteUpdate delUp = (DeleteUpdate) conflict;
			System.out.println(delUp.getLeftChange() + " XXX "
					+ delUp.getRightChange());
		}
		assertEquals(4, conflictList.size());
		
		
		// TEST 4
		System.out.println("TEST 4");
		detector = new DeleteUpdateConflictDetector();
		conflictList = getEmptyConflictList();
		equivalentChangesList = getEmptyEquivalentChangesList();
		detector.detectOverlappingChanges(threeWayDiffProvider_test4, conflictList,
				equivalentChangesList, getProgressMonitor());
		// TODO more sophisticated asserts
		for (Conflict conflict : conflictList) {
			DeleteUpdate delUp = (DeleteUpdate) conflict;
			System.out.println(delUp.getLeftChange() + " XXX "
					+ delUp.getRightChange());
		}
		assertEquals(2, conflictList.size());
	}

}
