package de.signWritingEditor.shared.infrastructure.migration;

import de.signWritingEditor.server.persistence.DBUpdater;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.service.ConfigurationService;

/*
 * Configure the database, that should be migrated via the /config/ESFConfig.properties file (key: esf.db.url).
 */
public class DbMigrator {
	private static DbConnector connector;

	public static void main(String[] args) {
		short exitValue = migrate();
		System.exit(exitValue);
	}

	private static short migrate() {
		short successValue = -1;
		try {
			ConfigurationService configService = new ConfigurationService();
			connector = new DbConnector(configService);
			DBUpdater dbUpdater = new DBUpdater(connector, configService);
			if (dbUpdater.isDatabaseOutOfDate()) {
				dbUpdater.updateDatabase();
			}
			successValue = 0;
		} catch (Exception e) {
			System.err.println("Error migrating database:");
			e.printStackTrace();
		} finally {
			if (connector != null) {
				connector = null;
			}
		}
		return successValue;
	}
}