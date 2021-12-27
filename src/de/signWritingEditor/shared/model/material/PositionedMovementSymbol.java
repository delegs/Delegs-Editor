package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedMovementSymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = 1L;

	private Set<Symbol> validVariations;

	public PositionedMovementSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height,
			int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.MOVEMENT.getCategoryNumber(), group, symbol, variation, fill, rotation, width,
				height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedMovementSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.MOVEMENT
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.MOVEMENT.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedMovementSymbol clone() {
		return new PositionedMovementSymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Override
	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	@Override
	public boolean canManipulate() {
		return validVariations.size() > 1;
	}

	@Override
	public boolean canRotate() {
		return (canManipulate() && MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotations().size() > 1);
	}

	@Override
	public boolean canMirror() {

		boolean canBeMirrored = MovementBaseSymbol.getMovementBaseSymbol(getBaseSymbol()).canBeMirrored();

		// Symbols which can be mirrored but do not correspond to the general
		// mirror behavior according to iswa
		if (!canBeMirrored) {
			if ((MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SQUEEZE_FLICK_ALTERNATING.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRAVEL_SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.TRAVEL_SHAKING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()) && getSymbol().getRotation() < 5)
					|| (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()) && getSymbol().getRotation() < 5)
					|| (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()
							.equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
					|| (MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))) {
				canBeMirrored = true;
			}
		}

		return canBeMirrored;
	}

	@Override
	public boolean canMirrorVertically() {
		boolean canMirrorVertically = false;

		if ((getSymbol().getCategory() == 2 && getSymbol().getGroup() == 7) || (!(getSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_COMBINED.getIswaSymbol().getBaseSymbol()))
				&& (getMaxRotation() == 4 || getMaxRotation() == 6 || getMaxRotation() == 8
						|| getMaxRotation() == 16))) {
			canMirrorVertically = true;
		}

		return canMirrorVertically;
	}

	private int getMaxRotation() {
		assert validVariations != null : "Precondition failed: validVariations is null";

		int maxRotation = getSymbol().getRotation();

		for (Symbol variation : validVariations) {
			if (variation.getRotation() > maxRotation) {
				maxRotation = variation.getRotation();
			}
		}

		return maxRotation;
	}

	@Override
	public boolean canPitch() {
		boolean canPitch = false;

		if (MovementBaseSymbol.SURFACE_SYMBOLS
				.equals(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()))
				|| MovementBaseSymbol.SURFACE_BETWEEN
						.equals(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()))) {
			canPitch = true;
		}

		return canPitch;
	}

	@Override
	protected boolean isValidFill(int fill) {
		return MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(fill);
	}

	@Override
	protected boolean isValidRotation(int rotation) {
		return MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	@Override
	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation();

		if (isMirrored()) {
			nextRotation = getPreviousRotation();
		} else {
			nextRotation = getNextRotation();
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
	}

	@Override
	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation();

		if (isMirrored()) {
			nextRotation = getNextRotation();
		} else {
			nextRotation = getPreviousRotation();
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);

	}

	private boolean isMirrored() {
		boolean result = false;

		if (getSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() > 4) {
				result = true;
			}
		} else {
			if (getSymbol().getRotation() > 8) {
				result = true;
			}
		}

		return result;

	}

	private int getPreviousRotation() {
		int maxRotations = Collections
				.max(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues());
		int unmirroredRotations = MovementBaseSymbol.getMovementBaseSymbol(getBaseSymbol()).canBeMirrored()
				? maxRotations / 2 : maxRotations;

		int result = getSymbol().getRotation() - 1;

		if (result < 1) {
			result = unmirroredRotations;
		} else if (result == unmirroredRotations) {
			result = maxRotations;
		}

		// Symbols that do not have rotations 3 and 7
		if (getSymbol().getCategory() == 2 && getSymbol().getGroup() == 4) {
			if (result == 3) {
				result = 2;
			} else if (result == 7) {
				result = 6;
			}
		}
		// Symbols that do not have rotations 3,7, 11, 15
		if (getSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (result == 3) {
				result = 2;
			} else if (result == 7) {
				result = 6;
			} else if (result == 11) {
				result = 10;
			} else if (result == 15) {
				result = 14;
			}
		}
		return result;
	}

	private int getNextRotation() {

		int maxRotations = Collections
				.max(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues());
		int unmirroredRotations = MovementBaseSymbol.getMovementBaseSymbol(getBaseSymbol()).canBeMirrored()
				? maxRotations / 2 : maxRotations;
		boolean isMirrored = getSymbol().getRotation() > unmirroredRotations;

		int result = getSymbol().getRotation() % unmirroredRotations + 1;

		if (isMirrored) {
			result += unmirroredRotations;
		}

		// Symbols that do not have rotations 3 and 7
		if (getSymbol().getCategory() == 2 && getSymbol().getGroup() == 4) {
			if (result == 3) {
				result = 4;
			} else if (result == 7) {
				result = 8;
			}
		}
		// Symbols that do not have rotations 3,7, 11, 15
		if (getSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (result == 3) {
				result = 4;
			} else if (result == 7) {
				result = 8;
			} else if (result == 11) {
				result = 12;
			} else if (result == 15) {
				result = 16;
			}
		}

		return result;
	}

	@Override
	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : validVariations) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	@Deprecated
	protected PositionedMovementSymbol() {
	}

	@Override
	public void pitch() {
		assert canPitch() : "Precondition failed: canPitch()";

		int newFill = getSymbol().getFill();

		if (MovementBaseSymbol.SURFACE_SYMBOLS
				.equals(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()))) {
			newFill = ((getSymbol().getFill()) % 2) + 1;
		} else if (MovementBaseSymbol.SURFACE_BETWEEN
				.equals(MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol()))) {
			newFill = ((getSymbol().getFill()) % 2) + 1;
		}

		setFillAndRotation(newFill, getSymbol().getRotation());
	}

	@Override
	public void mirror() {
		assert canMirror() : "Precondition failed: canMirror()";

		int newRotation = getSymbol().getRotation();
		if ((MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 2) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 2;
			}
		} else if ((MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SQUEEZE_FLICK_ALTERNATING.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRAVEL_SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.TRAVEL_SHAKING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 2) {
				newRotation = 8;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 6;
			} else if (getSymbol().getRotation() == 6) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 7) {
				newRotation = 3;
			} else if (getSymbol().getRotation() == 8) {
				newRotation = 2;
			}
		} else if ((MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()
				.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 2) {
				newRotation = 8;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 6;
			} else if (getSymbol().getRotation() == 6) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 8) {
				newRotation = 2;
			}
		} else if ((MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 1;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
		} else if ((MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 1;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 8;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 6;
			} else if (getSymbol().getRotation() == 6) {
				newRotation = 5;
			} else if (getSymbol().getRotation() == 7) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 8) {
				newRotation = 3;
			}
		} else if ((MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()
				.equals(getBaseSymbol()) && getSymbol().getRotation() < 5)
				|| (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()) && getSymbol().getRotation() < 5)) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 2;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 1;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
		} else if ((MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()
				.equals(getBaseSymbol()))
				|| (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol()))) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 3;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 4;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 1;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 2;
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 6;
			} else if (getSymbol().getRotation() == 6) {
				newRotation = 5;
			} else if (getSymbol().getRotation() == 7) {
				newRotation = 8;
			} else if (getSymbol().getRotation() == 8) {
				newRotation = 7;
			}
		} else if (getSymbol().getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			newRotation += 4;
			if (newRotation > 8) {
				newRotation -= 8;
			}
		} else {
			newRotation += 8;
			if (newRotation > 16) {
				newRotation -= 16;
			}
		}

		setFillAndRotation(getSymbol().getFill(), newRotation);

	}

	@Override
	public void mirrorVertically() {
		assert canMirrorVertically() : "Precondition failed: canMirrorVertically()";

		int newFill = getSymbol().getFill();
		int newRotation = getSymbol().getRotation();

		if (getSymbol().getCategory() == 2 && getSymbol().getGroup() == 7) {
			if (getSymbol().getSymbol() <= 11) {
				newRotation = ((newRotation + 1) % 4) + 1;
			} else if (getSymbol().getSymbol() == 12) {
				if (newRotation == 1) {
					newRotation = 4;
				} else if (newRotation == 2) {
					newRotation = 3;
				} else if (newRotation == 3) {
					newRotation = 2;
				} else if (newRotation == 4) {
					newRotation = 1;
				}
			} else if (getSymbol().getSymbol() <= 15) {
				newRotation = ((newRotation + 1) % 4) + 1;
			} else if (getSymbol().getSymbol() > 15) {
				if (newRotation < 5) {
					newRotation += 12;
				} else if (newRotation < 9) {
					newRotation += 4;
				} else if (newRotation < 13) {
					newRotation -= 4;
				} else if (newRotation >= 13) {
					newRotation -= 12;
				}
			}
		} else if (getSymbol().getCategory() == 2 && getSymbol().getGroup() == 8) {
			if (newRotation == 1) {
				newRotation = 5;
			} else if (newRotation == 2) {
				newRotation = 6;
			} else if (newRotation == 3) {
				newRotation = 4;
			} else if (newRotation == 4) {
				newRotation = 3;
			} else if (newRotation == 5) {
				newRotation = 1;
			} else if (newRotation == 6) {
				newRotation = 2;
			} else if (newRotation == 7) {
				newRotation = 8;
			} else if (newRotation == 8) {
				newRotation = 7;
			}
		} else if (getMaxRotation() == 8) {
			if (newRotation == 1) {
				newRotation = 5;
			} else if (newRotation == 2) {
				newRotation = 4;
			} else if (newRotation == 4) {
				newRotation = 2;
			} else if (newRotation == 5) {
				newRotation = 1;
			} else if (newRotation == 6) {
				newRotation = 8;
			} else if (newRotation == 8) {
				newRotation = 6;
			}
		} else if (getMaxRotation() == 4) {
			if (newRotation == 2) {
				newRotation = 4;
			} else if (newRotation == 4) {
				newRotation = 2;
			}
		} else if (getMaxRotation() == 16) {
			if (newRotation == 1) {
				newRotation = 13;
			} else if (newRotation == 2) {
				newRotation = 14;
			} else if (newRotation == 3) {
				newRotation = 15;
			} else if (newRotation == 4) {
				newRotation = 16;
			} else if (newRotation == 5) {
				newRotation = 9;
			} else if (newRotation == 6) {
				newRotation = 10;
			} else if (newRotation == 7) {
				newRotation = 11;
			} else if (newRotation == 8) {
				newRotation = 12;
			} else if (newRotation == 9) {
				newRotation = 5;
			} else if (newRotation == 10) {
				newRotation = 6;
			} else if (newRotation == 11) {
				newRotation = 7;
			} else if (newRotation == 12) {
				newRotation = 8;
			} else if (newRotation == 13) {
				newRotation = 1;
			} else if (newRotation == 14) {
				newRotation = 2;
			} else if (newRotation == 15) {
				newRotation = 3;
			} else if (newRotation == 16) {
				newRotation = 4;
			}
		} else if (getMaxRotation() == 6) {
			if (newRotation == 1) {
				newRotation = 3;
			} else if (newRotation == 2) {
				newRotation = 4;
			} else if (newRotation == 3) {
				newRotation = 1;
			} else if (newRotation == 4) {
				newRotation = 2;
			} else if (newRotation == 5) {
				newRotation = 6;
			} else if (newRotation == 6) {
				newRotation = 5;
			}
		}
		setFillAndRotation(newFill, newRotation);
	}

	@Override
	public boolean canIncrease() {
		boolean canIncrease = false;
		MovementBaseSymbol movementBaseSymbol = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol());
		if (MovementBaseSymbol.TOUCH_SINGLE.equals(movementBaseSymbol)
				|| (MovementBaseSymbol.TOUCH_MULTIPE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.TOUCH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.GRASP_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.GRASP_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.GRASP_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.STRIKE_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.STRIKE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.STRIKE_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.BRUSH_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.BRUSH_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.BRUSH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.RUB_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.RUB_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.RUB_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.SQUEEZE_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.FLICK_LARGE_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FLICK_SMALL_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1)
				|| (MovementBaseSymbol.FLICK_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.equals(movementBaseSymbol) && getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() < 4)) {
			canIncrease = true;
		}

		return canIncrease;
	}

	@Override
	public boolean canDecrease() {
		boolean canDecrease = false;
		MovementBaseSymbol movementBaseSymbol = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol());
		if ((MovementBaseSymbol.TOUCH_MULTIPE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TOUCH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2)
				|| (MovementBaseSymbol.GRASP_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.GRASP_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2)
				|| (MovementBaseSymbol.STRIKE_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.STRIKE_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2)
				|| (MovementBaseSymbol.BRUSH_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.BRUSH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2)
				|| (MovementBaseSymbol.RUB_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.RUB_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2)
				|| (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.SQUEEZE_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() > 1
						&& getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FLICK_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() > 1
						&& getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1 && getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1 && getSymbol().getFill() < 5)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1)
				|| (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1)
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1 && getSymbol().getFill() != 3)
				|| (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
						&& getSymbol().getFill() > 1 && getSymbol().getFill() != 3)
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.LOOP_WALL_PLANE_SMALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.equals(movementBaseSymbol))
				|| (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.equals(movementBaseSymbol))) {
			canDecrease = true;
		}

		return canDecrease;
	}

	@Override
	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";
		MovementBaseSymbol movementBaseSymbol = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol());

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (MovementBaseSymbol.TOUCH_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TOUCH_MULTIPE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.TOUCH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.GRASP_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 1, 5, 1, 1, 1, 22, 10));
		} else if (MovementBaseSymbol.GRASP_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.GRASP_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.STRIKE_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 1, 8, 1, 1, 1, 28, 13));
		} else if (MovementBaseSymbol.STRIKE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.STRIKE_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.BRUSH_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 1, 11, 1, 1, 1, 26, 12));
		} else if (MovementBaseSymbol.BRUSH_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.BRUSH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.RUB_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 1, 14, 1, 1, 1, 28, 14));
		} else if (MovementBaseSymbol.RUB_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.RUB_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 2, 2, 1, 1, 1, 18, 8));
		} else if (MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 2, 2, 2, 1, 1, 14, 6));
		} else if (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());

		} else if (MovementBaseSymbol.SQUEEZE_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.FLICK_LARGE_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 2, 5, 1, 1, 1, 18, 8));
		} else if (MovementBaseSymbol.FLICK_SMALL_SINGLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setSymbol(new Symbol(2, 2, 5, 2, 1, 1, 14, 6));
		} else if (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.equals(movementBaseSymbol) && getSymbol().getFill() == 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(2, getSymbol().getRotation());
		} else if (MovementBaseSymbol.FLICK_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(5, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(5, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(4, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(4, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(5, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 1) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 2) {
				setFillAndRotation(4, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(5, getSymbol().getRotation());
			}
		} else if ((MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.equals(movementBaseSymbol) && getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.equals(movementBaseSymbol))) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.equals(movementBaseSymbol))) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.equals(movementBaseSymbol))) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if ((MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() < 4)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		}

	}

	@Override
	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";
		MovementBaseSymbol movementBaseSymbol = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol());

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if ((MovementBaseSymbol.TOUCH_MULTIPE.equals(movementBaseSymbol))) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.TOUCH_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 1, 1, 1, 1, 1, 10, 11));
			}
		} else if (MovementBaseSymbol.TOUCH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.GRASP_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.GRASP_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 1, 4, 1, 1, 1, 10, 10));
			}
		} else if (MovementBaseSymbol.GRASP_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.STRIKE_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.STRIKE_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 1, 7, 1, 1, 1, 13, 13));
			}
		} else if (MovementBaseSymbol.STRIKE_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.BRUSH_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.BRUSH_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 1, 10, 1, 1, 1, 12, 12));
			}
		} else if (MovementBaseSymbol.BRUSH_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.RUB_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.RUB_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 1, 13, 1, 1, 1, 13, 14));
			}
		} else if (MovementBaseSymbol.RUB_BETWEEN.equals(movementBaseSymbol) && getSymbol().getFill() == 2) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());

			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 2, 1, 1, 1, 1, 8, 8));
			}

		} else if (MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());

			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 2, 1, 2, 1, 1, 6, 6));
			}

		} else if (MovementBaseSymbol.SQUEEZE_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() > 1
				&& getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}
		} else if (MovementBaseSymbol.FLICK_LARGE_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.FLICK_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 2, 4, 1, 1, 1, 8, 8));
			}
		} else if (MovementBaseSymbol.FLICK_SMALL_MULTIPLE.equals(movementBaseSymbol)) {
			if (getSymbol().getFill() == 2) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setFillAndRotation(1, getSymbol().getRotation());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.FLICK_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());

				validVariations.clear();
				validVariations.addAll(allVariations);
				setSymbol(new Symbol(2, 2, 4, 2, 1, 1, 6, 6));
			}
		} else if (MovementBaseSymbol.FLICK_SEQUENTIAL.equals(movementBaseSymbol) && getSymbol().getFill() > 1
				&& getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			}
			if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			}

			if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 5) {
				setFillAndRotation(4, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 5) {
				setFillAndRotation(4, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1 && getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1 && getSymbol().getFill() < 5) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 3) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 3 || getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 5) {
				setFillAndRotation(3, getSymbol().getRotation());
			}

		} else if (MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)
				&& getSymbol().getFill() > 1) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			if (getSymbol().getFill() == 3 || getSymbol().getFill() == 2) {
				setFillAndRotation(1, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 4) {
				setFillAndRotation(2, getSymbol().getRotation());
			} else if (getSymbol().getFill() == 5) {
				setFillAndRotation(3, getSymbol().getRotation());
			}
		}

		else if (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.LOOP_WALL_PLANE_SMALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.equals(movementBaseSymbol)) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		}
	}

	@Override
	public boolean canSwitchArrowHead() {

		boolean result = true;

		if (getBaseSymbol().getGroup() == 1 || getBaseSymbol().getGroup() == 2
				|| getBaseSymbol().equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			result = false;
		}

		return result;
	}

	@Override
	public void switchArrowHead() {
		assert canSwitchArrowHead() : "Precondition failed: canSwitchArrowHead()";

		int newFill = (getSymbol().getFill() % 3) + 1;

		if ((getSymbol().getFill() > 3) && (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())
						&& getSymbol().getFill() > 3)
				|| (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())
						&& getSymbol().getFill() > 3)
				|| (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())
						&& getSymbol().getFill() > 3)
				|| (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())
						&& getSymbol().getFill() > 3))) {
			newFill += 3;
		}

		setFillAndRotation(newFill, getSymbol().getRotation());

	}

	@Override
	public boolean canSwitchToAlternatingArrows() {
		boolean result = false;

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			result = true;
		} else if ((getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 2 || getSymbol().getFill() == 4)) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canSwitchToNormalArrows() {
		boolean result = false;

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			result = true;
		} else if ((getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 3 || getSymbol().getFill() == 5)) {
			result = true;
		}

		return result;
	}

	public boolean canSwitchSize() {
		boolean result = false;

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canSwitchStartingPoint() {
		boolean result = false;

		if (getBaseSymbol().equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW
						.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canSwitchPlane() {

		boolean result = false;

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol()
						.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public void switchStartingPoint() {
		assert canSwitchStartingPoint();

		int newFill = getSymbol().getFill();

		if (getSymbol().getFill() > 3) {
			newFill -= 3;
		} else {
			newFill += 3;
		}

		setFillAndRotation(newFill, getSymbol().getRotation());
	}

	@Override
	public void switchToAlternatingArrows() {
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol()
							.getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW.getIswaSymbol()
							.getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			setFillAndRotation(getSymbol().getFill() + 1, getSymbol().getRotation());
		}

	}

	@Override
	public void switchToNormalArrows() {
		List<Symbol> allVariations = new ArrayList<Symbol>();

		int rotation = getSymbol().getRotation();
		if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 5;
			} else if (rotation == 10) {
				rotation = 4;
			} else if (rotation == 11) {
				rotation = 3;
			} else if (rotation == 12) {
				rotation = 2;
			} else if (rotation == 13) {
				rotation = 1;
			} else if (rotation == 14) {
				rotation = 8;
			} else if (rotation == 15) {
				rotation = 7;
			} else if (rotation == 16) {
				rotation = 6;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW
				.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol().equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW
				.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		}

		else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 5;
			} else if (rotation == 10) {
				rotation = 4;
			} else if (rotation == 11) {
				rotation = 3;
			} else if (rotation == 12) {
				rotation = 2;
			} else if (rotation == 13) {
				rotation = 1;
			} else if (rotation == 14) {
				rotation = 8;
			} else if (rotation == 15) {
				rotation = 7;
			} else if (rotation == 16) {
				rotation = 6;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			if (rotation == 9) {
				rotation = 1;
			} else if (rotation == 10) {
				rotation = 8;
			} else if (rotation == 11) {
				rotation = 7;
			} else if (rotation == 12) {
				rotation = 6;
			} else if (rotation == 13) {
				rotation = 5;
			} else if (rotation == 14) {
				rotation = 4;
			} else if (rotation == 15) {
				rotation = 3;
			} else if (rotation == 16) {
				rotation = 2;
			}

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);

		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);

		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol());

			validVariations.clear();
			validVariations.addAll(allVariations);
			setFillAndRotation(getSymbol().getFill(), rotation);

		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getBaseSymbol().equals(
						MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			setFillAndRotation(getSymbol().getFill() - 1, getSymbol().getRotation());
		}
	}

	public void switchSize() {
		List<Symbol> allVariations = new ArrayList<Symbol>();
		int newFill = getSymbol().getFill();

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BLEND_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BLEND_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BLEND_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BLEND_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CORNER_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CORNER_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CORNER_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CHECK_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CHECK_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CHECK_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CHECK_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.PEAKS_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CORNER_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.BOX_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.PEAKS_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() <= 3) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol());
				newFill += 3;
			} else {
				allVariations = new ArrayList<Symbol>(validVariations);
				newFill -= 3;
			}
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() <= 3) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol());
				newFill += 3;
			} else {
				allVariations = new ArrayList<Symbol>(validVariations);
				newFill -= 3;
			}
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() <= 3) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol());
				newFill += 3;
			} else {
				allVariations = new ArrayList<Symbol>(validVariations);
				newFill -= 3;
			}
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getFill() <= 3) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol());
				newFill += 3;
			} else {
				allVariations = new ArrayList<Symbol>(validVariations);
				newFill -= 3;
			}
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol());
		}

		validVariations.clear();
		validVariations.addAll(allVariations);
		setFillAndRotation(newFill, getSymbol().getRotation());
	}

	@Override
	public void switchPlane() {

		List<Symbol> allVariations = new ArrayList<Symbol>();
		int newFill = getSymbol().getFill();
		int newRotation = getSymbol().getRotation();

		if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 3 || getSymbol().getRotation() == 7) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 3 || getSymbol().getRotation() == 7) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 3 || getSymbol().getRotation() == 7) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 3 || getSymbol().getRotation() == 7) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol()
								.getBaseSymbol());
			} else {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 9) {
				newRotation = 2;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 13) {
				newRotation = 3;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 4;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else {
				newRotation -= 2;
				if (getSymbol().getRotation() < 9 && newRotation <= 0) {
					newRotation += 8;
				} else if (getSymbol().getRotation() >= 9 && newRotation <= 8) {
					newRotation += 8;
				}
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 9) {
				newRotation = 2;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 13) {
				newRotation = 3;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 4;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else {
				newRotation -= 2;
				if (getSymbol().getRotation() < 9 && newRotation <= 0) {
					newRotation += 8;
				} else if (getSymbol().getRotation() >= 9 && newRotation <= 8) {
					newRotation += 8;
				}
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 9) {
				newRotation = 2;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 13) {
				newRotation = 3;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 4;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else {
				newRotation -= 2;
				if (getSymbol().getRotation() < 9 && newRotation <= 0) {
					newRotation += 8;
				} else if (getSymbol().getRotation() >= 9 && newRotation <= 8) {
					newRotation += 8;
				}
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol()
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 9) {
				newRotation = 2;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 13) {
				newRotation = 3;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else if (getSymbol().getRotation() == 5) {
				newRotation = 4;
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol());
			} else {
				newRotation -= 2;
				if (getSymbol().getRotation() < 9 && newRotation <= 0) {
					newRotation += 8;
				} else if (getSymbol().getRotation() >= 9 && newRotation <= 8) {
					newRotation += 8;
				}
				allVariations = getAllVariationsForBaseSymbol(
						MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
			}
		} else if (getBaseSymbol().equals(MovementBaseSymbol.SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 15;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 11;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 15;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 11;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 15;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 11;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			if (getSymbol().getRotation() == 1) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 2) {
				newRotation = 15;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 11;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 3;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			newRotation += 1;
			newRotation = newRotation % 8 + 1;
			if (getSymbol().getRotation() >= 9) {
				newRotation += 8;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			newRotation += 1;
			newRotation = newRotation % 8 + 1;
			if (getSymbol().getRotation() >= 9) {
				newRotation += 8;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			newRotation += 1;
			newRotation = newRotation % 8 + 1;
			if (getSymbol().getRotation() >= 9) {
				newRotation += 8;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			newRotation += 1;
			newRotation = newRotation % 8 + 1;
			if (getSymbol().getRotation() >= 9) {
				newRotation += 8;
			}
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol());
		} else if (getBaseSymbol().equals(MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations = getAllVariationsForBaseSymbol(
					MovementBaseSymbol.SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol());
		}

		validVariations.clear();
		validVariations.addAll(allVariations);
		if (!isValidRotation(newRotation) || !isValidFill(newFill)) {
			setFillAndRotation(getSymbol().getFill(), getSymbol().getRotation());
		}
		setFillAndRotation(newFill, newRotation);
	}

	private static List<Symbol> getAllVariationsForBaseSymbol(BaseSymbol baseSymbol) {
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 1) {
			allVariations = getAllVariationsForBaseSymbolWithGroup1(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 2) {
			allVariations = getAllVariationsForBaseSymbolWithGroup2(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 3) {
			allVariations = getAllVariationsForBaseSymbolWithGroup3(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 4) {
			allVariations = getAllVariationsForBaseSymbolWithGroup4(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 5) {
			allVariations = getAllVariationsForBaseSymbolWithGroup5(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 6) {
			allVariations = getAllVariationsForBaseSymbolWithGroup6(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 7) {
			allVariations = getAllVariationsForBaseSymbolWithGroup7(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 8) {
			allVariations = getAllVariationsForBaseSymbolWithGroup8(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 9) {
			allVariations = getAllVariationsForBaseSymbolWithGroup9(baseSymbol);
		} else if (baseSymbol.getCategory() == 2 && baseSymbol.getGroup() == 10) {
			allVariations = getAllVariationsForBaseSymbolWithGroup10(baseSymbol);
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup3(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 3 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==3";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 2, 10, 11));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 1, 7, 8));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 8, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 6, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 7, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 1, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 8, 14, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 2, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 3, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 2, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 4, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 5, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 3, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 6, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 4, 14, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 1, 7, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 5, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 3, 1, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 7, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 8, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 7, 8, 7));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 5, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 8, 11, 10));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 6, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 5, 7, 8));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 3, 15, 13));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 6, 10, 11));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 4, 13, 14));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 3, 8, 7));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 1, 13, 15));
			allVariations.add(new Symbol(2, 3, 1, 1, 4, 4, 11, 10));
			allVariations.add(new Symbol(2, 3, 1, 1, 2, 2, 13, 14));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 7, 22, 8));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 6, 21, 21));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 3, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 2, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 8, 21, 21));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 3, 22, 8));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 4, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 2, 21, 21));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 7, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 5, 8, 22));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 6, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 4, 21, 21));
			allVariations.add(new Symbol(2, 3, 1, 2, 2, 8, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 4, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 3, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 2, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 8, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 7, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 7, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 6, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 8, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 3, 5, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 6, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 3, 30, 16));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 4, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 3, 1, 2, 1, 2, 24, 24));
			allVariations.add(new Symbol(2, 3, 1, 2, 4, 1, 8, 22));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 3, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 5, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 1, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 2, 29, 29));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 1, 8, 34));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 4, 29, 29));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 3, 34, 8));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 6, 29, 29));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 7, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 5, 8, 34));
			allVariations.add(new Symbol(2, 3, 1, 3, 2, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 8, 29, 29));
			allVariations.add(new Symbol(2, 3, 1, 3, 4, 7, 34, 8));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 7, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 1, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 5, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 5, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 3, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 3, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 1, 16, 42));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 3, 1, 7, 42, 16));
			allVariations.add(new Symbol(2, 3, 1, 3, 3, 8, 33, 33));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 6, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 7, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 8, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 5, 8, 42));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 7, 42, 8));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 2, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 3, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 1, 8, 42));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 4, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 1, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 4, 3, 42, 8));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 2, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 4, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 3, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 6, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 8, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 1, 7, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 7, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 8, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 2, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 6, 37, 37));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 3, 50, 16));
			allVariations.add(new Symbol(2, 3, 1, 4, 3, 4, 37, 37));
		} else if (baseSymbol.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 7, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 5, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 3, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 2, 1, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 1, 17, 2));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 2, 12, 12));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 3, 2, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 4, 12, 12));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 5, 17, 2));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 6, 12, 12));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 7, 2, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 4, 8, 12, 12));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 5, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 7, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 6, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 7, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 6, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 8, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 8, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 3, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 2, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 5, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 4, 19, 19));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 1, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 3, 18, 17));
			allVariations.add(new Symbol(2, 3, 1, 5, 3, 1, 17, 18));
			allVariations.add(new Symbol(2, 3, 1, 5, 1, 2, 19, 19));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 1, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 2, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 1, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 4, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 6, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 3, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 5, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 8, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 6, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 7, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 8, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 5, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 6, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 7, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 8, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 2, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 5, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 3, 7, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 4, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 1, 25, 14));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 4, 21, 21));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 3, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 1, 3, 14, 25));
			allVariations.add(new Symbol(2, 3, 2, 1, 2, 2, 21, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 7, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 5, 25, 18));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 7, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 7, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 8, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 5, 25, 18));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 8, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 3, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 1, 25, 18));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 3, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 5, 25, 18));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 3, 18, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 2, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 1, 25, 18));
			allVariations.add(new Symbol(2, 3, 2, 2, 1, 8, 26, 25));
			allVariations.add(new Symbol(2, 3, 2, 2, 3, 1, 25, 18));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 1, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 3, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 2, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 1, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 5, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 6, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 3, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 4, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 9, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 10, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 7, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 8, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 13, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 14, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 11, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 12, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 15, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 16, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 1, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 2, 2, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 15, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 4, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 14, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 5, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 6, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 16, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 7, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 11, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 8, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 10, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 9, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 13, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 10, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 12, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 11, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 7, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 12, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 6, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 13, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 9, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 14, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 8, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 15, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 3, 17, 26));
			allVariations.add(new Symbol(2, 3, 3, 1, 3, 16, 21, 20));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 2, 20, 21));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 5, 26, 17));
			allVariations.add(new Symbol(2, 3, 3, 1, 1, 4, 21, 20));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 1, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 2, 26, 29));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 9, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 8, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 7, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 6, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 5, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 4, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 3, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 2, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 16, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 15, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 14, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 13, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 12, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 11, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 10, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 2, 1, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 8, 29, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 2, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 1, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 7, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 10, 26, 29));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 4, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 3, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 9, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 6, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 4, 29, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 5, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 3, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 8, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 6, 26, 29));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 7, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 5, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 16, 29, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 10, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 15, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 9, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 12, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 11, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 12, 29, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 14, 27, 28));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 11, 20, 26));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 13, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 14, 26, 29));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 16, 28, 27));
			allVariations.add(new Symbol(2, 3, 3, 2, 3, 13, 26, 20));
			allVariations.add(new Symbol(2, 3, 3, 2, 1, 15, 20, 26));
		} else if (baseSymbol.equals(MovementBaseSymbol.CROSS_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 1, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 3, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 1, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 15, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 13, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 7, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 5, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 11, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 9, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 11, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 9, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 7, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 1, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 5, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 2, 3, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 15, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 13, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 3, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 11, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 13, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 15, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 3, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 5, 30, 26));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 7, 26, 30));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 4, 1, 1, 9, 30, 26));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 3, 14, 37));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 2, 29, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 1, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 2, 30, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 1, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 1, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 4, 29, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 3, 14, 37));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 5, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 4, 29, 30));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 3, 14, 37));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 2, 30, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 8, 29, 30));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 7, 14, 37));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 6, 30, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 7, 14, 37));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 8, 29, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 3, 8, 29, 30));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 5, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 2, 6, 29, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 4, 29, 30));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 5, 37, 14));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 6, 30, 29));
			allVariations.add(new Symbol(2, 3, 5, 1, 1, 7, 14, 37));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 6, 34, 33));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 4, 32, 33));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 5, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 3, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 4, 33, 34));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 2, 33, 32));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 1, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 3, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 8, 33, 34));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 7, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 8, 33, 34));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 2, 34, 33));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 6, 34, 33));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 5, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 3, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 7, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 6, 33, 32));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 4, 33, 34));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 7, 18, 37));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 1, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 1, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 2, 5, 37, 18));
			allVariations.add(new Symbol(2, 3, 5, 2, 3, 8, 32, 33));
			allVariations.add(new Symbol(2, 3, 5, 2, 1, 2, 34, 33));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 16, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 15, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 16, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 15, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 14, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 13, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 10, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 12, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 11, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 9, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 10, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 8, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 9, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 7, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 14, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 8, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 13, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 7, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 12, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 6, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 11, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 5, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 4, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 5, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 2, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 3, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 1, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 15, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 14, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 16, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 11, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 10, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 13, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 12, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 7, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 6, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 9, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 2, 8, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 3, 17, 39));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 4, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 5, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 6, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 1, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 3, 2, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 2, 30, 29));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 1, 39, 17));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 4, 29, 30));
			allVariations.add(new Symbol(2, 3, 6, 1, 1, 3, 17, 39));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPPLE_ALTERNATING_WRIST_FLEX_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 4, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 3, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 2, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 1, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 14, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 13, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 15, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 12, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 12, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 11, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 13, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 10, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 9, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 8, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 7, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 16, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 6, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 6, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 7, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 4, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 5, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 10, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 11, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 16, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 8, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 15, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 9, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 14, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 1, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 3, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 1, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 1, 2, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 3, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 2, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 5, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 3, 4, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 13, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 14, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 15, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 16, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 5, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 6, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 7, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 8, 36, 35));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 9, 39, 21));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 10, 35, 36));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 11, 21, 39));
			allVariations.add(new Symbol(2, 3, 6, 2, 2, 12, 36, 35));
		} else if (baseSymbol.equals(MovementBaseSymbol.BLEND_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 10, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 9, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 8, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 7, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 14, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 13, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 12, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 11, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 16, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 15, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 2, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 3, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 1, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 6, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 7, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 4, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 5, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 9, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 8, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 11, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 10, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 13, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 12, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 15, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 14, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 3, 16, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 1, 14, 18));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 2, 20, 12));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 3, 18, 14));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 4, 12, 20));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 5, 14, 18));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 6, 20, 12));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 7, 18, 14));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 8, 12, 20));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 16, 12, 20));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 2, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 15, 18, 14));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 1, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 14, 20, 12));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 13, 14, 18));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 12, 12, 20));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 6, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 11, 18, 14));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 5, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 10, 20, 12));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 4, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 4, 9, 14, 18));
			allVariations.add(new Symbol(2, 3, 7, 1, 2, 3, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 16, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 14, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 15, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 8, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 9, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 6, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 7, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 12, 16, 23));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 13, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 10, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 11, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 1, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 3, 25, 17));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 2, 23, 16));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 5, 17, 25));
			allVariations.add(new Symbol(2, 3, 7, 1, 1, 4, 16, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.BLEND_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 3, 22, 16));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 2, 25, 15));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 1, 16, 22));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 7, 22, 16));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 6, 25, 15));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 5, 16, 22));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 4, 15, 25));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 9, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 10, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 7, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 8, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 13, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 14, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 11, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 12, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 15, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 16, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 2, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 1, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 4, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 3, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 6, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 3, 5, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 6, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 7, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 8, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 9, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 10, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 11, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 12, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 13, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 14, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 15, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 16, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 16, 15, 25));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 11, 22, 16));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 5, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 10, 25, 15));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 4, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 9, 16, 22));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 3, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 2, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 8, 15, 25));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 15, 22, 16));
			allVariations.add(new Symbol(2, 3, 7, 2, 2, 1, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 14, 25, 15));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 13, 16, 22));
			allVariations.add(new Symbol(2, 3, 7, 2, 4, 12, 15, 25));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 11, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 12, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 9, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 10, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 7, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 8, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 5, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 6, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 15, 30, 20));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 16, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 13, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 14, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 2, 28, 18));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 1, 20, 30));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 4, 18, 28));
			allVariations.add(new Symbol(2, 3, 7, 2, 1, 3, 30, 20));
		} else if (baseSymbol.equals(MovementBaseSymbol.BLEND_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 16, 18, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 15, 34, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 10, 34, 18));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 9, 22, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 8, 18, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 7, 34, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 14, 34, 18));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 13, 22, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 12, 18, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 11, 34, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 3, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 2, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 1, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 4, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 5, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 6, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 7, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 8, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 9, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 10, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 11, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 12, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 13, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 14, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 15, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 1, 16, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 2, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 1, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 4, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 3, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 16, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 15, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 14, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 13, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 12, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 11, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 10, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 9, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 8, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 7, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 6, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 2, 5, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 4, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 5, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 2, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 3, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 1, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 15, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 14, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 16, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 11, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 10, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 13, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 12, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 7, 42, 26));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 6, 38, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 9, 26, 42));
			allVariations.add(new Symbol(2, 3, 7, 3, 3, 8, 22, 38));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 3, 34, 22));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 4, 18, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 5, 22, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 6, 34, 18));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 1, 22, 34));
			allVariations.add(new Symbol(2, 3, 7, 3, 4, 2, 34, 18));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 4, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 5, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 6, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 7, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 1, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 2, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 3, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 12, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 11, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 14, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 13, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 8, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 7, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 10, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 9, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 16, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 15, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 7, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 8, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 5, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 6, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 3, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 4, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 1, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 2, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 15, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 14, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 13, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 12, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 11, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 10, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 9, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 8, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 2, 16, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 3, 14, 16));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 2, 21, 17));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 5, 16, 14));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 4, 17, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 7, 14, 16));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 6, 21, 17));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 9, 16, 14));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 8, 17, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 1, 16, 14));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 9, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 10, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 11, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 12, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 13, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 14, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 15, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 3, 16, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 1, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 2, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 5, 19, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 6, 24, 18));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 3, 21, 19));
			allVariations.add(new Symbol(2, 3, 8, 1, 1, 4, 18, 24));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 12, 17, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 13, 16, 14));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 10, 21, 17));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 11, 14, 16));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 16, 17, 21));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 14, 21, 17));
			allVariations.add(new Symbol(2, 3, 8, 1, 4, 15, 14, 16));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 15, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 16, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 9, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 10, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 7, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 8, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 13, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 14, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 11, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 12, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 3, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 2, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 1, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 7, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 6, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 5, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 4, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 14, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 15, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 16, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 6, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 7, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 8, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 9, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 10, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 11, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 12, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 13, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 2, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 1, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 4, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 3, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 6, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 2, 5, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 15, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 16, 19, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 13, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 14, 27, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 11, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 12, 19, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 9, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 10, 27, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 16, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 12, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 13, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 14, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 15, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 1, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 8, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 2, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 9, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 3, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 10, 30, 22));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 4, 22, 30));
			allVariations.add(new Symbol(2, 3, 8, 2, 3, 11, 27, 23));
			allVariations.add(new Symbol(2, 3, 8, 2, 1, 5, 23, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 6, 27, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 5, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 8, 19, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 7, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 2, 27, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 1, 19, 19));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 4, 19, 27));
			allVariations.add(new Symbol(2, 3, 8, 2, 4, 3, 19, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 1, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 4, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 5, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 2, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 3, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 16, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 15, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 14, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 13, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 8, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 7, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 6, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 5, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 12, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 11, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 10, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 9, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 1, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 2, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 3, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 4, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 5, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 6, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 15, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 14, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 16, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 7, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 6, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 9, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 8, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 11, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 10, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 13, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 2, 12, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 10, 35, 22));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 11, 26, 23));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 8, 22, 35));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 9, 23, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 14, 35, 22));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 15, 26, 23));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 12, 22, 35));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 13, 23, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 16, 22, 35));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 7, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 1, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 8, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 2, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 9, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 3, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 10, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 1, 4, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 11, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 12, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 13, 27, 34));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 14, 38, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 15, 34, 27));
			allVariations.add(new Symbol(2, 3, 8, 3, 3, 16, 26, 38));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 1, 23, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 3, 26, 23));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 2, 35, 22));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 5, 23, 26));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 4, 22, 35));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 7, 26, 23));
			allVariations.add(new Symbol(2, 3, 8, 3, 4, 6, 35, 22));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CORNER_WALL_PLANE_WITH_ROTATION.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 11, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 10, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 9, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 8, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 7, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 6, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 5, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 4, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 16, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 15, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 14, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 13, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 12, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 3, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 4, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 1, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 2, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 10, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 9, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 12, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 11, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 6, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 5, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 8, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 7, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 14, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 13, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 16, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 2, 15, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 2, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 3, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 4, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 5, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 1, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 9, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 8, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 7, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 6, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 13, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 12, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 11, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 10, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 16, 26, 36));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 15, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 3, 14, 36, 26));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 1, 28, 25));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 2, 33, 23));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 5, 28, 25));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 6, 33, 23));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 3, 25, 28));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 4, 23, 33));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 8, 23, 33));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 7, 25, 28));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 10, 33, 23));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 9, 28, 25));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 12, 23, 33));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 11, 25, 28));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 14, 33, 23));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 13, 28, 25));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 16, 23, 33));
			allVariations.add(new Symbol(2, 3, 8, 4, 4, 15, 25, 28));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 1, 30, 32));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 3, 32, 30));
			allVariations.add(new Symbol(2, 3, 8, 4, 1, 2, 36, 26));
		} else if (baseSymbol.equals(MovementBaseSymbol.CHECK_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 14, 18, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 1, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 13, 18, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 12, 23, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 3, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 11, 21, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 2, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 5, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 4, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 16, 23, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 7, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 15, 21, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 6, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 16, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 10, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 11, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 8, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 9, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 14, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 15, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 12, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 1, 13, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 4, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 3, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 2, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 1, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 8, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 7, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 6, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 5, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 13, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 14, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 15, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 16, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 9, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 10, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 11, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 2, 12, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 7, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 6, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 9, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 8, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 3, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 2, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 5, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 4, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 1, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 16, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 14, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 15, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 12, 23, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 13, 21, 28));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 10, 21, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 3, 11, 28, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 10, 18, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 9, 18, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 8, 23, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 7, 21, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 6, 18, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 5, 18, 21));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 4, 23, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 3, 21, 18));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 2, 18, 23));
			allVariations.add(new Symbol(2, 3, 9, 1, 4, 1, 18, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.CHECK_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 14, 21, 27));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 15, 26, 22));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 16, 27, 21));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 10, 21, 27));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 11, 26, 22));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 12, 27, 21));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 13, 22, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 3, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 4, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 5, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 6, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 1, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 2, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 16, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 15, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 14, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 13, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 12, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 11, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 10, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 9, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 8, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 1, 7, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 6, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 7, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 4, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 5, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 2, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 3, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 1, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 8, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 9, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 10, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 11, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 12, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 13, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 14, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 15, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 2, 16, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 2, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 1, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 4, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 3, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 6, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 5, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 8, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 7, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 11, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 12, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 9, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 10, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 15, 34, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 16, 28, 25));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 13, 26, 34));
			allVariations.add(new Symbol(2, 3, 9, 2, 3, 14, 25, 28));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 1, 22, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 5, 22, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 4, 27, 21));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 3, 26, 22));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 2, 21, 27));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 9, 22, 26));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 8, 27, 21));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 7, 26, 22));
			allVariations.add(new Symbol(2, 3, 9, 2, 4, 6, 21, 27));
		} else if (baseSymbol.equals(MovementBaseSymbol.CHECK_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 1, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 2, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 3, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 4, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 5, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 9, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 10, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 11, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 12, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 13, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 14, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 15, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 16, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 1, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 2, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 5, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 6, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 3, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 4, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 9, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 8, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 7, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 6, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 13, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 12, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 11, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 10, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 16, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 15, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 1, 14, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 4, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 5, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 6, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 7, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 1, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 2, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 3, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 12, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 11, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 14, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 13, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 8, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 7, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 10, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 9, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 16, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 2, 15, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 7, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 8, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 5, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 6, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 3, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 4, 31, 24));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 1, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 4, 2, 24, 31));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 15, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 14, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 13, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 12, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 11, 39, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 10, 28, 32));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 9, 28, 39));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 8, 32, 28));
			allVariations.add(new Symbol(2, 3, 9, 3, 3, 16, 32, 28));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 16, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 15, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 14, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 13, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 12, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 11, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 10, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 1, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 2, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 9, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 10, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 7, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 8, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 5, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 6, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 3, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 4, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 14, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 13, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 16, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 15, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 10, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 9, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 12, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 11, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 1, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 6, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 7, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 8, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 9, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 2, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 3, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 4, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 2, 5, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 2, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 15, 16, 21));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 1, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 14, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 4, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 13, 21, 16));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 3, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 12, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 6, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 5, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 8, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 1, 7, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 16, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 12, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 11, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 14, 28, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 13, 24, 22));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 16, 25, 28));
			allVariations.add(new Symbol(2, 3, 10, 1, 3, 15, 22, 24));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 1, 21, 16));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 2, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 3, 16, 21));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 4, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 5, 21, 16));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 6, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 7, 16, 21));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 8, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 9, 21, 16));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 10, 25, 25));
			allVariations.add(new Symbol(2, 3, 10, 1, 4, 11, 16, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 9, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 10, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 11, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 12, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 13, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 14, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 15, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 16, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 1, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 3, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 2, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 5, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 4, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 7, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 6, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 9, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 8, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 10, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 11, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 8, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 9, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 14, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 15, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 12, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 13, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 16, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 4, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 3, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 2, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 1, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 8, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 7, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 6, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 2, 5, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 5, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 4, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 16, 32, 31));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 7, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 15, 22, 25));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 6, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 14, 31, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 1, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 13, 25, 22));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 12, 32, 31));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 3, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 11, 22, 25));
			allVariations.add(new Symbol(2, 3, 10, 2, 1, 2, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 7, 22, 25));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 8, 32, 31));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 9, 25, 22));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 10, 31, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 3, 22, 25));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 4, 32, 31));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 5, 25, 22));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 6, 31, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 1, 25, 22));
			allVariations.add(new Symbol(2, 3, 10, 2, 4, 2, 31, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 15, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 14, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 16, 32, 34));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 11, 27, 29));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 10, 34, 32));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 13, 29, 27));
			allVariations.add(new Symbol(2, 3, 10, 2, 3, 12, 32, 34));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 13, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 15, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 9, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 11, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 5, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 7, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 1, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 3, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 15, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 13, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 11, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 9, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 7, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 7, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 5, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 3, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 2, 1, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 10, 36, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 11, 26, 29));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 12, 35, 36));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 13, 29, 26));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 14, 36, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 15, 26, 29));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 16, 37, 36));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 1, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 3, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 5, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 1, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 11, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 9, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 15, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 13, 33, 33));
			allVariations.add(new Symbol(2, 3, 10, 3, 3, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 5, 29, 26));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 4, 35, 36));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 3, 26, 29));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 2, 36, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 9, 29, 26));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 8, 35, 36));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 7, 26, 29));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 6, 36, 35));
			allVariations.add(new Symbol(2, 3, 10, 3, 4, 1, 29, 26));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 1, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 3, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 2, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 5, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 4, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 7, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 6, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 9, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 8, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 14, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 13, 15, 24));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 16, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 15, 24, 15));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 2, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 1, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 6, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 5, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 4, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 3, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 10, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 9, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 8, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 7, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 12, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 13, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 10, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 11, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 16, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 14, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 1, 15, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 8, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 9, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 10, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 11, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 4, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 5, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 6, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 7, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 1, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 2, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 3, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 16, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 15, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 12, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 11, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 14, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 2, 13, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 11, 24, 15));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 12, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 9, 15, 24));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 10, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 7, 24, 15));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 8, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 5, 15, 24));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 6, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 3, 24, 15));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 4, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 1, 15, 24));
			allVariations.add(new Symbol(2, 3, 11, 1, 4, 2, 26, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 16, 26, 29));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 15, 31, 18));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 14, 29, 26));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 13, 18, 31));
			allVariations.add(new Symbol(2, 3, 11, 1, 3, 12, 26, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 6, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 5, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 8, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 7, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 2, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 1, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 4, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 3, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 16, 32, 33));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 13, 20, 31));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 12, 32, 33));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 15, 31, 20));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 14, 33, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 9, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 8, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 7, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 6, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 5, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 4, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 3, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 2, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 1, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 15, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 16, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 13, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 14, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 11, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 12, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 9, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 1, 10, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 4, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 3, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 6, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 5, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 8, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 7, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 10, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 9, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 2, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 1, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 10, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 11, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 12, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 13, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 14, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 15, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 2, 16, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 7, 31, 20));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 6, 33, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 5, 20, 31));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 4, 32, 33));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 11, 31, 20));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 10, 33, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 9, 20, 31));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 8, 32, 33));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 3, 31, 20));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 2, 33, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 4, 1, 20, 31));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 13, 24, 39));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 14, 37, 32));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 11, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 12, 32, 37));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 15, 39, 24));
			allVariations.add(new Symbol(2, 3, 11, 2, 3, 16, 32, 37));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 1, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 3, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 5, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 7, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 9, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 11, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 13, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 15, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 3, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 12, 35, 36));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 11, 35, 22));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 1, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 14, 36, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 13, 22, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 7, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 16, 35, 36));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 15, 35, 22));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 5, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 1, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 15, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 13, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 11, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 1, 22, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 2, 36, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 9, 22, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 10, 36, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 7, 35, 22));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 8, 35, 36));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 5, 22, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 6, 36, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 3, 35, 22));
			allVariations.add(new Symbol(2, 3, 11, 3, 4, 4, 35, 36));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 14, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 13, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 16, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 15, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 10, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 9, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 12, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 2, 11, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 1, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 6, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 7, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 8, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 9, 26, 43));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 2, 40, 35));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 3, 43, 26));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 4, 35, 40));
			allVariations.add(new Symbol(2, 3, 11, 3, 3, 5, 26, 43));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 16, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 15, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 14, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 13, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 12, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 3, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 4, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 1, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 2, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 11, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 12, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 9, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 10, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 7, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 8, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 5, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 6, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 16, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 15, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 12, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 11, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 14, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 13, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 1, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 2, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 3, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 8, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 9, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 10, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 11, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 4, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 5, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 6, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 2, 7, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 16, 18, 17));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 15, 25, 15));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 14, 17, 18));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 1, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 2, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 5, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 6, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 3, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 4, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 9, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 10, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 7, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 1, 8, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 14, 24, 21));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 13, 16, 28));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 16, 21, 24));
			allVariations.add(new Symbol(2, 3, 12, 1, 3, 15, 28, 16));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 2, 17, 18));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 3, 25, 15));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 4, 18, 17));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 5, 15, 25));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 1, 15, 25));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 10, 17, 18));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 11, 25, 15));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 12, 18, 17));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 13, 15, 25));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 6, 17, 18));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 7, 25, 15));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 8, 18, 17));
			allVariations.add(new Symbol(2, 3, 12, 1, 4, 9, 15, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 12, 27, 24));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 11, 32, 18));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 10, 24, 27));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 9, 18, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 8, 27, 24));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 7, 32, 18));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 6, 24, 27));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 5, 18, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 4, 27, 24));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 3, 32, 18));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 2, 24, 27));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 1, 18, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 16, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 14, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 15, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 12, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 13, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 1, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 6, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 7, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 8, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 9, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 2, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 3, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 4, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 5, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 13, 18, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 14, 24, 27));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 15, 32, 18));
			allVariations.add(new Symbol(2, 3, 12, 2, 4, 16, 27, 24));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 6, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 5, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 4, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 3, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 10, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 9, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 8, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 7, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 2, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 1, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 12, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 13, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 10, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 11, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 16, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 14, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 1, 15, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 5, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 4, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 7, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 6, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 9, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 8, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 11, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 10, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 1, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 3, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 3, 2, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 11, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 12, 31, 32));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 13, 19, 36));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 14, 32, 31));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 15, 36, 19));
			allVariations.add(new Symbol(2, 3, 12, 2, 2, 16, 31, 32));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 3, 43, 20));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 2, 30, 34));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 1, 20, 43));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 7, 43, 20));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 6, 30, 34));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 5, 20, 43));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 4, 34, 30));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 11, 43, 20));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 10, 30, 34));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 9, 20, 43));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 8, 34, 30));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 13, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 11, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 12, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 15, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 1, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 3, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 5, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 7, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 8, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 12, 34, 30));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 13, 20, 43));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 14, 30, 34));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 15, 43, 20));
			allVariations.add(new Symbol(2, 3, 12, 3, 4, 16, 34, 30));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 8, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 9, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 7, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 5, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 3, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 1, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 15, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 13, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 12, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 11, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 1, 9, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 7, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 8, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 9, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 3, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 5, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 1, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 3, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 15, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 11, 47, 21));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 13, 21, 47));
			allVariations.add(new Symbol(2, 3, 12, 3, 2, 12, 38, 38));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 15, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 13, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 1, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 5, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 3, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 9, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 7, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 13, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 11, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 15, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 3, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 2, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 1, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 4, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 3, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 6, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 5, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 8, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 7, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 10, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 9, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 12, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 11, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 14, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 13, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 16, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 4, 15, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 14, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 3, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 15, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 12, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 1, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 13, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 10, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 11, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 8, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 9, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 6, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 11, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 7, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 4, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 9, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 5, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 2, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 7, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 3, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 5, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 1, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 13, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 1, 15, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 5, 16, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 2, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 13, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 1, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 14, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 15, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 3, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 16, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 9, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 10, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 11, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 12, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 10, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 5, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 9, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 6, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 7, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 11, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 8, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 1, 22, 28));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 5, 22, 26));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 2, 23, 23));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 3, 28, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 2, 7, 26, 22));
			allVariations.add(new Symbol(2, 3, 13, 1, 6, 4, 23, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 15, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 14, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 16, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 11, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 12, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 13, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 14, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 7, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 8, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 9, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 10, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 3, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 4, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 5, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 6, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 1, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 2, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 7, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 9, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 3, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 5, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 15, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 16, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 11, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 15, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 14, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 13, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 13, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 12, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 13, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 10, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 11, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 8, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 9, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 6, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 7, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 4, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 5, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 2, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 3, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 6, 1, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 2, 1, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 9, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 11, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 13, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 2, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 1, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 15, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 4, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 3, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 1, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 6, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 5, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 3, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 8, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 7, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 5, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 10, 28, 31));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 9, 22, 35));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 7, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 12, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 5, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 1, 11, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 16, 31, 28));
			allVariations.add(new Symbol(2, 3, 14, 1, 3, 15, 35, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 11, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 9, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 15, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 13, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 3, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 1, 22, 38));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 7, 38, 22));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 14, 1, 4, 5, 22, 38));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 10, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 11, 35, 23));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 8, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 9, 23, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 14, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 15, 35, 23));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 12, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 13, 23, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 2, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 3, 35, 23));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 1, 23, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 6, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 7, 35, 23));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 4, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 5, 23, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 16, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 15, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 9, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 11, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 13, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 15, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 1, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 3, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 5, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 7, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 4, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 3, 16, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 15, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 13, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 11, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 9, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 7, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 5, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 3, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 3, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 5, 1, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 2, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 5, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 4, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 1, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 11, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 10, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 13, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 12, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 7, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 6, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 9, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 8, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 15, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 16, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 11, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 16, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 12, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 13, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 14, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 14, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 1, 15, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 7, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 8, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 9, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 10, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 3, 38, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 4, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 5, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 6, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 6, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 5, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 2, 30, 30));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 4, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 6, 1, 24, 38));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 3, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 2, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 1, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 14, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 13, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 12, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 11, 35, 24));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 10, 31, 28));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 9, 24, 35));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 8, 28, 31));
			allVariations.add(new Symbol(2, 3, 15, 1, 2, 7, 35, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 8, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 6, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 4, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 6, 22, 24));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 16, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 14, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 6, 12, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 2, 16, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 14, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 16, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 12, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 6, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 8, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 3, 4, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 4, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 8, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 6, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 12, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 16, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 4, 14, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 4, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 8, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 6, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 8, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 12, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 10, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 14, 22, 24));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 9, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 12, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 1, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 14, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 2, 22, 23));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 13, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 5, 16, 23, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 4, 24, 22));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 5, 21, 30));
			allVariations.add(new Symbol(2, 3, 16, 1, 1, 6, 22, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 6, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 2, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 1, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 5, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 3, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 9, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 5, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 13, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 1, 20, 36));
			allVariations.add(new Symbol(2, 3, 17, 1, 4, 2, 28, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 14, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 16, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 10, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 12, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 6, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 8, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 2, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 4, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 2, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 6, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 16, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 14, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 12, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 10, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 8, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 6, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 4, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 3, 2, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 6, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 8, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 2, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 4, 2, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 4, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 14, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 16, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 10, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 1, 12, 28, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 16, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 14, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 13, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 8, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 6, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 5, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 12, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 10, 28, 29));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 9, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 4, 29, 28));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 1, 22, 36));
			allVariations.add(new Symbol(2, 3, 18, 1, 5, 2, 28, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.TRAVEL_SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 1, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 1, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 1, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 3, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 8, 26, 25));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 5, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 3, 7, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 3, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 5, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 2, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 5, 18, 33));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 3, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 4, 26, 25));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 7, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 6, 25, 26));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 8, 26, 25));
			allVariations.add(new Symbol(2, 3, 19, 1, 2, 7, 33, 18));
			allVariations.add(new Symbol(2, 3, 19, 1, 1, 8, 26, 25));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 9, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 7, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 8, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 10, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 7, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 5, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 8, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 6, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 5, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 11, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 6, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 12, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 9, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 3, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 4, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 10, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 15, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 16, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 15, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 13, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 16, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 14, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 13, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 14, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 11, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 12, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 2, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 1, 1, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 4, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 3, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 2, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 3, 1, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 4, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 5, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 6, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 7, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 8, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 9, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 10, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 11, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 12, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 13, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 14, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 15, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 16, 27, 27));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 1, 25, 35));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 3, 35, 25));
			allVariations.add(new Symbol(2, 3, 20, 1, 2, 2, 27, 27));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 5, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 16, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 3, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 2, 32, 32));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 14, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 9, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 15, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 12, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 7, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 13, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 10, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 13, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 11, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 12, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 11, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 9, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 10, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 7, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 16, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 15, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 5, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 14, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 3, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 3, 1, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 1, 1, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 15, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 16, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 11, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 12, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 13, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 14, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 7, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 8, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 9, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 10, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 3, 42, 25));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 5, 25, 42));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 6, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 2, 33, 33));
			allVariations.add(new Symbol(2, 3, 20, 2, 2, 1, 25, 42));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 1, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 13, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 15, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 12, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 11, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 13, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 12, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 11, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 9, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 15, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 8, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 7, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 5, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 5, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 3, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 3, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 9, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 8, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 1, 1, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 3, 7, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 1, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 11, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 10, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 13, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 12, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 15, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 14, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 16, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 3, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 2, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 5, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 4, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 7, 50, 25));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 6, 38, 38));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 9, 25, 50));
			allVariations.add(new Symbol(2, 3, 20, 3, 2, 8, 38, 38));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup4(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 4 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==4";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 5, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 1, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 1, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 5, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 3, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 4, 12, 12));
			allVariations.add(new Symbol(2, 4, 1, 1, 1, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 6, 12, 12));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 5, 13, 3));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 8, 12, 12));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 1, 13, 15));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 5, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 1, 13, 22));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 5, 13, 15));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 4, 16, 16));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 2, 16, 16));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 8, 16, 16));
			allVariations.add(new Symbol(2, 4, 1, 1, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 1, 1, 4, 6, 16, 16));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 1, 13, 3));
			allVariations.add(new Symbol(2, 4, 1, 1, 5, 2, 12, 12));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 1, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 6, 15, 15));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 8, 15, 15));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 2, 15, 15));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 3, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 4, 15, 15));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 5, 16, 3));
			allVariations.add(new Symbol(2, 4, 1, 2, 5, 1, 16, 3));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 8, 20, 20));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 5, 16, 22));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 6, 20, 20));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 4, 20, 20));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 1, 16, 22));
			allVariations.add(new Symbol(2, 4, 1, 2, 4, 2, 20, 20));
			allVariations.add(new Symbol(2, 4, 1, 2, 2, 4, 24, 24));
		} else if (baseSymbol.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 3, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 1, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 1, 16, 4));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 2, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 4, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 5, 16, 4));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 6, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 3, 5, 8, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 3, 2, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 2, 29, 29));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 1, 16, 34));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 6, 29, 29));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 4, 29, 29));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 5, 16, 34));
			allVariations.add(new Symbol(2, 4, 1, 3, 4, 8, 29, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 4, 4, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 2, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 1, 16, 4));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 2, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 4, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 5, 16, 4));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 6, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 5, 8, 17, 17));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 1, 4, 3, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 1, 4, 1, 2, 37, 37));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 2, 16, 16));
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 1, 10, 15));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 1, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 5, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 1, 5, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 1, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 2, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 1, 3, 1, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 8, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 5, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 4, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 1, 5, 6, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 1, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 8, 16, 16));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 5, 14, 23));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 4, 16, 16));
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 5, 10, 15));
			allVariations.add(new Symbol(2, 4, 2, 1, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 4, 2, 1, 4, 6, 16, 16));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 1, 10, 22));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 8, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 5, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 6, 10, 10));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 4, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 2, 3, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 2, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 2, 5, 1, 9, 9));
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 2, 21, 21));
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 4, 21, 21));
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 5, 10, 22));
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 6, 21, 21));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 4, 8, 21, 21));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 2, 2, 2, 2, 24, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 5, 12, 34));
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 6, 29, 29));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 8, 29, 29));
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 1, 12, 34));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 2, 29, 29));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 4, 4, 29, 29));
			allVariations.add(new Symbol(2, 4, 2, 3, 2, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 1, 11, 11));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 5, 12, 12));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 4, 12, 12));
			allVariations.add(new Symbol(2, 4, 2, 3, 1, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 2, 11, 11));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 8, 13, 13));
			allVariations.add(new Symbol(2, 4, 2, 3, 3, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 3, 5, 6, 13, 13));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 1, 12, 41));
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 5, 12, 41));
			allVariations.add(new Symbol(2, 4, 2, 4, 4, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 2, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 8, 13, 13));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 5, 12, 12));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 6, 13, 13));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 4, 12, 12));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 1, 11, 11));
			allVariations.add(new Symbol(2, 4, 2, 4, 3, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 5, 2, 11, 11));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 2, 4, 1, 8, 37, 37));
		} else if (baseSymbol.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 8, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 5, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 6, 15, 15));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 8, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 6, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 6, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 4, 15, 15));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 8, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 5, 12, 13));
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 4, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 1, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 4, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 5, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 2, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 5, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 2, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 8, 15, 15));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 6, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 1, 4, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 2, 18, 18));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 1, 12, 13));
			allVariations.add(new Symbol(2, 4, 3, 1, 3, 1, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 2, 1, 14, 20));
			allVariations.add(new Symbol(2, 4, 3, 1, 4, 2, 15, 15));
		} else if (baseSymbol.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 8, 23, 23));
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 5, 12, 22));
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 6, 23, 23));
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 4, 23, 23));
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 1, 12, 22));
			allVariations.add(new Symbol(2, 4, 3, 2, 4, 2, 23, 23));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 6, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 2, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 8, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 8, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 6, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 2, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 6, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 4, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 3, 2, 2, 4, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 4, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 3, 2, 27, 27));
			allVariations.add(new Symbol(2, 4, 3, 2, 1, 8, 27, 27));
		} else if (baseSymbol.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 1, 16, 32));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 5, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 8, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 6, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 4, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 1, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 2, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 4, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 1, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 6, 29, 30));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 2, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 1, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 2, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 8, 30, 29));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 8, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 5, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 4, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 2, 29, 30));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 6, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 5, 16, 32));
			allVariations.add(new Symbol(2, 4, 3, 3, 3, 5, 16, 40));
			allVariations.add(new Symbol(2, 4, 3, 3, 2, 6, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 3, 1, 8, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 3, 4, 4, 30, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 8, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 2, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 1, 16, 41));
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 6, 37, 38));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 4, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 6, 33, 34));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 5, 16, 41));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 8, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 8, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 4, 8, 34, 33));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 6, 37, 38));
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 4, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 4, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 6, 37, 38));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 2, 37, 38));
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 4, 38, 37));
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 1, 2, 37, 38));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 3, 4, 2, 2, 37, 38));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 8, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 4, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 8, 13, 13));
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 5, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 5, 8, 12));
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 6, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 6, 13, 13));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 6, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 5, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 2, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 4, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 5, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 4, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 6, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 8, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 8, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 1, 1, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 2, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 1, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 2, 2, 16, 16));
			allVariations.add(new Symbol(2, 4, 4, 1, 3, 1, 14, 19));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 2, 13, 13));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 1, 8, 12));
			allVariations.add(new Symbol(2, 4, 4, 1, 4, 4, 13, 13));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 1, 8, 22));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 2, 20, 20));
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 6, 20, 20));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 5, 8, 22));
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 4, 20, 20));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 6, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 3, 8, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 2, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 1, 4, 24, 24));
			allVariations.add(new Symbol(2, 4, 4, 2, 4, 8, 20, 20));
			allVariations.add(new Symbol(2, 4, 4, 2, 2, 2, 24, 24));

		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 1, 8, 34));
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 2, 29, 29));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 1, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 1, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 8, 29, 29));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 6, 29, 29));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 5, 8, 34));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 5, 16, 42));
			allVariations.add(new Symbol(2, 4, 4, 3, 4, 4, 29, 29));
			allVariations.add(new Symbol(2, 4, 4, 3, 3, 4, 33, 33));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 6, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 8, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 2, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 6, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 4, 33, 33));
			allVariations.add(new Symbol(2, 4, 4, 4, 3, 2, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 4, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 5, 8, 42));
			allVariations.add(new Symbol(2, 4, 4, 4, 2, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 1, 8, 37, 37));
			allVariations.add(new Symbol(2, 4, 4, 4, 4, 1, 8, 42));
		} else {
			throw new RuntimeException("not yet implemented");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup5(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 5 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==5";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 4, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 5, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 6, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 1, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 7, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 2, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 3, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 1, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 4, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 2, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 5, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 3, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 6, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 7, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 1, 8, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 3, 8, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 2, 8, 8));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 1, 2, 10));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 4, 8, 8));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 3, 10, 2));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 6, 8, 8));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 5, 2, 10));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 8, 8, 8));
			allVariations.add(new Symbol(2, 5, 1, 1, 4, 7, 10, 2));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 5, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 6, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 3, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 4, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 1, 14, 15));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 2, 13, 13));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 7, 15, 14));
			allVariations.add(new Symbol(2, 5, 1, 1, 2, 8, 13, 13));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 7, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 8, 16, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 7, 22, 2));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 1, 16, 30));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 6, 16, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 5, 2, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 4, 16, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 5, 16, 30));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 3, 22, 2));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 2, 16, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 3, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 4, 1, 2, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 2, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 1, 16, 30));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 7, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 3, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 1, 16, 30));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 5, 16, 30));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 3, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 7, 30, 16));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 1, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 1, 2, 3, 5, 16, 30));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 2, 25, 25));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 1, 2, 34));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 7, 42, 16));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 6, 25, 25));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 8, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 5, 2, 34));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 5, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 4, 25, 25));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 6, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 3, 34, 2));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 3, 42, 16));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 4, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 1, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 8, 25, 25));
			allVariations.add(new Symbol(2, 5, 1, 3, 2, 2, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 4, 7, 34, 2));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 4, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 5, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 6, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 7, 42, 16));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 8, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 6, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 7, 42, 16));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 8, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 2, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 3, 42, 16));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 4, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 5, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 1, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 2, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 3, 3, 1, 16, 42));
			allVariations.add(new Symbol(2, 5, 1, 3, 1, 3, 42, 16));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 6, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 5, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 4, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 3, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 8, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 7, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 2, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 1, 1, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 4, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 5, 2, 42));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 2, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 3, 42, 2));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 2, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 1, 2, 42));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 3, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 1, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 6, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 7, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 4, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 5, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 8, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 6, 31, 31));
			allVariations.add(new Symbol(2, 5, 1, 4, 2, 8, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 4, 7, 42, 2));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 1, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 2, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 3, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 4, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 5, 16, 50));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 6, 37, 37));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 7, 50, 16));
			allVariations.add(new Symbol(2, 5, 1, 4, 3, 8, 37, 37));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 1, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 3, 18, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 2, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 1, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 7, 18, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 6, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 8, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 5, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 7, 18, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 6, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 4, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 5, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 3, 18, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 3, 8, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 1, 2, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 7, 2, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 8, 12, 12));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 5, 16, 2));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 6, 12, 12));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 3, 2, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 4, 12, 12));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 1, 16, 2));
			allVariations.add(new Symbol(2, 5, 1, 5, 4, 2, 12, 12));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 1, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 3, 18, 16));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 5, 16, 18));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 5, 1, 5, 2, 7, 18, 16));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 8, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 7, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 8, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 3, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 6, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 5, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 2, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 2, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 1, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 8, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 1, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 7, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 4, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 2, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 7, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 3, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 1, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 6, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 6, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 5, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 4, 21, 21));
			allVariations.add(new Symbol(2, 5, 2, 1, 1, 5, 27, 14));
			allVariations.add(new Symbol(2, 5, 2, 1, 3, 3, 14, 27));
			allVariations.add(new Symbol(2, 5, 2, 1, 2, 4, 21, 21));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 7, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 8, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 8, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 6, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 7, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 3, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 4, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 4, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 5, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 5, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 2, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 6, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 3, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 1, 1, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 1, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 2, 2, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 1, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 3, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 2, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 5, 27, 18));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 4, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 7, 18, 27));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 6, 28, 28));
			allVariations.add(new Symbol(2, 5, 2, 2, 3, 8, 28, 28));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 13, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 7, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 11, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 5, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 3, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 15, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 1, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 5, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 15, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 3, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 13, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 9, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 11, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 7, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 9, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 1, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 9, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 11, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 13, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 15, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 1, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 3, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 5, 27, 15));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 3, 1, 2, 7, 15, 27));
			allVariations.add(new Symbol(2, 5, 3, 1, 3, 1, 27, 15));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.DOUBLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 16, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 15, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 15, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 9, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 16, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 10, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 13, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 7, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 14, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 8, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 11, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 13, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 12, 27, 25));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 14, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 9, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 11, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 10, 25, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 12, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 7, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 1, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 8, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 2, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 5, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 6, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 3, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 5, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 4, 27, 25));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 6, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 1, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 3, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 3, 2, 25, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 1, 4, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 16, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 12, 27, 25));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 13, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 14, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 15, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 8, 27, 26));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 9, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 10, 25, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 11, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 4, 27, 25));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 5, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 6, 26, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 7, 19, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 1, 27, 19));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 2, 25, 27));
			allVariations.add(new Symbol(2, 5, 3, 2, 2, 3, 19, 27));
		} else if (baseSymbol.equals(MovementBaseSymbol.CROSS_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 1, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 13, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 14, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 15, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 16, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 9, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 10, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 11, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 12, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 5, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 6, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 7, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 8, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 1, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 2, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 3, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 1, 4, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 2, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 1, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 16, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 15, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 14, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 13, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 12, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 11, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 10, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 9, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 8, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 7, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 6, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 5, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 4, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 3, 3, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 16, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 14, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 15, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 12, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 13, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 10, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 11, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 8, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 9, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 6, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 7, 27, 31));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 4, 24, 20));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 5, 31, 27));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 2, 20, 24));
			allVariations.add(new Symbol(2, 5, 4, 1, 2, 3, 27, 31));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 6, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 4, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 5, 40, 14));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 7, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 6, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 5, 40, 14));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 8, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 3, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 6, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 4, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 7, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 2, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 8, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 3, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 4, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 7, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 5, 40, 14));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 8, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 1, 1, 40, 14));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 2, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 2, 1, 40, 14));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 3, 14, 40));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 2, 30, 30));
			allVariations.add(new Symbol(2, 5, 5, 1, 3, 1, 40, 14));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 7, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 8, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 8, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 6, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 7, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 4, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 3, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 4, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 5, 40, 18));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 5, 40, 18));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 2, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 6, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 3, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 2, 1, 40, 18));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 8, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 7, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 6, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 5, 40, 18));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 4, 37, 36));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 3, 18, 40));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 2, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 1, 1, 40, 18));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 2, 36, 37));
			allVariations.add(new Symbol(2, 5, 5, 2, 3, 1, 40, 18));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 5, 39, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 7, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 6, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 8, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 7, 15, 39));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 9, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 8, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 10, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 9, 39, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 3, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 10, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 4, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 11, 15, 39));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 5, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 12, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 6, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 13, 39, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 15, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 14, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 16, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 15, 15, 39));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 16, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 11, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 12, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 13, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 14, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 1, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 3, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 2, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 10, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 11, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 8, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 9, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 6, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 7, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 4, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 5, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 16, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 14, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 15, 15, 40));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 12, 28, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 2, 13, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 1, 40, 15));
			allVariations.add(new Symbol(2, 5, 6, 1, 1, 2, 27, 26));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 4, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 3, 15, 39));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 2, 28, 27));
			allVariations.add(new Symbol(2, 5, 6, 1, 3, 1, 39, 15));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.TRIPLE_ALTERNATING_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 1, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 2, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 3, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 16, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 2, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 5, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 4, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 7, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 12, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 6, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 13, 39, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 9, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 14, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 8, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 15, 19, 39));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 8, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 11, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 9, 39, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 10, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 13, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 10, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 12, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 11, 19, 39));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 4, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 15, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 5, 39, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 14, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 6, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 7, 19, 39));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 16, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 1, 1, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 2, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 3, 19, 39));
			allVariations.add(new Symbol(2, 5, 6, 2, 3, 1, 39, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 6, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 5, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 4, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 3, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 10, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 9, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 8, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 7, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 14, 34, 33));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 13, 40, 19));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 12, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 11, 19, 40));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 16, 33, 34));
			allVariations.add(new Symbol(2, 5, 6, 2, 2, 15, 19, 40));
		} else if (baseSymbol.equals(MovementBaseSymbol.BENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 2, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 3, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 4, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 5, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 1, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 14, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 13, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 16, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 15, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 10, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 9, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 12, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 11, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 6, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 5, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 8, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 7, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 5, 10, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 6, 20, 9));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 3, 20, 10));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 4, 9, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 1, 10, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 2, 20, 9));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 16, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 15, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 14, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 13, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 12, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 11, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 10, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 9, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 8, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 7, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 3, 6, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 16, 9, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 15, 20, 10));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 8, 9, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 7, 20, 10));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 10, 20, 9));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 9, 10, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 12, 9, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 3, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 11, 20, 10));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 2, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 14, 20, 9));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 1, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 4, 13, 10, 20));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 4, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 5, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 6, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 7, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 8, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 9, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 10, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 11, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 12, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 13, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 14, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 15, 27, 16));
			allVariations.add(new Symbol(2, 5, 7, 1, 1, 16, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 2, 25, 14));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 1, 16, 27));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 4, 14, 25));
			allVariations.add(new Symbol(2, 5, 7, 1, 2, 3, 27, 16));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 2, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 1, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 4, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 3, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 16, 10, 16));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 9, 12, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 8, 10, 16));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 11, 10, 12));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 10, 16, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 13, 12, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 12, 10, 16));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 15, 10, 12));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 14, 16, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 2, 16, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 3, 10, 12));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 1, 12, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 6, 16, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 7, 10, 12));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 4, 10, 16));
			allVariations.add(new Symbol(2, 5, 8, 1, 4, 5, 12, 10));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 16, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 15, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 10, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 9, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 8, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 7, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 14, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 13, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 12, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 11, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 4, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 3, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 6, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 5, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 2, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 3, 1, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 10, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 11, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 12, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 13, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 6, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 7, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 8, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 9, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 14, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 15, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 16, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 5, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 4, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 3, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 2, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 2, 1, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 11, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 12, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 9, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 10, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 7, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 8, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 5, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 6, 21, 14));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 15, 17, 18));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 16, 14, 21));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 13, 18, 17));
			allVariations.add(new Symbol(2, 5, 8, 1, 1, 14, 21, 14));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 8, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 10, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 5, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 4, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 6, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 16, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 12, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 14, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 2, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 4, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 12, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 10, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 8, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 6, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 5, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 16, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 14, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 2, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 4, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 5, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 2, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 6, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 8, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 10, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 12, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 14, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 3, 16, 19, 29));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 1, 17, 16));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 2, 24, 14));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 3, 16, 17));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 4, 14, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 5, 17, 16));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 6, 24, 14));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 10, 24, 14));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 9, 17, 16));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 8, 14, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 7, 16, 17));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 14, 24, 14));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 13, 17, 16));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 12, 14, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 1, 2, 29, 19));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 11, 16, 17));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 16, 14, 24));
			allVariations.add(new Symbol(2, 5, 8, 2, 4, 15, 16, 17));
		} else if (baseSymbol.equals(MovementBaseSymbol.CORNER_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 3, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 2, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 6, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 3, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 4, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 10, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 8, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 14, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 12, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 16, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 2, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 4, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 3, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 4, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 6, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 8, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 10, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 12, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 14, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 2, 16, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 14, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 16, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 10, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 12, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 6, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 8, 20, 34));
			allVariations.add(new Symbol(2, 5, 8, 3, 3, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 2, 28, 16));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 3, 20, 22));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 4, 16, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 5, 22, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 1, 22, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 16, 16, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 15, 20, 22));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 14, 28, 16));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 13, 22, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 12, 16, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 2, 34, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 11, 20, 22));
			allVariations.add(new Symbol(2, 5, 8, 3, 1, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 10, 28, 16));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 9, 22, 20));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 8, 16, 28));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 7, 20, 22));
			allVariations.add(new Symbol(2, 5, 8, 3, 4, 6, 28, 16));
		} else if (baseSymbol.equals(MovementBaseSymbol.CHECK_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 13, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 15, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 9, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 11, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 5, 14, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 6, 13, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 7, 18, 14));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 8, 20, 13));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 1, 14, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 2, 13, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 3, 18, 14));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 4, 20, 13));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 15, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 13, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 11, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 9, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 7, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 7, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 5, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 3, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 3, 1, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 15, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 14, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 16, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 7, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 9, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 8, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 11, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 10, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 13, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 12, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 13, 14, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 14, 13, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 15, 18, 14));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 1, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 16, 20, 13));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 9, 14, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 3, 25, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 10, 13, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 11, 18, 14));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 5, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 4, 12, 20, 13));
			allVariations.add(new Symbol(2, 5, 9, 1, 2, 6, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 1, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 4, 20, 18));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 5, 20, 25));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 2, 18, 20));
			allVariations.add(new Symbol(2, 5, 9, 1, 1, 3, 25, 20));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 14, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 15, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 12, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 13, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 10, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 11, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 8, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 9, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 16, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 8, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 7, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 6, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 5, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 4, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 3, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 2, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 1, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 11, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 12, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 13, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 14, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 7, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 8, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 9, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 10, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 15, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 16, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 5, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 4, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 7, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 6, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 1, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 3, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 2, 2, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 12, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 13, 13, 11));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 10, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 11, 11, 13));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 16, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 14, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 15, 11, 13));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 9, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 3, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 10, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 4, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 11, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 5, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 12, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 6, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 13, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 14, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 15, 18, 19));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 1, 19, 18));
			allVariations.add(new Symbol(2, 5, 10, 1, 3, 16, 17, 22));
			allVariations.add(new Symbol(2, 5, 10, 1, 1, 2, 22, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 1, 13, 11));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 3, 11, 13));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 2, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 5, 13, 11));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 4, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 7, 11, 13));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 6, 17, 17));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 9, 13, 11));
			allVariations.add(new Symbol(2, 5, 10, 1, 4, 8, 17, 17));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 12, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 10, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 8, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 6, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 16, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 14, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 5, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 6, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 4, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 2, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 12, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 14, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 8, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 10, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 16, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 2, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 4, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 5, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 6, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 7, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 2, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 15, 16, 17));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 16, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 13, 17, 16));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 14, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 11, 16, 17));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 12, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 9, 17, 16));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 10, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 6, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 5, 17, 16));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 8, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 7, 16, 17));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 2, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 1, 17, 16));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 4, 23, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 4, 3, 16, 17));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 16, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 12, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 13, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 14, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 15, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 1, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 8, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 2, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 9, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 3, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 10, 29, 23));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 4, 23, 29));
			allVariations.add(new Symbol(2, 5, 10, 2, 3, 11, 24, 24));
			allVariations.add(new Symbol(2, 5, 10, 2, 1, 5, 24, 24));
		} else if (baseSymbol.equals(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 16, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 14, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 8, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 6, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 12, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 10, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 4, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 2, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 3, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 14, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 16, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 6, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 8, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 10, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 2, 12, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 2, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 3, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 4, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 5, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 6, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 16, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 15, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 14, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 13, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 12, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 11, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 10, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 9, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 8, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 3, 7, 28, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 6, 29, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 7, 20, 22));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 4, 27, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 5, 22, 20));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 2, 29, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 3, 20, 22));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 1, 22, 20));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 16, 27, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 13, 22, 20));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 12, 27, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 15, 20, 22));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 14, 29, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 9, 22, 20));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 8, 27, 29));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 11, 20, 22));
			allVariations.add(new Symbol(2, 5, 10, 3, 4, 10, 29, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 2, 35, 27));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 1, 29, 28));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 4, 27, 35));
			allVariations.add(new Symbol(2, 5, 10, 3, 1, 3, 28, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 9, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 8, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 7, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 6, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 5, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 4, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 3, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 2, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 1, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 15, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 16, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 13, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 14, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 11, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 12, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 9, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 10, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 8, 20, 14));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 7, 19, 10));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 10, 14, 20));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 9, 10, 19));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 4, 20, 14));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 3, 19, 10));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 6, 14, 20));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 5, 10, 19));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 2, 14, 20));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 1, 10, 19));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 14, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 15, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 16, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 10, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 11, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 12, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 3, 13, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 2, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 3, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 1, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 6, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 7, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 4, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 5, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 13, 10, 19));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 14, 14, 20));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 11, 19, 10));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 12, 20, 14));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 15, 19, 10));
			allVariations.add(new Symbol(2, 5, 11, 1, 4, 16, 20, 14));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 1, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 2, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 3, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 4, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 5, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 6, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 7, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 2, 8, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 9, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 8, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 11, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 10, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 13, 16, 26));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 12, 25, 17));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 15, 26, 16));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 14, 17, 25));
			allVariations.add(new Symbol(2, 5, 11, 1, 1, 16, 25, 17));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 3, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 4, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 1, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 2, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 7, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 8, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 5, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 6, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 16, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 11, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 10, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 9, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 8, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 15, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 14, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 13, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 12, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 2, 19, 27));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 3, 26, 14));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 4, 27, 19));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 5, 14, 26));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 6, 19, 27));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 7, 26, 14));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 8, 27, 19));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 9, 14, 26));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 1, 14, 26));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 10, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 9, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 12, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 11, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 14, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 13, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 16, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 3, 15, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 5, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 6, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 3, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 4, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 1, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 2, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 16, 27, 19));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 14, 19, 27));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 15, 26, 14));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 12, 27, 19));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 13, 14, 26));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 10, 19, 27));
			allVariations.add(new Symbol(2, 5, 11, 2, 4, 11, 26, 14));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 4, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 5, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 6, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 7, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 1, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 2, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 2, 3, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 16, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 15, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 12, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 11, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 14, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 13, 21, 34));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 8, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 7, 34, 21));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 10, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 2, 1, 9, 21, 34));
		} else if (baseSymbol.equals(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 4, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 5, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 2, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 3, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 1, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 9, 14, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 3, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 10, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 4, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 11, 32, 14));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 5, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 12, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 6, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 13, 14, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 14, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 15, 32, 14));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 1, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 16, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 2, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 15, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 14, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 16, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 11, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 10, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 13, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 12, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 7, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 6, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 9, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 1, 8, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 14, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 15, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 12, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 13, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 10, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 11, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 8, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 9, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 16, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 8, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 7, 32, 14));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 6, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 5, 14, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 4, 32, 20));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 3, 32, 14));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 2, 20, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 4, 1, 14, 32));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 11, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 12, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 13, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 14, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 7, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 8, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 9, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 10, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 15, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 2, 16, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 5, 22, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 4, 38, 24));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 7, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 6, 24, 38));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 1, 21, 40));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 3, 40, 22));
			allVariations.add(new Symbol(2, 5, 11, 3, 3, 2, 24, 38));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 2, 15, 17));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 3, 18, 17));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 1, 17, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 6, 15, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 7, 18, 17));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 4, 18, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 5, 17, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 10, 15, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 11, 18, 17));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 8, 18, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 9, 17, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 14, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 13, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 12, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 11, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 16, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 15, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 13, 17, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 4, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 12, 18, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 3, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 15, 18, 17));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 2, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 14, 15, 18));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 1, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 8, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 4, 16, 18, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 7, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 6, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 5, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 13, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 14, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 15, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 16, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 9, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 10, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 11, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 1, 12, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 7, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 6, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 9, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 8, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 3, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 2, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 5, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 4, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 1, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 16, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 14, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 15, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 12, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 13, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 10, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 2, 11, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 10, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 9, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 8, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 7, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 6, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 5, 23, 25));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 4, 22, 15));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 3, 25, 23));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 2, 15, 22));
			allVariations.add(new Symbol(2, 5, 12, 1, 3, 1, 23, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 7, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 6, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 5, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 4, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 3, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 2, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 1, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 16, 26, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 15, 28, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 14, 21, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 13, 26, 28));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 12, 26, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 11, 28, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 1, 26, 28));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 2, 21, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 7, 28, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 8, 26, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 9, 26, 28));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 10, 21, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 3, 28, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 4, 26, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 5, 26, 28));
			allVariations.add(new Symbol(2, 5, 12, 2, 4, 6, 21, 26));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 15, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 14, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 16, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 11, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 10, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 13, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 12, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 1, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 4, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 5, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 2, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 3, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 8, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 9, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 6, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 3, 7, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 12, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 11, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 10, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 9, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 16, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 15, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 14, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 13, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 1, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 2, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 3, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 4, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 5, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 6, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 7, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 2, 8, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 9, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 8, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 11, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 10, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 13, 33, 36));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 12, 32, 21));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 15, 36, 33));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 14, 21, 32));
			allVariations.add(new Symbol(2, 5, 12, 2, 1, 16, 32, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.PEAKS_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 2, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 1, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 6, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 5, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 4, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 3, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 13, 28, 32));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 12, 31, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 11, 32, 28));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 10, 26, 31));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 16, 31, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 15, 32, 28));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 14, 26, 31));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 2, 26, 31));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 3, 32, 28));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 4, 31, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 5, 28, 32));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 6, 26, 31));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 7, 32, 28));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 8, 31, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 9, 28, 32));
			allVariations.add(new Symbol(2, 5, 12, 3, 4, 1, 28, 32));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 10, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 9, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 12, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 11, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 14, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 13, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 16, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 15, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 8, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 7, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 6, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 5, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 4, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 3, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 2, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 3, 1, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 14, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 15, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 12, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 13, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 10, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 11, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 8, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 9, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 16, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 5, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 4, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 7, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 6, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 1, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 3, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 2, 2, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 11, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 12, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 13, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 14, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 7, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 8, 37, 26));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 9, 35, 40));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 10, 26, 37));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 15, 40, 35));
			allVariations.add(new Symbol(2, 5, 12, 3, 1, 16, 37, 26));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 16, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 14, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 12, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 2, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 10, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 8, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 6, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 4, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 16, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 12, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 3, 14, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 4, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 4, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 2, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 8, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 6, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 10, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 12, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 14, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 1, 16, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 15, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 5, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 11, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 13, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 2, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 4, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 1, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 6, 22, 23));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 8, 23, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 9, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 6, 5, 20, 29));
			allVariations.add(new Symbol(2, 5, 13, 1, 2, 10, 22, 23));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 10, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 10, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 9, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 8, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 8, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 7, 42, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 9, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 14, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 1, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 14, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 13, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 2, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 12, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 12, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 13, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 2, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 5, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 2, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 1, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 6, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 4, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 1, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 6, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 9, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 6, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 5, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 10, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 7, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 4, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 7, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 4, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 8, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 5, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 16, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 16, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 14, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 5, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 7, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 6, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 9, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 8, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 10, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 13, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 12, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 1, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 2, 25, 26));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 5, 20, 33));
			allVariations.add(new Symbol(2, 5, 14, 1, 4, 4, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 13, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 14, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 6, 16, 26, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 16, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 12, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 10, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 9, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 8, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 7, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 6, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 5, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 4, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 2, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 3, 1, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 16, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 14, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 12, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 13, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 9, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 8, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 10, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 5, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 4, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 7, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 6, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 1, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 3, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 2, 2, 25, 28));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 15, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 16, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 11, 43, 16));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 12, 28, 25));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 13, 20, 31));
			allVariations.add(new Symbol(2, 5, 14, 1, 1, 14, 25, 28));
		} else if (baseSymbol.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_FLOOR_PLANE_FILLED_ARROW
				.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 13, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 9, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 5, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 2, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 1, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 6, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 13, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 9, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 5, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 2, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 5, 1, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 9, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 13, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 2, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 1, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 4, 5, 22, 33));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 5, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 9, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 1, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 2, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 9, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 13, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 1, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 13, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 5, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 1, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 3, 2, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 7, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 8, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 5, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 6, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 11, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 12, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 9, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 10, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 15, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 16, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 13, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 14, 28, 25));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 3, 43, 18));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 4, 25, 28));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 1, 22, 31));
			allVariations.add(new Symbol(2, 5, 15, 1, 2, 2, 28, 25));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 3, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 11, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 16, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 8, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 3, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 6, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 11, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 12, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 10, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 11, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 3, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 4, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 2, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 5, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 4, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 10, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 11, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 12, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 3, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 6, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 8, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 2, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 14, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 3, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 4, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 16, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 11, 32, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 10, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 12, 22, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 6, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 14, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 16, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 1, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 13, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 14, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 11, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 12, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 9, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 10, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 8, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 5, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 6, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 3, 32, 20));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 4, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 1, 22, 28));
			allVariations.add(new Symbol(2, 5, 16, 1, 3, 2, 22, 24));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 16, 24, 22));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 16, 1, 2, 14, 22, 24));
		} else if (baseSymbol.equals(
				MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 1, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 2, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 3, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 1, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 4, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 2, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 5, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 6, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 8, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 9, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 10, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 11, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 12, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 13, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 14, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 14, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 13, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 14, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 12, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 11, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 16, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 16, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 15, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 6, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 5, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 4, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 3, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 10, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 9, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 8, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 6, 7, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 1, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 4, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 5, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 2, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 1, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 3, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 8, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 9, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 6, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 12, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 13, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 10, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 1, 11, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 11, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 10, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 13, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 12, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 15, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 14, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 16, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 3, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 2, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 5, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 4, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 7, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 6, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 9, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 5, 8, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 5, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 6, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 7, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 8, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 1, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 2, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 3, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 4, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 13, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 14, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 15, 35, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 16, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 9, 22, 38));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 10, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 11, 38, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 4, 12, 29, 29));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 16, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 6, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 7, 33, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 4, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 5, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 2, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 3, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 1, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 14, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 15, 33, 19));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 12, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 13, 22, 35));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 10, 28, 31));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 11, 34, 20));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 8, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 3, 9, 22, 39));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 16, 31, 28));
			allVariations.add(new Symbol(2, 5, 17, 1, 2, 15, 33, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.TRAVEL_ROTATION_ALTERNATING_WALL_PLANE_FILLED_ARROW
				.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 1, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 14, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 16, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 11, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 10, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 13, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 12, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 6, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 9, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 8, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 3, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 2, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 5, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 4, 4, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 3, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 1, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 4, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 2, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 5, 23, 35));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 6, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 1, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 2, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 11, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 12, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 13, 23, 35));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 14, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 8, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 9, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 10, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 16, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 14, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 13, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 12, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 11, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 10, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 9, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 8, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 6, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 5, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 4, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 5, 3, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 1, 16, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 1, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 3, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 2, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 4, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 9, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 5, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 8, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 6, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 11, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 10, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 8, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 13, 23, 35));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 9, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 12, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 10, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 11, 41, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 14, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 12, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 1, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 13, 23, 36));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 14, 28, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 3, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 2, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 6, 16, 27, 28));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 5, 23, 35));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 4, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 6, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 2, 16, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 12, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 11, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 10, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 9, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 16, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 15, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 14, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 13, 23, 35));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 4, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 3, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 2, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 1, 25, 39));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 8, 27, 31));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 7, 37, 20));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 6, 31, 27));
			allVariations.add(new Symbol(2, 5, 18, 1, 3, 5, 23, 35));
		} else if (baseSymbol.equals(MovementBaseSymbol.TRAVEL_SHAKING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 1, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 1, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 2, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 1, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 5, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 5, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 2, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 7, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 1, 8, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 6, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 5, 16, 32));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 4, 22, 22));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 3, 32, 16));
			allVariations.add(new Symbol(2, 5, 19, 1, 3, 2, 22, 22));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup6(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 6 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==6";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 16, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 15, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 7, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 8, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 9, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 10, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 11, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 12, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 13, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 14, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 1, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 2, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 3, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 4, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 5, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 3, 6, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 16, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 15, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 14, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 8, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 9, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 6, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 7, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 12, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 13, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 10, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 11, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 1, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 4, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 5, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 2, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 2, 3, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 14, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 13, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 16, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 15, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 9, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 10, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 11, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 12, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 5, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 6, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 7, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 8, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 1, 12, 22));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 2, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 3, 22, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 1, 4, 20, 20));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 16, 17, 13));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 7, 19, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 6, 13, 17));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 5, 12, 19));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 4, 17, 13));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 3, 19, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 2, 13, 17));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 1, 12, 19));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 15, 19, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 14, 13, 17));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 13, 12, 19));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 12, 17, 13));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 11, 19, 12));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 10, 13, 17));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 9, 12, 19));
			allVariations.add(new Symbol(2, 6, 1, 1, 4, 8, 17, 13));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 2, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 3, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 4, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 5, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 1, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 10, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 11, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 12, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 13, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 6, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 7, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 8, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 9, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 15, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 14, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 3, 16, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 3, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 4, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 1, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 2, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 11, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 12, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 9, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 10, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 7, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 8, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 5, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 6, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 16, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 15, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 14, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 2, 13, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 1, 14, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 2, 19, 21));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 5, 14, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 6, 19, 21));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 3, 25, 14));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 4, 21, 19));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 9, 14, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 10, 19, 21));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 16, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 7, 25, 14));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 8, 21, 19));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 14, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 13, 14, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 15, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 14, 19, 21));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 12, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 11, 25, 14));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 13, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 12, 21, 19));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 11, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 10, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 9, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 16, 21, 19));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 8, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 4, 15, 25, 14));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 7, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 6, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 5, 15, 29));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 4, 25, 27));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 3, 29, 15));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 2, 27, 25));
			allVariations.add(new Symbol(2, 6, 1, 2, 1, 1, 15, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 13, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 15, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 1, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 3, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 9, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 11, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 5, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 7, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 2, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 15, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 13, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 3, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 1, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 11, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 9, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 7, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 3, 5, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 13, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 12, 26, 21));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 13, 16, 32));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 11, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 10, 21, 26));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 11, 32, 16));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 8, 26, 21));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 9, 16, 32));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 15, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 6, 21, 26));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 7, 32, 16));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 4, 26, 21));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 5, 16, 32));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 2, 21, 26));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 3, 32, 16));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 1, 16, 32));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 1, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 5, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 3, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 9, 17, 36));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 16, 26, 21));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 15, 32, 16));
			allVariations.add(new Symbol(2, 6, 1, 3, 1, 7, 36, 17));
			allVariations.add(new Symbol(2, 6, 1, 3, 4, 14, 21, 26));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 6, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 7, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 4, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 5, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 10, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 11, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 8, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 9, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 2, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 3, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 1, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 15, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 14, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 13, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 12, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 3, 16, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 3, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 4, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 5, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 6, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 7, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 8, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 9, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 10, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 1, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 2, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 12, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 11, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 14, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 13, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 16, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 2, 15, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 1, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 9, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 8, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 7, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 6, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 5, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 4, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 3, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 2, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 16, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 14, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 15, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 12, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 13, 20, 44));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 10, 36, 36));
			allVariations.add(new Symbol(2, 6, 1, 4, 1, 11, 44, 20));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 9, 19, 41));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 10, 28, 32));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 11, 41, 19));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 12, 32, 28));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 5, 19, 41));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 6, 28, 32));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 7, 41, 19));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 8, 32, 28));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 1, 19, 41));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 2, 28, 32));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 3, 41, 19));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 4, 32, 28));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 14, 28, 32));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 13, 19, 41));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 16, 32, 28));
			allVariations.add(new Symbol(2, 6, 1, 4, 4, 15, 41, 19));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 1, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 2, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 3, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 4, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 5, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 6, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 7, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 8, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 9, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 10, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 11, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 12, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 13, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 14, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 15, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 3, 16, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 3, 25, 17));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 4, 24, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 1, 17, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 2, 21, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 7, 25, 17));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 8, 24, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 5, 17, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 6, 21, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 11, 25, 17));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 12, 24, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 9, 17, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 10, 21, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 15, 25, 17));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 16, 24, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 13, 17, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 4, 14, 21, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 2, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 3, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 4, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 5, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 1, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 10, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 11, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 12, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 13, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 6, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 7, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 8, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 9, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 15, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 14, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 1, 16, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 5, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 6, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 3, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 4, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 1, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 2, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 13, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 14, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 11, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 12, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 9, 21, 28));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 10, 25, 24));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 7, 28, 21));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 8, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 16, 24, 25));
			allVariations.add(new Symbol(2, 6, 2, 1, 2, 15, 28, 21));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 11, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 13, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 7, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 9, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 3, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 5, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 1, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 3, 15, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 14, 25, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 15, 29, 21));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 12, 30, 25));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 13, 21, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 10, 25, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 11, 29, 21));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 8, 30, 25));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 9, 21, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 6, 25, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 7, 29, 21));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 4, 30, 25));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 5, 21, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 2, 25, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 3, 29, 21));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 1, 21, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 4, 16, 30, 25));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 1, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 3, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 5, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 7, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 9, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 11, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 13, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 15, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 1, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 1, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 5, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 4, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 3, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 2, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 9, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 8, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 7, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 6, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 13, 24, 33));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 12, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 11, 33, 24));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 10, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 16, 30, 29));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 14, 29, 30));
			allVariations.add(new Symbol(2, 6, 2, 2, 2, 15, 33, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 14, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 13, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 16, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 15, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 9, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 10, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 11, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 12, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 5, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 6, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 7, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 8, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 1, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 2, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 3, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 2, 4, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 16, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 15, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 14, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 13, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 12, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 10, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 11, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 8, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 9, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 6, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 7, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 4, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 5, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 2, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 3, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 1, 1, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 16, 33, 30));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 15, 32, 26));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 7, 32, 26));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 8, 33, 30));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 9, 26, 32));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 10, 30, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 11, 32, 26));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 12, 33, 30));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 13, 26, 32));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 14, 30, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 1, 26, 32));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 2, 30, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 3, 32, 26));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 4, 33, 30));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 5, 26, 32));
			allVariations.add(new Symbol(2, 6, 2, 3, 4, 6, 30, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 16, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 15, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 14, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 8, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 9, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 6, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 7, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 12, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 13, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 10, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 11, 36, 29));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 1, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 4, 33, 34));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 5, 29, 36));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 2, 34, 33));
			allVariations.add(new Symbol(2, 6, 2, 3, 3, 3, 36, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_LARGEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 8, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 7, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 10, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 9, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 4, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 3, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 6, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 5, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 2, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 1, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 15, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 16, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 11, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 12, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 13, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 1, 14, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 11, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 10, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 9, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 8, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 7, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 6, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 5, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 4, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 3, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 2, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 1, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 16, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 14, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 15, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 12, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 2, 13, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 15, 50, 33));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 14, 44, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 16, 45, 44));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 2, 44, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 3, 50, 33));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 4, 45, 44));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 5, 33, 50));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 1, 33, 50));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 10, 44, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 11, 50, 33));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 12, 45, 44));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 13, 33, 50));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 6, 44, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 7, 50, 33));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 8, 45, 44));
			allVariations.add(new Symbol(2, 6, 2, 4, 4, 9, 33, 50));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 16, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 15, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 14, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 13, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 3, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 4, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 1, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 2, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 11, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 12, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 9, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 10, 47, 45));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 7, 54, 37));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 8, 45, 47));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 5, 37, 54));
			allVariations.add(new Symbol(2, 6, 2, 4, 3, 6, 47, 45));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 13, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 12, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 15, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 14, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 9, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 8, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 11, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 10, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 5, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 4, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 7, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 6, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 1, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 3, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 2, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 2, 16, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 16, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 15, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 14, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 13, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 12, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 11, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 10, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 9, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 8, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 7, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 6, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 5, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 4, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 3, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 2, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 3, 1, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 1, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 11, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 10, 20, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 13, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 12, 23, 20));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 15, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 14, 20, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 16, 23, 20));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 3, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 2, 20, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 5, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 4, 23, 20));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 7, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 6, 20, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 9, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 4, 8, 23, 20));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 16, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 15, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 1, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 2, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 3, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 4, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 5, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 6, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 7, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 8, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 9, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 10, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 11, 27, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 12, 23, 23));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 13, 23, 27));
			allVariations.add(new Symbol(2, 6, 3, 1, 1, 14, 23, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 9, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 8, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 11, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 10, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 13, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 12, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 15, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 14, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 1, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 3, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 2, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 5, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 4, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 7, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 6, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 3, 16, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 10, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 9, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 8, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 7, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 14, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 13, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 12, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 11, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 2, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 1, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 6, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 5, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 4, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 3, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 15, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 2, 16, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 11, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 10, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 13, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 12, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 7, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 6, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 9, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 8, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 3, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 2, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 5, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 4, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 1, 28, 33));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 14, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 15, 33, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 1, 16, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 5, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 6, 25, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 7, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 8, 29, 25));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 1, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 2, 25, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 3, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 4, 29, 25));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 13, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 14, 25, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 15, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 16, 29, 25));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 9, 28, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 10, 25, 29));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 11, 29, 28));
			allVariations.add(new Symbol(2, 6, 3, 2, 4, 12, 29, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 16, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 9, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 8, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 11, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 10, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 13, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 12, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 15, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 14, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 1, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 3, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 2, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 5, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 4, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 7, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 1, 6, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 1, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 12, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 11, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 10, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 9, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 16, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 15, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 14, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 13, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 4, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 3, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 2, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 1, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 8, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 7, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 6, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 2, 5, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 2, 20, 22));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 1, 12, 28));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 6, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 7, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 8, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 9, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 2, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 3, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 4, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 5, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 14, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 15, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 16, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 10, 27, 26));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 11, 31, 14));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 12, 26, 27));
			allVariations.add(new Symbol(2, 6, 4, 1, 3, 13, 14, 31));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 9, 12, 28));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 10, 20, 22));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 7, 28, 12));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 8, 22, 20));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 5, 12, 28));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 6, 20, 22));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 3, 28, 12));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 4, 22, 20));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 15, 28, 12));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 16, 22, 20));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 13, 12, 28));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 14, 20, 22));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 11, 28, 12));
			allVariations.add(new Symbol(2, 6, 4, 1, 4, 12, 22, 20));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 15, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 16, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 4, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 3, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 6, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 5, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 2, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 1, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 12, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 11, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 14, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 13, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 8, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 7, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 10, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 1, 9, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 16, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 7, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 6, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 5, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 4, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 3, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 2, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 1, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 15, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 14, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 13, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 12, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 11, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 10, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 9, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 2, 8, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 1, 14, 37));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 2, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 1, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 4, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 3, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 6, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 5, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 8, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 7, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 10, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 9, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 12, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 11, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 14, 32, 34));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 13, 14, 41));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 16, 34, 32));
			allVariations.add(new Symbol(2, 6, 4, 2, 3, 15, 41, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 5, 14, 37));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 4, 30, 24));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 3, 37, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 2, 24, 30));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 9, 14, 37));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 8, 30, 24));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 7, 37, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 6, 24, 30));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 13, 14, 37));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 12, 30, 24));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 11, 37, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 10, 24, 30));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 16, 30, 24));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 15, 37, 14));
			allVariations.add(new Symbol(2, 6, 4, 2, 4, 14, 24, 30));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 16, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 15, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 14, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 1, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 4, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 5, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 2, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 3, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 8, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 9, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 6, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 7, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 12, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 13, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 10, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 1, 11, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 16, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 15, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 1, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 2, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 3, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 4, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 5, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 6, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 7, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 8, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 9, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 10, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 11, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 12, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 13, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 2, 14, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 13, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 12, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 15, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 14, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 9, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 8, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 11, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 10, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 5, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 4, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 7, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 6, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 1, 16, 44));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 3, 44, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 2, 39, 37));
			allVariations.add(new Symbol(2, 6, 4, 3, 3, 16, 37, 39));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 16, 33, 31));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 15, 41, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 14, 31, 33));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 13, 16, 41));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 12, 33, 31));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 11, 41, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 10, 31, 33));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 9, 16, 41));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 8, 33, 31));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 7, 41, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 6, 31, 33));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 5, 16, 41));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 4, 33, 31));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 3, 41, 16));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 2, 31, 33));
			allVariations.add(new Symbol(2, 6, 4, 3, 4, 1, 16, 41));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 9, 13, 27));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 1, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 7, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 8, 21, 19));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 11, 27, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 9, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 3, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 10, 19, 21));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 5, 13, 27));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 3, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 5, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 4, 21, 19));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 7, 27, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 5, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 7, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 6, 19, 21));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 15, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 9, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 16, 21, 19));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 11, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 13, 13, 27));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 13, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 11, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 12, 21, 19));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 15, 27, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 15, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 13, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 14, 19, 21));
			allVariations.add(new Symbol(2, 6, 5, 1, 1, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 1, 13, 27));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 3, 27, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 4, 2, 19, 21));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 1, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 9, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 7, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 5, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 3, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 15, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 13, 13, 31));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 2, 11, 31, 13));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 5, 1, 3, 1, 13, 31));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_WALL_PLANE_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 2, 20, 23));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 1, 15, 29));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 10, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 11, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 12, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 13, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 14, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 15, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 16, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 2, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 3, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 4, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 5, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 6, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 7, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 8, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 9, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 3, 1, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 11, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 12, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 9, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 10, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 15, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 16, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 13, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 14, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 3, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 4, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 1, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 2, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 7, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 8, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 5, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 2, 6, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 16, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 5, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 4, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 7, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 6, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 1, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 3, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 2, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 13, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 12, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 15, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 14, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 9, 15, 34));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 8, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 11, 34, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 1, 10, 28, 28));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 15, 29, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 16, 23, 20));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 13, 15, 29));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 14, 20, 23));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 11, 29, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 12, 23, 20));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 9, 15, 29));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 10, 20, 23));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 7, 29, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 8, 23, 20));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 5, 15, 29));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 6, 20, 23));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 3, 29, 15));
			allVariations.add(new Symbol(2, 6, 5, 2, 4, 4, 23, 20));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_WALL_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 1, 19, 43));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 14, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 13, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 16, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 15, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 10, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 9, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 12, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 11, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 6, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 5, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 8, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 7, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 2, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 1, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 4, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 3, 3, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 16, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 15, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 14, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 13, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 12, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 11, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 10, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 9, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 8, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 7, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 6, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 5, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 4, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 3, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 2, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 2, 1, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 15, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 16, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 8, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 7, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 10, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 9, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 12, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 11, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 14, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 13, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 2, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 1, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 4, 38, 37));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 3, 47, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 6, 37, 38));
			allVariations.add(new Symbol(2, 6, 5, 3, 1, 5, 19, 47));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 4, 33, 29));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 5, 19, 43));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 2, 29, 33));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 3, 43, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 8, 33, 29));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 9, 19, 43));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 6, 29, 33));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 7, 43, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 12, 33, 29));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 13, 19, 43));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 10, 29, 33));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 11, 43, 19));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 16, 33, 29));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 14, 29, 33));
			allVariations.add(new Symbol(2, 6, 5, 3, 4, 15, 43, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 1, 13, 41));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 2, 25, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 3, 41, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 4, 32, 25));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 5, 13, 41));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 6, 25, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 7, 41, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 8, 32, 25));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 9, 13, 41));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 10, 25, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 11, 41, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 12, 32, 25));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 13, 13, 41));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 14, 25, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 15, 41, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 4, 16, 32, 25));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 14, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 15, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 16, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 7, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 6, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 9, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 8, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 11, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 10, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 13, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 12, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 1, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 3, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 2, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 5, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 1, 4, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 3, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 4, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 5, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 6, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 1, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 2, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 11, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 12, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 13, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 14, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 7, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 8, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 9, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 10, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 16, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 2, 15, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 6, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 7, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 4, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 5, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 2, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 3, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 1, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 14, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 15, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 12, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 13, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 10, 32, 36));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 11, 44, 13));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 8, 36, 32));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 9, 13, 44));
			allVariations.add(new Symbol(2, 6, 5, 4, 3, 16, 36, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 7, 29, 13));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 8, 18, 21));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 5, 13, 29));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 6, 21, 18));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 11, 29, 13));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 12, 18, 21));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 9, 13, 29));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 10, 21, 18));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 15, 29, 13));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 16, 18, 21));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 13, 13, 29));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 14, 21, 18));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 4, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 5, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 6, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 7, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 8, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 9, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 10, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 11, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 12, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 13, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 14, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 15, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 16, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 2, 21, 18));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 1, 13, 29));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 4, 18, 21));
			allVariations.add(new Symbol(2, 6, 6, 1, 4, 3, 29, 13));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 9, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 10, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 7, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 8, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 5, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 6, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 3, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 4, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 15, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 16, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 13, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 14, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 11, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 12, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 3, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 2, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 3, 1, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 6, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 7, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 8, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 9, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 2, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 3, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 4, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 5, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 14, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 15, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 16, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 1, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 10, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 11, 32, 14));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 12, 22, 28));
			allVariations.add(new Symbol(2, 6, 6, 1, 1, 13, 14, 32));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 2, 28, 22));
			allVariations.add(new Symbol(2, 6, 6, 1, 2, 1, 14, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 1, 13, 31));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 1, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 2, 25, 21));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 3, 31, 13));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 16, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 16, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 15, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 15, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 14, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 13, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 12, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 12, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 11, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 11, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 10, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 14, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 9, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 13, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 8, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 8, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 7, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 7, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 6, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 10, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 5, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 9, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 4, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 4, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 3, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 3, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 2, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 6, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 1, 1, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 5, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 1, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 3, 2, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 15, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 14, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 16, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 16, 21, 25));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 11, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 15, 31, 13));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 10, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 14, 25, 21));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 13, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 13, 13, 31));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 12, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 12, 21, 25));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 11, 31, 13));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 7, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 10, 25, 21));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 6, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 9, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 9, 13, 31));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 8, 21, 25));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 8, 26, 33));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 7, 31, 13));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 3, 35, 15));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 6, 25, 21));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 2, 33, 26));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 5, 13, 31));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 5, 15, 35));
			allVariations.add(new Symbol(2, 6, 6, 2, 4, 4, 21, 25));
			allVariations.add(new Symbol(2, 6, 6, 2, 2, 4, 26, 33));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 1, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 2, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 3, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 4, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 5, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 6, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 7, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 8, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 9, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 10, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 11, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 12, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 13, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 14, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 15, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 2, 16, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 1, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 2, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 3, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 1, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 6, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 7, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 4, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 5, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 10, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 11, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 8, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 9, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 14, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 15, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 12, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 13, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 1, 16, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 7, 35, 17));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 8, 24, 27));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 9, 17, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 10, 27, 24));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 3, 35, 17));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 4, 24, 27));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 5, 17, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 6, 27, 24));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 15, 35, 17));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 16, 24, 27));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 11, 35, 17));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 12, 24, 27));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 13, 17, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 14, 27, 24));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 8, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 9, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 6, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 7, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 4, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 5, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 2, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 3, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 16, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 14, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 15, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 12, 28, 35));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 13, 18, 39));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 10, 35, 28));
			allVariations.add(new Symbol(2, 6, 6, 3, 3, 11, 39, 18));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 2, 27, 24));
			allVariations.add(new Symbol(2, 6, 6, 3, 4, 1, 17, 35));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 5, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 4, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 7, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 6, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 1, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 3, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 2, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 13, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 12, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 15, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 14, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 9, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 8, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 11, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 10, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 2, 16, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 6, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 5, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 4, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 3, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 2, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 1, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 14, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 13, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 12, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 11, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 10, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 9, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 8, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 7, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 15, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 1, 16, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 10, 27, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 11, 33, 16));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 12, 29, 27));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 13, 16, 33));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 14, 27, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 15, 33, 16));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 16, 29, 27));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 2, 27, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 3, 33, 16));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 4, 29, 27));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 5, 16, 33));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 6, 27, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 7, 33, 16));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 8, 29, 27));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 9, 16, 33));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 11, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 12, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 9, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 10, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 15, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 16, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 13, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 14, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 3, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 4, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 1, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 2, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 7, 37, 17));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 8, 29, 30));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 5, 17, 37));
			allVariations.add(new Symbol(2, 6, 6, 4, 3, 6, 30, 29));
			allVariations.add(new Symbol(2, 6, 6, 4, 4, 1, 16, 33));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 15, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 16, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 8, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 7, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 10, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 9, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 12, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 11, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 14, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 13, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 2, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 1, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 4, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 3, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 6, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 2, 5, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 16, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 14, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 15, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 9, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 8, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 7, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 6, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 13, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 12, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 11, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 10, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 1, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 5, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 4, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 3, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 1, 2, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 14, 36, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 13, 20, 46));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 16, 44, 36));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 15, 46, 20));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 10, 36, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 9, 20, 46));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 12, 44, 36));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 11, 46, 20));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 6, 36, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 5, 20, 46));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 8, 44, 36));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 7, 46, 20));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 2, 36, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 1, 20, 46));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 4, 44, 36));
			allVariations.add(new Symbol(2, 6, 6, 5, 4, 3, 46, 20));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 16, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 15, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 14, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 13, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 12, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 11, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 10, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 9, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 8, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 7, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 6, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 5, 21, 51));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 4, 44, 40));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 3, 51, 21));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 2, 40, 44));
			allVariations.add(new Symbol(2, 6, 6, 5, 3, 1, 21, 51));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 12, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 13, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 10, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 11, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 8, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 9, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 6, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 7, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 4, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 5, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 2, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 3, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 1, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 16, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 15, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 2, 14, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 9, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 10, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 11, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 12, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 5, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 6, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 7, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 8, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 1, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 2, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 3, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 4, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 14, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 13, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 16, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 1, 15, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 16, 45, 42));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 1, 30, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 3, 46, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 2, 42, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 5, 30, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 4, 45, 42));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 7, 46, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 6, 42, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 9, 30, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 8, 45, 42));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 11, 46, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 10, 42, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 13, 30, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 12, 45, 42));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 15, 46, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 4, 14, 42, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 15, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 16, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 2, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 1, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 6, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 5, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 4, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 3, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 10, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 9, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 8, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 7, 51, 30));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 14, 46, 45));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 13, 30, 51));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 12, 45, 46));
			allVariations.add(new Symbol(2, 6, 6, 6, 3, 11, 51, 30));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVE_THEN_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 13, 19, 25));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 12, 23, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 11, 25, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 10, 19, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 9, 19, 25));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 8, 23, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 7, 25, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 6, 19, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 16, 23, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 15, 25, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 14, 19, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 2, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 1, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 15, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 16, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 11, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 12, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 13, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 14, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 7, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 8, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 9, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 10, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 3, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 4, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 5, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 1, 6, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 1, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 3, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 2, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 7, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 6, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 5, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 4, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 11, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 10, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 9, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 8, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 15, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 14, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 13, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 12, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 2, 16, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 3, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 4, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 1, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 2, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 6, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 5, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 8, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 7, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 10, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 9, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 12, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 11, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 14, 23, 27));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 13, 19, 33));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 16, 27, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 3, 15, 33, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 1, 19, 25));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 2, 19, 23));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 3, 25, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 4, 23, 19));
			allVariations.add(new Symbol(2, 6, 7, 1, 4, 5, 19, 25));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 16, 25, 20));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 15, 24, 18));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 14, 20, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 13, 18, 24));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 8, 25, 20));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 7, 24, 18));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 6, 20, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 5, 18, 24));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 12, 25, 20));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 11, 24, 18));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 10, 20, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 9, 18, 24));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 1, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 3, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 5, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 7, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 9, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 11, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 13, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 15, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 1, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 1, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 9, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 7, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 5, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 3, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 15, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 13, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 11, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 2, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 3, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 2, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 1, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 8, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 9, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 10, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 11, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 4, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 5, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 6, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 7, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 16, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 12, 25, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 13, 21, 26));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 14, 26, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 3, 15, 26, 21));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 2, 20, 25));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 1, 18, 24));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 4, 25, 20));
			allVariations.add(new Symbol(2, 6, 7, 2, 4, 3, 24, 18));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 16, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 14, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 15, 31, 24));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 12, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 13, 24, 31));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 10, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 11, 31, 24));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 8, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 9, 24, 31));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 6, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 7, 31, 24));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 4, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 5, 24, 31));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 2, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 1, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 1, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 12, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 12, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 11, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 13, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 10, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 10, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 9, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 11, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 16, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 16, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 15, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 14, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 14, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 13, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 15, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 4, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 4, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 3, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 5, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 2, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 2, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 1, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 3, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 8, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 8, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 7, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 9, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 6, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 6, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 1, 5, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 2, 7, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 1, 24, 31));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 3, 31, 24));
			allVariations.add(new Symbol(2, 6, 7, 3, 4, 2, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 11, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 12, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 13, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 14, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 15, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 16, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 3, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 4, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 5, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 6, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 7, 34, 27));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 8, 34, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 9, 27, 34));
			allVariations.add(new Symbol(2, 6, 7, 3, 3, 10, 34, 34));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_SINGLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 11, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 12, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 9, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 10, 20, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 7, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 8, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 5, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 6, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 15, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 16, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 13, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 14, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 5, 23, 26));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 14, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 4, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 13, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 3, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 16, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 2, 20, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 15, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 1, 23, 27));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 10, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 9, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 12, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 11, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 8, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 7, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 9, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 8, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 10, 20, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 5, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 11, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 6, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 4, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 3, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 5, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 4, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 6, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 1, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 7, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 6, 2, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 16, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 12, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 13, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 14, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 15, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 16, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 15, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 2, 20, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 14, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 1, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 13, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 4, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 12, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 2, 3, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 11, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 10, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 9, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 8, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 1, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 2, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 3, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 4, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 5, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 6, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 5, 7, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 16, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 15, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 8, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 7, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 10, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 9, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 3, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 12, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 2, 20, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 11, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 1, 1, 23, 28));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 14, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 13, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 1, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 2, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 5, 22, 11));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 6, 20, 19));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 3, 11, 22));
			allVariations.add(new Symbol(2, 6, 8, 1, 4, 4, 19, 20));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 16, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 15, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 14, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 9, 23, 27));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 8, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 7, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 6, 21, 23));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 13, 23, 26));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 12, 23, 21));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 11, 21, 29));
			allVariations.add(new Symbol(2, 6, 8, 1, 3, 10, 20, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 3, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 4, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 1, 23, 36));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 2, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 4, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 3, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 2, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 1, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 8, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 7, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 6, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 5, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 10, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 11, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 8, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 9, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 14, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 15, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 12, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 13, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 16, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 1, 23, 36));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 2, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 3, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 4, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 1, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 5, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 3, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 2, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 5, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 4, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 7, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 6, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 9, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 8, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 9, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 14, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 13, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 10, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 16, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 11, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 15, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 12, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 13, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 14, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 15, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 5, 16, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 6, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 5, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 8, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 7, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 10, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 9, 23, 36));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 12, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 1, 11, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 5, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 6, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 3, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 4, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 1, 23, 36));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 2, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 16, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 14, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 15, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 12, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 16, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 13, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 15, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 10, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 14, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 6, 11, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 13, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 12, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 11, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 10, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 9, 23, 36));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 8, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 7, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 2, 6, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 4, 24, 26));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 5, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 6, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 7, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 1, 22, 21));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 2, 26, 24));
			allVariations.add(new Symbol(2, 6, 9, 1, 4, 3, 21, 22));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 16, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 15, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 12, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 11, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 14, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 13, 23, 40));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 8, 32, 29));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 7, 22, 48));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 10, 29, 32));
			allVariations.add(new Symbol(2, 6, 9, 1, 3, 9, 23, 36));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATE_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 6, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 12, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 7, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 13, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 4, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 10, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 5, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 11, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 2, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 16, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 3, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 14, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 1, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 15, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 2, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 1, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 16, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 15, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 14, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 6, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 13, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 5, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 12, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 4, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 11, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 3, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 10, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 10, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 9, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 9, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 8, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 8, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 7, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 7, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 3, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 11, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 4, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 12, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 5, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 13, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 6, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 14, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 15, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 6, 16, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 1, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 2, 2, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 15, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 14, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 16, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 11, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 10, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 13, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 12, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 7, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 6, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 9, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 8, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 4, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 5, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 2, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 3, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 8, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 9, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 6, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 7, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 1, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 5, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 4, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 5, 1, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 3, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 1, 2, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 12, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 11, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 10, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 9, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 16, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 15, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 14, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 13, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 1, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 2, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 3, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 4, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 5, 24, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 6, 27, 21));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 7, 21, 24));
			allVariations.add(new Symbol(2, 6, 10, 1, 4, 8, 21, 27));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 16, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 9, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 8, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 11, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 10, 33, 28));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 13, 25, 36));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 12, 28, 33));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 15, 21, 48));
			allVariations.add(new Symbol(2, 6, 10, 1, 3, 14, 33, 28));
		} else if (baseSymbol.equals(MovementBaseSymbol.SHAKING_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 2, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 1, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 16, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 15, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 10, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 10, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 9, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 9, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 8, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 8, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 7, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 7, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 6, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 14, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 5, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 13, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 4, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 12, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 3, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 11, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 2, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 16, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 3, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 14, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 1, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 15, 33, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 6, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 12, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 7, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 13, 19, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 4, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 10, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 5, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 11, 33, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 15, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 16, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 1, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 2, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 11, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 3, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 12, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 4, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 13, 19, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 5, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 5, 14, 22, 22));
			allVariations.add(new Symbol(2, 6, 11, 1, 1, 6, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 4, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 3, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 2, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 1, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 8, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 7, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 6, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 5, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 10, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 11, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 8, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 9, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 14, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 15, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 12, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 13, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 2, 16, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 1, 19, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 3, 33, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 2, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 5, 19, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 4, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 7, 33, 19));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 6, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 9, 19, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 4, 8, 25, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 9, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 10, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 11, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 12, 28, 25));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 13, 21, 33));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 14, 25, 28));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 15, 33, 21));
			allVariations.add(new Symbol(2, 6, 11, 1, 3, 16, 28, 25));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup7(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 7 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==7";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 1, 1, 3, 1, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 1, 3, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 1, 2, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 1, 1, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 2, 2, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 3, 4, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 2, 1, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 3, 3, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 2, 4, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 3, 2, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 2, 3, 17, 23));
			allVariations.add(new Symbol(2, 7, 1, 1, 1, 4, 17, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 2, 1, 3, 3, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 2, 1, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 3, 4, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 2, 2, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 3, 1, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 1, 3, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 2, 3, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 3, 2, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 1, 4, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 2, 4, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 1, 1, 18, 35));
			allVariations.add(new Symbol(2, 7, 2, 1, 1, 2, 18, 35));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 3, 1, 2, 4, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 2, 3, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 3, 4, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 3, 3, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 3, 2, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 2, 2, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 3, 1, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 2, 1, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 1, 1, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 1, 4, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 1, 2, 24, 47));
			allVariations.add(new Symbol(2, 7, 3, 1, 1, 3, 24, 47));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 4, 1, 1, 1, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 2, 1, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 1, 2, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 2, 2, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 2, 3, 16, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 2, 4, 16, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 1, 3, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 1, 4, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 3, 2, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 3, 1, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 3, 4, 17, 31));
			allVariations.add(new Symbol(2, 7, 4, 1, 3, 3, 17, 31));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 5, 1, 3, 1, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 2, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 3, 4, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 2, 1, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 3, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 2, 4, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 1, 4, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 3, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 2, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 1, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 1, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 5, 1, 1, 1, 28, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 6, 1, 3, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 3, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 1, 1, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 2, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 1, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 1, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 2, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 1, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 2, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 3, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 3, 1, 36, 23));
			allVariations.add(new Symbol(2, 7, 6, 1, 2, 1, 36, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 7, 1, 1, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 3, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 1, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 2, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 1, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 2, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 3, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 2, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 3, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 2, 1, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 1, 1, 40, 25));
			allVariations.add(new Symbol(2, 7, 7, 1, 3, 1, 40, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 9, 1, 3, 1, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 1, 3, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 2, 2, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 1, 2, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 2, 1, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 1, 1, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 2, 4, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 2, 3, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 3, 4, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 3, 3, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 3, 2, 13, 23));
			allVariations.add(new Symbol(2, 7, 9, 1, 1, 4, 13, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 10, 1, 1, 3, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 1, 4, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 1, 1, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 1, 2, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 3, 4, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 2, 4, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 3, 3, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 2, 3, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 2, 2, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 2, 1, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 3, 2, 13, 36));
			allVariations.add(new Symbol(2, 7, 10, 1, 3, 1, 13, 36));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 11, 1, 1, 2, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 1, 3, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 2, 3, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 1, 4, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 2, 4, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 2, 1, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 2, 2, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 1, 1, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 3, 1, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 3, 3, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 3, 2, 20, 47));
			allVariations.add(new Symbol(2, 7, 11, 1, 3, 4, 20, 47));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 12, 1, 1, 3, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 3, 1, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 2, 2, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 1, 4, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 3, 2, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 2, 3, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 3, 3, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 3, 4, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 2, 1, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 1, 1, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 2, 4, 19, 36));
			allVariations.add(new Symbol(2, 7, 12, 1, 1, 2, 19, 36));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 13, 1, 3, 1, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 2, 4, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 1, 1, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 2, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 2, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 1, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 2, 1, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 1, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 3, 3, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 1, 4, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 3, 2, 28, 23));
			allVariations.add(new Symbol(2, 7, 13, 1, 3, 4, 28, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 14, 1, 2, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 2, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 2, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 3, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 3, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 3, 1, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 1, 4, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 3, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 1, 3, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 1, 2, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 2, 1, 36, 23));
			allVariations.add(new Symbol(2, 7, 14, 1, 1, 1, 36, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 15, 1, 2, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 2, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 1, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 3, 1, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 1, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 3, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 1, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 3, 3, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 1, 1, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 3, 4, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 2, 2, 40, 25));
			allVariations.add(new Symbol(2, 7, 15, 1, 2, 1, 40, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 2, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 1, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 10, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 8, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 9, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 6, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 4, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 5, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 16, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 14, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 13, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 12, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 16, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 13, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 14, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 1, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 2, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 4, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 1, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 2, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 9, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 10, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 4, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 5, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 12, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 6, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 5, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 6, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 8, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 9, 22, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 3, 8, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 1, 10, 32, 31));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 16, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 13, 21, 37));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 12, 31, 32));
			allVariations.add(new Symbol(2, 7, 16, 1, 2, 14, 32, 31));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 1, 26, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 8, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 12, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 9, 26, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 13, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 6, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 14, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 4, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 16, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 5, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 2, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 5, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 4, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 6, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 9, 26, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 8, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 10, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 1, 26, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 2, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 12, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 13, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 10, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 16, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 16, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 14, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 1, 14, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 12, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 3, 13, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 6, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 5, 24, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 4, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 10, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 9, 26, 51));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 8, 45, 41));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 2, 41, 45));
			allVariations.add(new Symbol(2, 7, 16, 2, 2, 1, 26, 51));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 9, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 4, 46, 47));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 10, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 1, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 2, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 8, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 5, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 8, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 6, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 5, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 6, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 4, 46, 47));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 1, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 2, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 16, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 14, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 13, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 12, 46, 47));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 10, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 6, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 13, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 14, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 8, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 9, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 12, 46, 47));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 2, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 4, 46, 47));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 5, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 3, 16, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 2, 1, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 14, 47, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 13, 35, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 16, 46, 49));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 10, 49, 46));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 9, 38, 51));
			allVariations.add(new Symbol(2, 7, 16, 3, 1, 12, 46, 47));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup8(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 8 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==8";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 4, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 5, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 6, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 7, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 5, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 3, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 4, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 4, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 7, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 5, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 3, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 6, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 6, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 1, 19, 23));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 7, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 4, 8, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 2, 2, 19, 23));
			allVariations.add(new Symbol(2, 8, 1, 1, 6, 8, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 6, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 5, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 4, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 5, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 6, 17, 19));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 7, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 3, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 6, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 7, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 4, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 5, 14, 24));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 4, 20, 16));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 7, 18, 12));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 2, 19, 23));
			allVariations.add(new Symbol(2, 8, 1, 1, 5, 8, 22, 14));
			allVariations.add(new Symbol(2, 8, 1, 1, 3, 1, 19, 23));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 2, 19, 23));
			allVariations.add(new Symbol(2, 8, 1, 1, 1, 1, 19, 23));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 7, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 8, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 4, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 3, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 4, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 6, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 5, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 8, 29, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 6, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 3, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 2, 7, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 5, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 4, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 8, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 5, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 6, 6, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 4, 7, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 6, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 7, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 8, 29, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 4, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 5, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 1, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 5, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 4, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 3, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 7, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 6, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 5, 19, 33));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 4, 30, 23));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 8, 28, 18));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 7, 23, 15));
			allVariations.add(new Symbol(2, 8, 1, 2, 5, 6, 21, 24));
			allVariations.add(new Symbol(2, 8, 1, 2, 3, 8, 29, 20));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 4, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 5, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 2, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 3, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 2, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 3, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 1, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 1, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 6, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 7, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 4, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 5, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 8, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 6, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 1, 8, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 3, 7, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 3, 28, 12));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 4, 26, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 5, 14, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 6, 14, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 1, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 2, 26, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 3, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 1, 17, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 4, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 2, 17, 24));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 5, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 6, 20, 31));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 7, 31, 19));
			allVariations.add(new Symbol(2, 8, 2, 1, 2, 8, 31, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 7, 26, 14));
			allVariations.add(new Symbol(2, 8, 2, 1, 4, 8, 28, 12));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 7, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 8, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 5, 25, 36));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 6, 25, 36));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 8, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 7, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 6, 25, 36));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 3, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 5, 25, 36));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 4, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 4, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 1, 3, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 3, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 6, 18, 28));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 7, 34, 15));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 3, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 8, 36, 16));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 8, 40, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 1, 20, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 2, 20, 33));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 5, 25, 36));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 4, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 3, 37, 17));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 7, 39, 20));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 4, 34, 15));
			allVariations.add(new Symbol(2, 8, 2, 2, 4, 5, 18, 28));
			allVariations.add(new Symbol(2, 8, 2, 2, 2, 6, 25, 36));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 3, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 4, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 5, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 6, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 5, 19, 29));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 7, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 6, 19, 29));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 8, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 7, 35, 19));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 8, 38, 21));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 1, 24, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 2, 24, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 3, 38, 21));
			allVariations.add(new Symbol(2, 8, 2, 3, 4, 4, 35, 19));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 1, 33, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 2, 2, 33, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 4, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 5, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 2, 33, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 8, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 3, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 6, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 8, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 7, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 4, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 6, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 5, 26, 36));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 7, 40, 24));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 2, 33, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 3, 41, 23));
			allVariations.add(new Symbol(2, 8, 2, 3, 3, 1, 33, 32));
			allVariations.add(new Symbol(2, 8, 2, 3, 1, 1, 33, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 8, 53, 21));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 7, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 6, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 5, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 4, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 3, 53, 21));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 2, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 2, 1, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 1, 27, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 2, 27, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 3, 50, 18));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 4, 48, 17));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 5, 26, 39));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 6, 26, 39));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 7, 48, 17));
			allVariations.add(new Symbol(2, 8, 2, 4, 4, 8, 49, 17));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 6, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 5, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 8, 53, 21));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 7, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 2, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 1, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 4, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 1, 3, 53, 21));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 1, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 2, 38, 41));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 5, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 6, 33, 47));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 3, 53, 21));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 4, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 7, 53, 22));
			allVariations.add(new Symbol(2, 8, 2, 4, 3, 8, 53, 21));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 8, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 7, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 6, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 5, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 4, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 3, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 1, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 6, 7, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 7, 21, 17));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 4, 21, 17));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 5, 7, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 3, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 4, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 2, 10, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 4, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 5, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 3, 26, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 5, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 6, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 3, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 1, 10, 26));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 7, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 8, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 3, 8, 28, 21));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 6, 14, 28));
			allVariations.add(new Symbol(2, 8, 3, 1, 2, 7, 24, 20));
			allVariations.add(new Symbol(2, 8, 3, 1, 4, 8, 25, 19));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 7, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 8, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 5, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 6, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 3, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 4, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 1, 22, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 2, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 4, 28, 22));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 3, 30, 23));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 6, 11, 29));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 5, 11, 29));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 2, 11, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 1, 11, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 8, 29, 22));
			allVariations.add(new Symbol(2, 8, 3, 2, 4, 7, 28, 22));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 4, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 5, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 6, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 7, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 6, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 8, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 7, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 8, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 3, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 4, 32, 25));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 5, 19, 38));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 1, 22, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 3, 2, 1, 3, 31, 24));
			allVariations.add(new Symbol(2, 8, 3, 2, 3, 1, 22, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 4, 26, 22));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 5, 7, 29));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 2, 10, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 3, 31, 25));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 2, 19, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 1, 10, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 3, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 1, 19, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 6, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 7, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 4, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 5, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 8, 31, 25));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 6, 7, 29));
			allVariations.add(new Symbol(2, 8, 3, 3, 2, 8, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 4, 7, 27, 23));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 8, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 7, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 1, 19, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 4, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 2, 19, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 3, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 3, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 6, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 4, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 5, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 5, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 6, 14, 36));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 7, 30, 26));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 2, 19, 34));
			allVariations.add(new Symbol(2, 8, 3, 3, 3, 8, 34, 27));
			allVariations.add(new Symbol(2, 8, 3, 3, 1, 1, 19, 34));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 7, 35, 29));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 1, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 8, 36, 29));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 5, 11, 39));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 6, 11, 39));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 8, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 7, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 6, 19, 48));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 3, 36, 29));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 5, 19, 48));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 4, 35, 29));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 4, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 1, 11, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 2, 3, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 4, 2, 11, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 1, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 3, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 1, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 3, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 8, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 5, 19, 48));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 4, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 7, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 5, 19, 48));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 6, 19, 48));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 4, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 7, 40, 33));
			allVariations.add(new Symbol(2, 8, 3, 4, 1, 8, 37, 30));
			allVariations.add(new Symbol(2, 8, 3, 4, 3, 6, 19, 48));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 4, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 5, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 2, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 3, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 8, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 1, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 3, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 2, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 1, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 8, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 7, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 6, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 6, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 5, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 3, 4, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 1, 7, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 3, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 4, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 5, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 6, 20, 35));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 1, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 2, 23, 30));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 2, 13, 23));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 1, 13, 23));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 4, 29, 20));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 3, 33, 16));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 7, 33, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 6, 13, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 2, 8, 39, 22));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 5, 13, 26));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 8, 32, 15));
			allVariations.add(new Symbol(2, 8, 4, 1, 4, 7, 29, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 7, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 8, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 5, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 6, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 7, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 8, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 5, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 6, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 3, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 4, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 1, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 3, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 4, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 3, 2, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 1, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 1, 2, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 6, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 7, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 8, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 8, 38, 18));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 4, 38, 18));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 5, 20, 32));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 6, 20, 32));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 1, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 7, 38, 18));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 2, 33, 40));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 3, 46, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 1, 20, 31));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 4, 42, 21));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 2, 20, 31));
			allVariations.add(new Symbol(2, 8, 4, 2, 2, 5, 27, 41));
			allVariations.add(new Symbol(2, 8, 4, 2, 4, 3, 39, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 5, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 6, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 1, 13, 21));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 4, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 7, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 7, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 6, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 5, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 7, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 4, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 2, 13, 21));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 1, 13, 21));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 6, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 4, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 1, 5, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 3, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 2, 13, 21));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 4, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 5, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 6, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 4, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 7, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 5, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 4, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 6, 10, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 6, 7, 17, 15));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 8, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 7, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 6, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 5, 27, 24));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 4, 22, 22));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 3, 25, 18));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 2, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 2, 13, 21));
			allVariations.add(new Symbol(2, 8, 5, 1, 5, 1, 13, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 4, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 3, 31, 25));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 2, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 1, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 1, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 2, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 3, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 8, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 2, 40, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 7, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 1, 40, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 6, 39, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 5, 39, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 7, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 4, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 6, 39, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 3, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 5, 38, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 2, 41, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 4, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 7, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 4, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 1, 8, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 8, 31, 25));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 1, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 2, 23, 21));
			allVariations.add(new Symbol(2, 8, 6, 1, 5, 3, 31, 25));
			allVariations.add(new Symbol(2, 8, 6, 1, 3, 1, 41, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 2, 41, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 8, 31, 25));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 1, 41, 23));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 7, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 4, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 3, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 6, 39, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 4, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 5, 39, 24));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 3, 31, 25));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 8, 35, 28));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 2, 7, 32, 30));
			allVariations.add(new Symbol(2, 8, 6, 1, 4, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 7, 24, 22));
			allVariations.add(new Symbol(2, 8, 6, 1, 6, 8, 31, 25));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 4, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 8, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 6, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 7, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 8, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 7, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 7, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 8, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 2, 40, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 3, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 4, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 5, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 2, 40, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 1, 40, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 1, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 4, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 3, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 4, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 3, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 2, 40, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 1, 40, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 8, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 7, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 6, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 1, 5, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 7, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 8, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 7, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 8, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 5, 6, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 5, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 6, 43, 25));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 3, 33, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 3, 4, 32, 28));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 1, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 3, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 4, 1, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 5, 20, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 4, 29, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 3, 27, 24));
			allVariations.add(new Symbol(2, 8, 7, 1, 6, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 7, 1, 2, 1, 40, 24));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 6, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 5, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 8, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 7, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 8, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 7, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 3, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 4, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 5, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 3, 23, 18));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 5, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 6, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 7, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 8, 23, 18));
			allVariations.add(new Symbol(2, 8, 8, 1, 1, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 3, 23, 18));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 7, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 6, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 5, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 8, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 7, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 5, 6, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 3, 8, 23, 18));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 5, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 6, 17, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 3, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 4, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 3, 18, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 6, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 4, 19, 13));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 1, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 4, 2, 20, 16));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 5, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 6, 18, 26));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 3, 23, 18));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 7, 27, 17));
			allVariations.add(new Symbol(2, 8, 8, 1, 2, 8, 23, 18));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 1, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 7, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 3, 26, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 5, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 6, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 4, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 6, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 5, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 7, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 6, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 7, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 1, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 2, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 3, 26, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 1, 4, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 2, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 3, 1, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 4, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 4, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 5, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 2, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 6, 3, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 1, 25, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 6, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 7, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 7, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 6, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 4, 24, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 6, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 5, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 7, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 5, 5, 21, 20));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 4, 32, 19));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 5, 21, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 4, 8, 23, 16));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 2, 23, 29));
			allVariations.add(new Symbol(2, 8, 8, 2, 2, 3, 26, 19));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 6, 13, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 7, 22, 12));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 8, 20, 9));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 5, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 4, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 7, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 6, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 8, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 3, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 4, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 8, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 7, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 6, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 8, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 3, 5, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 7, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 6, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 5, 23, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 4, 29, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 1, 3, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 2, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 1, 13, 16));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 3, 28, 15));
			allVariations.add(new Symbol(2, 8, 9, 1, 2, 1, 23, 26));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 4, 22, 12));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 5, 13, 24));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 2, 13, 16));
			allVariations.add(new Symbol(2, 8, 9, 1, 4, 3, 20, 9));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 6, 23, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 8, 36, 18));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 5, 23, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 7, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 8, 29, 13));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 7, 35, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 8, 36, 18));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 4, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 7, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 3, 36, 18));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 6, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 5, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 6, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 5, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 4, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 2, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 6, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 7, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 8, 36, 18));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 3, 36, 18));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 4, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 1, 5, 27, 28));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 3, 30, 13));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 4, 36, 15));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 1, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 1, 24, 25));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 2, 31, 33));
			allVariations.add(new Symbol(2, 8, 9, 2, 4, 2, 24, 25));
			allVariations.add(new Symbol(2, 8, 9, 2, 3, 3, 36, 18));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 1, 22, 24));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 3, 32, 12));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 2, 22, 24));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 1, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 7, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 1, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 8, 38, 17));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 2, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 3, 38, 17));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 4, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 3, 38, 17));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 5, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 4, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 6, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 5, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 7, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 6, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 1, 8, 38, 17));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 2, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 3, 1, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 6, 25, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 8, 38, 17));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 7, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 6, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 4, 38, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 5, 25, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 7, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 4, 40, 15));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 5, 29, 34));
			allVariations.add(new Symbol(2, 8, 9, 3, 4, 8, 32, 12));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 2, 29, 31));
			allVariations.add(new Symbol(2, 8, 9, 3, 2, 3, 38, 17));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 4, 51, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 6, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 3, 40, 14));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 5, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 6, 31, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 8, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 5, 31, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 7, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 8, 40, 14));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 2, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 7, 51, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 1, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 4, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 2, 3, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 1, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 8, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 7, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 8, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 6, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 5, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 4, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 3, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 3, 2, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 2, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 3, 47, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 1, 39, 43));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 6, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 7, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 4, 53, 19));
			allVariations.add(new Symbol(2, 8, 9, 4, 1, 5, 35, 39));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 1, 32, 35));
			allVariations.add(new Symbol(2, 8, 9, 4, 4, 2, 31, 35));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 8, 20, 15));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 7, 26, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 7, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 6, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 5, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 3, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 4, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 5, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 3, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 7, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 6, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 3, 8, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 5, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 4, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 7, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 1, 6, 18, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 3, 26, 19));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 1, 11, 20));
			allVariations.add(new Symbol(2, 8, 10, 1, 2, 4, 28, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 2, 13, 20));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 3, 20, 15));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 4, 26, 18));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 5, 14, 28));
			allVariations.add(new Symbol(2, 8, 10, 1, 4, 6, 14, 28));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 3, 27, 21));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 2, 13, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 5, 17, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 4, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 1, 12, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 1, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 3, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 4, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 3, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 6, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 5, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 8, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 7, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 5, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 6, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 7, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 8, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 1, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 1, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 3, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 4, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 1, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 3, 2, 22, 32));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 7, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 6, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 5, 23, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 4, 37, 25));
			allVariations.add(new Symbol(2, 8, 10, 2, 2, 8, 34, 26));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 8, 28, 21));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 6, 16, 38));
			allVariations.add(new Symbol(2, 8, 10, 2, 4, 7, 34, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 1, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 2, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 1, 13, 28));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 2, 13, 28));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 3, 26, 20));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 4, 34, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 1, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 5, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 7, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 4, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 6, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 7, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 6, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 8, 32, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 3, 32, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 8, 32, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 2, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 5, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 1, 4, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 2, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 3, 32, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 3, 1, 20, 34));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 8, 26, 20));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 7, 33, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 6, 14, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 8, 32, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 4, 5, 15, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 7, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 6, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 5, 18, 38));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 4, 35, 25));
			allVariations.add(new Symbol(2, 8, 10, 3, 2, 3, 32, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 8, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 6, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 7, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 7, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 8, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 4, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 3, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 3, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 6, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 4, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 5, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 5, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 1, 13, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 2, 19, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 3, 34, 27));
			allVariations.add(new Symbol(2, 8, 10, 4, 3, 1, 22, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 7, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 8, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 5, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 8, 33, 27));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 6, 23, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 7, 42, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 3, 41, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 6, 16, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 4, 45, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 5, 16, 49));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 1, 22, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 4, 4, 42, 33));
			allVariations.add(new Symbol(2, 8, 10, 4, 1, 2, 22, 40));
			allVariations.add(new Symbol(2, 8, 10, 4, 2, 1, 22, 40));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 3, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 4, 29, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 5, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 6, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 1, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 2, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 8, 25, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 7, 29, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 4, 29, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 6, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 3, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 2, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 8, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 1, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 5, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 6, 17, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 6, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 7, 23, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 7, 29, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 4, 23, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 1, 8, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 5, 20, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 2, 19, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 3, 27, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 4, 1, 19, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 1, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 3, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 2, 24, 26));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 5, 22, 24));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 8, 32, 22));
			allVariations.add(new Symbol(2, 8, 11, 1, 2, 4, 29, 19));
			allVariations.add(new Symbol(2, 8, 11, 1, 3, 7, 29, 19));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 7, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 8, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 5, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 6, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 3, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 1, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 2, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 1, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 5, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 8, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 4, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 7, 37, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 3, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 2, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 8, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 6, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 7, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 3, 8, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 4, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 5, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 6, 29, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 1, 7, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 2, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 1, 36, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 4, 38, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 2, 30, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 2, 3, 39, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 1, 30, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 4, 37, 23));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 3, 38, 24));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 6, 25, 39));
			allVariations.add(new Symbol(2, 8, 11, 2, 4, 5, 24, 39));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 3, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 3, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 5, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 1, 13, 21));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 5, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 7, 27, 17));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 6, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 6, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 7, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 8, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 2, 13, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 3, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 4, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 5, 5, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 7, 27, 17));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 8, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 2, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 1, 26, 23));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 1, 13, 21));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 6, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 2, 13, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 5, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 4, 27, 17));
			allVariations.add(new Symbol(2, 8, 12, 1, 2, 3, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 5, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 7, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 6, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 8, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 3, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 5, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 4, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 6, 12, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 3, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 4, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 7, 22, 13));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 1, 13, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 6, 8, 19, 14));
			allVariations.add(new Symbol(2, 8, 12, 1, 4, 2, 13, 22));
			allVariations.add(new Symbol(2, 8, 12, 1, 3, 8, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 8, 23, 19));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 6, 33, 24));
			allVariations.add(new Symbol(2, 8, 12, 1, 1, 7, 27, 17));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 3, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 5, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 4, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 6, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 1, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 3, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 4, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 7, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 1, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 8, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 5, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 3, 6, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 7, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 6, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 5, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 8, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 4, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 8, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 3, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 6, 1, 23, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 1, 23, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 4, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 5, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 3, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 6, 44, 24));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 4, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 7, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 5, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 6, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 1, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 7, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 13, 1, 4, 8, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 2, 3, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 4, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 3, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 6, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 5, 24, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 8, 26, 21));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 8, 34, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 7, 31, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 1, 7, 40, 30));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 2, 23, 22));
			allVariations.add(new Symbol(2, 8, 13, 1, 5, 1, 23, 22));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 7, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 6, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 5, 43, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 4, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 3, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 1, 43, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 1, 8, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 1, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 8, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 2, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 7, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 6, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 5, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 5, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 7, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 4, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 6, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 8, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 5, 43, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 2, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 4, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 6, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 6, 1, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 3, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 4, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 1, 43, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 7, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 2, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 4, 8, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 1, 43, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 1, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 2, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 3, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 4, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 6, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 5, 26, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 7, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 6, 21, 22));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 8, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 7, 29, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 5, 8, 29, 20));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 2, 39, 23));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 3, 38, 28));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 4, 35, 33));
			allVariations.add(new Symbol(2, 8, 14, 1, 3, 5, 43, 23));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup9(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 9 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==9";

		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 13, 19, 7));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 14, 16, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 15, 17, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 16, 15, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 2, 15, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 1, 21, 8));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 4, 13, 11));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 3, 17, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 10, 15, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 9, 21, 8));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 12, 13, 11));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 11, 17, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 6, 16, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 5, 19, 7));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 8, 15, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 4, 7, 17, 12));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 6, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 7, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 8, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 9, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 2, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 3, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 4, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 5, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 1, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 15, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 14, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 16, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 11, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 10, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 13, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 1, 12, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 5, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 6, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 3, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 4, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 9, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 10, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 7, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 8, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 1, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 2, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 14, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 13, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 12, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 11, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 16, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 2, 15, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 4, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 5, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 6, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 7, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 8, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 9, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 10, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 11, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 1, 22, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 2, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 3, 19, 16));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 13, 21, 9));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 12, 19, 15));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 15, 20, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 14, 21, 17));
			allVariations.add(new Symbol(2, 9, 1, 1, 3, 16, 20, 17));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 10, 27, 21));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 9, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 12, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 11, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 14, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 13, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 16, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 15, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 1, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 2, 27, 21));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 3, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 4, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 5, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 6, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 7, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 1, 8, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 14, 19, 14));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 15, 20, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 12, 15, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 13, 26, 10));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 16, 15, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 3, 20, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 2, 21, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 1, 26, 9));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 7, 20, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 6, 19, 14));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 5, 26, 10));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 4, 15, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 11, 20, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 10, 21, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 9, 26, 9));
			allVariations.add(new Symbol(2, 9, 1, 2, 4, 8, 15, 16));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 15, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 16, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 11, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 12, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 13, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 14, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 2, 27, 21));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 1, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 8, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 7, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 10, 27, 21));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 9, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 4, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 3, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 6, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 3, 5, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 16, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 14, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 15, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 12, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 13, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 10, 27, 21));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 11, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 1, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 9, 29, 12));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 8, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 7, 22, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 6, 26, 22));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 5, 29, 13));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 4, 23, 17));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 3, 23, 20));
			allVariations.add(new Symbol(2, 9, 1, 2, 2, 2, 27, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 13, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 12, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 15, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 14, 29, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 9, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 8, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 11, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 10, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 16, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 4, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 5, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 6, 29, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 7, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 1, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 2, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 1, 3, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 15, 23, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 16, 19, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 13, 36, 11));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 14, 22, 17));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 11, 24, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 12, 21, 15));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 10, 23, 15));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 9, 36, 11));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 8, 19, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 7, 23, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 6, 22, 17));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 5, 36, 11));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 4, 21, 15));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 3, 24, 18));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 2, 23, 15));
			allVariations.add(new Symbol(2, 9, 1, 3, 4, 1, 36, 11));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 11, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 10, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 13, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 12, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 15, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 14, 29, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 16, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 1, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 2, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 3, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 4, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 5, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 6, 29, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 7, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 8, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 3, 9, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 12, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 11, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 10, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 9, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 16, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 15, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 14, 29, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 13, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 3, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 4, 29, 20));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 1, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 2, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 7, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 8, 27, 25));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 5, 39, 14));
			allVariations.add(new Symbol(2, 9, 1, 3, 2, 6, 29, 25));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 4, 25, 20));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 5, 43, 12));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 2, 27, 18));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 3, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 8, 26, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 9, 43, 12));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 6, 26, 21));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 7, 28, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 1, 43, 12));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 13, 43, 12));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 12, 25, 20));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 11, 29, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 10, 27, 18));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 16, 26, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 15, 28, 23));
			allVariations.add(new Symbol(2, 9, 1, 4, 4, 14, 26, 21));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 5, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 6, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 7, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 8, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 1, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 2, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 3, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 4, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 14, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 13, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 16, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 15, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 10, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 9, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 12, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 3, 11, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 6, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 6, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 5, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 7, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 4, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 4, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 3, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 5, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 2, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 2, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 1, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 3, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 1, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 15, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 16, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 16, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 13, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 15, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 14, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 14, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 11, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 13, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 12, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 12, 34, 24));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 9, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 11, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 10, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 10, 34, 27));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 7, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 9, 46, 15));
			allVariations.add(new Symbol(2, 9, 1, 4, 1, 8, 34, 30));
			allVariations.add(new Symbol(2, 9, 1, 4, 2, 8, 34, 30));
		} else if (baseSymbol.equals(MovementBaseSymbol.CURVE_FLOOR_PLANE_COMBINED.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 11, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 12, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 13, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 14, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 7, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 8, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 9, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 10, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 15, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 16, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 4, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 3, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 6, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 5, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 2, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 2, 1, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 14, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 15, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 12, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 13, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 10, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 11, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 8, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 9, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 7, 36, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 8, 38, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 5, 45, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 6, 45, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 3, 35, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 4, 35, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 16, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 1, 38, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 2, 43, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 16, 38, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 15, 36, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 14, 45, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 13, 45, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 12, 35, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 11, 35, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 10, 43, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 4, 9, 38, 16));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 7, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 6, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 5, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 4, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 3, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 2, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 3, 1, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 8, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 9, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 6, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 7, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 12, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 13, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 10, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 11, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 16, 45, 19));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 14, 45, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 15, 43, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 1, 38, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 5, 45, 22));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 4, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 3, 43, 20));
			allVariations.add(new Symbol(2, 9, 1, 5, 1, 2, 43, 20));
		} else if (baseSymbol.equals(MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 7, 16, 29));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 15, 16, 29));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 2, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 7, 16, 29));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 1, 15, 16, 29));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 12, 24, 24));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 13, 37, 10));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 10, 21, 20));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 11, 13, 26));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 8, 20, 21));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 9, 37, 9));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 6, 24, 26));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 7, 13, 24));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 4, 24, 24));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 5, 37, 10));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 2, 21, 20));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 3, 13, 26));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 1, 37, 9));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 16, 20, 21));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 15, 13, 24));
			allVariations.add(new Symbol(2, 9, 2, 1, 4, 14, 24, 26));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 7, 16, 29));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 2, 1, 3, 15, 16, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 7, 16, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 15, 16, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 2, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 7, 16, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 15, 16, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 3, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 5, 36, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 6, 24, 26));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 3, 13, 26));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 4, 24, 24));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 1, 36, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 2, 21, 20));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 13, 36, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 14, 24, 26));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 11, 13, 26));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 12, 24, 24));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 9, 36, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 10, 21, 20));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 7, 13, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 8, 20, 21));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 16, 20, 21));
			allVariations.add(new Symbol(2, 9, 3, 1, 4, 15, 13, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 9, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 11, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 5, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 4, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 7, 16, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 6, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 1, 40, 11));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 3, 20, 30));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 12, 32, 28));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 13, 40, 12));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 14, 24, 32));
			allVariations.add(new Symbol(2, 9, 3, 1, 1, 15, 16, 32));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SNAKE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 2, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 3, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 4, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 5, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 1, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 10, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 11, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 12, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 13, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 6, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 7, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 8, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 9, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 15, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 14, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 2, 16, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 3, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 4, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 1, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 2, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 11, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 12, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 9, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 10, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 7, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 8, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 5, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 6, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 16, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 15, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 14, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 1, 13, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 15, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 16, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 12, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 11, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 14, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 13, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 8, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 7, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 10, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 9, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 4, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 3, 13, 49));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 6, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 5, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 2, 34, 34));
			allVariations.add(new Symbol(2, 9, 4, 1, 3, 1, 49, 13));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 16, 28, 29));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 15, 9, 42));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 14, 29, 28));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 13, 42, 9));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 12, 28, 29));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 11, 9, 42));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 10, 29, 28));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 9, 42, 9));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 8, 28, 29));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 7, 9, 42));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 6, 29, 28));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 5, 42, 9));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 4, 28, 29));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 3, 9, 42));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 2, 29, 28));
			allVariations.add(new Symbol(2, 9, 4, 1, 4, 1, 42, 9));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 5, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 6, 26, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 7, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 8, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 9, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 10, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 11, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 12, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 1, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 2, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 3, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 4, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 14, 26, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 13, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 16, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 2, 15, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 6, 26, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 7, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 4, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 5, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 10, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 11, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 8, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 9, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 2, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 3, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 1, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 15, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 14, 26, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 13, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 12, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 1, 16, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 11, 15, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 12, 25, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 13, 36, 10));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 14, 26, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 7, 15, 34));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 8, 24, 23));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 9, 36, 10));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 10, 25, 23));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 3, 15, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 4, 25, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 5, 36, 10));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 6, 26, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 1, 36, 10));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 2, 25, 23));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 16, 24, 23));
			allVariations.add(new Symbol(2, 9, 4, 2, 4, 15, 15, 34));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 12, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 13, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 10, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 11, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 8, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 9, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 6, 26, 35));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 7, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 4, 33, 33));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 5, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 2, 31, 30));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 3, 18, 39));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 1, 42, 16));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 16, 31, 29));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 15, 16, 40));
			allVariations.add(new Symbol(2, 9, 4, 2, 3, 14, 26, 35));
		} else if (baseSymbol.equals(MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 16, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 15, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 14, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 13, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 12, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 11, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 9, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 10, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 7, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 8, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 5, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 6, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 3, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 4, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 1, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 1, 2, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 16, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 13, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 12, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 15, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 14, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 8, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 9, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 10, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 11, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 4, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 5, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 6, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 7, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 1, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 2, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 2, 3, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 15, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 16, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 13, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 14, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 4, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 3, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 2, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 1, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 8, 42, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 7, 21, 51));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 6, 36, 47));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 5, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 12, 41, 41));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 11, 21, 50));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 10, 40, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 3, 9, 50, 21));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 14, 36, 40));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 15, 20, 45));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 16, 33, 34));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 1, 44, 20));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 3, 20, 45));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 2, 33, 28));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 5, 44, 20));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 4, 32, 36));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 7, 20, 45));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 6, 36, 40));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 9, 44, 20));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 8, 33, 34));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 11, 20, 45));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 10, 33, 28));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 13, 44, 20));
			allVariations.add(new Symbol(2, 9, 4, 3, 4, 12, 32, 36));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 16, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 4, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 5, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 6, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 7, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 1, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 2, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 3, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 12, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 13, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 14, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 15, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 8, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 9, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 10, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 3, 11, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 16, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 15, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 5, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 6, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 16, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 3, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 15, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 4, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 14, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 1, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 13, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 2, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 12, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 11, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 10, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 13, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 9, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 14, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 8, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 11, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 7, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 12, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 6, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 9, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 5, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 10, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 4, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 7, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 3, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 2, 8, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 15, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 14, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 16, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 1, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 6, 2, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 11, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 10, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 13, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 1, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 12, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 2, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 15, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 3, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 14, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 4, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 5, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 16, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 6, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 3, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 7, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 2, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 8, 20, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 5, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 9, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 4, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 10, 21, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 7, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 11, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 6, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 12, 19, 24));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 9, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 1, 13, 21, 21));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 8, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 5, 1, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 12, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 11, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 10, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 9, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 16, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 15, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 14, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 13, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 4, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 3, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 2, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 1, 23, 8));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 8, 18, 20));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 7, 8, 23));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 6, 20, 18));
			allVariations.add(new Symbol(2, 9, 5, 1, 4, 5, 23, 8));
		} else if (baseSymbol.equals(MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 9, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 8, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 11, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 10, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 13, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 12, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 15, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 14, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 1, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 3, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 2, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 5, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 4, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 7, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 6, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 6, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 7, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 4, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 5, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 10, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 11, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 8, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 9, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 2, 16, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 14, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 15, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 12, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 13, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 16, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 10, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 9, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 8, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 7, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 14, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 13, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 12, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 11, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 2, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 1, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 1, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 6, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 5, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 3, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 4, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 6, 2, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 3, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 3, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 4, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 5, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 6, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 7, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 8, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 9, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 10, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 11, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 12, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 13, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 15, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 14, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 1, 16, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 15, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 16, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 15, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 14, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 16, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 11, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 10, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 13, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 12, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 7, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 6, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 9, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 8, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 3, 17, 23));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 2, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 5, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 4, 24, 26));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 1, 23, 17));
			allVariations.add(new Symbol(2, 9, 6, 1, 5, 2, 26, 24));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 16, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 15, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 14, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 13, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 12, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 11, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 10, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 9, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 8, 20, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 7, 20, 43));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 6, 21, 38));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 5, 21, 28));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 4, 19, 34));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 3, 19, 44));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 2, 21, 37));
			allVariations.add(new Symbol(2, 9, 6, 1, 3, 1, 21, 29));
			allVariations.add(new Symbol(2, 9, 6, 1, 4, 1, 23, 17));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 8, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 9, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 10, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 11, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 4, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 5, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 6, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 7, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 16, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 12, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 13, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 14, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 16, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 15, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 15, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 14, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 13, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 12, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 11, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 10, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 9, 23, 29));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 8, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 7, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 2, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 6, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 1, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 5, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 4, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 4, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 3, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 3, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 2, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 1, 1, 23, 29));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 9, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 10, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 7, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 8, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 5, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 6, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 3, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 4, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 15, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 16, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 13, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 14, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 11, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 12, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 3, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 2, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 5, 1, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 2, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 3, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 4, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 5, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 6, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 7, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 8, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 9, 23, 29));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 10, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 11, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 12, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 13, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 14, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 15, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 16, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 2, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 4, 1, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 16, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 3, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 4, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 15, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 14, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 1, 23, 29));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 13, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 2, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 7, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 8, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 5, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 6, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 11, 19, 45));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 8, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 12, 25, 36));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 7, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 6, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 9, 23, 29));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 10, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 5, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 15, 21, 40));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 12, 20, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 16, 25, 35));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 11, 16, 24));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 13, 23, 28));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 10, 28, 20));
			allVariations.add(new Symbol(2, 9, 7, 1, 2, 14, 25, 37));
			allVariations.add(new Symbol(2, 9, 7, 1, 6, 9, 24, 16));
			allVariations.add(new Symbol(2, 9, 7, 1, 3, 1, 23, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 1, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 6, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 5, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 8, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 7, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 13, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 2, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 14, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 1, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 15, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 4, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 16, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 3, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 9, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 14, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 10, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 13, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 11, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 16, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 12, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 15, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 5, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 10, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 6, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 9, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 7, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 12, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 8, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 1, 11, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 1, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 2, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 9, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 8, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 7, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 6, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 5, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 4, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 3, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 2, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 16, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 15, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 14, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 13, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 12, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 11, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 2, 10, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 1, 19, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 3, 32, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 2, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 11, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 12, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 13, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 14, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 15, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 16, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 3, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 4, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 5, 20, 34));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 6, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 7, 34, 20));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 8, 30, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 9, 20, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 3, 10, 27, 30));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 4, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 3, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 2, 22, 22));
			allVariations.add(new Symbol(2, 9, 8, 1, 5, 1, 19, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 14, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 15, 32, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 12, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 13, 19, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 16, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 6, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 7, 32, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 4, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 5, 19, 32));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 10, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 11, 32, 19));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 8, 27, 27));
			allVariations.add(new Symbol(2, 9, 8, 1, 4, 9, 19, 32));
		} else {
			throw new RuntimeException("not yet implemented");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup10(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 10 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==10";
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 2, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 4, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 10, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 2, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 8, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 6, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 8, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 6, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 4, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 12, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 10, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 16, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 14, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 16, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 13, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 12, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 14, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 3, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 1, 13, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 6, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 8, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 2, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 4, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 14, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 16, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 10, 23, 23));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 13, 23, 27));
			allVariations.add(new Symbol(2, 10, 1, 1, 2, 12, 23, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 12, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 10, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 16, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 15, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 14, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 4, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 2, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 8, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 6, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 3, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 16, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 10, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 8, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 12, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 10, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 14, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 12, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 16, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 14, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 15, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 15, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 2, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 4, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 2, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 6, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 4, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 2, 8, 29, 29));
			allVariations.add(new Symbol(2, 10, 1, 2, 1, 6, 29, 29));
		} else if (baseSymbol.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 10, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 8, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 6, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 4, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 2, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 16, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 13, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 14, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 2, 12, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 4, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 6, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 7, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 6, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 8, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 9, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 8, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 2, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 5, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 10, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 4, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 1, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 3, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 2, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 12, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 14, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 13, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 14, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 16, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 15, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 3, 16, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 10, 23, 27));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 11, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 12, 27, 23));
			allVariations.add(new Symbol(2, 10, 2, 1, 1, 13, 23, 27));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 4, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 2, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 8, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 6, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 12, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 10, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 16, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 15, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 2, 14, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 2, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 2, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 4, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 1, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 6, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 8, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 8, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 7, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 10, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 4, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 3, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 6, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 5, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 15, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 16, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 12, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 3, 14, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 10, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 9, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 12, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 11, 33, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 14, 29, 34));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 13, 29, 33));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 16, 34, 29));
			allVariations.add(new Symbol(2, 10, 2, 2, 1, 15, 33, 29));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 15, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 13, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 11, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 9, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 7, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 5, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 3, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 2, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 6, 1, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 3, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 15, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 1, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 5, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 3, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 9, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 7, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 13, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 11, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 4, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 15, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 2, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 1, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 3, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 6, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 5, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 8, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 7, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 10, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 9, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 12, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 11, 25, 16));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 14, 22, 20));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 16, 20, 22));
			allVariations.add(new Symbol(2, 10, 3, 1, 5, 13, 16, 25));
			allVariations.add(new Symbol(2, 10, 3, 1, 1, 15, 25, 15));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 3, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 13, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 5, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 6, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 2, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 13, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 5, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 3, 2, 1, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 5, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 5, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 3, 2, 4, 13, 16, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 3, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 15, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 6, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 2, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 15, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 5, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 1, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 15, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 3, 3, 4, 2, 30, 30));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 14, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 12, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 16, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 16, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 10, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 8, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 2, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 14, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 12, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 6, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 2, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 4, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 10, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 6, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 8, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 5, 4, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 1, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 14, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 16, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 10, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 12, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 14, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 2, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 16, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 4, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 2, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 6, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 4, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 8, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 6, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 10, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 8, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 2, 12, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 6, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 16, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 14, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 12, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 10, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 8, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 6, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 4, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 2, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 3, 1, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 15, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 16, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 12, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 11, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 14, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 13, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 8, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 7, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 10, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 9, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 4, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 3, 25, 15));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 6, 21, 22));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 5, 15, 25));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 2, 22, 21));
			allVariations.add(new Symbol(2, 10, 4, 1, 4, 1, 15, 25));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 5, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 1, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 13, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 5, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 5, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 13, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 2, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 6, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 15, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 13, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 7, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 5, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 11, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 9, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 3, 32, 15));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 1, 15, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 3, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 15, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 14, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 16, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 6, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 7, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 8, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 9, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 10, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 11, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 12, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 13, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 1, 16, 32));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 2, 24, 25));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 3, 32, 16));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 4, 25, 24));
			allVariations.add(new Symbol(2, 10, 4, 2, 4, 5, 16, 32));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 15, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 5, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 1, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 6, 15, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 2, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 3, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 1, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 11, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 9, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 7, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 5, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 15, 40, 15));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 13, 15, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 3, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 1, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 2, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 3, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 4, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 9, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 10, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 11, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 12, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 5, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 6, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 7, 40, 17));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 8, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 14, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 13, 17, 40));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 16, 30, 30));
			allVariations.add(new Symbol(2, 10, 4, 3, 4, 15, 40, 17));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 16, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 15, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 16, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 15, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 14, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 13, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 11, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 9, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 10, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 12, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 9, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 7, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 10, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 8, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 7, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 13, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 8, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 14, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 5, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 11, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 6, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 12, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 1, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 3, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 2, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 1, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 1, 2, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 5, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 6, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 3, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 3, 4, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 15, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 14, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 16, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 7, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 9, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 10, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 11, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 12, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 13, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 1, 17, 23));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 3, 23, 17));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 10, 5, 1, 2, 5, 17, 23));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 7, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 4, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 6, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 5, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 5, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 2, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 4, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 3, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 11, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 10, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 1, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 9, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 8, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 12, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 13, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 10, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 11, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 3, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 8, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 2, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 9, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 1, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 6, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 7, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 16, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 15, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 3, 14, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 14, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 15, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 12, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 13, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 1, 16, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 1, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 2, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 3, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 4, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 9, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 10, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 11, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 12, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 5, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 6, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 7, 23, 21));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 8, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 14, 22, 19));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 13, 21, 23));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 16, 19, 22));
			allVariations.add(new Symbol(2, 10, 5, 2, 2, 15, 23, 21));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 6, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 2, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 5, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 1, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 4, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 1, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 6, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 6, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 1, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 3, 18, 19));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 5, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 2, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 4, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 3, 18, 19));
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 5, 20, 18));
			allVariations.add(new Symbol(2, 10, 6, 1, 2, 3, 18, 19));
			allVariations.add(new Symbol(2, 10, 6, 1, 3, 2, 18, 20));
			allVariations.add(new Symbol(2, 10, 6, 1, 1, 4, 18, 20));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 6, 20, 22));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 5, 20, 21));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 6, 20, 21));
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 1, 21, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 2, 22, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 3, 21, 19));
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 3, 21, 19));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 4, 21, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 1, 21, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 2, 5, 20, 22));
			allVariations.add(new Symbol(2, 10, 6, 2, 1, 2, 21, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 2, 22, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 1, 21, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 4, 22, 20));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 3, 21, 19));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 6, 20, 22));
			allVariations.add(new Symbol(2, 10, 6, 2, 3, 5, 20, 22));
		} else if (baseSymbol.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 1, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 2, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 3, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 4, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 5, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 6, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 8, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 7, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 7, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 6, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 1, 8, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 5, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 4, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 3, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 2, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 1, 2, 1, 16, 10));
		} else if (baseSymbol.equals(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 4, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 1, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 3, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 6, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 5, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 5, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 4, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 2, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 3, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 1, 16, 10));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 2, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 8, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 7, 16, 17));
			allVariations.add(new Symbol(2, 10, 7, 2, 1, 6, 17, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 8, 10, 16));
			allVariations.add(new Symbol(2, 10, 7, 2, 2, 7, 16, 10));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 7, 18, 9));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 6, 22, 8));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 8, 18, 9));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 1, 7, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 3, 7, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 2, 7, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 5, 22, 8));
			allVariations.add(new Symbol(2, 10, 7, 3, 2, 4, 7, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 1, 9, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 2, 9, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 3, 9, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 4, 9, 22));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 5, 22, 10));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 6, 22, 10));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 7, 21, 10));
			allVariations.add(new Symbol(2, 10, 7, 3, 1, 8, 21, 10));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 8, 21, 10));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 7, 18, 9));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 8, 18, 9));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 5, 22, 8));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 6, 22, 8));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 4, 10, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 5, 22, 10));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 6, 22, 10));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 7, 21, 10));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 1, 10, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 2, 10, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 1, 3, 10, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 3, 8, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 4, 8, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 1, 8, 22));
			allVariations.add(new Symbol(2, 10, 7, 4, 2, 2, 8, 22));
		} else if (baseSymbol.equals(MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 8, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 3, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 2, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 1, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 2, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 1, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 7, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 2, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 6, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 1, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 5, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 4, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 1, 4, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 3, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 4, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 6, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 5, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 7, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 6, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 8, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 7, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 8, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 2, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 3, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 4, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 5, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 3, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 2, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 2, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 1, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 5, 1, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 4, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 3, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 6, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 5, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 8, 10, 10));
			allVariations.add(new Symbol(2, 10, 8, 1, 2, 7, 7, 13));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 7, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 8, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 5, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 7, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 6, 6, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 8, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 5, 14, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 6, 11, 11));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 3, 7, 14));
			allVariations.add(new Symbol(2, 10, 8, 1, 3, 1, 13, 7));
			allVariations.add(new Symbol(2, 10, 8, 1, 4, 4, 11, 11));
		} else if (baseSymbol.equals(MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 4, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 1, 18, 9));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 6, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 3, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 5, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 2, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 3, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 4, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 1, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 2, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 3, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 8, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 7, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 1, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 6, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 3, 5, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 8, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 1, 7, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 7, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 8, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 3, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 4, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 1, 18, 9));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 5, 18, 9));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 6, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 5, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 3, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 4, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 2, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 7, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 5, 18, 9));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 6, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 4, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 1, 16, 8));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 7, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 6, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 3, 8, 16));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 2, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 4, 8, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 2, 8, 12, 12));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 8, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 6, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 7, 9, 18));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 1, 18, 9));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 4, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 5, 2, 14, 14));
			allVariations.add(new Symbol(2, 10, 8, 2, 6, 5, 18, 9));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup1(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 1 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==1";
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.TOUCH_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 1, 1, 1, 1, 10, 11));
		} else if (baseSymbol.equals(MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 2, 1, 2, 4, 28, 27));
			allVariations.add(new Symbol(2, 1, 2, 1, 1, 1, 22, 11));
			allVariations.add(new Symbol(2, 1, 2, 1, 1, 2, 19, 19));
			allVariations.add(new Symbol(2, 1, 2, 1, 1, 3, 10, 24));
			allVariations.add(new Symbol(2, 1, 2, 1, 1, 4, 19, 19));
			allVariations.add(new Symbol(2, 1, 2, 1, 2, 3, 10, 37));
			allVariations.add(new Symbol(2, 1, 2, 1, 2, 2, 28, 27));
			allVariations.add(new Symbol(2, 1, 2, 1, 2, 1, 34, 11));
		} else if (baseSymbol.equals(MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 3, 1, 1, 4, 23, 22));
			allVariations.add(new Symbol(2, 1, 3, 1, 2, 3, 16, 32));
			allVariations.add(new Symbol(2, 1, 3, 1, 1, 1, 18, 15));
			allVariations.add(new Symbol(2, 1, 3, 1, 2, 4, 35, 33));
			allVariations.add(new Symbol(2, 1, 3, 1, 1, 2, 23, 22));
			allVariations.add(new Symbol(2, 1, 3, 1, 2, 1, 34, 15));
			allVariations.add(new Symbol(2, 1, 3, 1, 1, 3, 16, 17));
			allVariations.add(new Symbol(2, 1, 3, 1, 2, 2, 35, 33));
		} else if (baseSymbol.equals(MovementBaseSymbol.GRASP_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 4, 1, 1, 1, 10, 10));
		} else if (baseSymbol.equals(MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 5, 1, 1, 2, 18, 17));
			allVariations.add(new Symbol(2, 1, 5, 1, 1, 3, 10, 22));
			allVariations.add(new Symbol(2, 1, 5, 1, 1, 4, 18, 17));
			allVariations.add(new Symbol(2, 1, 5, 1, 2, 3, 10, 34));
			allVariations.add(new Symbol(2, 1, 5, 1, 2, 4, 26, 24));
			allVariations.add(new Symbol(2, 1, 5, 1, 2, 1, 34, 10));
			allVariations.add(new Symbol(2, 1, 5, 1, 2, 2, 26, 24));
			allVariations.add(new Symbol(2, 1, 5, 1, 1, 1, 22, 10));
		} else if (baseSymbol.equals(MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 6, 1, 1, 3, 16, 16));
			allVariations.add(new Symbol(2, 1, 6, 1, 1, 4, 21, 21));
			allVariations.add(new Symbol(2, 1, 6, 1, 1, 1, 18, 15));
			allVariations.add(new Symbol(2, 1, 6, 1, 1, 2, 21, 21));
			allVariations.add(new Symbol(2, 1, 6, 1, 2, 3, 16, 30));
			allVariations.add(new Symbol(2, 1, 6, 1, 2, 2, 31, 31));
			allVariations.add(new Symbol(2, 1, 6, 1, 2, 1, 34, 15));
			allVariations.add(new Symbol(2, 1, 6, 1, 2, 4, 31, 31));
		} else if (baseSymbol.equals(MovementBaseSymbol.STRIKE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 7, 1, 1, 1, 13, 13));
		} else if (baseSymbol.equals(MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 8, 1, 1, 4, 24, 24));
			allVariations.add(new Symbol(2, 1, 8, 1, 1, 3, 13, 28));
			allVariations.add(new Symbol(2, 1, 8, 1, 1, 2, 24, 24));
			allVariations.add(new Symbol(2, 1, 8, 1, 1, 1, 28, 13));
			allVariations.add(new Symbol(2, 1, 8, 1, 2, 3, 13, 43));
			allVariations.add(new Symbol(2, 1, 8, 1, 2, 2, 35, 35));
			allVariations.add(new Symbol(2, 1, 8, 1, 2, 4, 35, 35));
			allVariations.add(new Symbol(2, 1, 8, 1, 2, 1, 43, 13));
		} else if (baseSymbol.equals(MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 9, 1, 2, 1, 40, 15));
			allVariations.add(new Symbol(2, 1, 9, 1, 2, 2, 41, 41));
			allVariations.add(new Symbol(2, 1, 9, 1, 1, 1, 21, 15));
			allVariations.add(new Symbol(2, 1, 9, 1, 1, 2, 27, 27));
			allVariations.add(new Symbol(2, 1, 9, 1, 1, 3, 17, 19));
			allVariations.add(new Symbol(2, 1, 9, 1, 2, 3, 17, 36));
			allVariations.add(new Symbol(2, 1, 9, 1, 1, 4, 27, 27));
			allVariations.add(new Symbol(2, 1, 9, 1, 2, 4, 41, 41));
		} else if (baseSymbol.equals(MovementBaseSymbol.BRUSH_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 10, 1, 1, 1, 12, 12));
		} else if (baseSymbol.equals(MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 11, 1, 1, 4, 22, 21));
			allVariations.add(new Symbol(2, 1, 11, 1, 2, 3, 12, 40));
			allVariations.add(new Symbol(2, 1, 11, 1, 1, 1, 26, 12));
			allVariations.add(new Symbol(2, 1, 11, 1, 2, 4, 32, 30));
			allVariations.add(new Symbol(2, 1, 11, 1, 1, 2, 22, 21));
			allVariations.add(new Symbol(2, 1, 11, 1, 2, 1, 40, 12));
			allVariations.add(new Symbol(2, 1, 11, 1, 1, 3, 12, 26));
			allVariations.add(new Symbol(2, 1, 11, 1, 2, 2, 32, 30));
		} else if (baseSymbol.equals(MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 12, 1, 2, 3, 16, 34));
			allVariations.add(new Symbol(2, 1, 12, 1, 2, 2, 36, 35));
			allVariations.add(new Symbol(2, 1, 12, 1, 2, 4, 36, 35));
			allVariations.add(new Symbol(2, 1, 12, 1, 1, 4, 24, 23));
			allVariations.add(new Symbol(2, 1, 12, 1, 1, 3, 16, 18));
			allVariations.add(new Symbol(2, 1, 12, 1, 2, 1, 38, 15));
			allVariations.add(new Symbol(2, 1, 12, 1, 1, 2, 24, 23));
			allVariations.add(new Symbol(2, 1, 12, 1, 1, 1, 20, 15));
		} else if (baseSymbol.equals(MovementBaseSymbol.RUB_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 13, 1, 1, 1, 13, 14));
		} else if (baseSymbol.equals(MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 14, 1, 2, 4, 37, 36));
			allVariations.add(new Symbol(2, 1, 14, 1, 2, 2, 37, 36));
			allVariations.add(new Symbol(2, 1, 14, 1, 2, 3, 13, 46));
			allVariations.add(new Symbol(2, 1, 14, 1, 2, 1, 43, 14));
			allVariations.add(new Symbol(2, 1, 14, 1, 1, 2, 25, 25));
			allVariations.add(new Symbol(2, 1, 14, 1, 1, 1, 28, 14));
			allVariations.add(new Symbol(2, 1, 14, 1, 1, 4, 25, 25));
			allVariations.add(new Symbol(2, 1, 14, 1, 1, 3, 13, 30));
		} else if (baseSymbol.equals(MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 15, 1, 2, 1, 40, 16));
			allVariations.add(new Symbol(2, 1, 15, 1, 1, 2, 29, 27));
			allVariations.add(new Symbol(2, 1, 15, 1, 2, 2, 44, 40));
			allVariations.add(new Symbol(2, 1, 15, 1, 1, 3, 17, 22));
			allVariations.add(new Symbol(2, 1, 15, 1, 2, 3, 17, 42));
			allVariations.add(new Symbol(2, 1, 15, 1, 2, 4, 44, 40));
			allVariations.add(new Symbol(2, 1, 15, 1, 1, 1, 21, 16));
			allVariations.add(new Symbol(2, 1, 15, 1, 1, 4, 29, 27));
		} else if (baseSymbol.equals(MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 1, 15, 8));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 7, 8, 16));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 4, 12, 12));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 6, 13, 14));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 3, 5, 15));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 1, 15, 5));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 8, 14, 13));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 8, 12, 12));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 3, 8, 17));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 7, 5, 15));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 2, 13, 14));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 5, 15, 8));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 6, 12, 12));
			allVariations.add(new Symbol(2, 1, 16, 1, 2, 4, 14, 13));
			allVariations.add(new Symbol(2, 1, 16, 1, 1, 5, 15, 5));
		} else if (baseSymbol.equals(MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 1, 17, 1, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 1, 17, 1, 1, 3, 9, 16));
			allVariations.add(new Symbol(2, 1, 17, 1, 1, 4, 12, 12));
			allVariations.add(new Symbol(2, 1, 17, 1, 2, 3, 11, 15));
			allVariations.add(new Symbol(2, 1, 17, 1, 2, 4, 13, 13));
			allVariations.add(new Symbol(2, 1, 17, 1, 2, 2, 13, 13));
			allVariations.add(new Symbol(2, 1, 17, 1, 2, 1, 15, 11));
			allVariations.add(new Symbol(2, 1, 17, 1, 1, 1, 16, 9));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}

	private static List<Symbol> getAllVariationsForBaseSymbolWithGroup2(BaseSymbol baseSymbol) {
		assert baseSymbol.getCategory() == 2 && baseSymbol
				.getGroup() == 2 : "Precondition failed: baseSymbol.getCategory()==2 && baseSymbol.getGroup()==2";
		List<Symbol> allVariations = new ArrayList<Symbol>();

		if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 1, 1, 1, 1, 8, 8));
		} else if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 1, 2, 1, 1, 6, 6));
		} else if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 2, 1, 2, 1, 28, 8));
			allVariations.add(new Symbol(2, 2, 2, 1, 2, 2, 22, 22));
			allVariations.add(new Symbol(2, 2, 2, 1, 2, 4, 22, 22));
			allVariations.add(new Symbol(2, 2, 2, 1, 2, 3, 8, 28));
			allVariations.add(new Symbol(2, 2, 2, 1, 1, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 2, 1, 1, 1, 18, 8));
			allVariations.add(new Symbol(2, 2, 2, 1, 1, 3, 8, 18));
			allVariations.add(new Symbol(2, 2, 2, 1, 1, 2, 15, 15));
		} else if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 2, 2, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 2, 2, 2, 1, 1, 14, 6));
			allVariations.add(new Symbol(2, 2, 2, 2, 2, 4, 18, 18));
			allVariations.add(new Symbol(2, 2, 2, 2, 1, 4, 12, 12));
			allVariations.add(new Symbol(2, 2, 2, 2, 2, 3, 6, 22));
			allVariations.add(new Symbol(2, 2, 2, 2, 1, 3, 6, 14));
			allVariations.add(new Symbol(2, 2, 2, 2, 2, 2, 18, 18));
			allVariations.add(new Symbol(2, 2, 2, 2, 2, 1, 22, 6));
		} else if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 12, 14, 26));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 11, 25, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 14, 26, 14));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 13, 12, 25));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 16, 14, 26));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 15, 25, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 3, 22, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 4, 14, 26));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 2, 21, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 3, 25, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 1, 9, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 6, 26, 14));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 5, 12, 25));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 7, 22, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 8, 14, 26));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 6, 21, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 7, 25, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 5, 9, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 10, 26, 14));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 4, 12, 21));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 9, 12, 25));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 9, 9, 10));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 10, 8, 7));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 7, 10, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 8, 7, 8));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 13, 9, 10));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 1, 12, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 14, 8, 7));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 2, 30, 24));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 11, 10, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 3, 34, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 12, 7, 8));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 15, 10, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 16, 7, 8));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 2, 8, 7));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 1, 9, 10));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 4, 7, 8));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 3, 10, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 6, 8, 7));
			allVariations.add(new Symbol(2, 2, 3, 1, 5, 5, 9, 10));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 6, 37, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 7, 39, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 8, 34, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 9, 30, 39));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 10, 37, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 1, 12, 25));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 11, 39, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 1, 2, 26, 14));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 12, 34, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 13, 30, 39));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 14, 37, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 15, 39, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 16, 34, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 5, 30, 39));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 4, 34, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 3, 39, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 2, 37, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 4, 1, 30, 39));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 11, 37, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 12, 34, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 9, 22, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 10, 30, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 7, 37, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 8, 34, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 5, 22, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 6, 30, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 15, 37, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 16, 34, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 13, 22, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 14, 30, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 2, 30, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 1, 22, 37));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 4, 34, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 3, 3, 37, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 8, 24, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 9, 12, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 10, 30, 24));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 11, 34, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 4, 24, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 5, 12, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 16, 12, 21));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 6, 30, 24));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 7, 34, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 16, 24, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 13, 9, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 12, 12, 21));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 15, 22, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 14, 21, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 12, 24, 30));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 9, 9, 22));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 13, 12, 34));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 8, 12, 21));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 14, 30, 24));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 11, 22, 9));
			allVariations.add(new Symbol(2, 2, 3, 1, 2, 15, 34, 12));
			allVariations.add(new Symbol(2, 2, 3, 1, 6, 10, 21, 12));
		} else if (baseSymbol.equals(MovementBaseSymbol.FLICK_LARGE_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 4, 1, 1, 1, 8, 8));
		} else if (baseSymbol.equals(MovementBaseSymbol.FLICK_SMALL_SINGLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 4, 2, 1, 1, 6, 6));
		} else if (baseSymbol.equals(MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 5, 1, 1, 2, 15, 15));
			allVariations.add(new Symbol(2, 2, 5, 1, 1, 1, 18, 8));
			allVariations.add(new Symbol(2, 2, 5, 1, 2, 4, 22, 22));
			allVariations.add(new Symbol(2, 2, 5, 1, 1, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 5, 1, 2, 3, 8, 28));
			allVariations.add(new Symbol(2, 2, 5, 1, 1, 3, 8, 18));
			allVariations.add(new Symbol(2, 2, 5, 1, 2, 2, 22, 22));
			allVariations.add(new Symbol(2, 2, 5, 1, 2, 1, 28, 8));
		} else if (baseSymbol.equals(MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 5, 2, 2, 3, 6, 22));
			allVariations.add(new Symbol(2, 2, 5, 2, 2, 4, 18, 18));
			allVariations.add(new Symbol(2, 2, 5, 2, 1, 1, 14, 6));
			allVariations.add(new Symbol(2, 2, 5, 2, 2, 1, 22, 6));
			allVariations.add(new Symbol(2, 2, 5, 2, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 2, 5, 2, 2, 2, 18, 18));
			allVariations.add(new Symbol(2, 2, 5, 2, 1, 3, 6, 14));
			allVariations.add(new Symbol(2, 2, 5, 2, 1, 4, 12, 12));
		} else if (baseSymbol.equals(MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 7, 39, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 8, 34, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 5, 30, 39));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 6, 37, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 3, 39, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 4, 34, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 1, 30, 39));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 2, 37, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 15, 37, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 1, 12, 25));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 14, 30, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 13, 22, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 12, 34, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 11, 37, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 5, 12, 25));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 10, 30, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 4, 14, 26));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 9, 22, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 3, 25, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 8, 34, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 2, 26, 14));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 16, 34, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 1, 9, 10));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 6, 8, 7));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 7, 10, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 8, 7, 8));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 9, 9, 10));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 2, 8, 7));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 3, 10, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 4, 7, 8));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 5, 9, 10));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 14, 37, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 13, 30, 39));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 16, 34, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 15, 39, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 10, 37, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 9, 30, 39));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 12, 34, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 4, 11, 39, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 6, 21, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 5, 9, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 4, 12, 21));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 3, 22, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 10, 21, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 9, 9, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 8, 12, 21));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 7, 22, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 1, 12, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 2, 30, 24));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 2, 21, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 5, 12, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 1, 9, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 6, 30, 24));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 3, 34, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 4, 24, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 9, 12, 25));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 8, 14, 26));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 7, 25, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 6, 26, 14));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 13, 12, 25));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 12, 14, 26));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 11, 25, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 10, 26, 14));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 12, 7, 8));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 16, 14, 26));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 13, 9, 10));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 15, 25, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 10, 8, 7));
			allVariations.add(new Symbol(2, 2, 6, 1, 1, 14, 26, 14));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 11, 10, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 16, 7, 8));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 14, 8, 7));
			allVariations.add(new Symbol(2, 2, 6, 1, 5, 15, 10, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 1, 22, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 2, 30, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 3, 37, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 4, 34, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 5, 22, 37));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 6, 30, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 3, 7, 37, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 8, 24, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 7, 34, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 10, 30, 24));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 9, 12, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 12, 24, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 11, 34, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 14, 30, 24));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 13, 12, 34));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 11, 22, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 16, 24, 30));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 12, 12, 21));
			allVariations.add(new Symbol(2, 2, 6, 1, 2, 15, 34, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 13, 9, 22));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 14, 21, 12));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 15, 22, 9));
			allVariations.add(new Symbol(2, 2, 6, 1, 6, 16, 12, 21));
		} else if (baseSymbol.equals(MovementBaseSymbol.SQUEEZE_FLICK_ALTERNATING.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 8, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 7, 11, 34));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 8, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 4, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 5, 34, 11));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 5, 34, 11));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 6, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 3, 11, 34));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 6, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 4, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 7, 11, 34));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 1, 34, 11));
			allVariations.add(new Symbol(2, 2, 7, 1, 1, 2, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 1, 34, 11));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 2, 26, 26));
			allVariations.add(new Symbol(2, 2, 7, 1, 2, 3, 11, 34));
		} else if (baseSymbol.equals(MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 5, 32, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 6, 21, 21));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 3, 7, 32));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 4, 21, 21));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 8, 9, 9));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 7, 7, 32));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 8, 21, 21));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 1, 32, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 4, 2, 21, 21));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 6, 19, 19));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 5, 26, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 8, 19, 19));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 7, 7, 26));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 2, 19, 19));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 1, 26, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 4, 19, 19));
			allVariations.add(new Symbol(2, 2, 8, 1, 2, 3, 7, 26));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 4, 27, 27));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 5, 42, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 6, 27, 27));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 7, 7, 42));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 8, 27, 27));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 1, 42, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 2, 27, 27));
			allVariations.add(new Symbol(2, 2, 8, 1, 5, 3, 7, 42));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 1, 22, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 3, 7, 12));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 2, 9, 9));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 8, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 1, 12, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 7, 7, 22));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 6, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 7, 7, 12));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 5, 22, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 6, 9, 9));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 5, 12, 7));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 3, 7, 22));
			allVariations.add(new Symbol(2, 2, 8, 1, 1, 4, 9, 9));
			allVariations.add(new Symbol(2, 2, 8, 1, 3, 2, 15, 15));
		} else if (baseSymbol.equals(MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 1, 21, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 7, 5, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 6, 19, 20));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 3, 5, 21));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 2, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 8, 20, 19));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 5, 21, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 3, 5, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 2, 19, 20));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 7, 5, 21));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 5, 26, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 6, 15, 15));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 4, 20, 19));
			allVariations.add(new Symbol(2, 2, 8, 2, 4, 1, 26, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 7, 5, 10));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 8, 7, 7));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 4, 14, 13));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 3, 5, 18));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 8, 26, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 2, 13, 14));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 7, 5, 34));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 1, 18, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 6, 26, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 8, 14, 13));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 5, 34, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 7, 5, 18));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 4, 26, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 6, 13, 14));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 3, 5, 34));
			allVariations.add(new Symbol(2, 2, 8, 2, 3, 5, 18, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 2, 26, 26));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 5, 10, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 5, 1, 34, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 6, 7, 7));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 3, 5, 10));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 4, 7, 7));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 1, 10, 5));
			allVariations.add(new Symbol(2, 2, 8, 2, 1, 2, 7, 7));
			allVariations.add(new Symbol(2, 2, 8, 2, 2, 8, 15, 15));
		} else if (baseSymbol.equals(MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 14, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 13, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 16, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 15, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 9, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 10, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 11, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 12, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 13, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 14, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 15, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 16, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 3, 43, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 2, 35, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 5, 19, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 1, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 4, 34, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 2, 29, 17));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 7, 43, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 3, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 6, 35, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 4, 17, 29));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 9, 19, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 5, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 8, 34, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 6, 29, 17));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 7, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 8, 17, 29));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 9, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 10, 29, 17));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 11, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 12, 19, 29));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 1, 19, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 13, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 15, 43, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 14, 44, 38));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 13, 35, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 12, 38, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 16, 38, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 4, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 3, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 2, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 1, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 8, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 3, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 7, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 4, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 6, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 1, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 1, 1, 5, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 2, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 7, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 8, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 5, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 6, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 11, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 12, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 9, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 1, 5, 10, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 15, 42, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 16, 32, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 11, 42, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 12, 32, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 13, 35, 42));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 14, 44, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 9, 35, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 8, 38, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 11, 43, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 10, 44, 38));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 5, 35, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 4, 38, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 7, 43, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 6, 44, 38));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 1, 35, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 3, 43, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 4, 2, 44, 38));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 16, 17, 29));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 15, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 1, 6, 14, 29, 17));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 16, 34, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 14, 35, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 15, 43, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 12, 34, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 13, 19, 43));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 10, 35, 34));
			allVariations.add(new Symbol(2, 2, 9, 1, 2, 11, 43, 19));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 10, 44, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 9, 35, 42));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 8, 32, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 7, 42, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 6, 44, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 5, 35, 42));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 4, 32, 44));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 3, 42, 35));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 2, 44, 32));
			allVariations.add(new Symbol(2, 2, 9, 1, 3, 1, 35, 42));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 7, 43, 22));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 16, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 8, 34, 38));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 5, 22, 43));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 6, 38, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 3, 43, 22));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 12, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 4, 34, 38));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 13, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 1, 22, 43));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 14, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 2, 38, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 15, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 2, 29, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 1, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 4, 18, 29));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 3, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 16, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 10, 29, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 15, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 9, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 14, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 12, 18, 29));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 13, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 11, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 12, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 6, 29, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 11, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 5, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 10, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 8, 18, 29));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 9, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 7, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 8, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 4, 19, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 5, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 15, 44, 37));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 6, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 16, 44, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 7, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 13, 37, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 14, 45, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 1, 20, 35));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 11, 44, 37));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 2, 34, 19));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 12, 44, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 1, 3, 35, 20));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 3, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 2, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 1, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 11, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 10, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 9, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 8, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 7, 10, 9));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 6, 8, 7));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 5, 9, 10));
			allVariations.add(new Symbol(2, 2, 9, 2, 5, 4, 7, 8));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 10, 45, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 11, 42, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 12, 36, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 13, 36, 42));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 14, 45, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 15, 42, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 16, 36, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 2, 45, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 1, 37, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 4, 44, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 3, 44, 37));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 6, 45, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 5, 37, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 8, 44, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 7, 44, 37));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 10, 45, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 4, 9, 37, 44));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 11, 43, 22));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 12, 34, 38));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 9, 22, 43));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 10, 38, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 15, 43, 22));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 16, 34, 38));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 13, 22, 43));
			allVariations.add(new Symbol(2, 2, 9, 2, 2, 14, 38, 34));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 16, 18, 29));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 15, 32, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 14, 29, 18));
			allVariations.add(new Symbol(2, 2, 9, 2, 6, 13, 18, 32));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 1, 36, 42));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 5, 36, 42));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 4, 36, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 3, 42, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 2, 45, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 9, 36, 42));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 8, 36, 45));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 7, 42, 36));
			allVariations.add(new Symbol(2, 2, 9, 2, 3, 6, 45, 36));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 1, 42, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 2, 30, 30));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 3, 13, 42));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 4, 30, 30));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 1, 22, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 2, 18, 18));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 3, 13, 22));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 4, 18, 18));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 5, 22, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 6, 18, 18));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 7, 13, 22));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 5, 42, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 2, 8, 18, 18));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 6, 30, 30));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 7, 13, 42));
			allVariations.add(new Symbol(2, 2, 10, 1, 4, 8, 30, 30));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 8, 12, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 7, 13, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 6, 12, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 5, 12, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 2, 24, 24));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 4, 12, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 3, 13, 32));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 3, 13, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 2, 12, 12));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 1, 32, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 1, 1, 12, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 6, 24, 24));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 7, 13, 32));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 4, 24, 24));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 5, 32, 13));
			allVariations.add(new Symbol(2, 2, 10, 1, 3, 8, 24, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 1, 26, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 2, 22, 22));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 1, 10, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 7, 9, 26));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 2, 10, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 8, 22, 22));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 3, 9, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 4, 10, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 5, 10, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 3, 9, 26));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 6, 10, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 4, 22, 22));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 7, 9, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 5, 26, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 1, 8, 10, 10));
			allVariations.add(new Symbol(2, 2, 10, 2, 3, 6, 22, 22));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 7, 9, 34));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 1, 18, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 6, 28, 28));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 5, 34, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 4, 28, 28));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 8, 28, 28));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 8, 16, 16));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 6, 16, 16));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 7, 9, 18));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 4, 16, 16));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 3, 9, 34));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 5, 18, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 2, 28, 28));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 2, 16, 16));
			allVariations.add(new Symbol(2, 2, 10, 2, 4, 1, 34, 9));
			allVariations.add(new Symbol(2, 2, 10, 2, 2, 3, 9, 18));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 3, 10, 36));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 2, 34, 34));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 5, 36, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 4, 34, 34));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 1, 36, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 7, 10, 36));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 6, 34, 34));
			allVariations.add(new Symbol(2, 2, 11, 1, 4, 8, 34, 34));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 1, 16, 9));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 2, 17, 16));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 7, 10, 12));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 8, 17, 18));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 3, 10, 12));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 4, 16, 17));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 5, 12, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 1, 6, 17, 16));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 4, 27, 29));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 3, 10, 29));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 2, 29, 28));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 1, 29, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 8, 27, 29));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 7, 10, 29));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 6, 29, 27));
			allVariations.add(new Symbol(2, 2, 11, 1, 3, 5, 29, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 2, 23, 23));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 3, 10, 21));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 1, 21, 10));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 8, 23, 23));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 6, 23, 23));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 7, 10, 21));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 4, 23, 23));
			allVariations.add(new Symbol(2, 2, 11, 1, 2, 5, 21, 10));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 1, 21, 11));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 3, 10, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 2, 9, 9));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 1, 10, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 5, 21, 11));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 4, 16, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 3, 18, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 8, 20, 22));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 2, 16, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 6, 21, 20));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 8, 16, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 7, 10, 32));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 7, 18, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 4, 21, 20));
			allVariations.add(new Symbol(2, 2, 12, 1, 3, 6, 16, 16));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 8, 9, 9));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 5, 32, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 7, 10, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 2, 20, 21));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 6, 9, 9));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 3, 10, 32));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 5, 10, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 1, 4, 9, 9));
			allVariations.add(new Symbol(2, 2, 12, 1, 5, 1, 32, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 2, 15, 14));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 7, 10, 32));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 1, 21, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 8, 23, 24));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 3, 10, 19));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 3, 10, 32));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 6, 15, 15));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 4, 24, 23));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 5, 21, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 5, 32, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 8, 15, 14));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 6, 24, 23));
			allVariations.add(new Symbol(2, 2, 12, 1, 2, 7, 10, 19));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 1, 32, 10));
			allVariations.add(new Symbol(2, 2, 12, 1, 4, 2, 23, 24));
		} else if (baseSymbol
				.equals(MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 6, 15, 12));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 5, 21, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 4, 12, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 3, 10, 21));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 2, 15, 12));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 4, 8, 8));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 1, 21, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 3, 10, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 2, 8, 8));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 1, 10, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 8, 8, 8));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 7, 10, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 6, 8, 8));
			allVariations.add(new Symbol(2, 2, 13, 1, 1, 5, 10, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 8, 12, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 3, 7, 10, 21));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 1, 32, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 2, 19, 19));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 3, 10, 32));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 4, 19, 19));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 5, 32, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 6, 19, 19));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 7, 10, 32));
			allVariations.add(new Symbol(2, 2, 13, 1, 5, 8, 19, 19));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 5, 32, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 4, 22, 22));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 7, 10, 32));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 1, 21, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 6, 22, 22));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 1, 32, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 3, 10, 21));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 2, 15, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 3, 10, 32));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 5, 21, 10));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 2, 22, 22));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 4, 15, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 7, 10, 21));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 6, 15, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 2, 8, 15, 15));
			allVariations.add(new Symbol(2, 2, 13, 1, 4, 8, 22, 22));
		} else {
			throw new RuntimeException("does not exist");
		}

		return allVariations;
	}
}
