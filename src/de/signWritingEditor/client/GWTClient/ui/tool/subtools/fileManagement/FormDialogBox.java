package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.ModalDialogBox;

public abstract class FormDialogBox extends ModalDialogBox {
	private static final String LABEL_STYLE_NAME = "label";
	private static final String FORM_CONTENT_STYLE_NAME = "formContent";

	private static int CAPTCHA_RELOAD_COUNTER = 0;

	private FlexTable formPanel;
	private TextBox captchaTextBox;
	private Label captchaErrorLabel;

	public FormDialogBox(String dialogTitle, String submitButtonCaption) {
		assert dialogTitle != null : "Precondition failed: dialogTitle != null";
		assert submitButtonCaption != null : "Precondition failed: submitButtonCaption != null";

		setText(dialogTitle);

		FlowPanel mainPanel = new FlowPanel();
		mainPanel.setStyleName("formDialogBox");
		setWidget(mainPanel);

		mainPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.stopPropagation();
				}
			}
		}, KeyDownEvent.getType());

		mainPanel.sinkEvents(Event.ONKEYDOWN);

		formPanel = new FlexTable();
		mainPanel.add(formPanel);

		FlowPanel buttonPanel = new FlowPanel();
		buttonPanel.setStyleName("buttons");
		mainPanel.add(buttonPanel);

		Button confirmButton = new Button(submitButtonCaption);
		buttonPanel.add(confirmButton);
		confirmButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handleSubmit();
			}
		});

		Button cancelButton = new Button(I18N.getCancel());
		buttonPanel.add(cancelButton);
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
	}

	protected void addCaptcha() {
		int newRowIndex = formPanel.getRowCount();

		Label label = new Label("");
		label.setStyleName(LABEL_STYLE_NAME);
		formPanel.setWidget(newRowIndex, 0, label);

		FlowPanel captchaWidget = new FlowPanel();
		final Image image = new Image(getCaptchaImageUrl());
		captchaWidget.add(image);

		Button reloadCaptchaButton = new Button(I18N.getLoadNewText());
		reloadCaptchaButton.addStyleName("block");
		reloadCaptchaButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// make sure to always use a different URL to prevent image
				// caching
				image.setUrl(getCaptchaImageUrl());
			}
		});
		captchaWidget.add(reloadCaptchaButton);
		formPanel.setWidget(newRowIndex, 1, captchaWidget);

		FlowPanel captchaInputPanel = new FlowPanel();
		captchaTextBox = new TextBox();
		captchaInputPanel.add(captchaTextBox);
		captchaErrorLabel = new Label("Captcha stimmt nicht überein");
		captchaErrorLabel.setVisible(false);
		captchaInputPanel.add(captchaErrorLabel);

		addInputField(I18N.getInsertText() + ":", captchaInputPanel);
	}

	protected String getCaptcha() {
		return captchaTextBox.getText();
	}

	public void setCaptchaErrorVisible(boolean visible) {
		captchaErrorLabel.setVisible(visible);
	}

	protected void addInputField(String labelText, Widget input) {
		assert labelText != null : "Precondition failed: labelText != null";
		assert input != null : "Precondition failed: input != null";

		int newRowIndex = formPanel.getRowCount();

		Label label = new Label(labelText);
		label.setStyleName(LABEL_STYLE_NAME);
		formPanel.setWidget(newRowIndex, 0, label);

		input.addStyleName(FORM_CONTENT_STYLE_NAME);
		formPanel.setWidget(newRowIndex, 1, input);

		input.addHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					handleSubmit();
				}
			}
		}, KeyDownEvent.getType());
		input.sinkEvents(Event.ONKEYDOWN);
	}

	protected void addInfoLink(String infoLinkText, ClickHandler clickHandler) {
		int newRowIndex = formPanel.getRowCount();

		Hyperlink hyperlink = new Hyperlink(infoLinkText, "");
		hyperlink.addHandler(clickHandler, ClickEvent.getType());

		formPanel.setWidget(newRowIndex, 0, hyperlink);
	}

	protected abstract void handleSubmit();

	private String getCaptchaImageUrl() {
		FormDialogBox.CAPTCHA_RELOAD_COUNTER += 1;

		return "signwritingeditor/captchaImg?" + FormDialogBox.CAPTCHA_RELOAD_COUNTER;
	}
}
