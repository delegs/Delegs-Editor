package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum BreathBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually
	AIR_BLOWING_OUT(new Symbol(4, 3, 5, 1, 4, 1, 48, 22), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	AIR_SUCKING_IN(new Symbol(4, 3, 5, 2, 4, 1, 48, 22), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVatiations();

	private BreathBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static BreathBaseSymbol getBreathBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		BreathBaseSymbol result = null;
		for (BreathBaseSymbol breathBaseSymbol : BreathBaseSymbol.values()) {
			if (breathBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& breathBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& breathBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& breathBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = breathBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<BreathBaseSymbol> asList = Arrays.asList(BreathBaseSymbol.values());
		if (result == false) {
			for (BreathBaseSymbol breathBaseSymbol : asList) {
				if (breathBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& breathBaseSymbol.getValidFills().contains(symbol.getFill())
						&& breathBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = false;
		List<BreathBaseSymbol> asList = Arrays.asList(BreathBaseSymbol.values());
		for (BreathBaseSymbol breathBaseSymbol : asList) {
			if (breathBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int getFillForSymbolWithoutCircle(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(symbol)";

		return symbol.getFill() + 3;

	}

	public static boolean isLeftBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(symbol)";

		return getLeftBreathSymbolFor(symbol).equals(symbol);
	}

	public static boolean isRightBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(symbol)";

		return getRightBreathSymbolFor(symbol).equals(symbol);
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVatiations() {

		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();

		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 5, 2);
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 4, 1, 48, 22));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 3, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 6, 1, 17, 22));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 1, 1, 48, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 2, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 2, 5, 1, 17, 22));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 5, 1);
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 4, 1, 48, 22));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 3, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 1, 1, 48, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 2, 1, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 5, 1, 17, 22));
		variationsForBaseSymbol.add(new Symbol(4, 3, 5, 1, 6, 1, 17, 22));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

	public static Symbol getVariationForBaseSymbolWithFillAndRotation(BaseSymbol baseSymbol, int fill, int rotation) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";
		assert fill > 0 : "Precondition failed: fill > 0";
		assert rotation == 1 : "Precondition failed: rotation == 1";

		Symbol result = null;

		for (Symbol breathSymol : allVariations.get(baseSymbol)) {
			if (breathSymol.getFill() == fill && breathSymol.getRotation() == rotation) {
				result = breathSymol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;

	}

	public static Symbol getLeftBreathSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: newBreathSymbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(newBreathSymbol)";

		Symbol result = symbol;

		if (symbol.getVariation() == 1) {
			result = getVariationForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 6, symbol.getRotation());
		} else if (symbol.getVariation() == 2) {
			result = getVariationForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 6, symbol.getRotation());
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public static Symbol getRightBreathSymbolFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: newBreathSymbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(newBreathSymbol)";

		Symbol result = symbol;

		if (symbol.getVariation() == 1) {
			result = getVariationForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
		} else if (symbol.getVariation() == 2) {
			result = getVariationForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
