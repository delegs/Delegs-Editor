package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;

public class InfoDialogBox extends ModalDialogBox {

	private static final int DIALOG_BOX_HEIGHT = 473;
	private static final int DIALOG_BOX_WIDTH = 840;
	private AbsolutePanel mainPanel;

	public InfoDialogBox(int width, int height) {
		assert width >= 0 : "Precondition failed: width >= 0";
		assert height >= 0 : "Precondition failed: height >= 0";

		this.mainPanel = new AbsolutePanel();
		mainPanel.setPixelSize(width, height);
		add(mainPanel);
		mainPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);

		CloseButton closeButton = new CloseButton(new CloseListener() {
			@Override
			public void onClose() {
				InfoDialogBox.this.hide();
				InfoDialogBox.this.removeFromParent();
			}
		});

		mainPanel.add(closeButton, width - 5, -27);
	}

	public InfoDialogBox(Widget widget) {
		this(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT, widget);
		widget.setPixelSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT);
	}

	public InfoDialogBox(int width, int height, Widget widget) {
		this(width, height);
		assert widget != null : "Precondition failed:  widget != null";
		mainPanel.add(widget);
	}
}
