package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoadingDialog extends ModalDialogBox {

	public LoadingDialog(String title, String message) {
		setText(title);

		VerticalPanel dialogPanel = new VerticalPanel();
		dialogPanel.setSpacing(8);
		dialogPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		Label messageLabel = new Label(message);

		dialogPanel.add(messageLabel);

		setWidget(dialogPanel);
	}

}
