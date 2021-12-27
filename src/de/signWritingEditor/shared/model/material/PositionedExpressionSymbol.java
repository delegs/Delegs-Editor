package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedExpressionSymbol extends PositionedSymbol implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedExpressionSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedExpressionSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@Deprecated
	public PositionedExpressionSymbol() {
	}

	public static boolean isValidExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return ExpressionBaseSymbol.isValidExpressionSymbol(symbol);
	}

	public static boolean isAnyExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return ExpressionBaseSymbol.isAnyExpressionSymbol(symbol);
	}

	public static PositionedExpressionSymbol convertToValidExpressionSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyExpressionSymbol(symbol) : "Precondition failed: isAnyExpressionSymbol(symbol)";

		PositionedExpressionSymbol result = null;

		if (isValidExpressionSymbol(symbol)) {
			result = new PositionedExpressionSymbol(symbol);
		} else {
			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), 2, symbol.getRotation(), symbol.getWidth(), symbol.getHeight());

			result = new PositionedExpressionSymbol(newSymbol);
		}
		return result;
	}

	@Override
	public PositionedExpressionSymbol clone() {
		PositionedExpressionSymbol positionedExpressionSymbol = new PositionedExpressionSymbol(getSymbol(), getX(),
				getY(), getZ());
		positionedExpressionSymbol.setLineColor(getLineColor());
		positionedExpressionSymbol.setFillColor(getFillColor());
		return positionedExpressionSymbol;
	}

}
