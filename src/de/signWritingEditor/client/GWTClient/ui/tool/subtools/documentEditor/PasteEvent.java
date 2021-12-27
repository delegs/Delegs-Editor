package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.event.shared.GwtEvent;

public class PasteEvent extends GwtEvent<PasteHandler> {

	public static final Type<PasteHandler> TYPE = new Type<PasteHandler>();
	private String pastedText;
	private int positionInToken;

	@Override
	public Type<PasteHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<PasteHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PasteHandler handler) {
		handler.onPaste(this);
	}

	public void setPastedText(String pastedText) {
		this.pastedText = pastedText;
	}

	public String getPastedText() {
		return pastedText;
	}

	public void setPositionInToken(int positionInToken) {
		this.positionInToken = positionInToken;
	}

	public int getPositionInToken() {
		return positionInToken;
	}

}
