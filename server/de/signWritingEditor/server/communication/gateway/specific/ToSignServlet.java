package de.signWritingEditor.server.communication.gateway.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.signWritingEditor.shared.model.material.Sign;
import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.infrastructure.JsonDeserializer;
import de.signWritingEditor.server.communication.infrastructure.JsonSerializer;
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

public class ToSignServlet extends SignWritingServlet {
	private static final long serialVersionUID = -1286626931914268455L;

	private static final Logger LOG = Logger.getLogger(ToSignServlet.class);

	private DictionaryService dictionaryService;
	private JsonSerializer jsonSerializer;
	private JsonDeserializer jsonDeserializer;

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			DbConnector connector = new DbConnector(configurationService);
			UserDb userDB = new UserDb(connector);
			SymbolDB symbolDB = new SymbolDB(connector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
			SignDB signDB = new SignDB(connector, userDB, symbolFactory, configurationService);
			SignHistoryDB signHistoryDb = new SignHistoryDB(connector, userDB, configurationService, symbolFactory);
			dictionaryService = new DictionaryServiceImpl(signDB, signHistoryDb);

			jsonSerializer = new JsonSerializer();
			jsonDeserializer = new JsonDeserializer();

		} catch (IOException e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendResponse(response, "Only for mobile devices. Use Post");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		assert resp != null : "Precondition failed: resp != null";
		assert req != null : "Precondition failed: req != null";

		BufferedReader bReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String input;
		String jsonString = "";
		while ((input = bReader.readLine()) != null) {
			jsonString += input;
		}
		bReader.close();

		List<String> searchWordList = jsonDeserializer.convertTokensToList(jsonString);
		List<SignLocale> signLocales = Collections.nCopies(searchWordList.size(), SignLocale.DGS);
		Map<String, List<SignItem>> signs = dictionaryService.findSigns(searchWordList, signLocales);

		String result = jsonSerializer.serializeMapStringSignItemAsJson(signs);

		sendResponse(resp, result);
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}
}
