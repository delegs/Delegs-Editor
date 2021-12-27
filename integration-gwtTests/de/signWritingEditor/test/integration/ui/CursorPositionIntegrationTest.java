package de.signWritingEditor.test.integration.ui;

import org.junit.Test;

import com.google.gwt.user.client.ui.RootPanel;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class CursorPositionIntegrationTest extends IntegrationTestCase {
	private DocumentPanel documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
		// Attach panel to DOM to make sure certain UI functionality works
		RootPanel.get().add((DocumentPanelImpl) documentPanel);
	}

	@Override
	protected void initDefaultDocument() {
		// do not create initial page on startup - see testCursorPosition
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
		RootPanel.get().remove((DocumentPanelImpl) documentPanel);
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	@Test
	public void testCursorPositionLeft() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		String token1Word = "token1";
		SignItemToken token1 = getTokenFactory().createSignItemToken(token1Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		String token2Word = "token2";
		SignItemToken token2 = getTokenFactory().createSignItemToken(token2Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token2, true, true);

		String token3Word = "token3";
		SignItemToken token3 = getTokenFactory().createSignItemToken(token3Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		// Action
		int token1CursorLeft = getGwtDocumentEditor().getCursorLeft(token1.getId());
		int token2CursorLeft = getGwtDocumentEditor().getCursorLeft(token2.getId());
		int token3CursorLeft = getGwtDocumentEditor().getCursorLeft(token3.getId());

		// Test
		assertTrue(token1CursorLeft > 0);
		assertTrue(token2CursorLeft > 0);
		assertTrue(token3CursorLeft > 0);
		assertTrue(token2CursorLeft > token1CursorLeft);
		assertTrue(token3CursorLeft > token2CursorLeft);
	}

	@Test
	public void testRemoveBox() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		SignItemToken token1 = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		SignItemToken token2 = getTokenFactory().createSignItemToken("token2",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token2, true, true);

		SignItemToken token3 = getTokenFactory().createSignItemToken("token3",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		int token1CursorLeft = getGwtDocumentEditor().getCursorLeft(token1.getId());
		int token3CursorLeft = getGwtDocumentEditor().getCursorLeft(token3.getId());

		String tokenAfterLineBreakWord = "token1";
		SignItemToken tokenAfterLineBreak = getTokenFactory().createSignItemToken(tokenAfterLineBreakWord,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		Id freeTextId = getIdFactory().createId();
		insertFreeTextLineAfter(token3.getId(), freeTextId, "freetext", true);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, tokenAfterLineBreak);

		Id freeTextTokenId3 = getIdFactory().createId();
		insertFreeTextLineAfter(tokenAfterLineBreak.getId(), freeTextTokenId3, "FreeTextZeile3", true);
		int tokenAfterLineBreakCursorLeft = getGwtDocumentEditor().getCursorLeft(tokenAfterLineBreak.getId());

		// check if the position of token3 is the same of token2 after removing
		BoxIndex token2BoxIndex = getGwtDocumentLayouter().getIdBoxIndex(token2.getId());
		BoxIndex token3BoxIndex = getGwtDocumentLayouter().getIdBoxIndex(token3.getId());
		Box token3Box = getGwtDocumentLayouter().getBox(token3BoxIndex);

		// Action
		getGwtDocumentLayouter().removeTokenBox(token2.getId());

		Box token2Box = getGwtDocumentLayouter().getBox(token2BoxIndex);
		token3CursorLeft = getGwtDocumentEditor().getCursorLeft(token3.getId());

		// Test
		assertEquals(token3Box, token2Box);
		assertTrue(token1CursorLeft > 0);
		assertTrue(token3CursorLeft > 0);
		assertTrue(token3CursorLeft > token1CursorLeft);
		assertEquals(token1CursorLeft, tokenAfterLineBreakCursorLeft);

	}

	@Test
	public void testAddLineBreakWithCursorPosition() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		SignItemToken token1 = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		SignItemToken token3 = getTokenFactory().createSignItemToken("token3",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		int token1CursorLeft = getGwtDocumentEditor().getCursorLeft(token1.getId());

		SignItemToken tokenAfterLineBreak = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		// Action
		insertFreeTextLineAfter(token3.getId(), getIdFactory().createId(), "freetext", true);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, tokenAfterLineBreak);

		insertFreeTextLineAfter(tokenAfterLineBreak.getId(), getIdFactory().createId(), "FreeTextZeile3", true);
		int tokenAfterLineBreakCursorLeft = getGwtDocumentEditor().getCursorLeft(tokenAfterLineBreak.getId());
		// Test
		assertTrue(tokenAfterLineBreakCursorLeft > 0);
		assertEquals(token1CursorLeft, tokenAfterLineBreakCursorLeft);

	}

	@Test
	public void testSetCursorPosition() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		SignItemToken token1 = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		SignItemToken token3 = getTokenFactory().createSignItemToken("token3",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		SignItemToken tokenAfterLineBreak = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		insertFreeTextLineAfter(token3.getId(), getIdFactory().createId(), "freetext", true);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, tokenAfterLineBreak);

		insertFreeTextLineAfter(tokenAfterLineBreak.getId(), getIdFactory().createId(), "FreeTextZeile3", true);

		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(token1.getId());

		LayoutedSignItemTokenBoxWidget token1Widget = (LayoutedSignItemTokenBoxWidget) documentPanel
				.getTokenBoxWidget(idBoxIndex);
		// Action
		getGwtDocumentEditor().setCursorPositionInUi(token1.getId(), 3);

		// Test
		assertEquals(3, token1Widget.getCursorPosition());
	}

	@Test
	public void testGetCursorPositionAboveAndBelowForFreeTextLineAboveToken() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		SignItemToken token1 = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		SignItemToken token3 = getTokenFactory().createSignItemToken("token3",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		SignItemToken tokenAfterLineBreak = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		Id freeTextId = getIdFactory().createId();
		insertFreeTextLineAfter(token3.getId(), freeTextId, "freetext", true);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, tokenAfterLineBreak);

		Id freetextId2 = getIdFactory().createId();
		insertFreeTextLineAfter(tokenAfterLineBreak.getId(), freetextId2, "FreeTextZeile3", true);

		getGwtDocumentEditor().setCursorPositionInUi(token1.getId(), 3);

		String token4Word = "token4";
		SignItemToken token4 = getTokenFactory().createSignItemToken(token4Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token4, true, true);

		String token5Word = "token5";
		SignItemToken token5 = getTokenFactory().createSignItemToken(token5Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token5, true, true);

		CursorPosition cursorPositionAboveToken4 = getGwtDocumentLayouter().getCursorPositionAbove(token4.getId(), 2);
		assertEquals(freeTextId, cursorPositionAboveToken4.getTokenId());

		CursorPosition cursorPositionAboveToken5 = getGwtDocumentLayouter().getCursorPositionAbove(token5.getId(), 2);
		assertEquals(cursorPositionAboveToken4.getTokenId(), cursorPositionAboveToken5.getTokenId());

		CursorPosition cursorPositionBelow = getGwtDocumentLayouter()
				.getCursorPositionBelow(tokenAfterLineBreak.getId(), 1);
		assertEquals(freetextId2, cursorPositionBelow.getTokenId());
	}

	@Test
	public void testCursorPositionBelowWithTokenOnNextPage() {
		// Prepare
		getGwtDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getGwtDocumentLayouter().addNewLine();

		SignItemToken token1 = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token1, true, true);

		SignItemToken token3 = getTokenFactory().createSignItemToken("token3",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token3, true, true);

		SignItemToken tokenAfterLineBreak = getTokenFactory().createSignItemToken("token1",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		Id freeTextId = getIdFactory().createId();
		insertFreeTextLineAfter(token3.getId(), freeTextId, "freetext", true);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, tokenAfterLineBreak);

		Id freetextId2 = getIdFactory().createId();
		insertFreeTextLineAfter(tokenAfterLineBreak.getId(), freetextId2, "FreeTextZeile3", true);

		getGwtDocumentEditor().setCursorPositionInUi(token1.getId(), 3);

		SignItemToken token4 = getTokenFactory().createSignItemToken("token4",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token4, true, true);

		SignItemToken token5 = getTokenFactory().createSignItemToken("token5",
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().addToken(token5, true, true);

		insertFreeTextLineAfter(token5.getId(), getIdFactory().createId(), "", true);

		Id previousId = token5.getId();
		for (int tokenIndex = 0; tokenIndex < 2; tokenIndex++) {
			Id nextId = getIdFactory().createId();
			SignItemToken newToken = getTokenFactory().createSignItemToken("ein wort", null, nextId,
					getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS,
					false, false);
			getGwtDocumentLayouter().insertLineBreakAndTokenAfter(previousId, true, true, newToken);
			insertFreeTextLineAfter(newToken.getId(), getIdFactory().createId(), "", true);
			previousId = nextId;
		}

		String token6Word = "token6";
		SignItemToken token6 = getTokenFactory().createSignItemToken(token6Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertLineBreakAndTokenAfter(previousId, true, true, token6);
		insertFreeTextLineAfter(token6.getId(), getIdFactory().createId(), "", true);

		// Fill last line of first page with tokens until token get put in
		// second page
		String token7Word = "token7";
		SignItemToken token7 = getTokenFactory().createSignItemToken(token7Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token6.getId(), token7, true, true);
		String token8Word = "token8";
		SignItemToken token8 = getTokenFactory().createSignItemToken(token8Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token7.getId(), token8, true, true);
		String token9Word = "token9";
		SignItemToken token9 = getTokenFactory().createSignItemToken(token9Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token8.getId(), token9, true, true);
		String token10Word = "token10";
		SignItemToken token10 = getTokenFactory().createSignItemToken(token10Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token9.getId(), token10, true, true);
		String token11Word = "token11";
		SignItemToken token11 = getTokenFactory().createSignItemToken(token11Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token10.getId(), token11, true, true);
		String token12Word = "token12";
		SignItemToken token12 = getTokenFactory().createSignItemToken(token12Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token11.getId(), token12, true, true);
		String token13Word = "token13";
		SignItemToken token13 = getTokenFactory().createSignItemToken(token13Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token12.getId(), token13, true, true);
		String token14Word = "token14";
		SignItemToken token14 = getTokenFactory().createSignItemToken(token14Word,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getGwtDocumentLayouter().insertTokenAfter(token13.getId(), token14, true, true);

		CursorPosition cursorPositionBelowToken7 = getGwtDocumentLayouter().getCursorPositionBelow(token7.getId(), 1);
		assertEquals(token14.getId(), cursorPositionBelowToken7.getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token6.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token8.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token9.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token10.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token11.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token12.getId(), 1).getTokenId());
		assertEquals(token14.getId(), getGwtDocumentLayouter().getCursorPositionBelow(token13.getId(), 1).getTokenId());
		assertEquals(token6.getId(), getGwtDocumentLayouter().getCursorPositionAbove(token14.getId(), 1).getTokenId());
	}

	private void insertFreeTextLineAfter(Id previousToken, Id freeTextLineId, String freeText, boolean visibile) {

		FreeTextToken freeTextToken = getTokenFactory().createFreeTextToken(freeTextLineId,
				getTextbasedTokenStyleFactory().createDefaultTextbasedTokenStyle());
		freeTextToken.setText(freeText);
		BoxIndex index = getGwtDocumentLayouter().getIdBoxIndex(previousToken);
		int width = getGwtDocumentLayouter().getPage(index.getPageIndex()).getMaxWidth();
		freeTextToken.setWidth(width);
		freeTextToken.setIsFreeTextLine(true);
		getGwtDocumentLayouter().insertTokenAfter(previousToken, freeTextToken, visibile, visibile);
	}
}
