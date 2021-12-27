package de.signWritingEditor.shared.infrastructure;

import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public class SignDataEncoder {

	private IswaBswConverter iswaBswConverter;

	public SignDataEncoder() {
		iswaBswConverter = new IswaBswConverter();
	}

	public String encodePositionedSymbols(List<PositionedSymbol> symbols) {
		assert symbols != null : "Precondition failed: symbols != null";

		StringBuilder stringBuilder = new StringBuilder();

		int xMinimum = 0;
		for (int i = 0, size = symbols.size(); i < size; i++) {
			if (((PositionedSymbol) symbols.get(i)).getX() < 0) {
				xMinimum = Math.min(xMinimum, ((PositionedSymbol) symbols.get(i)).getX());
			}
		}

		int yMinimum = 0;
		for (int i = 0, size = symbols.size(); i < size; i++) {
			if (((PositionedSymbol) symbols.get(i)).getY() < 0) {
				yMinimum = Math.min(yMinimum, ((PositionedSymbol) symbols.get(i)).getY());
			}
		}

		for (int i = 0, size = symbols.size(); i < size; i++) {
			stringBuilder.append("s");

			PositionedSymbol positionedSymbol = symbols.get(i);
			Symbol symbol = positionedSymbol.getSymbol();

			String iswaId = symbol.getIswaId();
			stringBuilder.append(iswaBswConverter.convertIswaToBsw(iswaId));

			stringBuilder.append("x");
			stringBuilder.append(positionedSymbol.getX() - xMinimum);
			stringBuilder.append("y");
			stringBuilder.append(positionedSymbol.getY() - yMinimum);
			stringBuilder.append("z");
			assert positionedSymbol.getZ() >= 0 : "Precondition failed: positionedSymbol.getZ() >= 0";
			stringBuilder.append(positionedSymbol.getZ());
			stringBuilder.append("r");
			stringBuilder.append(positionedSymbol.getLineColor().getCssValue().substring(1));
			stringBuilder.append("w");
			stringBuilder.append(positionedSymbol.getFillColor().getCssValue().substring(1));
		}

		return stringBuilder.toString();
	}
}
