package de.badge.client.gwtClient.ui.widget;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import de.badge.shared.model.material.Badge;

public class ClickableSmallBadgeWidget extends Composite {

	private static final int CONTENT_WIDTH = 80;
	private static final int PADDING_SIZE = 0;
	private static final int MARGIN_SIZE = 10;
	private static final int BADGE_IMAGE_DIMENSIONS = 60;

	private FlowPanel mainPanel;
	private Image badgeImage;

	private Badge badge;

	private boolean isMarked = false;
	private boolean isSelected;

	public ClickableSmallBadgeWidget(Badge badge, final ClickHandler clickHandler) {
		this(badge, false, clickHandler);
	}

	public ClickableSmallBadgeWidget(Badge badge, boolean fakeNextLevelBadge, final ClickHandler clickHandler) {
		assert badge != null : "Precondition failed: badge != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		this.badge = badge;

		mainPanel = new FlowPanel();
		mainPanel.setStyleName("clickableSmallBadgeWidget");
		mainPanel.getElement().getStyle().setPadding(PADDING_SIZE, Unit.PX);
		mainPanel.getElement().getStyle().setMargin(MARGIN_SIZE, Unit.PX);
		mainPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		mainPanel.getElement().getStyle().setWidth(CONTENT_WIDTH, Unit.PX);
		mainPanel.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
		setMark(isMarked);
		initWidget(mainPanel);

		FlowPanel badgeImageContainer = new FlowPanel();
		badgeImageContainer.setStyleName("badgeImageContainer");
		badgeImageContainer.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mainPanel.add(badgeImageContainer);

		badgeImage = new Image();
		if (fakeNextLevelBadge) {
			badgeImage.setUrl(getBadge().getNextLevelImageAsBase64());
			badgeImage.getElement().getStyle().setOpacity(0.6);
		} else {
			badgeImage.setUrl(getBadge().getImageAsBase64());
		}
		badgeImage.setPixelSize(BADGE_IMAGE_DIMENSIONS, BADGE_IMAGE_DIMENSIONS);
		badgeImage.getElement().getStyle().setCursor(Cursor.POINTER);
		badgeImage.getElement().getStyle().setPadding(10, Unit.PX);
		badgeImageContainer.add(badgeImage);
		badgeImage.addClickHandler(clickHandler);

		Label badgeImageTitle = new Label(getBadge().getTitle());
		badgeImageContainer.add(badgeImageTitle);
	}

	public void setMark(boolean mark) {
		if (isMarked != mark) {
			isMarked = mark;
			if (isMarked) {
				mainPanel.addStyleName("opacityChanger");
			} else {
				mainPanel.removeStyleName("opacityChanger");
				mainPanel.getElement().getStyle().setOpacity(1);
			}
		}
	}

	public void setSelected(boolean show) {
		isSelected = show;
		if (isSelected) {
			// remove mark as soon as the badge is selected
			setMark(false);
			badgeImage.getElement().getStyle().setBackgroundColor("#ABC9E1");
		} else {
			badgeImage.getElement().getStyle().setBackgroundColor("#FFFFFF");
		}

	}

	public Badge getBadge() {
		return badge;
	}

	public static int getTotalPxWidth() {
		return CONTENT_WIDTH + 2 * (PADDING_SIZE + MARGIN_SIZE);
	}

}
