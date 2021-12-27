package de.signWritingEditor.server.service.pdfService;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.PdfService;
import de.signWritingEditor.client.service.VideoService;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.SignImageService;
import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class PdfServiceImpl implements PdfService {

	private static final Logger LOG = Logger.getLogger(PdfServiceImpl.class);

	private static final int FOOTER_FONT_SIZE_PT = 8;
	private static final PDType1Font FOOTER_FONT = PDType1Font.HELVETICA;
	private static final float POINTS_PER_INCH = 72f;
	static final float GRAY_GRAY_COLOR = 170f / 255f;
	private static final float GRAY_WHITE_COLOR = 1f;

	private static final String PROPERTY_PDF_PATH = "esf.pdf.path";
	private static final String PDF_URL = "esf.pdf.url";

	private final String absolutePdfDirPath;
	private final String pdfURL;

	private final SignImageService signImageService;
	private FontSizeService fontSizeService;
	private VideoService videoService;
	private TokenBoxTemplateFactory tokenBoxTemplateFactory;

	/**
	 * Constructor.
	 * 
	 * @require configurationService != null
	 */
	public PdfServiceImpl(ConfigurationService configurationService, SignImageService signImageService,
			VideoService videoService, FontSizeService fontSizeService) throws IOException {
		assert signImageService != null : "Precondition failed: signImageService != null";
		assert configurationService != null : "configurationService != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.absolutePdfDirPath = configurationService.getProperty(PROPERTY_PDF_PATH);
		this.pdfURL = configurationService.getProperty(PDF_URL);
		this.signImageService = signImageService;
		this.videoService = videoService;
		this.fontSizeService = fontSizeService;
		LOG.debug("PDFService was created!");
	}

	@Override
	public String exportToPdf(final de.signWritingEditor.shared.model.material.Document document, I18N i18n)
			throws IOException {
		assert document != null : "signWritingDocument != null";

		I18NAccess.I18N = i18n;

		File result = createFile(document);

		PageFormat pageFormat = document.getPageFormat();
		float pointsPerPixel = (float) (POINTS_PER_INCH / pageFormat.getDpi());

		PDDocument pdfDocument = new PDDocument();

		tokenBoxTemplateFactory = new TokenBoxTemplateFactory(pdfDocument, pointsPerPixel, LOG, signImageService,
				videoService, fontSizeService);

		fontSizeService.setMetric(new PdfFontMetric(pointsPerPixel));

		PdfDocumentLayouter pdfDocumentLayouter = new PdfDocumentLayouter(document,
				new TokenBoxFactory(fontSizeService), fontSizeService);

		try {

			for (int pageIndex = 0, pageCount = pdfDocumentLayouter
					.getPageCount(); pageIndex < pageCount; pageIndex++) {
				addPageToPDF(document.getDocumentTitle(), document.areUnderlinesVisible(), pageIndex, pageCount,
						pdfDocumentLayouter, pdfDocument, pageFormat, pointsPerPixel);
			}

			pdfDocument.save(result);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (pdfDocument != null) {
				pdfDocument.close();

			}
		}

		return getPdfFilePath(result.getName());
	}

	private String getPdfFilePath(String fileName) {
		return pdfURL + fileName;
	}

	private File createFile(final de.signWritingEditor.shared.model.material.Document document) {
		File result = null;

		File pdfDir = new File(absolutePdfDirPath);
		LOG.debug(pdfDir.getAbsolutePath());
		if (!pdfDir.exists()) {
			boolean success = pdfDir.mkdir();
			if (!success) {
				LOG.debug("Creating PDF dir was not successful " + pdfDir.getAbsolutePath());
			}
		}

		result = new File(pdfDir, createFileTitle(document.getDocumentTitle().getTitleString()));
		return result;
	}

	protected String createFileTitle(String documentTitle) {
		assert documentTitle != null : "Precondition failed: documentTitle != null";

		// Add timestamp to PDF file name
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		String dateTimeString = simpleDateFormat.format(new Date());

		return replaceSpecialChars(documentTitle) + " " + dateTimeString + ".pdf";
	}

	protected String replaceSpecialChars(String string) {
		assert string != null : "Precondition failed: string != null";

		String result = string;
		result = result.replaceAll("\u00e4", "ae");
		result = result.replaceAll("\u00c4", "Ae");
		result = result.replaceAll("\u00f6", "oe");
		result = result.replaceAll("\u00d6", "Oe");
		result = result.replaceAll("\u00fc", "ue");
		result = result.replaceAll("\u00dc", "Ue");
		result = result.replaceAll("\u00df", "ss");

		// √†√¢√°√®√™√©√¨√Æ√≠√≤√¥√≥√π√ª√∫√Ä√Ç√Å√à√ä√â√å√é√ç√í√î√ì√ô√õ√ö
		result = result.replaceAll("\u00e0", "a");
		result = result.replaceAll("\u00e2", "a");
		result = result.replaceAll("\u00e1", "a");
		result = result.replaceAll("\u00e8", "e");
		result = result.replaceAll("\u00ea", "e");
		result = result.replaceAll("\u00e9", "e");
		result = result.replaceAll("\u00ec", "i");
		result = result.replaceAll("\u00ee", "i");
		result = result.replaceAll("\u00ed", "i");
		result = result.replaceAll("\u00f2", "o");
		result = result.replaceAll("\u00f4", "o");
		result = result.replaceAll("\u00f3", "o");
		result = result.replaceAll("\u00f9", "u");
		result = result.replaceAll("\u00fb", "u");
		result = result.replaceAll("\u00fa", "u");
		result = result.replaceAll("\u00c0", "A");
		result = result.replaceAll("\u00c2", "A");
		result = result.replaceAll("\u00c1", "A");
		result = result.replaceAll("\u00c8", "E");
		result = result.replaceAll("\u00ca", "E");
		result = result.replaceAll("\u00c9", "E");
		result = result.replaceAll("\u00cc", "I");
		result = result.replaceAll("\u00ce", "I");
		result = result.replaceAll("\u00cd", "I");
		result = result.replaceAll("\u00d2", "O");
		result = result.replaceAll("\u00d4", "O");
		result = result.replaceAll("\u00d3", "O");
		result = result.replaceAll("\u00d9", "U");
		result = result.replaceAll("\u00db", "U");
		result = result.replaceAll("\u00da", "U");

		result = result.replaceAll("[.:,?!*|\\/<>\"]", "_");

		return result;
	}

	private void addPageToPDF(FileTitle documentTitle, final boolean areUnderLinesVisible, int pageIndex, int pageCount,
			PdfDocumentLayouter pdfDocumentLayouter, PDDocument pdfDocument, PageFormat pageFormat,
			float pointsPerPixel) throws Exception {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert pointsPerPixel > 0 : "Precondition failed: pointsPerPixel > 0";
		assert pdfDocument != null : "Precondition failed: pdfDocument != null";
		assert pdfDocumentLayouter != null : "Precondition failed: pdfDocumentLayouter != null";
		assert pageCount > 0 : "Precondition failed: pageCount > 0";
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < pageCount : "Precondition failed: pageIndex < pageCount";

		PDRectangle pageRectangle = new PDRectangle(0F, 0F, pointsPerPixel * pageFormat.getPixelWidth(),
				pointsPerPixel * pageFormat.getPixelHeight());
		PDPage page = new PDPage(pageRectangle);
		pdfDocument.addPage(page);

		try (PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, page)) {

			// set the cursor position to left top corner
			float y_PT = pageRectangle.getHeight() - (pageFormat.getPixelPaddingTop() * pointsPerPixel);

			addFooter(documentTitle, pageIndex, pageCount, pageFormat, pointsPerPixel, contentStream);

			if (pdfDocumentLayouter.isCollage(pageIndex)) {
				ArrayList<PdfSnippetTemplate> pageSnippets = new ArrayList<>();

				for (int snippetIndex = 0; snippetIndex < pdfDocumentLayouter
						.getSnippetCount(pageIndex); snippetIndex++) {
					LineIndex snippetIndexObject = new LineIndex(pageIndex, snippetIndex, 0);
					pageSnippets.add(getSnippetForPDF(snippetIndexObject, page, pageFormat, pointsPerPixel,
							pdfDocumentLayouter));
				}

				// sort snippets by z index
				Collections.sort(pageSnippets, new Comparator<PdfSnippetTemplate>() {
					@Override
					public int compare(PdfSnippetTemplate o1, PdfSnippetTemplate o2) {
						return ((Integer) o1.getZIndex()).compareTo(o2.getZIndex());
					}
				});

				for (PdfSnippetTemplate template : pageSnippets) {
					template.draw(contentStream, template.getX_PT() + template.getSnippetPadding_PT(),
							-template.getY_PT() + (pageFormat.getPixelHeight() * pointsPerPixel));
				}

			} else {
				for (int lineIndex = 0; lineIndex < pdfDocumentLayouter.getLineCount(pageIndex); lineIndex++) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
					int lineHeight_PX = pdfDocumentLayouter.getLineHeight_PX(lineIndexObject);
					y_PT -= lineHeight_PX * pointsPerPixel;
					drawLineToPDF(lineIndexObject, areUnderLinesVisible, page, pageFormat, pointsPerPixel,
							pdfDocumentLayouter, contentStream, y_PT);
				}
			}

		}
	}

	private void drawLineToPDF(LineIndex lineIndexObject, final boolean areUnderLinesVisible, PDPage page,
			PageFormat pageFormat, float pointsPerPixel, PdfDocumentLayouter pdfDocumentLayouter,
			PDPageContentStream contentStream, float y_PT) throws Exception {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert pointsPerPixel > 0 : "Precondition failed: pointsPerPixel > 0";
		assert pdfDocumentLayouter != null : "Precondition failed: pdfDocumentLayouter != null";
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";

		float minX_PT = pageFormat.getPixelPaddingLeft_PX() * pointsPerPixel;
		float maxX_PT = (pageFormat.getPixelWidth() - pageFormat.getPixelPaddingRight()) * pointsPerPixel;

		float x_PT = minX_PT;

		for (int boxIndex = 0; boxIndex < pdfDocumentLayouter.getBoxCount(lineIndexObject); boxIndex++) {
			Box box = pdfDocumentLayouter.getBox(new BoxIndex(lineIndexObject, boxIndex));
			TokenBoxTemplate boxTemplate = tokenBoxTemplateFactory.createTokenBoxTemplate(box, page);
			boxTemplate.draw(contentStream, x_PT, y_PT);
			x_PT += boxTemplate.getWidth_PT();
		}

		if (areUnderLinesVisible) {
			contentStream.setStrokingColor(GRAY_GRAY_COLOR);
			contentStream.setLineDashPattern(new float[] { 3 }, 0);
			// FIXME line width is too thick
			contentStream.setLineWidth(1 * pointsPerPixel);
			contentStream.moveTo(minX_PT, y_PT);
			contentStream.lineTo(maxX_PT, y_PT);
			contentStream.stroke();
		} else {
			contentStream.setStrokingColor(GRAY_WHITE_COLOR);
		}

	}

	private PdfSnippetTemplate getSnippetForPDF(LineIndex snippetIndexObject, PDPage page, PageFormat pageFormat,
			float pointsPerPixel, PdfDocumentLayouter pdfDocumentLayouter) throws IOException {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert pointsPerPixel > 0 : "Precondition failed: pointsPerPixel > 0";
		assert pdfDocumentLayouter != null : "Precondition failed: pdfDocumentLayouter != null";
		assert snippetIndexObject.getPageIndex() >= 0 : "Precondition failed: snippetIndexObject.getPageIndex() >= 0";
		assert snippetIndexObject
				.getSnippetIndex() >= 0 : "Precondition failed: snippetIndexObject.getSnippetIndex() >= 0";

		PdfSnippetTemplate pdfSnippetTemplate = null;

		SnippetLayout snippet = pdfDocumentLayouter.getSnippet(snippetIndexObject.getPageIndex(),
				snippetIndexObject.getSnippetIndex());

		int x_PX = snippet.getX_PX();
		int y_PX = snippet.getY_PX();
		int z = snippet.getZ();

		float width_PT = snippet.getWidth_PX() * pointsPerPixel;
		float height_PT = snippet.getHeight_PX() * pointsPerPixel;

		pdfSnippetTemplate = tokenBoxTemplateFactory.createPdfSnippetTemplate(width_PT, height_PT, x_PX, y_PX, z);

		// Es wird rückwärts durch die Liste gegangen, da die Zeilen sonst in
		// falscher Reihenfolge eingefügt werden
		for (int lineIndex = pdfDocumentLayouter.getLineCount(snippetIndexObject) - 1; lineIndex >= 0; lineIndex--) {
			LineIndex lineIndexObject = new LineIndex(snippetIndexObject.getPageIndex(),
					snippetIndexObject.getSnippetIndex(), lineIndex);
			pdfSnippetTemplate
					.addLine(getSnippetLine(lineIndexObject, page, pageFormat, pointsPerPixel, pdfDocumentLayouter));
		}

		return pdfSnippetTemplate;
	}

	private PdfLineTemplate getSnippetLine(LineIndex lineIndexObject, PDPage page, PageFormat pageFormat,
			float pointsPerPixel, PdfDocumentLayouter pdfDocumentLayouter) throws IOException {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert pointsPerPixel > 0 : "Precondition failed: pointsPerPixel > 0";
		assert pdfDocumentLayouter != null : "Precondition failed: pdfDocumentLayouter != null";
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";

		float minX_PT = pageFormat.getPixelPaddingLeft_PX() * pointsPerPixel;
		float maxX_PT = (pageFormat.getPixelWidth() - pageFormat.getPixelPaddingRight()) * pointsPerPixel;

		PdfLineTemplate pdfLineTemplate = null;

		float height_PT = pdfDocumentLayouter.getLineHeight_PX(lineIndexObject) * pointsPerPixel;
		pdfLineTemplate = tokenBoxTemplateFactory.createPdfLineTemplate(maxX_PT - minX_PT, height_PT, 0, 0);

		for (int boxIndex = 0; boxIndex < pdfDocumentLayouter.getBoxCount(lineIndexObject); boxIndex++) {
			Box box = pdfDocumentLayouter.getBox(new BoxIndex(lineIndexObject, boxIndex));
			pdfLineTemplate.addTokenBoxTemplate(tokenBoxTemplateFactory.createTokenBoxTemplate(box, page));
		}

		return pdfLineTemplate;
	}

	private void addFooter(FileTitle documentTitle, int pageIndex, int pageCount, PageFormat pageFormat,
			float pointsPerPixel, PDPageContentStream contentStream) throws IOException {
		float footerY_PT = (pageFormat.getPixelPaddingBottom() - pageFormat.FOOTER_PIXEL_PADDING) * pointsPerPixel;

		float documentTitleX_PT = (pageFormat.getPixelPaddingLeft_PX()) * pointsPerPixel;
		contentStream.setNonStrokingColor(119, 119, 153);
		contentStream.setFont(FOOTER_FONT, FOOTER_FONT_SIZE_PT);
		contentStream.beginText();
		contentStream.newLineAtOffset(documentTitleX_PT, footerY_PT);
		contentStream.showText(documentTitle.getTitleString());
		contentStream.endText();

		float pageCountX_PT = (pageFormat.getPixelWidth() / 2) * pointsPerPixel;
		String pageCountString = (pageIndex + 1) + " / " + pageCount;
		float pageCountWidth = FOOTER_FONT.getStringWidth(pageCountString);
		float pageCountOffset = (pageCountWidth / 1000 * FOOTER_FONT_SIZE_PT) / 2;
		contentStream.beginText();
		contentStream.newLineAtOffset(pageCountX_PT - pageCountOffset, footerY_PT);
		contentStream.showText(pageCountString);
		contentStream.endText();

		float copyrightX_PT = (pageFormat.getPixelWidth() - pageFormat.getPixelPaddingRight()) * pointsPerPixel;
		float copyrightWidth = FOOTER_FONT.getStringWidth(I18N.getDelegsCopyright());
		float copyrightOffset_PT = copyrightWidth / 1000 * FOOTER_FONT_SIZE_PT;
		contentStream.beginText();
		contentStream.newLineAtOffset(copyrightX_PT - copyrightOffset_PT, footerY_PT);
		contentStream.showText(I18N.getDelegsCopyright());
		contentStream.endText();
	}
}
