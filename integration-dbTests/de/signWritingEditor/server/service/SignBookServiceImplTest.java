package de.signWritingEditor.server.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignBookDB;
import de.signWritingEditor.server.service.signbook.SignBookService;
import de.signWritingEditor.server.service.signbook.SignBookServiceImpl;

public class SignBookServiceImplTest {

	@Ignore
	@Test
	public void testGetLocalizedAppDescriptions() throws IOException {
		DbConnector connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		SignBookService signBookService = new SignBookServiceImpl(new SignBookDB(connector));

		Map<String, String> localizedAppDescriptions = signBookService.getLocalizedAppDescriptions();

		assertNotNull(localizedAppDescriptions);
		assertTrue(localizedAppDescriptions.containsKey("de"));
		assertNotNull(localizedAppDescriptions.get("de"));
		assertTrue(localizedAppDescriptions.containsKey("en"));
		assertNotNull(localizedAppDescriptions.get("en"));

		connector = null;
	}

}
