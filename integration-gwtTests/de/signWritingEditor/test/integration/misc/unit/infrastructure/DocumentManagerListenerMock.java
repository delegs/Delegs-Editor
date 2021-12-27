package de.signWritingEditor.test.integration.misc.unit.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManager.DocumentManagerListener;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;

public class DocumentManagerListenerMock implements DocumentManagerListener {

	@Override
	public void onOpenDocument(DocumentItem documentItem, FolderItem folderItem, RoomItem roomItem) {
	}

	@Override
	public void onOpenNewDocument() {
	}

	@Override
	public void onInvalidSessionExceptionCaught() {
	}

	@Override
	public void onMissingAuthorizationExceptionCaught() {
	}

	@Override
	public void onAddUserToRoom(RoomItem room, String userName) {
	}

	@Override
	public void onDeleteUserFromRoom(RoomItem room, String userName) {
	}

	@Override
	public void onPolicyChanged(RoomItem room, RoomPolicy selectedPolicy) {
	}

	@Override
	public void onDeleteAdminFromRoom(RoomItem room, String name) {
	}

	@Override
	public void onAddAdminToRoom(RoomItem room, String name) {
	}

	@Override
	public void onOpenFolder(FolderItem folder) {
	}
}