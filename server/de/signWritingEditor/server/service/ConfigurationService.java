package de.signWritingEditor.server.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationService {

	private static final String CONFIGURATION_FILE = "/ESFConfig.properties";
	private static final String VERSION_FILE_URL = "/Version.properties";

	public final static String PROPERTY_APP_URL = "esf.app.type";

	public static final String PROPERTY_SMTP_SERVER_HOST_NAME = "esf.smtp.hostname";
	public static final String PROPERTY_SMTP_SERVER_PORT = "esf.smtp.port";
	public static final String PROPERTY_SMTP_SERVER_USER_NAME = "esf.smtp.accountname";
	public static final String PROPERTY_SMTP_SERVER_PASSWORD = "esf.smtp.password";

	public static final String PROPERTY_EMAIL_INFO = "esf.email.info";
	public static final String PROPERTY_EMAIL_TEAM = "esf.email.team";

	public static final String PROPERTY_VIDEO_CACHE_DIR = "esf.video.cache.dir";
	public static final String PROPERTY_VIDEO_UPLOAD_DIR = "esf.video.upload.dir";
	public static final String PROPERTY_VIDEO_LIB_DIR = "esf.video.lib.dir";
	public static final String PROPERTY_MEDIA_URL = "esf.mediaservlet.url";

	public static final String PROPERTY_OPERATING_SYSTEM = "esf.operating.system";
	public static final String PROPERTY_SIGN_IMAGE_CACHE_URL = "esf.signimagecache.url";

	public final static String PROPERTY_DB_USERNAME = "esf.db.username";
	public final static String PROPERTY_DB_PASSWORD = "esf.db.password";
	public final static String PROPERTY_DB_URL = "esf.db.url";
	public final static String PROPERTY_DB_DRIVER = "esf.db.driver";

	public final static String PROPERTY_WAR_PATH = "esf.war.path";

	private static final String VIDEO_CACHE_PATH = "esf.video.cache.dir";

	private final Properties properties;

	public ConfigurationService() throws IOException {
		this(firstNonNullString(System.getProperty("configuration.file"), CONFIGURATION_FILE));
	}

	private static String firstNonNullString(String first, String second) {
		return first != null ? first : second;
	}

	public ConfigurationService(String configurationFileUrl) throws IOException {
		properties = new Properties();

		loadPropertiesFromXmlFile(configurationFileUrl);
		loadPropertiesFromXmlFile(VERSION_FILE_URL);

		loadPropertiesFromSystemEnvironment();
	}

	private void loadPropertiesFromXmlFile(String filename) throws IOException {
		try (InputStream inputStream = ConfigurationService.class.getResourceAsStream(filename)) {
			properties.loadFromXML(inputStream);
		}
	}

	private void loadPropertiesFromSystemEnvironment() {
		for (String key : System.getenv().keySet()) {
			if (key.startsWith("esf.")) {
				properties.put(key, System.getenv(key));
			}
		}
	}

	/**
	 * Returns the value for the given property-key.
	 * 
	 * @require key != null
	 * @require hasProperty(key)
	 */
	public String getProperty(String key) {
		assert key != null : "key != null";
		assert hasProperty(key) : "hasProperty(" + key + ")";

		return (String) properties.get(key);
	}

	/**
	 * Returns whether the property-key exists.
	 * 
	 * @require key != null
	 */
	public boolean hasProperty(String key) {
		assert key != null : "key != null";
		return properties.containsKey(key);
	}

	public OS getOS() {
		return OS.valueOf(getProperty(PROPERTY_OPERATING_SYSTEM));
	}

	public enum OS {
		Windows, Linux, Mac;
	}
}
