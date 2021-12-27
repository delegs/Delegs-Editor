package de.signWritingEditor.client.service;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public interface ContentReportService {
	public void reportUrl(String reportingUserName, String documentOwnerName, Date reportingDate, Id documentId,
			FileTitle documentName, String url);
}
