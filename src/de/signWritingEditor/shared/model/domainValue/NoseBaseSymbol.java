package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NoseBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, null, null), //

	NOSE_NEUTRAL(new Symbol(4, 3, 4, 1, 2, 1, 2, 12), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	NOSE_CONTACT(new Symbol(4, 3, 4, 2, 2, 1, 10, 13), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	NOSE_WRINKLES(new Symbol(4, 3, 4, 3, 2, 1, 8, 12), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	NOSE_WIGGLES(new Symbol(4, 3, 4, 4, 2, 1, 14, 13), Arrays.asList(new Integer[] { 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	private NoseBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static NoseBaseSymbol getNoseBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		NoseBaseSymbol result = null;
		for (NoseBaseSymbol noseBaseSymbol : NoseBaseSymbol.values()) {
			if (noseBaseSymbol.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
				result = noseBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<NoseBaseSymbol> asList = Arrays.asList(NoseBaseSymbol.values());
		if (result == false) {
			for (NoseBaseSymbol noseBaseSymbol : asList) {
				if (noseBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& noseBaseSymbol.getValidFills().contains(symbol.getFill())
						&& noseBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		NoseBaseSymbol[] asList = NoseBaseSymbol.values();
		if (!result) {
			for (NoseBaseSymbol noseBaseSymbol : asList) {
				if (noseBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
