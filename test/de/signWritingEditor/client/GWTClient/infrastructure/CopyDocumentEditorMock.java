package de.signWritingEditor.client.GWTClient.infrastructure;

import java.util.List;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.CopyToClipboardCompletionListener;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.infrastructure.DocumentEditorMock;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.StandardClipboard;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;

public class CopyDocumentEditorMock extends DocumentEditorMock {
	public CopyDocumentEditorMock(DictionaryServiceAsync dictionaryService, DocumentServiceAsync documentService,
			PdfServiceAsync pdfService, VideoServiceAsync videoService, MediaUrlServiceAsync mediaUrlService,
			BrowserHistoryService browserHistoryService, FontSizeService fontSizeService,
			BadgeServiceClient badgeService, IdFactory idFactory, TextbasedTokenStyleFactory styleFactory,
			LocalSessionService localSessionService, RoomItem rootRoom, SignLocale defaultSignLocale,
			DocumentEditorListener listener) {
		super(dictionaryService, documentService, pdfService, videoService, mediaUrlService, browserHistoryService,
				fontSizeService, badgeService, idFactory, styleFactory, localSessionService, rootRoom,
				defaultSignLocale, listener);
	}

	private StandardClipboard clipboard;
	private Document dummyDocument;

	@Override
	public void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler) {
		completionHandler.onCopyToClipboardCompleted();
	}

	@Override
	public Clipboard initClipboard() {
		if (clipboard == null) {
			clipboard = new StandardClipboard();
		}
		return clipboard;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public void insertTokensAfter(Id tokenId, List<Token> tokensToInsert) {
		super.insertTokensAfter(tokenId, tokensToInsert);
	}

	@Override
	public Document getDocument() {
		return dummyDocument;
	}

	public void setDocument(Document document) {
		this.dummyDocument = document;
	}
}