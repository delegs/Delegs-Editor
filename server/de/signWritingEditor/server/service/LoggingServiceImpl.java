package de.signWritingEditor.server.service;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.LoggingService;

public class LoggingServiceImpl implements LoggingService {

	private static final Logger MISSING_CHAR_LOGGER = Logger.getLogger("missingChar");
	private Set<Entry<String, Character>> missingCharacterSet;

	public LoggingServiceImpl() {
		missingCharacterSet = new HashSet<Entry<String, Character>>();
	}

	@Override
	public void logMissingCharacter(char c, String documentName) {
		Entry<String, Character> charInDocument = new AbstractMap.SimpleEntry<String, Character>(documentName, c);
		if (!missingCharacterSet.contains(charInDocument)) {
			missingCharacterSet.add(charInDocument);
			MISSING_CHAR_LOGGER.warn("DOCUMENT: " + documentName + " - MISSING CHARACTER: " + c + "("
					+ Integer.toHexString(c) + " in UTF8 )");
		}
	}
}
