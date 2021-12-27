package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.user.client.ui.FlowPanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.TokenBox;

public abstract class SignItemTokenBoxWidgetBase extends AbstractTextbasedTokenBoxWidget {
	protected SignSelectorPanel signSelectorPanel;

	private SearchWordBoxBase searchWordBox;

	protected FlowPanel mainPanel;
	protected FlowPanel signItemPanel;

	private SignItemTokenBox tokenBox;
	private FontSizeService fontSizeService;

	public SignItemTokenBoxWidgetBase(SignItemTokenBox tokenBox, DocumentUiListener documentUiListener,
			SignDataEncoder signDataEncoder, ChangeAlternativeToolTip changeAlternativeToolTip,
			EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert documentUiListener != null : "Precondition failed: simpleTextBoxListener != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.tokenBox = tokenBox;
		this.fontSizeService = fontSizeService;

		mainPanel = new FlowPanel();
		signItemPanel = new FlowPanel();
		signItemPanel.getElement().getStyle().setFloat(Float.LEFT);

		initWidget(mainPanel);

		setStyleName("tokenBoxWidget");

		Id tokenId = tokenBox.getId();

		signSelectorPanel = GWT.create(SignSelectorPanel.class);
		signSelectorPanel.init(tokenId, signDataEncoder, changeAlternativeToolTip);
		signSelectorPanel.addSignSelectorPanelListener(documentUiListener);
		signItemPanel.addStyleName("basicTokenBorder");
		signItemPanel.add(signSelectorPanel);
		mainPanel.add(signItemPanel);
	}

	public void setSearchWordBoxBase(SearchWordBoxBase searchWordBoxBase) {
		this.searchWordBox = searchWordBoxBase;
		mainPanel.add(searchWordBox);
	}

	@Override
	public void setCursorPositionAndFocus(int cursorPosition) {
		assert cursorPosition >= 0 : "cursorPosition >= 0";
		assert cursorPosition <= getTextLength() : "cursorPosition <= getTextLength()";

		searchWordBox.setCursorPositionAndFocus(cursorPosition);
	}

	@Override
	public void focus() {
		searchWordBox.setFocus(true);
	}

	/**
	 * Returns the cursor position.
	 * 
	 * @return cursor position
	 */
	@Override
	public int getCursorPosition() {
		return searchWordBox.getCursorPosition();
	}

	@Override
	public int getCursorPositionAt(int left) {
		assert left >= 0 : "Precondition failed: left >= 0";

		return searchWordBox.getCursorPositionAt(left, tokenBox.getFontMetricSpecifier());
	}

	public boolean hasText() {
		return searchWordBox.hasText();
	}

	/**
	 * Selects the text from <code>leftIndex</code> to <code>rightIndex</code>.
	 * 
	 * @param leftIndex
	 * @param rightIndex
	 */
	@Override
	public void toggleSelection() {
		if (this.searchWordBox.isSelected()) {
			this.searchWordBox.setSelection(false);
			this.signSelectorPanel.setSelection(false);
		} else {
			this.searchWordBox.setSelection(true);
			this.signSelectorPanel.setSelection(true);
		}
	}

	public void hideOverlayPanel() {
		signSelectorPanel.hideToolTipPanel();
	}

	public int getCursorLeft() {
		return searchWordBox.getCursorLeft(tokenBox.getFontMetricSpecifier());
	}

	@Override
	public Id getId() {
		return tokenBox.getId();
	}

	@Override
	public boolean isWholeTextSelected() {
		return searchWordBox.isWholeTextSelected();
	}

	private boolean contentEquals(List<SignItem> oldSignItems, List<SignItem> newSignItems) {
		assert oldSignItems != null : "Precondition failed: oldSignItems != null";
		assert newSignItems != null : "Precondition failed: newSignItems != null";

		boolean result = oldSignItems.size() == newSignItems.size();

		if (result) {
			for (int i = 0, l = newSignItems.size(); result && i < l; i++) {
				SignItem oldSignItem = oldSignItems.get(i);
				SignItem newSignItem = newSignItems.get(i);

				result = oldSignItem.equals(newSignItem) && oldSignItem.getSignWidth() == newSignItem.getSignWidth()
						&& oldSignItem.getRevision() == newSignItem.getRevision();

				// If signs could be edited on the server, this method has to be
				// adjusted
				if (result && oldSignItem.hasLocalSign() && newSignItem.hasLocalSign()) {
					result = oldSignItem.getLocalSign().contentBasedEquals(newSignItem.getLocalSign());
				}
			}
		}

		return result;
	}

	@Override
	public boolean isValidCursorPosition(int cursorPosition) {
		return searchWordBox.isValidPosition(cursorPosition);
	}

	public String getText() {
		return searchWordBox.getText();
	}

	/**
	 * Sets the given text
	 * 
	 * @param text
	 * @require text != null
	 */
	public void setText(String text) {
		assert text != null : "text != null";

		searchWordBox.setText(text);
	}

	public int getTextLength() {
		return searchWordBox.getTextLength();
	}

	public void setTokenBox(TokenBox newTokenBox) {
		assert newTokenBox != null : "Precondition failed: tokenBox != null";
		assert newTokenBox instanceof SignItemTokenBox : "Precondition failed: tokenBox instanceof SignItemTokenBox";

		this.tokenBox = (SignItemTokenBox) newTokenBox;

		Id tokenId = this.tokenBox.getId();
		String word = this.tokenBox.getText();
		List<SignItem> signItems = this.tokenBox.getSignItems();
		int selectedSignIndex = this.tokenBox.getSelectedSignIndex();

		signSelectorPanel.setTokenId(tokenId);
		boolean signsChanged = !contentEquals(signSelectorPanel.getSignItems(), signItems);
		if (signsChanged) {
			signSelectorPanel.setSignItems(signItems);
		}
		if (signsChanged || signSelectorPanel.getSelectedSignIndex() != selectedSignIndex) {
			signSelectorPanel.selectSign(selectedSignIndex);
		}

		searchWordBox.setTokenId(tokenId);
		if (!searchWordBox.getText().equals(word)) {
			searchWordBox.setText(word);
		}
		if (this.tokenBox.isSearchWordVisible()) {
			searchWordBox.removeStyleName("hidden");
		} else {
			searchWordBox.addStyleName("hidden");
		}

		if (this.tokenBox.isSignVisible()) {
			signSelectorPanel.removeStyleName("hidden");
			this.signItemPanel.getElement().getStyle().setOpacity(1);
		} else {
			signSelectorPanel.addStyleName("hidden");
			this.signItemPanel.getElement().getStyle().setOpacity(0);
		}

		this.signItemPanel.getElement().getStyle().setBackgroundColor(tokenBox.getBackgroundColor().getCssValue());
		setTextBoxBackgroundColor(this.tokenBox.getTextBackgroundColor());

		float stringWidthFromWidget = fontSizeService.getStringWidth(tokenBox.getText(),
				tokenBox.getFontMetricSpecifier());
		tokenBox.setTextWidth(stringWidthFromWidget);

		updateWidget();
	}

	protected void updateFont() {
		searchWordBox.setTextColor(tokenBox.getColor());
		searchWordBox
				.setTextFontSize(fontSizeService.getActualFontSize(tokenBox.getFontMetricSpecifier().getFontSize()));
		searchWordBox.setTextFontStyle(tokenBox.getFontMetricSpecifier().getFontStyle());
		searchWordBox.setTextFontWeight(tokenBox.getFontMetricSpecifier().getFontWeight());
		searchWordBox.setFont(tokenBox.getFontMetricSpecifier().getFont());
	}

	protected void updateWidget() {
		updateFont();
		updateHeigthAndWidth();
	}

	private void updateHeigthAndWidth() {
		float tokenBoxWidth = tokenBox.getWidth_PX();
		int height = tokenBox.getHeight_PX();
		int tokenBoxCeilWidth = fontSizeService.getCeilPixelSize(tokenBoxWidth);
		int tokenBoxWidthWithoutMargin = fontSizeService.getCeilPixelSize(tokenBoxWidth - tokenBox.getMarginRight_PX());
		int textHeight = tokenBox.getTextHeight_PX();
		int tokenBoxHeight = height - textHeight - tokenBox.getMarginBetweenSignItemAndText_PX();

		searchWordBox.setHeight(textHeight + "px");
		searchWordBox.setMarginTop(tokenBox.getMarginBetweenSignItemAndText_PX());
		searchWordBox.setWidth(tokenBoxWidthWithoutMargin + "px");
		signItemPanel.setPixelSize(tokenBoxWidthWithoutMargin, tokenBoxHeight);
		setPixelSize(tokenBoxCeilWidth, height);
	}

	@Override
	public TokenBox getTokenBox() {
		return tokenBox;
	}

	@Override
	public void setTextBoxBackgroundColor(Color color) {
		searchWordBox.setTextBackground(color);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		// Is not resizeable see isResizeable
		throw new UnsupportedOperationException("SignItemTokenBoxWidgetBase is not resizeable");
	}

	@Override
	protected boolean isResizeable() {
		return false;
	}

}
