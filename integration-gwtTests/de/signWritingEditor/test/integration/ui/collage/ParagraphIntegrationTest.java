package de.signWritingEditor.test.integration.ui.collage;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Tokenizer;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.test.integration.infrastructure.CollageIntegrationTestCase;

public class ParagraphIntegrationTest extends CollageIntegrationTestCase {

	private DocumentPanelImpl documentPanel;

	private Set<Id> selectedIDsInGwt;
	private Set<Id> selectedParagraphs;
	private Document document;

	@SuppressWarnings("unchecked")
	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		Object selectedIDs = getSelectedIDsFromDocumentEditor(getGwtDocumentEditor());
		this.selectedIDsInGwt = (Set<Id>) selectedIDs;

		documentPanel = (DocumentPanelImpl) getPanel(getGwtDocumentEditor());

		document = getGwtDocumentEditor().getDocument();
		this.selectedParagraphs = new HashSet<Id>();
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

	@Test
	public void testInsertCollage() {
		// Precondition
		int pageCount = getDocumentPanel().getPageCount();
		assertEquals(1, pageCount);

		// Require
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));

		// Actions
		getDocumentEditorSidebarListener().onAddCollage();

		// Check
		assertEquals(pageCount + 1, getDocument().getSectionCount());
		assertEquals(pageCount + 1, getGwtDocumentLayouter().getPageCount());
		assertEquals(pageCount + 1, getDocumentPanel().getPageCount());

		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(0, getGwtDocumentLayouter().getSnippetCount(1));

		assertEquals(2, getDocumentPanel().getLineCount(0));
		assertEquals(0, getDocumentPanel().getSnippetCount(1));

		assertFalse(getDocumentPanel().isCollage(0));
		assertTrue(getDocumentPanel().isCollage(1));
	}

	@Test
	public void testAdressCollageById() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		Id tokenId = getDocument().getSection(0).getParagraph(0).getToken(0).getId();

		// Preconditions
		assertNotNull(collageId);
		assertNotNull(tokenId);

		// Action
		generateParagraph(collageId, 10, 10, 130);
		getDocumentUiListener().onTextChanged(tokenId, " " + Tokenizer.PAGE_BREAK + " Hallo", 0);

		// Check
		assertFalse(getDocument().getSection(1).isCollage());
		assertTrue(getDocument().getSection(2).isCollage());

		assertFalse(getGwtDocumentLayouter().getPage(1) instanceof CollagePageLayout);
		assertTrue(getGwtDocumentLayouter().getPage(2) instanceof CollagePageLayout);

		assertFalse(getDocumentPanel().isCollage(1));
		assertTrue(getDocumentPanel().isCollage(2));

		assertEquals(collageId, getDocument().getSection(2).getCollageId());
		assertEquals(2, getDocument().getSectionIndexForCollageId(collageId));

		assertEquals(1, getDocument().getParagraphCount(2));
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(2));
		assertEquals(1, getDocumentPanel().getSnippetCount(2));
	}

	@Test
	public void testDeleteCollageByDeletingOnlyTokenOnPage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraph = generateParagraph(1, 10, 10, 130);

		// Preconditions
		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentPanel().getPageCount());

		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(1, 0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(1, 0, 1)));
		assertEquals(1, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(1, 0, 0)));
		assertEquals(1, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(1, 0, 1)));

		// Actions
		Id id = getDocument().getParagraph(paragraph).getToken(1).getId();
		getDocumentUiListener().onDeletePrevious(id);
		id = getDocument().getParagraph(paragraph).getToken(0).getId();
		getDocumentUiListener().onDeletePrevious(id);

		// Check
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getDocumentPanel().getPageCount());

		assertFalse(getGwtDocumentLayouter().getPage(0) instanceof CollagePageLayout);

		assertFalse(getDocumentPanel().isCollage(0));
	}

	@Test
	public void testDeleteCollageBySelectingAndThenDeletingAllParagraphs() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		generateParagraph(1, 10, 10, 130);
		generateParagraph(1);

		for (Id id : getGeneratedParagraphs()) {
			toggleSelectionOfID(id, true);
		}

		// Precondition
		assertEquals(2, getDocument().getSectionCount());
		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(selectedIDsInGwt.size(), getGeneratedParagraphs().size());

		// Action
		getDocumentUiListener().onDeleteSnippet();

		// Check
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getDocumentPanel().getPageCount());

		assertFalse(getDocument().getSection(0).isCollage());
		assertFalse(getGwtDocumentLayouter().getPage(0) instanceof CollagePageLayout);
		assertFalse(getDocumentPanel().isCollage(0));
	}

	@Test
	public void testSelectWithClick() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphId = generateParagraph(getDocument().getSectionCount() - 1);

		// Precondition
		assertEquals("snippet", getStyleOfParagraph(paragraphId));

		// Actions
		getDocumentUiListener().onToggleSnippetSelection(paragraphId, true);

		// Check
		assertEquals(selectedIDsInGwt.size(), 1);
		assertTrue("Paragraph[" + paragraphId + "] is not in selected set", selectedIDsInGwt.contains(paragraphId));
		assertHasSelectionBorder(paragraphId);
	}

	@Test
	public void testDeleteSelectedParagraph() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		generateParagraphs(2, getDocument().getSectionCount() - 1);
		Id paragraphToDeleteId = getGeneratedParagraphs().get(0);
		Id remainingParagraphId = getGeneratedParagraphs().get(1);
		int pageIndex = getPageIndexFromParagraphId(paragraphToDeleteId);
		getDocumentUiListener().onToggleSnippetSelection(paragraphToDeleteId, true);

		// Actions
		getDocumentUiListener().onDeleteSnippet();

		// Check
		assertEquals(selectedIDsInGwt.size(), 0);
		assertFalse(getDocument().containsParagraph(paragraphToDeleteId));
		assertEquals(getDocumentPanel().getPage(pageIndex).getWidgetCount(), 1);
		SelectedFlowPanel freePositonedFlowPanel = (SelectedFlowPanel) getDocumentPanel().getPage(pageIndex)
				.getWidget(0);
		Id freePositonedFlowPanelId = (Id) getIDFromSelectedFlowPanel(freePositonedFlowPanel);
		assertEquals(freePositonedFlowPanelId, remainingParagraphId);
	}

	@Test
	public void testDeleteSelectedParagraphAndPage() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id paragraphToDeleteId = generateParagraph(getDocument().getSectionCount() - 1);
		int pageIndex = getPageIndexFromParagraphId(paragraphToDeleteId);
		FlowPanel pageToDelete = getDocumentPanel().getPage(pageIndex);
		int pageCountBeforeDeleting = getDocumentPanel().getPageCount();
		toggleSelectionOfID(paragraphToDeleteId, false);

		// Actions
		getDocumentUiListener().onDeleteSnippet();

		// Check

		assertEquals(selectedIDsInGwt.size(), 0);
		assertFalse(getDocument().containsParagraph(paragraphToDeleteId));
		assertEquals(pageCountBeforeDeleting - 1, getDocumentPanel().getPageCount());
		for (int index = 0; index < getDocumentPanel().getPageCount(); index++) {
			assertFalse(getDocumentPanel().getPage(index).equals(pageToDelete));
		}
	}

	@Test
	public void testMultipleSelectWithClick() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		generateParagraphs(5, getDocument().getSectionCount() - 1);

		// Precondition
		assertEqualsStyle("snippet", getGeneratedParagraphs());

		// Actions
		toggleSelectionOfID(getGeneratedParagraphs().get(0), true);
		toggleSelectionOfID(getGeneratedParagraphs().get(4), true);

		// Check
		assertEquals(selectedIDsInGwt.size(), 2);
		assertEquals("Paragraph is not in selected set", selectedParagraphs, selectedIDsInGwt);

		assertHasSelectionBorder(getGeneratedParagraphs().get(0));
		assertHasSelectionBorder(getGeneratedParagraphs().get(4));
	}

	private void assertHasSelectionBorder(Id id) {
		SelectedFlowPanel selectedFlowPanel = (SelectedFlowPanel) getFlowPanelForParagraph(id);
		assertTrue(!(selectedFlowPanel == null));
		assertTrue(getSelectionBorderForSnippet(selectedFlowPanel).isVisible());
	}

	private SelectedFlowPanel getFlowPanelForParagraph(Id id) {
		for (int pageIndex = 0; pageIndex < getDocumentPanel().getPageCount(); pageIndex++) {
			if (getDocumentPanel().isCollage(pageIndex)) {

				for (int snippetIndex = 0; snippetIndex < getDocumentPanel()
						.getSnippetCount(pageIndex); snippetIndex++) {
					SelectedFlowPanel snippet = getDocumentPanel().getSnippet(pageIndex, snippetIndex);

					SelectedFlowPanel selectedFlowPanel = (SelectedFlowPanel) snippet;
					Id paragraphId = (Id) getParagraphId(selectedFlowPanel);
					if (paragraphId.equals(id)) {
						return (SelectedFlowPanel) selectedFlowPanel;
					}
				}
			}
		}
		return null;
	}

	private native Object getParagraphId(SelectedFlowPanel selectedFlowPanel)/*-{
		return selectedFlowPanel.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::id;
	}-*/;

	@Test
	public void testDeselectMultipleSelectOneWithClick() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		generateParagraphs(5, getDocument().getSectionCount() - 1);

		// Precondition
		assertEqualsStyle("snippet", getGeneratedParagraphs());

		// Actions
		toggleSelectionOfID(getGeneratedParagraphs().get(0), true);
		toggleSelectionOfID(getGeneratedParagraphs().get(4), true);
		assertEquals(selectedIDsInGwt.size(), 2);
		toggleSelectionOfID(getGeneratedParagraphs().get(1), false);

		// Check
		assertEquals(selectedIDsInGwt.size(), 1);
		assertEquals("Paragraph is not in selected set", selectedParagraphs, selectedIDsInGwt);
		for (Id id : selectedIDsInGwt) {
			assertHasSelectionBorder(id);
		}
	}

	@Test
	public void testAddParagraph() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();

		// Action
		Id paragraph = generateParagraph(getDocument().getSectionCount() - 1, 22, 33, 100);

		// Check
		FlowPanel page = getDocumentPanel().getPage(getPageIndexFromParagraphId(paragraph));
		assertEquals(page.getWidgetCount(), 1);
		assertTrue(page.getWidget(0) instanceof SelectedFlowPanel);
		SelectedFlowPanel panel = (SelectedFlowPanel) page.getWidget(0);
		assertEquals(paragraph, getIDFromSelectedFlowPanel(panel));
		assertEquals("40px", panel.getElement().getStyle().getLeft());
		assertEquals("40px", panel.getElement().getStyle().getTop());
		assertEquals("70px", panel.getElement().getStyle().getWidth());
	}

	@Test
	public void testDeleteSnippetByDeletingTheTokens() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		Id paragraphToDeleteByDeletingTokens = generateParagraph(collageId, 10, 10, 130);
		generateParagraph(collageId, 10, 10, 130);

		// Preconditions
		assertTrue(getDocument().containsParagraph(paragraphToDeleteByDeletingTokens));

		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(2, getDocumentPanel().getSnippetCount(1));

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getSnippetCount(1));

		// Action
		Id id = getDocument().getParagraph(paragraphToDeleteByDeletingTokens).getToken(1).getId();
		getDocumentUiListener().onDeletePrevious(id);
		id = getDocument().getParagraph(paragraphToDeleteByDeletingTokens).getToken(0).getId();
		getDocumentUiListener().onDeletePrevious(id);

		// Check
		assertEquals(1, getDocument().getParagraphCount(1));
		assertFalse(getDocument().containsParagraph(paragraphToDeleteByDeletingTokens));

		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(1, getDocumentPanel().getSnippetCount(1));

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));
	}

	public void testDeletParagraphbySelectAndDelete() {
		// Prepare
		getDocumentEditorSidebarListener().onAddCollage();
		Id collageId = getDocument().getSection(1).getCollageId();
		Id paragraphToDeleteBySelctionAndDelete = generateParagraph(collageId, 10, 10, 130);
		generateParagraph(collageId, 10, 10, 130);
		toggleSelectionOfID(paragraphToDeleteBySelctionAndDelete, false);

		// Preconditions
		assertTrue(getDocument().containsParagraph(paragraphToDeleteBySelctionAndDelete));

		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(2, getDocumentPanel().getSnippetCount(1));

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getSnippetCount(1));

		// Action
		getDocumentUiListener().onDeleteSnippet();

		// Check
		assertEquals(1, getDocument().getParagraphCount(1));
		assertFalse(getDocument().containsParagraph(paragraphToDeleteBySelctionAndDelete));

		assertEquals(2, getGwtDocumentLayouter().getPageCount());
		assertEquals(1, getGwtDocumentLayouter().getSnippetCount(1));

		assertEquals(2, getDocumentPanel().getPageCount());
		assertEquals(1, getDocumentPanel().getSnippetCount(1));
	}

	private String getStyleOfParagraph(Id paragraphId) {
		BoxIndex boxIndex = getBoxIndexFromParagraphId(paragraphId);
		FlowPanel page = getDocumentPanel().getPage(boxIndex.getPageIndex());
		return page.getWidget(boxIndex.getLineIndex()).getStyleName();
	}

	private void toggleSelectionOfID(Id id, boolean addToExistingSelection) {
		assert getGeneratedParagraphs().contains(id) : "Precondition failed generatedParagraphs.contains(id)";
		if (!addToExistingSelection) {
			selectedParagraphs.clear();
		}
		selectedParagraphs.add(id);
		getDocumentUiListener().onToggleSnippetSelection(id, addToExistingSelection);
	}

	protected void assertEqualsStyle(String style, Id id) {
		assertEquals(style, getStyleOfParagraph(id));
	}

	protected void assertEqualsStyle(String style, Collection<Id> collection) {
		StringBuilder message = new StringBuilder();
		for (Id id : collection) {
			try {
				assertEqualsStyle(style, id);
			} catch (Error cf) {
				message.append("{" + id + ", " + cf.getMessage() + "}");
			}
		}
		if (message.length() > 0)
			fail(message.toString());
	}
}
