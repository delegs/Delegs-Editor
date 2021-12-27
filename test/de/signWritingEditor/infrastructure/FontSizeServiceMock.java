package de.signWritingEditor.infrastructure;

import java.util.List;
import java.util.Map;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FontMetricInterface;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class FontSizeServiceMock implements FontSizeService {

	@Override
	public int getHeight(List<String> lines, FontMetricSpecifier fontMetricSpecifier) {
		return 0;
	}

	@Override
	public int getHeight_PX(FontMetricSpecifier fontMetricSpecifier) {
		return 0;
	}

	@Override
	public int getFontAscent_PX(FontMetricSpecifier fontMetricSpecifier) {
		return 0;
	}

	@Override
	public int getFontDescent_PX(FontMetricSpecifier fontMetricSpecifier) {
		return 0;
	}

	@Override
	public void setFontMetrics(Map<FontMetricSpecifier, FontMetric> metrics) {
	}

	@Override
	public float getStringWidth(String text, FontMetricSpecifier fontMetricSpecifier) {
		return 0;
	}

	@Override
	public void setMetric(FontMetricInterface metric) {
	}

	@Override
	public float getActualFontSize(FontSize fontSize) {
		return 0;
	}

	@Override
	public int getPixelSize(float value) {
		return 0;
	}

	@Override
	public int getCeilPixelSize(double value) {
		return 0;
	}

	@Override
	public void addLoggingListener(LoggingListener listener) {
	}

	@Override
	public FontMetricInterface getPdfFontMetric() {
		return null;
	}

}
