package de.signWritingEditor.server.service;

import de.signWritingEditor.client.service.DocumentService;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.SessionKey;

public interface SystemDocumentService extends DocumentService {
	boolean existsDocumentTitle(SessionKey sessionKey, FileTitle documentTitle, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException;

	boolean existsFolderTitle(SessionKey sessionKey, FileTitle folderName, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException;
}
