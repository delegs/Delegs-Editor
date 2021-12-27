package de.signWritingEditor.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public class SymbolServiceAsyncMock implements SymbolServiceAsync {

	@Override
	public void createPositionedSymbol(Symbol symbol, int x, int y, int z, AsyncCallback<PositionedSymbol> callback) {
	}

}
