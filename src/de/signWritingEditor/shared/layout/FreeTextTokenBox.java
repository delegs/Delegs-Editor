package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class FreeTextTokenBox extends AbstractIdBox implements TokenBox {

	protected static final int MIN_FREE_TEXT_BOX_WIDTH = 50;
	public static final int FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX = 6;
	public static final int SLIDER_WIDTH = 15;
	private static final int FREE_TEXT_TOKEN_BOX_PADDING_RIGHT_PX = 6;
	private static final int FREE_TEXT_TOKEN_BOX_PADDING_LEFT_PX = 6;

	private List<String> lines;

	private int minWidth;
	private int maxWidth;

	private int height;
	private int maxHeight;

	private float textWidth;
	private int paragraphWidth;

	private FreeTextToken freeTextToken;

	private FontSizeService fontSizeService;

	public FreeTextTokenBox(FreeTextToken freeTextToken, boolean visible, int minWidth, int maxLineWidth, int maxHeight,
			FontSizeService fontSizeService) {
		super(freeTextToken.getId());
		assert freeTextToken != null : "Precondition failed: freeText != null";
		assert minWidth >= 0 : "Precondition failed: minWidth >= 0";
		assert maxLineWidth >= 0 : "Precondition failed: maxLineWidth >= 0";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";
		assert maxHeight > 0 : "Precondition failed: maxHeight > 0";

		this.fontSizeService = fontSizeService;
		this.freeTextToken = freeTextToken;
		this.paragraphWidth = maxLineWidth;
		this.maxWidth = maxLineWidth - SLIDER_WIDTH - getMarginRight_PX();
		if (this.maxWidth < 0) {
			this.maxWidth = 0;
		}
		this.minWidth = freeTextToken.hasFixedWidth() ? freeTextToken.getWidth() : minWidth;
		if (freeTextToken.isFreeTextLine()) {
			this.minWidth = maxWidth;
		} else {
			this.minWidth = this.minWidth < maxWidth ? this.minWidth : maxWidth;
		}
		this.textWidth = 0;
		this.height = -1;
		this.maxHeight = maxHeight;

		assert maxWidth >= this.minWidth : "postcondition failed: maxWidth >= minWidth";
		if (freeTextToken.hasFixedWidth()) {
			setFixedWidthWithoutMargin(freeTextToken.getWidth() + SLIDER_WIDTH);
		}
	}

	public int getParagraphWidth() {
		return paragraphWidth;
	}

	public void setText(String freeText) {
		assert freeText != null : "Precondition failed: freeText != null";

		this.freeTextToken.setText(freeText);
	}

	public List<String> getFreeTextLines() {
		assert lines != null && !lines.isEmpty() : "Precondition failed: lines != null && !lines.isEmpty()";
		return Collections.unmodifiableList(lines);
	}

	public String getText() {
		return freeTextToken.getText();
	}

	@Override
	public float getWidth_PX() {
		float result = getTokenWidth();
		assert result >= minWidth && result <= maxWidth : "Postcondition failed minWidth <= width <= maxWidth";
		result += getMarginRight_PX() + SLIDER_WIDTH;
		return result;
	}

	public float getTokenWidth() {
		float result = textWidth + getPaddingLeft_PX() + getPaddingRight_PX();
		if (result < minWidth) {
			result = minWidth;
		}
		result = result < maxWidth ? result : maxWidth;
		return result;
	}

	public void splitFreeTextToLines() {
		FreeTextTokenDataStorage dataStorage = splitFreeTextToLines(
				maxWidth - getPaddingLeft_PX() - getPaddingRight_PX());
		setTextWidth(dataStorage.getMaxTextWidth());
		setLines(dataStorage.getLines());
		setHeight(dataStorage.getTokenBoxHeight());
	}

	private FreeTextTokenDataStorage splitFreeTextToLines(int maxLineWidth) {
		assert freeTextToken.getText() != null : "Precondition failed: freeText != null";
		assert freeTextToken.getStyle()
				.getFontMetricSpecifier() != null : "Precondition failed: fontMetricSpecifier != null";

		String freeText = freeTextToken.getText();
		FontMetricSpecifier fontMetricSpecifier = freeTextToken.getStyle().getFontMetricSpecifier();

		List<String> result = new ArrayList<String>();
		float maxTextLineWidth = 0;
		if (freeText.isEmpty()) {
			result.add("");
		} else {
			int length = freeText.length();
			int lastLineBreakIndex = 0;

			float lineWidth = 0;

			String currentString = new String();

			for (int i = 0; i < length; i++) {
				char charAt = freeText.charAt(i);
				if (charAt == '\n') {
					result.add(freeText.substring(lastLineBreakIndex, i));
					lastLineBreakIndex = i + 1;
					maxTextLineWidth = maxTextLineWidth > lineWidth ? maxTextLineWidth : lineWidth;
					lineWidth = 0;

					currentString = "";
				} else {
					currentString += charAt;

					lineWidth = fontSizeService.getStringWidth(currentString, fontMetricSpecifier);

					maxTextLineWidth = Math.max(maxTextLineWidth, lineWidth);
					lineWidth = i + 1 == length ? (float) Math.ceil(lineWidth) : lineWidth;
					if (lineWidth >= maxLineWidth) {
						// Wrap only complete words if word is not longer than
						// one line:
						int lastSpaceIndex = freeText.lastIndexOf(" ", i);
						if (lastSpaceIndex > lastLineBreakIndex) {
							i = lastSpaceIndex + 1;
							maxTextLineWidth = fontSizeService.getStringWidth(freeText.substring(0, i),
									fontMetricSpecifier);
						}

						result.add(freeText.substring(lastLineBreakIndex, i));
						lastLineBreakIndex = i;
						lineWidth = 0;

						currentString = "";
					}
				}
			}

			result.add(freeText.substring(lastLineBreakIndex, length));
		}

		assert result != null : "Postcondition failed: result != null";
		assert !result.isEmpty() : "Postcondition failed: !result.isEmpty()";

		int height = fontSizeService.getHeight(result, fontMetricSpecifier);

		FreeTextTokenDataStorage freeTextTokenDataStorage = new FreeTextTokenDataStorage(result, maxTextLineWidth,
				height);
		return freeTextTokenDataStorage;
	}

	private void setHeight(int height) {
		if (height <= maxHeight) {
			this.height = height;
		} else {
			this.height = this.maxHeight;
		}
	}

	@Override
	public int getHeight_PX() {
		if (height < 0) {
			if (lines == null) {
				setHeight(fontSizeService.getHeight_PX(getFontMetricSpecifier()));
			} else {
				setHeight(fontSizeService.getHeight(getFreeTextLines(), getFontMetricSpecifier()));
			}
		}
		return height;
	}

	public int getFontAscent_PX() {
		return fontSizeService.getFontAscent_PX(getFontMetricSpecifier());
	}

	public int getFontDescent_PX() {
		return fontSizeService.getFontDescent_PX(getFontMetricSpecifier());
	}

	public boolean isVisible() {
		return freeTextToken.isVisible();
	}

	public void setVisibility(boolean isVisible) {
		freeTextToken.setVisible(isVisible);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (String line : lines) {
			result.append(line);
		}

		result.append(" (paragraphId: " + getId() + ")");

		return result.toString();
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public Color getColor() {
		return freeTextToken.getFontColor();
	}

	public FontMetricSpecifier getFontMetricSpecifier() {
		return freeTextToken.getStyle().getFontMetricSpecifier();
	}

	public final void setFixedWidthWithoutMargin(int width) {
		int newWidth = width <= paragraphWidth ? width : paragraphWidth;
		newWidth = newWidth >= MIN_FREE_TEXT_BOX_WIDTH ? newWidth : MIN_FREE_TEXT_BOX_WIDTH;
		boolean isLine = newWidth >= paragraphWidth;
		setIsLine(isLine);
		newWidth = newWidth - SLIDER_WIDTH;
		if (newWidth < 0) {
			newWidth = 0;
		}
		minWidth = newWidth;
		maxWidth = newWidth;
		if (!isLine) {
			freeTextToken.setFixedWidth(true, newWidth);
		}
	}

	public int getMinWidth() {
		return minWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setTextWidth(float textWidth) {
		assert textWidth >= 0 : "Precondition failed: textWidth >= 0";
		this.textWidth = textWidth;
	}

	public void setMaxWidth(int maxWidth) {
		assert maxWidth >= 0 : "Precondition failed: maxWidth >= 0";
		this.maxWidth = maxWidth;
	}

	public void setMinWidth(int minWidth) {
		assert minWidth >= 0 : "Precondition failed: minWidth >= 0";
		this.minWidth = minWidth;
	}

	private void setIsLine(boolean isLine) {
		freeTextToken.setIsFreeTextLine(isLine);
		if (isLine) {
			freeTextToken.setFixedWidth(false, -1);
		}
	}

	public boolean isLine() {
		return freeTextToken.isFreeTextLine();
	}

	@Override
	public Color getBackgroundColor() {
		return freeTextToken.getBackgroundColor();
	}

	public Color getTextBackgroundColor() {
		return freeTextToken.getTextBackgroundColor();
	}

	public int getMarginRight_PX() {
		if (isLine()) {
			return 0;
		} else {
			return FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX;
		}
	}

	public int getPaddingRight_PX() {
		return FREE_TEXT_TOKEN_BOX_PADDING_RIGHT_PX;
	}

	public int getPaddingLeft_PX() {
		return FREE_TEXT_TOKEN_BOX_PADDING_LEFT_PX;
	}

	public int getSliderWidth() {
		return SLIDER_WIDTH;
	}

	public void setParagraphWidth(int width) {
		this.paragraphWidth = width;
		if (!freeTextToken.hasFixedWidth()) {
			maxWidth = paragraphWidth - SLIDER_WIDTH - getMarginRight_PX();
			if (maxWidth < 0) {
				maxWidth = 0;
			}
		}
		if (isLine()) {
			minWidth = paragraphWidth - SLIDER_WIDTH - getMarginRight_PX();
			if (minWidth < 0) {
				minWidth = 0;
			}
		}
	}

	@Override
	public boolean isLockedLayout() {
		return freeTextToken.isLayoutLocked();
	}

	@Override
	public boolean isContentLocked() {
		return freeTextToken.isContentLocked();
	}
}
