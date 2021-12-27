package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;

public class MaterialDBTest {

	private static final String TEST_TABLE_NAME = "MaterialDBTest";
	private DbConnector connector;
	private MaterialDB materialDB;

	@Before
	public void setUp() {
		try {

			connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
			materialDB = new MaterialDB(connector);
			materialDB.createQuery("DROP TABLE IF EXISTS " + TEST_TABLE_NAME).execute();
			materialDB.createQuery("CREATE TABLE " + TEST_TABLE_NAME + " (id INTEGER, testvalue VARCHAR(30))")
					.execute();
		} catch (IOException e) {
			fail("Failed creating MaterialDB: " + e.getMessage());
		}
	}

	@Test
	public void testMaterialDB() {

		int id = 1;

		materialDB.createQuery("INSERT INTO " + TEST_TABLE_NAME + " VALUES (?, ?)", id++, "Test" + id).execute();

		assertTrue(materialDB.exists("" + (id - 1), TEST_TABLE_NAME, "id"));
		assertEquals(materialDB.getNumberOfEntries(TEST_TABLE_NAME), id - 1);

		for (int i = 0; i < 6; i++) {
			materialDB.createQuery("INSERT INTO " + TEST_TABLE_NAME + " VALUES (?, ?)", id++, "Test" + id).execute();
		}

		assertTrue(materialDB.exists("" + (id - 2), TEST_TABLE_NAME, "id"));
		assertEquals(id - 1, materialDB.getNumberOfEntries(TEST_TABLE_NAME));
		List<String> allIds = materialDB.getAllIds(TEST_TABLE_NAME, "id");
		assertEquals(allIds.size(), materialDB.getNumberOfEntries(TEST_TABLE_NAME));
		for (int i = 1; i < id; i++) {
			assertTrue(allIds.contains("" + i));
		}

		materialDB.delete("" + (id - 2), TEST_TABLE_NAME, "id");
		assertFalse(materialDB.exists("" + (id - 2), TEST_TABLE_NAME, "id"));

		assertEquals(id - 2, materialDB.getNumberOfEntries(TEST_TABLE_NAME));
	}

	@After
	public void tearDown() {
		assertTrue(materialDB.createQuery("DELETE FROM " + TEST_TABLE_NAME).execute());
		assertTrue(materialDB.createQuery("DROP TABLE " + TEST_TABLE_NAME).execute());

	}

}
