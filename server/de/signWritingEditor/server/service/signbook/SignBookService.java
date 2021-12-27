package de.signWritingEditor.server.service.signbook;

import java.util.Map;

public interface SignBookService {

	public abstract Map<String, String> getLocalizedAppDescriptions();

	public abstract int getDatabaseRevision();
}
