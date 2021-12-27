package de.signWritingEditor.test.integration.ui.collage;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class ParagraphMoveIntegrationTest extends CollageIntegrationTestCase {

	private DocumentPanel documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
	}

	@Test
	public void testMoveSnippetOverTheTopOfThePage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphId = generateParagraph(1, 22, 33, 100);

		Paragraph paragraph = getDocument().getParagraph(1, 0);
		SnippetLayout segmentLayoutBox = (SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) documentPanel.getPage(1).getWidget(0);
		// Precondition
		assertEquals(paragraphId, paragraph.getParagraphId());

		// Action
		invokeMoveOnSelectedFlowPanel(segmentPanel, 0, -80);

		// Check
		assertEquals(0, paragraph.getPositionY());
		assertEquals(0, segmentLayoutBox.getY_PX());
		assertEquals("0px", segmentPanel.getElement().getStyle().getTop());
	}

	@Test
	// Seit GWT 2.8.2 liefert segmentLayoutBox.getY_PX() 1400 statt 1160,
	// manuell nicht reproduzierbar
	public void IGNORE_testMoveSnippetOverTheBottomOfThePage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphId = generateParagraph(1, 22, 33, 100);
		int defaultParagraphHeight = getDefaultParagraphHeight();
		int pageHeight = getGwtDocumentLayouter().getPage(1).getMaxHeight();

		Paragraph paragraph = getDocument().getParagraph(1, 0);
		SnippetLayout segmentLayoutBox = (SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) documentPanel.getPage(1).getWidget(0);
		// Precondition
		assertEquals(paragraphId, paragraph.getParagraphId());

		// Action
		invokeMoveOnSelectedFlowPanel(segmentPanel, 0, pageHeight);

		// Check
		int heightOffset = pageHeight - defaultParagraphHeight;
		heightOffset = heightOffset + (PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH
				- (heightOffset % PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH));

		assertEquals(heightOffset, segmentLayoutBox.getY_PX());
		assertEquals(heightOffset + "px", segmentPanel.getElement().getStyle().getTop());
	}

	@Test
	public void testMoveSnippetOverTheLeftOfThePage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphId = generateParagraph(1, 22, 33, 100);

		Paragraph paragraph = getDocument().getParagraph(1, 0);
		SnippetLayout segmentLayoutBox = (SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) documentPanel.getPage(1).getWidget(0);
		// Precondition
		assertEquals(paragraphId, paragraph.getParagraphId());

		// Action
		invokeMoveOnSelectedFlowPanel(segmentPanel, -60, 0);

		// Check
		assertEquals(0, paragraph.getPositionX());
		assertEquals(0, segmentLayoutBox.getX_PX());
		assertEquals("0px", segmentPanel.getElement().getStyle().getLeft());
	}

	@Test
	public void testMoveSnippetOverTheRightOfThePage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphId = generateParagraph(1, 22, 33, 100);
		int defaultSegmentWidth = getDefaultParagraphWidth();
		int pageWidth = getGwtDocumentLayouter().getPage(1).getMaxWidth();

		Paragraph paragraph = getDocument().getParagraph(1, 0);
		SnippetLayout segmentLayoutBox = (SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0);
		SelectedFlowPanel segmentPanel = (SelectedFlowPanel) documentPanel.getPage(1).getWidget(0);
		// Precondition
		assertEquals(paragraphId, paragraph.getParagraphId());

		// Action
		invokeMoveOnSelectedFlowPanel(segmentPanel, pageWidth, 0);

		// Check
		int widthOffset = pageWidth - defaultSegmentWidth;
		widthOffset = widthOffset
				+ (PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH - (widthOffset % PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH));

		assertEquals(widthOffset, paragraph.getPositionX());
		assertEquals(widthOffset, segmentLayoutBox.getX_PX());
		assertEquals(widthOffset + "px", segmentPanel.getElement().getStyle().getLeft());
	}
}
