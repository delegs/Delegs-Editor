package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyle;

public class TextbasedTokenStyleTool {

	private GWTDocumentLayouter documentLayouter;

	public TextbasedTokenStyleTool(GWTDocumentLayouter documentLayouter) {
		assert documentLayouter != null : "Precondition failed: documentLayouter != null";

		this.documentLayouter = documentLayouter;
	}

	protected void changeFontColorTo(Color fontColor, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setFontColor(fontColor);
		updateDocumentLayouter(textbasedToken, true);
	}

	protected void changeTextBackgroundColorTo(Color fontColor, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setTextBackgroundColor(fontColor);
		updateDocumentLayouter(textbasedToken, true);
	}

	protected void changeFontSizeTo(FontSize fontSize, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setFontSize(fontSize);
		updateDocumentLayouter(textbasedToken, false);
	}

	protected void changeFontStyleTo(FontStyle fontStyle, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setFontStyle(fontStyle);
		updateDocumentLayouter(textbasedToken, false);
	}

	protected void changeFontWeightTo(FontWeight fontWeight, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setFontWeight(fontWeight);
		updateDocumentLayouter(textbasedToken, false);
	}

	protected void changeFontTo(Font font, TextbasedToken textbasedToken) {
		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) textbasedToken.getStyle();
		textbasedTokenStyle.setFont(font);
		updateDocumentLayouter(textbasedToken, false);
	}

	private void updateDocumentLayouter(TextbasedToken textbasedToken, boolean colorChanged) {
		assert textbasedToken != null : "Precondition failed: textbasedToken != null";

		if (textbasedToken instanceof SignItemToken && !colorChanged) {
			documentLayouter.updateTokenBoxMargin(textbasedToken.getId());
		}
		documentLayouter.updateTokenBox(textbasedToken.getId());
	}

	protected void copyTextbasedTokenStyleFromTokenToToken(TextbasedToken fromToken, TextbasedToken toToken) {
		assert fromToken != null : "Precondition failed: fromToken != null";
		assert toToken != null : "Precondition failed: toToken != null";

		ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle = fromToken.getStyle();
		copyTextbasedStyleToToken(readOnlyTextbasedTokenStyle, toToken);
	}

	protected void copyTextbasedStyleToToken(ReadOnlyTextbasedTokenStyle readOnlyTextbasedTokenStyle,
			TextbasedToken toToken) {

		TextbasedTokenStyle textbasedTokenStyle = (TextbasedTokenStyle) toToken.getStyle();
		textbasedTokenStyle.setFont(readOnlyTextbasedTokenStyle.getFont());
		textbasedTokenStyle.setFontColor(readOnlyTextbasedTokenStyle.getFontColor());
		textbasedTokenStyle.setFontSize(readOnlyTextbasedTokenStyle.getFontSize());
		textbasedTokenStyle.setFontStyle(readOnlyTextbasedTokenStyle.getFontStyle());
		textbasedTokenStyle.setFontWeight(readOnlyTextbasedTokenStyle.getFontWeight());
		textbasedTokenStyle.setTextBackgroundColor(readOnlyTextbasedTokenStyle.getTextBackgroundColor());

		assert readOnlyTextbasedTokenStyle.equals(
				toToken.getStyle()) == true : "Postcondition failed: fromTokenStyle is not equal to toTokenStyle";
	}

}
