package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.server.persistence.infrastructure.SignPersistenceTestCase;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SignDBTest extends SignPersistenceTestCase {

	private SignSource source;
	private String comment;
	private SignId signId;
	private SimpleSign sign;
	private String word;
	private SignLocale signLocale;
	private long upperIdPart;
	private User user;
	private ExtendedSignDB extendedSignDB;

	@Before
	public void setUp() throws IOException {
		super.setUp();
		extendedSignDB = new ExtendedSignDB(getConnector(), getUserDB(), getSymbolFactory(), configurationService);

		source = SignSource.DELEGS;
		comment = "Neu gespeicherte Gebärde im Test.";
		word = "signDbTest".toLowerCase();

		user = User.getImportedUser();
		signLocale = SignLocale.DGS;

		upperIdPart = getSignDB().getNewSignUpperId(signLocale);
		signId = new SignId(upperIdPart, word, signLocale, source);
		sign = new SimpleSign(signId, user, signLocale, new Date(0), comment);

	}

	@After
	public void tearDown() {

		if (getSignDB().existsItem(signId)) {
			getSignDB().deleteSign(signId);
		}
		extendedSignDB.removeAllEntriesFromHistoryTables();
		extendedSignDB.removeEntriesFromDeletedSignsTable();

		closeConnector();
	}

	@Test
	public void testAddSignToDeletedSignsTable() throws Exception {

		getSignDB().saveSign(signId.getLowerIdPart(), sign);
		assertTrue(getSignDB().existsItem(signId));
		assertFalse(getSignDB().isSignDeleted(signId));

		getSignDB().addSignToDeletedSignsTable(signId);
		assertTrue(getSignDB().existsItem(signId));
		assertTrue(getSignDB().isSignDeleted(signId));

		getSignDB().removeSignFromDeletedSignsTable(signId);
		assertTrue(getSignDB().existsItem(signId));
		assertFalse(getSignDB().isSignDeleted(signId));

		getSignDB().deleteSign(sign);
		assertFalse(getSignDB().existsItem(signId));
	}

	@Test
	public void testAddSignToDeletedSignsTableForOverwrittenSign() throws Exception {

		String testWord = "anOtherSign";
		SignId importedSignId = new SignId(332311, testWord, SignLocale.DGS, SignSource.IMPORTED);
		SimpleSign importedSign = new SimpleSign(importedSignId, user, SignLocale.DGS, new Date(), "imported");
		SignId importedButOverwrittenSignId = new SignId(332311, testWord, SignLocale.DGS,
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign importedButOverwrittenSign = new SimpleSign(importedButOverwrittenSignId, user, SignLocale.DGS,
				new Date(), "overwritten");

		if (getSignDB().existsItem(importedButOverwrittenSignId)) {
			getSignDB().deleteSign(importedButOverwrittenSignId);
			extendedSignDB.removeEntriesFromDeletedSignsTable();
		}
		if (getSignDB().existsItem(importedSignId)) {
			getSignDB().deleteSign(importedSignId);
			extendedSignDB.removeEntriesFromDeletedSignsTable();
		}

		getSignDB().saveSign(testWord, importedSign);
		getSignDB().saveSign(testWord, importedButOverwrittenSign);
		assertTrue(1 == getSignHistoryDb().getSignHistoryItemsFor(importedButOverwrittenSignId).size());

		if (getSignDB().existsItem(importedButOverwrittenSignId)) {
			extendedSignDB.removeEntriesFromDeletedSignsTable();
			getSignDB().deleteSign(importedButOverwrittenSignId);
		}
		if (getSignDB().existsItem(importedSignId)) {
			extendedSignDB.removeEntriesFromDeletedSignsTable();
			getSignDB().deleteSign(importedSignId);
		}
	}

	@Test
	public void testExistsItem() throws Exception {

		assertFalse(getSignDB().existsItem(signId));
		getSignDB().saveSign(word, sign);
		assertTrue(getSignDB().existsItem(signId));

		getSignDB().deleteSign(signId);
		assertFalse(getSignDB().existsItem(signId));
	}

	@Test
	public void testCountItemsWithDictionaryIndex() throws Exception {

		getSignDB().saveSign(word, sign);
		assertTrue(getSignDB().existsItem(signId));

		SignId secondSignId = new SignId(666666, word, signLocale, source);

		if (getSignDB().existsItem(secondSignId)) {
			getSignDB().deleteSign(secondSignId);
		}

		assertTrue(getSignDB().countItemsWithLocale(signLocale) > 0);

		int currentACount = getSignDB().countItemsWithLocale(signLocale);

		if (!getSignDB().existsItem(secondSignId)) {
			SimpleSign sign = new SimpleSign(secondSignId, User.getUnknownUser(), signLocale, new Date(2), comment);
			getSignDB().saveSign(word, sign);
		}
		assertTrue(getSignDB().existsItem(secondSignId));
		assertEquals(currentACount + 1, getSignDB().countItemsWithLocale(signLocale));

		getSignDB().deleteSign(secondSignId);
	}

	@Test
	public void testUpdateSignItems() throws Exception {

		String word2 = "EinBaum";
		SignId secondSignId = new SignId(upperIdPart, word2, signLocale, source);

		sign.addSymbol(new PositionedSymbol(getSymbolFactory().createSymbol(01, 01, 001, 01, 01, 01), 1, 1, 1));
		sign.addSymbol(new PositionedSymbol(getSymbolFactory().createSymbol(01, 01, 001, 01, 01, 02), 2, 2, 2));

		SignItem firstSignItem = new SignItem(sign.getSignId(), sign.getWidth());

		SimpleSign secondSign = new SimpleSign(secondSignId, user, signLocale, new Date(2), comment);
		secondSign.addSymbol(new PositionedSymbol(getSymbolFactory().createSymbol(01, 01, 001, 01, 01, 01), -20, 1, 1));
		secondSign.addSymbol(new PositionedSymbol(getSymbolFactory().createSymbol(01, 01, 001, 01, 01, 02), 29, 2, 2));

		SignItem secondSignItem = new SignItem(secondSign.getSignId(), secondSign.getWidth());

		PositionedSymbol rightMostSymbol = new PositionedSymbol(
				getSymbolFactory().createSymbol(01, 01, 001, 01, 01, 01), 100, 1, 1);
		sign.addSymbol(rightMostSymbol);

		getSignDB().saveSign(word, sign);
		getSignDB().saveSign(word2, secondSign);

		assertFalse(firstSignItem.getSignWidth() == sign.getWidth());
		assertTrue(secondSignItem.getSignWidth() == secondSign.getWidth());

		Set<SignItem> signItems = new HashSet<SignItem>();
		signItems.add(firstSignItem);
		signItems.add(secondSignItem);
		getSignDB().loadSignItemWidth(signItems, SignLocale.DGS);

		assertEquals(firstSignItem.getSignWidth(), sign.getWidth());
		assertEquals(secondSignItem.getSignWidth(), secondSign.getWidth());

		if (getSignDB().existsItem(secondSignId)) {
			getSignDB().deleteSign(secondSignId);
		}
	}

	@Ignore
	@Test
	public void testUpdateSign() throws Exception {
		sign.setComment(comment);
		getSignDB().saveSign(word, sign);
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 1, 1, 1), 12, 12, 1);
		sign.addSymbol(positionedSymbol);
		List<SignHistoryItem> signHistoryItemsForSign = getSignHistoryDb().getSignHistoryItemsFor(signId);
		assertNotNull(signHistoryItemsForSign);
		assertEquals(0, signHistoryItemsForSign.size());

		sign.setComment("Noch ein anderer Kommentar");
		getSignDB().updateSign(sign);

		assertEquals(sign, getSignDB().getSign(signId));
		List<SignHistoryItem> signHistoryItemsForSignWithOneEntry = getSignHistoryDb().getSignHistoryItemsFor(signId);
		assertEquals(1, signHistoryItemsForSignWithOneEntry.size());

		PositionedSymbol anOtherPositionedSymbol = new PositionedSymbol(new Symbol(1, 2, 1, 1, 1, 1, 1, 1), 42, 12, 1);
		sign.addSymbol(anOtherPositionedSymbol);

		getSignDB().updateSign(sign);

		assertEquals(sign, getSignDB().getSign(signId));
		List<SignHistoryItem> signHistoryItemsForSignWithTwiEntries = getSignHistoryDb().getSignHistoryItemsFor(signId);
		assertEquals(2, signHistoryItemsForSignWithTwiEntries.size());

	}

	@Test
	public void testSaveSignModificationDate() throws Exception {

		getSignDB().saveSign(word, sign);

		String word = "junittest";
		SignId importedSignID = new SignId(666666, word, SignLocale.DGS, SignSource.IMPORTED);
		SimpleSign importedSign = new SimpleSign(importedSignID, User.getImportedUser(), SignLocale.DGS, new Date(1),
				comment);

		getSignDB().saveSign(word, importedSign);
		assertEquals(new Date(1), getSignDB().getSign(importedSignID).getModificationDate());

		assertTrue(getSignDB().getSign(signId).getModificationDate().after(new Date(1)));

		getSignDB().deleteSign(importedSign);
	}

	@Ignore
	@Test
	public void testSaveSignRevision() throws Exception {

		long currentRevision = getSignDB().getCurrentRevision();
		assertTrue(currentRevision >= 0);

		getSignDB().saveSign(word, sign);

		long newRevision = getSignDB().getCurrentRevision();
		assertTrue(currentRevision < newRevision);

		getSignDB().updateSign(sign);
		assertTrue(newRevision < getSignDB().getCurrentRevision());
	}

	@Ignore
	@Test
	public void testGetSignItemsSinceRevision() throws Exception {

		long revision1 = getSignDB().getCurrentRevision();
		assertTrue(revision1 >= 0);

		getSignDB().saveSign(word, sign);

		long revision2 = getSignDB().getCurrentRevision();
		assertTrue(revision1 < revision2);

		assertEquals(1, getSignDB().getEntriesSinceRevision(revision1, signLocale).getDictionaryEntries().size());
		assertTrue(getSignDB().getEntriesSinceRevision(revision1, signLocale).getDictionaryEntries().get(0)
				.containsSignId(signId));
		assertEquals(0, getSignDB().getEntriesSinceRevision(revision2, signLocale).getDictionaryEntries().size());

		getSignDB().updateSign(sign);

		assertEquals(1, getSignDB().getEntriesSinceRevision(revision1, signLocale).getDictionaryEntries().size());
		assertTrue(getSignDB().getEntriesSinceRevision(revision1, signLocale).getDictionaryEntries().get(0)
				.containsSignId(signId));
		assertEquals(1, getSignDB().getEntriesSinceRevision(revision2, signLocale).getDictionaryEntries().size());
		assertTrue(getSignDB().getEntriesSinceRevision(revision2, signLocale).getDictionaryEntries().get(0)
				.containsSignId(signId));

		assertTrue(revision2 < getSignDB().getCurrentRevision());
	}

	@Ignore
	@Test
	public void testSaveAndDeleteSign() throws Exception {

		long revision = getSignDB().getCurrentRevision();
		assertTrue(revision >= 0);

		getSignDB().saveSign(word, sign);
		assertTrue(getSignDB().getCurrentRevision() > revision);
		assertFalse(getSignDB().isSignDeleted(sign));
		assertTrue(getSignDB().existsItem(sign.getSignId()));

		revision = getSignDB().getCurrentRevision();
		getSignDB().deleteSign(sign);

		RevisionedWordToSignsDictionaryEntries deletedEntriesSinceRevision = getSignDB()
				.getDeletedEntriesSinceRevision(revision, sign.getSignLocale());

		assertTrue(getSignDB().getCurrentRevision() > revision);
		assertTrue(getSignDB().isSignDeleted(sign));
		assertFalse(getSignDB().existsItem(sign.getSignId()));

		assertTrue(deletedEntriesSinceRevision.containsWord(word));
		assertTrue(deletedEntriesSinceRevision.getDictionaryEntry(word).containsSignId(sign.getSignId()));
		assertFalse(getSignDB().getDeletedEntriesSinceRevision(getSignDB().getCurrentRevision(), sign.getSignLocale())
				.containsWord(word));

		getSignDB().saveSign(word, sign);
		assertTrue(getSignDB().getCurrentRevision() > revision);
		// Make sure sign is NOT_EXISTS marked as deleted
		assertFalse(getSignDB().isSignDeleted(sign));

		assertFalse(getSignDB().getDeletedEntriesSinceRevision(revision, sign.getSignLocale()).containsWord(word));

	}

	@Test
	public void testGetNewSignUpperId() throws Exception {
		long initialNewUpperId = getSignDB().getNewSignUpperId(signLocale);

		getSignDB().saveSign(word, sign);
		assertTrue(getSignDB().existsItem(signId));
		long newUpperId = getSignDB().getNewSignUpperId(signLocale);
		assertEquals(sign.getSignId().getUpperIdPart() + 1, newUpperId);

		getSignDB().deleteSign(sign);
		assertFalse(getSignDB().existsItem(signId));
		assertEquals(initialNewUpperId, getSignDB().getNewSignUpperId(signLocale));
	}

	@Test
	public void testFindSignsWithListOfWords() throws Exception {
		// Prepare
		SignId importedSignId = new SignId(upperIdPart + 1, word, signLocale, SignSource.IMPORTED);
		SimpleSign importedSign = new SimpleSign(importedSignId, user, signLocale, new Date(1), comment);
		SignId importedButOverwrittenSignId = new SignId(upperIdPart + 1, word, signLocale,
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign importedButOverwrittenSign = new SimpleSign(importedButOverwrittenSignId, user, signLocale,
				new Date(1), comment);

		String secondWord = "ZweitesWorts".toLowerCase();

		SignId secondImportedSignId = new SignId(upperIdPart + 22, secondWord, signLocale, SignSource.IMPORTED);
		SimpleSign secondImportedSign = new SimpleSign(secondImportedSignId, user, signLocale, new Date(1), comment);
		SignId secondImportedButOverwrittenSignId = new SignId(upperIdPart + 22, secondWord, signLocale,
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign secondImportedButOverwrittenSign = new SimpleSign(secondImportedButOverwrittenSignId, user,
				signLocale, new Date(1), comment);

		deleteSigns(importedSignId, importedButOverwrittenSignId, secondImportedSignId,
				secondImportedButOverwrittenSignId);

		List<String> searchWordList = Arrays.asList(new String[] { word, secondWord });

		// Action
		Map<? extends String, ? extends List<SignItem>> resultWithNoEntry = getSignDB().findSigns(signLocale,
				searchWordList);
		assertNotNull(resultWithNoEntry);
		assertFalse(resultWithNoEntry.containsKey(word));
		assertFalse(resultWithNoEntry.containsKey(secondWord));

		if (!getSignDB().existsItem(importedSignId)) {
			getSignDB().saveSign(word, importedSign);
			assertTrue(getSignDB().existsItem(importedSignId));
		}
		if (!getSignDB().existsItem(secondImportedSignId)) {
			getSignDB().saveSign(secondWord, secondImportedSign);
			assertTrue(getSignDB().existsItem(secondImportedSignId));
		}

		Map<String, List<SignItem>> resultWithOneEntry = getSignDB().findSigns(signLocale, searchWordList);
		assertNotNull(resultWithOneEntry);
		assertEquals(1, resultWithOneEntry.get(word).size());
		assertEquals(1, resultWithOneEntry.get(secondWord).size());

		getSignDB().saveSign(word, sign);

		Map<String, List<SignItem>> resultWithTwoEntries = getSignDB().findSigns(signLocale, searchWordList);
		assertNotNull(resultWithTwoEntries);
		assertEquals(2, resultWithTwoEntries.get(word).size());
		assertEquals(1, resultWithTwoEntries.get(secondWord).size());

		if (!getSignDB().existsItem(importedButOverwrittenSignId)) {
			getSignDB().saveSign(word, importedButOverwrittenSign);
			assertTrue(getSignDB().existsItem(importedButOverwrittenSignId));
		}
		if (!getSignDB().existsItem(secondImportedButOverwrittenSignId)) {
			getSignDB().saveSign(secondWord, secondImportedButOverwrittenSign);
			assertTrue(getSignDB().existsItem(secondImportedButOverwrittenSignId));
		}

		Map<String, List<SignItem>> resultWithOverwrittenEntry = getSignDB().findSigns(signLocale, searchWordList);
		assertNotNull(resultWithOverwrittenEntry);
		assertEquals(resultWithTwoEntries.get(word).size(), resultWithOverwrittenEntry.get(word).size());
		assertEquals(resultWithOneEntry.get(secondWord).size(), resultWithOverwrittenEntry.get(secondWord).size());

		getSignDB().deleteSign(sign);

		assertEquals(resultWithOneEntry.get(word).size(),
				getSignDB().findSigns(signLocale, searchWordList).get(word).size());

		deleteSigns(importedButOverwrittenSignId, importedSignId, secondImportedButOverwrittenSignId,
				secondImportedSignId);
	}

	private class ExtendedSignDB extends SignDB {

		private static final String POSITIONED_SYMBOLS_HISTORY_TABLE_NAME = "positionedsymbolshistory";
		private static final String SIGN_HISTORY_TABLE_NAME = "signshistory";

		public ExtendedSignDB(DbConnector connector, UserDb authorDB, SymbolFactory symbolFactory,
				ConfigurationService configurationService) {
			super(connector, authorDB, symbolFactory, configurationService);
		}

		public void removeAllEntriesFromHistoryTables() {
			createQuery("DELETE FROM " + SIGN_HISTORY_TABLE_NAME).execute();
			createQuery("DELETE FROM " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME).execute();
		}

		public void removeEntriesFromDeletedSignsTable() {
			createQuery("DELETE FROM " + DELETEDSIGNS_TABLE_NAME).execute();
		}
	}
}
