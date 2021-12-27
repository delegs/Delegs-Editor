package de.signWritingEditor.server.service.pdfService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget;
import de.signWritingEditor.client.service.VideoService;
import de.signWritingEditor.server.service.VideoServiceImpl;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public class VideoTokenBoxTemplate extends TokenBoxTemplate {
	private VideoService videoService;
	private VideoTokenBox videoTokenBox;

	private float videoHeight_PT;
	private float videoWidth_PT;
	private float tokenBoxWidthWithoutMargin_PT;
	private float tokenBoxHeightWithoutMargin_PT;
	private float urlBoxPixelHeight_PT;
	private float yOffset_PT;
	private float bottomTextPadding_PT;
	private float marginBetweenTextAndImage_PT;
	private float pointsPerPixel;
	private PDDocument pdfDocument;
	private PDPage page;

	public VideoTokenBoxTemplate(VideoTokenBox videoTokenBox, PDDocument pdfDocument, PDPage page, float pointsPerPixel,
			VideoService videoService) {
		assert videoTokenBox != null : "Precondition failed: freeTextBox != null";
		assert pointsPerPixel >= 0 : "Precondition failed: pointsPerPixel >= 0";

		this.videoService = videoService;
		this.videoTokenBox = videoTokenBox;
		this.pdfDocument = pdfDocument;
		this.page = page;

		this.videoHeight_PT = videoTokenBox.getHeight_PX() * pointsPerPixel;
		this.videoWidth_PT = videoTokenBox.getWidth_PX() * pointsPerPixel;
		this.tokenBoxHeightWithoutMargin_PT = (videoTokenBox.getHeight_PX() - videoTokenBox.getURLBoxHeight_PX()
				- videoTokenBox.getBottomTextPadding_PX()) * pointsPerPixel;
		this.tokenBoxWidthWithoutMargin_PT = (videoTokenBox.getWidth_PX() - videoTokenBox.getMarginRight_PX())
				* pointsPerPixel;
		this.urlBoxPixelHeight_PT = videoTokenBox.getURLBoxHeight_PX() * pointsPerPixel;
		this.bottomTextPadding_PT = videoTokenBox.getBottomTextPadding_PX() * pointsPerPixel;
		this.yOffset_PT = videoTokenBox.getButtonPanelHeight() * pointsPerPixel;
		this.marginBetweenTextAndImage_PT = videoTokenBox.getMarginBetweenVideoAndTextPX() * pointsPerPixel;
		this.pointsPerPixel = pointsPerPixel;
	}

	private void createURLBackground(float x_PT, float y_PT, float tokenBoxWidthWithoutMargin_PT, float urlBoxHeight_PT,
			PDPageContentStream contentStream) throws IOException {
		// Add Background
		Color color = videoTokenBox.getTextBackgroundColor() == null ? Color.GREY
				: videoTokenBox.getTextBackgroundColor();
		contentStream.setNonStrokingColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

		contentStream.addRect(x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, urlBoxHeight_PT);
		contentStream.fill();

		if (videoTokenBox.isLockedLayout() && !videoTokenBox.isContentLocked()) {
			contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
			contentStream.setLineDashPattern(new float[] { 0 }, 0);
			contentStream.addRect(x_PT, y_PT,
					tokenBoxWidthWithoutMargin_PT - (videoTokenBox.getMarginRight_PX() * pointsPerPixel),
					urlBoxHeight_PT);
			contentStream.stroke();
		}
	}

	private void createVideoImage(float x_PT, float y_PT, float tokenBoxWidthWithoutMargin_PT,
			float tokenBoxHeightWithoutMargin_PT, float urlBoxHeight_PT, File file, PDPageContentStream contentStream)
			throws IOException {

		BufferedImage image = ImageIO.read(file);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ImageIO.write(image, DEFAULT_IMAGE_TYPE, outStream);
		outStream.flush();

		PDImageXObject pdfImage = PDImageXObject.createFromByteArray(pdfDocument, outStream.toByteArray(), null);

		scaleImageToCenter(pdfImage, true, x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, tokenBoxHeightWithoutMargin_PT, 0,
				urlBoxHeight_PT, contentStream);

	}

	private void scaleImageToCenter(PDImageXObject pdfImage, boolean createImageLink, float x_PT, float y_PT,
			float targetWidth_PT, float targetHeight_PT, float startXOffset_PT, float startYOffset_PT,
			PDPageContentStream contentStream) throws IOException {
		float width_PT = pdfImage.getWidth();
		float height_PT = pdfImage.getHeight();

		float widthScale = targetWidth_PT / VideoTokenBoxWidget.SIDE_RATIO_X;
		float heightScale = targetHeight_PT / VideoTokenBoxWidget.SIDE_RATIO_Y;

		if (heightScale * VideoTokenBoxWidget.SIDE_RATIO_X < targetWidth_PT) {
			height_PT = heightScale * VideoTokenBoxWidget.SIDE_RATIO_Y;
			width_PT = heightScale * VideoTokenBoxWidget.SIDE_RATIO_X;
		} else {
			height_PT = widthScale * VideoTokenBoxWidget.SIDE_RATIO_Y;
			width_PT = widthScale * VideoTokenBoxWidget.SIDE_RATIO_X;
		}

		float posX = startXOffset_PT + (targetWidth_PT - width_PT) / 2;
		float posY = startYOffset_PT + (targetHeight_PT - height_PT) / 2;

		contentStream.drawImage(pdfImage, x_PT + posX, y_PT + posY + yOffset_PT - bottomTextPadding_PT, width_PT,
				height_PT);

		if (createImageLink) {
			addAnnotationLink(page, videoTokenBox.getUrl(), x_PT + posX,
					y_PT + posY + yOffset_PT - bottomTextPadding_PT, width_PT, height_PT);
		}
	}

	private void createVideoPlaceholder(float x_PT, float y_PT, VideoTokenBox videoTokenBox, float videoTokenBoxHeight,
			float tokenBoxWidthWithoutMargin_PT, float urlBoxHeight_PT, PDPageContentStream contentStream,
			String placeholder) throws IOException {

		BufferedImage noVideoFoundImage = createErrorImageFromServlet(placeholder);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ImageIO.write(noVideoFoundImage, DEFAULT_IMAGE_TYPE, outStream);
		outStream.flush();

		PDImageXObject pdfImage = PDImageXObject.createFromByteArray(pdfDocument, outStream.toByteArray(), null);

		scaleImageToCenter(pdfImage, false, x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, tokenBoxHeightWithoutMargin_PT,
				0, urlBoxHeight_PT, contentStream);
	}

	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws IOException {
		String posterUrl = ((VideoServiceImpl) videoService).getPosterUrl(videoTokenBox.getUrl());
		File posterFile = new File(posterUrl);

		// draw image
		if (posterFile.exists()) {
			createVideoImage(x_PT, y_PT + marginBetweenTextAndImage_PT, tokenBoxWidthWithoutMargin_PT,
					tokenBoxHeightWithoutMargin_PT, urlBoxPixelHeight_PT, posterFile, contentStream);
		} else {
			if (videoTokenBox.getUrl().isEmpty()) {
				createVideoPlaceholder(x_PT, y_PT + marginBetweenTextAndImage_PT, videoTokenBox, videoHeight_PT,
						tokenBoxWidthWithoutMargin_PT, urlBoxPixelHeight_PT, contentStream,
						I18NAccess.I18N.getNoVideoLoaded());
			} else {
				createVideoPlaceholder(x_PT, y_PT + marginBetweenTextAndImage_PT, videoTokenBox, videoHeight_PT,
						tokenBoxWidthWithoutMargin_PT, urlBoxPixelHeight_PT, contentStream,
						I18NAccess.I18N.getNoVideoFound());
			}

		}

		drawFrame(contentStream, x_PT, y_PT + marginBetweenTextAndImage_PT + urlBoxPixelHeight_PT + yOffset_PT,
				tokenBoxWidthWithoutMargin_PT, tokenBoxHeightWithoutMargin_PT - yOffset_PT + 2);

		// draw textbox background
		if (videoTokenBox.isURLVisible()) {
			createURLBackground(x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, urlBoxPixelHeight_PT, contentStream);
		}
	}

	@Override
	public float getWidth_PT() {
		return videoWidth_PT;
	}

	@Override
	public float getHeight_PT() {
		return videoHeight_PT;
	}

}
