package de.signWritingEditor.server.service.pdfService;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.TagTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public class TagTokenBoxTemplate extends TokenBoxTemplate {
	private float width_PT;
	private float height_PT;
	private TagTokenBox tagTokenBox;
	private float pointsPerPixel;
	private FontSizeService fontSizeService;

	public TagTokenBoxTemplate(TagTokenBox tagTokenBox, float pointsPerPixel, FontSizeService fontSizeService) {
		this.tagTokenBox = tagTokenBox;
		this.pointsPerPixel = pointsPerPixel;
		this.fontSizeService = fontSizeService;
		height_PT = this.tagTokenBox.getHeight_PX() * pointsPerPixel;
		width_PT = (this.tagTokenBox.getWidth_PX() + tagTokenBox.getPaddingLeft_PX() + tagTokenBox.getPaddingRight_PX())
				* pointsPerPixel;
	}

	@Override
	public float getWidth_PT() {
		return width_PT;
	}

	@Override
	public float getHeight_PT() {
		return height_PT;
	}

	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException, Exception {
		Color textBackgroundColorString = Color.WHITE;

		contentStream.setNonStrokingColor(new java.awt.Color(textBackgroundColorString.getRed(),
				textBackgroundColorString.getGreen(), textBackgroundColorString.getBlue()));
		contentStream.addRect(x_PT, y_PT, width_PT - (tagTokenBox.getTagTokenBorder() * pointsPerPixel), height_PT);
		contentStream.fill();

		if (tagTokenBox.isLockedLayout() && !tagTokenBox.isContentLocked()) {
			contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
			contentStream.setLineDashPattern(new float[] { 0 }, 0);
			contentStream.addRect(x_PT, y_PT, width_PT - (tagTokenBox.getTagTokenBorder() * pointsPerPixel), height_PT);
			contentStream.stroke();
		}

		// Add text
		((PdfFontMetric) fontSizeService.getPdfFontMetric()).setTextFormat(Color.BLACK,
				tagTokenBox.getFontMetricSpecifier(), pointsPerPixel, contentStream);

		float textStartingPositionX_PT = x_PT + (tagTokenBox.getPaddingLeft_PX() * pointsPerPixel);
		float textLineBottomDistance_PT = -tagTokenBox.getFontDescent_PX() * pointsPerPixel;

		contentStream.beginText();
		contentStream.newLineAtOffset(textStartingPositionX_PT, y_PT + textLineBottomDistance_PT);
		contentStream.showText(tagTokenBox.getSelectedItemString());
		contentStream.endText();
	}
}
