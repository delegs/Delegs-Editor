package de.signWritingEditor.shared.model.domainValue;

public enum Font {
	HELVETICA("Helvetica"), COURIER("Courier"), TIMES_NEW_ROMAN("Times New Roman");

	private String name;

	private Font(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static Font fromString(String font) {
		assert font != null : "Precondition failed: font!=null";
		if (TIMES_NEW_ROMAN.name.equals(font)) {
			return TIMES_NEW_ROMAN;
		} else {
			return Font.valueOf(font.toUpperCase());
		}
	}
}