package de.signWritingEditor.client.GWTClient.infrastructure;

import com.google.gwt.storage.client.Storage;

import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class LocalStorageClipboard implements Clipboard {

	private static final String CONTENT_KEY = "content_key";
	private static final String TEXT_KEY = "delegsEditorClipboardText";

	private Storage localStorage;
	private JsonConverter jsonConverter;

	public LocalStorageClipboard(TokenFactory tokenFactory, TextbasedTokenStyleFactory textbasedTokenStyleFactory,
			PositionedSymbolFactory positionedSymbolFactory) {
		super();
		this.localStorage = Storage.getLocalStorageIfSupported();
		assert localStorage != null : "Precondition failed: localStorage != null";
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";

		this.jsonConverter = new JsonConverter(tokenFactory, textbasedTokenStyleFactory, positionedSymbolFactory);
	}

	@Override
	public String getText() {
		assert !isEmpty() : "Precondition failed: !isEmpty()";

		return jsonConverter.reconvertString(localStorage.getItem(TEXT_KEY));
	}

	@Override
	public void clear() {
		localStorage.removeItem(TEXT_KEY);
	}

	@Override
	public boolean isClipboardText(String pastedText) {
		assert pastedText != null : "Precondition failed: pastedText != null";
		assert !isEmpty() : "Precondition failed: !isEmpty()";

		return pastedText.equals(getText());
	}

	@Override
	public boolean isEmpty() {
		return localStorage.getItem(TEXT_KEY) == null;
	}

	@Override
	public void setText(String text) {
		assert text != null : "Precondition failed: text != null";

		// Escape text via JSONString to escape page break for use in IE
		String escapedText = jsonConverter.convertString(text);
		localStorage.setItem(TEXT_KEY, escapedText);
	}

	@Override
	public void setContent(Object content) {
		String escapedText = jsonConverter.convert(content);
		localStorage.setItem(CONTENT_KEY, escapedText);
	}

	@Override
	public <T> T getContent() {
		return jsonConverter.reconvert(localStorage.getItem(CONTENT_KEY));
	}

}
