package de.signWritingEditor.server.service;

import java.util.Arrays;

import de.signWritingEditor.client.service.AuthenticationService;
import de.signWritingEditor.client.service.QueryResult;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.sessionService.SystemSessionService;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserDb userDb;
	private final SystemSessionService sessionService;
	private final SendEmailService sendEmailService;

	public AuthenticationServiceImpl(UserDb userDb, SystemSessionService sessionService,
			SendEmailService sendEmailService) {
		assert userDb != null : "Precondition failed: userDb != null";
		assert sessionService != null : "Precondition failed: sessionService != null";

		this.userDb = userDb;
		this.sessionService = sessionService;
		this.sendEmailService = sendEmailService;
	}

	@Override
	public UserSession login(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		UserSession result = sessionService.createUnknownUserSession();

		if (userDb.isValidCredential(username, password)) {
			User user = userDb.getUser(username);
			if (userDb.isUserActivated(user)) {
				result = sessionService.createStandardUserSession(user);
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public void updateAcceptedPrivacyPolicyVersion(User user, int newAcceptedPrivacyPolicyVersion) {
		assert user
				.getAcceptedPrivacyPolicyVersion() < newAcceptedPrivacyPolicyVersion : "Precondition failed: user.getAcceptedPrivacyPolicyVersion() < newAcceptedPrivacyPolicyVersion";

		user.setAcceptedPrivacyPolicyVersion(newAcceptedPrivacyPolicyVersion);
		userDb.updateAcceptedPrivacyPolicyVersionForUser(user);
	}

	@Override
	public void logout(SessionKey sessionKey) {
		assert sessionKey != null : "Precondition failed: user != null";

		sessionService.invalidateSession(sessionKey);
	}

	@Override
	public boolean isAdminUser(String username, SessionKey sessionKey) {
		assert username != null : "Precondition failed: username != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		boolean result = false;

		if (userDb.existsUsername(username)) {
			result = userDb.getUser(username).isAdmin();
		}

		return result;
	}

	@Override
	public User registerUser(String username, String firstName, String lastName, String password,
			EmailAddress emailAddress, int privacyPolicyVersionNumber) {
		assert username != null : "Precondition failed: username != null";
		assert firstName != null : "Precondition failed: firstName != null";
		assert lastName != null : "Precondition failed: lastName != null";
		assert password != null : "Precondition failed: password != null";
		assert emailAddress != null : "Precondition failed: emailAddress != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber >= 0";
		assert !username.isEmpty() : "Precondition failed: !username.isEmpty()";
		assert !firstName.isEmpty() : "Precondition failed: !firstName.isEmpty()";
		assert !lastName.isEmpty() : "Precondition failed: !lastName.isEmpty()";
		assert !password.isEmpty() : "Precondition failed: !password.isEmpty()";
		assert User.isValidUsername(username) : "Precondition failed: User.isValidUsername(username)";
		assert User.isValidName(firstName) : "Precondition failed: User.isValidName(firstName)";
		assert User.isValidName(lastName) : "Precondition failed: User.isValidName(lastName)";
		assert User.isValidPassword(password) : "Precondition failed: User.isValidPassword(password)";

		User user = new User(username, firstName, lastName, emailAddress,
				Arrays.asList(new UserRole[] { UserRole.USER }), privacyPolicyVersionNumber);

		userDb.registerUser(user, password);

		SendEmailService validationEmailService = sendEmailService;
		User registeredUser = userDb.getUser(username);

		validationEmailService.sendRegistrationEmailToUser(registeredUser);

		return registeredUser;
	}

	@Override
	public QueryResult<UserQueryResultReason> existsUser(String username, EmailAddress emailAddress) {
		assert username != null : "Precondition failed: username != null";

		boolean result;
		UserQueryResultReason reason;

		if ((userDb.existsUsername(username) || User.isReservedUsername(username))) {
			result = true;
			reason = UserQueryResultReason.USERNAME_EXISTS;
		} else if (userDb.existsEmail(emailAddress)) {
			result = true;
			reason = UserQueryResultReason.EMAIL_EXISTS;
		} else {
			result = false;
			reason = UserQueryResultReason.USER_DOES_NOT_EXIST;
		}

		return new QueryResult<UserQueryResultReason>(result, reason);
	}

	@Override
	public QueryResult<UserQueryResultReason> isUserActivated(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		boolean result;
		UserQueryResultReason reason;

		if (userDb.isValidCredential(username, password)) {
			User user = userDb.getUser(username);
			result = userDb.isUserActivated(user);
			reason = result ? UserQueryResultReason.USER_ACTIVATED : UserQueryResultReason.USER_NOT_ACTIVATED;
		} else {
			result = false;
			reason = UserQueryResultReason.INVALID_CREDENTIALS;
		}

		return new QueryResult<AuthenticationService.UserQueryResultReason>(result, reason);
	}
}
