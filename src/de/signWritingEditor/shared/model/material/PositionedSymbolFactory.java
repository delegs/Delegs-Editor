package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class PositionedSymbolFactory {

	public PositionedSymbolFactory() {
	}

	public PositionedSymbol createPositionedSymbol(Symbol symbol) {
		return createPositionedSymbol(symbol, 0, 0, 0);
	}

	public PositionedSymbol createPositionedSymbol(Symbol symbol, Location location) {
		return createPositionedSymbol(symbol, location, 0, 0, 0);
	}

	public PositionedSymbol createPositionedSymbol(Symbol symbol, int x, int y, int z) {
		assert symbol != null : "Precondition failed: symbol != null";

		return createPositionedSymbol(symbol, Location.UNKNOWN, x, y, z);
	}

	public PositionedSymbol createPositionedSymbol(Symbol symbol, Location position, int x, int y, int z) {
		assert symbol != null : "Precondition failed: symbol != null";

		PositionedSymbol result = null;
		if (SymbolCategoryAnalyzer.isHeadSymbol(symbol)) {
			result = createHeadSymbolElement(symbol, position, x, y, z);
		} else {
			throw (new RuntimeException("Symbol Category not implemented: " + symbol.getCategory()));
		}
		return result;
	}

	public HeadSymbol createHeadSymbol(PositionedSymbol... positionedSymbols) {
		return createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), positionedSymbols);
	}

	public HeadSymbol createHeadSymbol(PositionedHeadPostureSymbol positionedHeadPosture,
			PositionedSymbol... positionedSymbols) {
		return createHeadSymbol(positionedHeadPosture, 0, 0, 1, positionedSymbols);
	}

	public HeadSymbol createHeadSymbol(PositionedHeadPostureSymbol positionedHeadPosture, int x, int y, int z,
			PositionedSymbol... positionedSymbols) {
		assert z >= 0 : "Precondition failed: z >= 0";
		return new HeadSymbol(positionedHeadPosture, x, y, z, positionedSymbols);
	}

	private PositionedSymbol createHeadSymbolElement(Symbol symbol, Location location, int x, int y, int z) {
		PositionedSymbol result = null;

		if (HeadPostureBaseSymbol.isAnyHeadPostureSymbol(symbol)) {
			result = new PositionedHeadPostureSymbol(symbol, x, y, z);
		} else if (EyesBaseSymbol.isAnyEyesSymbol(symbol)) {
			if (EyesBaseSymbol.isValidEyesSymbol(symbol)) {
				result = new PositionedEyeSymbol(symbol, location, x, y, z);
			}
		} else if (MouthBaseSymbol.isAnyMouthSymbol(symbol.getBaseSymbol())) {
			result = PositionedMouthSymbol.convertToValidMouthSymbol(symbol);
		} else if (BreathBaseSymbol.isAnyBreathSymbol(symbol)) {
			result = new PositionedBreathSymbol(symbol, location, x, y, z);
		} else if (HairBaseSymbol.isAnyHairSymbol(symbol)) {
			result = new PositionedHairSymbol(symbol, x, y, z);
		} else if (NoseBaseSymbol.isAnyNoseSymbol(symbol)) {
			result = new PositionedNoseSymbol(symbol, x, y, z);
		} else if (CheeksBaseSymbol.isAnyCheeksSymbol(symbol)) {
			result = new PositionedCheekSymbol(symbol, location, x, y, z);
		} else if (JawBaseSymbol.isAnyJawSymbol(symbol)) {
			result = new PositionedJawSymbol(symbol, location, x, y, z);
		} else if (NeckBaseSymbol.isAnyNeckSymbol(symbol)) {
			result = new PositionedNeckSymbol(symbol, x, y, z);
		} else if (ExpressionBaseSymbol.isAnyExpressionSymbol(symbol)) {
			result = new PositionedExpressionSymbol(symbol, x, y, z);
		} else if (EarsBaseSymbol.isAnyEarsSymbol(symbol)) {
			result = new PositionedEarsSymbol(symbol, location, x, y, z);
		}

		else {
			throw (new RuntimeException("Not implemented Symbol Group: " + symbol.getGroup()));
		}
		assert result != null : "Postcondition failed: result != null";
		result.setX(x);
		result.setY(y);
		result.setZ(z);
		return result;
	}
}
