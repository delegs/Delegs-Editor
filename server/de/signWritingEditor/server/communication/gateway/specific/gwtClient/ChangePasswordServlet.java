package de.signWritingEditor.server.communication.gateway.specific.gwtClient;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.gateway.specific.iPadPhone.DictionaryServlet;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.MailValidationKeyUtil;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.SendEmailService;
import de.signWritingEditor.server.service.UserServiceImpl;
import de.signWritingEditor.shared.model.material.User;

public class ChangePasswordServlet extends SignWritingServlet {

	private static final long serialVersionUID = 1L;

	private static final String PARAMETER_VALIDATIONKEY = "validationkey";
	private static final String PARAMETER_USERNAME = "username";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_REPEATED_PASSWORD = "password_repeat";

	private static final Logger LOG = Logger.getLogger(DictionaryServlet.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		assert response != null : "Precondition failed: response != null";
		assert request != null : "Precondition failed: request != null";

		String responseString;
		ConfigurationService configurationService = new ConfigurationService();
		UserDb userDb = new UserDb(new DbConnector(configurationService));
		UserServiceImpl userService = new UserServiceImpl(userDb, new SendEmailService(configurationService));

		if (hasParameters(request, PARAMETER_PASSWORD, PARAMETER_REPEATED_PASSWORD, PARAMETER_USERNAME,
				PARAMETER_VALIDATIONKEY)) {

			String username = request.getParameter(PARAMETER_USERNAME);
			String password = request.getParameter(PARAMETER_PASSWORD);

			if (password.equals(request.getParameter(PARAMETER_REPEATED_PASSWORD))) {
				if (User.isValidPassword(password)) {

					if (userService.existsUsername(username)) {

						String validationKeyForUser = MailValidationKeyUtil
								.getValidationKeyForUser(userService.getUserByUsernameOrMail(username));
						if (request.getParameter(PARAMETER_VALIDATIONKEY).equals(validationKeyForUser)) {
							if (userService.changePassword(username, password)) {
								responseString = I18N.getPasswordChanged();
							} else {
								// PW ändern hat nicht geklappt
								responseString = I18N.getTechnicalError();
							}
						} else {
							// Validation Key stimmt nicht überein
							responseString = I18N.getTechnicalError();
						}
					} else {
						// User nicht in DB
						responseString = I18N.getTechnicalError();
					}
				} else {
					// PW nicht valide
					responseString = I18N.getRegistrationInvalidPassword();
				}
			} else {
				// Passwörter sind nicht identisch
				responseString = I18N.getRegistrationPasswordMismatch();
			}
		} else {
			// Nicht alle Parameter da
			responseString = I18N.getTechnicalError();
		}

		response.setContentType("text/html");

		String appURL = configurationService.getProperty(ConfigurationService.PROPERTY_APP_URL);
		responseString += "</br></br><a href='" + appURL + "'>delegs-Editor</a>";
		sendResponse(response, responseString);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		ConfigurationService configurationService = new ConfigurationService();
		String appURL = configurationService.getProperty(ConfigurationService.PROPERTY_APP_URL);

		String htmlPage = "<form method='post' id='changePassword' action='" + appURL
				+ "/signwritingeditor/changePassword'><table><tr><td>" + "<label>" + I18N.getNewPassword()
				+ ":</label></td><td><input name='password' type='password'></td></tr>" + "<tr><td><label>"
				+ I18N.getRepeatNewPassword()
				+ ":</label></td><td><input name='password_repeat' type='password'></td></tr>"
				+ "<tr><td></td><td><input type='submit' name='change_passwort' value='" + I18N.getChangePassword()
				+ "'>" + "</td></tr></table>" + "<input name='username' value='"
				+ request.getParameter(PARAMETER_USERNAME) + "' type='hidden'>" + "<input name='validationkey' value='"
				+ request.getParameter(PARAMETER_VALIDATIONKEY) + "' type='hidden'>" + "</form>";

		response.setContentType("text/html");
		sendResponse(response, htmlPage);
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}

}
