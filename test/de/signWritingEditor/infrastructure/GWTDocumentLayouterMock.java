package de.signWritingEditor.infrastructure;

import java.util.List;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentLayouter;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.Token;

public class GWTDocumentLayouterMock extends GWTDocumentLayouter {

	@SuppressWarnings("deprecation")
	public GWTDocumentLayouterMock() {
	}

	@Override
	public void addPage(PageFormat pageFormat) {
	}

	@Override
	public void addToken(Token token, boolean searchWordVisible, boolean signVisible) {
	}

	@Override
	public void updateTokenBox(Id tokenBoxId) {
	};

	@Override
	public Id getLastTokenIdInLine(Id tokenId) {
		return null;
	}

	@Override
	public void removeTokenBox(Id tokenBoxId) {
	}

	@Override
	public BoxIndex getIdBoxIndex(Id id) {
		return null;
	}

	@Override
	public PageLayout getPage(int pageIndex) {
		return null;
	}

	@Override
	public void addNewLine() {
	}

	@Override
	public void setSnippetSelection(int pageIndex, int lineIndex, boolean selection) {
	}

	@Override
	public void removeLine(LineIndex lineIndexObject) {
	}

	@Override
	public void removePage(int pageIndex) {
	}

	@Override
	public void updateSnippetZPosition(int pageIndex, int lineIndex, int maxZIndex) {
	}

	@Override
	public void insertPageBreakAfterPage(Id id, boolean isCollage, Id collageId, boolean showCollageGrid) {
	}

	@Override
	public void addSnippetToCollagePage(Id id, int pageNo, int x, int y, int width, int zIndex) {
	}

	@Override
	public void updateSnippetWidth(int pageIndex, int lineIndex, int width, boolean automatic) {
	}

	@Override
	public void addTokenToSnippet(int pageNo, int lineNo, Token token) {
	}

	@Override
	public void removeFirstSnippet(int pageIndex) {
	}

	@Override
	public void removeSnippet(int pageIndex, int snippetIndex) {
	}

	@Override
	public int getLineCount(int pageIndex) {
		return 0;
	}

	@Override
	public int getSnippetCount(int pageIndex) {
		return 0;
	}

	@Override
	public void removeBoxesBetween(Id fromBoxExcludedId, Id toBoxExcludedId) {
	}

	@Override
	public void insertTokenAfter(Id previousTokenId, Token newToken, boolean searchWordVisible, boolean signVisible) {
	}

	@Override
	protected void insertPageBreakAfter(Id previousToken, boolean isNewPageCollage, Id collageId,
			boolean showCollageGrid) {
	}

	@Override
	public void insertPageBreakAndTokenAfter(Id tokenId, boolean isFreeTextVisible, boolean searchWordVisible,
			boolean signVisible, Token newToken) {
	}

	@Override
	public void insertLineBreakAndTokenAfter(Id tokenId, boolean searchWordVisible, boolean signVisible,
			Token newToken) {
	}

	@Override
	public void updateSignsInTokenBox(Id tokenId, List<SignItem> signItems, int selectedSignIndex) {
	}

	@Override
	public void clear() {
	}

	@Override
	public Box getBox(BoxIndex boxIndex) {
		return null;
	}

	@Override
	public boolean containsTokenBox(Id tokenBoxId) {
		return false;
	}

	@Override
	public void setSnippetAutomaticResize(int pageNo, int lineNo, boolean automaticResize) {
	}

	@Override
	protected void insertLineBreakAfter(Id previousToken) {
	}

	@Override
	protected void insertPageBreakAfter(Id previousToken) {
	}

	@Override
	public void insertTokenBefore(Id nextTokenId, Token newToken, boolean searchWordLineVisible,
			boolean signLineVisible) {

	}

	@Override
	public void onInsertPage(int pageIndex, PageLayout pageLayout) {
	}

	@Override
	public int getCollagePageNumber(Id collageId) {
		return 1;
	}
}
