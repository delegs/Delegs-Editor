package de.signWritingEditor.server.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.VersionNumber;

public class DBUpdater extends MaterialDB {
	private static final String PROPERTY_VERSION = "esf.app.version";
	private static final String PROPERTY_DB_SCHEMA_NAME = "esf.db.schemaName";
	private static final String PROPERTY_MIGRATION_URL = "esf.migration.url";

	private static final Logger LOG = Logger.getLogger(DBUpdater.class);

	private final ConfigurationService configurationService;
	private final DbConnector connector;

	public DBUpdater(DbConnector connector, ConfigurationService configurationService) {
		super(connector);
		assert configurationService != null : "Precondition failed: configurationService != null";

		this.connector = connector;
		this.configurationService = configurationService;
	}

	public void updateDatabase() throws Exception {
		assert isDatabaseVersioned() : "Precondition failed: isDatabaseVersioned()";
		assert isDatabaseOutOfDate() : "Precondition failed: isDatabaseOutOfDate()";

		String dbSchemaName = configurationService.getProperty(PROPERTY_DB_SCHEMA_NAME);
		try {
			while (isDatabaseOutOfDate()) {
				VersionNumber databaseVersion = getDatabaseVersion();
				LOG.info("Updating database " + dbSchemaName + " from version " + databaseVersion);

				executeSqlFile(getMigrationFile(databaseVersion));

			}
			LOG.info("Database " + dbSchemaName + " is up to date at version " + getDatabaseVersion());
		} catch (Exception e) {
			LOG.error("Could not complete updating database " + dbSchemaName + " : " + e.getMessage(), e);
			throw e;
		}
	}

	public boolean isDatabaseOutOfDate() {
		assert isDatabaseVersioned() : "Precondition failed: isDatabaseVersioned()";

		return getApplicationVersion().compareTo(getDatabaseVersion()) > 0;
	}

	public boolean isDatabaseVersioned() {
		if (isDatabaseEmpty()) {
			// Empty database has version 0.0
			return true;
		} else {

			String queryString = "SELECT count(*) FROM information_schema.tables WHERE table_schema = '"
					+ configurationService.getProperty(PROPERTY_DB_SCHEMA_NAME) + "' AND table_name = 'version'";
			Query query = createQuery(queryString);
			int i = query.getNumberOfMatches();
			return i > 0;
		}
	}

	private File getMigrationFile(final VersionNumber databaseVersion) {
		assert databaseVersion != null : "Precondition failed: databaseVersion != null";

		File result = null;
		File migrationDirectory = new File(configurationService.getProperty(PROPERTY_MIGRATION_URL));

		assert migrationDirectory.exists() : "Assertion failed: migrationDirectory.exists()";
		assert migrationDirectory.isDirectory() : "Assertion failed: migrationDirectory.isDirectory()";

		File[] sqlFiles = migrationDirectory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String fileName) {
				return fileName.startsWith("v" + databaseVersion.toString() + "-to")
						&& fileName.toLowerCase().endsWith(".sql");
			}
		});

		if (sqlFiles != null && sqlFiles.length > 0) {
			result = sqlFiles[0];
		} else {
			LOG.error("Migration file for database version " + databaseVersion.toString() + " is missing");
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void executeSqlFile(File sqlFile) throws Exception {
		assert sqlFile != null : "Precondition failed: sqlFile != null";
		assert sqlFile.exists() : "Precondition failed: sqlFile.exists()";

		try (Connection connection = connector.getConnection()) {
			connection.setAutoCommit(false);
			try {
				BufferedReader file;
				StringBuilder sqlStringBuilder = new StringBuilder();
				file = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "UTF8"));

				String line;
				while ((line = file.readLine()) != null) {
					sqlStringBuilder.append(line).append("\n");
				}
				file.close();

				String sql = sqlStringBuilder.toString();

				executeSql(sql, connection);
				connection.commit();
			} catch (SQLException e) {
				// It is strongly recommended that an application explicitly
				// commits or rolls back an active transaction prior to calling
				// the close method. If the close method is called and there is
				// an active transaction, the results are
				// implementation-defined.
				// https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html#close()
				connection.rollback();
				throw e;
			} finally {
				// not strictly required, as c3p0 resets "closed" connections
				// anyway
				connection.setAutoCommit(true);
			}
		}
	}

	private void executeSql(String sqlString, Connection connection) throws Exception {
		assert sqlString != null : "Precondition failed: sqlString != null";

		String[] statements = sqlString.split(";\n");

		LOG.info("Starting SQL execution: " + statements.length + " statements");
		int statementCounter = 0;

		for (String statement : statements) {
			String trimmedStatement = statement.trim();

			if (!trimmedStatement.equals("")) {
				createQuery(trimmedStatement).execute(connection);
			}
			statementCounter++;
			if (statementCounter % 1000 == 0) {
				LOG.info("executing " + statementCounter + ". statement");
			}
		}
	}

	private VersionNumber getApplicationVersion() {
		return new VersionNumber(configurationService.getProperty(PROPERTY_VERSION));
	}

	private VersionNumber getDatabaseVersion() {
		if (isDatabaseEmpty()) {
			return VersionNumber.EMPTY_VERSION;
		} else {

			String queryString = "SELECT version FROM version";

			Query query = createQuery(queryString);
			return new VersionNumber(query.getString());
		}
	}

	private boolean isDatabaseEmpty() {
		String queryString = "SELECT count(*) FROM information_schema.tables WHERE table_schema = '"
				+ configurationService.getProperty(PROPERTY_DB_SCHEMA_NAME) + "'";

		Query query = createQuery(queryString);
		int i = query.getNumberOfMatches();
		return i == 0;
	}
}
