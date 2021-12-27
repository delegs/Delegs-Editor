package de.signWritingEditor.shared.model.material;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class SymbolFactory {
	private final Map<String, Symbol> iswaToSymbolsMap;

	/**
	 * Return whether the given string is a valid id representation. A valid
	 * representation matches the pattern "CC-GG-SSS-VV-FF-RR", where each
	 * letter stands for a digit being part of an index.<br>
	 * NOTE: This method does not state whether the corresponding id is actually
	 */
	public static boolean isValidIswaId(String string) {
		assert string != null : "string != null";

		return string.matches("\\d\\d-\\d\\d-\\d\\d\\d-\\d\\d-0[1-6]-(0\\d|1[0-6])");
	}

	public SymbolFactory(Collection<Map<String, String>> allSymbols) {
		assert allSymbols != null : "allSymbols != null";

		this.iswaToSymbolsMap = createAllSymbols(allSymbols);
	}

	public Symbol createSymbol(int category, int group, int symbol, int variation, int fill, int rotation) {
		assert isValidSymbol(category, group, symbol, variation, fill,
				rotation) : "isValidSymbol(category, group, symbol, variation, fill, rotation)";

		String symbolKey = Symbol.getIswaCode(category, group, symbol, variation, fill, rotation);

		Symbol result = iswaToSymbolsMap.get(symbolKey);

		assert result != null : "result != null";
		return result;
	}

	public Symbol createSymbol(String iswaId) {
		assert isValidSymbol(iswaId) : "Precondition failed: isValidSymbol(iswaId) :" + iswaId;

		String[] symbolCodeDigits = iswaId.split("-");
		int[] symbolCodeNumbers = new int[6];

		for (int i = 0; i < symbolCodeDigits.length; i++) {
			symbolCodeNumbers[i] = Integer.valueOf(symbolCodeDigits[i]);
		}

		return createSymbol(symbolCodeNumbers[0], symbolCodeNumbers[1], symbolCodeNumbers[2], symbolCodeNumbers[3],
				symbolCodeNumbers[4], symbolCodeNumbers[5]);
	}

	public Collection<Symbol> getAllSymbols() {
		return Collections.unmodifiableCollection(iswaToSymbolsMap.values());
	}

	public Set<Symbol> getAllRotationsAndFillsFor(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		Set<Symbol> result = new HashSet<Symbol>();

		for (Symbol symbol : getAllSymbols()) {
			if (baseSymbol.equals(symbol.getBaseSymbol())) {
				result.add(symbol);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		assert !result.isEmpty() : "Postcondition failed: !result.isEmpty()";
		return result;
	}

	public boolean isValidSymbol(int category, int group, int symbol, int variation, int fill, int rotation) {
		return iswaToSymbolsMap.containsKey(Symbol.getIswaCode(category, group, symbol, variation, fill, rotation));
	}

	public boolean isValidSymbol(String iswaId) {
		boolean result = iswaId != null && isValidIswaId(iswaId);

		if (result) {
			String[] symbolCodeDigits = iswaId.split("-");

			result = isValidSymbol(symbolCodeDigits[0], symbolCodeDigits[1], symbolCodeDigits[2], symbolCodeDigits[3],
					symbolCodeDigits[4], symbolCodeDigits[5]);
		}

		return result;
	}

	public boolean isValidSymbol(String category, String group, String symbol, String variation, String fill,
			String rotation) {
		// is this a valid combination
		return isValidSymbol(Integer.parseInt(category), Integer.parseInt(group), Integer.parseInt(symbol),
				Integer.parseInt(variation), Integer.parseInt(fill), Integer.parseInt(rotation));
	}

	private Map<String, Symbol> createAllSymbols(Collection<Map<String, String>> allSymbols) {
		assert allSymbols != null : "Precondition failed: allSymbols != null";

		Map<String, Symbol> result = new HashMap<String, Symbol>(allSymbols.size());

		for (Map<String, String> symbolMap : allSymbols) {
			Symbol symbol = new Symbol(Integer.parseInt(symbolMap.get("CATEGORY")),
					Integer.parseInt(symbolMap.get("SGROUP")), Integer.parseInt(symbolMap.get("SYMBOL")),
					Integer.parseInt(symbolMap.get("VARIATION")), Integer.parseInt(symbolMap.get("FILL")),
					Integer.parseInt(symbolMap.get("ROTATION")), Integer.parseInt(symbolMap.get("width")),
					Integer.parseInt(symbolMap.get("height")));
			result.put(symbol.getIswaId(), symbol);
		}

		return result;
	}
}
