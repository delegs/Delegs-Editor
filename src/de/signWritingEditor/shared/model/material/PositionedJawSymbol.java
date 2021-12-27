package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedJawSymbol extends PositionedSymbol implements Cloneable, Locatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;

	public PositionedJawSymbol(Symbol symbol, Location location, int x, int y, int z) {
		super(symbol, x, y, z);
		this.location = location;
	}

	public PositionedJawSymbol(Symbol symbol, Location location) {
		this(symbol, location, 0, 0, 0);
	}

	@Deprecated
	public PositionedJawSymbol() {
	}

	@Override
	public PositionedJawSymbol clone() {
		PositionedJawSymbol positionedJawSymbol = new PositionedJawSymbol(getSymbol(), location, getX(), getY(),
				getZ());
		positionedJawSymbol.setLineColor(getLineColor());
		positionedJawSymbol.setFillColor(getFillColor());
		return positionedJawSymbol;
	}

	public static boolean isAnyJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return JawBaseSymbol.isAnyJawSymbol(symbol);
	}

	public static boolean isValidJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return JawBaseSymbol.isValidJawSymbol(symbol);
	}

	public static List<PositionedJawSymbol> convertToValidJawSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyJawSymbol(symbol) : "Precondition failed: isAnyJawSymbol(symbol)";

		List<PositionedJawSymbol> result = new ArrayList<PositionedJawSymbol>();

		if (isValidJawSymbol(symbol)) {
			result.add(new PositionedJawSymbol(symbol, Location.LEFT));
			if (symbol.equals(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL)) {
				result.add(new PositionedJawSymbol(symbol, Location.BOTH));
			} else {
				result.add(new PositionedJawSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH));
			}
			result.add(new PositionedJawSymbol(symbol, Location.RIGHT));
		} else {
			int height = symbol.getHeight();
			int width = symbol.getWidth();

			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), JawBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					symbol.getWidth(), symbol.getHeight());

			for (Symbol symbolToSet : JawBaseSymbol.getAllVariationsForSymbol(symbol)) {
				if (symbolToSet.equals(newSymbol)) {
					height = symbolToSet.getHeight();
					width = symbolToSet.getWidth();
					break;
				}
			}

			Symbol newJawSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), JawBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					width, height);

			result.add(new PositionedJawSymbol(newJawSymbol, Location.LEFT));
			result.add(new PositionedJawSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH));
			result.add(new PositionedJawSymbol(newJawSymbol, Location.RIGHT));
		}
		return result;
	}

	public boolean canRotate() {
		return true;
	}

	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (!getSymbol().equals(Symbol.JAW_PART_HEAD_RIM)) {
			int newRotation = getSymbol().getRotation() - 1;

			if (newRotation == 0) {
				newRotation = 8;
			}

			setFillAndRotation(getSymbol().getFill(), newRotation);
		}
	}

	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (!getSymbol().equals(Symbol.JAW_PART_HEAD_RIM)) {
			int newRotation = getSymbol().getRotation() + 1;

			if (newRotation == 9) {
				newRotation = 1;
			}

			setFillAndRotation(getSymbol().getFill(), newRotation);
		}
	}

	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : JawBaseSymbol.getAllVariationsForSymbol(getSymbol())) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	protected boolean isValidRotation(int rotation) {
		assert rotation > 0 : "Precondition failed: rotation > 0";

		return JawBaseSymbol.getJawBaseSymbol(getSymbol().getBaseSymbol()).getValidRotationValues().contains(rotation);
	}

	protected boolean isValidFill(int fill) {
		assert fill > 0 : "Precondition failed: fill > 0";

		return JawBaseSymbol.getJawBaseSymbol(getSymbol().getBaseSymbol()).getValidFills().contains(fill);
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		PositionedJawSymbol other = (PositionedJawSymbol) obj;
		if (location != other.location)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Symbol(id: " + getSymbol().toString() + ", x: " + getX() + ", y: " + getY() + ", z: " + getZ()
				+ ", Location: " + getLocation() + ")";
	}

}
