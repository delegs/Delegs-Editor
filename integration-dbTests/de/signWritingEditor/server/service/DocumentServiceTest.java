package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class DocumentServiceTest {

	private SystemDocumentService documentServiceUnderTest;
	private SymbolFactory symbolFactory;
	private FolderItem rootFolder;
	private RoomItem publicRoom;
	private UserSession authorSession;
	private RecycleBinItem publicRecycleBinItem;
	private IdFactory idFactory;
	private String comment;
	private DbConnector dbConnector;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp()
			throws IOException, AccessDeniedException, InvalidSessionException, MissingAuthorizationException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		dbConnector = new DbConnector(configurationService);
		UserDb userDb = new UserDb(dbConnector);
		SignDB signDB = new SignDB(dbConnector, userDb, symbolFactory, configurationService);
		DocumentDb documentDb = new DocumentDb(dbConnector);
		symbolFactory = new SymbolFactory(new SymbolDB(dbConnector).getAllSymbols());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		long uniqueNumber = 9;
		idFactory = new IdFactory(uniqueNumber);
		comment = "test";

		SessionServiceImpl sessionService = new SessionServiceImpl(configurationService);
		AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl(userDb, sessionService,
				new SendEmailService(configurationService));
		documentServiceUnderTest = new DocumentServiceImpl(sessionService, documentDb, userDb,
				new DocumentXMLConverter(userDb, signDB, symbolFactory, textbasedTokenStyleFactory,
						new PositionedSymbolFactory(), uniqueNumber));

		rootFolder = documentServiceUnderTest.getRootRoomItem();

		User user = new User("delegs", "signWritingTestUser", "", null, true,
				Arrays.asList(new UserRole[] { UserRole.AUTHOR }), 1);
		String password = "foobar";
		userDb.saveUser(user, PasswordHashUtil.hash(password));

		authorSession = authenticationService.login(user.getUsername(), password);

		FileTitle publicFolderName = new FileTitle("Öffentlich");
		if (!documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), publicFolderName, rootFolder)) {
			List<String> ownerList = Arrays.asList(new String[] { authorSession.getUser().getUsername() });
			List<String> roomUsers = Arrays.asList(new String[] { User.getUnknownUser().getUsername() });
			documentServiceUnderTest.createNewRoom(authorSession.getSessionKey(), publicFolderName, ownerList,
					roomUsers, RoomPolicy.SHARED_CONTENT, false, null);
		}

		FolderItem publicFolder = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(),
				publicFolderName, rootFolder);

		publicRoom = (RoomItem) publicFolder;
		publicRecycleBinItem = publicRoom.getRecycleBinItem();

		List<FileItem> fileItems = documentServiceUnderTest
				.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder).getFileItemsInFolder();
		fileItems.remove(publicRecycleBinItem);

		documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
				fileItems.toArray(new FileItem[fileItems.size()]));

	}

	@After
	public void tearDown() {
		dbConnector = null;
	}

	@Test
	public void testDefault() throws IOException {
		assertSaveAndDelete(createDummyDocument(new FileTitle("test")));
		assertSaveAndDelete(createDummyDocument(new FileTitle("asldj23\"49810äöas\" ädöäaöwein234720ad?34$§")));
		assertSaveAndDelete(createDummyDocument(new FileTitle("0 OR 1 = 1")));
		assertSaveAndDelete(createDummyDocument(new FileTitle("0 DELETE FROM user")));

		assertSaveAndMove(createDummyDocument(new FileTitle("test")));
		assertSaveAndMove(createDummyDocument(new FileTitle("asldj23\"49810äöas\" ädöäaöwein234720ad?34$§")));
		assertSaveAndMove(createDummyDocument(new FileTitle("0 OR 1 = 1")));
		assertSaveAndMove(createDummyDocument(new FileTitle("0 DELETE FROM user")));

		assertSaveAndRename(createDummyDocument(new FileTitle("test")));
		assertSaveAndRename(createDummyDocument(new FileTitle("asldj23\"49810äöas\" ädöäaöwein234720ad?34$§")));
		assertSaveAndRename(createDummyDocument(new FileTitle("0 OR 1 = 1")));
		assertSaveAndRename(createDummyDocument(new FileTitle("0 DELETE FROM user")));
	}

	@Test
	public void testFolders() {
		FileTitle testTitle = new FileTitle("test");
		try {
			if (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), testTitle, publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
						documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), testTitle, publicRoom));
			}
			assertFalse(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), testTitle, publicRoom));

			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), testTitle, publicRoom);
			assertTrue(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), testTitle, publicRoom));

			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
					documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), testTitle, publicRoom));
			assertFalse(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), testTitle, publicRoom));
		} catch (InvalidSessionException | AccessDeniedException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testRecycleBinRoomItem() {
		assertEquals(publicRecycleBinItem, publicRoom.getRecycleBinItem());

		List<FileItem> fileItemsInPublicFolder;
		try {
			fileItemsInPublicFolder = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder();
			assertTrue(fileItemsInPublicFolder.contains(publicRecycleBinItem));
		} catch (InvalidSessionException | AccessDeniedException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testExistFileInAFolder() {
		FileTitle documentTitle = new FileTitle("a document");
		Document document = new Document(authorSession.getUser(), SignLocale.DGS, documentTitle,
				PageFormat.A4_PORTRAIT);
		FileTitle folderTitleA = new FileTitle("FolderA");
		FileTitle folderTitleB = new FileTitle("FolderB");

		try {
			while (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getFolderItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			}
			while (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitleA,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getFolderItem(authorSession.getSessionKey(), folderTitleA, publicRoom));
			}
			while (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitleB,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getFolderItem(authorSession.getSessionKey(), folderTitleB, publicRoom));
			}

			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), folderTitleA, publicRoom);
			FolderItem folderItemA = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitleA,
					publicRoom);
			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), folderTitleB, publicRoom);
			FolderItem folderItemB = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitleB,
					publicRoom);
			documentServiceUnderTest.saveOrUpdateDocument(authorSession.getSessionKey(), document, folderItemA);
			documentServiceUnderTest.getDocumentItem(authorSession.getSessionKey(), documentTitle, folderItemA);

			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitleA,
					publicRoom));
			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitleB,
					publicRoom));
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					folderItemA));
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					folderItemB));

		} catch (AccessDeniedException | InvalidSessionException e) {
			e.printStackTrace();
			fail();
		}

	}

	private void assertSaveAndDelete(Document document) {
		FileTitle documentTitle = document.getDocumentTitle();

		try {
			if (documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			}
			int documentCount = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder().size();

			documentServiceUnderTest.saveOrUpdateDocument(authorSession.getSessionKey(), document, publicRoom);

			List<FileItem> documents = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder();

			assertEquals(documentCount + 1, documents.size());

			assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle));
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));

			Document loadedDocument = documentServiceUnderTest.loadDocument(authorSession.getSessionKey(),
					documentServiceUnderTest.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			assertEquals(document, loadedDocument);

			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
					documentServiceUnderTest.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));
			assertEquals(documentCount, documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder().size());
			assertEquals(1, document.getParagraphCount(0));
			assertEquals(5, document.getParagraph(0, 0).getTokenCount());
			assertEquals(3, document.getLocalDictionary().getKeyWords().size());

			Set<String> words = document.getLocalDictionary().getKeyWords();
			assertTrue(words.contains("Haus"));
			assertTrue(words.contains("Baum"));
			assertTrue(words.contains("Blume"));
		} catch (AccessDeniedException | InvalidSessionException e) {
			e.printStackTrace();
			fail();
		}
	}

	private void assertSaveAndMove(Document document) {
		FileTitle documentTitle = document.getDocumentTitle();
		try {
			if (documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			}
			int documentCount = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder().size();

			documentServiceUnderTest.saveOrUpdateDocument(authorSession.getSessionKey(), document, publicRoom);

			List<FileItem> documents = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder();

			assertEquals(documentCount + 1, documents.size());

			assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle));
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));

			DocumentItem documentItem = documentServiceUnderTest.getDocumentItem(authorSession.getSessionKey(),
					documentTitle, publicRoom);
			Document loadedDocument = documentServiceUnderTest.loadDocument(authorSession.getSessionKey(),
					documentItem);
			assertEquals(document, loadedDocument);
			FileTitle folderTitle = new FileTitle("testMove");

			if (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
						documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitle, publicRoom));
			}

			// to move a document to newFolder
			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), folderTitle, publicRoom);
			FolderItem newFolder = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitle,
					publicRoom);

			documentServiceUnderTest.moveFiles(authorSession.getSessionKey(), newFolder, documentItem);
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					newFolder));

			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentItem);
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					newFolder));
			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), newFolder);
			assertFalse(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicRoom));

			// to move a folder
			FileTitle newFolderTitle = new FileTitle("testFolderToGetMovedFolder");
			while (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), newFolderTitle,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getFolderItem(authorSession.getSessionKey(), newFolderTitle, publicRoom));
			}

			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), documentTitle, publicRoom);
			FolderItem folderToMove = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(),
					documentTitle, publicRoom);

			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), newFolderTitle, publicRoom);
			newFolder = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), newFolderTitle,
					publicRoom);

			assertFalse(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), newFolder));
			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), publicRoom));

			documentServiceUnderTest.moveFiles(authorSession.getSessionKey(), newFolder, folderToMove);
			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), newFolder));
			assertFalse(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), publicRoom));

			documentServiceUnderTest.moveFiles(authorSession.getSessionKey(), publicRoom, folderToMove);
			assertFalse(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), newFolder));

			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(),
					folderToMove.getFileTitle(), publicRoom));
		} catch (AccessDeniedException | InvalidSessionException e) {
			e.printStackTrace();
			fail();
		}
	}

	private void assertSaveAndRename(Document document) {
		FileTitle documentTitle = document.getDocumentTitle();

		try {
			if (documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentServiceUnderTest
						.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicRoom));
			}
			int documentCount = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder().size();

			documentServiceUnderTest.saveOrUpdateDocument(authorSession.getSessionKey(), document, publicRoom);

			List<FileItem> documents = documentServiceUnderTest
					.getFolderContentAndPath(authorSession.getSessionKey(), publicRoom).getFileItemsInFolder();

			assertEquals(documentCount + 1, documents.size());

			assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle));
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));

			DocumentItem documentItem = documentServiceUnderTest.getDocumentItem(authorSession.getSessionKey(),
					documentTitle, publicRoom);
			Document loadedDocument = documentServiceUnderTest.loadDocument(authorSession.getSessionKey(),
					documentItem);
			assertEquals(document, loadedDocument);

			FileTitle folderTitle = new FileTitle("testRename");
			if (documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicRoom)) {
				documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(),
						documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitle, publicRoom));
			}

			documentServiceUnderTest.createNewFolder(authorSession.getSessionKey(), folderTitle, publicRoom);
			FolderItem newFolder = documentServiceUnderTest.getFolderItem(authorSession.getSessionKey(), folderTitle,
					publicRoom);

			FileTitle newFolderTitle = new FileTitle("Renamed");
			documentServiceUnderTest.renameFile(authorSession.getSessionKey(), newFolder, newFolderTitle);
			assertTrue(documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), newFolderTitle,
					publicRoom));
			assertFalse(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicRoom));

			FileTitle newDocumentTitle = new FileTitle("RenamedDoc");
			documentServiceUnderTest.renameFile(authorSession.getSessionKey(), documentItem, newDocumentTitle);
			assertTrue(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), newDocumentTitle,
					publicRoom));
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));

			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), documentItem);
			assertFalse(documentServiceUnderTest.existsDocumentTitle(authorSession.getSessionKey(), documentTitle,
					publicRoom));
			documentServiceUnderTest.deleteFiles(authorSession.getSessionKey(), newFolder);

			assertFalse(
					documentServiceUnderTest.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicRoom));
		} catch (AccessDeniedException | InvalidSessionException e) {
			e.printStackTrace();
			fail();
		}
	}

	private boolean containsDocumentItemsListDocumentWithTitle(List<FileItem> fileItems, FileTitle fileTitle) {
		boolean result = false;
		for (FileItem documentItem : fileItems) {
			result |= documentItem.getFileTitle().equals(fileTitle);
		}
		return result;
	}

	private Document createDummyDocument(FileTitle documentTitle) {
		Document document = new Document(User.getUnknownUser(), SignLocale.DGS, documentTitle, PageFormat.A4_PORTRAIT);
		LocalDictionary localDictionary = new LocalDictionary();
		localDictionary.save(new SimpleSign(new SignId(12345, "Haus", SignLocale.DGS, SignSource.UNKNOWN),
				User.getUnknownUser(), SignLocale.DGS, new Date(123), comment));
		localDictionary.save(new SimpleSign(new SignId(12346, "Baum", SignLocale.DGS, SignSource.UNKNOWN),
				User.getUnknownUser(), SignLocale.DGS, new Date(1234), comment));
		localDictionary.save(new SimpleSign(new SignId(12347, "Blume", SignLocale.DGS, SignSource.UNKNOWN),
				User.getUnknownUser(), SignLocale.DGS, new Date(12345), comment));
		document.setLocalDictionary(localDictionary);

		Section section = new Section();
		document.addSection(section);

		TokenFactory tokenFactory = new TokenFactory(idFactory);

		section.addParagraph(new Paragraph(idFactory.createId()));
		for (int i = 0; i < 5; i++) {
			SignItem signItem = new SignItem(new SignId(12348 + i, "testMeaning", SignLocale.DGS, SignSource.DELEGS),
					20);

			SignItemToken token = tokenFactory.createSignItemToken("test" + i, signItem,
					textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
			document.addToken(token);
		}
		return document;
	}

}
