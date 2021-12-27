package de.signWritingEditor.shared.model.domainValue;

public enum FileItemColorLabel {
	NONE("colorLabelNone"), PINK("colorLabelPink"), RED("colorLabelRed"), ORANGE("colorLabelOrange"),
	YELLOW("colorLabelYellow"), GREEN("colorLabelGreen"), DARKGREEN("colorLabelDarkGreen"), BLUE("colorLabelBlue"),
	CYAN("colorLabelCyan"), VIOLET("colorLabelViolet");

	private String styleName;

	private FileItemColorLabel(String styleName) {
		assert styleName != null : "Precondition failed: styleName != null";

		this.styleName = styleName;
	}

	public String getStyleName() {
		assert styleName != null : "Postcondition failed: result != null";
		return styleName;
	}
}
