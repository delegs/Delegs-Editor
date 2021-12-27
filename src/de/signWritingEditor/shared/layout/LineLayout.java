package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Orientation;

public class LineLayout extends OverflowListLayout {

	private static final int MARGIN_TOP = 5;
	private static final int BORDER_BOTTOM_WIDTH = 1;

	public LineLayout(Orientation orientation, int overflowThreshold) {
		super(orientation, overflowThreshold);
	}

	@Override
	public int getHeight_PX() {
		return super.getHeight_PX() + MARGIN_TOP + BORDER_BOTTOM_WIDTH;
	}

	@Override
	public int getMarginTop_PX() {
		return MARGIN_TOP;
	}

	@Override
	public int getMarginBottom_PX() {
		return BORDER_BOTTOM_WIDTH;
	}
}
