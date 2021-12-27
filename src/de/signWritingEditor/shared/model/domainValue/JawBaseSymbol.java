package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum JawBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually
	JAW_MOVEMENT_WALL_PLANE(new Symbol(4, 5, 9, 1, 2, 1, 8, 9), Arrays.asList(new Integer[] { 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), // used in combination with
													// HEAD_RIM
													// south and needs left and
													// right
	JAW_MOVEMENT_FLOOR_PLANE(new Symbol(4, 5, 10, 1, 2, 1, 7, 9), Arrays.asList(new Integer[] { 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), // used in combination with
													// HEAD_RIM
													// south and needs left and
													// right
	JAW_PART_HEAD_RIM(new Symbol(4, 99, 999, 96, 1, 1, 14, 4), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH }));
	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVatiations();

	private JawBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static JawBaseSymbol getJawBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		JawBaseSymbol result = null;
		for (JawBaseSymbol jawBaseSymbol : JawBaseSymbol.values()) {
			if (jawBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& jawBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& jawBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& jawBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = jawBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<JawBaseSymbol> asList = Arrays.asList(JawBaseSymbol.values());
		if (result == false) {
			for (JawBaseSymbol jawBaseSymbol : asList) {
				if (jawBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& jawBaseSymbol.getValidFills().contains(symbol.getFill())
						&& jawBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<JawBaseSymbol> asList = Arrays.asList(JawBaseSymbol.values());
		if (result == false) {
			for (JawBaseSymbol jawBaseSymbol : asList) {
				if (jawBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						|| symbol.equals(Symbol.JAW_PART_HEAD_RIM)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static int getFillForSymbolWithoutCircle(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyJawSymbol(symbol) : "Precondition failed: isAnyJawSymbol(symbol)";

		return symbol.getFill() + 1;

	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyJawSymbol(symbol) : "Precondition failed: isAnyJawSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVatiations() {
		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();

		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 9, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 1, 8, 9));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 2, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 3, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 4, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 5, 8, 9));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 6, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 7, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 2, 8, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 2, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 4, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 6, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 9, 1, 3, 8, 6, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 10, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 1, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 2, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 3, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 4, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 5, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 6, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 7, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 2, 8, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 2, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 4, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 6, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 10, 1, 3, 8, 5, 5));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 99, 999, 96);
		variationsForBaseSymbol.add(new Symbol(4, 99, 999, 96, 1, 1, 14, 4));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

}
