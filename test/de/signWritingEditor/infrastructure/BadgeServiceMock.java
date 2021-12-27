package de.signWritingEditor.infrastructure;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.Badge;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;

public class BadgeServiceMock implements BadgeServiceClient {

	@Override
	public void userLoggedOut() {
	}

	@Override
	public void userCreatedGlobalSign() {
	}

	@Override
	public void userUpdatedGlobalSign() {
	}

	@Override
	public void userDeletedGlobalSign() {
	}

	@Override
	public void userCreatedLocalSign() {
	}

	@Override
	public void userUpdatedLocalSign() {
	}

	@Override
	public void userCreatedDocument() {
	}

	@Override
	public void userUpdatedDocument() {
	}

	@Override
	public void userOpenedOwnDocument() {

	}

	@Override
	public void userOpenedSignEditor() {

	}

	@Override
	public void getActiveUsersBadges(BadgeType[] badgeTypes, AsyncCallback<List<Badge>> asyncCallback) {
	}

	@Override
	public void getCSVBadgeReportsSince(Date date, AsyncCallback<String> asyncCallback) {
	}

	@Override
	public void addBadgesUpdatedListener(BadgesUpdatedListener listener) {
	}

	@Override
	public void userLoggedIn() {

	}

}
