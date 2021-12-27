package de.signWritingEditor.server.service.pdfService;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public class FreeTextTokenBoxTemplate extends TokenBoxTemplate {

	private float width_PT;
	private float height_PT;
	private FreeTextTokenBox freeTextBox;
	private float pointsPerPixel;
	private FontSizeService fontSizeService;

	public FreeTextTokenBoxTemplate(FreeTextTokenBox freeTextBox, float pointsPerPixel,
			FontSizeService fontSizeService) {

		assert freeTextBox != null : "Precondition failed: freeTextBox != null";
		assert pointsPerPixel >= 0 : "Precondition failed: pointsPerPixel >= 0";

		this.height_PT = freeTextBox.getHeight_PX() * pointsPerPixel;
		if (freeTextBox.isContentLocked() || !freeTextBox.isLockedLayout()) {
			this.width_PT = freeTextBox.getWidth_PX() * pointsPerPixel;
		} else {
			this.width_PT = freeTextBox.getTokenWidth() * pointsPerPixel;
		}
		this.freeTextBox = freeTextBox;
		this.pointsPerPixel = pointsPerPixel;
		this.fontSizeService = fontSizeService;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException {
		if (freeTextBox.isVisible()) {
			// Add Background
			Color textBackgroundColorString = freeTextBox.getTextBackgroundColor() == null ? Color.GREY
					: freeTextBox.getTextBackgroundColor();

			contentStream.setNonStrokingColor(new java.awt.Color(textBackgroundColorString.getRed(),
					textBackgroundColorString.getGreen(), textBackgroundColorString.getBlue()));
			contentStream.addRect(x_PT, y_PT, width_PT - (freeTextBox.getMarginRight_PX() * pointsPerPixel), height_PT);
			contentStream.fill();

			if (freeTextBox.isLockedLayout() && !freeTextBox.isContentLocked()) {
				contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
				contentStream.setLineDashPattern(new float[] { 0 }, 0);
				contentStream.addRect(x_PT, y_PT, width_PT - (freeTextBox.getMarginRight_PX() * pointsPerPixel),
						height_PT);
				contentStream.stroke();
			}

			// Add text
			((PdfFontMetric) fontSizeService.getPdfFontMetric()).setTextFormat(freeTextBox.getColor(),
					freeTextBox.getFontMetricSpecifier(), pointsPerPixel, contentStream);

			float textStartingPositionX_PT = x_PT + (freeTextBox.getPaddingLeft_PX() * pointsPerPixel);
			float textLineBottomDistance_PT = -freeTextBox.getFontDescent_PX() * pointsPerPixel;
			float singleLineHeight_PT = height_PT / freeTextBox.getFreeTextLines().size();

			List<String> lines = freeTextBox.getFreeTextLines();
			for (int i = 0; i < lines.size(); i++) {
				contentStream.beginText();
				contentStream.newLineAtOffset(textStartingPositionX_PT,
						y_PT + (textLineBottomDistance_PT + singleLineHeight_PT * (lines.size() - 1 - i)));
				contentStream.showText(lines.get(i));
				contentStream.endText();
			}
		}
	}

	@Override
	public float getWidth_PT() {
		return width_PT;
	}

	@Override
	public float getHeight_PT() {
		return height_PT;
	}
}
