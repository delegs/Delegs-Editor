package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.GWTClient.infrastructure.CollageDocumentLayouterMock;
import de.signWritingEditor.client.GWTClient.infrastructure.FindSignDictionaryServiceAsyncMock;
import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.GWTClient.infrastructure.MiniDocumentEditorMock;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.FontSizeServiceMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.UnitTestCase;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;

public class DocumentEditorTest extends UnitTestCase {

	private CollageDocumentLayouterMock documentLayouter;
	private FindSignDictionaryServiceAsyncMock dictionaryService;
	private IdFactory idFactory;
	private MiniDocumentEditorMock documentEditor;
	private TokenFactory tokenFactory;
	private String comment;
	private Document dummyDocument;
	private RoomItem dummyRootRoom;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private TextbasedTokenStyleTool textbasedTokenStyleTool;

	@Before
	public void setUp() throws Exception {
		dictionaryService = new FindSignDictionaryServiceAsyncMock();
		idFactory = new IdFactory(10);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);
		comment = "test";
		dummyDocument = createDummyDocument();
		documentLayouter = new CollageDocumentLayouterMock(dummyDocument);
		textbasedTokenStyleTool = new TextbasedTokenStyleTool(documentLayouter);

		DocumentServiceAsync documentService = new DocumentServiceAsyncMock(idFactory);
		PdfServiceAsync pdfService = new PdfServiceAsyncMock();

		dummyRootRoom = createDummyRoot();
		FontSizeService fontSizeService = new FontSizeServiceMock();
		documentEditor = new MiniDocumentEditorMock(dictionaryService, documentService, pdfService,
				new VideoServiceAsyncMock(), new MediaUrlServiceAsyncMock(), new BrowserHistoryServiceMock(),
				fontSizeService, new BadgeServiceMock(), idFactory, textbasedTokenStyleFactory,
				new LocalSessionServiceForUnknownUserMock(), dummyRootRoom, SignLocale.DGS,
				new DocumentEditorListenerMock());
		documentEditor.setGwtDocumentLayouter(documentLayouter);
	}

	@Test
	public void testIsDocumentNeverSaved() {
		assertTrue(documentEditor.isDocumentNeverSaved());
		documentEditor.setDocumentItem(createDummyDocumentItem());
		assertFalse(documentEditor.isDocumentNeverSaved());
	}

	@Test
	public void testSetDocumentTitle() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		FileTitle fileTitle = new FileTitle("Krieg und Frieden");
		documentEditor.setDocumentTitle(fileTitle);

		assertEquals("Krieg und Frieden", documentEditor.getFooterText());
		assertEquals(new FileTitle("Krieg und Frieden"), documentEditor.getDocument().getDocumentTitle());
	}

	@Test
	public void testUpdateModifiedSign() {

		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		SimpleSign sign = new SimpleSign(
				new SignId(1234567, "Test", dummyDocument.getSignLocale(),
						SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS),
				dummyDocument.getAuthor(), dummyDocument.getSignLocale(), new Date(), comment);

		LocalDictionary localDictionary = dummyDocument.getLocalDictionary();
		assertFalse(localDictionary.contains(sign.getSignId()));

		documentEditor.updateLocallyModifiedSign(sign, dummyDocument.getToken(0, 0, 0).getId());
		assertTrue(localDictionary.contains(sign.getSignId()));
	}

	@Test
	public void testToggleUnderlineVisibility() {
		dummyDocument.setUnderlinesVisible(false);
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		assertFalse(documentEditor.getDocument().areUnderlinesVisible());
		assertFalse(documentEditor.isUnderlineVisible());

		documentEditor.toggleUnderlineVisibility();
		assertTrue(documentEditor.getDocument().areUnderlinesVisible());
		assertTrue(documentEditor.isUnderlineVisible());

		documentEditor.toggleUnderlineVisibility();
		assertFalse(documentEditor.getDocument().areUnderlinesVisible());
		assertFalse(documentEditor.isUnderlineVisible());
	}

	@Test
	public void testOpenDocument() {
		documentEditor.setFooterText("falsch");
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		assertEquals("Erstes Dokument", documentEditor.getFooterText());
		assertFalse("falsch".equals(documentEditor.getFooterText()));

		assertEquals(new PageFormat("Hochkant", Orientation.HORIZONTAL, 72, 300, 200, 1, 1, 1, 1).getName(),
				documentLayouter.getPageFormat().getName());

		Token token = dummyDocument.getToken(0, 0, 0);
		assertNotNull(token);
		assertEquals(SignItemToken.class, token.getClass());
		SignItemToken signItemToken = (SignItemToken) token;
		assertEquals(token.getId(), documentLayouter.getNewTokenId());
		assertEquals(signItemToken.getText(), documentLayouter.getAddTokenWord());
		assertEquals(dummyDocument.getSection(0).getParagraph(0).isSearchWordLineVisible(),
				documentLayouter.isSearchWordVisible());

		assertTrue(signItemToken.getText().equalsIgnoreCase(dictionaryService.getDictionaryWord()));

		dummyDocument.addToken(tokenFactory.createSignItemToken("Token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		Section section2 = new Section();
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		paragraph2.addToken(tokenFactory.createSignItemToken("Token1 in Para2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(tokenFactory.createSignItemToken("Token2 in Para2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph2.addToken(tokenFactory.createSignItemToken("Token3 in Para2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph3 = new Paragraph(idFactory.createId());
		paragraph3.addToken(tokenFactory.createSignItemToken("Token1 in Para3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(tokenFactory.createSignItemToken("Token2 in Para3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		paragraph3.addToken(tokenFactory.createSignItemToken("Token3 in Para3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		section2.addParagraph(paragraph2);
		section2.addParagraph(paragraph3);
		dummyDocument.addSection(section2);
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
	}

	@Test
	public void testOpenNewDocument() {
		documentEditor.createNewDocument(new FileTitle("Test Dokument"),
				new PageFormat("Hochkant", Orientation.HORIZONTAL, 72, 300, 200, 1, 1, 1, 1), SignLocale.DGS,
				dummyRootRoom, dummyRootRoom);
		assertEquals("Test Dokument", documentEditor.getDocument().getDocumentTitle().getTitleString());
	}

	@Test
	public void testOnTextChangedForBreaks() {
		// Prepare
		dummyDocument.setAutomaticFreeTextLineEnabled(false);
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		int sectionCountBefore = dummyDocument.getSectionCount();
		int paragraphCountBefore = dummyDocument.getParagraphCount(0);
		int tokenCountBefore = dummyDocument.getTokenCount(0, 0);

		// Action
		documentEditor.handleTextChanged(dummyDocument.getToken(0, 0, 0).getId(),
				"tral llala \n guo gugu \n bla bla bal \n bla \f tralala", 0);

		// Check
		assertTrue(sectionCountBefore < dummyDocument.getSectionCount());
		assertTrue(paragraphCountBefore < dummyDocument.getParagraphCount(0));
		assertTrue(tokenCountBefore < dummyDocument.getTokenCount(0, 0));

		assertEquals(sectionCountBefore + 1, dummyDocument.getSectionCount());
		assertEquals(paragraphCountBefore + 3, dummyDocument.getParagraphCount(0));
		assertEquals(tokenCountBefore + 1, dummyDocument.getTokenCount(0, 0));
	}

	@Test
	public void testOnTextChanged() {
		// Prepare
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		SignItemToken signItemToken = (SignItemToken) dummyDocument.getToken(0, 0, 0);
		assertNotNull(signItemToken);
		String newText = "NEU";
		assertNotEquals(newText, signItemToken.getText());

		// Action
		documentEditor.handleTextChanged(signItemToken.getId(), newText, 0);

		// Check
		assertEquals(newText, signItemToken.getText());
	}

	@Test
	public void testOnFreeTextChanged() {
		// Prepare
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		FreeTextToken freeTextToken = (FreeTextToken) tokenFactory
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		dummyDocument.addToken(freeTextToken);
		assertEquals("", freeTextToken.getText());
		Id targetTokenId = freeTextToken.getId();

		String newText = "tral llala \n guo gugu \n bla bla bal \n bla \f tralala";

		// Action
		documentEditor.handleFreeTextChanged(targetTokenId, newText, 0);

		// Check
		assertEquals(newText, freeTextToken.getText());
	}

	@Test
	public void testEditLockedContentSignItemToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		SignItemToken signItemToken = new SignItemToken("Igel", idFactory.createId(),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		signItemToken.lockContent(true);
		dummyDocument.addToken(signItemToken);
		assertEquals("Igel", signItemToken.getText());
		String newText = "Hund";

		// Action
		signItemToken.setText(newText);

		// Check
		assertEquals("Igel", signItemToken.getText());
	}

	@Test
	public void testEditLockedLayoutSignItemToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		SignItemToken signItemToken = new SignItemToken("Igel", idFactory.createId(),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		signItemToken.lockLayout(true);
		dummyDocument.addToken(signItemToken);
		assertEquals("Igel", signItemToken.getText());
		String newText = "Hund";

		// Action
		signItemToken.setText(newText);

		// Check
		assertEquals(newText, signItemToken.getText());
	}

	@Test
	public void testEditLockedContentFreeTextToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		FreeTextToken freeTextToken = new FreeTextToken(idFactory.createId(), "Hallo Igel",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), false, true);
		dummyDocument.addToken(freeTextToken);
		assertEquals("Hallo Igel", freeTextToken.getText());
		Id targetTokenId = freeTextToken.getId();

		String newText = "tral llala \n guo gugu \n bla bla bal \n bla \f tralala";

		// Action
		documentEditor.handleFreeTextChanged(targetTokenId, newText, 0);

		// Check
		assertEquals("Hallo Igel", freeTextToken.getText());
	}

	@Test
	public void testEditLockedLayoutFreeTextToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		FreeTextToken freeTextToken = new FreeTextToken(idFactory.createId(), "Hallo Igel",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), true, false);
		dummyDocument.addToken(freeTextToken);
		assertEquals("Hallo Igel", freeTextToken.getText());
		Id targetTokenId = freeTextToken.getId();

		String newText = "tral llala \n guo gugu \n bla bla bal \n bla \f tralala";

		// Action
		documentEditor.handleFreeTextChanged(targetTokenId, newText, 0);

		// Check
		assertEquals(newText, freeTextToken.getText());
	}

	@Test
	public void testEditLockedContentVideoToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		VideoToken videoToken = new VideoToken(idFactory.createId(), false, true);

		dummyDocument.addToken(videoToken);
		assertEquals("", videoToken.getUrl());

		// Action
		documentEditor.handleUpdateVideoSource(videoToken.getId(),
				"https://media.spreadthesign.com/video/mp4/9/9794.mp4");

		// Check
		assertEquals("", videoToken.getUrl());
	}

	@Test
	public void testEditLockedLayoutVideoToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		VideoToken videoToken = new VideoToken(idFactory.createId(), true, false);

		dummyDocument.addToken(videoToken);
		assertEquals("", videoToken.getUrl());

		// Action
		documentEditor.handleUpdateVideoSource(videoToken.getId(),
				"https://media.spreadthesign.com/video/mp4/9/9794.mp4");

		// Check
		assertEquals("https://media.spreadthesign.com/video/mp4/9/9794.mp4", videoToken.getUrl());
	}

	@Test
	public void testEditLockedContentImageToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		ImageToken imageToken = new ImageToken(idFactory.createId(), false, true);

		dummyDocument.addToken(imageToken);
		assertEquals("", imageToken.getUrl());

		// Action
		documentEditor.handleImageUrlChanged(imageToken.getId(),
				"https://cdn.collider.com/wp-content/uploads/2019/11/baby-yoda-concept-art.jpg");

		// Check
		assertEquals("", imageToken.getUrl());
	}

	@Test
	public void testEditLockedLayoutImageToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		ImageToken imageToken = new ImageToken(idFactory.createId(), true, false);

		dummyDocument.addToken(imageToken);
		assertEquals("", imageToken.getUrl());

		// Action
		documentEditor.handleImageUrlChanged(imageToken.getId(),
				"https://cdn.collider.com/wp-content/uploads/2019/11/baby-yoda-concept-art.jpg");

		// Check
		assertEquals("https://cdn.collider.com/wp-content/uploads/2019/11/baby-yoda-concept-art.jpg",
				imageToken.getUrl());
	}

	@Test
	public void testDeleteLockedContentFreeTextToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		FreeTextToken freeTextToken = new FreeTextToken(idFactory.createId(), "",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), false, true);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(freeTextToken);
		assertEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedLayoutFreeTextToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		FreeTextToken freeTextToken = new FreeTextToken(idFactory.createId(), "",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), true, false);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(freeTextToken);
		assertEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) freeTextToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedLayoutSignItemToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		SignItemToken signItemToken = new SignItemToken("Igel", idFactory.createId(),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		signItemToken.lockLayout(true);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) signItemToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(signItemToken);
		assertEquals((Token) signItemToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) signItemToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedLayoutVideoToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		VideoToken videoToken = new VideoToken(idFactory.createId(), true, false);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(videoToken);
		assertEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedContentVideoToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		VideoToken videoToken = new VideoToken(idFactory.createId(), false, true);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(videoToken);
		assertEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) videoToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedLayoutImageToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		ImageToken imageToken = new ImageToken(idFactory.createId(), true, false);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(imageToken);
		assertEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testDeleteLockedContentImageToken() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		ImageToken imageToken = new ImageToken(idFactory.createId(), true, false);
		Token lastTokenBeforeAdd = dummyDocument.getLastTokenInDocument();
		assertNotEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());
		dummyDocument.addToken(imageToken);
		assertEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());

		// Action
		documentEditor.handleDeleteNext(lastTokenBeforeAdd.getId());

		// Check
		assertEquals((Token) imageToken, dummyDocument.getLastTokenInDocument());
	}

	@Test
	public void testOnTextChangedWithFreeText() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());
		int sectionCountBefore = dummyDocument.getSectionCount();
		int paragraphCountBefore = dummyDocument.getParagraphCount(0);
		int tokenCountBefore = dummyDocument.getTokenCount(0, 0);

		documentEditor.handleTextChanged(dummyDocument.getToken(0, 0, 0).getId(),
				"tral llala \n guo gugu \n bla bla bal \n bla \f tralala", 0);

		assertTrue(sectionCountBefore < dummyDocument.getSectionCount());
		assertTrue(paragraphCountBefore < dummyDocument.getParagraphCount(0));
		assertTrue(tokenCountBefore < dummyDocument.getTokenCount(0, 0));

		assertEquals(sectionCountBefore + 1, dummyDocument.getSectionCount());
		assertEquals(paragraphCountBefore + 3, dummyDocument.getParagraphCount(0));
		assertEquals(tokenCountBefore + 2, dummyDocument.getTokenCount(0, 0));
	}

	@Test
	public void testOnCopy() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		dummyDocument.addToken(tokenFactory.createSignItemToken("bla",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		documentEditor.handleMoveCursorToLineEnd(dummyDocument.getToken(0, 0, 0).getId(), true);

		assertFalse("Hallo".equals(documentEditor.getOnCopyEventText()));
		documentEditor.handleCopy();
		assertEquals("Hallo", documentEditor.getOnCopyEventText());
	}

	@Test
	public void testOnCutEvent() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		dummyDocument.addToken(tokenFactory.createSignItemToken("bla",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		Token token = dummyDocument.getToken(0, 0, 0);
		assertNotNull(token);
		assertEquals(SignItemToken.class, token.getClass());
		SignItemToken signItemToken = (SignItemToken) token;
		assertNotEquals("", signItemToken.getText());
		documentEditor.handleMoveCursorToLineEnd(token.getId(), true);
		assertFalse("Hallo".equals(documentEditor.getOnCopyEventText()));

		documentEditor.handleCut();
		assertEquals("Hallo", documentEditor.getOnCopyEventText());

		assertEquals("", signItemToken.getText());
	}

	@Test
	public void testOnDeletePrevious() {
		documentEditor.openDocument(dummyDocument, null, createDummyFolderItem(), createDummyRoomItem());

		SignItemToken token = tokenFactory.createSignItemToken("bla",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		dummyDocument.addToken(token);

		assertEquals(dummyDocument.getToken(0, 0, 1), token);
		assertEquals(2, dummyDocument.getTokenCount(0, 0));

		documentEditor.handleDeletePrevious(token.getId());
		assertEquals(1, dummyDocument.getTokenCount(0, 0));

		assertTrue(documentLayouter.isRemoveTokenBoxesCalled());
	}

	@Test
	public void testDocumentChangeAndUndo() {
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		assertFalse(documentEditor.isDocumentNeverSaved());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Edit document
		dummyDocument.addToken(tokenFactory.createSignItemToken("test",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		assertTrue(documentEditor.hasUnsavedChanges());

		// Delete token to get the "old" document
		SignItemToken token = (SignItemToken) dummyDocument.getToken(0, 0, 1);
		documentEditor.handleTextChanged(token.getId(), "", 0);
		documentEditor.handleDeletePrevious(token.getId());

		assertFalse(documentEditor.hasUnsavedChanges());
	}

	@Test
	public void testDocumentChangeAndSave() {
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		assertFalse(documentEditor.isDocumentNeverSaved());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Edit document
		dummyDocument.addToken(tokenFactory.createSignItemToken("test",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		long hashCodeOld = dummyDocument.contentHashCode();

		assertTrue(documentEditor.hasUnsavedChanges());

		// Save document
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());

		assertFalse(documentEditor.hasUnsavedChanges());
		assertEquals(documentEditor.getSavedDocumentVersionHash(), hashCodeOld);
	}

	@Test
	public void testOpenDocument_noTokensInserted_oneTokenInDocument() {
		// Prepare, Action
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		// Check
		assertEquals(1, documentEditor.getDocument().getTokenCount());
	}

	@Test
	public void testAddSnippetToDocument() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		// Action
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		// Checks
		assertEquals(2, dummyDocument.getSectionCount());

		assertFalse(dummyDocument.getSection(0).isCollage());
		assertTrue(dummyDocument.getSection(1).isCollage());
	}

	@Test
	public void testDeleteCollageToDocument() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		setPageCountForDocumentLayouterMock(2);
		documentEditor.handleAddSnippetToDocument(dummyDocument.getSection(1).getCollageId(), 10, 10, 130, true);
		documentEditor.handleToggleSnippetSelection(dummyDocument.getParagraph(1, 0).getParagraphId(), false);

		// Action
		documentEditor.handleDeleteSnippet();

		// Checks
		assertEquals(1, dummyDocument.getSectionCount());
		assertFalse(dummyDocument.getSection(0).isCollage());
	}

	@Test
	public void testAddSnippetToPage() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		// Action
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		// Check
		assertTrue(dummyDocument.getSection(sectionIndex).isCollage());
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);
		assertEquals(11, paragraph.getPositionX());
		assertEquals(12, paragraph.getPositionY());
		assertEquals(100, paragraph.getWidth());
		assertEquals(2, paragraph.getTokenCount());
		assertFalse(paragraph.isAutomaticResize());
	}

	@Test
	public void testZIndexForSnippetsToPage() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		// Action
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		// Check
		assertTrue(dummyDocument.getSection(sectionIndex).isCollage());
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);
		assertEquals(1, paragraph.getZIndex());
		paragraph = dummyDocument.getParagraph(sectionIndex, 1);
		assertEquals(2, paragraph.getZIndex());
		paragraph = dummyDocument.getParagraph(sectionIndex, 2);
		assertEquals(3, paragraph.getZIndex());
	}

	@Test
	public void testSendToFrontSelectedSnippets() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 10, 10, 100, false);
		documentEditor.handleAddSnippetToDocument(collageId, 20, 20, 100, false);
		documentEditor.handleAddSnippetToDocument(collageId, 30, 30, 100, false);

		// Action
		documentEditor.handleSelectSnippetsFromTo(collageId, 9, 9, 2, 2, false);
		documentEditor.handleSendParagraphToFront();

		// Check
		assertTrue(dummyDocument.getSection(sectionIndex).isCollage());
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);
		assertEquals(2, paragraph.getZIndex());
		paragraph = dummyDocument.getParagraph(sectionIndex, 1);
		assertEquals(0, paragraph.getZIndex());
		paragraph = dummyDocument.getParagraph(sectionIndex, 2);
		assertEquals(1, paragraph.getZIndex());
	}

	@Test
	public void testSendToBackSelectedSnippets() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		documentEditor.insertCollage();
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		assertTrue(dummyDocument.getSection(lastSectionIndex).isCollage());
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 10, 10, 100, 1);
		paragraph1.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 20, 20, 100, 2);
		paragraph2.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph3 = new Paragraph(idFactory.createId(), 30, 30, 100, 3);
		paragraph3.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph3);

		// Action
		documentEditor.handleToggleSnippetSelection(paragraph2.getParagraphId(), false);
		documentEditor.handleSendParagraphToBack();

		// Check
		assertEquals(0, paragraph2.getZIndex());
		assertEquals(1, paragraph1.getZIndex());
		assertEquals(2, paragraph3.getZIndex());
	}

	@Test
	public void testAddTokenToSnippet() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);

		// Action
		SignItemToken newToken = tokenFactory.createSignItemToken("a",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		List<Token> tokensToInsert = new ArrayList<Token>();
		tokensToInsert.add(newToken);
		documentEditor.insertTokensAfter(paragraph.getToken(0).getId(), tokensToInsert);

		// Check
		assertTrue(paragraph.getToken(1) instanceof SignItemToken);
		SignItemToken insertedToken = (SignItemToken) paragraph.getToken(1);
		assertEquals("a", insertedToken.getText());
	}

	@Test
	public void testAddFreeTextTokenToSnippet() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);

		// Action
		Token newToken = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		((FreeTextToken) newToken).setText("freeText");
		List<Token> tokensToInsert = new ArrayList<Token>();
		tokensToInsert.add(newToken);
		documentEditor.insertTokensAfter(paragraph.getToken(0).getId(), tokensToInsert);

		// Check
		assertTrue(paragraph.getToken(1) instanceof FreeTextToken);
		FreeTextToken insertedToken = (FreeTextToken) paragraph.getToken(1);
		assertEquals("freeText", insertedToken.getText());
	}

	@Test
	public void testAddFrameTokenToSnippet() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		setPageCountForDocumentLayouterMock(2);
		int sectionIndex = dummyDocument.getSectionCount() - 1;
		Id collageId = dummyDocument.getSection(sectionIndex).getCollageId();
		documentEditor.handleAddSnippetToDocument(collageId, 11, 12, 100, false);
		Paragraph paragraph = dummyDocument.getParagraph(sectionIndex, 0);

		// Action
		Token newToken = tokenFactory.createFrameToken();
		List<Token> tokensToInsert = new ArrayList<Token>();
		tokensToInsert.add(newToken);
		documentEditor.insertTokensAfter(paragraph.getToken(0).getId(), tokensToInsert);

		// Check
		assertTrue(paragraph.getToken(1) instanceof FrameToken);
	}

	@Test
	public void testHasUnsavedChangesForChangedFontColor() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Token token = dummyDocument.getFirstTokenInDocument();
		assertTrue(token instanceof TextbasedToken);
		textbasedTokenStyleTool.changeFontColorTo(Color.WHITE, ((TextbasedToken) token));
		// Check
		assertTrue(documentEditor.hasUnsavedChanges());
	}

	@Test
	public void testHasUnsavedChangesForChangedTextBackgroundColor() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Token token = dummyDocument.getFirstTokenInDocument();
		assertTrue(token instanceof TextbasedToken);
		textbasedTokenStyleTool.changeTextBackgroundColorTo(Color.WHITE, ((TextbasedToken) token));
		// Check
		assertTrue(documentEditor.hasUnsavedChanges());
	}

	@Test
	public void testHasUnsavedChangesForChangedBackgroundColor() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Token token = dummyDocument.getFirstTokenInDocument();
		token.setBackgroundColor(Color.BLACK);
		// Check
		assertTrue(documentEditor.hasUnsavedChanges());
	}

	@Test
	public void testHasUnsavedChangesForTagToken() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Ich");
		itemList.add("will");
		itemList.add("Erdnüsse");
		TagToken tagToken = new TagToken(idFactory.createId(),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), true, false, itemList,
				new ArrayList<String>(), "Patricks Spruch");
		dummyDocument.addToken(tagToken);
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Action
		tagToken.selectWord("Ich");

		// Check
		assertTrue(documentEditor.hasUnsavedChanges());

		// Prepare
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Action
		tagToken.deselectWord("Ich");

		// Check
		assertTrue(documentEditor.hasUnsavedChanges());

		// Prepare
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Action
		tagToken.setDescription("Ist Mayonaise auch ein Instrument?");

		// Check
		assertTrue(documentEditor.hasUnsavedChanges());

		// Prepare
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Action
		tagToken.setWidth(999);

		// Check
		assertTrue(documentEditor.hasUnsavedChanges());

		// Prepare
		documentEditor.setSavedDocumentVersionHash(dummyDocument.contentHashCode());
		assertFalse(documentEditor.hasUnsavedChanges());

		// Action
		tagToken.lockContent(true);

		// Check
		assertTrue(documentEditor.hasUnsavedChanges());

	}

	@Test
	public void testSendParagraphToFrontForParagraphSelection() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Id collageId = idFactory.createId();
		dummyDocument.getSection(0).setIsCollage(true, collageId);
		Paragraph paragraph = dummyDocument.getParagraph(0, 0);
		paragraph.setZIndex(0);
		paragraph.setPositionX(0);
		paragraph.setPositionY(0);

		// Action
		documentEditor.handleSelectSnippetsFromTo(collageId, 0, 0, 1000, 1000, false);
		documentEditor.handleSendParagraphToFront();

		// Check
		assertEquals(0, paragraph.getZIndex());
	}

	@Test
	public void testSendParagraphToFrontForTokenSelection() {
		// Prepare
		Token secondToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		paragraph2.setZIndex(0);
		paragraph2.addToken(secondToken);
		dummyDocument.getSection(0).addParagraph(paragraph2);

		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Paragraph paragraph = dummyDocument.getParagraph(0, 0);
		paragraph.setZIndex(0);
		Token token = dummyDocument.getToken(0, 0, 0);

		setFieldValue(documentEditor, DocumentEditor.class, "currentCursorTokenId", token.getId());
		setFieldValue(documentEditor, DocumentEditor.class, "firstSelectedTokenId", secondToken.getId());

		// Action
		documentEditor.handleSendParagraphToFront();
		// Check
		assertEquals(1, paragraph.getZIndex());
	}

	@Test
	public void testSendParagraphToFrontForCursorInToken() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		Paragraph paragraph = dummyDocument.getParagraph(0, 0);
		paragraph.setZIndex(0);
		Token token = dummyDocument.getToken(0, 0, 0);
		documentEditor.setCursorPositionInUi(token.getId(), 0);
		// Action
		documentEditor.handleSendParagraphToFront();
		// Check
		assertEquals(1, paragraph.getZIndex());
	}

	@Test
	public void testSendParagraphToBackForParagraphSelection() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 100, 0, 0, 1);
		paragraph1.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 100, 300, 300, 2);
		paragraph2.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);

		// Action
		documentEditor.handleToggleSnippetSelection(paragraph2.getParagraphId(), false);
		documentEditor.handleSendParagraphToBack();

		// Check
		assertEquals(0, paragraph2.getZIndex());
		assertEquals(1, paragraph1.getZIndex());
	}

	@Test
	public void testSendParagraphToBackAlreadyInBackground() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 100, 0, 0, 1);
		paragraph1.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 100, 300, 300, 2);
		paragraph2.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);

		// Action
		documentEditor.handleToggleSnippetSelection(paragraph1.getParagraphId(), false);
		documentEditor.handleSendParagraphToBack();

		// Check
		assertEquals(0, paragraph1.getZIndex());
		assertEquals(1, paragraph2.getZIndex());
	}

	@Test
	public void testSendParagraphToBackForMultipleParagraphs() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 100, 0, 0, 1);
		paragraph1.addToken(tokenFactory.createSignItemToken("1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 100, 300, 300, 2);
		paragraph2.addToken(tokenFactory.createSignItemToken("2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph3 = new Paragraph(idFactory.createId(), 100, 400, 400, 3);
		paragraph3.addToken(tokenFactory.createSignItemToken("3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph3);

		// Action
		documentEditor.handleToggleSnippetSelection(paragraph2.getParagraphId(), false);
		documentEditor.handleToggleSnippetSelection(paragraph3.getParagraphId(), true);
		documentEditor.handleSendParagraphToBack();

		// Check
		assertEquals(0, paragraph2.getZIndex());
		assertEquals(1, paragraph3.getZIndex());
		assertEquals(2, paragraph1.getZIndex());
	}

	@Test
	public void testSendParagraphToBackForTokenSelection() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 100, 0, 0, 1);
		paragraph1.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 100, 300, 300, 2);
		SignItemToken firstSelectedToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph2.addToken(firstSelectedToken);
		SignItemToken currentCursorToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph2.addToken(currentCursorToken);
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);

		setFieldValue(documentEditor, DocumentEditor.class, "currentCursorTokenId", currentCursorToken.getId());
		setFieldValue(documentEditor, DocumentEditor.class, "firstSelectedTokenId", firstSelectedToken.getId());

		// Action
		documentEditor.handleSendParagraphToBack();

		// Check
		assertEquals(1, paragraph2.getZIndex());
		assertEquals(2, paragraph1.getZIndex());
	}

	@Test
	public void testSendParagraphToBackForCursorInToken() {
		// Prepare
		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());
		documentEditor.insertCollage();
		Paragraph paragraph1 = new Paragraph(idFactory.createId(), 100, 0, 0, 1);
		paragraph1.addToken(tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		Paragraph paragraph2 = new Paragraph(idFactory.createId(), 100, 300, 300, 2);
		SignItemToken cursorToken = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph2.addToken(cursorToken);
		int lastSectionIndex = dummyDocument.getSectionCount() - 1;
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph1);
		dummyDocument.getSection(lastSectionIndex).addParagraph(paragraph2);

		setFieldValue(documentEditor, DocumentEditor.class, "currentCursorTokenId", cursorToken.getId());
		// Action
		documentEditor.handleSendParagraphToBack();
		// Check
		assertEquals(1, paragraph2.getZIndex());
		assertEquals(2, paragraph1.getZIndex());
	}

	@Test
	public void testMergeParagraphWithNext() {

		documentEditor.openDocument(dummyDocument, createDummyDocumentItem(), createDummyFolderItem(),
				createDummyRoomItem());

		Paragraph paragraph = new Paragraph(idFactory.createId());

		TextbasedTokenStyleFactory textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();

		SignItem sign = new SignItem(new SignId(1234, "test", SignLocale.DGS, SignSource.DELEGS), 30);
		Token token1 = tokenFactory.createSignItemToken("token1", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Token token2 = tokenFactory.createSignItemToken("token2", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		Token token3 = tokenFactory.createSignItemToken("token3", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph.addToken(token3);

		assertEquals(3, paragraph.getTokenCount());
		assertEquals(token1, paragraph.getToken(0));
		assertEquals(token2, paragraph.getToken(1));
		assertEquals(token3, paragraph.getToken(2));
		assertNotNull(((SignItemToken) paragraph.getToken(0)).getSignItem());
		assertNotNull(((SignItemToken) paragraph.getToken(1)).getSignItem());
		assertNotNull(((SignItemToken) paragraph.getToken(2)).getSignItem());

		dummyDocument.getSection(0).addParagraph(paragraph);

		Method tryMergeSignItemTokenWithNextMethod = null;
		try {
			tryMergeSignItemTokenWithNextMethod = DocumentEditor.class
					.getDeclaredMethod("tryMergeSignItemTokenWithNext", Id.class);
			tryMergeSignItemTokenWithNextMethod.setAccessible(true);
			tryMergeSignItemTokenWithNextMethod.invoke(documentEditor, token1.getId());

			assertEquals(2, paragraph.getTokenCount());
			assertEquals("token1token2", ((SignItemToken) paragraph.getToken(0)).getText());
			assertEquals("token3", ((SignItemToken) paragraph.getToken(1)).getText());
			assertNull(((SignItemToken) paragraph.getToken(0)).getSignItem());
			assertNotNull(((SignItemToken) paragraph.getToken(1)).getSignItem());

			tryMergeSignItemTokenWithNextMethod.invoke(documentEditor, token1.getId());

			assertEquals(1, paragraph.getTokenCount());
			assertEquals("token1token2token3", ((SignItemToken) paragraph.getToken(0)).getText());
			assertNull(((SignItemToken) paragraph.getToken(0)).getSignItem());

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("No exception expected");
			e.printStackTrace();
		}

	}

	private Document createDummyDocument() {
		PageFormat format = new PageFormat("Hochkant", Orientation.HORIZONTAL, 72, 300, 200, 1, 1, 1, 1);
		Document document = new Document(
				new User("peterle", "peter", "parker", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
				SignLocale.DGS, new FileTitle("Erstes Dokument"), format);
		Section section = new Section();
		Paragraph paragraph = new Paragraph(idFactory.createId());
		paragraph.addToken(tokenFactory.createSignItemToken("Hallo",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));
		section.addParagraph(paragraph);

		document.addSection(section);
		return document;
	}

	private FolderItem createDummyFolderItem() {
		return new FolderItem(idFactory.createId(), "user", new FileTitle("/"), new Date(), new Date(),
				FileItemColorLabel.NONE, SortCriteria.TYPE);
	}

	private DocumentItem createDummyDocumentItem() {
		return new DocumentItem(idFactory.createId(), "user", new FileTitle("/"), new Date(), new Date(),
				FileItemColorLabel.NONE);
	}

	private RoomItem createDummyRoomItem() {
		return new RoomItem(idFactory.createId(), "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}

	private RoomItem createDummyRoot() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}

	private void setPageCountForDocumentLayouterMock(int pageCount) {
		documentLayouter.setPageCount(pageCount);
	}
}