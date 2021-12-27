package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;

public class TextbasedTokenStyleFactory {

	public static final FontSize DEFAULT_FONT_SIZE = FontSizeService.STANDARD_FONT_SIZE;
	public static final FontStyle DEFAULT_FONT_STYLE = FontStyle.NORMAL;
	public static final FontWeight DEFAULT_FONT_WEIGHT = FontWeight.NORMAL;
	public static final Font DEFAULT_FONT = Font.HELVETICA;
	public static final Color DEFAULT_TEXT_BACKGROUND_COLOR = Color.GREY;
	public static final Color DEFAULT_FONT_COLOR = Color.BLACK;

	public ReadOnlyTextbasedTokenStyle createDefaultTextbasedTokenStyle() {
		return new TextbasedTokenStyle(DEFAULT_FONT_SIZE, Color.BLACK, Color.GREY, DEFAULT_FONT_STYLE,
				DEFAULT_FONT_WEIGHT, DEFAULT_FONT);
	}

	public ReadOnlyTextbasedTokenStyle createTextbasedTokenStyleFromStyle(ReadOnlyTextbasedTokenStyle style) {
		return ((TextbasedTokenStyle) style).clone();
	}

	public ReadOnlyTextbasedTokenStyle createTextbasedTokenStyle(FontSize fontSize, Color fontColor,
			Color textBackgroundColor, FontStyle fontStyle, FontWeight fontWeight, Font font) {
		return new TextbasedTokenStyle(fontSize, fontColor, textBackgroundColor, fontStyle, fontWeight, font);
	}
}
