package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedEarsSymbol extends PositionedSymbol implements Cloneable, Locatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;

	public PositionedEarsSymbol(Symbol earSymbol, Location location, int x, int y, int z) {
		super(earSymbol, x, y, z);
		this.location = location;
	}

	public PositionedEarsSymbol(Symbol symbol, Location location) {
		this(symbol, location, 0, 0, 0);
	}

	public static List<PositionedEarsSymbol> convertToValidEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyEarsSymbol(symbol) : "Precondition failed: isAnyEarsSymbol(symbol)";

		List<PositionedEarsSymbol> result = new ArrayList<PositionedEarsSymbol>();

		if (symbol.getFill() <= 2) {
			result.add(new PositionedEarsSymbol(EarsBaseSymbol.getRightEarFor(symbol), Location.RIGHT));
		}
		if (symbol.getFill() == 1 || symbol.getFill() == 3) {
			result.add(new PositionedEarsSymbol(EarsBaseSymbol.getLeftEarFor(symbol), Location.LEFT));
		}

		return result;
	}

	@Deprecated
	public PositionedEarsSymbol() {
	}

	public static boolean isValidEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EarsBaseSymbol.isValidEarsSymbol(symbol);
	}

	public static boolean isAnyEarsSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EarsBaseSymbol.isAnyEarsSymbol(symbol);
	}

	@Override
	public PositionedEarsSymbol clone() {
		PositionedEarsSymbol positionedEarsSymbol = new PositionedEarsSymbol(getSymbol(), location, getX(), getY(),
				getZ());
		positionedEarsSymbol.setLineColor(getLineColor());
		positionedEarsSymbol.setFillColor(getFillColor());
		return positionedEarsSymbol;
	}

	public boolean isLeftEar() {
		return Location.LEFT.equals(location);
	}

	public boolean isRightEar() {
		return Location.RIGHT.equals(location);
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
		PositionedEarsSymbol other = (PositionedEarsSymbol) obj;
		if (location != other.location)
			return false;
		return true;
	}
}
