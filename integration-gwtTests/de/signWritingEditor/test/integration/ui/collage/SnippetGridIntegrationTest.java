package de.signWritingEditor.test.integration.ui.collage;

import org.junit.Test;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.CollagePanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class SnippetGridIntegrationTest extends CollageIntegrationTestCase {

	private DocumentPanelImpl documentPanel;
	private Document document;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();

		documentPanel = (DocumentPanelImpl) getPanel(getGwtDocumentEditor());
		document = getGwtDocumentEditor().getDocument();
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

	protected Document getDocument() {
		return document;
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	// Duplicate
	public boolean isCollage(int pageIndex) {
		assert pageIndex < getDocumentPanel().getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		return getDocumentPanel().getPage(pageIndex).getParent() instanceof CollagePanel;
	}

	@Test
	public void testSnippetSnapsToGridOnXAchsisForPositiveMarginForTheLeftSide() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		generateParagraph(collageId, 10, 10, 100);

		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getX_PX());

		assertEquals(0, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());

		// Action
		((SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0)).updatePosition(43, 10);

		// Tests
		assertEquals(40, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(40, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(40, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());
	}

	@Test
	public void testSnippetSnapsToGridOnXAchsisForNegativeMarginForTheLeftSide() {
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		generateParagraph(collageId, 10, 10, 100);

		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(0, getGwtDocumentLayouter().getSnippet(1, 0).getX_PX());
		assertEquals(0, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());

		// Action
		((SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0)).updatePosition(37, 10);

		// Tests
		// Test domain model
		assertEquals(40, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(40, getGwtDocumentLayouter().getSnippet(1, 0).getX_PX());
		assertEquals(40, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());
		// Test UI
		assertEquals(PageFormat.A4_PORTRAIT.getPixelPaddingLeft_PX(),
				getDocumentPanel().getPage(1).getWidget(0).getOffsetWidth());
		assertEquals(PageFormat.A4_PORTRAIT.getPixelPaddingLeft_PX(), getDocumentPanel().getPage(1).getAbsoluteLeft());
	}

	@Test
	public void testSnippetSnapsToGridOnYAchsisForPositiveMarginForTheTop() {
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		generateParagraph(collageId, 10, 10, 100);
		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionY());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getY_PX());
		assertEquals(0,
				convertTopStringToInt(getDocumentPanel().getPage(1).getWidget(0).getElement().getStyle().getTop()));

		// Action
		((SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0)).updatePosition(10, 43);

		// Tests

		assertEquals(40, getDocument().getSection(1).getParagraph(0).getPositionY());
		assertEquals(40, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getY_PX());
		assertEquals(40,
				convertTopStringToInt(getDocumentPanel().getPage(1).getWidget(0).getElement().getStyle().getTop()));
	}

	@Test
	public void testSnippetSnapsToGridOnYAchsisForNegativeMarginForTheTop() {
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		generateParagraph(collageId, 10, 10, 100);
		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionY());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getY_PX());
		assertEquals(0,
				convertTopStringToInt(getDocumentPanel().getPage(1).getWidget(0).getElement().getStyle().getTop()));

		// Action
		((SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0)).updatePosition(10, 37);

		// Tests

		assertEquals(40, getDocument().getSection(1).getParagraph(0).getPositionY());
		assertEquals(40, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getY_PX());
		assertEquals(40,
				convertTopStringToInt(getDocumentPanel().getPage(1).getWidget(0).getElement().getStyle().getTop()));
	}

	public void testSnippetWidthSnapsToGridFromTheRight() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		Id paragraphId = generateParagraph(collageId, 10, 10, 130);
		Paragraph paragraph = getDocument().getParagraph(paragraphId);

		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, paragraph.getPositionX());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(0, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());

		assertEquals(130, paragraph.getWidth());
		assertEquals(130, getGwtDocumentLayouter().getSnippet(1, 0).getWidth_PX(), 0);
		assertEquals(130, getDocumentPanel().getPage(1).getWidget(0).getOffsetWidth());

		// Action
		SelectedFlowPanel freePositionedFlowPanel = (SelectedFlowPanel) documentPanel.getPage(1).getWidget(0);
		int newWidth = 140;
		invokeHandleWidthChangedOnSelectedFlowPanel(freePositionedFlowPanel, newWidth, false);

		// Check
		assertEquals(163, freePositionedFlowPanel.getWidth());
		assertEquals(163, paragraph.getWidth());
		assertEquals(163, getGwtDocumentLayouter().getSnippet(1, 0).getWidth_PX(), 0);
		assertEquals(163, getDocumentPanel().getPage(1).getWidget(0).getOffsetWidth());
	}

	public void testSnippetWidthSnapsToGridFromTheLeft() {

		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		generateParagraph(collageId, 10, 10, 100);
		// Require
		assertTrue(collageId != null);
		assertTrue(getDocument().getSection(1).isCollage());
		assertTrue(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(isCollage(1));

		assertEquals(1, getDocument().getParagraphCount(1));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(0, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());

		assertEquals(100, getDocument().getSection(1).getParagraph(0).getWidth());
		assertEquals(100.0f, getGwtDocumentLayouter().getSnippet(1, 0).getWidth_PX(), 0);
		assertEquals(100, getDocumentPanel().getPage(1).getWidget(0).getOffsetWidth());

		// Action
		SelectedFlowPanel panel = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);
		int deltaX = 3;

		resizeFromTheLeftByDeltaX(panel, deltaX);

		// Test
		assertEquals(0, getDocument().getSection(1).getParagraph(0).getPositionX());
		assertEquals(0, ((SnippetLayout) getGwtDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(0, getDocumentPanel().getPage(1).getWidget(0).getAbsoluteLeft());

		assertEquals(163, panel.getWidth());
		assertEquals(163, getDocument().getSection(1).getParagraph(0).getWidth());
		assertEquals(163.0f, getGwtDocumentLayouter().getSnippet(1, 0).getWidth_PX(), 0);
		assertEquals(163, getDocumentPanel().getPage(1).getWidget(0).getOffsetWidth());
	}

	private int convertTopStringToInt(String top) {
		int splitAt = top.indexOf("px");
		assert splitAt >= 0 : "Unit was not in Pixel";
		String num = top.substring(0, splitAt);
		return Integer.parseInt(num);
	}

	private void resizeFromTheLeftByDeltaX(SelectedFlowPanel panel, int deltaX) {
		invokeResizeOnSelectedFlowPanel(panel, deltaX, false);
		invokeMoveOnSelectedFlowPanel(panel, -deltaX, 0);
	}
}
