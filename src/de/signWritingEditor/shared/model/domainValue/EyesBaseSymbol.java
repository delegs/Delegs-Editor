package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum EyesBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually

	EYEBROWS_STRAIGHT_UP(new Symbol(4, 2, 1, 1, 4, 1, 23, 10), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYEBROWS_STRAIGHT_NEUTRAL(new Symbol(4, 2, 1, 2, 4, 1, 22, 6), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYEBROWS_STRAIGHT_DOWN(new Symbol(4, 2, 1, 3, 4, 1, 22, 10), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	DREAMY_EYEBROWS_NEUTRAL_DOWN(new Symbol(4, 2, 2, 1, 4, 1, 26, 9), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	DREAMY_EYEBROWS_DOWN_NEUTRAL(new Symbol(4, 2, 2, 2, 4, 1, 24, 8), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	DREAMY_EYEBROWS_UP_NEUTRAL(new Symbol(4, 2, 2, 3, 4, 1, 24, 8), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	DREAMY_EYEBROWS_NEUTRAL_UP(new Symbol(4, 2, 2, 4, 4, 1, 24, 8), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	FOREHEAD_NEUTRAL(new Symbol(4, 2, 3, 1, 2, 1, 12, 2), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	FOREHEAD_CONTACT(new Symbol(4, 2, 3, 2, 2, 1, 20, 11), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	FOREHEAD_WRINKLED(new Symbol(4, 2, 3, 3, 2, 1, 16, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_OPEN(new Symbol(4, 2, 4, 1, 4, 1, 21, 4), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_SQUEEZED(new Symbol(4, 2, 4, 2, 4, 1, 21, 2), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_CLOSED(new Symbol(4, 2, 4, 3, 4, 1, 21, 4), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYE_BLINK_SINGLE(new Symbol(4, 2, 4, 4, 4, 1, 11, 4), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYE_BLINKS_MULTIPLE(new Symbol(4, 2, 4, 5, 4, 1, 9, 4), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	// 2 symbols EYE_BLINK_SINGLE and EYE_BLINKS_MULTIPLE are a combination of
	// EYES_OPEN and themselves
	EYES_HALF_OPEN(new Symbol(4, 2, 5, 1, 4, 1, 22, 6), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_WIDE_OPEN(new Symbol(4, 2, 5, 2, 4, 1, 22, 8), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_HALF_CLOSED(new Symbol(4, 2, 5, 3, 4, 1, 22, 6), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYES_WIDENING_MOVEMENT(new Symbol(4, 2, 5, 4, 4, 1, 21, 10), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYE_WINK_SQUEEZED_EYE_BLINK(new Symbol(4, 2, 5, 5, 4, 1, 26, 9), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYELASHES_UP(new Symbol(4, 2, 6, 1, 4, 1, 24, 9), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYELASHES_DOWN(new Symbol(4, 2, 6, 2, 4, 1, 24, 9), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYELASHES_FLUTTERING(new Symbol(4, 2, 6, 3, 4, 1, 24, 13), Arrays.asList(new Integer[] { 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	EYEGAZE_STRAIGHT_WALL_PLANE(new Symbol(4, 2, 7, 1, 2, 1, 20, 9), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_STRAIGHT_WALL_DOUBLE(new Symbol(4, 2, 7, 2, 2, 1, 28, 7), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_STRAIGHT_WALL_ALTERNATE(new Symbol(4, 2, 7, 3, 2, 1, 28, 8), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_STRAIGHT_FLOOR_PLANE(new Symbol(4, 2, 8, 1, 2, 1, 18, 9), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_STRAIGHT_FLOOR_DOUBLE(new Symbol(4, 2, 8, 2, 2, 1, 28, 7), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_STRAIGHT_FLOOR_ALTERNATE(new Symbol(4, 2, 8, 3, 2, 1, 22, 9), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_CURVED_WALL_PLANE(new Symbol(4, 2, 9, 1, 2, 1, 25, 6), Arrays.asList(new Integer[] { 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	EYEGAZE_CURVED_FLOOR_PLANE(new Symbol(4, 2, 10, 1, 2, 1, 22, 6), Arrays.asList(new Integer[] { 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EYEGAZE_CIRCLES_WALL_PLANE(new Symbol(4, 2, 11, 1, 2, 1, 25, 10), Arrays.asList(new Integer[] { 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })) //
	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static Map<BaseSymbol, Map<Integer, Integer>> circleSymbolToFillMap = createCircleSymbolToFillMap();
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();

	private EyesBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyEyesSymbol(symbol) : "Precondition failed: isAnyEyesSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
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

	public static EyesBaseSymbol getEyesBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		EyesBaseSymbol result = null;
		for (EyesBaseSymbol eyesBaseSymbol : EyesBaseSymbol.values()) {
			if (eyesBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& eyesBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& eyesBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& eyesBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = eyesBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidEyesSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<EyesBaseSymbol> asList = Arrays.asList(EyesBaseSymbol.values());
		if (result == false) {
			for (EyesBaseSymbol eyesBaseSymbol : asList) {
				if (eyesBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& eyesBaseSymbol.getValidFills().contains(symbol.getFill())
						&& eyesBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyEyesSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = false;
		List<EyesBaseSymbol> asList = Arrays.asList(EyesBaseSymbol.values());
		for (EyesBaseSymbol eyesBaseSymbol : asList) {
			if (eyesBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int getFillForSymbolWithoutCircle(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyEyesSymbol(symbol) : "Precondition failed: isAnyEyesSymbol(symbol)";

		int result = symbol.getFill();

		if (!isValidEyesSymbol(symbol)) {
			Map<Integer, Integer> map = circleSymbolToFillMap.get(symbol.getBaseSymbol());
			if (map != null) {
				result = map.get(symbol.getFill());
			}
		}

		return result;
	}

	public static Symbol getLeftEyeFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		Symbol result = null;

		if (symbol.getSymbol() == 1 || symbol.getSymbol() == 2) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 6, symbol.getRotation());
		} else if (symbol.getSymbol() == 3) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 2, symbol.getRotation());
		} else if (symbol.getSymbol() == 4 || symbol.getSymbol() == 5 || symbol.getSymbol() == 6) {
			if (EyesBaseSymbol.getEyesBaseSymbol(symbol.getBaseSymbol()).equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE)) {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 4, symbol.getRotation());
			} else {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
			}
		} else if (symbol.getSymbol() > 6 && symbol.getSymbol() < 12) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 3, symbol.getRotation());
		} else {
			result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		}
		assert result != null : "Postcondition failed: result != null";

		return result;

	}

	public static Symbol getRightEyeFor(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		Symbol result = null;

		EyesBaseSymbol eyesBaseSymbol = EyesBaseSymbol.getEyesBaseSymbol(symbol.getBaseSymbol());

		if (symbol.getSymbol() == 1 || symbol.getSymbol() == 2) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
		} else if (symbol.getSymbol() == 3) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 2, symbol.getRotation());
		} else if (symbol.getSymbol() == 4 || symbol.getSymbol() == 5 || symbol.getSymbol() == 6) {

			if (EyesBaseSymbol.getEyesBaseSymbol(symbol.getBaseSymbol()).equals(EyesBaseSymbol.EYE_BLINK_SINGLE)) {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 4, symbol.getRotation());
			} else if (EyesBaseSymbol.getEyesBaseSymbol(symbol.getBaseSymbol())
					.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE)) {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 4, symbol.getRotation());
			} else {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 5, symbol.getRotation());
			}
		} else if (symbol.getSymbol() == 7 || symbol.getSymbol() == 8) {
			if (eyesBaseSymbol.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE)
					&& (symbol.getRotation() == 1 || symbol.getRotation() == 5)) {
				if (symbol.getRotation() == 1) {
					result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 3, 5);
				} else if (symbol.getRotation() == 5) {
					result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 3, 1);
				}
			} else {
				result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 3, symbol.getRotation());
			}
		} else if (symbol.getSymbol() == 9 || symbol.getSymbol() == 10 || symbol.getSymbol() == 11) {
			result = getSymbolForBaseSymbolWithFillAndRotation(symbol.getBaseSymbol(), 3, symbol.getRotation());
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

	private static Map<BaseSymbol, Map<Integer, Integer>> createCircleSymbolToFillMap() {

		Map<BaseSymbol, Map<Integer, Integer>> result = new HashMap<BaseSymbol, Map<Integer, Integer>>();

		HashMap<Integer, Integer> hashMapPlusThree = new HashMap<Integer, Integer>();
		hashMapPlusThree.put(1, 4);
		hashMapPlusThree.put(2, 5);
		hashMapPlusThree.put(3, 6);
		HashMap<Integer, Integer> hashMapPlusOne = new HashMap<Integer, Integer>();
		hashMapPlusOne.put(1, 2);
		HashMap<Integer, Integer> hashMapFromThreeToTwo = new HashMap<Integer, Integer>();
		hashMapFromThreeToTwo.put(1, 4);
		hashMapFromThreeToTwo.put(2, 5);
		hashMapFromThreeToTwo.put(3, 5);

		result.put(new BaseSymbol(4, 2, 1, 1), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 1, 2), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 1, 3), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 2, 1), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 2, 2), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 2, 3), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 2, 4), hashMapPlusThree);
		result.put(new BaseSymbol(4, 2, 3, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 3, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 3, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 4, 1), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 4, 2), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 4, 3), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 4, 4), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 4, 5), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 5, 1), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 5, 2), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 5, 3), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 5, 4), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 5, 5), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 6, 1), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 6, 2), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 6, 3), hashMapFromThreeToTwo);
		result.put(new BaseSymbol(4, 2, 7, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 7, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 7, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 8, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 8, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 8, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 9, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 10, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 2, 11, 1), hashMapPlusOne);

		return result;
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVariations() {
		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 3, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 1, 2, 1, 12, 2));
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 3, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 3, 2, 1, 16, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 3, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 3, 2, 2, 1, 20, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 4, 5);
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 5, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 5, 4, 1, 9, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 5, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 5, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 5, 5, 1, 9, 4));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 1, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 5, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 6, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 4, 1, 23, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 5, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 1, 4, 1, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 1, 5, 1, 8, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 11, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 7, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 8, 10, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 6, 23, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 7, 25, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 8, 23, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 2, 23, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 1, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 3, 25, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 2, 10, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 4, 23, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 5, 25, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 5, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 6, 10, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 3, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 2, 1, 25, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 11, 1, 3, 4, 10, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 9, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 6, 20, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 7, 17, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 4, 23, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 5, 25, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 10, 20, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 11, 17, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 8, 23, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 9, 25, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 2, 20, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 3, 17, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 1, 25, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 15, 6, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 16, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 13, 11, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 14, 9, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 14, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 13, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 12, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 11, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 16, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 15, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 2, 9, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 1, 11, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 4, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 3, 6, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 9, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 10, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 10, 9, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 9, 11, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 12, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 11, 6, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 6, 9, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 5, 11, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 8, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 3, 7, 6, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 16, 23, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 12, 23, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 13, 25, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 14, 20, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 9, 1, 2, 15, 17, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 7, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 6, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 5, 28, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 8, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 7, 21, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 2, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 1, 28, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 4, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 2, 3, 21, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 2, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 4, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 6, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 4, 8, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 1, 13, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 4, 10, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 5, 13, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 2, 10, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 3, 7, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 8, 10, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 6, 10, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 2, 3, 7, 7, 13));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 2, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 4, 1, 24, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 6, 1, 11, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 5, 1, 11, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 3, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 5, 4);
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 4, 5, 1, 8, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 4, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 4, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 4, 4, 1, 21, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 4, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 7, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 1, 28, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 6, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 3, 22, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 2, 23, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 8, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 5, 28, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 4, 26, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 2, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 7, 22, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 6, 26, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 4, 4, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 8, 10, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 7, 8, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 6, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 5, 13, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 4, 11, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 3, 8, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 2, 10, 11));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 3, 1, 13, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 3, 2, 8, 23, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 2, 4);
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 4, 1, 24, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 5, 1, 11, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 4, 6, 1, 11, 8));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 5, 5);
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 5, 5, 1, 12, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 5, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 5, 4, 1, 26, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 5, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 5, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 5, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 2, 4, 1, 22, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 2, 5, 1, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 2, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 5, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 3, 5, 1, 8, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 3, 4, 1, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 5, 3, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 7, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 2, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 8, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 3, 22, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 4, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 5, 20, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 6, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 4, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 7, 22, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 8, 20, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 6, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 2, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 2, 1, 20, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 7, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 8, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 5, 8, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 6, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 3, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 4, 8, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 1, 8, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 7, 1, 3, 2, 8, 8));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 4, 4);
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 4, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 4, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 4, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 4, 5, 1, 11, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 4, 4, 1, 11, 4));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 4, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 3, 4, 1, 21, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 3, 5, 1, 8, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 3, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 4, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 2, 5, 1, 8, 2));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 2, 4, 1, 21, 2));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 2, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 4, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 1, 5, 1, 8, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 1, 4, 1, 21, 4));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 4, 1, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 2, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 6, 1, 11, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 5, 1, 11, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 4, 1, 24, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 2, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 2, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 5, 1, 12, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 4, 1, 26, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 2, 1, 6, 1, 12, 9));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 1, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 4, 1, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 6, 1, 8, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 2, 5, 1, 8, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 6, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 1, 5, 1, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 1, 4, 1, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 1, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 1, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 5, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 4, 1, 22, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 1, 3, 6, 1, 10, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 6, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 2, 5, 1, 11, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 2, 4, 1, 24, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 2, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 8, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 8, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 6, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 7, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 4, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 5, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 2, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 3, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 3, 1, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 7, 21, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 6, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 8, 19, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 8, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 3, 21, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 4, 19, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 5, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 6, 19, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 1, 18, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 2, 2, 19, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 2, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 1, 4, 4, 5, 5));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 6, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 3, 4, 1, 24, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 3, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 3, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 3, 5, 1, 11, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 6, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 8, 2);
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 1, 28, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 8, 23, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 7, 21, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 6, 23, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 5, 28, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 4, 23, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 3, 21, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 2, 2, 23, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 2, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 1, 13, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 8, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 7, 7, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 4, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 3, 7, 13));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 6, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 3, 5, 13, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 2, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 8, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 4, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 6, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 2, 4, 7, 7, 7));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 8, 3);
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 4, 22, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 3, 21, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 8, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 2, 19, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 7, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 1, 22, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 6, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 8, 19, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 5, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 7, 21, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 4, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 6, 22, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 3, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 2, 5, 22, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 2, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 4, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 3, 7, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 2, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 5, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 4, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 7, 7, 10));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 6, 9, 7));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 8, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 3, 1, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 8, 3, 1, 3, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 2, 10, 1);
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 1, 9, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 5, 9, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 2, 20, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 4, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 1, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 3, 9, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 4, 22, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 2, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 3, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 6, 20, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 8, 9, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 5, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 7, 9, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 8, 22, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 3, 6, 7, 9));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 2, 7, 22, 6));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 2, 10, 1, 1, 4, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

}
