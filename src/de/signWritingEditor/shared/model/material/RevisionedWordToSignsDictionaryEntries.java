package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RevisionedWordToSignsDictionaryEntries implements Serializable {

	private static final long serialVersionUID = 1283860301057729727L;

	private long revision;
	private List<WordToSignsDictionaryEntry> wordToSignsDictionaryEntries;

	public RevisionedWordToSignsDictionaryEntries() {
		this.wordToSignsDictionaryEntries = new ArrayList<WordToSignsDictionaryEntry>();
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		assert revision >= 0 : "Precondition failed: revision >= 0";

		this.revision = revision;
	}

	public void addDictionaryEntry(WordToSignsDictionaryEntry wordToSignsDictionaryEntry) {
		assert wordToSignsDictionaryEntry != null : "Precondition failed: wordToSignsDictionaryEntry != null";
		assert !this.containsDictionaryEntry(
				wordToSignsDictionaryEntry) : "Precondition failed: !this.containsDictionaryEntry(wordToSignsDictionaryEntry)";

		this.wordToSignsDictionaryEntries.add(wordToSignsDictionaryEntry);
	}

	public void removeDictionaryEntry(WordToSignsDictionaryEntry wordToSignsDictionaryEntry) {
		assert wordToSignsDictionaryEntry != null : "Precondition failed: wordToSignsDictionaryEntry != null";
		assert containsDictionaryEntry(
				wordToSignsDictionaryEntry) : "Precondition failed: containsDictionaryEntry(wordToSignsDictionaryEntry)";

		this.wordToSignsDictionaryEntries.remove(wordToSignsDictionaryEntry);
	}

	public boolean containsWord(String word) {
		assert word != null : "Precondition failed: word != null";

		boolean result = false;
		for (WordToSignsDictionaryEntry wordToSignsDictionaryEntry : this.wordToSignsDictionaryEntries) {
			if (wordToSignsDictionaryEntry.getWord().equals(word)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public boolean containsDictionaryEntry(WordToSignsDictionaryEntry wordToSignsDictionaryEntry) {
		assert wordToSignsDictionaryEntry != null : "Precondition failed: wordToSignsDictionaryEntry != null";

		return this.wordToSignsDictionaryEntries.contains(wordToSignsDictionaryEntry);
	}

	public WordToSignsDictionaryEntry getDictionaryEntry(String word) {
		assert word != null : "Precondition failed: word != null";
		assert this.containsWord(word) : "Precondition failed: this.containsMeaning(word)";

		WordToSignsDictionaryEntry result = null;
		for (WordToSignsDictionaryEntry wordToSignsDictionaryEntry : this.wordToSignsDictionaryEntries) {
			if (wordToSignsDictionaryEntry.getWord().equals(word)) {
				result = wordToSignsDictionaryEntry;
				break;
			}
		}

		return result;
	}

	public List<WordToSignsDictionaryEntry> getDictionaryEntries() {
		return wordToSignsDictionaryEntries;
	}
}
