package de.signWritingEditor.test.integration.ui.collage;

import org.junit.Test;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class ParagraphSelectionTest extends CollageIntegrationTestCase {

	private DocumentPanel documentPanel;
	private Document document;
	private Id collageId;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();

		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
		document = getGwtDocumentEditor().getDocument();

		getDocumentEditorSidebarListener().onAddCollage();

		assertEquals(2, document.getSectionCount());
		assertTrue(document.getSection(1).isCollage());

		collageId = document.getSection(1).getCollageId();

		RootPanel.get().add((DocumentPanelImpl) documentPanel);
	}

	protected Document getDocument() {
		return document;
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	@Test
	public void testParagraphCountAfterSelection() {
		// Prepare
		getDocumentUiListener().addParagraph(collageId, 10, 10, 300, false);
		SelectedFlowPanel line = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);

		// Action
		line.setSelection(true);
		// Test

		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(1, getDocumentPanel().getSnippetCount(1));
	}

	@Test
	public void testSingleParagraphSelectionPosition() {
		// Prepare
		getDocumentUiListener().addParagraph(collageId, 10, 10, 300, false);
		final SelectedFlowPanel line = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);

		// Action
		line.setSelection(true);
		// Test
		final SimplePanel boarderPanel = (SimplePanel) getSelectedBorderPanel(line);
		// BoarderPanel and Paragraph should be at the same position
		// BoarderPanel and Paragraph should be at the same position
		delayTestFinish(100);
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				assertTrue(boarderPanel.isAttached());
				assertTrue(boarderPanel.isVisible());

				finishTest();
			}
		});
	}

	@Test
	public void testMultipleParagraphSelectionPosition() {
		getDocumentUiListener().addParagraph(collageId, 10, 10, 300, false);
		getDocumentUiListener().addParagraph(collageId, 30, 30, 300, false);
		getDocumentUiListener().addParagraph(collageId, 100, 100, 300, false);

		// Action
		getDocumentUiListener().onSelectSnippetsFromTo(collageId, 0, 0, 130, 130, false);

		// TEST
		SelectedFlowPanel firstLine = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);
		SimplePanel boarderPanel = (SimplePanel) getSelectedBorderPanel(firstLine);
		// BoarderPanel and Paragraph should be at the same position
		assertTrue(boarderPanel.isAttached());
		assertTrue(boarderPanel.isVisible());

		SelectedFlowPanel secondLine = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);
		boarderPanel = (SimplePanel) getSelectedBorderPanel(secondLine);
		// BoarderPanel and Paragraph should be at the same position
		assertTrue(boarderPanel.isAttached());
		assertTrue(boarderPanel.isVisible());

		SelectedFlowPanel thirdLine = (SelectedFlowPanel) getDocumentPanel().getPage(1).getWidget(0);
		boarderPanel = (SimplePanel) getSelectedBorderPanel(thirdLine);
		// BoarderPanel and Paragraph should be at the same position
		assertTrue(boarderPanel.isAttached());
		assertTrue(boarderPanel.isVisible());
	}

	protected native Object getSelectedBorderPanel(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::selectedBorderPanel;
	}-*/;
}
