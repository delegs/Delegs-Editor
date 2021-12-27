package de.signWritingEditor.client.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Pair;
import de.signWritingEditor.client.service.BrowserHistoryService.BrowserHistoryListener;
import de.signWritingEditor.client.service.infrastructure.IdFactoryMock;
import de.signWritingEditor.client.service.infrastructure.LocalSessionServiceMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.UnitTestCase;
import de.signWritingEditor.server.communication.infrastructure.URLConverterServerImpl;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public class BrowserHistoryServiceImplTest extends UnitTestCase {

	private static final String WWW_DELEGS_DE_DELEGSEDITOR = "www.delegs.de/delegseditor";
	private static final long TIMEOUT = 5;
	private static final String DOCUMENT_NOT_FOUND = "Document not found";

	private BrowserHistoryService browserHistoryService;
	private CountDownLatch lock = new CountDownLatch(1);
	private ChangeableUserLocalSessionServiceMock localSessionService;
	private User registeredUser;
	private User publicUser;

	@Before
	public void setUp() throws IOException {
		registeredUser = new User("user", "testname", "lastName", null, Arrays.asList(new UserRole[] { UserRole.USER }),
				1);
		publicUser = new User("public", "testname", "lastName", null, Arrays.asList(new UserRole[] { UserRole.USER }),
				1);

		localSessionService = new ChangeableUserLocalSessionServiceMock(publicUser);
		URLConverter urlConverter = new URLConverterServerImpl();

		DocumentServiceAsyncMock documentServiceMock = new SampleDocumentAndFolderStructureDocumentServiceMock(
				publicUser, registeredUser);
		browserHistoryService = new BrowserHistoryServiceImpl(localSessionService, documentServiceMock, urlConverter);
	}

	public ChangeableUserLocalSessionServiceMock getLocalSessionService() {
		return localSessionService;
	}

	private class ChangeableUserLocalSessionServiceMock extends LocalSessionServiceMock {

		private User user;

		public void setUser(User user) {
			this.user = user;
		}

		public ChangeableUserLocalSessionServiceMock(User user) {
			this.user = user;
		}

		@Override
		public User getCurrentUser() {
			return user;
		}
	};

	private class SampleDocumentAndFolderStructureDocumentServiceMock extends DocumentServiceAsyncMock {

		List<List<Pair<String, User>>> validStructures;

		public SampleDocumentAndFolderStructureDocumentServiceMock(User publicUser, User registeredUser) {
			super(null);
			validStructures = new ArrayList<List<Pair<String, User>>>();

			List<Pair<String, User>> doc1InPublic = new ArrayList<Pair<String, User>>();
			doc1InPublic.add(new Pair<String, User>("doc1", publicUser));
			validStructures.add(doc1InPublic);

			List<Pair<String, User>> doc1 = new ArrayList<Pair<String, User>>();
			doc1.add(new Pair<String, User>("Öffentlich", publicUser));
			doc1.add(new Pair<String, User>("doc1", publicUser));
			validStructures.add(doc1);

			List<Pair<String, User>> folder = new ArrayList<Pair<String, User>>();
			folder.add(new Pair<String, User>("Öffentlich", publicUser));
			folder.add(new Pair<String, User>("Mathematik", publicUser));
			validStructures.add(folder);

			List<Pair<String, User>> doc1Private = new ArrayList<Pair<String, User>>();
			doc1Private.add(new Pair<String, User>("Öffentlich", registeredUser));
			doc1Private.add(new Pair<String, User>("Entwickler", registeredUser));
			doc1Private.add(new Pair<String, User>("doc1", registeredUser));
			validStructures.add(doc1Private);
		}

		private DocumentItem searchValidFile(User user, String filename, String[] folders)
				throws DocumentNotFoundException {
			List<Pair<String, User>> searchValidFolder = searchValidFolderPath(user, folders);
			Pair<String, User> documentInFolder = searchValidFolder.get(folders.length);
			if (documentInFolder.getA().equals(filename) && documentInFolder.getB().equals(user)) {
				return createDummyFile(documentInFolder.getA(), documentInFolder.getB().getUsername());
			}
			throw new DocumentNotFoundException();
		}

		private DocumentItem createDummyFile(String title, String owner) {
			Id createId = (new IdFactoryMock()).createId();
			FileTitle fileTitle = new FileTitle(title);
			return new DocumentItem(createId, owner, fileTitle, new Date(), new Date(), FileItemColorLabel.NONE);
		}

		private FolderItem createDummyFolder(String title, String user) {
			IdFactory idFactory = new IdFactoryMock();
			FileTitle fileTitle = new FileTitle(title);
			FolderItem folderItem = new FolderItem(idFactory.createId(), user, fileTitle, new Date(), new Date(),
					FileItemColorLabel.NONE, SortCriteria.TYPE);
			return folderItem;
		}

		private List<Pair<String, User>> searchValidFolderPath(User user, String[] folders) {
			for (List<Pair<String, User>> folderOrFilePath : validStructures) {
				boolean found = true;
				for (int i = 0; i < folders.length; i++) {
					Pair<String, User> folder = folderOrFilePath.get(i);
					if (!folder.getA().equals(folders[i]) || !folder.getB().equals(user)) {
						found = false;
						break;
					}
				}
				if (found) {
					return folderOrFilePath;
				}
			}
			return null;
		}

		private FolderItem searchValidFolder(User user, String[] folders) {
			List<Pair<String, User>> searchValidFolder = searchValidFolderPath(user, folders);
			FolderItem result = null;
			if (searchValidFolder != null) {
				Pair<String, User> folder = searchValidFolder.get(folders.length - 1);
				result = createDummyFolder(folder.getA(), folder.getB().getUsername());
			}
			return result;
		}

		@Override
		public void getFolderItem(SessionKey sessionKey, String[] folderNames, AsyncCallback<FolderItem> callback) {
			FolderItem folderItem = searchValidFolder(getLocalSessionService().getCurrentUser(), folderNames);
			callback.onSuccess(folderItem);
		}

		@Override
		public void getDocumentItem(SessionKey sessionKey, String fileTitle, String[] folderNames,
				AsyncCallback<DocumentItem> callback) {
			DocumentItem documentItem;
			try {
				documentItem = searchValidFile(getLocalSessionService().getCurrentUser(), fileTitle, folderNames);
				callback.onSuccess(documentItem);
			} catch (Exception e) {
				if (e instanceof DocumentNotFoundException)
					throw new RuntimeException(DOCUMENT_NOT_FOUND);
			}
		}
	};

	private class CheckForEmptyFileListener implements BrowserHistoryListener {

		@Override
		public void onDefaultFileItemRequested() {
			// Check
			lock.countDown();
		}

		@Override
		public void onFileItemAccessDenied() {
			// Check
			lock.countDown();
		}

		@Override
		public void onDocumentItemRequested(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem) {
			// Check
			assertEquals(null, documentItem);
			lock.countDown();
		}

		@Override
		public void onFolderItemRequested(FolderItem folderItem) {
			// Check
			assertEquals(null, folderItem);
			lock.countDown();
		}

		@Override
		public void onSessionInvalid() {
			fail();
		}
	};

	private class CheckForDocumentItemListener implements BrowserHistoryListener {
		private String fileTitle;

		public CheckForDocumentItemListener(String fileTitle) {
			this.fileTitle = fileTitle;
		}

		@Override
		public void onDefaultFileItemRequested() {
			onDocumentItemRequested(null, null);
		}

		@Override
		public void onFileItemAccessDenied() {
		}

		@Override
		public void onDocumentItemRequested(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem) {
			// Check
			assertNotNull(documentItem);
			assertEquals(DocumentItem.class, documentItem.getClass());
			assertEquals(documentItem.getFileTitle().getTitleString(), fileTitle);
			lock.countDown();
		}

		@Override
		public void onFolderItemRequested(FolderItem folderItem) {
			fail("no folder item expected");
		}

		@Override
		public void onSessionInvalid() {
			fail();
		}
	}

	private class CheckForFolderItemListener implements BrowserHistoryListener {
		private String folderTitle;

		public CheckForFolderItemListener(String folderTitle) {
			this.folderTitle = folderTitle;
		}

		@Override
		public void onDefaultFileItemRequested() {
			onFolderItemRequested(null);
		}

		@Override
		public void onFileItemAccessDenied() {
		}

		@Override
		public void onDocumentItemRequested(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem) {
			fail("no document item expected");
		}

		@Override
		public void onFolderItemRequested(FolderItem folderItem) {
			// Check
			assertNotNull("Expected to receive a file.", folderItem);
			assertEquals(FolderItem.class, folderItem.getClass());
			assertEquals(folderItem.getFileTitle().getTitleString(), folderTitle);
			lock.countDown();
		}

		@Override
		public void onSessionInvalid() {
			fail();
		}
	}

	@Test
	public void testAnalyzeUrlForRootPath() throws InterruptedException {
		// Prepare
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR);

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForHash() throws InterruptedException {
		// Prepare
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#");

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForDocumentInFolder() throws InterruptedException {
		// Prepare
		String documentName = "doc1";
		browserHistoryService.setBrowserHistoryListener(new CheckForDocumentItemListener(documentName));

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#Öffentlich/" + documentName);

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForNotExistingDocument() throws InterruptedException {
		// Prepare
		String documentNameThatDoesNotExist = "Lannister";
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + documentNameThatDoesNotExist);

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForNotExistingDocumentInFolder() throws InterruptedException {
		// Prepare
		String documentNameThatDoesNotExist = "Lannister";
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "Mathematik/" + documentNameThatDoesNotExist);

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForDocumentInNotExistingFolder() throws InterruptedException {
		// Prepare
		String documentName = "doc1";
		String folderThatDoesNotExist = "FolderThatDoesNotExist";
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + folderThatDoesNotExist + "/" + documentName);

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForFolder() throws InterruptedException {
		// Prepare
		String folderName = "Öffentlich";
		browserHistoryService.setBrowserHistoryListener(new CheckForFolderItemListener(folderName));

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#" + folderName + "/");

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlForFolderWithNoSlashAndTreatedAsFile() throws InterruptedException {
		// Prepare
		String folderName = "Öffentlich";
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		try {
			browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#" + folderName);
			fail("Document not found exception expected.");
		} catch (Exception e) {
			assertEquals(DOCUMENT_NOT_FOUND, e.getMessage());
		}
	}

	@Test
	public void testAnalyzeUrlForSubFolderWithNoSlashAndTreatedAsFile() throws InterruptedException {
		// Prepare
		String folderName = "Öffentlich";
		String subfolderName = "Mathematik";
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		try {
			browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#" + folderName + "/" + subfolderName);
			fail("Document not found exception expected.");
		} catch (Exception e) {
			assertEquals(DOCUMENT_NOT_FOUND, e.getMessage());
		}
	}

	@Test
	public void testAnalyzeUrlUserAccessToFolder() throws InterruptedException {
		// Prepare
		String folderName = "Entwickler";
		getLocalSessionService().setUser(registeredUser);
		browserHistoryService.setBrowserHistoryListener(new CheckForFolderItemListener(folderName));

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#Öffentlich/" + folderName + "/");

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testAnalyzeUrlUserAccessDeniedToFolder() throws InterruptedException {
		// Prepare
		String folderWithNoAccess = "Entwickler";
		getLocalSessionService().setUser(publicUser);
		browserHistoryService.setBrowserHistoryListener(new CheckForEmptyFileListener());

		// Action
		browserHistoryService.navigateToUrl(WWW_DELEGS_DE_DELEGSEDITOR + "#Öffentlich/" + folderWithNoAccess + "/");

		// Check
		assertTrue(lock.await(TIMEOUT, TimeUnit.SECONDS));
	}

	@Test
	public void testIsInStandardLocation() {
		String nonStandardFolder = "Entwickler/";

		assertTrue(browserHistoryService.isInNewDocument(WWW_DELEGS_DE_DELEGSEDITOR));
		assertTrue(browserHistoryService.isInNewDocument(WWW_DELEGS_DE_DELEGSEDITOR + "#"));
		assertFalse(browserHistoryService.isInNewDocument(WWW_DELEGS_DE_DELEGSEDITOR + "#" + nonStandardFolder));
	}

}
