package de.signWritingEditor.shared.model.material;

import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedDynamicsSymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = -9094662265046929734L;

	private Set<Symbol> validVariations;

	public PositionedDynamicsSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height,
			int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.DYNAMICS.getCategoryNumber(), group, symbol, variation, fill, rotation, width,
				height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedDynamicsSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.DYNAMICS
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.DYNAMICS.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedDynamicsSymbol clone() {
		return new PositionedDynamicsSymbol(
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
		return (canManipulate() && DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotations().size() > 1);
	}

	@Override
	public boolean canRoll() {
		return false;
	}

	@Override
	public boolean canMirror() {
		return (canManipulate()
				&& DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).canBeMirrored());
	}

	@Override
	public boolean canPitch() {
		return false;
	}

	public boolean canSwitchSize() {
		return false;
	}

	public void switchSize() {
		assert canSwitchSize() : "Precondition failed: canSwitchSize()";

	}

	@Override
	public boolean isValidFill(int fill) {
		return DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(fill);

	}

	@Override
	public boolean isValidRotation(int rotation) {
		return DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	@Override
	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int maxRotations = DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotationValues().size();
		int unmirroredRotations = canMirror()
				&& DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(4)
						? maxRotations / 2 : maxRotations;

		boolean isMirrored = getSymbol().getRotation() > unmirroredRotations;

		int nextRotation = getSymbol().getRotation() % unmirroredRotations + 1;

		if (isMirrored) {
			nextRotation += unmirroredRotations;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
	}

	@Override
	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int maxRotations = DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotationValues().size();
		int unmirroredRotations = canMirror()
				&& DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(4)
						? maxRotations / 2 : maxRotations;

		int nextRotation = getSymbol().getRotation() - 1;

		if (nextRotation < 1) {
			nextRotation = unmirroredRotations;
		} else if (nextRotation == unmirroredRotations) {
			nextRotation = maxRotations;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
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
	protected PositionedDynamicsSymbol() {

	}

	@Override
	public void mirror() {
		assert canMirror() : "Precondition failed: canMirror()";

		int newRotation = getSymbol().getRotation();
		int newFill = this.getSymbol().getFill();
		// we know we have 4 fills if we can mirror
		if (DynamicsBaseSymbol.getDynamicsBaseSymbol(this.getSymbol().getBaseSymbol()).getValidFills().contains(4)) {
			if (this.getSymbol().getFill() == 1 || this.getSymbol().getFill() == 3) {
				newFill++;
			} else if (this.getSymbol().getFill() == 2 || this.getSymbol().getFill() == 4) {
				newFill--;
			}
		} else {
			if (getSymbol().getRotation() == 2) {
				newRotation = 8;
			} else if (getSymbol().getRotation() == 3) {
				newRotation = 7;
			} else if (getSymbol().getRotation() == 4) {
				newRotation = 6;
			} else if (getSymbol().getRotation() == 6) {
				newRotation = 2;
			} else if (getSymbol().getRotation() == 7) {
				newRotation = 3;
			} else if (getSymbol().getRotation() == 8) {
				newRotation = 4;
			}
		}

		setFillAndRotation(newFill, newRotation);
	}

	@Override
	public boolean canIncrease() {
		return (DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().size() == 4
				&& (this.getSymbol().getFill() == 1 || this.getSymbol().getFill() == 2));
	}

	@Override
	public boolean canDecrease() {
		return (DynamicsBaseSymbol.getDynamicsBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().size() == 4
				&& (this.getSymbol().getFill() == 3 || this.getSymbol().getFill() == 4));
	}

	@Override
	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";

		int newFill = this.getSymbol().getFill() + 2;

		setFillAndRotation(newFill, this.getSymbol().getRotation());
	}

	@Override
	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";

		int newFill = this.getSymbol().getFill() - 2;

		setFillAndRotation(newFill, this.getSymbol().getRotation());
	}

	@Override
	public boolean canMirrorVertically() {
		boolean result = false;

		if (!DynamicsBaseSymbol.FAST.getIswaSymbol().getBaseSymbol().equals(getSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	@Override
	public void mirrorVertically() {
		assert canMirrorVertically() : "Precondition failed: canMirrorVertically()";

		int newFill = getSymbol().getFill();
		int newRotation = getSymbol().getRotation();

		if (DynamicsBaseSymbol.TENSE.getIswaSymbol().getBaseSymbol().equals(getSymbol().getBaseSymbol())
				|| DynamicsBaseSymbol.RELAXED.getIswaSymbol().getBaseSymbol().equals(getSymbol().getBaseSymbol())) {
			if (newFill <= 2) {
				newFill = (newFill % 2) + 1;
			} else {
				newFill = (newFill % 2) + 3;
			}
		} else {
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
		}

		setFillAndRotation(newFill, newRotation);
	}
}
