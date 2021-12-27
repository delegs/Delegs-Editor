package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial.TutorialVideoElement.TutorialNavigationListener;

public abstract class TutorialWidgetElement {

	protected TutorialNavigationListener listener;

	protected Widget tutorialWidget;
	protected Label headerLabel;
	protected Label navigationLabel;

	protected TutorialWidgetElement(TutorialNavigationListener listener) {
		this.listener = listener;
	}

	abstract Widget getWidget();

	abstract String getName();

	abstract Widget getHeaderLabel();

	abstract Widget getNavigationLabel();

}
