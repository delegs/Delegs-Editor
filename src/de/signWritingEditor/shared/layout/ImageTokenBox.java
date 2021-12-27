package de.signWritingEditor.shared.layout;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.TokenBox;

public class ImageTokenBox extends AbstractIdBox implements TokenBox {

	private static final int RESIZE_BUTTON_HEIGHT = 10;
	private static final int URL_TEXTBOX_HEIGHT_PX = 18;
	private static final int MIN_IMAGE_BOX_HEIGHT = 110;
	private static final int MARGIN_RIGHT = 5;
	private static final int BOTTOM_TEXT_PADDING = 3;
	private static final int BUTTON_PANEL_HEIGHT = 10;
	private static final int MIN_MARGIN_BETWEEN_IMAGE_AND_TEXT_PX = 0;
	private ImageToken imageToken;
	private int minWidth;
	private int maxWidth;
	private int maxHeight;
	private int marginBetweenImageAndText_PX;

	public ImageTokenBox(ImageToken imageToken, int minWidth, int maxWidth, int maxHeight) {
		super(imageToken.getId());
		this.imageToken = imageToken;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.marginBetweenImageAndText_PX = MIN_MARGIN_BETWEEN_IMAGE_AND_TEXT_PX;

		assert minWidth < maxWidth : "Precondition failed: minWidth < maxWidth";
		assert MIN_IMAGE_BOX_HEIGHT < maxHeight : "Precondition failed: MIN_IMAGE_BOX_HEIGHT < maxHeight";

		if (maxHeight < imageToken.getHeight()) {
			scaleDown(maxHeight, imageToken.getHeight());
		}
		if (maxWidth - MARGIN_RIGHT < imageToken.getWidth()) {
			scaleDown(maxWidth - MARGIN_RIGHT, imageToken.getWidth());
		}
		if (MIN_IMAGE_BOX_HEIGHT > imageToken.getHeight()) {
			scaleUp(MIN_IMAGE_BOX_HEIGHT, imageToken.getHeight());
		}
		if (minWidth > imageToken.getWidth()) {
			scaleUp(minWidth, imageToken.getWidth());
		}

	}

	private void scaleUp(int minAllowedValue, int value) {
		double distance = ((double) value) / ((double) minAllowedValue);

		assert imageToken.getHeight()
				* distance <= maxHeight : "Precondition failed: imageToken.getHeight() * distance <= maxHeight";
		assert imageToken.getWidth()
				* distance <= maxWidth : "Precondition failed: imageToken.getWidth() * distance <= maxWidth";

		imageToken.setWidth((int) Math.ceil((imageToken.getWidth() * distance)));
		imageToken.setHeight((int) Math.ceil((imageToken.getHeight() * distance)));
	}

	private void scaleDown(int maxAllowedValue, int value) {
		double distance = ((double) maxAllowedValue) / ((double) value);

		assert imageToken.getHeight()
				* distance >= getMinHeight() : "Precondition failed: imageToken.getHeight() * distance >= getMinHeight()";
		assert imageToken.getWidth()
				* distance >= getMinWidth() : "Precondition failed: imageToken.getWidth() * distance >= getMinWidth()";

		imageToken.setWidth((int) Math.floor((imageToken.getWidth() * distance)));
		imageToken.setHeight((int) Math.floor((imageToken.getHeight() * distance)));
	}

	public void setWidth(int newWidth) {
		assert newWidth <= maxWidth - MARGIN_RIGHT : "Precondition failed: newWidth < maxWidth - MARGIN_RIGHT";
		assert newWidth >= minWidth : "Precondition failed: newWidth > minWidth";
		imageToken.setWidth(newWidth);
	}

	@Override
	public float getWidth_PX() {
		return imageToken.getWidth() + MARGIN_RIGHT;
	}

	public void setHeight(int newHeight) {
		assert newHeight <= maxHeight : "Precondition failed: newHeight < maxHeight";
		assert newHeight >= MIN_IMAGE_BOX_HEIGHT : "Precondition failed: newHeight > MIN_IMAGE_BOX_HEIGHT";
		imageToken.setHeight(newHeight);
	}

	@Override
	public int getHeight_PX() {
		return imageToken.getHeight();
	}

	public int getHeightWithMargin_PX() {
		return imageToken.getHeight() + marginBetweenImageAndText_PX;
	}

	@Override
	public Color getBackgroundColor() {
		return imageToken.getBackgroundColor();
	}

	public String getUrl() {
		return imageToken.getUrl().replaceAll("\\p{Cc}", "");
	}

	public void setUrl(String url) {
		imageToken.setUrl(url);
	}

	public void setMaxWidth(int newMaxWidth) {
		maxWidth = newMaxWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMinWidth() {
		return minWidth;
	}

	public int getURLBoxHeight_PX() {
		return URL_TEXTBOX_HEIGHT_PX;
	}

	public int getMarginRight() {
		return MARGIN_RIGHT;
	}

	public int getBottomTextPadding() {
		return BOTTOM_TEXT_PADDING;
	}

	public int getResizeButtonHeight() {
		return RESIZE_BUTTON_HEIGHT;
	}

	public int getMinHeight() {
		return MIN_IMAGE_BOX_HEIGHT;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public int getButtonPanelHeight() {
		return BUTTON_PANEL_HEIGHT;
	}

	public void updateMarginBetweenImageAndText(int maxHeight) {
		marginBetweenImageAndText_PX = maxHeight - URL_TEXTBOX_HEIGHT_PX;
		if (marginBetweenImageAndText_PX < MIN_MARGIN_BETWEEN_IMAGE_AND_TEXT_PX) {
			marginBetweenImageAndText_PX = MIN_MARGIN_BETWEEN_IMAGE_AND_TEXT_PX;
		}
	}

	public int getMarginBetweenImageAndTextPX() {
		return marginBetweenImageAndText_PX;
	}

	@Override
	public boolean isLockedLayout() {
		return imageToken.isLayoutLocked();
	}

	@Override
	public boolean isContentLocked() {
		return imageToken.isContentLocked();
	}
}
