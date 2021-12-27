package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SignHistoryDBTest {

	private SimpleSign importedSign;
	private SimpleSign delegsSign;
	private SignDB signDB;
	private UserDb userDB;
	private SignHistoryDB signHistoryDB;
	private SymbolFactory symbolFactory;
	private String comment;
	private DbConnector connector;
	private SignHistoryDb signHistoryDBTest;
	private User user;

	@Before
	public void setUp() throws IOException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		userDB = new UserDb(connector);
		signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
		signHistoryDB = new SignHistoryDB(connector, userDB, configurationService, symbolFactory);
		signHistoryDBTest = new SignHistoryDb(connector);

		comment = "SignHistoryTest Case Comment";

		user = new User("SignHistoryTestUser", "History", "Test", null,
				Arrays.asList(new UserRole[] { UserRole.AUTHOR, UserRole.USER }), 1);

		userDB.saveUser(user, "12123234");
		delegsSign = new SimpleSign(new SignId(12345, "signHistoryTest", SignLocale.DGS, SignSource.DELEGS), user,
				SignLocale.DGS, new Date(1), comment);
		delegsSign.setRevision(12345);
		importedSign = new SimpleSign(new SignId(12362, "signHistoryTest", SignLocale.DGS, SignSource.IMPORTED), user,
				SignLocale.DGS, new Date(2), comment);

		signHistoryDBTest.removeAllEntriesFromHistoryTables();

	}

	@After
	public void tearDown() {

		if (signDB.existsItem(delegsSign.getSignId())) {
			signDB.deleteSign(delegsSign);
			assertFalse(signDB.existsItem(delegsSign.getSignId()));
		}

		if (signDB.existsItem(importedSign.getSignId())) {
			signDB.deleteSign(importedSign);
			assertFalse(signDB.existsItem(importedSign.getSignId()));
		}

		if (userDB.existsUserWithName(user)) {
			userDB.delete(user);
		}

		signHistoryDBTest.removeAllEntriesFromHistoryTables();

		connector = null;
	}

	@Ignore
	@Test
	public void testGetSignHistoryItemsForDelegsSign() throws Exception {

		assertNotNull(signHistoryDB.getSignHistoryItemsFor(delegsSign.getSignId()));
		assertTrue(signHistoryDB.getSignHistoryItemsFor(delegsSign.getSignId()).isEmpty());
		assertFalse(signDB.existsItem(delegsSign.getSignId()));

		signDB.saveSign(delegsSign.getSignId().getLowerIdPart(), delegsSign);
		assertTrue(signDB.existsItem(delegsSign.getSignId()));
		assertTrue(signHistoryDB.getSignHistoryItemsFor(delegsSign.getSignId()).isEmpty());

		delegsSign.setComment("Das ist der 2. Kommentar");
		signDB.updateSign(delegsSign);
		assertEquals(1, signHistoryDB.getSignHistoryItemsFor(delegsSign.getSignId()).size());

		delegsSign.setComment("Das ist der 3. Kommentar");
		signDB.updateSign(delegsSign);
		assertEquals(2, signHistoryDB.getSignHistoryItemsFor(delegsSign.getSignId()).size());

	}

	@Test
	public void testGetSignHistoryItemsForImportedSign() throws Exception {

		SignId overwrittenSignId = new SignId(importedSign.getSignId().getUpperIdPart(),
				importedSign.getSignId().getLowerIdPart(), importedSign.getSignId().getSignLocale(),
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign overwrittenSign = new SimpleSign(overwrittenSignId, importedSign.getAuthor(),
				importedSign.getSignLocale(), importedSign.getModificationDate(), comment);

		if (signDB.existsItem(overwrittenSignId)) {
			signDB.deleteSign(overwrittenSignId);
			assertFalse(signDB.existsItem(overwrittenSignId));
		}

		assertNotNull(signHistoryDB.getSignHistoryItemsFor(importedSign.getSignId()));
		assertTrue(signHistoryDB.getSignHistoryItemsFor(importedSign.getSignId()).isEmpty());
		assertFalse(signDB.existsItem(importedSign.getSignId()));

		signDB.saveSign(importedSign.getSignId().getLowerIdPart(), importedSign);
		assertTrue(signDB.existsItem(importedSign.getSignId()));
		assertTrue(signHistoryDB.getSignHistoryItemsFor(importedSign.getSignId()).isEmpty());

		signDB.saveSign(importedSign.getSignId().getLowerIdPart(), overwrittenSign);
		assertEquals(1, signHistoryDB.getSignHistoryItemsFor(importedSign.getSignId()).size());
		assertEquals(1, signHistoryDB.getSignHistoryItemsFor(overwrittenSignId).size());

		overwrittenSign.setComment("Das ist der 3. Kommentar");
		signDB.updateSign(overwrittenSign);
		assertEquals(2, signHistoryDB.getSignHistoryItemsFor(importedSign.getSignId()).size());
		assertEquals(2, signHistoryDB.getSignHistoryItemsFor(overwrittenSignId).size());

		signDB.deleteSign(overwrittenSign);
		assertFalse(signDB.existsItem(overwrittenSignId));
	}

	@Test
	public void testExistsItem() throws Exception {

		delegsSign.setComment("Initialer Commit.");
		SignHistoryItem signHistoryItemForDelegsSign = new SignHistoryItem(delegsSign.getSignId(),
				delegsSign.getAuthor().getUsername(), delegsSign.getComment(), delegsSign.getModificationDate(),
				delegsSign.getRevision());

		assertFalse(signHistoryDB.existsItem(signHistoryItemForDelegsSign));

		signDB.saveSign(delegsSign.getSignId().getLowerIdPart(), delegsSign);
		assertFalse(signHistoryDB.existsItem(signHistoryItemForDelegsSign));

		SimpleSign signWithRevision = signDB.getSign(delegsSign.getSignId());
		SignHistoryItem signHistoryItemForSavedSign = new SignHistoryItem(signWithRevision.getSignId(),
				signWithRevision.getAuthor().getUsername(), signWithRevision.getComment(),
				signWithRevision.getModificationDate(), signWithRevision.getRevision());

		delegsSign.setComment("Erste Änderung");
		signDB.updateSign(delegsSign);

		assertTrue(signHistoryDB.existsItem(signHistoryItemForSavedSign));
	}

	@Test
	public void testGetSignForSignHistoryItem() {

		List<SignHistoryItem> emptySignHistoryItemsForDelegsSign = signHistoryDB
				.getSignHistoryItemsFor(delegsSign.getSignId());
		assertNotNull(emptySignHistoryItemsForDelegsSign);
		assertEquals(0, emptySignHistoryItemsForDelegsSign.size());

		signHistoryDBTest.makeSignHistory(delegsSign);
		List<SignHistoryItem> oneEntrySignHistoryItemsForDelegsSign = signHistoryDB
				.getSignHistoryItemsFor(delegsSign.getSignId());
		assertNotNull(oneEntrySignHistoryItemsForDelegsSign);
		assertEquals(1, oneEntrySignHistoryItemsForDelegsSign.size());

		SimpleSign signFromSignHistroyItem = signHistoryDB.getSign(oneEntrySignHistoryItemsForDelegsSign.get(0));

		assertEquals(delegsSign, signFromSignHistroyItem);
		assertTrue(delegsSign.contentBasedEquals(signFromSignHistroyItem));
		assertEquals(delegsSign.getRevision(), signFromSignHistroyItem.getRevision());
	}

	private class SignHistoryDb extends MaterialDB {

		private static final String POSITIONED_SYMBOLS_HISTORY_TABLE_NAME = "positionedsymbolshistory";
		private static final String SIGN_HISTORY_TABLE_NAME = "signshistory";

		protected SignHistoryDb(DbConnector connector) {
			super(connector);
		}

		public void removeAllEntriesFromHistoryTables() {
			createQuery("DELETE FROM " + SIGN_HISTORY_TABLE_NAME).execute();
			createQuery("DELETE FROM " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME).execute();
		}

		public void makeSignHistory(SimpleSign sign) {
			assert sign != null : "Precondition failed: sign != null";

			Query historiciseSignQuery = createQuery("INSERT INTO " + SIGN_HISTORY_TABLE_NAME
					+ " (idupper, word, owner, language, topic, details, width, mdtSignPuddle, revision, source, comment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ",
					sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(),
					sign.getAuthor().getUsername(), sign.getSignId().getSignLocale().name(), "", "", sign.getWidth(),
					sign.getModificationDate().getTime(), sign.getRevision(), sign.getSignId().getSignSource().name(),
					sign.getComment());
			historiciseSignQuery.execute();

		}

	}

}
