package de.signWritingEditor.server.persistence;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.DirectoryNotFoundException;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
import de.signWritingEditor.shared.exceptions.RecursiveDirectoryException;
import de.signWritingEditor.shared.infrastructure.migration.DocumentMetaDaten;
import de.signWritingEditor.shared.infrastructure.migration.Tupel;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.PdfFileItem;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.TemplateItem;

public class DocumentDb extends MaterialDB {
	private static final String TABLENAME_ROOMS = "rooms";
	private static final String TABLENAME_DOCUMENTS = "documents";
	private static final String TABLENAME_FOLDERS = "folders";
	private static final String TABLENAME_RECYCLE_BINS = "recyclebins";
	private static final String TABLENAME_ROOMUSERS = "roomusers";

	private static final String PROPERTY_PDF_PATH = "esf.pdf.url";

	private static final Logger LOG = Logger.getLogger(DocumentDb.class);

	protected final IdFactory idFactory;
	private final UserDb userDb;
	private final String pdfPath;

	public DocumentDb(DbConnector connector, ConfigurationService configurationService) {
		super(connector);

		idFactory = new IdFactory(System.nanoTime());
		userDb = new UserDb(connector);
		this.pdfPath = configurationService.getProperty(PROPERTY_PDF_PATH);
	}

	public DocumentDb(DbConnector connector) throws IOException {
		this(connector, new ConfigurationService());
	}

	public boolean moveDocument(FileItem document, Id newFolderId) {
		assert document != null : "Precondition failed: documentId != null";
		assert newFolderId != null : "Precondition failed: newFolderId != null";
		assert existsDocument(document.getId()) : "Precondition failed: existsDocument(documentId)";
		assert existsFolder(newFolderId) : "Precondition failed: existsFolder(newFolderId)";

		boolean result = true;

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		result = createQuery("UPDATE " + TABLENAME_DOCUMENTS
				+ " SET parentFolderUpperId = ?, parentFolderLowerId = ?, changeDate = ? WHERE upperid = ? AND lowerid = ?",
				newFolderId.getUpperIdPart(), newFolderId.getLowerIdPart(), document.getChangeDate(),
				document.getId().getUpperIdPart(), document.getId().getLowerIdPart()).execute();

		assert result : "Postcondition failed: result";
		return result;
	}

	public boolean moveFolder(Id folderId, Id newFolderId) {
		assert folderId != null : "Precondition failed: folderId != null";
		assert newFolderId != null : "Precondition failed: newFolderId != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";
		assert existsFolder(newFolderId) : "Precondition failed: existsFolder(newFolderId)";

		boolean result = createQuery(
				"UPDATE " + TABLENAME_FOLDERS
						+ " SET parentFolderUpperId = ?, parentFolderLowerId = ? WHERE upperid = ? AND lowerid = ?",
				newFolderId.getUpperIdPart(), newFolderId.getLowerIdPart(), folderId.getUpperIdPart(),
				folderId.getLowerIdPart()).execute();

		assert result : "Postcondition failed: result";
		return result;
	}

	public List<FolderItem> getFilePath(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		LinkedList<FolderItem> result = new LinkedList<FolderItem>();
		if (!fileItem.getId().equals(FolderItem.ROOT_FOLDER_ID)) {
			FolderItem parentFolderItem = getParentFolder(fileItem);
			result.add(parentFolderItem);
			while (!parentFolderItem.getId().equals(FolderItem.ROOT_FOLDER_ID)) {
				parentFolderItem = getParentFolder(parentFolderItem);
				result.addFirst(parentFolderItem);
			}
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public List<FileItem> getVisibleFileItemsInFolderAccessibleForUser(FolderItem parentFolderItem, String username) {
		assert parentFolderItem != null : "Precondition failed: parentFolderItem != null";
		assert username != null : "Precondition failed: user != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		List<FileItem> result = new ArrayList<FileItem>();
		List<FolderItem> folderAndRoomItemsInFolder = getFolderAndRoomItemsInFolder(parentFolderItem);

		for (FolderItem folderItem : folderAndRoomItemsInFolder) {
			if (folderItem instanceof RoomItem) {
				RoomItem roomItem = (RoomItem) folderItem;
				if (!roomItem.isHidden() || roomItem.isRoomAccessPermitted(username)) {
					result.add(folderItem);
				}
			} else {
				result.add(folderItem);
			}
		}

		result.addAll(getDocumentItemsInFolder(parentFolderItem.getId()));
		result.addAll(getPdfFileItemsInFolder(parentFolderItem.getId()));

		return result;
	}

	public FolderItem getFolderItem(final Id folderId) {
		assert folderId != null : "Precondition failed: folderId != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";

		final Query queryFolderItem = createQuery("SELECT title, owner, createDate, changeDate, colorLabel FROM "
				+ TABLENAME_FOLDERS + " WHERE upperId = ? AND lowerId = ?", folderId.getUpperIdPart(),
				folderId.getLowerIdPart());

		return queryFolderItem.mapFirstRow(new ResultSetFunction<FolderItem>() {
			@Override
			public FolderItem apply(ResultSet resultSet) throws SQLException {
				String fileTitleString = resultSet.getString("title");

				if (FileTitle.isValidTitle(fileTitleString)) {
					FileTitle fileTitle = new FileTitle(fileTitleString);
					String owner = resultSet.getString("owner");
					Date creation = resultSet.getDate("createDate");
					Date change = resultSet.getDate("changeDate");
					String colorLabelString = resultSet.getString("colorLabel");
					FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);

					FolderItem folderItem = new FolderItem(folderId, owner, fileTitle, creation, change, colorLabel,
							SortCriteria.TYPE);

					if (isRoom(folderItem)) {
						return getRoomItem(folderItem);
					} else if (isRecycleBin(folderItem)) {
						return getRecycleBin(folderItem);
					} else {
						return folderItem;
					}
				} else {
					String errorMessage = "FolderItem \"" + fileTitleString + "\" contains invalid characters";
					LOG.error(errorMessage);
					throw new AssertionError(errorMessage);
				}
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + queryFolderItem);
			}
		});
	}

	public FolderItem getFolderItemWithTitleInParentFolder(FileTitle folderTitle, Id parentFolderId) {
		assert folderTitle != null : "Precondition failed: folderTitle != null";
		assert parentFolderId != null : "Precondition failed: parentFolderId != null";
		assert existsFolder(parentFolderId) : "Precondition failed: existsFolder(parentFolderId)";
		assert existsFolderWithTitleInParentFolder(folderTitle,
				parentFolderId) : "Precondition failed: existsFolder(folderTitle, parentFolderId)";

		final Query query = createQuery(
				"SELECT upperid, lowerid FROM " + TABLENAME_FOLDERS
						+ " WHERE title = ? AND parentFolderUpperId = ? AND parentFolderLowerId = ?",
				folderTitle.getTitleString(), parentFolderId.getUpperIdPart(), parentFolderId.getLowerIdPart());

		return query.mapFirstRow(new ResultSetFunction<FolderItem>() {
			@Override
			public FolderItem apply(ResultSet resultSet) throws SQLException {
				long upperId = resultSet.getLong("upperid");
				long lowerId = resultSet.getLong("lowerid");

				Id id = idFactory.reconstructId(upperId, lowerId);

				return getFolderItem(id);
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + query);
			}
		});
	}

	public synchronized FolderItem getParentFolder(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		FolderItem result = null;

		Id fileId = fileItem.getId();

		if (RoomItem.ROOT_FOLDER_ID.equals(fileId)) {
			assert fileItem instanceof RoomItem : "Assertion failed: fileItem instanceof RoomItem";
			result = (FolderItem) fileItem;
		} else {
			String tableName;
			if (fileItem instanceof DocumentItem) {
				tableName = TABLENAME_DOCUMENTS;
			} else {
				tableName = TABLENAME_FOLDERS;
			}

			final Query query = createQuery("SELECT parentFolderUpperId, parentFolderLowerId FROM " + tableName
					+ " WHERE upperId = ? AND lowerId = ?", fileId.getUpperIdPart(), fileId.getLowerIdPart());

			result = query.mapFirstRow(new ResultSetFunction<FolderItem>() {
				@Override
				public FolderItem apply(ResultSet resultSet) throws SQLException {
					long parentUpperId = resultSet.getLong("parentFolderUpperId");
					long parentLowerId = resultSet.getLong("parentFolderLowerId");

					Id parentId = idFactory.reconstructId(parentUpperId, parentLowerId);

					return getFolderItem(parentId);
				}

				@Override
				public void onError() {
					LOG.error("[GREPME] Empty ResultSet for: " + query);
				}
			});
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private boolean getIsRoomHidden(FileItem room) {
		assert room != null : "Precondition failed: room != null";
		assert isRoom((FolderItem) room) : "Precondition failed: isRoom(room)";
		Query query = createQuery(
				"SELECT isHidden FROM " + TABLENAME_ROOMS + " WHERE folderUpperId = ? AND folderLowerId = ?",
				room.getId().getUpperIdPart(), room.getId().getLowerIdPart());
		return query.getBoolean() == Boolean.TRUE;
	}

	// Returns itself if it is a room
	public RoomItem getRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		FileItem nextFileItem = fileItem;
		while (!(nextFileItem instanceof RoomItem)) {
			// Use db query to ensure actual parent is used
			nextFileItem = getParentFolder(nextFileItem);
		}
		RoomItem result = (RoomItem) nextFileItem;
		result.setIsHidden(getIsRoomHidden(nextFileItem));
		return result;
	}

	// Does not return itself, even if it is a room
	public RoomItem getParentRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		FileItem nextFileItem = fileItem;
		do {
			// Use db query to ensure actual parent is used
			nextFileItem = getParentFolder(nextFileItem);
		} while (!(nextFileItem instanceof RoomItem));
		RoomItem result = (RoomItem) nextFileItem;
		result.setIsHidden(getIsRoomHidden(nextFileItem));
		return result;
	}

	public RoomItem getRootRoomItem() {
		RoomItem result = null;
		if (getFolderItem(RoomItem.ROOT_FOLDER_ID) instanceof RoomItem) {
			result = (RoomItem) getFolderItem(RoomItem.ROOT_FOLDER_ID);
		} else if (getFolderItem(RoomItem.ROOT_FOLDER_ID) == null) {
			LOG.error("getRootRoomItem() - getFolderItem(RoomItem.ROOT_FOLDER_ID) is null");
			throw new RuntimeException();
		} else {
			LOG.error("getRootRoomItem() - getFolderItem(RoomItem.ROOT_FOLDER_ID)");
			throw new RuntimeException();
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public int getDocumentCount() {
		return getNumberOfEntries(TABLENAME_DOCUMENTS);
	}

	public String getDocumentContent(Id documentId) {
		assert documentId != null : "Precondition failed: documentId != null";
		assert existsDocument(documentId) : "Precondition failed: existsDocument(documentId)";

		Query query = createQuery("SELECT content FROM documents WHERE upperid = ? AND lowerid = ?",
				documentId.getUpperIdPart(), documentId.getLowerIdPart());
		String result = query.getString();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public List<Tupel<String, DocumentMetaDaten>> getAllDocuments() {
		Query query = createQuery("SElECT * FROM documents");

		ResultSetFunction<Tupel<String, DocumentMetaDaten>> getAllEntrys = new ResultSetFunction<Tupel<String, DocumentMetaDaten>>() {

			@Override
			public Tupel<String, DocumentMetaDaten> apply(ResultSet resultSet) throws SQLException {
				return new Tupel<String, DocumentMetaDaten>(resultSet.getString("content"),
						new DocumentMetaDaten(resultSet.getString("title"), resultSet.getString("owner"),
								resultSet.getLong("upperId"), resultSet.getLong("lowerId"),
								resultSet.getString("colorLabel")));
			}
		};

		return query.mapRows(getAllEntrys);
	}

	public boolean saveDocument(Id newDocumentId, FileTitle documentTitle, String content, String authorName,FileItemColorLabel fileItemColorLabel, Id folderId) {
		assert newDocumentId != null : "Precondition failed: newDocumentId != null";
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert authorName != null : "Precondition failed: authorName != null";
		assert content != null : "Precondition failed: content != null";
		assert folderId != null : "Precondition failed: folderId != null";
		assert fileItemColorLabel != null : "Precondition failed: fileItemColorLabel != null";
		assert existsUsername(authorName) : "Precondition failed: existsUsername(authorName)";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";
		assert !existsDocumentTitleInFolder(documentTitle,
				folderId) : "Precondition failed: !existsDocumentTitleInFolder(documentTitle, folderId)";

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		boolean result = createQuery(
				"INSERT INTO documents(title, owner, content, createdate, changedate, parentFolderUpperId, parentFolderLowerId , upperid, lowerId, colorLabel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				documentTitle.getTitleString(), authorName, content, currentTime, currentTime,
				folderId.getUpperIdPart(), folderId.getLowerIdPart(), newDocumentId.getUpperIdPart(),
				newDocumentId.getLowerIdPart(), fileItemColorLabel.name()).execute();

		assert result == existsDocumentTitleInFolder(documentTitle,
				folderId) : "Postcondition failed: result == exists(documentTitle, folderId)";
		return result;
	}

	public boolean saveDocument(Id newDocumentId, FileTitle documentTitle, String content, String authorName,
			Id folderId) {
		assert newDocumentId != null : "Precondition failed: newDocumentId != null";
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert authorName != null : "Precondition failed: authorName != null";
		assert content != null : "Precondition failed: content != null";
		assert folderId != null : "Precondition failed: folderId != null";
		assert existsUsername(authorName) : "Precondition failed: existsUsername(authorName)";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";
		assert !existsDocumentTitleInFolder(documentTitle,
				folderId) : "Precondition failed: !existsDocumentTitleInFolder(documentTitle, folderId)";

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		boolean result = createQuery(
				"INSERT INTO documents(title, owner, content, createdate, changedate, parentFolderUpperId, parentFolderLowerId , upperid, lowerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
				documentTitle.getTitleString(), authorName, content, currentTime, currentTime,
				folderId.getUpperIdPart(), folderId.getLowerIdPart(), newDocumentId.getUpperIdPart(),
				newDocumentId.getLowerIdPart()).execute();

		assert result == existsDocumentTitleInFolder(documentTitle,
				folderId) : "Postcondition failed: result == exists(documentTitle, folderId)";
		return result;
	}

	public DocumentItem createDocument(FileTitle documentTitle, String authorName) {
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert authorName != null : "Precondition failed: authorName != null";
		assert existsUsername(authorName) : "Precondition failed: existsUsername(authorName)";

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		DocumentItem result = new DocumentItem(idFactory.createId(), authorName, documentTitle, currentTime,
				currentTime, FileItemColorLabel.NONE);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public boolean updateDocumentContentWithoutChangedate(Id documentId, String newContent) {
		assert documentId != null : "Precondition failed: documentId != null";
		assert newContent != null : "Precondition failed: newContent != null";

		return createQuery("UPDATE " + TABLENAME_DOCUMENTS + " SET content = ? WHERE upperId = ? AND lowerId = ?",
				newContent, documentId.getUpperIdPart(), documentId.getLowerIdPart()).execute();
	}

	public boolean updateDocument(Id documentId, FileTitle newDocumentTitle, String newContent, String newOwnerName,
			FileItemColorLabel newColorLabel) {
		assert documentId != null : "Precondition failed: documentId != null";
		assert newDocumentTitle != null : "Precondition failed: newDocumentTitle != null";
		assert newContent != null : "Precondition failed: newContent != null";
		assert newOwnerName != null : "Precondition failed: newOwnerName != null";
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";
		assert existsDocument(documentId) : "Precondition failed: existsDocument(documentId)";

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		return createQuery("UPDATE " + TABLENAME_DOCUMENTS
				+ " SET title = ?, owner = ?, content = ?, changeDate = ?, colorLabel = ? WHERE upperid = ? AND lowerid = ?",
				newDocumentTitle.getTitleString(), newOwnerName, newContent, currentTime, newColorLabel.name(),
				documentId.getUpperIdPart(), documentId.getLowerIdPart()).execute();
	}

	public boolean updateDocument(DocumentItem documentItem, String xmlContent, FileItemColorLabel colorLabel) {
		Id id = documentItem.getId();
		FileTitle fileTitle = documentItem.getFileTitle();
		String ownerName = documentItem.getOwner();
		return updateDocument(id, fileTitle, xmlContent, ownerName, colorLabel);
	}

	public boolean updateFolder(Id folderId, FileTitle newFolderTitle, String newOwnerName,
			FileItemColorLabel newColorLabel) {
		assert folderId != null : "Precondition failed: folderId != null";
		assert newFolderTitle != null : "Precondition failed: folderTitle != null";
		assert newOwnerName != null : "Precondition failed: newOwnerName != null";
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";

		return createQuery(
				"UPDATE " + TABLENAME_FOLDERS
						+ " SET title = ?, owner = ?, colorLabel = ? WHERE upperid = ? AND lowerid = ?",
				newFolderTitle.getTitleString(), newOwnerName, newColorLabel.name(), folderId.getUpperIdPart(),
				folderId.getLowerIdPart()).execute();
	}

	public void createNewFolder(FileTitle newFolderTitle, Id parentFolderId, String ownerName) {
		assert newFolderTitle != null : "Precondition failed: newFolderTitle != null";
		assert parentFolderId != null : "Precondition failed: parentFolderId != null";
		assert ownerName != null : "Precondition failed: ownerName != null";
		assert existsFolder(parentFolderId) : "Precondition failed: existsFolder(parentFolderId)";
		assert existsUsername(ownerName) : "Precondition failed: existsUsername(ownerName)";

		Timestamp currentTime = new Timestamp(new Date().getTime());

		Id newFolderId = idFactory.createId();

		createQuery("INSERT INTO " + TABLENAME_FOLDERS
				+ " (title, owner, createdate, changedate,  parentFolderUpperId, parentFolderLowerId , upperid, lowerid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				newFolderTitle.getTitleString(), ownerName, currentTime, currentTime, parentFolderId.getUpperIdPart(),
				parentFolderId.getLowerIdPart(), newFolderId.getUpperIdPart(), newFolderId.getLowerIdPart()).execute();

		assert existsFolderWithTitleInParentFolder(newFolderTitle,
				parentFolderId) : "Postcondition failed: existsFolderTitle(newFolderName, parentFolderId)";
	}

	public Id createNewRoomWithRecycleBin(FileTitle roomName, List<String> roomOwners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription) {
		assert roomName != null : "Precondition failed: roomName != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";
		assert roomOwners != null : "Precondition failed: roomOwners != null";
		assert !roomOwners.isEmpty() : "Precondition failed: !roomOwners.isEmpty()";

		Id newRoomId = createNewRoomEntry(roomName, roomUsers, roomOwners, roomPolicy, isHidden, roomDescription);
		Id recycleBinId = createRecycleBinForRoom(newRoomId);

		assert existsRoom(newRoomId) : "Postcondition failed: existsRoom(newRoomId)";
		assert existsRecycleBin(recycleBinId) : "Postcondition failed: existsRecycleBin(recycleBinId)";
		return newRoomId;
	}

	public List<DocumentItem> findDocumentByTitleLike(String searchString) {
		assert searchString != null : "Precondition failed: searchString != null";

		searchString = "%" + searchString + "%";
		Query queryDocumentTitle = createQuery(
				"SELECT upperId, lowerId, title, owner, content, createDate, changeDate, colorLabel FROM "
						+ TABLENAME_DOCUMENTS + " WHERE title LIKE ?",
				searchString);
		return queryDocumentTitle.mapRows(new ResultSetFunction<DocumentItem>() {
			@Override
			public DocumentItem apply(ResultSet resultSet) throws SQLException {
				FileTitle documentTitle = new FileTitle(resultSet.getString("title"));
				String owner = resultSet.getString("owner");
				Date createDate = (Date) resultSet.getObject("createDate");
				Date changeDate = (Date) resultSet.getObject("changeDate");
				FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(resultSet.getString("colorLabel"));
				Long upperId = (Long) resultSet.getObject("upperId");
				Long lowerId = (Long) resultSet.getObject("lowerId");
				Id fileId = idFactory.reconstructId(upperId, lowerId);

				String xml = resultSet.getString("content");
				if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
					return new TemplateItem(fileId, owner, documentTitle, createDate, changeDate, colorLabel,
							xml.contains("templateValidity=\"true\""));
				} else {
					return new DocumentItem(fileId, owner, documentTitle, createDate, changeDate, colorLabel);
				}
			}
		});
	}

	public List<DocumentItem> findSortedDocumentsByTitleLike(String searchString) {
		assert searchString != null : "Precondition failed: searchString != null";

		searchString = "%" + searchString + "%";
		Query queryDocumentTitle = createQuery(
				"SELECT upperId, lowerId, title, owner, content, createDate, changeDate, colorLabel FROM "
						+ TABLENAME_DOCUMENTS
						+ " WHERE title LIKE ? ORDER BY parentFolderUpperId, parentFolderLowerId, title",
				searchString);
		return queryDocumentTitle.mapRows(new ResultSetFunction<DocumentItem>() {
			@Override
			public DocumentItem apply(ResultSet resultSet) throws SQLException {
				FileTitle documentTitle = new FileTitle(resultSet.getString("title"));
				String owner = resultSet.getString("owner");
				Date createDate = (Date) resultSet.getObject("createDate");
				Date changeDate = (Date) resultSet.getObject("changeDate");
				FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(resultSet.getString("colorLabel"));
				Long upperId = (Long) resultSet.getObject("upperId");
				Long lowerId = (Long) resultSet.getObject("lowerId");
				Id fileId = idFactory.reconstructId(upperId, lowerId);

				String xml = resultSet.getString("content");
				if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
					return new TemplateItem(fileId, owner, documentTitle, createDate, changeDate, colorLabel,
							xml.contains("templateValidity=\"true\""));
				} else {
					return new DocumentItem(fileId, owner, documentTitle, createDate, changeDate, colorLabel);
				}
			}
		});
	}

	public boolean changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy) {
		return createQuery(
				"UPDATE " + TABLENAME_ROOMS + " SET `roomPolicy`= ? WHERE `folderUpperId`=? and`folderLowerId`=?; ",
				selectedPolicy.toString(), room.getId().getUpperIdPart(), room.getId().getLowerIdPart()).execute();
	}

	protected Id createNewRoomEntry(FileTitle roomName, List<String> roomUsers, List<String> roomOwners,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription) {
		assert roomName != null : "Precondition failed: roomName != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";
		assert roomOwners != null : "Precondition failed: roomOwners != null";
		assert !roomOwners.isEmpty() : "Precondition failed: !roomOwners.isEmpty()";

		// temp fix
		if (roomDescription == null) {
			roomDescription = "";
		}

		Timestamp currentTime = new Timestamp(new Date().getTime());

		Id newRoomId = idFactory.createId();
		String roomOwner = roomOwners.get(0);

		createQuery("INSERT INTO " + TABLENAME_FOLDERS
				+ " (title, owner, createdate, changedate,  parentFolderUpperId, parentFolderLowerId , upperid, lowerid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				roomName.getTitleString(), roomOwner, currentTime, currentTime,
				RoomItem.ROOT_FOLDER_ID.getUpperIdPart(), RoomItem.ROOT_FOLDER_ID.getLowerIdPart(),
				newRoomId.getUpperIdPart(), newRoomId.getLowerIdPart()).execute();

		createQuery("INSERT INTO " + TABLENAME_ROOMS
				+ " (folderUpperId, folderLowerId, roomPolicy, recycleBinUpperId, recycleBinLowerId, isHidden, description) VALUES (?, ?, ?, ?, ?, ?,?)",
				newRoomId.getUpperIdPart(), newRoomId.getLowerIdPart(), roomPolicy.toString(), null, null, isHidden,
				roomDescription).execute();

		// Room owners get inserted below with isowner = true
		// We don't want to modify the given list
		List<String> roomUsersToInsert = new ArrayList<String>(roomUsers);
		roomUsersToInsert.removeAll(roomOwners);

		for (String userName : roomUsersToInsert) {
			assert existsUsername(userName) : "Precondition failed: existsUsername(userName)";
			createQuery(
					"INSERT INTO " + TABLENAME_ROOMUSERS
							+ " (username, roomUpperId, roomLowerId, isOwner) VALUES (?, ?, ?, 0)",
					userName, newRoomId.getUpperIdPart(), newRoomId.getLowerIdPart()).execute();
		}

		for (String userName : roomOwners) {
			assert existsUsername(userName) : "Precondition failed: existsUsername(userName)";
			createQuery(
					"INSERT INTO " + TABLENAME_ROOMUSERS
							+ " (username, roomUpperId, roomLowerId, isOwner) VALUES (?, ?, ?, 1)",
					userName, newRoomId.getUpperIdPart(), newRoomId.getLowerIdPart()).execute();
		}

		assert existsRoom(newRoomId) : "Postcondition failed: existsRoom(newRoomId)";
		return newRoomId;
	}

	protected Id createRecycleBinForRoom(Id roomId) {
		assert roomId != null : "Precondition failed: roomId != null";
		assert existsRoom(roomId) : "Precondition failed: existsRoom(roomId)";

		FolderItem roomItem = getFolderItem(roomId);

		String recycleBinTitleString = new String("Papierkorb " + roomItem.getFileTitle().getTitleString());

		FileTitle recycleBinTitle = new FileTitle(recycleBinTitleString);

		// make sure that the recycle bin's title is unique
		int nameCounter = 1;
		while (existsFolderWithTitleInParentFolder(recycleBinTitle, roomId)) {
			String newTitleString = recycleBinTitleString + " " + nameCounter;
			recycleBinTitle = new FileTitle(newTitleString);
			nameCounter++;
		}

		createNewFolder(recycleBinTitle, roomId, roomItem.getOwner());
		FolderItem recycleBin = getFolderItemWithTitleInParentFolder(recycleBinTitle, roomId);

		createQuery("INSERT INTO " + TABLENAME_RECYCLE_BINS + " (upperId, lowerId) VALUES (?, ?)",
				recycleBin.getId().getUpperIdPart(), recycleBin.getId().getLowerIdPart()).execute();

		createQuery("UPDATE " + TABLENAME_ROOMS
				+ " SET recycleBinUpperId = ?, recycleBinLowerId = ? WHERE folderUpperId = ? AND folderLowerId = ?",
				recycleBin.getId().getUpperIdPart(), recycleBin.getId().getLowerIdPart(),
				roomItem.getId().getUpperIdPart(), roomItem.getId().getLowerIdPart()).execute();

		assert isRecycleBin(recycleBin) : "Postcondition failed: isRecycleBin(folderItem)";

		return recycleBin.getId();
	}

	public boolean deleteDocument(Id documentId) {
		assert documentId != null : "Precondition failed: documentId != null";
		assert existsDocument(documentId) : "Precondition failed: existsDocument(documentId)";

		Timestamp currentTime = new Timestamp(new java.util.Date().getTime());

		boolean result = createQuery("DELETE FROM " + TABLENAME_DOCUMENTS + " WHERE upperid = ? AND lowerid = ?",
				documentId.getUpperIdPart(), documentId.getLowerIdPart()).execute();

		assert result : "Postcondition failed: result";
		assert !existsDocument(documentId) : "Postcondition failed: !existsDocument(documentId)";
		return result;
	}

	public boolean deleteFolder(Id folderId) {
		assert folderId != null : "Precondition failed: folderId != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";
		assert !existsRecycleBin(folderId) : "Precondition failed: !existsRecycleBin(folderId)";

		boolean result = createQuery("DELETE FROM " + TABLENAME_FOLDERS + " WHERE upperid = ? AND lowerid = ?",
				folderId.getUpperIdPart(), folderId.getLowerIdPart()).execute();

		assert !existsRoom(folderId) : "Postcondition failed: !existsRoom(folderId)";
		assert !existsFolder(folderId) : "Postcondition failed: !existsFolder(folderId)";
		assert result != existsFolder(folderId) : "Postcondition failed: result != existsFolder(folderId)";
		return result;
	}

	public boolean deleteRoom(Id roomId) {
		assert roomId != null : "Precondition failed: roomId != null";
		assert existsRoom(roomId) : "Precondition failed: existsRoom(roomId)";

		boolean result = deleteFolder(roomId);

		assert result != existsRoom(roomId) : "Postcondition failed: result != existsRoom(roomId)";
		return result;
	}

	public boolean deleteRecycleBin(Id recycleBinId) {
		assert recycleBinId != null : "Precondition failed: recycleBinId != null";
		assert existsRecycleBin(recycleBinId) : "Precondition failed: existsRecycleBin(recycleBinId)";

		boolean result = createQuery("DELETE FROM " + TABLENAME_RECYCLE_BINS + " WHERE upperId = ? AND lowerId = ?",
				recycleBinId.getUpperIdPart(), recycleBinId.getLowerIdPart()).execute()
				&& createQuery("UPDATE " + TABLENAME_ROOMS
						+ " SET recycleBinUpperId = NULL, recycleBinLowerId = NULL WHERE recycleBinUpperId = "
						+ recycleBinId.getUpperIdPart() + " AND recycleBinLowerId = " + recycleBinId.getLowerIdPart())
								.execute()
				&& deleteFolder(recycleBinId);

		assert result != existsRecycleBin(
				recycleBinId) : "Postcondition failed: result != existsRecycleBin(recycleBinId)";
		return result;
	}

	public boolean existsFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		Id id = fileItem.getId();
		boolean result = false;

		if (fileItem instanceof DocumentItem) {
			result = existsDocument(id);
		} else if (fileItem instanceof FolderItem) {
			result = existsFolder(id);
		}

		return result;
	}

	public boolean existsDocument(Id documentId) {
		assert documentId != null : "Precondition failed: documentId != null";

		Query query = createQuery("SELECT COUNT(*) FROM " + TABLENAME_DOCUMENTS + " WHERE upperid= ? AND lowerid = ?",
				documentId.getUpperIdPart(), documentId.getLowerIdPart());
		return query.getNumberOfMatches() > 0;
	}

	public boolean existsDocumentTitleInFolder(FileTitle documentTitle, Id folderId) {
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert folderId != null : "Precondition failed: folderId != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";

		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_DOCUMENTS
						+ " WHERE title = ? AND parentFolderUpperId = ? AND parentFolderLowerId = ?",
				documentTitle.getTitleString(), folderId.getUpperIdPart(), folderId.getLowerIdPart());

		return query.getNumberOfMatches() > 0;
	}

	public boolean existsFolder(Id folderId) {
		assert folderId != null : "Precondition failed: folderId != null";

		Query query = createQuery("SELECT COUNT(*) FROM " + TABLENAME_FOLDERS + " WHERE upperid= ? AND lowerid = ?",
				folderId.getUpperIdPart(), folderId.getLowerIdPart());

		return query.getNumberOfMatches() > 0;
	}

	public boolean existsFolderWithTitleInParentFolder(FileTitle folderTitle, Id parentFolderId) {
		assert folderTitle != null : "Precondition failed: folderTitle != null";
		assert parentFolderId != null : "Precondition failed: parentFolderId != null";
		assert existsFolder(parentFolderId) : "Precondition failed: existsFolder(parentFolderId)";

		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_FOLDERS
						+ " WHERE title = ? AND parentFolderUpperId = ? AND parentFolderLowerId = ?",
				folderTitle.getTitleString(), parentFolderId.getUpperIdPart(), parentFolderId.getLowerIdPart());

		return query.getNumberOfMatches() > 0;
	}

	public boolean existsRoom(Id roomId) {
		assert roomId != null : "Precondition failed: roomId != null";

		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_ROOMS + " WHERE folderUpperId = ? AND folderLowerId = ?",
				roomId.getUpperIdPart(), roomId.getLowerIdPart());

		return existsFolder(roomId) && query.getNumberOfMatches() > 0;
	}

	public boolean existsRoomWithTitle(FileTitle roomTitle) {
		assert roomTitle != null : "Precondition failed: roomTitle != null";

		return existsFolderWithTitleInParentFolder(roomTitle, RoomItem.ROOT_FOLDER_ID)
				&& getFolderItemWithTitleInParentFolder(roomTitle, RoomItem.ROOT_FOLDER_ID) instanceof RoomItem;
	}

	public boolean existsRoomNameForUser(String roomName, String userName) {
		assert roomName != null : "Precondition failed: roomName != null";
		assert userName != null : "Precondition failed: userName != null";

		Query query = createQuery("SELECT COUNT(DISTINCT rooms.folderUpperId, rooms.folderLowerId, folder.title) FROM "
				+ TABLENAME_ROOMS + " as rooms, " + TABLENAME_ROOMUSERS + " as roomusers , " + TABLENAME_FOLDERS
				+ " as folder WHERE folder.upperId = rooms.folderUpperId  AND  folder.lowerId= rooms.folderLowerId AND folder.title = ? AND ((roomusers.roomUpperId = rooms.folderUpperId AND rooms.folderLowerId = roomusers.roomLowerId AND roomusers.username like ?) OR rooms.isHidden = 0);",
				roomName, userName);

		return query.getNumberOfMatches() > 0;
	}

	public boolean existsRecycleBin(Id recycleBinId) {
		assert recycleBinId != null : "Precondition failed: recycleBinId != null";

		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_RECYCLE_BINS + " WHERE upperId = ? AND lowerId = ?",
				recycleBinId.getUpperIdPart(), recycleBinId.getLowerIdPart());

		return existsFolder(recycleBinId) && query.getNumberOfMatches() > 0;
	}

	public boolean existsUsername(String username) {
		assert username != null : "Precondition failed: username != null";
		return userDb.existsUsername(username);
	}

	public DocumentItem getDocumentItem(final Id documentId) {
		assert documentId != null : "Precondition failed: documentId != null";
		assert existsDocument(documentId) : "Precondition failed: existsDocument(documentId)";

		final Query queryFolderItem = createQuery(
				"SELECT title, owner, content, createDate, changeDate, colorLabel FROM " + TABLENAME_DOCUMENTS
						+ " WHERE upperId = ? AND lowerId = ?",
				documentId.getUpperIdPart(), documentId.getLowerIdPart());

		return queryFolderItem.mapFirstRow(new ResultSetFunction<DocumentItem>() {
			@Override
			public DocumentItem apply(ResultSet resultSet) throws SQLException {
				String fileTitleString = resultSet.getString("title");

				if (FileTitle.isValidTitle(fileTitleString)) {
					FileTitle fileTitle = new FileTitle(fileTitleString);
					String owner = resultSet.getString("owner");
					Date creation = new Date(resultSet.getTimestamp("createDate").getTime());
					Date change = new Date(resultSet.getTimestamp("changeDate").getTime());
					String colorLabelString = resultSet.getString("colorLabel");
					FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);

					String xml = resultSet.getString("content");
					if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
						return new TemplateItem(documentId, owner, fileTitle, creation, change, colorLabel,
								xml.contains("templateValidity=\"true\""));
					} else {
						return new DocumentItem(documentId, owner, fileTitle, creation, change, colorLabel);
					}

				} else {
					String errorMessage = "DocumentItem \"" + fileTitleString + "\" contains invalid characters";
					LOG.error(errorMessage);
					throw new AssertionError(errorMessage);
				}
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet empty: " + queryFolderItem);
			}
		});
	}

	public DocumentItem getDocumentItem(FileTitle documentTitle, Id folderId) {
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert folderId != null : "Precondition failed: folderId != null";
		assert existsFolder(folderId) : "Precondition failed: existsFolder(folderId)";
		assert existsDocumentTitleInFolder(documentTitle,
				folderId) : "Precondition failed: existsDocumentTitleInFolder(documentTitle, folderId)";

		final Query query = createQuery(
				"SELECT upperId, lowerId, content FROM " + TABLENAME_DOCUMENTS
						+ " WHERE title = ? AND parentFolderUpperId = ? AND parentFolderLowerId = ?",
				documentTitle.getTitleString(), folderId.getUpperIdPart(), folderId.getLowerIdPart());

		return query.mapFirstRow(new ResultSetFunction<DocumentItem>() {
			@Override
			public DocumentItem apply(ResultSet resultSet) throws SQLException {
				long upperId = resultSet.getLong("upperid");
				long lowerId = resultSet.getLong("lowerid");

				Id documentId = idFactory.reconstructId(upperId, lowerId);

				return getDocumentItem(documentId);
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet empty: " + query);
			}
		});
	}

	private List<DocumentItem> getDocumentItemsInFolderForQuery(Id folderId, String queryString) {
		assert folderId != null : "Precondition failed: folderId != null";

		return createQuery(queryString, folderId.getUpperIdPart(), folderId.getLowerIdPart())
				.mapRows(new ResultSetFunction<DocumentItem>() {
					@Override
					public DocumentItem apply(ResultSet resultSet) throws SQLException {
						String documentTitleString = resultSet.getString("title");
						assert FileTitle.isValidTitle(documentTitleString) : "Document: " + documentTitleString
								+ " :contains invalid characters";

						FileTitle fileTitle = new FileTitle(documentTitleString);
						String owner = resultSet.getString("owner");
						Date creation = resultSet.getTimestamp("createDate");
						Date change = resultSet.getTimestamp("changeDate");
						String colorLabelString = resultSet.getString("colorLabel");
						FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);
						Long upperId = resultSet.getLong("upperId");
						Long lowerId = resultSet.getLong("lowerId");

						Id id = idFactory.reconstructId(upperId, lowerId);

						String xml = resultSet.getString("content");
						if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
							return new TemplateItem(id, owner, fileTitle, creation, change, colorLabel,
									xml.contains("templateValidity=\"true\""));
						} else {
							return new DocumentItem(id, owner, fileTitle, creation, change, colorLabel);
						}
					}
				});
	}

	public List<String> getContentOfDocumentsInFolder(Id folderId) {

		String queryString = "Select content from documents where parentFolderUpperId = ? and ParentFolderLowerId = ?";

		return createQuery(queryString, folderId.getUpperIdPart(), folderId.getLowerIdPart())
				.mapRows(new ResultSetFunction<String>() {
					@Override
					public String apply(ResultSet resultSet) throws SQLException {
						return resultSet.getString("content");
					}

				});
	}

	/**
	 * @return Map aus Contents mit einer Id aus Lower- und UpperId des
	 * Documents
	 */
	public Map<String, String> getDocumentIdsWithContent(Id folderId) {
		String queryString = "Select upperId, lowerId, content from documents where"
				+ " parentFolderUpperId = ? and ParentFolderLowerId = ?";

		Map<String, String> documentIdToContentMap = new HashMap<String, String>();

		createQuery(queryString, folderId.getUpperIdPart(), folderId.getLowerIdPart())
				.forEachRow(new ResultSetConsumer() {

					@Override
					public void accept(ResultSet resultSet) throws SQLException {

						String upperId = resultSet.getString("upperId");
						String lowerId = resultSet.getString("lowerId");
						String content = resultSet.getString("content");
						String documentId = upperId + ":" + lowerId;

						documentIdToContentMap.put(documentId, content);
					}
				});
		return documentIdToContentMap;
	}

	public List<DocumentItem> getDocumentItemsInFolderNewerThan(Id folderId, String date) {
		assert folderId != null : "Precondition failed: folderId != null";
		String queryString = "SELECT title, owner, content, createDate, changeDate,colorLabel, upperId, lowerId FROM documents WHERE parentFolderUpperId = ? AND parentFolderLowerId = ? AND changeDate > ?";

		return createQuery(queryString, folderId.getUpperIdPart(), folderId.getLowerIdPart(), date)
				.mapRows(new ResultSetFunction<DocumentItem>() {
					@Override
					public DocumentItem apply(ResultSet resultSet) throws SQLException {
						String documentTitleString = resultSet.getString("title");
						assert FileTitle.isValidTitle(documentTitleString) : "Document: " + documentTitleString
								+ " :contains invalid characters";

						FileTitle fileTitle = new FileTitle(documentTitleString);
						String owner = resultSet.getString("owner");
						Date creation = resultSet.getTimestamp("createDate");
						Date change = resultSet.getTimestamp("changeDate");
						String colorLabelString = resultSet.getString("colorLabel");
						FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);
						Long upperId = resultSet.getLong("upperId");
						Long lowerId = resultSet.getLong("lowerId");

						Id id = idFactory.reconstructId(upperId, lowerId);

						String xml = resultSet.getString("content");
						if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
							return new TemplateItem(id, owner, fileTitle, creation, change, colorLabel,
									xml.contains("templateValidity=\"true\""));
						} else {
							return new DocumentItem(id, owner, fileTitle, creation, change, colorLabel);
						}
					}
				});
	}

	public List<DocumentItem> getDocumentItemsInFolder(Id folderId) {
		assert folderId != null : "Precondition failed: folderId != null";

		return getDocumentItemsInFolderForQuery(folderId,
				"SELECT title, owner, content, createDate, changeDate,colorLabel, upperId, lowerId FROM documents WHERE parentFolderUpperId = ? AND parentFolderLowerId = ?");
	}

	private List<PdfFileItem> getPdfFileItemsInFolderForQuery(Id folderId, String queryString) {
		assert folderId != null : "Precondition failed: folderId != null";

		return createQuery(queryString, folderId.getUpperIdPart(), folderId.getLowerIdPart())
				.mapRows(new ResultSetFunction<PdfFileItem>() {
					@Override
					public PdfFileItem apply(ResultSet resultSet) throws SQLException {
						String pdfTitleString = resultSet.getString("title");
						assert FileTitle.isValidTitle(pdfTitleString) : "Pdf: " + pdfTitleString
								+ " :contains invalid characters";

						FileTitle fileTitle = new FileTitle(pdfTitleString);
						String owner = resultSet.getString("owner");
						String colorLabelString = resultSet.getString("colorLabel");
						FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);
						Long upperId = resultSet.getLong("upperId");
						Long lowerId = resultSet.getLong("lowerId");
						Date createDate = resultSet.getTimestamp("createDate");
						Date changeDate = resultSet.getTimestamp("changeDate");
						Id id = idFactory.reconstructId(upperId, lowerId);

						return new PdfFileItem(id, owner, fileTitle, colorLabel, pdfPath, createDate, changeDate);
					}

				});
	}

	public List<PdfFileItem> getPdfFileItemsInFolder(Id folderId) {
		assert folderId != null : "Precondition failed: folderId != null";

		return getPdfFileItemsInFolderForQuery(folderId,
				"SELECT title, owner,colorLabel, upperId, lowerId, createDate, changeDate FROM pdfdocuments WHERE parentFolderUpperId = ? AND parentFolderLowerId = ?");
	}

	private DocumentItem getDocumentItemInFolder(Id folderId, String title) throws DocumentNotFoundException {
		assert folderId != null : "Precondition failed: folderId != null";
		assert title != null : "Precondition failed: title != null";

		List<DocumentItem> resultSet = getDocumentItemsInFolderForQuery(folderId,
				"SELECT title, owner, content, createDate, changeDate,colorLabel, upperId, lowerId FROM documents WHERE parentFolderUpperId = ? AND parentFolderLowerId = ?");

		if (resultSet.size() < 1) {
			throw new DocumentNotFoundException("Document " + title + " not found.");
		}

		DocumentItem result = null;
		for (DocumentItem item : resultSet) {
			if (item.getFileTitle().getTitleString().equals(title)) {
				result = item;
			}
		}
		if (result == null) {
			throw new DocumentNotFoundException("Document " + title + " not found.");
		}
		return result;
	}

	public List<DocumentItem> getDocumentItemsForUser(String username) {
		assert username != null : "Precondition failed: user != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		String queryString = "SELECT title, owner, content, createDate, changeDate,colorLabel, upperId, lowerId FROM documents WHERE owner = ?";

		return createQuery(queryString, username).mapRows(new ResultSetFunction<DocumentItem>() {
			@Override
			public DocumentItem apply(ResultSet resultSet) throws SQLException {
				String documentTitleString = resultSet.getString("title");
				assert FileTitle.isValidTitle(documentTitleString) : "Document: " + documentTitleString
						+ " :contains invalid characters";

				FileTitle fileTitle = new FileTitle(documentTitleString);
				String owner = resultSet.getString("owner");
				Date creation = resultSet.getDate("createDate");
				Date change = resultSet.getDate("changeDate");
				String colorLabelString = resultSet.getString("colorLabel");
				FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);
				Long upperId = resultSet.getLong("upperId");
				Long lowerId = resultSet.getLong("lowerId");

				Id id = idFactory.reconstructId(upperId, lowerId);

				String xml = resultSet.getString("content");
				if (xml.contains(DocumentXMLConverter.TEMPLATE_VERSION)) {
					return new TemplateItem(id, owner, fileTitle, creation, change, colorLabel,
							xml.contains("templateValidity=\"true\""));
				} else {
					return new DocumentItem(id, owner, fileTitle, creation, change, colorLabel);
				}
			}
		});
	}

	public List<FolderItem> getFolderItemsForUser(final String username) {
		assert username != null : "Precondition failed: user != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		String queryString = "SELECT title, createDate, changeDate, colorLabel, upperId, lowerId FROM folders WHERE owner = ?";

		return createQuery(queryString, username).mapRows(new ResultSetFunction<FolderItem>() {
			@Override
			public FolderItem apply(ResultSet resultSet) throws SQLException {
				String documentTitleString = resultSet.getString("title");
				assert FileTitle.isValidTitle(documentTitleString) : "Document: " + documentTitleString
						+ " :contains invalid characters";

				FileTitle fileTitle = new FileTitle(documentTitleString);
				Date creation = resultSet.getDate("createDate");
				Date change = resultSet.getDate("changeDate");
				String colorLabelString = resultSet.getString("colorLabel");
				FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);
				Long upperId = resultSet.getLong("upperId");
				Long lowerId = resultSet.getLong("lowerId");

				Id id = idFactory.reconstructId(upperId, lowerId);

				return new FolderItem(id, username, fileTitle, creation, change, colorLabel, SortCriteria.TYPE);
			}
		});
	}

	protected RecycleBinItem getRecycleBin(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert isRecycleBin(folderItem) : "Precondition failed: isRecycleBin(folderItem)";

		RecycleBinItem result = new RecycleBinItem(folderItem.getId(), folderItem.getOwner(), folderItem.getFileTitle(),
				folderItem.getCreationDate(), folderItem.getChangeDate());

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public boolean isRecycleBin(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";

		Id id = folderItem.getId();
		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_RECYCLE_BINS + " WHERE upperId= ? AND lowerId = ?",
				id.getUpperIdPart(), id.getLowerIdPart());

		return query.getNumberOfMatches() > 0;
	}

	protected RoomItem getRoomItem(final FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert isRoom(folderItem) : "Precondition failed: isRoomItem(folderItem)";

		final Id id = folderItem.getId();

		final Query query = createQuery("SELECT recycleBinUpperId, recycleBinLowerId, roomPolicy,description FROM "
				+ TABLENAME_ROOMS + " WHERE folderUpperId = ? AND folderLowerId = ?", id.getUpperIdPart(),
				id.getLowerIdPart());

		return query.mapFirstRow(new ResultSetFunction<RoomItem>() {
			@Override
			public RoomItem apply(ResultSet resultSet) throws SQLException {

				String roomPolicyString = resultSet.getString("roomPolicy");

				String roomDescriptionString = resultSet.getString("description");

				Query queryRoomUsers = createQuery(
						"SELECT username, isOwner FROM " + TABLENAME_ROOMUSERS
								+ " WHERE roomUpperId = ? AND roomLowerId = ?",
						id.getUpperIdPart(), id.getLowerIdPart());

				final List<String> roomUsers = new ArrayList<String>();
				final List<String> roomOwners = new ArrayList<String>();

				queryRoomUsers.forEachRow(new ResultSetConsumer() {
					@Override
					public void accept(ResultSet resultSet) throws SQLException {
						String username = resultSet.getString("username");
						boolean isOwner = resultSet.getBoolean("isOwner");
						if (isOwner) {
							roomOwners.add(username);
						} else {
							roomUsers.add(username);
						}
					}
				});

				RoomItem result = new RoomItem(folderItem.getId(), folderItem.getOwner(), roomUsers, roomOwners,
						folderItem.getFileTitle(), folderItem.getCreationDate(), folderItem.getChangeDate(),
						RoomPolicy.getRoomPolicy(roomPolicyString), roomDescriptionString);

				if (result.getId().equals(RoomItem.ROOT_FOLDER_ID)) {
					result = RoomItem.getRootRoomItem(result);
				} else if (result.getId().equals(RoomItem.PUBLIC_FOLDER_ID)) {
					result = RoomItem.getPublicRoomItem(result);
				} else if (result.getId().equals(RoomItem.SYSTEM_FOLDER_ID)) {
					result = RoomItem.getSystemRoomItem(result);
				} else if (result.getId().equals(RoomItem.SHOWROOM_FOLDER_ID)) {
					result = RoomItem.getShowRoomItem(result);
				}

				// Maintenance note: Do NOT refactor (Long) getObject to
				// getLong, because getLong will return 0 instead of null.
				Long recycleBinUpperIdPart = (Long) resultSet.getObject("recycleBinUpperId");
				// Maintenance note: Do NOT refactor (Long) getObject to
				// getLong, because getLong will return 0 instead of null.
				Long recycleBinLowerIdPart = (Long) resultSet.getObject("recycleBinLowerId");
				if (recycleBinUpperIdPart != null && recycleBinLowerIdPart != null) {
					result.setRecycleBinItem(getRecycleBin(recycleBinUpperIdPart, recycleBinLowerIdPart));
				}

				result.setIsHidden(getIsRoomHidden(result));
				assert result != null : "Postcondition failed: result != null";
				return result;
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + query);
			}
		});
	}

	protected boolean isRoom(FolderItem folderItem) {
		Id id = folderItem.getId();
		Query query = createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_ROOMS + " WHERE folderUpperId= ? AND folderLowerId = ?",
				id.getUpperIdPart(), id.getLowerIdPart());
		return query.getNumberOfMatches() > 0;
	}

	public List<FolderItem> getFolderAndRoomItemsInFolder(FolderItem parentFolderItem) {
		assert parentFolderItem != null : "Precondition failed: parentFolderItem != null";

		Query folderAndRoomItemsQuery = createQuery(
				"SELECT upperId, lowerId, createDate, changeDate, colorLabel, owner, title, recycleBinUpperId, recycleBinLowerId, roomPolicy, isHidden "
						+ "FROM " + TABLENAME_FOLDERS
						+ " f LEFT OUTER JOIN rooms r ON f.upperId = r.folderUpperId AND f.lowerId = r.folderLowerId "
						+ "WHERE f.parentFolderUpperId = ? AND f.parentFolderLowerId = ?",
				parentFolderItem.getId().getUpperIdPart(), parentFolderItem.getId().getLowerIdPart());

		return folderAndRoomItemsQuery.mapRows(new ResultSetFunction<FolderItem>() {
			@Override
			public FolderItem apply(ResultSet folderAndRoomResultSet) throws SQLException {
				String titleString = folderAndRoomResultSet.getString("title");
				if (FileTitle.isValidTitle(titleString)) {
					Id id = idFactory.reconstructId(folderAndRoomResultSet.getLong("upperId"),
							folderAndRoomResultSet.getLong("lowerId"));
					FileTitle fileTitle = new FileTitle(titleString);
					Date creation = folderAndRoomResultSet.getTimestamp("createDate");
					Date change = folderAndRoomResultSet.getTimestamp("changeDate");
					String owner = folderAndRoomResultSet.getString("owner");

					String roomPolicyString = folderAndRoomResultSet.getString("roomPolicy");
					boolean isHidden = folderAndRoomResultSet.getBoolean("isHidden");
					// Get IDs as Objects to check if null
					Long recycleBinUpperId = (Long) folderAndRoomResultSet.getObject("recycleBinUpperId");
					Long recycleBinLowerId = (Long) folderAndRoomResultSet.getObject("recycleBinLowerId");

					// Check if row is roomItem
					if (roomPolicyString != null) {
						Query roomUsersQuery = createQuery(
								"SELECT username, isOwner FROM roomusers WHERE roomUpperId = ? AND roomLowerId = ?",
								id.getUpperIdPart(), id.getLowerIdPart());

						Query roomDescriptionQuery = createQuery(
								"SELECT description FROM rooms WHERE folderUpperId = ? AND folderLowerId = ?",
								id.getUpperIdPart(), id.getLowerIdPart());

						final List<String> roomUsers = new ArrayList<String>();
						final List<String> roomOwners = new ArrayList<String>();

						roomUsersQuery.mapRows(new ResultSetFunction<String>() {
							@Override
							public String apply(ResultSet roomUserResultSet) throws SQLException {
								String newUsername = roomUserResultSet.getString("username");

								assert existsUsername(newUsername) : "Precondition failed: existsUsername(newUsername)";

								boolean isOwner = roomUserResultSet.getBoolean("isOwner");
								if (isOwner) {
									roomOwners.add(newUsername);
								} else {
									roomUsers.add(newUsername);
								}
								return null;
							}
						});

						final List<String> roomDescriptions = new ArrayList<String>();
						roomDescriptionQuery.mapRows(new ResultSetFunction<String>() {
							@Override
							public String apply(ResultSet roomsResultSet) throws SQLException {
								String description = "";

								if (!(roomsResultSet.getString("description") == null)) {
									description = roomsResultSet.getString("description");
								}
								;
								roomDescriptions.add(description);
								return null;
							}
						});

						RoomItem roomItem = new RoomItem(id, owner, roomUsers, roomOwners, fileTitle, creation, change,
								RoomPolicy.getRoomPolicy(roomPolicyString), roomDescriptions.get(0));
						roomItem.setIsHidden(isHidden);

						if (id.equals(RoomItem.ROOT_FOLDER_ID)) {
							roomItem = RoomItem.getRootRoomItem(roomItem);
						} else if (id.equals(RoomItem.PUBLIC_FOLDER_ID)) {
							roomItem = RoomItem.getPublicRoomItem(roomItem);
						} else if (id.equals(RoomItem.SYSTEM_FOLDER_ID)) {
							roomItem = RoomItem.getSystemRoomItem(roomItem);
						} else if (id.equals(RoomItem.SHOWROOM_FOLDER_ID)) {
							roomItem = RoomItem.getShowRoomItem(roomItem);
						}

						if (recycleBinUpperId != null && recycleBinLowerId != null) {
							Id recycleBinId = idFactory.reconstructId(recycleBinUpperId, recycleBinLowerId);
							roomItem.setRecycleBinItem(getRecycleBin(getFolderItem(recycleBinId)));
						}
						return roomItem;

					} // If row is not a roomItem it's a folderItem or
						// recycleBinItem
					else {
						String colorLabelString = folderAndRoomResultSet.getString("colorLabel");
						FileItemColorLabel colorLabel = FileItemColorLabel.valueOf(colorLabelString);

						FolderItem folderItem = new FolderItem(id, owner, fileTitle, creation, change, colorLabel,
								SortCriteria.TYPE);
						if (isRecycleBin(folderItem)) {
							return getRecycleBin(folderItem);
						} else {
							return folderItem;
						}
					}
				} else {
					throw new IllegalStateException("Document: " + titleString + " :contains invalid characters");
				}
			}
		});
	}

	private RecycleBinItem getRecycleBin(final Long recycleBinUpperIdPart, final Long recycleBinLowerIdPart) {

		final Query queryRecycleBinItem = createQuery(
				"SELECT title, owner, createdate, changedate FROM folders WHERE upperId = ? AND lowerId = ?",
				recycleBinUpperIdPart, recycleBinLowerIdPart);

		return queryRecycleBinItem.mapFirstRow(new ResultSetFunction<RecycleBinItem>() {
			@Override
			public RecycleBinItem apply(ResultSet resultSet) throws SQLException {
				String fileTitleString = resultSet.getString("title");
				FileTitle fileTitle = new FileTitle(fileTitleString);
				String author = resultSet.getString("owner");

				assert existsUsername(author) : "Precondition failed: existsUsername(author)";

				Date creation = resultSet.getDate("createdate");
				Date change = resultSet.getDate("changedate");

				Id recycleBinId = idFactory.reconstructId(recycleBinUpperIdPart, recycleBinLowerIdPart);

				return new RecycleBinItem(recycleBinId, author, fileTitle, creation, change);
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + queryRecycleBinItem);
			}
		});
	}

	public FolderItem getFolderItem(String username, String[] folderNames)
			throws RecursiveDirectoryException, DirectoryNotFoundException, AccessDeniedException {
		assert folderNames != null : "Precondition failed: folderNames != null";
		assert username != null : "Precondition failed: username != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		RoomItem rootRoomItem = getRootRoomItem();
		FolderItem currentFolderItem = rootRoomItem;

		for (int i = 0; i < folderNames.length; i++) {
			FolderItem nextFolderItem = null;
			List<FolderItem> folderAndRoomItemsInFolder = getFolderAndRoomItemsInFolder(currentFolderItem);
			for (FolderItem folderItem : folderAndRoomItemsInFolder) {
				if (i == 0 && folderItem.getId().toString().equals(folderNames[i])) {
					nextFolderItem = folderItem;
					break;
				}
				if (folderItem.getFileTitle().getTitleString().equals(folderNames[i])) {
					nextFolderItem = folderItem;
					break;
				}
			}

			if (nextFolderItem instanceof RoomItem && !((RoomItem) nextFolderItem).isRoomAccessPermitted(username)) {
				throw new AccessDeniedException();
			} else if (nextFolderItem == null) {
				throw new DirectoryNotFoundException("Can't find " + folderNames[i] + ".");
			} else if (nextFolderItem == currentFolderItem) {
				throw new RecursiveDirectoryException("Folder " + nextFolderItem + " is containig itself.");
			} else {
				currentFolderItem = nextFolderItem;
			}
		}
		return currentFolderItem;
	}

	public DocumentItem getDocumentItem(String fileName, String username, String[] folderNames)
			throws RecursiveDirectoryException, DirectoryNotFoundException, AccessDeniedException,
			DocumentNotFoundException {
		assert fileName != null : "Precondition failed: fileName != null";
		assert username != null : "Precondition failed: username != null";
		assert folderNames != null : "Precondition failed: folderNames != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		FolderItem folderItem = getFolderItem(username, folderNames);
		assert folderItem != null : "Postcondition failed: folderItem != null";

		DocumentItem documentItem = getDocumentItemInFolder(folderItem.getId(), fileName);
		assert documentItem != null : "Postcondition failed: documentItem != null";
		return documentItem;
	}

	public RoomPolicy getRoomPolicy(String roomName) {
		assert roomName != null : "Precondition failed: roomName != null";

		final Query roomPolicyQuery = createQuery(
				"SELECT roomPolicy FROM rooms, folders where rooms.folderUpperId = folders.upperId and rooms.folderLowerId = folders.lowerId AND title = ?",
				roomName);

		return roomPolicyQuery.mapFirstRow(new ResultSetFunction<RoomPolicy>() {
			@Override
			public RoomPolicy apply(ResultSet resultSet) throws SQLException {
				return RoomPolicy.getRoomPolicy(resultSet.getString("roomPolicy"));
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + roomPolicyQuery);
			}
		});
	}

	public List<FolderItem> getAllRecycleBins() {
		Query recycleBinQuery = createQuery("SELECT * FROM " + TABLENAME_RECYCLE_BINS);

		return recycleBinQuery.mapRows(new ResultSetFunction<FolderItem>() {
			@Override
			public FolderItem apply(ResultSet binSet) throws SQLException {
				return getRecycleBin(binSet.getLong("upperId"), binSet.getLong("lowerId"));
			}
		});
	}

	public String getOwnerByDocumentId(Id documentId) {
		Query ownerQuery = createQuery(
				"SELECT owner FROM " + TABLENAME_DOCUMENTS + " where upperId = ? and lowerId = ?",
				documentId.getUpperIdPart(), documentId.getLowerIdPart());

		return ownerQuery.getString();
	}
}
