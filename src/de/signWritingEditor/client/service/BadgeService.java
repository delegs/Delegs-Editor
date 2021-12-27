package de.signWritingEditor.client.service;

import java.util.Date;
import java.util.List;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.badge.shared.service.DataCouldNotBeStoredException;
import de.signWritingEditor.shared.model.material.User;

public interface BadgeService {

	public JsonBadgesWithUsername getBadgesForUser(User user, String username, BadgeType[] badgeTypes,
			boolean readOnly);

	public void updateBadgesForUser(User user, JsonBadgesWithUsername badges) throws DataCouldNotBeStoredException;

	public List<BadgeReport> getBadgeReportsSince(User user, Date date);

}
