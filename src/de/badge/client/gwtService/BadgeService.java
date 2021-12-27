package de.badge.client.gwtService;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;

public interface BadgeService {

	public void addBadgesUpdatedListener(BadgesUpdatedListener listener);

	public void getActiveUsersBadges(BadgeType[] badgeTypes, AsyncCallback<List<Badge>> asyncCallback);

	public void getCSVBadgeReportsSince(Date date, AsyncCallback<String> asyncCallback);

	public interface BadgesUpdatedListener {
		public void badgesUpdated(List<Badge> badgesThatReachedANewLevel, List<Badge> badgesThatUpdated);
	}

}
