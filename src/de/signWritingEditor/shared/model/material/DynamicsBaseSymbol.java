package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public enum DynamicsBaseSymbol implements SymbolEnum {
	FAST(new Symbol(3, 1, 1, 1, 1, 1, 12, 7), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	SLOW(new Symbol(3, 1, 2, 1, 1, 1, 38, 11), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	TENSE(new Symbol(3, 1, 3, 1, 1, 1, 11, 5), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	RELAXED(new Symbol(3, 1, 3, 2, 1, 1, 11, 7), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	SAME_TIME(new Symbol(3, 1, 4, 1, 1, 1, 15, 6), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SAME_TIME_ALTERNATING(new Symbol(3, 1, 4, 2, 1, 1, 15, 11), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	EVERY_OTHER_TIME(new Symbol(3, 1, 4, 3, 1, 1, 23, 6), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	GRADUAL(new Symbol(3, 1, 4, 4, 1, 1, 15, 14), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })) //
	;

	private final Symbol iswaSymbol;
	private List<Integer> validFills;
	private List<SymbolRotation> validRotations;

	private DynamicsBaseSymbol(Symbol symbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.validFills = validFills;
		this.validRotations = validRotations;
		this.iswaSymbol = symbol;
	}

	@Override
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
		boolean canBeMirrored = true;
		return canBeMirrored;
	}

	public static DynamicsBaseSymbol getDynamicsBaseSymbol(BaseSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		DynamicsBaseSymbol result = null;
		for (DynamicsBaseSymbol dynamicBaseSymbol : DynamicsBaseSymbol.values()) {
			if (dynamicBaseSymbol.getIswaSymbol().getCategory() == symbol.getCategory()
					&& dynamicBaseSymbol.getIswaSymbol().getGroup() == symbol.getGroup()
					&& dynamicBaseSymbol.getIswaSymbol().getSymbol() == symbol.getSymbol()
					&& dynamicBaseSymbol.getIswaSymbol().getVariation() == symbol.getVariation()) {
				result = dynamicBaseSymbol;
				break;
			}
		}

		return result;
	}

}
