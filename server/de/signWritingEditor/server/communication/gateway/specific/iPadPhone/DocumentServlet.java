package de.signWritingEditor.server.communication.gateway.specific.iPadPhone;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import de.signWritingEditor.client.service.AuthenticationService;
import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.AuthenticationServiceImpl;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.SendEmailService;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class DocumentServlet extends SignWritingServlet {
	private static final String PARAMETER_NAME_ACTION = "action";
	private static final String PARAMETER_NAME_USERNAME = "username";
	private static final String PARAMETER_NAME_PASSWORD = "password";
	private static final String PARAMETER_NAME_FOLDER_ID = "folderid";
	private static final String PARAMETER_NAME_DOCUMENT_ID = "documentid";

	private static final String ACTION_GET_DOCUMENTS_ITEMS_IN_FOLDER = "getdocumentsinfolder";
	private static final String ACTION_GET_DOCUMENT = "getdocument";

	private static final String ID_SEPERATOR = "-";
	private static final Pattern ID_PATTERN = Pattern.compile("\\d+\\" + ID_SEPERATOR + "\\d+");

	private static final String ELEMENT_NAME_DOCUMENT = "document";
	private static final String ELEMENT_NAME_DOCUMENTS = "documents";

	private static final long serialVersionUID = 8282045622939593774L;

	private static final Logger LOG = Logger.getLogger(DocumentServlet.class);

	private DocumentDb documentDb;
	private AuthenticationService authenticationService;
	private IdFactory idFactory;
	private DbConnector dbConnector;

	@Override
	protected Logger getLog() {
		return LOG;
	}

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			dbConnector = new DbConnector(configurationService);
			documentDb = new DocumentDb(dbConnector);
			SendEmailService emailService = new SendEmailService(configurationService);
			authenticationService = new AuthenticationServiceImpl(new UserDb(dbConnector),
					new SessionServiceImpl(configurationService), emailService);
			idFactory = new IdFactory(System.currentTimeMillis());
		} catch (Exception e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidParameters(request)) {
			String username = request.getParameter(PARAMETER_NAME_USERNAME);
			String password = request.getParameter(PARAMETER_NAME_PASSWORD);

			UserSession userSession = authenticationService.login(username, password);

			if (!userSession.getUser().isUnknown()) {
				User user = userSession.getUser();

				String action = request.getParameter(PARAMETER_NAME_ACTION);

				if (action.equals(ACTION_GET_DOCUMENTS_ITEMS_IN_FOLDER)) {
					Id folderId = deserializeId(request.getParameter(PARAMETER_NAME_FOLDER_ID));
					handleGetDocumentsItemsInFolder(response, folderId, user);
				}

				if (action.equals(ACTION_GET_DOCUMENT)) {
					Id documentId = deserializeId(request.getParameter(PARAMETER_NAME_DOCUMENT_ID));
					handleGetDocument(response, documentId, user);
				}
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} else {
			respondToBadRequest(response);
		}
	}

	private void handleGetDocumentsItemsInFolder(HttpServletResponse response, Id folderId, User user)
			throws IOException {
		assert response != null : "Precondition failed: response != null";
		assert folderId != null : "Precondition failed: folderId != null";
		assert user != null : "Precondition failed: user != null";

		if (documentDb.existsFolder(folderId)) {
			if (isAllowedToReadFileItem(user, documentDb.getFolderItem(folderId))) {
				sendResponse(response, serializeDocumentItems(documentDb.getDocumentItemsInFolder(folderId)));
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void handleGetDocument(HttpServletResponse response, Id documentId, User user) throws IOException {
		assert response != null : "Precondition failed: response != null";
		assert documentId != null : "Precondition failed: documentId != null";

		if (documentDb.existsDocument(documentId)) {
			if (isAllowedToReadFileItem(user, documentDb.getDocumentItem(documentId))) {
				sendResponse(response, documentDb.getDocumentContent(documentId));
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private boolean isAllowedToReadFileItem(User user, FileItem fileItem) {
		assert user != null : "Precondition failed: user != null";
		assert fileItem != null : "Precondition failed: fileItem != null";

		return documentDb.getRoomForFileItem(fileItem).isRoomAccessPermitted(user.getUsername());
	}

	private boolean hasValidParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		String action = request.getParameter(PARAMETER_NAME_ACTION);
		String username = request.getParameter(PARAMETER_NAME_USERNAME);
		String password = request.getParameter(PARAMETER_NAME_PASSWORD);
		String documentId = request.getParameter(PARAMETER_NAME_DOCUMENT_ID);
		String folderId = request.getParameter(PARAMETER_NAME_FOLDER_ID);

		boolean result = action != null && username != null && password != null && !action.isEmpty()
				&& !username.isEmpty() && !password.isEmpty();

		if (result) {
			if (action.equals(ACTION_GET_DOCUMENT)) {
				result = documentId != null && isValidIdString(documentId);
			} else if (action.equals(ACTION_GET_DOCUMENTS_ITEMS_IN_FOLDER)) {
				result = folderId != null && isValidIdString(folderId);
			} else {
				result = false;
			}
		}

		return result;
	}

	private boolean isValidIdString(String idString) {
		assert idString != null : "Precondition failed: idString != null";

		return ID_PATTERN.matcher(idString).matches();
	}

	private Id deserializeId(String idString) {
		assert idString != null : "Precondition failed: idString != null";
		assert isValidIdString(idString) : "Precondition failed: isValidIdString(idString)";

		String[] idParts = idString.split(ID_SEPERATOR);

		long upperIdPart = Long.parseLong(idParts[0]);
		long lowerIdPart = Long.parseLong(idParts[1]);

		Id result = idFactory.reconstructId(upperIdPart, lowerIdPart);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private String serializeId(Id id) {
		assert id != null : "Precondition failed: id != null";

		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append(id.getUpperIdPart());
		resultBuilder.append(ID_SEPERATOR);
		resultBuilder.append(id.getLowerIdPart());

		String result = resultBuilder.toString();

		assert result != null : "Postcondition failed: result != null";
		assert isValidIdString(result) : "Postcondition failed: isValidIdString(result)";
		return result;
	}

	private String serializeDocumentItems(List<DocumentItem> documentItems) {
		assert documentItems != null : "Precondition failed: documentItems != null";

		Element documentItemsElement = new Element(ELEMENT_NAME_DOCUMENTS);

		for (DocumentItem documentItem : documentItems) {
			Element documentElement = new Element(ELEMENT_NAME_DOCUMENT);
			documentElement.setAttribute("title", documentItem.getFileTitle().getTitleString());
			documentElement.setAttribute("id", serializeId(documentItem.getId()));
			documentItemsElement.addContent(documentElement);
		}

		String result = new XMLOutputter().outputString(new Document(documentItemsElement));

		assert result != null : "Postcondition failed: result != null";
		return result;
	}
}
