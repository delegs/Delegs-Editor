package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import de.signWritingEditor.shared.layout.AbstractIdBox;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.CollagePageLayout;
import de.signWritingEditor.shared.layout.ContinuousPageLayout;
import de.signWritingEditor.shared.layout.DocumentLayout;
import de.signWritingEditor.shared.layout.IdBox;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.layout.LineLayout;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.layout.PageLayout;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.layout.VideoTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.TokenBox;

public abstract class GWTDocumentLayouterBase extends DocumentLayout {

	private DocumentPanel documentPanel;

	@Deprecated
	GWTDocumentLayouterBase() {
		// Only for tests
	}

	GWTDocumentLayouterBase(DocumentPanel documentPanel) {
		this.documentPanel = documentPanel;
	}

	protected void updateLineHeight(LineIndex lineIndexObject) {
		OverflowListLayout line = getLine(lineIndexObject);
		int height = line.getHeight_PX() - line.getMarginBottom_PX() - line.getMarginTop_PX();
		documentPanel.updateLineHeight(lineIndexObject, height);
	}

	public void addNewLine() {
		int pageIndex = getPageCount() - 1;
		int lineIndex = getLineCount(pageIndex);
		LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
		insertNewLine(lineIndexObject);
	}

	public void addPage(PageFormat pageFormat, boolean isCollage, Id collageId, boolean showCollageGrid) {
		insertNewPage(pageFormat, getPageCount(), isCollage, collageId, showCollageGrid);
	}

	public void addPage(PageFormat pageFormat) {
		insertNewPage(pageFormat, getPageCount(), false, null, false);
	}

	protected void addToken(TokenBox newTokenBox) {
		assert newTokenBox.getId() != null : "Precondition failed: newToken.getId() != null";
		assert !containsTokenBox(newTokenBox.getId()) : "Precondition failed: !containsTokenBox(newToken.getId())";

		int pageIndex = getPageCount() - 1;
		int lineIndex = getLineCount(pageIndex) - 1;
		LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
		int boxIndex = getBoxCount(lineIndexObject);

		insertTokenBox(newTokenBox, new BoxIndex(lineIndexObject, boxIndex));
	}

	protected void addTokenToNewLine(TokenBox newTokenBox, Id previousToken) {
		assert newTokenBox.getId() != null : "Precondition failed: newToken.getId() != null";
		assert !containsTokenBox(newTokenBox.getId()) : "Precondition failed: !containsTokenBox(newToken.getId())";

		BoxIndex boxIndexObject = this.getIdBoxIndex(previousToken);
		int pageIndex = boxIndexObject.getPageIndex();
		int lineIndex = boxIndexObject.getLineIndex() + 1;
		int boxIndex = 0;

		LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
		insertTokenBox(newTokenBox, new BoxIndex(lineIndexObject, boxIndex));
	}

	protected void addTokenToNewPage(TokenBox newTokenBox, Id previousTokenId) {
		BoxIndex boxIndexObject = this.getIdBoxIndex(previousTokenId);
		int pageIndex = boxIndexObject.getPageIndex() + 1;
		addTokenToNewPage(newTokenBox, pageIndex);
	}

	protected void addTokenToNewPage(TokenBox newTokenBox, int pageIndex) {
		insertTokenBox(newTokenBox, new BoxIndex(pageIndex, 0, 0));
	}

	public void clear() {
		while (getPageCount() > 0) {
			removePage(0);
		}
	}

	public boolean containsIdBox(Id id) {
		assert id != null : "Precondition failed: id != null";

		boolean result = false;

		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount && !result; pageIndex++) {
			PageLayout page = getPage(pageIndex);

			if (page instanceof ContinuousPageLayout) {
				result = isInPage(id, pageIndex);
			} else {
				result = isInCollage(id, pageIndex);
			}
		}

		return result;
	}

	private boolean isInPage(Id id, int pageIndex) {
		for (int lineIndex = 0, lineCount = getLineCount(pageIndex); lineIndex < lineCount; lineIndex++) {
			LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
			for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); boxIndex < boxCount; boxIndex++) {
				Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
				if (box instanceof AbstractIdBox && ((AbstractIdBox) box).getId().equals(id)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isInCollage(Id id, int pageIndex) {
		for (int snippetIndex = 0, snippenCount = getSnippetCount(
				pageIndex); snippetIndex < snippenCount; snippetIndex++) {
			SnippetLayout snippet = getSnippet(pageIndex, snippetIndex);

			for (int lineIndex = 0; lineIndex < snippet.getBoxCount(); lineIndex++) {
				LineLayout line = snippet.getLine(lineIndex);

				for (int boxIndex = 0, boxCount = line.getBoxCount(); boxIndex < boxCount; boxIndex++) {
					Box box = line.getBox(boxIndex);

					if (box instanceof AbstractIdBox && ((AbstractIdBox) box).getId().equals(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean containsTokenBox(Id tokenBoxId) {

		boolean result = containsIdBox(tokenBoxId);
		if (result) {
			BoxIndex boxIndexObject = getIdBoxIndex(tokenBoxId);

			Box box = getBox(boxIndexObject);

			result = result && box instanceof TokenBox;
		}
		return result;
	}

	public CursorPosition getCursorPositionAbove(Id tokenId, int left) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";
		assert !isInFirstTokenBoxLine(tokenId) : "Precondition failed: !isInFirstTokenBoxLine(tokenId)";

		BoxIndex boxIndex = getIdBoxIndex(tokenId);
		int pageIndex = boxIndex.getPageIndex();
		int lineIndex;
		int snippetIndex = -1;

		if (isCollage(pageIndex)) {
			snippetIndex = boxIndex.getSnippetIndex();
		}
		lineIndex = boxIndex.getLineIndex();

		// Start looking for token boxes in previous line:

		int[] temp = getPrivouseLine(lineIndex, snippetIndex, pageIndex);
		// need temp because of call-by-value
		lineIndex = temp[0];
		snippetIndex = temp[1];
		pageIndex = temp[2];

		LineIndex lineId;

		if (isCollage(pageIndex)) {
			lineId = new LineIndex(pageIndex, snippetIndex, lineIndex);
		} else {
			lineId = new LineIndex(pageIndex, lineIndex);
		}

		LineIndex previousTokenBoxLineIndex = getPreviousTokenBoxLineIndex(lineId);

		return documentPanel.getCursorPositionInLineAt(previousTokenBoxLineIndex, left);
	}

	private int[] getPrivouseLine(int lineIndex, int snippetIndex, int pageIndex) {
		int[] result = new int[3];
		lineIndex--;
		while (lineIndex < 0) {
			if (isCollage(pageIndex)) {
				snippetIndex--;
				if (snippetIndex >= 0) {
					lineIndex = getSnippet(pageIndex, snippetIndex).getBoxCount() - 1;
				} else {
					while (snippetIndex < 0) {
						pageIndex--;
						if (!isCollage(pageIndex)) {
							return getPrivouseLine(getLineCount(pageIndex), -1, pageIndex);
						}
						snippetIndex = getSnippetCount(pageIndex);
					}
				}
			} else {
				pageIndex--;
				if (isCollage(pageIndex)) {
					snippetIndex = getSnippetCount(pageIndex) - 1;
					if (snippetIndex >= 0) {
						return getPrivouseLine(getSnippet(pageIndex, snippetIndex).getBoxCount(), snippetIndex,
								pageIndex);
					}
				} else {
					lineIndex = getLineCount(pageIndex) - 1;
				}
			}
		}

		result[0] = lineIndex;
		result[1] = snippetIndex;
		result[1 + 1] = pageIndex;

		assert result.length == 3 : "prediction failed result.length != 3";
		return result;
	}

	public CursorPosition getCursorPositionBelow(Id tokenId, int left) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";
		assert !isInLastTokenBoxLine(tokenId) : "Precondition failed: !isInLastTokenBoxLine(tokenId)";

		BoxIndex boxIndex = getIdBoxIndex(tokenId);
		int pageIndex = boxIndex.getPageIndex();
		int snippetIndex = boxIndex.getSnippetIndex();
		int lineIndex = boxIndex.getLineIndex();

		// Start looking for token boxes in next line:
		int[] temp = getNextLine(lineIndex, snippetIndex, pageIndex);

		lineIndex = temp[0];
		snippetIndex = temp[1];
		pageIndex = temp[2];

		if (pageIndex == documentPanel.getPageCount()) {
			pageIndex = boxIndex.getPageIndex();
			if (isCollage(pageIndex)) {
				snippetIndex = boxIndex.getSnippetIndex();
			}
			lineIndex = boxIndex.getLineIndex();
		}

		LineIndex lineId = null;

		if (isCollage(pageIndex)) {
			lineId = new LineIndex(pageIndex, snippetIndex, lineIndex);
		} else {
			lineId = new LineIndex(pageIndex, lineIndex);
		}

		LineIndex nextTokenBoxLineIndex = getNextTokenBoxLineIndex(lineId);

		return documentPanel.getCursorPositionInLineAt(nextTokenBoxLineIndex, left);
	}

	private int[] getNextLine(int lineIndex, int snippetIndex, int pageIndex) {
		int[] result = new int[3];
		lineIndex++;
		boolean firstGo = true;

		while (pageIndex < documentPanel.getPageCount()
				&& lineIndex > getMaxLineCount(pageIndex, snippetIndex, lineIndex)) {
			if (isCollage(pageIndex)) {
				if (firstGo) {
					snippetIndex++;
				}
				lineIndex = 0;
				while (snippetIndex > getSnippetCount(pageIndex) - 1) {
					pageIndex++;
					if (!isCollage(pageIndex)) {
						// -1 'cause of the start increment and second -1 'cause
						// of invalid value
						return getNextLine(-1, -1, pageIndex);
					}
					firstGo = false;
					snippetIndex = 0;
					if (0 > getSnippetCount(pageIndex)
							&& getSnippet(pageIndex, snippetIndex).getBoxCount() < lineIndex) {
						lineIndex = -1;
					}
				}
			} else {
				pageIndex++;
				if (isCollage(pageIndex)) {
					snippetIndex = 0;
					while (isCollage(pageIndex) && getSnippetCount(pageIndex) <= 0) {
						pageIndex++;
					}
					if (isCollage(pageIndex)) {
						return getNextLine(-1, snippetIndex, pageIndex);
					}
				}
				lineIndex = 0;
			}
		}

		result[0] = lineIndex;
		result[1] = snippetIndex;
		result[1 + 1] = pageIndex;

		assert result.length == 3 : "prediction failed result.length != 3";
		return result;
	}

	private int getMaxLineCount(int pageIndex, int snippetIndex, int lineIndex) {
		if (isCollage(pageIndex)) {
			return getSnippet(pageIndex, snippetIndex).getBoxCount() - 1;
		}
		return getLineCount(pageIndex) - 1;
	}

	public Id getFirstTokenIdFromPreviousPage(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";
		assert !isOnFirstPageWithTokenBoxes(tokenId) : "Precondition failed: !isOnLastPageWithTokenBoxes(tokenId)";

		int prevPage = getIdBoxIndex(tokenId).getPageIndex() - 1;
		while (!pageHasTokens(prevPage)) {
			prevPage--; // If the prev Page is an empty collage it must be
						// skipped, because there is no token to set the cursor
		}

		LineIndex lineIndex;
		if (isCollage(prevPage)) {
			lineIndex = new LineIndex(prevPage, 0, 0);
		} else {
			lineIndex = new LineIndex(prevPage, 0);
		}

		LineIndex nextTokenBoxLineIndex = getNextTokenBoxLineIndex(lineIndex);
		BoxIndex firstTokenFromPreviousPageIndex = new BoxIndex(nextTokenBoxLineIndex, 0);

		return ((IdBox) getBox(firstTokenFromPreviousPageIndex)).getId();
	}

	public Id getFirstTokenIdInLine(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		BoxIndex boxIndex = getIdBoxIndex(tokenId);
		BoxIndex firstTokenInLineBoxIndex = new BoxIndex(boxIndex.getLineIndexObject(), 0);

		return ((IdBox) getBox(firstTokenInLineBoxIndex)).getId();
	}

	public BoxIndex getIdBoxIndex(Id id) {
		assert id != null : "Precondition failed: id != null";
		assert containsIdBox(id) : "Precondition failed: containsIdBox(id)";

		BoxIndex result = null;

		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount && result == null; pageIndex++) {
			PageLayout page = getPage(pageIndex);

			if (page instanceof ContinuousPageLayout) {
				result = getIdBoxIndexInContinuousPage(id, pageIndex);
			} else {
				result = getIdBoxIndexInCollagePage(id, pageIndex);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private BoxIndex getIdBoxIndexInContinuousPage(Id id, int pageIndex) {
		for (int lineIndex = 0, lineCount = getLineCount(pageIndex); lineIndex < lineCount; lineIndex++) {
			LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
			for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); boxIndex < boxCount; boxIndex++) {
				BoxIndex idBoxIndex = new BoxIndex(lineIndexObject, boxIndex);
				Box box = getBox(idBoxIndex);
				if (box instanceof AbstractIdBox && ((AbstractIdBox) box).getId().equals(id)) {
					return idBoxIndex;
				}
			}
		}
		return null;
	}

	private BoxIndex getIdBoxIndexInCollagePage(Id id, int pageIndex) {
		for (int snippetIndex = 0, snippenCount = getSnippetCount(
				pageIndex); snippetIndex < snippenCount; snippetIndex++) {
			SnippetLayout snippet = getSnippet(pageIndex, snippetIndex);

			for (int lineIndex = 0; lineIndex < snippet.getBoxCount(); lineIndex++) {
				LineLayout line = snippet.getLine(lineIndex);

				for (int boxIndex = 0, boxCount = line.getBoxCount(); boxIndex < boxCount; boxIndex++) {
					Box box = line.getBox(boxIndex);

					if (box instanceof AbstractIdBox && ((AbstractIdBox) box).getId().equals(id)) {
						return new BoxIndex(pageIndex, snippetIndex, lineIndex, boxIndex);
					}
				}
			}
		}
		return null;
	}

	public Id getLastTokenIdInLine(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		BoxIndex boxIndex = getIdBoxIndex(tokenId);
		BoxIndex lastTokenInLineIndex = new BoxIndex(boxIndex.getLineIndexObject(),
				getBoxCount(boxIndex.getLineIndexObject()) - 1);
		return ((IdBox) getBox(lastTokenInLineIndex)).getId();
	}

	public Id getNextTokenIdNotOnThisPage(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";
		assert !isOnLastPageWithTokenBoxes(tokenId) : "Precondition failed: !isOnLastPageWithTokenBoxes(tokenId)";

		int nextPage = getIdBoxIndex(tokenId).getPageIndex() + 1;
		while (!pageHasTokens(nextPage)) {
			nextPage++; // If the next Page is an empty collage it must be
						// skipped, because there is no token to set the cursor
		}

		LineIndex lineIndex;
		if (isCollage(nextPage)) {
			CollagePageLayout cPL = (CollagePageLayout) getPage(nextPage);
			int snippetsIdWithLowestY = cPL.getTopMostSnippetID();
			lineIndex = new LineIndex(nextPage, snippetsIdWithLowestY, 0);
		} else {
			lineIndex = new LineIndex(nextPage, 0);
		}

		LineIndex nextTokenBoxLineIndex = getNextTokenBoxLineIndex(lineIndex);
		BoxIndex nextTokenBoxNotOnPageIndex = new BoxIndex(nextTokenBoxLineIndex, 0);

		return ((IdBox) getBox(nextTokenBoxNotOnPageIndex)).getId();
	}

	private boolean pageHasTokens(int pageIndex) {
		if (isCollage(pageIndex) && getSnippetCount(pageIndex) <= 0) {
			return false;
		}
		return true;
	}

	private LineIndex getNextTokenBoxLineIndex(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		LineIndex result = null;

		for (int nextTokenBoxPageIndex = lineIndexObject
				.getPageIndex(); nextTokenBoxPageIndex < getPageCount(); nextTokenBoxPageIndex++) {
			// Start with given line index on given page, otherwise start with
			// last line index on page

			int startLineIndex = 0;
			int startSnippetIndex = -1;

			if (isCollage(nextTokenBoxPageIndex)) {
				startSnippetIndex = nextTokenBoxPageIndex == lineIndexObject.getPageIndex()
						? lineIndexObject.getSnippetIndex()
						: 0;
				startLineIndex = startSnippetIndex == lineIndexObject.getSnippetIndex() ? lineIndexObject.getLineIndex()
						: 0;
				result = checkCollageForNextTokenBox(startLineIndex, startSnippetIndex, nextTokenBoxPageIndex);
			} else {
				startLineIndex = nextTokenBoxPageIndex == lineIndexObject.getPageIndex()
						? lineIndexObject.getLineIndex()
						: 0;

				result = checkPageForNextTokenBox(startLineIndex, nextTokenBoxPageIndex);
			}

			if (result != null) { // wenn eine Methode etwas gefunden hat
				return result;
			}
		}

		return result;
	}

	private LineIndex getPreviousTokenBoxLineIndex(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		LineIndex result = null;

		for (int previousTokenBoxPageIndex = lineIndexObject
				.getPageIndex(); previousTokenBoxPageIndex >= 0; previousTokenBoxPageIndex--) {
			// Start with given line index on given page, otherwise start with
			// last line index on page

			int startLineIndex = 0;
			int startSnippetIndex = -1;

			LineIndex previousLineIndexObject = new LineIndex(lineIndexObject.getPageIndex(),
					lineIndexObject.getSnippetIndex(), -1);

			if (isCollage(previousTokenBoxPageIndex)) {
				startSnippetIndex = previousTokenBoxPageIndex == lineIndexObject.getPageIndex()
						? lineIndexObject.getSnippetIndex()
						: getSnippetCount(previousLineIndexObject.getPageIndex()) - 1;
				startLineIndex = startSnippetIndex == lineIndexObject.getSnippetIndex() ? lineIndexObject.getLineIndex()
						: -1;
				result = checkCollageForPreviouseTokenBox(startLineIndex, startSnippetIndex, previousTokenBoxPageIndex);
			} else {
				startLineIndex = previousTokenBoxPageIndex == lineIndexObject.getPageIndex()
						? lineIndexObject.getLineIndex()
						: getLineCount(previousLineIndexObject) - 1;

				result = checkPageForPreviouseTokenBox(startLineIndex, previousTokenBoxPageIndex);
			}

			if (result != null) { // wenn eine Methode etwas gefunden hat
				return result;
			}
		}

		return result;
	}

	private LineIndex checkCollageForPreviouseTokenBox(int startLineIndex, int startSnippetIndex,
			int previousTokenBoxPageIndex) {
		LineIndex result = null;

		for (int previousTokenBoxSnippetIndex = startSnippetIndex; previousTokenBoxSnippetIndex >= 0; previousTokenBoxSnippetIndex--) {
			int snippetLine = 0;
			if (startLineIndex == -1) {
				snippetLine = getSnippet(previousTokenBoxPageIndex, previousTokenBoxSnippetIndex).getBoxCount() - 1;
			} else {
				snippetLine = startLineIndex;
			}
			for (int lineIndex = snippetLine; lineIndex >= 0; lineIndex--) {
				result = new LineIndex(previousTokenBoxPageIndex, previousTokenBoxSnippetIndex, lineIndex);
				OverflowListLayout line = getLine(result);

				if (line.getBoxCount() > 0 && line.getBox(0) instanceof TokenBox) {
					return result;
				}
				result = null;
			}
			startLineIndex = -1;
		}

		return result;
	}

	private LineIndex checkCollageForNextTokenBox(int startLineIndex, int startSnippetIndex,
			int nextTokenBoxPageIndex) {
		LineIndex result = null;

		for (int nextTokenBoxSnippetIndex = startSnippetIndex; nextTokenBoxSnippetIndex < getSnippetCount(
				nextTokenBoxPageIndex); nextTokenBoxSnippetIndex++) {
			int snippetLine = 0;
			if (startLineIndex == -1) {
				snippetLine = 0;
			} else {
				snippetLine = startLineIndex;
			}
			for (int lineIndex = snippetLine; lineIndex < getSnippet(nextTokenBoxPageIndex, nextTokenBoxSnippetIndex)
					.getBoxCount(); lineIndex++) {
				result = new LineIndex(nextTokenBoxPageIndex, nextTokenBoxSnippetIndex, lineIndex);
				OverflowListLayout line = getLine(result);

				if (line.getBoxCount() > 0 && line.getBox(0) instanceof TokenBox) {
					return result;
				}
				result = null;
			}
			startLineIndex = -1;
		}

		return result;
	}

	private LineIndex checkPageForPreviouseTokenBox(int startLineIndex, int previousTokenBoxPageIndex) {

		LineIndex result = null;
		for (int previousTokenBoxLineIndex = startLineIndex; previousTokenBoxLineIndex >= 0; previousTokenBoxLineIndex--) {
			result = new LineIndex(previousTokenBoxPageIndex, previousTokenBoxLineIndex);
			OverflowListLayout line = getLine(result);

			if (line.getBoxCount() > 0 && line.getBox(0) instanceof TokenBox) {
				return result;
			}
			result = null;
		}

		return result;
	}

	private LineIndex checkPageForNextTokenBox(int startLineIndex, int nextTokenBoxPageIndex) {

		LineIndex result = null;
		for (int nextTokenBoxLineIndex = startLineIndex; nextTokenBoxLineIndex < getLineCount(
				nextTokenBoxPageIndex); nextTokenBoxLineIndex++) {
			result = new LineIndex(nextTokenBoxPageIndex, nextTokenBoxLineIndex);
			OverflowListLayout line = getLine(result);

			if (line.getBoxCount() > 0 && line.getBox(0) instanceof TokenBox) {
				return result;
			}
			result = null;
		}

		return result;
	}

	protected TokenBox getTokenBoxForId(Id tokenBoxId) {
		assert tokenBoxId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenBoxId) : "Precondition failed: containsTokenBox(tokenId)";

		BoxIndex boxIndexObject = getIdBoxIndex(tokenBoxId);

		Box box = getBox(boxIndexObject);

		return (TokenBox) box;

	}

	protected void insertLineBreakAfter(Id previousToken) {
		assert previousToken != null : "Precondition failed: previousToken != null";

		BoxIndex previousTokenBoxIndexObject = getIdBoxIndex(previousToken);
		BoxIndex boxIndexObject = new BoxIndex(previousTokenBoxIndexObject.getLineIndexObject(),
				previousTokenBoxIndexObject.getBoxIndex() + 1);
		insertLineBreak(boxIndexObject);
	}

	protected void insertPageBreakAfter(Id previousToken) {
		insertPageBreakAfter(previousToken, false, null, false);
	}

	protected void insertPageBreakAfter(Id previousToken, boolean isNewPageCollage, Id collageId,
			boolean showCollageGrid) {
		assert previousToken != null : "Precondition failed: previousToken != null";

		BoxIndex boxIndexObject = getIdBoxIndex(previousToken);
		BoxIndex newBoxIndexObject = new BoxIndex(boxIndexObject.getLineIndexObject(),
				boxIndexObject.getBoxIndex() + 1);

		insertPageBreak(newBoxIndexObject, isNewPageCollage, collageId, showCollageGrid);
	}

	public void insertCollageAtPage(int pageIndex, Id collageId, boolean showCollageGrid) {
		insertPage(new CollagePageLayout(getPage(pageIndex - 1).getPageDimension(), collageId, showCollageGrid),
				pageIndex);
	}

	protected void insertTokenBoxAfter(Id previousToken, TokenBox newTokenBox) {
		BoxIndex boxIndexObject = this.getIdBoxIndex(previousToken);

		BoxIndex newBoxIndexObject = new BoxIndex(boxIndexObject.getLineIndexObject(),
				boxIndexObject.getBoxIndex() + 1);

		insertTokenBox(newTokenBox, newBoxIndexObject);
	}

	protected void insertTokenBoxBefore(Id nextTokenId, TokenBox newTokenBox) {
		BoxIndex boxIndexObject = this.getIdBoxIndex(nextTokenId);
		insertTokenBox(newTokenBox, boxIndexObject);
	}

	private void insertTokenBox(TokenBox newTokenBox, BoxIndex boxIndexObject) {

		this.insertBox(newTokenBox, boxIndexObject);
		compensate(boxIndexObject.getLineIndexObject());

		assert containsTokenBox(newTokenBox.getId()) : "Postcondition failed: containsTokenBox(newToken.getId())";
	}

	public boolean isInFirstTokenBoxLine(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		boolean result = false;
		boolean tokenBoxLineFound = false;

		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount && !tokenBoxLineFound; pageIndex++) {
			if (isCollage(pageIndex)) {
				for (int snippetIndex = 0; snippetIndex < getSnippetCount(pageIndex) - 1; snippetIndex++) {
					for (int lineIndex = 0, lineCount = getLineCount(
							new LineIndex(pageIndex, snippetIndex, 0)); lineIndex < lineCount
									&& !tokenBoxLineFound; lineIndex++) {
						LineIndex lineIndexObject = new LineIndex(pageIndex, snippetIndex, lineIndex);
						tokenBoxLineFound = getBoxCount(lineIndexObject) > 0
								&& getBox(new BoxIndex(lineIndexObject, 0)) instanceof TokenBox;
						if (tokenBoxLineFound) {
							for (int boxIndex = 0; boxIndex < getBoxCount(lineIndexObject) && !result; boxIndex++) {
								result = ((TokenBox) getBox(new BoxIndex(lineIndexObject, boxIndex))).getId()
										.equals(tokenId);
							}
						}
					}
				}
			} else {
				for (int lineIndex = 0, lineCount = getLineCount(pageIndex); lineIndex < lineCount
						&& !tokenBoxLineFound; lineIndex++) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
					tokenBoxLineFound = getBoxCount(lineIndexObject) > 0
							&& getBox(new BoxIndex(pageIndex, lineIndex, 0)) instanceof TokenBox;
					if (tokenBoxLineFound) {
						for (int boxIndex = 0; boxIndex < getBoxCount(lineIndexObject) && !result; boxIndex++) {
							result = ((TokenBox) getBox(new BoxIndex(lineIndexObject, boxIndex))).getId()
									.equals(tokenId);
						}
					}
				}
			}
		}

		return result;
	}

	public boolean isInLastTokenBoxLine(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		boolean result = false;
		boolean tokenBoxLineFound = false;

		for (int pageIndex = getPageCount() - 1; pageIndex >= 0 && !tokenBoxLineFound; pageIndex--) {
			if (isCollage(pageIndex)) {
				for (int snippetIndex = getSnippetCount(pageIndex) - 1; snippetIndex >= 0; snippetIndex--) {
					for (int lineIndex = getLineCount(new LineIndex(pageIndex, snippetIndex, 0)) - 1; lineIndex >= 0
							&& !tokenBoxLineFound; lineIndex--) {
						LineIndex lineIndexObject = new LineIndex(pageIndex, snippetIndex, lineIndex);
						for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); boxIndex < boxCount
								&& !result; boxIndex++) {
							Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
							if (box instanceof IdBox) {
								tokenBoxLineFound = true;
								result = ((IdBox) box).getId().equals(tokenId);
							}
						}
					}
				}
			} else {
				for (int lineIndex = getLineCount(pageIndex) - 1; lineIndex >= 0 && !tokenBoxLineFound; lineIndex--) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);
					for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); boxIndex < boxCount
							&& !result; boxIndex++) {
						Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
						if (box instanceof IdBox) {
							tokenBoxLineFound = true;
							result = ((IdBox) box).getId().equals(tokenId);
						}
					}
				}
			}
		}

		return result;
	}

	public boolean isOnFirstPageWithTokenBoxes(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		boolean result = false;
		boolean tokenBoxPageFound = false;

		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount && !tokenBoxPageFound; pageIndex++) {
			for (int lineIndex = 0, lineCount = getLineCount(pageIndex); lineIndex < lineCount; lineIndex++) {
				LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);

				if (getBoxCount(lineIndexObject) > 0 && getBox(new BoxIndex(lineIndexObject, 0)) instanceof TokenBox) {
					tokenBoxPageFound = true;
					for (int boxIndex = 0; boxIndex < getBoxCount(lineIndexObject) && !result; boxIndex++) {
						result = ((TokenBox) getBox(new BoxIndex(lineIndexObject, boxIndex))).getId().equals(tokenId);
					}
				}
			}
		}

		return result;
	}

	public boolean isOnLastPageWithTokenBoxes(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		boolean result = false;
		boolean tokenBoxPageFound = false;

		for (int pageIndex = getPageCount() - 1; !tokenBoxPageFound && pageIndex >= 0; pageIndex--) {

			if (!isCollage(pageIndex)) {
				for (int lineIndex = getLineCount(pageIndex) - 1; lineIndex >= 0; lineIndex--) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);

					for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); !result
							&& boxIndex < boxCount; boxIndex++) {
						Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
						if (box instanceof TokenBox) {
							tokenBoxPageFound = true;
							result = ((TokenBox) box).getId().equals(tokenId);
						}
					}
				}
			} else {
				for (int snippetIndex = getSnippetCount(pageIndex) - 1; snippetIndex >= 0; snippetIndex--) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, snippetIndex, 0);

					for (int boxIndex = 0, boxCount = getBoxCount(lineIndexObject); !result
							&& boxIndex < boxCount; boxIndex++) {
						Box box = getBox(new BoxIndex(lineIndexObject, boxIndex));
						if (box instanceof TokenBox) {
							tokenBoxPageFound = true;
							result = ((TokenBox) box).getId().equals(tokenId);
						}
					}
				}
			}
		}

		return result;
	}

	public void removeBoxesBetween(Id fromTokenBoxExcludedId, Id toTokenBoxExcludedId) {
		assert fromTokenBoxExcludedId != null : "Precondition failed: fromBoxExcludedId != null";
		assert toTokenBoxExcludedId != null : "Precondition failed: toBoxExcludedId != null";
		assert containsTokenBox(fromTokenBoxExcludedId) : "Precondition failed: containsTokenBox(fromBoxExcludedId)";
		assert containsTokenBox(toTokenBoxExcludedId) : "Precondition failed: containsTokenBox(toBoxExcludedId)";

		BoxIndex fromTokenBoxIndex = getIdBoxIndex(fromTokenBoxExcludedId);
		BoxIndex toTokenBoxIndex = getIdBoxIndex(toTokenBoxExcludedId);
		assert fromTokenBoxIndex
				.compareTo(toTokenBoxIndex) < 0 : "Assertion failed: fromTokenBoxIndex.compareTo(toTokenBoxIndex) < 0";

		int fromPageIndex = fromTokenBoxIndex.getPageIndex();
		int fromSnippetIndex = fromTokenBoxIndex.getSnippetIndex();
		int fromLineIndex = fromTokenBoxIndex.getLineIndex();
		int fromBoxIndex = fromTokenBoxIndex.getBoxIndex();
		int toPageIndex = toTokenBoxIndex.getPageIndex();
		int toLineIndex = toTokenBoxIndex.getLineIndex();
		int toBoxIndex = toTokenBoxIndex.getBoxIndex();

		int pageDifference = toPageIndex - fromPageIndex;
		if (pageDifference > 0) {
			// Remove page and line break to enable compensate
			removePageBreak(fromPageIndex);
			removeLineBreak(fromTokenBoxIndex.getLineIndexObject());

			// Remove intermediate pages
			if (pageDifference > 1) {
				removePages(fromPageIndex + 1, toPageIndex);
				toPageIndex = fromPageIndex + 1;
			}

			// Remove page tail + head if necessary
			int pageTailStartIndex = fromLineIndex + 1;
			int fromPageLineCount = getLineCount(fromPageIndex);
			if (pageTailStartIndex < fromPageLineCount) {
				removeLines(new LineIndex(fromPageIndex, pageTailStartIndex), fromPageLineCount);
			}
			if (toLineIndex > 0) {
				removeLines(new LineIndex(toPageIndex, 0), toLineIndex);
			}
			toLineIndex = 0;

			// Remove line tail + head if necessary
			int lineTailStartIndex = fromBoxIndex + 1;
			int fromLineBoxCount = getBoxCount(fromTokenBoxIndex.getLineIndexObject());
			if (lineTailStartIndex < fromLineBoxCount) {
				removeBoxes(fromTokenBoxIndex.getLineIndexObject(), lineTailStartIndex, fromLineBoxCount);
			}
			if (toBoxIndex > 0) {
				LineIndex lineIndexObject;
				if (toTokenBoxIndex.getSnippetIndex() >= 0) {
					lineIndexObject = new LineIndex(toPageIndex, toTokenBoxIndex.getSnippetIndex(), toLineIndex);
				} else {
					lineIndexObject = new LineIndex(toPageIndex, toLineIndex);
				}
				removeBoxes(lineIndexObject, 0, toBoxIndex);
			}
		} else {
			int lineDifference = toLineIndex - fromLineIndex;
			if (lineDifference > 0) {
				// Remove line break to enable compensate
				removeLineBreak(fromTokenBoxIndex.getLineIndexObject());

				// Remove intermediate lines
				if (lineDifference > 1) {
					removeLines(new LineIndex(fromPageIndex, fromSnippetIndex, fromLineIndex + 1), toLineIndex);
					toLineIndex = fromLineIndex + 1;
				}

				// Remove line tail + head if necessary
				int lineTailStartIndex = fromBoxIndex + 1;
				int fromLineBoxCount = getBoxCount(fromTokenBoxIndex.getLineIndexObject());
				if (lineTailStartIndex < fromLineBoxCount) {
					removeBoxes(fromTokenBoxIndex.getLineIndexObject(), lineTailStartIndex, fromLineBoxCount);
				}
				if (toBoxIndex > 0) {
					removeBoxes(new LineIndex(fromPageIndex, fromSnippetIndex, toLineIndex), 0, toBoxIndex);
				}
			} else {
				int boxDifference = toBoxIndex - fromBoxIndex;
				if (boxDifference > 1) {
					// Remove intermediate boxes in one line
					removeBoxes(fromTokenBoxIndex.getLineIndexObject(), fromBoxIndex + 1, toBoxIndex);
				}
			}
		}
		int pageCount = getPageCount();
		int lastPageIndex = pageCount - 1;

		LineIndex lastLineIndexObject;

		if (isCollage(lastPageIndex)) {
			int lastSnippetIndex = getSnippetCount(lastPageIndex) - 1;
			int lastLineIndex = getLineCount(new LineIndex(lastPageIndex, lastSnippetIndex, 0)) - 1;

			lastLineIndexObject = new LineIndex(lastPageIndex, lastSnippetIndex, lastLineIndex);
		} else {
			int lastLineIndex = getLineCount(lastPageIndex) - 1;

			lastLineIndexObject = new LineIndex(lastPageIndex, lastLineIndex);
		}

		BoxIndex lastTokenBoxIndex = new BoxIndex(lastLineIndexObject, getBoxCount(lastLineIndexObject) - 1);
		BoxIndex endIndex = lastTokenBoxIndex;
		// Remove empty lines
		for (int currentPageIndex = endIndex.getPageIndex(); currentPageIndex >= fromPageIndex; currentPageIndex--) {

			if (isCollage(currentPageIndex)) {
				for (int currentSnippetIndex = getSnippetCount(currentPageIndex)
						- 1; currentSnippetIndex >= 0; currentSnippetIndex--) {
					int beginLineIndex = getLineCount(new LineIndex(currentPageIndex, currentSnippetIndex, 0)) - 1;

					for (int currentLineIndex = beginLineIndex; currentLineIndex >= 0; currentLineIndex--) {
						LineIndex currentLineIndexObject = new LineIndex(currentPageIndex, currentSnippetIndex,
								currentLineIndex);
						if (getLine(currentLineIndexObject).isEmpty()) {
							removeLine(currentLineIndexObject);
						}
					}
				}
			} else {
				int beginLineIndex = getLineCount(currentPageIndex) - 1;

				for (int currentLineIndex = beginLineIndex; currentLineIndex >= 0; currentLineIndex--) {
					LineIndex currentLineIndexObject = new LineIndex(currentPageIndex, currentLineIndex);
					if (getLine(currentLineIndexObject).isEmpty()) {
						removeLine(currentLineIndexObject);
					}
				}
			}
			// Remove empty pages
			PageLayout page = getPage(currentPageIndex);
			if (page.isEmpty() && !(page instanceof CollagePageLayout)) {
				removePage(currentPageIndex);
			}
		}

		compensate(fromTokenBoxIndex.getLineIndexObject());
	}

	public void removeLineBreakAfter(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		BoxIndex boxIndexObject = getIdBoxIndex(tokenId);
		int pageIndex = boxIndexObject.getPageIndex();
		int lineIndex = boxIndexObject.getLineIndex();

		assert !getLine(boxIndexObject.getLineIndexObject())
				.canCompensate() : "!getLine(pageIndex, lineIndex).canCompensate()";

		removeLineBreak(boxIndexObject.getLineIndexObject());
		if (lineIndex == getLineCount(pageIndex) - 1 && hasPageBreak(pageIndex)) {
			removePageBreak(pageIndex);
		}

		compensate(boxIndexObject.getLineIndexObject());
	}

	public void removeTokenBox(Id tokenBoxId) {
		assert containsTokenBox(tokenBoxId) : "Precondition failed: containsTokenBox(tokenBoxId)";

		BoxIndex boxIndex = getIdBoxIndex(tokenBoxId);
		removeBox(boxIndex);
		updateLineHeight(boxIndex.getLineIndexObject());
		compensate(boxIndex.getLineIndexObject());

		assert !containsTokenBox(tokenBoxId) : "Postcondition failed: !containsTokenBox(tokenBoxId)";
	}

	protected void updateTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		BoxIndex boxIndexObject = getIdBoxIndex(tokenBox.getId());

		setBox(tokenBox, boxIndexObject);

		compensate(boxIndexObject.getLineIndexObject());

		// index may have changed due to compensate
		boxIndexObject = getIdBoxIndex(tokenBox.getId());
		if (boxIndexObject.getLineIndexObject().isCollageLineIndex()) {
			documentPanel.updateSnippetHeight(boxIndexObject.getPageIndex(), boxIndexObject.getSnippetIndex());
		}
	}

	protected void updateTokenBoxMargin(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		BoxIndex boxIndexObject = getIdBoxIndex(tokenBox.getId());
		int maxHeightInLine = getLine(boxIndexObject.getLineIndexObject()).getMaxSignItemTokenBoxHeight_PX();
		updateLine(getLine(boxIndexObject.getLineIndexObject()), maxHeightInLine, boxIndexObject.getLineIndexObject());
	}

	protected void updateLine(OverflowListLayout line, int maxHeight, LineIndex lineIndexObject) {
		for (int i = 0, tokenBoxCount = line.getBoxCount(); i < tokenBoxCount; i++) {
			Box box = line.getBox(i);
			if (box instanceof VideoTokenBox) {
				((VideoTokenBox) box).updateMarginBetweenVideoAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			} else if (box instanceof SignItemTokenBox) {
				((SignItemTokenBox) box).updateMarginBetweenSignItemAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			} else if (box instanceof ImageTokenBox) {
				((ImageTokenBox) box).updateMarginBetweenImageAndText(maxHeight);
				setBox(box, new BoxIndex(lineIndexObject, i));
			}
		}
	}
}
