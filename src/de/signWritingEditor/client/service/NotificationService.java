package de.signWritingEditor.client.service;

import java.util.List;

import de.signWritingEditor.shared.model.material.Notification;

public interface NotificationService {

	public List<Notification> getNotifications(String username);

	public void removeNotificationEntry(String username);

	public int getNotificationCount(String username);
}
