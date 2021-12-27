package de.signWritingEditor.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.model.material.Document;

public class PdfServiceAsyncMock implements PdfServiceAsync {

	@Override
	public void exportToPdf(Document doc, I18N i18n, AsyncCallback<String> callback) {
	}
}
