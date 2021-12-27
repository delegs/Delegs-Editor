package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class ContinuousPageLayout extends PageLayout {

	public ContinuousPageLayout(PageFormat pageFormat) {
		super(pageFormat);
	}

	public void insertNewLine(int lineIndex) {
		assert lineIndex >= 0 : "Precondition failed: lineIndex >= 0";
		assert lineIndex <= getBoxCount() : "Precondition failed: lineIndex <= getBoxCount()";
		insertBox(new LineLayout(getOrientation().toggle(), getLineOverflowThreshold()), lineIndex);
	}

	public int getLineCount() {
		int result = getBoxCount();
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public OverflowListLayout getLine(int lineIndex) {
		assert lineIndex >= 0 : "Precondition failed: lineIndex >= 0";
		assert lineIndex < getLineCount() : "Precondition failed: lineIndex < getLineCount()";
		return (OverflowListLayout) getBox(lineIndex);
	}

	public void setMaxSize(int maxWidth, int maxHeight) {
		assert maxWidth >= 0 : "Precondition failed: maxWidth >= 0";
		assert maxHeight >= 0 : "Precondition failed: maxHeight >= 0";

		super.setMaxSize(maxWidth, maxHeight);

		for (int i = 0, n = getLineCount(); i < n; i++) {
			getLine(i).setOverflowThreshold(getLineOverflowThreshold());
		}

		assert getMaxWidth() == maxWidth : "Postcondition failed: getMaxWidth() == maxWidth";
		assert getMaxHeight() == maxHeight : "Postcondition failed: getMaxHeight() == maxHeight";
	}
}
