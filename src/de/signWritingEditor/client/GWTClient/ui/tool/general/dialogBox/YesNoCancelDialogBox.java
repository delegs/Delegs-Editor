package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public abstract class YesNoCancelDialogBox extends YesNoDialogBox {

	public YesNoCancelDialogBox(String title, String text) {
		super(title, text);
		Button cancelButton = new Button(I18N.getCancel(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		cancelButton.setWidth(BUTTON_WIDTH);
		getButtonPanel().add(cancelButton);
	}

}
