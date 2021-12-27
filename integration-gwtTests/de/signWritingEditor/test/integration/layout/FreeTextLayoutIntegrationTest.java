package de.signWritingEditor.test.integration.layout;

import org.junit.Test;

import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class FreeTextLayoutIntegrationTest extends IntegrationTestCase {
	public static final int TOKEN_BOX_PIXEL_HEIGHT = SimpleSign.SIGN_HEIGHT_PX + PageFormat.SEARCH_WORD_BOX_PIXEL_HEIGHT
			+ PageFormat.SEARCH_WORD_BOX_PIXEL_HEIGHT;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	private Document getDocument() {
		return getGwtDocumentEditor().getDocument();
	}

	/**
	 * Test special case where freeTextLine is on next page: Create a special
	 * page with smaller height.
	 * <p>
	 */
	@Test
	public void testRemoveAndInsertWithFreeTextLineOnNewPage() {
		// Prepare
		int pageCountAtTestStart = getGwtDocumentLayouter().getPageCount();
		PageFormat customPageFormat = new PageFormat("A4 Hochformat", Orientation.VERTICAL, PageFormat.DEFAULT_DPI, 990,
				TOKEN_BOX_PIXEL_HEIGHT + 5, 0, 0, 0, 0);
		Id freeTextId = getIdFactory().createId();
		String freeText = "FreeText";
		SignItemToken token6 = getTokenFactory().createSignItemToken("token6",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		// Action
		getGwtDocumentLayouter().addPage(customPageFormat);
		getGwtDocumentLayouter().addNewLine();
		getGwtDocumentLayouter().addToken(token6, true, true);
		insertFreeTextLineAfter(token6.getId(), freeTextId, freeText, true);

		// Check
		assertEquals(pageCountAtTestStart + 2, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart));
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart + 1));

		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart + 1, 0)));

		assertTrue(
				getGwtDocumentLayouter().getBox(new BoxIndex(pageCountAtTestStart, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getGwtDocumentLayouter()
				.getBox(new BoxIndex(pageCountAtTestStart + 1, 0, 0)) instanceof FreeTextTokenBox);

		// Prepare
		SignItemToken token7 = getTokenFactory().createSignItemToken("token7",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		// Action
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token6.getId(), true, true, token7);

		// Check
		assertEquals(pageCountAtTestStart + 3, getGwtDocumentLayouter().getPageCount());

		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart));
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart + 1));
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart + 2));

		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart + 1, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart + 2, 0)));

		assertTrue(
				getGwtDocumentLayouter().getBox(new BoxIndex(pageCountAtTestStart, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getGwtDocumentLayouter()
				.getBox(new BoxIndex(pageCountAtTestStart + 1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getGwtDocumentLayouter()
				.getBox(new BoxIndex(pageCountAtTestStart + 2, 0, 0)) instanceof FreeTextTokenBox);

		// Action
		getGwtDocumentLayouter().removeLineBreakAfter(token6.getId());

		// Check
		assertEquals(pageCountAtTestStart + 2, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart));
		assertEquals(1, getGwtDocumentLayouter().getLineCount(pageCountAtTestStart + 1));

		assertEquals(2, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(pageCountAtTestStart + 1, 0)));

		assertTrue(
				getGwtDocumentLayouter().getBox(new BoxIndex(pageCountAtTestStart, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(
				getGwtDocumentLayouter().getBox(new BoxIndex(pageCountAtTestStart, 0, 1)) instanceof SignItemTokenBox);
		assertTrue(getGwtDocumentLayouter()
				.getBox(new BoxIndex(pageCountAtTestStart + 1, 0, 0)) instanceof FreeTextTokenBox);

		assertTrue(getGwtDocumentLayouter().containsFreeTextBox(freeTextId));

		BoxIndex freeTextBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextId);
		Box freeTextBox = getGwtDocumentLayouter().getBox(freeTextBoxIndex);

		assertTrue(freeTextBox instanceof FreeTextTokenBox);
	}

	private void insertFreeTextLineAfter(Id previousToken, Id freeTextLineId, String freeText, boolean visibile) {

		FreeTextToken freeTextToken = getTokenFactory().createFreeTextToken(freeTextLineId,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle());
		freeTextToken.setText(freeText);
		BoxIndex index = getGwtDocumentLayouter().getIdBoxIndex(previousToken);
		int width = getGwtDocumentLayouter().getPage(index.getPageIndex()).getMaxWidth();// -
																							// PageFormat.FREE_TEXT_LINE_SLIDER_WIDTH;
		freeTextToken.setWidth(width);
		freeTextToken.setIsFreeTextLine(true);
		getGwtDocumentLayouter().insertTokenAfter(previousToken, freeTextToken, visibile, visibile);
	}

	@Test
	public void testAddFreeTextLine() {
		// Prepare
		int sectionIndex = getDocument().getSectionCount() - 1;
		int paragraphIndex = getDocument().getParagraphCount(sectionIndex) - 1;
		int tokenIndex = getDocument().getTokenCount(sectionIndex, paragraphIndex) - 2;
		Id id = getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex).getId();
		DocumentIndex documentIndex = getDocument().getDocumentIndex(id);
		int paragraphWidth = getGwtDocumentLayouter().getPage(0).getMaxWidth();
		int maxFreeTextTokenWidth = paragraphWidth - getFreeTextTokenBoxSliderWidth();

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		// Check - Document/Layout
		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		assertTrue(freeTextToken.isFreeTextLine());
		// -1 means a flexible width of a freeTextToken
		assertEquals(-1, freeTextToken.getWidth());

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		assertTrue(freeTextTokenBox.isLine());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals("Java script cache has cached the wrong values, please clear the cache",
				paragraphWidth - maxFreeTextTokenWidth, getFreeTextTokenBoxSliderWidth());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMaxWidth());
		assertEquals((float) paragraphWidth, freeTextTokenBox.getWidth_PX(), 0);
	}

	@Test
	public void testAddFreeTextBox() {
		// Prepare
		int sectionIndex = getDocument().getSectionCount() - 1;
		int paragraphIndex = getDocument().getParagraphCount(sectionIndex) - 1;
		int tokenIndex = getDocument().getTokenCount(sectionIndex, paragraphIndex) - 2;
		Id id = getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex).getId();
		DocumentIndex documentIndex = getDocument().getDocumentIndex(id);
		int paragraphWidth = getGwtDocumentLayouter().getPage(0).getMaxWidth();
		int minFreeTextTokenBoxWidth = 100;
		int maxFreeTextTokenBoxWidth = paragraphWidth - getFreeTextTokenBoxSliderWidth() - getFreeTextBoxMarginRight();

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		// Check - Document/Layout
		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		assertFalse(freeTextToken.isFreeTextLine());
		// -1 means a flexible width of a freeTextToken
		assertEquals(-1, freeTextToken.getWidth());

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		assertFalse(freeTextTokenBox.isLine());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals("Java script cache has cached the wrong values, please clear the cache",
				paragraphWidth - maxFreeTextTokenBoxWidth,
				getFreeTextTokenBoxSliderWidth() + getFreeTextBoxMarginRight());
		assertEquals(minFreeTextTokenBoxWidth, freeTextTokenBox.getMinWidth());
		assertEquals(maxFreeTextTokenBoxWidth, freeTextTokenBox.getMaxWidth());
		assertEquals((float) minFreeTextTokenBoxWidth + getFreeTextTokenBoxSliderWidth() + getFreeTextBoxMarginRight(),
				freeTextTokenBox.getWidth_PX(), 0);
	}

}
