package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class FrameTokenBox extends AbstractIdBox implements TokenBox {

	private FrameToken token;
	private static final int MIN_FRAME_BOX_HEIGHT = 50;
	private static final int SELECTED_FRAME_PANEL_MARGIN = 3;
	private static final int SELECTED_FRAME_PANEL_BORDER_WIDTH = 3;
	public static final int FRAME_MARGIN_RIGHT = 6;
	private int maxWidth;
	private int minWidth;
	private int maxHeight;

	public FrameTokenBox(FrameToken frameToken, int minWidth, int maxWidth, int maxHeight) {
		super(frameToken.getId());

		assert frameToken != null : "Precondition failed: frameToken != null";
		assert minWidth >= 0 : "Precondition failed: width >= 0";
		assert maxWidth > 0 : "Precondition failed: width >= 0";

		this.token = frameToken;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;

		if (token.getWidth() + 2 * token.getBorderWidth_PX() + getDecorations() + getMarginRight() > maxWidth) {
			token.setWidth(maxWidth - (2 * token.getBorderWidth_PX() + getDecorations() + getMarginRight()));
		}
		if (token.getWidth() + 2 * token.getBorderWidth_PX() + getDecorations() + getMarginRight() < minWidth) {
			token.setWidth(minWidth - (2 * token.getBorderWidth_PX() + getDecorations() + getMarginRight()));
		}
		if (token.getHeight() + 2 * token.getBorderWidth_PX() + getDecorations() > maxHeight) {
			token.setHeight(maxHeight - (2 * token.getBorderWidth_PX() + getDecorations()));
		}
		if (token.getHeight() + 2 * token.getBorderWidth_PX() + getDecorations() < MIN_FRAME_BOX_HEIGHT) {
			token.setHeight(MIN_FRAME_BOX_HEIGHT - (2 * token.getBorderWidth_PX() + getDecorations()));
		}
	}

	@Override
	public float getWidth_PX() {
		return getTokenBoxWidth() + getDecorations() + getMarginRight();
	}

	public int getDecorations() {
		return 2 * SELECTED_FRAME_PANEL_MARGIN + 2 * SELECTED_FRAME_PANEL_BORDER_WIDTH;
	}

	public int getTokenBoxWidth() {
		return token.getWidth() + 2 * getBorderWidth_PX();
	}

	public int getMarginRight() {
		return FRAME_MARGIN_RIGHT;
	}

	@Override
	public int getHeight_PX() {
		return getTokenBoxHeight() + getDecorations();
	}

	public int getTokenBoxHeight() {
		return token.getHeight() + 2 * getBorderWidth_PX();
	}

	public Color getFrameColor() {
		return token.getFrameColor();
	}

	public int getBorderWidth_PX() {
		return token.getBorderWidth_PX();
	}

	@Override
	public String toString() {
		return "FrameTokenBox(TokenId: " + getId() + ")";
	}

	public void setWidth(int width) {
		assert width <= maxWidth : "Precondition failed: width <= maxWidth";
		assert width >= minWidth : "Precondition failed: width >= minWidth";

		if (!token.isLayoutLocked()) {
			int tokenBoxWidthDecorations = 2 * token.getBorderWidth_PX() + getDecorations() + getMarginRight();
			token.setWidth(width - tokenBoxWidthDecorations);
		}
	}

	public void setHeight(int height) {
		assert height <= maxHeight : "Precondition failed: height <= maxHeight";
		assert height >= MIN_FRAME_BOX_HEIGHT : "Precondition failed: height >= MIN_FRAME_BOX_HEIGHT";

		if (token.isLayoutLocked()) {
			int tokenBoxHeightDecorations = 2 * token.getBorderWidth_PX() + getDecorations();
			token.setHeight(height - tokenBoxHeightDecorations);
		}
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMinWidth() {
		return minWidth;
	}

	public int getMinHeight() {
		return MIN_FRAME_BOX_HEIGHT;
	}

	@Override
	public Color getBackgroundColor() {
		return token.getBackgroundColor();
	}

	public int getSelectionBorderWidth() {
		return SELECTED_FRAME_PANEL_BORDER_WIDTH;
	}

	@Override
	public boolean isLockedLayout() {
		return token.isLayoutLocked();
	}

	@Override
	public boolean isContentLocked() {
		return token.isContentLocked();
	}

}
