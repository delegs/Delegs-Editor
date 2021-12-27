package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public interface SymbolServiceAsync {
	void createPositionedSymbol(Symbol symbol, int x, int y, int z, AsyncCallback<PositionedSymbol> callback);
}
