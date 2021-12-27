package de.signWritingEditor.client.GWTClient.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.CopyToClipboardCompletionListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentLayouter;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.StandardClipboard;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;

public class DocumentEditorPasteMock extends DocumentEditor {

	public DocumentEditorPasteMock(DictionaryServiceAsync dictionaryService, DocumentServiceAsync documentService,
			PdfServiceAsync pdfService, VideoServiceAsync videoService, MediaUrlServiceAsync mediaUrlService,
			BrowserHistoryService browserHistoryService, FontSizeService fontSizeService,
			BadgeServiceClient badgeService, IdFactory idFactory, TextbasedTokenStyleFactory styleFactory,
			LocalSessionService localSessionService, RoomItem rootRoom, SignLocale defaultSignLocale,
			DocumentEditorListener listener) {
		super(dictionaryService, documentService, videoService, mediaUrlService, browserHistoryService, fontSizeService,
				badgeService, idFactory, styleFactory, localSessionService, rootRoom, defaultSignLocale, listener);
	}

	private StandardClipboard clipboard;
	private int cursorPosition;

	public void setGwtDocumentLayouter(GWTDocumentLayouter layouter) {
		setDocumentLayouter(layouter);
	}

	@Override
	protected void initLayouter() {
	}

	@Override
	protected Clipboard initClipboard() {
		if (clipboard == null) {
			clipboard = new StandardClipboard();
		}
		return clipboard;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	protected void onFreeTextVisibilityChanged() {
	}

	@Override
	protected void onSearchWordVisibilityChanged() {
	}

	@Override
	protected void onSignVisibilityChanged() {
	}

	@Override
	protected void onGlossWritingToggled() {
	}

	@Override
	protected void setCursorPositionInUi(Id tokenId, int cursorPosition) {
	}

	@Override
	protected void focusBoxInUi(Id tokenId) {
	}

	@Override
	protected int getCursorLeft(Id tokenId) {
		return 0;
	}

	@Override
	protected int getCursorPosition(Id tokenId) {
		return cursorPosition;
	}

	public void setCursorPositionInTargetToken(int cursorPosition) {
		this.cursorPosition = cursorPosition;
	}

	@Override
	protected void updateTokenMargins() {
	}

	@Override
	protected void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler) {

	}

	@Override
	protected void toggleTokenBoxSelection(Id tokenId) {

	}

	@Override
	protected boolean isFrameSelected(Id tokenId) {
		return false;
	}

	@Override
	protected void setUnderlineVisibility(boolean visible) {
	}

	@Override
	protected void setFooterText(String newText) {

	}
}
