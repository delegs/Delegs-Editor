package de.signWritingEditor.client.service;

import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public interface SymbolService {
	PositionedSymbol createPositionedSymbol(Symbol symbol, int x, int y, int z);
}
