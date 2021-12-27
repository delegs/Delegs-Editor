package de.signWritingEditor.test.integration.ui.tokenBoxWidget;

import org.junit.Test;

import com.google.gwt.event.dom.client.KeyCodes;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.IdBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.test.integration.infrastructure.NavigationIntegrationTestCase;

public class TextbasedTokenBoxWidgetShortcutTest extends NavigationIntegrationTestCase {

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
	}

	@Test
	public void testAddFreeTextLineShortcutOnSignItemToken() throws Exception {
		// Prepare
		getDocumentEditorSidebarListener().onAddSignItemToken();
		getGwtDocumentEditor().setCursorPositionInUi(document.getToken(0, 0, 0).getId(), 0);
		assertEquals(3, document.getTokenCount(0, 0));

		Token firstSignItemToken = document.getToken(0, 0, 0);
		Token secondSignItemToken = document.getToken(0, 0, 1);
		IdBox firstIdBox = (IdBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 0));
		IdBox secondIdBox = (IdBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));
		AbstractTokenBoxWidget firstAbstractTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0));
		AbstractTokenBoxWidget secondAbstractTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));

		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_SPACE,
				getLayoutedSearchWordBox(firstAbstractTokenBoxWidget));

		// Check
		Token secondToken = document.getToken(0, 0, 1);
		assertEquals(4, document.getTokenCount(0, 0));
		assertTrue(secondToken instanceof FreeTextToken);
		assertTrue(((FreeTextToken) secondToken).isFreeTextLine());
		assertEquals(firstSignItemToken, document.getToken(0, 0, 0));
		assertEquals(secondSignItemToken, document.getToken(0, 0, 2));

		Box secondTokenBox = getGwtDocumentLayouter().getBox(new BoxIndex(0, 1, 0));
		assertEquals(4, getGwtDocumentLayouter().getLineCount(0));
		assertTrue(secondTokenBox instanceof FreeTextTokenBox);
		assertEquals(secondToken.getId(), ((FreeTextTokenBox) secondTokenBox).getId());
		assertEquals(firstIdBox, getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 0)));
		assertEquals(secondIdBox, getGwtDocumentLayouter().getBox(new BoxIndex(0, 2, 0)));

		AbstractTokenBoxWidget secondTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		assertEquals(4, documentPanel.getLineCount(0));
		assertTrue(secondTokenBoxWidget instanceof FreeTextTokenBoxWidget);
		assertEquals(secondToken.getId(), secondTokenBoxWidget.getId());
		assertEquals(firstAbstractTokenBoxWidget, documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 0)));
		assertEquals(secondAbstractTokenBoxWidget, documentPanel.getTokenBoxWidget(new BoxIndex(0, 2, 0)));
	}

	@Test
	public void testAddFreeTextLineShortcutOnFreeTextToken() throws Exception {
		// Prepare
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		getGwtDocumentEditor().setCursorPositionInUi(document.getToken(0, 0, 1).getId(), 0);
		assertEquals(4, document.getTokenCount(0, 0));

		Token firstFreeTextToken = document.getToken(0, 0, 1);
		Token secondFreeTextToken = document.getToken(0, 0, 2);
		IdBox firstIdBox = (IdBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));
		IdBox secondIdBox = (IdBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 2));
		AbstractTokenBoxWidget firstAbstractTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		AbstractTokenBoxWidget secondAbstractTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 2));

		// Action
		createKeyDownEvent(false, false, true, false, KeyCodes.KEY_SPACE,
				getExtendedRichTextAreaFromFreeTextToken(firstAbstractTokenBoxWidget));

		// Check
		Token secondToken = document.getToken(0, 0, 2);
		assertEquals(5, document.getTokenCount(0, 0));
		assertTrue(secondToken instanceof FreeTextToken);
		assertTrue(((FreeTextToken) secondToken).isFreeTextLine());
		assertEquals(firstFreeTextToken, document.getToken(0, 0, 1));
		assertEquals(secondFreeTextToken, document.getToken(0, 0, 3));

		Box secondTokenBox = getGwtDocumentLayouter().getBox(new BoxIndex(0, 1, 0));
		assertEquals(4, getGwtDocumentLayouter().getLineCount(0));
		assertTrue(secondTokenBox instanceof FreeTextTokenBox);
		assertEquals(secondToken.getId(), ((FreeTextTokenBox) secondTokenBox).getId());
		assertEquals(firstIdBox, getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1)));
		assertEquals(secondIdBox, getGwtDocumentLayouter().getBox(new BoxIndex(0, 2, 0)));

		AbstractTokenBoxWidget secondTokenBoxWidget = documentPanel.getTokenBoxWidget(new BoxIndex(0, 1, 0));
		assertEquals(4, documentPanel.getLineCount(0));
		assertTrue(secondTokenBoxWidget instanceof FreeTextTokenBoxWidget);
		assertEquals(secondToken.getId(), secondTokenBoxWidget.getId());
		assertEquals(firstAbstractTokenBoxWidget, documentPanel.getTokenBoxWidget(new BoxIndex(0, 0, 1)));
		assertEquals(secondAbstractTokenBoxWidget, documentPanel.getTokenBoxWidget(new BoxIndex(0, 2, 0)));
	}
}
