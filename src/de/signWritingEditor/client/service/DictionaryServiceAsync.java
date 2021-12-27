package de.signWritingEditor.client.service;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;

public interface DictionaryServiceAsync {
	void saveSign(String word, SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> callback);

	void deleteSign(SimpleSign sign, AsyncCallback<Void> callback);

	void existsItem(SignId signId, AsyncCallback<Boolean> callback);

	void findSigns(String word, SignLocale language, AsyncCallback<List<SignItem>> callback);

	void findSignWordsWithPrefix(String prefix, Integer count, SignLocale language,
			AsyncCallback<List<String>> callback);

	void findSigns(List<String> words, List<SignLocale> locales, AsyncCallback<Map<String, List<SignItem>>> callback);

	void findEntries(SignLocale signLocale, AsyncCallback<List<WordToSignsDictionaryEntry>> callback);

	void getEntriesSinceRevision(long revision, SignLocale signLocale,
			AsyncCallback<RevisionedWordToSignsDictionaryEntries> callback);

	void getDeletedEntriesSinceRevision(long revision, SignLocale signLocale,
			AsyncCallback<RevisionedWordToSignsDictionaryEntries> callback);

	void getModificationDate(SignId signId, AsyncCallback<Long> callback);

	void updateSign(SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> callback);

	void getSign(SignId signId, AsyncCallback<SimpleSign> callback);

	void getNewSignUpperId(SignLocale locale, AsyncCallback<Long> callback);

	void isSignReplacable(boolean saveLocally, SimpleSign sign, boolean isLocallySaved,
			AsyncCallback<Boolean> callback);

	void getSignHistoryFor(SignId signId, AsyncCallback<List<SignHistoryItem>> callback);

	void getSignFromHistory(SignHistoryItem signHistoryItem, AsyncCallback<SimpleSign> callback);

	void hideSign(SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> asyncCallback);

	void resolveLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale,
			AsyncCallback<SignSource> asyncCallback);
}
