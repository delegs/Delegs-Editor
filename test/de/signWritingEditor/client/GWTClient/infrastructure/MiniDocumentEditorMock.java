package de.signWritingEditor.client.GWTClient.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor;
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
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.StandardClipboard;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;

public class MiniDocumentEditorMock extends DocumentEditor {
	public MiniDocumentEditorMock(DictionaryServiceAsync dictionaryService, DocumentServiceAsync documentService,
			PdfServiceAsync pdfService, VideoServiceAsync videoService, MediaUrlServiceAsync mediaUrlService,
			BrowserHistoryService browserHistoryService, FontSizeService fontSizeService,
			BadgeServiceClient badgeService, IdFactory idFactory, TextbasedTokenStyleFactory styleFactory,
			LocalSessionService localSessionService, RoomItem rootRoom, SignLocale defaultSignLocale,
			DocumentEditorListener listener) {
		super(dictionaryService, documentService, videoService, mediaUrlService, browserHistoryService, fontSizeService,
				badgeService, idFactory, styleFactory, localSessionService, rootRoom, defaultSignLocale, listener);

	}

	private String footerText;
	private boolean underlineVisible;
	private String onCopyEventText;

	@Override
	protected void updateTokenMargins() {
	}

	@Override
	public void onFreeTextVisibilityChanged() {
	}

	public boolean isUnderlineVisible() {
		return underlineVisible;
	}

	@Override
	public void onSearchWordVisibilityChanged() {
	}

	@Override
	public void setCursorPositionInUi(Id tokenId, int cursorPosition) {
	}

	@Override
	public int getCursorLeft(Id tokenId) {
		return 0;
	}

	@Override
	public void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler) {
		this.onCopyEventText = text;
		completionHandler.onCopyToClipboardCompleted();
	}

	@Override
	public void setUnderlineVisibility(boolean visible) {
		underlineVisible = visible;
	}

	@Override
	public void setFooterText(String newText) {
		footerText = newText;
	}

	public String getFooterText() {
		return footerText;
	}

	@Override
	public void toggleTokenBoxSelection(Id tokenId) {
	}

	@Override
	public void focusBoxInUi(Id tokenId) {
	}

	@Override
	public void onSignVisibilityChanged() {
	}

	@Override
	public Clipboard initClipboard() {
		return new StandardClipboard();
	}

	@Override
	protected void onGlossWritingToggled() {

	}

	@Override
	protected boolean isFrameSelected(Id tokenId) {
		return false;
	}

	public String getOnCopyEventText() {
		return onCopyEventText;
	}

	@Override
	protected int getCursorPosition(Id tokenId) {
		return 0;
	}

	public void setGwtDocumentLayouter(CollageDocumentLayouterMock gwtDocumentLayouter) {
		setDocumentLayouter(gwtDocumentLayouter);
	}

	@Override
	protected void initLayouter() {

	}

	@Override
	public void insertCollage() {
		super.insertCollage();
	}
}