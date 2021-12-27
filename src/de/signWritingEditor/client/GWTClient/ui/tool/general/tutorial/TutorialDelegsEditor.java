package de.signWritingEditor.client.GWTClient.ui.tool.general.tutorial;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TutorialDelegsEditor implements EntryPoint {

	public void onModuleLoad() {
		Label lpl = new Label("Tutorial");
		VerticalPanel panel = new VerticalPanel();
		panel.add(lpl);
		RootPanel.get().add(panel);

		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		sendButton.addStyleName("sendButton");

		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		RootPanel.get().add(sendButton);
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setVisible(false);

		final DockLayoutPanel tutorialPanel = new TutorialMainPanel(Unit.PX);
		dialogBox.setWidget(tutorialPanel);

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				dialogBox.setWidth("859px");
				dialogBox.setHeight("501px");
				dialogBox.setVisible(true);
				dialogBox.center();
			}
		}
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
	}
}
