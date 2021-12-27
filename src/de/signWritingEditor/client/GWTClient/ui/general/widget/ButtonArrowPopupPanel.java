package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.signWritingEditor.shared.model.material.SignInfo;

public class ButtonArrowPopupPanel extends ArrowPopupPanel {

	protected static final int DEFAULT_BUTTON_WIDTH = 120;
	protected VerticalPanel mainPanel;
	protected Label label;
	protected FlowPanel buttonPanel;

	public ButtonArrowPopupPanel() {
		mainPanel = new VerticalPanel();

		mainPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.stopPropagation();
				}
			}
		}, KeyDownEvent.getType());

		mainPanel.sinkEvents(Event.ONKEYDOWN);

		label = new Label("");
		mainPanel.add(label);
		mainPanel.setSpacing(8);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.getElement().getStyle().setBackgroundColor("#FFFFFF");
		add(mainPanel);

		buttonPanel = new FlowPanel();
		mainPanel.add(buttonPanel);
	}

	protected Button addButton(String text, int width, ClickHandler clickHandler) {
		assert text != null : "Precondition failed: text != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		Button button = new Button(text);
		button.setWidth(width + "px");
		button.addClickHandler(clickHandler);
		button.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		buttonPanel.add(button);
		return button;
	}

	protected Button addButton(String text, int width, SignInfo signInfo, ClickHandler clickHandler) {
		assert signInfo != null : "Precondition failed: signInfo != null";

		Button result = addButton(text, width, clickHandler);
		return result;
	}

	protected void setPopupPanelText(String text) {
		assert text != null : "Precondition failed: text != null";
		label.setText(text);
	}
}
