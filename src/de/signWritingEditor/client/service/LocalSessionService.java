package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public interface LocalSessionService {

	public void login(final String username, final String password);

	public void updateAcceptedPrivacyPolicyVersion(int newAcceptedPrivacyPolicyVersion);

	public void registerUser(final String username, final String firstName, final String lastName,
			final String password, final String emailAddressString, final int privacyPolicyVersionNumber);

	public User getCurrentUser();

	public SessionKey getSessionKey();

	public void storeUserSession();

	public void restoreUserSession(AsyncCallback<Boolean> callback);

	public boolean hasStoredUserSession();

	public boolean isLocalStorageSupported();

	public void setLocalSessionServiceListener(LogonListener localSessionServiceListener);

	public void validateUserSession(AsyncCallback<Boolean> callback);

	public void logout();

	public void setUserSessionToUnknownUserSession();

	public boolean isCurrentUserUnknown();

	public UserSession getUserSession();
}
