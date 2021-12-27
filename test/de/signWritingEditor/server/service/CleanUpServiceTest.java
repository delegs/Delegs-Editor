package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.infrastructure.DocumentDbMock;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.shared.model.material.FolderItem;

public class CleanUpServiceTest {
	private DocumentDbMock documentDb;

	@Before
	public void setUp() {
		DbConnector connector = null;
		ConfigurationService configurationService;
		try {
			configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
			connector = new DbConnector(configurationService);
			documentDb = new DocumentDbMock(connector);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCleanUpPublicFolder() {
		CleanUpFoldersService.cleanUpPublicRoom(documentDb);
		assertEquals(1, documentDb.getDocumentItemsInFolder(FolderItem.PUBLIC_FOLDER_ID).size());

		List<FolderItem> folders = documentDb
				.getFolderAndRoomItemsInFolder(documentDb.getFolderItem(FolderItem.PUBLIC_FOLDER_ID));
		assertEquals(2, folders.size());

		FolderItem folder2 = null;
		for (FolderItem item : folders) {
			if (!documentDb.isRecycleBin(item)) {
				folder2 = item;
			}
		}
		assertEquals(1, documentDb.getDocumentItemsInFolder(folder2.getId()).size());
	}

	@Test
	public void testCleanUpRecycleBin() {
		CleanUpFoldersService.cleanUpRecycleBins(documentDb);
		FolderItem recycleBin = documentDb.getAllRecycleBins().get(0);
		assertEquals(1, documentDb.getDocumentItemsInFolder(recycleBin.getId()).size());
	}

}
