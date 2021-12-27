package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.infrastructure.UnitTestCase;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.ContinuousPageLayout;
import de.signWritingEditor.shared.layout.DocumentLayout;
import de.signWritingEditor.shared.layout.LineLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class DocumentLayoutTest extends UnitTestCase {
	TestDocumentLayout testDocumentLayout;
	private int defaultTestboxHeight;
	private int defaultTestboxWidth;

	@Before
	public void setUp() {
		testDocumentLayout = new TestDocumentLayout();
		defaultTestboxHeight = 30 - getFieldValue(LineLayout.class, "MARGIN_TOP")
				- getFieldValue(LineLayout.class, "BORDER_BOTTOM_WIDTH");
		defaultTestboxWidth = 30;
	}

	@Test
	public void testDocumentLayoutHasNoCalls() {
		assertEquals("", getDocumentLayout().getCallsAndReset());
	}

	@Test
	public void testPageInsert() {
		// Prepare
		ContinuousPageLayout page1 = new ContinuousPageLayout(createPageDimension(Orientation.VERTICAL, 100, 100));
		page1.setCanCompensate(true);

		ContinuousPageLayout page2 = new ContinuousPageLayout(createPageDimension(Orientation.VERTICAL, 100, 100));
		page2.setCanCompensate(true);

		ContinuousPageLayout page3 = new ContinuousPageLayout(createPageDimension(Orientation.HORIZONTAL, 50, 50));

		getDocumentLayout().insertPage(page1, 0);
		getDocumentLayout().insertPage(page2, 1);
		getDocumentLayout().insertPage(page3, 2);

		// Check
		assertEquals("onInsertPage onInsertPage onInsertPage", getDocumentLayout().getCallsAndReset());

		assertEquals(100, getDocumentLayout().getPageWidth(0));
		assertEquals(100, getDocumentLayout().getPageHeight(0));
		assertEquals(Orientation.VERTICAL, getDocumentLayout().getPageOrientation(0));
		assertEquals(100, getDocumentLayout().getPageWidth(1));
		assertEquals(100, getDocumentLayout().getPageHeight(1));
		assertEquals(50, getDocumentLayout().getPageWidth(2));
		assertEquals(50, getDocumentLayout().getPageHeight(2));

		assertEquals(Orientation.VERTICAL, getDocumentLayout().getPageOrientation(0));
		assertEquals(Orientation.VERTICAL, getDocumentLayout().getPageOrientation(1));
		assertEquals(Orientation.HORIZONTAL, getDocumentLayout().getPageOrientation(2));

		assertEquals(page1, getDocumentLayout().getPage(0));
		assertEquals(page2, getDocumentLayout().getPage(1));
		assertEquals(page3, getDocumentLayout().getPage(2));
		assertEquals(3, getDocumentLayout().getPageCount());
	}

	@Test
	public void testRemovePagesAndInsertAfter() {
		insertNewDefaultPage(0, false);
		insertNewDefaultPage(1, false);
		insertNewDefaultPage(2, false);
		ContinuousPageLayout pageHorizontal = new ContinuousPageLayout(
				createPageDimension(Orientation.HORIZONTAL, 50, 50));

		getDocumentLayout().removePages(1, 3);

		assertEquals(1, getDocumentLayout().getPageCount());

		getDocumentLayout().insertPage(pageHorizontal, 1);

		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(pageHorizontal, getDocumentLayout().getPage(1));
	}

	@Test
	public void testCompensateRemovesEmptyPages() {
		// Prepare
		insertNewDefaultPage(0, true);
		insertNewDefaultPage(1, true);
		insertNewDefaultPage(2, false);

		insertNewLineWithDefaultBoxes(0, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onRemovePage onRemovePage", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertFalse(getDocumentLayout().getPage(0).canCompensate());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
	}

	@Test
	public void testLineInsert() {
		// Prepare
		insertNewDefaultPage(0, false);

		// Action
		insertNewLine(0, 0, true);
		insertNewLine(0, 1, false);

		// Check
		assertEquals("onInsertPage onInsertNewLine onInsertNewLine", getDocumentLayout().getCallsAndReset());

		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
	}

	@Test
	public void testBoxInsert() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLine(0, 0, false);
		insertNewLine(0, 1, false);
		insertNewLine(0, 2, false);
		Box testBox1 = new TestLayoutBox(30, 20);
		Box testBox2 = new TestLayoutBox(20, 10);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().insertBox(testBox1, new BoxIndex(0, 0, 0));
		getDocumentLayout().insertBox(testBox2, new BoxIndex(0, 1, 0));
		insertDefaultBoxesToBeginningOfLine(0, 2, 1);

		// Check
		assertEquals("onInsertBox onInsertBox onInsertBox", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(testBox1, getDocumentLayout().getBox(new BoxIndex(0, 0, 0)));
		assertEquals(testBox2, getDocumentLayout().getBox(new BoxIndex(0, 1, 0)));
		assertEquals(defaultTestboxWidth, getDocumentLayout().getBox(new BoxIndex(0, 2, 0)).getWidth_PX(), 0);
		assertEquals(defaultTestboxHeight, getDocumentLayout().getBox(new BoxIndex(0, 2, 0)).getHeight_PX(), 0);
	}

	@Test
	public void testLineUnderflowHandling() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLine(0, 0, true);
		insertNewLine(0, 1, true);
		insertNewLine(0, 2, true);
		insertNewLine(0, 3, false);

		getDocumentLayout().insertBox(createDefaultTestLayoutBox(), new BoxIndex(0, 0, 0));
		getDocumentLayout().insertBox(createDefaultTestLayoutBox(), new BoxIndex(0, 1, 0));
		getDocumentLayout().insertBox(createDefaultTestLayoutBox(), new BoxIndex(0, 2, 0));
		getDocumentLayout().insertBox(createDefaultTestLayoutBox(), new BoxIndex(0, 3, 0));
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onMoveLineHead onRemoveLine onMoveLineHead onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());

		assertEquals(2, getDocumentLayout().getLineCount(0));

		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		assertFalse(getDocumentLayout().getPage(0).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
	}

	@Test
	public void testInsertBoxIntoAlreadyFilledLine() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);

		insertDefaultBoxesToBeginningOfLine(0, 0, 1);

		getDocumentLayout().resetCalls();

		// Precondition
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(4, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onMoveLineTail", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));

		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
	}

	@Test
	public void testInsertBoxIntoAlreadyFilledLineCreatesNewLine() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);

		insertDefaultBoxesToBeginningOfLine(0, 0, 2);
		getDocumentLayout().resetCalls();

		// Precondition
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(5, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onMoveLineTail onInsertNewLine onMoveLineTail", getDocumentLayout().getCallsAndReset());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
	}

	@Test
	public void testInsertingBoxIntoNotCompensateableFilledLineCreatesNewLine() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 3);
		insertDefaultBoxesToBeginningOfLine(0, 0, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onInsertNewLine onMoveLineTail", getDocumentLayout().getCallsAndReset());

		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));

		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));

		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
	}

	@Test
	public void testOverflowHandlingWithNotCompensateableLines() {
		// Prepare
		insertNewDefaultPage(0, true);
		insertNewDefaultPage(1, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		insertNewLineWithDefaultBoxes(0, 2, true, 3);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		insertDefaultBoxesToBeginningOfLine(0, 0, 3);
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onInsertBox onInsertBox onInsertBox onMoveLineTail onInsertNewLine onMoveLineTail onMovePageTail",
				getDocumentLayout().getCallsAndReset());

		assertEquals(2, getDocumentLayout().getPageCount());
		assertTrue(getDocumentLayout().getPage(0).canCompensate());
		assertFalse(getDocumentLayout().getPage(1).canCompensate());

		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getLineCount(1));

		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(1, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(1, 1)).canCompensate());

		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 1)));
	}

	@Test
	public void testPageOverflowHandlingByInsertingBoxAtBeginningOfPage() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 3);
		getDocumentLayout().resetCalls();

		// Action
		insertDefaultBoxesToBeginningOfLine(0, 0, 1);
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals(
				"onInsertBox onMoveLineTail onMoveLineTail onInsertNewLine onMoveLineTail onInsertPage onMovePageTail",
				getDocumentLayout().getCallsAndReset());

		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));

		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));

		assertTrue(getDocumentLayout().getPage(0).canCompensate());
		assertFalse(getDocumentLayout().getPage(1).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(1, 0)).canCompensate());
	}

	@Test
	public void testRemoveLine() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().removeLine(new LineIndex(0, 0));

		// Check
		assertEquals("onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
	}

	@Test
	public void testRemovingLineMovesPageHead() {
		// Prepare
		insertNewDefaultPage(0, true);
		insertNewDefaultPage(1, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 1);
		insertNewLineWithDefaultBoxes(1, 0, true, 3);
		insertNewLineWithDefaultBoxes(1, 1, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().removeLine(new LineIndex(0, 1));
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals("onRemoveLine onMovePageHead", getDocumentLayout().getCallsAndReset());

		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(1, 0)).canCompensate());
	}

	@Test
	public void testRemoveFirstLine() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().removeLine(new LineIndex(0, 0));
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals("onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testCallingCompensateTwiceDoesNotChangeLayout() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewDefaultPage(1, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		// Nothing happened
		assertEquals("", getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("", getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	@Test
	public void testPageUnderflowWithNotCompensateablePage() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewDefaultPage(1, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 3);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);

		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		// nothing happened
		assertEquals("", getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	@Test
	public void testPageUnderflowWithCompensateablePage() {
		// Prepare
		insertNewDefaultPage(0, true);
		insertNewDefaultPage(1, false);

		insertNewLineWithDefaultBoxes(0, 0, false, 3);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onMovePageHead onRemovePage", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testLineUnderflowByRemovingBoxes() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		getDocumentLayout().resetCalls();

		getDocumentLayout().removeBox(new BoxIndex(0, 1, 0));
		getDocumentLayout().removeBox(new BoxIndex(0, 0, 2));
		getDocumentLayout().resetCalls();

		// Precondition
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(0, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
	}

	@Test
	public void testRemoveBoxInNotCompensateableLine() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, false, 2);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);

		getDocumentLayout().removeBox(new BoxIndex(0, 0, 1));
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		// Nothing happened
		assertEquals("", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testSwitchCanCompensateAtFirstLine() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, false, 2);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().getLine(new LineIndex(0, 0)).setCanCompensate(true);
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testLargeBoxDoesNotFitIntoFirstLine() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().insertBox(new TestLayoutBox(60, defaultTestboxHeight), new BoxIndex(0, 1, 0));
		getDocumentLayout().removeBox(new BoxIndex(0, 0, 2));
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onInsertBox onRemoveBox", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));

		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testLineUnderflowByRemovingLargeBox() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 2);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		getDocumentLayout().insertBox(new TestLayoutBox(60, defaultTestboxHeight), new BoxIndex(0, 1, 0));
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().removeBox(new BoxIndex(0, 1, 0));
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onRemoveBox onMoveLineHead onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
	}

	@Test
	public void testRemoveAllBoxesInNotCompensateableLine() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		getDocumentLayout().removeBox(new BoxIndex(0, 0, 0));
		getDocumentLayout().removeBox(new BoxIndex(0, 0, 0));
		getDocumentLayout().removeBox(new BoxIndex(0, 0, 0));
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(0, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().removeLine(new LineIndex(0, 0));
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onRemoveLine", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
	}

	@Test
	public void testRemoveBoxAfterPageBreak() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 11);
		getDocumentLayout().compensate(new LineIndex(0, 0));
		getDocumentLayout().resetCalls();

		// Precondition
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));

		// Action
		getDocumentLayout().removeBox(new BoxIndex(1, 0, 0));
		getDocumentLayout().compensate(new LineIndex(1, 0));

		// Check
		assertEquals("onRemoveBox", getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	@Test
	public void testPageUnderflowByRemovingBox() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 10);
		getDocumentLayout().compensate(new LineIndex(0, 0));
		getDocumentLayout().resetCalls();

		// Precondition
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));

		// Action
		getDocumentLayout().removeBox(new BoxIndex(0, 2, 2));
		getDocumentLayout().compensate(new LineIndex(0, 2));
		assertEquals("onRemoveBox onMoveLineHead onRemoveLine onRemovePage", getDocumentLayout().getCallsAndReset());

		// Check
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
	}

	@Test
	public void testPageUnderflowByRemovingLine() {
		// Prepare
		insertNewDefaultPage(0, true);
		insertNewDefaultPage(1, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		insertNewLineWithDefaultBoxes(0, 2, true, 3);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().removeLine(new LineIndex(0, 1));
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals("onRemoveLine onMovePageHead onRemovePage", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 0)).canCompensate());
		assertTrue(getDocumentLayout().getLine(new LineIndex(0, 1)).canCompensate());
		assertFalse(getDocumentLayout().getLine(new LineIndex(0, 2)).canCompensate());
	}

	@Test
	public void testInsertLineBreak() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 3);
		getDocumentLayout().resetCalls();

		// Precondition
		assertFalse(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));
		assertTrue(getDocumentLayout().hasPageBreak(0)); // is last page

		// Action
		getDocumentLayout().insertLineBreak(new BoxIndex(0, 1, 2));
		getDocumentLayout().compensate(new LineIndex(0, 2)); // start in next
																// line

		// Check
		assertEquals("onInsertNewLine onMoveLineTail onMoveLineHead onInsertPage onMovePageTail",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertFalse(getDocumentLayout().hasLineBreak(new LineIndex(0, 0)));
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));
		assertFalse(getDocumentLayout().hasLineBreak(new LineIndex(0, 2)));
		assertFalse(getDocumentLayout().hasPageBreak(0));
		assertTrue(getDocumentLayout().hasPageBreak(1));
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	@Test
	public void testRemoveLineBreak() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);
		insertNewLineWithDefaultBoxes(0, 2, false, 3);
		getDocumentLayout().resetCalls();

		// Precondition
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().removeLineBreak(new LineIndex(0, 1));
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals("onMoveLineHead", getDocumentLayout().getCallsAndReset());
		assertFalse(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
	}

	@Test
	public void testAutoPageBreakByInsertingBoxes() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 3);
		getDocumentLayout().resetCalls();

		// Precondition
		assertTrue(getDocumentLayout().hasPageBreak(0)); // is last page

		// Action
		// create auto-page-break after first page
		insertDefaultBoxesToBeginningOfLine(0, 0, 2);
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onInsertBox onInsertBox " + //
				"onMoveLineTail onMoveLineTail onInsertNewLine onMoveLineTail onInsertPage onMovePageTail",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));

		assertFalse(getDocumentLayout().hasPageBreak(0)); // auto-page-break
		assertTrue(getDocumentLayout().hasPageBreak(1)); // is last page
	}

	@Test
	public void testAutoPageBreakWithLargeBox() {
		// Prepare
		insertNewDefaultPage(0, false);

		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 1);
		TestLayoutBox largeBox = new TestLayoutBox(defaultTestboxWidth, 101);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().insertBox(largeBox, new BoxIndex(0, 0, 0));
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals("onInsertBox onMoveLineTail onMoveLineTail onInsertPage onMovePageTail",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertEquals(1, getDocumentLayout().getLineCount(0));
		assertEquals(2, getDocumentLayout().getLineCount(1));
		assertEquals(largeBox, getDocumentLayout().getBox(new BoxIndex(0, 0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(1, 1)));
	}

	@Test
	public void testManualPageBreak() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 3);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().insertPageBreak(new BoxIndex(0, 1, 2)); // manual
																	// page
																	// break
		getDocumentLayout().compensate(new LineIndex(1, 0)); // start on next
																// page

		// Check
		assertEquals("onInsertPage onInsertNewLine onMoveLineTail onMovePageTail",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertTrue(getDocumentLayout().hasPageBreak(0));
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));
		assertEquals(2, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	@Test
	public void testRemovePageBreak() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewDefaultPage(1, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 2);
		insertNewLineWithDefaultBoxes(1, 0, false, 1);
		getDocumentLayout().resetCalls();

		// Precondition
		assertTrue(getDocumentLayout().hasPageBreak(0));
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));

		// Action
		getDocumentLayout().removePageBreak(0);
		getDocumentLayout().compensate(new LineIndex(0, 1)); // start in last
																// line of first
		// page

		// Check
		assertEquals("onMovePageHead onRemovePage", getDocumentLayout().getCallsAndReset());
		assertEquals(1, getDocumentLayout().getPageCount());
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1))); // still
																			// there!
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
	}

	@Test
	public void testRemovePageBreakByRemovingLastLineBreakOnPage() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewDefaultPage(1, true);
		insertNewDefaultPage(2, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, false, 1);
		insertNewLineWithDefaultBoxes(1, 0, true, 3);
		insertNewLineWithDefaultBoxes(1, 1, true, 3);
		insertNewLineWithDefaultBoxes(1, 2, true, 3);
		insertNewLineWithDefaultBoxes(2, 0, false, 3);
		getDocumentLayout().resetCalls();

		// Precondition
		assertTrue(getDocumentLayout().hasPageBreak(0));
		assertTrue(getDocumentLayout().hasLineBreak(new LineIndex(0, 1)));
		assertFalse(getDocumentLayout().hasPageBreak(1));

		// Action
		getDocumentLayout().removeLineBreak(new LineIndex(0, 1));
		getDocumentLayout().removePageBreak(0);
		getDocumentLayout().compensate(new LineIndex(0, 1));

		// Check
		assertEquals(
				"onMoveLineHead onMoveLineHead onMoveLineHead onMoveLineHead onMovePageHead onMovePageHead onRemovePage",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertFalse(getDocumentLayout().hasLineBreak(new LineIndex(0, 1))); // also
																			// gone!
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(3, getDocumentLayout().getLineCount(1));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(1, 1)));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(1, 2)));
	}

	@Test
	public void testSetBox() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, false, 2);
		TestLayoutBox testBox = new TestLayoutBox(40, defaultTestboxHeight);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().setBox(testBox, new BoxIndex(0, 0, 0));

		// Check
		assertEquals("onSetBox", getDocumentLayout().getCallsAndReset());
		assertEquals(testBox, getDocumentLayout().getBox(new BoxIndex(0, 0, 0)));
		assertFalse(testBox.equals(getDocumentLayout().getBox(new BoxIndex(0, 0, 1))));
	}

	@Test
	public void testPageBreakBehaviourByUpdatingBox() {
		// Prepare
		insertNewDefaultPage(0, false);
		insertNewLineWithDefaultBoxes(0, 0, true, 3);
		insertNewLineWithDefaultBoxes(0, 1, true, 3);
		insertNewLineWithDefaultBoxes(0, 2, false, 3);
		getDocumentLayout().resetCalls();

		// Action
		getDocumentLayout().setBox(new TestLayoutBox(101, defaultTestboxHeight), new BoxIndex(0, 0, 0));
		getDocumentLayout().compensate(new LineIndex(0, 0));

		// Check
		assertEquals(
				"onSetBox onMoveLineTail onMoveLineTail onInsertNewLine onMoveLineTail onInsertPage onMovePageTail",
				getDocumentLayout().getCallsAndReset());
		assertEquals(2, getDocumentLayout().getPageCount());
		assertFalse(getDocumentLayout().hasPageBreak(0));
		assertEquals(3, getDocumentLayout().getLineCount(0));
		assertEquals(1, getDocumentLayout().getLineCount(1));
		assertEquals(1, getDocumentLayout().getBoxCount(new LineIndex(0, 0)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayout().getBoxCount(new LineIndex(0, 2)));
		assertEquals(2, getDocumentLayout().getBoxCount(new LineIndex(1, 0)));
	}

	// private operations

	private TestDocumentLayout getDocumentLayout() {
		return testDocumentLayout;
	}

	private void insertDefaultBoxesToBeginningOfLine(int pageIndex, int lineIndex, int numberOfBoxes) {
		assert 0 <= pageIndex && pageIndex < getDocumentLayout()
				.getPageCount() : "0 <= pageIndex && pageIndex < testDocumentLayout.getPageCount()";
		assert 0 <= lineIndex && lineIndex < getDocumentLayout()
				.getLineCount(pageIndex) : "0 <= lineIndex && lineIndex < testDocumentLayout.getLineCount(pageIndex)";
		assert numberOfBoxes > 0 : "Precondition failed: numberOfBoxes > 0";
		for (int i = 0; i < numberOfBoxes; i++) {
			getDocumentLayout().insertBox(createDefaultTestLayoutBox(), new BoxIndex(pageIndex, lineIndex, 0));
		}
	}

	private void insertNewLine(int pageIndex, int lineIndex, boolean canCompensate) {
		assert 0 <= pageIndex && pageIndex < getDocumentLayout()
				.getPageCount() : "0 <= pageIndex && pageIndex < testDocumentLayout.getPageCount()";
		assert 0 <= lineIndex && lineIndex <= getDocumentLayout()
				.getLineCount(pageIndex) : "0 <= lineIndex && lineIndex <= testDocumentLayout.getLineCount(pageIndex)";
		getDocumentLayout().insertNewLine(new LineIndex(pageIndex, lineIndex));
		getDocumentLayout().getLine(new LineIndex(pageIndex, lineIndex)).setCanCompensate(canCompensate);
	}

	private void insertNewDefaultPage(int pageIndex, boolean canCompensate) {
		assert 0 <= pageIndex && pageIndex <= getDocumentLayout()
				.getPageCount() : "0 <= pageIndex && pageIndex <= testDocumentLayout.getPageCount()";
		ContinuousPageLayout page = new ContinuousPageLayout(createPageDimension(Orientation.VERTICAL, 100, 100));
		page.setCanCompensate(canCompensate);
		getDocumentLayout().insertPage(page, pageIndex);
	}

	private void insertNewLineWithDefaultBoxes(int pageIndex, int lineIndex, boolean canCompensate, int numberOfBoxes) {
		assert 0 <= pageIndex && pageIndex < getDocumentLayout()
				.getPageCount() : "0 <= pageIndex && pageIndex < testDocumentLayout.getPageCount()";
		assert 0 <= lineIndex && lineIndex <= getDocumentLayout()
				.getLineCount(pageIndex) : "0 <= lineIndex && lineIndex <= testDocumentLayout.getLineCount(pageIndex)";
		assert numberOfBoxes > 0 : "Precondition failed: numberOfBoxes > 0";

		getDocumentLayout().insertNewLine(new LineIndex(pageIndex, lineIndex));
		getDocumentLayout().getLine(new LineIndex(pageIndex, lineIndex)).setCanCompensate(canCompensate);
		insertDefaultBoxesToBeginningOfLine(pageIndex, lineIndex, numberOfBoxes);
	}

	private TestLayoutBox createDefaultTestLayoutBox() {
		return new TestLayoutBox(defaultTestboxWidth, defaultTestboxHeight);
	}

	private PageFormat createPageDimension(Orientation orientation, int width, int height) {
		PageFormat result = new PageFormat("test", orientation, 120d, width, height, 0, 0, 0, 0);
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private class TestDocumentLayout extends DocumentLayout {

		private StringBuilder calls;

		public TestDocumentLayout() {
			calls = new StringBuilder();
		}

		public String getCallsAndReset() {
			String result = calls.toString();
			calls = new StringBuilder();
			assert result != null : "Postcondition failed: result != null";
			return result;
		}

		public void resetCalls() {
			calls = new StringBuilder();
		}

		@Override
		public void onRemovePage(int pageIndex) {
			countCall("onRemovePage");
		}

		@Override
		public void onRemoveLine(LineIndex lineIndexObject) {
			countCall("onRemoveLine");
		}

		@Override
		public void onRemoveBox(BoxIndex boxIndexObject) {
			countCall("onRemoveBox");
		}

		@Override
		public void onMovePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength) {
			countCall(fromLineIndexObject.getPageIndex() < toLineIndexObject.getPageIndex() ? "onMovePageTail"
					: "onMovePageHead");
		}

		@Override
		public void onMoveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength) {
			countCall(fromBoxIndexObject.getPageIndex() < toBoxIndexObject.getPageIndex()
					|| (fromBoxIndexObject.getPageIndex() == toBoxIndexObject.getPageIndex()
							&& fromBoxIndexObject.getLineIndex() < toBoxIndexObject.getLineIndex()) ? "onMoveLineTail"
									: "onMoveLineHead");
		}

		@Override
		public void onInsertPage(int pageIndex, PageLayout pageLayout) {
			countCall("onInsertPage");
		}

		@Override
		public void onInsertNewLine(LineIndex lineIndexObject, Orientation pageOrientation) {
			countCall("onInsertNewLine");
		}

		@Override
		public void onInsertBox(Box box, BoxIndex boxIndexObject, Orientation pageOrientation) {
			countCall("onInsertBox");
		}

		@Override
		public void onSetBox(Box box, BoxIndex boxIndexObject) {
			countCall("onSetBox");
		}

		@Override
		public void onMoveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject) {
			countCall("onMoveLine");

		}

		// private operations
		private void countCall(String methodName) {
			assert methodName != null : "Precondition failed: methodName != null";
			if (calls.length() > 0) {
				calls.append(" ");
			}
			calls.append(methodName);
		}

		@Override
		public void onRemoveSnippet(int pageIndex, int snippetIndex) {
			countCall("onRemoveSnippet");
		}
	}

}
