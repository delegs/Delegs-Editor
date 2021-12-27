package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum HairBaseSymbol implements SymbolEnum {

	// Höhe und Breite entsprechen dem Originalwert/4
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually
	HAIR(new Symbol(4, 5, 12, 1, 2, 1, 36, 36), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH }));

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	private HairBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static HairBaseSymbol getHairBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		HairBaseSymbol result = null;
		for (HairBaseSymbol hairBaseSymbol : HairBaseSymbol.values()) {
			if (hairBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& hairBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& hairBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& hairBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = hairBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<HairBaseSymbol> asList = Arrays.asList(HairBaseSymbol.values());
		if (result == false) {
			for (HairBaseSymbol hairBaseSymbol : asList) {
				if (hairBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& hairBaseSymbol.getValidFills().contains(symbol.getFill())
						&& hairBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<HairBaseSymbol> asList = Arrays.asList(HairBaseSymbol.values());
		if (result == false) {
			for (HairBaseSymbol hairBaseSymbol : asList) {
				if (hairBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

}
