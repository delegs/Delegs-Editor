package de.signWritingEditor.server.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.model.material.Notification;
import de.signWritingEditor.shared.model.material.User;

public class NotificationDb extends MaterialDB {

	private static final String TABLENAME_NOTIFICATION = "notification";
	private static final String TABLENAME_USERNOTIFICATION = "usernotification";
	private static final Logger LOG = Logger.getLogger(NotificationDb.class);

	public NotificationDb(DbConnector connector) {
		super(connector);
	}

	public List<Notification> getNotifications(String username) {

		if (User.getUnknownUser().getUsername().equals(username)) {
			return getNotificationsForUnknownUser();
		} else {
			List<Notification> notifications = getNotificationsForUser();
			return notifications;
		}
	}

	public void removeUserNotificationEntry(String username) {

		// Momentan werden alle Notification-Einträge aus der Datenbank für den
		// User gelöscht, da es erstmal nur einen Eintrag geben wird.
		createQuery("DELETE FROM " + TABLENAME_USERNOTIFICATION + " WHERE username = ?", username).execute();
	}

	private List<Notification> getNotificationsForUser() {

		Query query = createQuery(
				"SELECT DISTINCT notificationId FROM " + TABLENAME_NOTIFICATION + " WHERE loggedIn = 1");

		List<Notification> result = createNotificationListFromQuery(query, true);
		return result;
	}

	private List<Notification> getNotificationsForUnknownUser() {
		Query query = createQuery(
				"SELECT DISTINCT notificationId FROM " + TABLENAME_NOTIFICATION + " WHERE loggedIn = 0");

		List<Notification> result = createNotificationListFromQuery(query, false);
		return result;
	}

	private List<Notification> createNotificationListFromQuery(Query query, boolean loggedIn) {
		assert query != null : "Precondition failed: query != null";

		final int loggedInTinyInt = loggedIn ? 1 : 0;

		List<Notification> result = query.mapRows(new ResultSetFunction<Notification>() {

			@Override
			public Notification apply(ResultSet resultSet) throws SQLException {
				int notificationId = resultSet.getInt("notificationId");

				Query notificationQuery = createQuery(
						"SELECT * FROM " + TABLENAME_NOTIFICATION + " WHERE notificationId = ? AND loggedIn = ?",
						notificationId, loggedInTinyInt);

				return createNotificationFromQuery(notificationQuery);
			}
		});

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private Notification createNotificationFromQuery(Query query) {
		assert query != null : "Precondition failed: query != null";

		Notification result = new Notification();

		List<List<String>> notifications = query.mapRows(new ResultSetFunction<List<String>>() {

			@Override
			public List<String> apply(ResultSet resultSet) throws SQLException {
				List<String> result = new ArrayList<String>();

				result.add(resultSet.getString("language"));
				result.add(resultSet.getString("notification"));

				return result;
			}
		});

		for (List<String> i : notifications) {
			result.addNotification(I18NLocale.valueOf(i.get(0)), i.get(1));
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public int getnotificationCount(String username) {

		if (User.getUnknownUser().getUsername().equals(username)) {
			return getNotificationCountForUnknownUser();
		} else {
			return getNotificationCountForUser(username);
		}
	}

	private int getNotificationCountForUser(String username) {
		Query query = createQuery(
				"SELECT count(notificationId) as count FROM " + TABLENAME_USERNOTIFICATION + " WHERE username = ?",
				username);

		return getNotificationCountFromQuery(query);
	}

	private int getNotificationCountForUnknownUser() {
		Query query = createQuery("SELECT count( distinct notificationId) as count FROM " + TABLENAME_NOTIFICATION);

		return getNotificationCountFromQuery(query);
	}

	private int getNotificationCountFromQuery(final Query query) {
		assert query != null : "Precondition failed: query != null";

		return query.mapFirstRow(new ResultSetFunction<Integer>() {
			@Override
			public Integer apply(ResultSet resultSet) throws SQLException {
				return resultSet.getInt("count");
			}

			@Override
			public void onError() {
				LOG.error("[GREPME] ResultSet closed: " + query);
			}
		});
	}
}
