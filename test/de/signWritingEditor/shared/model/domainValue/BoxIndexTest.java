package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.BoxIndex;

public class BoxIndexTest {

	List<BoxIndex> boxIndexPermutations;

	@Before
	public void setup() {
		// Increase numbers to test hashCode() and equals()
		// functions thoroughly (time consuming!)
		boxIndexPermutations = new ArrayList<BoxIndex>();
		for (int pageIndex = 0; pageIndex < 10; pageIndex++) {
			for (int lIndex = 0; lIndex < 10; lIndex++) {
				for (int bIndex = 0; bIndex < 10; bIndex++) {
					boxIndexPermutations.add(new BoxIndex(pageIndex, lIndex, bIndex));
				}
			}
		}
	}

	@Test
	public void testEquals() {
		for (int index = 0; index < boxIndexPermutations.size(); index++) {
			BoxIndex boxIndex = boxIndexPermutations.get(index);
			assertEquals(boxIndex, boxIndex);

			BoxIndex equalBoxIndex = new BoxIndex(boxIndex.getPageIndex(), boxIndex.getLineIndex(),
					boxIndex.getBoxIndex());
			assertEquals(boxIndex, equalBoxIndex);

			for (int compareIndex = index + 1; compareIndex < boxIndexPermutations.size(); compareIndex++) {
				BoxIndex compareBoxIndex = boxIndexPermutations.get(compareIndex);
				assertFalse("Equals failed for " + boxIndex + " and " + compareBoxIndex,
						boxIndex.equals(compareBoxIndex));
			}
		}
	}

	@Test
	public void testHashCode() {
		for (int index = 0; index < boxIndexPermutations.size(); index++) {
			BoxIndex boxIndex = boxIndexPermutations.get(index);
			BoxIndex equalBoxIndex = new BoxIndex(boxIndex.getPageIndex(), boxIndex.getLineIndex(),
					boxIndex.getBoxIndex());
			assertTrue("Different hashcodes for " + boxIndex + "(" + boxIndex.hashCode() + ") and " + equalBoxIndex
					+ "(" + equalBoxIndex.hashCode() + ")", boxIndex.hashCode() == equalBoxIndex.hashCode());

			for (int compareIndex = index + 1; compareIndex < boxIndexPermutations.size(); compareIndex++) {
				BoxIndex compareBoxIndex = boxIndexPermutations.get(compareIndex);
				assertFalse("Same hashcode for " + boxIndex + " and " + compareBoxIndex + ": " + boxIndex.hashCode(),
						boxIndex.hashCode() == compareBoxIndex.hashCode());
			}
		}
	}
}
