package de.signWritingEditor.test.integration.layout.collage;

import org.junit.Test;

import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class FreeTextLayoutIntegrationTest extends CollageIntegrationTestCase {

	@Test
	public void testFreePositionedAddFreeTextLine() {
		// Prepare
		int paragraphWidth = 250;
		int innerParagraphWidth = 220;
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(getDocument().getSectionCount() - 1).getCollageId();
		Id paragraphId = generateParagraph(collageId, 10, 10, paragraphWidth);
		Paragraph paragraph = getDocument().getParagraph(paragraphId);
		int maxFreeTextTokenWidth = innerParagraphWidth - getFreeTextTokenBoxSliderWidth();

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		// Check - Document/Layout
		Token token = paragraph.getToken(paragraph.getTokenCount() - 1);
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		assertTrue(freeTextToken.isFreeTextLine());

		assertEquals(-1, freeTextToken.getWidth());

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		assertTrue(freeTextTokenBox.isLine());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) innerParagraphWidth, freeTextTokenBox.getWidth_PX(), 0);
	}

	@Test
	public void testFreePositionedAddFreeTextBox() {
		// Prepare
		int paragraphWidth = 250;
		int innerParagraphWidth = 220;
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(getDocument().getSectionCount() - 1).getCollageId();
		Id paragraphId = generateParagraph(collageId, 10, 10, paragraphWidth);
		Paragraph paragraph = getDocument().getParagraph(paragraphId);
		int defaultTokenboxWidth = 100;
		int minFreeTextTokenWidth = defaultTokenboxWidth;
		int maxFreeTextTokenWidth = innerParagraphWidth - getFreeTextTokenBoxSliderWidth()
				- getFreeTextBoxMarginRight();

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		// Check - Document/Layout
		// Has an automatic freeTextLine at the end
		assertEquals(3, paragraph.getTokenCount());
		Token token = paragraph.getToken(1);
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		assertFalse(freeTextToken.isFreeTextLine());
		// -1 means automatically resize
		assertEquals(-1, freeTextToken.getWidth());

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		assertFalse(freeTextTokenBox.isLine());
		assertEquals(minFreeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) defaultTokenboxWidth + getFreeTextTokenBoxSliderWidth() + getFreeTextBoxMarginRight(),
				freeTextTokenBox.getWidth_PX(), 0);
	}

}
