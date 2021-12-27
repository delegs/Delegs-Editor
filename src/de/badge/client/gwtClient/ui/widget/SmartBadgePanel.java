package de.badge.client.gwtClient.ui.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.badge.shared.i18n.BadgeI18NProvider;
import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;

public class SmartBadgePanel extends Composite {

	private static final int NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW = 2;
	private static final int NUMBER_OF_NEXT_TO_EARN_BADGES_ALWAYS_SHOW = 2;

	private List<Badge> badges;
	private Badge selectedBadge;
	private boolean selectedBadgeIsRecommended;

	private FlowPanel mainPanel;
	private Button olderBadgesVisibilityToggler;
	private FlowPanel hideableContentPanel;

	private FlowPanel nextToEarnBadgesPanel;
	private FlowPanel lastEarnedBadgesPanel;
	private FlowPanel hideableSmallBadgesPanel;

	private SimplePanel largeBadgePanel;
	private LargeBadgeWidget largeBadgeWidget;

	private List<ClickableSmallBadgeWidget> hideableSmallBadgeWidgets = new ArrayList<ClickableSmallBadgeWidget>();
	private List<ClickableSmallBadgeWidget> lastEarnedSmallBadgeWidgets = new ArrayList<ClickableSmallBadgeWidget>();
	private List<ClickableSmallBadgeWidget> nextToEarnSmallBadgeWidgets = new ArrayList<ClickableSmallBadgeWidget>();

	private int width;

	public SmartBadgePanel(List<Badge> badges, final BadgeI18NProvider i18nProvider) {
		assert badges != null : "Precondition failed: badges != null";
		assert badges.size() > 0 : "Precondition failed: badges.size() > 0";
		assert i18nProvider != null : "Precondition failed: i18nProvider != null";

		this.badges = badges;

		int childWidth = ClickableSmallBadgeWidget.getTotalPxWidth();
		int childsPerRow = NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW + NUMBER_OF_NEXT_TO_EARN_BADGES_ALWAYS_SHOW + 1;
		width = childsPerRow * childWidth;

		mainPanel = new FlowPanel();
		mainPanel.setStyleName("smartBadgePanel");
		mainPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		mainPanel.getElement().getStyle().setWidth(width, Unit.PX);
		initWidget(mainPanel);

		FlowPanel alwaysVisibleSmallBadgesAndTextContainerPanel = new FlowPanel();
		alwaysVisibleSmallBadgesAndTextContainerPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		alwaysVisibleSmallBadgesAndTextContainerPanel.getElement().getStyle().setProperty("marginLeft", "auto");
		alwaysVisibleSmallBadgesAndTextContainerPanel.getElement().getStyle().setProperty("marginRight", "auto");
		mainPanel.add(alwaysVisibleSmallBadgesAndTextContainerPanel);

		FlowPanel lastEarnedBadgesAndTextContainerPanel = new FlowPanel();
		lastEarnedBadgesAndTextContainerPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		lastEarnedBadgesAndTextContainerPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		lastEarnedBadgesAndTextContainerPanel.getElement().getStyle()
				.setWidth(100f * NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW / childsPerRow + 1, Unit.PCT);
		lastEarnedBadgesAndTextContainerPanel.getElement().getStyle().setProperty("verticalAlign", "top");
		alwaysVisibleSmallBadgesAndTextContainerPanel.add(lastEarnedBadgesAndTextContainerPanel);

		Label lastEarnedBadgesLabel = new Label(i18nProvider.getRecentlyReceivedBadges());
		lastEarnedBadgesLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		lastEarnedBadgesLabel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		lastEarnedBadgesAndTextContainerPanel.add(lastEarnedBadgesLabel);

		lastEarnedBadgesPanel = new FlowPanel();
		lastEarnedBadgesPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		lastEarnedBadgesAndTextContainerPanel.add(lastEarnedBadgesPanel);

		FlowPanel spacePanel = new FlowPanel();
		spacePanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		spacePanel.getElement().getStyle().setWidth(50f / childsPerRow, Unit.PCT);
		alwaysVisibleSmallBadgesAndTextContainerPanel.add(spacePanel);

		FlowPanel nextToEarnBadgesAndTextContainerPanel = new FlowPanel();
		nextToEarnBadgesAndTextContainerPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		nextToEarnBadgesAndTextContainerPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		nextToEarnBadgesAndTextContainerPanel.getElement().getStyle()
				.setWidth(100f * NUMBER_OF_NEXT_TO_EARN_BADGES_ALWAYS_SHOW / childsPerRow + 1, Unit.PCT);
		nextToEarnBadgesAndTextContainerPanel.getElement().getStyle().setProperty("verticalAlign", "top");
		alwaysVisibleSmallBadgesAndTextContainerPanel.add(nextToEarnBadgesAndTextContainerPanel);

		Label nextToEarnBadgesLabel = new Label(i18nProvider.getRecommendedNextBadges());
		nextToEarnBadgesLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		nextToEarnBadgesLabel.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		nextToEarnBadgesAndTextContainerPanel.add(nextToEarnBadgesLabel);

		nextToEarnBadgesPanel = new FlowPanel();
		nextToEarnBadgesPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		nextToEarnBadgesAndTextContainerPanel.add(nextToEarnBadgesPanel);

		olderBadgesVisibilityToggler = new Button(i18nProvider.getShowOlderBadges());
		olderBadgesVisibilityToggler.getElement().getStyle().setMargin(10, Unit.PX);
		olderBadgesVisibilityToggler.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hideableContentPanel.setVisible(!hideableContentPanel.isVisible());
				if (hideableContentPanel.isVisible()) {
					olderBadgesVisibilityToggler.setText(i18nProvider.getHideOlderBadges());
				} else {
					olderBadgesVisibilityToggler.setText(i18nProvider.getShowOlderBadges());
				}
			}
		});
		mainPanel.add(olderBadgesVisibilityToggler);
		olderBadgesVisibilityToggler
				.setVisible(getAmountOfEarnedBadges(badges) > NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW);

		hideableContentPanel = new FlowPanel();
		hideableContentPanel.setVisible(false);
		mainPanel.add(hideableContentPanel);

		hideableSmallBadgesPanel = new FlowPanel();
		hideableSmallBadgesPanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		hideableSmallBadgesPanel.getElement().getStyle().setProperty("marginLeft", "auto");
		hideableSmallBadgesPanel.getElement().getStyle().setProperty("marginRight", "auto");
		hideableSmallBadgesPanel.getElement().getStyle().setWidth(width, Unit.PX);
		hideableContentPanel.add(hideableSmallBadgesPanel);

		largeBadgePanel = new SimplePanel();
		largeBadgePanel.getElement().getStyle().setOverflow(Overflow.HIDDEN);
		largeBadgePanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mainPanel.add(largeBadgePanel);

		initBadgeWidgets(null);
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void updateBadges(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated) {
		assert badgesThatReachedANewLevel != null : "Precondition failed: badgesThatReachedANewLevel != null";
		assert badgesThatUpdated != null : "Precondition failed: badgesThatUpdated != null";
		assert badgesThatUpdated.size() > 0 : "Precondition failed: badgesThatUpdated.size() > 0";

		// they have the same id but different content
		badges.removeAll(badgesThatUpdated);
		badges.addAll(badgesThatUpdated);

		olderBadgesVisibilityToggler
				.setVisible(getAmountOfEarnedBadges(badges) > NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW);

		initBadgeWidgets(badgesThatReachedANewLevel);

		for (Badge badge : badgesThatUpdated) {
			if (badge.equals(selectedBadge)) {
				selectedBadge = badge;
			}
		}

		if (selectedBadge != null) {
			handleBadgeWasClicked(selectedBadge, selectedBadgeIsRecommended);
		}
	}

	public void selectRecommendedBadgeOfType(BadgeType badgeType) {
		assert badgeType != null : "Precondition failed: badgeType != null";

		for (Badge badge : badges) {
			if (badge.getBadgeType() == badgeType) {
				handleBadgeWasClicked(badge, true);
				break;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	private void initBadgeWidgets(List<Badge> optionalBadgesToBeMarked) {
		initTimeSortedBadges(optionalBadgesToBeMarked);
		initRecommendedBadges(optionalBadgesToBeMarked);
	}

	private void initTimeSortedBadges(List<Badge> optionalBadgesToBeMarked) {
		List<Badge> leftOverBadges = new ArrayList<Badge>();

		for (Badge badge : badges) {
			if (badge.getCurrentLevel() != BadgeLevel.NONE) {
				leftOverBadges.add(badge);
			}
		}
		// Init the badges that were recently earned
		Badge.Comparators.BY_LATEST_EARNED.sort(leftOverBadges);

		lastEarnedSmallBadgeWidgets.clear();
		lastEarnedBadgesPanel.clear();

		int size = leftOverBadges.size();
		for (int i = 0; i < Math.min(NUMBER_OF_LAST_EARNED_BADGES_TO_ALWAYS_SHOW, size); i++) {
			final Badge badge = leftOverBadges.remove(0);
			ClickableSmallBadgeWidget badgeWidget = new ClickableSmallBadgeWidget(badge, new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					handleBadgeWasClicked(badge, false);
				}
			});
			boolean shouldBeMarked = optionalBadgesToBeMarked != null && optionalBadgesToBeMarked.contains(badge);
			badgeWidget.setMark(shouldBeMarked);
			lastEarnedSmallBadgeWidgets.add(badgeWidget);
			lastEarnedBadgesPanel.add(badgeWidget);
		}

		assert lastEarnedSmallBadgeWidgets != null : "Postcondition failed: lastEarnedSmallBadgeWidgets != null";

		// init the badges that were earned longer ago
		hideableSmallBadgesPanel.clear();
		hideableSmallBadgeWidgets.clear();

		for (int i = 0; i < leftOverBadges.size(); i++) {
			final Badge badge = leftOverBadges.get(i);
			ClickableSmallBadgeWidget badgeWidget = new ClickableSmallBadgeWidget(badge, new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					handleBadgeWasClicked(badge, false);
				}
			});
			boolean shouldBeMarked = optionalBadgesToBeMarked != null && optionalBadgesToBeMarked.contains(badge);
			badgeWidget.setMark(shouldBeMarked);
			hideableSmallBadgesPanel.add(badgeWidget);
			hideableSmallBadgeWidgets.add(badgeWidget);
		}

		assert hideableSmallBadgeWidgets != null : "Postcondition failed: hideableSmallBadgeWidgets != null";
	}

	private void initRecommendedBadges(List<Badge> optionalBadgesToBeMarked) {
		Badge.Comparators.BY_LEARN_PATH.sort(badges);

		nextToEarnSmallBadgeWidgets.clear();
		nextToEarnBadgesPanel.clear();

		for (int i = 0; i < Math.min(NUMBER_OF_NEXT_TO_EARN_BADGES_ALWAYS_SHOW, badges.size()); i++) {
			final Badge badge = badges.get(i);
			ClickableSmallBadgeWidget badgeWidget = new ClickableSmallBadgeWidget(badge, true, new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					handleBadgeWasClicked(badge, true);
				}
			});
			nextToEarnSmallBadgeWidgets.add(badgeWidget);
			nextToEarnBadgesPanel.add(badgeWidget);
		}
	}

	private void handleBadgeWasClicked(Badge badge, boolean wasRecommendedBadge) {
		assert badge != null : "Precondition failed: badge != null";

		selectedBadge = badge;
		selectedBadgeIsRecommended = wasRecommendedBadge;
		if (largeBadgeWidget != null) {
			largeBadgePanel.remove(largeBadgeWidget);
		}
		largeBadgeWidget = new LargeBadgeWidget(badge, wasRecommendedBadge);
		largeBadgePanel.add(largeBadgeWidget);

		for (ClickableSmallBadgeWidget widget : hideableSmallBadgeWidgets) {
			widget.setSelected(!wasRecommendedBadge && widget.getBadge().equals(badge));
		}
		for (ClickableSmallBadgeWidget widget : lastEarnedSmallBadgeWidgets) {
			widget.setSelected(!wasRecommendedBadge && widget.getBadge().equals(badge));
		}
		for (ClickableSmallBadgeWidget widget : nextToEarnSmallBadgeWidgets) {
			widget.setSelected(wasRecommendedBadge && widget.getBadge().equals(badge));
		}
	}

	private int getAmountOfEarnedBadges(List<Badge> badges) {
		int amount = 0;

		for (Badge badge : badges) {
			if (badge.isEarned()) {
				amount++;
			}
		}

		return amount;
	}

}
