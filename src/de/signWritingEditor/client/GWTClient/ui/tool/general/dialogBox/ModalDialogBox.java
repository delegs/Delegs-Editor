package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ModalDialogBox extends DialogBox {

	private SimplePanel shadowPanel;

	public ModalDialogBox() {
		shadowPanel = new SimplePanel();
		shadowPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
		shadowPanel.getElement().getStyle().setZIndex(33000);
		shadowPanel.getElement().getStyle().setLeft(0, Unit.PX);
		shadowPanel.getElement().getStyle().setTop(0, Unit.PX);
		shadowPanel.setSize("100%", "100%");
		shadowPanel.setStyleName("modalDialogShadow");
		getElement().getStyle().setPosition(Position.ABSOLUTE);
		getElement().getStyle().setZIndex(34000);
	}

	@Override
	public void show() {
		if (!shadowPanel.isAttached()) {
			RootPanel.get().add(shadowPanel);
		}

		super.show();
	}

	@Override
	public void hide() {
		super.hide();

		if (shadowPanel.isAttached()) {
			RootPanel.get().remove(shadowPanel);
		}
	}
}
