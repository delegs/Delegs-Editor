package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;

public class VideoRecorderCloseButton extends Composite {

	protected final CloseListener closeListeners;

	public VideoRecorderCloseButton(CloseListener closeListener) {
		assert closeListener != null : "Precondition failed: closeListener != null";
		this.closeListeners = closeListener;

		Button closeButton = new Button("X");
		closeButton.addStyleName("closeButton");
		setStyle(closeButton);
		initWidget(closeButton);

		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				closeListeners.onClose();
			}
		});
	}

	private void setStyle(Button closeButton) {
		Style style = closeButton.getElement().getStyle();
		style.setTop(-30, Unit.PX);
		style.setRight(0, Unit.PX);
		style.setPosition(Position.ABSOLUTE);
		style.setPaddingTop(5, Unit.PX);
		style.setPaddingRight(5, Unit.PX);
		style.setCursor(Cursor.POINTER);
		style.setBorderStyle(BorderStyle.NONE);
		style.setBackgroundImage("none");
	}

}
