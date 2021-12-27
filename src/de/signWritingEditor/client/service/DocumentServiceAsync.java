package de.signWritingEditor.client.service;

import java.util.List;
import java.util.Set;

import com.google.gwt.user.client.rpc.AsyncCallback;

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

public interface DocumentServiceAsync {
	void getDocumentItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem,
			AsyncCallback<DocumentItem> callback);

	void getDocumentItem(SessionKey sessionKey, String fileTitle, String[] folderNames,
			AsyncCallback<DocumentItem> callback);

	void getFolderItem(SessionKey sessionKey, String[] folderNames, AsyncCallback<FolderItem> callback);

	void loadDocument(SessionKey sessionKey, DocumentItem documentItem, AsyncCallback<Document> callback);

	void saveOrUpdateDocument(SessionKey sessionKey, Document document, FolderItem folderItem,
			AsyncCallback<DocumentItem> callback);

	void deleteFiles(SessionKey sessionKey, FileItem[] fileItems, AsyncCallback<Void> callback);

	void moveFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem[] fileItems, AsyncCallback<Void> callback);

	void copyFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem[] fileItems,
			AsyncCallback<FileItem[]> callback);

	void getFolderContentAndPath(SessionKey sessionKey, FolderItem folderItem,
			AsyncCallback<FolderContentAndPath> callback);

	void existsFileItem(FileItem fileItem, AsyncCallback<Boolean> callback);

	void existFileItems(FileItem[] fileItems, AsyncCallback<Boolean> callback);

	void getNonexistentFileItems(FileItem[] fileItems, AsyncCallback<Set<FileItem>> callback);

	void getRootRoomItem(AsyncCallback<RoomItem> callback);

	void getFolderItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem,
			AsyncCallback<FolderItem> callback);

	void createNewFolder(SessionKey sessionKey, FileTitle newFolderName, FolderItem folderItem,
			AsyncCallback<Void> callback);

	void createNewRoom(SessionKey sessionKey, FileTitle name, List<String> owners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription, AsyncCallback<Void> callback);

	void renameFile(SessionKey sessionKey, FileItem fileItem, FileTitle newFileTitle, AsyncCallback<Void> callback);

	void setColorLabel(FileItemColorLabel newColorLabel, FileItem[] fileItems, AsyncCallback<Void> callback);

	void getRoomForFileItem(FileItem fileItem, AsyncCallback<RoomItem> callback);

	void getParentRoomForFileItem(FileItem fileItem, AsyncCallback<RoomItem> callback);

	void verifyRoomParameters(SessionKey sessionKey, String roomName, List<String> roomOwners, List<String> roomUsers,
			AsyncCallback<Void> callback);

	void findDocumentsByTitle(SessionKey sessionKey, String searchString, AsyncCallback<List<DocumentItem>> callback);

	void getParentFolder(final FileItem fileItem, AsyncCallback<FolderItem> callback);

	void getFilePath(FileItem fileItem, AsyncCallback<List<FolderItem>> callback);

	void changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy, AsyncCallback<Boolean> callback);

	void getRoomPolicy(String roomName, AsyncCallback<RoomPolicy> callback);

	void findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString, FolderItem currentFolder,
			AsyncCallback<List<FileItem>> callback);

	void findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString,
			AsyncCallback<List<DocumentItem>> callback);

	void setLastClosedDocument(FileTitle fileTitle, Id folderId, AsyncCallback<Void> callback);

	void getLastClosedDocumentItem(AsyncCallback<DocumentItem> callback);

}