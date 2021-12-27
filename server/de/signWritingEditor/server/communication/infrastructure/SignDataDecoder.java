package de.signWritingEditor.server.communication.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import de.signWritingEditor.shared.infrastructure.IswaBswConverter;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SignDataDecoder {

	private static final Pattern SIGN_PATTERN = Pattern
			.compile("(s[0-9a-fA-F]{5}x\\d+y\\d+z\\d+(r[A-Fa-f0-9]{6})?(w[A-Fa-f0-9]{6})?)*");

	private final SymbolFactory symbolFactory;
	private IswaBswConverter iswaBswConverter;

	public SignDataDecoder(SymbolFactory symbolFactory) {
		assert symbolFactory != null : "Precondition failed: symbolFactory != null";

		this.symbolFactory = symbolFactory;

		iswaBswConverter = new IswaBswConverter();
	}

	public List<PositionedSymbol> decodePositionedSymbols(String signCode) {
		assert isValidSignDataCode(signCode) : "Precondition failed: isValidSignCode(signCode)";

		String[] positionedSymbolCodes = signCode.split("s");
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		for (String symbolCode : positionedSymbolCodes) {
			if (!"".equals(symbolCode)) {
				String[] symbolCodeParts = symbolCode.split("[xyzrw]");

				String bswSymbolString = symbolCodeParts[0];
				int bswSymbol = Integer.parseInt(bswSymbolString.substring(0, 3), 16);
				int bswFill = Integer.parseInt(bswSymbolString.substring(3, 4), 16);
				int bswRotation = Integer.parseInt(bswSymbolString.substring(4), 16);

				Symbol symbol = symbolFactory
						.createSymbol(iswaBswConverter.convertBswToIswa(bswSymbol, bswFill, bswRotation));

				int x = Integer.valueOf(symbolCodeParts[1]);
				int y = Integer.valueOf(symbolCodeParts[2]);
				int z = Integer.valueOf(symbolCodeParts[3]);

				Color lineColor;
				if (symbolCodeParts.length > 4) {
					lineColor = Color.makeFromCssString("#" + symbolCodeParts[4]);
				} else {
					lineColor = Color.BLACK;
				}

				Color fillColor;
				if (symbolCodeParts.length > 4) {
					fillColor = Color.makeFromCssString("#" + symbolCodeParts[5]);
				} else {
					fillColor = Color.WHITE;
				}

				PositionedSymbol positionedSymbol;
				if (SymbolCategoryAnalyzer.isFingerAlphabetSymbol(symbol)) {
					positionedSymbol = new PositionedFingerAlphabetSymbol(
							FingerAlphabet.getFingerAlphabetSymbolFor(symbol), x, y, z);
				} else {
					positionedSymbol = new PositionedSymbol(symbol, x, y, z);
				}
				positionedSymbol.setLineColor(lineColor);
				positionedSymbol.setFillColor(fillColor);
				result.add(positionedSymbol);

			}
		}

		return result;
	}

	public boolean isValidSignDataCode(String signCode) {
		return signCode != null && SIGN_PATTERN.matcher(signCode).matches();
	}
}
