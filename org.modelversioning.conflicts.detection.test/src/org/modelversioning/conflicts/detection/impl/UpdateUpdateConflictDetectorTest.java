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
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.modelversioning.conflictreport.EquivalentChange;
import org.modelversioning.conflictreport.conflict.Conflict;
import org.modelversioning.conflictreport.conflict.UpdateUpdate;

/**
 * Test case for {@link UpdateUpdateConflictDetector}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class UpdateUpdateConflictDetectorTest extends ConflictDetectorTestCase {

	@Override
	public void testDetectConflicts() {
		// TEST 1
		UpdateUpdateConflictDetector detector = new UpdateUpdateConflictDetector();
		EList<Conflict> conflictList = getEmptyConflictList();
		EList<EquivalentChange> equivalentChangesList = getEmptyEquivalentChangesList();
		detector.detectOverlappingChanges(threeWayDiffProvider_test1, conflictList,
				equivalentChangesList, getProgressMonitor());
		assertEquals(1, conflictList.size());
		Conflict conflict = conflictList.get(0);
		assertTrue(conflict instanceof UpdateUpdate);
		UpdateUpdate updateUpdate = (UpdateUpdate) conflict;
		DiffElement leftChange = updateUpdate.getLeftChange();
		DiffElement rightChange = updateUpdate.getRightChange();
		assertNotNull(leftChange);
		assertNotNull(rightChange);
		assertTrue(leftChange instanceof AttributeChange);
		assertTrue(rightChange instanceof AttributeChange);
		AttributeChange leftAttChange = (AttributeChange) leftChange;
		AttributeChange rightAttChange = (AttributeChange) rightChange;
		assertTrue(leftAttChange.getAttribute() == rightAttChange
				.getAttribute());
		assertEquals("upperBound", leftAttChange.getAttribute().getName());

		// TEST 2
		detector = new UpdateUpdateConflictDetector();
		conflictList = getEmptyConflictList();
		equivalentChangesList = getEmptyEquivalentChangesList();
		detector.detectOverlappingChanges(threeWayDiffProvider_test2, conflictList,
				equivalentChangesList, getProgressMonitor());
		assertEquals(1, conflictList.size());
		conflict = conflictList.get(0);
		assertTrue(conflict instanceof UpdateUpdate);
		updateUpdate = (UpdateUpdate) conflict;
		leftChange = updateUpdate.getLeftChange();
		rightChange = updateUpdate.getRightChange();
		assertNotNull(leftChange);
		assertNotNull(rightChange);
		assertTrue(leftChange instanceof ReferenceChange);
		assertTrue(rightChange instanceof ReferenceChange);

	}

}
