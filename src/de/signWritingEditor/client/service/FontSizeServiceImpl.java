package de.signWritingEditor.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.signWritingEditor.shared.layout.FontMetricInterface;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontSizeServiceImpl implements FontSizeService {
	public static final FontSize STANDARD_FONT_SIZE = FontSize.SIZE_13;
	// average character width for helvetica size 13
	private static final float DEFAULT_CHARACTER_WIDTH = 7f;
	private FontMetricInterface metric;
	private Map<FontMetricSpecifier, FontMetric> fontMetrics;
	private List<LoggingListener> listeners;

	public FontSizeServiceImpl() {
		metric = null;
		listeners = new ArrayList<LoggingListener>();
	}

	@Override
	public int getHeight(List<String> lines, FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";
		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getFontHeight() * lines.size());
	}

	@Override
	public int getHeight_PX(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";

		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getFontHeight());
	}

	@Override
	public int getFontAscent_PX(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";

		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getMaxFontAscent());
	}

	@Override
	public int getFontDescent_PX(FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";
		assert fontMetrics.containsKey(fontMetricSpecifier) : "Precondition failed fontMetrics.containsKey(fontId)";

		return getCeilPixelSize(fontMetrics.get(fontMetricSpecifier).getMaxFontDescent());
	}

	@Override
	public void setFontMetrics(Map<FontMetricSpecifier, FontMetric> metrics) {

		fontMetrics = metrics;
	}

	@Override
	public float getStringWidth(String text, FontMetricSpecifier fontMetricSpecifier) {
		assert fontMetrics != null : "Precondition failed: fontMetrics != null";

		float width = 0;
		int length = text.length();

		if (length > 0) {
			Map<Character, Float> charWidthMap = fontMetrics.get(fontMetricSpecifier).getCharacterWidths();

			for (int i = 0; i < length; i++) {
				char charAt = text.charAt(i);
				if (charWidthMap.containsKey(charAt)) {
					width += charWidthMap.get(charAt);
				} else {
					width += DEFAULT_CHARACTER_WIDTH;
					for (LoggingListener loggingListener : listeners) {
						loggingListener.logMissingCharacter(charAt);
					}
				}
			}

		}

		return width;
	}

	@Override
	public void setMetric(FontMetricInterface metric) {
		assert metric != null : "Precondition failed: metric != null";

		this.metric = metric;
	}

	@Override
	public float getActualFontSize(FontSize fontSize) {
		assert fontSize != null : "Precondition failed: fontSize != null";
		assert metric != null : "Precondition failed: metric != null";

		return metric.getActualFontSize_PT(fontSize.getSize());
	}

	@Override
	public int getPixelSize(float value) {
		return Math.round(value);
	}

	@Override
	public int getCeilPixelSize(double value) {
		return (int) Math.ceil(value);
	}

	@Override
	public void addLoggingListener(LoggingListener listener) {
		assert listener != null : "Precondition failed: listener != null";
		assert listeners != null : "Precondition failed: listeners != null";

		listeners.add(listener);
	}

	@Deprecated
	@Override
	public FontMetricInterface getPdfFontMetric() {
		return metric;
	}
}