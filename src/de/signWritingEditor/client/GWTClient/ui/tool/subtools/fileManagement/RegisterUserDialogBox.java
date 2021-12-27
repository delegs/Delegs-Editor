package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.InfoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.UserRegistrationValidator.UserRegistrationValidationResult;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.PasswordTextBoxWithWatermark;

public abstract class RegisterUserDialogBox extends FormDialogBox {

	private TextBox usernameTextBox;
	private TextBox firstNameTextBox;
	private TextBox lastNameTextBox;
	private TextBox passwordTextBox;
	private TextBox repeatPasswordTextBox;
	private TextBox emailTextBox;

	private CheckBox privacyPolicyCheckBox;
	private CheckBox ageVerificationCheckBox;

	private Label usernameErrorLabel;
	private Label firstNameErrorLabel;
	private Label lastNameErrorLabel;
	private Label passwordErrorLabel;
	private Label emailErrorLabel;
	private Label privacyPolicyErrorLabel;
	private Label ageVerificationErrorLabel;
	private final UserRegistrationValidator registrationValidator;

	public RegisterUserDialogBox(UserRegistrationValidator registrationValidator) {
		super(I18N.getNewUser(), I18N.getRegister());
		this.addStyleName("registerUserDialogBox");

		assert registrationValidator != null : "Precondition failed: registrationValidator != null";
		this.registrationValidator = registrationValidator;

		usernameErrorLabel = new Label();
		usernameTextBox = new TextBox();
		addInputField(I18N.getUserName() + ":", usernameTextBox, usernameErrorLabel);

		firstNameTextBox = new TextBox();
		firstNameErrorLabel = new Label();
		addInputField(I18N.getFirstName() + ":", firstNameTextBox, firstNameErrorLabel);

		lastNameTextBox = new TextBox();
		lastNameErrorLabel = new Label();
		addInputField(I18N.getLastName() + ":", lastNameTextBox, lastNameErrorLabel);

		emailTextBox = new TextBox();
		emailErrorLabel = new Label();
		addInputField(I18N.getEmailAdress() + ":", emailTextBox, emailErrorLabel);

		passwordTextBox = new PasswordTextBoxWithWatermark("°°°°°°°°");
		addInputField(I18N.getPassword() + ":", passwordTextBox);

		passwordErrorLabel = new Label();
		repeatPasswordTextBox = new PasswordTextBoxWithWatermark("°°°°°°°°");
		addInputField(I18N.getRepeatNewPassword(), repeatPasswordTextBox, passwordErrorLabel);

		addCaptcha();

		privacyPolicyCheckBox = new CheckBox();
		privacyPolicyErrorLabel = new Label();
		addInputField(I18N.getPrivacyPolicyAgreement(), privacyPolicyCheckBox, privacyPolicyErrorLabel);

		addInfoLink(I18N.getOpenPrivacyPolicy(), new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				HTML impressum = new HTML(I18N.getPrivacyPolicyText());
				ScrollPanel impressumPanel = new ScrollPanel(impressum);
				new InfoDialogBox(impressumPanel).center();

			}
		});

		ageVerificationCheckBox = new CheckBox();
		ageVerificationErrorLabel = new Label();
		addInputField(I18N.getAgeVerification(), ageVerificationCheckBox, ageVerificationErrorLabel);

	}

	public void focusUsernameTextBox() {
		usernameTextBox.setSelectionRange(0, usernameTextBox.getText().length());
		usernameTextBox.setFocus(true);
	}

	public abstract void handleRegisterUser(String username, String firstName, String lastName, String password,
			String emailAddressString, String userCaptcha);

	protected void handleSubmit() {
		boolean validInputs = true;

		UserRegistrationValidationResult validationResult = registrationValidator
				.validateUserName(usernameTextBox.getText());
		handleValidationForTextBox(validationResult, usernameTextBox, usernameErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validateFirstNameFormat(firstNameTextBox.getText());
		handleValidationForTextBox(validationResult, firstNameTextBox, firstNameErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validateLastNameFormat(lastNameTextBox.getText());
		handleValidationForTextBox(validationResult, lastNameTextBox, lastNameErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validateMailAddressFormat(emailTextBox.getText());
		handleValidationForTextBox(validationResult, emailTextBox, emailErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validatePassword(passwordTextBox.getText(),
				repeatPasswordTextBox.getText());
		handleValidationForTextBox(validationResult, passwordTextBox, passwordErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validatePrivacyPolicyCheckBox(privacyPolicyCheckBox.getValue());
		handleValidationForCheckBox(validationResult, privacyPolicyCheckBox, privacyPolicyErrorLabel);
		validInputs &= validationResult.isValid();

		validationResult = registrationValidator.validateAgeVerificationCheckBox(ageVerificationCheckBox.getValue());
		handleValidationForCheckBox(validationResult, ageVerificationCheckBox, ageVerificationErrorLabel);
		validInputs &= validationResult.isValid();

		if (validInputs) {
			handleRegisterUser(usernameTextBox.getText(), firstNameTextBox.getText(), lastNameTextBox.getText(),
					passwordTextBox.getText(), emailTextBox.getText(), getCaptcha());
		} else {
			center();
		}
	}

	private void handleValidationForTextBox(UserRegistrationValidationResult validationResult, TextBox textBox,
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

	private void handleValidationForCheckBox(UserRegistrationValidationResult validationResult, CheckBox checkBox,
			Label errorLabel) {
		if (!validationResult.isValid()) {
			checkBox.addStyleName("colorLabelRed");
			errorLabel.setText(validationResult.getDescription());
			errorLabel.setVisible(true);
		} else {
			checkBox.removeStyleName("colorLabelRed");
			errorLabel.setText("");
			errorLabel.setVisible(false);
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
