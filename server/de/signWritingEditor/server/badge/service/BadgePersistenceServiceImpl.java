package de.signWritingEditor.server.badge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.badge.client.gwtService.BadgePersistenceService;
import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeBoard;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.badge.shared.service.DataCouldNotBeStoredException;
import de.signWritingEditor.client.service.SessionService;
import de.signWritingEditor.server.badge.persistence.BadgeDb;
import de.signWritingEditor.server.badge.persistence.BadgeReportDb;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.shared.badge.model.domainValue.DelegsBadgeType;
import de.signWritingEditor.shared.badge.model.material.DelegsBadgeBoard;

public class BadgePersistenceServiceImpl implements BadgePersistenceService {

	private static final Logger LOG = Logger.getLogger(BadgePersistenceServiceImpl.class);

	private static final int MAX_TRIES = 15;
	private static final long WAITING_TIME_MS = 400;

	private BadgeDb badgeDb;
	private BadgeReportDb badgeReportDb;
	private SessionService sessionService;
	private UserDb userDb;

	public BadgePersistenceServiceImpl(DbConnector dbConnector, SessionService sessionService) {
		assert dbConnector != null : "Precondition failed: dbConnector != null";
		assert sessionService != null : "Precondition failed: sessionService != null";

		this.badgeDb = new BadgeDb(dbConnector);
		this.badgeReportDb = new BadgeReportDb(dbConnector);
		this.sessionService = sessionService;
		this.userDb = new UserDb(dbConnector);

		DelegsBadgeType.initialize();

		assert this.badgeDb != null : "Postcondition failed: this.badgeDb != null";
		assert this.badgeReportDb != null : "Postcondition failed: this.badgeReportDb != null";
		assert this.sessionService != null : "Postcondition failed: this.sessionService != null";
		assert this.userDb != null : "Postcondition failed: this.userDb != null";
	}

	@Override
	public void updateBadgesForUser(JsonBadgesWithUsername badges) throws DataCouldNotBeStoredException {
		assert badges != null : "Precondition failed: badges != null";
		badgeDb.storeBadgesFor(badges);
	}

	@Override
	public JsonBadgesWithUsername getBadgesForUser(String badgeUsername, BadgeType[] badgeTypes, boolean readOnly) {
		assert badgeUsername != null : "Precondition failed: badgeUsername != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";
		assert badgeTypes.length >= 1 : "Precondition failed: badgeTypes.length >= 1";
		return tryGetAllBadgesForUser(badgeUsername, badgeTypes, readOnly, 1);
	}

	public void createReport() {
		try {
			List<BadgeBoard> allUserBadgeBoards = new ArrayList<BadgeBoard>();

			for (String username : userDb.getAllUsernames()) {
				JsonBadgesWithUsername jsonBadgesForUser = tryGetAllBadgesForUser(username, DelegsBadgeType.values(),
						true, 1);
				allUserBadgeBoards.add(new DelegsBadgeBoard(jsonBadgesForUser.getUsername(),
						jsonBadgesForUser.getBadges(), BadgeType.values()));
			}

			BadgeReport badgeReport = new BadgeReport(allUserBadgeBoards);
			badgeReportDb.saveBadgeReport(badgeReport);
		} catch (Exception e) {
			LOG.error("Could not create badge report", e);
		}

	}

	@Override
	public List<BadgeReport> getBadgeReportsSince(Date date) {
		assert date != null : "Precondition failed: date != null";
		return badgeReportDb.getBadgeReportsSince(date);
	}

	private JsonBadgesWithUsername tryGetAllBadgesForUser(String username, BadgeType[] badgeTypes, boolean readOnly,
			int tryNr) {
		assert username != null : "Precondition failed: username != null";
		assert badgeTypes != null : "Precondition failed: badgeTypes != null";
		assert badgeTypes.length > 0 : "Precondition failed: badgeTypes.length > 0";
		assert tryNr > 0 : "Precondition failed: tryNr > 0";

		return badgeDb.getBadgesFor(username, badgeTypes, readOnly);
	}
}
