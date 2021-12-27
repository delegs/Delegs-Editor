package de.signWritingEditor.infrastructure;

import java.util.List;

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
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;

public class DocumentEditorMock extends DocumentEditor {

	public DocumentEditorMock(DictionaryServiceAsync dictionaryService, DocumentServiceAsync documentService,
			PdfServiceAsync pdfService, VideoServiceAsync videoService, MediaUrlServiceAsync mediaUrlService,
			BrowserHistoryService browserHistoryService, FontSizeService fontSizeService,
			BadgeServiceClient badgeService, IdFactory idFactory, TextbasedTokenStyleFactory tokenStyleFactory,
			LocalSessionService localSessionService, RoomItem rootRoom, SignLocale defaultSignLocale,
			DocumentEditorListener listener) {
		super(dictionaryService, documentService, videoService, mediaUrlService, browserHistoryService, fontSizeService,
				badgeService, idFactory, tokenStyleFactory, localSessionService, rootRoom, defaultSignLocale, listener);
	}

	@Override
	protected void initLayouter() {
	}

	@Override
	protected Clipboard initClipboard() {
		return null;
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
		return 0;
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

	@Override
	public void openDocument(Document document, DocumentItem optionalDocumentItem, FolderItem folderItemOfDocument,
			RoomItem roomContainingDocument) {
	};

	@Override
	public void updateAllTokensWithWord(String word) {
	}

	@Override
	public boolean isAutomaticFreeTextLineEnabled() {
		return false;
	}

	@Override
	public void setDocumentItem(DocumentItem optionalDocumentItem) {
	}

	@Override
	public Document getDocument() {
		return null;
	}

	@Override
	public boolean isDocumentNeverSaved() {
		return false;
	}

	@Override
	public boolean hasUnsavedChanges() {
		return false;
	}

	@Override
	public void toggleUnderlineVisibility() {
	}

	@Override
	public void setDocumentTitle(FileTitle fileTitle) {
	}

	@Override
	public void updateLocallyModifiedSign(SimpleSign modifiedSign, Id tokenId) {
	}

	@Override
	public void updateModifiedSign(SimpleSign modifiedSign, Id tokenId) {
	}

	@Override
	public void updateSignInLocalDictionary(SimpleSign modifiedSign) {
	}

	@Override
	public void saveSignInLocalDictionary(SimpleSign modifiedSign) {
	}

	@Override
	public Id getCurrentCursorTokenId() {
		return null;
	}

	@Override
	public void handleAddSnippetToDocument(Id collageId, int x, int y, int width, boolean automaticallyResize) {
	}

    @Override
	public void handleAddNormalPage() {
	}

	@Override
	protected void handleSelectSnippetsFromTo(Id collageId, int x, int y, int width, int height,
			boolean addToExistingSelection) {
	}

	@Override
	protected void insertTokensAfter(Id tokenId, List<Token> tokensToInsert) {
	}
}
