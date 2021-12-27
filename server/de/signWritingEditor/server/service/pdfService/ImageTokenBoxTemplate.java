package de.signWritingEditor.server.service.pdfService;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.net.ssl.SSLHandshakeException;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;

public class ImageTokenBoxTemplate extends TokenBoxTemplate {
	private PDDocument pdfDocument;
	private ImageTokenBox imageTokenBox;
	private ErrorImage errorImage;

	private static final long MAX_IMAGE_SIZE = 5000000;

	private String DATA_URL_RX = "^data:image.*";

	private static final String CONTENT_TYPE_IMAGE = "image/";

	private float imageHeight_PT;
	private float imageWidth_PT;
	private float tokenBoxWidthWithoutMargin_PT;
	private float tokenBoxHeightWithoutMargin_PT;
	private float urlBoxHeight_PT;
	private float marginBetweenImageAndText_PT;
	private Boolean annotation = true;
	private PDPage page;

	private float buttonPanelHeight_PT;

	public ImageTokenBoxTemplate(ImageTokenBox imageTokenBox, PDDocument pdfDocument, PDPage page,
			float pointsPerPixel) {
		this.pdfDocument = pdfDocument;
		this.page = page;
		this.imageTokenBox = imageTokenBox;
		this.buttonPanelHeight_PT = imageTokenBox.getButtonPanelHeight() * pointsPerPixel;

		errorImage = new ErrorImage();
		this.imageHeight_PT = this.imageTokenBox.getHeight_PX() * pointsPerPixel;
		this.imageWidth_PT = this.imageTokenBox.getWidth_PX() * pointsPerPixel;

		this.tokenBoxWidthWithoutMargin_PT = (imageTokenBox.getWidth_PX() - imageTokenBox.getMarginRight())
				* pointsPerPixel;
		this.tokenBoxHeightWithoutMargin_PT = (imageTokenBox.getHeight_PX() - imageTokenBox.getURLBoxHeight_PX())
				* pointsPerPixel - buttonPanelHeight_PT;
		this.urlBoxHeight_PT = imageTokenBox.getURLBoxHeight_PX() * pointsPerPixel;
		this.marginBetweenImageAndText_PT = imageTokenBox.getMarginBetweenImageAndTextPX() * pointsPerPixel;
	}

	private void createImage(float x_PT, float y_PT, float width, float height, float yOffset,
			PDPageContentStream contentStream) throws Exception {
		BufferedImage image = null;
		String urlText = imageTokenBox.getUrl().replaceAll("\\p{Cc}", "");
		String imageType = DEFAULT_IMAGE_TYPE;

		ByteArrayOutputStream imageOutputString;

		try {
			if (urlText.isEmpty()) {
				throw new IOException(I18N.getImageNotFound());
			} else if (Pattern.matches(DATA_URL_RX, urlText)) {
				// handle data url
				byte[] imagedata = DatatypeConverter.parseBase64Binary(urlText.substring(urlText.indexOf(",") + 1));
				image = ImageIO.read(new ByteArrayInputStream(imagedata));
				annotation = false;
			} else {
				URL url = new URL(urlText);
				HttpURLConnection urlConnection;

				urlConnection = (HttpURLConnection) url.openConnection();

				urlConnection.setRequestMethod("GET");
				// Fake user agent
				urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0;)");

				InputStream inputStream = urlConnection.getInputStream();

				if (urlConnection.getContentType().endsWith("stream")) {
					byte[] imagedata = IOUtils.toByteArray(inputStream);
					image = ImageIO.read(new ByteArrayInputStream(imagedata));
				} else if (!urlConnection.getContentType().startsWith(CONTENT_TYPE_IMAGE)) {
					throw new IOException(I18N.getImageNotFound());
				} else if (urlConnection.getContentLengthLong() > MAX_IMAGE_SIZE) {
					throw new IOException(I18N.getImageTooLarge());
				} else {
					image = ImageIO.read(inputStream);

					// determine and isolate image type
					imageType = urlConnection.getContentType();

					if (imageType.contains(DEFAULT_MIME_SEP)) {
						imageType = imageType.substring(imageType.lastIndexOf(DEFAULT_MIME_SEP) + 1);
					}
				}
			}

			if (image == null) {
				imageType = DEFAULT_IMAGE_TYPE;
				throw new IOException(I18N.getImageNotFound());
			}
		} catch (SSLHandshakeException e) {
			annotation = false;
			image = errorImage.drawImage(I18N.getWebsideNotSupported());

			assert image != null : "Image was null, even if handelt exception";
		} catch (IOException e) {
			annotation = false;
			if (e.getMessage().equals(I18N.getImageNotFound()) || e.getMessage().equals(I18N.getImageTooLarge())) {
				image = createErrorImageFromServlet(e.getMessage());
			} else {
				image = createErrorImageFromServlet(I18N.getImageNotFound());

			}
			assert image != null : "Image was null, even if handelt exception";

		} finally {
			assert image != null : "Image was null, due to unhandelt exception";
			imageOutputString = writeImageToStream(image, imageType);
		}

		PDImageXObject pdfImage = PDImageXObject.createFromByteArray(pdfDocument, imageOutputString.toByteArray(),
				null);

		scaleImageToCenterandDraw(pdfImage, annotation, x_PT, y_PT, tokenBoxWidthWithoutMargin_PT,
				tokenBoxHeightWithoutMargin_PT, 0, urlBoxHeight_PT, contentStream);
	}

	private ByteArrayOutputStream writeImageToStream(BufferedImage image, String imageType) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, imageType, outStream);
			outStream.flush();
		} catch (IOException e) {
			try {
				BufferedImage fallbackImage = null;
				String fallbackImageType = DEFAULT_IMAGE_TYPE;
				image = errorImage.drawImage();
				return writeImageToStream(fallbackImage, fallbackImageType);
			} catch (Exception ex) {
				// nothing todo
			}
		}
		assert outStream != null : "Postassertion failed: outStream != null";
		return outStream;
	}

	private void scaleImageToCenterandDraw(PDImageXObject pdfImage, boolean annotation, float x_PT, float y_PT,
			float targetWidth_PT, float targetHeight_PT, float startXOffset_PT, float startYOffset_PT,
			PDPageContentStream contentStream) throws IOException {
		float aspectRatio;
		float width_PT = pdfImage.getWidth();
		float height_PT = pdfImage.getHeight();

		if (targetWidth_PT != width_PT) {
			aspectRatio = targetWidth_PT / width_PT;
			width_PT *= aspectRatio;
			height_PT *= aspectRatio;
		}

		if (targetHeight_PT < height_PT) {
			aspectRatio = targetHeight_PT / height_PT;
			width_PT *= aspectRatio;
			height_PT *= aspectRatio;
		}

		float posX = startXOffset_PT + (targetWidth_PT - width_PT) / 2;
		float posY = startYOffset_PT + (targetHeight_PT - height_PT) / 2;

		contentStream.drawImage(pdfImage, x_PT + posX, y_PT + posY + buttonPanelHeight_PT, width_PT, height_PT);
		if (annotation) {
			addAnnotationLink(page, imageTokenBox.getUrl(), x_PT + posX, y_PT + posY + buttonPanelHeight_PT, width_PT,
					height_PT);
		}

		drawFrame(contentStream, x_PT + startXOffset_PT, y_PT + startYOffset_PT + buttonPanelHeight_PT,
				tokenBoxWidthWithoutMargin_PT, tokenBoxHeightWithoutMargin_PT);
	}

	private void createURLBackground(float x_PT, float y_PT, float tokenBoxWidthWithoutMargin_PT, float urlBoxHeight_PT,
			PDPageContentStream contentStream) throws IOException {

		// Add Background
		Color color = Color.GREY;
		contentStream.setNonStrokingColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

		contentStream.addRect(x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, urlBoxHeight_PT);
		contentStream.fill();
	}

	@Override
	public void draw(PDPageContentStream contentStream, float x_PT, float y_PT) throws Exception {

		createImage(x_PT, y_PT + marginBetweenImageAndText_PT, tokenBoxWidthWithoutMargin_PT,
				tokenBoxHeightWithoutMargin_PT, urlBoxHeight_PT, contentStream);
		createURLBackground(x_PT, y_PT, tokenBoxWidthWithoutMargin_PT, urlBoxHeight_PT, contentStream);
	}

	@Override
	public float getWidth_PT() {
		return imageWidth_PT;
	}

	@Override
	public float getHeight_PT() {
		return imageHeight_PT;
	}

}
