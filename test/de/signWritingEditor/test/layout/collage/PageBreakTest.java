package de.signWritingEditor.test.layout.collage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class PageBreakTest extends LayoutTestCase {

	@Test
	/**
	 * Checks that no normal page is added after adding a free positionable page
	 */
	public void testAddCollagePage() {
		// Prepare

		// Action
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, getIdFactory().createId(), true);

		// Check
		assertEquals(getDocumentLayouter().getPageCount(), 1);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;
		PageLayout page = getDocumentLayouter().getPage(pageIndex);
		assertEquals(0, page.getBoxCount());
		assertTrue(page instanceof CollagePageLayout);
	}
}
