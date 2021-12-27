package de.signWritingEditor.shared.layout;

import java.util.ArrayList;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class TagTokenBox extends AbstractIdBox implements TokenBox {
	private static final int MARGIN_RIGHT = 5;
	private static final float TAG_TOKEN_BOX_PADDING = 6;
	private static final int TAG_TOKEN_BORDER = 4;
	protected static final int MIN_TAG_TOKEN_BOX_WIDTH = 100;

	private TagToken tagToken;
	private FontSizeService fontSizeService;

	public TagTokenBox(TagToken tagToken, FontSizeService fontSizeService) {
		super(tagToken.getId());
		this.tagToken = tagToken;
		this.fontSizeService = fontSizeService;
	}

	public TagTokenBox(Id id) {
		super(id);
	}

	public FontMetricSpecifier getFontMetricSpecifier() {
		return tagToken.getStyle().getFontMetricSpecifier();
	}

	public int getFontDescent_PX() {
		return fontSizeService.getFontDescent_PX(getFontMetricSpecifier());
	}

	public ArrayList<String> getItemList() {
		return tagToken.getItemList();
	}

	public ArrayList<String> getSelectedItemList() {
		return tagToken.getSelectedItemList();
	}

	public String getDescription() {
		return tagToken.getDescription();
	}

	@Override
	public float getWidth_PX() {
		return getWidthWithoutMargin_PX() + MARGIN_RIGHT;
	}

	public float getWidthWithoutMargin_PX() {
		return tagToken.getWidth();
	}

	public void selectWord(String selectedWord) {
		tagToken.selectWord(selectedWord);
	}

	public void deselectWord(String word) {
		tagToken.deselectWord(word);
	}

	@Override
	public int getHeight_PX() {
		int height = Math.max(fontSizeService.getHeight_PX(tagToken.getStyle().getFontMetricSpecifier()),
				tagToken.getHeight());
		return height;
	}

	@Override
	public Color getBackgroundColor() {
		return tagToken.getBackgroundColor();
	}

	@Override
	public boolean isLockedLayout() {
		return tagToken.isLayoutLocked();
	}

	@Override
	public boolean isContentLocked() {
		return tagToken.isContentLocked();
	}

	public float getPaddingLeft_PX() {
		return TAG_TOKEN_BOX_PADDING;
	}

	public String getSelectedItemString() {
		return tagToken.getSelectedItemString();
	}

	public int getTagTokenBorder() {
		return TAG_TOKEN_BORDER;
	}

	public float getPaddingRight_PX() {
		return TAG_TOKEN_BOX_PADDING;
	}

	public int getDescriptionWidth_PX() {
		int descriptionStringWidth = Math
				.round(1.1f * (fontSizeService.getStringWidth(getDescription(), getFontMetricSpecifier())));
		descriptionStringWidth += TAG_TOKEN_BOX_PADDING;
		return Math.max(descriptionStringWidth, tagToken.getDescriptionWidth_PX());
	}

	public int getInputWidth_PX() {
		return Math.max(MIN_TAG_TOKEN_BOX_WIDTH, tagToken.getInputWidth_PX());
	}

	public void setFixedInputWidthWithoutMargin(int width) {
		int newWidth = Math.max(width, MIN_TAG_TOKEN_BOX_WIDTH);
		assert newWidth >= 0 : "Postcondition failed: newWidth >= 0";
		tagToken.setInputWidth(newWidth);
	}

	public void setFixedDescriptionWidthWithoutMargin(int width) {
		int descriptionStringWidth = (int) fontSizeService.getStringWidth(getDescription(), getFontMetricSpecifier());
		int newWidth = Math.max(width, descriptionStringWidth);

		assert newWidth >= 0 : "Postcondition failed: newWidth >= 0";
		tagToken.setDescriptionWidth(newWidth);
	}

	public void setFontWeight(FontWeight fontWeight) {
		tagToken.getTokenStyle().setFontWeight(fontWeight);
	}

	public Color getColor() {
		return tagToken.getFontColor();
	}

}
