package de.signWritingEditor.server.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.RoomnameCollisionException;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.sessionService.SystemSessionService;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.DirectoryNotFoundException;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
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
import de.signWritingEditor.shared.model.material.User;

public class DocumentServiceImpl implements SystemDocumentService {

	private static final Id COPY_CACHE_FOLDER_ID = new Id(0, 3);
	private UserDb userDb;
	private DocumentDb documentDb;
	private final DocumentXMLConverter xmlConverter;
	private final SystemSessionService sessionService;
	private DocumentItem lastClosedDocumentItem;

	public DocumentServiceImpl(SystemSessionService sessionService, DocumentDb documentDb, UserDb userDb,
			DocumentXMLConverter xmlConverter) {
		assert sessionService != null : "Precondition failed: sessionService != null";
		assert documentDb != null : "Precondition failed: documentDb != null";
		assert userDb != null : "Precondition failed: userDb != null";
		assert xmlConverter != null : "xmlConverter != null";

		this.sessionService = sessionService;
		this.documentDb = documentDb;
		this.userDb = userDb;
		this.xmlConverter = xmlConverter;
	}

	@Override
	public void deleteFiles(SessionKey sessionKey, FileItem... fileItems) throws InvalidSessionException {
		assert fileItems != null : "fileItems != null";
		assert sessionKey != null : "Precondition failed sessionKey != null";
		assert isFileModificationInParentRoomPermitted(sessionService.getUser(sessionKey),
				fileItems) : "isFileModificationInParentRoomPermitted(user, fileItems)";

		for (FileItem fileItem : fileItems) {
			Id fileId = fileItem.getId();

			if (fileItem instanceof DocumentItem) {
				documentDb.deleteDocument(fileId);
			} else {
				documentDb.deleteFolder(fileId);
			}
		}
	}

	private boolean isFileModificationInParentRoomPermitted(User user, FileItem... fileItems) {
		for (FileItem fileItem : fileItems) {
			if (!getParentRoomForFileItem(fileItem).isModifyFilePermitted(user.getUsername(), fileItem)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void moveFiles(SessionKey sessionKey, FolderItem targetFolderItem, FileItem... fileItems)
			throws InvalidSessionException {
		assert targetFolderItem != null : "Precondition failed: newFolderItem != null";
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";
		assert isFileModificationInParentRoomPermitted(sessionService.getUser(sessionKey),
				fileItems) : "isFileModificationInParentRoomPermitted(user, fileItems)";

		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof DocumentItem) {
				documentDb.moveDocument(fileItem, targetFolderItem.getId());
			} else {
				FolderItem folderItem = (FolderItem) fileItem;
				// Do not allow to move a folder into itself
				assert !folderItem.equals(targetFolderItem) : "Precondition failed: !folderItem.equals(newFolderItem)";
				assert !isSubFolder(targetFolderItem,
						folderItem) : "Precondition failed: !isSubFolder(newFolderItem, folderItem)";
				// For server side where assertions might not be enabled
				if (isSubFolder(targetFolderItem, folderItem) || folderItem.equals(targetFolderItem)) {
					throw new RuntimeException(I18N.getCantMoveFolderIntoItself());
				}
				documentDb.moveFolder(folderItem.getId(), targetFolderItem.getId());
			}
		}
	}

	private boolean isSubFolder(FolderItem folderItem, FolderItem potentialParentFolder) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert potentialParentFolder != null : "Precondition failed: potentialParentFolder != null";

		return getFilePath(folderItem).contains(potentialParentFolder);
	}

	@Override
	public FileItem[] copyFiles(SessionKey sessionKey, FolderItem parentFolderItem, FileItem... fileItems)
			throws InvalidSessionException {
		assert parentFolderItem != null : "Precondition failed: parentFolderItem != null";
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";
		assert getRoomForFileItem(parentFolderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(parentFolderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";

		User user = sessionService.getUser(sessionKey);
		String username = user.getUsername();
		if (user.isUnknown()) {
			username += sessionKey;
		}

		FolderItem copyCacheFolder = prepareCopyCacheFolder(username);

		for (FileItem fileItem : fileItems) {

			if (fileItem instanceof DocumentItem) {
				String documentContent = documentDb.getDocumentContent(fileItem.getId());

				// rename name attribute in Content to new FileTitle
				Document oldContent = xmlConverter.fromXML(documentContent, user);
				oldContent.setDocumentTitle(fileItem.getFileTitle());

				DocumentItem documentItem = documentDb.createDocument(fileItem.getFileTitle(), user.getUsername());
				documentDb.saveDocument(documentItem.getId(), documentItem.getFileTitle(),
						xmlConverter.toXML(oldContent), documentItem.getOwner(), copyCacheFolder.getId());
			} else if (fileItem instanceof FolderItem) {
				copyFolderContent(copyCacheFolder, (FolderItem) fileItem);
			}
		}

		List<FileItem> newFileItems = documentDb.getVisibleFileItemsInFolderAccessibleForUser(copyCacheFolder,
				user.getUsername());

		updateOwnerOfFiles(user, newFileItems);
		FileItem[] newFileItemsArray = new FileItem[newFileItems.size()];
		newFileItems.toArray(newFileItemsArray);

		moveFiles(sessionKey, parentFolderItem, newFileItemsArray);

		documentDb.deleteFolder(copyCacheFolder.getId());

		return newFileItemsArray;
	}

	private FolderItem prepareCopyCacheFolder(String username) {
		FolderItem systemCopyCacheFolder = documentDb.getFolderItem(COPY_CACHE_FOLDER_ID);
		deleteCopyCacheFolder(username, systemCopyCacheFolder);

		return createCopyCacheFolder(username, systemCopyCacheFolder);
	}

	private FolderItem createCopyCacheFolder(String username, FolderItem systemCopyCacheFolder) {
		documentDb.createNewFolder(new FileTitle(username), systemCopyCacheFolder.getId(),
				User.getSystemUser().getUsername());

		FolderItem cacheFolder = documentDb.getFolderItemWithTitleInParentFolder(new FileTitle(username),
				systemCopyCacheFolder.getId());
		return cacheFolder;
	}

	private void deleteCopyCacheFolder(String username, FolderItem systemCopyCacheFolder) {
		List<FileItem> copyCacheContent = documentDb.getVisibleFileItemsInFolderAccessibleForUser(systemCopyCacheFolder,
				User.getSystemUser().getUsername());

		for (FileItem item : copyCacheContent) {
			if (item instanceof FolderItem && item.getFileTitle().getTitleString() == username) {
				documentDb.deleteFolder(item.getId());
			}
		}
	}

	private void updateOwnerOfFiles(User user, Collection<FileItem> newFileItemsArray) {

		for (FileItem fileItem : newFileItemsArray) {

			if (fileItem instanceof DocumentItem) {
				String documentContent = documentDb.getDocumentContent(fileItem.getId());
				documentDb.updateDocument(fileItem.getId(), fileItem.getFileTitle(), documentContent,
						user.getUsername(), fileItem.getColorLabel());
			} else if (fileItem instanceof FolderItem) {
				documentDb.updateFolder(fileItem.getId(), fileItem.getFileTitle(), user.getUsername(),
						fileItem.getColorLabel());
				updateOwnerOfFiles(user, documentDb.getVisibleFileItemsInFolderAccessibleForUser((FolderItem) fileItem,
						User.getSystemUser().getUsername()));
			}
		}

	}

	private void copyFolderContent(FolderItem parentFolderItem, FolderItem folderItem) throws InvalidSessionException {

		User systemUser = sessionService.getSystemUserSession().getUser();

		List<FileItem> fileItems = documentDb.getVisibleFileItemsInFolderAccessibleForUser(folderItem,
				systemUser.getUsername());

		createNewFolder(sessionService.getSystemUserSession().getSessionKey(), folderItem.getFileTitle(),
				parentFolderItem);

		FolderItem subFolder = documentDb.getFolderItemWithTitleInParentFolder(folderItem.getFileTitle(),
				parentFolderItem.getId());

		for (FileItem fileItem : fileItems) {

			if (fileItem instanceof DocumentItem) {
				String documentContent = documentDb.getDocumentContent(fileItem.getId());
				DocumentItem documentItem = documentDb.createDocument(fileItem.getFileTitle(),
						systemUser.getUsername());
				documentDb.saveDocument(documentItem.getId(), documentItem.getFileTitle(), documentContent,
						documentItem.getOwner(), subFolder.getId());
			} else if (fileItem instanceof FolderItem) {
				copyFolderContent(subFolder, (FolderItem) fileItem);
			}
		}
	}

	@Override
	public boolean existsDocumentTitle(SessionKey sessionKey, FileTitle documentTitle, FolderItem folderItem)
			throws InvalidSessionException {
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		return documentDb.existsDocumentTitleInFolder(documentTitle, folderItem.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gebaerden.signWritingEditor.server.service.DocumentService# loadDocument (java.lang.String)
	 */
	@Override
	public Document loadDocument(SessionKey sessionKey, DocumentItem documentItem) throws InvalidSessionException {
		assert documentItem != null : "Precondition failed: documentItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert getRoomForFileItem(documentItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(documentItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";

		return existsFileItem(documentItem)
				? xmlConverter.fromXML(documentDb.getDocumentContent(documentItem.getId()),
						userDb.getUser(documentItem.getOwner()))
				: null;
	}

	@Override
	public DocumentItem saveOrUpdateDocument(SessionKey sessionKey, Document document, FolderItem folderItem)
			throws InvalidSessionException {
		assert document != null : "Precondition failed: document != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert sessionService
				.getUser(sessionKey) != null : "Precondition failed: sessionService.getUser(sessionKey) != null";
		assert !existsDocumentTitle(sessionKey, document.getDocumentTitle(), folderItem)
				|| getRoomForFileItem(getDocumentItem(sessionKey, document.getDocumentTitle(), folderItem))
						.isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(), getDocumentItem(
								sessionKey, document.getDocumentTitle(),
								folderItem)) : "Precondition failed:!existsDocumentTitle(document.getDocumentTitle(), folderItem, userSession) || getRoomForFileItem(getDocumentItem(document.getDocumentTitle(), folderItem, userSession.getUser())).isModifyFilePermitted(userSession.getUser(), getDocumentItem(document.getDocumentTitle(), folderItem, userSession))";
		assert existsDocumentTitle(sessionKey, document.getDocumentTitle(), folderItem)
				|| getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
						.getUsername()) : "Precondition failed: existsDocumentTitle(document.getDocumentTitle(), folderItem, userSession) || getRoomForFileItem(folderItem).isRoomAccessPermitted(userSession.getUser())";
		assert userDb
				.existsUserWithName(document.getAuthor()) : "Precondition failed: userDb.exists(document.getAuthor())";

		User author = document.getAuthor();
		FileTitle documentTitle = document.getDocumentTitle();
		Id parentFolderId = folderItem.getId();

		String content = xmlConverter.toXML(document);

		if (existsDocumentTitle(sessionKey, documentTitle, folderItem)) {
			DocumentItem documentItem = documentDb.getDocumentItem(documentTitle, parentFolderId);
			documentDb.updateDocument(documentItem.getId(), documentTitle, content, author.getUsername(),
					documentItem.getColorLabel());
		} else {
			DocumentItem documentItem = documentDb.createDocument(documentTitle, author.getUsername());
			documentDb.saveDocument(documentItem.getId(), documentItem.getFileTitle(), content, documentItem.getOwner(),
					parentFolderId);
		}

		DocumentItem result = documentDb.getDocumentItem(documentTitle, parentFolderId);

		assert existsDocumentTitle(sessionKey, documentTitle,
				folderItem) : "Postcondition failed: existsDocumentTitle(documentTitle, folderItem, user)";
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public FolderContentAndPath getFolderContentAndPath(SessionKey sessionKey, FolderItem folderItem)
			throws InvalidSessionException {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())";
		User user = sessionService.getUser(sessionKey);

		return new FolderContentAndPath(documentDb.getFilePath(folderItem),
				documentDb.getVisibleFileItemsInFolderAccessibleForUser(folderItem, user.getUsername()));
	}

	@Override
	public void createNewFolder(SessionKey sessionKey, FileTitle newFolderName, FolderItem folderItem)
			throws InvalidSessionException {
		assert newFolderName != null : "Precondition failed: newFolderName != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";
		assert !existsFolderTitle(sessionKey, newFolderName,
				folderItem) : "Precondition failed: !existsFolderTitle(sessionKey, newFolderName, folderItem)";

		User user = sessionService.getUser(sessionKey);
		documentDb.createNewFolder(newFolderName, folderItem.getId(), user.getUsername());

		assert existsFolderTitle(sessionKey, newFolderName,
				folderItem) : "Postcondition failed: existsFolderTitle(newFolderName, folderItem, user)";
	}

	@Override
	public boolean existsFolderTitle(SessionKey sessionKey, FileTitle folderName, FolderItem folderItem)
			throws InvalidSessionException {
		assert folderName != null : "Precondition failed: folderName != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";

		return documentDb.existsFolderWithTitleInParentFolder(folderName, folderItem.getId());
	}

	@Override
	public RoomItem getRootRoomItem() {
		return documentDb.getRootRoomItem();
	}

	@Override
	public boolean existsFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		return documentDb.existsFileItem(fileItem);
	}

	@Override
	public DocumentItem getDocumentItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws InvalidSessionException {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";
		assert existsDocumentTitle(sessionKey, fileTitle,
				folderItem) : "Precondition failed: existsDocumentTitle(sessionKey, fileTitle, folderItem)";

		return documentDb.getDocumentItem(fileTitle, folderItem.getId());
	}

	@Override
	public FolderItem getFolderItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws InvalidSessionException {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey)
				.getUsername()) : "Precondition failed: getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey))";
		assert existsFolderTitle(sessionKey, fileTitle,
				folderItem) : "Precondition failed: existsFolderTitle(sessionKey, fileTitle, folderItem)";

		return documentDb.getFolderItemWithTitleInParentFolder(fileTitle, folderItem.getId());
	}

	@Override
	public void renameFile(SessionKey sessionKey, FileItem fileItem, FileTitle newFileTitle)
			throws InvalidSessionException {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert newFileTitle != null : "Precondition failed: newFileTitle != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existsFileItem(fileItem) : "Precondition failed: existsFileItem(fileItem)";
		assert getRoomForFileItem(fileItem).isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(),
				fileItem) : "Precondition failed: getRoomForFileItem(fileItem).isModifyFilePermitted(sessionService.getUser(sessionKey), fileItem)";

		Id fileId = fileItem.getId();
		User fileOwner = userDb.getUser(fileItem.getOwner());
		FileItemColorLabel colorLabel = fileItem.getColorLabel();

		if (fileItem instanceof DocumentItem) {
			// Update title inside document:
			String oldContent = documentDb.getDocumentContent(fileItem.getId());
			Document document = xmlConverter.fromXML(oldContent, fileOwner);
			document.setDocumentTitle(newFileTitle);
			String newContent = xmlConverter.toXML(document);

			documentDb.updateDocument(fileId, newFileTitle, newContent, fileOwner.getUsername(), colorLabel);
		} else if (fileItem instanceof FolderItem) {
			documentDb.updateFolder(fileId, newFileTitle, fileOwner.getUsername(), colorLabel);
		}
	}

	@Override
	public RoomItem getRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		RoomItem result;
		FileItem rootFolderFileItem = getRootRoomItem();
		if (fileItem.equals(rootFolderFileItem)) {

			assert rootFolderFileItem instanceof RoomItem : "Root folder must be a room";
			result = (RoomItem) rootFolderFileItem;
		} else {
			result = documentDb.getRoomForFileItem(fileItem);
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public RoomItem getParentRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		RoomItem result = documentDb.getParentRoomForFileItem(fileItem);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public void verifyRoomParameters(SessionKey sessionKey, String roomName, List<String> roomOwners,
			List<String> roomUsers) throws RoomnameCollisionException, InvalidSessionException {
		User user = sessionService.getUser(sessionKey);
		boolean doesRoomNameExist = documentDb.existsRoomNameForUser(roomName, user.getUsername());
		if (doesRoomNameExist) {
			throw new RoomnameCollisionException();
		}
	}

	@Override
	public Set<FileItem> getNonexistentFileItems(FileItem... fileItems) {
		assert fileItems != null : "Precondition failed: fileItems != null";

		HashSet<FileItem> result = new HashSet<FileItem>();
		for (FileItem fileItem : fileItems) {
			if (!existsFileItem(fileItem)) {
				result.add(fileItem);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public boolean existFileItems(FileItem... fileItems) {
		assert fileItems != null : "Precondition failed: fileItems != null";

		return getNonexistentFileItems(fileItems).isEmpty();
	}

	@Override
	public void createNewRoom(SessionKey sessionKey, FileTitle fileTitle, List<String> owners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription) throws InvalidSessionException {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert owners != null : "Precondition failed: owners != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert !owners.isEmpty() : "Precondition failed: !owners.isEmpty()";
		assert !sessionService.getUser(sessionKey)
				.isUnknown() : "Precondition failed: !sessionService.getUser(sessionKey).isUnknown()";

		documentDb.createNewRoomWithRecycleBin(fileTitle, owners, roomUsers, roomPolicy, isHidden, roomDescription);
	}

	@Override
	public void setColorLabel(FileItemColorLabel newColorLabel, FileItem... fileItems) {
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";

		for (FileItem fileItem : fileItems) {
			Id fileId = fileItem.getId();
			String fileOwnerName = fileItem.getOwner();
			FileTitle fileTitle = fileItem.getFileTitle();

			if (fileItem instanceof DocumentItem) {
				documentDb.updateDocument(fileId, fileTitle, documentDb.getDocumentContent(fileItem.getId()),
						fileOwnerName, newColorLabel);
			} else if (fileItem instanceof FolderItem) {
				documentDb.updateFolder(fileId, fileTitle, fileOwnerName, newColorLabel);
			}
		}
	}

	@Override
	public List<DocumentItem> findDocumentsByTitle(SessionKey sessionKey, String searchString)
			throws InvalidSessionException {
		assert searchString != null : "Precondition failed: searchString != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		List<DocumentItem> result = new ArrayList<DocumentItem>();

		List<DocumentItem> items = documentDb.findDocumentByTitleLike(searchString);

		User user = sessionService.getUser(sessionKey);
		for (DocumentItem documentItem : items) {
			if (getRoomForFileItem(documentItem).isReadFilePermitted(user.getUsername(), documentItem)) {
				result.add(documentItem);
			}
		}

		return result;
	}

	@Override
	public List<DocumentItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString)
			throws InvalidSessionException {
		assert searchString != null : "Precondition failed: searchString != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		List<DocumentItem> result = new ArrayList<DocumentItem>();

		List<DocumentItem> items = documentDb.findSortedDocumentsByTitleLike(searchString);

		User user = sessionService.getUser(sessionKey);
		for (DocumentItem documentItem : items) {
			if (getRoomForFileItem(documentItem).isReadFilePermitted(user.getUsername(), documentItem)) {
				result.add(documentItem);
			}
		}

		return result;
	}

	@Override
	public FolderItem getParentFolder(final FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert existsFileItem(fileItem) : "Precondition failed: existsFileItem(fileItem)";

		return documentDb.getParentFolder(fileItem);
	}

	@Override
	public List<FolderItem> getFilePath(FileItem fileItem) {
		return documentDb.getFilePath(fileItem);
	}

	@Override
	public boolean changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy) {
		return documentDb.changeRoomPolicy(room, selectedPolicy);
	}

	@Override
	public DocumentItem getDocumentItem(SessionKey sessionKey, String fileName, String[] folderNames)
			throws RecursiveDirectoryException, DirectoryNotFoundException, AccessDeniedException,
			DocumentNotFoundException, InvalidSessionException {
		User user = sessionService.getUser(sessionKey);
		return documentDb.getDocumentItem(fileName, user.getUsername(), folderNames);
	}

	@Override
	public FolderItem getFolderItem(SessionKey sessionKey, String[] folderNames) throws RecursiveDirectoryException,
			DirectoryNotFoundException, AccessDeniedException, InvalidSessionException {
		User user = sessionService.getUser(sessionKey);
		return documentDb.getFolderItem(user.getUsername(), folderNames);
	}

	@Override
	public RoomPolicy getRoomPolicy(String roomName) {
		return documentDb.getRoomPolicy(roomName);
	}

	@Override
	public List<FileItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String title,
			FolderItem currentFolder) {
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert title != null : "Precondition failed: title != null";
		assert currentFolder != null : "Precondition failed: currentFolder != null";

		List<FileItem> result = new ArrayList<>();
		List<FileItem> foundDocuments = new ArrayList<>();
		try {
			foundDocuments.addAll(findSortedDocumentsByTitleLike(sessionKey, title));
		} catch (InvalidSessionException e) {
			e.printStackTrace();
		}

		List<FileItem> itemsInCurrentFolder = new ArrayList<>();
		Map<FolderItem, List<FileItem>> subFoldersToDocuments = new HashMap<FolderItem, List<FileItem>>();
		Map<FolderItem, List<FileItem>> remainingFoldersToDocuments = new HashMap<FolderItem, List<FileItem>>();

		for (FileItem doc : foundDocuments) {
			FolderItem parentFolder = getParentFolder(doc);
			if (parentFolder.equals(currentFolder)) {
				if (!itemsInCurrentFolder.contains(currentFolder)) {
					itemsInCurrentFolder.add(currentFolder);
				}
				itemsInCurrentFolder.add(doc);

			} else if (isSubFolder(parentFolder, currentFolder)) {
				if (!subFoldersToDocuments.containsKey(parentFolder)) {
					subFoldersToDocuments.put(parentFolder, new LinkedList<FileItem>());
				}
				subFoldersToDocuments.get(parentFolder).add(doc);

			} else {
				if (!remainingFoldersToDocuments.containsKey(parentFolder)) {
					remainingFoldersToDocuments.put(parentFolder, new LinkedList<FileItem>());
				}
				remainingFoldersToDocuments.get(parentFolder).add(doc);
			}
		}

		result.addAll(itemsInCurrentFolder);
		addFoldersToResult(result, subFoldersToDocuments);
		addFoldersToResult(result, remainingFoldersToDocuments);

		return result;
	}

	private void addFoldersToResult(List<FileItem> result, Map<FolderItem, List<FileItem>> foldersToDocuments) {
		assert result != null : "Precondition failed: result != null";
		assert foldersToDocuments != null : "Precondition failed: foldersToDocuments != null";

		List<FolderItem> folders = new ArrayList<FolderItem>(foldersToDocuments.keySet());

		folders.sort(new Comparator<FileItem>() {
			@Override
			public int compare(FileItem o1, FileItem o2) {
				List<FolderItem> path1 = getFilePath(o1);
				List<FolderItem> path2 = getFilePath(o2);

				if (path1.size() != path2.size()) {
					return path1.size() < path2.size() ? -1 : 1;
				}

				for (int i = 0; i < path1.size(); i++) {
					String folder1 = path1.get(i).getFileTitle().getTitleString();
					String folder2 = path2.get(i).getFileTitle().getTitleString();

					int comparision = folder1.compareTo(folder2);
					if (comparision != 0) {
						return comparision;
					}
				}

				return 0;
			}
		});

		for (FolderItem folder : folders) {
			result.add(folder);
			result.addAll(foldersToDocuments.get(folder));
		}
	}

	@Override
	public DocumentItem getLastClosedDocumentItem() {
		return lastClosedDocumentItem;
	}

	@Override
	public void setLastClosedDocument(FileTitle documentTitle, Id currentFolderId) {
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert currentFolderId != null : "Precondition failed: currentFolderId != null";

		if (!currentFolderId.equals(documentDb.getRootRoomItem().getId())) {
			if (documentDb.existsDocumentTitleInFolder(documentTitle, currentFolderId)) {
				lastClosedDocumentItem = documentDb.getDocumentItem(documentTitle, currentFolderId);

			} else {
				lastClosedDocumentItem = null;
			}
		} else {
			lastClosedDocumentItem = null;
		}
	}

}
