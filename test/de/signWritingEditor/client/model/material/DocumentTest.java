package de.signWritingEditor.client.model.material;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.ParagraphIndex;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;

public class DocumentTest {

	private IdFactory idFactory;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(7);
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	@Test
	public void testDocument() {
		User authorTest = new User("authorTest", "author", "Test", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document1 = new Document(authorTest, SignLocale.DGS, new FileTitle("testDocument"),
				PageFormat.A4_PORTRAIT);
		assertTrue(document1.getAuthor() == authorTest);
		assertTrue(document1.getDocumentTitle().equals(new FileTitle("testDocument")));
		assertEquals(SignLocale.DGS, document1.getSignLocale());
		assertEquals(PageFormat.A4_PORTRAIT, document1.getPageFormat());
		assertTrue(document1.areUnderlinesVisible());

		User authorSomebody = new User("Somebody else", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }),
				1);
		document1.setAuthor(authorSomebody);
		assertTrue(document1.getAuthor() == authorSomebody);

		document1.setDocumentTitle(new FileTitle("test2"));
		assertTrue(document1.getDocumentTitle().getTitleString().equals("test2"));

		document1.setRegion(SignLocale.ASL);
		assertEquals(SignLocale.ASL, document1.getSignLocale());
		assertTrue(document1.isEmpty());
		assertEquals(0, document1.getSectionCount());

		document1.setPageFormat(PageFormat.A4_LANDSCAPE);
		assertEquals(PageFormat.A4_LANDSCAPE, document1.getPageFormat());

		LocalDictionary localDictionary = new LocalDictionary();
		document1.setLocalDictionary(localDictionary);
		assertEquals(localDictionary, document1.getLocalDictionary());

		document1.setUnderlinesVisible(false);
		assertFalse(document1.areUnderlinesVisible());

		document1.addSection(new Section());
		document1.insertSection(new Section(), 1);

		Document document2 = new Document(authorSomebody, SignLocale.DGS, new FileTitle("testDocument"),
				PageFormat.A4_LANDSCAPE);
		document2.setDocumentTitle(new FileTitle("test2"));
		document2.setRegion(SignLocale.ASL);
		assertTrue(document2.isEmpty());

		document2.addSection(new Section());
		assertFalse(document1.equals(document2));

		document2.insertSection(new Section(), 1);
		assertEquals(document1, document2);
		assertTrue("Different hashcodes for " + document1 + "(" + document1.hashCode() + ") and " + document2 + "("
				+ document2.hashCode() + ")", document1.hashCode() == document2.hashCode());

		document1.removeSection(1);
		assertEquals(1, document1.getSectionCount());
		assertFalse(document1.equals(document2));
	}

	@Test
	public void testConstructor() {
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document1 = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		assertEquals(author, document1.getAuthor());
		assertEquals(SignLocale.DGS, document1.getSignLocale());
		assertEquals(new FileTitle(I18N.getNewDocument()), document1.getDocumentTitle());
		assertTrue(document1.isEmpty());
		assertEquals(0, document1.getSectionCount());
		assertTrue(document1.getPageFormat() == PageFormat.A4_PORTRAIT);
		assertTrue(document1.areUnderlinesVisible());

		Document document2 = new Document(author, SignLocale.DGS, new FileTitle("title"), PageFormat.A4_LANDSCAPE);
		assertEquals(author, document2.getAuthor());
		assertEquals(SignLocale.DGS, document2.getSignLocale());
		assertEquals("title", document2.getDocumentTitle().getTitleString());
		assertTrue(document2.isEmpty());
		assertEquals(0, document2.getSectionCount());
		assertTrue(document2.getPageFormat() == PageFormat.A4_LANDSCAPE);
		assertTrue(document2.areUnderlinesVisible());
	}

	@Test
	public void testSections() {
		Document document = createDummyDocument();
		assertTrue(document.isEmpty());

		Section section = new Section();
		document.addSection(section);

		assertFalse(document.isEmpty());
		assertEquals(1, document.getSectionCount());
		assertEquals(section, document.getSection(0));

		Section secondSection = new Section();
		document.insertSection(secondSection, 1);
		assertEquals(2, document.getSectionCount());
		assertEquals(section, document.getSection(0));
		assertEquals(secondSection, document.getSection(1));

		Section middleSection = new Section();
		document.insertSection(middleSection, 1);
		assertEquals(3, document.getSectionCount());
		assertEquals(section, document.getSection(0));
		assertEquals(middleSection, document.getSection(1));
		assertEquals(secondSection, document.getSection(2));

		document.removeSection(1);
		assertEquals(2, document.getSectionCount());
		assertEquals(section, document.getSection(0));
		assertEquals(secondSection, document.getSection(1));

		document.removeSection(0);
		document.removeSection(0);
		assertTrue(document.isEmpty());
	}

	@Test
	public void testInsertTokens() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.getSection(0).addParagraph(new Paragraph(idFactory.createId()));

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Id tokenId1 = token1.getId();
		assertFalse(document.containsToken(tokenId1));
		document.addToken(token1);
		assertTrue(document.containsToken(tokenId1));
		assertEquals(token1, document.getToken(tokenId1));

		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Id tokenId2 = token2.getId();
		assertFalse(document.containsToken(tokenId2));
		document.insertTokenAfter(tokenId1, token2);
		assertTrue(document.containsToken(tokenId2));
		assertEquals(token2, document.getSection(0).getParagraph(0).getToken(1));
		assertEquals(token2, document.getToken(tokenId2));

		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Id tokenId3 = token3.getId();
		assertFalse(document.containsToken(tokenId3));
		document.insertTokenAfter(tokenId1, token3);
		assertTrue(document.containsToken(tokenId3));
		assertEquals(token3, document.getSection(0).getParagraph(0).getToken(1));
		assertEquals(token3, document.getToken(tokenId3));

		SignItemToken tokenInParagraph2 = tokenFactory.createSignItemToken("token4",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		document.getSection(0).addParagraph(new Paragraph(idFactory.createId()));
		document.addToken(tokenInParagraph2);

		document.addSection(new Section());
		document.getSection(1).addParagraph(new Paragraph(idFactory.createId()));
		SignItemToken tokenInSection2 = tokenFactory.createSignItemToken("token5",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		document.addToken(tokenInSection2);
	}

	@Test
	public void testTokenCount() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Section section = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		document.addSection(section);
		section.addParagraph(paragraph);

		// Action
		document.addToken(token);

		// Check
		assertEquals(1, document.getTokenCount());
	}

	@Test
	public void testTokenCountForMultipleTokens() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token1 = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token3 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token4 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token5 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);

		Section section = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		document.addSection(section);
		section.addParagraph(paragraph);

		// Action
		document.addToken(token1);
		document.addToken(token2);
		document.addToken(token3);
		document.addToken(token4);
		document.addToken(token5);

		// Check
		assertEquals(5, document.getTokenCount());
	}

	@Test
	public void testTokenCountForMultipleTokensOnDifferentParagraphs() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token1 = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token3 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token4 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token5 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);

		Section section = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		Id paragraphId2 = idFactory.createId();
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		document.addSection(section);
		section.addParagraph(paragraph);
		section.addParagraph(paragraph2);

		// Action
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph2.addToken(token3);
		paragraph2.addToken(token4);
		paragraph2.addToken(token5);

		// Check
		assertEquals(5, document.getTokenCount());
	}

	@Test
	public void testTokenCountForMultipleTokensOnDifferentSections() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token1 = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token3 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token4 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token5 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);

		Section section = new Section();
		Section section2 = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		Id paragraphId2 = idFactory.createId();
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		document.addSection(section);
		document.addSection(section2);
		section.addParagraph(paragraph);
		section2.addParagraph(paragraph2);

		// Action
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph2.addToken(token3);
		paragraph2.addToken(token4);
		paragraph2.addToken(token5);

		// Check
		assertEquals(5, document.getTokenCount());
	}

	@Test
	public void testGetTokenCount_removeToken() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token1 = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token3 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token4 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token5 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);

		Section section = new Section();
		Section section2 = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		Id paragraphId2 = idFactory.createId();
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		document.addSection(section);
		document.addSection(section2);
		section.addParagraph(paragraph);
		section2.addParagraph(paragraph2);

		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph2.addToken(token3);
		paragraph2.addToken(token4);
		paragraph2.addToken(token5);

		// Action
		document.removeToken(token2.getId());

		// Check
		assertEquals(4, document.getTokenCount());
	}

	@Test
	public void testGetTokenCount_removeMultipleTokens() {
		// Prepare
		User author = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		Document document = new Document(author, SignLocale.DGS, new FileTitle(I18N.getNewDocument()),
				PageFormat.A4_PORTRAIT);
		SignItemToken token1 = tokenFactory.createSignItemToken("token",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token3 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token4 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);
		SignItemToken token5 = (SignItemToken) tokenFactory.createNewTokenFromToken(token1);

		Section section = new Section();
		Section section2 = new Section();
		Id paragraphId = idFactory.createId();
		Paragraph paragraph = new Paragraph(paragraphId);
		Id paragraphId2 = idFactory.createId();
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		document.addSection(section);
		document.addSection(section2);
		section.addParagraph(paragraph);
		section2.addParagraph(paragraph2);

		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph2.addToken(token3);
		paragraph2.addToken(token4);
		paragraph2.addToken(token5);

		// Action
		document.removeToken(token2.getId());
		document.removeToken(token3.getId());
		document.removeToken(token5.getId());

		// Check
		assertEquals(2, document.getTokenCount());
	}

	@Test
	public void testMergeSection() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.addSection(new Section());
		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		document.getSection(0).addParagraph(paragraph1);
		document.getSection(1).addParagraph(paragraph2);

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		paragraph2.addToken(token2);

		assertEquals(2, document.getSectionCount());

		document.mergeSectionWithNext(0);

		assertEquals(1, document.getSectionCount());
		assertEquals(2, document.getParagraphCount(0));
	}

	@Test
	public void testGetPreviousParagraphIndex() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.addSection(new Section());
		Id id1 = idFactory.createId();
		Id id2 = idFactory.createId();
		Id id3 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(id1);
		Paragraph paragraph2 = new Paragraph(id2);
		Paragraph paragraph3 = new Paragraph(id3);
		document.getSection(0).addParagraph(paragraph1);
		document.getSection(1).addParagraph(paragraph2);
		document.getSection(1).addParagraph(paragraph3);

		ParagraphIndex paragraphIndex1 = document.getParagraphIndex(id1);
		ParagraphIndex paragraphIndex2 = document.getParagraphIndex(id2);
		ParagraphIndex paragraphIndex3 = document.getParagraphIndex(id3);

		assertEquals(new ParagraphIndex(0, 0), paragraphIndex1);
		assertEquals(new ParagraphIndex(1, 0), paragraphIndex2);
		assertEquals(new ParagraphIndex(1, 1), paragraphIndex3);

		assertTrue(document.isFirstParagraphIndex(paragraphIndex1));
		assertFalse(document.isFirstParagraphIndex(paragraphIndex2));
		assertFalse(document.isFirstParagraphIndex(paragraphIndex3));

		assertEquals(paragraphIndex1, document.getPreviousParagraphIndex(paragraphIndex2));
		assertEquals(paragraphIndex2, document.getPreviousParagraphIndex(paragraphIndex3));
	}

	@Test
	public void testGetNextParagraphIndex() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.addSection(new Section());
		Id id1 = idFactory.createId();
		Id id2 = idFactory.createId();
		Id id3 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(id1);
		Paragraph paragraph2 = new Paragraph(id2);
		Paragraph paragraph3 = new Paragraph(id3);
		document.getSection(0).addParagraph(paragraph1);
		document.getSection(1).addParagraph(paragraph2);
		document.getSection(1).addParagraph(paragraph3);

		ParagraphIndex paragraphIndex1 = document.getParagraphIndex(id1);
		ParagraphIndex paragraphIndex2 = document.getParagraphIndex(id2);
		ParagraphIndex paragraphIndex3 = document.getParagraphIndex(id3);

		assertEquals(new ParagraphIndex(0, 0), paragraphIndex1);
		assertEquals(new ParagraphIndex(1, 0), paragraphIndex2);
		assertEquals(new ParagraphIndex(1, 1), paragraphIndex3);

		assertFalse(document.isLastParagraphIndex(paragraphIndex1));
		assertFalse(document.isLastParagraphIndex(paragraphIndex2));
		assertTrue(document.isLastParagraphIndex(paragraphIndex3));

		assertEquals(paragraphIndex2, document.getNextParagraphIndex(paragraphIndex1));
		assertEquals(paragraphIndex3, document.getNextParagraphIndex(paragraphIndex2));
	}

	@Test
	public void testGetNextDocumentIndex() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.addSection(new Section());
		Id paragraphId1 = idFactory.createId();
		Id paragraphId2 = idFactory.createId();
		Id paragraphId3 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(paragraphId1);
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		Paragraph paragraph3 = new Paragraph(paragraphId3);
		document.getSection(0).addParagraph(paragraph1);
		document.getSection(1).addParagraph(paragraph2);
		document.getSection(1).addParagraph(paragraph3);
		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token4 = tokenFactory.createSignItemToken("token4",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		paragraph2.addToken(token2);
		paragraph3.addToken(token3);
		paragraph3.addToken(token4);

		DocumentIndex documentIndex1 = document.getDocumentIndex(token1.getId());
		DocumentIndex documentIndex2 = document.getDocumentIndex(token2.getId());
		DocumentIndex documentIndex3 = document.getDocumentIndex(token3.getId());
		DocumentIndex documentIndex4 = document.getDocumentIndex(token4.getId());

		assertEquals(new DocumentIndex(0, 0, 0), documentIndex1);
		assertEquals(new DocumentIndex(1, 0, 0), documentIndex2);
		assertEquals(new DocumentIndex(1, 1, 0), documentIndex3);
		assertEquals(new DocumentIndex(1, 1, 1), documentIndex4);

		assertFalse(document.isLastDocumentIndex(documentIndex1));
		assertFalse(document.isLastDocumentIndex(documentIndex2));
		assertFalse(document.isLastDocumentIndex(documentIndex3));
		assertTrue(document.isLastDocumentIndex(documentIndex4));

		assertEquals(documentIndex2, document.getNextDocumentIndex(documentIndex1));
		assertEquals(documentIndex3, document.getNextDocumentIndex(documentIndex2));
		assertEquals(documentIndex4, document.getNextDocumentIndex(documentIndex3));
	}

	@Test
	public void testGetPreviousDocumentIndex() {
		Document document = createDummyDocument();
		document.addSection(new Section());
		document.addSection(new Section());
		Id paragraphId1 = idFactory.createId();
		Id paragraphId2 = idFactory.createId();
		Id paragraphId3 = idFactory.createId();
		Paragraph paragraph1 = new Paragraph(paragraphId1);
		Paragraph paragraph2 = new Paragraph(paragraphId2);
		Paragraph paragraph3 = new Paragraph(paragraphId3);
		document.getSection(0).addParagraph(paragraph1);
		document.getSection(1).addParagraph(paragraph2);
		document.getSection(1).addParagraph(paragraph3);
		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token4 = tokenFactory.createSignItemToken("token4",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		paragraph2.addToken(token2);
		paragraph3.addToken(token3);
		paragraph3.addToken(token4);

		DocumentIndex documentIndex1 = document.getDocumentIndex(token1.getId());
		DocumentIndex documentIndex2 = document.getDocumentIndex(token2.getId());
		DocumentIndex documentIndex3 = document.getDocumentIndex(token3.getId());
		DocumentIndex documentIndex4 = document.getDocumentIndex(token4.getId());

		assertEquals(new DocumentIndex(0, 0, 0), documentIndex1);
		assertEquals(new DocumentIndex(1, 0, 0), documentIndex2);
		assertEquals(new DocumentIndex(1, 1, 0), documentIndex3);
		assertEquals(new DocumentIndex(1, 1, 1), documentIndex4);

		assertTrue(document.isFirstDocumentIndex(documentIndex1));
		assertFalse(document.isFirstDocumentIndex(documentIndex2));
		assertFalse(document.isFirstDocumentIndex(documentIndex3));
		assertFalse(document.isFirstDocumentIndex(documentIndex4));

		assertEquals(documentIndex1, document.getPreviousDocumentIndex(documentIndex2));
		assertEquals(documentIndex2, document.getPreviousDocumentIndex(documentIndex3));
		assertEquals(documentIndex3, document.getPreviousDocumentIndex(documentIndex4));
	}

	@Test
	public void testGetTokensFromToInOneParagraph() {
		Document document = createDummyDocument();

		Paragraph paragraph = new Paragraph(idFactory.createId());
		Section section = new Section();

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph.addToken(token3);

		section.addParagraph(paragraph);

		document.addSection(section);

		// Action
		List<Token> foundTokens = document.getTokensFromTo(token1.getId(), token3.getId());

		// Test
		assertEquals(3, foundTokens.size());
		assertEquals(token1, foundTokens.get(0));
		assertEquals(token2, foundTokens.get(1));
		assertEquals(token3, foundTokens.get(2));
	}

	@Test
	public void testGetTokensFromToInOneParagraphInreversedOrder() {
		Document document = createDummyDocument();

		Paragraph paragraph = new Paragraph(idFactory.createId());
		Section section = new Section();

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph.addToken(token3);

		section.addParagraph(paragraph);

		document.addSection(section);

		// Action
		List<Token> foundTokens = document.getTokensFromTo(token3.getId(), token1.getId());

		// Test
		assertEquals(3, foundTokens.size());
		assertEquals(token1, foundTokens.get(0));
		assertEquals(token2, foundTokens.get(1));
		assertEquals(token3, foundTokens.get(2));
	}

	@Test
	public void testGetTokensFromToOverMultipleParagraphs() {
		Document document = createDummyDocument();

		Section section = new Section();

		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		paragraph1.addToken(token1);
		paragraph1.addToken(token2);

		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph2.addToken(token3);

		section.addParagraph(paragraph1);
		section.addParagraph(paragraph2);

		document.addSection(section);

		// Action
		List<Token> foundTokens = document.getTokensFromTo(token3.getId(), token1.getId());

		// Test
		assertEquals(3, foundTokens.size());
		assertEquals(token1, foundTokens.get(0));
		assertEquals(token2, foundTokens.get(1));
		assertEquals(token3, foundTokens.get(2));

	}

	@Test
	public void testGetTokensFromToOverMultipleSections() {
		Document document = createDummyDocument();

		Section section1 = new Section();
		Section section2 = new Section();

		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		paragraph1.addToken(token2);

		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph2.addToken(token3);

		section1.addParagraph(paragraph1);
		section2.addParagraph(paragraph2);

		document.addSection(section1);
		document.addSection(section2);

		// Action
		List<Token> foundTokens = document.getTokensFromTo(token3.getId(), token1.getId());

		// Test
		assertEquals(3, foundTokens.size());
		assertEquals(token1, foundTokens.get(0));
		assertEquals(token2, foundTokens.get(1));
		assertEquals(token3, foundTokens.get(2));

	}

	private Document createDummyDocument() {
		Document document = new Document(
				new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1), SignLocale.DGS,
				new FileTitle(I18N.getNewDocument()), PageFormat.A4_PORTRAIT);
		return document;
	}

}
