package de.badge.client.gwtClient.ui.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.badge.client.gwtClient.ui.resources.BadgeImageProvider;
import de.badge.client.gwtService.BadgeService;
import de.badge.client.gwtService.BadgeService.BadgesUpdatedListener;
import de.badge.shared.i18n.BadgeI18NProvider;
import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;

public class BadgeProfileWidget extends Composite {

	private FlowPanel contentPanel;
	private Image loader;

	private SmartBadgePanel smartBadgePanel;
	private SimplePanel badgePanelContainer;
	private Label goldAmount;
	private Label silverAmount;
	private Label bronzeAmount;

	private BadgeService badgeService;
	private BadgeI18NProvider i18nProvider;

	List<BadgeProfilePanelListener> listeners = new ArrayList<BadgeProfilePanelListener>();

	public BadgeProfileWidget(BadgeService badgeService, BadgeImageProvider badgeImageProvider,
			BadgeI18NProvider i18nProvider) {
		assert badgeService != null : "Precondition failed: badgeService != null";
		assert badgeImageProvider != null : "Precondition failed: badgeImageProvider != null";
		assert i18nProvider != null : "Precondition failed: i18nProvider != null";

		this.badgeService = badgeService;
		this.i18nProvider = i18nProvider;

		FlowPanel mainPanel = new FlowPanel();
		initWidget(mainPanel);

		loader = new Image(badgeImageProvider.getLoading());
		loader.setPixelSize(44, 44);
		mainPanel.add(loader);

		contentPanel = new FlowPanel();
		contentPanel.setVisible(false);
		mainPanel.add(contentPanel);

		Label welcomeLabel = new Label(i18nProvider.getYourBadges());
		welcomeLabel.getElement().getStyle().setMargin(10, Unit.PX);
		welcomeLabel.getElement().getStyle().setDisplay(Display.BLOCK);
		welcomeLabel.getElement().getStyle().setFontSize(20, Unit.PX);
		contentPanel.add(welcomeLabel);

		FlowPanel badgeAggregationPanel = new FlowPanel();
		badgeAggregationPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		badgeAggregationPanel.getElement().getStyle().setHeight(38, Unit.PX);
		contentPanel.add(badgeAggregationPanel);

		Image goldBadge = new Image(badgeImageProvider.getGoldBadge());
		goldBadge.setSize("22px", "22px");
		goldBadge.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		goldBadge.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		Image silverBadge = new Image(badgeImageProvider.getSilverBadge());
		silverBadge.setSize("22px", "22px");
		silverBadge.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		silverBadge.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		Image bronzeBadge = new Image(badgeImageProvider.getBronzeBadge());
		bronzeBadge.setSize("22px", "22px");
		bronzeBadge.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		bronzeBadge.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);

		goldAmount = new Label();
		goldAmount.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		goldAmount.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		goldAmount.getElement().getStyle().setFontSize(20, Unit.PX);
		goldAmount.getElement().getStyle().setPaddingLeft(5, Unit.PX);
		silverAmount = new Label();
		silverAmount.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		silverAmount.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		silverAmount.getElement().getStyle().setFontSize(20, Unit.PX);
		silverAmount.getElement().getStyle().setPaddingLeft(5, Unit.PX);
		bronzeAmount = new Label();
		bronzeAmount.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		bronzeAmount.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		bronzeAmount.getElement().getStyle().setFontSize(20, Unit.PX);
		bronzeAmount.getElement().getStyle().setPaddingLeft(5, Unit.PX);

		FlowPanel goldAggregation = new FlowPanel();
		goldAggregation.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		goldAggregation.getElement().getStyle().setMarginLeft(10, Unit.PX);
		goldAggregation.getElement().getStyle().setMarginRight(10, Unit.PX);
		goldAggregation.getElement().getStyle().setMarginBottom(10, Unit.PX);
		goldAggregation.add(goldBadge);
		goldAggregation.add(goldAmount);
		badgeAggregationPanel.add(goldAggregation);

		FlowPanel silverAggregation = new FlowPanel();
		silverAggregation.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		silverAggregation.getElement().getStyle().setMarginLeft(10, Unit.PX);
		silverAggregation.getElement().getStyle().setMarginRight(10, Unit.PX);
		silverAggregation.getElement().getStyle().setMarginBottom(10, Unit.PX);
		silverAggregation.add(silverBadge);
		silverAggregation.add(silverAmount);
		badgeAggregationPanel.add(silverAggregation);

		FlowPanel bronzeAggregation = new FlowPanel();
		bronzeAggregation.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		bronzeAggregation.getElement().getStyle().setMarginLeft(10, Unit.PX);
		bronzeAggregation.getElement().getStyle().setMarginRight(10, Unit.PX);
		bronzeAggregation.getElement().getStyle().setMarginBottom(10, Unit.PX);
		bronzeAggregation.add(bronzeBadge);
		bronzeAggregation.add(bronzeAmount);
		badgeAggregationPanel.add(bronzeAggregation);

		HTML horizontalRow = new HTML("<hr style=\"color:#CCCCCC\" noshade/>");
		horizontalRow.getElement().getStyle().setHeight(1, Unit.PX);
		contentPanel.add(horizontalRow);

		badgePanelContainer = new SimplePanel();
		badgePanelContainer.getElement().getStyle().setMarginTop(10, Unit.PX);
		contentPanel.add(badgePanelContainer);

		badgeService.addBadgesUpdatedListener(new BadgesUpdatedListener() {

			@Override
			public void badgesUpdated(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated) {
				assert badgesThatReachedANewLevel != null : "Precondition failed: badgesThatReachedANewLevel != null";
				assert badgesThatUpdated != null : "Precondition failed: badgesThatUpdated != null";
				assert badgesThatUpdated.size() > 0 : "Precondition failed: badgesThatUpdated.size() > 0";
				handleBadgesUpdated(badgesThatReachedANewLevel, badgesThatUpdated);
			}
		});
	}

	public void addBadgesUpdatedListener(final BadgeProfilePanelListener listener) {
		listeners.add(listener);
	}

	public void switchToLoggedInMode() {
		BadgeType[] allBadgeTypes = BadgeType.values();
		badgeService.getActiveUsersBadges(allBadgeTypes, new AsyncCallback<List<Badge>>() {
			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Could not retrieve badges for current user.");
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(List<Badge> result) {
				if (result != null && result.size() > 0) {
					if (smartBadgePanel != null) {
						badgePanelContainer.remove(smartBadgePanel);
					}
					smartBadgePanel = new SmartBadgePanel(result, i18nProvider);
					badgePanelContainer.add(smartBadgePanel);
					Badge.Comparators.BY_LEARN_PATH.sort(result);
					smartBadgePanel.selectRecommendedBadgeOfType(result.get(0).getBadgeType());

					updateAggregationOfBadges(result);

					for (BadgeProfilePanelListener listener : listeners) {
						listener.badgesUpdated(smartBadgePanel.getWidth(), result);
					}

					loader.setVisible(false);
					contentPanel.setVisible(true);
				}
			}
		});
	}

	public void switchToLoggedOutMode() {
		if (smartBadgePanel != null) {
			badgePanelContainer.remove(smartBadgePanel);
			smartBadgePanel = null;
		}
	}

	private void updateAggregationOfBadges(List<Badge> badges) {
		int goldenBadges = 0;
		int bronzeBadges = 0;
		int silverBadges = 0;
		for (Badge badge : badges) {
			switch (badge.getCurrentLevel()) {
			case GOLD:
				goldenBadges++;
				break;
			case SILVER:
				silverBadges++;
				break;
			case BRONZE:
				bronzeBadges++;
				break;
			case NONE:
			default:
				break;
			}
		}
		goldAmount.setText("x " + goldenBadges);
		silverAmount.setText("x " + silverBadges);
		bronzeAmount.setText("x " + bronzeBadges);
	}

	private void handleBadgesUpdated(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated) {
		assert badgesThatReachedANewLevel != null : "Precondition failed: badgesThatReachedANewLevel != null";
		assert badgesThatUpdated != null : "Precondition failed: badgesThatUpdated != null";
		assert badgesThatUpdated.size() > 0 : "Precondition failed: badgesThatUpdated.size() > 0";

		if (smartBadgePanel != null) {
			smartBadgePanel.updateBadges(badgesThatReachedANewLevel, badgesThatUpdated);
			updateAggregationOfBadges(smartBadgePanel.getBadges());
			for (BadgeProfilePanelListener listener : listeners) {
				listener.badgesUpdated(smartBadgePanel.getWidth(), smartBadgePanel.getBadges());
			}
		}
	}

	public interface BadgeProfilePanelListener {
		public void badgesUpdated(int newWidth, List<Badge> badgesThatReachedANewLevel);
	}

}
