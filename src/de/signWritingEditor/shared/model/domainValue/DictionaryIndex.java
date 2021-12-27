package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

public class DictionaryIndex implements Serializable {

	private static final long serialVersionUID = 5461538557977805796L;
	private char dictionaryIndexCharacter;

	@Deprecated
	public DictionaryIndex() {
	}

	public DictionaryIndex(char dictionaryIndexCharacter) {
		this.dictionaryIndexCharacter = dictionaryIndexCharacter;
	}

	public char getDictionaryIndexCharacter() {
		return dictionaryIndexCharacter;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other != null && other instanceof DictionaryIndex) {
			result = this.dictionaryIndexCharacter == ((DictionaryIndex) other).getDictionaryIndexCharacter();
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Character.valueOf(getDictionaryIndexCharacter()).hashCode();
	}

	public String toString() {
		return "" + dictionaryIndexCharacter;
	}
}
