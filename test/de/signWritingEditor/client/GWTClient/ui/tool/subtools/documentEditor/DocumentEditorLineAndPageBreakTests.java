package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorInsertLineOrPageBreakMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.FontSizeServiceMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.UnitTestCase;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;

public class DocumentEditorLineAndPageBreakTests extends UnitTestCase {

	private DocumentEditorInsertLineOrPageBreakMock documentEditor;
	private IdFactory idFactory;
	private TokenFactory tokenFactory;
	private Document dummyDocument;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(0);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);

		dummyDocument = createDummyDocument();

		documentEditor = new DocumentEditorInsertLineOrPageBreakMock(new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(idFactory), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new BrowserHistoryServiceMock(), new FontSizeServiceMock(),
				new BadgeServiceMock(), idFactory, textbasedTokenStyleFactory,
				new LocalSessionServiceForUnknownUserMock(), createDummyRoot(), SignLocale.DGS,
				new DocumentEditorListenerMock(), dummyDocument);
	}

	protected RoomItem createDummyRoot() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}

	@Test
	public void testInsertLineBreakWithoutAutomaticFreeTextLine() {
		// Prepare
		Token tokenBeforeLineBreak = dummyDocument.getToken(0, 0, 2);
		Id tokenBeforeLineBreakId = tokenBeforeLineBreak.getId();
		List<Token> tokensToInsert = new ArrayList<Token>();
		SignItemToken tokenAfterLineBreak = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		tokensToInsert.add(tokenAfterLineBreak);

		// Action
		callInsertPageOrLineBreakOnDocumentEditor(tokenBeforeLineBreakId, Tokenizer.LINE_BREAK, tokensToInsert);

		// Check
		assertEquals(1, dummyDocument.getSectionCount());
		assertEquals(4, dummyDocument.getParagraphCount(0));
		assertEquals(3, dummyDocument.getTokenCount(0, 0));
		assertEquals(tokenBeforeLineBreak, dummyDocument.getToken(0, 0, 2));
		assertEquals(2, dummyDocument.getTokenCount(0, 1));
		assertEquals(tokenAfterLineBreak, dummyDocument.getToken(0, 1, 0));
	}

	@Test
	public void testInsertPageBreakWithoutAutomaticFreeTextLine() {
		// Prepare
		Token tokenBeforeLineBreak = dummyDocument.getToken(0, 0, 2);
		Id tokenBeforeLineBreakId = tokenBeforeLineBreak.getId();
		List<Token> tokensToInsert = new ArrayList<Token>();
		SignItemToken tokenAfterLineBreak = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		tokensToInsert.add(tokenAfterLineBreak);

		// Action
		callInsertPageOrLineBreakOnDocumentEditor(tokenBeforeLineBreakId, Tokenizer.PAGE_BREAK, tokensToInsert);

		// Check
		assertEquals(2, dummyDocument.getSectionCount());
		assertEquals(1, dummyDocument.getParagraphCount(0));
		assertEquals(3, dummyDocument.getParagraphCount(1));
		assertEquals(3, dummyDocument.getTokenCount(0, 0));
		assertEquals(tokenBeforeLineBreak, dummyDocument.getToken(0, 0, 2));
		assertEquals(2, dummyDocument.getTokenCount(1, 0));
		assertEquals(tokenAfterLineBreak, dummyDocument.getToken(1, 0, 0));
	}

	@Test
	public void testInsertLineBreakWithAutomaticFreeTextLine() {
		// Prepare
		Token tokenBeforeLineBreak = dummyDocument.getToken(0, 0, 2);
		Id tokenBeforeLineBreakId = tokenBeforeLineBreak.getId();
		List<Token> tokensToInsert = new ArrayList<Token>();
		SignItemToken tokenAfterLineBreak = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		tokensToInsert.add(tokenAfterLineBreak);

		documentEditor.setAtomaticFreeTextLine(true);
		// Action
		callInsertPageOrLineBreakOnDocumentEditor(tokenBeforeLineBreakId, Tokenizer.LINE_BREAK, tokensToInsert);

		// Check
		assertEquals(1, dummyDocument.getSectionCount());
		assertEquals(4, dummyDocument.getParagraphCount(0));

		assertEquals(4, dummyDocument.getTokenCount(0, 0));
		assertEquals(tokenBeforeLineBreak, dummyDocument.getToken(0, 0, 2));
		assertTrue(dummyDocument.getToken(0, 0, 3) instanceof FreeTextToken);

		assertEquals(2, dummyDocument.getTokenCount(0, 1));
		assertEquals(tokenAfterLineBreak, dummyDocument.getToken(0, 1, 0));
	}

	@Test
	public void testInsertPageBreakWithAutomaticFreeTextLine() {
		// Prepare
		Token tokenBeforeLineBreak = dummyDocument.getToken(0, 0, 2);
		Id tokenBeforeLineBreakId = tokenBeforeLineBreak.getId();
		List<Token> tokensToInsert = new ArrayList<Token>();
		SignItemToken tokenAfterLineBreak = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		tokensToInsert.add(tokenAfterLineBreak);

		documentEditor.setAtomaticFreeTextLine(true);

		// Action
		callInsertPageOrLineBreakOnDocumentEditor(tokenBeforeLineBreakId, Tokenizer.PAGE_BREAK, tokensToInsert);

		// Check
		assertEquals(2, dummyDocument.getSectionCount());
		assertEquals(1, dummyDocument.getParagraphCount(0));
		assertEquals(3, dummyDocument.getParagraphCount(1));

		assertEquals(4, dummyDocument.getTokenCount(0, 0));
		assertEquals(tokenBeforeLineBreak, dummyDocument.getToken(0, 0, 2));
		assertTrue(dummyDocument.getToken(0, 0, 3) instanceof FreeTextToken);

		assertEquals(2, dummyDocument.getTokenCount(1, 0));
		assertEquals(tokenAfterLineBreak, dummyDocument.getToken(1, 0, 0));
	}

	private void callInsertPageOrLineBreakOnDocumentEditor(Id id, char breakChar, List<Token> tokensToInsert) {
		Class<?>[] argClasses = new Class<?>[3];
		argClasses[0] = Id.class;
		argClasses[1] = char.class;
		argClasses[2] = List.class;

		this.callMethod(documentEditor, DocumentEditor.class, argClasses, "insertLineOrPageBreakAndTokensAfter", id,
				breakChar, (List<Token>) tokensToInsert);
	}

	private Document createDummyDocument() {
		Document dummyDocument = new Document(User.getUnknownUser(), SignLocale.DGS,
				new FileTitle("For what its worth"), PageFormat.A4_PORTRAIT);

		Section firstSection = new Section();
		Paragraph firstParagraph = new Paragraph(idFactory.createId());
		firstParagraph.addToken(tokenFactory.createSignItemToken("Something",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		firstParagraph.addToken(tokenFactory.createSignItemToken("is",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		firstParagraph.addToken(tokenFactory.createSignItemToken("happening",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		firstParagraph.addToken(tokenFactory.createSignItemToken("here",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		firstSection.addParagraph(firstParagraph);

		Paragraph secondParagraph = new Paragraph(idFactory.createId());
		secondParagraph.addToken(tokenFactory.createSignItemToken("What",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		secondParagraph.addToken(tokenFactory.createSignItemToken("it",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		secondParagraph.addToken(tokenFactory.createSignItemToken("is",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		secondParagraph.addToken(tokenFactory.createSignItemToken("aint",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		secondParagraph.addToken(tokenFactory.createSignItemToken("exactly",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		secondParagraph.addToken(tokenFactory.createSignItemToken("clear",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		firstSection.addParagraph(secondParagraph);

		Paragraph thirdParagraph = new Paragraph(idFactory.createId());
		thirdParagraph.addToken(tokenFactory.createSignItemToken("Bruce",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		thirdParagraph.addToken(tokenFactory.createSignItemToken("Springstein",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		firstSection.addParagraph(thirdParagraph);

		dummyDocument.addSection(firstSection);

		return dummyDocument;
	}
}
