package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.DateFormTokenBox;
import de.signWritingEditor.shared.layout.FormTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

public class DateFormTokenBoxWidget extends AbstractTextbasedTokenBoxWidget {
	private DateFormTokenBox formTokenBox;
	private FlowPanel mainPanel;
	private Label descriptionLabel;
	private ExtendedRichTextBox inputTextBox;
	private FlowPanel inputPanel;
	private DocumentPanel.DocumentUiListener uiListener;
	private FontSizeService fontSizeService;
	private Label contentExplanationLabel;

	public DateFormTokenBoxWidget(DateFormTokenBox formTokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		this.formTokenBox = formTokenBox;
		this.fontSizeService = fontSizeService;

		mainPanel = new FlowPanel();
		descriptionLabel = new Label(formTokenBox.getDescription());
		inputTextBox = new ExtendedRichTextBox(eventTranslator, fontSizeService);
		inputPanel = new FlowPanel();

		inputTextBox.setText(formTokenBox.getInputContent());

		inputTextBox.addChangeHandler(event -> {
			formTokenBox.setInputContent(inputTextBox.getText());
		});

		inputTextBox.addKeyUpHandler(event -> {
			this.formTokenBox.setInputContent(inputTextBox.getText());
			this.formTokenBox.setValid(!hasInvalidContent());
		});

		descriptionLabel.setHeight(formTokenBox.getHeight_PX() + "px");
		descriptionLabel.setWidth(formTokenBox.getDescriptionWidth_PX() + "px");
		descriptionLabel.addStyleName("formDescriptionLabel");
		descriptionLabel.addStyleName("textAreaHover");

		inputTextBox.setWidth(formTokenBox.getInputWidth_PX() + "px");
		inputTextBox.setHeight(formTokenBox.getHeight_PX() + "px");
		inputTextBox.getElement().getStyle().setWhiteSpace(Style.WhiteSpace.NOWRAP);
		inputTextBox.getElement().getStyle().setPaddingLeft(formTokenBox.getPaddingLeft(), Style.Unit.PX);
		inputTextBox.addStyleName("freeTextLineTemplate");
		inputTextBox.addFocusHandler(event -> {
			uiListener.onSelectToken(getId(), false, false);
		});

		setTextBoxBackgroundColor(formTokenBox.getTextBackgroundColor());

		contentExplanationLabel = new Label(formTokenBox.getContentExplanation());
		contentExplanationLabel.addStyleName("contentExplanationLabel");

		inputPanel.add(inputTextBox);
		inputPanel.add(contentExplanationLabel);
		inputPanel.addStyleName("formTokenInput");

		mainPanel.add(descriptionLabel);
		mainPanel.add(inputPanel);
		mainPanel.addStyleName("formTokenWidget");

		initWidget(mainPanel);

		inputTextBox.getElement().setPropertyString("type", "date");
		setTokenBox(formTokenBox);
		this.formTokenBox.setValid(!hasInvalidContent());
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert tokenBox instanceof FormTokenBox : "Precondition failed: tokenBox instanceof FormTokenBox";

		this.formTokenBox = (DateFormTokenBox) tokenBox;
		String newText = formTokenBox.getInputContent();
		if (!newText.equals(inputTextBox.getText())) {
			int tempCursorPos = inputTextBox.getCursorPos();
			setCursorPositionAndFocus(tempCursorPos);
			inputTextBox.setText(newText);
		}

		descriptionLabel.getElement().getStyle().setProperty("fontFamily",
				formTokenBox.getFontMetricSpecifier().getFont().toString());
		descriptionLabel.getElement().getStyle().setProperty("fontStyle",
				formTokenBox.getFontMetricSpecifier().getFontStyle().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontWeight",
				formTokenBox.getFontMetricSpecifier().getFontWeight().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontSize",
				formTokenBox.getFontMetricSpecifier().getFontSize().getSize() + "px");
		descriptionLabel.getElement().getStyle().setColor(formTokenBox.getColor().getCssValue());

		inputTextBox.setFont(formTokenBox.getFontMetricSpecifier().getFont());
		inputTextBox.setTextFontStyle(formTokenBox.getFontMetricSpecifier().getFontStyle());
		inputTextBox.setTextFontWeight(formTokenBox.getFontMetricSpecifier().getFontWeight());
		inputTextBox.setTextFontSize(
				fontSizeService.getActualFontSize(formTokenBox.getFontMetricSpecifier().getFontSize()));
		inputTextBox.setTextColor(formTokenBox.getColor());

		setTextBoxBackgroundColor(formTokenBox.getTextBackgroundColor());
	}

	@Override
	public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
	}

	@Override
	public void setCursorPositionAndFocus(int cursorPosition) {
		inputTextBox.setFocus(true);
		inputTextBox.setCursorPos(0);
	}

	@Override
	public String getText() {
		return formTokenBox.getInputContent();
	}

	@Override
	public void setDragModeHandler(MouseDragListener listener) {
	}

	@Override
	public void setTextBoxBackgroundColor(Color color) {
		inputTextBox.setTextBackground(color);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
	}

	@Override
	protected boolean isResizeable() {
		return false;
	}

	@Override
	public Id getId() {
		return formTokenBox.getId();
	}

	@Override
	public void focus() {
		setCursorPositionAndFocus(0);
	}

	@Override
	public void toggleSelection() {

	}

	@Override
	public TokenBox getTokenBox() {
		return formTokenBox;
	}

	@Override
	public int getCursorLeft() {
		return 0;
	}

	@Override
	public int getCursorPosition() {
		return 0;
	}

	@Override
	public int getCursorPositionAt(int left) {
		return 0;
	}

	@Override
	public boolean isValidCursorPosition(int cursorPosition) {
		return false;
	}

	public void addDateTokenBoxWidgetListener(DocumentPanel.DocumentUiListener documentUiListener) {
		uiListener = documentUiListener;
	}

	public boolean hasInvalidContent() {
		return !getValidity(inputTextBox.getElement());
	}

	private native boolean getValidity(Element element) /*-{
		return element.validity.valid
	}-*/;
}
