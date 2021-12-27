package de.signWritingEditor.test.integration.ui.navigation;

import org.junit.Test;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextArea;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FrameTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.test.integration.infrastructure.NavigationIntegrationTestCase;

public class NavigateToPreviousTokenIntegrationTest extends NavigationIntegrationTestCase {

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
	}

	@Test
	public void testMoveToPreviousBoxFromSignItemTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		Timer timer = new NavigationCompletionTimer(token1Id);

		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, searchWordBox);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToPreviousBoxFromFreeTextTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		Timer timer = new NavigationCompletionTimer(token1Id);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToPreviousBoxFromFrameTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFrame();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FrameTokenBoxWidget tokenBoxWidget = (FrameTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		Timer timer = new NavigationCompletionTimer(token1Id);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		TextArea area = getTextAreaFromFrameToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToPreviousBoxFromVideoTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddVideo();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getGwtDocumentEditor().setCursorPositionInUi(token2Id, 0);
		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token1Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToPreviousBoxFromImageTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddImage();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getGwtDocumentEditor().setCursorPositionInUi(token2Id, 0);
		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);

		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token1Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testDoNotMoveToPreviousBoxFromSignItemTokenWithKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		Timer timer = new NavigationCompletionTimer(token2Id);

		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		getGwtDocumentEditor().setCursorPositionInUi(token2Id, 0);
		getDocumentUiListener().onSelectToken(token2Id, false);
		searchWordBox.setText("Testen");
		searchWordBox.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, searchWordBox);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToPreviousBoxFromFreeTextTokenWithKeyLeft() {
		// Prepare
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		assertEquals(token2Id, tokenBoxWidget.getId());

		Timer timer = new NavigationCompletionTimer(token2Id);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);
		area.setText("Testen");
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
        assertEquals("Cursor is not in expected token.", token2Id, currentCursorTokenId);
		assertEquals("Cursor is not in expected position.", 2, area.getCursorPos());

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);

		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToPreviousBoxFromVideoTokenWithKeyLeft() {

		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddVideo();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);
	}

	@Test
	public void testDoNotMoveToPreviousBoxFromImageTokenWithKeyLeft() {

		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddImage();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToPreviousBoxFromSignItemTokenWithCtrlKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		Timer timer = new NavigationCompletionTimer(token2Id);

		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		searchWordBox.setText("Testen");
		getDocumentUiListener().onSelectToken(token2Id, false);
		getGwtDocumentEditor().setCursorPositionInUi(token2Id, 2);
		searchWordBox.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_LEFT, searchWordBox);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToPreviousBoxFromFreeTextTokenWithCtrlKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		Timer timer = new NavigationCompletionTimer(token2Id);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoMoveToPreviousBoxFromFreeTextTokenWithCtrlKeyLeft() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		Timer timer = new NavigationCompletionTimer(token1Id);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(0);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToPreviousBoxFromVideoTokenWithCtrlKeyLeft() {

		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddVideo();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		assertTrue(getGwtDocumentLayouter().containsIdBox(token2Id));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token1Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToPreviousBoxFromImageTokenWithCtrlKeyLeft() {

		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddImage();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);
		getDocumentUiListener().onSelectToken(token2Id, false);
		area.setText("Testen");
		area.setCursorPos(2);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		assertTrue(getGwtDocumentLayouter().containsIdBox(token2Id));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_LEFT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token1Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToPreviousBoxFromSignItemTokenWithKeyShiftTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_TAB, searchWordBox);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToPreviousBoxFromFreeTextTokenWithKeyShiftTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);

		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToPreviousBoxFromFrameTokenWithKeyShiftTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddFrame();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FrameTokenBoxWidget tokenBoxWidget = (FrameTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);

		TextArea area = getTextAreaFromFrameToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToPreviousBoxFromVideoTokenWithKeyShiftTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddVideo();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);
		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);

	}

	@Test
	public void testMoveToPreviousBoxFromImageTokenWithKeyShiftTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getDocumentEditorSidebarListener().onAddImage();
		Id token1Id = document.getToken(0, 0, 1).getId();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 2));
		getDocumentUiListener().onSelectToken(token2Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, tokenBoxWidget.getId());
		assertEquals(token2Id, currentCursorTokenId);
		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);

	}

}
