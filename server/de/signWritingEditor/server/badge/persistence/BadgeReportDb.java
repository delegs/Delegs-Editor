package de.signWritingEditor.server.badge.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.badge.shared.model.material.BadgeReport;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.MaterialDB;
import de.signWritingEditor.server.persistence.ResultSetFunction;

public class BadgeReportDb extends MaterialDB {

	private static final Logger LOG = Logger.getLogger(BadgeReportDb.class);

	private static final String TABLENAME_BADGEREPORTS = "badgereports";
	private static final String COLUMNNAME_CREATIONDATE = "creationdate";
	private static final String COLUMNNAME_REPORT = "report";

	public BadgeReportDb(DbConnector connector) {
		super(connector);
		assert connector != null : "Precondition failed: connector != null";
	}

	public void saveBadgeReport(BadgeReport badgeReport) {
		assert badgeReport != null : "Precondition failed: badgeReport != null";

		String error = "";
		LOG.info("Storing new BadgeReport " + badgeReport);

		// create new entry
		String userBadgeQuery = "INSERT INTO " + TABLENAME_BADGEREPORTS + " (" + COLUMNNAME_CREATIONDATE + ", "
				+ COLUMNNAME_REPORT + ") VALUES (?, ?)";

		if (!createQuery(userBadgeQuery, new Timestamp(badgeReport.getCreationDate().getTime()), badgeReport.toJson())
				.execute()) {
			error = "Could not create new report " + badgeReport;
			LOG.error(error);
			throw new RuntimeException(error);
		}
	}

	public List<BadgeReport> getBadgeReportsSince(Date date) {
		assert date != null : "Precondition failed: date != null";

		String sql = "SELECT " + COLUMNNAME_REPORT + " FROM " + TABLENAME_BADGEREPORTS + " WHERE "
				+ COLUMNNAME_CREATIONDATE + " >= ? ORDER BY " + COLUMNNAME_CREATIONDATE + " ASC";

		Query query = createQuery(sql, new Timestamp(date.getTime()));

		return query.mapRows(new ResultSetFunction<BadgeReport>() {
			@Override
			public BadgeReport apply(ResultSet resultSet) throws SQLException {
				String reportAsJson = resultSet.getString(COLUMNNAME_REPORT);
				BadgeReport badgeReport = BadgeReport.JSON_BLANK_FACTORY.createJsonBlank();
				badgeReport.fromJson(reportAsJson);
				return badgeReport;
			}
		});
	}
}
