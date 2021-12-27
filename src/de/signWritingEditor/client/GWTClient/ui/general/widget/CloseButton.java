package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;

public class CloseButton extends Composite {

	protected final CloseListener closeListeners;

	public CloseButton(CloseListener closeListener) {
		assert closeListener != null : "Precondition failed: closeListener != null";
		this.closeListeners = closeListener;

		Image closeIcon = new Image(Resources.RESOURCE.getCloseButtonIcon());
		FlowPanel closeButton = new FlowPanel();
		closeButton.setStyleName("closeButton");
		setStyle(closeIcon, closeButton);
		initWidget(closeButton);

		closeButton.add(closeIcon);
		closeIcon.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				closeListeners.onClose();
			}
		}, ClickEvent.getType());
	}

	private void setStyle(Image closeIcon, FlowPanel closeButton) {
		closeButton.setPixelSize(closeIcon.getWidth(), closeIcon.getHeight());
		Style style = closeButton.getElement().getStyle();
		style.setTop(0, Unit.PX);
		style.setRight(0, Unit.PX);
		style.setPosition(Position.ABSOLUTE);
		style.setPaddingTop(5, Unit.PX);
		style.setPaddingRight(5, Unit.PX);
		style.setCursor(Cursor.POINTER);
	}

	public interface CloseListener {
		void onClose();
	}
}
