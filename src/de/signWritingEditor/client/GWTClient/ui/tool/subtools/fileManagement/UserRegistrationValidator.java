package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class UserRegistrationValidator {

	UserRegistrationValidationResult validateUserName(String username) {
		assert username != null : "Precondition failed: username != null";

		boolean isValid = User.isValidUsername(username);
		String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidUserName();

		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	UserRegistrationValidationResult validateMailAddressFormat(String mailAddress) {
		boolean isValid = EmailAddress.isValidAddressFormat(mailAddress);
		String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidMailAddress();

		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	UserRegistrationValidationResult validateLastNameFormat(String lastName) {
		boolean isValid = User.isValidName(lastName);
		String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidLastNameField();
		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	UserRegistrationValidationResult validateFirstNameFormat(String firstName) {
		boolean isValid = User.isValidName(firstName);
		String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidFirstNameField();

		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	UserRegistrationValidationResult validatePassword(String password, String passwordRepeat) {
		assert password != null : "Precondition failed: password != null";

		UserRegistrationValidationResult result = null;
		boolean isValid = password.equals(passwordRepeat);
		if (!isValid) {
			result = new UserRegistrationValidationResult(isValid, I18N.getRegistrationPasswordMismatch());
		} else {
			isValid = User.isValidPassword(password);
			String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidPassword();
			result = new UserRegistrationValidationResult(isValid, validationDescription);
		}

		return result;
	}

	UserRegistrationValidationResult validatePrivacyPolicyCheckBox(boolean privacyPolicyCheckBoxValue) {
		boolean isValid = privacyPolicyCheckBoxValue;
		String validationDescription = isValid ? "valid" : I18N.getRegistrationNoPrivacyPolicyAgreement();

		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	UserRegistrationValidationResult validateAgeVerificationCheckBox(boolean ageVerificationCheckBoxValue) {
		boolean isValid = ageVerificationCheckBoxValue;
		String validationDescription = isValid ? "valid" : I18N.getRegistrationNoAgeVerification();

		return new UserRegistrationValidationResult(isValid, validationDescription);
	}

	class UserRegistrationValidationResult {
		private boolean isValid;
		private final String description;

		public UserRegistrationValidationResult(boolean isValid, String description) {
			this.isValid = isValid;
			this.description = description;
		}

		public boolean isValid() {
			return isValid;
		}

		public String getDescription() {
			return description;
		}
	}
}
