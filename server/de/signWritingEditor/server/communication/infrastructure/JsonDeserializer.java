package de.signWritingEditor.server.communication.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {

	private static final String SEARCH_TOKEN_KEY = "searchTokens";

	public JsonDeserializer() {

	}

	public List<String> convertTokensToList(String jsonString) {
		assert jsonString != null : "Precondition failed: jsonString != null";

		List<String> result = new ArrayList<>();

		String[] splitTokens = removeFirstAndLastChar(jsonString).split(":");

		if (splitTokens.length > 1) {

			if (removeFirstAndLastChar(splitTokens[0]).equals(SEARCH_TOKEN_KEY)) {

				String[] tokens = removeFirstAndLastChar(splitTokens[1]).split(",");

				for (int index = 0; index < tokens.length; index++) {
					result.add(removeFirstAndLastChar(tokens[index]));
				}
			}
		}
		return result;
	}

	private String removeFirstAndLastChar(String jsonString) {
		assert jsonString != null : "Precondition failed: jsonString != null";
		assert jsonString.length() > 2 : "Precondition failed: jsonString.length()>2";

		return jsonString.substring(1, jsonString.length() - 1);

	}
}
