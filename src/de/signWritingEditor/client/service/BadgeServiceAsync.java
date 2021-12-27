package de.signWritingEditor.client.service;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.signWritingEditor.shared.model.material.User;

public interface BadgeServiceAsync {

	public void getBadgesForUser(User user, String username, BadgeType[] badgeTypes, boolean readOnly,
			AsyncCallback<JsonBadgesWithUsername> callback);

	public void updateBadgesForUser(User user, JsonBadgesWithUsername badges, AsyncCallback<Void> callback);

	public void getBadgeReportsSince(User user, Date date, AsyncCallback<List<BadgeReport>> callback);

}
