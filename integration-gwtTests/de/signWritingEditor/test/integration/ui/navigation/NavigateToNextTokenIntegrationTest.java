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

public class NavigateToNextTokenIntegrationTest extends NavigationIntegrationTestCase {

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
	}

	@Test
	public void testMoveToNextBoxFromSignItemTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		Timer timer = new NavigationCompletionTimer(token2Id);

		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, searchWordBox);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToNextBoxFromFreeTextTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		Timer timer = new NavigationCompletionTimer(token2Id);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToNextBoxFromFrameTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddFrame();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FrameTokenBoxWidget tokenBoxWidget = (FrameTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		Timer timer = new NavigationCompletionTimer(token2Id);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		TextArea area = getTextAreaFromFrameToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToNextBoxFromVideoTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddVideo();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token2Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToNextBoxFromImageTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddImage();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget imageBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		assertEquals(token1Id, imageBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		ExtendedRichTextArea textArea = getExtendedRichTextAreaFromImage(imageBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, textArea);

		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token2Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testDoNotMoveToNextBoxFromSignItemTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		Timer timer = new NavigationCompletionTimer(token1Id);

		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		searchWordBox.setText("Testen");
		searchWordBox.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		getGwtDocumentEditor().setCursorPositionInUi(token1Id, 0);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, searchWordBox);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToNextBoxFromFreeTextTokenWithKeyRight() {
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		Timer timer = new NavigationCompletionTimer(token1Id);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);
		area.setText("Testen");
		getDocumentUiListener().onSelectToken(token1Id, false);
		area.setCursorPos(0);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToNextBoxFromVideoTokenWithKeyRight() {

		getDocumentEditorSidebarListener().onAddVideo();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		area.setText("Testen");
		area.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);
	}

	@Test
	public void testDoNotMoveToNextBoxFromImageTokenWithKeyRight() {

		getDocumentEditorSidebarListener().onAddImage();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);
		area.setText("Testen");
		area.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToNextBoxFromSignItemTokenWithCtrlKeyRight() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		Timer timer = new NavigationCompletionTimer(token2Id);

		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		searchWordBox.setText("Testen");
		searchWordBox.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		getGwtDocumentEditor().setCursorPositionInUi(token1Id, 0);
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_RIGHT, searchWordBox);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testDoNotMoveToNextBoxFromFreeTextTokenWithCtrlKeyRight() {
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();

		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		Timer timer = new NavigationCompletionTimer(token1Id);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);
		area.setText("Testen");
		getDocumentUiListener().onSelectToken(token1Id, false);
		area.setCursorPos(0);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		delayTestFinish(MAXIMAL_ACCEPTED_REACTION_TIME);
		timer.scheduleRepeating(PERIODIC_TEST_DELAY);
	}

	@Test
	public void testMoveToNextBoxFromVideoTokenWithCtrlKeyRight() {

		getDocumentEditorSidebarListener().onAddVideo();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);
		area.setText("Testen");
		area.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		assertTrue(getGwtDocumentLayouter().containsIdBox(token2Id));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token2Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToNextBoxFromImageTokenWithCtrlKeyRight() {

		getDocumentEditorSidebarListener().onAddImage();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);
		area.setText("Testen");
		area.setCursorPos(0);
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		assertTrue(getGwtDocumentLayouter().containsIdBox(token2Id));
		// Action
		createKeyDownEvent(true, false, false, false, KeyCodes.KEY_RIGHT, area);
		// Test
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
				assertEquals(token2Id, currentCursorTokenId);
				finishTest();
			}
		});
		delayTestFinish(100);
	}

	@Test
	public void testMoveToNextBoxFromSignItemTokenWithKeyTab() {
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		LayoutedSignItemTokenBoxWidget tokenBoxWidget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		LayoutedSearchWordBox searchWordBox = getLayoutedSearchWordBox(tokenBoxWidget);

		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_TAB, searchWordBox);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToNextBoxFromFreeTextTokenWithKeyTab() {
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		FreeTextTokenBoxWidget tokenBoxWidget = (FreeTextTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);

		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		ExtendedRichTextArea area = getExtendedRichTextAreaFromFreeTextToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToNextBoxFromFrameTokenWithKeyTab() {
		getDocumentEditorSidebarListener().onAddFrame();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();
		FrameTokenBoxWidget tokenBoxWidget = (FrameTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);

		TextArea area = getTextAreaFromFrameToken(tokenBoxWidget);

		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);
	}

	@Test
	public void testMoveToNextBoxFromVideoTokenWithKeyTab() {
		getDocumentEditorSidebarListener().onAddVideo();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		VideoTokenBoxWidget tokenBoxWidget = (VideoTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		ExtendedRichTextArea area = getExtendedRichTextAreaFromVideo(tokenBoxWidget);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);

	}

	@Test
	public void testMoveToNextBoxFromImageTokenWithKeyTab() {
		getDocumentEditorSidebarListener().onAddImage();
		Id token1Id = document.getToken(0, 0, 1).getId();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		final Id token2Id = document.getToken(0, 0, 2).getId();

		ImageTokenBoxWidget tokenBoxWidget = (ImageTokenBoxWidget) documentPanel
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		getDocumentUiListener().onSelectToken(token1Id, false);
		Id currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());

		ExtendedRichTextArea area = getExtendedRichTextAreaFromImage(tokenBoxWidget);

		getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token1Id, tokenBoxWidget.getId());
		assertEquals(token1Id, currentCursorTokenId);
		// Action
		createKeyDownEvent(false, false, false, false, KeyCodes.KEY_TAB, area);
		// Test
		currentCursorTokenId = getCurrentCursorTokenId(getGwtDocumentEditor());
		assertEquals(token2Id, currentCursorTokenId);

	}
}
