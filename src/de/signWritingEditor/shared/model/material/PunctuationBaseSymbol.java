package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public enum PunctuationBaseSymbol implements SymbolEnum {
	COMMA(new Symbol(7, 1, 1, 1, 1, 1, 74, 8), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	PERIOD(new Symbol(7, 1, 1, 2, 1, 1, 72, 8), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	SEMICOLON(new Symbol(7, 1, 2, 1, 1, 1, 72, 14), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	COLON(new Symbol(7, 1, 2, 2, 1, 1, 72, 21), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	PARENTHESES(new Symbol(7, 1, 3, 1, 1, 1, 60, 15), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //

	;

	private static final List<SymbolRotation> MIRRORED_ROTATIONS = Arrays.asList(new SymbolRotation[] {
			SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST, SymbolRotation.MIRRORED_WEST,
			SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH, SymbolRotation.MIRRORED_SOUTH_EAST,
			SymbolRotation.MIRRORED_EAST, SymbolRotation.MIRRORED_NORTH_EAST });

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	private PunctuationBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public static PunctuationBaseSymbol getPunctuationBaseSymbol(BaseSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		PunctuationBaseSymbol result = null;
		for (PunctuationBaseSymbol punctuationBaseSymbol : PunctuationBaseSymbol.values()) {
			if (punctuationBaseSymbol.getIswaSymbol().getCategory() == symbol.getCategory()
					&& punctuationBaseSymbol.getIswaSymbol().getGroup() == symbol.getGroup()
					&& punctuationBaseSymbol.getIswaSymbol().getSymbol() == symbol.getSymbol()
					&& punctuationBaseSymbol.getIswaSymbol().getVariation() == symbol.getVariation()) {
				result = punctuationBaseSymbol;
				break;
			}
		}

		return result;
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

		boolean result = false;

		for (SymbolRotation mirroredSymbolEnum : MIRRORED_ROTATIONS) {
			if (validRotations.contains(mirroredSymbolEnum)) {
				result = true;
				break;
			}
		}
		return result;
	}

}
