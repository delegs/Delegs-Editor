package de.signWritingEditor.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class DictionaryServiceImpl implements DictionaryService {

	private final SignDB signDB;
	private SignHistoryDB signHistoryDb;

	public DictionaryServiceImpl(SignDB signDb, SignHistoryDB signHistoryDb) {
		assert signDb != null : "Precondition failed: signDb != null";
		assert signHistoryDb != null : "Precondition failed: signHistoryDb != null";

		this.signHistoryDb = signHistoryDb;
		this.signDB = signDb;
	}

	@Override
	public void saveSign(String word, SimpleSign sign, SessionKey sessionKey) throws Exception {
		assert word != null : "Precondition failed: word != null";
		assert sign != null : "Precondition failed: sign != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		signDB.saveSign(word, sign);

		// If a signPuddleSigne is updated the saveSign-Method is called. The
		// following part handles the cach
		if (sign.getSignId().getSignSource().equals(SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS)) {

			SignId signCouldBeOverwritingSignPuddleSignId = new SignId(sign.getSignId().getUpperIdPart(),
					sign.getSignId().getLowerIdPart(), sign.getSignId().getSignLocale(), SignSource.IMPORTED);

			clearCachedSignImage(signCouldBeOverwritingSignPuddleSignId);
		}

	}

	@Override
	public void deleteSign(SimpleSign sign) {
		assert sign != null : "sign != null";
		assert existsItem(sign.getSignId()) : "exists(sign.getMeaning())";
		assert sign.getSignId()
				.getSignSource() != SignSource.IMPORTED : "Precondition failed: sign.getSignId().getSignSource() != SignSource.IMPORTED";

		signDB.deleteSign(sign);
		signHistoryDb.deleteSignHistoryForSign(sign.getSignId());

		clearCachedSignImage(sign.getSignId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gebaerden.signWritingEditor.server.service.DictionaryService#
	 * existsItem (java.lang.String)
	 */
	@Override
	public boolean existsItem(SignId signId) {
		assert signId != null : "signId != null";
		return signDB.existsItem(signId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.gebaerden.signWritingEditor.server.service.DictionaryService#findSigns
	 * (java.lang.String)
	 */
	@Override
	public List<SignItem> findSigns(String word, SignLocale language) {
		assert word != null : "word != null";

		// Es werden alle Elemente für jede benötigte Sprache aus der Datenbank
		// gelesen. Da ein Datenbankzugriff imperformant ist, werden alle
		// Einträge in einem Zugriff geholt.
		return signDB.findSigns(word, language);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gebaerden.signWritingEditor.server.service.DictionaryService#
	 * findSignsWithPrefix (java.lang.String)
	 */
	@Override
	public List<String> findSignWordsWithPrefix(String prefix, Integer count, SignLocale language) {
		assert prefix != null : "prefix != null";

		return signDB.findSignWordsWithPrefix(prefix, count, language);
	}

	@Override
	public Map<String, List<SignItem>> findSigns(List<String> words, List<SignLocale> signLocales) {
		assert words != null : "Precondition failed: words != null";
		assert signLocales != null : "Precondition failed: signLocales != null";
		assert words.size() == signLocales.size() : "Precondition failed: words.size() == signLocales.size()";

		Map<String, List<SignItem>> result = new HashMap<String, List<SignItem>>();

		HashMap<SignLocale, List<String>> signlocaleToWords = new HashMap<SignLocale, List<String>>();
		for (int i = 0; i < words.size(); i++) {
			SignLocale key = signLocales.get(i);
			List<String> list;
			if (signlocaleToWords.containsKey(key)) {
				list = signlocaleToWords.get(key);
			} else {
				list = new ArrayList<String>();
				signlocaleToWords.put(key, list);
			}
			list.add(words.get(i));
		}

		// Es werden alle Elemente für jede benötigte Sprache aus der Datenbank
		// gelesen. Da ein Datenbankzugriff imperformant ist, werden alle
		// Einträge in einem Zugriff geholt.

		for (SignLocale locale : signlocaleToWords.keySet()) {
			Map<String, List<SignItem>> queryResult = signDB.findSigns(locale, signlocaleToWords.get(locale));
			for (String word : queryResult.keySet()) {
				if (result.containsKey(word)) {
					result.get(word).addAll(queryResult.get(word));
				} else {
					result.put(word, queryResult.get(word));
				}
			}
		}

		return result;
	}

	@Override
	public RevisionedWordToSignsDictionaryEntries findEntries(SignLocale signLocale) {
		assert signLocale != null : "Precondition failed: signLocale != null";

		return signDB.findEntries(signLocale);
	}

	public RevisionedWordToSignsDictionaryEntries getEntriesSinceRevision(long revision, SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";

		return signDB.getEntriesSinceRevision(revision, signLocale);
	}

	public RevisionedWordToSignsDictionaryEntries getDeletedEntriesSinceRevision(long revision, SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";

		return signDB.getDeletedEntriesSinceRevision(revision, signLocale);
	}

	public long getModificationDate(SignId signId) {
		return signDB.getModificationDate(signId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gebaerden.signWritingEditor.server.service.DictionaryService#
	 * updateSign (de.gebaerden.signWritingEditor.client .material.Sign)
	 */
	@Override
	public void updateSign(SimpleSign sign, SessionKey sessionKey) {
		assert sign != null : "sign != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		signDB.updateSign(sign);

		clearCachedSignImage(sign.getSignId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.signWritingEditor.client.service.DictionaryService#getSign(de.
	 * signWritingEditor.client.domainValue.SignId)
	 */
	@Override
	public SimpleSign getSign(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		SimpleSign result = signDB.getSign(signId);

		assert result != null : "Postcondition failed: result != null";
		assert result.getSignId().equals(signId) : "Postcondition failed: result.getSignId().equals(signId)";
		return result;
	}

	@Override
	public SimpleSign getSignFromHistory(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: signHistoryItem != null";

		SimpleSign result = signHistoryDb.getSign(signHistoryItem);

		assert result != null : "Postcondition failed: result != null";
		assert result.getSignId().equals(signHistoryItem
				.getSignId()) : "Postcondition failed: result.getSignId().equals(signHistoryItem.getSignId())";
		return result;
	}

	@Override
	public List<SignHistoryItem> getSignHistoryFor(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		return signHistoryDb.getSignHistoryItemsFor(signId);
	}

	@Override
	public Long getNewSignUpperId(SignLocale locale) {
		assert locale != null : "Precondition failed: locale != null";

		return signDB.getNewSignUpperId(locale);
	}

	private boolean existsSign(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		return signDB.existsItem(sign.getSignId());
	}

	@Override
	public boolean isSignReplacable(boolean saveLocally, SimpleSign sign, boolean isLocallySaved) {
		assert sign != null : "Precondition failed: sign != null";

		boolean result = false;

		if (saveLocally && isLocallySaved) {
			result = true;
		} else if (saveLocally && !isLocallySaved) {
			result = false;
			// } else if (existsSign(sign) && !isSignPuddleSign(sign)) {
		} else if (existsSign(sign)) {
			result = true;
		}

		return result;
	}

	private void clearCachedSignImage(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		ConfigurationService configurationService;
		try {
			configurationService = new ConfigurationService();
			SignImageCache signImageCache = new SignImageFileSystemCache(configurationService);
			if (signImageCache.containsSignImagesFor(signId)) {
				signImageCache.removeSignImagesFor(signId);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hideSign(SimpleSign sign, SessionKey sessionKey) {
		assert sign != null : "Precondition failed: sign != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		signDB.addSignToDeletedSignsTable(sign.getSignId());
		clearCachedSignImage(sign.getSignId());
	}

	@Override
	public SignSource resolveLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale) {
		return signDB.findLatestSource(upperIdPart, lowerIdPart, signLocale);
	}
}
