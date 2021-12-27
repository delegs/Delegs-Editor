package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.Map;

/**
 * <img src=
 * "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Typography_Line_Terms.svg/361px-Typography_Line_Terms.svg.png"
 * />
 */
public class FontMetric implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float fontHeight;
	private float maxFontAscent;
	private float maxFontDescent;

	private Map<Character, Float> characterWidths;

	// Only for serialization
	@Deprecated
	public FontMetric() {
	}

	public FontMetric(float fontHeight, float ascent, float descent, Map<Character, Float> characterWidths) {
		this.fontHeight = fontHeight;
		this.characterWidths = characterWidths;
		this.maxFontAscent = ascent;
		this.maxFontDescent = descent;
	}

	public void setFontHeight(float fontHeight) {
		this.fontHeight = fontHeight;
	}

	public void setMaxFontAscent(float maxFontAscent) {
		this.maxFontAscent = maxFontAscent;
	}

	public void setMaxFontDescent(float maxFontDescent) {
		this.maxFontDescent = maxFontDescent;
	}

	public void setCharacterWidths(Map<Character, Float> characterWidths) {
		this.characterWidths = characterWidths;
	}

	public float getFontHeight() {
		return fontHeight;
	}

	public float getMaxFontAscent() {
		return maxFontAscent;
	}

	public float getMaxFontDescent() {
		return maxFontDescent;
	}

	public Map<Character, Float> getCharacterWidths() {
		return characterWidths;
	}

	@Override
	public String toString() {
		return "FontMetric [fontHeight=" + fontHeight + ", maxFontAscent=" + maxFontAscent + ", maxFontDescent="
				+ maxFontDescent + ", characterWidths=" + characterWidths + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characterWidths == null) ? 0 : characterWidths.hashCode());
		result = prime * result + Float.floatToIntBits(fontHeight);
		result = prime * result + Float.floatToIntBits(maxFontAscent);
		result = prime * result + Float.floatToIntBits(maxFontDescent);
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
		FontMetric other = (FontMetric) obj;
		if (characterWidths == null) {
			if (other.characterWidths != null)
				return false;
		} else if (!characterWidths.equals(other.characterWidths))
			return false;
		if (Float.floatToIntBits(fontHeight) != Float.floatToIntBits(other.fontHeight))
			return false;
		if (Float.floatToIntBits(maxFontAscent) != Float.floatToIntBits(other.maxFontAscent))
			return false;
		if (Float.floatToIntBits(maxFontDescent) != Float.floatToIntBits(other.maxFontDescent))
			return false;
		return true;
	}

}
