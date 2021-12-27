package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.model.domainValue.Orientation;

public class OverflowListLayoutTest {

	@Test
	public void testHorizontalOverflowListLayout() {
		assertEquals(Orientation.HORIZONTAL, Orientation.VERTICAL.toggle());
		assertEquals(Orientation.VERTICAL, Orientation.HORIZONTAL.toggle());

		OverflowListLayout overflowListLayout = new TestOverflowListLayout(Orientation.HORIZONTAL, 200);

		assertEquals(Orientation.HORIZONTAL, overflowListLayout.getOrientation());
		assertEquals(200, overflowListLayout.getOverflowThreshold());
		assertEquals(0, overflowListLayout.getBoxCount());

		overflowListLayout.setOverflowThreshold(100);
		assertEquals(100, overflowListLayout.getOverflowThreshold());

		assertFalse(overflowListLayout.canCompensate());
		overflowListLayout.setCanCompensate(true);
		assertTrue(overflowListLayout.canCompensate());

		Box testBox1 = new TestLayoutBox(30, 30);
		Box testBox2 = new TestLayoutBox(30, 30);
		Box testBox3 = new TestLayoutBox(30, 30);
		Box testBox4 = new TestLayoutBox(30, 30);
		Box testBox5 = new TestLayoutBox(50, 50);

		overflowListLayout.addBox(testBox1);
		overflowListLayout.addBox(testBox2);
		overflowListLayout.addBox(testBox3);
		overflowListLayout.addBox(testBox4);

		assertEquals(testBox1, overflowListLayout.getBox(0));
		assertEquals(testBox2, overflowListLayout.getBox(1));
		assertEquals(testBox3, overflowListLayout.getBox(2));
		assertEquals(testBox4, overflowListLayout.getBox(3));

		assertEquals(4, overflowListLayout.getBoxCount());
		assertEquals(2, overflowListLayout.getBoxIndex(testBox3));
		assertEquals(1, overflowListLayout.getBoxIndex(testBox2));
		assertEquals(120, overflowListLayout.getWidth_PX(), 0);
		assertEquals(30, overflowListLayout.getHeight_PX());

		overflowListLayout.insertBox(testBox5, 2);

		assertEquals(5, overflowListLayout.getBoxCount());

		assertEquals(testBox1, overflowListLayout.getBox(0));
		assertEquals(testBox2, overflowListLayout.getBox(1));
		assertEquals(testBox5, overflowListLayout.getBox(2));
		assertEquals(testBox3, overflowListLayout.getBox(3));
		assertEquals(testBox4, overflowListLayout.getBox(4));

		assertEquals(170, overflowListLayout.getWidth_PX(), 0);
		assertEquals(50, overflowListLayout.getHeight_PX());
		assertEquals(70, overflowListLayout.getOverflow(), 0);
		assertEquals(2, overflowListLayout.getOverflowStartIndex());

		overflowListLayout.removeBox(2);

		assertEquals(120, overflowListLayout.getWidth_PX(), 0);
		assertEquals(30, overflowListLayout.getHeight_PX());
		assertEquals(20, overflowListLayout.getOverflow(), 0);
		assertEquals(3, overflowListLayout.getOverflowStartIndex());

		assertEquals(0, overflowListLayout.getOutlierStartIndex(20));
		assertEquals(0, overflowListLayout.getOutlierStartIndex(29));
		assertEquals(1, overflowListLayout.getOutlierStartIndex(30));
		assertEquals(1, overflowListLayout.getOutlierStartIndex(31));
		assertEquals(2, overflowListLayout.getOutlierStartIndex(60));
		assertEquals(3, overflowListLayout.getOutlierStartIndex(95));

		OverflowListLayout overflowListLayout2 = new TestOverflowListLayout(Orientation.HORIZONTAL, 100);

		overflowListLayout.moveTail(overflowListLayout2, 2);

		assertEquals(testBox3, overflowListLayout2.getBox(0));
		assertEquals(testBox4, overflowListLayout2.getBox(1));
		assertEquals(2, overflowListLayout.getBoxCount());
		assertEquals(2, overflowListLayout2.getBoxCount());

		overflowListLayout2.moveHead(overflowListLayout, 0);

		assertEquals(3, overflowListLayout.getBoxCount());
		assertEquals(1, overflowListLayout2.getBoxCount());
		assertEquals(testBox4, overflowListLayout2.getBox(0));
		assertEquals(testBox3, overflowListLayout.getBox(2));
	}

	@Test
	public void testVerticalOverflowListLayout() {
		OverflowListLayout overflowListLayout = new TestOverflowListLayout(Orientation.VERTICAL, 100);

		assertEquals(Orientation.VERTICAL, overflowListLayout.getOrientation());
		assertEquals(100, overflowListLayout.getOverflowThreshold());
		assertEquals(0, overflowListLayout.getBoxCount());

		assertFalse(overflowListLayout.canCompensate());
		overflowListLayout.setCanCompensate(true);
		assertTrue(overflowListLayout.canCompensate());

		Box testBox1 = new TestLayoutBox(30, 30);
		Box testBox2 = new TestLayoutBox(30, 30);
		Box testBox3 = new TestLayoutBox(30, 30);
		Box testBox4 = new TestLayoutBox(60, 60);
		Box testBox5 = new TestLayoutBox(50, 50);
		Box testBox6 = new TestLayoutBox(30, 30);

		overflowListLayout.addBox(testBox1);
		overflowListLayout.addBox(testBox2);
		overflowListLayout.addBox(testBox3);
		overflowListLayout.addBox(testBox4);

		assertEquals(testBox1, overflowListLayout.getBox(0));
		assertEquals(testBox2, overflowListLayout.getBox(1));
		assertEquals(testBox3, overflowListLayout.getBox(2));
		assertEquals(testBox4, overflowListLayout.getBox(3));

		overflowListLayout.setBox(testBox6, 3);

		assertEquals(testBox1, overflowListLayout.getBox(0));
		assertEquals(testBox2, overflowListLayout.getBox(1));
		assertEquals(testBox3, overflowListLayout.getBox(2));
		assertEquals(testBox6, overflowListLayout.getBox(3));

		assertEquals(4, overflowListLayout.getBoxCount());
		assertEquals(2, overflowListLayout.getBoxIndex(testBox3));
		assertEquals(1, overflowListLayout.getBoxIndex(testBox2));
		assertEquals(120, overflowListLayout.getHeight_PX());
		assertEquals(30, overflowListLayout.getWidth_PX(), 0);

		overflowListLayout.insertBox(testBox5, 2);

		assertEquals(5, overflowListLayout.getBoxCount());

		assertEquals(testBox1, overflowListLayout.getBox(0));
		assertEquals(testBox2, overflowListLayout.getBox(1));
		assertEquals(testBox5, overflowListLayout.getBox(2));
		assertEquals(testBox3, overflowListLayout.getBox(3));
		assertEquals(testBox6, overflowListLayout.getBox(4));

		assertEquals(170, overflowListLayout.getHeight_PX());
		assertEquals(50, overflowListLayout.getWidth_PX(), 0);
		assertEquals(70, overflowListLayout.getOverflow(), 0);
		assertEquals(2, overflowListLayout.getOverflowStartIndex());

		overflowListLayout.removeBox(2);

		assertEquals(120, overflowListLayout.getHeight_PX());
		assertEquals(30, overflowListLayout.getWidth_PX(), 0);
		assertEquals(20, overflowListLayout.getOverflow(), 0);
		assertEquals(3, overflowListLayout.getOverflowStartIndex());

		assertEquals(0, overflowListLayout.getOutlierStartIndex(20));
		assertEquals(0, overflowListLayout.getOutlierStartIndex(29));
		assertEquals(1, overflowListLayout.getOutlierStartIndex(30));
		assertEquals(1, overflowListLayout.getOutlierStartIndex(31));
		assertEquals(2, overflowListLayout.getOutlierStartIndex(60));
		assertEquals(3, overflowListLayout.getOutlierStartIndex(95));

		OverflowListLayout overflowListLayout2 = new TestOverflowListLayout(Orientation.VERTICAL, 100);

		overflowListLayout.moveTail(overflowListLayout2, 2);

		assertEquals(testBox3, overflowListLayout2.getBox(0));
		assertEquals(testBox6, overflowListLayout2.getBox(1));
		assertEquals(2, overflowListLayout.getBoxCount());
		assertEquals(2, overflowListLayout2.getBoxCount());

		overflowListLayout2.moveHead(overflowListLayout, 0);

		assertEquals(3, overflowListLayout.getBoxCount());
		assertEquals(1, overflowListLayout2.getBoxCount());
		assertEquals(testBox6, overflowListLayout2.getBox(0));
		assertEquals(testBox3, overflowListLayout.getBox(2));
	}
}
