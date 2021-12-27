package de.signWritingEditor.server.badge.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.badge.shared.service.DataCouldNotBeStoredException;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.MaterialDB;
import de.signWritingEditor.server.persistence.ResultSetConsumer;
import de.signWritingEditor.shared.badge.model.domainValue.DelegsBadgeType;

public class BadgeDb extends MaterialDB {

	private static final Logger LOG = Logger.getLogger(BadgeDb.class);

	private static final String TABLENAME_USERBADGES = "userbadges";
	private static final String COLUMNNAME_USERNAME = "username";
	private static final String COLUMNNAME_BADGETYPE = "badgetype";
	private static final String COLUMNNAME_BADGE = "badge";

	public BadgeDb(DbConnector connector) {
		super(connector);
		assert connector != null : "Precondition failed: connector != null";
	}

	public void storeBadgesFor(JsonBadgesWithUsername badges) throws DataCouldNotBeStoredException {
		assert badges != null : "Precondition failed: badges != null";
		try (Connection connection = connector.getConnection()) {
			connection.setAutoCommit(false);
			try {
				for (Map.Entry<BadgeType, String> entry : badges.getBadges().entrySet()) {
					storeUserBadge(connection, badges.getUsername(), entry.getKey(), entry.getValue());
				}
				connection.commit();
			} catch (Exception ex) {
				// It is strongly recommended that an application explicitly
				// commits or rolls back an active transaction prior to calling
				// the close method. If the close method is called and there is
				// an active transaction, the results are
				// implementation-defined.
				// https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html#close()
				connection.rollback();
				throw ex;
			} finally {
				// not strictly required, as c3p0 resets "closed" connections
				// anyway
				connection.setAutoCommit(true);
			}
		} catch (SQLException connectionException) {
			LOG.error(connectionException.getMessage(), connectionException);
			throw new DataCouldNotBeStoredException(connectionException.getMessage());
		}
	}

	public JsonBadgesWithUsername getBadgesFor(final String username, final BadgeType[] badgeTypes,
			final boolean readOnly) {
		assert username != null : "Precondition failed: username != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";

		Map<BadgeType, String> allBadgesFor = getBadgesFor(username, badgeTypes);
		JsonBadgesWithUsername result = new JsonBadgesWithUsername(allBadgesFor, username);
		return result;
	}

	private void storeUserBadge(Connection connection, final String username, final BadgeType badgeType,
			final String badge) throws DataCouldNotBeStoredException {
		assert username != null : "Precondition failed: username != null";
		assert badgeType != null : "Precondition failed: badgeType != null";
		assert badge != null : "Precondition failed: badge != null";

		String error = "";
		// check if badge entry exists
		String checkIfEntryExists = "SELECT COUNT(*) AS amount FROM " + TABLENAME_USERBADGES + " WHERE "
				+ COLUMNNAME_USERNAME + " = ? AND " + COLUMNNAME_BADGETYPE + " = ?";
		Query query = createQuery(checkIfEntryExists, username, badgeType.getId());
		boolean entryExists = query.getNumberOfMatches(connection) > 0;

		boolean everythingWentWell = false;
		if (entryExists) {
			// update entry
			String userBadgeQuery = "UPDATE " + TABLENAME_USERBADGES + " SET " + COLUMNNAME_BADGE + " = ? " + "WHERE "
					+ COLUMNNAME_USERNAME + " = ? AND " + COLUMNNAME_BADGETYPE + " = ?";

			Query updateQuery = createQuery(userBadgeQuery, badge, username, badgeType.getId());
			everythingWentWell = updateQuery.execute(connection);
			if (!everythingWentWell) {
				error = "Could not update " + username + " 's badgetype " + badgeType + " as " + badge;
			}
		} else {
			// create new entry
			String userBadgeQuery = "INSERT INTO " + TABLENAME_USERBADGES + " (" + COLUMNNAME_USERNAME + ", "
					+ COLUMNNAME_BADGETYPE + ", " + COLUMNNAME_BADGE + ") VALUES (?, ?, ?)";

			everythingWentWell = createQuery(userBadgeQuery, username, badgeType.getId(), badge).execute(connection);
			if (!everythingWentWell) {
				error = "Could not create new badge for " + username + " with badgetype " + badgeType + " as " + badge;
			}
		}

		if (!everythingWentWell) {
			throw new DataCouldNotBeStoredException(error);
		}
	}

	private Map<BadgeType, String> getBadgesFor(final String username, BadgeType[] badgeTypes) {
		assert username != null : "Precondition failed: username != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";
		assert badgeTypes.length > 0 : "Precondition failed: badgeTypes.length > 0";

		final Map<BadgeType, String> badges = new HashMap<BadgeType, String>();

		String arrayString = "";
		for (int i = 0; i < badgeTypes.length; i++) {
			arrayString += "?,";
		}
		if (arrayString.length() > 1) {
			arrayString = arrayString.substring(0, arrayString.length() - 1);
		}

		String retrieveAllBadgesForUser = "SELECT " + COLUMNNAME_BADGETYPE + ", " + COLUMNNAME_BADGE + " FROM "
				+ TABLENAME_USERBADGES + " WHERE " + COLUMNNAME_USERNAME + " = ? AND " + COLUMNNAME_BADGETYPE + " IN ("
				+ arrayString + ") ";

		Object[] args = new Object[badgeTypes.length + 1];
		args[0] = username;
		for (int i = 0; i < badgeTypes.length; i++) {
			args[i + 1] = badgeTypes[i].getId();
		}
		Query query = createQuery(retrieveAllBadgesForUser, args);

		query.forEachRow(new ResultSetConsumer() {
			@Override
			public void accept(ResultSet badgeResultSet) throws SQLException {
				String badgeAsJsonString = badgeResultSet.getString(COLUMNNAME_BADGE);
				String badgeTypeString = badgeResultSet.getString(COLUMNNAME_BADGETYPE);
				try {
					BadgeType badgeType = DelegsBadgeType.valueOf(badgeTypeString);
					badges.put(badgeType, badgeAsJsonString);
				} catch (IllegalArgumentException e) {
					LOG.error("The database returned a badgetype string " + badgeTypeString
							+ " which is not defined in the enum BadgeType.", e);
				}
			}
		});

		return badges;
	}
}
