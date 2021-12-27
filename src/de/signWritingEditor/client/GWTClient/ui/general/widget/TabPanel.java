package de.signWritingEditor.client.GWTClient.ui.general.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class TabPanel extends Composite {
	private FlowPanel tabIconPanel;
	private SimplePanel tabContentPanel;

	private SimplePanel arrow;

	private final List<Tab> tabs;
	private Tab selectedTab;

	private final TabPanelListener tabPanelListener;
	private HandlerRegistration attachHandlerRegistration;

	public TabPanel(TabPanelListener tabPanelListener) {
		assert tabPanelListener != null : "Precondition failed: tabPanelListener != null";

		tabs = new ArrayList<Tab>();

		this.tabPanelListener = tabPanelListener;

		FlowPanel mainPanel = new FlowPanel();
		mainPanel.setStyleName("tabPanel");
		initWidget(mainPanel);

		tabIconPanel = new FlowPanel();
		tabIconPanel.setStyleName("tabIcons");
		mainPanel.add(tabIconPanel);

		arrow = new SimplePanel();
		arrow.setStyleName("arrow");
		tabIconPanel.add(arrow);

		tabContentPanel = new SimplePanel();
		tabContentPanel.setStyleName("tabContent");
		mainPanel.add(tabContentPanel);
	}

	public boolean isTabSelected(final Tab tab) {
		return this.selectedTab.equals(tab);
	}

	public void addTab(final Tab tab) {
		assert tab != null : "Precondition failed: tab != null";
		assert !containsTab(tab) : "Precondition failed: !containsTab(tab)";

		boolean isFirstAddedTab = !hasTabs();

		tab.getTabIcon().setStyleName("tabIcon");

		tabs.add(tab);

		final Widget tabIcon = tab.getTabIcon();
		tabIconPanel.add(tabIcon);

		tabIcon.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (tab.getEnabled()) {
					selectTab(tab);
				}

			}
		}, ClickEvent.getType());

		// Directly display first tab
		if (isFirstAddedTab) {
			selectTab(tab);
		}

		assert containsTab(tab) : "Postcondition failed: containsTab(tab)";
	}

	public boolean hasTabs() {
		return !tabs.isEmpty();
	}

	public boolean containsTab(Tab tab) {
		assert tab != null : "Precondition failed: tab != null";

		return tabs.contains(tab);
	}

	public void removeTab(final Tab tab) {
		assert tab != null : "Precondition failed: tab != null";
		assert containsTab(tab) : "Precondition failed: containsTab(tab)";

		tabs.remove(tab);
		tab.getTabIcon().removeFromParent();
		tab.getTabContent().removeFromParent();

		if (selectedTab == tab) {
			if (tabs.isEmpty()) {
				setArrowPosFromLeft(0);
			} else {
				selectTab(tabs.get(0));
			}
		} else {
			adjustTabArrow(selectedTab);
		}

		assert !containsTab(tab) : "Postcondition failed: !containsTab(tab)";
	}

	public void clearTabs() {
		tabIconPanel.clear();
		tabContentPanel.clear();
		tabs.clear();
		tabIconPanel.add(arrow);

		assert !hasTabs() : "Postcondition failed: !hasTabs()";
	}

	// can be called in order to set the arrow position manually if the tabs
	// aren't rendered when they are added
	public void setInitialArrowPositionDeferred(final int positionFromLeft) {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				setArrowPosFromLeft(positionFromLeft);
			}
		});
	}

	public void selectTab(final Tab selectedTab) {
		assert selectedTab != null : "Precondition failed: selectedTab != null";
		assert containsTab(selectedTab) : "Precondition failed: containsTab(selectedTab)";

		this.selectedTab = selectedTab;
		tabContentPanel.setWidget(selectedTab.getTabContent());

		// Adjust arrow position deferred as the panel must be attached and
		// rendered to get tab icon positions
		if (isAttached()) {
			adjustTabArrow(selectedTab);
		} else {
			if (attachHandlerRegistration != null) {
				attachHandlerRegistration.removeHandler();
			}

			attachHandlerRegistration = addAttachHandler(new AttachEvent.Handler() {
				@Override
				public void onAttachOrDetach(AttachEvent event) {
					if (event.isAttached()) {
						adjustTabArrow(selectedTab);

						// Remove handler after first event
						attachHandlerRegistration.removeHandler();
						attachHandlerRegistration = null;
					}
				}
			});
		}

		tabPanelListener.onTabSelected(selectedTab.getTabContent());
	}

	private void adjustTabArrow(Tab tab) {
		assert tab != null : "Precondition failed: tab != null";
		assert containsTab(tab) : "Precondition failed: containsTab(tab)";

		Widget tabIcon = tab.getTabIcon();

		int tabIconCenter = tabIcon.getElement().getOffsetLeft() + tabIcon.getOffsetWidth() / 2;

		int newArrowLeft = Math.max(0, tabIconCenter - arrow.getOffsetWidth() / 2);

		setArrowPosFromLeft(newArrowLeft);
	}

	private void setArrowPosFromLeft(int newArrowLeft) {
		assert newArrowLeft >= 0 : "Precondition failed: newArrowLeft >= 0";

		arrow.getElement().getStyle().setLeft(newArrowLeft, Unit.PX);
	}

	public interface TabPanelListener {
		void onTabSelected(Widget selectedTabContent);
	}
}
