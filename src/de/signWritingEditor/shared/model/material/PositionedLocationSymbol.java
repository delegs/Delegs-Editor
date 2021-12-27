package de.signWritingEditor.shared.model.material;

import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedLocationSymbol extends PositionedSymbol implements Cloneable {

	private static final long serialVersionUID = 9196600289659280647L;

	private Set<Symbol> validVariations;

	public PositionedLocationSymbol(int group, int symbol, int variation, int fill, int rotation, int width, int height,
			int x, int y, int z, Set<Symbol> validVariations) {
		super(new Symbol(SymbolCategory.LOCATION.getCategoryNumber(), group, symbol, variation, fill, rotation, width,
				height), x, y, z);

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedLocationSymbol(Symbol symbol, int x, int y, int z, Set<Symbol> validVariations) {
		super(symbol, x, y, z);

		assert symbol != null : "Precondition failed: symbol != null";
		assert symbol.getCategory() == SymbolCategory.LOCATION
				.getCategoryNumber() : "Precondition failed: symbol.getCategory() == SymbolCategory.LOCATION.getCategoryNumber()";

		assert validVariations != null : "Precondition failed: validVariations != null";
		assert validVariations.size() > 0 : "Precondition failed: validVariations.size() > 0";
		this.validVariations = validVariations;
	}

	public PositionedLocationSymbol clone() {
		return new PositionedLocationSymbol(
				new Symbol(getSymbol().getCategory(), getSymbol().getGroup(), getSymbol().getSymbol(),
						getSymbol().getVariation(), getSymbol().getFill(), getSymbol().getRotation(),
						getSymbol().getWidth(), getSymbol().getHeight()),
				getX(), getY(), getZ(), new HashSet<Symbol>(validVariations));
	}

	@Deprecated
	protected PositionedLocationSymbol() {

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
	public boolean canMirror() {
		return (canManipulate()
				&& LocationBaseSymbol.getLocationBaseSymbol(getSymbol().getBaseSymbol()).canBeMirrored());
	}

	@Override
	protected boolean isValidFill(int fill) {
		return LocationBaseSymbol.getLocationBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(fill);
	}

	@Override
	protected boolean isValidRotation(int rotation) {
		return LocationBaseSymbol.getLocationBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues()
				.contains(rotation);
	}

	@Override
	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int maxRotations = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotationValues().size();
		int unmirroredRotations = canMirror() ? maxRotations / 2 : maxRotations;
		boolean isMirrored = getSymbol().getRotation() > unmirroredRotations;

		int nextRotation = getSymbol().getRotation() % unmirroredRotations + 1;

		if (isMirrored) {
			nextRotation += unmirroredRotations;
		}

		setFillAndRotation(getSymbol().getFill(), nextRotation);
	}

	@Override
	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int maxRotations = MovementBaseSymbol.getMovementBaseSymbol(getSymbol().getBaseSymbol())
				.getValidRotationValues().size();
		int unmirroredRotations = canMirror() ? maxRotations / 2 : maxRotations;

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

}
