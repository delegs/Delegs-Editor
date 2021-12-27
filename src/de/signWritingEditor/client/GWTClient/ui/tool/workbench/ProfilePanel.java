package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.badge.client.gwtClient.ui.widget.BadgeProfileWidget;
import de.badge.client.gwtClient.ui.widget.BadgeProfileWidget.BadgeProfilePanelListener;
import de.badge.client.gwtClient.ui.widget.BadgeReportWidget;
import de.badge.client.gwtService.BadgeService;
import de.badge.shared.model.domainValue.BadgeLevel;
import de.badge.shared.model.material.Badge;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.shared.model.material.User;

public abstract class ProfilePanel extends Composite {

	private BadgeService badgeService;

	private TabPanel tabPanel;
	private Tab adminTab;
	private Tab badgeTab;

	private BadgeReportWidget adminContainer;
	private BadgeProfileWidget badgeProfileWidget;

	private boolean isAdmin;

	public ProfilePanel(BadgeService badgeService) {
		assert badgeService != null : "Precondition failed: badgeService != null";

		this.badgeService = badgeService;

		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.addStyleName("profilePanel");
		mainPanel.getElement().getStyle().setBackgroundColor("#FFFFFF");
		initWidget(mainPanel);

		FlowPanel flowPanel = new FlowPanel();
		flowPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mainPanel.add(flowPanel);

		tabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				// nothing to do
			}
		});
		tabPanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		tabPanel.getElement().getStyle().setWidth(500, Unit.PX);
		flowPanel.add(tabPanel);

		ImageButton logoutButton = new ImageButton(new Image(RESOURCE.getToolBarIconLogout()), I18N.getDoLogout(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						event.stopPropagation();
						switchToLoggedOutMode();
						onLogout();
					}
				});
		logoutButton.ensureDebugId("loginPanel-logoutButton");
		logoutButton.getElement().getStyle().setPosition(Position.ABSOLUTE);
		logoutButton.getElement().getStyle().setTop(32, Unit.PX);
		logoutButton.getElement().getStyle().setRight(15, Unit.PX);
		flowPanel.add(logoutButton);

		Image badgeIcon = new Image(RESOURCE.getUnearnedBadge());
		badgeIcon.setSize("44px", "44px");

		badgeProfileWidget = new BadgeProfileWidget(badgeService, RESOURCE, I18N);
		badgeProfileWidget.addBadgesUpdatedListener(new BadgeProfilePanelListener() {

			@Override
			public void badgesUpdated(int newWidth, List<Badge> badges) {
				if (adminContainer != null) {
					adminContainer.getElement().getStyle().setWidth(newWidth, Unit.PX);
				}
				tabPanel.getElement().getStyle().setWidth(100, Unit.PCT);
				updateBadgeTabIcon(badges);
			}
		});
		badgeTab = new Tab(badgeIcon, badgeProfileWidget);
		tabPanel.addTab(badgeTab);
		tabPanel.selectTab(badgeTab);
	}

	public void switchToLoggedInMode(final User user) {
		assert user != null : "Precondition failed: user != null";

		badgeProfileWidget.switchToLoggedInMode();

		if (user.isAdmin()) {
			isAdmin = true;
			adminContainer = new BadgeReportWidget(badgeService);
			Image adminIcon = new Image(RESOURCE.getIconGear());
			adminIcon.setSize("33px", "33px");
			adminIcon.getElement().getStyle().setMarginBottom(6, Unit.PX);
			adminIcon.getElement().getStyle().setMarginLeft(6, Unit.PX);
			adminTab = new Tab(adminIcon, adminContainer);
			tabPanel.addTab(adminTab);
		}

	}

	protected void switchToLoggedOutMode() {
		if (isAdmin) {
			tabPanel.removeTab(adminTab);
		}
		badgeProfileWidget.switchToLoggedOutMode();
		isAdmin = false;
	}

	protected abstract void onLogout();

	protected void updateBadgeTabIcon(List<Badge> badges) {
		assert badges != null : "Precondition failed: badges != null";

		BadgeLevel highestEarnedLevel = BadgeLevel.NONE;
		for (Badge badge : badges) {
			if (BadgeLevel.Comparators.BY_WORTH.compare(highestEarnedLevel, badge.getCurrentLevel()) == -1) {
				highestEarnedLevel = badge.getCurrentLevel();
			}
		}
		Image badgeIcon = null;
		switch (highestEarnedLevel) {
		case NONE:
			badgeIcon = new Image(RESOURCE.getUnearnedBadge());
			break;
		case BRONZE:
			badgeIcon = new Image(RESOURCE.getBronzeBadge());
			break;
		case SILVER:
			badgeIcon = new Image(RESOURCE.getSilverBadge());
			break;
		case GOLD:
			badgeIcon = new Image(RESOURCE.getGoldBadge());
			break;
		default:
			throw new RuntimeException("Unknown BadgeLevel " + highestEarnedLevel);
		}
		assert badgeIcon != null : "Postcondition failed: badgeIcon != null";

		badgeIcon.setSize("44px", "44px");
		badgeTab.setTabIcon(badgeIcon);
	}

}
