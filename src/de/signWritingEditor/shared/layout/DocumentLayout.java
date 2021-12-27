package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public abstract class DocumentLayout {

	private List<PageLayout> pages;

	public DocumentLayout() {
		this.pages = new ArrayList<PageLayout>();
	}

	public int getPageCount() {
		return pages.size();
	}

	public Orientation getPageOrientation(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		Orientation result = getPage(pageIndex).getOrientation();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public int getPageWidth(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		int result = getPage(pageIndex).getMaxWidth();

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getPageHeight(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		int result = getPage(pageIndex).getMaxHeight();

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	/**
	 * 
	 * @param pageFormat
	 * @param pageIndex
	 */
	public void insertNewPage(PageFormat pageFormat, int pageIndex) {
		insertNewPage(pageFormat, pageIndex, false, null, false);
	}

	/**
	 * 
	 * @param pageFormat
	 * @param pageIndex
	 * @param showCollageGrid
	 */
	public void insertNewPage(PageFormat pageFormat, int pageIndex, boolean isCollage, Id collageId,
			boolean showCollageGrid) {
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex <= getPageCount() : "Precondition failed: pageIndex <= getPageCount()";

		PageLayout pageLayout = null;
		if (isCollage) {
			pageLayout = new CollagePageLayout(pageFormat, collageId, showCollageGrid);
		} else {
			pageLayout = new ContinuousPageLayout(pageFormat);
		}
		insertPage(pageLayout, pageIndex);
	}

	public void insertPage(PageLayout pageLayout, int pageIndex) {
		assert pageLayout != null : "Precondition failed: pageLayout != null";
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex <= getPageCount() : "Precondition failed: pageIndex <= getPageCount()";

		pages.add(pageIndex, pageLayout);

		onInsertPage(pageIndex, pageLayout);
	}

	public boolean hasPageBreak(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		return !getPage(pageIndex).canCompensate();
	}

	public void insertPageBreak(BoxIndex boxIndexObject) {
		insertPageBreak(boxIndexObject, false, null, false);
	}

	public void insertPageBreak(BoxIndex boxIndexObject, boolean createCollage, Id collageId, boolean showCollageGrid) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		PageLayout page = getPage(boxIndexObject.getPageIndex());
		PageLayout newPage = null;
		if (createCollage) {
			newPage = new CollagePageLayout(page.getPageDimension(), collageId, showCollageGrid);
		} else {
			newPage = new ContinuousPageLayout(page.getPageDimension());
		}

		insertPage(newPage, boxIndexObject.getPageIndex() + 1);

		if (!createCollage && !boxIndexObject.isCollageBoxIndex()) {
			insertLineBreak(boxIndexObject);
		} else if (!createCollage && boxIndexObject.isCollageBoxIndex()) {
			LineIndex lineIndexObject = new LineIndex(boxIndexObject.getPageIndex() + 1, 0);
			insertNewLine(lineIndexObject);
		}

		newPage.setCanCompensate(page.canCompensate());
		page.setCanCompensate(false);

		if (!createCollage && !isCollage(boxIndexObject.getPageIndex())) {
			int tailLength = page.getBoxCount() - boxIndexObject.getLineIndex() - 1;

			if (tailLength > 0) {
				page.moveTail(newPage, boxIndexObject.getLineIndex() + 1);
				onMovePageSegment(new LineIndex(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex() + 1),
						new LineIndex(boxIndexObject.getPageIndex() + 1, 0), tailLength);
			}
			compensate(new LineIndex(boxIndexObject.getPageIndex() + 1, 0));
		}

		assert hasPageBreak(
				boxIndexObject.getPageIndex()) : "Postcondition failed: hasPageBreak(boxIndexObject.getPageIndex())";
	}

	public void removePageBreak(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		// Don't remove last page break
		if (pageIndex != getPageCount() - 1) {
			getPage(pageIndex).setCanCompensate(true);
		}

		assert hasPageBreak(pageIndex) == (pageIndex == getPageCount()
				- 1) : "Postcondition failed: hasPageBreak(pageIndex) == (pageIndex == getPageCount() - 1)";
	}

	public void removePage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		pages.remove(pageIndex);

		onRemovePage(pageIndex);
	}

	public void removePages(int beginPageIndex, int endPageIndex) {
		assert beginPageIndex >= 0 : "Precondition failed: beginPageIndex [" + beginPageIndex + "] >= 0";
		assert beginPageIndex < endPageIndex : "Precondition failed: beginPageIndex [" + beginPageIndex
				+ "] < endPageIndex [" + endPageIndex + "]";
		assert endPageIndex <= getPageCount() : "Precondition failed: endPageIndex <= getPageCount()";

		for (int removedPageCount = 0; removedPageCount < endPageIndex - beginPageIndex; removedPageCount++) {
			removePage(beginPageIndex);
		}
	}

	public int getLineCount(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert !isCollage(pageIndex) : "Precondition failed: !isCollage(pageIndex)";

		return getPage(pageIndex).getBoxCount();
	}

	public int getLineCount(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";

		if (lineIndexObject.isCollageLineIndex()) {
			return getSnippet(lineIndexObject.getPageIndex(), lineIndexObject.getSnippetIndex()).getBoxCount();
		} else {
			return getLineCount(lineIndexObject.getPageIndex());
		}
	}

	public boolean isCollage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		return getPage(pageIndex) instanceof CollagePageLayout;
	}

	public void insertNewLine(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() <= getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() <= getLineCount(lineIndexObject)";

		Orientation orientation = getPage(lineIndexObject.getPageIndex()).getOrientation();
		if (lineIndexObject.isCollageLineIndex()) {
			LineLayout box = new LineLayout(orientation.toggle(),
					getSnippet(lineIndexObject.getPageIndex(), lineIndexObject.getSnippetIndex()).getInnerWidth_PX());
			getSnippet(lineIndexObject.getPageIndex(), lineIndexObject.getSnippetIndex()).insertBox(box,
					lineIndexObject.getLineIndex());
		} else {
			ContinuousPageLayout page = (ContinuousPageLayout) getPage(lineIndexObject.getPageIndex());
			page.insertNewLine(lineIndexObject.getLineIndex());
		}

		onInsertNewLine(lineIndexObject, orientation);
	}

	public void insertSnippet(int pageIndex, int snippetIndex, int x, int y, int z, int width) {
		assert getPage(
				pageIndex) instanceof CollagePageLayout : "Precondition failed: getPage(pageIndex) instanceof CollagePageLayout";

		CollagePageLayout page = (CollagePageLayout) getPage(pageIndex);
		page.insertNewSnippet(snippetIndex, x, y, z, width);
	}

	public boolean hasLineBreak(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		return !getLine(lineIndexObject).canCompensate();
	}

	public void insertLineBreak(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert getPage(boxIndexObject
				.getPageIndex()) instanceof ContinuousPageLayout : "Precondition failed: getPage(boxIndex.getPageIndex()) instanceof ContinuousPageLayout";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getPageIndex()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getPageIndex())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		ContinuousPageLayout page = (ContinuousPageLayout) getPage(boxIndexObject.getPageIndex());
		OverflowListLayout line = getLine(boxIndexObject.getLineIndexObject());

		page.insertNewLine(boxIndexObject.getLineIndex() + 1);
		OverflowListLayout newLine = page.getLine(boxIndexObject.getLineIndex() + 1);

		int tailLength = line.getBoxCount() - boxIndexObject.getBoxIndex();
		line.moveTail(newLine, boxIndexObject.getBoxIndex());

		newLine.setCanCompensate(line.canCompensate());
		line.setCanCompensate(false);

		LineIndex newLineIndexObject = new LineIndex(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex() + 1);
		onInsertNewLine(newLineIndexObject, page.getOrientation());

		BoxIndex toBoxIndexObject = new BoxIndex(newLineIndexObject, 0);
		onMoveLineSegment(boxIndexObject, toBoxIndexObject, tailLength);

		assert hasLineBreak(boxIndexObject
				.getLineIndexObject()) : "Postcondition failed: hasLineBreak(boxIndex.getLineIndexObject())";
	}

	public void removeSnippet(int pageIndex, int snippetIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert isCollage(pageIndex) : "Precondition failed: isCollage(pageIndex)";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getSnippetCount(pageIndex) : "Precondition failed: snippetIndex < getSnippetCount()";

		pages.get(pageIndex).removeBox(snippetIndex);

		onRemoveSnippet(pageIndex, snippetIndex);
	}

	public void removeLineBreak(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject)";

		int pageIndex = lineIndexObject.getPageIndex();
		int lastLineIndex = getLineCount(lineIndexObject) - 1;

		// Don't remove last line break
		if (pageIndex != getPageCount() - 1 || lineIndexObject.getLineIndex() != lastLineIndex) {
			getLine(lineIndexObject).setCanCompensate(true);
		}

		assert hasLineBreak(lineIndexObject) == (pageIndex == getPageCount() - 1
				&& lineIndexObject.getLineIndex() == getLineCount(lineIndexObject)
						- 1) : "Postcondition failed: hasLineBreak(pageIndex, lineIndex) == (pageIndex == getPageCount() - 1 && lineIndex == getLineCount(lineIndexObject) - 1)";
	}

	public void removeLine(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		if (lineIndexObject.isCollageLineIndex()) {
			getSnippet(lineIndexObject.getPageIndex(), lineIndexObject.getSnippetIndex())
					.removeBox(lineIndexObject.getLineIndex());
		} else {
			pages.get(lineIndexObject.getPageIndex()).removeBox(lineIndexObject.getLineIndex());
		}

		onRemoveLine(lineIndexObject);
	}

	public void removeLines(LineIndex beginLineIndexObject, int endLineIndex) {
		assert beginLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: beginLineIndexObject.getPageIndex() >= 0";
		assert beginLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: beginLineIndexObject.getPageIndex() < getPageCount()";
		assert beginLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: beginLineIndexObject.getLineIndex() >= 0";
		assert beginLineIndexObject.getLineIndex() < getLineCount(
				beginLineIndexObject) : "Precondition failed: beginLineIndexObject.getLineIndex() < getLineCount(beginLineIndexObject))";
		assert beginLineIndexObject
				.getLineIndex() < endLineIndex : "Precondition failed: beginLineIndexObject.getLineIndex() < endLineIndex";
		assert endLineIndex <= getLineCount(
				beginLineIndexObject) : "Precondition failed: endLineIndex <= getLineCount(beginLineIndexObject)";

		for (int removedLineCount = 0; removedLineCount < endLineIndex
				- beginLineIndexObject.getLineIndex(); removedLineCount++) {
			removeLine(beginLineIndexObject);
		}
	}

	public int getBoxCount(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject.getPageIndex()))";

		return getLine(lineIndexObject).getBoxCount();
	}

	public Box getBox(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		Box result = getLine(boxIndexObject.getLineIndexObject()).getBox(boxIndexObject.getBoxIndex());

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public void setBox(Box box, BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		getLine(boxIndexObject.getLineIndexObject()).setBox(box, boxIndexObject.getBoxIndex());

		onSetBox(box, boxIndexObject);
	}

	public void insertBox(Box box, BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";
		assert box != null : "Precondition failed: box != null";

		getLine(boxIndexObject.getLineIndexObject()).insertBox(box, boxIndexObject.getBoxIndex());
		Orientation pageOrientation = getPage(boxIndexObject.getPageIndex()).getOrientation();
		onInsertBox(box, boxIndexObject, pageOrientation);
	}

	public void removeBox(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getBoxCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		getLine(boxIndexObject.getLineIndexObject()).removeBox(boxIndexObject.getBoxIndex());

		onRemoveBox(boxIndexObject);
	}

	public void removeBoxes(LineIndex lineIndexObject, int beginBoxIndex, int endBoxIndex) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";
		assert beginBoxIndex >= 0 : "Precondition failed: beginBoxIndex >= 0";
		assert beginBoxIndex < endBoxIndex : "Precondition failed: beginBoxIndex < endBoxIndex";
		assert endBoxIndex <= getBoxCount(lineIndexObject) : "Precondition failed: endBoxIndex [" + endBoxIndex
				+ "] <= getBoxCount(lineIndexObject) [" + getBoxCount(lineIndexObject) + "]";

		for (int removedBoxCount = 0; removedBoxCount < endBoxIndex - beginBoxIndex; removedBoxCount++) {
			removeBox(new BoxIndex(lineIndexObject, beginBoxIndex));
		}
	}

	public void compensate(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(
				firstLineIndexObject) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject))";

		if (firstLineIndexObject.isCollageLineIndex()) {
			compensateCollagePage(firstLineIndexObject);
		} else {
			compensateContinuousPage(firstLineIndexObject);
		}
	}

	public void compensateLinesOverflow(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";

		if (firstLineIndexObject.isCollageLineIndex()) {
			compensateLinesOverflowForCollagePage(firstLineIndexObject);
		} else {
			compensateLinesOverflowForContinuousPage(firstLineIndexObject);
		}
	}

	public void compensateLinesUnderflow(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";

		if (firstLineIndexObject.isCollageLineIndex()) {
			compensateLinesUnderflowForCollagePage(firstLineIndexObject);
		} else {
			compensateLinesUnderflowForContinuousPage(firstLineIndexObject);
		}
	}

	public void compensateContinuousPage(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(firstLineIndexObject
				.getPageIndex()) instanceof ContinuousPageLayout : "Precondition failed: getPage(firstLineIndexObject.getPageIndex()) instanceof ContinuousPageLayout)";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject
				.getPageIndex()) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject.getPageIndex()))";

		// get previous line, if existing
		int pageIndex = firstLineIndexObject.getPageIndex();
		int lineIndex = firstLineIndexObject.getLineIndex();
		if (lineIndex > 0) {
			lineIndex--;
		} else if (pageIndex > 0 && !(pages.get(pageIndex - 1) instanceof CollagePageLayout)) {
			pageIndex--;
			lineIndex = getLineCount(pageIndex) - 1;
		}

		// only start with previous line, if it can compensate
		OverflowListLayout firstLine = getLine(new LineIndex(pageIndex, lineIndex));
		if (!firstLine.canCompensate()) {
			pageIndex = firstLineIndexObject.getPageIndex();
			lineIndex = firstLineIndexObject.getLineIndex();
		}

		// compensate underflow first
		if (lineIndex < getLineCount(pageIndex)) {
			compensateLinesUnderflow(new LineIndex(pageIndex, lineIndex));
		}
		compensatePagesUnderflow(pageIndex);

		// compensate overflow afterwards
		int firstPageIndex = firstLineIndexObject.getPageIndex();
		if (firstPageIndex < getPageCount()) {
			if (firstLineIndexObject.getLineIndex() < getLineCount(firstPageIndex)) {
				compensateLinesOverflow(firstLineIndexObject);
			}
			compensatePagesOverflow(firstPageIndex);
		}
	}

	public void compensateCollagePage(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(firstLineIndexObject
				.getPageIndex()) instanceof CollagePageLayout : "Precondition failed: getPage(firstLineIndexObject.getPageIndex()) instanceof CollagePageLayout";
		assert firstLineIndexObject
				.getSnippetIndex() >= 0 : "Precondition failed: firstLineIndexObject.getSnippetIndex() >= 0";
		assert firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject
				.getPageIndex()) : "Precondition failed: firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject.getPageIndex())";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(
				firstLineIndexObject) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject))";

		// get previous line, if existing
		int lineIndex = firstLineIndexObject.getLineIndex();
		if (lineIndex > 0 && getLine(new LineIndex(firstLineIndexObject.getPageIndex(),
				firstLineIndexObject.getSnippetIndex(), lineIndex - 1)).canCompensate()) {
			lineIndex--;
		}

		// compensate underflow first
		if (lineIndex < getLineCount(firstLineIndexObject)) {
			compensateLinesUnderflow(new LineIndex(firstLineIndexObject.getPageIndex(),
					firstLineIndexObject.getSnippetIndex(), lineIndex));
		}

		// compensate overflow afterwards
		if (firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject)) {
			compensateLinesOverflow(new LineIndex(firstLineIndexObject.getPageIndex(),
					firstLineIndexObject.getSnippetIndex(), firstLineIndexObject.getLineIndex()));
		}
	}

	public void compensateLinesOverflowForCollagePage(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(firstLineIndexObject
				.getPageIndex()) instanceof CollagePageLayout : "Precondition failed: getPage(firstLineIndexObject.getPageIndex()) instanceof CollagePageLayout";
		assert firstLineIndexObject
				.getSnippetIndex() >= 0 : "Precondition failed: firstLineIndexObject.getSnippetIndex() >= 0";
		assert firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject
				.getPageIndex()) : "Precondition failed: firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject.getPageIndex())";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(
				firstLineIndexObject) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject))";

		int pageIndex = firstLineIndexObject.getPageIndex();
		int snippetIndex = firstLineIndexObject.getSnippetIndex();
		int lineIndex = firstLineIndexObject.getLineIndex();

		OverflowListLayout lineLayout = getLine(firstLineIndexObject);

		// Solange die aktuelle Zeile zu lang ist und mehr als ein Token enthält
		while (lineIndex < getLineCount(new LineIndex(pageIndex, snippetIndex, lineIndex))) {
			if (lineLayout.getOverflow() > 0 && lineLayout.getBoxCount() > 1) {
				int nextLineIndex = lineIndex + 1;

				LineIndex nextLineIndexObject = new LineIndex(pageIndex, snippetIndex, nextLineIndex);

				// Wenn die aktuelle Zeile mit einem manuellen Zeilenumbruch endet
				if (!lineLayout.canCompensate()) {
					// Zeilenumbruch rutscht in eine neue leere Nachfolgezeile
					lineLayout.setCanCompensate(true);
					insertNewLine(nextLineIndexObject);
				}

				OverflowListLayout nextLineLayout = getLine(nextLineIndexObject);

				int overflowStartIndex = lineLayout.getOverflowStartIndex();
				// Die erste Box kann nicht sinnvoll verschoben werden
				overflowStartIndex = Math.max(overflowStartIndex, 1);

				int tailLength = lineLayout.getBoxCount() - overflowStartIndex;
				// Verschiebe die Boxen, die nicht mehr auf die aktuelle Zeile
				// passen, in die Nachfolgezeile
				if (tailLength > 0) {
					lineLayout.moveTail(nextLineLayout, overflowStartIndex);
					BoxIndex fromBoxIndexObject = new BoxIndex(pageIndex, snippetIndex, lineIndex, overflowStartIndex);
					BoxIndex toBoxIndexObject = new BoxIndex(nextLineIndexObject, 0);
					onMoveLineSegment(fromBoxIndexObject, toBoxIndexObject, tailLength);
				}

				assert lineLayout.getBoxCount() >= 1;
				assert lineLayout.getBoxCount() == 1 || lineLayout.getOverflow() <= 0;

				lineIndex = nextLineIndex;
				lineLayout = nextLineLayout;
			} else {
				lineIndex++;
				LineIndex newLineIndex = new LineIndex(pageIndex, snippetIndex, lineIndex);
				if (lineIndex < getLineCount(newLineIndex)) {
					lineLayout = getLine(newLineIndex);
				}
			}
		}
	}

	public void compensateLinesUnderflowForCollagePage(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(firstLineIndexObject
				.getPageIndex()) instanceof CollagePageLayout : "Precondition failed: getPage(firstLineIndexObject.getPageIndex()) instanceof CollagePageLayout";
		assert firstLineIndexObject
				.getSnippetIndex() >= 0 : "Precondition failed: firstLineIndexObject.getSnippetIndex() >= 0";
		assert firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject
				.getPageIndex()) : "Precondition failed: firstLineIndexObject.getSnippetIndex() < getSnippetCount(firstLineIndexObject.getPageIndex())";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(
				firstLineIndexObject) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject))";

		int pageIndex = firstLineIndexObject.getPageIndex();
		int snippetIndex = firstLineIndexObject.getSnippetIndex();
		int lineIndex = firstLineIndexObject.getLineIndex();

		OverflowListLayout lineLayout = getLine(firstLineIndexObject);
		float overflow;

		while (lineIndex < getLineCount(new LineIndex(pageIndex, snippetIndex, lineIndex))) {
			// Solange die aktuelle Zeile noch Platz hat und nicht mit einem
			// manuellen Zeilenumbruch endet
			if ((overflow = lineLayout.getOverflow()) <= 0.0 && lineLayout.canCompensate()) {
				int nextLineIndex = lineIndex + 1;

				LineIndex nextLineIndexObject = new LineIndex(pageIndex, snippetIndex, nextLineIndex);
				OverflowListLayout nextLineLayout = getLine(nextLineIndexObject);

				// Schiebt alle Tokens, die passen, von der Nachfolgezeile in die
				// aktuelle Zeile
				int fittingBoxCount = nextLineLayout.getOutlierStartIndex(-overflow);
				if (fittingBoxCount > 0) {
					int boxIndex = lineLayout.getBoxCount();

					nextLineLayout.moveHead(lineLayout, fittingBoxCount - 1);
					BoxIndex fromBoxIndexObject = new BoxIndex(nextLineIndexObject, 0);
					BoxIndex toBoxIndexObject = new BoxIndex(pageIndex, snippetIndex, lineIndex, boxIndex);
					onMoveLineSegment(fromBoxIndexObject, toBoxIndexObject, fittingBoxCount);
				}

				// Falls die Nachfolgezeile leer ist, wird sie gelöscht
				if (nextLineLayout.getBoxCount() == 0) {
					lineLayout.setCanCompensate(nextLineLayout.canCompensate());
					removeLine(nextLineIndexObject);

					// Wurde die Nachfolgezeile gelöscht, rutschen die
					// Nachfolgezeilen hoch
					// Indizes dürfen nicht hochgezählt werden
				} else {
					lineIndex = nextLineIndex;
					lineLayout = nextLineLayout;
				}
			} else {
				lineIndex++;
				LineIndex newLineIndex = new LineIndex(pageIndex, snippetIndex, lineIndex);
				if (lineIndex < getLineCount(newLineIndex)) {
					lineLayout = getLine(newLineIndex);
				}
			}
		}
	}

	public PageLayout getPage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		PageLayout result = pages.get(pageIndex);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public SnippetLayout getSnippet(int pageIndex, int snippetIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(
				pageIndex) instanceof CollagePageLayout : "Precondition failed: getPage(pageIndex) instanceof CollagePageLayout";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getSnippetCount(
				pageIndex) : "Precondition failed: snippetIndex < getSnippetCount(pageIndex)";

		return (SnippetLayout) ((CollagePageLayout) getPage(pageIndex)).getBox(snippetIndex);
	}

	public int getSnippetCount(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(
				pageIndex) instanceof CollagePageLayout : "Precondition failed: getPage(pageIndex) instanceof CollagePageLayout";

		return getPage(pageIndex).getBoxCount();
	}

	public OverflowListLayout getLine(LineIndex lineIndex) {
		if (lineIndex.isCollageLineIndex()) {
			SnippetLayout snippet = (SnippetLayout) getPage(lineIndex.getPageIndex())
					.getBox(lineIndex.getSnippetIndex());
			return (OverflowListLayout) snippet.getBox(lineIndex.getLineIndex());
		} else {
			return ((ContinuousPageLayout) getPage(lineIndex.getPageIndex())).getLine(lineIndex.getLineIndex());
		}
	}

	public void compensateLinesOverflowForContinuousPage(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(lineIndexObject
				.getPageIndex()) instanceof ContinuousPageLayout : "Precondition failed: getPage(lineIndexObject.getPageIndex()) instanceof ContinuousPageLayout";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(lineIndexObject
				.getPageIndex()) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject.getPageIndex()))";

		int pageIndex = lineIndexObject.getPageIndex();
		int lineIndex = lineIndexObject.getLineIndex();

		OverflowListLayout lineLayout = getLine(lineIndexObject);

		// Solange die aktuelle Zeile zu lang ist und mehr als ein Token enthält
		while (lineLayout.getOverflow() > 0 && lineLayout.getBoxCount() > 1) {
			int nextLineIndex = lineIndex + 1;
			int nextPageIndex = pageIndex;

			// Wenn die aktuelle Zeile mit einem manuellen Zeilenumbruch endet
			if (!lineLayout.canCompensate()) {
				// Zeilenumbruch rutscht in eine neue leere Nachfolgezeile
				lineLayout.setCanCompensate(true);
				insertNewLine(new LineIndex(nextPageIndex, nextLineIndex));
			}
			// Wenn sich die Nachfolgezeile auf der nächsten Seite befindet
			else if (nextLineIndex >= getLineCount(nextPageIndex)) {
				nextLineIndex = 0;
				nextPageIndex++;
			}
			assert nextPageIndex < getPageCount();

			LineIndex nextLineIndexObject = new LineIndex(nextPageIndex, nextLineIndex);
			OverflowListLayout nextLineLayout = getLine(nextLineIndexObject);

			int overflowStartIndex = lineLayout.getOverflowStartIndex();
			// Die erste Box kann nicht sinnvoll verschoben werden
			overflowStartIndex = Math.max(overflowStartIndex, 1);

			int tailLength = lineLayout.getBoxCount() - overflowStartIndex;
			// Verschiebe die Boxen, die nicht mehr auf die aktuelle Zeile
			// passen, in die Nachfolgezeile
			if (tailLength > 0) {
				lineLayout.moveTail(nextLineLayout, overflowStartIndex);
				BoxIndex fromBoxIndexObect = new BoxIndex(pageIndex, lineIndex, overflowStartIndex);
				BoxIndex toBoxIndexObject = new BoxIndex(nextLineIndexObject, 0);
				onMoveLineSegment(fromBoxIndexObect, toBoxIndexObject, tailLength);
			}

			assert lineLayout.getBoxCount() >= 1;
			assert lineLayout.getBoxCount() == 1 || lineLayout.getOverflow() <= 0;

			pageIndex = nextPageIndex;
			lineIndex = nextLineIndex;
			lineLayout = nextLineLayout;
		}
	}

	public void compensateLinesUnderflowForContinuousPage(LineIndex firstLineIndexObject) {
		assert firstLineIndexObject
				.getPageIndex() >= 0 : "Precondition failed: firstLineIndexObject.getPageIndex() >= 0";
		assert firstLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: firstLineIndexObject.getPageIndex() < getPageCount()";
		assert getPage(firstLineIndexObject
				.getPageIndex()) instanceof ContinuousPageLayout : "Precondition failed: getPage(firstLineIndexObject.getPageIndex()) instanceof ContinuousPageLayout";
		assert firstLineIndexObject
				.getLineIndex() >= 0 : "Precondition failed: firstLineIndexObject.getLineIndex() >= 0";
		assert firstLineIndexObject.getLineIndex() < getLineCount(firstLineIndexObject
				.getPageIndex()) : "Precondition failed: firstLineIndexObject.getLineIndex() < getLineCount(lineIndexObject.getPageIndex()))";

		int pageIndex = firstLineIndexObject.getPageIndex();
		int lineIndex = firstLineIndexObject.getLineIndex();

		OverflowListLayout lineLayout = getLine(firstLineIndexObject);
		float overflow;

		// Solange die aktuelle Zeile noch Platz hat und nicht mit einem
		// manuellen Zeilenumbruch endet
		while ((overflow = lineLayout.getOverflow()) <= 0.0 && lineLayout.canCompensate()) {
			boolean nextPage = false;
			int nextPageIndex = pageIndex;
			int nextLineIndex = lineIndex + 1;
			if (nextLineIndex >= getLineCount(nextPageIndex)) {
				nextLineIndex = 0;
				nextPageIndex++;
				nextPage = true;
			}
			assert nextPageIndex < getPageCount() : "nextPageIndex < getPageCount()";

			LineIndex nextLineIndexObject = new LineIndex(nextPageIndex, nextLineIndex);
			OverflowListLayout nextLineLayout = getLine(nextLineIndexObject);

			// Schiebt alle Tokens, die passen, von der Nachfolgezeile in die
			// aktuelle Zeile
			int fittingBoxCount = nextLineLayout.getOutlierStartIndex(-overflow);
			if (fittingBoxCount > 0) {
				int boxIndex = lineLayout.getBoxCount();

				nextLineLayout.moveHead(lineLayout, fittingBoxCount - 1);
				BoxIndex fromBoxIndexObject = new BoxIndex(nextLineIndexObject, 0);
				BoxIndex toBoxIndexObject = new BoxIndex(pageIndex, lineIndex, boxIndex);
				onMoveLineSegment(fromBoxIndexObject, toBoxIndexObject, fittingBoxCount);
			}

			// Falls die Nachfolgezeile leer ist, wird sie gelöscht
			if (nextLineLayout.getBoxCount() == 0) {
				lineLayout.setCanCompensate(nextLineLayout.canCompensate());
				removeLine(nextLineIndexObject);

				// Wenn die einzige Zeile auf der Nachfolgeseite gelöscht wird,
				// wird die ganze Seite gelöscht
				if (nextPage && getLineCount(nextPageIndex) == 0) {
					getPage(nextPageIndex - 1).setCanCompensate(getPage(nextPageIndex).canCompensate());
					removePage(nextPageIndex);
				}
				// Wurde die Nachfolgezeile gelöscht, rutschen die
				// Nachfolgezeilen hoch
				// Indizes dürfen nicht hochgezählt werden
			} else {
				pageIndex = nextPageIndex;
				lineIndex = nextLineIndex;
				lineLayout = nextLineLayout;
			}
		}
	}

	public void compensatePagesOverflow(int firstPageIndex) {
		assert firstPageIndex >= 0 : "Precondition failed: firstPageIndex >= 0";
		assert firstPageIndex < getPageCount() : "Precondition failed: firstPageIndex < getPageCount()";
		assert getPage(
				firstPageIndex) instanceof ContinuousPageLayout : "Precondition failed: getPage(firstPageIndex) instanceof ContinuousPageLayout";

		int pageIndex = firstPageIndex;

		// Solange wir auf einer existierenden Seite sind
		while (pageIndex < getPageCount()) {
			PageLayout pageLayout = getPage(pageIndex);

			int nextPageIndex = pageIndex + 1;

			// Wenn die aktuelle Seite zu viele Zeilen und mehr als eine enthält
			if (pageLayout.getOverflow() > 0 && pageLayout.getBoxCount() > 1) {
				PageLayout nextPageLayout;

				// Wenn die Seite nicht mit einem manuellen Seitenumbruch endet
				if (pageLayout.canCompensate()) {
					nextPageLayout = getPage(nextPageIndex);
				} else {
					// Der Seitenumbruch wird auf eine neue leere Seite
					// geschoben
					pageLayout.setCanCompensate(true);

					nextPageLayout = new ContinuousPageLayout(pageLayout.getPageDimension());
					insertPage(nextPageLayout, nextPageIndex);
				}

				int overflowStartIndex = pageLayout.getOverflowStartIndex();
				// Die erste Zeile kann nicht sinnvoll verschoben werden
				overflowStartIndex = Math.max(overflowStartIndex, 1);

				int tailLength = pageLayout.getBoxCount() - overflowStartIndex;
				// Verschiebe die Zeilen, die nicht mehr auf die aktuelle Seite
				// passen, in die Nachfolgeseite
				if (tailLength > 0) {
					pageLayout.moveTail(nextPageLayout, overflowStartIndex);

					LineIndex fromLineIndexObject = new LineIndex(pageIndex, overflowStartIndex);
					LineIndex toLineIndexObject = new LineIndex(nextPageIndex, 0);
					onMovePageSegment(fromLineIndexObject, toLineIndexObject, tailLength);
				}

				assert pageLayout.getOverflow() <= 0 || pageLayout
						.getBoxCount() == 1 : "Postcondition failed: pageLayout.getOverflow() <= 0 || pageLayout.getBoxCount() == 1";
			}
			pageIndex++;
		}
	}

	public void compensatePagesUnderflow(int firstPageIndex) {
		assert firstPageIndex >= 0 : "Precondition failed: firstPageIndex >= 0";
		assert firstPageIndex < getPageCount() : "Precondition failed: firstPageIndex < getPageCount()";
		assert getPage(
				firstPageIndex) instanceof ContinuousPageLayout : "Precondition failed: getPage(firstPageIndex) instanceof ContinuousPageLayout";

		int pageIndex = firstPageIndex;

		PageLayout pageLayout = getPage(pageIndex);
		float overflow;

		// Solange auf der aktuellen Seite noch Platz ist und nicht mit einem
		// manuellen Seitenumbruch endet
		while ((overflow = pageLayout.getOverflow()) <= 0 && pageLayout.canCompensate()) {
			int nextPageIndex = pageIndex + 1;
			PageLayout nextPageLayout = getPage(nextPageIndex);

			int fittingBoxCount = nextPageLayout.getOutlierStartIndex(-overflow);
			// Schiebt alle Zeilen, die passen, von der Nachfolgeseite in die
			// aktuelle Seite
			if (fittingBoxCount > 0) {
				int toLineIndex = pageLayout.getBoxCount();

				nextPageLayout.moveHead(pageLayout, fittingBoxCount - 1);

				LineIndex fromLineIndexObject = new LineIndex(nextPageIndex, 0);
				LineIndex toLineIndexObject = new LineIndex(pageIndex, toLineIndex);
				onMovePageSegment(fromLineIndexObject, toLineIndexObject, fittingBoxCount);
			}

			// Wenn die Nachfolgeseite leer ist, wird sie gelöscht
			if (nextPageLayout.getBoxCount() == 0) {
				pageLayout.setCanCompensate(nextPageLayout.canCompensate());
				removePage(nextPageIndex);
				// Wurde die Nachfolgeseite gelöscht, rutschen die
				// Nachfolgeseiten hoch
				// Indizes dürfen nicht hochgezählt werden
			} else {
				pageIndex = nextPageIndex;
				pageLayout = nextPageLayout;
			}
		}
	}

	public abstract void onInsertPage(int pageIndex, PageLayout pageLayout);

	public abstract void onRemovePage(int pageIndex);

	public abstract void onInsertNewLine(LineIndex lineIndexObject, Orientation pageOrientation);

	public abstract void onRemoveLine(LineIndex lineIndex);

	public abstract void onSetBox(Box box, BoxIndex boxIndex);

	public abstract void onInsertBox(Box box, BoxIndex boxIndex, Orientation pageOrientation);

	public abstract void onRemoveBox(BoxIndex boxIndex);

	public abstract void onMoveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength);

	public abstract void onMovePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject,
			int segmentLength);

	public abstract void onMoveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject);

	public abstract void onRemoveSnippet(int pageIndex, int snippetIndex);

}
