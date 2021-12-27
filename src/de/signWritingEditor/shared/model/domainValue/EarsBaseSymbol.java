package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum EarsBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually

	EARS(new Symbol(4, 3, 3, 1, 1, 1, 48, 35), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();

	private EarsBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public List<SymbolRotation> getValidRotations() {
		return validRotations;
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVariations() {
		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 3, 1);
		variationsForBaseSymbol.add(new Symbol(4, 3, 3, 1, 1, 1, 48, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 3, 1, 2, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 3, 1, 3, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 3, 1, 4, 1, 10, 14));
		variationsForBaseSymbol.add(new Symbol(4, 3, 3, 1, 5, 1, 10, 14));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

	public static Symbol getLeftEarFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		Symbol result = null;

		if (symbol.getBaseSymbol().equals(EarsBaseSymbol.EARS.getIswaSymbol().getBaseSymbol()) && symbol.getFill() == 1
				|| symbol.getFill() == 3 || symbol.getFill() == 5) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
		} else {
			result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		}

		assert result != null : "Postcondition failed: result != null";

		return result;

	}

	public static Symbol getRightEarFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		Symbol result = null;

		if (symbol.getBaseSymbol().equals(EarsBaseSymbol.EARS.getIswaSymbol().getBaseSymbol())
				&& (symbol.getFill() == 1 || symbol.getFill() == 2 || symbol.getFill() == 4)) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 4, symbol.getRotation());
		} else {
			result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		}

		assert result != null : "Postcondition failed: result != null";

		return result;

	}

	private static Symbol getSymbolForBaseSymbolWithFillAndRotation(BaseSymbol baseSymbol, int fill, int rotation) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		Symbol result = null;

		for (Symbol symbol : allVariations.get(baseSymbol)) {
			if (symbol.getBaseSymbol().equals(baseSymbol) && symbol.getFill() == fill
					&& symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		return result;
	}

	public List<Integer> getValidRotationValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (SymbolRotation rotation : validRotations) {
			result.add(rotation.getRotationValue());
		}
		return result;
	}

	@Override
	public List<Integer> getValidFills() {
		return validFills;
	}

	@Override
	public boolean canBeMirrored() {
		return false;
	}

	public static EarsBaseSymbol getEarsBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		EarsBaseSymbol result = null;
		for (EarsBaseSymbol earsBaseSymbol : EarsBaseSymbol.values()) {
			if (earsBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& earsBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& earsBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& earsBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = earsBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<EarsBaseSymbol> asList = Arrays.asList(EarsBaseSymbol.values());
		if (result == false) {
			for (EarsBaseSymbol earsBaseSymbol : asList) {
				if (earsBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& earsBaseSymbol.getValidFills().contains(symbol.getFill())
						&& earsBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<EarsBaseSymbol> asList = Arrays.asList(EarsBaseSymbol.values());
		if (result == false) {
			for (EarsBaseSymbol earsBaseSymbol : asList) {
				if (earsBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isLeftEarSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidEarsSymbol(symbol) : "Precondition failed: isValidEarsSymbol(symbol)";

		boolean result = false;
		if (symbol.getFill() == 5) {
			result = true;
		}
		return result;
	}

	public static boolean isRightEarSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidEarsSymbol(symbol) : "Precondition failed: isValidEarsSymbol(symbol)";

		boolean result = false;
		if (symbol.getFill() == 4) {
			result = true;
		}
		return result;
	}
}
