package de.badge.client.gwtClient.ui.widget;

import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.badge.shared.model.material.Badge;

public class LargeBadgeWidget extends Composite {

	private static final int CONTENT_HEIGHT = 400;
	private static final int CONTENT_WIDTH = 300;
	private static final int BORDER_SIZE = 1;
	private static final int PADDING_SIZE = 10;
	private static final int MARGIN_SIZE = 10;
	private static final int BADGE_IMAGE_DIMENSIONS = 100;

	public LargeBadgeWidget(Badge badge) {
		this(badge, false);
	}

	public LargeBadgeWidget(Badge badge, boolean fakeNextLevelBadge) {
		assert badge != null : "Precondition failed: badge != null";

		FlowPanel mainPanel = new FlowPanel();
		mainPanel.setStyleName("largeBadgeWidget");
		mainPanel.getElement().getStyle().setPadding(MARGIN_SIZE, Unit.PX);
		mainPanel.getElement().getStyle().setMargin(PADDING_SIZE, Unit.PX);
		mainPanel.getElement().getStyle().setBorderWidth(BORDER_SIZE, Unit.PX);
		mainPanel.getElement().getStyle().setBorderColor("#E3E3E3");
		mainPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		mainPanel.getElement().getStyle().setWidth(CONTENT_WIDTH, Unit.PX);
		mainPanel.getElement().getStyle().setHeight(CONTENT_HEIGHT, Unit.PX);
		mainPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		mainPanel.getElement().getStyle().setVerticalAlign(VerticalAlign.TOP);
		initWidget(mainPanel);

		SimplePanel badgeImageContainer = new SimplePanel();
		badgeImageContainer.setStyleName("badgeImageContainer");
		badgeImageContainer.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		Image badgeImage = new Image();
		if (fakeNextLevelBadge) {
			badgeImage.setUrl(badge.getNextLevelImageAsBase64());
			badgeImage.getElement().getStyle().setOpacity(0.6);
		} else {
			badgeImage.setUrl(badge.getImageAsBase64());
		}
		badgeImage.setPixelSize(BADGE_IMAGE_DIMENSIONS, BADGE_IMAGE_DIMENSIONS);
		badgeImage.getElement().getStyle().setMarginTop(10, Unit.PX);
		badgeImageContainer.add(badgeImage);
		mainPanel.add(badgeImageContainer);

		SimplePanel badgeTitlePanel = new SimplePanel();
		badgeTitlePanel.setStyleName("badgeTitlePanel");
		badgeTitlePanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		badgeTitlePanel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		badgeTitlePanel.getElement().getStyle().setFontSize(30, Unit.PX);
		badgeTitlePanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		Label badgeTitle = new Label(badge.getTitle());
		badgeTitlePanel.add(badgeTitle);
		mainPanel.add(badgeTitlePanel);

		HTML badgeEarnedLabel;
		if (fakeNextLevelBadge) {
			badgeEarnedLabel = new HTML(badge.getNextLevelBadgeEarnedText());
		} else {
			badgeEarnedLabel = new HTML(badge.getBadgeEarnedText());
		}
		badgeEarnedLabel.getElement().getStyle().setPaddingBottom(10, Unit.PX);
		badgeEarnedLabel.getElement().getStyle().setPaddingTop(5, Unit.PX);
		badgeEarnedLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		badgeEarnedLabel.getElement().getStyle().setColor("#666666");
		mainPanel.add(badgeEarnedLabel);

		HTMLPanel descriptionPanel = new HTMLPanel(ParagraphElement.TAG, badge.getDescription());
		descriptionPanel.setStyleName("descriptionPanel");
		descriptionPanel.getElement().getStyle().setPadding(10, Unit.PX);
		descriptionPanel.getElement().getStyle().setMargin(0, Unit.PX);
		descriptionPanel.getElement().getStyle().setLineHeight(20, Unit.PX);
		descriptionPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mainPanel.add(descriptionPanel);

		HTML horizontalRow = new HTML("<hr style=\"color:#CCCCCC\" noshade/>");
		horizontalRow.getElement().getStyle().setHeight(1, Unit.PX);
		horizontalRow.getElement().getStyle().setWidth(30, Unit.PCT);
		horizontalRow.getElement().getStyle().setProperty("margin", "auto");
		mainPanel.add(horizontalRow);

		HTMLPanel statusPanel = new HTMLPanel(ParagraphElement.TAG, badge.getStatus());
		statusPanel.setStyleName("statusPanel");
		statusPanel.getElement().getStyle().setPadding(10, Unit.PX);
		statusPanel.getElement().getStyle().setMargin(0, Unit.PX);
		statusPanel.getElement().getStyle().setLineHeight(20, Unit.PX);
		statusPanel.getElement().getStyle().setProperty("marginTop", "auto");
		statusPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		statusPanel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		mainPanel.add(statusPanel);
	}

	public int getTotalPxWidth() {
		return CONTENT_WIDTH + 2 * (BORDER_SIZE + PADDING_SIZE + MARGIN_SIZE);
	}

}
