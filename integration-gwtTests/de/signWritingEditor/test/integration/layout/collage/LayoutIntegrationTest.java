package de.signWritingEditor.test.integration.layout.collage;

import org.junit.Test;

import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class LayoutIntegrationTest extends CollageIntegrationTestCase {

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	@Test
	public void testAddSnippetLayout() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();

		// Action
		Id paragraph = generateParagraph(1, 22, 33, 100);

		// Check
		PageLayout page = getGwtDocumentLayouter().getPage(getPageIndexFromParagraphId(paragraph));
		assertTrue(page instanceof CollagePageLayout);
		assertEquals(1, page.getBoxCount());
		assertTrue(page.getBox(0) instanceof SnippetLayout);
		SnippetLayout segmentLayout = (SnippetLayout) page.getBox(0);
		assertEquals(40, segmentLayout.getX_PX());
		assertEquals(40, segmentLayout.getY_PX());
		assertEquals(100, segmentLayout.getWidth_PX(), 0);
	}
}
