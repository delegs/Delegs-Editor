package de.signWritingEditor.client.badge.gwtClient.service;

import de.badge.client.gwtService.BadgeService;

public interface BadgeServiceClient extends BadgeService {
	public void userLoggedIn();

	public void userLoggedOut();

	public void userCreatedGlobalSign();

	public void userUpdatedGlobalSign();

	public void userDeletedGlobalSign();

	public void userCreatedLocalSign();

	public void userUpdatedLocalSign();

	public void userOpenedOwnDocument();

	public void userCreatedDocument();

	public void userUpdatedDocument();

	public void userOpenedSignEditor();
}
