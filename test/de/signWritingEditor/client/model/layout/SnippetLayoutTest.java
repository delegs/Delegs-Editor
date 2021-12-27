package de.signWritingEditor.client.model.layout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.shared.layout.LineLayout;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.Orientation;

public class SnippetLayoutTest extends LayoutTestCase {

	@Test
	public void testSnippetLayoutHeight() {
		// Prepare
		int height = 42;
		SnippetLayout layout = new SnippetLayout(10, 10, 0, 100, 500);
		LineLayout line = layout.getLine(0);

		// Action
		line.addBox(new TestLayoutBox(10, height));

		// Check
		int expectedHeight = height + line.getMarginTop_PX() + line.getMarginBottom_PX();
		assertEquals(expectedHeight, layout.getHeight_PX());
	}

	@Test
	public void testSnippetLayoutHeightMultipleLines() {
		// Prepare
		int height = 58;
		SnippetLayout layout = new SnippetLayout(10, 10, 0, 100, 500);
		layout.addBox(new LineLayout(Orientation.HORIZONTAL, 100));
		LineLayout firstLine = layout.getLine(0);
		LineLayout secondLine = layout.getLine(1);

		// Action
		firstLine.addBox(new TestLayoutBox(10, height));
		secondLine.addBox(new TestLayoutBox(10, 2 * height));
		secondLine.addBox(new TestLayoutBox(10, height));

		// Check
		int expectedHeight = 3 * height + firstLine.getMarginTop_PX() + firstLine.getMarginBottom_PX()
				+ secondLine.getMarginTop_PX() + secondLine.getMarginBottom_PX();
		assertEquals(expectedHeight, layout.getHeight_PX());
	}
}
