package de.signWritingEditor.server.service.videoService;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.server.communication.infrastructure.URLConverterServerImpl;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.video.VideoCleanUpService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class VideoCleanUpServiceTest {

	private static final int ONE_DAY_MILLIS = 24 * 60 * 60 * 1000;
	private static final Id TEST_DOCUMENT_ID = new IdFactory(3).createId();
	private static final String VIDEO_UPLOAD_DIR = "videotestDir";
	private static final String VIDEO_CACHE_DIR = "videoCacheDir";
	private static final File testFolder = new File(VIDEO_UPLOAD_DIR);
	private static final File cacheFolder = new File(VIDEO_CACHE_DIR);
	private static final String SERVLET_URL = "https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet";
	private static final String USER_NAME = "delegs_JUNIT";

	private static VideoCleanUpService cleaner;
	private static DocumentDb docDB;
	private static UserDb userDb;
	private static Id testRoomId;

	@BeforeClass
	@Ignore
	public static void IGNORE_setUpBeforeClass() throws Exception {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		DbConnector connector = new DbConnector(configurationService);
		userDb = new UserDb(connector);
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		SignDB signDB = new SignDB(connector, userDb, symbolFactory, configurationService);
		docDB = new DocumentDb(connector);
		cleaner = new VideoCleanUpService(userDb, signDB, docDB, symbolFactory, VIDEO_UPLOAD_DIR, VIDEO_CACHE_DIR,
				SERVLET_URL);

		userDb.saveUser(new User(USER_NAME, "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
				PasswordHashUtil.hash("TestPasswort"));
		testRoomId = docDB.createNewRoomWithRecycleBin(new FileTitle("JUNIT_TEST_ROOM"), Arrays.asList(USER_NAME),
				Arrays.asList(USER_NAME), RoomPolicy.SHARED_CONTENT, true, "Hier wird getestet.");
	}

	@Before
	@Ignore
	public void IGNORE_setup() {
		testFolder.mkdir();
		cacheFolder.mkdir();
	}

	@After
	@Ignore
	public void IGNORE_tearDown() throws Exception {
		FileUtils.deleteDirectory(testFolder);
		FileUtils.deleteDirectory(cacheFolder);
		if (docDB.existsDocument(TEST_DOCUMENT_ID)) {
			docDB.deleteDocument(TEST_DOCUMENT_ID);
		}
	}

	@Test
	@Ignore
	public void INGORE_testEmptyFolderStaysEmpty() {
		assertEquals(0, testFolder.listFiles().length);

		cleaner.cleanUpVideos();

		assertEquals(0, testFolder.listFiles().length);
	}

	@Test
	@Ignore
	public void INGORE_testDeleteUnlinkedFilesOlderThanOneDay() throws IOException {
		File testFile0 = new File(VIDEO_UPLOAD_DIR + "/foo.mp4");
		File testFile1 = new File(VIDEO_UPLOAD_DIR + "/bar.mov");
		File testFile2 = new File(VIDEO_UPLOAD_DIR + "/baz.webm");
		testFile0.createNewFile();
		testFile0.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);
		testFile1.createNewFile();
		testFile1.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);
		testFile2.createNewFile();
		testFile2.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);

		assertEquals(3, testFolder.listFiles().length);

		cleaner.cleanUpVideos();

		assertEquals(0, testFolder.listFiles().length);
	}

	@Test
	@Ignore
	public void INGORE_testDontDeleteLinkedFilesNewThanOneDay() throws IOException {
		File testFile0 = new File(VIDEO_UPLOAD_DIR + "/foo.mp4");
		File testFile1 = new File(VIDEO_UPLOAD_DIR + "/bar.mov");
		File testFile2 = new File(VIDEO_UPLOAD_DIR + "/baz.webm");
		testFile0.createNewFile();
		testFile1.createNewFile();
		testFile2.createNewFile();
		createTestDocumentInDb();
		assertEquals(3, testFolder.listFiles().length);

		cleaner.cleanUpVideos();

		assertEquals(3, testFolder.listFiles().length);
	}

	@Test
	@Ignore
	public void INGORE_testOnlyDeleteUnlinkedFilesOlderThanOneDay() throws IOException {
		File testFile0 = new File(VIDEO_UPLOAD_DIR + "/foo.mp4");
		File testFile1 = new File(VIDEO_UPLOAD_DIR + "/bar.mov");
		File testFile2 = new File(VIDEO_UPLOAD_DIR + "/baz.webm");
		File testFileIgel = new File(VIDEO_UPLOAD_DIR + "/igel.MoV");
		File testFileAffe = new File(VIDEO_UPLOAD_DIR + "/affe.png");
		testFile0.createNewFile();
		testFile1.createNewFile();
		testFile2.createNewFile();
		testFileIgel.createNewFile();
		testFileIgel.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);
		testFileAffe.createNewFile();
		testFileAffe.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS / 2);
		createTestDocumentInDb();
		assertEquals(5, testFolder.listFiles().length);

		cleaner.cleanUpVideos();

		assertEquals(4, testFolder.listFiles().length);
	}

	public void createTestDocumentInDb() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<document name=\"JUNIT_TEST_VIDEO_CLEANUP\" region=\"DGS\" pageDimension=\"A4 Hochformat\" documentVersion=\"1.6\" isGlossWritingActive=\"true\" automaticFreeTextLineEnabled=\"true\" collagePositioningGridVisibility=\"true\" lockedLayout=\"false\" lockedContent=\"false\"><section collage=\"false\" lockedLayout=\"false\" lockedContent=\"false\"><paragraph freeTextVisible=\"true\" searchWordsVisible=\"true\" signsVisible=\"true\" id=\"716395190084001:1\" paragraphPositionX=\"0\" paragraphPositionY=\"0\" paragraphWidth=\"0\" automaticResize=\"false\" zindex=\"0\" lockedLayout=\"false\" lockedContent=\"false\"><token tokenType=\"videoToken\" id=\"716395190084001:4\" videoTokenUrl=\"https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet/foo.mp4\" videoTokenUrlVisible=\"true\" videoTokenWidth=\"220\" videoTokenHeight=\"207\" videoTokenColor=\"#808080\" backgroundColor=\"#808080\" lockedLayout=\"false\" lockedContent=\"false\" /><token tokenType=\"videoToken\" id=\"716395190084001:5\" videoTokenUrl=\"https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet/bar.mov\" videoTokenUrlVisible=\"true\" videoTokenWidth=\"220\" videoTokenHeight=\"207\" videoTokenColor=\"#808080\" backgroundColor=\"#808080\" lockedLayout=\"false\" lockedContent=\"false\" /><token tokenType=\"videoToken\" id=\"716395190084001:6\" videoTokenUrl=\"https://apps.delegs.de/delegseditormedia/DelegsVideoSupplierServlet/baz.webm\" videoTokenUrlVisible=\"true\" videoTokenWidth=\"220\" videoTokenHeight=\"207\" videoTokenColor=\"#808080\" backgroundColor=\"#808080\" lockedLayout=\"false\" lockedContent=\"false\" /></paragraph></section></document>\r\n"
				+ "";
		docDB.saveDocument(TEST_DOCUMENT_ID, new FileTitle("JUNIT_TEST_VIDEO_CLEANUP"), xml, USER_NAME, testRoomId);
	}

	@Test
	@Ignore
	public void INGORE_testClearsVideoCacheForDeletedFiles() throws IOException {
		File testFile0 = new File(VIDEO_UPLOAD_DIR + "/foo.mp4");
		File testFile1 = new File(VIDEO_UPLOAD_DIR + "/bar.mov");
		File testFile2 = new File(VIDEO_UPLOAD_DIR + "/baz.webm");
		File testFileIgel = new File(VIDEO_UPLOAD_DIR + "/igel.MoV");
		File testFileAffe = new File(VIDEO_UPLOAD_DIR + "/affe.png");
		testFile0.createNewFile();
		testFile1.createNewFile();
		testFile2.createNewFile();
		testFileIgel.createNewFile();
		testFileIgel.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);
		testFileAffe.createNewFile();
		testFileAffe.setLastModified(System.currentTimeMillis() - ONE_DAY_MILLIS);
		createTestDocumentInDb();
		assertEquals(5, testFolder.listFiles().length);

		URLConverterServerImpl urlConverter = new URLConverterServerImpl();
		File cacheFile0 = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "foo.mp4.webm"));
		File cacheFile1 = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "bar.mov.mp4"));
		File cacheFile2 = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "baz.webm.webm"));
		File cacheFileIgel = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "igel.MoV.mp4"));

		File cacheFile0Jpg = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "foo.mp4.jpg"));
		File cacheFile1Jpg = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "bar.mov.jpg"));
		File cacheFile2Jpg = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "baz.webm.jpg"));
		File cacheFileIgelJpg = new File(cacheFolder, urlConverter.encode(SERVLET_URL + "/" + "igel.MoV.jpg"));

		cacheFile0.createNewFile();
		cacheFile1.createNewFile();
		cacheFile2.createNewFile();
		cacheFileIgel.createNewFile();

		cacheFile0Jpg.createNewFile();
		cacheFile1Jpg.createNewFile();
		cacheFile2Jpg.createNewFile();
		cacheFileIgelJpg.createNewFile();

		assertEquals(8, cacheFolder.listFiles().length);

		cleaner.cleanUpVideos();

		assertEquals(3, testFolder.listFiles().length);
		assertEquals(6, cacheFolder.listFiles().length);
	}

}
