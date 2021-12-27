package de.signWritingEditor.shared.layout;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class FormTokenBox extends AbstractIdBox implements TokenBox {

	protected static final int MIN_FORM_TOKEN_BOX_WIDTH = 100;

	protected FormToken formToken;
	private FontSizeService fontSizeService;
	private final static int FORM_TOKEN_BOX_PADDING_LEFT = 6;

	public FormTokenBox(FormToken formToken, FontSizeService fontSizeService) {
		super(formToken.getId());

		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.formToken = formToken;
		this.fontSizeService = fontSizeService;
	}

	public String getPattern() {
		return formToken.getPattern();
	}

	public String getDescription() {
		return formToken.getDescription();
	}

	public String getInputContent() {
		return formToken.getInputContent();
	}

	public void setInputContent(String content) {
		formToken.setInputContent(content);
	}

	public int getDescriptionWidth_PX() {
		int descriptionStringWidth = Math
				.round(1.1f * (fontSizeService.getStringWidth(getDescription(), getFontMetricSpecifier())));
		descriptionStringWidth += FORM_TOKEN_BOX_PADDING_LEFT;
		return Math.max(descriptionStringWidth, formToken.getDescriptionWidthPx());
	}

	public int getInputWidth_PX() {
		return Math.max(MIN_FORM_TOKEN_BOX_WIDTH, formToken.getInputWidthPx());
	}

	@Override
	public float getWidth_PX() {
		return formToken.getWidthPx();
	}

	@Override
	public int getHeight_PX() {
		return fontSizeService.getHeight_PX(formToken.getStyle().getFontMetricSpecifier());
	}

	@Override
	public Color getBackgroundColor() {
		return formToken.getBackgroundColor();
	}

	@Override
	public boolean isLockedLayout() {
		return true;
	}

	@Override
	public boolean isContentLocked() {
		return false;
	}

	public FontMetricSpecifier getFontMetricSpecifier() {
		return formToken.getStyle().getFontMetricSpecifier();
	}

	public int getPaddingLeft() {
		return FORM_TOKEN_BOX_PADDING_LEFT;
	}

	public int getFontAscent_PX() {
		return fontSizeService.getFontAscent_PX(getFontMetricSpecifier());
	}

	public int getFontDescent_PX() {
		return fontSizeService.getFontDescent_PX(getFontMetricSpecifier());
	}

	public void setFontWeight(FontWeight fontWeight) {
		formToken.getTokenStyle().setFontWeight(fontWeight);
	}

	public Color getColor() {
		return formToken.getFontColor();
	}

	public Color getTextBackgroundColor() {
		return formToken.getTextBackgroundColor();
	}

	public void setFixedInputWidthWithoutMargin(int width) {
		int newWidth = Math.max(width, MIN_FORM_TOKEN_BOX_WIDTH);
		assert newWidth >= 0 : "Postcondition failed: newWidth >= 0";
		formToken.setInputWidth(newWidth);
	}

	public void setFixedDescriptionWidthWithoutMargin(int width) {
		int descriptionStringWidth = (int) fontSizeService.getStringWidth(getDescription(), getFontMetricSpecifier());
		int newWidth = Math.max(width, descriptionStringWidth);

		assert newWidth >= 0 : "Postcondition failed: newWidth >= 0";
		formToken.setDescriptionWidth(newWidth);
	}

	public String getContentExplanation() {
		return formToken.getContentExplanation();
	}

	public boolean hasValidContent() {
		return formToken.hasValidContent();
	}

}
