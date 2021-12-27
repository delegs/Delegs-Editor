package de.signWritingEditor.test.integration.layout.collage;

import org.junit.Test;

import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class PageBreakIntegrationTest extends CollageIntegrationTestCase {

	@Test
	public void testAddCollage() {
		// Prepare

		// Action
		getDocumentEditorSidebarListener().onAddCollage();

		// Check - Document/Layout
		int sectionCount = getDocument().getSectionCount();
		int lastPageIndex = sectionCount - 1;
		assertEquals(2, sectionCount);
		assertTrue(getDocument().getSection(lastPageIndex).isCollage());

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		PageLayout page = getGwtDocumentLayouter().getPage(lastPageIndex);
		assertNotNull(page);
		assertEquals(page.getClass(), CollagePageLayout.class);
	}

}
