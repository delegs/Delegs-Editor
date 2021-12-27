package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolEnum;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public enum BodyBaseSymbol implements SymbolEnum {
	SHOULDER_HIP_SPINE(new Symbol(5, 1, 1, 1, 1, 1, 42, 4), Arrays.asList(new Integer[] { 1, 2, 3 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	SHOULDER_HIP_POSITIONS(new Symbol(5, 1, 2, 1, 1, 1, 46, 12), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST })), //
	SHOULDER_HIP_MOVE_WALL_PLANE(new Symbol(5, 1, 3, 1, 1, 1, 54, 10),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	SHOULDER_HIP_MOVE_FLOOR_PLANE(new Symbol(5, 1, 4, 1, 1, 1, 53, 10),
			Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	SHOULDER_TILTS(new Symbol(5, 1, 5, 1, 1, 1, 50, 11), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	TORSO_STRAIGHT_STRETCH_WALL(new Symbol(5, 1, 6, 1, 1, 1, 42, 20), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	TORSO_CURVED_BLEND_WALL(new Symbol(5, 1, 7, 1, 1, 1, 42, 14), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	TORSO_TWIST_FLOOR_PLANE(new Symbol(5, 1, 8, 1, 1, 1, 42, 12), Arrays.asList(new Integer[] { 1, 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST })), //
	UPPER_BODY_TILTS(new Symbol(5, 1, 9, 1, 1, 1, 36, 48), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST })), //
	LIMB_COMBINATIONS(new Symbol(5, 2, 1, 1, 1, 1, 24, 23), Arrays.asList(new Integer[] { 1 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_1(new Symbol(5, 2, 2, 1, 1, 1, 2, 25), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_2(new Symbol(5, 2, 2, 2, 1, 1, 2, 32), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_3(new Symbol(5, 2, 2, 3, 1, 1, 2, 40), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_4(new Symbol(5, 2, 2, 4, 1, 1, 2, 48), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_5(new Symbol(5, 2, 3, 1, 1, 1, 2, 16), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_6(new Symbol(5, 2, 3, 2, 1, 1, 2, 12), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	LIMB_LENGTH_7(new Symbol(5, 2, 3, 3, 1, 1, 2, 8), Arrays.asList(new Integer[] { 1, 2 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	FINGERS(new Symbol(5, 2, 4, 1, 1, 1, 9, 14), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH, SymbolRotation.SOUTH_EAST, SymbolRotation.EAST,
					SymbolRotation.NORTH_EAST, SymbolRotation.MIRRORED_NORTH, SymbolRotation.MIRRORED_NORTH_WEST,
					SymbolRotation.MIRRORED_WEST, SymbolRotation.MIRRORED_SOUTH_WEST, SymbolRotation.MIRRORED_SOUTH,
					SymbolRotation.MIRRORED_SOUTH_EAST, SymbolRotation.MIRRORED_EAST,
					SymbolRotation.MIRRORED_NORTH_EAST })), //
	HEAD_WITH_SHOULDERS_OR_NOSE(new Symbol(4, 1, 1, 1, 3, 1, 48, 35), Arrays.asList(new Integer[] { 2, 3, 4 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH, SymbolRotation.NORTH_WEST, SymbolRotation.WEST,
					SymbolRotation.SOUTH_WEST, SymbolRotation.SOUTH })), //
	// Breath Symbols That behave like a BodySymbol
	BREATH_EXHALE(new Symbol(4, 3, 7, 1, 4, 1, 7, 12), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH })), //
	BREATH_INHALE(new Symbol(4, 3, 7, 2, 4, 1, 7, 12), Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }),
			Arrays.asList(new SymbolRotation[] { SymbolRotation.NORTH }))//
	;

	private final Symbol iswaSymbol;
	private List<SymbolRotation> validRotations;
	private List<Integer> validFills;
	private static List<BodyBaseSymbol> airRelatedBodySymbols = Arrays
			.asList(new BodyBaseSymbol[] { BREATH_EXHALE, BREATH_INHALE });

	private BodyBaseSymbol(Symbol iswaSymbol, List<Integer> validFills, List<SymbolRotation> validRotations) {
		this.iswaSymbol = iswaSymbol;
		this.validFills = validFills;
		this.validRotations = validRotations;
	}

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

		if (getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_2.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_3.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_4.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_5.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_6.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.LIMB_LENGTH_7.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.SHOULDER_TILTS.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(BodyBaseSymbol.SHOULDER_HIP_MOVE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(BodyBaseSymbol.TORSO_CURVED_BLEND_WALL.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol()
						.equals(BodyBaseSymbol.TORSO_TWIST_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getIswaSymbol().getBaseSymbol().equals(BodyBaseSymbol.FINGERS.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	public static BodyBaseSymbol getBodyBaseSymbol(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		BodyBaseSymbol result = null;
		for (BodyBaseSymbol bodyBaseSymbol : BodyBaseSymbol.values()) {
			if (bodyBaseSymbol.getIswaSymbol().getCategory() == baseSymbol.getCategory()
					&& bodyBaseSymbol.getIswaSymbol().getGroup() == baseSymbol.getGroup()
					&& bodyBaseSymbol.getIswaSymbol().getSymbol() == baseSymbol.getSymbol()
					&& bodyBaseSymbol.getIswaSymbol().getVariation() == baseSymbol.getVariation()) {
				result = bodyBaseSymbol;
				break;
			}
		}

		return result;
	}

	public static boolean isAirRelatedBodySymbol(BaseSymbol baseSymbol) {
		boolean result = false;
		for (BodyBaseSymbol element : airRelatedBodySymbols) {
			if (element.getIswaSymbol().getBaseSymbol().equals(baseSymbol)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
