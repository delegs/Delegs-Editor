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
import de.signWritingEditor.shared.model.material.User;

public class EmailAuthentificationServlet extends SignWritingServlet {

	private static final long serialVersionUID = -6893687105261135457L;

	private static final String PARAMETER_VALIDATIONKEY = "validationkey";
	private static final String PARAMETER_USERNAME = "username";
	private static Logger LOG = Logger.getLogger(DictionaryServlet.class);
	private UserDb userDb;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";
		try {
			if (hasParameters(request, PARAMETER_VALIDATIONKEY, PARAMETER_USERNAME)) {
				userDb = new UserDb(new DbConnector(new ConfigurationService()));

				String userName = request.getParameter(PARAMETER_USERNAME);
				if (!userDb.existsUsername(userName)) {
					respondToBadRequest(response, "Invalid activation key!");
				} else {
					User user = userDb.getUser(userName);
					if (!user.hasEmailAddress()) {
						respondToBadRequest(response, "Invalid activation key!");
					} else {
						String validationKeyForUser = MailValidationKeyUtil.getValidationKeyForUser(user);
						if (validationKeyForUser.equalsIgnoreCase(request.getParameter(PARAMETER_VALIDATIONKEY))) {
							userDb.activateUser(user);
							sendResponse(response, createResponsePage());
						} else {
							respondToBadRequest(response, "Invalid activation key!");
						}
					}
				}
			} else {
				respondToBadRequest(response, "Missing parameters.");
			}
		} catch (Exception e) {
			respondToInternalServerError(response);
			LOG.error(e);
		}

	}

	private String createResponsePage() {
		return I18N.getAccountValidationSuccessful();
	}

	@Override
	protected Logger getLog() {
		return LOG;
	}

}
