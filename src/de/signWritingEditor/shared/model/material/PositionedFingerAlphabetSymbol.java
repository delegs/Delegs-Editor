package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedFingerAlphabetSymbol extends PositionedSymbol {

	private static final long serialVersionUID = 1L;

	private static final int ZY_OFFSET = 8;
	private static final int ZX_OFFSET = 3;
	private static final int J_OFFSET = 19;
	private static final int Y_OFFSET = 19;
	private static final int X_OFFSET = 5;
	private static final int UX_OFFSET = 4;
	protected static final int AX_OFFSET = 1;

	private FingerAlphabet fingerAlphabetSymbol;
	private List<PositionedSymbol> symbolList;

	@Deprecated
	protected PositionedFingerAlphabetSymbol() {
	}

	public PositionedFingerAlphabetSymbol(FingerAlphabet fingerAlphabetSymbol, int x, int y, int z) {
		super(fingerAlphabetSymbol.getIswaSymbol(), x, y, z);

		this.fingerAlphabetSymbol = fingerAlphabetSymbol;
		symbolList = new ArrayList<PositionedSymbol>();
		Symbol handSymbol = fingerAlphabetSymbol.getHandSymbol();
		Symbol movementSymbol = null;
		if (fingerAlphabetSymbol.hasMovement()) {
			movementSymbol = fingerAlphabetSymbol.getMovementSymbol();
			symbolList.add(new PositionedSymbol(movementSymbol, 0, 0, 1));
		}

		if (fingerAlphabetSymbol.equals(FingerAlphabet.Ü)) {
			symbolList.add(new PositionedSymbol(handSymbol, UX_OFFSET, Y_OFFSET, 1));
		} else if (fingerAlphabetSymbol.equals(FingerAlphabet.Ö) || fingerAlphabetSymbol.equals(FingerAlphabet.ß)) {
			symbolList.add(new PositionedSymbol(handSymbol, X_OFFSET, Y_OFFSET, 1));
		} else if (fingerAlphabetSymbol.equals(FingerAlphabet.Ä)) {
			symbolList.add(new PositionedSymbol(handSymbol, AX_OFFSET, Y_OFFSET, 1));
		} else if (fingerAlphabetSymbol.equals(FingerAlphabet.Z)) {
			symbolList.add(new PositionedSymbol(handSymbol, -ZX_OFFSET, ZY_OFFSET, 1));
		} else if (fingerAlphabetSymbol.equals(FingerAlphabet.J)) {
			symbolList.add(new PositionedSymbol(handSymbol, J_OFFSET, J_OFFSET, 1));
		} else {
			symbolList.add(new PositionedSymbol(handSymbol, 0, 0, 1));
		}

	}

	@Override
	public int getWidth() {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;

		for (PositionedSymbol positionedSymbol : symbolList) {
			minX = Math.min(positionedSymbol.getX(), minX);
			maxX = Math.max(positionedSymbol.getX() + positionedSymbol.getWidth(), maxX);
		}

		return maxX - minX;
	}

	@Override
	public int getHeight() {
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (PositionedSymbol positionedSymbol : symbolList) {
			minY = Math.min(positionedSymbol.getY(), minY);
			maxY = Math.max(positionedSymbol.getY() + positionedSymbol.getHeight(), maxY);
		}

		return maxY - minY;
	}

	public List<PositionedSymbol> getIswaSymbols() {
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();
		for (PositionedSymbol positionedSymbol : symbolList) {

			PositionedSymbol resultSymbol = new PositionedSymbol(positionedSymbol.getSymbol(), //
					getX() + positionedSymbol.getX(), //
					getY() + positionedSymbol.getY(), //
					getZ() + +positionedSymbol.getZ());

			resultSymbol.setFillColor(getFillColor());
			resultSymbol.setLineColor(getLineColor());
			result.add(resultSymbol);
		}

		return result;
	}

	public List<PositionedSymbol> getPositionedSymbols() {
		return java.util.Collections.unmodifiableList(symbolList);
	}

	@Override
	public PositionedFingerAlphabetSymbol clone() {
		PositionedFingerAlphabetSymbol clone = new PositionedFingerAlphabetSymbol(fingerAlphabetSymbol, getX(), getY(),
				getZ());

		clone.setFillColor(getFillColor());
		clone.setLineColor(getLineColor());

		List<PositionedSymbol> positionedSymbolListClone = new ArrayList<PositionedSymbol>();

		for (PositionedSymbol positionedSymbol : symbolList) {
			positionedSymbolListClone.add(positionedSymbol.clone());
		}

		clone.setPositionedSymbols(positionedSymbolListClone);
		return clone;
	}

	@Override
	public void setLineColor(Color color) {
		assert color != null : "Precondition failed: color != null";

		super.setLineColor(color);

		for (PositionedSymbol positionedSymbol : symbolList) {
			positionedSymbol.setLineColor(color);
		}
	}

	public void setFillColor(Color color) {
		assert color != null : "Precondition failed: color != null";

		super.setFillColor(color);

		for (PositionedSymbol positionedSymbol : symbolList) {
			positionedSymbol.setFillColor(color);
		}
	}

	public Color getLineColor() {
		if (symbolList.size() > 0) {
			return symbolList.get(0).getLineColor();
		}
		return super.getLineColor();
	}

	public Color getFillColor() {
		if (symbolList.size() > 0) {
			return symbolList.get(0).getFillColor();
		}
		return super.getFillColor();
	}

	public FingerAlphabet getFingerAlphabetSymbol() {
		return fingerAlphabetSymbol;
	}

	private void setPositionedSymbols(List<PositionedSymbol> positionedSymbolList) {
		this.symbolList = positionedSymbolList;

	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((symbolList == null) ? 0 : symbolList.hashCode());
		result = prime * result + ((fingerAlphabetSymbol == null) ? 0 : fingerAlphabetSymbol.hashCode());

		return result;
	}
}
