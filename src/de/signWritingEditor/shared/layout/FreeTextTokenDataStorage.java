package de.signWritingEditor.shared.layout;

import java.util.List;

public class FreeTextTokenDataStorage {

	private List<String> lines;
	private float maxTextWidth;
	private int tokenBoxHeight;

	public FreeTextTokenDataStorage(List<String> lines, float maxTextWidth, int tokenBoxHeight) {
		assert lines != null : "Precondition failed: lines != null";

		this.lines = lines;
		this.maxTextWidth = maxTextWidth;
		this.tokenBoxHeight = tokenBoxHeight;
	}

	public List<String> getLines() {
		return lines;
	}

	public float getMaxTextWidth() {
		return maxTextWidth;
	}

	public int getTokenBoxHeight() {
		return tokenBoxHeight;
	}

}
