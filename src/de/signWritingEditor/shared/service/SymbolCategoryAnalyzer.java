package de.signWritingEditor.shared.service;

import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.BodyBaseSymbol;

public class SymbolCategoryAnalyzer {

	public static boolean isBodySymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = symbol.getCategory() == SymbolCategory.BODY.getCategoryNumber();
		if (symbol.getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol()) //
				&& symbol.getFill() >= 2) {
			result = true;
		} else if (BodyBaseSymbol.isAirRelatedBodySymbol(symbol.getBaseSymbol())) {
			result = true;
		}

		return result;
	}

	public static boolean isHeadSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		boolean result = false;
		if (symbol.getBaseSymbol().equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol().getBaseSymbol())
				&& symbol.getFill() > 1) {
			result = false;
		} else if (BodyBaseSymbol.isAirRelatedBodySymbol(symbol.getBaseSymbol())) {
			result = false;
		} else {
			result = symbol.getCategory() == SymbolCategory.HEAD.getCategoryNumber();
		}
		return result;
	}

	public static boolean isMovementSymbol(Symbol symbol) {
		return SymbolCategory.MOVEMENT.getCategoryNumber() == symbol.getCategory();
	}

	public static boolean isHandSymbol(Symbol symbol) {
		return SymbolCategory.HAND.getCategoryNumber() == symbol.getCategory() && symbol.getGroup() != 99;
	}

	public static boolean isFingerAlphabetSymbol(Symbol symbol) {
		return SymbolCategory.HAND.getCategoryNumber() == symbol.getCategory() && symbol.getGroup() == 99;
	}

	public static boolean isPunctuationSymbol(Symbol symbol) {
		return SymbolCategory.PUNCTUATION.getCategoryNumber() == symbol.getCategory();
	}

	public static boolean isDynamicsSymbol(Symbol symbol) {
		return SymbolCategory.DYNAMICS.getCategoryNumber() == symbol.getCategory();
	}
}
