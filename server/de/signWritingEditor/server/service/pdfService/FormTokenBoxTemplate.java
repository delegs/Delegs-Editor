package de.signWritingEditor.server.service.pdfService;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FormTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FontWeight;

public class FormTokenBoxTemplate extends TokenBoxTemplate {

	private FormTokenBox tokenBox;
	private float pointsPerPixel;
	private FontSizeService fontSizeService;
	private float width_PT;
	private float height_PT;
	private float descriptionWidth_PT;
	private float inputWidth_PT;
	private final static int INPUT_BORDER_PT = 1;

	public FormTokenBoxTemplate(FormTokenBox tokenBox, float pointsPerPixel, FontSizeService fontSizeService) {
		assert tokenBox != null : "Precondition failed: freeTextBox != null";
		assert pointsPerPixel >= 0 : "Precondition failed: pointsPerPixel >= 0";

		this.tokenBox = tokenBox;
		this.pointsPerPixel = pointsPerPixel;
		this.fontSizeService = fontSizeService;
		this.width_PT = tokenBox.getWidth_PX() * pointsPerPixel;
		this.height_PT = tokenBox.getHeight_PX() * pointsPerPixel;
		this.descriptionWidth_PT = tokenBox.getDescriptionWidth_PX() * pointsPerPixel;
		this.inputWidth_PT = tokenBox.getInputWidth_PX() * pointsPerPixel;

	}

	@Override
	public float getWidth_PT() {
		return width_PT;
	}

	@Override
	public float getHeight_PT() {
		return height_PT;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException, Exception {
		Color textBackgroundColor = tokenBox.getBackgroundColor() == null ? Color.WHITE : tokenBox.getBackgroundColor();
		Color descriptionBackgroundColor = Color.WHITE;

		// Set Background for Description
		contentStream.setNonStrokingColor(new java.awt.Color(descriptionBackgroundColor.getRed(),
				descriptionBackgroundColor.getGreen(), descriptionBackgroundColor.getBlue()));
		contentStream.addRect(x_PT, y_PT, descriptionWidth_PT, height_PT);
		contentStream.fill();

		// Add Description
		tokenBox.setFontWeight(FontWeight.BOLD);
		((PdfFontMetric) fontSizeService.getPdfFontMetric()).setTextFormat(Color.BLACK,
				tokenBox.getFontMetricSpecifier(), pointsPerPixel, contentStream);

		float descriptionStartingPositionX_PT = x_PT + (tokenBox.getPaddingLeft() * pointsPerPixel);
		float textLineBottomDistance_PT = -tokenBox.getFontDescent_PX() * pointsPerPixel;

		contentStream.beginText();
		contentStream.newLineAtOffset(descriptionStartingPositionX_PT,
				y_PT + textLineBottomDistance_PT + INPUT_BORDER_PT);
		contentStream.showText(tokenBox.getDescription());
		contentStream.endText();

		// Set Background for Input
		contentStream.setNonStrokingColor(new java.awt.Color(textBackgroundColor.getRed(),
				textBackgroundColor.getGreen(), textBackgroundColor.getBlue()));
		contentStream.addRect(x_PT + descriptionWidth_PT, y_PT, inputWidth_PT, height_PT);
		contentStream.fill();

		// Add Textbox-Border
		contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
		contentStream.setLineDashPattern(new float[] { 0 }, 0);
		contentStream.addRect(x_PT + descriptionWidth_PT, y_PT, inputWidth_PT, height_PT);
		contentStream.stroke();

		// Add InputContent
		tokenBox.setFontWeight(FontWeight.NORMAL);
		((PdfFontMetric) fontSizeService.getPdfFontMetric()).setTextFormat(tokenBox.getColor(),
				tokenBox.getFontMetricSpecifier(), pointsPerPixel, contentStream);

		float inputTextStartingPosition = x_PT + descriptionWidth_PT + (tokenBox.getPaddingLeft() * pointsPerPixel);

		contentStream.beginText();
		contentStream.newLineAtOffset(inputTextStartingPosition, y_PT + textLineBottomDistance_PT + INPUT_BORDER_PT);
		contentStream.showText(tokenBox.getInputContent());
		contentStream.endText();
	}

}
