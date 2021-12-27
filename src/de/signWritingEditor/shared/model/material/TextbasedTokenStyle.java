package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;

public class TextbasedTokenStyle implements ReadOnlyTextbasedTokenStyle, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FontMetricSpecifier fontMetricSpecifier;
	private Color fontColor;
	private Color textBackgroundColor;

	/**
	 * Only for serializatuion
	 */
	@Deprecated
	protected TextbasedTokenStyle() {
	}

	public TextbasedTokenStyle(FontSize fontSize, Color fontColor, Color textBackgroundColor, FontStyle fontStyle,
			FontWeight fontWeight, Font font) {
		assert fontSize != null : "Precondition failed: fontSize != null";
		assert fontColor != null : "Precondition failed: fontColor != null";
		assert fontStyle != null : "Precondition failed: fontStyle != null";
		assert fontWeight != null : "Precondition failed: fontWeight != null";
		assert font != null : "Precondition failed: font != null";
		assert textBackgroundColor != null : "Precondition failed: textBackgroundColor != null";

		fontMetricSpecifier = new FontMetricSpecifier(font, fontStyle, fontSize, fontWeight);
		this.fontColor = fontColor;
		this.textBackgroundColor = textBackgroundColor;
	}

	private TextbasedTokenStyle(ReadOnlyTextbasedTokenStyle style) {
		assert style != null : "Precondition failed: style != null";

		fontMetricSpecifier = new FontMetricSpecifier(style.getFont(), style.getFontStyle(), style.getFontSize(),
				style.getFontWeight());
		this.fontColor = style.getFontColor();
		this.textBackgroundColor = style.getTextBackgroundColor();
	}

	public void setFontSize(FontSize fontSize) {
		assert fontSize != null : "Precondition failed: fontSize != null";
		fontMetricSpecifier.setFontSize(fontSize);
	}

	public void setFontColor(Color fontColor) {
		assert fontColor != null : "Precondition failed: fontColor != null";
		this.fontColor = fontColor;
	}

	public void setTextBackgroundColor(Color color) {
		assert color != null : "Precondition failed: color != null";
		textBackgroundColor = color;
	}

	public void setFontStyle(FontStyle fontStyle) {
		assert fontStyle != null : "Precondition failed: fontStyle != null";
		fontMetricSpecifier.setFontStyle(fontStyle);
	}

	public void setFontWeight(FontWeight fontWeight) {
		assert fontWeight != null : "Precondition failed: fontWeight != null";
		fontMetricSpecifier.setFontWeight(fontWeight);
	}

	public void setFont(Font font) {
		assert font != null : "Precondition failed: font != null";
		fontMetricSpecifier.setFont(font);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.signWritingEditor.shared.model.material.ReadOnlyStyle#getFontSize()
	 */
	@Override
	public final FontSize getFontSize() {
		return fontMetricSpecifier.getFontSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.signWritingEditor.shared.model.material.ReadOnlyStyle#
	 * getFontMetricSpecifier()
	 */
	@Override
	public FontMetricSpecifier getFontMetricSpecifier() {
		return fontMetricSpecifier;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.signWritingEditor.shared.model.material.ReadOnlyStyle#getFontColor()
	 */
	@Override
	public final Color getFontColor() {
		return fontColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.signWritingEditor.shared.model.material.ReadOnlyStyle#
	 * getTextBackgroundColor()
	 */
	@Override
	public Color getTextBackgroundColor() {
		return textBackgroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.signWritingEditor.shared.model.material.ReadOnlyStyle#getFontStyle()
	 */
	@Override
	public final FontStyle getFontStyle() {
		return fontMetricSpecifier.getFontStyle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.signWritingEditor.shared.model.material.ReadOnlyStyle#getFontWeight()
	 */
	@Override
	public final FontWeight getFontWeight() {
		return fontMetricSpecifier.getFontWeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.signWritingEditor.shared.model.material.ReadOnlyStyle#getFont()
	 */
	@Override
	public final Font getFont() {
		return fontMetricSpecifier.getFont();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((fontMetricSpecifier == null) ? 0 : fontMetricSpecifier.hashCode());
		result = prime * result + ((textBackgroundColor == null) ? 0 : textBackgroundColor.hashCode());
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
		TextbasedTokenStyle other = (TextbasedTokenStyle) obj;
		if (fontColor == null) {
			if (other.fontColor != null)
				return false;
		} else if (!fontColor.equals(other.fontColor))
			return false;
		if (fontMetricSpecifier == null) {
			if (other.fontMetricSpecifier != null)
				return false;
		} else if (!fontMetricSpecifier.equals(other.fontMetricSpecifier))
			return false;
		if (textBackgroundColor == null) {
			if (other.textBackgroundColor != null)
				return false;
		} else if (!textBackgroundColor.equals(other.textBackgroundColor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextbasedTokenStyle [fontColor=" + fontColor + ", fontMetricSpecifier=" + fontMetricSpecifier
				+ ", textBackgroundColor=" + textBackgroundColor + "]";
	}

	protected TextbasedTokenStyle clone() {
		return new TextbasedTokenStyle(this);
	}

}
