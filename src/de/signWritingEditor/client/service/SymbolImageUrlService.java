package de.signWritingEditor.client.service;

import java.util.List;

import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;

public class SymbolImageUrlService {
	private SignDataEncoder signDataEncoder;

	public SymbolImageUrlService() {
		signDataEncoder = new SignDataEncoder();
	}

	public String getSymbolImageUrl(Symbol symbol, double scaleFactor) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		String result = "signwritingeditor/symbolimages?symboldata=" + symbol.getIswaId() + "&scale="
				+ Double.toString(scaleFactor);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public String getSymbolImageUrl(PositionedSymbol positionedSymbol, double scaleFactor) {
		assert positionedSymbol != null : "Precondition failed: symbol != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";
		String result = null;
		if (positionedSymbol instanceof PositionedFingerAlphabetSymbol) {
			result = createImageUrlStringForCompositeSymbols(
					((PositionedFingerAlphabetSymbol) positionedSymbol).getPositionedSymbols(), scaleFactor, true);
		} else {
			result = "signwritingeditor/symbolimages?symboldata=" + positionedSymbol.getSymbol().getIswaId() + "&scale="
					+ Double.toString(scaleFactor) + "&colorFormerBlack="
					+ positionedSymbol.getLineColor().getCssValue().substring(1) + "&colorFormerWhite="
					+ positionedSymbol.getFillColor().getCssValue().substring(1);
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public String getHeadSymbolImageUrl(HeadSymbol headSymbol, double scaleFactor, boolean transparent) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert scaleFactor > 0 : "Precondition failed: scaleFactor > 0";

		String result = createImageUrlStringForCompositeSymbols(
				SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol, 0, 0, 1), scaleFactor,
				transparent);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private String createImageUrlStringForCompositeSymbols(List<PositionedSymbol> list, double scaleFactor,
			boolean transparent) {
		StringBuilder resultBuilder = new StringBuilder("signwritingeditor/signwritingimage");
		resultBuilder.append("?symbols=");
		resultBuilder.append(signDataEncoder.encodePositionedSymbols(list));

		resultBuilder.append("&transparent=");
		resultBuilder.append(transparent);

		resultBuilder.append("&scale=");
		resultBuilder.append(scaleFactor);

		String result = resultBuilder.toString();
		return result;
	}
}
