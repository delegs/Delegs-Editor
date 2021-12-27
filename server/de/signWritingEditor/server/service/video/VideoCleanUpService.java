package de.signWritingEditor.server.service.video;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.server.communication.infrastructure.URLConverterServerImpl;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public class VideoCleanUpService {

	private static final String MEDIA_SERVLET_URL = "esf.mediaservlet.url";
	private static final String VIDEO_CACHE_DIR = "esf.video.cache.dir";
	private static final String VIDEO_UPLOAD_DIR = "esf.video.upload.dir";
	private DocumentXMLConverter xmlConverter;
	private DocumentDb docDB;
	private User user;
	private String uploadDirPath;
	private String cacheDirPath;
	private String servletUrl;

	public VideoCleanUpService(UserDb userDb, SignDB signDB, DocumentDb docDB, SymbolFactory symbolFactory,
			String uploadDirPath, String cacheDirPath, String servletUrl) throws IOException {
		assert userDb != null : "Precondition failed: userDb != null";
		assert signDB != null : "Precondition failed: signDB != null";
		assert docDB != null : "Precondition failed: docDB != null";
		assert symbolFactory != null : "Precondition failed: symbolFactory != null";
		assert uploadDirPath != null : "Precondition failed: uploadDirPath != null";
		assert !uploadDirPath.isEmpty() : "Precondition failed: !uploadDirPath.isEmpty()";
		assert cacheDirPath != null : "Precondition failed: cacheDirPath != null";
		assert servletUrl != null : "Precondition failed: servletUrl != null";

		int uniqueNumber = 3;
		TextbasedTokenStyleFactory textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		xmlConverter = new DocumentXMLConverter(userDb, signDB, symbolFactory, textbasedTokenStyleFactory,
				new PositionedSymbolFactory(), uniqueNumber);
		this.docDB = docDB;

		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(UserRole.AUTHOR);
		user = new User("delegs", "delegs", "delegs", null, true, roles, 1);

		this.uploadDirPath = uploadDirPath;
		this.cacheDirPath = cacheDirPath;
		this.servletUrl = servletUrl;
	}

	public void cleanUpVideos() {

		RoomItem rootRoom = docDB.getRootRoomItem();
		Set<FolderItem> allFolders = new HashSet<FolderItem>();
		addAllSubFolder(allFolders, rootRoom, docDB);

		Map<String, Set<Id>> linkedVideos = new HashMap<String, Set<Id>>();

		for (FolderItem folder : allFolders) {
			List<DocumentItem> allDocumentsInFolder = docDB.getDocumentItemsInFolderNewerThan(folder.getId(),
					"2019-08-01"); // Vorher gab es keinen Upload

			for (DocumentItem doc : allDocumentsInFolder) {

				String xml = docDB.getDocumentContent(doc.getId());
				if (containsDelegsVideoUrl(xml)) {
					Document document = xmlConverter.fromXML(xml, user);

					List<Token> allTokens = document.getTokensFromTo(document.getFirstTokenInDocument().getId(),
							document.getLastTokenInDocument().getId());

					for (Token token : allTokens) {
						if (token instanceof VideoToken) {
							String url = ((VideoToken) token).getUrl();
							if (containsDelegsVideoUrl(url)) {
								String[] segments = url.split("/");
								String videoName = segments[segments.length - 1];
								if (linkedVideos.containsKey(videoName)) {
									linkedVideos.get(videoName).add(doc.getId());
								} else {
									Set<Id> ids = new HashSet<Id>();
									ids.add(doc.getId());
									linkedVideos.put(videoName, ids);
								}
							}
						}
					}
				}
			}
		}

		File uploadDir = new File(uploadDirPath);

		for (File video : uploadDir.listFiles()) {
			// lastModified = creation date, because videos are never modified
			Date videoLastModified = new Date(video.lastModified());
			long oneDay = 24 * 60 * 60 * 1000;
			Date yesterday = new Date(System.currentTimeMillis() - oneDay);

			if (!video.getName().startsWith(".") && videoLastModified.before(yesterday)
					&& !linkedVideos.containsKey(video.getName())) {
				// Cache
				URLConverterServerImpl urlConverter = new URLConverterServerImpl();
				String cacheFileName = urlConverter.encode(servletUrl + "/" + video.getName());

				File cacheDir = new File(cacheDirPath);
				File videoJPG = new File(cacheDir, cacheFileName + ".jpg");
				File videoMP4 = new File(cacheDir, cacheFileName + ".mp4");
				File videoWEBM = new File(cacheDir, cacheFileName + ".webm");

				videoJPG.delete();
				videoMP4.delete();
				videoWEBM.delete();

				// Upload
				video.delete();
			}
		}
	}

	private boolean containsDelegsVideoUrl(String str) {
		if (str.contains(servletUrl)) {
			return true;
		} else if (servletUrl.contains("test")) {
			// Test accepts test and prod urls
			String prodUrl = servletUrl.replaceFirst("test", "");
			return str.contains(prodUrl);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			ConfigurationService configurationService = new ConfigurationService("/ESFConfig.properties");
			DbConnector connector = new DbConnector(configurationService);
			UserDb userDb = new UserDb(connector);
			SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
			SignDB signDB = new SignDB(connector, userDb, symbolFactory, configurationService);
			DocumentDb docDB = new DocumentDb(connector);

			VideoCleanUpService cleaner = new VideoCleanUpService(userDb, signDB, docDB, symbolFactory,
					configurationService.getProperty(VIDEO_UPLOAD_DIR),
					configurationService.getProperty(VIDEO_CACHE_DIR),
					configurationService.getProperty(MEDIA_SERVLET_URL));
			cleaner.cleanUpVideos();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addAllSubFolder(Set<FolderItem> foundFolders, FolderItem currentFolder, DocumentDb docDB) {
		assert foundFolders != null : "Precondition failed: foundFolders != null";
		assert currentFolder != null : "Precondition failed: currentFolder != null";
		assert docDB != null : "Precondition failed: docDB != null";

		Set<FolderItem> subFolder = new HashSet<FolderItem>(docDB.getFolderAndRoomItemsInFolder(currentFolder));
		foundFolders.add(currentFolder);

		for (FolderItem folder : subFolder) {
			foundFolders.add(folder);
			addAllSubFolder(foundFolders, folder, docDB);
		}
	}
}
