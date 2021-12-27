package de.signWritingEditor.shared.model.domainValue;

public enum FontStyle {
	NORMAL(""), ITALIC("Italic");

	private String style;

	private FontStyle(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}
}
