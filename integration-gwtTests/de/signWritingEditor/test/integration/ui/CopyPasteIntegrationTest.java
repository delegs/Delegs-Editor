package de.signWritingEditor.test.integration.ui;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ExtendedRichTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSignItemTokenBoxWidget;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.test.integration.infrastructure.CopyPasteIntegrationTestCase;

public class CopyPasteIntegrationTest extends CopyPasteIntegrationTestCase {

	private DocumentPanelImpl documentPanel;

	private Document document;

	// duplicate constants
	protected static final int MAXIMAL_ACCEPTED_REACTION_TIME = 500;
	protected static final int PERIODIC_TEST_DELAY = 10;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = ((DocumentPanelImpl) getPanel(getGwtDocumentEditor()));
		RootPanel.get().add(getDocumentPanel());
		document = getGwtDocumentEditor().getDocument();
	}

	public Document getDocument() {
		return document;
	}

	@SuppressWarnings("unchecked")
	private <T extends AbstractTokenBoxWidget> T getTokenBoxWidgetById(Id tokenId) {
		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(tokenId);
		return (T) getDocumentPanel().getTokenBoxWidget(idBoxIndex);
	}

	@SuppressWarnings("unchecked")
	private <T extends TokenBox> T getBoxById(Id id) {
		BoxIndex idBoxIndex = getGwtDocumentLayouter().getIdBoxIndex(id);
		return (T) getGwtDocumentLayouter().getBox(idBoxIndex);
	}

	public DocumentPanelImpl getDocumentPanel() {
		return documentPanel;
	}

	@Override
	protected void gwtTearDown() throws Exception {
		super.gwtTearDown();
		RootPanel.get().remove(getDocumentPanel());
	}

	@Test
	public void ignoretestCopySignItemTokenAndPasteIntoSignItemToken() {
		// Prepare
		int initialTokenCount = getDocument().getTokenCount(0, 0);
		String copyFromString = "Test";
		String emptyTokenString = "";
		Id firstTokenId = getDocument().getFirstTokenInDocument().getId();
		getDocumentUiListener().onTextChanged(firstTokenId, copyFromString + " ", 0);

		// Precondition - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(initialTokenCount + 1, getDocument().getTokenCount(0, 0));
		int tokenCountBeforePaste = getDocument().getTokenCount(0, 0);
		SignItemToken copyFromToken = (SignItemToken) getDocument().getToken(0, 0, 0);
		SignItemToken targetToken = (SignItemToken) getDocument().getToken(0, 0, 1);

		// Precondition - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(2, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		SignItemTokenBox copyFromTokenBox = getBoxById(copyFromToken.getId());
		SignItemTokenBox targetTokenBox = getBoxById(targetToken.getId());
		assertEquals(copyFromString, copyFromTokenBox.getText());
		assertEquals(emptyTokenString, targetTokenBox.getText());

		// Precondition - UI
		LayoutedSignItemTokenBoxWidget copyFromWidget = getTokenBoxWidgetById(copyFromToken.getId());
		LayoutedSignItemTokenBoxWidget targetWidget = getTokenBoxWidgetById(targetToken.getId());
		assertEquals(copyFromString, copyFromWidget.getText());
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		// Action - Copy
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), false); // navigate
																				// to
																				// token
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), true); // mark
																			// token
																			// as
																			// selected
		getDocumentUiListener().onCopy();

		// Action - Paste
		getDocumentUiListener().onSelectToken(targetToken.getId(), false);
		LayoutedSearchWordBox area = getLayoutedSearchWordBox(targetWidget);
		createPasteEvent(copyFromString, area);

		// Check - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(tokenCountBeforePaste, getDocument().getTokenCount(0, 0));

		// Check - Token
		assertEquals(emptyTokenString, targetToken.getText());
		Token pastedToken = getDocument().getToken(0, 0, 1);
		assertNotNull(pastedToken);
		assertEquals(SignItemToken.class, pastedToken.getClass());
		assertEquals(copyFromString, ((SignItemToken) pastedToken).getText());

		// Check - Layout
		SignItemTokenBox pastedTokenBox = getBoxById(pastedToken.getId());
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(3, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(emptyTokenString, targetTokenBox.getText());
		assertEquals(copyFromString, pastedTokenBox.getText());

		// Check - UI
		assertEquals(3, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));
		LayoutedSignItemTokenBoxWidget pastedWidget = getTokenBoxWidgetById(pastedToken.getId());
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(copyFromString, pastedWidget.getText());
	}

	@Test
	public void ignoretestCopySignItemTokenAndPasteAtBeginningOfSignItemToken() {
		// Prepare
		int initialTokenCount = getDocument().getTokenCount(0, 0);
		String targetString = "Hallo";
		String copyFromString = "Test";
		Id firstTokenId = getDocument().getFirstTokenInDocument().getId();
		getDocumentUiListener().onTextChanged(firstTokenId, targetString + " " + copyFromString, 0);

		// Precondition - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(initialTokenCount + 1, getDocument().getTokenCount(0, 0));
		int tokenCountBeforePaste = getDocument().getTokenCount(0, 0);

		SignItemToken targetToken = (SignItemToken) getDocument().getToken(0, 0, 0);
		SignItemToken copyFromToken = (SignItemToken) getDocument().getToken(0, 0, 1);

		// Precondition - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(2, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		SignItemTokenBox copyFromTokenBox = getBoxById(copyFromToken.getId());
		SignItemTokenBox targetTokenBox = getBoxById(targetToken.getId());
		assertEquals(copyFromString, copyFromTokenBox.getText());
		assertEquals(targetString, targetTokenBox.getText());

		// Precondition - UI
		LayoutedSignItemTokenBoxWidget copyFromWidget = getTokenBoxWidgetById(copyFromToken.getId());
		LayoutedSignItemTokenBoxWidget targetWidget = getTokenBoxWidgetById(targetToken.getId());
		assertEquals(copyFromString, copyFromWidget.getText());
		assertEquals(targetString, targetWidget.getText());
		assertEquals(2, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		// Action - Copy
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), false); // navigate
																				// to
																				// token
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), true); // mark
																			// token
																			// as
																			// selected
		getDocumentUiListener().onCopy();

		// Action - Paste
		getDocumentUiListener().onSelectToken(targetToken.getId(), false);
		LayoutedSearchWordBox area = getLayoutedSearchWordBox(targetWidget);
		area.setCursorPos(0);
		createPasteEvent(copyFromString, area);

		// Check - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(tokenCountBeforePaste + 1, getDocument().getTokenCount(0, 0));

		// Check - Token
		assertEquals(targetString, targetToken.getText());
		Token pastedToken = getDocument().getToken(0, 0, 0);
		assertNotNull(pastedToken);
		assertEquals(SignItemToken.class, pastedToken.getClass());
		assertEquals(copyFromString, ((SignItemToken) pastedToken).getText());

		// Check - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(3, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		SignItemTokenBox pastedTokenBox = getBoxById(pastedToken.getId());
		assertEquals(targetString, targetTokenBox.getText());
		assertEquals(copyFromString, pastedTokenBox.getText());

		// Check - UI
		assertEquals(3, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));
		LayoutedSignItemTokenBoxWidget pastedWidget = getTokenBoxWidgetById(pastedToken.getId());
		assertEquals(targetString, targetWidget.getText());
		assertEquals(copyFromString, pastedWidget.getText());
	}

	@Test
	public void ignoretestCopyDifferentTokensAndPasteIntoSignItemToken() {
		// Prepare
		int initialTokenCount = getDocument().getTokenCount(0, 0);
		String emptyTokenString = "";
		String copyFromString = "Test";
		Id firstTokenId = getDocument().getFirstTokenInDocument().getId();
		getDocumentUiListener().onTextChanged(firstTokenId, copyFromString, 0);
		getDocumentEditorSidebarListener().onAddFrame();
		getDocumentEditorSidebarListener().onAddFreeTextBox();
		getDocumentEditorSidebarListener().onAddSignItemToken();
		String copyString = copyFromString + "  "; // spaces for empty
													// FreeTextToken and
													// FrameToken

		// Precondition - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(initialTokenCount + 3, getDocument().getTokenCount(0, 0));
		int tokenCountBeforePaste = getDocument().getTokenCount(0, 0);
		SignItemToken copyFromToken = (SignItemToken) getDocument().getToken(0, 0, 0);
		FreeTextToken copyToToken = (FreeTextToken) getDocument().getToken(0, 0, 2);
		SignItemToken targetToken = (SignItemToken) getDocument().getToken(0, 0, 3);

		// Precondition - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(4, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		SignItemTokenBox targetTokenBox = getBoxById(targetToken.getId());
		assertEquals(emptyTokenString, targetTokenBox.getText());

		// Precondition - UI
		LayoutedSignItemTokenBoxWidget targetWidget = getTokenBoxWidgetById(targetToken.getId());
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(4, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		// Action - Copy
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), false); // navigate
																				// to
																				// token
		getDocumentUiListener().onSelectToken(copyToToken.getId(), true); // mark
																			// tokens
																			// as
																			// selected
		getDocumentUiListener().onCopy();

		// Action - Paste
		getDocumentUiListener().onSelectToken(targetToken.getId(), false);
		LayoutedSearchWordBox area = getLayoutedSearchWordBox(targetWidget);
		createPasteEvent(copyString, area);

		// Check - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(tokenCountBeforePaste + 3, getDocument().getTokenCount(0, 0));

		// Check - Token
		assertEquals(emptyTokenString, targetToken.getText());
		Token pastedSignItemToken = getDocument().getToken(0, 0, 4);
		Token pastedFrameToken = getDocument().getToken(0, 0, 5);
		Token pastedFreeTextToken = getDocument().getToken(0, 0, 6);
		assertNotNull(pastedSignItemToken);
		assertNotNull(pastedFreeTextToken);
		assertNotNull(pastedFrameToken);
		assertEquals(SignItemToken.class, pastedSignItemToken.getClass());
		assertEquals(FreeTextToken.class, pastedFreeTextToken.getClass());
		assertEquals(FrameToken.class, pastedFrameToken.getClass());
		assertEquals(copyFromString, ((SignItemToken) pastedSignItemToken).getText());

		// Check - Layout
		assertEquals(emptyTokenString, targetTokenBox.getText());
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(3, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(6, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 2)));
		SignItemTokenBox pastedSignItemTokenBox = getBoxById(pastedSignItemToken.getId());
		assertEquals(copyFromString, pastedSignItemTokenBox.getText());

		// Check - UI
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(6, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 2)));
		LayoutedSignItemTokenBoxWidget pastedSignItemWidget = getTokenBoxWidgetById(pastedSignItemToken.getId());
		assertEquals(copyFromString, pastedSignItemWidget.getText());
	}

	@Test
	public void testPasteTextIntoSignItemToken() {
		// Prepare
		final int initialTokenCount = getDocument().getTokenCount(0, 0);
		final String halloString = "Hallo";
		final String testString = "Test";
		String copyString = halloString + " " + testString;
		String emptyTokenString = "";

		// Precondition - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(initialTokenCount, getDocument().getTokenCount(0, 0));

		Id targetTokenId = getDocument().getFirstTokenInDocument().getId();
		final SignItemToken targetToken = (SignItemToken) getDocument().getToken(targetTokenId);

		// Precondition - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		final SignItemTokenBox targetTokenBox = getBoxById(targetTokenId);
		assertEquals(emptyTokenString, targetTokenBox.getText());

		// Precondition - UI
		final LayoutedSignItemTokenBoxWidget targetWidget = getTokenBoxWidgetById(targetToken.getId());
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		// Action - Paste
		getDocumentUiListener().onSelectToken(targetToken.getId(), false);
		LayoutedSearchWordBox area = getLayoutedSearchWordBox(targetWidget);
		createPasteEvent(copyString, area);

		Timer timer = new Timer() {

			@Override
			public void run() {
				// DOES NOT WORK THAT WAY
				// Check - Document
			}
		};

	}

	@Ignore
	@Test
	public void ignoreignoretestCopySignItemTokensAndPasteIntoEmptyFreeTextToken() {
		// Prepare
		int initialTokenCount = getDocument().getTokenCount(0, 0);
		String copyString = "Hallo Test";
		String emptyTokenString = "";
		Id firstTokenId = getDocument().getFirstTokenInDocument().getId();
		getDocumentUiListener().onTextChanged(firstTokenId, copyString, 0);
		getDocumentEditorSidebarListener().onAddFreeTextBox();

		// Precondition - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(initialTokenCount + 2, getDocument().getTokenCount(0, 0));
		int tokenCountBeforePaste = getDocument().getTokenCount(0, 0);

		SignItemToken copyFromToken = (SignItemToken) getDocument().getToken(0, 0, 0);
		SignItemToken copyToToken = (SignItemToken) getDocument().getToken(0, 0, 1);
		FreeTextToken targetToken = (FreeTextToken) getDocument().getToken(0, 0, 2);

		// Precondition - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(3, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		FreeTextTokenBox targetTokenBox = getBoxById(targetToken.getId());
		assertEquals(emptyTokenString, targetTokenBox.getText());

		// Precondition - UI
		FreeTextTokenBoxWidget targetWidget = getTokenBoxWidgetById(targetToken.getId());
		assertEquals(emptyTokenString, targetWidget.getText());
		assertEquals(3, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));

		// Action - Copy
		getDocumentUiListener().onSelectToken(copyFromToken.getId(), false); // navigate
																				// to
																				// token
		getDocumentUiListener().onSelectToken(copyToToken.getId(), true); // mark
																			// first
																			// two
																			// tokens
																			// as
																			// selected
		getDocumentUiListener().onCopy();

		// Action - Paste
		getDocumentUiListener().onSelectToken(targetToken.getId(), false);
		ExtendedRichTextArea textArea = getTextAreaFromFreeTextTokenBoxWidget(targetWidget);
		createPasteEvent(copyString, textArea);

		// Check - Document
		assertEquals(1, getDocument().getSectionCount());
		assertEquals(1, getDocument().getParagraphCount(0));
		assertEquals(tokenCountBeforePaste, getDocument().getTokenCount(0, 0));
		assertEquals(copyString, targetToken.getText());

		// Check - Layout
		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getLineCount(0));
		assertEquals(3, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(copyString, targetTokenBox.getText());

		// Check - UI
		assertEquals(3, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, documentPanel.getIdBoxWidgetCount(new LineIndex(0, 1)));
		assertEquals(copyString, targetWidget.getText());
	}
}
