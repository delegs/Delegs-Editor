package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedHairSymbol extends PositionedSymbol implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedHairSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedHairSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@Deprecated
	public PositionedHairSymbol() {
	}

	@Override
	public PositionedHairSymbol clone() {
		PositionedHairSymbol positionedHairSymbol = new PositionedHairSymbol(getSymbol(), getX(), getY(), getZ());
		positionedHairSymbol.setLineColor(getLineColor());
		positionedHairSymbol.setFillColor(getFillColor());
		return positionedHairSymbol;
	}

	public static boolean isValidHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return HairBaseSymbol.isValidHairSymbol(symbol);
	}

	public static boolean isAnyHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return HairBaseSymbol.isAnyHairSymbol(symbol);
	}

	public static PositionedHairSymbol convertToValidHairSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyHairSymbol(symbol) : "Precondition failed: isAnyHairSymbol(symbol)";

		PositionedHairSymbol result = null;

		if (isValidHairSymbol(symbol)) {
			result = new PositionedHairSymbol(symbol);
		} else {
			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), 2, symbol.getRotation(), symbol.getWidth(), symbol.getHeight());

			result = new PositionedHairSymbol(newSymbol);
		}
		return result;
	}
}
