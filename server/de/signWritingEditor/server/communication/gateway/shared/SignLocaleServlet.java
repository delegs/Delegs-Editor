package de.signWritingEditor.server.communication.gateway.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.infrastructure.JsonBuilder;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class SignLocaleServlet extends SignWritingServlet {

	private static final Logger LOG = Logger.getLogger(SignLocaleServlet.class);

	private static final long serialVersionUID = -2794803259536851774L;

	private JsonBuilder jsonBuilder;

	@Override
	public void init() throws ServletException {
		jsonBuilder = new JsonBuilder();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String, String>> signLocalesAsPropertyMaps = new ArrayList<Map<String, String>>();
		for (SignLocale locale : SignLocale.values()) {
			signLocalesAsPropertyMaps.add(getSignLocaleAsPropertyMap(locale));
		}

		sendResponse(resp, jsonBuilder.getListAsJson(signLocalesAsPropertyMaps));
	}

	private Map<String, String> getSignLocaleAsPropertyMap(SignLocale signLocale) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("localeId", signLocale.name());
		result.put("description", signLocale.getLongForm());
		return result;
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}

}
