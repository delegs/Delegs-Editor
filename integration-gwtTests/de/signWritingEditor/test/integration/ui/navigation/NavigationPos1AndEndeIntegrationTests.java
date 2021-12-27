package de.signWritingEditor.test.integration.ui.navigation;

import org.junit.Test;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.ui.TextArea;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FrameTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.test.integration.infrastructure.NavigationIntegrationTestCase;

public class NavigationPos1AndEndeIntegrationTests extends NavigationIntegrationTestCase {

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

	@Test
	public void testPos1ForSignItemTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();

		assertEquals(1, documentPanel.getPageCount());
		assertEquals(2, documentPanel.getLineCount(0));
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		assertTrue(source instanceof LayoutedSignItemTokenBoxWidget);

		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlPos1ForSignItemTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		assertEquals(3, document.getTokenCount(0, 1));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 2));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));

		assertEquals(LayoutedSignItemTokenBoxWidget.class, source.getClass());
		getDocumentUiListener().onSelectToken(source.getId(), false);

		assertTrue(source instanceof LayoutedSignItemTokenBoxWidget);

		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(source);
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
		assertEquals(document.getFirstTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testEndeForSignItemTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		int lastTokenInLineIndex = documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, lastTokenInLineIndex - 1));

		assertTrue(source instanceof LayoutedSignItemTokenBoxWidget);

		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlEndeForSignItemTokenBoxWidgets() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		insertLineBreak(document.getToken(0, 0, 2).getId());
		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		assertTrue(source instanceof LayoutedSignItemTokenBoxWidget);

		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(source);
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(document.getLastTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testPos1ForFreeTextTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		assertEquals(1, documentPanel.getPageCount());
		assertEquals(2, documentPanel.getLineCount(0));
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		assertTrue(source instanceof FreeTextTokenBoxWidget);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromFreeTextToken(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlPos1ForFreeTextTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		assertEquals(3, document.getTokenCount(0, 1));
		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 2));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		assertEquals(FreeTextTokenBoxWidget.class, source.getClass());

		getDocumentUiListener().onSelectToken(source.getId(), false);

		assertTrue(source instanceof FreeTextTokenBoxWidget);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromFreeTextToken(source);
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
		assertEquals(document.getFirstTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testEndeForFreeTextTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		int lastTokenInLineIndex = documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, lastTokenInLineIndex - 1));

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromFreeTextToken(source);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlEndeForFreeTextTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromFreeTextToken(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(document.getLastTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testPos1ForFrameTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddFrame();

		assertEquals(1, documentPanel.getPageCount());
		assertEquals(2, documentPanel.getLineCount(0));
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		TextArea searchWordBox = getTextAreaFromFrameToken(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlPos1ForFrameTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFrame();
		assertEquals(3, document.getTokenCount(0, 1));
		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 2));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		assertEquals(FrameTokenBoxWidget.class, source.getClass());

		getDocumentUiListener().onSelectToken(source.getId(), false);

		TextArea searchWordBox = getTextAreaFromFrameToken(source);
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
		assertEquals(document.getFirstTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testEndeForFrameTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddFrame();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		int lastTokenInLineIndex = documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, lastTokenInLineIndex - 1));

		TextArea searchWordBox = getTextAreaFromFrameToken(source);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlEndeForFrameTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddFrame();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		TextArea searchWordBox = getTextAreaFromFrameToken(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(document.getLastTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testPos1ForVideoTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddVideo();

		assertEquals(1, documentPanel.getPageCount());
		assertEquals(2, documentPanel.getLineCount(0));
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromVideo(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlPos1ForVideoTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddVideo();
		assertEquals(3, document.getTokenCount(0, 1));
		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 2));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		assertEquals(VideoTokenBoxWidget.class, source.getClass());
		getDocumentUiListener().onSelectToken(source.getId(), false);
		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromVideo(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_HOME, searchWordBox);

		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
		assertEquals(document.getFirstTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testEndeForVideoTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddVideo();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		int lastTokenInLineIndex = documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, lastTokenInLineIndex - 1));

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromVideo(source);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlEndeForVideoTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddVideo();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromVideo(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(document.getLastTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testPos1ForImageTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddImage();

		assertEquals(1, documentPanel.getPageCount());
		assertEquals(2, documentPanel.getLineCount(0));
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 1));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));

		getDocumentUiListener().onSelectToken(source.getId(), false);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromImage(source);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_HOME, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlPos1ForImageTokenBoxWidgets() {
		insertLineBreak(document.getFirstTokenInDocument().getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddImage();
		assertEquals(3, document.getTokenCount(0, 1));
		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 2));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		assertEquals(ImageTokenBoxWidget.class, source.getClass());
		getDocumentUiListener().onSelectToken(source.getId(), false);
		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromImage(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_HOME, searchWordBox);

		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
		assertEquals(document.getFirstTokenInDocument().getId(), currentCursorTokenId);
	}

	@Test
	public void testEndeForImageTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddImage();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		int lastTokenInLineIndex = documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0));
		AbstractTokenBoxWidget target = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, lastTokenInLineIndex - 1));

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromImage(source);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(target.getId(), currentCursorTokenId);
	}

	@Test
	public void testCtrlEndeForImageTokenBoxWidgets() {
		getDocumentUiListener().onSelectToken(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)).getId(), false);
		getDocumentEditorSidebarListener().onAddImage();
		getDocumentUiListener().onDeleteNext(document.getToken(0, 0, 0).getId());
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		insertLineBreak(documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 3)).getId());

		AbstractTokenBoxWidget source = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		getDocumentUiListener().onSelectToken(source.getId(), false);

		ExtendedRichTextArea searchWordBox = getExtendedRichTextAreaFromImage(source);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_END, searchWordBox);
		// Test
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(document.getLastTokenInDocument().getId(), currentCursorTokenId);
	}

	private void insertLineBreak(Id id) {
		getDocumentUiListener().onTextChanged(id, " \n  ", 0);
	}
}
