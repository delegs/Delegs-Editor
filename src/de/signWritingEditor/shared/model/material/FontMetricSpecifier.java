package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;

public class FontMetricSpecifier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font;
	private FontStyle fontStyle;
	private FontSize fontSize;
	private FontWeight fontWeight;

	public FontMetricSpecifier(Font font, FontStyle fontStyle, FontSize fontSize, FontWeight fontWeight) {
		this.fontStyle = fontStyle;
		this.fontSize = fontSize;
		this.fontWeight = fontWeight;
		this.font = font;
	}

	// Only for serialization
	@Deprecated
	public FontMetricSpecifier() {

	}

	public final Font getFont() {
		return font;
	}

	public final FontStyle getFontStyle() {
		return fontStyle;
	}

	public final FontSize getFontSize() {
		return fontSize;
	}

	public final FontWeight getFontWeight() {
		return fontWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((font == null) ? 0 : font.hashCode());
		result = prime * result + ((fontStyle == null) ? 0 : fontStyle.hashCode());
		result = prime * result + ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((fontWeight == null) ? 0 : fontWeight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		FontMetricSpecifier other = (FontMetricSpecifier) obj;
		if (font != other.font)
			return false;
		if (fontSize != other.fontSize)
			return false;
		if (fontStyle != other.fontStyle)
			return false;
		if (fontWeight != other.fontWeight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FontMetricId [font=" + font + ", fontStyle=" + fontStyle + ", fontSize=" + fontSize + ", fontWeight="
				+ fontWeight + "]";
	}

	public String getFontAsKey() {
		String weightStyle = fontWeight.getWeight() + fontStyle.getStyle();

		if (weightStyle.isEmpty()) {
			return font.toString();
		}

		return font.toString() + "-" + weightStyle;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}

	public void setFontWeight(FontWeight fontWeight) {
		this.fontWeight = fontWeight;
	}

}
