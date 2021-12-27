package de.signWritingEditor.server.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;

public class CleanUpFoldersService {

	private static final Logger LOG = Logger.getLogger(CleanUpFoldersService.class);
	private static final int FILE_AGE_TO_DELETE = 30;

	public static void cleanUpPublicRoom(DocumentDb documentDb) {
		LOG.info("Starting Clean-Up Playground service...");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -FILE_AGE_TO_DELETE);
		Date date = c.getTime();

		FolderItem folderItem = documentDb.getFolderItem(FolderItem.PUBLIC_FOLDER_ID);

		deleteOldDocumentsInAllSubFoldersAndEmptyFolders(folderItem, date, documentDb);
		LOG.info("Done cleaning up Playground.");

	}

	public static void cleanUpRecycleBins(DocumentDb documentDb) {
		LOG.info("Sarting Clean-up Recyclebins...");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -FILE_AGE_TO_DELETE);
		Date date = c.getTime();

		List<FolderItem> bins = documentDb.getAllRecycleBins();

		for (FolderItem bin : bins) {
			deleteOldDocumentsInAllSubFoldersAndEmptyFolders(bin, date, documentDb);
		}
		LOG.info("Done cleaning up Recyclebins.");
	}

	private static void deleteOldDocumentsInAllSubFoldersAndEmptyFolders(FolderItem folderItem, Date date,
			DocumentDb documentDb) {
		deleteOldDocumentsInFolder(folderItem, date, documentDb);

		for (FolderItem subFolder : documentDb.getFolderAndRoomItemsInFolder(folderItem)) {
			if (!documentDb.isRecycleBin(subFolder)) {
				deleteOldDocumentsInAllSubFoldersAndEmptyFolders(subFolder, date, documentDb);
				deleteFolderIfEmpty(subFolder, documentDb);
			}
		}
	}

	private static void deleteOldDocumentsInFolder(FolderItem folderItem, Date date, DocumentDb documentDb) {
		List<DocumentItem> documents = documentDb.getDocumentItemsInFolder(folderItem.getId());

		for (DocumentItem document : documents) {
			if (document.getChangeDate().before(date)) {
				documentDb.deleteDocument(document.getId());
			}
		}
	}

	private static void deleteFolderIfEmpty(FolderItem folder, DocumentDb documentDb) {
		List<DocumentItem> documents = documentDb.getDocumentItemsInFolder(folder.getId());
		List<FolderItem> subFolders = documentDb.getFolderAndRoomItemsInFolder(folder);

		if (documents.isEmpty() && subFolders.isEmpty()) {
			documentDb.deleteFolder(folder.getId());
		}
	}

	public static void cleanUpPublicRoom() {
		DbConnector connector = null;
		ConfigurationService configurationService;
		try {
			configurationService = new ConfigurationService();
			connector = new DbConnector(configurationService);
			DocumentDb documentDb = new DocumentDb(connector);

			cleanUpPublicRoom(documentDb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cleanUpRecycleBins() {
		DbConnector connector = null;
		ConfigurationService configurationService;
		try {
			configurationService = new ConfigurationService();
			connector = new DbConnector(configurationService);
			DocumentDb documentDb = new DocumentDb(connector);

			cleanUpRecycleBins(documentDb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}