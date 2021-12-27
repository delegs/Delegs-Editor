package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class Sign extends SimpleSign {

	private static final long serialVersionUID = 1L;
	private SignMetaData signMetaData;

	public static final Sign emptySign = new Sign(SignId.emptySignId, User.getSystemUser(), SignLocale.DGS, new Date(0),
			null, null);

	public Sign(SignId id, User author, SignLocale language, Date modificationDate, String comment,
			SignMetaData signMetaData) {
		super(id, author, language, modificationDate, comment);
		this.signMetaData = signMetaData;
	}

	public SignMetaData getSignMetaData() {
		return signMetaData;
	}

	@Deprecated
	public Sign() {
	}

}
