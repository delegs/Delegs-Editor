package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.MaterialDB;
import de.signWritingEditor.server.persistence.infrastructure.SignPersistenceTestCase;
import de.signWritingEditor.server.service.sessionService.SessionKeyFactory;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;

public class DictionaryServiceImplTest extends SignPersistenceTestCase {

	private DictionaryService dictionaryService;
	private String comment;
	private SignSource signSourceImportedButOverwrittenInDelegs;
	private SignLocale signLocale;
	private SignId importedButOverwrittenSignId;
	private SimpleSign importedButOverwrittenSign;
	private String word;
	private long upperIdPart;
	private User user;
	private SignId importedSignId;
	private SimpleSign importedSign;
	private ExtendedSignHistoryDb extendedSignHistoryDb;

	private SignId dgsSignId;
	private SignId aslSignId;
	private SimpleSign dgsSign;
	private SimpleSign aslSign;
	private String languageWord;

	private SessionKey sessionKey;

	@Before
	public void setUp() throws IOException {
		super.setUp();
		dictionaryService = new DictionaryServiceImpl(getSignDB(), getSignHistoryDb());
		extendedSignHistoryDb = new ExtendedSignHistoryDb(getConnector());

		comment = "DictionaryServiceImple Testcase";
		word = "DictionaryServiceImplTest".toLowerCase();
		signSourceImportedButOverwrittenInDelegs = SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS;
		signLocale = SignLocale.DGS;
		user = new User("unknown", "unknown", "unknown", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		upperIdPart = getSignDB().getNewSignUpperId(signLocale);

		importedSignId = new SignId(upperIdPart, word, signLocale, SignSource.IMPORTED);
		importedSign = new SimpleSign(importedSignId, user, signLocale, new Date(1), comment);

		int languageUpperId = 1337;
		languageWord = "name";

		dgsSignId = new SignId(languageUpperId, languageWord, SignLocale.DGS, SignSource.IMPORTED);
		dgsSign = new SimpleSign(dgsSignId, user, signLocale, new Date(1), comment);
		aslSignId = new SignId(languageUpperId + 1, languageWord, SignLocale.DGS, SignSource.IMPORTED);
		aslSign = new SimpleSign(aslSignId, user, signLocale, new Date(1), comment);

		importedButOverwrittenSignId = new SignId(upperIdPart, word, signLocale,
				signSourceImportedButOverwrittenInDelegs);
		importedButOverwrittenSign = new SimpleSign(importedButOverwrittenSignId, user, signLocale, new Date(1),
				comment);

		sessionKey = new SessionKeyFactory().createSessionKey();

		deleteSignsForSearchWord(languageWord, SignLocale.DGS);
		deleteSignsForSearchWord(languageWord, SignLocale.ASL);

		try {
			dictionaryService.saveSign(languageWord, dgsSign, sessionKey);
			dictionaryService.saveSign(languageWord, aslSign, sessionKey);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@After
	public void tearDown() {

		deleteSigns(importedSignId, importedButOverwrittenSignId, dgsSignId, aslSignId);

		extendedSignHistoryDb.removeAllEntriesFromHistoryTables();
	}

	@Test
	public void testFindSignsWithWord() throws Exception {

		String searchWord = "";
		List<SignItem> result = dictionaryService.findSigns(searchWord, signLocale);
		assertNotNull(result);
		assertTrue(result.isEmpty());

		// Delete word without symbols
		searchWord = "TestwortXYZ";
		result = dictionaryService.findSigns(searchWord, signLocale);
		assertNotNull(result);
		if (!result.isEmpty()) {
			for (SignItem signItem : result) {
				if (signItem.getSignId().getSignSource() != SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS) {
					dictionaryService.deleteSign(dictionaryService.getSign(signItem.getSignId()));
					assertFalse(dictionaryService.existsItem(signItem.getSignId()));
				}
			}
		}
		result = dictionaryService.findSigns(searchWord, signLocale);
		assertNotNull(result);
		assertTrue(result.isEmpty());
		assertTrue(result.size() == dictionaryService.findSigns(searchWord.toLowerCase(), signLocale).size());

		result = dictionaryService.findSigns(word, signLocale);
		assertNotNull(result);
		assertTrue(result.isEmpty());
		assertEquals(dictionaryService.findSigns(searchWord.toLowerCase(), signLocale).size(), result.size());

		importedSign.setComment(comment);
		dictionaryService.saveSign(word, importedSign, sessionKey);
		importedButOverwrittenSign.setComment(comment);
		dictionaryService.saveSign(word, importedButOverwrittenSign, sessionKey);
		result = dictionaryService.findSigns(word, signLocale);
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertTrue(dictionaryService.existsItem(importedButOverwrittenSign.getSignId()));
		assertEquals(dictionaryService.findSigns(word.toLowerCase(), signLocale).size(), result.size());

		assertEquals(1, result.size());
		assertEquals(importedButOverwrittenSign.getSignId(), result.get(0).getSignId());
		assertEquals(importedButOverwrittenSign.getWidth(), result.get(0).getSignWidth());
	}

	@Test
	public void testFindSignsForMultipleLanguages() throws Exception {
		String searchWord = languageWord;
		List<String> words = new ArrayList<String>();
		List<SignLocale> locales = new ArrayList<SignLocale>();

		words.add(languageWord);
		locales.add(SignLocale.DGS);

		words.add(languageWord);
		locales.add(SignLocale.ASL);

		List<SignItem> result = dictionaryService.findSigns(words, locales).get(searchWord);

		assertEquals(2, result.size());
		assertEquals(dgsSign.getSignId(), result.get(0).getSignId());
		assertEquals(aslSign.getSignId(), result.get(1).getSignId());
	}

	@Test
	public void testFindEntriesInList() throws Exception {

		List<String> testWords = new ArrayList<String>();
		List<SignLocale> testLocales = new ArrayList<SignLocale>();
		String testWordEmpty = "";
		testWords.add(testWordEmpty);
		testLocales.add(signLocale);
		String testWord1 = "TestwortXYZ";
		String testWord2 = word;
		testWords.add(testWordEmpty);
		testLocales.add(signLocale);
		testWords.add(testWord1);
		testLocales.add(signLocale);
		testWords.add(testWord2);
		testLocales.add(signLocale);

		Map<String, List<SignItem>> result = dictionaryService.findSigns(testWords, testLocales);
		assertNotNull(result);

		// Delete word without symbols

		if (result.containsKey(testWord1)) {
			List<SignItem> testWord1Signs = result.get(testWord1);
			assertNotNull(testWord1Signs);
			for (SignItem signItem : testWord1Signs) {
				if (signItem.getSignId().getSignSource() != SignSource.IMPORTED) {
					dictionaryService.deleteSign(dictionaryService.getSign(signItem.getSignId()));
					assertFalse(dictionaryService.existsItem(signItem.getSignId()));
				}
			}
		}
		result = dictionaryService.findSigns(testWords, testLocales);
		assertFalse(result.containsKey(testWord1));
		assertEquals(0, dictionaryService.findSigns(testWord1, signLocale).size());

		// Delete word with symbols
		if (result.containsKey(testWord2)) {
			for (SignItem signItem : result.get(testWord2)) {
				if (signItem.getSignId().getSignSource() != SignSource.IMPORTED) {
					dictionaryService.deleteSign(dictionaryService.getSign(signItem.getSignId()));
					assertFalse(dictionaryService.existsItem(signItem.getSignId()));
				}
			}
		}

		result = dictionaryService.findSigns(testWords, testLocales);
		List<SignItem> testWord2Signs = result.get(testWord2);
		assertFalse(result.containsValue(testWord2));
		assertEquals(0, dictionaryService.findSigns(testWord2, signLocale).size());

		importedSign.setComment(comment);
		dictionaryService.saveSign(testWord2, importedSign, sessionKey);
		dictionaryService.saveSign(testWord2, importedButOverwrittenSign, sessionKey);
		result = dictionaryService.findSigns(testWords, testLocales);

		testWord2Signs = result.get(testWord2);
		assertNotNull(testWord2Signs);
		assertFalse(testWord2Signs.isEmpty());
		assertTrue(dictionaryService.existsItem(importedButOverwrittenSign.getSignId()));
		assertEquals(dictionaryService.findSigns(testWord2, signLocale).size(), testWord2Signs.size());

		assertEquals(1, testWord2Signs.size());
		assertEquals(importedButOverwrittenSign.getSignId(), testWord2Signs.get(0).getSignId());
		assertEquals(importedButOverwrittenSign.getWidth(), testWord2Signs.get(0).getSignWidth());
	}

	@Test
	public void testFindEntriesWithDictionaryIndex() throws Exception {

		dictionaryService.saveSign(word, importedSign, sessionKey);
		dictionaryService.saveSign(word, importedButOverwrittenSign, sessionKey);
		assertTrue(dictionaryService.existsItem(importedButOverwrittenSignId));

		SignId secondId = new SignId(666666, word, signLocale, SignSource.DELEGS);
		if (!dictionaryService.existsItem(secondId)) {
			SimpleSign secondSign = new SimpleSign(secondId, User.getUnknownUser(), signLocale, new Date(124), comment);
			dictionaryService.saveSign(word, secondSign, sessionKey);
		}
		assertTrue(dictionaryService.existsItem(secondId));

		// FIXME: Test fails, when a sign with '?' as first letter of meaning is
		// added
		String specialWord = "$ab!=_";
		SignId specialCharacterSignId = new SignId(666667, specialWord, signLocale, SignSource.DELEGS);
		if (!dictionaryService.existsItem(specialCharacterSignId)) {
			SimpleSign specialSign = new SimpleSign(specialCharacterSignId, User.getUnknownUser(), signLocale,
					new Date(125), comment);
			dictionaryService.saveSign(specialWord, specialSign, sessionKey);
		}
		assertTrue(dictionaryService.existsItem(specialCharacterSignId));

		RevisionedWordToSignsDictionaryEntries dictionaryEntriesForA = dictionaryService.findEntries(signLocale);
		assertTrue(containsSignId(dictionaryEntriesForA, importedButOverwrittenSignId));
		assertTrue(containsSignId(dictionaryEntriesForA, secondId));
		assertTrue(containsSignId(dictionaryEntriesForA, specialCharacterSignId));

		dictionaryService.deleteSign(dictionaryService.getSign(secondId));
		dictionaryService.deleteSign(dictionaryService.getSign(specialCharacterSignId));
	}

	@Test
	public void testSaveDeleteSignAndExistsItem() throws Exception {

		assertFalse(dictionaryService.existsItem(importedButOverwrittenSignId));

		dictionaryService.saveSign(word, importedSign, sessionKey);
		dictionaryService.saveSign(word, importedButOverwrittenSign, sessionKey);
		assertTrue(dictionaryService.existsItem(importedButOverwrittenSignId));
	}

	@Test
	public void testIsSignReplacable() throws Exception {

		SignId importedSignId = new SignId(1, "Hallo", SignLocale.DGS, SignSource.IMPORTED);
		SimpleSign importedSignPuddleSign = new SimpleSign(importedSignId, User.getImportedUser(), SignLocale.DGS,
				new Date(1), comment);

		if (!dictionaryService.existsItem(importedSignId)) {
			dictionaryService.saveSign("Hallo", importedSignPuddleSign, sessionKey);
			assertTrue(dictionaryService.existsItem(importedSignId));
		}

		// Save all Signs Locally
		// Sign not yet locally saved --> cannot replace
		assertFalse(dictionaryService.isSignReplacable(true, importedSignPuddleSign, false));
		// Sign already locally saved --> can replace
		assertTrue(dictionaryService.isSignReplacable(true, importedSignPuddleSign, true));

		// Save all signs in the signBook
		// Sign exists but is imported, so not replacable
		assertTrue(dictionaryService.isSignReplacable(false, importedSignPuddleSign, false));
		// Create new replacable Sign
		SignId replacableSignId = new SignId(importedSignPuddleSign.getSignId().getUpperIdPart(),
				importedSignPuddleSign.getSignId().getLowerIdPart(), importedSignPuddleSign.getSignId().getSignLocale(),
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign replacableSign = new SimpleSign(replacableSignId, User.getUnknownUser(),
				importedSignPuddleSign.getSignLocale(), new Date(2), comment);

		dictionaryService.saveSign("Hallo", replacableSign, sessionKey);
		assertTrue(dictionaryService.existsItem(replacableSignId));
		assertTrue(dictionaryService.isSignReplacable(false, replacableSign, false));

		if (dictionaryService.existsItem(replacableSignId)) {
			dictionaryService.deleteSign(replacableSign);
			assertFalse(dictionaryService.existsItem(replacableSignId));
		}
		if (dictionaryService.existsItem(importedSignId)) {
			// Use signDb to delete IMPORTED signs
			getSignDB().deleteSign(importedSignPuddleSign);
			assertFalse(dictionaryService.existsItem(importedSignId));
		}

	}

	@Test
	public void testSignAlternativesAscending() {
		// Prepare
		String signWord = "delegs";
		SignId signId_0 = new SignId(upperIdPart, signWord, signLocale, SignSource.IMPORTED);
		SimpleSign sign_0 = new SimpleSign(signId_0, user, signLocale, new Date(1), "");
		SignId signId_1 = new SignId(upperIdPart + 1, signWord, signLocale, SignSource.IMPORTED);
		SimpleSign sign_1 = new SimpleSign(signId_1, user, signLocale, new Date(1), "");
		SignId signId_2 = new SignId(upperIdPart + 2, signWord, signLocale, SignSource.IMPORTED);
		SimpleSign sign_2 = new SimpleSign(signId_2, user, signLocale, new Date(1), "");

		deleteSignsForSearchWord(signWord, signLocale);

		try {
			dictionaryService.saveSign(signWord, sign_0, sessionKey);
			dictionaryService.saveSign(signWord, sign_1, sessionKey);
			dictionaryService.saveSign(signWord, sign_2, sessionKey);

			List<String> wordList = new ArrayList<String>();
			wordList.add(signWord);
			List<SignLocale> signLocaleList = new ArrayList<SignLocale>();
			signLocaleList.add(signLocale);

			// Action
			Map<String, List<SignItem>> foundSigns = dictionaryService.findSigns(wordList, signLocaleList);
			List<SignItem> signList = foundSigns.get(signWord);

			// Check
			assertEquals(signId_0, signList.get(0).getSignId());
			assertEquals(signId_1, signList.get(1).getSignId());
			assertEquals(signId_2, signList.get(2).getSignId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteSigns(signId_0, signId_1, signId_2);
		}
	}

	@Test
	public void testGetNewSignUpperId() throws Exception {

		// Clean up db
		deleteSigns(dgsSignId, aslSignId);

		long initialNewUpperId = dictionaryService.getNewSignUpperId(signLocale);

		assertFalse(dictionaryService.existsItem(importedButOverwrittenSignId));
		dictionaryService.saveSign(word, importedSign, sessionKey);
		dictionaryService.saveSign(word, importedButOverwrittenSign, sessionKey);
		assertTrue(dictionaryService.existsItem(importedButOverwrittenSignId));

		long newUpperId = dictionaryService.getNewSignUpperId(signLocale);

		assertEquals(importedButOverwrittenSign.getSignId().getUpperIdPart() + 1, newUpperId);

		dictionaryService.deleteSign(importedButOverwrittenSign);
		assertFalse(dictionaryService.existsItem(importedButOverwrittenSignId));

		assertEquals(upperIdPart + 1, dictionaryService.getNewSignUpperId(signLocale).longValue());
	}

	@Test
	public void testFindSignsWithListOfWords() throws Exception {
		// Prepare
		SignId delegsSignId = new SignId(upperIdPart, word, signLocale, SignSource.DELEGS);
		SimpleSign delegsSign = new SimpleSign(delegsSignId, user, signLocale, new Date(1), comment);

		String secondWord = "ZweitesWort".toLowerCase();

		SignId secondImportedSignId = new SignId(upperIdPart + 22, secondWord, signLocale, SignSource.IMPORTED);
		SimpleSign secondImportedSign = new SimpleSign(secondImportedSignId, user, signLocale, new Date(1), comment);
		SignId secondImportedButOverwrittenSignId = new SignId(upperIdPart + 22, secondWord, signLocale,
				SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
		SimpleSign secondImportedButOverwrittenSign = new SimpleSign(secondImportedButOverwrittenSignId, user,
				signLocale, new Date(1), comment);

		deleteSigns(delegsSignId, secondImportedSignId, secondImportedButOverwrittenSignId);

		List<String> searchWordList = new ArrayList<String>();
		List<SignLocale> testLocales = new ArrayList<SignLocale>();
		searchWordList.add(word);
		testLocales.add(signLocale);
		searchWordList.add(secondWord);
		testLocales.add(signLocale);

		Map<String, List<SignItem>> resultWithNoEntry = dictionaryService.findSigns(searchWordList, testLocales);
		assertNotNull(resultWithNoEntry);
		assertFalse(resultWithNoEntry.containsKey(word));
		assertFalse(resultWithNoEntry.containsKey(secondWord));

		if (!dictionaryService.existsItem(importedSignId)) {
			dictionaryService.saveSign(word, importedSign, sessionKey);
			assertTrue(dictionaryService.existsItem(importedSignId));
		}
		if (!dictionaryService.existsItem(secondImportedSignId)) {
			dictionaryService.saveSign(secondWord, secondImportedSign, sessionKey);
			assertTrue(dictionaryService.existsItem(secondImportedSignId));
		}

		Map<String, List<SignItem>> resultWithOneEntry = dictionaryService.findSigns(searchWordList, testLocales);
		assertNotNull(resultWithOneEntry);
		assertEquals(1, resultWithOneEntry.get(word).size());
		assertEquals(1, resultWithOneEntry.get(secondWord).size());

		dictionaryService.saveSign(word, importedButOverwrittenSign, sessionKey);

		Map<String, List<SignItem>> resultWithTwoEntries = dictionaryService.findSigns(searchWordList, testLocales);
		assertNotNull(resultWithTwoEntries);
		assertEquals(1, resultWithTwoEntries.get(word).size());
		assertEquals(1, resultWithTwoEntries.get(secondWord).size());

		dictionaryService.saveSign(word, delegsSign, sessionKey);
		Map<String, List<SignItem>> resultWithEntries = dictionaryService.findSigns(searchWordList, testLocales);
		assertNotNull(resultWithEntries);
		assertEquals(2, resultWithEntries.get(word).size());
		assertEquals(1, resultWithEntries.get(secondWord).size());

		if (!dictionaryService.existsItem(secondImportedButOverwrittenSignId)) {
			dictionaryService.saveSign(secondWord, secondImportedButOverwrittenSign, sessionKey);
			assertTrue(dictionaryService.existsItem(secondImportedButOverwrittenSignId));
		}

		Map<String, List<SignItem>> resultWithOverwrittenEntry = dictionaryService.findSigns(searchWordList,
				testLocales);
		assertNotNull(resultWithOverwrittenEntry);
		assertEquals(2, resultWithOverwrittenEntry.get(word).size());
		assertEquals(1, resultWithOverwrittenEntry.get(secondWord).size());

		dictionaryService.deleteSign(delegsSign);

		assertEquals(1, dictionaryService.findSigns(searchWordList, testLocales).get(word).size());

		if (dictionaryService.existsItem(delegsSignId)) {
			dictionaryService.deleteSign(delegsSign);
		}
		if (dictionaryService.existsItem(importedSignId)) {
			// Use signDb to delete IMPORTED signs
			getSignDB().deleteSign(importedSign);
		}
		if (dictionaryService.existsItem(secondImportedButOverwrittenSignId)) {
			dictionaryService.deleteSign(secondImportedButOverwrittenSign);
		}
		if (dictionaryService.existsItem(secondImportedSignId)) {
			// Use signDb to delete IMPORTED signs
			getSignDB().deleteSign(secondImportedSign);
		}

	}

	@Test
	public void testGetSignFromHistory() throws Exception {

		dictionaryService.saveSign(word, importedSign, sessionKey);
		SimpleSign savedSignWithRightRevision = dictionaryService.getSign(importedSignId);

		List<SignHistoryItem> emptySignHistoryList = dictionaryService.getSignHistoryFor(importedSignId);
		assertNotNull(emptySignHistoryList);
		assertEquals(0, emptySignHistoryList.size());

		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(1, 1, 1, 1, 1, 1, 1, 1), 12, 12, 2);
		importedSign.addSymbol(positionedSymbol);
		importedSign.setComment("Jetzt ändere ich dich ab!");
		dictionaryService.updateSign(importedSign, sessionKey);

		List<SignHistoryItem> signHistoryList = dictionaryService.getSignHistoryFor(importedSignId);
		assertTrue(signHistoryList != null);
		assertEquals(1, signHistoryList.size());

		SignHistoryItem signHistoryItemForImportedSign = signHistoryList.get(0);
		assertEquals(savedSignWithRightRevision, dictionaryService.getSignFromHistory(signHistoryItemForImportedSign));

	}

	private boolean containsSignId(RevisionedWordToSignsDictionaryEntries dictionaryEntries, SignId signId) {
		assert dictionaryEntries != null : "Precondition failed: dictionaryEntries != null";
		assert signId != null : "Precondition failed: signId != null";

		boolean result = false;

		for (WordToSignsDictionaryEntry dictionaryEntry : dictionaryEntries.getDictionaryEntries()) {
			if (dictionaryEntry.containsSignId(signId)) {
				result = true;
				break;
			}
		}

		return result;
	}

	private void deleteSignsForSearchWord(String searchWord, SignLocale signLocale) {
		List<SignItem> foundSigns = getSignDB().findSigns(searchWord, signLocale);
		for (SignItem sign : foundSigns) {
			getSignDB().deleteSign(sign.getSignId());
		}
	}

	private class ExtendedSignHistoryDb extends MaterialDB {

		private static final String POSITIONED_SYMBOLS_HISTORY_TABLE_NAME = "positionedsymbolshistory";
		private static final String SIGN_HISTORY_TABLE_NAME = "signshistory";

		protected ExtendedSignHistoryDb(DbConnector connector) {
			super(connector);
		}

		public void removeAllEntriesFromHistoryTables() {
			createQuery("DELETE FROM " + SIGN_HISTORY_TABLE_NAME).execute();
			createQuery("DELETE FROM " + POSITIONED_SYMBOLS_HISTORY_TABLE_NAME).execute();
		}
	}
}
