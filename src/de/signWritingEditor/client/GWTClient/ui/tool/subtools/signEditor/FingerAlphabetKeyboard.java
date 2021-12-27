package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.domainValue.FingerAlphabet;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;

public class FingerAlphabetKeyboard extends SymbolKeyboard {

	private SymbolImageUrlService symbolImageUrlService;

	public FingerAlphabetKeyboard(SymbolImageUrlService symbolImageUrlService) {
		super(symbolImageUrlService, true);
		this.symbolImageUrlService = symbolImageUrlService;

		this.addStyleName("fingeralphabetKeyboard");
		this.addStyleDependentName("fingeralphabetSymbols");
	}

	public void addFingerAlphabetSymbol(FingerAlphabet fingerAlphabetSymbol, char fingerAlphabetChar,
			ClickHandler clickHandler) {
		assert fingerAlphabetSymbol != null : "Precondition failed: fingerAlphabetSymbol != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol = new PositionedFingerAlphabetSymbol(
				fingerAlphabetSymbol, 0, 0, 1);
		Image symbolImage = new Image(symbolImageUrlService.getSymbolImageUrl(positionedFingerAlphabetSymbol, 1.0));

		this.addSymbol(symbolImage, Character.toString(fingerAlphabetChar), clickHandler);

	}

	public interface FingerAlphabetKeyboardListener {
		void onAddFingerAlphabetSymbols(PositionedFingerAlphabetSymbol symbol);
	}
}
