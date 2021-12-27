package de.signWritingEditor.shared.layout;

import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public class CollagePageLayout extends PageLayout {

	private Id collagePageId;
	private boolean showCollageGrid;

	public CollagePageLayout(PageFormat pageFormat, Id collagePageId, boolean showCollageGrid) {
		super(pageFormat);
		this.collagePageId = collagePageId;
		this.showCollageGrid = showCollageGrid;
	}

	@Override
	public void setOverflowThreshold(int overflowThreshold) {
		// Disabled due to no automatic layouting
	}

	@Override
	public void setCanCompensate(boolean canCompensate) {
		// Disabled due to no automatic layouting
	}

	@Override
	public boolean canCompensate() {
		return false;
	}

	@Override
	public float getOverflow() {
		return -this.getMaxWidth();
	}

	public void insertNewSnippet(int snippetIndex, int x, int y, int z, int width) {
		insertBox(createSnippet(x, y, z, width), snippetIndex);
	}

	public Id getCollagePageId() {
		return collagePageId;
	}

	private Box createSnippet(int x, int y, int z, int width) {
		return new SnippetLayout(x, y, z, width, getMaxWidth());
	}

	@Override
	public int getMaxWidth() {
		return super.getPageDimension().getPixelWidth();
	}

	@Override
	public int getMaxHeight() {
		return super.getPageDimension().getPixelHeight();
	}

	public boolean showCollageGrid() {
		return showCollageGrid;
	}

	public void setCollageGridVisibility(boolean showGrid) {
		showCollageGrid = showGrid;
	}

	public int getTopMostSnippetID() {
		List<Box> boxes = super.getBox();
		SnippetLayout sL = (SnippetLayout) boxes.get(0);
		int ID = 0;
		for (int i = 1; i < boxes.size(); i++) {
			SnippetLayout sLOther = (SnippetLayout) boxes.get(i);
			if (sL.getY_PX() > sLOther.getY_PX()) {
				sL = sLOther;
				ID = i;
			} else if (sL.getY_PX() == sLOther.getY_PX()) {
				if (sL.getX_PX() > sLOther.getX_PX()) {
					sL = sLOther;
					ID = i;
				}

			}
		}
		return ID;
	}
}
