package de.signWritingEditor.client.service;

import java.util.Map;

import com.google.gwt.touch.client.Point;

import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class SignEditorHistoryState implements HistoryState {

	private final SimpleSign savedPreviousSign;
	private final SimpleSign currentSign;
	private final Map<PositionedSymbol, Point> selectedSymbolsAndDifferenceMap;

	public SignEditorHistoryState(SimpleSign savedPreviousSign, SimpleSign currentSign,
			Map<PositionedSymbol, Point> selectedSymbolsAndDifferenceMap) {
		assert currentSign != null : "Precondition failed: currentSign != null";
		assert savedPreviousSign != null : "Precondition failed: savedPreviousSign != null";
		assert selectedSymbolsAndDifferenceMap != null : "Precondition failed: selectedSymbolsAndDifferenceMap != null";

		this.savedPreviousSign = savedPreviousSign;
		this.currentSign = currentSign;
		this.selectedSymbolsAndDifferenceMap = selectedSymbolsAndDifferenceMap;
	}

	public SimpleSign getSavedPreviousSign() {
		return savedPreviousSign;
	}

	public SimpleSign getCurrentSign() {
		return currentSign;
	}

	public Map<PositionedSymbol, Point> getSelectedSymbolsAndDifferenceMap() {
		return selectedSymbolsAndDifferenceMap;
	}

}
