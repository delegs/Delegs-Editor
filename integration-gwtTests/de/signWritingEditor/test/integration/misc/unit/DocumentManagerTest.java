package de.signWritingEditor.test.integration.misc.unit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManager;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManager.DocumentManagerListener;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.infrastructure.FontSizeServiceMock;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.FolderContentAndPath;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.test.integration.misc.unit.infrastructure.DocumentManagerListenerMock;

public class DocumentManagerTest extends GWTTestCase {

	private DocumentManager documentManager;
	private StringBuilder calls;

	@Override
	public void gwtSetUp() {
		calls = new StringBuilder();
		RoomItem rootRoom = createDummyRootRoom();
		documentManager = new DocumentManager(createDocumentServiceMock(), new LocalSessionServiceForUnknownUserMock(),
				rootRoom, rootRoom, createNewDummyListener(), new FontSizeServiceMock());
	}

	@Test
	public void testHandleDeleteDocumentsConfirmed() throws Exception {
		getCallsAndReset();

		documentManager.handleDeleteConfirmed(true);
		assertEquals("getNonexistentFileItems", getCallsAndReset());
	}

	public String getCallsAndReset() {
		String result = calls.toString();
		calls = new StringBuilder();
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}

	private RoomItem createDummyRootRoom() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.INDIVIDUAL_CONTENT);
	}

	private DocumentManagerListener createNewDummyListener() {
		return new DocumentManagerListenerMock();
	}

	private DocumentServiceAsync createDocumentServiceMock() {
		DocumentServiceAsync result = new DocumentServiceAsync() {
			@Override
			public void getRootRoomItem(AsyncCallback<RoomItem> callback) {
				countCall("getRootRoomItem");
			}

			@Override
			public void getRoomForFileItem(FileItem fileItem, AsyncCallback<RoomItem> callback) {
				countCall("getRoomForFileItem");
			}

			@Override
			public void getParentRoomForFileItem(FileItem fileItem, AsyncCallback<RoomItem> callback) {
				countCall("getParentRoomForFileItem");
			}

			@Override
			public void getNonexistentFileItems(FileItem[] fileItems, AsyncCallback<Set<FileItem>> callback) {
				countCall("getNonexistentFileItems");
				callback.onSuccess(new HashSet<FileItem>());
			}

			@Override
			public void existsFileItem(FileItem fileItem, AsyncCallback<Boolean> callback) {
				countCall("existsFileItem");
			}

			@Override
			public void existFileItems(FileItem[] fileItems, AsyncCallback<Boolean> callback) {
				countCall("existFileItems");
			}

			private void countCall(String methodName) {
				assert methodName != null : "Precondition failed: methodName != null";
				if (calls.length() > 0) {
					calls.append(" ");
				}
				calls.append(methodName);
			}

			@Override
			public void setColorLabel(FileItemColorLabel newColorLabel, FileItem[] fileItems,
					AsyncCallback<Void> callback) {
			}

			@Override
			public void getParentFolder(FileItem fileItem, AsyncCallback<FolderItem> callback) {

			}

			@Override
			public void getFilePath(FileItem fileItem, AsyncCallback<List<FolderItem>> callback) {
			}

			@Override
			public void changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy, AsyncCallback<Boolean> callback) {
			}

			@Override
			public void getDocumentItem(SessionKey sessionKey, String fileTitle, String[] folderNames,
					AsyncCallback<DocumentItem> callback) {
			}

			@Override
			public void getFolderItem(SessionKey sessionKey, String[] folderNames, AsyncCallback<FolderItem> callback) {
			}

			@Override
			public void getRoomPolicy(String roomName, AsyncCallback<RoomPolicy> signWritingCallback) {
			}

			@Override
			public void getDocumentItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem,
					AsyncCallback<DocumentItem> callback) {

			}

			@Override
			public void loadDocument(SessionKey sessionKey, DocumentItem documentItem,
					AsyncCallback<Document> callback) {

			}

			@Override
			public void saveOrUpdateDocument(SessionKey sessionKey, Document document, FolderItem folderItem,
					AsyncCallback<DocumentItem> callback) {

			}

			@Override
			public void deleteFiles(SessionKey sessionKey, FileItem[] fileItems, AsyncCallback<Void> callback) {

			}

			@Override
			public void moveFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem[] fileItems,
					AsyncCallback<Void> callback) {

			}

			@Override
			public void copyFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem[] fileItems,
					AsyncCallback<FileItem[]> callback) {

			}

			@Override
			public void getFolderContentAndPath(SessionKey sessionKey, FolderItem folderItem,
					AsyncCallback<FolderContentAndPath> callback) {

			}

			@Override
			public void getFolderItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem,
					AsyncCallback<FolderItem> callback) {

			}

			@Override
			public void createNewFolder(SessionKey sessionKey, FileTitle newFolderName, FolderItem folderItem,
					AsyncCallback<Void> callback) {

			}

			@Override
			public void createNewRoom(SessionKey sessionKey, FileTitle name, List<String> owners,
					List<String> roomUsers, RoomPolicy roomPolicy, boolean isHidden, String roomDescription,
					AsyncCallback<Void> callback) {

			}

			@Override
			public void renameFile(SessionKey sessionKey, FileItem fileItem, FileTitle newFileTitle,
					AsyncCallback<Void> callback) {

			}

			@Override
			public void verifyRoomParameters(SessionKey sessionKey, String roomName, List<String> roomOwners,
					List<String> roomUsers, AsyncCallback<Void> callback) {

			}

			@Override
			public void findDocumentsByTitle(SessionKey sessionKey, String searchString,
					AsyncCallback<List<DocumentItem>> callback) {

			}

			@Override
			public void findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString,
					FolderItem currentFolder, AsyncCallback<List<FileItem>> callback) {
			}

			@Override
			public void findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString,
					AsyncCallback<List<DocumentItem>> callback) {
			}

			@Override
			public void setLastClosedDocument(FileTitle fileTitle, Id folderId, AsyncCallback<Void> callback) {
			}

			@Override
			public void getLastClosedDocumentItem(AsyncCallback<DocumentItem> callback) {
			}

		};

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
