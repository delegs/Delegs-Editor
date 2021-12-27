package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;

import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontSizeCalculator {
	public static final FontSize STANDARD_FONT_SIZE = FontSize.SIZE_13;
	private static FontMetricInterface metric;
	private static Map<FontMetricSpecifier, FontMetric> fontMetrics;

	static {
		metric = null;
	}

	public static int getHeight(List<String> lines, FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";
		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getFontHeight() * lines.size());
	}

	public static int getHeight(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";
		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getFontHeight());
	}

	public static int getFontAscent(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";
		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getMaxFontAscent());
	}

	public static int getFontDescent(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";
		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getMaxFontDescent());
	}

	public static void setFontMetrics(Map<FontMetricSpecifier, FontMetric> metrics) {
		fontMetrics = metrics;
	}

	public static float getStringWidth(String text, FontMetricSpecifier fontMetricSpecifier) {

		float width = 0;
		int length = text.length();

		if (length > 0) {
			Map<Character, Float> charWidthMap = fontMetrics.get(fontMetricSpecifier).getCharacterWidths();

			for (int i = 0; i < length; i++) {
				char charAt = text.charAt(i);
				if (charWidthMap.containsKey(charAt)) {
					width += charWidthMap.get(charAt);
				}
			}
		}
		return width;
	}

	public static void setMetric(FontMetricInterface metric) {
		FontSizeCalculator.metric = metric;
	}

	public static FreeTextTokenDataStorage splitFreeTextToLines(String freeText,
			FontMetricSpecifier fontMetricSpecifier, int maxLineWidth) {
		assert freeText != null : "Precondition failed: freeText != null";
		assert fontMetricSpecifier != null : "Precondition failed: fontMetricSpecifier != null";

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

					lineWidth = FontSizeCalculator.getStringWidth(currentString, fontMetricSpecifier);

					maxTextLineWidth = Math.max(maxTextLineWidth, lineWidth);
					if (lineWidth > maxLineWidth) {
						// Wrap only complete words if word is not longer than
						// one line:
						int lastSpaceIndex = freeText.lastIndexOf(" ", i);
						if (lastSpaceIndex > lastLineBreakIndex) {
							i = lastSpaceIndex + 1;
							maxTextLineWidth = FontSizeCalculator.getStringWidth(freeText.substring(0, i),
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

		int height = getHeight(result, fontMetricSpecifier);

		FreeTextTokenDataStorage freeTextTokenDataStorage = new FreeTextTokenDataStorage(result, maxTextLineWidth,
				height);
		return freeTextTokenDataStorage;
	}

	public interface StringWidthCalculator {
		int getStringWidth(String text);

		void setTextFormat(String fontName, int fontSize, FontStyle fontStyle, FontWeight fontWeight);
	}

	public static float getActualFontSize(FontSize fontSize) {
		return metric.getActualFontSize_PT(fontSize.getSize());
	}

	public static int getPixelSize(float value) {
		return Math.round(value);
	}

	public static int getCeilPixelSize(double value) {
		return (int) Math.ceil(value);
	}
}