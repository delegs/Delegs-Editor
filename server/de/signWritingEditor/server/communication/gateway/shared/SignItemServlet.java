package de.signWritingEditor.server.communication.gateway.shared;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.DictionaryServiceImpl;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SignItemServlet extends HttpServlet {
	private static final long serialVersionUID = 5688888923191650035L;
	private static final Logger LOG = Logger.getLogger(SignItemServlet.class);
	private static final int DEFAULT_COUNT = 10;

	private DictionaryService _dictionaryService;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService _configurationService = new ConfigurationService();
			DbConnector connector = new DbConnector(_configurationService);
			UserDb userDB = new UserDb(connector);
			SymbolDB symbolDB = new SymbolDB(connector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
			SignDB signDB = new SignDB(connector, userDB, symbolFactory, _configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDB, _configurationService, symbolFactory);
			_dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);
		} catch (IOException e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		String callbackNameInput = request.getParameter("callback");
		String countInput = request.getParameter("count");
		String prefixInput = request.getParameter("prefix");
		String wordInput = request.getParameter("word");
		int count = DEFAULT_COUNT;

		try {
			count = Integer.parseInt(countInput);
		} catch (Exception ignored) {
		}

		if (callbackNameInput == null) {
			callbackNameInput = "";
		}

		String responseString = null;
		if (prefixInput != null) {
			List<String> resultList = _dictionaryService.findSignWordsWithPrefix(prefixInput, count, SignLocale.DGS);
			responseString = resultStringListToJson(resultList, callbackNameInput);
		} else {
			if (wordInput != null) {
				List<SignItem> resultList = _dictionaryService.findSigns(wordInput, SignLocale.DGS);
				responseString = resultSignListToJson(resultList, callbackNameInput);
			}
		}

		OutputStream outputStream = null;
		PrintStream printStream = null;
		try {
			if (responseString != null) {
				outputStream = response.getOutputStream();
				printStream = new PrintStream(outputStream);
				printStream.print(responseString);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			if (outputStream != null) {
				printStream.close();
				outputStream.close();
			}
		}
	}

	private String resultStringListToJson(List<String> resultList, String callBack) {
		String result = null;
		if (resultList != null && resultList.size() > 0) {
			result = callBack + "([";
			for (String word : resultList) {
				result = result.concat("\"" + word + "\",");
			}
			result = result.substring(0, result.length() - 1);
			result = result.concat("])");
		} else {
			result = callBack + "([])";
		}
		return result;
	}

	private String resultSignListToJson(List<SignItem> resultList, String callBack) {
		String result = null;
		if (resultList != null && resultList.size() > 0) {
			result = callBack + "([";
			for (SignItem sign : resultList) {
				result = result.concat("{\"id\":\"" + sign.getSignId().getUpperIdPart() + "\",\"word\":\""
						+ sign.getSignId().getLowerIdPart() + "\",\"width\":\"" + sign.getSignWidth() + "\"},");
			}
			result = result.substring(0, result.length() - 1);
			result = result.concat("])");
		} else {
			result = callBack + "([])";
		}
		return result;
	}
}