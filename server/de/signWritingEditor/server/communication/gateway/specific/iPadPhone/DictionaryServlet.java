package de.signWritingEditor.server.communication.gateway.specific.iPadPhone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.infrastructure.JsonSerializer;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignBookDB;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.AuthenticationServiceImpl;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.server.service.SendEmailService;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.server.service.signbook.SignBookService;
import de.signWritingEditor.server.service.signbook.SignBookServiceImpl;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class DictionaryServlet extends SignWritingServlet {

	private static final String LOWER_ID_PARAMETER = "lowerId";
	private static final String UPPER_ID_PARAMETER = "upperId";
	private static final String SOURCE_PARAMETER = "singSource";
	private static final String SIGN_LOCALE_PARAMETER = "signLocale";
	private static final String REVISION_PARAMETER = "revision";

	private static final String USERNAME_PARAMETER = "username";
	private static final String PASSWORD_PARAMETER = "password";

	private enum DictionaryServletOperation {

		GET_SIGN("getSign"), FIND_ENTRIES("findEntries"), GET_SIGN_LOCALES("getSignLocales"),
		GET_ENTRIES_SINCE_REVISION("getEntriesSinceRevision"),
		GET_DELETED_ENTRIES_SINCE_REVISION("getDeletedEntriesSinceRevision"),
		GET_LOCALIZED_APP_DESCRIPTIONS("getLocalizedAppDescriptions"), GET_DB_REVISION("getDbRevision"),
		LOGIN("login");

		private final String operationName;

		DictionaryServletOperation(String operationName) {
			this.operationName = operationName;
		}
	}

	private static final long serialVersionUID = 5688888923191650035L;
	private static final Logger LOG = Logger.getLogger(DictionaryServlet.class);

	private DictionaryService _dictionaryService;
	private SignBookService _signBookService;
	private JsonSerializer jsonSerializer;

	private AuthenticationServiceImpl authService;
	private UserDb userDB;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService _configurationService = new ConfigurationService();
			DbConnector connector = new DbConnector(_configurationService);
			userDB = new UserDb(connector);
			SymbolDB symbolDB = new SymbolDB(connector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
			SignDB signDB = new SignDB(connector, userDB, symbolFactory, _configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDB, _configurationService, symbolFactory);
			_dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);
			SignBookDB signBookDB = new SignBookDB(connector);
			_signBookService = new SignBookServiceImpl(signBookDB);

			jsonSerializer = new JsonSerializer();

			SessionServiceImpl sessionService = new SessionServiceImpl(_configurationService);
			authService = new AuthenticationServiceImpl(userDB, sessionService,
					new SendEmailService(_configurationService));

		} catch (IOException e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		try {
			String operationParameter = request.getParameter("operation");
			if (DictionaryServletOperation.FIND_ENTRIES.operationName.equals(operationParameter)) {
				handleFindEntries(request, response);
			} else if (DictionaryServletOperation.GET_SIGN.operationName.equals(operationParameter)) {
				handleGetSign(request, response);
			} else if (DictionaryServletOperation.GET_SIGN_LOCALES.operationName.equals(operationParameter)) {
				handleGetSignLocales(request, response);
			} else if (DictionaryServletOperation.GET_ENTRIES_SINCE_REVISION.operationName.equals(operationParameter)) {
				handleGetEntriesSinceRevision(request, response);
			} else if (DictionaryServletOperation.GET_DELETED_ENTRIES_SINCE_REVISION.operationName
					.equals(operationParameter)) {
				handleGetDeletedEntriesSinceRevision(request, response);
			} else if (DictionaryServletOperation.GET_LOCALIZED_APP_DESCRIPTIONS.operationName
					.equals(operationParameter)) {
				handleGetLocalizedAppDescriptions(response);
			} else if (DictionaryServletOperation.GET_DB_REVISION.operationName.equals(operationParameter)) {
				handleGetDBRevision(response);
			} else if (DictionaryServletOperation.LOGIN.operationName.equals(operationParameter)) {
				handleLogin(request, response);
			} else {
				respondToBadRequest(response);
			}
		} catch (Exception e) {
			respondToInternalServerError(response);
			LOG.error(e);
		}
	}

	private void handleLogin(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";
		if (hasValidLoginParameters(request)) {
			String username = request.getParameter(USERNAME_PARAMETER);
			String password = request.getParameter(PASSWORD_PARAMETER);
			if (userDB.isValidCredential(username, password)) {
				// login
				UserSession userSession = authService.login(username, password);
				String userSessionAsJson = jsonSerializer.serializeUserSessionAsJson(userSession);
				sendResponse(response, userSessionAsJson);
			} else {
				respondToBadRequest(response);
			}
		} else {
			respondToBadRequest(response);
		}
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}

	private void handleGetEntriesSinceRevision(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidEntriesSinceRevisionParameters(request)) {
			SignLocale signLocale = SignLocale.valueOf(request.getParameter(SIGN_LOCALE_PARAMETER));
			long revision = Long.parseLong(request.getParameter(REVISION_PARAMETER));
			RevisionedWordToSignsDictionaryEntries entriesSinceRevision = _dictionaryService
					.getEntriesSinceRevision(revision, signLocale);
			String revisionedDictionaryEntriesAsJson = jsonSerializer
					.getRevisionedDictionaryEntriesAsJson(entriesSinceRevision);
			sendResponse(response, revisionedDictionaryEntriesAsJson);
		} else {
			respondToBadRequest(response);
		}
	}

	private void handleGetDeletedEntriesSinceRevision(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidEntriesSinceRevisionParameters(request)) {
			SignLocale signLocale = SignLocale.valueOf(request.getParameter(SIGN_LOCALE_PARAMETER));
			long revision = Long.parseLong(request.getParameter(REVISION_PARAMETER));
			RevisionedWordToSignsDictionaryEntries deletedEntriesSinceRevision = _dictionaryService
					.getDeletedEntriesSinceRevision(revision, signLocale);
			String deletedDictionaryEntriesAsJson = jsonSerializer
					.getRevisionedDictionaryEntriesAsJson(deletedEntriesSinceRevision);
			sendResponse(response, deletedDictionaryEntriesAsJson);

		} else {
			respondToBadRequest(response);
		}
	}

	private void handleGetLocalizedAppDescriptions(HttpServletResponse response) {
		assert response != null : "Precondition failed: response != null";

		String localizedAppDescriptionsAsJson = jsonSerializer
				.searializeLocalizedAppDescriptionsAsJson(this._signBookService.getLocalizedAppDescriptions());

		sendResponse(response, localizedAppDescriptionsAsJson);
	}

	private void handleGetDBRevision(HttpServletResponse response) {
		assert response != null : "Precondition failed: response != null";

		int databaseRevision = this._signBookService.getDatabaseRevision();
		String dbRevisionAsJson = jsonSerializer.serializeDbRevisionAsJson(databaseRevision);

		sendResponse(response, dbRevisionAsJson);
	}

	private void handleGetSignLocales(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		String signLocalesAsJson = jsonSerializer.serializeSignLocalesAsJson(SignLocale.values());
		sendResponse(response, signLocalesAsJson);
	}

	private void handleFindEntries(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidFindEntriesParameters(request)) {
			SignLocale signLocale = SignLocale.valueOf(request.getParameter(SIGN_LOCALE_PARAMETER));

			RevisionedWordToSignsDictionaryEntries dictionaryEntries = _dictionaryService.findEntries(signLocale);
			String dictionaryEntryListAsJson = jsonSerializer.getRevisionedDictionaryEntriesAsJson(dictionaryEntries);
			sendResponse(response, dictionaryEntryListAsJson);

		} else {
			respondToBadRequest(response);
		}
	}

	private void handleGetSign(HttpServletRequest request, HttpServletResponse response) {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidGetSignParameters(request)) {
			long upperId = Long.parseLong(request.getParameter(UPPER_ID_PARAMETER));
			SignLocale signLocale = SignLocale.valueOf(request.getParameter(SIGN_LOCALE_PARAMETER));
			SignSource source = SignSource.valueOf(request.getParameter(SOURCE_PARAMETER));
			SignId signId = new SignId(upperId, request.getParameter(LOWER_ID_PARAMETER), signLocale, source);
			if (_dictionaryService.existsItem(signId)) {
				SimpleSign sign = _dictionaryService.getSign(signId);
				sendResponse(response, jsonSerializer.serializeSignAsJson(sign));
			} else {
				respondToNotFound(response);
			}
		} else {
			respondToBadRequest(response);
		}
	}

	private boolean hasValidEntriesSinceRevisionParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		boolean result = false;

		String signLocaleParameter = request.getParameter(SIGN_LOCALE_PARAMETER);
		String revisionParameter = request.getParameter(REVISION_PARAMETER);

		if (signLocaleParameter != null) {
			if (isValidSignLocale(signLocaleParameter)) {
				result = isValidRevisionParameter(revisionParameter);
			}
		}

		return result;
	}

	private boolean hasValidFindEntriesParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		boolean result = false;
		String signLocaleParameter = request.getParameter(SIGN_LOCALE_PARAMETER);
		if (signLocaleParameter != null) {
			result = isValidSignLocale(signLocaleParameter);
		}
		return result;
	}

	private boolean hasValidGetSignParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		boolean result = false;
		String upperIdParameter = request.getParameter(UPPER_ID_PARAMETER);
		String lowerIdParameter = request.getParameter(LOWER_ID_PARAMETER);
		String signLocaleParameter = request.getParameter(SIGN_LOCALE_PARAMETER);
		if (upperIdParameter != null && lowerIdParameter != null && signLocaleParameter != null) {
			result = isValidIdParameter(upperIdParameter, lowerIdParameter, signLocaleParameter);
		}
		return result;
	}

	private boolean hasValidLoginParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		boolean result = false;
		String usernameParameter = request.getParameter(USERNAME_PARAMETER);
		String passwordParameter = request.getParameter(PASSWORD_PARAMETER);
		if (usernameParameter != null && passwordParameter != null) {
			result = User.isValidUsername(usernameParameter) && !passwordParameter.isEmpty();
		}
		return result;
	}

	private boolean isValidIdParameter(String upperIdParameter, String lowerIdParameter, String signLocaleParameter) {
		assert upperIdParameter != null : "Precondition failed: upperIdParameter != null";
		assert lowerIdParameter != null : "Precondition failed: lowerIdParameter != null";
		assert signLocaleParameter != null : "Precondition failed: signLocaleParameter != null";

		boolean result = false;
		try {
			Long.parseLong(upperIdParameter); // parameter is valid if it can be
												// parsed as long
			SignLocale.valueOf(signLocaleParameter); // parameter is valid if it
														// has valid sign locale
			result = lowerIdParameter.length() > 0;
		} catch (Exception ignored) {
		}

		return result;
	}

	private boolean isValidRevisionParameter(String revisionParameter) {
		assert revisionParameter != null : "Precondition failed: revisionParameter != null";

		long parameterValue = Long.parseLong(revisionParameter);
		return parameterValue >= 0;
	}

	private boolean isValidSignLocale(String signLocaleParameter) {
		assert signLocaleParameter != null : "Precondition failed: signLocaleParameter != null";

		boolean result = false;
		for (SignLocale signLocale : SignLocale.values()) {
			if (signLocale.name().equals(signLocaleParameter)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
