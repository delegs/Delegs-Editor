package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class PrivacyPolicyUpdateDialogBox extends ModalDialogBox {

	private final static String BUTTON_WIDTH = "80px";
	private HorizontalPanel buttonPanel;

	public PrivacyPolicyUpdateDialogBox() {
		setText(I18N.getPrivacyPolicyUpdate());

		VerticalPanel mainPanel = new VerticalPanel();

		HTML privacyPolicyText = new HTML(I18N.getPrivacyPolicyText());
		privacyPolicyText.getElement().getStyle().setTextAlign(TextAlign.CENTER);

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.getElement().getStyle().setProperty("height", "80vh");
		scrollPanel.getElement().getStyle().setProperty("width", "75vw");
		scrollPanel.add(privacyPolicyText);

		mainPanel.add(scrollPanel);

		HTML htmlText = new HTML(I18N.getPrivacyPolicyUpdateMessage());
		htmlText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		mainPanel.add(htmlText);

		mainPanel.setSpacing(8);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(8);

		Button acceptButton = new Button(I18N.getAccept(), new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onAccept();
				hide();
			}
		});
		acceptButton.setWidth(BUTTON_WIDTH);
		buttonPanel.add(acceptButton);

		Button declineButton = new Button(I18N.getDecline(), new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onDecline();
				hide();
			}
		});
		declineButton.setWidth(BUTTON_WIDTH);
		buttonPanel.add(declineButton);

		mainPanel.add(buttonPanel);
		add(mainPanel);
	}

	public abstract void onAccept();

	public abstract void onDecline();

}
