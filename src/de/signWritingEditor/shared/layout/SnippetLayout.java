package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Orientation;

public class SnippetLayout extends OverflowListLayout {

	private static final int SNIPPET_PADDING_PX = 15;
	private static final int TOKEN_MARGIN_BOTTOM = 5;
	private int x_PX;
	private int y_PX;
	private int z;
	private int width_PX;
	private boolean automaticResize;

	public SnippetLayout(int x, int y, int z, int width, int maxWidth) {
		this(Orientation.HORIZONTAL, x, y, z, width, maxWidth);
	}

	/**
	 * {@link CollagePageLayout} is always in {@link Orientation#HORIZONTAL}
	 * 
	 * @param orientation
	 * @param x_PX
	 * @param y_PX
	 * @param width_PX
	 */
	private SnippetLayout(Orientation orientation, int x_PX, int y_PX, int z, int width_PX, int maxWidth) {
		super(orientation, width_PX);
		this.x_PX = x_PX;
		this.y_PX = y_PX;
		this.width_PX = width_PX;
		this.z = z;
		addBox(new LineLayout(orientation, getInnerWidth_PX()));
	}

	public int getX_PX() {
		return x_PX;
	}

	public void setX(int x) {
		this.x_PX = x;
	}

	public int getY_PX() {
		return y_PX;
	}

	public void setY(int y) {
		this.y_PX = y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public float getWidth_PX() {
		return width_PX;
	}

	@Override
	public int getHeight_PX() {
		return computeHeight_PX();
	}

	public LineLayout getLine(int lineIndex) {
		assert lineIndex >= 0 : "Precondition failed: lineIndex >= 0";
		assert lineIndex < getBoxCount() : "Precondition failed: lineIndex < getBoxCount()";

		return (LineLayout) getBox(lineIndex);
	}

	public int computeHeight_PX() {
		int result_PX = 0;

		for (int i = 0; i < getBoxCount(); i++) {
			Box box = getBox(i);
			result_PX += box.getHeight_PX();
		}
		return result_PX;
	}

	@Override
	public boolean canCompensate() {
		return false;
	}

	@Override
	public void setCanCompensate(boolean canCompensate) {
		// Never Compensate
	}

	@Override
	public float getOverflow() {
		return -super.getOverflowThreshold();
	}

	public void setWidth(int width) {
		this.width_PX = width;
	}

	public void setInnerWidth(int width) {
		this.width_PX = width + 2 * SNIPPET_PADDING_PX;
	}

	public boolean isAutomaticResizeActive() {
		return automaticResize;
	}

	public void setAutomaticResize(boolean automaticResize) {
		this.automaticResize = automaticResize;
	}

	@Override
	public int getInnerWidth_PX() {
		int innerWidth_PX = width_PX - 2 * SNIPPET_PADDING_PX;
		return innerWidth_PX > 0 ? innerWidth_PX : 2 * SNIPPET_PADDING_PX;
	}

	@Override
	public int getMarginTop_PX() {
		return SNIPPET_PADDING_PX;
	}

	@Override
	public int getMarginBottom_PX() {
		return SNIPPET_PADDING_PX;
	}

	public static int getSnippetPadding_PX() {
		return SNIPPET_PADDING_PX;
	}

	public static int getTokenMarginBottom() {
		return TOKEN_MARGIN_BOTTOM;
	}
}
