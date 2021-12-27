package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class PasswordForgottenValidator {

	PasswordForgottenValidationResult validateUserNameOrEmailAddress(String usernameOrEmailaddress) {
		assert usernameOrEmailaddress != null : "Precondition failed: usernameOrEmailaddress != null";

		boolean isValid = false;
		boolean isValidUsername = User.isValidUsername(usernameOrEmailaddress);
		boolean isValidEmailAddress = EmailAddress.isValidAddressFormat(usernameOrEmailaddress);
		String validationDescription = I18N.getPasswordForgottenInputInvalid();

		if (isValidUsername || isValidEmailAddress) {
			validationDescription = "valid";
			isValid = true;
		}

		return new PasswordForgottenValidationResult(isValid, validationDescription);
	}

	PasswordForgottenValidationResult validatePassword(String password, String passwordRepeat) {
		assert password != null : "Precondition failed: password != null";

		PasswordForgottenValidationResult result = null;
		boolean isValid = password.equals(passwordRepeat);
		if (!isValid) {
			result = new PasswordForgottenValidationResult(isValid, I18N.getRegistrationPasswordMismatch());
		} else {
			isValid = User.isValidPassword(password);
			String validationDescription = isValid ? "valid" : I18N.getRegistrationInvalidPassword();
			result = new PasswordForgottenValidationResult(isValid, validationDescription);
		}

		return result;
	}

	class PasswordForgottenValidationResult {
		private boolean isValid;
		private final String description;

		public PasswordForgottenValidationResult(boolean isValid, String description) {
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
