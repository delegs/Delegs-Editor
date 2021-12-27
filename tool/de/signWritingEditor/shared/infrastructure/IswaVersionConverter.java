package de.signWritingEditor.shared.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.signWritingEditor.shared.model.material.SymbolFactory;

public class IswaVersionConverter {

	private static final Logger LOGGER = Logger.getLogger(IswaVersionConverter.class);

	private Map<String, String> iswa2008to2010Map;
	private Map<String, String> iswa2010to2008Map;

	public IswaVersionConverter() {
		iswa2008to2010Map = new HashMap<String, String>();
		iswa2010to2008Map = new HashMap<String, String>();
		fill2008to2010Map();
	}

	public String convertIswa2008To2010(String iswa2008Code) {
		assert iswa2008Code != null : "Precondition failed: iswa2008Code != null";
		assert SymbolFactory.isValidIswaId(
				iswa2008Code) : "Precondition failed: SymbolFactory.isValidIdRepresentation(iswa2008Code)";
		assert isValidIswa2008(iswa2008Code) : "Precondition failed: isValidIswa2008(iswa2008Code)";

		String result = iswa2008to2010Map.get(iswa2008Code);

		assert result != null : "Postcondition failed: result != null";
		assert SymbolFactory
				.isValidIswaId(result) : "Postcondition failed: SymbolFactory.isValidIdRepresentation(result)";
		return result;
	}

	public String convertIswa2010To2008(String iswa2010Code) {
		assert iswa2010Code != null : "Precondition failed: iswa2010Code != null";
		assert SymbolFactory.isValidIswaId(
				iswa2010Code) : "Precondition failed: SymbolFactory.isValidIdRepresentation(iswa2010Code)";

		String result = iswa2010to2008Map.get(iswa2010Code);
		if (result == null) {
			// iswa2008 and iswa2010 are identical
			LOGGER.info("ISWA 2010 symbol without 2008 representation!");
			result = iswa2010Code;
		}

		assert result != null : "Postcondition failed: result != null";
		assert SymbolFactory
				.isValidIswaId(result) : "Postcondition failed: SymbolFactory.isValidIdRepresentation(result)";
		return result;
	}

	public boolean isValidIswa2008(String iswa2008Code) {
		assert iswa2008Code != null : "Precondition failed: iswa2008Code != null";
		assert SymbolFactory.isValidIswaId(
				iswa2008Code) : "Precondition failed: SymbolFactory.isValidIdRepresentation(iswa2008Code)";

		return iswa2008to2010Map.containsKey(iswa2008Code);
	}

	private void fill2008to2010Map() {
		try {
			String conversionString = IOUtils
					.toString(IswaVersionConverter.class.getResourceAsStream("2008to2010.txt"));
			BufferedReader bufReader = new BufferedReader(new StringReader(conversionString));

			boolean finished = false;
			while (!finished) {
				String line = bufReader.readLine();
				if (line == null) {
					finished = true;
				} else {
					String[] split = line.split(" is ");
					if (split.length == 2) {
						iswa2008to2010Map.put(split[0], split[1]);
						iswa2010to2008Map.put(split[1], split[0]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
