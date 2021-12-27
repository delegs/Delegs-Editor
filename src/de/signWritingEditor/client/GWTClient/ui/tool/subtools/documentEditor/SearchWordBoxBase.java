package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Id;

public class SearchWordBoxBase extends ExtendedRichTextArea {
	protected Id tokenId;

	// Keep track of focus to set it again if box is detached from DOM
	protected boolean isFocused;

	protected boolean checkingText;

	public SearchWordBoxBase(Id tokenId, EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		super(eventTranslator, fontSizeService);
		assert tokenId != null : "Precondition failed: tokenId != null";
		this.tokenId = tokenId;
		this.isFocused = false;
		this.checkingText = false;
		this.getElement().setId(DocumentPanel.ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR);

		setText("");

		getElement().setAttribute("wrap", "off");
		setStyleName("searchWordBox");
	}

	public void setTokenId(Id tokenId) {
		this.tokenId = tokenId;
	}

	public boolean isVisible() {
		return getElement().getStyle().getVisibility().equals(Visibility.VISIBLE.getCssName());
	}

	public void setCursorPositionAndFocus(int newCursorPosition) {
		assert newCursorPosition >= 0 : "Precondition failed: newCursorPosition >= 0";
		assert newCursorPosition <= getTextLength() : "Precondition failed: newCursorPosition <= getTextLength()";

		setCursorPos(newCursorPosition);
		setFocus(true);
	}

	@Override
	public void setFocus(boolean focused) {
		super.setFocus(focused);
		isFocused = focused;
	}

	public boolean isWholeTextSelected() {
		return getSelectionLength() == getTextLength();
	}

	protected int getInvertedCursorPosition() {
		return getTextLength() - getCursorPosition();
	}

	public void setMarginTop(int marginTop) {
		getElement().getStyle().setMarginTop(marginTop, Unit.PX);
	}
}
