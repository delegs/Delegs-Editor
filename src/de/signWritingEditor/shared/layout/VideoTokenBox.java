package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.VideoToken;

public class VideoTokenBox extends AbstractIdBox implements TokenBox {

	private static final int URL_TEXTBOX_HEIGHT_PX = 18;
	private static final int MIN_VIDEO_BOX_HEIGHT = 120;
	private static final int BUTTON_PANEL_HEIGHT = 10;
	private static final int MIN_MARGIN_BETWEEN_VIDEO_AND_TEXT_PX = 0;

	public static int getUrlTextboxHeight() {
		return URL_TEXTBOX_HEIGHT_PX;
	}

	private static final int MARGIN_RIGHT_PX = 5;
	private static final int BOTTOM_TEXT_PADDING_PX = 3;
	private static final int LEFT_TEXT_PADDING = 1;

	private VideoToken token;
	private int minWidth;
	private int maxWidth;
	private int maxHeight;
	private int marginBetweenVideoAndText_PX;

	public VideoTokenBox(VideoToken token, int minWidth, int maxWidth, int maxHeight) {
		super(token.getId());
		this.token = token;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.marginBetweenVideoAndText_PX = MIN_MARGIN_BETWEEN_VIDEO_AND_TEXT_PX;

		assert minWidth < maxWidth : "Precondition failed: minWidth < maxWidth";
		assert MIN_VIDEO_BOX_HEIGHT < maxHeight : "Precondition failed: MIN_VIDEO_BOX_HEIGHT < maxHeight";

		if (maxHeight < token.getHeight()) {
			scaleDown(maxHeight, token.getHeight());
		}
		if (maxWidth - MARGIN_RIGHT_PX < token.getWidth()) {
			scaleDown(maxWidth - MARGIN_RIGHT_PX, token.getWidth());
		}
		if (MIN_VIDEO_BOX_HEIGHT > token.getHeight()) {
			scaleUp(MIN_VIDEO_BOX_HEIGHT, token.getHeight());
		}
		if (minWidth > token.getWidth()) {
			scaleUp(minWidth, token.getWidth());
		}

	}

	private void scaleUp(int minAllowedValue, int value) {
		double distance = ((double) value) / ((double) minAllowedValue);

		assert token.getHeight()
				* distance <= maxHeight : "Precondition failed: imageToken.getHeight() * distance <= maxHeight";
		assert token.getWidth()
				* distance <= maxWidth : "Precondition failed: imageToken.getWidth() * distance <= maxWidth";

		token.setWidth((int) Math.ceil((token.getWidth() * distance)));
		token.setHeight((int) Math.ceil((token.getHeight() * distance)));
	}

	private void scaleDown(int maxAllowedValue, int value) {
		double distance = ((double) maxAllowedValue) / ((double) value);

		assert token.getHeight()
				* distance >= getMinHeight() : "Precondition failed: imageToken.getHeight() * distance >= getMinHeight()";
		assert token.getWidth()
				* distance >= getMinWidth() : "Precondition failed: imageToken.getWidth() * distance >= getMinWidth()";

		token.setWidth((int) Math.floor((token.getWidth() * distance)));
		token.setHeight((int) Math.floor((token.getHeight() * distance)));
	}

	public int getMinWidth() {
		return minWidth;
	}

	public void setMaxWidth(int newMaxWidth) {
		maxWidth = newMaxWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	@Override
	public Id getId() {
		return token.getId();
	}

	@Override
	public float getWidth_PX() {
		return token.getWidth() + MARGIN_RIGHT_PX;
	}

	public void setWidth(int newWidth) {
		token.setWidth(newWidth);
	}

	@Override
	public int getHeight_PX() {
		return token.getHeight();
	}

	public int getHeightWithMargin_PX() {
		return token.getHeight() + marginBetweenVideoAndText_PX;
	}

	public void setHeight(int newHeight) {
		token.setHeight(newHeight);
	}

	@Override
	public Color getBackgroundColor() {
		return token.getBackgroundColor();
	}

	public Color getTextBackgroundColor() {
		return token.getTextBackgroundColor();
	}

	public String getUrl() {
		return token.getUrl();
	}

	public void setUrl(String url) {
		token.setUrl(url);
	}

	public boolean isURLVisible() {
		return token.isUrlVisible();
	}

	public void setURLVisible(boolean isURLVisible) {
		token.setUrlVisible(isURLVisible);
	}

	public int getURLBoxHeight_PX() {
		return URL_TEXTBOX_HEIGHT_PX;
	}

	public int getMarginRight_PX() {
		return MARGIN_RIGHT_PX;
	}

	public int getBottomTextPadding_PX() {
		return BOTTOM_TEXT_PADDING_PX;
	}

	public int getLeftTextPadding() {
		return LEFT_TEXT_PADDING;
	}

	public int getMinHeight() {
		return MIN_VIDEO_BOX_HEIGHT;
	}

	public int getButtonPanelHeight() {
		return BUTTON_PANEL_HEIGHT;
	}

	public void updateMarginBetweenVideoAndText(int maxHeight) {
		marginBetweenVideoAndText_PX = maxHeight - URL_TEXTBOX_HEIGHT_PX;
		if (marginBetweenVideoAndText_PX < MIN_MARGIN_BETWEEN_VIDEO_AND_TEXT_PX) {
			marginBetweenVideoAndText_PX = MIN_MARGIN_BETWEEN_VIDEO_AND_TEXT_PX;
		}
	}

	public int getMarginBetweenVideoAndTextPX() {
		return marginBetweenVideoAndText_PX;
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
