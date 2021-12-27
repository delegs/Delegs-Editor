package de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class YesNoDialogBox extends ModalDialogBox {

	protected final static String BUTTON_WIDTH = "80px";
	private HorizontalPanel buttonPanel;

	public YesNoDialogBox(String title, String text) {
		setText(title);

		VerticalPanel mainPanel = new VerticalPanel();
		FlowPanel contentPanel = new FlowPanel();
		HTML htmlText = new HTML(text);
		htmlText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		contentPanel.add(htmlText);
		contentPanel.getElement().getStyle().setProperty("maxHeight", "80vh");
		contentPanel.getElement().getStyle().setOverflow(Overflow.AUTO);
		mainPanel.add(contentPanel);
		mainPanel.setSpacing(8);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(8);

		Button yesButton = new Button(I18N.getYes(), new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onYes();
				hide();
			}
		});
		yesButton.setWidth(BUTTON_WIDTH);
		buttonPanel.add(yesButton);

		Button noButton = new Button(I18N.getNo(), new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onNo();
				hide();
			}
		});
		noButton.setWidth(BUTTON_WIDTH);
		buttonPanel.add(noButton);

		mainPanel.add(buttonPanel);
		add(mainPanel);
	}

	protected HorizontalPanel getButtonPanel() {
		return buttonPanel;
	}

	public abstract void onYes();

	public abstract void onNo();

}
