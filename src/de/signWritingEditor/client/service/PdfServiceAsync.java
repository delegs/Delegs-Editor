package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.model.material.Document;

public interface PdfServiceAsync {

	/**
	 * Export the given SignWritingDocument to PDF
	 * 
	 * @param doc
	 * 
	 * @return
	 * 
	 * @require doc != null
	 */
	void exportToPdf(Document doc, I18N i18n, AsyncCallback<String> callback);
}