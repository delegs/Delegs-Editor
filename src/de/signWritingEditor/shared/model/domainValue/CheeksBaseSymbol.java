package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum CheeksBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually

	CHEEKS_PUFFED(new Symbol(4, 3, 1, 1, 4, 1, 9, 15), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	CHEEKS_NEUTRAL(new Symbol(4, 3, 1, 2, 4, 1, 9, 16), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	CHEEKS_SUCKED(new Symbol(4, 3, 1, 3, 4, 1, 12, 10), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TENSE_CHEEKS_HIGH(new Symbol(4, 3, 2, 1, 4, 1, 11, 5), Arrays.asList(new Integer[] { 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TENSE_CHEEKS_MIDDLE(new Symbol(4, 3, 2, 2, 4, 1, 11, 5), Arrays.asList(new Integer[] { 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TENSE_CHEEKS_LOW(new Symbol(4, 3, 2, 3, 4, 1, 11, 5), Arrays.asList(new Integer[] { 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	// last 4 (AIR_BLOW_SMALL_ROTATIONS, AIR_SUCK_SMALL_ROTATIONS,
	// BREATH_EXHALE, BREATH_INHALE) should be in an extra category as they are
	// not attached to a
	// head
	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static final List<CheeksBaseSymbol> cheekBaseSymbolList = Arrays.asList(CheeksBaseSymbol.values());
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();
	private static Map<BaseSymbol, Map<Integer, Integer>> circleSymbolToFillMap = createCircleSymbolToFillMap();

	private CheeksBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	@Override
	public List<Integer> getValidFills() {
		return validFills;
	}

	@Override
	public List<Integer> getValidRotationValues() {
		List<Integer> result = new ArrayList<Integer>();

		for (SymbolRotation rotation : validRotations) {
			result.add(rotation.getRotationValue());
		}
		return result;
	}

	@Override
	public List<SymbolRotation> getValidRotations() {
		return validRotations;
	}

	@Override
	public boolean canBeMirrored() {
		return false;
	}

	public static CheeksBaseSymbol getCheeksBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		CheeksBaseSymbol result = null;
		for (CheeksBaseSymbol cheeksBaseSymbol : CheeksBaseSymbol.values()) {
			if (cheeksBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& cheeksBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& cheeksBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& cheeksBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = cheeksBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);

		if (result == false) {
			for (CheeksBaseSymbol cheeksBaseSymbol : cheekBaseSymbolList) {
				if (cheeksBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& cheeksBaseSymbol.getValidFills().contains(symbol.getFill())
						&& cheeksBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static Symbol getRightCheekFor(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		Symbol result = null;

		if (CHEEKS_PUFFED.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 1, 5, 1, 9, 15);
		} else if (CHEEKS_NEUTRAL.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 2, 5, 1, 9, 16);
		} else if (CHEEKS_SUCKED.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 3, 5, 1, 12, 10);
		} else if (TENSE_CHEEKS_HIGH.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 1, 4, 1, 11, 5);
		} else if (TENSE_CHEEKS_MIDDLE.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 2, 4, 1, 11, 5);
		} else if (TENSE_CHEEKS_LOW.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 3, 4, 1, 11, 5);
		} else if (NONE.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		}

		return result;

	}

	public static Symbol getLeftCheekFor(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		Symbol result = null;

		if (CHEEKS_PUFFED.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 1, 4, 1, 9, 15);
		} else if (CHEEKS_NEUTRAL.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 2, 4, 1, 9, 16);
		} else if (CHEEKS_SUCKED.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 1, 3, 4, 1, 12, 10);
		} else if (TENSE_CHEEKS_HIGH.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 1, 4, 1, 11, 5);
		} else if (TENSE_CHEEKS_MIDDLE.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 2, 4, 1, 11, 5);
		} else if (TENSE_CHEEKS_LOW.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = new Symbol(4, 3, 2, 3, 4, 1, 11, 5);
		} else if (NONE.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
			result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		}

		return result;
	}

	public static int getFillForSymbolWithoutCircle(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyCheeksSymbol(symbol) : "Precondition failed: isAnyCheeksSymbol(symbol)";

		int result = symbol.getFill();

		if (!isValidCheeksSymbol(symbol)) {
			Map<Integer, Integer> map = circleSymbolToFillMap.get(symbol.getBaseSymbol());
			if (map != null) {
				result = map.get(symbol.getFill());
			}
		}

		return result;
	}

	public static boolean isLeftCheek(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidCheeksSymbol(symbol) : "Precondition failed: isValidCheeksSymbol(symbol)";

		return symbol.equals(getLeftCheekFor(symbol.getBaseSymbol()));
	}

	public static boolean isRightCheek(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidCheeksSymbol(symbol) : "Precondition failed: isValidCheeksSymbol(symbol)";

		return symbol.equals(getRightCheekFor(symbol.getBaseSymbol()));
	}

	public static boolean isAnyCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<CheeksBaseSymbol> asList = Arrays.asList(CheeksBaseSymbol.values());
		if (result == false) {
			for (CheeksBaseSymbol cheeksBaseSymbol : asList) {
				if (cheeksBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private static Map<BaseSymbol, Map<Integer, Integer>> createCircleSymbolToFillMap() {

		Map<BaseSymbol, Map<Integer, Integer>> result = new HashMap<BaseSymbol, Map<Integer, Integer>>();

		HashMap<Integer, Integer> hashMapPlusTwo = new HashMap<Integer, Integer>();
		hashMapPlusTwo.put(1, 4); // Special case
		hashMapPlusTwo.put(2, 4);
		hashMapPlusTwo.put(3, 5);

		HashMap<Integer, Integer> hashMapFromTwoToOne = new HashMap<Integer, Integer>();
		hashMapFromTwoToOne.put(1, 4); // Special case
		hashMapFromTwoToOne.put(2, 4);
		hashMapFromTwoToOne.put(3, 4);

		result.put(new BaseSymbol(4, 3, 1, 1), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 3, 1, 2), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 3, 1, 3), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 3, 2, 1), hashMapFromTwoToOne);
		result.put(new BaseSymbol(4, 3, 2, 2), hashMapFromTwoToOne);
		result.put(new BaseSymbol(4, 3, 2, 3), hashMapFromTwoToOne);

		return result;
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyCheeksSymbol(symbol) : "Precondition failed: isAnyMouthSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

	public static Map<BaseSymbol, Set<Symbol>> createAllVariations() {

		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 2, 2);
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 2, 4, 1, 11, 5));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 2, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 2, 3);
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 3, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 3, 4, 1, 11, 5));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 2, 1);
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 1, 4, 1, 11, 5));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 2, 1, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 1, 3);
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 3, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 3, 4, 1, 12, 10));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 3, 5, 1, 12, 10));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 3, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 1, 2);
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 2, 5, 1, 9, 16));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 2, 4, 1, 9, 16));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 2, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 3, 1, 1);
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 1, 4, 1, 9, 15));
		variationsForBaseSymbol.add(new Symbol(4, 3, 1, 1, 5, 1, 9, 15));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}
}
