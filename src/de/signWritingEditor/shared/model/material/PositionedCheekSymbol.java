package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedCheekSymbol extends PositionedSymbol implements Cloneable, Locatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;

	public PositionedCheekSymbol(Symbol cheekSymbol, Location location, int x, int y, int z) {
		super(cheekSymbol, x, y, z);
		this.location = location;
	}

	public PositionedCheekSymbol(Symbol symbol, Location position) {
		this(symbol, position, 0, 0, 0);
	}

	@Deprecated
	public PositionedCheekSymbol() {
	}

	@Override
	public PositionedCheekSymbol clone() {
		PositionedCheekSymbol positionedCheekSymbol = new PositionedCheekSymbol(getSymbol(), location, getX(), getY(),
				getZ());
		positionedCheekSymbol.setLineColor(getLineColor());
		positionedCheekSymbol.setFillColor(getFillColor());
		return positionedCheekSymbol;
	}

	public boolean isLeftCheek() {
		return Location.LEFT.equals(location);
	}

	public boolean isRightCheek() {
		return Location.RIGHT.equals(location);
	}

	public static boolean isValidCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return CheeksBaseSymbol.isValidCheeksSymbol(symbol);
	}

	public static boolean isAnyCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return CheeksBaseSymbol.isAnyCheeksSymbol(symbol);
	}

	public static List<PositionedCheekSymbol> convertToValidCheeksSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyCheeksSymbol(symbol) : "Precondition failed: isAnyCheeksSymbol(symbol)";

		List<PositionedCheekSymbol> result = new ArrayList<PositionedCheekSymbol>();

		if (isValidCheeksSymbol(symbol)) {
			result.add(
					new PositionedCheekSymbol(CheeksBaseSymbol.getLeftCheekFor(symbol.getBaseSymbol()), Location.LEFT));
			result.add(new PositionedCheekSymbol(CheeksBaseSymbol.getRightCheekFor(symbol.getBaseSymbol()),
					Location.RIGHT));
		} else {

			int height = symbol.getHeight();
			int width = symbol.getWidth();

			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), CheeksBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					symbol.getWidth(), symbol.getHeight());

			for (Symbol symbolToSet : CheeksBaseSymbol.getAllVariationsForSymbol(symbol)) {
				if (symbolToSet.equals(newSymbol)) {

					height = symbolToSet.getHeight();
					width = symbolToSet.getWidth();
					break;
				}
			}

			Symbol newCheekSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), CheeksBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					width, height);
			if (symbol.getFill() <= 2) {
				result.add(new PositionedCheekSymbol(CheeksBaseSymbol.getRightCheekFor(newCheekSymbol.getBaseSymbol()),
						Location.RIGHT));
			}
			if (symbol.getFill() == 1 || symbol.getFill() == 3) {
				result.add(new PositionedCheekSymbol(CheeksBaseSymbol.getLeftCheekFor(newCheekSymbol.getBaseSymbol()),
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
	public String toString() {
		return "Symbol(id: " + getSymbol().toString() + ", x: " + getX() + ", y: " + getY() + ", z: " + getZ()
				+ ", Location: " + getLocation() + ")";
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
		PositionedCheekSymbol other = (PositionedCheekSymbol) obj;
		if (location != other.location)
			return false;
		return true;
	}
}
