package de.signWritingEditor.server.service.pdfService;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.VideoService;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FormTokenBox;
import de.signWritingEditor.shared.layout.FrameTokenBox;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.TagTokenBox;
import de.signWritingEditor.shared.layout.VideoTokenBox;

public class TokenBoxTemplateFactory {

	private float pointsPerPixel;
	private SignImageService signImageService;
	private VideoService videoService;
	private Logger LOG;
	private FontSizeService fontSizeService;
	private PDDocument pdfDocument;

	public TokenBoxTemplateFactory(PDDocument pdfDocument, float pointsPerPixel, Logger logger,
			SignImageService signImageService, VideoService videoService, FontSizeService fontSizeService) {
		this.pointsPerPixel = pointsPerPixel;
		this.LOG = logger;
		this.signImageService = signImageService;
		this.videoService = videoService;
		this.fontSizeService = fontSizeService;
		this.pdfDocument = pdfDocument;
	}

	public TokenBoxTemplateFactory(PDDocument pdfDocument, PDPageContentStream contentStream, float pointsPerPixel,
			Logger logger, SignImageService signImageService, FontSizeService fontSizeService) {
		this(pdfDocument, pointsPerPixel, logger, signImageService, null, fontSizeService);
	}

	public TokenBoxTemplate createTokenBoxTemplate(Box box, PDPage page) {
		TokenBoxTemplate result = null;
		if (box instanceof SignItemTokenBox) {
			result = new SignItemTokenBoxTemplate((SignItemTokenBox) box, pdfDocument, pointsPerPixel,
					((SignItemTokenBox) box).getSignVisibility(), signImageService, fontSizeService);
		} else if (box instanceof FreeTextTokenBox) {
			result = new FreeTextTokenBoxTemplate((FreeTextTokenBox) box, pointsPerPixel, fontSizeService);
		} else if (box instanceof FrameTokenBox) {
			result = new FrameTokenBoxTemplate((FrameTokenBox) box, pointsPerPixel);
		} else if (box instanceof VideoTokenBox) {
			result = new VideoTokenBoxTemplate((VideoTokenBox) box, pdfDocument, page, pointsPerPixel, videoService);
		} else if (box instanceof ImageTokenBox) {
			result = new ImageTokenBoxTemplate((ImageTokenBox) box, pdfDocument, page, pointsPerPixel);
		} else if (box instanceof FormTokenBox) {
			result = new FormTokenBoxTemplate((FormTokenBox) box, pointsPerPixel, fontSizeService);
		} else if (box instanceof TagTokenBox) {
			result = new TagTokenBoxTemplate((TagTokenBox) box, pointsPerPixel, fontSizeService);
		}
		return result;

	}

	public PdfLineTemplate createPdfLineTemplate(float width_PT, float height_PT, int x, int y) {
		return new PdfLineTemplate(width_PT, height_PT, pointsPerPixel, x, y);
	}

	public PdfSnippetTemplate createPdfSnippetTemplate(float width_PT, float height_PT, float x_PX, float y_PX, int z) {
		return new PdfSnippetTemplate(width_PT, height_PT, pointsPerPixel, x_PX, y_PX, z);
	}
}
