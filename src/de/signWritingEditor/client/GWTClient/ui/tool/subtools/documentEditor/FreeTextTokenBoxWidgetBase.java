package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

abstract public class FreeTextTokenBoxWidgetBase extends AbstractTextbasedTokenBoxWidget {

	protected static final int RESIZE_BUTTON_HEIGTH = 19;
	protected static final int FONT_SIZE_ESTIMATION_MARGIN = 4;

	protected FreeTextTokenBox freeTextTokenBox;

	protected Image resizeButtonImage;

	protected int paragraphWidth;
	protected volatile ExtendedRichTextArea textArea;
	protected SimplePanel sliderPanel;

	protected SimplePanel fullScreenWidget;
	protected FlowPanel textAreaPanel;

	protected volatile AbsolutePanel contentPanel;
	private FontSizeService fontSizeService;

	public FreeTextTokenBoxWidgetBase(final FreeTextTokenBox freeTextBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		assert freeTextBox != null : "Precondition failed: freeTextBox != null";
		assert eventTranslator != null : "Precondition failed: eventTranslator != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.fontSizeService = fontSizeService;
		this.freeTextTokenBox = freeTextBox;
		paragraphWidth = freeTextBox.getParagraphWidth();

		fullScreenWidget = new SimplePanel();
		fullScreenWidget.addStyleName("fullScreenResizeCursorPanel");

		textArea = new ExtendedRichTextArea(eventTranslator, fontSizeService);
		textArea.setReadOnly(freeTextBox.isContentLocked());
		if (freeTextBox.isContentLocked()) {
			textArea.addStyleName("textAreaHover");
		}

		sliderPanel = new SimplePanel();
		resizeButtonImage = new Image(RESOURCE.getResizeButton());
		resizeButtonImage.getElement().getStyle().setVerticalAlign(VerticalAlign.BASELINE);

		sliderPanel.addStyleName("slider");
		sliderPanel.add(resizeButtonImage);

		contentPanel = new AbsolutePanel();
		contentPanel.addStyleName("freeTextTokenBoxWidget");
		textAreaPanel = new FlowPanel();
		textAreaPanel.addStyleName("textAreaPanel");

		if (!freeTextBox.isLockedLayout()) {
			textAreaPanel.add(sliderPanel);
		}
	}

	@Override
	public int getCursorLeft() {
		return this.textArea.getCursorLeft(freeTextTokenBox.getFontMetricSpecifier());
	}

	@Override
	public void setCursorPositionAndFocus(int cursorPosition) {
		assert cursorPosition >= 0 : "Precondition failed: cursorPosition >= 0";
		assert cursorPosition <= getText().length() : "Precondition failed: cursorPosition <= getText().length()";

		textArea.setCursorPos(cursorPosition);
		textArea.setFocus(true);
	}

	@Override
	public void focus() {
		textArea.setFocus(true);
	}

	@Override
	public String getText() {
		return textArea.getText();
	}

	@Override
	public Id getId() {
		return freeTextTokenBox.getId();
	}

	@Override
	public int getCursorPosition() {
		return this.textArea.getCursorPosition();
	}

	@Override
	public int getCursorPositionAt(int left) {
		return this.textArea.getCursorPositionAt(left, freeTextTokenBox.getFontMetricSpecifier());
	}

	@Override
	public boolean isValidCursorPosition(int cursorPosition) {
		return this.textArea.isValidPosition(cursorPosition);
	}

	@Override
	public void toggleSelection() {
		this.textArea.setSelection(!this.textArea.isSelected());
	}

	@Override
	public boolean isWholeTextSelected() {
		return textArea.getSelectionLength() == textArea.getTextLength();
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert tokenBox instanceof FreeTextTokenBox : "Precondition failed: tokenBox instanceof FreeTextTokenBox";

		this.freeTextTokenBox = (FreeTextTokenBox) tokenBox;
		this.paragraphWidth = freeTextTokenBox.getParagraphWidth();

		contentPanel.getElement().getStyle().setMarginRight(freeTextTokenBox.getMarginRight_PX(), Unit.PX);
		// Only update if text has changed to avoid unnecessary scrolling in ui

		String newText = freeTextTokenBox.getText();
		if (!newText.equals(textArea.getText())) {
			int tempCursorPos = textArea.getCursorPos();
			setCursorPositionAndFocus(tempCursorPos);
			textArea.setText(newText);
		}
		textArea.setTextColor(freeTextTokenBox.getColor());
		textArea.setTextFontSize(
				fontSizeService.getActualFontSize(freeTextTokenBox.getFontMetricSpecifier().getFontSize()));
		textArea.setTextFontStyle(freeTextTokenBox.getFontMetricSpecifier().getFontStyle());
		textArea.setTextFontWeight(freeTextTokenBox.getFontMetricSpecifier().getFontWeight());
		updateHeight(freeTextTokenBox);

		textArea.setFont(freeTextTokenBox.getFontMetricSpecifier().getFont());

		setTextAreaVisible(freeTextTokenBox.isVisible());
		updateWidth();
		setTextBoxBackgroundColor(freeTextTokenBox.getTextBackgroundColor());
	}

	protected void updateHeight(FreeTextTokenBox freeTextTokenBox) {
		freeTextTokenBox.splitFreeTextToLines();
		int height = freeTextTokenBox.getHeight_PX();
		int lines = freeTextTokenBox.getFreeTextLines().size();

		int lineHeight = freeTextTokenBox.getFontMetricSpecifier().getFontSize().getSize();

		if (!(lineHeight * lines > height)) {
			textArea.getElement().getStyle().setLineHeight(((double) height / (lines)), Unit.PX);
		}

		textArea.setHeight(height + "px");
		textAreaPanel.setHeight(height + "px");
		sliderPanel.setHeight(height + "px");
		contentPanel.setHeight(height + "px");
		int marginTop = height - RESIZE_BUTTON_HEIGTH <= 0 ? 0 : height - RESIZE_BUTTON_HEIGTH;
		resizeButtonImage.getElement().getStyle().setMarginTop(marginTop, Unit.PX);
	}

	protected void updateWidth() {
		freeTextTokenBox.splitFreeTextToLines();
		float newWidth = freeTextTokenBox.getWidth_PX() - freeTextTokenBox.getMarginRight_PX();
		String newCompleteWidth = fontSizeService.getCeilPixelSize(newWidth) + "px";
		contentPanel.setWidth(newCompleteWidth);
		textAreaPanel.setWidth(newCompleteWidth);
		int tokenWidth = fontSizeService.getCeilPixelSize(freeTextTokenBox.getTokenWidth());
		textArea.setWidth(tokenWidth + "px");
	}

	public void setTextAreaVisible(boolean visible) {
		if (visible) {
			textArea.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			sliderPanel.getElement().getStyle().setVisibility(Visibility.VISIBLE);
		} else {
			textArea.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			sliderPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
	}

	@Override
	public void setBackgroundColor(Color color) {
	}

	@Override
	public void setTextBoxBackgroundColor(Color color) {
		if (!freeTextTokenBox.isContentLocked()) {
			textArea.setTextBackground(color);
			sliderPanel.getElement().getStyle().setBackgroundColor(color.getCssValue());
		} else {
			textArea.setTextBackground(Color.WHITE);
		}
	}

	@Override
	public TokenBox getTokenBox() {
		return freeTextTokenBox;
	}

	public boolean isFreeTextLine() {
		return freeTextTokenBox.isLine();
	}
}
