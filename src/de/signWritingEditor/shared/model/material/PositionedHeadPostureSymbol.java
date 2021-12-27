package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedHeadPostureSymbol extends PositionedSymbol implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedHeadPostureSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedHeadPostureSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@Deprecated
	public PositionedHeadPostureSymbol() {
	}

	public static PositionedHeadPostureSymbol getStandardHeadPostureSymbol() {
		return new PositionedHeadPostureSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol());
	}

	public static PositionedHeadPostureSymbol getEmptyHeadPostureSymbol() {
		return new PositionedHeadPostureSymbol(Symbol.HEAD_POSTURE_PLACEHOLDER_SYMBOL);
	}

	@Override
	public PositionedHeadPostureSymbol clone() {
		PositionedHeadPostureSymbol positionedHeadPostureSymbol = new PositionedHeadPostureSymbol(getSymbol(), getX(),
				getY(), getZ());
		positionedHeadPostureSymbol.setLineColor(getLineColor());
		positionedHeadPostureSymbol.setFillColor(getFillColor());
		return positionedHeadPostureSymbol;
	}

	public static boolean isValidHeadPostureSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return HeadPostureBaseSymbol.isValidHeadPostureSymbol(symbol);
	}

	public boolean canRotate() {

		boolean result = false;

		if (HeadPostureBaseSymbol.HEAD_RIMS.getIswaSymbol().getBaseSymbol().equals(getSymbol().getBaseSymbol())
				|| HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol())
				|| HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol())
				|| HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol())
				|| HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING.getIswaSymbol()
						.getBaseSymbol().equals(getSymbol().getBaseSymbol())
				|| HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	public boolean canIncrease() {
		boolean result = false;
		if ((HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
				.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() < 4)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() < 4)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() < 3)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getRotation() < 3)) {
			result = true;
		}
		return result;
	}

	public boolean canDecrease() {
		boolean result = false;
		if ((HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
				.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() > 1)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() > 1)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getFill() > 1)
				|| (HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol()
						.equals(getSymbol().getBaseSymbol()) && getSymbol().getRotation() > 2)) {
			result = true;
		}
		return result;
	}

	public boolean canSwitchToAlternatingArrows() {
		boolean result = false;

		if ((getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol().equals(
						HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 2 || getSymbol().getFill() == 4)) {
			result = true;
		} else if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 4) {
			result = true;
		}

		return result;
	}

	public boolean canSwitchToNormalArrows() {
		boolean result = false;

		if ((getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol().equals(
						HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()))
				&& (getSymbol().getFill() == 3 || getSymbol().getFill() == 5)) {
			result = true;
		} else if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getFill() == 5) {
			result = true;
		}

		return result;
	}

	public void switchToAlternatingArrows() {
		assert canSwitchToAlternatingArrows() : "Precondition failed: canSwitchToAlternatingArrows()";

		setFillAndRotation(getSymbol().getFill() + 1, getSymbol().getRotation());
	}

	public void switchToNormalArrows() {
		assert canSwitchToNormalArrows() : "Precondition failed: canSwitchToNormalArrows()";

		setFillAndRotation(getSymbol().getFill() - 1, getSymbol().getRotation());
	}

	public boolean canMirrorVertically() {
		return (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CURVES_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CURVES_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_FORWARD_TILTING.getIswaSymbol()
								.getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING.getIswaSymbol()
								.getBaseSymbol()));
	}

	public boolean canMirror() {
		return (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CURVES_WALL_PLANE.getIswaSymbol().getBaseSymbol()));
	}

	public void mirror() {
		assert canMirror() : "Precondition failed: canMirrorHorizontal()";

		int newRotation = 0;
		if (getSymbol().getRotation() == 1) {
			newRotation = 4;
		} else if (getSymbol().getRotation() == 2) {
			newRotation = 3;
		} else if (getSymbol().getRotation() == 3) {
			newRotation = 2;
		} else if (getSymbol().getRotation() == 4) {
			newRotation = 1;
		}

		setFillAndRotation(getSymbol().getFill(), newRotation);
	}

	public void mirrorVertically() {
		assert canMirrorVertically() : "Precondition failed: canMirrorVertical()";

		int newRotation = getSymbol().getRotation();

		if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_TILTS_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_FORWARD_TILTING.getIswaSymbol()
								.getBaseSymbol())) {
			newRotation = (newRotation % 2) + 1;
		} else if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CURVES_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol().equals(
						HeadPostureBaseSymbol.HEAD_MOVEMENT_CURVES_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			newRotation = (newRotation + 2) % 4;
			if (newRotation == 0) {
				newRotation = 4;
			}
		} else if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING.getIswaSymbol()
						.getBaseSymbol())) {
			if (newRotation > 8) {
				newRotation = (newRotation + 8) % 16;
			} else {
				newRotation = (newRotation % 16) + 8;
			}
		} else if (getSymbol().getBaseSymbol()
				.equals(HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol())) {
			if (newRotation < 3) {
				newRotation = (newRotation % 2) + 1;
			} else {
				newRotation = ((newRotation - 2) % 2) + 3;
			}
		}

		setFillAndRotation(getSymbol().getFill(), newRotation);

	}

	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";

		// increase is a change in Rotation for HEAD_MOVEMENT_CIRCLES
		if (HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol()
				.equals(getSymbol().getBaseSymbol())) {
			int newRotation = getSymbol().getRotation() + 2;
			setFillAndRotation(getSymbol().getFill(), newRotation);
		} else {

			int newFill = getSymbol().getFill() + 1;

			if ((HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
					.equals(getSymbol().getBaseSymbol())
					|| HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getSymbol().getBaseSymbol()))
					&& newFill == 3) {
				newFill = 4;
			}

			setFillAndRotation(newFill, getSymbol().getRotation());

		}

	}

	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";

		// decrease is a change in Rotation for HEAD_MOVEMENT_CIRCLES
		if (HeadPostureBaseSymbol.HEAD_MOVEMENT_CIRCLES.getIswaSymbol().getBaseSymbol()
				.equals(getSymbol().getBaseSymbol())) {
			int newRotation = getSymbol().getRotation() - 2;
			setFillAndRotation(getSymbol().getFill(), newRotation);
		} else {

			int newFill = getSymbol().getFill() - 1;

			if ((HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()
					.equals(getSymbol().getBaseSymbol())
					|| HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol()
							.equals(getSymbol().getBaseSymbol()))
					&& newFill == 3) {
				newFill = 2;
			}

			setFillAndRotation(newFill, getSymbol().getRotation());

		}

	}

	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int newFill = getSymbol().getFill();
		int newRotation = getPreviousRotation();

		if (getSymbol().getBaseSymbol().equals(
				HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol().getBaseSymbol())) {
			if (newRotation > 5 && getSymbol().getRotation() <= 5) {
				newRotation = 5;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 6) {
				newFill = 2;
				newRotation = getSymbol().getRotation();
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 8) {
				newFill = 1;
				newRotation = getSymbol().getRotation();
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() > 5) {
				newRotation = getNextRotation();
			}
		}

		if (getSymbol().getBaseSymbol().equals(
				HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getRotation() > 8) {
			newRotation = getNextRotation();
		}

		setFillAndRotation(newFill, newRotation);
	}

	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int newFill = getSymbol().getFill();
		int newRotation = getNextRotation();

		if (getSymbol().getBaseSymbol().equals(
				HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol().getBaseSymbol())) {
			if (newRotation > 5 && getSymbol().getRotation() <= 5) {
				newRotation = 1;
			} else if (getSymbol().getFill() == 1 && getSymbol().getRotation() == 8) {
				newFill = 2;
				newRotation = getSymbol().getRotation();
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() == 6) {
				newFill = 1;
				newRotation = getSymbol().getRotation();
			} else if (getSymbol().getFill() == 2 && getSymbol().getRotation() > 5) {
				newRotation = getPreviousRotation();
			}
		}
		if (getSymbol().getBaseSymbol().equals(
				HeadPostureBaseSymbol.FACE_DIRECTION_POSITIONS_NOSE_UP_OR_DOWN_TILTING.getIswaSymbol().getBaseSymbol())
				&& getSymbol().getRotation() > 8) {
			newRotation = getPreviousRotation();
		}

		setFillAndRotation(newFill, newRotation);
	}

	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : HeadPostureBaseSymbol.getAllVariationsForSymbol(getSymbol())) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	private int getNextRotation() {
		int newRotation = getSymbol().getRotation() + 1;

		if (newRotation == 9) {
			newRotation = 1;
		}

		if (newRotation == 17) {
			newRotation = 9;
		}

		return newRotation;

	}

	private int getPreviousRotation() {
		int newRotation = getSymbol().getRotation() - 1;

		if (newRotation == 8) {
			newRotation = 16;
		}

		if (newRotation == 0) {
			newRotation = 8;
		}

		return newRotation;
	}

	protected boolean isValidRotation(int rotation) {
		assert rotation > 0 : "Precondition failed: rotation > 0";

		return HeadPostureBaseSymbol.getHeadPostureBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	protected boolean isValidFill(int fill) {
		assert fill > 0 : "Precondition failed: fill > 0";

		return HeadPostureBaseSymbol.getHeadPostureBaseSymbol(getSymbol().getBaseSymbol()).getValidFills()
				.contains(fill);
	}
}
