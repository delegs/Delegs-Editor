package de.signWritingEditor.shared.model.material;

import java.util.List;

import de.signWritingEditor.shared.model.domainValue.SignId;

public class WordToSignsDictionaryEntry {

	private final String word;
	private final List<SignId> signIds;

	public WordToSignsDictionaryEntry(String word, List<SignId> signIds) {
		assert word != null : "Precondition failed: word != null";
		assert signIds != null : "Precondition failed: signIds != null";

		this.word = word;
		this.signIds = signIds;
	}

	public String getWord() {
		return word;
	}

	public List<SignId> getSignIds() {
		return signIds;
	}

	public boolean containsSignId(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		return signIds.contains(signId);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Ids: ");
		for (SignId signId : this.getSignIds()) {
			result.append(signId + ", ");
		}
		result.append("Word: " + this.getWord());
		return result.toString();
	}
}
