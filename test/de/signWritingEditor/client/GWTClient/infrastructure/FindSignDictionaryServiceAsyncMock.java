package de.signWritingEditor.client.GWTClient.infrastructure;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.SignItem;

public class FindSignDictionaryServiceAsyncMock extends DictionaryServiceAsyncMock {
	private String dictionaryWord;

	public String getDictionaryWord() {
		return dictionaryWord;
	}

	@Override
	public void findSigns(String word, SignLocale language, AsyncCallback<List<SignItem>> callback) {
		this.dictionaryWord = word;
	}

	@Override
	public void findSigns(List<String> words, List<SignLocale> locale,
			AsyncCallback<Map<String, List<SignItem>>> callback) {
		this.dictionaryWord = words.get(0);
	}
}
