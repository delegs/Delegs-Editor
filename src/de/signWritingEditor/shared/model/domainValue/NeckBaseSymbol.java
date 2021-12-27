package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum NeckBaseSymbol implements SymbolEnum {

	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually
	NECK(new Symbol(4, 5, 11, 1, 2, 1, 20, 13), Arrays.asList(new Integer[] { 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private final static Map<BaseSymbol, Set<Symbol>> allVariations = createAllVariations();

	private NeckBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static NeckBaseSymbol getNeckBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		NeckBaseSymbol result = null;
		for (NeckBaseSymbol neckBaseSymbol : NeckBaseSymbol.values()) {
			if (neckBaseSymbol.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
				result = neckBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<NeckBaseSymbol> asList = Arrays.asList(NeckBaseSymbol.values());
		if (result == false) {
			for (NeckBaseSymbol neckBaseSymbol : asList) {
				if (neckBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& neckBaseSymbol.getValidFills().contains(symbol.getFill())
						&& neckBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<NeckBaseSymbol> asList = Arrays.asList(NeckBaseSymbol.values());
		if (result == false) {
			for (NeckBaseSymbol neckBaseSymbol : asList) {
				if (neckBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static NeckBaseSymbol getNeckBaseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isValidNeckSymbol(symbol) : "Precondition failed: isNeckBaseSymbol(symbol)";

		NeckBaseSymbol result = null;

		List<NeckBaseSymbol> asList = Arrays.asList(NeckBaseSymbol.values());

		for (NeckBaseSymbol neckBaseSymbol : asList) {
			if (neckBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				result = neckBaseSymbol;
				break;
			}
		}
		return result;
	}

	public static List<Symbol> getAllVariationsForSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyNeckSymbol(symbol) : "Precondition failed: isAnyNeckSymbol(symbol)";

		return new ArrayList<Symbol>(allVariations.get(symbol.getBaseSymbol()));
	}

	private static Map<BaseSymbol, Set<Symbol>> createAllVariations() {

		Map<BaseSymbol, Set<Symbol>> result = new HashMap<BaseSymbol, Set<Symbol>>();
		BaseSymbol baseSymbol = null;
		Set<Symbol> variationsForBaseSymbol = new HashSet<Symbol>();
		variationsForBaseSymbol = new HashSet<Symbol>();
		baseSymbol = new BaseSymbol(4, 5, 11, 1);
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 1, 1, 36, 46));
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 2, 1, 20, 13));
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 3, 1, 20, 20));
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 4, 1, 20, 20));
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 5, 1, 20, 20));
		variationsForBaseSymbol.add(new Symbol(4, 5, 11, 1, 6, 1, 20, 20));
		result.put(new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
				baseSymbol.getVariation()), new HashSet<Symbol>(variationsForBaseSymbol));

		return result;
	}

}
