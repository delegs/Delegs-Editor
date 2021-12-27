package de.signWritingEditor.server.service;

import java.util.ArrayList;
import java.util.List;

public class SignPuddleEntryFilter {
	enum Filters {
		SIGNS_WITH_DELEGS_ORIGIN, SIGNS_LBG, SIGNS_PMS, SIGNS_NON_DGS, SIGNS_ONLY_MB, SIGNS_DRAWINGS, SIGNS_PLURAL, SIGNS_CLASSIFYING_OBJECTS
	}

	private static final String SIGNS_WITH_DELEGS_ORIGIN_FILTER_STRING = "vgl. delegs";
	private static final String SIGNS_LBG_FILTER_STRING = "LBG";
	private static final String SIGNS_PMS_FILTER_STRING = "PMS";
	private static final String SIGNS_NON_DGS_FILTER_STRING = "non DGS";
	private static final String SIGNS_ONLY_MB_FILTER_STRING = "nur MB";
	private static final String SIGNS_DRAWINGS_FILTER_STRING = "Malerei";
	private static final String SIGNS_PLURAL_FILTER_STRING = "Plural";
	private static final String SIGNS_CLASSIFYING_OBJECTS_FILTER_STRING = "Klassifikator";

	public static List<DictionaryEntry> filter(List<DictionaryEntry> allEntries, Filters filter, boolean filterOut) {

		List<DictionaryEntry> result = new ArrayList<DictionaryEntry>();

		switch (filter) {
		case SIGNS_WITH_DELEGS_ORIGIN:
			result.addAll(filterSigns(allEntries, SIGNS_WITH_DELEGS_ORIGIN_FILTER_STRING, filterOut));
			break;
		case SIGNS_LBG:
			result.addAll(filterSigns(allEntries, SIGNS_LBG_FILTER_STRING, filterOut));
			break;
		case SIGNS_PMS:
			result.addAll(filterSigns(allEntries, SIGNS_PMS_FILTER_STRING, filterOut));
			break;
		case SIGNS_NON_DGS:
			result.addAll(filterSigns(allEntries, SIGNS_NON_DGS_FILTER_STRING, filterOut));
			break;
		case SIGNS_ONLY_MB:
			result.addAll(filterSigns(allEntries, SIGNS_ONLY_MB_FILTER_STRING, filterOut));
			break;
		case SIGNS_DRAWINGS:
			result.addAll(filterSigns(allEntries, SIGNS_DRAWINGS_FILTER_STRING, filterOut));
			break;
		case SIGNS_PLURAL:
			result.addAll(filterSigns(allEntries, SIGNS_PLURAL_FILTER_STRING, filterOut));
			break;
		case SIGNS_CLASSIFYING_OBJECTS:
			result.addAll(filterSigns(allEntries, SIGNS_CLASSIFYING_OBJECTS_FILTER_STRING, filterOut));
			break;
		default:
			result.addAll(allEntries);
		}

		return result;

	}

	private static List<DictionaryEntry> filterSigns(List<DictionaryEntry> allEntriesFromSignPuddle,
			String filterString, boolean filterOut) {

		List<DictionaryEntry> result = new ArrayList<DictionaryEntry>();
		if (filterOut) {
			for (DictionaryEntry dictionaryEntry : allEntriesFromSignPuddle) {
				if (!dictionaryEntry.getSign().getComment().contains(filterString)) {
					result.add(dictionaryEntry);
				}
			}
		} else {
			for (DictionaryEntry dictionaryEntry : allEntriesFromSignPuddle) {
				if (dictionaryEntry.getSign().getComment().contains(SIGNS_WITH_DELEGS_ORIGIN_FILTER_STRING)) {
					result.add(dictionaryEntry);
				}
			}
		}
		return result;
	}

}
