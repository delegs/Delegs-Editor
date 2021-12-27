package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedSymbol implements Serializable {

	private static final long serialVersionUID = 6893488754843107458L;

	private Symbol symbol;

	private int x;
	private int y;
	private int z;
	private Color lineColor = Color.makeFromRGB(0, 0, 0);
	private Color fillColor = Color.makeFromRGB(255, 255, 255);

	public PositionedSymbol(Symbol symbol, int x, int y, int z) throws AssertionError {
		assert symbol != null : "Precondition failed: symbol != null";
		assert z >= 0 : "Precondition failed: z >= 0";
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		assert z >= 0 : "Precondition failed: z >= 0";
		this.z = z;
	}

	public void setLineColor(Color color) {
		assert color != null : "Precondition failed: color != null";

		this.lineColor = color;
	}

	public void setFillColor(Color color) {
		assert color != null : "Precondition failed: color != null";

		this.fillColor = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getHeight() {
		int result = getSymbol().getHeight();

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getWidth() {
		int result = getSymbol().getWidth();

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public void setSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Symbol(id: " + symbol.toString() + ", x: " + x + ", y: " + y + ", z: " + z + ")";
	}

	@SuppressWarnings("all")
	public PositionedSymbol clone() {
		PositionedSymbol positionedSymbol = new PositionedSymbol(
				new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(), symbol.getVariation(),
						symbol.getFill(), symbol.getRotation(), symbol.getWidth(), symbol.getHeight()),
				x, y, z);
		positionedSymbol.setLineColor(lineColor);
		positionedSymbol.setFillColor(fillColor);
		return positionedSymbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		result = prime * result + ((lineColor == null) ? 0 : lineColor.hashCode());
		result = prime * result + ((fillColor == null) ? 0 : fillColor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj instanceof PositionedSymbol) {
			PositionedSymbol other = (PositionedSymbol) obj;

			if (symbol != null) {
				result = symbol.equals(other.symbol);
			} else {
				result = other.symbol == null;
			}
			result &= this.x == other.x && this.y == other.y && this.z == other.z;
			result &= this.fillColor.equals(other.fillColor) && this.lineColor.equals(other.lineColor);
		}
		return result;
	}

	/**
	 * Empty constructor.
	 * 
	 * @deprecated For serialization only.
	 */
	@Deprecated
	protected PositionedSymbol() {
	}

	public BaseSymbol getBaseSymbol() {
		return getSymbol().getBaseSymbol();
	}

	public boolean canSwitchArrowHead() {
		return false;
	}

	public boolean canManipulate() {
		return false;
	}

	public boolean canRotate() {
		return false;
	}

	public boolean canRoll() {
		return false;
	}

	public boolean canMirror() {
		return false;
	}

	public boolean canMirrorVertically() {
		return false;
	}

	public boolean canPitch() {
		return false;
	}

	protected boolean isValidFill(int fill) {
		return false;
	}

	protected boolean isValidRotation(int rotation) {
		return false;
	}

	public boolean canIncrease() {
		return false;
	}

	public boolean canDecrease() {
		return false;
	}

	public boolean canSwitchToAlternatingArrows() {
		return false;
	}

	public boolean canSwitchToNormalArrows() {
		return false;
	}

	public boolean canSwitchStartingPoint() {
		return false;
	}

	public boolean canSwitchSize() {
		return false;
	}

	public boolean canSwitchPlane() {
		return false;
	}

	public void switchArrowHead() {
	}

	public void roll() {
	}

	public void pitch() {
	}

	public void rotateClockwise() {
	}

	public void rotateCounterClockwise() {
	}

	public void setFillAndRotation(int fill, int rotation) {
	}

	public void mirror() {
	}

	public void mirrorVertically() {
	}

	public void increase() {
	}

	public void decrease() {
	}

	public void switchToAlternatingArrows() {
	}

	public void switchToNormalArrows() {
	}

	public void switchStartingPoint() {
	}

	public void switchSize() {
	}

	public void switchPlane() {
	}

	public Color getLineColor() {
		return lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}
}
