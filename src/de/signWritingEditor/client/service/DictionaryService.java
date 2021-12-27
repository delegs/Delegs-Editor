package de.signWritingEditor.client.service;

import java.util.List;
import java.util.Map;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;

public interface DictionaryService {
	void saveSign(String word, SimpleSign sign, SessionKey sessionKey) throws Exception;

	void deleteSign(SimpleSign sign);

	void hideSign(SimpleSign sign, SessionKey sessionKey) throws Exception;

	boolean existsItem(SignId signId);

	List<SignItem> findSigns(String word, SignLocale language);

	Map<String, List<SignItem>> findSigns(List<String> words, List<SignLocale> locales);

	List<String> findSignWordsWithPrefix(String prefix, Integer count, SignLocale language);

	RevisionedWordToSignsDictionaryEntries findEntries(SignLocale signLocale);

	RevisionedWordToSignsDictionaryEntries getEntriesSinceRevision(long revision, SignLocale signLocale);

	RevisionedWordToSignsDictionaryEntries getDeletedEntriesSinceRevision(long revision, SignLocale signLocale);

	long getModificationDate(SignId signId);

	void updateSign(SimpleSign sign, SessionKey sessionKey) throws Exception;

	SimpleSign getSign(SignId signId);

	Long getNewSignUpperId(SignLocale locale);

	boolean isSignReplacable(boolean saveLocally, SimpleSign sign, boolean isLocallySaved);

	List<SignHistoryItem> getSignHistoryFor(SignId signId);

	SimpleSign getSignFromHistory(SignHistoryItem signHistoryItem);

	SignSource resolveLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale);
}
