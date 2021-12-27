package de.signWritingEditor.server.service.signbook;

import java.util.Map;

import de.signWritingEditor.server.persistence.SignBookDB;

public class SignBookServiceImpl implements SignBookService {

	private final SignBookDB signBookDB;

	public SignBookServiceImpl(SignBookDB signBookDB) {
		assert signBookDB != null : "Precondition failed: signBookDB != null";

		this.signBookDB = signBookDB;
	}

	@Override
	public Map<String, String> getLocalizedAppDescriptions() {
		return this.signBookDB.getAllLocalizedAppDescriptions();
	}

	@Override
	public int getDatabaseRevision() {
		return this.signBookDB.getDatabaseVersion();
	}
}
