package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.SignPuddleXmlParser.PositionedSymbolEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.SignPuddleEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.SymbolEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.TextTermEntry;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.infrastructure.IswaBswConverter;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

@RunWith(JUnit4.class)
public class SignWritingServiceImplTest {

	private SignWritingServiceImpl signWritingService;
	private SymbolFactory symbolFactory;
	private DbConnector connector;
	private IdFactory idFactory;
	private ConfigurationService configurationService;
	private FolderItem rootFolder;
	private FolderItem publicFolder;
	private UserSession authorSession;
	private String comment;

	private User delegsUser;
	private String delegsUserPassword;

	@Before
	public void setUp() throws Exception {
		configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		comment = "Das ist ein Kommentar";

		signWritingService = new SignWritingServiceImpl(configurationService);
		idFactory = new IdFactory(9);
		rootFolder = signWritingService.getRootRoomItem();

		delegsUser = new User("delegs", "signWritingTestUser", "", null, true,
				Arrays.asList(new UserRole[] { UserRole.AUTHOR }), 1);
		UserDb userDB = new UserDb(connector);
		delegsUserPassword = "foobar";
		userDB.saveUser(delegsUser, PasswordHashUtil.hash(delegsUserPassword));

		authorSession = signWritingService.login(delegsUser.getUsername(), delegsUserPassword);

		FileTitle publicFolderName = createPublicFolder();

		publicFolder = signWritingService.getFolderItem(authorSession.getSessionKey(), publicFolderName, rootFolder);
	}

	private FileTitle createPublicFolder()
			throws AccessDeniedException, InvalidSessionException, MissingAuthorizationException {
		FileTitle publicFolderName = new FileTitle("Öffentlich");
		if (!signWritingService.existsFolderTitle(authorSession.getSessionKey(), publicFolderName, rootFolder)) {
			List<String> ownerList = Arrays.asList(new String[] { authorSession.getUser().getUsername() });
			ArrayList<String> roomUsers = new ArrayList<String>();
			roomUsers.add(User.getUnknownUser().getUsername());
			signWritingService.createNewRoom(authorSession.getSessionKey(), publicFolderName, ownerList, roomUsers,
					RoomPolicy.SHARED_CONTENT, false, null);
		}
		return publicFolderName;
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() {
		UserDb userDb = new UserDb(connector);
		SignDB signDb = new SignDB(connector, userDb, symbolFactory, configurationService);
		signDb.purgeTableSigns();

		connector = null;
	}

	@Test(expected = AccessDeniedException.class)
	public void testMissingAuthorizationToHideSign() throws Exception {
		String word = "test" + new Date().getTime();
		SimpleSign sign = createSimpleSign(word);

		UserSession userSession = createUserSession("testuser");
		signWritingService.saveSign(word, sign, authorSession.getSessionKey());
		signWritingService.hideSign(sign, userSession.getSessionKey());
	}

	@Test
	public void testMissingAuthorizationToSaveSign() throws Exception {
		String word = "test" + new Date().getTime();
		SimpleSign sign = createSimpleSign(word);

		UserSession userSession = createUserSession("testuser");
		try {
			signWritingService.saveSign(word, sign, userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here...
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testMissingAuthorizationToUpdateSign() throws Exception {
		String word = "test" + new Date().getTime();
		SimpleSign sign = createSimpleSign(word);

		UserSession userSession = createUserSession("testuser");
		signWritingService.saveSign(word, sign, authorSession.getSessionKey());

		try {
			signWritingService.updateSign(sign, userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here...
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddUserToRoomNotAllowed() throws Exception {
		UserSession userSession = createUserSession("testuser");
		UserSession userSession2 = createUserSession("testuser2");
		RoomItem room = signWritingService.getRoomForFileItem(publicFolder);
		signWritingService.addUserToRoom(room, userSession.getUser().getUsername(), authorSession.getSessionKey());
		try {
			signWritingService.addUserToRoom(room, userSession2.getUser().getUsername(), userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testDeleteUserFromRoomNotAllowed() throws Exception {
		UserSession userSession = createUserSession("testuser");
		UserSession userSession2 = createUserSession("testuser2");
		RoomItem room = signWritingService.getRoomForFileItem(publicFolder);
		signWritingService.addUserToRoom(room, userSession.getUser().getUsername(), authorSession.getSessionKey());
		signWritingService.addUserToRoom(room, userSession2.getUser().getUsername(), authorSession.getSessionKey());
		try {
			signWritingService.deleteUserFromRoom(room, userSession2.getUser().getUsername(),
					userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddAdminToRoomNotAllowed() throws Exception {
		UserSession userSession = createUserSession("testuser");
		UserSession userSession2 = createUserSession("testuser2");
		RoomItem room = signWritingService.getRoomForFileItem(publicFolder);
		signWritingService.addUserToRoom(room, userSession.getUser().getUsername(), authorSession.getSessionKey());
		try {
			signWritingService.addAdminToRoom(room, userSession2.getUser().getUsername(), userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testDeleteAdminFromRoomNotAllowed() throws Exception {
		UserSession userSession = createUserSession("testuser");
		UserSession userSession2 = createUserSession("testuser2");
		RoomItem room = signWritingService.getRoomForFileItem(publicFolder);
		signWritingService.addUserToRoom(room, userSession.getUser().getUsername(), authorSession.getSessionKey());
		signWritingService.addAdminToRoom(room, userSession2.getUser().getUsername(), authorSession.getSessionKey());
		try {
			signWritingService.deleteAdminFromRoom(room, userSession2.getUser().getUsername(),
					userSession.getSessionKey());
			fail();
		} catch (MissingAuthorizationException e) {
			// Nothing to do here
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testVideoAndImagePermission() throws InvalidSessionException {
		UserSession userSession = createUserSession("testUser");

		assertFalse(signWritingService.hasVideoAndImagePermission(userSession.getSessionKey()));
		assertTrue(signWritingService.hasVideoAndImagePermission(authorSession.getSessionKey()));
	}

	private UserSession createUserSession(String username) {
		UserDb userDb = new UserDb(connector);

		String password = "TestUserPassword";
		User user = new User(username, "firstname", "lastname", null, Arrays.asList(new UserRole[] { UserRole.USER }),
				1);
		if (userDb.existsUserWithName(user)) {
			userDb.delete(user);
		}
		userDb.saveUser(user, PasswordHashUtil.hash(password));
		if (!userDb.isUserActivated(user)) {
			userDb.activateUser(user);
		}
		UserSession userSession = signWritingService.login(username, password);
		return userSession;
	}

	private SimpleSign createSimpleSign(String word) {
		SimpleSign sign = new SimpleSign(new SignId(12345, word, SignLocale.DGS, SignSource.DELEGS),
				User.getUnknownUser(), SignLocale.DGS, new Date(1234), comment);
		sign.addSymbol((new PositionedSymbol(symbolFactory.createSymbol("01-01-001-01-01-16"), 10, 10, 1)));
		sign.addSymbol((new PositionedSymbol(symbolFactory.createSymbol("01-02-001-01-01-16"), 10, 30, 2)));
		sign.addSymbol(new PositionedSymbol(symbolFactory.createSymbol("01-01-003-01-01-16"), 55, 20, 3));

		sign.normalize();
		return sign;
	}

	@Test
	public void testDocumentRelatedOperations() throws Exception {
		assertSaveAndDelete(createTestDocument(User.getUnknownUser(), new FileTitle("test")));
		assertSaveAndDelete(createTestDocument(User.getUnknownUser(), new FileTitle("0 OR 1 = 1")));
		assertSaveAndDelete(createTestDocument(User.getUnknownUser(), new FileTitle("0) DELETE FROM USER--")));

		assertSaveAndMove(createTestDocument(User.getUnknownUser(), new FileTitle("test")));
		assertSaveAndMove(createTestDocument(User.getUnknownUser(), new FileTitle("0 OR 1 = 1")));
		assertSaveAndMove(createTestDocument(User.getUnknownUser(), new FileTitle("0) DELETE FROM USER--")));
	}

	@Test
	public void testLogin() {
		assertEquals(authorSession.getUser(), signWritingService.login(delegsUser.getUsername(), delegsUserPassword).getUser());

		assertEquals(User.getUnknownUser(), signWritingService.login("unknownUserName", "password").getUser());
	}

	@Test
	public void testGetIdSeed() {
		long lastIdSeed = 0;
		for (int i = 0; i < 100; i++) {
			long idSeed = signWritingService.getInitBundle().getIdSeed();
			assertTrue(idSeed > lastIdSeed);
			lastIdSeed = idSeed;
		}
	}

	@Test
	public void testPermissions() throws Exception {
		User owner = new User("owner", "firstname", "lastname", null, Arrays.asList(new UserRole[] { UserRole.USER }),
				1);
		User additionalOwner = new User("additionalOwner", "firstname", "lastname", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User user = new User("user", "firstname", "lastname", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		SessionKey otherUserSessionKey = signWritingService.createUnknownUserSession().getSessionKey();

		UserDb userDB = new UserDb(connector);
		DocumentDb documentDB = new DocumentDb(connector);
		if (!userDB.existsUserWithName(owner)) {
			userDB.saveUser(owner, PasswordHashUtil.hash("TestOwnerPassword"));
		}
		if (!userDB.isUserActivated(owner)) {
			userDB.activateUser(owner);
		}
		if (!userDB.existsUserWithName(user)) {
			userDB.saveUser(user, PasswordHashUtil.hash("TestUserPassword"));
		}
		if (!userDB.isUserActivated(user)) {
			userDB.activateUser(user);
		}

		if (userDB.existsUserWithName(additionalOwner)) {

			List<DocumentItem> documentItemsForUser = documentDB.getDocumentItemsForUser(additionalOwner.getUsername());
			for (DocumentItem documentItem : documentItemsForUser) {
				documentDB.deleteDocument(documentItem.getId());
			}

			List<FolderItem> folderItemsForUser = documentDB.getFolderItemsForUser(additionalOwner.getUsername());
			for (FolderItem folderItem : folderItemsForUser) {
				documentDB.deleteFolder(folderItem.getId());
			}

			assertTrue(userDB.delete(additionalOwner));

		}
		userDB.saveUser(additionalOwner, PasswordHashUtil.hash("test123"));
		userDB.activateUser(additionalOwner);

		SessionKey userSessionKey = signWritingService.login(user.getUsername(), "TestUserPassword").getSessionKey();
		SessionKey ownerSessionKey = signWritingService.login(owner.getUsername(), "TestOwnerPassword").getSessionKey();
		SessionKey additionalOwnerSessionKey = signWritingService.login(additionalOwner.getUsername(), "test123")
				.getSessionKey();

		ArrayList<String> roomUsers = new ArrayList<String>();
		roomUsers.add(user.getUsername());

		ArrayList<String> roomOwners = new ArrayList<String>();
		roomOwners.add(owner.getUsername());
		roomOwners.add(additionalOwner.getUsername());

		RoomItem sharedContentRoom = createRoom(documentDB, new FileTitle("Room1"), owner, roomUsers, roomOwners,
				RoomPolicy.SHARED_CONTENT);
		RoomItem collectiveContentRoom = createRoom(documentDB, new FileTitle("Room2"), owner, roomUsers, roomOwners,
				RoomPolicy.COLLECTIVE_CONTENT);
		RoomItem individualContentRoom = createRoom(documentDB, new FileTitle("Room3"), owner, roomUsers, roomOwners,
				RoomPolicy.INDIVIDUAL_CONTENT);

		FileTitle userDocumentTitle = new FileTitle("document1");
		FileTitle ownerDocumentTitle = new FileTitle("document2");

		Document userDocument = createTestDocument(user, userDocumentTitle);
		Document ownerDocument = createTestDocument(owner, ownerDocumentTitle);

		// Test permissions of createNewFolder()
		try {
			signWritingService.createNewFolder(ownerSessionKey, new FileTitle("folder1"), sharedContentRoom);
			signWritingService.createNewFolder(additionalOwnerSessionKey, new FileTitle("additional"),
					sharedContentRoom);
			signWritingService.createNewFolder(userSessionKey, new FileTitle("folder2"), sharedContentRoom);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.createNewFolder(otherUserSessionKey, new FileTitle("folder3"), sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of saveDocument()

		try {
			signWritingService.saveOrUpdateDocument(ownerSessionKey, userDocument, sharedContentRoom);
			signWritingService.saveOrUpdateDocument(additionalOwnerSessionKey, userDocument, sharedContentRoom);

			userDocument.setDocumentTitle(ownerDocumentTitle);
			signWritingService.saveOrUpdateDocument(userSessionKey, userDocument, sharedContentRoom);
			signWritingService.saveOrUpdateDocument(ownerSessionKey, userDocument, sharedContentRoom);
			signWritingService.saveOrUpdateDocument(additionalOwnerSessionKey, userDocument, sharedContentRoom);

			userDocument.setDocumentTitle(userDocumentTitle);
			signWritingService.saveOrUpdateDocument(userSessionKey, userDocument, sharedContentRoom);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, ownerDocument, sharedContentRoom);
			signWritingService.saveOrUpdateDocument(additionalOwnerSessionKey, ownerDocument, sharedContentRoom);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.saveOrUpdateDocument(userSessionKey, ownerDocument, sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.saveOrUpdateDocument(otherUserSessionKey, userDocument, sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of moveDocument()

		DocumentItem userDocumentItem = null;
		DocumentItem ownerDocumentItem = null;
		try {
			userDocumentItem = signWritingService.getDocumentItem(userSessionKey, userDocumentTitle, sharedContentRoom);
			ownerDocumentItem = signWritingService.getDocumentItem(userSessionKey, ownerDocumentTitle,
					sharedContentRoom);
			signWritingService.moveFiles(ownerSessionKey, collectiveContentRoom, userDocumentItem);
			signWritingService.moveFiles(additionalOwnerSessionKey, sharedContentRoom, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.moveFiles(userSessionKey, individualContentRoom, ownerDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.moveFiles(ownerSessionKey, individualContentRoom, ownerDocumentItem);
			signWritingService.moveFiles(ownerSessionKey, sharedContentRoom, ownerDocumentItem);
			signWritingService.moveFiles(additionalOwnerSessionKey, individualContentRoom, ownerDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.moveFiles(userSessionKey, collectiveContentRoom, userDocumentItem);
			signWritingService.moveFiles(userSessionKey, individualContentRoom, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.moveFiles(otherUserSessionKey, collectiveContentRoom, userDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.moveFiles(ownerSessionKey, collectiveContentRoom, userDocumentItem);
			signWritingService.moveFiles(ownerSessionKey, individualContentRoom, userDocumentItem);
			signWritingService.moveFiles(additionalOwnerSessionKey, collectiveContentRoom, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.moveFiles(otherUserSessionKey, individualContentRoom, userDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.moveFiles(userSessionKey, individualContentRoom, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		// Test permissions of getDocumentItem()

		try {
			signWritingService.getDocumentItem(otherUserSessionKey, userDocumentTitle, individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.getDocumentItem(ownerSessionKey, userDocumentTitle, individualContentRoom);
			signWritingService.getDocumentItem(additionalOwnerSessionKey, userDocumentTitle, individualContentRoom);
			signWritingService.getDocumentItem(userSessionKey, userDocumentTitle, individualContentRoom);
			signWritingService.moveFiles(ownerSessionKey, sharedContentRoom, userDocumentItem);
			signWritingService.getDocumentItem(ownerSessionKey, ownerDocumentTitle, individualContentRoom);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.getDocumentItem(otherUserSessionKey, userDocumentTitle, sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.getDocumentItem(userSessionKey, ownerDocumentTitle, individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of existDocumentTitle()

		try {
			assertTrue(signWritingService.existsDocumentTitle(ownerSessionKey, userDocumentTitle, sharedContentRoom));
			assertTrue(signWritingService.existsDocumentTitle(additionalOwnerSessionKey, userDocumentTitle,
					sharedContentRoom));
			assertTrue(signWritingService.existsDocumentTitle(userSessionKey, userDocumentTitle, sharedContentRoom));
			assertFalse(
					signWritingService.existsDocumentTitle(ownerSessionKey, userDocumentTitle, individualContentRoom));
			assertFalse(signWritingService.existsDocumentTitle(additionalOwnerSessionKey, userDocumentTitle,
					individualContentRoom));
			assertFalse(
					signWritingService.existsDocumentTitle(userSessionKey, userDocumentTitle, individualContentRoom));
			signWritingService.existsDocumentTitle(userSessionKey, ownerDocumentTitle, individualContentRoom);
			signWritingService.moveFiles(ownerSessionKey, individualContentRoom, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.existsDocumentTitle(otherUserSessionKey, userDocumentTitle, sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.existsDocumentTitle(otherUserSessionKey, userDocumentTitle, individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of loadDocument()

		try {
			signWritingService.moveFiles(ownerSessionKey, sharedContentRoom, userDocumentItem);
			signWritingService.loadDocument(ownerSessionKey, userDocumentItem);
			signWritingService.loadDocument(userSessionKey, userDocumentItem);

			signWritingService.moveFiles(ownerSessionKey, individualContentRoom, userDocumentItem);
			signWritingService.loadDocument(ownerSessionKey, userDocumentItem);
			signWritingService.loadDocument(additionalOwnerSessionKey, userDocumentItem);
			signWritingService.loadDocument(userSessionKey, userDocumentItem);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.loadDocument(otherUserSessionKey, userDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of deleteFiles()

		try {
			signWritingService.deleteFiles(otherUserSessionKey, userDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.deleteFiles(otherUserSessionKey, ownerDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.deleteFiles(userSessionKey, ownerDocumentItem);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.deleteFiles(userSessionKey, userDocumentItem);
			signWritingService.deleteFiles(ownerSessionKey, ownerDocumentItem);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, ownerDocument, sharedContentRoom);
			ownerDocumentItem = signWritingService.getDocumentItem(ownerSessionKey, ownerDocumentTitle,
					sharedContentRoom);
			signWritingService.deleteFiles(additionalOwnerSessionKey, ownerDocumentItem);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, userDocument, sharedContentRoom);
			userDocumentItem = signWritingService.getDocumentItem(ownerSessionKey, userDocumentTitle,
					sharedContentRoom);
			signWritingService.deleteFiles(ownerSessionKey, userDocumentItem);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, userDocument, sharedContentRoom);
			userDocumentItem = signWritingService.getDocumentItem(ownerSessionKey, userDocumentTitle,
					sharedContentRoom);
			signWritingService.deleteFiles(additionalOwnerSessionKey, userDocumentItem);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, userDocument, sharedContentRoom);
			userDocumentItem = signWritingService.getDocumentItem(ownerSessionKey, userDocumentTitle,
					sharedContentRoom);

			signWritingService.saveOrUpdateDocument(ownerSessionKey, ownerDocument, sharedContentRoom);
			ownerDocumentItem = signWritingService.getDocumentItem(ownerSessionKey, ownerDocumentTitle,
					sharedContentRoom);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		// Test permission of getFolderItem()

		FolderItem folderItem1 = null;
		FolderItem folderItem2 = null;

		try {
			folderItem1 = signWritingService.getFolderItem(ownerSessionKey, new FileTitle("folder1"),
					sharedContentRoom);
			folderItem1 = signWritingService.getFolderItem(additionalOwnerSessionKey, new FileTitle("folder1"),
					sharedContentRoom);
			folderItem1 = signWritingService.getFolderItem(userSessionKey, new FileTitle("folder1"), sharedContentRoom);
			folderItem2 = signWritingService.getFolderItem(userSessionKey, new FileTitle("folder2"), sharedContentRoom);
			folderItem2 = signWritingService.getFolderItem(additionalOwnerSessionKey, new FileTitle("folder2"),
					sharedContentRoom);

			signWritingService.moveFiles(ownerSessionKey, individualContentRoom, folderItem1);

		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			folderItem1 = signWritingService.getFolderItem(otherUserSessionKey, new FileTitle("folder1"),
					individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permission of getFileItemsInFolder()

		try {
			signWritingService.getFolderContentAndPath(ownerSessionKey, folderItem1);
			signWritingService.getFolderContentAndPath(additionalOwnerSessionKey, folderItem1);
			signWritingService.getFolderContentAndPath(userSessionKey, folderItem1);

			signWritingService.getFolderContentAndPath(ownerSessionKey, folderItem2);
			signWritingService.getFolderContentAndPath(additionalOwnerSessionKey, folderItem2);
			signWritingService.getFolderContentAndPath(userSessionKey, folderItem2);
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.getFolderContentAndPath(otherUserSessionKey, folderItem2);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.getFolderContentAndPath(otherUserSessionKey, folderItem1);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permission of existsFolderTitle

		try {
			assertTrue(signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder1"),
					individualContentRoom));
			assertTrue(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder1"),
					individualContentRoom));
			assertTrue(signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder1"),
					individualContentRoom));

			assertFalse(
					signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder1"), sharedContentRoom));
			assertFalse(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder1"),
					sharedContentRoom));
			assertFalse(
					signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder1"), sharedContentRoom));

			assertFalse(signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder1"),
					collectiveContentRoom));
			assertFalse(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder1"),
					collectiveContentRoom));
			assertFalse(signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder1"),
					collectiveContentRoom));

			assertTrue(
					signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder2"), sharedContentRoom));
			assertTrue(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder2"),
					sharedContentRoom));
			assertTrue(
					signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder2"), sharedContentRoom));

			assertFalse(signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder2"),
					individualContentRoom));
			assertFalse(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder2"),
					individualContentRoom));
			assertFalse(signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder2"),
					individualContentRoom));

			assertFalse(signWritingService.existsFolderTitle(ownerSessionKey, new FileTitle("folder2"),
					collectiveContentRoom));
			assertFalse(signWritingService.existsFolderTitle(additionalOwnerSessionKey, new FileTitle("folder2"),
					collectiveContentRoom));
			assertFalse(signWritingService.existsFolderTitle(userSessionKey, new FileTitle("folder2"),
					collectiveContentRoom));

		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.existsFolderTitle(otherUserSessionKey, new FileTitle("folder1"), collectiveContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.existsFolderTitle(otherUserSessionKey, new FileTitle("folder1"), sharedContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.existsFolderTitle(otherUserSessionKey, new FileTitle("folder2"), individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.existsFolderTitle(otherUserSessionKey, new FileTitle("folder1"), individualContentRoom);
			fail();
		} catch (AccessDeniedException e) {
		}

		// Test permissions of renameFile()

		try {
			signWritingService.renameFile(ownerSessionKey, userDocumentItem, new FileTitle("newDocumentName1"));
			signWritingService.renameFile(additionalOwnerSessionKey, userDocumentItem,
					new FileTitle("newDocumentName1"));
			signWritingService.renameFile(userSessionKey, userDocumentItem, new FileTitle("newDocumentName1"));
			signWritingService.renameFile(ownerSessionKey, ownerDocumentItem, new FileTitle("newDocumentName1"));
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			signWritingService.renameFile(userSessionKey, ownerDocumentItem, new FileTitle("newDocumentName1"));
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.renameFile(otherUserSessionKey, userDocumentItem, new FileTitle("newDocumentName1"));
			fail();
		} catch (AccessDeniedException e) {
		}

		try {
			signWritingService.renameFile(otherUserSessionKey, ownerDocumentItem, new FileTitle("newDocumentName1"));
			fail();
		} catch (AccessDeniedException e) {
		}
	}

	@Test
	public void testUserSession() throws Exception {
		// Prepare
		SessionKey invalidSessionKey = new SessionKey(authorSession.getSessionKey().getValue() - 5);

		FileTitle ownerDocumentTitle = new FileTitle("document1");
		Document ownerDocument = createTestDocument(authorSession.getUser(), ownerDocumentTitle);

		FileTitle newFolderTitle = new FileTitle("newFolderTitleTest");
		DocumentDb documentDb = new DocumentDb(connector);
		if (signWritingService.existsFolderTitle(authorSession.getSessionKey(), newFolderTitle, publicFolder)) {
			FolderItem folderItem = documentDb.getFolderItemWithTitleInParentFolder(newFolderTitle,
					publicFolder.getId());
			documentDb.deleteFolder(folderItem.getId());
		}

		// Action
		signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), ownerDocument, publicFolder);

		try {
			signWritingService.saveOrUpdateDocument(invalidSessionKey, ownerDocument, publicFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		DocumentItem ownerdocumentItem = signWritingService.getDocumentItem(authorSession.getSessionKey(),
				ownerDocument.getDocumentTitle(), publicFolder);

		signWritingService.existsDocumentTitle(authorSession.getSessionKey(), ownerDocumentTitle, publicFolder);

		try {
			signWritingService.existsDocumentTitle(invalidSessionKey, ownerDocumentTitle, publicFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder);

		try {
			signWritingService.getFolderContentAndPath(invalidSessionKey, publicFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.loadDocument(authorSession.getSessionKey(), ownerdocumentItem);

		try {
			signWritingService.loadDocument(invalidSessionKey, ownerdocumentItem);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.deleteFiles(authorSession.getSessionKey(), ownerdocumentItem);
		signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), ownerDocument, publicFolder);
		ownerdocumentItem = signWritingService.getDocumentItem(authorSession.getSessionKey(), ownerDocumentTitle,
				publicFolder);

		try {
			signWritingService.deleteFiles(invalidSessionKey, ownerdocumentItem);
			fail();
		} catch (InvalidSessionException e) {
			assertTrue(signWritingService.existFileItems(ownerdocumentItem));
		}

		signWritingService.moveFiles(authorSession.getSessionKey(), publicFolder, ownerdocumentItem);

		try {
			signWritingService.moveFiles(invalidSessionKey, publicFolder, ownerdocumentItem);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.createNewFolder(authorSession.getSessionKey(), newFolderTitle, publicFolder);
		FolderItem newFolder = signWritingService.getFolderItem(authorSession.getSessionKey(), newFolderTitle,
				publicFolder);
		signWritingService.deleteFiles(authorSession.getSessionKey(), newFolder);

		try {
			signWritingService.createNewFolder(invalidSessionKey, newFolderTitle, publicFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.existsFolderTitle(authorSession.getSessionKey(), publicFolder.getFileTitle(), rootFolder);

		try {
			signWritingService.existsFolderTitle(invalidSessionKey, publicFolder.getFileTitle(), rootFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.getDocumentItem(authorSession.getSessionKey(), ownerDocumentTitle, publicFolder);

		try {
			signWritingService.getDocumentItem(invalidSessionKey, ownerDocumentTitle, publicFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.getFolderItem(authorSession.getSessionKey(), new FileTitle("Öffentlich"), rootFolder);

		try {
			signWritingService.getFolderItem(invalidSessionKey, new FileTitle("Öffentlich"), rootFolder);
			fail();
		} catch (InvalidSessionException e) {
		}

		signWritingService.renameFile(authorSession.getSessionKey(), ownerdocumentItem, ownerDocumentTitle);

		try {
			signWritingService.renameFile(invalidSessionKey, ownerdocumentItem, ownerDocumentTitle);
			fail();
		} catch (InvalidSessionException e) {
		}
	}

	private RoomItem createRoom(DocumentDb documentDb, FileTitle roomName, User user, List<String> roomUsers,
			List<String> roomOwners, RoomPolicy roomPolicy) {
		assert user != null : "Precondition failed: user != null";
		assert roomName != null : "Precondition failed: roomName != null";
		assert documentDb != null : "Precondition failed: documentDB != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomOwners != null : "Precondition failed: roomOwners != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";

		if (documentDb.existsRoomWithTitle(roomName)) {
			documentDb
					.deleteRoom(documentDb.getFolderItemWithTitleInParentFolder(roomName, rootFolder.getId()).getId());
		}

		if (documentDb.existsFolderWithTitleInParentFolder(roomName, rootFolder.getId())) {
			documentDb.deleteFolder(
					documentDb.getFolderItemWithTitleInParentFolder(roomName, rootFolder.getId()).getId());
		}

		Id newroomId = documentDb.createNewRoomWithRecycleBin(roomName, roomOwners, roomUsers, roomPolicy, false, null);
		FolderItem folderItemOfRoom2 = documentDb.getFolderItem(newroomId);
		assertTrue(folderItemOfRoom2 instanceof RoomItem);
		RoomItem room2 = (RoomItem) folderItemOfRoom2;

		return room2;
	}

	private void assertSaveAndDelete(Document document) throws Exception {
		FileTitle documentTitle = document.getDocumentTitle();

		try {
			if (signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder)) {
				signWritingService.deleteFiles(authorSession.getSessionKey(),
						signWritingService.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicFolder));
			}

			int documentCount = signWritingService.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder)
					.getFileItemsInFolder().size();

			signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), document, publicFolder);

			List<FileItem> documents = signWritingService
					.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder).getFileItemsInFolder();

			assertNotNull(documents);
			assertEquals(documentCount + 1, documents.size());
			assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle));
			assertTrue(
					signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder));

			Document loadedDocument = signWritingService.loadDocument(authorSession.getSessionKey(),
					signWritingService.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicFolder));
			assertEquals(document, loadedDocument);

			signWritingService.deleteFiles(authorSession.getSessionKey(),
					signWritingService.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicFolder));
			assertFalse(
					signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder));
			assertEquals(documentCount,
					signWritingService.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder)
							.getFileItemsInFolder().size());
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void assertSaveAndMove(Document document) throws Exception {
		FileTitle documentTitle = document.getDocumentTitle();

		try {
			if (signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder)) {
				signWritingService.deleteFiles(authorSession.getSessionKey(),
						signWritingService.getDocumentItem(authorSession.getSessionKey(), documentTitle, publicFolder));
			}

			int documentCount = signWritingService.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder)
					.getFileItemsInFolder().size();

			signWritingService.saveOrUpdateDocument(authorSession.getSessionKey(), document, publicFolder);

			List<FileItem> documents = signWritingService
					.getFolderContentAndPath(authorSession.getSessionKey(), publicFolder).getFileItemsInFolder();

			assertEquals(documentCount + 1, documents.size());
			assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle));
			assertTrue(
					signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder));

			DocumentItem documentItem = signWritingService.getDocumentItem(authorSession.getSessionKey(), documentTitle,
					publicFolder);
			Document loadedDocument = signWritingService.loadDocument(authorSession.getSessionKey(), documentItem);
			assertEquals(document.toString(), loadedDocument.toString());
			FileTitle folderTitle = new FileTitle("testMove");
			if (signWritingService.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicFolder)) {
				signWritingService.deleteFiles(authorSession.getSessionKey(),
						signWritingService.getFolderItem(authorSession.getSessionKey(), folderTitle, publicFolder));
			}

			signWritingService.createNewFolder(authorSession.getSessionKey(), folderTitle, publicFolder);
			FolderItem newFolder = signWritingService.getFolderItem(authorSession.getSessionKey(), folderTitle,
					publicFolder);

			signWritingService.moveFiles(authorSession.getSessionKey(), newFolder, documentItem);
			assertFalse(
					signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, publicFolder));
			assertTrue(signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, newFolder));

			signWritingService.deleteFiles(authorSession.getSessionKey(), documentItem);
			assertFalse(
					signWritingService.existsDocumentTitle(authorSession.getSessionKey(), documentTitle, newFolder));
			signWritingService.deleteFiles(authorSession.getSessionKey(), newFolder);
			assertFalse(signWritingService.existsFolderTitle(authorSession.getSessionKey(), folderTitle, publicFolder));
		} catch (AccessDeniedException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private boolean containsDocumentItemsListDocumentWithTitle(List<FileItem> fileItems, FileTitle title) {
		boolean result = false;
		for (FileItem documentItem : fileItems) {
			result |= documentItem.getFileTitle().equals(title);
		}
		return result;
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

}
