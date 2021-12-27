package de.signWritingEditor.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
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
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
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

@RunWith(JUnit4.class)
public class SignWritingServiceImplSessionTimeoutTest {

	private String sessionTimeoutMillis = "2000";
	private SignWritingServiceImpl signWritingService;
	private SymbolFactory symbolFactory;
	private DbConnector connector;
	private IdFactory idFactory;
	private ConfigurationService configurationService;
	private FolderItem rootFolder;
	private FolderItem publicFolder;
	private UserSession authorSession;
	private String comment;
	private FileTitle ownerDocumentTitle;
	private Document ownerDocument;
	private DocumentItem ownerdocumentItem;

	@Before
	public void setUp() throws Exception {
		configurationService = new ConfigurationServiceTimeoutMock();
		connector = new DbConnector(configurationService);
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		comment = "Das ist ein Kommentar";

		signWritingService = new SignWritingServiceImpl(configurationService);
		idFactory = new IdFactory(9);
		rootFolder = signWritingService.getRootRoomItem();

		User user = new User("delegs", "signWritingTestUser", "", null, true,
				Arrays.asList(new UserRole[] { UserRole.AUTHOR }), 1);
		String password = "foobar";
		UserDb userDb = new UserDb(connector);
		userDb.saveUser(user, PasswordHashUtil.hash(password));

		authorSession = signWritingService.login(user.getUsername(), password);

		FileTitle publicFolderName = createPublicFolder();

		publicFolder = signWritingService.getFolderItem(authorSession.getSessionKey(), publicFolderName, rootFolder);

		ownerDocumentTitle = new FileTitle("document1");
		ownerDocument = createTestDocument(authorSession.getUser(), ownerDocumentTitle);
		signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), ownerDocument, publicFolder);
		ownerdocumentItem = signWritingService.getDocumentItem(authorSession.getSessionKey(),
				ownerDocument.getDocumentTitle(), publicFolder);
		Thread.sleep(Long.parseLong(sessionTimeoutMillis));
	}

	private FileTitle createPublicFolder()
			throws AccessDeniedException, InvalidSessionException, MissingAuthorizationException {
		FileTitle publicFolderName = new FileTitle("Öffentlich");
		if (!signWritingService.existsFolderTitle(authorSession.getSessionKey(), publicFolderName, rootFolder)) {
			List<String> ownerList = Arrays.asList(new String[] { authorSession.getUser().getUsername() });
			ArrayList<String> roomUsers = new ArrayList<String>();
			roomUsers.add(authorSession.getUser().getUsername());
			roomUsers.add(User.getUnknownUser().getUsername());
			signWritingService.createNewRoom(authorSession.getSessionKey(), publicFolderName, roomUsers, ownerList,
					RoomPolicy.SHARED_CONTENT, false, null);
		}
		return publicFolderName;
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws AccessDeniedException, InvalidSessionException {
		UserDb userDb = new UserDb(connector);
		SignDB signDb = new SignDB(connector, userDb, symbolFactory, configurationService);
		signDb.purgeTableSigns();

		connector = null;
	}

	@Test(expected = InvalidSessionException.class)
	public void testSaveDocument_expiredSession_ThrowsExeption() throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), ownerDocument, publicFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testExistsDocumentTitle_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.existsDocumentTitle(authorSession.getSessionKey(), ownerDocumentTitle, publicFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testGetFolderContentAndPath_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testLoadDocument_expiredSession_ThrowsExeption() throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.loadDocument(authorSession.getSessionKey(), ownerdocumentItem);
	}

	@Test(expected = InvalidSessionException.class)
	public void testDeleteFiles_expiredSession_ThrowsExeption() throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.deleteFiles(authorSession.getSessionKey(), ownerdocumentItem);
	}

	@Test(expected = InvalidSessionException.class)
	public void testMoveFiles_expiredSession_ThrowsExeption() throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.moveFiles(authorSession.getSessionKey(), publicFolder, ownerdocumentItem);
	}

	@Test(expected = InvalidSessionException.class)
	public void testCreateNewFolder_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Prepare
		FileTitle newFolderTitle = new FileTitle("newFolderTitleTest");
		// Action & Check
		signWritingService.createNewFolder(authorSession.getSessionKey(), newFolderTitle, publicFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testExistsFolderTitle_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.existsFolderTitle(authorSession.getSessionKey(), publicFolder.getFileTitle(), rootFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testGetDocumentItem_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.getDocumentItem(authorSession.getSessionKey(), ownerDocumentTitle, publicFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testGetFolderItem_expiredSession_ThrowsExeption()
			throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.getFolderItem(authorSession.getSessionKey(), publicFolder.getFileTitle(), rootFolder);
	}

	@Test(expected = InvalidSessionException.class)
	public void testRenameFile_expiredSession_ThrowsExeption() throws AccessDeniedException, InvalidSessionException {
		// Action & Check
		signWritingService.renameFile(authorSession.getSessionKey(), ownerdocumentItem, ownerDocumentTitle);
	}

	private Document createTestDocument(User user, FileTitle documentTitle) throws Exception {
		Document document = new Document(user, SignLocale.DGS, documentTitle, PageFormat.A4_PORTRAIT);
		Section section = new Section();
		document.addSection(section);

		section.addParagraph(new Paragraph(idFactory.createId()));
		TextbasedTokenStyleFactory textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		TokenFactory tokenFactory = new TokenFactory(idFactory);

		for (int i = 0; i < 5; i++) {
			String word = "testMeaning" + i;
			SimpleSign sign = new SimpleSign(new SignId(12345 + i, word, SignLocale.DGS, SignSource.DELEGS),
					User.getUnknownUser(), SignLocale.DGS, new Date(i), comment);
			sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("02-05-005-01-01-01"), i, 2 * i, i));
			if (!signWritingService.existsItem(sign.getSignId())) {
				signWritingService.saveSign(word, sign, authorSession.getSessionKey());
			}
			SignItem signItem = new SignItem(sign.getSignId(), sign.getWidth());
			SignItemToken token = tokenFactory.createSignItemToken("test" + i, signItem,
					textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
			document.addToken(token);
		}
		return document;
	}

	private class ConfigurationServiceTimeoutMock extends ConfigurationService {

		public ConfigurationServiceTimeoutMock() throws IOException {
			super("/ESFConfig_Junit.properties");
		}

		@Override
		public String getProperty(String key) {
			if (key == "esf.session.expiryTimeMillis") {
				return sessionTimeoutMillis;
			}
			return super.getProperty(key);
		}
	}
}
