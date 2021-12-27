package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;

/**
 * A wrapper for the standard GWT-CheckBox that fires MouseOverEvents correctly.
 * Normally it doesn't.
 */
public class CheckBoxFiringMouseEvents extends Composite implements HasClickHandlers, HasMouseOverHandlers,
		HasMouseDownHandlers, HasMouseMoveHandlers, HasMouseOutHandlers, HasBlurHandlers {
	private CheckBox checkBox;
	private FocusPanel focusPanel;

	public CheckBoxFiringMouseEvents(String label) {
		assert label != null : "Precondition failed: label != null";

		focusPanel = new FocusPanel();
		checkBox = new CheckBox(label);
		focusPanel.add(checkBox);

		initWidget(focusPanel);
	}

	public void setValue(boolean value) {
		checkBox.setValue(value);
	}

	public boolean getValue() {
		return checkBox.getValue().booleanValue();
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addClickHandler(handler);
	}

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addBlurHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addMouseOutHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addMouseMoveHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addMouseDownHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		assert handler != null : "Precondition failed: handler != null";

		return focusPanel.addMouseOverHandler(handler);
	}
}
