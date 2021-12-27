package de.signWritingEditor.client.service;

import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public interface AuthenticationService {
	public enum UserQueryResultReason {
		USER_DOES_NOT_EXIST, USERNAME_EXISTS, EMAIL_EXISTS, USER_NOT_ACTIVATED, INVALID_CREDENTIALS, USER_ACTIVATED
	}

	UserSession login(String username, String password);

	void updateAcceptedPrivacyPolicyVersion(User user, int newAcceptedPrivacyPolicyVersion);

	void logout(SessionKey sessionKey);

	User registerUser(String username, String firstName, String lastName, String password, EmailAddress emailAddress,
			int privacyPolicyVersionNumber);

	boolean isAdminUser(String username, SessionKey sessionKey) throws Exception;

	QueryResult<UserQueryResultReason> existsUser(String username, EmailAddress emailAddress);

	QueryResult<UserQueryResultReason> isUserActivated(String username, String password);
}
