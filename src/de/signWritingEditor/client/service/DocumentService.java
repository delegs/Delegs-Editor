package de.signWritingEditor.client.service;

import java.util.List;
import java.util.Set;

import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.DirectoryNotFoundException;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.exceptions.RecursiveDirectoryException;
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

public interface DocumentService {
	DocumentItem getDocumentItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws InvalidSessionException, AccessDeniedException;

	DocumentItem getDocumentItem(SessionKey sessionKey, String fileName, String[] folderNames)
			throws RecursiveDirectoryException, DirectoryNotFoundException, DocumentNotFoundException,
			InvalidSessionException, AccessDeniedException;

	FolderItem getFolderItem(SessionKey sessionKey, String[] folderNames) throws RecursiveDirectoryException,
			DirectoryNotFoundException, InvalidSessionException, AccessDeniedException;

	Document loadDocument(SessionKey sessionKey, DocumentItem documentItem)
			throws InvalidSessionException, AccessDeniedException;

	DocumentItem saveOrUpdateDocument(SessionKey sessionKey, Document document, FolderItem folderItem)
			throws InvalidSessionException, AccessDeniedException;

	void deleteFiles(SessionKey sessionKey, FileItem... fileItems)
			throws InvalidSessionException, AccessDeniedException;

	void moveFiles(SessionKey sessionKey, FolderItem targetFolderItem, FileItem... fileItems)
			throws InvalidSessionException, AccessDeniedException;

	FileItem[] copyFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem... fileItems)
			throws InvalidSessionException, AccessDeniedException;

	FolderContentAndPath getFolderContentAndPath(SessionKey sessionKey, FolderItem folderItem)
			throws InvalidSessionException, AccessDeniedException;

	FolderItem getFolderItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws InvalidSessionException, AccessDeniedException;

	void createNewFolder(SessionKey sessionKey, FileTitle newFolderName, FolderItem folderItem)
			throws InvalidSessionException, AccessDeniedException;

	void createNewRoom(SessionKey sessionKey, FileTitle name, List<String> owners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription)
			throws InvalidSessionException, MissingAuthorizationException, AccessDeniedException;

	void renameFile(SessionKey sessionKey, FileItem fileItem, FileTitle newFileTitle)
			throws InvalidSessionException, AccessDeniedException;

	void setColorLabel(FileItemColorLabel newColorLabel, FileItem... fileItems);

	boolean existsFileItem(FileItem fileItem);

	boolean existFileItems(FileItem... fileItems);

	Set<FileItem> getNonexistentFileItems(FileItem... fileItems);

	RoomItem getRootRoomItem();

	List<DocumentItem> findDocumentsByTitle(SessionKey sessionKey, String searchString) throws InvalidSessionException;

	List<FolderItem> getFilePath(FileItem fileItem);

	/**
	 * Returns itself if it is a room
	 */
	RoomItem getRoomForFileItem(FileItem fileItem);

	/**
	 * Does not return itself, even if it is a room
	 */
	RoomItem getParentRoomForFileItem(FileItem fileItem);

	FolderItem getParentFolder(final FileItem fileItem);

	boolean changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy);

	RoomPolicy getRoomPolicy(String roomName);

	void verifyRoomParameters(SessionKey sessionKey, String roomName, List<String> roomOwners, List<String> roomUsers)
			throws InvalidSessionException, RoomnameCollisionException, InvalidUsernameException;

	List<FileItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String title, FolderItem currentFolder);

	List<DocumentItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString)
			throws InvalidSessionException;

	void setLastClosedDocument(FileTitle documentTitle, Id currentFolderId);

	DocumentItem getLastClosedDocumentItem();
}