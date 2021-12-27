package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.List;

import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.layout.LineLayout;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;

public class GWTDocumentLayouter extends GWTDocumentLayouterBase {

	private DocumentPanel documentPanel;
	private TokenBoxFactory tokenBoxFactory;
	private PageFormat pageFormat;

	public GWTDocumentLayouter(DocumentPanel documentPanel, TokenBoxFactory tokenBoxFactory) {
		super(documentPanel);
		this.documentPanel = documentPanel;
		this.tokenBoxFactory = tokenBoxFactory;
	}

	@Deprecated
	protected GWTDocumentLayouter() {
		// Only for tests
		super();
	}

	public void insertTokenAfter(Id previousTokenId, Token newToken, boolean searchWordVisible, boolean signVisible) {
		assert previousTokenId != null : "Precondition failed: previousTokenId != null";
		assert newToken.getId() != null : "Precondition failed: newToken.getId() != null";
		assert !previousTokenId
				.equals(newToken.getId()) : "Precondition failed: !previousTokenId.equals(newToken.getId())";
		assert !containsTokenBox(newToken.getId()) : "Precondition failed: !containsTokenBox(newToken.getId())";

		BoxIndex index = this.getIdBoxIndex(previousTokenId);
		int width = getLineWidth(index.getLineIndexObject());

		TokenBox newTokenBox = tokenBoxFactory.create(newToken, searchWordVisible, signVisible, width);

		insertTokenBoxAfter(previousTokenId, newTokenBox);
		index = this.getIdBoxIndex(newTokenBox.getId());

		OverflowListLayout line = getLine(index.getLineIndexObject());
		int maxHeigth = line.getMaxSignItemTokenBoxHeight_PX();

		updateLine(line, maxHeigth, index.getLineIndexObject());
	}

	public void insertTokenBefore(Id nextTokenId, Token newToken, boolean searchWordLineVisible,
			boolean signLineVisible) {
		assert nextTokenId != null : "Precondition failed: previousTokenId != null";
		assert newToken.getId() != null : "Precondition failed: newToken.getId() != null";

		BoxIndex index = this.getIdBoxIndex(nextTokenId);
		int width = getLineWidth(index.getLineIndexObject());

		TokenBox newTokenBox = tokenBoxFactory.create(newToken, searchWordLineVisible, signLineVisible, width);

		insertTokenBoxBefore(nextTokenId, newTokenBox);
	}

	public void insertLineBreakAndTokenAfter(Id tokenId, boolean searchWordVisible, boolean signVisible,
			Token newToken) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert newToken.getId() != null : "Precondition failed: newToken.getId() != null";

		BoxIndex index = this.getIdBoxIndex(tokenId);
		int width = getLineWidth(index.getLineIndexObject());

		insertLineBreakAfter(tokenId);

		addTokenToNewLine(tokenBoxFactory.create(newToken, searchWordVisible, signVisible, width), tokenId);
	}

	public void insertPageBreakAndTokenAfter(Id tokenId, boolean isFreeTextVisible, boolean searchWordVisible,
			boolean signVisible, Token newToken) {
		assert newToken.getId() != null : "Precondition failed: newToken.getId() != null";
		assert tokenId != null : "Precondition failed: tokenId != null";

		BoxIndex index = this.getIdBoxIndex(tokenId);
		int width = getLineWidth(index.getLineIndexObject());

		insertPageBreakAfter(tokenId);

		addTokenToNewPage(tokenBoxFactory.create(newToken, searchWordVisible, signVisible, width), tokenId);
	}

	public void compensateNextLineForToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsIdBox(tokenId) : "Precondition failed: containsIdBox(tokenId)";

		BoxIndex boxIndexObject = getIdBoxIndex(tokenId);
		int pageIndex = boxIndexObject.getPageIndex();
		int snippetIndex = boxIndexObject.getSnippetIndex();
		int lineIndex = boxIndexObject.getLineIndex() + 1;
		compensate(new LineIndex(pageIndex, snippetIndex, lineIndex));
	}

	public void addToken(Token newToken, boolean searchWordVisible, boolean signVisible) {
		assert newToken.getId() != null : "Precondition failed: newToken.getId() != null";

		int pageIndex = getPageCount() - 1;
		int lineIndex = getLineCount(pageIndex) - 1;
		LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
		int lineWidth = getLineWidth(lineIndexObject);

		this.addToken(tokenBoxFactory.create(newToken, searchWordVisible, signVisible, lineWidth));
	}

	public void updateSignsInTokenBox(Id tokenId, List<SignItem> signItems, int selectedSignIndex) {
		assert signItems != null : "Precondition failed: signItems != null";
		// !signs.isEmpty => selectedSignIndex must be within bounds:
		assert signItems.isEmpty() || (selectedSignIndex >= 0 && selectedSignIndex < signItems
				.size()) : "Precondition failed: signs.isEmpty() || (selectedSignIndex >= 0 && selectedSignIndex < signs.size())";

		TokenBox tokenBox = getTokenBoxForId(tokenId);
		assert tokenBox instanceof SignItemTokenBox : "Assertion failed: box instanceof TokenBox";
		SignItemTokenBox signItemtokenBox = (SignItemTokenBox) tokenBox;

		signItemtokenBox.setSigns(signItems);

		if (!signItems.isEmpty()) {
			signItemtokenBox.selectSign(selectedSignIndex);
		}

		updateTokenBox(signItemtokenBox);
	}

	public void changeSignAlternativeFor(Id tokenId, int selectedSignIndex) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		TokenBox tokenBox = getTokenBoxForId(tokenId);
		assert tokenBox instanceof SignItemTokenBox : "Assertion failed: box instanceof TokenBox";
		SignItemTokenBox signItemTokenBox = (SignItemTokenBox) tokenBox;

		signItemTokenBox.selectSign(selectedSignIndex);

		updateTokenBox(signItemTokenBox);
	}

	public void setFreeTextBoxVisibility(Id tokenBoxId, boolean visible) {
		assert tokenBoxId != null : "Precondition failed: paragraphId != null";
		assert containsFreeTextBox(tokenBoxId) : "Precondition failed: containsFreeTextBox(paragraphId)";

		TokenBox tokenBox = getTokenBoxForId(tokenBoxId);

		if (tokenBox instanceof FreeTextTokenBox) {
			FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) tokenBox;
			freeTextTokenBox.setVisibility(visible);
		}

		updateTokenBox(tokenBox);
	}

	public void updateTokenBox(Id tokenBoxId) {
		updateTokenBox(getTokenBoxForId(tokenBoxId));
	}

	public void setSearchWordVisibility(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		TokenBox box = getTokenBoxForId(tokenId);
		if (box instanceof SignItemTokenBox) {
			SignItemTokenBox signItemTokenBox = (SignItemTokenBox) box;
			signItemTokenBox.setSearchWordVisibility(visible);
			updateTokenBox(signItemTokenBox);
		}
	}

	public void setSignVisibility(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		TokenBox tokenBox = getTokenBoxForId(tokenId);
		if (tokenBox instanceof SignItemTokenBox) {
			SignItemTokenBox signItemTokenBox = (SignItemTokenBox) tokenBox;
			signItemTokenBox.setSignVisibility(visible);
			updateTokenBox(signItemTokenBox);
		}
	}

	public boolean containsFreeTextBox(Id paragraphId) {
		assert paragraphId != null : "Precondition failed: paragraphId != null";

		for (int pageIndex = 0; pageIndex < getPageCount(); pageIndex++) {
			for (int lineIndex = 0; lineIndex < getLineCount(pageIndex); lineIndex++) {
				LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);

				for (int boxIndex = 0; boxIndex < getBoxCount(lineIndexObject); boxIndex++) {
					Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
					if (box instanceof FreeTextTokenBox) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void onInsertPage(int pageIndex, PageLayout pageLayout) {
		if (pageLayout instanceof CollagePageLayout) {
			CollagePageLayout collageLayout = (CollagePageLayout) pageLayout;

			documentPanel.insertNewCollage(pageIndex, collageLayout.getPageDimension(),
					collageLayout.getCollagePageId(), collageLayout.showCollageGrid());
		} else {
			documentPanel.insertNewPage(pageIndex, pageLayout.getPageDimension());
		}
	}

	@Override
	public void onRemovePage(int pageIndex) {
		documentPanel.removePage(pageIndex);
	}

	@Override
	public void onInsertNewLine(LineIndex lineIndexObject, Orientation pageOrientation) {
		documentPanel.insertNewLine(lineIndexObject, pageOrientation);
	}

	@Override
	public void onRemoveLine(LineIndex lineIndexObject) {
		documentPanel.removeLine(lineIndexObject);
	}

	@Override
	public void onRemoveSnippet(int pageIndex, int snippetIndex) {
		documentPanel.removeSnippet(pageIndex, snippetIndex);
	}

	@Override
	public void onInsertBox(Box box, BoxIndex boxIndexObject, Orientation pageOrientation) {
		if (box instanceof TokenBox) {
			documentPanel.insertTokenBoxWidget((TokenBox) box, boxIndexObject);
			updateLineHeight(boxIndexObject.getLineIndexObject());
		} else {
			throw new RuntimeException("unexpected box type");
		}
	}

	@Override
	public void onRemoveBox(BoxIndex boxIndexObject) {

		documentPanel.removeTokenBoxWidget(boxIndexObject);

	}

	@Override
	public void onSetBox(Box box, BoxIndex boxIndexObject) {
		assert box != null : "Precondition failed: box != null";
		assert box instanceof TokenBox : "Precondition failed: box instanceof TokenBox";

		documentPanel.setBox(box, boxIndexObject);
		updateLineHeight(boxIndexObject.getLineIndexObject());
	}

	@Override
	public void onMovePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength) {
		documentPanel.movePageSegment(fromLineIndexObject, toLineIndexObject, segmentLength);

	}

	@Override
	public void onMoveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength) {
		documentPanel.moveLineSegment(fromBoxIndexObject, toBoxIndexObject, segmentLength);
		updateLineHeight(fromBoxIndexObject.getLineIndexObject());
		updateLineHeight(toBoxIndexObject.getLineIndexObject());
	}

	@Override
	public void onMoveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject) {
		documentPanel.moveLine(fromLineIndexObject, toLineIndexObject);
	}

	public boolean isSignVisible(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		boolean result = false;
		TokenBox tokenBox = getTokenBoxForId(tokenId);
		if (tokenBox instanceof SignItemTokenBox) {
			SignItemTokenBox signItemTokenBox = (SignItemTokenBox) tokenBox;
			result = signItemTokenBox.isSignVisible();
		}
		return result;
	}

	public TokenBox getLastToken() {
		int pageIndex = getPageCount() - 1;
		OverflowListLayout line = getLine(new LineIndex(pageIndex, getLineCount(pageIndex) - 1));
		TokenBox token = (TokenBox) line.getBox(line.getBoxCount() - 1);
		return token;
	}

	public void setBackgroundOfToken(Id id, Color color) {
		BoxIndex index = getIdBoxIndex(id);
		documentPanel.changeBackgroundColor(index, color);
	}

	public void setTextBackgroundOfToken(Id tokenId, Color color) {
		BoxIndex index = getIdBoxIndex(tokenId);
		documentPanel.changeTextBackgroundColor(index, color);
	}

	public void reloadVideoToken(Id id) {
		BoxIndex index = getIdBoxIndex(id);
		documentPanel.reloadVideoToken(index);
	}

	public void loadVideoNotFoundInVideoToken(Id id) {
		BoxIndex index = getIdBoxIndex(id);
		documentPanel.loadVideoNotFoundInVideoToken(index);
	}

	public void setVideoToConvertingTillLoaded(Id id) {
		BoxIndex index = getIdBoxIndex(id);
		documentPanel.setVideoToConvertingTillLoaded(index);
	}

	public void setVideoTokenBoxVisibility(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: videoTokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(paragraphId)";
		assert getTokenBoxForId(
				tokenId) instanceof VideoTokenBox : "Precondition failed: getTokenBoxForId(tokenId) instanceof VideoTokenBox";

		TokenBox tokenBox = getTokenBoxForId(tokenId);

		if (tokenBox instanceof VideoTokenBox) {
			VideoTokenBox videoTokenBox = (VideoTokenBox) tokenBox;
			videoTokenBox.setURLVisible(visible);
			updateTokenBox(tokenBox);
		}
	}

	public void updateTokenBoxMargin(final Id id) {
		assert id != null : "Precondition failed: id != null";
		updateTokenBoxMargin(getTokenBoxForId(id));
	}

	@Deprecated
	public void removeFirstSnippet(int pageIndex) {
		if (getPage(pageIndex).getBoxCount() > 0 && !(getPage(pageIndex).getBox(0) instanceof SnippetLayout)) {
			getPage(pageIndex).removeBox(0);
			documentPanel.removeSnippet(pageIndex, 0);
		}
	}

	public void addSnippetToCollagePage(Id id, int pageIndex, int x, int y, int width, int zIndex) {
		PageLayout page = getPage(pageIndex);
		page.addBox(new SnippetLayout(x, y, zIndex, width, page.getMaxWidth()));
		documentPanel.insertNewSnippet(id, pageIndex, page.getMaxWidth(), page.getMaxHeight(), x, y, width, zIndex);
	}

	public void addTokenToSnippet(int pageIndex, int snippetIndex, Token token) {
		int lineWidth = getSnippetWidth(pageIndex, snippetIndex);
		TokenBox tokenBox = tokenBoxFactory.create(token, true, true, lineWidth);

		SnippetLayout snippet = getSnippet(pageIndex, snippetIndex);
		int lastLineIndex = snippet.getBoxCount() - 1;
		int lastBoxIndex = snippet.getLine(lastLineIndex).getBoxCount();

		snippet.getLine(lastLineIndex).addBox(tokenBox);

		assert containsIdBox(token.getId()) : "Postcondition failed: containsIdBox(token.getId())";

		BoxIndex boxIndexObject = new BoxIndex(pageIndex, snippetIndex, lastLineIndex, lastBoxIndex);
		documentPanel.insertTokenBoxWidget(tokenBox, boxIndexObject);
	}

	public void updateSnippetWidth(int pageIndex, int snippetIndex, int width, boolean automatic) {
		SnippetLayout snippetLayout = (SnippetLayout) getPage(pageIndex).getBox(snippetIndex);
		snippetLayout.setWidth(width);
		if (!automatic) {
			snippetLayout.setAutomaticResize(false);
			documentPanel.setSnippetAutomaticResizeActive(pageIndex, snippetIndex, false);
		}

		for (int lineIndex = 0; lineIndex < snippetLayout.getBoxCount(); lineIndex++) {
			LineLayout lineLayout = (LineLayout) snippetLayout.getBox(lineIndex);
			lineLayout.setOverflowThreshold(snippetLayout.getInnerWidth_PX());

			for (int boxIndex = 0; boxIndex < lineLayout.getBoxCount(); boxIndex++) {
				if (lineLayout.getBox(boxIndex) instanceof FreeTextTokenBox) {
					FreeTextTokenBox box = (FreeTextTokenBox) lineLayout.getBox(boxIndex);

					box.setParagraphWidth(snippetLayout.getInnerWidth_PX());
					setBox(box, getIdBoxIndex(box.getId()));
				}
			}
		}

		LineIndex firstLineIndexObject = new LineIndex(pageIndex, snippetIndex, 0);

		if (getLineCount(firstLineIndexObject) > 0) {
			compensateCollagePage(firstLineIndexObject);
		}

		for (int lineIndex = 0; lineIndex < snippetLayout.getBoxCount(); lineIndex++) {
			LineIndex lineIndexObject = new LineIndex(pageIndex, snippetIndex, lineIndex);
			OverflowListLayout line = getLine(lineIndexObject);
			updateLine(line, line.getMaxSignItemTokenBoxHeight_PX(), lineIndexObject);
		}
	}

	public void updateSnippetPosition(int pageIndex, int snippetIndex, int x, int y) {
		assert getSnippet(pageIndex,
				snippetIndex) instanceof SnippetLayout : "Precondition failed: getLine(pageIndex, lineIndex) instanceof SnippetLayout";
		SnippetLayout snippetLayout = (SnippetLayout) getSnippet(pageIndex, snippetIndex);
		snippetLayout.setX(x);
		snippetLayout.setY(y);
		documentPanel.setSnippetPosition(pageIndex, snippetIndex, x, y);
	}

	public void setSnippetSelection(int pageIndex, int snippetIndex, boolean selection) {
		documentPanel.setSnippetSelection(pageIndex, snippetIndex, selection);
	}

	public void setSnippetAutomaticResize(int pageIndex, int snippetIndex, boolean automaticResize) {
		documentPanel.setSnippetAutomaticResize(pageIndex, snippetIndex, automaticResize);

	}

	/**
	 * Searches for the page number for a free positionable page by its id
	 * 
	 * @param collageId the page id
	 * @return index of the page if pageId is contained -1 otherwise
	 */
	public int getCollagePageNumber(Id collageId) {
		int result = -1;

		for (int i = 0; i < getPageCount(); i++) {
			if (getPage(i) instanceof CollagePageLayout) {
				if (((CollagePageLayout) getPage(i)).getCollagePageId().equals(collageId)) {
					result = i;
					break;
				}
			}
		}
		assert result >= -1 : "Precondition failed: result>=-1";
		assert result < getPageCount() : "Precondition failed: result<getPageCount()";

		return result;
	}

	private int getLineWidth(LineIndex lineIndexObject) {
		return getLine(lineIndexObject).getInnerWidth_PX();
	}

	private int getSnippetWidth(int pageIndex, int snippetIndex) {
		return getSnippet(pageIndex, snippetIndex).getInnerWidth_PX();
	}

	public void updateSnippetZPosition(int pageIndex, int lineIndex, int maxZIndex) {
		documentPanel.setSnippetZIndex(pageIndex, lineIndex, maxZIndex);
	}

	public void insertPageBreakAfterPage(Id id, boolean createCollage, Id collageId, boolean showCollageGrid) {
		BoxIndex index = getIdBoxIndex(id);

		int pageIndex = index.getPageIndex();
		int lineIndex = getLineCount(index.getLineIndexObject()) - 1;
		LineIndex lineIndexObject = new LineIndex(pageIndex, index.getSnippetIndex(), lineIndex);
		insertPageBreak(new BoxIndex(lineIndexObject, getBoxCount(lineIndexObject)), createCollage, collageId,
				showCollageGrid);
	}

	public void addNewLineToPage(int pageIndex) {
		PageLayout page = getPage(pageIndex);
		page.addBox(new LineLayout(page.getOrientation(), page.getLineOverflowThreshold()));
	}

	public void insertNewPageAfterPage(Id id, int pageIndex, Token newToken) {
		insertPageBreakAfterPage(id, false, null, false);
		assert getLineCount(pageIndex + 1) >= 1 : "Precondition failed: getLineCount(pageIndex+1) >= 1";
		TokenBox box = tokenBoxFactory.create(newToken, true, true, (int) getPage(pageIndex + 1).getWidth_PX());
		insertBox(box, new BoxIndex(pageIndex + 1, 0, 0));
	}

	public void changeCollageGridVisibility(List<Id> collageIds, boolean showGrid) {

		for (Id id : collageIds) {

			int pageNumber = getCollagePageNumber(id);

			assert pageNumber >= 0 : "Precondition failed: pageNumber >= 0";
			assert getPageCount() > pageNumber : "Precondition failed: getPageCount() > pageNumber";
			assert getPage(
					pageNumber) instanceof CollagePageLayout : "Precondition failed: getPage(pageNumber) instanceof CollagePageLayout";

			((CollagePageLayout) getPage(pageNumber)).setCollageGridVisibility(showGrid);
			documentPanel.changeCollageGridVisibility(pageNumber, showGrid);
		}
	}

	public void scrollToTopOfPageWithNumber(int pageIndex) {
		documentPanel.scrollToPage(pageIndex);
	}

	public void setPageFormat(PageFormat pageFormat) {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		this.pageFormat = pageFormat;
		tokenBoxFactory.setPageHeight(pageFormat.getPixelInnerHeight());
	}

	public void changeTokenBoxMaxWidthInSnippet(Id id, int newMaxWidth) {
		TokenBox tokenbox = this.getTokenBoxForId(id);

		assert (tokenbox instanceof VideoTokenBox
				|| tokenbox instanceof ImageTokenBox) : "Precondition failed: Tokenbox isn't a Image or a VideoTokenBox";

		if (tokenbox instanceof VideoTokenBox) {
			((VideoTokenBox) tokenbox).setMaxWidth(newMaxWidth);
		} else {
			((ImageTokenBox) tokenbox).setMaxWidth(newMaxWidth);
		}
	}

}