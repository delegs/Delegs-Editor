package de.signWritingEditor.server.service;

import java.util.Date;

import org.apache.log4j.Logger;

import de.signWritingEditor.client.service.ContentReportService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public class ContentReportServiceImpl implements ContentReportService {

	private static final Logger CONTENT_REPORT_LOGGER = Logger.getLogger("ContentReportServiceImpl");
	private SendEmailService emailService;

	public ContentReportServiceImpl(SendEmailService emailService) {
		this.emailService = emailService;
	}

	@Override
	public void reportUrl(String reportingUserName, String documentOwnerName, Date reportingDate, Id documentId,
			FileTitle documentName, String url) {
		emailService.sendReportContentEmailToDelegs(reportingUserName, documentOwnerName, reportingDate, documentId,
				documentName, url);
		CONTENT_REPORT_LOGGER.info("User " + reportingUserName + " reported URL: " + url);
	}
}
