package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.SymbolRotation;

public class PositionedHandSymbol extends PositionedSymbol implements Cloneable, Serializable {
	private static final long serialVersionUID = 2038075211771026844L;

	private Set<Symbol> validVariations;
	private int maxFill;

	public PositionedHandSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.HAND
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.HAND.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;

		determineMaxFill();
	}

	public void pitch() {
		assert canPitch() : "Precondition failed: canPitch()";

		int newFill = (getSymbol().getFill() + (maxFill / 2) - 1) % maxFill + 1;

		setFillAndRotation(newFill, getSymbol().getRotation());
	}

	public void roll() {
		assert canRoll() : "Precondition failed: canRoll()";

		int maxFillInWallPlane = maxFill / 2;

		int nextFill = getSymbol().getFill() - 1;

		if (nextFill == 0) {
			// We are in wall plane
			nextFill = maxFillInWallPlane;
		} else if (nextFill == maxFillInWallPlane) {
			// We are in desktop plane
			nextFill = maxFill;
		}

		setFillAndRotation(nextFill, getSymbol().getRotation());
	}

	public boolean isRightHand() {
		return getSymbol().getRotation() <= SymbolRotation.NORTH_EAST.getRotationValue();
	}

	public boolean isLeftHand() {
		return !isRightHand();
	}

	public PositionedHandSymbol clone() {

		return new PositionedHandSymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
		result = prime * result + getX();
		result = prime * result + getY();
		result = prime * result + getZ();
		return result;
	}

	@Override
	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	@Override
	public boolean canManipulate() {
		return true;
	}

	@Override
	public boolean canRotate() {
		return true;
	}

	@Override
	public boolean canRoll() {
		boolean result = false;

		if (!HandBaseSymbol.FIVE_FINGERS_SPREAD_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FIVE_FINGERS_SPREAD_FOUR_BENT_HEEL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol())
				&& !HandBaseSymbol.FIVE_FINGERS_SPREAD_BENT_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FLAT_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.THUMB_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FIST_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FLAT_THUMB_SIDE_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean canMirror() {
		return true;
	}

	@Override
	public boolean canPitch() {
		boolean result = false;

		if (!HandBaseSymbol.FIVE_FINGERS_SPREAD_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FIVE_FINGERS_SPREAD_FOUR_BENT_HEEL.getIswaSymbol().getBaseSymbol()
						.equals(getBaseSymbol())
				&& !HandBaseSymbol.FIVE_FINGERS_SPREAD_BENT_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FLAT_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.THUMB_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FIST_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())
				&& !HandBaseSymbol.FLAT_THUMB_SIDE_HEEL.getIswaSymbol().getBaseSymbol().equals(getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && (obj instanceof PositionedSymbol || obj instanceof PositionedHandSymbol)) {
			PositionedSymbol other = (PositionedSymbol) obj;

			if (getSymbol() != null) {
				result = getSymbol().equals(other.getSymbol());
			} else {
				result = other.getSymbol() == null;
			}
			result &= this.getX() == other.getX() && this.getY() == other.getY() && this.getZ() == other.getZ();
		}
		return result;
	}

	@Override
	public boolean isValidFill(int fill) {
		boolean result = false;

		if (validVariations.contains(new Symbol(getSymbol().getCategory(), getSymbol().getGroup(),
				getSymbol().getSymbol(), getSymbol().getVariation(), fill, getSymbol().getRotation(),
				getSymbol().getWidth(), getSymbol().getHeight()))) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean isValidRotation(int rotation) {
		return (rotation > 0 && rotation <= 16);
	}

	@Override
	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (isLeftHand()) {
			getNextRotation();
		} else {
			getPreviousRotation();
		}
	}

	@Override
	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (isLeftHand()) {
			getPreviousRotation();
		} else {
			getNextRotation();
		}
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

	private void getNextRotation() {
		assert canRotate() : "Precondition failed: canRotate()";

		// In ISWA 2010 all hand symbols have 8 valid rotations (either 1-8 for
		// right hand or 9-16
		// for left hand)
		int nextRotation = getSymbol().getRotation() % 8 + 1;

		if (isLeftHand()) {
			nextRotation += 8;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
	}

	private void getPreviousRotation() {
		assert canRotate() : "Precondition failed: canRotate()";

		// In ISWA 2010 all hand symbols have 8 valid rotations (either 1-8 for
		// right hand or 9-16
		// for left hand)
		int nextRotation = getSymbol().getRotation() - 1;

		if (nextRotation < 1) {
			// It's a right hand
			nextRotation = 8;
		} else if (nextRotation == 8) {
			// It's a left hand
			nextRotation = 16;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
	}

	private void determineMaxFill() {
		this.maxFill = -1;
		for (Symbol symbol : validVariations) {
			int symbolFill = symbol.getFill();
			if (symbolFill > maxFill) {
				maxFill = symbolFill;
			}
		}
	}

	/**
	 * For serialization only!
	 */
	@Deprecated
	protected PositionedHandSymbol() {
	}

	@Override
	public void mirror() {
		assert canMirror() : "Precondition failed: canMirror()";

		int currenRotation = getSymbol().getRotation();
		int nextRotation = (currenRotation + 8) % 16;

		if (nextRotation == 0) {
			nextRotation = 16;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);

	}

	@Override
	public boolean canMirrorVertically() {
		return true;
	}

	@Override
	public void mirrorVertically() {
		int newRotation = getSymbol().getRotation();

		if (newRotation <= 4) {
			newRotation += 12;
		} else if (newRotation <= 8) {
			newRotation += 4;
		} else if (newRotation <= 12) {
			newRotation -= 4;
		} else if (newRotation <= 16) {
			newRotation -= 12;
		}

		setFillAndRotation(getSymbol().getFill(), newRotation);
	}
}
