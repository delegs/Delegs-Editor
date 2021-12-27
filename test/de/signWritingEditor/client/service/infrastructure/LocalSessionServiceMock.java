package de.signWritingEditor.client.service.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LogonListener;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class LocalSessionServiceMock implements LocalSessionService {

	@Override
	public User getCurrentUser() {
		return null;
	}

	@Override
	public boolean hasStoredUserSession() {
		return false;
	}

	@Override
	public boolean isLocalStorageSupported() {
		return false;
	}

	@Override
	public void login(String username, String password) {
	}

	@Override
	public void registerUser(String username, String firstName, String lastName, String password,
			String emailAddressString, int acceptedPrivacyPolicyVersion) {
	}

	@Override
	public void setLocalSessionServiceListener(LogonListener localSessionServiceListener) {
	}

	@Override
	public void storeUserSession() {
	}

	@Override
	public void validateUserSession(AsyncCallback<Boolean> callback) {
	}

	@Override
	public void logout() {
	}

	@Override
	public void setUserSessionToUnknownUserSession() {
	}

	@Override
	public boolean isCurrentUserUnknown() {
		return false;
	}

	@Override
	public SessionKey getSessionKey() {
		return null;
	}

	@Override
	public void restoreUserSession(AsyncCallback<Boolean> callback) {
	}

	@Override
	public UserSession getUserSession() {
		return null;
	}

	@Override
	public void updateAcceptedPrivacyPolicyVersion(int newAcceptedPrivacyPolicyVersion) {

	}
}
