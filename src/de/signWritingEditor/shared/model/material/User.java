package de.signWritingEditor.shared.model.material;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.UserRole;

public class User implements Serializable {
	private static final String EURO_SPECIALS = "ÄÀÁÂÃäàáâãÇçÈÉÊËèéêëÌÍÎìíîïÑñÖÒÓÔÕöòóôõøßŠšÜÙÚÛüùúûÝýÿŸŽž";
	private static final String VALID_NAME_CHARACTERS = "[A-Za-z0-9" + EURO_SPECIALS + "\\- ]";
	private static final String VALID_USERNAME_CHARACTERS = "[A-Za-z0-9" + "+#_\\-|.:]";
	private static final String VALID_PASSWORD_CHARACTERS = "[A-Za-z0-9" + "+#_\\-|\"$!?%&.:;,]";

	private static final long serialVersionUID = 5850290296332638248L;

	private static final String UNKNOWN_USERNAME = "unknown";
	private static final String IMPORTED_USERNAME = "imported";
	private static final String DELETED_USERNAME = "deleted";
	private static final String SYSTEM_USERNAME = "system";

	private static final User UNKNOWN_USER = new User(UNKNOWN_USERNAME, UNKNOWN_USERNAME, UNKNOWN_USERNAME, null,
			Arrays.asList(UserRole.USER, UserRole.UNKNOWN));
	private static final User IMPORTED_USER = new User(IMPORTED_USERNAME, IMPORTED_USERNAME, IMPORTED_USERNAME, null,
			Arrays.asList(UserRole.USER, UserRole.AUTHOR));
	private static final User DELETED_USER = new User(DELETED_USERNAME, DELETED_USERNAME, DELETED_USERNAME, null,
			Arrays.asList(UserRole.USER));
	private static final User SYSTEM_USER = new User(SYSTEM_USERNAME, SYSTEM_USERNAME, SYSTEM_USERNAME, null,
			Arrays.asList(UserRole.USER));

	private static final int USERNAME_MAX_LENGTH = 30;
	private static final int USERNAME_MIN_LENGTH = 4;

	// validated against lower case variants of usernames
	private static final List<String> RESERVED_USERNAMES = Arrays
			.asList(new String[] { "admin", "test", "username", "user", "delegs", "c1wps", "c1-wps", "wps",
					"workplace-solutions", UNKNOWN_USERNAME, IMPORTED_USERNAME, DELETED_USERNAME, SYSTEM_USERNAME });

	private String username;
	private String firstName;
	private String lastName;

	private EmailAddress emailAddress;

	private List<UserRole> roles;

	private boolean isAdmin;

	private int acceptedPrivacyPolicyVersion;

	public User(String username, String firstName, String lastName, EmailAddress emailAddress, List<UserRole> roles,
			int acceptedPrivacyPolicyVersion) {
		this(username, firstName, lastName, emailAddress, false, roles, acceptedPrivacyPolicyVersion);
	}

	public User(String username, String firstName, String lastName, EmailAddress emailAddress, boolean isAdmin,
			List<UserRole> roles, int acceptedPrivacyPolicyVersion) {
		assert username != null : "Precondition failed: username != null";
		assert firstName != null : "Precondition failed: firstName != null";
		assert lastName != null : "Precondition failed: lastName != null";
		assert roles != null : "Precondition failed: roles != null";
		assert acceptedPrivacyPolicyVersion >= 0 : "Precondition failed: acceptedPrivacyPolicyVersion >= 0";

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.isAdmin = isAdmin;
		this.roles = roles;
		this.acceptedPrivacyPolicyVersion = acceptedPrivacyPolicyVersion;
	}

	private User(String username, String firstName, String lastName, EmailAddress emailAddress, List<UserRole> roles) {
		this(username, firstName, lastName, emailAddress, false, roles, 0);
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public String getDisplayUsername() {
		return UNKNOWN_USERNAME.equals(username) ? I18N.getUnknownUserName() : username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		assert firstName != null : "Precondition failed: firstName != null";

		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		assert lastName != null : "Precondition failed: lastName != null";

		this.lastName = lastName;
	}

	public int getAcceptedPrivacyPolicyVersion() {
		return acceptedPrivacyPolicyVersion;
	}

	public void setAcceptedPrivacyPolicyVersion(int acceptedPrivacyPolicyVersion) {
		assert acceptedPrivacyPolicyVersion >= 0 : "Precondition failed: acceptedPrivacyPolicyVersion >= 0";

		this.acceptedPrivacyPolicyVersion = acceptedPrivacyPolicyVersion;
	}

	@Override
	public String toString() {
		String result = "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + (emailAddress != null ? emailAddress.asString() : "null") + ", roles={";

		for (UserRole role : roles) {
			result += role.name() + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "}]";

		return result;
	}

	@Override
	public int hashCode() {
		int result = 1;

		final int prime = 31;

		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;

		if (!result && obj != null && obj instanceof User) {
			User other = (User) obj;

			if (username != null) {
				result = username.equals(other.username);
			} else {
				result = other.username == null;
			}
		}

		return result;
	}

	public boolean hasEmailAddress() {
		return emailAddress != null;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public static boolean isReservedUsername(String username) {
		return RESERVED_USERNAMES.contains(username.toLowerCase());
	}

	public static boolean isValidName(String name) {
		return name != null && !name.isEmpty() && name.equals(name.trim()) && name.length() <= 50
				&& name.matches(VALID_NAME_CHARACTERS + "+");
	}

	public static boolean isValidUsername(String username) {
		return username != null && username.length() >= USERNAME_MIN_LENGTH && username.length() <= USERNAME_MAX_LENGTH
				&& !isReservedUsername(username) && username.matches(VALID_USERNAME_CHARACTERS + "+");
	}

	public static boolean isValidPassword(String password) {
		return password != null && !password.isEmpty() && password.length() >= 6 && password.length() <= 50
				&& password.matches(VALID_PASSWORD_CHARACTERS + "+");
	}

	public static User getUnknownUser() {
		assert UNKNOWN_USER != null : "Precondition failed: result != null";
		return UNKNOWN_USER;
	}

	public static User getImportedUser() {
		assert IMPORTED_USER != null : "Precondition failed: result != null";
		return IMPORTED_USER;
	}

	public static User getDeletedUser() {
		assert DELETED_USER != null : "Precondition failed: result != null";
		return DELETED_USER;
	}

	public static User getSystemUser() {
		assert SYSTEM_USER != null : "Precondition failed: SYSTEM_USER != null";
		return SYSTEM_USER;
	}

	// protected

	/**
	 * For GWT serialization only.
	 */
	@Deprecated
	protected User() {
	}

	public boolean isAuthor() {
		return roles.contains(UserRole.AUTHOR);
	}

	public boolean isLecturer() {
		return roles.contains(UserRole.LECTURER) || isAuthor();
	}

	public boolean isUnknown() {
		return roles.contains(UserRole.UNKNOWN);
	}

}
