package de.signWritingEditor.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public interface UserServiceAsync {

	public void addUserToRoom(RoomItem room, String userName, SessionKey sessionKey, AsyncCallback<Boolean> callback);

	public void deleteUserFromRoom(RoomItem room, String userName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback);

	public void getUserFromUserName(String userName, AsyncCallback<User> callback);

	public void sendPasswordForgottenEmail(String usernameOrMail, AsyncCallback<Boolean> callback);

	public void addAdminToRoom(RoomItem room, String adminName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback);

	public void deleteAdminFromRoom(RoomItem room, String adminName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback);

	public void existsUsers(List<String> usernames, AsyncCallback<Boolean> asyncCallback);

	public void hasVideoAndImagePermission(SessionKey sessionKey, AsyncCallback<Boolean> asyncCallback);
}
