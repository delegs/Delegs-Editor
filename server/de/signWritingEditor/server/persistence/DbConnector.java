package de.signWritingEditor.server.persistence;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashSet;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import de.signWritingEditor.server.service.ConfigurationService;

public class DbConnector {

	private static final Logger LOG = Logger.getLogger(DbConnector.class);

	private final ConfigurationService configurationService;

	// Es sollten niemals mehrere dbUrls parallel verwendet werden!
	// ENTWEDER signbase ODER signbase_junit
	private static LinkedHashSet<String> configuredDbUrls = new LinkedHashSet<>();

	private static ComboPooledDataSource connectionPool;

	public DbConnector(ConfigurationService configurationService) {
		assert configurationService != null : "configurationService != null";
		this.configurationService = configurationService;

		synchronized (DbConnector.class) {
			String dbUrl = configurationService.getProperty(ConfigurationService.PROPERTY_DB_URL);
			boolean firstOccurrence = configuredDbUrls.add(dbUrl);
			if (firstOccurrence) {
				LOG.info(configuredDbUrls);
				if (configuredDbUrls.size() >= 2) {
					LOG.error(configuredDbUrls);
				}
			}

			if (connectionPool == null) {
				connectionPool = createPool();
			}
		}
	}

	/**
	 * for now, resources do get cleaned up, but you may need to tolerate
	 * hot-restart false alarms. https://github.com/swaldman/c3p0/issues/79
	 */
	public static void shutDownConnectionPool() {
		synchronized (DbConnector.class) {
			if (connectionPool != null) {
				connectionPool.close();
			}
		}
	}

	public Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}

	private ComboPooledDataSource createPool() {
		String userName = configurationService.getProperty(ConfigurationService.PROPERTY_DB_USERNAME);
		String password = configurationService.getProperty(ConfigurationService.PROPERTY_DB_PASSWORD);
		String dbUrl = configurationService.getProperty(ConfigurationService.PROPERTY_DB_URL);
		String driver = configurationService.getProperty(ConfigurationService.PROPERTY_DB_DRIVER);

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		try {
			comboPooledDataSource.setDriverClass(driver);
			comboPooledDataSource.setContextClassLoaderSource("library");
			comboPooledDataSource.setPrivilegeSpawnedThreads(true);
			comboPooledDataSource.setMaxAdministrativeTaskTime(5);
		} catch (PropertyVetoException e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		comboPooledDataSource.setJdbcUrl(dbUrl + "?useUnicode=true&characterEncoding=UTF-8");
		comboPooledDataSource.setUser(userName);
		comboPooledDataSource.setPassword(password);
		comboPooledDataSource.setTestConnectionOnCheckout(true);
		comboPooledDataSource.setUnreturnedConnectionTimeout(300);

		return comboPooledDataSource;
	}

	public String getDBConnectionURL() {
		return configurationService.getProperty(ConfigurationService.PROPERTY_DB_URL);
	}
}
