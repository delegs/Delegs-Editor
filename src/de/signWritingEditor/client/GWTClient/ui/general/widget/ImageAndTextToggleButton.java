package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;

public class ImageAndTextToggleButton extends ImageAndTextButton {

	private boolean isActive = false;
	private Image buttonImage;
	private Image activeButtonImage;
	private String title;
	private String activeTitle;
	private ToggleHandler toggleHandler;
	private boolean isMarkUpEnabled;

	public ImageAndTextToggleButton(Image buttonImage, String title, ToggleHandler toggleHandler) {
		this(buttonImage, buttonImage, title, title, toggleHandler, true);
	}

	public ImageAndTextToggleButton(Image buttonImage, Image activeButtonImage, String title, String activeTitle,
			ToggleHandler toggleHandler) {
		this(buttonImage, activeButtonImage, title, activeTitle, toggleHandler, true);
	}

	public ImageAndTextToggleButton(Image buttonImage, Image activeButtonImage, String title, String activeTitle,
			ToggleHandler toggleHandler, boolean isMarkUpEnabled) {
		super(buttonImage, title, null);

		this.buttonImage = buttonImage;
		this.activeButtonImage = activeButtonImage;
		this.title = title;
		this.activeTitle = activeTitle;
		this.toggleHandler = toggleHandler;
		this.isMarkUpEnabled = isMarkUpEnabled;

		init();
	}

	private final void init() {
		this.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setToggleState(!isActive);
			}
		}, ClickEvent.getType());
		sinkEvents(Event.ONCLICK);
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setToggleStateManually(boolean active) {
		setToggleState(active);
		if (isMarkUpEnabled) {
			if (active) {
				markButton();
			} else {
				removeMarkUp();
			}
		}
	}

	private void setToggleState(boolean active) {
		if (active != isActive) {
			isActive = active;
			if (isActive) {
				this.setText(activeTitle);
				this.setImage(activeButtonImage);
				if (isMarkUpEnabled) {
					unsinkEvents(Event.ONMOUSEOUT);
				}
			} else {
				this.setText(title);
				this.setImage(buttonImage);
				if (isMarkUpEnabled) {
					sinkEvents(Event.ONMOUSEOUT);
				}
			}
			toggleHandler.onToggle(isActive);
		}
	}
}
