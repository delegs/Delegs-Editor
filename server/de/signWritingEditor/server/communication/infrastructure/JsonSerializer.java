package de.signWritingEditor.server.communication.infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Pair;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.DictionaryStructure;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;
import de.signWritingEditor.shared.model.material.WordToSignsDictionaryEntry;

public class JsonSerializer {

	private final JsonBuilder jsonBuilder;
	private static final String WIDTH_KEY = "width";
	private static final String ID_KEY = "id";
	private static final String LOWER_ID_KEY = "lowerId";
	private static final String UPPER_ID_KEY = "upperId";
	private static final String SOURCE_ID_KEY = "source";
	private static final String LANGUAGE_KEY = "language";
	private static final String REVISION_KEY = "revision";

	public JsonSerializer() {
		jsonBuilder = new JsonBuilder();
	}

	public String serializeMapStringSignItemAsJson(Map<String, List<SignItem>> mapOfSignItemLists) {
		assert mapOfSignItemLists != null : "Precondition failed: mapOfSignItemLists != null";

		Map<String, Object> result = new HashMap<String, Object>();

		for (String key : mapOfSignItemLists.keySet()) {
			result.put(key, getListofSignItemsAsMap(mapOfSignItemLists.get(key)));
		}
		return jsonBuilder.getMapAsJson(result);
	}

	public String serializeSignAsJson(SimpleSign sign) {
		String result = null;
		if (sign != null) {

			Map<String, Object> resultMap = new HashMap<String, Object>(4);

			resultMap.put("upperId", sign.getSignId().getUpperIdPart());
			resultMap.put("lowerId", sign.getSignId().getLowerIdPart());
			resultMap.put("signLocaleShortForm", sign.getSignLocale().name());
			resultMap.put("signLocaleLongForm", sign.getSignLocale().getLongForm());
			resultMap.put("source", sign.getSignId().getSignSource().name());
			resultMap.put("width", sign.getWidth());
			resultMap.put("symbols", getPositionedSymbolsAsPropertyMaps(sign.getPlainSymbols()));
			resultMap.put("mdt", String.valueOf(sign.getModificationDate().getTime()));
			resultMap.put("comment", sign.getComment());

			result = jsonBuilder.getMapAsJson(resultMap);
		}
		return result;
	}

	public String serializeUserSessionAsJson(UserSession userSession) {
		String result = null;
		if (userSession != null) {

			Map<String, Object> resultMap = new HashMap<String, Object>(4);

			User user = userSession.getUser();
			userSession.getSessionKey().getValue();
			resultMap.put("username", user.getUsername());
			resultMap.put("firstName", user.getFirstName());
			resultMap.put("lastName", user.getLastName());
			resultMap.put("isAdmin", String.valueOf(user.isAdmin()));
			resultMap.put("sessionKey", String.valueOf(userSession.getSessionKey().getValue()));
			resultMap.put("expiryTime", String.valueOf(userSession.getExpiryTime().getMillisecondsSinceUnixEpoch()));

			result = jsonBuilder.getMapAsJson(resultMap);
		}
		return result;
	}

	public String getRevisionedDictionaryEntriesAsJson(
			RevisionedWordToSignsDictionaryEntries revisionedDictionaryEntries) {
		assert revisionedDictionaryEntries != null : "Precondition failed: revisionedDictionaryEntries != null";


		Map<String, Object> result = new HashMap<>();
		result.put("revision", revisionedDictionaryEntries.getRevision());

		List<Map<String, Object>> entries = new ArrayList<>();
		final List<WordToSignsDictionaryEntry> dictionaryEntries = revisionedDictionaryEntries.getDictionaryEntries();
		for(WordToSignsDictionaryEntry entry : dictionaryEntries) {
			final String word = entry.getWord();
			final List<Long> upperIds = entry.getSignIds().stream()
					.map(SignId::getUpperIdPart)
					.collect(Collectors.toList());

			Map<String, Object> entryMap = new HashMap<>();
			entryMap.put("word", word);
			entryMap.put("upperIds", upperIds);
			entries.add(entryMap);
		}
		result.put("entries", entries);

		return jsonBuilder.getMapAsJson(result);
	}

	public String serializeDictionaryEntryListAsJson(List<WordToSignsDictionaryEntry> dictionaryEntries) {
		assert dictionaryEntries != null : "Precondition failed: signItemList != null";

		List<List<?>> dictionaryEntriesProperties = new ArrayList<List<?>>(dictionaryEntries.size());

		if (dictionaryEntries != null && dictionaryEntries.size() > 0) {
			for (WordToSignsDictionaryEntry dictionaryEntry : dictionaryEntries) {
				List<Object> dictionaryEntryProperties = new ArrayList<Object>();
				dictionaryEntryProperties.add(dictionaryEntry.getWord());

				for (SignId signId : dictionaryEntry.getSignIds()) {
					Map<String, String> signIdProperties = new HashMap<String, String>();
					signIdProperties.put("upperId", String.valueOf(signId.getUpperIdPart()));
					signIdProperties.put("lowerId", signId.getLowerIdPart());
					signIdProperties.put("source", signId.getSignSource().name());
					dictionaryEntryProperties.add(signIdProperties);
				}

				dictionaryEntriesProperties.add(dictionaryEntryProperties);
			}
		}
		return jsonBuilder.getListAsJson(dictionaryEntriesProperties);
	}

	public String serializeDictionaryStructureAsJson(DictionaryStructure dictionaryStructure) {
		assert dictionaryStructure != null : "Precondition failed: dictionaryStructure != null";

		Map<String, Object> dictionaryStructureMap = new HashMap<String, Object>(2);
		dictionaryStructureMap.put("revision", dictionaryStructure.getRevision());
		dictionaryStructureMap.put("dictionaryIndexToSignCount", dictionaryStructure.getDictionaryIndexToSignCount());
		return jsonBuilder.getMapAsJson(dictionaryStructureMap);
	}

	public String serializeSignLocalesAsJson(SignLocale[] signLocales) {
		assert signLocales != null : "Precondition failed: signLocales != null";

		List<Map<String, String>> signLocalesPropertyList = new ArrayList<Map<String, String>>();

		for (SignLocale signLocale : signLocales) {
			signLocalesPropertyList.add(getSignLocaleAsPropertyMap(signLocale));
		}

		return jsonBuilder.getListAsJson(signLocalesPropertyList);
	}

	public String searializeLocalizedAppDescriptionsAsJson(Map<String, String> appDescriptions) {
		assert appDescriptions != null : "Precondition failed: appDescriptions != null";

		return jsonBuilder.getMapAsJson(appDescriptions);
	}

	public String serializeDbRevisionAsJson(int dbRevision) {
		assert dbRevision > -1 : "Precondition failed: dbRevision > -1";

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("dbRevision", Integer.toString(dbRevision));

		return jsonBuilder.getMapAsJson(map);
	}

	private List<Map<String, Object>> getListofSignItemsAsMap(List<SignItem> signItemList) {
		assert signItemList != null : "Precondition failed: signItemList != null";

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		for (SignItem signItem : signItemList) {
			result.add(getSignItemAsMap(signItem));
		}
		return result;
	}

	private List<Map<String, String>> getPositionedSymbolsAsPropertyMaps(List<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols != null : "Precondition failed: positionedSymbols != null";

		List<Map<String, String>> posSymbolsAsPropertyMaps = new ArrayList<Map<String, String>>(
				positionedSymbols.size());

		for (PositionedSymbol posSymbol : positionedSymbols) {
			Map<String, String> symbolPropertiesMap = new HashMap<String, String>();
			symbolPropertiesMap.put("iswaId", posSymbol.getSymbol().getIswaId());
			symbolPropertiesMap.put("x", String.valueOf(posSymbol.getX()));
			symbolPropertiesMap.put("y", String.valueOf(posSymbol.getY()));
			symbolPropertiesMap.put("z", String.valueOf(posSymbol.getZ()));
			symbolPropertiesMap.put("width", String.valueOf(posSymbol.getSymbol().getWidth()));
			symbolPropertiesMap.put("height", String.valueOf(posSymbol.getSymbol().getHeight()));

			posSymbolsAsPropertyMaps.add(symbolPropertiesMap);
		}

		return posSymbolsAsPropertyMaps;
	}

	private Map<String, String> getSignLocaleAsPropertyMap(SignLocale signLocale) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("localeId", signLocale.name());
		result.put("description", signLocale.getLongForm());

		return result;
	}

	private Map<String, Object> getSignItemAsMap(SignItem signItem) {
		assert signItem != null : "Precondition failed: signItem != null";

		Map<String, Object> result = new HashMap<String, Object>();
		result.put(ID_KEY, serializeSignId(signItem.getSignId()));
		result.put(WIDTH_KEY, signItem.getSignWidth());
		result.put(REVISION_KEY, signItem.getRevision());

		return result;
	}

	private Map<String, Object> serializeSignId(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";

		Map<String, Object> result = new HashMap<String, Object>();
		result.put(UPPER_ID_KEY, String.valueOf(signId.getUpperIdPart()));
		result.put(LOWER_ID_KEY, signId.getLowerIdPart());
		result.put(LANGUAGE_KEY, signId.getSignLocale().name());
		result.put(SOURCE_ID_KEY, signId.getSignSource().name());

		return result;
	}
}
