package de.signWritingEditor.infrastructure;

import de.signWritingEditor.shared.layout.FontMetricInterface;

public class FontMetricMock implements FontMetricInterface {

	@Override
	public float getActualFontSize_PT(int fontSize) {
		return 0;
	}

}