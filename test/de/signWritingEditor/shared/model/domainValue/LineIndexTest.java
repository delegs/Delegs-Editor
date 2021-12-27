package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.LineIndex;

public class LineIndexTest {

	List<LineIndex> lineIndexPermutations;

	@Before
	public void setup() {
		lineIndexPermutations = new ArrayList<LineIndex>();
		// Increase numbers to test hashCode() and equals()
		// functions thoroughly (time consuming!)
		for (int pageIndex = 0; pageIndex < 40; pageIndex++) {
			for (int lIndex = 0; lIndex < 50; lIndex++) {
				lineIndexPermutations.add(new LineIndex(pageIndex, lIndex));
			}
		}
	}

	@Test
	public void testEquals() {
		for (int index = 0; index < lineIndexPermutations.size(); index++) {
			LineIndex lineIndex = lineIndexPermutations.get(index);
			assertEquals(lineIndex, lineIndex);

			LineIndex equalLineIndex = new LineIndex(lineIndex.getPageIndex(), lineIndex.getLineIndex());
			assertEquals(lineIndex, equalLineIndex);

			for (int compareIndex = index + 1; compareIndex < lineIndexPermutations.size(); compareIndex++) {
				LineIndex compareLineIndex = lineIndexPermutations.get(compareIndex);
				assertFalse("Equals failed for " + lineIndex + " and " + compareLineIndex,
						lineIndex.equals(compareLineIndex));
			}
		}
	}

	@Test
	public void testHashcode() {
		for (int index = 0; index < lineIndexPermutations.size(); index++) {
			LineIndex lineIndex = lineIndexPermutations.get(index);
			assertEquals(lineIndex.hashCode(), lineIndex.hashCode());

			LineIndex equalLineIndex = new LineIndex(lineIndex.getPageIndex(), lineIndex.getLineIndex());
			assertTrue("Different hashcodes for " + lineIndex + "(" + lineIndex.hashCode() + ") and " + equalLineIndex
					+ "(" + equalLineIndex.hashCode() + ")", lineIndex.hashCode() == equalLineIndex.hashCode());

			for (int compareIndex = index + 1; compareIndex < lineIndexPermutations.size(); compareIndex++) {
				LineIndex compareLineIndex = lineIndexPermutations.get(compareIndex);
				assertFalse("Same hashcode for " + lineIndex + " and " + compareLineIndex + ": " + lineIndex.hashCode(),
						lineIndex.hashCode() == compareLineIndex.hashCode());
			}
		}
	}
}
