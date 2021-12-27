package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedBreathSymbol extends PositionedSymbol implements Cloneable, Locatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;

	public PositionedBreathSymbol(Symbol leftSymbol, Location location, int x, int y, int z) {
		super(leftSymbol, x, y, z);
		this.location = location;
	}

	public PositionedBreathSymbol(Symbol symbol, Location location) {
		this(symbol, location, 0, 0, 0);
	}

	@Deprecated
	public PositionedBreathSymbol() {
	}

	@Override
	public PositionedBreathSymbol clone() {
		PositionedBreathSymbol positionedBreathSymbol = new PositionedBreathSymbol(getSymbol(), location, getX(),
				getY(), getZ());
		positionedBreathSymbol.setLineColor(getLineColor());
		positionedBreathSymbol.setFillColor(getFillColor());
		return positionedBreathSymbol;
	}

	public boolean isLeftBreathSymbol() {
		return Location.LEFT.equals(location);
	}

	public boolean isRightBreathSymbol() {
		return Location.RIGHT.equals(location);
	}

	public static boolean isValidBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return BreathBaseSymbol.isValidBreathSymbol(symbol);
	}

	public static boolean isAnyBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return BreathBaseSymbol.isAnyBreathSymbol(symbol);
	}

	public static List<PositionedBreathSymbol> convertToValidBreathSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyBreathSymbol(symbol) : "Precondition failed: isAnyBreathSymbol(symbol)";

		List<PositionedBreathSymbol> result = new ArrayList<PositionedBreathSymbol>();

		if (isValidBreathSymbol(symbol)) {
			result.add(new PositionedBreathSymbol(BreathBaseSymbol.getLeftBreathSymbolFor(symbol), Location.LEFT));
			result.add(new PositionedBreathSymbol(BreathBaseSymbol.getRightBreathSymbolFor(symbol), Location.RIGHT));
		} else {
			int height = symbol.getHeight();
			int width = symbol.getWidth();
			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), BreathBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					symbol.getWidth(), symbol.getHeight());

			for (Symbol symbolToSet : BreathBaseSymbol.getAllVariationsForSymbol(symbol)) {
				if (symbolToSet.equals(newSymbol)) {
					height = symbolToSet.getHeight();
					width = symbolToSet.getWidth();
					break;
				}
			}

			Symbol newBreathSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), BreathBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					width, height);

			if (symbol.getFill() <= 2) {
				result.add(new PositionedBreathSymbol(BreathBaseSymbol.getRightBreathSymbolFor(newBreathSymbol),
						Location.RIGHT));
			}
			if (symbol.getFill() == 1 || symbol.getFill() == 3) {
				result.add(new PositionedBreathSymbol(BreathBaseSymbol.getLeftBreathSymbolFor(newBreathSymbol),
						Location.LEFT));
			}
		}
		return result;
	}

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
	public String toString() {
		return "Symbol(id: " + getSymbol().toString() + ", x: " + getX() + ", y: " + getY() + ", z: " + getZ()
				+ ", Location: " + getLocation() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		PositionedBreathSymbol other = (PositionedBreathSymbol) obj;
		if (location != other.location)
			return false;
		return true;
	}
}
