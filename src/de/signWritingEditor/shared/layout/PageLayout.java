package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.PageFormat;

public abstract class PageLayout extends OverflowListLayout {

	private PageFormat pageFormat;
	private int lineOverflowThreshold;

	public PageLayout(PageFormat pageFormat) {
		super(pageFormat.getOrientation(), (VERTICAL.equals(pageFormat.getOrientation())
				? pageFormat.getPixelInnerHeight() : pageFormat.getPixelInnerWidth()));

		assert pageFormat != null : "Precondition failed: pageFormat != null";

		this.pageFormat = pageFormat;
		this.lineOverflowThreshold = (VERTICAL.equals(pageFormat.getOrientation()) ? pageFormat.getPixelInnerWidth()
				: pageFormat.getPixelInnerHeight());

		assert getPageDimension() == pageFormat : "Postcondition failed: getPageDimension() == pageFormat";
	}

	public PageFormat getPageDimension() {
		assert pageFormat != null : "Postcondition failed: result != null";
		return pageFormat;
	}

	public int getLineOverflowThreshold() {
		assert lineOverflowThreshold >= 0 : "Postcondition failed: result >= 0";
		return lineOverflowThreshold;
	}

	public int getMaxWidth() {
		int result = 0;
		if (VERTICAL.equals(getOrientation())) {
			result = getLineOverflowThreshold();
		} else {
			result = getOverflowThreshold();
		}
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getMaxHeight() {
		int result = 0;
		if (VERTICAL.equals(getOrientation())) {
			result = getOverflowThreshold();
		} else {
			result = getLineOverflowThreshold();
		}
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public void setMaxSize(int maxWidth, int maxHeight) {
		assert maxWidth >= 0 : "Precondition failed: maxWidth >= 0";
		assert maxHeight >= 0 : "Precondition failed: maxHeight >= 0";

		maxHeight = maxHeight - pageFormat.getPixelPaddingTop() - pageFormat.getPixelPaddingBottom();
		maxWidth = maxWidth - pageFormat.getPixelPaddingLeft_PX() - pageFormat.getPixelPaddingRight();

		if (VERTICAL.equals(getOrientation())) {
			setOverflowThreshold(maxHeight);
			lineOverflowThreshold = maxWidth;
		} else {
			setOverflowThreshold(maxWidth);
			lineOverflowThreshold = maxHeight;
		}

		assert getMaxWidth() == maxWidth : "Postcondition failed: getMaxWidth() == maxWidth";
		assert getMaxHeight() == maxHeight : "Postcondition failed: getMaxHeight() == maxHeight";
	}

	@Override
	public int getMarginTop_PX() {
		return 0;
	}

	@Override
	public int getMarginBottom_PX() {
		return 0;
	}

}
