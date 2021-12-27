package de.signWritingEditor.server.service.pdfService;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.SignItem;

public class SignItemTokenBoxTemplate extends TokenBoxTemplate {

	private static final int SIGN_IMAGE_SCALE_FACTOR = 4;

	private static final int SIGN_HEIGHT = 144;

	private final SignItemTokenBox signTokenBox;
	private final float signTokenBoxWidth_PT;
	private final float signTokenBoxHeight_PT;
	private final boolean signVisible;
	private final SignImageService signImageService;
	private final PDDocument pdfDocument;
	private final FontSizeService fontSizeService;

	private final float signItemWidthWithoutMargin_PT;
	private final float signItemPaddingRight_PT;
	private final float signItemPaddingLeft_PT;
	private final float pointsPerPixel;

	public SignItemTokenBoxTemplate(SignItemTokenBox signTokenBox, PDDocument pdfDocument, float pointsPerPixel,
			boolean signVisible, SignImageService signImageService, FontSizeService fontSizeService) {

		this.pointsPerPixel = pointsPerPixel;
		assert signTokenBox != null : "Precondition failed: tokenBox != null";
		assert pointsPerPixel >= 0 : "Precondition failed: pointsPerPixel >= 0";

		this.signTokenBox = signTokenBox;
		this.signTokenBoxWidth_PT = signTokenBox.getWidth_PX() * pointsPerPixel;
		this.signTokenBoxHeight_PT = signTokenBox.getHeight_PX() * pointsPerPixel;
		this.signVisible = signVisible;
		this.signImageService = signImageService;
		this.pdfDocument = pdfDocument;
		this.fontSizeService = fontSizeService;

		this.signItemWidthWithoutMargin_PT = (signTokenBox.getWidth_PX() - signTokenBox.getMarginRight_PX())
				* pointsPerPixel;
		this.signItemPaddingRight_PT = signTokenBox.getPaddingRight_PX() * pointsPerPixel;
		this.signItemPaddingLeft_PT = signTokenBox.getPaddingLeft_PX() * pointsPerPixel;
	}

	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException {

		String word = signTokenBox.getText();

		SignItem signItem = signTokenBox.getSelectedSign();

		BufferedImage image;
		float searchWordHeight_PT = signTokenBox.getTextHeight_PX() * pointsPerPixel;
		float marginTextToImage_PT = signTokenBox.getMarginBetweenSignItemAndText_PX() * pointsPerPixel;
		float marginRight_PT = signTokenBox.getMarginRight_PX() * pointsPerPixel;
		try {
			if (signItem == null || !signVisible) {
				image = new BufferedImage((int) ((signTokenBoxWidth_PT - marginRight_PT) * SIGN_IMAGE_SCALE_FACTOR),
						SIGN_HEIGHT * SIGN_IMAGE_SCALE_FACTOR, BufferedImage.TYPE_INT_ARGB);
			} else {
				if (signTokenBox.getText().contains(".")) {
					image = signImageService.createSignImage(signItem, SIGN_IMAGE_SCALE_FACTOR, false);
				} else {
					image = signImageService.createSignImage(signItem, SIGN_IMAGE_SCALE_FACTOR, true);
				}
			}

			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", outStream);
			outStream.flush();

			PDImageXObject pdfImage = PDImageXObject.createFromByteArray(pdfDocument, outStream.toByteArray(), null);

			float imageBackgroundStartIndexY_PT = (searchWordHeight_PT + marginTextToImage_PT);

			if (signVisible) {
				Color backgroundColor = signTokenBox.getBackgroundColor() == null ? Color.WHITE
						: signTokenBox.getBackgroundColor();

				contentStream.setNonStrokingColor(new java.awt.Color(backgroundColor.getRed(),
						backgroundColor.getGreen(), backgroundColor.getBlue()));

				contentStream.addRect(x_PT, y_PT + imageBackgroundStartIndexY_PT, signTokenBoxWidth_PT - marginRight_PT,
						signTokenBoxHeight_PT - imageBackgroundStartIndexY_PT);

				contentStream.fill();

				drawFrame(contentStream, x_PT, y_PT + searchWordHeight_PT + marginTextToImage_PT,
						signTokenBoxWidth_PT - marginRight_PT,
						signTokenBoxHeight_PT - (searchWordHeight_PT + marginTextToImage_PT));

				drawAfterScaleAndCenter(pdfImage, x_PT + signItemPaddingLeft_PT,
						y_PT + searchWordHeight_PT + marginTextToImage_PT,
						signItemWidthWithoutMargin_PT - signItemPaddingRight_PT - signItemPaddingLeft_PT,
						signTokenBoxHeight_PT - searchWordHeight_PT - marginTextToImage_PT, contentStream);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		if (signTokenBox.isSearchWordVisible()) {
			// Add Background
			Color textBackgroundColor = signTokenBox.getTextBackgroundColor() == null ? Color.GREY
					: signTokenBox.getTextBackgroundColor();

			contentStream.setNonStrokingColor(new java.awt.Color(textBackgroundColor.getRed(),
					textBackgroundColor.getGreen(), textBackgroundColor.getBlue()));

			contentStream.addRect(x_PT, y_PT, signTokenBoxWidth_PT - marginRight_PT, searchWordHeight_PT);
			contentStream.fill();

			if (signTokenBox.isLockedLayout() && !signTokenBox.isContentLocked()) {
				contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
				contentStream.setLineDashPattern(new float[] { 0 }, 0);
				contentStream.addRect(x_PT, y_PT, signTokenBoxWidth_PT - marginRight_PT, searchWordHeight_PT);
				contentStream.stroke();
			}

			// Add text
			((PdfFontMetric) fontSizeService.getPdfFontMetric()).setTextFormat(signTokenBox.getColor(),
					signTokenBox.getFontMetricSpecifier(), pointsPerPixel, contentStream);

			float boxCenterOffset_PT = (signTokenBoxWidth_PT - marginRight_PT) / 2;
			PDFont font = ((PdfFontMetric) fontSizeService.getPdfFontMetric())
					.getPDFFontFromEditorFont(signTokenBox.getFontMetricSpecifier());

			PDFontDescriptor pdfFontDescriptor = font.getFontDescriptor();

			float fontSize = ((PdfFontMetric) fontSizeService.getPdfFontMetric())
					.getActualFontSize_PT(signTokenBox.getFontMetricSpecifier().getFontSize().getSize());

			float wordWidth = font.getStringWidth(word);
			float wordOffset_PT = wordWidth / 1000 * fontSize / 2;
			float wordStart_PT = boxCenterOffset_PT - wordOffset_PT;

			contentStream.beginText();
			contentStream.newLineAtOffset(x_PT + wordStart_PT,
					y_PT - signTokenBox.getFontDescent_PX() * pointsPerPixel);
			contentStream.showText(word);
			contentStream.endText();
		}
	}

	private void drawAfterScaleAndCenter(PDImageXObject pdfImage, float x_PT, float y_PT, float targetWidth_PT,
			float targetHeight_PT, PDPageContentStream contentStream) throws IOException {
		float width_PT = pdfImage.getWidth();
		float height_PT = pdfImage.getHeight();

		if (targetWidth_PT < width_PT) {
			float scalingFactor = targetWidth_PT / width_PT;
			width_PT = targetWidth_PT;
			height_PT *= scalingFactor;
		}

		if (targetHeight_PT < height_PT) {
			float scalingFactor = targetHeight_PT / height_PT;
			width_PT *= scalingFactor;
			height_PT = targetHeight_PT;
		}

		float deltaWidth = targetWidth_PT - width_PT;
		float deltaHeight = targetHeight_PT - height_PT;

		contentStream.drawImage(pdfImage, x_PT + deltaWidth / 2, y_PT + deltaHeight / 2, width_PT, height_PT);
	}

	@Override
	public float getWidth_PT() {
		return signTokenBoxWidth_PT;
	}

	@Override
	public float getHeight_PT() {
		return signTokenBoxHeight_PT;
	}

	public int getMarginBetweenSignAndText() {
		return signTokenBox.getMarginBetweenSignItemAndText_PX();
	}
}
