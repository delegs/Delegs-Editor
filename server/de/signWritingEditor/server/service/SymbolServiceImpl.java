package de.signWritingEditor.server.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.client.service.SymbolService;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedBodySymbol;
import de.signWritingEditor.shared.model.material.PositionedDynamicsSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedHandSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadSymbol;
import de.signWritingEditor.shared.model.material.PositionedLocationSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.PositionedPunctuationSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.service.SymbolCategoryAnalyzer;

public class SymbolServiceImpl implements SymbolService {

	private SymbolFactory symbolFactory;
	private Map<BaseSymbol, Set<Symbol>> validVariationsForBaseSymbol;

	public SymbolServiceImpl(SymbolFactory symbolFactory) {
		assert symbolFactory != null : "Precondition failed: symbolFactory != null";

		this.symbolFactory = symbolFactory;
		validVariationsForBaseSymbol = new HashMap<BaseSymbol, Set<Symbol>>();
	}

	public Set<Symbol> getValidVariationsFor(BaseSymbol baseSymbol) {
		assert baseSymbol != null : "Precondition failed: baseSymbol != null";

		Set<Symbol> result = null;

		if (validVariationsForBaseSymbol.containsKey(baseSymbol)) {
			result = validVariationsForBaseSymbol.get(baseSymbol);
		} else {
			result = symbolFactory.getAllRotationsAndFillsFor(baseSymbol);
			validVariationsForBaseSymbol.put(baseSymbol, result);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public PositionedSymbol createPositionedSymbol(Symbol symbol, int x, int y, int z) {
		assert symbol != null : "Precondition failed: symbol != null";

		PositionedSymbol result = null;

		if (SymbolCategoryAnalyzer.isHandSymbol(symbol)) {
			result = new PositionedHandSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isMovementSymbol(symbol)) {
			result = new PositionedMovementSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isDynamicsSymbol(symbol)) {
			result = new PositionedDynamicsSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isBodySymbol(symbol)) {
			result = new PositionedBodySymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isHeadSymbol(symbol)) {
			result = new PositionedHeadSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isPunctuationSymbol(symbol)) {
			result = new PositionedPunctuationSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (symbol.getCategory() == SymbolCategory.LOCATION.getCategoryNumber()) {
			result = new PositionedLocationSymbol(symbol, x, y, z, getValidVariationsFor(symbol.getBaseSymbol()));
		} else if (SymbolCategoryAnalyzer.isFingerAlphabetSymbol(symbol)) {
			result = new PositionedFingerAlphabetSymbol(FingerAlphabet.getFingerAlphabetSymbolFor(symbol), x, y, z);
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
