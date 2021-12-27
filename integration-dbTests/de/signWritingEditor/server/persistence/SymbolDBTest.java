package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;

public class SymbolDBTest {

	private SymbolDB symbolDB;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolDB = new SymbolDB(connector);

	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testGetAllSymbols() throws Exception {
		assertEquals(37845, symbolDB.getAllSymbols().size());
	}

	@Test
	public void testGetAllBaseSymbols() throws Exception {
		assertEquals(686, symbolDB.getAllBaseSymbols().size());
	}
}
