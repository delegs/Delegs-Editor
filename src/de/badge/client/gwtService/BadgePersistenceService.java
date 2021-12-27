package de.badge.client.gwtService;

import java.util.Date;
import java.util.List;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.badge.shared.service.DataCouldNotBeStoredException;

public interface BadgePersistenceService {

	public JsonBadgesWithUsername getBadgesForUser(String username, BadgeType[] badgeTypes, boolean readOnly);

	public void updateBadgesForUser(JsonBadgesWithUsername badges) throws DataCouldNotBeStoredException;

	public List<BadgeReport> getBadgeReportsSince(Date date);
}
