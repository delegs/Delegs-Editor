package de.signWritingEditor.client.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.service.AuthenticationService.UserQueryResultReason;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.ExpiryDate;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class LocalSessionServiceImpl implements LocalSessionService {

	private final static String USER_NAME_KEY = "userName";
	private final static String USER_FIRST_NAME_KEY = "userFirstName";
	private final static String USER_LAST_NAME_KEY = "userLastName";
	private final static String USER_IS_ADMIN_KEY = "userIsAdmin";
	private final static String USER_SESSION_KEY_KEY = "userSessionKey";
	private final static String USER_EXPIRY_TIME_KEY = "userExpiryTime";
	private final static String USER_EMAIL_ADDRESS_KEY = "userEmailAddress";
	private final static String USER_ROLES_KEY = "userRoles";
	private final static String USER_MESSAGE_KEY = "userMessage";
	private final static String USER_ACCEPTED_PRIVACY_POLICY_VERSION_KEY = "acceptedPrivacyPolicyVersion";
	private final static String DELIMITER = ";";

	private final SessionServiceAsync sessionServiceAsync;
	private final Storage localStorage;
	private final AuthenticationServiceAsync authenticationService;
	private LogonListener loginListener;
	private UserSession userSession;

	private final Reporter reporter;

	@Deprecated // test only
	protected LocalSessionServiceImpl(SessionServiceAsync sessionService, Storage storage,
			AuthenticationServiceAsync authenticationService, Reporter reporter) {
		this.sessionServiceAsync = sessionService;
		this.localStorage = storage;
		this.authenticationService = authenticationService;
		this.reporter = reporter;
		setUserSessionToUnknownUserSession();
	}

	public LocalSessionServiceImpl(SessionServiceAsync sessionService,
			AuthenticationServiceAsync authenticationService) {
		this(sessionService, Storage.getLocalStorageIfSupported(), authenticationService,
				new MessageDialogBoxReporter());
	}

	public void login(final String username, final String password) {
		assert password != null : "Precondition failed: password != null";
		assert username != null : "Precondition failed: username != null";

		authenticationService.isUserActivated(username, password,
				new SignWritingCallback<QueryResult<UserQueryResultReason>>(I18N.getErrorOnLogin()) {
					@Override
					public void onSuccess(QueryResult<UserQueryResultReason> result) {
						handleUserActivated(username, password, result);
					}
				});
	}

	public void updateAcceptedPrivacyPolicyVersion(int newAcceptedPrivacyPolicyVersion) {
		authenticationService.updateAcceptedPrivacyPolicyVersion(getCurrentUser(), newAcceptedPrivacyPolicyVersion,
				new SignWritingCallback<Void>("Fehler"));
		getCurrentUser().setAcceptedPrivacyPolicyVersion(newAcceptedPrivacyPolicyVersion);
		storeUserSession();
	}

	private void handleUserActivated(final String username, final String password,
			QueryResult<UserQueryResultReason> result) {
		if (result.getResult()) {
			authenticationService.login(username, password,
					new SignWritingCallback<UserSession>(I18N.getErrorOnLogin()) {
						@Override
						public void onSuccess(UserSession resultingUserSession) {
							handleSuccessfullLogin(resultingUserSession);
						}
					});
		} else {
			String loginErrorMessage = getUserNotActivatedMessage(result);

			loginListener.onLoginFailed(loginErrorMessage);

		}
	}

	private String getUserNotActivatedMessage(QueryResult<UserQueryResultReason> result) {
		String errorMessage;
		if (result.getReason() == UserQueryResultReason.INVALID_CREDENTIALS) {
			errorMessage = I18N.getCheckUserNameAndPassword();
		} else {
			errorMessage = I18N.getAccountNotActivated();
		}
		return errorMessage;

	}

	private void handleSuccessfullLogin(UserSession session) {
		setUserSession(session);
		if (getUserSession().getUser().isUnknown()) {
			reporter.report(I18N.getLoginFailed(), I18N.getCheckUserNameAndPassword());
		} else {
			storeUserSession();

			loginListener.onLogin();

		}
	}

	public void registerUser(final String username, final String firstName, final String lastName,
			final String password, final String emailAddressString, final int privacyPolicyVersionNumber) {
		if (!User.isValidUsername(username)) {
			reporter.report(I18N.getRegistrationNotPossible(), I18N.getInvalidUsername());
		} else if (!EmailAddress.isValidAddressFormat(emailAddressString)) {
			reporter.report(I18N.getRegistrationNotPossible(), I18N.getInvalidEmailAddress());
		} else {
			final EmailAddress emailAddress = new EmailAddress(emailAddressString);
			authenticationService.existsUser(username, emailAddress,
					new SignWritingCallback<QueryResult<UserQueryResultReason>>(I18N.getRegistrationError()) {
						@Override
						public void onSuccess(QueryResult<UserQueryResultReason> userExists) {
							super.onSuccess(userExists);
							handleUserExists(username, firstName, lastName, password, emailAddress,
									privacyPolicyVersionNumber, userExists);
						}
					});
		}

	}

	private void handleUserExists(final String username, final String firstName, final String lastName,
			final String password, final EmailAddress emailAddress, int privacyPolicyVersionNumber,
			QueryResult<UserQueryResultReason> userExists) {
		if (!userExists.getResult()) {
			registerUser(username, firstName, lastName, password, emailAddress, privacyPolicyVersionNumber);
		} else {
			String errorMessage;
			if (userExists.getReason() == UserQueryResultReason.USERNAME_EXISTS) {
				errorMessage = I18N.getUserNameNotAvailable();
			} else {
				errorMessage = I18N.getEmailAddressNotAvailable();
			}
			reporter.report(I18N.getRegistrationNotPossible(), errorMessage);
		}
	}

	private void registerUser(final String username, final String firstName, final String lastName,
			final String password, final EmailAddress emailAddress, int privacyPolicyVersionNumber) {
		authenticationService.registerUser(username, firstName, lastName, password, emailAddress,
				privacyPolicyVersionNumber, new SignWritingCallback<User>(I18N.getRegistrationError()) {
					@Override
					public void onSuccess(User result) {
						reporter.report(I18N.getActivateAccount(), I18N.getRegistrationDialogueMessageTextForUser(
								result.getFirstName(), result.getLastName()));
						super.onSuccess(result);
					}
				});
	}

	@Override
	public User getCurrentUser() {
		return getUserSession().getUser();
	}

	private SessionKey getCurrentSessionKey() {
		return getUserSession().getSessionKey();
	}

	@Override
	public void storeUserSession() {
		assert getUserSession() != null : "Precondition failed: getUserSession() != null";

		if (isLocalStorageSupported()) {
			User user = getUserSession().getUser();

			localStorage.setItem(USER_NAME_KEY, user.getUsername());
			localStorage.setItem(USER_FIRST_NAME_KEY, user.getFirstName());
			localStorage.setItem(USER_LAST_NAME_KEY, user.getLastName());
			localStorage.setItem(USER_IS_ADMIN_KEY, Boolean.toString(user.isAdmin()));
			localStorage.setItem(USER_SESSION_KEY_KEY, Long.toString(getUserSession().getSessionKey().getValue()));
			localStorage.setItem(USER_EXPIRY_TIME_KEY,
					Long.toString(getUserSession().getExpiryTime().getMillisecondsSinceUnixEpoch()));
			localStorage.setItem(USER_ROLES_KEY, serializeUserRoles(user.getRoles()));
			if (user.hasEmailAddress()) {
				localStorage.setItem(USER_EMAIL_ADDRESS_KEY, user.getEmailAddress().asString());
			}
			localStorage.setItem(USER_ACCEPTED_PRIVACY_POLICY_VERSION_KEY,
					Integer.toString(user.getAcceptedPrivacyPolicyVersion()));
		}
	}

	private String serializeUserRoles(List<UserRole> roles) {
		assert roles != null : "Precondition failed: roles != null";

		StringBuilder stringBuilder = new StringBuilder();

		int counter = 0;
		for (UserRole userRole : roles) {
			counter++;
			if (counter < roles.size()) {
				stringBuilder.append(userRole.name() + DELIMITER);
			} else {
				stringBuilder.append(userRole.name());
			}
		}

		return stringBuilder.toString();
	}

	@Override
	public void restoreUserSession(final AsyncCallback<Boolean> callback) {
		assert hasStoredUserSession() : "Precondition failed: hasStoredUserSession()";

		if (isLocalStorageSupported()) {
			final UserSession tempUserSession = getStoredUserSession();
			sessionServiceAsync.isUserSessionValid(tempUserSession.getSessionKey(), new AsyncCallback<Boolean>() {

				@Override
				public void onFailure(Throwable caught) {
					setUserSessionToUnknownUserSession();
					validateUserSession(callback);
				}

				@Override
				public void onSuccess(Boolean result) {
					if (result) {
						setUserSession(tempUserSession);
					} else {
						setUserSessionToUnknownUserSession();
					}
					validateUserSession(callback);
				}
			});
		} else {
			setUserSessionToUnknownUserSession();
		}

		assert getUserSession() != null : "Postcondition failed: getUserSession() != null";
	}

	private UserSession getStoredUserSession() {
		String userName = localStorage.getItem(USER_NAME_KEY);
		String userFirstName = localStorage.getItem(USER_FIRST_NAME_KEY);
		String userLastName = localStorage.getItem(USER_LAST_NAME_KEY);
		String userIsAdminString = localStorage.getItem(USER_IS_ADMIN_KEY);
		String userSessionKeyString = localStorage.getItem(USER_SESSION_KEY_KEY);
		String userExpiryTime = localStorage.getItem(USER_EXPIRY_TIME_KEY);
		String userEmailAddressString = localStorage.getItem(USER_EMAIL_ADDRESS_KEY);
		EmailAddress emailAddress = (userEmailAddressString != null
				&& EmailAddress.isValidAddressFormat(userEmailAddressString)) ? new EmailAddress(userEmailAddressString)
						: null;
		List<UserRole> userRoles = deserializeUserRoles(localStorage.getItem(USER_ROLES_KEY));

		String userAcceptedPrivacyPolicyVersionString = localStorage.getItem(USER_ACCEPTED_PRIVACY_POLICY_VERSION_KEY);
		int userAcceptedPrivacyPolicyVersion = 0;
		if (userAcceptedPrivacyPolicyVersionString != null) {
			userAcceptedPrivacyPolicyVersion = Integer.parseInt(userAcceptedPrivacyPolicyVersionString);
		}

		User user = new User(userName, userFirstName, userLastName, emailAddress, Boolean.valueOf(userIsAdminString),
				userRoles, userAcceptedPrivacyPolicyVersion);
		SessionKey sessionKey = new SessionKey(Long.valueOf(userSessionKeyString));
		ExpiryDate expiryTime = ExpiryDate.fromMilliseconds(Long.parseLong(userExpiryTime));
		final UserSession tempUserSession = new UserSession(user, sessionKey, expiryTime);
		return tempUserSession;
	}

	private List<UserRole> deserializeUserRoles(String roles) {
		assert roles != null : "Precondition failed: roles != null";

		List<UserRole> result = new ArrayList<UserRole>();

		String[] roleArray = roles.split(DELIMITER);
		for (String role : roleArray) {
			result.add(UserRole.valueOf(role));
		}

		return result;
	}

	@Override
	public boolean hasStoredUserSession() {
		boolean result = false;
		if (isLocalStorageSupported()) {
			result = localStorage.getItem(USER_NAME_KEY) != null && localStorage.getItem(USER_FIRST_NAME_KEY) != null
					&& localStorage.getItem(USER_LAST_NAME_KEY) != null
					&& localStorage.getItem(USER_IS_ADMIN_KEY) != null
					&& localStorage.getItem(USER_SESSION_KEY_KEY) != null
					&& localStorage.getItem(USER_EXPIRY_TIME_KEY) != null
					&& localStorage.getItem(USER_ROLES_KEY) != null;

		}
		return result;
	}

	@Override
	public void logout() {
		SessionKey currentSessionKey = getCurrentSessionKey();
		clearStoredUserSession();
		setUserSessionToUnknownUserSession();
		authenticationService.logout(currentSessionKey, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(Void result) {
			}
		});
	}

	private void clearStoredUserSession() {
		if (isLocalStorageSupported()) {
			localStorage.removeItem(USER_NAME_KEY);
			localStorage.removeItem(USER_FIRST_NAME_KEY);
			localStorage.removeItem(USER_LAST_NAME_KEY);
			localStorage.removeItem(USER_IS_ADMIN_KEY);
			localStorage.removeItem(USER_SESSION_KEY_KEY);
			localStorage.removeItem(USER_EXPIRY_TIME_KEY);
			localStorage.removeItem(USER_EMAIL_ADDRESS_KEY);
			localStorage.removeItem(USER_ROLES_KEY);
			localStorage.removeItem(USER_ACCEPTED_PRIVACY_POLICY_VERSION_KEY);
		}
		assert !hasStoredUserSession() : "Postcondition failed: !hasStoredUserSession()";
	}

	@Override
	public boolean isLocalStorageSupported() {
		return localStorage != null;
	}

	@Override
	public void setLocalSessionServiceListener(LogonListener logonListener) {
		assert logonListener != null : "Precondition failed: logonListener != null";
		loginListener = logonListener;
	}

	@Override
	public boolean isCurrentUserUnknown() {
		if (getUserSession() != null) {
			return getUserSession().getUser().isUnknown();
		} else {
			return true;
		}
	}

	@Override
	public void setUserSessionToUnknownUserSession() {
		if (userSession != null) {
			userSession.setUserToUnknownUser();
		}
		sessionServiceAsync.createUnknownUserSession(new AsyncCallback<UserSession>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Programing error: " + caught);
			}

			@Override
			public void onSuccess(UserSession result) {
				setUserSession(result);
			}
		});
	}

	private synchronized void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	@Override
	public synchronized UserSession getUserSession() {
		return userSession;
	}

	@Override
	public void validateUserSession(AsyncCallback<Boolean> callback) {
		sessionServiceAsync.isUserSessionValid(getCurrentSessionKey(), callback);
	}

	@Override
	public SessionKey getSessionKey() {
		return userSession.getSessionKey();
	}

	interface Reporter {
		public void report(String title, String message);
	}

	static class MessageDialogBoxReporter implements Reporter {
		@Override
		public void report(String title, String message) {
			new MessageDialogBox(title, message).center();
		}
	}
}
