package de.signWritingEditor.test.layout.collage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class GWTDocumentLayouterTest extends LayoutTestCase {

	@Test
	public void testAddSnippetLayout() {
		// Prepare

		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, getIdFactory().createId(), true);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;

		// Action
		getDocumentLayouter().addSnippetToCollagePage(null, pageIndex, 11, 35, 134, 0);

		// Check
		PageLayout page = getDocumentLayouter().getPage(pageIndex);
		assertEquals(1, page.getBoxCount());
		assertTrue(page instanceof CollagePageLayout);
		assertTrue(page.getBox(0) instanceof SnippetLayout);
		SnippetLayout snippet = (SnippetLayout) page.getBox(0);
		assertEquals(11, snippet.getX_PX());
		assertEquals(35, snippet.getY_PX());
		assertEquals(134, snippet.getWidth_PX(), 0);
	}
}
