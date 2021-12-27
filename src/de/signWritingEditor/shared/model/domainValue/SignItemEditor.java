package de.signWritingEditor.shared.model.domainValue;

import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class SignItemEditor extends SignItem {

	private String searchWord;

	public SignItemEditor(SignId signId, int signWidth, String word) {
		super(signId, signWidth);

		searchWord = word;
	}

	public SignItemEditor(SimpleSign localSign, String word) {
		super(localSign);
		searchWord = word;
	}

	public SignId getSignId() {
		return super.getSignId();
	}

	public boolean hasLocalSign() {
		return super.getLocalSign() != null;
	}

	public SimpleSign getSignItem() {
		return super.getLocalSign();
	}

	public String getSearchWord() {
		return searchWord;
	}

}
