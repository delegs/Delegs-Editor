package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.AuthenticationService.UserQueryResultReason;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public interface AuthenticationServiceAsync {

	void registerUser(String username, String firstName, String lastName, String password, EmailAddress emailAddress,
			int privacyPolicyVersionNumber, AsyncCallback<User> callback);

	void isUserActivated(String username, String password, AsyncCallback<QueryResult<UserQueryResultReason>> callback);

	void login(String username, String password, AsyncCallback<UserSession> callback);

	void updateAcceptedPrivacyPolicyVersion(User user, int newAcceptedPrivacyPolicyVersion,
			AsyncCallback<Void> callback);

	void logout(SessionKey sessionKey, AsyncCallback<Void> callback);

	void isAdminUser(String username, SessionKey sessionKey, AsyncCallback<Boolean> callback);

	void existsUser(String username, EmailAddress emailAddress,
			AsyncCallback<QueryResult<UserQueryResultReason>> callback);
}
