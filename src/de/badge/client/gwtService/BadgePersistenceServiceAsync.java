package de.badge.client.gwtService;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;

public interface BadgePersistenceServiceAsync {

	public void getBadgesForUser(String username, BadgeType[] badgeTypes, boolean readOnly,
			AsyncCallback<JsonBadgesWithUsername> asyncCallback);

	public void updateBadgesForUser(String username, JsonBadgesWithUsername badges, AsyncCallback<Void> asyncCallback);

	public void getBadgeReportsSince(String username, Date date, AsyncCallback<List<BadgeReport>> asyncCallback);

}
