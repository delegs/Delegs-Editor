package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;

public class SignBookDbTest {

	private DbConnector connector;
	private SignBookDB signBookDb;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		signBookDb = new SignBookDB(connector);
	}

	@After
	public void tearDown() {
		connector = null;
		signBookDb = null;
	}

	@Ignore
	@Test
	public void testAppDescription() throws IOException {

		Map<String, String> localizedAppDescriptions = signBookDb.getAllLocalizedAppDescriptions();
		assertNotNull(localizedAppDescriptions);
		assertTrue(localizedAppDescriptions.containsKey("de"));
		assertNotNull(localizedAppDescriptions.get("de"));
		assertTrue(localizedAppDescriptions.containsKey("en"));
		assertNotNull(localizedAppDescriptions.get("en"));
	}

	@Ignore
	@Test
	public void testDbRevision() throws IOException {
		int databaseVersion = signBookDb.getDatabaseVersion();
		// Database version # is currently "1"
		assertTrue(databaseVersion == 1);
	}
}
