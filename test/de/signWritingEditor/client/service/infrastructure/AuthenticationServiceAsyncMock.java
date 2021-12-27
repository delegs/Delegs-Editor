package de.signWritingEditor.client.service.infrastructure;

import java.util.Collections;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.AuthenticationService;
import de.signWritingEditor.client.service.AuthenticationService.UserQueryResultReason;
import de.signWritingEditor.client.service.AuthenticationServiceAsync;
import de.signWritingEditor.client.service.QueryResult;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.ExpiryDate;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class AuthenticationServiceAsyncMock implements AuthenticationServiceAsync {

	// Eigentlich müssten wir uns alle registrierten User merken, aber für
	// die bisherigen Testfälle reicht auch erst mal nur der letzte.
	private User lastRegisteredUser = new User("Hans", "Hans", "Maier", new EmailAddress("Hans.Meier@yahoo.com"),
			Collections.singletonList(UserRole.USER), 1);

	@Override
	public void registerUser(String username, String firstName, String lastName, String password,
			EmailAddress emailAddress, int privacyPolicyVersionNumber, AsyncCallback<User> callback) {
		lastRegisteredUser = new User(username, firstName, lastName, emailAddress,
				Collections.singletonList(UserRole.USER), privacyPolicyVersionNumber);
		callback.onSuccess(lastRegisteredUser);
	}

	@Override
	public void isUserActivated(String username, String password,
			AsyncCallback<QueryResult<UserQueryResultReason>> callback) {
		if (lastRegisteredUser.getUsername().equals(username)) {
			callback.onSuccess(new QueryResult<AuthenticationService.UserQueryResultReason>(true,
					UserQueryResultReason.USER_ACTIVATED));
		} else {
			callback.onSuccess(new QueryResult<AuthenticationService.UserQueryResultReason>(false,
					UserQueryResultReason.USER_NOT_ACTIVATED));
		}
	}

	@Override
	public void login(String username, String password, AsyncCallback<UserSession> callback) {
		SessionKey sessionKey = new SessionKey(123L);
		ExpiryDate expiryTime = ExpiryDate.now().plusHours(1);
		if (lastRegisteredUser.getUsername().equals(username) && "passwort1".equals(password)) {
			callback.onSuccess(new UserSession(lastRegisteredUser, sessionKey, expiryTime));
		} else {
			User user = new User("Unknown", "Anne", "Known", new EmailAddress("anne.known@yahoo.com"),
					Collections.singletonList(UserRole.UNKNOWN), 1);
			callback.onSuccess(new UserSession(user, sessionKey, expiryTime));
		}
	}

	@Override
	public void logout(SessionKey sessionKey, AsyncCallback<Void> callback) {
	}

	@Override
	public void isAdminUser(String username, SessionKey sessionKey, AsyncCallback<Boolean> callback) {
	}

	@Override
	public void existsUser(String username, EmailAddress emailAddress,
			AsyncCallback<QueryResult<UserQueryResultReason>> callback) {
		if (lastRegisteredUser.getUsername().equals(username)) {
			callback.onSuccess(new QueryResult<AuthenticationService.UserQueryResultReason>(true,
					UserQueryResultReason.USERNAME_EXISTS));
		} else if (lastRegisteredUser.getEmailAddress().equals(emailAddress)) {
			callback.onSuccess(new QueryResult<AuthenticationService.UserQueryResultReason>(true,
					UserQueryResultReason.EMAIL_EXISTS));
		} else {
			callback.onSuccess(new QueryResult<AuthenticationService.UserQueryResultReason>(false,
					UserQueryResultReason.USER_DOES_NOT_EXIST));
		}
	}

	@Override
	public void updateAcceptedPrivacyPolicyVersion(User user, int newAcceptedPrivacyPolicyVersion,
			AsyncCallback<Void> callback) {

	}
}
