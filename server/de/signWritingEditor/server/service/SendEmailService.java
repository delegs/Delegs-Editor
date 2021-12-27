package de.signWritingEditor.server.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.sun.mail.smtp.SMTPTransport;

import de.signWritingEditor.server.persistence.MailValidationKeyUtil;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.User;

public class SendEmailService {

	private final String appUrl;
	private final String smtpServerHostName;
	private final int smtpServerPort;
	private final String smtpUsername;
	private final String smtpPassword;
	private final String infoMail;
	private final String teamMail;

	private static final Logger LOG = Logger.getLogger(SendEmailService.class);
	private static final String TEXT_PLAIN_CHARSET_UTF_8 = "text/plain; charset=utf-8";

	public SendEmailService(ConfigurationService configurationService) {
		this.smtpServerHostName = configurationService.getProperty(ConfigurationService.PROPERTY_SMTP_SERVER_HOST_NAME);
		this.smtpServerPort = Integer
				.parseInt(configurationService.getProperty(ConfigurationService.PROPERTY_SMTP_SERVER_PORT));
		this.smtpUsername = configurationService.getProperty(ConfigurationService.PROPERTY_SMTP_SERVER_USER_NAME);
		this.smtpPassword = configurationService.getProperty(ConfigurationService.PROPERTY_SMTP_SERVER_PASSWORD);
		this.appUrl = configurationService.getProperty(ConfigurationService.PROPERTY_APP_URL);

		this.infoMail = configurationService.getProperty(ConfigurationService.PROPERTY_EMAIL_INFO);
		this.teamMail = configurationService.getProperty(ConfigurationService.PROPERTY_EMAIL_TEAM);

		assert this.smtpServerHostName != null : "Postcondition failed: smtpServerHostName != null";
		assert this.smtpUsername != null : "Postcondition failed: smtpUsername != null";
		assert this.smtpPassword != null : "Postcondition failed: smtpPassword != null";
		assert this.appUrl != null : "Postcondition failed: appUrl != null";
		assert this.infoMail != null : "Postcondition failed: infoMail != nulll";
		assert this.teamMail != null : "Postcondition failed: teamMail != null";
	}

	private Session getSession() {
		Properties properties = System.getProperties();
		properties.setProperty("mail.transport.protocol", "smtps");
		properties.setProperty("mail.host", smtpServerHostName);
		properties.setProperty("mail.smtps.auth", "true");
		properties.setProperty("mail.smtps.port", "" + smtpServerPort);
		properties.setProperty("mail.smtps.ssl.trust", smtpServerHostName);
		properties.setProperty("mail.smtps.ssl.enable", "true");
		properties.setProperty("mail.smtps.ssl.protocols", "TLSv1.2");

		return System.getSecurityManager() == null ? Session.getInstance(properties)
				: Session.getDefaultInstance(properties);
	}

	private MimeMessage getMessage(String to, String subject, String content, Session session)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(infoMail, "delegs-Editor"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject);
		message.setContent(content, TEXT_PLAIN_CHARSET_UTF_8);
		message.saveChanges();
		return message;
	}

	private void sendMail(String to, String subject, String content) {
		assert to != null : "Precondition failed: to != null";
		assert subject != null : "Precondition failed: subject != null";
		assert content != null : "Precondition failed: content != null";

		try {
			Session session = getSession();
			MimeMessage message = getMessage(to, subject, content, session);

			SMTPTransport transport = (SMTPTransport) session.getTransport("smtps");
			transport.connect(smtpServerHostName, smtpUsername, smtpPassword);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException | UnsupportedEncodingException e) {
			LOG.error("Fehler beim Versenden einer E-Mail:\n", e);
		}
	}

	public void sendRegistrationEmailToUser(User user) {
		assert user != null : "Precondition failed: user != null";
		assert user.hasEmailAddress() : "Precondition failed: user.hasEmailAddress()";

		String to = user.getEmailAddress().asString();
		String subject = I18N.getValidationEmailSubjectForUser();
		String content = I18N.getValidationEmailTextForUser(user.getUsername(),
				appUrl + "/signwritingeditor/emailAuthentification?validationkey=" + createValidationKey(user)
						+ "&username=" + user.getUsername());
		sendMail(to, subject, content);
	}

	public void sendPasswordForgottenEmail(User user) {
		assert user != null : "Precondition failed: user != null";
		assert user.hasEmailAddress() : "Precondition failed: user.hasEmailAddress()";

		final String to = user.getEmailAddress().asString();
		final String subject = I18N.getPasswordForgottenSubjectForUser();
		final String content = I18N.getPasswordForgottenEmailTextForUser(user.getUsername(),
				appUrl + "/signwritingeditor/changePassword?validationkey=" + createValidationKey(user) + "&username="
						+ user.getUsername());
		sendMail(to, subject, content);
	}

	public void sendReportContentEmailToDelegs(String reportingUserName, String documentOwnerName, Date reportingDate,
			Id documentId, FileTitle documentName, String url) {

		assert reportingUserName != null : "Precondition failed: reportingUserName != null";
		assert reportingDate != null : "Precondition failed: reportingDate != null";

		String subject = "Reported content";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
		String content = "Reporting user: " + reportingUserName + "\n" + "Reporting date: "
				+ dateFormat.format(reportingDate) + "\n" + "\n" + "Document owner: " + documentOwnerName + "\n"
				+ "Document ID: " + documentId + "\n" + "Filetitle: " + documentName.getTitleString() + "\n"
				+ "Content url: " + url + "\n";
		sendMail(teamMail, subject, content);
	}

	private String createValidationKey(User user) {
		assert user != null : "Precondition failed: user != null";
		assert user.hasEmailAddress() : "Precondition failed: user.hasEmailAddress()";

		return MailValidationKeyUtil.getValidationKeyForUser(user);
	}
}
