package de.signWritingEditor.client.service;

import java.util.List;

import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public interface UserService {

	public boolean addUserToRoom(RoomItem room, String userName, SessionKey sessionKey) throws Exception;

	public boolean deleteUserFromRoom(RoomItem room, String userName, SessionKey sessionKey) throws Exception;

	public User getUserFromUserName(String userName);

	public boolean sendPasswordForgottenEmail(String usernameOrMail);

	public boolean addAdminToRoom(RoomItem room, String adminName, SessionKey sessionKey) throws Exception;

	public boolean deleteAdminFromRoom(RoomItem room, String adminName, SessionKey sessionKey) throws Exception;

	public boolean existsUsers(List<String> userNames);

	public boolean hasVideoAndImagePermission(SessionKey sessionKey) throws InvalidSessionException;
}
