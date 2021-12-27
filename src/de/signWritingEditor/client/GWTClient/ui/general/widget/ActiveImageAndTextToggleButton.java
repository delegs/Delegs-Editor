package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;

public class ActiveImageAndTextToggleButton extends ImageAndTextToggleButton {

	private Image disabledImage;
	private boolean isEnabled;
	private Image buttonImage;

	public ActiveImageAndTextToggleButton(Image buttonImage, Image activeButtonImage, Image disabledImage, String title,
			String activeTitle, ToggleHandler toggleHandler) {
		super(buttonImage, activeButtonImage, title, activeTitle, toggleHandler);

		this.buttonImage = buttonImage;
		this.disabledImage = disabledImage;
	}

	public void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
		if (!enabled) {
			setToggleStateManually(false);
			setImage(disabledImage);
			unsinkEvents(Event.ONCLICK);
			unsinkEvents(Event.ONMOUSEOVER);
			addStyleDependentName("disabled");
			getElement().getStyle().setCursor(Cursor.DEFAULT);
		} else {
			setImage(buttonImage);
			sinkEvents(Event.ONCLICK);
			sinkEvents(Event.ONMOUSEOVER);
			removeStyleDependentName("disabled");
		}
	}

	public boolean getEnabled() {
		return isEnabled;
	}

}
