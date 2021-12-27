package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum HeadPostureBaseSymbol implements SymbolEnum {
	// all symbols with head circle
	STANDARD(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.WEST, SymbolRotation.SOUTH,
					SymbolRotation.EAST })), // Renamed
	HEAD_RIMS(new Symbol(4, 1, 2, 1, 1, 1, 36, 35), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HEAD_MOVEMENT_STRAIGHT_WALL_PLANE(new Symbol(4, 1, 3, 1, 1, 1, 36, 46),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HEAD_MOVEMENT_TILTS_WALL_PLANE(new Symbol(4, 1, 4, 1, 1, 1, 36, 45), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST })), //
	HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE(new Symbol(4, 1, 5, 1, 1, 1, 36, 46),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	HEAD_MOVEMENT_CURVES_WALL_PLANE(new Symbol(4, 1, 6, 1, 1, 1, 36, 44), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	HEAD_MOVEMENT_CURVES_FLOOR_PLANE(new Symbol(4, 1, 7, 1, 1, 1, 36, 42), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.WEST, SymbolRotation.SOUTH,
					SymbolRotation.EAST })), //
	HEAD_MOVEMENT_CIRCLES(new Symbol(4, 1, 8, 1, 1, 1, 36, 38), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	FACE_DIRECTION_POSITIONS_NOSE_FORWARD_TILTING(new Symbol(4, 1, 9, 1, 1, 1, 36, 35),
			Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST })), //
	FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN(new Symbol(4, 1, 10, 1, 1, 1, 36, 44), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING(new Symbol(4, 1, 10, 2, 1, 1, 36, 43),
			Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF(new Symbol(4, 5, 2, 1, 1, 1, 39, 35), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //

	NONE(Symbol.HEAD_POSTURE_PLACEHOLDER_SYMBOL, Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })),

	NONE_SPACE_WIDTH(Symbol.HEAD_WHITESPACE_SYMBOL, Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH }));

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();

	private HeadPostureBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public Set<Symbol> getAllVariationsForBaseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyHeadPostureSymbol(symbol) : "Precondition failed: isAnyHeadPostureSymbol(symbol)";

		return allVariations.get(symbol.getBaseSymbol());
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

	public static HeadPostureBaseSymbol getHeadPostureBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		HeadPostureBaseSymbol result = null;
		for (HeadPostureBaseSymbol headPostureSymbol : HeadPostureBaseSymbol.values()) {
			if (headPostureSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& headPostureSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& headPostureSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& headPostureSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = headPostureSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidHeadPostureSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_POSTURE_PLACEHOLDER_SYMBOL.equals(symbol)
				|| Symbol.HEAD_WHITESPACE_SYMBOL.equals(symbol);
		List<HeadPostureBaseSymbol> asList = Arrays.asList(HeadPostureBaseSymbol.values());
		if (result == false) {
			for (HeadPostureBaseSymbol headPostureBaseSymbol : asList) {
				if (headPostureBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& headPostureBaseSymbol.getValidFills().contains(symbol.getFill())
						&& headPostureBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyHeadPostureSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_POSTURE_PLACEHOLDER_SYMBOL.equals(symbol)
				|| Symbol.HEAD_WHITESPACE_SYMBOL.equals(symbol);
		List<HeadPostureBaseSymbol> asList = Arrays.asList(HeadPostureBaseSymbol.values());
		if (result == false) {
			for (HeadPostureBaseSymbol headPostureBaseSymbol : asList) {
				if (headPostureBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVariations() {
		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 9, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 2, 2, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 2, 1, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 3, 1, 42, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 4, 1, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 4, 2, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 5, 2, 18, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 6, 1, 19, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 6, 2, 19, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 3, 2, 42, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 9, 1, 5, 1, 18, 8));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 10, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 7, 42, 19));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 6, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 9, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 8, 42, 12));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 11, 42, 19));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 10, 42, 12));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 13, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 12, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 1, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 3, 42, 19));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 2, 42, 12));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 5, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 4, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 16, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 15, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 13, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 14, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 15, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 16, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 10, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 12, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 9, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 11, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 8, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 10, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 7, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 9, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 14, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 8, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 13, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 7, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 12, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 6, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 11, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 5, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 2, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 4, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 1, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 3, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 2, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 1, 1, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 6, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 5, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 4, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 3, 3, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 16, 42, 12));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 14, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 1, 2, 15, 42, 19));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 10, 2);
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 2, 45, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 1, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 4, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 3, 45, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 10, 45, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 9, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 12, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 11, 45, 18));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 6, 45, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 5, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 8, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 7, 47, 15));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 14, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 16, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 15, 21, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 16, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 12, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 13, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 14, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 15, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 5, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 4, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 3, 19, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 2, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 1, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 13, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 12, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 11, 19, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 10, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 9, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 8, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 7, 21, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 3, 6, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 4, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 5, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 6, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 7, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 8, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 15, 47, 15));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 9, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 16, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 13, 42, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 10, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 2, 14, 45, 11));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 11, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 1, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 2, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 10, 2, 1, 3, 36, 44));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 4, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 5, 1, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 5, 2, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 4, 1, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 1, 2, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 1, 1, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 2, 1, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 2, 2, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 3, 1, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 3, 2, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 4, 2, 36, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 6, 1, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 4, 1, 6, 2, 9, 9));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 6, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 1, 2, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 1, 1, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 1, 4, 36, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 1, 3, 36, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 2, 4, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 2, 3, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 2, 2, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 6, 1, 2, 1, 20, 8));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 5, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 4, 43, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 5, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 8, 46, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 2, 44, 41));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 6, 45, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 8, 44, 41));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 4, 45, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 6, 43, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 5, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 7, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 2, 46, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 6, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 4, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 5, 1, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 3, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 2, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 3, 1, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 1, 8, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 4, 47, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 6, 47, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 5, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 6, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 8, 46, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 7, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 8, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 6, 41, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 2, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 3, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 8, 44, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 6, 4, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 2, 44, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 4, 41, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 2, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 5, 1, 4, 2, 46, 46));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 8, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 2, 3, 22, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 1, 3, 36, 38));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 2, 2, 22, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 1, 4, 36, 38));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 2, 1, 22, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 1, 1, 36, 38));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 2, 4, 22, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 8, 1, 1, 2, 36, 38));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 3, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 2, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 3, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 2, 44, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 4, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 4, 44, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 6, 44, 43));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 8, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 8, 46, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 6, 46, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 5, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 4, 46, 44));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 2, 46, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 5, 1, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 4, 48, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 6, 40, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 3, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 2, 46, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 4, 40, 45));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 7, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 8, 46, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 2, 2, 36, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 5, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 4, 6, 48, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 8, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 7, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 3, 8, 44, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 4, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 3, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 8, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 6, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 7, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 5, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 1, 6, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 2, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 1, 3, 1, 6, 1, 10, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 7, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 2, 3, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 1, 4, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 2, 4, 14, 10));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 1, 2, 36, 47));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 1, 3, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 1, 1, 36, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 2, 1, 18, 6));
		variationsForBaseSymbol.add(new Symbol(4, 1, 7, 1, 2, 2, 14, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 1, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 3, 4, 42, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 4, 3, 37, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 4, 4, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 3, 2, 42, 42));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 3, 3, 35, 48));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 3, 1, 48, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 4, 1, 37, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 4, 2, 42, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 2, 4, 36, 29));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 2, 3, 44, 29));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 1, 3, 44, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 2, 2, 36, 29));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 1, 1, 2, 1, 36, 29));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 1, 2, 1);
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 1, 2, 1, 1, 7, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		baseSymbol = new BaseSymbol(4, 5, 2, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 1, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 3, 35, 39));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 6, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 5, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 8, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 1, 7, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 7, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 8, 7, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 3, 15, 12));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 4, 12, 12));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 5, 12, 15));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 6, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 1, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 3, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 2, 4, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 1, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 5, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 3, 35, 39));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 8, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 7, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 2, 6, 39, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 8, 4, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 6, 4, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 7, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 4, 4, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 4, 5, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 1, 12, 15));
		variationsForBaseSymbol.add(new Symbol(4, 5, 2, 1, 3, 2, 12, 12));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidHeadPostureSymbol(symbol) : "Precondition failed: isValidHeadPostureSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

}
