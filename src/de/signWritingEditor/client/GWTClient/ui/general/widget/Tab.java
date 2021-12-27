package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Tab {
	private Image enabledIcon;
	private final Widget tabContent;
	private final SimplePanel tabIcon;
	private boolean isEnabled;
	private Image disabledIcon;

	public Tab(Image enabledIcon, Image disabledIcon, Widget tabContent) {
		assert enabledIcon != null : "Precondition failed: tabIcon != null";
		assert disabledIcon != null : "Precondition failed: disabledIcon != null";
		assert tabContent != null : "Precondition failed: tabContent != null";
		this.enabledIcon = enabledIcon;
		this.disabledIcon = disabledIcon;
		this.tabIcon = new SimplePanel();
		this.tabContent = tabContent;
		this.tabContent.addStyleName("tabContent");
		this.isEnabled = true;
		this.tabIcon.add(enabledIcon);
		this.tabIcon.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		this.tabIcon.sinkEvents(Event.ONCLICK);
	}

	public Tab(Image icon, Widget tabContent) {
		this(icon, icon, tabContent);
	}

	public Widget getTabIcon() {
		return tabIcon;
	}

	public void setTabIcon(Image icon) {
		enabledIcon = icon;
		setEnabled(getEnabled());
	}

	public Widget getTabContent() {
		return tabContent;
	}

	public boolean getEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
		tabIcon.clear();
		if (enabled) {
			tabIcon.add(enabledIcon);
			tabIcon.getElement().getStyle().clearCursor();
		} else {
			tabIcon.getElement().getStyle().setCursor(Cursor.DEFAULT);
			tabIcon.add(disabledIcon);
		}
	}
}