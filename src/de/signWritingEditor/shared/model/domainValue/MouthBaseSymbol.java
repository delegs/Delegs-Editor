package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: für open-source die ganzen Warnungen beheben
public enum MouthBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), // Added
																			// manually
	WHITESPACE(Symbol.HEAD_WHITESPACE_SYMBOL, Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), // Added
																			// manually

	MOUTH_CLOSED_NEUTRAL(new Symbol(4, 4, 1, 1, 2, 1, 14, 2), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_CLOSED_FORWARD(new Symbol(4, 4, 1, 2, 2, 1, 22, 9), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_CLOSED_CONTACT(new Symbol(4, 4, 1, 3, 2, 1, 18, 11), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, })), //
	MOUTH_SMILE(new Symbol(4, 4, 2, 1, 2, 1, 15, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_SMILE_WRINKLED(new Symbol(4, 4, 2, 2, 2, 1, 21, 8), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_SMILE_OPEN(new Symbol(4, 4, 2, 3, 2, 1, 15, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_FROWN(new Symbol(4, 4, 3, 1, 2, 1, 15, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_FROWN_WRINKLED(new Symbol(4, 4, 3, 2, 2, 1, 21, 7), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_FROWN_OPEN(new Symbol(4, 4, 3, 3, 2, 1, 15, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_CIRCLE(new Symbol(4, 4, 4, 1, 2, 1, 9, 8), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_FORWARD(new Symbol(4, 4, 4, 2, 2, 1, 21, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_WRINKLED(new Symbol(4, 4, 4, 3, 2, 1, 13, 14), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_OVAL(new Symbol(4, 4, 5, 1, 2, 1, 14, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_OVAL_WRINKLED(new Symbol(4, 4, 5, 2, 2, 1, 23, 7), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_OVAL_YAWN(new Symbol(4, 4, 5, 3, 2, 1, 6, 12), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_RECTANGLE(new Symbol(4, 4, 6, 1, 2, 1, 10, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_RECTANGLE_WRINKLED(new Symbol(4, 4, 6, 2, 2, 1, 16, 12), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_OPEN_RECTANGLE_YAWN(new Symbol(4, 4, 6, 3, 2, 1, 6, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_KISS(new Symbol(4, 4, 7, 1, 2, 1, 5, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_KISS_FORWARD(new Symbol(4, 4, 7, 2, 2, 1, 19, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_KISS_WRINKLED(new Symbol(4, 4, 7, 3, 2, 1, 11, 11), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_TENSE(new Symbol(4, 4, 8, 1, 2, 1, 11, 5), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_TENSE_FORWARD(new Symbol(4, 4, 8, 2, 2, 1, 23, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_TENSE_SUCKED(new Symbol(4, 4, 8, 3, 2, 1, 23, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	LIPS_PRESSED_TOGETHER(new Symbol(4, 4, 9, 1, 2, 1, 13, 7), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	LIP_LOWER_OVER_UPPER(new Symbol(4, 4, 9, 2, 2, 1, 14, 4), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	LIP_UPPER_OVER_LOWER(new Symbol(4, 4, 9, 3, 2, 1, 14, 4), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_CORNERS(new Symbol(4, 4, 10, 1, 4, 1, 23, 6), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_WRINKLES_SINGLE(new Symbol(4, 4, 11, 1, 4, 1, 20, 7), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	MOUTH_WRINKLES_DOUBLE(new Symbol(4, 4, 11, 2, 4, 1, 24, 7), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	// From here on out category "tongue teeth chin neck" starts
	TONGUE_STICKS_OUT_FAR(new Symbol(4, 5, 1, 1, 2, 1, 10, 13), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TONGUE_LICKS_LIPS(new Symbol(4, 5, 1, 2, 2, 1, 14, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TONGUE_TIP_BETWEEN_LIPS(new Symbol(4, 5, 1, 3, 2, 1, 16, 6), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TONGUE_TIP_TOUCHES_INSIDE_MOUTH(new Symbol(4, 5, 1, 4, 2, 1, 10, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TONGUE_INSIDE_MOUTH_RELAXED(new Symbol(4, 5, 1, 5, 2, 1, 10, 10), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TONGUE_CENTER_STICKS_OUT(new Symbol(4, 5, 3, 1, 4, 1, 10, 10), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TONGUE_CENTER_INSIDE_MOUTH(new Symbol(4, 5, 4, 1, 3, 1, 10, 10), Arrays.asList(new Integer[] { 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH(new Symbol(4, 5, 5, 1, 2, 1, 15, 8), Arrays.asList(new Integer[] { 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_MOVEMENT(new Symbol(4, 5, 5, 2, 4, 1, 27, 12), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_ON_TONGUE(new Symbol(4, 5, 6, 1, 3, 1, 15, 10), Arrays.asList(new Integer[] { 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_ON_TONGUE_MOVEMENT(new Symbol(4, 5, 6, 2, 4, 1, 25, 15), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_ON_LIPS(new Symbol(4, 5, 7, 1, 3, 1, 10, 6), Arrays.asList(new Integer[] { 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_ON_LIPS_MOVEMENT(new Symbol(4, 5, 7, 2, 4, 1, 24, 11), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	TEETH_BITE_LIPS(new Symbol(4, 5, 8, 1, 4, 1, 15, 8), Arrays.asList(new Integer[] { 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static Map<BaseSymbol, Map<Integer, Integer>> circleSymbolToFillMap = createCircleSymbolToFillMap();
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();

	private MouthBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public Symbol getIswaSymbol() {
		return iswaSymbol;
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyMouthSymbol(symbol) : "Precondition failed: isAnyMouthSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

	public static List<Symbol> getAllVariationsForSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: symbol != null";
		assert isAnyMouthSymbol(baseSymbol) : "Precondition failed: isAnyMouthSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(baseSymbol));
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

	public boolean canIncrease() {
		boolean result = false;

		if (iswaSymbol.getBaseSymbol().equals(MouthBaseSymbol.MOUTH_WRINKLES_SINGLE.iswaSymbol.getBaseSymbol())) {
			result = true;
		}
		return result;
	}

	public boolean canDecrease() {
		boolean result = false;

		if (iswaSymbol.getBaseSymbol().equals(MouthBaseSymbol.MOUTH_WRINKLES_DOUBLE.iswaSymbol.getBaseSymbol())) {
			result = true;
		}
		return result;
	}

	public static MouthBaseSymbol getMouthBaseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidMouthSymbol(symbol) : "Precondition failed: isMouthBaseSymbol(symbol)";

		MouthBaseSymbol result = null;

		List<MouthBaseSymbol> asList = Arrays.asList(MouthBaseSymbol.values());

		for (MouthBaseSymbol mouthBaseSymbol : asList) {
			if (mouthBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				result = mouthBaseSymbol;
				break;
			}
		}
		return result;
	}

	public static boolean isValidMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<MouthBaseSymbol> asList = Arrays.asList(MouthBaseSymbol.values());
		if (result == false) {
			for (MouthBaseSymbol mouthBaseSymbol : asList) {
				if (mouthBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& mouthBaseSymbol.getValidFills().contains(symbol.getFill())
						&& mouthBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = false;
		List<MouthBaseSymbol> asList = Arrays.asList(MouthBaseSymbol.values());
		for (MouthBaseSymbol mouthBaseSymbol : asList) {
			if (mouthBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static boolean isAnyMouthSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		boolean result = false;
		List<MouthBaseSymbol> asList = Arrays.asList(MouthBaseSymbol.values());
		for (MouthBaseSymbol mouthBaseSymbol : asList) {
			if (mouthBaseSymbol.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static int getFillForSymbolWithoutCircle(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyMouthSymbol(symbol) : "Precondition failed: isAnyMouthSymbol(symbol)";

		int result = symbol.getFill();

		if (!isValidMouthSymbol(symbol)) {
			Map<Integer, Integer> map = circleSymbolToFillMap.get(symbol.getBaseSymbol());
			if (map != null) {
				result = map.get(symbol.getFill());
			}
		}

		return result;
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVariations() {

		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 11, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 4, 1, 20, 7));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 6, 1, 4, 7));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 1, 5, 1, 4, 7));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 2, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 2, 2, 1, 21, 8));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 2, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 1, 2, 1, 15, 6));
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 2, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 2, 3, 2, 1, 15, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
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
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 9, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 2, 2, 1, 14, 4));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 4, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 3, 2, 1, 13, 14));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 9, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 3, 2, 1, 14, 4));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 9, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 1, 2, 1, 13, 7));
		variationsForBaseSymbol.add(new Symbol(4, 4, 9, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 11, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 6, 1, 8, 7));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 4, 1, 24, 7));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 11, 2, 5, 1, 8, 7));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 7, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 3, 2, 1, 11, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 7, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 2, 2, 1, 19, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 5, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 6, 1, 19, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 5, 1, 13, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 3, 1, 6, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 4, 1, 7, 4));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 2, 1, 15, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 5, 2);
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 4, 1, 27, 12));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 5, 1, 21, 13));
		variationsForBaseSymbol.add(new Symbol(4, 5, 5, 2, 6, 1, 19, 16));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 5, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 1, 2, 1, 14, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 5, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 3, 2, 1, 6, 12));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 7, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 7, 1, 2, 1, 5, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 5, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 5, 2, 2, 1, 23, 7));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 1, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 3, 13, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 4, 11, 11));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 1, 10, 13));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 2, 11, 11));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 7, 13, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 8, 11, 11));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 5, 10, 13));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 1, 2, 6, 11, 11));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 1, 2);
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 1, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 3, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 2, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 5, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 4, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 7, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 6, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 2, 8, 14, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 2, 1, 7, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 3, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 1, 2, 1, 15, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 7, 2);
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 5, 1, 17, 11));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 4, 1, 24, 11));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 2, 6, 1, 19, 14));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 1, 3);
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 8, 16, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 7, 15, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 4, 16, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 3, 15, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 6, 16, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 5, 16, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 2, 16, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 3, 2, 1, 16, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 7, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 5, 1, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 4, 1, 10, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 3, 1, 10, 6));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 6, 1, 5, 5));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 7, 1, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 1, 4);
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 6, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 7, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 8, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 1, 2, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 2, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 3, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 4, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 4, 2, 5, 10, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 1, 5);
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 2, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 3, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 4, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 5, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 6, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 7, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 2, 8, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 5, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 4, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 7, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 6, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 8, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 3, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 1, 5, 1, 2, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 1, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 3, 2, 1, 18, 11));
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 1, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 2, 2, 1, 22, 9));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 1, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 1, 1, 2, 1, 14, 2));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 3, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 3, 2, 1, 15, 6));
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 3, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 3, 2, 2, 1, 21, 7));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 10, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 5, 1, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 6, 1, 19, 6));
		variationsForBaseSymbol.add(new Symbol(4, 4, 10, 1, 4, 1, 23, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 3, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 4, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 5, 1, 20, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 3, 1, 6, 1, 21, 15));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 6, 2);
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 6, 1, 19, 18));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 4, 1, 25, 15));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 5, 1, 21, 15));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 2, 3, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 6, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 6, 1, 7, 7));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 3, 1, 15, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 4, 1, 15, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 6, 1, 5, 1, 6, 6));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 8, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 3, 2, 1, 23, 10));
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 8, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 2, 2, 1, 23, 10));
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 2, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 4, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 4, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 4, 1, 4, 1, 20, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 4, 1, 3, 1, 10, 10));
		variationsForBaseSymbol.add(new Symbol(4, 5, 4, 1, 2, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 6, 3);
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 3, 2, 1, 6, 10));
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 3, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 8, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 1, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 8, 1, 2, 1, 11, 5));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 6, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 2, 2, 1, 16, 12));
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 2, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 6, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 1, 2, 1, 10, 6));
		variationsForBaseSymbol.add(new Symbol(4, 4, 6, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 8, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 2, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 3, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 6, 1, 14, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 5, 1, 14, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 4, 1, 15, 8));
		variationsForBaseSymbol.add(new Symbol(4, 5, 8, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 4, 1);
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 1, 2, 1, 9, 8));
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 1, 1, 1, 36, 35));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 4, 4, 2);
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 2, 1, 1, 36, 35));
		variationsForBaseSymbol.add(new Symbol(4, 4, 4, 2, 2, 1, 21, 10));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

	private static Map<BaseSymbol, Map<Integer, Integer>> createCircleSymbolToFillMap() {

		Map<BaseSymbol, Map<Integer, Integer>> result = new HashMap<BaseSymbol, Map<Integer, Integer>>();

		HashMap<Integer, Integer> hashMapPlusThree = new HashMap<Integer, Integer>();
		hashMapPlusThree.put(1, 4);
		hashMapPlusThree.put(2, 5);
		hashMapPlusThree.put(3, 6);
		HashMap<Integer, Integer> hashMapPlusTwo = new HashMap<Integer, Integer>();
		hashMapPlusTwo.put(1, 3);
		hashMapPlusTwo.put(2, 4);
		HashMap<Integer, Integer> hashMapPlusOne = new HashMap<Integer, Integer>();
		hashMapPlusOne.put(1, 2);
		HashMap<Integer, Integer> hashMapFromThreeToTwo = new HashMap<Integer, Integer>();
		hashMapFromThreeToTwo.put(1, 4);
		hashMapFromThreeToTwo.put(2, 5);
		hashMapFromThreeToTwo.put(3, 5);

		result.put(new BaseSymbol(4, 4, 1, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 1, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 1, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 2, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 2, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 2, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 3, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 3, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 3, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 4, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 4, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 4, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 5, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 5, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 5, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 6, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 6, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 6, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 7, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 7, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 7, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 8, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 8, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 8, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 9, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 9, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 9, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 4, 10, 1), hashMapPlusThree);
		result.put(new BaseSymbol(4, 4, 11, 1), hashMapPlusThree);
		result.put(new BaseSymbol(4, 4, 11, 2), hashMapPlusThree);

		// Next Symbol Group Tongue Teeth Chin Neeck
		result.put(new BaseSymbol(4, 5, 1, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 1, 2), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 1, 3), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 1, 4), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 1, 5), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 3, 1), hashMapPlusThree);
		result.put(new BaseSymbol(4, 5, 4, 1), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 5, 5, 1), hashMapPlusOne);
		result.put(new BaseSymbol(4, 5, 5, 2), hashMapPlusThree);
		result.put(new BaseSymbol(4, 5, 6, 1), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 5, 6, 2), hashMapPlusThree);
		result.put(new BaseSymbol(4, 5, 7, 1), hashMapPlusTwo);
		result.put(new BaseSymbol(4, 5, 7, 2), hashMapPlusThree);
		result.put(new BaseSymbol(4, 5, 8, 1), hashMapPlusThree);

		return result;
	}
}
