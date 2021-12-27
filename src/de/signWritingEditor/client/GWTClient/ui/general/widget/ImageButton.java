package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;

public class ImageButton extends Button {
	public ImageButton(Image buttonImage, String title, ClickHandler clickHandler) {
		super("<img src=\"" + buttonImage.getUrl() + "\"/><div style=\"padding-top:"
				+ getPaddingTopForTitle(buttonImage) + "px\">" + title + "</div>", clickHandler);
		this.addStyleName("imageButton");
		this.getElement().getStyle().setHeight(buttonImage.getHeight() + 8, Unit.PX);
	}

	private static double getPaddingTopForTitle(Image image) {
		return (image.getHeight() - 18) / 2.0;
	}

}
