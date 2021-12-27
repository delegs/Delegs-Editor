package de.signWritingEditor.server.persistence.infrastructure;

import java.io.IOException;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public abstract class SignPersistenceTestCase {

	private SignDB signDB;
	private SymbolFactory symbolFactory;
	private DbConnector connector;
	private SignHistoryDB signHistoryDb;
	private UserDb userDB;
	protected ConfigurationService configurationService;

	public void setUp() throws IOException {
		configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		userDB = new UserDb(connector);
		signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
		signHistoryDb = new SignHistoryDB(connector, userDB, configurationService, symbolFactory);
	}

	protected SignDB getSignDB() {
		return signDB;
	}

	protected SymbolFactory getSymbolFactory() {
		return symbolFactory;
	}

	protected SignHistoryDB getSignHistoryDb() {
		return signHistoryDb;
	}

	protected DbConnector getConnector() {
		return connector;
	}

	protected void closeConnector() {
		connector = null;
	}

	public UserDb getUserDB() {
		return userDB;
	}

	protected void deleteSigns(SignId... signIds) {
		for (SignId signId : signIds) {
			deleteSign(signId);
		}
	}

	protected void deleteSign(SignId signId) {
		if (signDB.existsItem(signId)) {
			signDB.deleteSign(signId);
		}
	}
}
