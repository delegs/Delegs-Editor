package de.signWritingEditor.server.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.badge.service.BadgePersistenceServiceImpl;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.server.service.video.VideoCleanUpService;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class ServletContextListenerImpl implements ServletContextListener {

	private static final Logger LOGGER = Logger.getLogger(ServletContextListenerImpl.class);
	private static final Timer IMPORT_TIMER = new Timer();

	private final static String PROPERTY_IMPORT_TIME = "esf.db.importTime";
	private final static String PROPERTY_IMPORT_SIGNPUDDLE_ON_STARTUP = "esf.startup.importSignpuddle";
	private static final String MEDIA_SERVLET_URL = "esf.mediaservlet.url";
	private static final String VIDEO_CACHE_DIR = "esf.video.cache.dir";
	private static final String VIDEO_UPLOAD_DIR = "esf.video.upload.dir";
	private DbConnector dbConnector;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		IMPORT_TIMER.cancel();
		LOGGER.info("Import timer stopped");
		DbConnector.shutDownConnectionPool();
		LOGGER.info("ComboPooledDataSource closed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("starting application");

		if (!PasswordHashUtil.isWorking()) {
			LOGGER.error("Initialising of the Hashsystem with SHA256 failed.");
			throw new RuntimeException("Initialising of the Hashsystem with SHA256 failed.");
		}

		try {
			ConfigurationService configurationService = new ConfigurationService();
			dbConnector = new DbConnector(configurationService);

			DocumentDb documentDb = new DocumentDb(dbConnector);

			final SessionServiceImpl sessionService = new SessionServiceImpl(configurationService);
			final BadgePersistenceServiceImpl badgeServiceImpl = new BadgePersistenceServiceImpl(dbConnector,
					sessionService);

			int importTime = Integer.parseInt(configurationService.getProperty(PROPERTY_IMPORT_TIME));

			UserDb userDb = new UserDb(dbConnector);
			SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(dbConnector).getAllSymbols());
			SignDB signDB = new SignDB(dbConnector, userDb, symbolFactory, configurationService);
			final VideoCleanUpService videoCleanupService = new VideoCleanUpService(userDb, signDB, documentDb,
					symbolFactory, configurationService.getProperty(VIDEO_UPLOAD_DIR),
					configurationService.getProperty(VIDEO_CACHE_DIR),
					configurationService.getProperty(MEDIA_SERVLET_URL));

			// Since server is restarted at 3 am (cache reset), import is
			// scheduled for 2 am
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, importTime);
			cal.set(Calendar.MINUTE, 0);

			IMPORT_TIMER.schedule(new TimerTask() {
				@Override
				public void run() {
					LOGGER.info("Starting scheduled SignPuddle import");
					ImportSignPuddleDataService.importData();

					/*
					 * TODO Das ist eine temporäre Lösung, damit die S2M Videos
					 * nicht jeden Tag neu konvertiert werden müssen. In Zukunft
					 * sollte der Cache intelligenter gebaut werden, so dass er
					 * nur die Videos löscht, die auch schon längere Zeit nicht
					 * mehr abgefragt wurden. Außerdem sollte ggfs. die Größe
					 * des Caches begrenzt werden.
					 */

                    videoCleanupService.cleanUpVideos();
					badgeServiceImpl.createReport();
					sessionService.removeExpiredUserSessions();
					CleanUpFoldersService.cleanUpPublicRoom();
					CleanUpFoldersService.cleanUpRecycleBins();
				}
			}, cal.getTime(), 1000 * 60 * 60 * 24);
			LOGGER.info("Import timer started. Import will start at " + importTime + " o'clock.");

			if (Boolean.parseBoolean(configurationService.getProperty(PROPERTY_IMPORT_SIGNPUDDLE_ON_STARTUP))) {
				LOGGER.info("Starting SignPuddle import (Server startup routine...)");
				ImportSignPuddleDataService.importData();
			}
			LOGGER.info("Server started successfully.");

		} catch (IOException e) {
			LOGGER.error("Starting import timer failed. Could not find properties files. " + e.getMessage(), e);
		}
	}
}
