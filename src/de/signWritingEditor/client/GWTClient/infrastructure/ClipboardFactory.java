package de.signWritingEditor.client.GWTClient.infrastructure;

import com.google.gwt.storage.client.Storage;

import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.StandardClipboard;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class ClipboardFactory {

	private boolean isLocalStorageSupported;
	private PositionedSymbolFactory positionedSymbolFactory;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	public ClipboardFactory(IdFactory idFactory, TokenFactory tokenFactory,
			TextbasedTokenStyleFactory textbasedTokenStyleFactory, PositionedSymbolFactory positionedSymbolFactory) {
		this.tokenFactory = tokenFactory;
		this.textbasedTokenStyleFactory = textbasedTokenStyleFactory;
		isLocalStorageSupported = Storage.isLocalStorageSupported();
		this.positionedSymbolFactory = positionedSymbolFactory;
	}

	public Clipboard getClipboard() {
		if (isLocalStorageSupported) {
			return new LocalStorageClipboard(tokenFactory, textbasedTokenStyleFactory, positionedSymbolFactory);
		} else {
			return new StandardClipboard();
		}
	}
}
