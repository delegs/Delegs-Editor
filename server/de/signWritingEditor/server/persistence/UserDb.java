package de.signWritingEditor.server.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.User;

public class UserDb extends MaterialDB {
	public enum UserRoomPrivilege {
		USER, ADMIN
	}

	private static final Logger LOG = Logger.getLogger(UserDb.class);

	protected static final String TABLENAME_USER = "user";
	private static final String TABLENAME_FOLDERS = "folders";
	private static final String TABLENAME_USER_ROLES = "userroles";
	private static final String TABLENAME_ROOM_USERS = "roomusers";

	public UserDb(DbConnector connector) {
		super(connector);
	}

	public User getUser(String username) {
		assert username != null : "Precondition failed: username != null";
		assert existsUsername(username) : "Precondition failed: existsUser(username)";

		Query query = createQuery("SELECT username, firstname, lastname, isAdmin, email, acceptedprivacypolicy FROM "
				+ TABLENAME_USER + " WHERE username = ?", username);

		return createUserFromQuery(query);
	}

	public List<User> getAllUsers() {

		String queryString = String.format("SELECT username, firstname, lastname, isAdmin, email, acceptedprivacypolicy FROM %s",TABLENAME_USER);
		Query query = createQuery(queryString);
		return createUsersFromQuery(query);
	}

	public User getUserByEMail(EmailAddress mailAddress) {
		assert mailAddress != null : "Precondition failed: mailAddress != null";

		Query query = createQuery("SELECT username, firstname, lastname, isAdmin, email, acceptedprivacypolicy FROM "
				+ TABLENAME_USER + " WHERE email = ?", mailAddress.asString());

		User result = null;

		if (existsEmail(mailAddress)) {
			result = createUserFromQuery(query);
		}
		return result;
	}

	public boolean isValidCredential(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		String hashPassword = PasswordHashUtil.hash(password);

		return createQuery("SELECT COUNT(*) FROM " + TABLENAME_USER + " WHERE username = ? AND password = ?", username,
				hashPassword).getNumberOfMatches() > 0;
	}

	public boolean saveUser(User user, String passwordHash) {
		assert user != null : "Precondition failed: user != null";
		assert passwordHash != null : "Precondition failed: passwordHash != null";
		assert isUserEmailValid(user) : "Precondition failed: isUserEmailValid(user)";
		assert !user.getRoles().isEmpty() : "Precondition failed: !user.getRoles().isEmpty()";

		boolean result = false;

		int isAdminValue = user.isAdmin() ? 1 : 0;

		String emailString = user.hasEmailAddress() ? user.getEmailAddress().asString() : null;

		if (existsUserWithName(user)) {
			result = createQuery("UPDATE " + TABLENAME_USER
					+ " SET firstname = ?, lastname = ?, password = ?, email= ?, isAdmin = ?, acceptedprivacypolicy = ? WHERE username = ?",
					user.getFirstName(), user.getLastName(), passwordHash, emailString, isAdminValue,
					user.getAcceptedPrivacyPolicyVersion(), user.getUsername()).execute();
		} else {
			result = createQuery("INSERT INTO " + TABLENAME_USER
					+ " (username, firstname, lastname, password, email, isAdmin, activated, acceptedprivacypolicy) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					user.getUsername(), user.getFirstName(), user.getLastName(), passwordHash, emailString,
					isAdminValue, 0, user.getAcceptedPrivacyPolicyVersion()).execute();
			for (int i = 0; i < user.getRoles().size(); i++) {
				createQuery("INSERT INTO " + TABLENAME_USER_ROLES + " (username, role) VALUES (?, ?)",
						user.getUsername(), user.getRoles().get(i).name()).execute();
			}
		}

		assert !result || existsUserWithName(user) : "!result || exists(id)";
		return result;
	}

	public boolean delete(User user) {
		assert user != null : "Precondition failed: user != null";
		assert existsUsername(user.getUsername()) : "Precondition failed: existsUser(user.getUsername())";

		boolean result = deleteUser(user.getUsername());

		assert result != existsUsername(
				user.getUsername()) : "Postcondition failed: result != existsUser(user.getUsername())";
		return result;
	}

	public boolean deleteUser(String userName) {
		assert userName != null : "Precondition failed: userName != null";
		assert existsUsername(userName) : "Precondition failed: existsUser(userName)";

		boolean result = createQuery("UPDATE " + TABLENAME_FOLDERS + " SET owner = ? WHERE owner = ?",
				User.getDeletedUser().getUsername(), userName).execute();
		if (result) {
			result = createQuery("DELETE FROM " + TABLENAME_USER + " WHERE username = ?", userName).execute();
		}

		assert result != existsUsername(userName) : "Postcondition failed: result != existsUser(userName)";
		return result;
	}

	public boolean existsUserWithName(User user) {
		assert user != null : "Precondition failed: user != null";

		return existsUsername(user.getUsername());
	}

	public boolean existsUsername(String username) {
		assert username != null : "Precondition failed: username != null";

		return exists(username, TABLENAME_USER, "username");
	}

	public boolean existsEmail(EmailAddress emailAddress) {
		return exists(emailAddress.asString(), TABLENAME_USER, "email");
	}

	public boolean isUserEmailValid(User user) {
		return user.hasEmailAddress() ? canUserHaveEmailAddress(user) : true;
	}

	public boolean activateUser(User user) {
		assert user != null : "Precondition failed: user != null";

		return createQuery("UPDATE " + TABLENAME_USER + " SET activated=1 WHERE username=?", user.getUsername())
				.execute();
	}

	public void updateAcceptedPrivacyPolicyVersionForUser(User user) {
		assert user != null : "Precondition failed: user != null";

		createQuery("UPDATE " + TABLENAME_USER + " SET acceptedprivacypolicy=? WHERE username=?",
				user.getAcceptedPrivacyPolicyVersion(), user.getUsername()).execute();
	}

	public boolean isUserActivated(User user) {
		assert user != null : "Precondition failed: user != null";

		int activated = createQuery("SELECT activated FROM " + TABLENAME_USER + " WHERE username = ?",
				user.getUsername()).getInt();

		return activated != 0;
	}

	public boolean registerUser(User user, String password) {
		assert user != null : "Precondition failed: user != null";
		assert password != null : "Precondition failed: password != null";
		assert !existsUserWithName(user) : "Precondition failed: !existsUser(user)";

		String passwordHash = PasswordHashUtil.hash(password);
		boolean result = saveUser(user, passwordHash);

		return result;
	}

	public boolean changePassword(User user, String password) {
		assert user != null : "Precondition failed: user != null";
		assert password != null : "Precondition failed: password != null";
		assert existsUserWithName(user) : "Precondition failed: existsUser(user)";

		String passwordHash = PasswordHashUtil.hash(password);
		boolean result = changeUserPassword(user, passwordHash);

		return result;
	}

	public List<String> getAllUsernames() {
		return getAllIds(TABLENAME_USER, "username");
	}

	public boolean isUserInRoom(final RoomItem room, final User user) {
		return createQuery(
				"SELECT COUNT(*) FROM " + TABLENAME_ROOM_USERS
						+ " WHERE username = ? AND roomUpperId = ? AND roomLowerId = ?;",
				user.getUsername(), room.getId().getUpperIdPart(), room.getId().getLowerIdPart())
						.getNumberOfMatches() == 1;
	}

	public boolean addUserToRoom(RoomItem room, User user) {
		return addUserToRoom(room, user, false);
	}

	public boolean addAdminToRoom(RoomItem room, User user) {
		return addUserToRoom(room, user, true);
	}

	private boolean addUserToRoom(RoomItem room, User user, boolean isAdmin) {
		assert !isUserInRoom(room, user) : "Precondition failed !isUserInRoom(room, user)";
		return createQuery(
				"INSERT INTO " + TABLENAME_ROOM_USERS
						+ " (`username`, `roomUpperId`, `roomLowerId`, `isOwner`) VALUES (?, ?, ?, ?);",
				user.getUsername(), room.getId().getUpperIdPart(), room.getId().getLowerIdPart(), isAdmin).execute();
	}

	public boolean deleteUserFromRoom(RoomItem room, User user) {
		assert isUserInRoom(room, user) : "Precondition failed isUserInRoom(room, user)";
		return createQuery(
				"DELETE FROM " + TABLENAME_ROOM_USERS + " WHERE `username`= ? and`roomUpperId`= ? and`roomLowerId`= ?;",
				user.getUsername(), room.getId().getUpperIdPart(), room.getId().getLowerIdPart()).execute();
	}

	public boolean changeUserRoomPrivileges(RoomItem room, User user, UserRoomPrivilege admin) {
		boolean isAdmin = admin.equals(UserRoomPrivilege.ADMIN);
		return createQuery(
				"UPDATE " + TABLENAME_ROOM_USERS
						+ " SET `isOwner`=? WHERE `username`=? and`roomUpperId`=? and`roomLowerId`=?;",
				isAdmin, user.getUsername(), room.getId().getUpperIdPart(), room.getId().getLowerIdPart()).execute();
	}

	private User createUserFromQuery(Query query) {
		assert query != null : "Precondition failed: query != null";

		return query.mapRows(new ResultSetFunction<User>() {

			@Override
			public User apply(ResultSet resultSet) throws SQLException {
				// Return username from database to make sure small and capital
				// letters are like inside the database:
				return getUser(resultSet);
			}
		}).get(0);

	}

	private List<User> createUsersFromQuery(Query query) {
		assert query != null : "Precondition failed: query != null";

		return query.mapRows(new ResultSetFunction<User>() {

			@Override
			public User apply(ResultSet resultSet) throws SQLException {
				return getUser(resultSet);
			}
		});
	}

	private User getUser(ResultSet resultSet) throws SQLException {
		String resultUsername = resultSet.getString("username");
		String firstName = resultSet.getString("firstname");
		String lastName = resultSet.getString("lastname");

		String mailAddressString = resultSet.getString("email");
		EmailAddress emailAddress = mailAddressString != null
				&& EmailAddress.isValidAddressFormat(mailAddressString) ? new EmailAddress(mailAddressString)
				: null;

		boolean isAdmin = resultSet.getBoolean("isAdmin");

		int acceptedPrivacyPolicyVersion = resultSet.getInt("acceptedprivacypolicy");

		List<UserRole> userRoles = getUserRoles(resultUsername);

		return new User(resultUsername, firstName, lastName, emailAddress, isAdmin, userRoles,
				acceptedPrivacyPolicyVersion);
	}

	private boolean changeUserPassword(User user, String passwordHash) {
		assert user != null : "Precondition failed: user != null";
		assert passwordHash != null : "Precondition failed: passwordHash != null";

		return createQuery("UPDATE " + TABLENAME_USER + " SET password = ? WHERE username = ?", passwordHash,
				user.getUsername()).execute();
	}

	protected List<UserRole> getUserRoles(String username) {
		assert username != null : "Precondition failed: username != null";
		assert existsUsername(username) : "Precondition failed: existsUsername(username)";

		return createQuery("SELECT role FROM " + TABLENAME_USER_ROLES + " WHERE username = ?", username)
				.mapRows(new ResultSetFunction<UserRole>() {

					@Override
					public UserRole apply(ResultSet resultSet) throws SQLException {
						return UserRole.valueOf(resultSet.getString("role"));
					}
				});
	}

	protected boolean canUserHaveEmailAddress(User user) {
		assert user != null : "Precondition failed: user != null";
		assert user.hasEmailAddress() : "Precondition failed: user.hasEmailAddress()";

		boolean result = !existsEmail(user.getEmailAddress());

		// If email exists, check if user owns the address himself
		if (!result && existsUserWithName(user)) {
			User userInDb = getUser(user.getUsername());
			if (userInDb.hasEmailAddress()) {
				result = userInDb.getEmailAddress().equals(user.getEmailAddress());
			}
		}

		return result;
	}
}
