package de.signWritingEditor.shared.layout;

public class GWTFontMetric implements FontMetricInterface {

	public GWTFontMetric() {
	}

	@Override
	public float getActualFontSize_PT(int fontSize) {
		return fontSize * 0.75f;
	}

}
