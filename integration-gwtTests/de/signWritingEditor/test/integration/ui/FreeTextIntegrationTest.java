package de.signWritingEditor.test.integration.ui;

import org.junit.Test;

import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class FreeTextIntegrationTest extends IntegrationTestCase {
	private DocumentPanel documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	private Document getDocument() {
		return getGwtDocumentEditor().getDocument();
	}

	@Test
	public void testResizeFreeTextBoxLargerThenParagraphWidth() {
		// Prepare
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextTokenBoxWidget.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		int paragraphWidth = getGwtDocumentLayouter().getPage(boxIndex.getPageIndex()).getMaxWidth();
		int maxFreeTextTokenWidth = paragraphWidth - getFreeTextTokenBoxSliderWidth();
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		// Precondition
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());

		// Action
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, paragraphWidth + 10);

		// Check
		assertEquals(-1, freeTextToken.getWidth());
		assertTrue(freeTextToken.isFreeTextLine());

		assertTrue(freeTextTokenBox.isLine());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(maxFreeTextTokenWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) paragraphWidth, freeTextTokenBox.getWidth_PX(), 0);

		assertTrue(freeTextTokenBoxWidget.isFreeTextLine());
		checkWidgetWidth(freeTextTokenBoxWidget, paragraphWidth);
	}

	@Test
	public void testResizeFreeTextBoxSmallerThenParagraphWidth() {
		// Prepare
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextTokenBoxWidget.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int freeTextTokenMarginRight = getFreeTextBoxMarginRight();
		int paragraphWidth = getGwtDocumentLayouter().getPage(boxIndex.getPageIndex()).getMaxWidth();
		int maxFreeTextTokenWidth = paragraphWidth - sliderWidth - freeTextTokenMarginRight;
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		// Precondition
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());

		// Action
		int newWidth = maxFreeTextTokenWidth - 10;
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, newWidth);

		// Check
		assertFalse(freeTextToken.isFreeTextLine());
		assertEquals(newWidth - sliderWidth, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) newWidth + freeTextTokenMarginRight, freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());
		checkWidgetWidth(freeTextTokenBoxWidget, newWidth);
	}

	private void checkWidgetWidth(Widget widget, int expectedWidth) {
		String widgetWidth = widget.getElement().getStyle().getWidth();
		assertEquals(expectedWidth + "px", widgetWidth);
	}

	@Test
	public void testResizeFreeTextLineSmallerThenParagraphWidth() {
		// Prepare
		getDocumentEditorSidebarListener().onAddFreeTextLine();
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextTokenBoxWidget.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int freeTextTokenMarginRight = getFreeTextBoxMarginRight();
		int freeTextTokenBoxDecorationWidth = sliderWidth + freeTextTokenMarginRight;
		int paragraphWidth = getGwtDocumentLayouter().getPage(boxIndex.getPageIndex()).getMaxWidth();
		int maxFreeTextTokenWidth = paragraphWidth - freeTextTokenBoxDecorationWidth;
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		// Precondition
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());

		// Action
		int newWidth = maxFreeTextTokenWidth - 10;
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, newWidth);

		// Check
		assertFalse(freeTextToken.isFreeTextLine());
		assertEquals(newWidth - sliderWidth, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) newWidth + freeTextTokenMarginRight, freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());
		checkWidgetWidth(freeTextTokenBoxWidget, newWidth);
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
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int freeTextTokenBoxDecorationWidth = sliderWidth;
		int freeTextTokenWidth = paragraphWidth - freeTextTokenBoxDecorationWidth;

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		// Check - Document/Layout/Widget
		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		assertTrue(freeTextToken.isFreeTextLine());
		// -1 means a flexible FreeTextToken width
		assertEquals(-1, freeTextToken.getWidth());

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);
		assertTrue(freeTextTokenBox.isLine());
		assertEquals(freeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(freeTextTokenWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) paragraphWidth, freeTextTokenBox.getWidth_PX(), 0);

		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 1, 0));
		assertTrue(tokenBoxWidget instanceof FreeTextTokenBoxWidget);
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) tokenBoxWidget;
		assertTrue(freeTextTokenBoxWidget.isFreeTextLine());
		checkWidgetWidth(freeTextTokenBoxWidget, paragraphWidth);
	}

	@Test
	public void testAddFreeTextBox() {

		int sectionIndex = 0;
		int paragraphIndex = 0;
		int tokenIndex = 0;
		Id id = getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex).getId();
		DocumentIndex documentIndex = getDocument().getDocumentIndex(id);
		int paragraphWidth = getGwtDocumentLayouter().getLine(new LineIndex(0, 0)).getOverflowThreshold();
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int freeTextTokenMarginRight = getFreeTextBoxMarginRight();
		int defaultFreeTextTokenWidth = 100;

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		// Check - Document/Layout/Widget
		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;
		// -1 means a flexible FreeTextToken width

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);

		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1));
		assertTrue(tokenBoxWidget instanceof FreeTextTokenBoxWidget);
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) tokenBoxWidget;

		assertFalse(freeTextToken.isFreeTextLine());
		assertEquals(-1, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(defaultFreeTextTokenWidth, freeTextTokenBox.getMinWidth());
		assertEquals(paragraphWidth - sliderWidth - getFreeTextBoxMarginRight(), freeTextTokenBox.getMaxWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) defaultFreeTextTokenWidth + sliderWidth + freeTextTokenMarginRight,
				freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());
		checkWidgetWidth(freeTextTokenBoxWidget, defaultFreeTextTokenWidth + sliderWidth);
	}

	@Test
	public void testFreeTextLineLayoutOnLineBreak() {
		// Prepare
		FontMetricSpecifier defaultFontMetric = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL,
				FontSizeService.STANDARD_FONT_SIZE, FontWeight.NORMAL);
		FontMetricSpecifier targetFontMetric = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL,
				FontSize.SIZE_8, FontWeight.NORMAL);
		Id firstTokenId = getDocument().getFirstTokenInDocument().getId();
		Id lastAddedTokenId = getDocument().getLastTokenInDocument().getId();
		Id firstAddedFreeTextLineId = lastAddedTokenId;
		assertEquals(firstTokenId, getCurrentCursorTokenId(getGwtDocumentEditor()));
		getDocumentEditorSidebarListener().onFontSizeChanged(targetFontMetric.getFontSize());
		Token firstFreeTextLineToken = getDocument().getToken(firstAddedFreeTextLineId);
		assertNotNull(firstFreeTextLineToken);
		assertEquals(FreeTextToken.class, firstFreeTextLineToken.getClass());
		FreeTextToken firstAddedFreeTextToken = (FreeTextToken) firstFreeTextLineToken;
		assertEquals(defaultFontMetric, firstAddedFreeTextToken.getStyle().getFontMetricSpecifier());

		// Action
		getDocumentUiListener().onTextChanged(firstTokenId, "\n", 0);

		// Check - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(2, getDocument().getParagraphCount(0));
		assertEquals(2, getDocument().getTokenCount(0, 0));
		assertEquals(2, getDocument().getTokenCount(0, 1));
		Id secondAddedFreeTextLineId = getNextTokenId(firstTokenId);
		Token secondAddedFreeTextLineToken = getDocument().getToken(secondAddedFreeTextLineId);
		assertNotNull(secondAddedFreeTextLineToken);
		assertEquals(FreeTextToken.class, secondAddedFreeTextLineToken.getClass());
		FreeTextToken secondAddedFreeTextToken = (FreeTextToken) secondAddedFreeTextLineToken;
		assertEquals(defaultFontMetric, secondAddedFreeTextToken.getStyle().getFontMetricSpecifier());
		assertEquals(defaultFontMetric, firstAddedFreeTextToken.getStyle().getFontMetricSpecifier());
		assertEquals(firstAddedFreeTextToken.getStyle().getFontMetricSpecifier(),
				secondAddedFreeTextToken.getStyle().getFontMetricSpecifier());

		// Check - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(4, getGwtDocumentLayouter().getLineCount(0));
		Box firstAddedFreeTextLineBox = getBoxById(firstAddedFreeTextLineId);
		assertNotNull(firstAddedFreeTextLineBox);
		assertEquals(FreeTextTokenBox.class, firstAddedFreeTextLineBox.getClass());
		FreeTextTokenBox firstAddedFreeTextBox = (FreeTextTokenBox) firstAddedFreeTextLineBox;
		assertEquals(defaultFontMetric, firstAddedFreeTextBox.getFontMetricSpecifier());
		Box secondAddedFreeTextLineBox = getBoxById(secondAddedFreeTextLineId);
		assertNotNull(secondAddedFreeTextLineBox);
		assertEquals(FreeTextTokenBox.class, firstAddedFreeTextLineBox.getClass());
		FreeTextTokenBox secondAddedFreeTextBox = (FreeTextTokenBox) secondAddedFreeTextLineBox;
		assertEquals(defaultFontMetric, secondAddedFreeTextBox.getFontMetricSpecifier());
		assertEquals(firstAddedFreeTextBox.getFontMetricSpecifier(), secondAddedFreeTextBox.getFontMetricSpecifier());

		// Check - Widget
		AbstractTokenBoxWidget firstAddedFreeTextLineWidget = getTokenBoxWidgetById(firstAddedFreeTextLineId);
		assertNotNull(firstAddedFreeTextLineWidget);
		assertEquals(FreeTextTokenBoxWidget.class, firstAddedFreeTextLineWidget.getClass());
		assertEquals(getFontSizeService().getHeight_PX(defaultFontMetric), firstAddedFreeTextLineWidget.getOffsetHeight());
		AbstractTokenBoxWidget secondAddedFreeTextLineWidget = getTokenBoxWidgetById(secondAddedFreeTextLineId);
		assertNotNull(secondAddedFreeTextLineWidget);
		assertEquals(FreeTextTokenBoxWidget.class, secondAddedFreeTextLineWidget.getClass());
		assertEquals(getFontSizeService().getHeight_PX(defaultFontMetric),
				secondAddedFreeTextLineWidget.getOffsetHeight());
	}

	private Box getBoxById(Id id) {
		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(id);
		return getGwtDocumentLayouter().getBox(idBoxIndex);
	}

	private Id getNextTokenId(Id token) {
		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(getDocument().getDocumentIndex(token));
		return getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex()).getId();
	}

	private AbstractTokenBoxWidget getTokenBoxWidgetById(Id tokenId) {
		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(tokenId);
		return getDocumentPanel().getTokenBoxWidget(idBoxIndex);
	}

}