package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedMouthSymbol extends PositionedSymbol implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PositionedMouthSymbol(Symbol symbol, int x, int y, int z) {
		super(symbol, x, y, z);
	}

	public PositionedMouthSymbol(Symbol symbol) {
		this(symbol, 0, 0, 0);
	}

	@Deprecated
	public PositionedMouthSymbol() {
	}

	@Override
	public PositionedMouthSymbol clone() {
		PositionedMouthSymbol positionedMouthSymbol = new PositionedMouthSymbol(getSymbol(), getX(), getY(), getZ());
		positionedMouthSymbol.setLineColor(getLineColor());
		positionedMouthSymbol.setFillColor(getFillColor());
		return positionedMouthSymbol;
	}

	public static boolean isValidMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return MouthBaseSymbol.isValidMouthSymbol(symbol);
	}

	public static boolean isAnyMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return MouthBaseSymbol.isAnyMouthSymbol(symbol);
	}

	public static PositionedMouthSymbol convertToValidMouthSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyMouthSymbol(symbol) : "Precondition failed: isAnyMouthSymbol(symbol)";

		PositionedMouthSymbol result = null;

		if (isValidMouthSymbol(symbol)) {
			result = new PositionedMouthSymbol(symbol);
		} else {
			int height = symbol.getHeight();
			int width = symbol.getWidth();
			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), MouthBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					symbol.getWidth(), symbol.getHeight());

			for (Symbol symbolToSet : MouthBaseSymbol.getAllVariationsForSymbol(symbol)) {
				if (symbolToSet.equals(newSymbol)) {
					height = symbolToSet.getHeight();
					width = symbolToSet.getWidth();
					break;
				}
			}

			result = new PositionedMouthSymbol(new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), MouthBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					width, height));
		}

		return result;
	}

	public boolean canRotate() {
		boolean result = false;
		BaseSymbol baseSymbol = getSymbol().getBaseSymbol();
		if ((MouthBaseSymbol.getMouthBaseSymbol(getSymbol()).getValidRotations().size() > 1)
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_CORNERS.getIswaSymbol().getBaseSymbol()) || getSymbol()
						.getBaseSymbol().equals(MouthBaseSymbol.TEETH_BITE_LIPS.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	public boolean canMirror() {
		boolean result = false;
		BaseSymbol baseSymbol = getSymbol().getBaseSymbol();

		if (baseSymbol.equals(MouthBaseSymbol.TEETH_ON_LIPS.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE_WRINKLED.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE_OPEN.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN_WRINKLED.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN_OPEN.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.LIP_LOWER_OVER_UPPER.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.LIP_UPPER_OVER_LOWER.getIswaSymbol().getBaseSymbol())) {
			result = true;
		}
		return result;
	}

	public boolean canIncrease() {
		return MouthBaseSymbol.getMouthBaseSymbol(getSymbol()).canIncrease();
	}

	public boolean canDecrease() {
		return MouthBaseSymbol.getMouthBaseSymbol(getSymbol()).canDecrease();
	}

	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";

		int oldFill = getSymbol().getFill();
		int oldRotation = getSymbol().getRotation();

		Symbol increasedSymbol = MouthBaseSymbol.MOUTH_WRINKLES_DOUBLE.getIswaSymbol();
		setSymbol(increasedSymbol);

		setFillAndRotation(oldFill, oldRotation);
	}

	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";

		int oldFill = getSymbol().getFill();
		int oldRotation = getSymbol().getRotation();

		Symbol decreasedSymbol = MouthBaseSymbol.MOUTH_WRINKLES_SINGLE.getIswaSymbol();
		setSymbol(decreasedSymbol);

		setFillAndRotation(oldFill, oldRotation);

	}

	public void mirror() {
		assert canMirror() : "Precondition failed: canMirrorHorizontal()";

		BaseSymbol baseSymbol = getSymbol().getBaseSymbol();
		int newFill = getSymbol().getFill();

		if (baseSymbol.equals(MouthBaseSymbol.TEETH_ON_LIPS.getIswaSymbol().getBaseSymbol())) {
			if (newFill == 3) {
				newFill = 4;
			} else {
				newFill = 3;
			}

			setFillAndRotation(newFill, getSymbol().getRotation());

		} else if (baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE_WRINKLED.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_SMILE_OPEN.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN_WRINKLED.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.MOUTH_FROWN_OPEN.getIswaSymbol().getBaseSymbol())) {

			BaseSymbol newBaseSymbol = null;

			if (baseSymbol.getSymbol() == 2) {
				newBaseSymbol = new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(),
						baseSymbol.getSymbol() + 1, baseSymbol.getVariation());
			} else {
				newBaseSymbol = new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(),
						baseSymbol.getSymbol() - 1, baseSymbol.getVariation());
			}
			Symbol newSymbol = getMouthSymbolForBaseSymbolWithFillAndRotation(newBaseSymbol, getSymbol().getFill(),
					getSymbol().getRotation());
			setSymbol(newSymbol);

		} else if (baseSymbol.equals(MouthBaseSymbol.LIP_LOWER_OVER_UPPER.getIswaSymbol().getBaseSymbol())
				|| baseSymbol.equals(MouthBaseSymbol.LIP_UPPER_OVER_LOWER.getIswaSymbol().getBaseSymbol())) {

			BaseSymbol newBaseSymbol = null;

			if (baseSymbol.getVariation() == 2) {
				newBaseSymbol = new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
						baseSymbol.getVariation() + 1);
			} else {
				newBaseSymbol = new BaseSymbol(baseSymbol.getCategory(), baseSymbol.getGroup(), baseSymbol.getSymbol(),
						baseSymbol.getVariation() - 1);
			}

			Symbol newSymbol = getMouthSymbolForBaseSymbolWithFillAndRotation(newBaseSymbol, getSymbol().getFill(),
					getSymbol().getRotation());
			setSymbol(newSymbol);

		}

	}

	private Symbol getMouthSymbolForBaseSymbolWithFillAndRotation(BaseSymbol newBaseSymbol, int fill, int rotation) {
		assert newBaseSymbol != null : "Precondition failed: newBaseSymbol != null";
		assert fill > 0 : "Precondition failed: fill > 0";
		assert rotation > 0 : "Precondition failed: rotation > 0";

		Symbol result = null;

		for (Symbol symbol : MouthBaseSymbol.getAllVariationsForSymbol(newBaseSymbol)) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		return result;
	}

	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation() - 1;
		int nextFill = getSymbol().getFill();

		if (getSymbol().getBaseSymbol().equals(MouthBaseSymbol.MOUTH_CORNERS.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MouthBaseSymbol.TEETH_BITE_LIPS.getIswaSymbol().getBaseSymbol())) {
			nextRotation = 1;
			nextFill++;

			if (nextFill == 7) {
				nextFill = 4;
			}
		} else {
			if (nextRotation == 0) {
				nextRotation = 8;
			}
		}

		setFillAndRotation(nextFill, nextRotation);
	}

	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		int nextRotation = getSymbol().getRotation() + 1;
		int nextFill = getSymbol().getFill();

		if (getSymbol().getBaseSymbol().equals(MouthBaseSymbol.MOUTH_CORNERS.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(MouthBaseSymbol.TEETH_BITE_LIPS.getIswaSymbol().getBaseSymbol())) {
			nextRotation = 1;
			nextFill--;

			if (nextFill == 3) {
				nextFill = 6;
			}
		} else {
			if (nextRotation == 9) {
				nextRotation = 1;
			}

		}

		setFillAndRotation(nextFill, nextRotation);
	}

	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(rotation) : "Precondition failed: isValidRotation(rotation)";
		assert isValidFill(fill) : "Precondition failed: isValidFill(fill)";

		Symbol result = null;

		for (Symbol symbol : MouthBaseSymbol.getAllVariationsForSymbol(getSymbol())) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	protected boolean isValidFill(int fill) {
		assert fill > 0 : "Precondition failed: fill > 0";

		return MouthBaseSymbol.getMouthBaseSymbol(getSymbol()).getValidFills().contains(fill);
	}

	protected boolean isValidRotation(int rotation) {
		assert rotation > 0 : "Precondition failed: rotation > 0";

		return MouthBaseSymbol.getMouthBaseSymbol(getSymbol()).getValidRotationValues().contains(rotation);
	}

	public static PositionedMouthSymbol getEmptySymbol() {
		return new PositionedMouthSymbol(Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL);
	}

}
