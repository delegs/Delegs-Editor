package de.signWritingEditor.client.service;

import java.io.IOException;

import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.model.material.Document;

public interface PdfService {

	/**
	 * Creates a PDF-document from a Document
	 * 
	 * @param document Document from which a PDF representation is created
	 * 
	 * @return The URL to the PDF file
	 * @throws IOException
	 * 
	 * @require signWritingDocument != null
	 */
	String exportToPdf(Document document, I18N i18n) throws IOException;
}