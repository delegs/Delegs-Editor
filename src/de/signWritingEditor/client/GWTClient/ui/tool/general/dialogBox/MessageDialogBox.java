package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageDialogBox extends ModalDialogBox {

	public MessageDialogBox(String title, String message) {

		setText(title);

		VerticalPanel dialogPanel = new VerticalPanel();
		dialogPanel.setSpacing(8);
		dialogPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		dialogPanel.add(new HTML(message));

		Button okButton = new Button("Ok");
		okButton.setWidth("70px");
		okButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});

		dialogPanel.add(okButton);

		setWidget(dialogPanel);
	}

	@Override
	public void center() {
		super.center();
		setPopupPosition(getPopupLeft() + 50, getPopupTop());
	}
}
