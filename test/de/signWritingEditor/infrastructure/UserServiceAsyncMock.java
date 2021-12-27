package de.signWritingEditor.infrastructure;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public class UserServiceAsyncMock implements UserServiceAsync {

	@Override
	public void addUserToRoom(RoomItem room, String userName, SessionKey sessionKey, AsyncCallback<Boolean> callback) {
	}

	@Override
	public void deleteUserFromRoom(RoomItem room, String userName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback) {
	}

	@Override
	public void getUserFromUserName(String userName, AsyncCallback<User> callback) {
	}

	@Override
	public void sendPasswordForgottenEmail(String usernameOrMail, AsyncCallback<Boolean> callback) {
	}

	@Override
	public void addAdminToRoom(RoomItem room, String adminName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback) {
	}

	@Override
	public void deleteAdminFromRoom(RoomItem room, String adminName, SessionKey sessionKey,
			AsyncCallback<Boolean> asyncCallback) {
	}

	@Override
	public void existsUsers(List<String> usernames, AsyncCallback<Boolean> asyncCallback) {
	}

	@Override
	public void hasVideoAndImagePermission(SessionKey sessionKey, AsyncCallback<Boolean> asyncCallback) {
	}
}
