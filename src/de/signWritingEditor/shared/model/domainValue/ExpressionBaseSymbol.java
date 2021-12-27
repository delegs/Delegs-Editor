package de.signWritingEditor.shared.model.domainValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ExpressionBaseSymbol implements SymbolEnum {
	NONE(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL, Collections.<Integer>emptyList(),
			Collections.<SymbolRotation>emptyList()), // Added manually
	EXCITEMENT(new Symbol(4, 5, 13, 1, 2, 1, 47, 47), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //

	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	private ExpressionBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
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

	public static ExpressionBaseSymbol getExpressionBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		ExpressionBaseSymbol result = null;
		for (ExpressionBaseSymbol expressionBaseSymbol : ExpressionBaseSymbol.values()) {
			if (expressionBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& expressionBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& expressionBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& expressionBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = expressionBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isValidExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<ExpressionBaseSymbol> asList = Arrays.asList(ExpressionBaseSymbol.values());
		if (result == false) {
			for (ExpressionBaseSymbol expressionBaseSymbol : asList) {
				if (expressionBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())
						&& expressionBaseSymbol.getValidFills().contains(symbol.getFill())
						&& expressionBaseSymbol.getValidRotationValues().contains(symbol.getRotation())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static boolean isAnyExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL.equals(symbol);
		List<ExpressionBaseSymbol> asList = Arrays.asList(ExpressionBaseSymbol.values());
		if (result == false) {
			for (ExpressionBaseSymbol expressionBaseSymbol : asList) {
				if (expressionBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
