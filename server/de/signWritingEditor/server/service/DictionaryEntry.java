package de.signWritingEditor.server.service;

import de.signWritingEditor.shared.model.material.SimpleSign;

public class DictionaryEntry {
	private String word;
	private SimpleSign sign;

	public DictionaryEntry(String word, SimpleSign sign) {
		assert word != null : "Precondition failed: word != null";
		assert sign != null : "Precondition failed: sign != null";

		this.word = word;
		this.sign = sign;
	}

	public String getWord() {
		assert word != null : "Postcondition failed: result != null";

		return word;
	}

	public SimpleSign getSign() {
		assert sign != null : "Postcondition failed: result != null";

		return sign;
	}

	@Override
	public String toString() {
		return "DictionaryEntry [word=" + word + ", sign=" + sign + "]";
	}

}
