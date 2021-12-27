package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedNeckSymbol extends PositionedSymbol implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedNeckSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedNeckSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@SuppressWarnings("deprecation")
	public PositionedNeckSymbol() {
	}

	public static PositionedNeckSymbol convertToValidNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyNeckSymbol(symbol) : "Precondition failed: isAnyNeckSymbol(symbol)";

		PositionedNeckSymbol result = null;

		if (isValidNeckSymbol(symbol)) {
			result = new PositionedNeckSymbol(symbol);
		} else {
			if (NeckBaseSymbol.NECK.getIswaSymbol().getBaseSymbol().equals(symbol.getBaseSymbol())) {
				Symbol newSymbol = NeckBaseSymbol.NECK.getIswaSymbol();

				result = new PositionedNeckSymbol(newSymbol);
			}

		}
		return result;
	}

	public static boolean isValidNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NeckBaseSymbol.isValidNeckSymbol(symbol);
	}

	public static boolean isAnyNeckSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return NeckBaseSymbol.isAnyNeckSymbol(symbol);
	}

	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";

		setFillAndRotation(getSymbol().getFill() + 1, getSymbol().getRotation());
	}

	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";

		setFillAndRotation(getSymbol().getFill() - 1, getSymbol().getRotation());
	}

	public boolean canIncrease() {
		boolean canIncrease = false;

		if (getSymbol().getFill() < 6) {
			canIncrease = true;
		}

		return canIncrease;
	}

	public boolean canDecrease() {
		boolean canDecrease = false;

		if (getSymbol().getFill() > 2) {
			canDecrease = true;
		}

		return canDecrease;
	}

	protected boolean isValidFill(int fill) {
		assert fill > 0 : "Precondition failed: fill > 0";

		return NeckBaseSymbol.getNeckBaseSymbol(getSymbol()).getValidFills().contains(fill);
	}

	protected boolean isValidRotation(int rotation) {
		assert rotation > 0 : "Precondition failed: rotation > 0";

		return NeckBaseSymbol.getNeckBaseSymbol(getSymbol()).getValidRotationValues().contains(rotation);
	}

	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : NeckBaseSymbol.getAllVariationsForSymbol(getSymbol())) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	@Override
	public PositionedNeckSymbol clone() {
		PositionedNeckSymbol positionedNeckSymbol = new PositionedNeckSymbol(getSymbol(), getX(), getY(), getZ());
		positionedNeckSymbol.setLineColor(getLineColor());
		positionedNeckSymbol.setFillColor(getFillColor());
		return positionedNeckSymbol;
	}

}
