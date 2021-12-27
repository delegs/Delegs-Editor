package de.signWritingEditor.test.integration.ui.collage;

import org.junit.Test;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.LineLayout;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class FreeTextIntegrationTest extends CollageIntegrationTestCase {
	private DocumentPanelImpl documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanelImpl) getPanel(getGwtDocumentEditor());
		RootPanel.get().add(createScrollPanels());
	}

	// needed because of scrollToPage (DocumentPanel) used in methods all tests
	// use (onAddFreepositionablePage)
	private ScrollPanel createScrollPanels() {
		ScrollPanel scrollPanel = new ScrollPanel();
		ScrollPanel innerScrollPanel = new ScrollPanel();
		innerScrollPanel.add(documentPanel);
		scrollPanel.add(innerScrollPanel);
		return scrollPanel;
	}

	protected DocumentPanelImpl getDocumentPanel() {
		return documentPanel;
	}

	@Test
	public void testFreePositionedResizeFreeTextBoxLargerThenParagraphWidth() {
		// Prepare
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int paragraphWidth = 200;
		int innerParagraphWidth = 170;

		getDocumentEditorSidebarListener().onAddCollage();
		Section collage = getDocument().getSection(1);
		getDocumentUiListener().addParagraph(collage.getCollageId(), 0, 0, paragraphWidth, false);
		getDocumentUiListener().onMoveCursorToLineStart(collage.getParagraph(0).getToken(0).getId(), false);
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 1, 0)) instanceof FreeTextTokenBox);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 2, 0)) instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter()
				.getBox(new BoxIndex(1, 0, 1, 0));
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		FreeTextTokenBoxWidget freeTextTokenBoxWidget = getDocumentPanel()
				.getFreeTextLineWidget(new BoxIndex(1, 0, 1, 0));

		// Precondition
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());

		// Action
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, innerParagraphWidth + 10);

		// Check
		assertEquals(-1, freeTextToken.getWidth());
		assertTrue(freeTextToken.isFreeTextLine());

		assertTrue(freeTextTokenBox.isLine());
		assertEquals(innerParagraphWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(innerParagraphWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) innerParagraphWidth, freeTextTokenBox.getWidth_PX(), 0);

		assertTrue(freeTextTokenBoxWidget.isFreeTextLine());
		assertEquals((innerParagraphWidth) + "px", freeTextTokenBoxWidget.getElement().getStyle().getWidth());
	}

	@Test
	public void testFreePositionedResizeFreeTextBoxSmallerThenParagraphWidth() {
		// Prepare
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int marginRight = getFreeTextBoxMarginRight();
		int paragraphWidth = 200;
		int innerParagraphWidth = 170;

		getDocumentEditorSidebarListener().onAddCollage();
		Section collage = getDocument().getSection(1);
		getDocumentUiListener().addParagraph(collage.getCollageId(), 0, 0, paragraphWidth, false);
		getDocumentUiListener().onMoveCursorToLineStart(collage.getParagraph(0).getToken(0).getId(), false);
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 1, 0)) instanceof FreeTextTokenBox);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 2, 0)) instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter()
				.getBox(new BoxIndex(1, 0, 1, 0));
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		FreeTextTokenBoxWidget freeTextTokenBoxWidget = getDocumentPanel()
				.getFreeTextLineWidget(new BoxIndex(1, 0, 1, 0));
		// Precondition
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertFalse(freeTextToken.isFreeTextLine());

		// Action
		int newWidth = innerParagraphWidth - 10;
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, newWidth);

		// Check
		assertFalse(freeTextToken.isFreeTextLine());
		assertEquals(newWidth - sliderWidth, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) newWidth + marginRight, freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());
		assertEquals(newWidth + "px", freeTextTokenBoxWidget.getElement().getStyle().getWidth());
	}

	@Test
	public void testFreePositionedResizeFreeTextLineSmallerThenParagraphWidth() {
		// Prepare
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int marginRight = getFreeTextBoxMarginRight();
		int paragraphWidth = 200;
		int innerParagraphWidth = 170;
		getDocumentEditorSidebarListener().onAddCollage();
		Section collage = getDocument().getSection(1);
		getDocumentUiListener().addParagraph(collage.getCollageId(), 0, 0, paragraphWidth, false);
		getDocumentUiListener().onMoveCursorToLineStart(collage.getParagraph(0).getToken(0).getId(), false);
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 1, 0)) instanceof FreeTextTokenBox);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 2, 0)) instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter()
				.getBox(new BoxIndex(1, 0, 1, 0));
		assertTrue(getDocument().getToken(freeTextTokenBox.getId()) instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(freeTextTokenBox.getId());

		FreeTextTokenBoxWidget freeTextTokenBoxWidget = getDocumentPanel()
				.getFreeTextLineWidget(new BoxIndex(1, 0, 1, 0));
		// Precondition
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());

		// Action
		int newWidth = innerParagraphWidth - 10;
		setFixedFreeTextBoxSize(freeTextTokenBoxWidget, newWidth);

		// Check
		assertFalse(freeTextToken.isFreeTextLine());
		assertEquals(newWidth - sliderWidth, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(newWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) newWidth + marginRight, freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());

		assertEquals(newWidth + "px", freeTextTokenBoxWidget.getElement().getStyle().getWidth());
	}

	@Test
	public void testFreePositionedAddFreeTextLine() {
		// Prepare
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int paragraphWidth = 200;
		int innerParagraphWidth = 170;

		getDocumentEditorSidebarListener().onAddCollage();
		Section collage = getDocument().getSection(1);
		getDocumentUiListener().addParagraph(collage.getCollageId(), 0, 0, paragraphWidth, false);
		getDocumentUiListener().onMoveCursorToLineStart(collage.getParagraph(0).getToken(0).getId(), false);

		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 1, 0)) instanceof FreeTextTokenBox);
		DocumentIndex documentIndex = new DocumentIndex(1, 0, 0);

		// Action
		getDocumentEditorSidebarListener().onAddFreeTextLine();

		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);

		// Check - Document/Layout/Widget
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);

		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 1, 0));
		assertTrue(tokenBoxWidget instanceof FreeTextTokenBoxWidget);
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) tokenBoxWidget;

		assertTrue(freeTextToken.isFreeTextLine());

		assertEquals(-1, freeTextToken.getWidth());

		assertTrue(freeTextTokenBox.isLine());
		assertEquals(innerParagraphWidth - sliderWidth, freeTextTokenBox.getMinWidth());
		assertEquals(innerParagraphWidth - sliderWidth, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) innerParagraphWidth, freeTextTokenBox.getWidth_PX(), 0);

		assertTrue(freeTextTokenBoxWidget.isFreeTextLine());
		assertEquals(innerParagraphWidth + "px", freeTextTokenBoxWidget.getElement().getStyle().getWidth());
	}

	@Test
	public void testAddFreeTextBox() {
		// Prepare
		int sliderWidth = getFreeTextTokenBoxSliderWidth();
		int marginRight = getFreeTextBoxMarginRight();
		int defaultFreeTextBoxWidth = 100;
		int paragraphWidth = 200;
		int innerParagraphWidth = 170;

		getDocumentEditorSidebarListener().onAddCollage();
		Section collage = getDocument().getSection(1);
		getDocumentUiListener().addParagraph(collage.getCollageId(), 0, 0, paragraphWidth, false);
		getDocumentUiListener().onMoveCursorToLineStart(collage.getParagraph(0).getToken(0).getId(), false);

		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(1, 0, 1, 0)) instanceof FreeTextTokenBox);
		DocumentIndex documentIndex = new DocumentIndex(1, 0, 0);
		// Action
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);

		// Check - Document/Layout/Widget
		Token token = getDocument().getToken(nextDocumentIndex.getSectionIndex(), nextDocumentIndex.getParagraphIndex(),
				nextDocumentIndex.getTokenIndex());
		assertTrue(token instanceof FreeTextToken);
		FreeTextToken freeTextToken = (FreeTextToken) token;

		BoxIndex boxIndex = getGwtDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) getGwtDocumentLayouter().getBox(boxIndex);

		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(new BoxIndex(1, 0, 1, 0));
		assertTrue(tokenBoxWidget instanceof FreeTextTokenBoxWidget);
		FreeTextTokenBoxWidget freeTextTokenBoxWidget = (FreeTextTokenBoxWidget) tokenBoxWidget;

		assertFalse(freeTextToken.isFreeTextLine());

		assertEquals(-1, freeTextToken.getWidth());

		assertFalse(freeTextTokenBox.isLine());
		assertEquals(defaultFreeTextBoxWidth, freeTextTokenBox.getMinWidth());
		assertEquals(innerParagraphWidth - sliderWidth - marginRight, freeTextTokenBox.getMaxWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals((float) defaultFreeTextBoxWidth + sliderWidth + marginRight, freeTextTokenBox.getWidth_PX(), 0);

		assertFalse(freeTextTokenBoxWidget.isFreeTextLine());
		assertEquals(defaultFreeTextBoxWidth + sliderWidth + "px",
				freeTextTokenBoxWidget.getElement().getStyle().getWidth());
	}

	@Test
	public void testFreePositionedDeleteFreeTextLine() {
		// Prepare
		DocumentPanelImpl panel = getDocumentPanel();
		int paragraphWidth = 250;
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(getDocument().getSectionCount() - 1).getCollageId();
		getDocumentUiListener().addParagraph(collageId, 10, 10, paragraphWidth, true);
		Id paragraphId = getDocument().getSection(1).getParagraph(0).getParagraphId();
		Paragraph paragraph = getDocument().getParagraph(paragraphId);
		getDocumentEditorSidebarListener().onAddFreeTextLine();
		assertEquals(3, paragraph.getTokenCount());

		assertTrue(paragraph.getToken(0) instanceof SignItemToken);
		assertTrue(paragraph.getToken(1) instanceof FreeTextToken);
		assertTrue(paragraph.getToken(2) instanceof FreeTextToken);

		FreeTextToken tokenToDelete = (FreeTextToken) paragraph.getToken(2);
		assertTrue(tokenToDelete.isFreeTextLine());

		int originalParagraphWidth = paragraph.getWidth();
		float originalSnippetLayoutWidth = getGwtDocumentLayouter().getPage(1).getBox(0).getWidth_PX();
		Object originalSnippetPanelWidth = ((SelectedFlowPanel) panel.getPage(1).getWidget(0)).getWidth();

		// Action
		getDocumentUiListener().onDeletePrevious(tokenToDelete.getId());

		// Check
		assertEquals(2, paragraph.getTokenCount());
		assertTrue(paragraph.getToken(0) instanceof SignItemToken);
		assertTrue(paragraph.getToken(1) instanceof FreeTextToken);
		assertEquals(originalParagraphWidth, paragraph.getWidth());

		assertEquals(1, getGwtDocumentLayouter().getPage(1).getBoxCount());
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		SnippetLayout snippet = (SnippetLayout) getGwtDocumentLayouter().getPage(1).getBox(0);
		assertTrue(((LineLayout) snippet.getBox(0)).getBox(0) instanceof SignItemTokenBox);
		assertTrue(((LineLayout) snippet.getBox(1)).getBox(0) instanceof FreeTextTokenBox);
		assertEquals(2, snippet.getBoxCount());
		assertEquals(1, (((LineLayout) snippet.getBox(0)).getBoxCount()));
		assertEquals(1, (((LineLayout) snippet.getBox(1)).getBoxCount()));
		assertEquals(originalSnippetLayoutWidth, snippet.getWidth_PX());

		assertEquals(1, panel.getPage(1).getWidgetCount());
		assertTrue(panel.getPage(1).getWidget(0) instanceof SelectedFlowPanel);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) panel.getPage(1).getWidget(0);
		assertTrue(
				((OrientedFlowPanel) segmentPanel.getWidget(0)).getWidget(0) instanceof LayoutedSignItemTokenBoxWidget);
		assertTrue(((OrientedFlowPanel) segmentPanel.getWidget(1)).getWidget(0) instanceof FreeTextTokenBoxWidget);
		assertEquals(2, segmentPanel.getWidgetCount());
		assertEquals(1, ((OrientedFlowPanel) segmentPanel.getWidget(0)).getWidgetCount());
		assertEquals(1, ((OrientedFlowPanel) segmentPanel.getWidget(1)).getWidgetCount());
		assertEquals(originalSnippetPanelWidth, segmentPanel.getWidth());
	}

	@Test
	public void testFreePositionedDeleteFreeTextBox() {
		// Prepare
		DocumentPanelImpl panel = (DocumentPanelImpl) getDocumentPanel();
		int paragraphWidth = 200;
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(getDocument().getSectionCount() - 1).getCollageId();
		getDocumentUiListener().addParagraph(collageId, 10, 10, paragraphWidth, true);
		Id paragraphId = getDocument().getSection(1).getParagraph(0).getParagraphId();
		Paragraph paragraph = getDocument().getParagraph(paragraphId);
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		assertEquals(3, paragraph.getTokenCount());

		assertTrue(paragraph.getToken(0) instanceof SignItemToken);
		assertTrue(paragraph.getToken(1) instanceof FreeTextToken);
		assertTrue(paragraph.getToken(2) instanceof FreeTextToken);

		FreeTextToken tokenToDelete = (FreeTextToken) paragraph.getToken(1);
		assertFalse(tokenToDelete.isFreeTextLine());
		int originalParagraphWidth = paragraph.getWidth();
		float originalSnippetLayoutWidth = getGwtDocumentLayouter().getPage(1).getBox(0).getWidth_PX();
		int originalSnippetPanelWidth = ((SelectedFlowPanel) panel.getPage(1).getWidget(0)).getWidth();

		// Action
		getDocumentUiListener().onDeletePrevious(tokenToDelete.getId());

		// Check
		assertEquals(2, paragraph.getTokenCount());
		assertTrue(paragraph.getToken(0) instanceof SignItemToken);
		assertTrue(paragraph.getToken(1) instanceof FreeTextToken);
		assertTrue(originalParagraphWidth == paragraph.getWidth());

		assertEquals(1, getGwtDocumentLayouter().getPage(1).getBoxCount());
		assertTrue(getGwtDocumentLayouter().getPage(1).getBox(0) instanceof SnippetLayout);
		SnippetLayout segment = (SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0);
		assertEquals(2, segment.getBoxCount());
		assertTrue(((OverflowListLayout) segment.getBox(0)).getBox(0) instanceof SignItemTokenBox);
		assertTrue(((OverflowListLayout) segment.getBox(1)).getBox(0) instanceof FreeTextTokenBox);
		assertTrue(originalSnippetLayoutWidth == segment.getWidth_PX());

		assertEquals(1, panel.getPage(1).getWidgetCount());
		assertTrue(panel.getPage(1).getWidget(0) instanceof SelectedFlowPanel);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) panel.getSnippet(1, 0);
		assertEquals(2, segmentPanel.getWidgetCount());
		assertTrue(((FlowPanel) segmentPanel.getWidget(0)).getWidget(0) instanceof LayoutedSignItemTokenBoxWidget);
		assertTrue(((FlowPanel) segmentPanel.getWidget(1)).getWidget(0) instanceof FreeTextTokenBoxWidget);
		assertTrue(originalSnippetPanelWidth == segmentPanel.getWidth());
	}
}
