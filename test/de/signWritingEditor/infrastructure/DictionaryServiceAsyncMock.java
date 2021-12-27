package de.signWritingEditor.infrastructure;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;

public class DictionaryServiceAsyncMock implements DictionaryServiceAsync {
	@Override
	public void saveSign(String word, SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> callback) {
	}

	@Override
	public void deleteSign(SimpleSign sign, AsyncCallback<Void> callback) {
	}

	@Override
	public void existsItem(SignId signId, AsyncCallback<Boolean> callback) {
	}

	@Override
	public void findSigns(String word, SignLocale language, AsyncCallback<List<SignItem>> callback) {
	}

	@Override
	public void updateSign(SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> callback) {
	}

	@Override
	public void getSign(SignId signId, AsyncCallback<SimpleSign> callback) {
	}

	@Override
	public void findSigns(List<String> words, List<SignLocale> locales,
			AsyncCallback<Map<String, List<SignItem>>> callback) {
	}

	@Override
	public void findSignWordsWithPrefix(String prefix, Integer count, SignLocale language,
			AsyncCallback<List<String>> callback) {
	}

	@Override
	public void findEntries(SignLocale signLocale, AsyncCallback<List<WordToSignsDictionaryEntry>> callback) {
	}

	@Override
	public void getEntriesSinceRevision(long revision, SignLocale signLocale,
			AsyncCallback<RevisionedWordToSignsDictionaryEntries> callback) {
	}

	@Override
	public void getDeletedEntriesSinceRevision(long revision, SignLocale signLocale,
			AsyncCallback<RevisionedWordToSignsDictionaryEntries> callback) {
	}

	@Override
	public void getNewSignUpperId(SignLocale locale, AsyncCallback<Long> callback) {
	}

	@Override
	public void isSignReplacable(boolean saveLocally, SimpleSign sign, boolean isLocallySaved,
			AsyncCallback<Boolean> callback) {

	}

	@Override
	public void getSignHistoryFor(SignId signId, AsyncCallback<List<SignHistoryItem>> callback) {
	}

	@Override
	public void getSignFromHistory(SignHistoryItem signHistoryItem, AsyncCallback<SimpleSign> callback) {
	}

	@Override
	public void hideSign(SimpleSign sign, SessionKey sessionKey, AsyncCallback<Void> asyncCallback) {
	}

	@Override
	public void getModificationDate(SignId signId, AsyncCallback<Long> callback) {
	}

	@Override
	public void resolveLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale,
			AsyncCallback<SignSource> asyncCallback) {
	}
}
