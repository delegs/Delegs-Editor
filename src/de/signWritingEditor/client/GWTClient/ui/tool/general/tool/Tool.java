package de.signWritingEditor.client.GWTClient.ui.tool.general.tool;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public interface Tool {
	Widget getPanel();

	ButtonBar getButtonBar();

	int getButtonBarPosition();

	String getTitle();

	boolean hasUnsavedChanges();

	void logout();

	void open();

	void close();

	void handleSave(SavingFinishedListener listener);

	Image getIcon();

	boolean hasHistorySupport();

	interface SavingFinishedListener {
		void onSavingFinished();
	}

	void discardChanges();
}
