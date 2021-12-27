package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.infrastructure.CopyPasteUnitTestCase;
import de.signWritingEditor.client.GWTClient.infrastructure.DocumentEditorPasteMock;
import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.FontSizeServiceMock;
import de.signWritingEditor.infrastructure.GWTDocumentLayouterMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;

public class DocumentEditorPasteTest extends CopyPasteUnitTestCase {

	private DocumentEditor documentEditor;
	private Clipboard clipboard;
	private Document copyFromDocument;

	public void setUp() throws Exception {
		super.setUp();

		FontSizeService fontSizeService = new FontSizeServiceMock();
		documentEditor = new DocumentEditorPasteMock(new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(getIdFactory()), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new BrowserHistoryServiceMock(), fontSizeService,
				new BadgeServiceMock(), getIdFactory(), getStyleFactory(), new LocalSessionServiceForUnknownUserMock(),
				createDummyRoot(), SignLocale.DGS, new DocumentEditorListenerMock());
		DocumentEditorPasteMock pasteDocumentEditorMock = (DocumentEditorPasteMock) documentEditor;
		pasteDocumentEditorMock.setGwtDocumentLayouter(new GWTDocumentLayouterMock());
		clipboard = pasteDocumentEditorMock.getClipboard();
		pasteDocumentEditorMock.setDocument(getDocument());
		copyFromDocument = createDummyDocument();
		getDocument().setGlossWritingActive(false);
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	private void setCursorToLastPositionInTargetToken(String pastedText, String targetTokenText) {
		setCursorPositionInTargetToken(pastedText.length() + targetTokenText.length());
	}

	private void setCursorToFirstPositionInTargetToken(String pastedText) {
		setCursorPositionInTargetToken(pastedText.length());
	}

	private void setCursorPositionInTargetToken(int cursorPosition) {
		((DocumentEditorPasteMock) documentEditor).setCursorPositionInTargetToken(cursorPosition);
	}

	private void setClipboardContent(String pastedText, List<Section> sectionList) {
		getClipboard().setText(pastedText);
		getClipboard().setContent(sectionList);
	}

	private Document getCopyFromDocument() {
		return copyFromDocument;
	}

	private List<Section> createSectionListFromToken(Token... tokens) {
		assert tokens != null : "Precondition failed: tokens != null";
		Paragraph copyParagraph = new Paragraph(getIdFactory().createId());

		for (Token token : tokens) {
			copyParagraph.addToken(token);
		}
		return createSectionListFromParagraph(copyParagraph);
	}

	private List<Section> createSectionListFromParagraph(Paragraph... paragraphs) {
		assert paragraphs != null : "Precondition failed: paragraphs != null";
		Section copySection = new Section();

		for (Paragraph paragraph : paragraphs) {
			copySection.addParagraph(paragraph);
		}
		return createSectionList(copySection);
	}

	private List<Section> createSectionList(Section... sections) {
		assert sections != null : "Precondition failed: sections != null";
		List<Section> sectionList = new ArrayList<Section>();
		for (Section section : sections) {
			sectionList.add(section);
		}
		return sectionList;
	}

	private Section createAndAddCollageToDocument() {
		Section result = new Section();
		result.setIsCollage(true, getIdFactory().createId());
		getDocument().addSection(result);
		return result;
	}

	private void selectTokensFromTo(Id fromTokenId, Id toTokenId) {
		setFieldValue(documentEditor, DocumentEditor.class, "firstSelectedTokenId", fromTokenId);
		setFieldValue(documentEditor, DocumentEditor.class, "currentCursorTokenId", toTokenId);
	}

	@Test
	public void testHandlePasteTokenAfter() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		assertTrue(copyParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = copyToken.getText();
		List<Section> sectionList = createSectionListFromToken(copyToken);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(targetParagraph.getTokenCount() - 1);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, getDocument().getSection(1).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(1).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		testTokensContentEquality(copyToken,
				targetParagraphAfterPaste.getToken(targetParagraphAfterPaste.getTokenCount() - 1));
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(targetParagraphAfterPaste.getTokenCount() - 2));
	}

	@Test
	public void testHandlePasteTokenIntoEmptyToken() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		assertTrue(copyParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = copyToken.getText();
		List<Section> sectionList = createSectionListFromToken(copyToken);

		Section targetSection = getDocument().getSection(2);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		assertTrue(targetParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken emptyTargetToken = (SignItemToken) targetParagraph.getToken(0);
		assertTrue(emptyTargetToken.isEmpty());
		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, emptyTargetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", emptyTargetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, getDocument().getSection(2).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(2).getParagraph(0);
		assertEquals(tokenCountBeforePaste, targetParagraphAfterPaste.getTokenCount());
		testTokensContentEquality(copyToken, targetParagraphAfterPaste.getToken(0));
	}

	@Test
	public void testHandlePasteTokenBefore() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		assertTrue(copyParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = copyToken.getText();
		List<Section> sectionList = createSectionListFromToken(copyToken);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		int tokenIndexOfTargetTokenBeforePaste = targetParagraph.getTokenCount() - 1;
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(tokenIndexOfTargetTokenBeforePaste);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pastedText, sectionList);
		setCursorToFirstPositionInTargetToken(pastedText);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, getDocument().getSection(1).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(1).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		testTokensContentEquality(copyToken, targetParagraphAfterPaste.getToken(tokenIndexOfTargetTokenBeforePaste));
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(tokenIndexOfTargetTokenBeforePaste + 1));
	}

	@Test
	public void testHandlePasteTokenAtTheEndOfDocument() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		assertTrue(copyParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = copyToken.getText();
		List<Section> sectionList = createSectionListFromToken(copyToken);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		Section targetSection = getDocument().getSection(sectionCountBeforePaste - 1);
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		Paragraph targetParagraph = targetSection.getParagraph(paragraphCountBeforePaste - 1);
		int tokenCountBeforePaste = targetParagraph.getTokenCount();
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(tokenCountBeforePaste - 1);

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste,
				getDocument().getSection(sectionCountBeforePaste - 1).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(sectionCountBeforePaste - 1)
				.getParagraph(paragraphCountBeforePaste - 1);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(targetParagraphAfterPaste.getTokenCount() - 2));
		testTokensContentEquality(copyToken,
				targetParagraphAfterPaste.getToken(targetParagraphAfterPaste.getTokenCount() - 1));
	}

	@Test
	public void testHandlePasteParagraphsAfter() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph paragraph1 = copySection.getParagraph(0);
		Paragraph paragraph2 = copySection.getParagraph(1);
		String pastedText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut";
		List<Section> sectionList = createSectionList(copySection);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		int tokenIndexOfTargetTokenBeforePaste = targetParagraph.getTokenCount() - 1;
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(tokenIndexOfTargetTokenBeforePaste);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste + 1, getDocument().getSection(1).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(1).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(tokenIndexOfTargetTokenBeforePaste));
		testTokensContentEquality(paragraph1.getToken(0),
				targetParagraphAfterPaste.getToken(tokenIndexOfTargetTokenBeforePaste + 1));
		testParagrahContentEquality(paragraph2, getDocument().getSection(1).getParagraph(1));
	}

	@Test
	public void testHandlePasteParagraphsBefore() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph1 = copySection.getParagraph(0);
		Paragraph copyParagraph2 = copySection.getParagraph(1);
		String pasteText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut";
		List<Section> sectionList = createSectionList(copySection);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pasteText, sectionList);
		setCursorToFirstPositionInTargetToken(pasteText);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pasteText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste + 1, getDocument().getSection(1).getParagraphCount());
		testParagrahContentEquality(copyParagraph1, getDocument().getSection(1).getParagraph(0));
		assertEquals(tokenCountBeforePaste + copyParagraph2.getTokenCount(),
				getDocument().getSection(1).getParagraph(1).getTokenCount());
		testTokensContentEquality(targetToken,
				getDocument().getSection(1).getParagraph(1).getToken(copyParagraph2.getTokenCount()));
	}

	private void testSectionContentEquality(Section expectedSection, Section actualSection) {
		assertEquals(expectedSection.getParagraphCount(), actualSection.getParagraphCount());

		List<Paragraph> expectedParagraphs = expectedSection.getParagraphs();
		List<Paragraph> actualParagraphs = actualSection.getParagraphs();

		for (int i = 0; i < actualParagraphs.size(); i++) {
			testParagrahContentEquality(expectedParagraphs.get(i), actualParagraphs.get(i));
		}
	}

	private void testParagrahContentEquality(Paragraph expectedParagraph, Paragraph actualParagraph) {
		assertEquals(expectedParagraph.getPositionX(), actualParagraph.getPositionX());
		assertEquals(expectedParagraph.getPositionY(), actualParagraph.getPositionY());
		assertEquals(expectedParagraph.getZIndex(), actualParagraph.getZIndex());
		assertEquals(expectedParagraph.getWidth(), actualParagraph.getWidth());
		assertEquals(expectedParagraph.getTokenCount(), actualParagraph.getTokenCount());

		List<Token> expectedTokens = expectedParagraph.getTokens();
		List<Token> actualTokens = actualParagraph.getTokens();

		for (int i = 0; i < actualTokens.size(); i++) {
			testTokensContentEquality(expectedTokens.get(i), actualTokens.get(i));
		}
	}

	private void testTokensContentEquality(Token expectedToken, Token actualToken) {
		assertTrue(expectedToken.getClass().equals(actualToken.getClass()));
		if (expectedToken instanceof SignItemToken) {
			compareSignItemTokens((SignItemToken) expectedToken, (SignItemToken) actualToken);
		} else {
			assertTrue("Token type not implemented", false);
		}
	}

	private void compareSignItemTokens(SignItemToken expectedToken, SignItemToken actualToken) {
		assertEquals(expectedToken.getBackgroundColor(), actualToken.getBackgroundColor());
		assertEquals(expectedToken.getLocale(), actualToken.getLocale());
		assertEquals(expectedToken.getSignItem(), actualToken.getSignItem());
		assertEquals(expectedToken.getSignHeight_PX(), actualToken.getSignHeight_PX());
		assertEquals(expectedToken.getText(), actualToken.getText());
		assertEquals(expectedToken.getStyle(), actualToken.getStyle());
	}

	@Test
	public void testHandlePasteLocalDictionary() {
		// Prepare
		Section copySection = new Section();
		Paragraph copyParagraph = new Paragraph(getIdFactory().createId());
		String pastedText = "Test";
		Token copyToken = getTokenFactory().createSignItemToken(pastedText,
				getStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		assertEquals(SignItemToken.class, copyToken.getClass());
		SignItemToken signItemToken = (SignItemToken) copyToken;
		SignId id = new SignId(0, "Test", SignLocale.DGS, SignSource.UNKNOWN);
		SimpleSign localSign = new SimpleSign(id, User.getUnknownUser(), SignLocale.DGS, new Date(0), "test purpose");
		SignItem newSignItem = new SignItem(localSign);
		signItemToken.setSignItem(newSignItem);
		copyParagraph.addToken(copyToken);
		copySection.addParagraph(copyParagraph);
		List<Section> sectionList = new ArrayList<Section>();
		sectionList.add(copySection);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(targetParagraph.getTokenCount() - 1);

		int cursorPositionInTargetToken = targetToken.getText().length() + pastedText.length();

		// Action
		getClipboard().setText(pastedText);
		getClipboard().setContent(sectionList);
		setCursorPositionInTargetToken(cursorPositionInTargetToken);
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertNotNull(getClipboard().getContent());
		assertTrue(getClipboard().getContent() instanceof List);
		List<Section> content = getClipboard().getContent();
		assertEquals(1, content.size());
		Section copiedSection = content.get(0);
		assertEquals(1, copiedSection.getParagraphCount());
		Paragraph copiedParagraph = copiedSection.getParagraph(0);
		assertEquals(1, copiedParagraph.getTokenCount());
		assertEquals(copyToken, copiedParagraph.getToken(0));

		LocalDictionary localDictionary = getDocument().getLocalDictionary();
		assertTrue(localDictionary.contains(id));
		assertEquals(localSign, localDictionary.getSign(id));
	}

	@Test
	public void testHandlePasteTwoSectionsAtEndOfDocument() {
		// Prepare
		Section copySectionFrom = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph1 = copySectionFrom.getParagraph(0);
		Paragraph copyParagraph2 = copySectionFrom.getParagraph(1);
		Section copySectionTo = getCopyFromDocument().getSection(1);

		List<Section> sectionList = createSectionList(copySectionFrom, copySectionTo);
		String pastedText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht";

		int sectionCountBeforePaste = getDocument().getSectionCount();
		Section targetSection = getDocument().getSection(sectionCountBeforePaste - 1);
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		Paragraph targetParagraph = targetSection.getParagraph(paragraphCountBeforePaste - 1);
		int tokenCountBeforePaste = targetParagraph.getTokenCount();
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(tokenCountBeforePaste - 1);

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste + 1, getDocument().getSectionCount());
		int sectionCountAfterPaste = sectionCountBeforePaste + 1;
		Section targetSectionAfterPaste = getDocument().getSection(sectionCountAfterPaste - 2);
		assertEquals(paragraphCountBeforePaste + 1, targetSectionAfterPaste.getParagraphCount());
		Paragraph targetParagraphAfterPaste = targetSectionAfterPaste.getParagraph(0);
		assertEquals(tokenCountBeforePaste + copyParagraph1.getTokenCount(), targetParagraphAfterPaste.getTokenCount());
		int tokenCountAfterPaste = targetParagraphAfterPaste.getTokenCount();
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(tokenCountAfterPaste - 2));
		testTokensContentEquality(copyParagraph1.getToken(0),
				targetParagraphAfterPaste.getToken(tokenCountAfterPaste - 1));
		testParagrahContentEquality(copyParagraph2, targetSectionAfterPaste.getParagraph(1));
		Section pastedSection = getDocument().getSection(sectionCountAfterPaste - 1);
		testSectionContentEquality(copySectionTo, pastedSection);
	}

	@Test
	public void testHandlePasteTwoSectionsIntoParagraph() {
		// Prepare
		Section copySectionFrom = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph1 = copySectionFrom.getParagraph(0);
		Paragraph copyParagraph2 = copySectionFrom.getParagraph(1);
		Section copySectionTo = getCopyFromDocument().getSection(1);
		Paragraph copyParagraph3 = copySectionTo.getParagraph(0);
		Paragraph copyParagraph4 = copySectionTo.getParagraph(1);

		List<Section> sectionList = createSectionList(copySectionFrom, copySectionTo);
		String pastedText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht";

		int sectionCountBeforePaste = getDocument().getSectionCount();
		Section targetSection = getDocument().getSection(sectionCountBeforePaste - 1);
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		Paragraph targetParagraph = targetSection.getParagraph(0);
		int tokenCountBeforePaste = targetParagraph.getTokenCount();
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste + 1, getDocument().getSectionCount());
		int sectionCountAfterPaste = sectionCountBeforePaste + 1;
		Section targetSectionAfterPaste = getDocument().getSection(sectionCountAfterPaste - 2);
		assertEquals(paragraphCountBeforePaste + 1, targetSectionAfterPaste.getParagraphCount());
		Paragraph targetParagraphAfterPaste = targetSectionAfterPaste.getParagraph(0);
		assertEquals(2, targetParagraphAfterPaste.getTokenCount());
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(0));
		testTokensContentEquality(copyParagraph1.getToken(0), targetParagraphAfterPaste.getToken(1));
		testParagrahContentEquality(copyParagraph2, targetSectionAfterPaste.getParagraph(1));
		Section pastedSection = getDocument().getSection(sectionCountAfterPaste - 1);
		assertEquals(paragraphCountBeforePaste + 1, pastedSection.getParagraphCount());
		testParagrahContentEquality(copyParagraph3, pastedSection.getParagraph(0));
		assertEquals(copyParagraph4.getTokenCount() + tokenCountBeforePaste - 1,
				pastedSection.getParagraph(1).getTokenCount());
	}

	@Test
	public void testHandlePasteMultipleSectionsAtEndOfDocument() {
		// Prepare
		Section copySection1 = getCopyFromDocument().getSection(0);
		Section copySection2 = getCopyFromDocument().getSection(1);
		Section copySection3 = getCopyFromDocument().getSection(2);
		List<Section> sectionList = createSectionList(copySection1, copySection2, copySection3);
		Paragraph copyParagraph1 = copySection1.getParagraph(0);
		Paragraph copyParagraph2 = copySection1.getParagraph(1);
		String pastedText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht\f ";

		int sectionCountBeforePaste = getDocument().getSectionCount();
		Section targetSection = getDocument().getSection(sectionCountBeforePaste - 1);
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		Paragraph targetParagraph = targetSection.getParagraph(paragraphCountBeforePaste - 1);
		int tokenCountBeforePaste = targetParagraph.getTokenCount();
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(tokenCountBeforePaste - 1);

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste + 2, getDocument().getSectionCount());
		Section targetSectionAfterPaste = getDocument().getSection(sectionCountBeforePaste - 1);
		assertEquals(paragraphCountBeforePaste + 1, targetSectionAfterPaste.getParagraphCount());
		Paragraph targetParagraphAfterPaste = targetSectionAfterPaste.getParagraph(0);
		assertEquals(tokenCountBeforePaste + copyParagraph1.getTokenCount(), targetParagraphAfterPaste.getTokenCount());
		int tokenCountAfterPaste = targetParagraphAfterPaste.getTokenCount();
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(tokenCountAfterPaste - 2));
		testTokensContentEquality(copyParagraph1.getToken(0),
				targetParagraphAfterPaste.getToken(tokenCountAfterPaste - 1));
		testParagrahContentEquality(copyParagraph2, targetSectionAfterPaste.getParagraph(1));
		testSectionContentEquality(copySection2, getDocument().getSection(sectionCountBeforePaste));
		testSectionContentEquality(copySection3, getDocument().getSection(sectionCountBeforePaste + 1));
	}

	@Test
	public void testHandlePasteMultipleSectionsAtBeginningOfDocument() {
		// Prepare
		Section copySection1 = getCopyFromDocument().getSection(0);
		Section copySection2 = getCopyFromDocument().getSection(1);
		Section copySection3 = getCopyFromDocument().getSection(2);
		List<Section> sectionList = createSectionList(copySection1, copySection2, copySection3);
		Paragraph copyParagraph = copySection3.getParagraph(0);
		String pastedText = "Hallo\nSpiderschwein Spiderschwein macht was ein Spiderschwein so tut\fDa . Da . Da .\nIch lieb dich nicht du liebst mich nicht\f ";

		int sectionCountBeforePaste = getDocument().getSectionCount();
		Section targetSection = getDocument().getSection(0);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);
		Section originalSection2 = getDocument().getSection(1);
		Section originalSection3 = getDocument().getSection(2);
		Section originalSection4 = getDocument().getSection(3);

		setClipboardContent(pastedText, sectionList);
		setCursorToFirstPositionInTargetToken(pastedText);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste + 2, getDocument().getSectionCount());
		testSectionContentEquality(copySection1, getDocument().getSection(0));
		testSectionContentEquality(copySection2, getDocument().getSection(1));
		Section mergedSection = getDocument().getSection(2);
		assertEquals(targetSection.getParagraphCount(), mergedSection.getParagraphCount());
		Paragraph mergedParagraph = mergedSection.getParagraph(0);
		testTokensContentEquality(copyParagraph.getToken(0), mergedParagraph.getToken(0));
		assertEquals(targetToken, mergedParagraph.getToken(1));
		assertEquals(originalSection2, getDocument().getSection(3));
		assertEquals(originalSection3, getDocument().getSection(4));
		assertEquals(originalSection4, getDocument().getSection(5));
	}

	@Test
	public void testHandlePasteWithTokenizedCharacters() {
		// Prepare
		String pastedText = "Test!";

		Section targetSection = getDocument().getSection(0);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);
		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		Section targetSectionAfterPaste = getDocument().getSection(0);
		assertEquals(paragraphCountBeforePaste, targetSectionAfterPaste.getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(0).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		SignItemToken mergedToken = (SignItemToken) targetParagraphAfterPaste.getToken(0);
		assertEquals("HalloTest", mergedToken.getText());
		Token pastedToken = targetParagraphAfterPaste.getToken(1);
		assertNotNull(pastedToken);
		assertTrue(pastedToken instanceof SignItemToken);
		assertEquals("!", ((SignItemToken) pastedToken).getText());
	}

	// Tokenizer is tested seperately in TokenizerTest
	@Test
	public void testHandlePasteWithTokenizedCharactersToEmptyToken() {
		// Prepare
		String pastedText = "Test!";

		Section targetSection = getDocument().getSection(0);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);
		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		Section targetSectionAfterPaste = getDocument().getSection(0);
		assertEquals(paragraphCountBeforePaste, targetSectionAfterPaste.getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(0).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		assertEquals(targetToken, targetParagraph.getToken(0));
		Token pastedToken = targetParagraphAfterPaste.getToken(0);
		assertNotNull(pastedToken);
		assertTrue(pastedToken instanceof SignItemToken);
		assertEquals("HalloTest", ((SignItemToken) pastedToken).getText());
		Token pastedToken1 = targetParagraphAfterPaste.getToken(1);
		assertNotNull(pastedToken1);
		assertTrue(pastedToken1 instanceof SignItemToken);
		assertEquals("!", ((SignItemToken) pastedToken1).getText());
	}

	@Test
	public void testHandlePasteWithGlossWritingActive() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		assertTrue(copyParagraph.getToken(0) instanceof SignItemToken);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = copyToken.getText();
		List<Section> sectionList = createSectionListFromToken(copyToken);

		Section targetSection = getDocument().getSection(0);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setClipboardContent(pastedText, sectionList);
		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());
		getDocument().setGlossWritingActive(true);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, getDocument().getSection(0).getParagraphCount());
		Paragraph targetParagraphAfterPaste = getDocument().getSection(0).getParagraph(0);
		assertEquals(tokenCountBeforePaste + 1, targetParagraphAfterPaste.getTokenCount());
		assertEquals(targetToken, targetParagraphAfterPaste.getToken(0));
		Token pastedToken = targetParagraphAfterPaste.getToken(1);
		assertNotNull(pastedToken);
		assertTrue(pastedToken instanceof SignItemToken);
		assertEquals(pastedText.toUpperCase(), ((SignItemToken) pastedToken).getText());
	}

	@Test
	public void testPasteTextIntoCollage() {
		// Prepare
		String pastedText = "Hallo Test";
		Section collage = createAndAddCollageToDocument();
		assertTrue(collage.getParagraphs().isEmpty());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", collage.getCollageId(), pastedText,
				PasteTarget.FP_PAGE);

		// Check
		assertEquals(1, collage.getParagraphCount());
		Paragraph insertedParagraph = collage.getParagraph(0);
		assertEquals(2, insertedParagraph.getTokenCount());
		Token pastedToken1 = insertedParagraph.getToken(0);
		assertTrue(pastedToken1 instanceof SignItemToken);
		Token pastedToken2 = insertedParagraph.getToken(1);
		assertNotNull(pastedToken2);
		assertTrue(pastedToken2 instanceof SignItemToken);
	}

	@Test
	public void testPasteTokenIntoCollage() {
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		int tokenCount = copyParagraph.getTokenCount();
		assertEquals(1, tokenCount);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = "Hallo";
		assertEquals(pastedText, copyToken.getText());
		List<Section> clipboardSection = createSectionListFromToken(copyToken);
		Section collage = createAndAddCollageToDocument();
		assertTrue(collage.getParagraphs().isEmpty());
		setClipboardContent(pastedText, clipboardSection);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", collage.getCollageId(), pastedText,
				PasteTarget.FP_PAGE);

		// Check
		assertEquals(1, collage.getParagraphCount());
		Paragraph insertedParagraph = collage.getParagraph(0);
		assertEquals(tokenCount, insertedParagraph.getTokenCount());
		Token token = insertedParagraph.getToken(0);
		assertTrue(token instanceof SignItemToken);
		assertEquals(copyToken.getText(), ((SignItemToken) token).getText());
		assertEquals(copyToken.getStyle(), ((TextbasedToken) token).getStyle());
	}

	@Test
	public void testPasteTextIntoSnippet() {
		// Prepare
		String pastedText = "Hallo Test";
		Section collage = createAndAddCollageToDocument();
		Paragraph snippet = new Paragraph(getIdFactory().createId());
		snippet.addToken(getTokenFactory().createSignItemToken("Vorher",
				getStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		collage.addParagraph(snippet);
		assertEquals(1, collage.getParagraphCount());

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", snippet.getParagraphId(), pastedText,
				PasteTarget.FP_PARAGRAPH);

		// Check
		assertEquals(1, collage.getParagraphCount());
		Paragraph paragraph = collage.getParagraph(0);
		assertEquals(2, paragraph.getTokenCount());
		Token pastedToken1 = paragraph.getToken(0);
		assertTrue(pastedToken1 instanceof SignItemToken);
		Token pastedToken2 = paragraph.getToken(1);
		assertTrue(pastedToken2 instanceof SignItemToken);
		assertEquals("Hallo", ((SignItemToken) pastedToken1).getText());
		assertEquals("Test", ((SignItemToken) pastedToken2).getText());
	}

	@Test
	public void testPasteTokenIntoSnippet() {
		// Prepare
		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		int tokenCountBeforePaste = copyParagraph.getTokenCount();
		assertEquals(1, tokenCountBeforePaste);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = "Hallo";
		assertEquals(pastedText, copyToken.getText());
		List<Section> clipboardSection = createSectionListFromToken(copyToken);

		Section collage = createAndAddCollageToDocument();
		Paragraph snippet = new Paragraph(getIdFactory().createId());
		snippet.addToken(getTokenFactory().createSignItemToken("Vorher",
				getStyleFactory().createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		collage.addParagraph(snippet);
		assertEquals(1, collage.getParagraphCount());
		setClipboardContent(pastedText, clipboardSection);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", snippet.getParagraphId(), pastedText,
				PasteTarget.FP_PARAGRAPH);

		// Check
		assertEquals(1, collage.getParagraphCount());
		Paragraph paragraph = collage.getParagraph(0);
		assertEquals(tokenCountBeforePaste, paragraph.getTokenCount());
		Token pastedToken = paragraph.getToken(0);
		assertTrue(pastedToken instanceof SignItemToken);
		assertEquals(copyToken.getText(), ((SignItemToken) pastedToken).getText());
		assertEquals(copyToken.getStyle(), ((TextbasedToken) pastedToken).getStyle());
	}

	@Test
	public void testPasteTextIntoSelectedToken() {
		// Prepare

		String pastedText = "TestPasteText";
		Section targetSection = getDocument().getSection(0);
		Paragraph targetParagraph = targetSection.getParagraph(0);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(0);
		targetToken.setText("Haus");

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());
		selectTokensFromTo(targetToken.getId(), targetToken.getId());
		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, targetSection.getParagraphCount());
		assertEquals(tokenCountBeforePaste, targetParagraph.getTokenCount());

		assertEquals(pastedText, targetToken.getText());
	}

	@Test
	public void testPasteTokenIntoSelectedToken() {
		// Prepare

		Section copySection = getCopyFromDocument().getSection(0);
		Paragraph copyParagraph = copySection.getParagraph(0);
		SignItemToken copyToken = (SignItemToken) copyParagraph.getToken(0);
		String pastedText = "TestPaste";
		copyToken.setText(pastedText);
		assertEquals(pastedText, copyToken.getText());
		List<Section> clipboardSection = createSectionListFromToken(copyToken);

		Section targetSection = getDocument().getSection(1);
		Paragraph targetParagraph = targetSection.getParagraph(1);
		SignItemToken targetToken = (SignItemToken) targetParagraph.getToken(1);
		targetToken.setText("Haus");

		int sectionCountBeforePaste = getDocument().getSectionCount();
		int paragraphCountBeforePaste = targetSection.getParagraphCount();
		int tokenCountBeforePaste = targetParagraph.getTokenCount();

		setCursorToLastPositionInTargetToken(pastedText, targetToken.getText());
		selectTokensFromTo(targetToken.getId(), targetToken.getId());
		setClipboardContent(pastedText, clipboardSection);

		// Action
		callMethod(documentEditor, DocumentEditor.class, "handlePaste", targetToken.getId(), pastedText,
				PasteTarget.TOKEN);

		// Check
		assertEquals(sectionCountBeforePaste, getDocument().getSectionCount());
		assertEquals(paragraphCountBeforePaste, targetSection.getParagraphCount());
		assertEquals(tokenCountBeforePaste, targetParagraph.getTokenCount());
		targetToken = (SignItemToken) targetParagraph.getToken(1);

		assertEquals(pastedText, targetToken.getText());
	}

}
