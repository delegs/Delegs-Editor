package de.signWritingEditor.test.integration.ui.navigation;

import org.junit.Test;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.ui.TextArea;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.test.integration.infrastructure.NavigationIntegrationTestCase;

public class NavigateToNextLineIntegrationTest extends NavigationIntegrationTestCase {

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		turnAutomaticFreeTextLineOf();
		getDocumentUiListener().onDeletePrevious(document.getToken(0, 0, 1).getId());
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
	}

	// SignItemToken
	@Test
	public void testMoveToNextLineFromSignItemToken() {
		// Preparation
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		LayoutedSignItemTokenBoxWidget sourceTokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_DOWN, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	@Test
	public void testMoveToNextParagraphFromSignItemToken() {
		// Preparation
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		LayoutedSignItemTokenBoxWidget sourceTokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_DOWN, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	// FreitTextToken
	@Test
	public void testMoveToNextLineFromFreeTextToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		FreeTextTokenBoxWidget sourceTokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromFreeTextToken(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget tokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	@Test
	public void testMoveToNextParagraphFromFreeTextToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		FreeTextTokenBoxWidget sourceTokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromFreeTextToken(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	// FrameToken
	@Test
	public void testMoveToNextLineFromFrameToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddFrame();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		TextArea textArea = getTextAreaFromFrameToken(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	@Test
	public void testMoveToNextParagraphFromFrameToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddFrame();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		TextArea textArea = getTextAreaFromFrameToken(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	// Video
	@Test
	public void testMoveToNextLineFromVideoToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddVideo();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromVideo(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	@Test
	public void testMoveToNextParagraphFromVideoToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddVideo();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromVideo(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	// Image
	@Test
	public void testMoveToNextLineFromImageToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddImage();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromImage(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	@Test
	public void testMoveToNextParagraphFromImageToken() {
		createTwoParagraphsForTestWithToken();
		getDocumentEditorSidebarListener().onAddImage();
		AbstractTokenBoxWidget sourceTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		sourceTokenBoxWidget.getElement().getStyle().setLeft(200, Unit.PX);
		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromImage(sourceTokenBoxWidget);
		Id sourceTokenId = sourceTokenBoxWidget.getId();

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
		assertEquals(2, document.getTokenCount(0, 0));
		assertEquals(2, document.getTokenCount(0, 1));
		getDocumentUiListener().onSelectToken(sourceTokenId, false);

		LayoutedSignItemTokenBoxWidget destinationToken = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_DOWN, textArea);
		// Test
		Id currentCursorTokenId = (Id) getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(destinationToken.getId(), currentCursorTokenId);
	}

	private void createTwoParagraphsForTestWithToken() {
		Id tokenId = document.getToken(0, 0, 0).getId();
		getDocumentUiListener().onTextChanged(tokenId, "\n1 2", 0);
		getDocumentUiListener().onSelectToken(tokenId, false);
		// Necessary to correctly position the widgets in the layout
		// The position is derived by the standard widget width and a general
		// starting position
		documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getElement().getStyle().setLeft(100, Unit.PX);
		documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0)).getElement().getStyle().setLeft(100, Unit.PX);
		documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1)).getElement().getStyle().setLeft(200, Unit.PX);
	}
}
