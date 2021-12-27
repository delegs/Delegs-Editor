package de.signWritingEditor.server.service.pdfService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import de.signWritingEditor.shared.layout.FontMetricInterface;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;

public class PdfFontMetric implements FontMetricInterface {
	private final Map<String, PDType1Font> fontMappingByName;

	private float pxToPt;

	public PdfFontMetric() {
		this(0.75f);
	}

	public PdfFontMetric(float pointsPerPixel) {
		this.pxToPt = pointsPerPixel;
		fontMappingByName = new HashMap<>();
		fontMappingByName.put("Courier", PDType1Font.COURIER);
		fontMappingByName.put("Courier-Bold", PDType1Font.COURIER_BOLD);
		fontMappingByName.put("Courier-BoldItalic", PDType1Font.COURIER_BOLD_OBLIQUE);
		fontMappingByName.put("Courier-Italic", PDType1Font.COURIER_OBLIQUE);
		fontMappingByName.put("Helvetica", PDType1Font.HELVETICA);
		fontMappingByName.put("Helvetica-Bold", PDType1Font.HELVETICA_BOLD);
		fontMappingByName.put("Helvetica-BoldItalic", PDType1Font.HELVETICA_BOLD_OBLIQUE);
		fontMappingByName.put("Helvetica-Italic", PDType1Font.HELVETICA_OBLIQUE);
		fontMappingByName.put("Times New Roman", PDType1Font.TIMES_ROMAN);
		fontMappingByName.put("Times New Roman-Bold", PDType1Font.TIMES_BOLD);
		fontMappingByName.put("Times New Roman-BoldItalic", PDType1Font.TIMES_BOLD_ITALIC);
		fontMappingByName.put("Times New Roman-Italic", PDType1Font.TIMES_ITALIC);
	}

	@Override
	public float getActualFontSize_PT(int fontSize) {
		return fontSize * pxToPt;
	}

	public PDFont getPDFFontFromEditorFont(FontMetricSpecifier fms) {
		return fontMappingByName.get(fms.getFontAsKey());
	}

	public void setTextFormat(Color color, FontMetricSpecifier fontMetricSpecifier, float pointsPerPixel,
			PDPageContentStream contentStream) throws IOException {
		contentStream.setNonStrokingColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
		PDFont font = getPDFFontFromEditorFont(fontMetricSpecifier);

		contentStream.setFont(font, getActualFontSize_PT(fontMetricSpecifier.getFontSize().getSize()));
	}
}
