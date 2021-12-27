package de.signWritingEditor.server.service.pdfService;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

import de.signWritingEditor.server.service.ConfigurationService;

public abstract class TokenBoxTemplate {
	public static final String DEFAULT_IMAGE_TYPE = "png";
	public static final String DEFAULT_MIME_SEP = "/";

	private static Logger LOGGER = Logger.getLogger(TokenBoxTemplate.class);
	private static ConfigurationService configurationService;
	private static String systemBaseURL;

	static {
		try {
			configurationService = new ConfigurationService();
			systemBaseURL = configurationService.getProperty("esf.app.type");
		} catch (Exception e) {
			// everything is broken
		}
	}

	public abstract float getWidth_PT();

	public abstract float getHeight_PT();

	public abstract void draw(PDPageContentStream contentStream, float x, float y) throws IOException, Exception;

	protected void drawFrame(PDPageContentStream contentStream, float startX, float startY, float width, float heigth)
			throws IOException {
		contentStream.setStrokingColor(PdfServiceImpl.GRAY_GRAY_COLOR);
		contentStream.setLineDashPattern(new float[] { 3 }, 0);

		contentStream.drawLine(startX, startY, startX, startY + heigth);
		contentStream.drawLine(startX, startY + heigth, startX + width, startY + heigth);
		contentStream.drawLine(startX + width, startY + heigth, startX + width, startY);
		contentStream.drawLine(startX + width, startY, startX, startY);
		contentStream.stroke();
	}

	protected void addAnnotationLink(PDPage page, String url, float x_PT, float y_PT, float width_PT, float height_PT)
			throws IOException {
		PDAnnotationLink link = new PDAnnotationLink();

		PDActionURI actionURI = new PDActionURI();
		actionURI.setURI(url);
		link.setAction(actionURI);

		PDRectangle pdRectangle = new PDRectangle(x_PT, y_PT, width_PT, height_PT);

		link.setRectangle(pdRectangle);

		page.getAnnotations().add(link);
	}

	protected BufferedImage createErrorImageFromServlet(String errorMessage) {

		String imageURL = null;
		BufferedImage errorImage = null;

		try {
			imageURL = systemBaseURL + "/signwritingeditor/errorImage?error-message="
					+ URLEncoder.encode(errorMessage, StandardCharsets.UTF_8.toString());
			errorImage = ImageIO.read(new URL(imageURL).openStream());
		} catch (Exception e) {
			LOGGER.error("createErrorImageFromServlet : " + e.getMessage());
			// fallback handling
			ErrorImage fallbackImage = new ErrorImage();
			errorImage = fallbackImage.drawImage();
		}

		return errorImage;
	}
}