package de.badge.client.gwtClient.ui.widget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

import de.badge.shared.model.material.Badge;

public class BadgePanel extends Composite {

	private FlowPanel mainPanel;
	private Map<Badge, LargeBadgeWidget> containedBadgesMap = new HashMap<Badge, LargeBadgeWidget>();
	private List<Badge> badges;
	private int widthInPx;

	public BadgePanel(List<Badge> badges) {
		assert badges != null : "Precondition failed: badges != null";

		this.badges = badges;

		mainPanel = new FlowPanel();
		mainPanel.setStyleName("badgePanel");
		mainPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		initWidget(mainPanel);

		initBadges();
	}

	public int getWidthInPx() {
		return widthInPx;
	}

	private void initBadges() {
		assert badges != null : "Precondition failed: badges != null";

		Badge.Comparators.BY_ID.sort(badges);

		containedBadgesMap.clear();

		for (int i = 0; i < badges.size(); i++) {
			LargeBadgeWidget badgeWidget = new LargeBadgeWidget(badges.get(i));
			containedBadgesMap.put(badges.get(i), badgeWidget);
			mainPanel.add(badgeWidget);
			if (i == 0) {
				updateSize(badgeWidget.getTotalPxWidth(), badges.size());
			}
		}
	}

	private void updateSize(int childWidth, int amountOfChilds) {
		assert childWidth != 0 : "Precondition failed: childWidth != 0";

		int desiredSize = 0;
		int maximumChildsSupportedInARow = (RootPanel.get().getElement().getOffsetWidth()) / childWidth;
		desiredSize = Math.min(amountOfChilds, maximumChildsSupportedInARow);
		desiredSize *= childWidth;
		if (desiredSize != 0) {
			mainPanel.setWidth(desiredSize + "px");
			widthInPx = desiredSize;
		}
	}

}
