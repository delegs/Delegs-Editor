package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedNoseSymbol extends PositionedSymbol implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedNoseSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedNoseSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@Deprecated
	public PositionedNoseSymbol() {
	}

	public static boolean isValidNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NoseBaseSymbol.isValidNoseSymbol(symbol);
	}

	public static PositionedNoseSymbol convertToValidNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyNoseSymbol(symbol) : "Precondition failed: isAnyNoseSymbol(symbol)";

		PositionedNoseSymbol result = null;

		if (isValidNoseSymbol(symbol)) {
			result = new PositionedNoseSymbol(symbol);
		} else {
			for (NoseBaseSymbol noseBaseSymbol : NoseBaseSymbol.values()) {
				if (noseBaseSymbol.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
					Symbol newSymbol = noseBaseSymbol.getIswaSymbol();
					result = new PositionedNoseSymbol(newSymbol);
				}
			}

		}
		return result;
	}

	public static boolean isAnyNoseSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NoseBaseSymbol.isAnyNoseSymbol(symbol);
	}

	@Override
	public PositionedNoseSymbol clone() {
		PositionedNoseSymbol positionedNoseSymbol = new PositionedNoseSymbol(getSymbol(), getX(), getY(), getZ());
		positionedNoseSymbol.setLineColor(getLineColor());
		positionedNoseSymbol.setFillColor(getFillColor());
		return positionedNoseSymbol;
	}

}
