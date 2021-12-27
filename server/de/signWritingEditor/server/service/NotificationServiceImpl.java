package de.signWritingEditor.server.service;

import java.util.List;

import de.signWritingEditor.client.service.NotificationService;
import de.signWritingEditor.server.persistence.NotificationDb;
import de.signWritingEditor.shared.model.material.Notification;

public class NotificationServiceImpl implements NotificationService {

	private NotificationDb notificationDb;

	public NotificationServiceImpl(NotificationDb notificationDb) {
		this.notificationDb = notificationDb;
	}

	@Override
	public List<Notification> getNotifications(String username) {
		return notificationDb.getNotifications(username);
	}

	@Override
	public int getNotificationCount(String username) {
		return notificationDb.getnotificationCount(username);
	}

	@Override
	public void removeNotificationEntry(String username) {
		notificationDb.removeUserNotificationEntry(username);
	}
}
