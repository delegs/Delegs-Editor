package de.signWritingEditor.client.service;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public interface ContentReportServiceAsync {
	public void reportUrl(String reportingUserName, String documentOwnerName, Date reportingDate, Id documentId,
			FileTitle documentName, String url, AsyncCallback<Void> callback);
}
