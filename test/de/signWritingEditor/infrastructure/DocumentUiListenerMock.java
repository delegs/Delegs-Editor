package de.signWritingEditor.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;
import de.signWritingEditor.shared.model.material.SignItem;

public class DocumentUiListenerMock implements DocumentUiListener {

	@Override
	public void onDeletePrevious(Id tokenId) {
	}

	@Override
	public void onDeleteNext(Id tokenId) {
	}

	@Override
	public boolean handleForTokenSelection(Id tokenId, boolean textChanged) {
		return false;
	}

	@Override
	public void onMoveCursorToNextBox(Id tokenId, boolean select) {
	}

	@Override
	public void onSignAlternativeChanged(Id tokenId, SignItem signItem, int selectedSignIndex) {
	}

	@Override
	public void onFreeTextChanged(Id paragraphId, String freeLineText, int cursorPosition) {
	}

	@Override
	public void onFreeTextVisibilityChanged(Id paragraphId, boolean visible) {
	}

	@Override
	public void onSearchWordVisibilityChanged(Id tokenId, boolean visible) {
	}

	@Override
	public void onMoveCursorToDocumentEnd(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToDocumentTop(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToPreviousParagraph(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToNextParagraph(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToPreviousPage(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToNextPage(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToPreviousBox(Id tokenId, boolean atEnd, boolean select) {
	}

	@Override
	public void onMoveCursorLineUp(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorLineDown(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToLineEnd(Id tokenId, boolean select) {
	}

	@Override
	public void onMoveCursorToLineStart(Id tokenId, boolean select) {
	}

	@Override
	public void onCopy() {
	}

	@Override
	public boolean onCut() {
		return true;
	}

	@Override
	public void onToggleUnderlineVisibility() {
	}

	@Override
	public void onEditSign(SignItem signItem, Id tokenId) {
	}

	@Override
	public void onTextChanged(Id tokenId, String newText, int invertedCursorPosition) {
	}

	@Override
	public void onSignVisibilityChanged(Id tokenId, boolean visible) {
	}

	@Override
	public void onSelectToken(Id tokenId, boolean select) {
	}

	@Override
	public void onResizeToken(Id tokenId) {
	}

	@Override
	public void onSelectToken(Id tokenId, boolean isShiftPressed, boolean selectWholeBox) {

	}

	@Override
	public void onInsertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter) {

	}

	@Override
	public void addParagraph(Id collageId, int x, int y, int width, boolean automaticallyResize) {
	}

	@Override
	public void onSnippetPositionChanged(Id id, int x, int y, boolean snapped, int deltaX, int deltaY) {
	}

	@Override
	public void onDrawParagraphModeChanged(boolean b) {
	}

	@Override
	public void onSnippetWidthChanged(Id id, int width, boolean activate) {
	}

	@Override
	public void onToggleSnippetSelection(Id id, boolean addToExistingSelection) {
	}

	@Override
	public void onDeleteSnippet() {
	}

	@Override
	public void onDeselection(boolean deactivate) {
	}

	@Override
	public void onSelectSnippetsFromTo(Id collageId, int x, int y, int width, int height,
			boolean addToExistingSelection) {
	}

	@Override
	public void onUpdateVideoSource(Id id, String url) {
	}

	@Override
	public void onPreUpdateVideoSource(Id id, String url) {
	}

	@Override
	public void onVideoURLVisibilityChanged(Id tokenId, boolean visible) {
	}

	@Override
	public void onPaste(Id pageId, String pastedText, PasteTarget pasteTarget) {
	}

	@Override
	public void onDeleteCollage(Id collageId) {
	}

	@Override
	public void onDeleteCollageModeChanged(boolean b) {
	}

	@Override
	public void onImageUrlChanged(Id id, String newUrl) {
	}

	@Override
	public void onSelectSearchWord(Id tokenId, boolean isShiftPressed) {
	}

	@Override
	public void onInsertFreeTextLineAfterToken(Id id) {
	}

	@Override
	public void onReport(String url) {
	}

	@Override
	public void onInputContentChanged(Id tokenId, String inputContent, int cursorPosition) {
	}

	@Override
	public void onSuggestBoxHeightChanged(Id tokenId, int newHeight) {
		

	}

};