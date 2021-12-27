package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.PasswordForgottenValidator.PasswordForgottenValidationResult;

public abstract class PasswordForgottenDialogBox extends FormDialogBox {

	private TextBox usernameOrEmailAddressTextBox;

	private Label usernameOrEmailAddressErrorLabel;
	private final PasswordForgottenValidator passswordForgottenValidator;

	public PasswordForgottenDialogBox(PasswordForgottenValidator passswordForgottenValidator) {
		super(I18N.getPasswordForgotten() + "?", I18N.getContinue());
		this.addStyleName("passwordForgottenDialogBox");

		assert passswordForgottenValidator != null : "Precondition failed: passswordForgottenValidator != null";
		this.passswordForgottenValidator = passswordForgottenValidator;

		usernameOrEmailAddressErrorLabel = new Label();
		usernameOrEmailAddressTextBox = new TextBox();
		addInputField(I18N.getUserNameOrEmailAddress() + ":", usernameOrEmailAddressTextBox,
				usernameOrEmailAddressErrorLabel);
	}

	public void focusUsernameOrEmailAddressTextBox() {
		usernameOrEmailAddressTextBox.setSelectionRange(0, usernameOrEmailAddressTextBox.getText().length());
		usernameOrEmailAddressTextBox.setFocus(true);
	}

	public abstract void handlePasswordForgotten(String usernameOrEmailAddress);

	protected void handleSubmit() {
		boolean validInputs = true;

		PasswordForgottenValidationResult validationResult = passswordForgottenValidator
				.validateUserNameOrEmailAddress(usernameOrEmailAddressTextBox.getText());
		handleValidationForTextBox(validationResult, usernameOrEmailAddressTextBox, usernameOrEmailAddressErrorLabel);
		validInputs &= validationResult.isValid();

		if (validInputs) {
			handlePasswordForgotten(usernameOrEmailAddressTextBox.getText());
		}
	}

	private void handleValidationForTextBox(PasswordForgottenValidationResult validationResult, TextBox textBox,
			Label errorLabel) {
		if (!validationResult.isValid()) {
			textBox.addStyleName("colorLabelRed");
			errorLabel.setText(validationResult.getDescription());
			errorLabel.setVisible(true);
		} else {
			textBox.removeStyleName("colorLabelRed");
			errorLabel.setText("");
			errorLabel.setVisible(false);
		}
	}

	public void setErrorMessage(String message, boolean addOrRemove) {
		if (addOrRemove) {
			usernameOrEmailAddressTextBox.addStyleName("colorLabelRed");
			usernameOrEmailAddressErrorLabel.setText(message);
			usernameOrEmailAddressErrorLabel.setVisible(true);
		} else {
			usernameOrEmailAddressTextBox.removeStyleName("colorLabelRed");
			usernameOrEmailAddressErrorLabel.setText("");
			usernameOrEmailAddressErrorLabel.setVisible(false);
		}
	}

	private void addInputField(String labelText, Widget input, Label errorLabel) {
		FlowPanel inputPanel = new FlowPanel();
		inputPanel.add(input);
		inputPanel.add(errorLabel);
		errorLabel.setVisible(false);

		super.addInputField(labelText, inputPanel);
	}
}
