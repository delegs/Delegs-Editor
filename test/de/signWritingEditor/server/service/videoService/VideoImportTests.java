package de.signWritingEditor.server.service.videoService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.VideoServiceImpl;

public class VideoImportTests {

	private static final String TEST_VIDEO_DIR = "misc/testVideos/";
	private static final String VIDEO_CACHE_PROPERTY = "esf.video.cache.dir";
	ConfigurationService service;
	private File videoCacheFolder;

	@Before
	public void setUp() {
		try {
			service = new ConfigurationService("/ESFConfig_Junit.properties");
			String videoCacheProperty = service.getProperty(VIDEO_CACHE_PROPERTY);
			String debugMessage = String.format("The ESFConfig.properties file does not contain an entry %s",
					VIDEO_CACHE_PROPERTY);
			assertNotNull(debugMessage, videoCacheProperty);
			videoCacheFolder = new File(videoCacheProperty);
			assertNotNull(videoCacheFolder);

		} catch (IOException e) {
			System.out.println("Failed to find config");
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateVideoFolder() {
		// Preparation
		removeCacheFolder();

		assertFalse("VideoCacheFolder does still exist!", videoCacheFolder.exists());

		// Action
		new VideoServiceImpl(service);

		// Test
		String debugMessage = String.format("The video cache folder in %s does not exist",
				videoCacheFolder.getAbsolutePath());
		assertTrue(debugMessage, videoCacheFolder.exists());
		assertTrue(videoCacheFolder.isDirectory());
	}

	@Test
	public void testConvertMP4Video() {

		removeCacheFolder();

		VideoServiceImpl videoService = new VideoServiceImpl(service);

		String videoUrl = TEST_VIDEO_DIR + "test1.mp4";
		File videoFile = new File(videoUrl);
		assertTrue("Video does not exist", videoFile.exists());

		// Action
		videoService.loadVideoFromUrl(videoFile.getAbsolutePath());

		// Test
		String[] videoAndImageFileNames = videoCacheFolder.list();
		List<String> listOfFileNames = new ArrayList<String>();
		for (String file : videoAndImageFileNames) {
			listOfFileNames.add(file);
		}

		String fileName = videoService.urlEncode(videoFile.getAbsolutePath());

		assertTrue("jpg File missing", listOfFileNames.contains(fileName + ".jpg"));
		assertTrue("mp4 File missing", listOfFileNames.contains(fileName + ".webm"));
		assertEquals(2, listOfFileNames.size());
	}

	@Test
	public void testConvertWebmVideo() {

		removeCacheFolder();

		VideoServiceImpl videoService = new VideoServiceImpl(service);

		String videoUrl = TEST_VIDEO_DIR + "test1.webm";
		File videoFile = new File(videoUrl);
		assertTrue("Video does not exist", videoFile.exists());

		// Action
		videoService.loadVideoFromUrl(videoFile.getAbsolutePath());
		// Test
		String[] videoAndImageFileNames = videoCacheFolder.list();
		List<String> listOfFileNames = new ArrayList<String>();
		for (String file : videoAndImageFileNames) {
			listOfFileNames.add(file);
		}

		String fileName = videoService.urlEncode(videoFile.getAbsolutePath());

		assertTrue("jpg File missing", listOfFileNames.contains(fileName + ".jpg"));
		assertTrue("webM File missing", listOfFileNames.contains(fileName + ".webm"));
		assertEquals(2, listOfFileNames.size());
	}

	@Test
	public void testConvertMP4VideoTwice() {

		removeCacheFolder();

		VideoServiceImpl videoService = new VideoServiceImpl(service);

		String videoUrl = TEST_VIDEO_DIR + "test1.mp4";
		File videoFile = new File(videoUrl);
		assertTrue("Video does not exist", videoFile.exists());

		// Action
		videoService.loadVideoFromUrl(videoFile.getAbsolutePath());
		String fileName = videoService.urlEncode(videoFile.getAbsolutePath());
		File resultFile = new File(videoCacheFolder, fileName + ".mp4");
		long lastModified = resultFile.lastModified();
		videoService.loadVideoFromUrl(videoFile.getAbsolutePath());

		// Test
		String[] videoAndImageFileNames = videoCacheFolder.list();

		assertEquals(lastModified, resultFile.lastModified());
		assertEquals(2, videoAndImageFileNames.length);
	}

	private void removeCacheFolder() {
		if (videoCacheFolder.isDirectory())
			for (String filenName : videoCacheFolder.list()) {
				File fileToDelete = new File(videoCacheFolder, filenName);
				fileToDelete.delete();
			}

		videoCacheFolder.delete();
	}
}