package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import de.signWritingEditor.shared.model.domainValue.Symbol;

public interface SymbolEditorListener {
	void onAddSymbol(Symbol symbol, int xOffset, int yOffset);
}
