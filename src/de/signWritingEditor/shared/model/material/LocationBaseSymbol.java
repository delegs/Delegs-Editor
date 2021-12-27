package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public enum LocationBaseSymbol implements SymbolEnum {
	LOCATION_SPACE_WALL_PLANE(new Symbol(6, 1, 1, 1, 1, 1, 41, 41), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_SPACE_FLOOR_PLANE(new Symbol(6, 1, 1, 2, 1, 1, 41, 41), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_HEIGHT(new Symbol(6, 1, 2, 1, 1, 1, 43, 39), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_WIDTH(new Symbol(6, 1, 3, 1, 1, 1, 28, 43), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH })), //
	LOCATION_DEPTH(new Symbol(6, 1, 4, 1, 1, 1, 43, 21), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_HEAD_NECK(new Symbol(6, 1, 5, 1, 1, 1, 36, 41), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_TORSO(new Symbol(6, 1, 6, 1, 1, 1, 27, 48), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LOCATION_LIMBS_DIGITS(new Symbol(6, 1, 7, 1, 1, 1, 27, 37), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //

	;

	private static final List<SymbolRotation> MIRRORED_ROTATIONS = Arrays.asList(new SymbolRotation[] {
			SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST, SymbolRotation.MIRRORED_WEST,
			SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH, SymbolRotation.MIRRORED_SOUTH_EAST,
			SymbolRotation.MIRRORED_EAST, SymbolRotation.MIRRORED_NORTH_EAST });

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;

	private LocationBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

	public static LocationBaseSymbol getLocationBaseSymbol(BaseSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		LocationBaseSymbol result = null;
		for (LocationBaseSymbol locationBaseSymbol : LocationBaseSymbol.values()) {
			if (locationBaseSymbol.getIswaSymbol().getCategory() == symbol.getCategory()
					&& locationBaseSymbol.getIswaSymbol().getGroup() == symbol.getGroup()
					&& locationBaseSymbol.getIswaSymbol().getSymbol() == symbol.getSymbol()
					&& locationBaseSymbol.getIswaSymbol().getVariation() == symbol.getVariation()) {
				result = locationBaseSymbol;
				break;
			}
		}

		return result;
	}

	@Override
	public List<Integer> getValidFills() {
		return validFills;
	}

	@Override
	public List<SymbolRotation> getValidRotations() {
		return validRotations;
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
	public Symbol getIswaSymbol() {
		return iswaSymbol;
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
