package de.signWritingEditor.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.material.Notification;

public interface NotificationServiceAsync {

	public void getNotifications(String username, AsyncCallback<List<Notification>> callback);

	public void removeNotificationEntry(String username, AsyncCallback<Void> callback);

	public void getNotificationCount(String username, AsyncCallback<Integer> callback);

}
