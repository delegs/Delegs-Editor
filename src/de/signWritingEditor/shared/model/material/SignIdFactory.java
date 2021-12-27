package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.SignId;

public class SignIdFactory {

	private long highestUpperId;

	public SignIdFactory() {
		highestUpperId = System.currentTimeMillis();
	}

	public SignId createNewSignIdFrom(SignId signId) {
		highestUpperId++;
		return new SignId(highestUpperId, signId.getLowerIdPart(), signId.getSignLocale(), signId.getSignSource());
	}

}
