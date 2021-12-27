package de.signWritingEditor.client.service;

import java.util.List;
import java.util.Map;

import de.signWritingEditor.shared.layout.FontMetricInterface;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public interface FontSizeService {

	public static final FontSize STANDARD_FONT_SIZE = FontSize.SIZE_13;

	int getHeight(List<String> lines, FontMetricSpecifier fontMetricSpecifier);

	int getHeight_PX(FontMetricSpecifier fontMetricSpecifier);

	int getFontAscent_PX(FontMetricSpecifier fontMetricSpecifier);

	int getFontDescent_PX(FontMetricSpecifier fontMetricSpecifier);

	@Deprecated
	void setFontMetrics(Map<FontMetricSpecifier, FontMetric> metrics);

	float getStringWidth(String text, FontMetricSpecifier fontMetricSpecifier);

	@Deprecated
	void setMetric(FontMetricInterface metric);

	@Deprecated
	FontMetricInterface getPdfFontMetric();

	float getActualFontSize(FontSize fontSize);

	int getPixelSize(float value);

	int getCeilPixelSize(double value);

	void addLoggingListener(LoggingListener listener);

	public interface LoggingListener {
		void logMissingCharacter(char c);
	}
}