package de.signWritingEditor.server.service;

import java.util.List;

import de.signWritingEditor.client.service.UserService;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.persistence.UserDb.UserRoomPrivilege;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public class UserServiceImpl implements UserService {

	private final UserDb userDb;
	private final SendEmailService emailService;
	private UserDb userDb2;

	public UserServiceImpl(UserDb userDb, SendEmailService emailService) {
		assert userDb != null : "Precondition failed: userDb != null";
		this.userDb = userDb;
		this.emailService = emailService;
	}

	public boolean changePassword(String userNameOrMail, String password) {
		assert userNameOrMail != null : "Precondition failed: user != null";
		assert password != null : "Precondition failed: password != null";

		boolean result = false;
		User user = null;

		if (existsUsername(userNameOrMail)) {
			user = userDb.getUser(userNameOrMail);
		} else if (existsEmailAddress(userNameOrMail)) {
			user = userDb.getUserByEMail(new EmailAddress(userNameOrMail));
		}

		if (user != null) {
			result = userDb.changePassword(user, password);
		}

		return result;
	}

	public boolean existsUserByUserNameOrMail(String usernameOrMail) {
		assert usernameOrMail != null : "Precondition failed: usernameOrMail != null";

		return existsUsername(usernameOrMail) || existsEmailAddress(usernameOrMail);
	}

	public User getUserByUsernameOrMail(String usernameOrMail) {
		assert usernameOrMail != null : "Precondition failed: usernameOrMail != null";

		User user = null;

		if (existsUsername(usernameOrMail)) {
			user = userDb.getUser(usernameOrMail);
		} else if (existsEmailAddress(usernameOrMail)) {
			user = userDb.getUserByEMail(new EmailAddress(usernameOrMail));
		}

		return user;
	}

	public boolean existsUsername(String username) {
		assert username != null : "Precondition failed: username != null";

		return userDb.existsUsername(username);
	}

	public boolean existsUsers(List<String> userNames) {
		boolean result = true;

		for (String user : userNames) {
			if (!existsUsername(user)) {
				result = false;
				break;
			}
		}

		return result;
	}

	public boolean existsEmailAddress(String emailaddress) {
		assert emailaddress != null : "Precondition failed: emailaddress != null";

		boolean result = false;
		if (EmailAddress.isValidAddressFormat(emailaddress)) {
			result = userDb.existsEmail(new EmailAddress(emailaddress));
		}
		return result;
	}

	public void sendPasswordForgottenEmail(User user) {
		assert user != null : "Precondition failed: user != null";

		emailService.sendPasswordForgottenEmail(user);
	}

	@Override
	public boolean sendPasswordForgottenEmail(String usernameOrMail) {
		boolean result = false;

		User user = getUserByUsernameOrMail(usernameOrMail);
		if (user != null && user.hasEmailAddress()) {
			sendPasswordForgottenEmail(user);
			result = true;
		}
		return result;
	}

	@Override
	public boolean addUserToRoom(RoomItem room, String userName, SessionKey sessionKey) {
		assert room != null : "Precondition failed: room != null";
		assert userName != null : "Precondition failed: userName != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null ";

		boolean result = existsUsername(userName);

		if (result) {
			User user = getUserByUsernameOrMail(userName);
			result = !userDb.isUserInRoom(room, user);
			if (result) {
				result = userDb.addUserToRoom(room, user);
			}
		}

		return result;
	}

	@Override
	public boolean deleteUserFromRoom(RoomItem room, String userName, SessionKey sessionKey) throws Exception {
		assert room != null : "Precondition failed: room != null";
		assert userName != null : "Precondition failed: userName != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		boolean result = false;

		if (existsUsername(userName)) {
			User user = getUserByUsernameOrMail(userName);
			if (userDb.isUserInRoom(room, user)) {
				result = userDb.deleteUserFromRoom(room, user);
			}
		}
		return result;
	}

	@Override
	public User getUserFromUserName(String userName) {
		assert existsUsername(userName);
		return getUserByUsernameOrMail(userName);
	}

	@Override
	public boolean addAdminToRoom(RoomItem room, String adminName, SessionKey sessionKey) {
		assert room != null : "Precondition failed: room != null";
		assert adminName != null : "Precondition failed: adminName != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		boolean result = existsUsername(adminName);

		if (result) {
			User user = getUserByUsernameOrMail(adminName);
			if (userDb.isUserInRoom(room, user)) {
				result = userDb.changeUserRoomPrivileges(room, user, UserRoomPrivilege.ADMIN);
			} else {
				result = userDb.addAdminToRoom(room, user);
			}
		}
		return result;
	}

	@Override
	public boolean deleteAdminFromRoom(RoomItem room, String adminName, SessionKey sessionKey) {
		assert room != null : "Precondition failed: room != null";
		assert adminName != null : "Precondition failed: adminName != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		boolean result = existsUsername(adminName);

		if (result) {
			User user = getUserByUsernameOrMail(adminName);
			result = userDb.isUserInRoom(room, user);
			if (result) {
				result = userDb.changeUserRoomPrivileges(room, user, UserRoomPrivilege.USER);
			}
		}
		return result;
	}

	@Override
	public boolean hasVideoAndImagePermission(SessionKey sessionKey) {
		throw new UnsupportedOperationException();
	}
}
