package de.signWritingEditor.shared.model.domainValue;

public enum FontSize {
	SIZE_8(8), SIZE_9(9), SIZE_10(10), SIZE_11(11), SIZE_12(12), SIZE_13(13), SIZE_14(14), SIZE_16(16), SIZE_18(
			18), SIZE_20(20), SIZE_22(22), SIZE_24(24), SIZE_26(26), SIZE_28(28);

	private int size;

	public int getSize() {
		return size;
	}

	private FontSize(int size) {
		this.size = size;
	}

	@Deprecated
	public static FontSize valueOf(int size) {
		for (FontSize fontSize : values()) {
			if (fontSize.getSize() == size) {
				return fontSize;
			}
		}
		return null;
	}

}
