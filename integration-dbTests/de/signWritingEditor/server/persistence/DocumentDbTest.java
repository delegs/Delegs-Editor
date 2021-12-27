package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.User;

public class DocumentDbTest {
	private DocumentDb documentDb;
	private UserDb userDb;

	private RoomItem rootRoomItem;
	private Id rootRoomId;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		documentDb = new DocumentDb(connector);
		userDb = new UserDb(connector);

		rootRoomItem = documentDb.getRootRoomItem();
		rootRoomId = rootRoomItem.getId();
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testSaveAndDeleteDocuments() throws Exception {

		// initialize
		String documentTitleString0 = "0";
		String documentTitleString1 = "1";
		String documentTitleString2 = "2";
		String documentTitleString3 = "3";

		FileTitle documentTitle0 = new FileTitle(documentTitleString0);
		FileTitle documentTitle1 = new FileTitle(documentTitleString1);
		FileTitle documentTitle2 = new FileTitle(documentTitleString2);
		FileTitle documentTitle3 = new FileTitle(documentTitleString3);

		String author1 = getUserDeleteOldIfExists("Autor 1").getUsername();
		String author2 = getUserDeleteOldIfExists("Autor 2").getUsername();
		String author3 = getUserDeleteOldIfExists("Autor 3").getUsername();

		FolderItem otherFolder = createFolderItemDeleteOldIfExists(author1, "other", rootRoomId);

		assertNotExistsDocument(documentTitleString0, rootRoomId);
		assertNotExistsDocument(documentTitleString1, rootRoomId);
		assertNotExistsDocument(documentTitleString2, rootRoomId);
		assertNotExistsDocument(documentTitleString3, rootRoomId);

		int documentCount = documentDb.getDocumentCount();

		DocumentItem documentItem0 = documentDb.createDocument(documentTitle0, author1);
		assertTrue(documentDb.saveDocument(documentItem0.getId(), documentItem0.getFileTitle(), "Inhalt 1",
				documentItem0.getOwner(), rootRoomId));
		documentCount++;

		DocumentItem documentItem1 = documentDb.createDocument(documentTitle1, author2);
		assertTrue(documentDb.saveDocument(documentItem1.getId(), documentItem1.getFileTitle(), "Inhalt 2",
				documentItem1.getOwner(), rootRoomId));
		documentCount++;

		DocumentItem documentItem2 = documentDb.createDocument(documentTitle1, author2);
		assertTrue(documentDb.saveDocument(documentItem2.getId(), documentItem2.getFileTitle(), "Inhalt 2",
				documentItem2.getOwner(), otherFolder.getId()));
		documentCount++;

		DocumentItem documentItem3 = documentDb.createDocument(documentTitle2, author3);
		assertTrue(documentDb.saveDocument(documentItem3.getId(), documentItem3.getFileTitle(), "Inhalt 3",
				documentItem3.getOwner(), rootRoomId));
		documentCount++;

		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle0, rootRoomId));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle1, rootRoomId));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle1, otherFolder.getId()));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle2, rootRoomId));

		assertEquals(documentCount, documentDb.getDocumentCount());
		Id documentId = documentDb.getDocumentItem(documentTitle2, rootRoomId).getId();
		assertEquals("Inhalt 3", documentDb.getDocumentContent(documentId));

		// test update
		assertTrue(documentDb.updateDocument(documentId, documentTitle2, "Anderer Inhalt", author3,
				FileItemColorLabel.BLUE));
		assertEquals("Anderer Inhalt", documentDb.getDocumentContent(documentId));
		assertEquals(FileItemColorLabel.BLUE, documentDb.getDocumentItem(documentTitle2, rootRoomId).getColorLabel());

		DocumentItem documentItem4 = documentDb.createDocument(documentTitle3, author3);
		assertTrue(
				documentDb.saveDocument(documentItem4.getId(), documentTitle3, "Anderer Inhalt", author3, rootRoomId));
		documentCount++;

		assertEquals(documentDb.getDocumentContent(documentDb.getDocumentItem(documentTitle3, rootRoomId).getId()),
				"Anderer Inhalt");

		assertFalse(documentDb.existsDocumentTitleInFolder(new FileTitle("df54"), rootRoomId));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle0, rootRoomId));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle1, rootRoomId));
		assertTrue(documentDb.existsDocumentTitleInFolder(documentTitle2, rootRoomId));

		assertTrue(documentDb.deleteDocument(documentDb.getDocumentItem(documentTitle0, rootRoomId).getId()));
		documentCount--;
		assertFalse(documentDb.existsDocumentTitleInFolder(documentTitle0, rootRoomId));
		assertEquals(documentCount, documentDb.getDocumentCount());

		// Any user is ok since we are looking for documents that can't be
		// hidden
		List<FileItem> documents = documentDb.getVisibleFileItemsInFolderAccessibleForUser(rootRoomItem,
				User.getUnknownUser().getUsername());
		assertFalse(containsDocumentItemsListDocumentWithTitle(documents, documentTitle0));
		assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle1));
		assertTrue(containsDocumentItemsListDocumentWithTitle(documents, documentTitle2));

		assertTrue(documentDb.deleteDocument(documentDb.getDocumentItem(documentTitle1, rootRoomId).getId()));
		documentCount--;
		assertTrue(documentDb.deleteDocument(documentId));
		documentCount--;

		// Any user is ok since we are looking for documents that can't be
		// hidden
		documents = documentDb.getVisibleFileItemsInFolderAccessibleForUser(rootRoomItem,
				User.getUnknownUser().getUsername());

		assertFalse(containsDocumentItemsListDocumentWithTitle(documents, documentTitle1));
		assertFalse(containsDocumentItemsListDocumentWithTitle(documents, documentTitle2));

		assertEquals(documentCount, documentDb.getDocumentCount());
	}

	@Test
	public void testFolderOperations() throws IOException {
		String author1 = getUserDeleteOldIfExists("Autor 1").getUsername();

		FileTitle folderName = new FileTitle("testFolder1");
		if (!documentDb.existsFolderWithTitleInParentFolder(folderName, rootRoomId)) {
			documentDb.createNewFolder(folderName, rootRoomId, author1);
		}
		assertTrue(documentDb.existsFolderWithTitleInParentFolder(folderName, rootRoomId));

		FolderItem folderItem = documentDb.getFolderItemWithTitleInParentFolder(folderName, rootRoomId);
		assertEquals(documentDb.getParentFolder(folderItem), rootRoomItem);

		FileTitle folderName2 = new FileTitle("testFolder2");
		if (!documentDb.existsFolderWithTitleInParentFolder(folderName2, folderItem.getId())) {
			documentDb.createNewFolder(folderName2, folderItem.getId(), author1);
		}
		assertTrue(documentDb.existsFolderWithTitleInParentFolder(folderName2, folderItem.getId()));

		FolderItem folderItem2 = documentDb.getFolderItemWithTitleInParentFolder(folderName2, folderItem.getId());

		assertEquals(documentDb.getParentFolder(folderItem2), folderItem);

		documentDb.moveFolder(folderItem2.getId(), rootRoomId);
		assertEquals(documentDb.getParentFolder(folderItem2), rootRoomItem);
		assertTrue(documentDb.existsFolderWithTitleInParentFolder(folderName, rootRoomId));
		assertTrue(documentDb.existsFolderWithTitleInParentFolder(folderName2, rootRoomId));
	}

	@Test
	public void testHiddenRooms() {
		User additionalOwner = getUserDeleteOldIfExists("additionalOwner");

		List<String> ownerList = Arrays.asList(new String[] { additionalOwner.getUsername() });
		RoomItem additionalOwnerRoom = createRoomItemDeleteOldIfExists("additionalOwnerRoom", ownerList, ownerList,
				RoomPolicy.INDIVIDUAL_CONTENT);
		Id additionalOwnerRoomId = additionalOwnerRoom.getId();

		List<String> room2Users = Arrays.asList(new String[] { User.getUnknownUser().getUsername() });
		RoomItem additionalOwnerRoomWithUnknownUser = createRoomItemDeleteOldIfExists(
				"additionalOwnerRoomWithUnknownUser", room2Users, ownerList, RoomPolicy.COLLECTIVE_CONTENT);
		Id room2Id = additionalOwnerRoomWithUnknownUser.getId();

		List<FileItem> filesVisibleForUnknown = documentDb.getVisibleFileItemsInFolderAccessibleForUser(rootRoomItem,
				User.getUnknownUser().getUsername());
		List<FileItem> filesVisibleForAdditional = documentDb.getVisibleFileItemsInFolderAccessibleForUser(rootRoomItem,
				additionalOwner.getUsername());

		assertFalse(filesVisibleForUnknown.contains(additionalOwnerRoom));
		assertTrue(filesVisibleForUnknown.contains(additionalOwnerRoomWithUnknownUser));
		assertTrue(filesVisibleForAdditional.contains(additionalOwnerRoom));
		assertTrue(filesVisibleForAdditional.contains(additionalOwnerRoomWithUnknownUser));

		assertTrue(filesVisibleForAdditional.contains(additionalOwnerRoomWithUnknownUser));
		assertTrue(filesVisibleForUnknown.contains(additionalOwnerRoomWithUnknownUser));

		assertTrue(documentDb.deleteRoom(additionalOwnerRoomId));
		assertFalse(documentDb.existsRoom(additionalOwnerRoomId));
		assertFalse(documentDb.existsFolder(additionalOwnerRoomId));

		assertTrue(documentDb.deleteRoom(room2Id));
		assertFalse(documentDb.existsRoom(room2Id));
		assertFalse(documentDb.existsFolder(room2Id));
	}

	@Test
	public void testRoomMapping() {
		String author1 = getUserDeleteOldIfExists("Autor 1").getUsername();
		String additionalOwner = getUserDeleteOldIfExists("additionalOwner").getUsername();

		List<String> roomUsers = Arrays.asList(new String[] { User.getUnknownUser().getUsername() });
		List<String> roomOwners = Arrays.asList(new String[] { author1, additionalOwner });

		RoomItem roomItem = createRoomItemDeleteOldIfExists("roomTestFolder", roomUsers, roomOwners,
				RoomPolicy.SHARED_CONTENT);
		assertTrue(documentDb.isRoom(roomItem));

		Id roomId = roomItem.getId();

		assertEquals(RoomPolicy.SHARED_CONTENT, roomItem.getRoomPolicy());

		ArrayList<String> roomAdmins = new ArrayList<String>();
		for (String user : roomItem.getRoomAdmins()) {
			roomAdmins.add(user);
		}

		ArrayList<String> roomUsernames = new ArrayList<String>();
		for (String user : roomItem.getRoomUsers()) {
			roomUsernames.add(user);
		}

		for (String username : roomOwners) {
			assertTrue(roomAdmins.contains(username));
			;
		}

		for (String username : roomUsers) {
			assertTrue(roomUsernames.contains(username));
		}

		assertEquals(roomOwners.size(), roomItem.getRoomAdmins().size());
		assertEquals(roomUsers.size(), roomItem.getRoomUsers().size());

		assertTrue(roomItem.isResponsible(additionalOwner));
		assertTrue(roomItem.isResponsible(author1));
		assertFalse(roomItem.isResponsible(User.getUnknownUser().getUsername()));

		FileTitle folderName1 = new FileTitle("folderInRoom1");
		if (!documentDb.existsFolderWithTitleInParentFolder(folderName1, rootRoomId)) {
			documentDb.createNewFolder(folderName1, roomId, author1);
		}
		FolderItem folderInRoom1 = documentDb.getFolderItemWithTitleInParentFolder(folderName1, roomId);
		Id folderInRoom1Id = folderInRoom1.getId();

		FileTitle folderName2 = new FileTitle("folderInRoom2");
		if (!documentDb.existsFolderWithTitleInParentFolder(folderName2, folderInRoom1Id)) {
			documentDb.createNewFolder(folderName2, folderInRoom1Id, author1);
		}
		FolderItem folderInRoom2 = documentDb.getFolderItemWithTitleInParentFolder(folderName2, folderInRoom1Id);

		assertEquals(roomItem, documentDb.getRoomForFileItem(folderInRoom1));
		assertEquals(roomItem, documentDb.getRoomForFileItem(folderInRoom2));

		documentDb.deleteRoom(roomId);
		assertFalse(documentDb.existsRoom(roomId));
		assertFalse(documentDb.existsFolder(roomId));
	}

	@Test
	public void testGetFilePath() {
		String author = getUserDeleteOldIfExists("Autor 1").getUsername();

		FileTitle level1FileTitle = new FileTitle("level1");
		if (documentDb.existsFolderWithTitleInParentFolder(level1FileTitle, rootRoomId)) {
			documentDb
					.deleteFolder(documentDb.getFolderItemWithTitleInParentFolder(level1FileTitle, rootRoomId).getId());
		}
		documentDb.createNewFolder(level1FileTitle, rootRoomId, author);

		FolderItem folderItemLevel1 = documentDb.getFolderItemWithTitleInParentFolder(level1FileTitle, rootRoomId);
		Id folderLevel1Id = folderItemLevel1.getId();

		FileTitle level2FileTitle = new FileTitle("level2");
		if (documentDb.existsFolderWithTitleInParentFolder(level2FileTitle, folderLevel1Id)) {
			documentDb.deleteFolder(
					documentDb.getFolderItemWithTitleInParentFolder(level2FileTitle, folderLevel1Id).getId());
		}
		documentDb.createNewFolder(level2FileTitle, folderLevel1Id, author);

		FolderItem folderItemLevel2 = documentDb.getFolderItemWithTitleInParentFolder(level2FileTitle, folderLevel1Id);
		Id folderLevel2Id = folderItemLevel2.getId();

		FileTitle level3FileTitle = new FileTitle("level3");
		if (documentDb.existsFolderWithTitleInParentFolder(level3FileTitle, folderLevel2Id)) {
			documentDb.deleteFolder(
					documentDb.getFolderItemWithTitleInParentFolder(level3FileTitle, folderLevel2Id).getId());
		}
		documentDb.createNewFolder(level3FileTitle, folderLevel2Id, author);

		FolderItem folderItemLevel3 = documentDb.getFolderItemWithTitleInParentFolder(level3FileTitle, folderLevel2Id);

		List<FolderItem> filePath = documentDb.getFilePath(folderItemLevel3);

		assertEquals(3, filePath.size());
		assertEquals(rootRoomItem, filePath.get(0));
		assertEquals(folderItemLevel1, filePath.get(1));
		assertEquals(folderItemLevel2, filePath.get(2));

		filePath = documentDb.getFilePath(folderItemLevel2);

		assertEquals(2, filePath.size());
		assertEquals(rootRoomItem, filePath.get(0));
		assertEquals(folderItemLevel1, filePath.get(1));

		filePath = documentDb.getFilePath(folderItemLevel1);

		assertEquals(1, filePath.size());
		assertEquals(rootRoomItem, filePath.get(0));

		filePath = documentDb.getFilePath(rootRoomItem);

		assertEquals(0, filePath.size());
	}

	@Test
	public void testRecycleBinMapping() {
		User author1 = getUserDeleteOldIfExists("Autor 1");
		List<String> roomUsers = new ArrayList<String>();
		roomUsers.add(author1.getUsername());

		FileTitle recycleBinRoomTitle = new FileTitle("RecycleBinRoom");
		if (documentDb.existsRoomWithTitle(recycleBinRoomTitle)) {
			RoomItem roomItem = (RoomItem) documentDb.getFolderItemWithTitleInParentFolder(recycleBinRoomTitle,
					RoomItem.ROOT_FOLDER_ID);
			documentDb.deleteRoom(roomItem.getId());
		}
		Id roomId = documentDb.createNewRoomEntry(recycleBinRoomTitle, roomUsers, roomUsers,
				RoomPolicy.INDIVIDUAL_CONTENT, true, null);
		RoomItem roomItem = (RoomItem) documentDb.getFolderItem(roomId);
		assertFalse(roomItem.hasRecycleBinItem());

		Id recycleBinId = documentDb.createRecycleBinForRoom(roomId);
		FolderItem recycleBinFolderItem = documentDb.getFolderItem(recycleBinId);
		assertTrue(recycleBinFolderItem instanceof RecycleBinItem);
		RecycleBinItem recycleBinItem = (RecycleBinItem) recycleBinFolderItem;
		assertTrue(documentDb.isRecycleBin(recycleBinItem));

		assertTrue(documentDb.deleteRecycleBin(recycleBinId));
		assertFalse(documentDb.existsRecycleBin(recycleBinId));
	}

	@Test
	public void testGetFolderAndDocumentItemsForUser() {
		String user = getUserDeleteOldIfExists("Doc-Db-Test-User").getUsername();

		assertTrue(documentDb.getFolderItemsForUser(user).isEmpty());
		assertTrue(documentDb.getDocumentItemsForUser(user).isEmpty());

		List<String> userList = Arrays.asList(new String[] { user });

		RoomItem room = createRoomItemDeleteOldIfExists("DocumentTestRoom", userList, userList,
				RoomPolicy.INDIVIDUAL_CONTENT);
		FolderItem folderForRoom = createFolderItemDeleteOldIfExists(user, "TestFolder", room.getId());
		FileTitle fileTitle = new FileTitle("DocTitle");

		DocumentItem documentItem = documentDb.createDocument(fileTitle, user);
		documentDb.saveDocument(documentItem.getId(), fileTitle, "Das ist ein Test", user, room.getId());

		List<DocumentItem> docList = documentDb.getDocumentItemsForUser(user);
		assertEquals(1, docList.size());
		assertEquals(fileTitle, docList.get(0).getFileTitle());

		List<FolderItem> folderList = documentDb.getFolderItemsForUser(user);
		assertEquals(3, folderList.size());// Room, Recyclebin and Folder

		assertTrue(folderList.contains(folderForRoom));
		assertTrue(folderList.contains(room));
	}

	@Test
	public void testGetParentFolder() {
		String owner = getUserDeleteOldIfExists("parentFolderTest").getUsername();
		List<String> userList = Arrays.asList(new String[] { owner });
		FileTitle fileTitle = new FileTitle("parentFolderTest");

		RoomItem roomItem = createRoomItemDeleteOldIfExists("DocumentTestRoom", userList, userList,
				RoomPolicy.SHARED_CONTENT);

		DocumentItem documentItem1 = documentDb.createDocument(fileTitle, owner);
		documentDb.saveDocument(documentItem1.getId(), fileTitle, "Das Dokument ist inhaltsleer", owner,
				roomItem.getId());

		DocumentItem documentItem = documentDb.getDocumentItem(fileTitle, roomItem.getId());
		assertTrue(documentDb.getParentFolder(documentItem).equals(roomItem));
	}

	@Test
	public void testFindDocumentByTitleLike() {
		String owner = getUserDeleteOldIfExists("findDocumentByTitleLikeTest").getUsername();
		List<String> userList = Arrays.asList(new String[] { owner });
		FileTitle fileTitle = new FileTitle("findDocumentByTitleLikeTest");
		RoomItem roomItem = createRoomItemDeleteOldIfExists("DocumentTestRoom", userList, userList,
				RoomPolicy.SHARED_CONTENT);
		DocumentItem documentItem1 = documentDb.createDocument(fileTitle, owner);
		documentDb.saveDocument(documentItem1.getId(), fileTitle, "Das Dokument ist inhaltsleer", owner,
				roomItem.getId());

		DocumentItem documentItem = documentDb.getDocumentItem(fileTitle, roomItem.getId());
		List<DocumentItem> findDocumentByTitleLike = documentDb.findDocumentByTitleLike("yTitleLi");
		assertTrue(findDocumentByTitleLike.contains(documentItem));
	}

	private boolean containsDocumentItemsListDocumentWithTitle(List<FileItem> fileItems, FileTitle title) {
		boolean result = false;
		for (FileItem documentItem : fileItems) {
			result |= documentItem.getFileTitle().equals(title);
		}
		return result;
	}

	private User getUserDeleteOldIfExists(String username) {
		assert username != null : "Precondition failed: username != null";

		if (userDb.existsUsername(username)) {
			List<DocumentItem> documentItemsForUser = documentDb.getDocumentItemsForUser(username);
			for (DocumentItem documentItem : documentItemsForUser) {
				documentDb.deleteDocument(documentItem.getId());
			}

			List<FolderItem> folderItemsForUser = documentDb.getFolderItemsForUser(username);
			for (FolderItem folderItem : folderItemsForUser) {
				// double check if folder still exists, because it could have
				// been deleted if it's parent was deleted
				if (documentDb.existsFolder(folderItem.getId())) {
					documentDb.deleteFolder(folderItem.getId());
				}
			}
		}
		assertTrue(userDb.saveUser(new User(username, "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
				PasswordHashUtil.hash("TestPasswort")));
		assertTrue(userDb.existsUsername(username));

		return userDb.getUser(username);
	}

	private FolderItem createFolderItemDeleteOldIfExists(String owner, String folderTitleString, Id parentFolderId) {
		assert owner != null : "Precondition failed: owner != null";
		assert folderTitleString != null : "Precondition failed: folderTitleString != null";
		assert parentFolderId != null : "Precondition failed: parentFolderId != null";

		FileTitle folderTitle = new FileTitle(folderTitleString);
		if (documentDb.existsFolderWithTitleInParentFolder(folderTitle, parentFolderId)) {
			assertTrue(documentDb.deleteFolder(
					documentDb.getFolderItemWithTitleInParentFolder(folderTitle, parentFolderId).getId()));
		}
		assertFalse(documentDb.existsFolderWithTitleInParentFolder(folderTitle, parentFolderId));
		documentDb.createNewFolder(folderTitle, parentFolderId, owner);
		assertTrue(documentDb.existsFolderWithTitleInParentFolder(folderTitle, parentFolderId));

		return documentDb.getFolderItemWithTitleInParentFolder(folderTitle, parentFolderId);
	}

	private RoomItem createRoomItemDeleteOldIfExists(String roomTitleString, List<String> roomUsers,
			List<String> roomOwners, RoomPolicy roomPolicy) {
		assert roomTitleString != null : "Precondition failed: roomTitleString != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomOwners != null : "Precondition failed: roomOwners != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";

		FileTitle roomTitle = new FileTitle(roomTitleString);
		if (documentDb.existsRoomWithTitle(roomTitle)) {
			documentDb.deleteRoom(documentDb.getFolderItemWithTitleInParentFolder(roomTitle, rootRoomId).getId());
		}

		if (documentDb.existsFolderWithTitleInParentFolder(roomTitle, rootRoomId)) {
			documentDb.deleteFolder(documentDb.getFolderItemWithTitleInParentFolder(roomTitle, rootRoomId).getId());
		}

		Id newRoomId = documentDb.createNewRoomWithRecycleBin(roomTitle, roomOwners, roomUsers, roomPolicy, true, null);
		RoomItem roomItem = (RoomItem) documentDb.getFolderItem(newRoomId);
		return roomItem;
	}

	private void assertNotExistsDocument(String documentTitleString, Id folderId) {
		assert documentTitleString != null : "Precondition failed: documentTitleString != null";
		assert folderId != null : "Precondition failed: folderId != null";

		FileTitle documentTitle = new FileTitle(documentTitleString);

		if (documentDb.existsDocumentTitleInFolder(documentTitle, folderId)) {
			documentDb.deleteDocument(documentDb.getDocumentItem(documentTitle, folderId).getId());
		}

		assertFalse(documentDb.existsDocumentTitleInFolder(documentTitle, folderId));
	}
}
