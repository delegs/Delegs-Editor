package de.signWritingEditor.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor.DocumentEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor.SignModifiedListener;
import de.signWritingEditor.shared.model.domainValue.SignItemEditor;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.PdfFileItem;

public class DocumentEditorListenerMock implements DocumentEditorListener {

	@Override
	public void onEditSign(SignItemEditor signItem, SignLocale signLocale, String searchWord,
			SignModifiedListener signModifiedListener) {
	}

	@Override
	public void onInvalidSessionExceptionCaught() {
	}

	@Override
	public void onDocumentLoaded() {
	}

	@Override
	public void onPdfLoaded(PdfFileItem document) {
	}

	@Override
	public void onExceptionDuringDocumentLoaded() {
	}

	@Override
	public void onDocumentSavedAs(FolderItem folder) {
	}

}
