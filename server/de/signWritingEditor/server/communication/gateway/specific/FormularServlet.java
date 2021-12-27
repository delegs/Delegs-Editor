package de.signWritingEditor.server.communication.gateway.specific;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.communication.infrastructure.JsonBuilder;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;

public class FormularServlet extends SignWritingServlet {

	private static final long serialVersionUID = 1762143590950020950L;
	private static final Logger LOG = Logger.getLogger(FormularServlet.class);
	private static final String PARAMETER_DEEPLINK = "deepLink";
	private static final String SIGN_IMG_BASE_URL = "esf.app.type";
	private static final String SIGN_IMG_API_URL = "esf.image.api";

	private String signImgBaseUrl;
	private String signImgApiUrl;

	private DocumentDb documentDb;
	private DbConnector dbConnector;
	private UserDb userDb;
	private SignDB signDb;
	private DocumentXMLConverter xmlConverter;
	private FileTitle roomTitle;
	private FileTitle folderTitle;
	private Date date;

	@Override
	protected Logger getLog() {
		return LOG;
	}

	@Override
	public void init() throws ServletException {
		try {
			ConfigurationService confService = new ConfigurationService();
			signImgBaseUrl = confService.getProperty(SIGN_IMG_BASE_URL);
			signImgApiUrl = confService.getProperty(SIGN_IMG_API_URL);
			dbConnector = new DbConnector(confService);
			documentDb = new DocumentDb(dbConnector);
			userDb = new UserDb(dbConnector);
			SymbolDB symbolDb = new SymbolDB(dbConnector);
			SymbolFactory symbolFactory = new SymbolFactory(symbolDb.getAllSymbols());
			signDb = new SignDB(dbConnector, userDb, symbolFactory, confService);
			PositionedSymbolFactory positionedSymbolFactory = new PositionedSymbolFactory();
			xmlConverter = new DocumentXMLConverter(userDb, signDb, symbolFactory, new TextbasedTokenStyleFactory(),
					positionedSymbolFactory, System.nanoTime());
		} catch (Exception e) {
			LOG.error("Error while creating configuration service: " + e.getMessage(), e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert request != null : "Precondition failed: request != null";
		assert response != null : "Precondition failed: response != null";

		if (hasValidParameters(request)) {
			handleGetDocumentsAfterDate(response);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	private void handleGetDocumentsAfterDate(HttpServletResponse response) {

		Id folderId = documentDb
				.getFolderItemWithTitleInParentFolder(folderTitle,
						documentDb.getFolderItemWithTitleInParentFolder(roomTitle, RoomItem.ROOT_FOLDER_ID).getId())
				.getId();
		Map<String, String> documentIdsWithContent = documentDb.getDocumentIdsWithContent(folderId);

		if (documentIdsWithContent.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			List<Map<String, Object>> documentPropertyMapList = new ArrayList<>();
			for (String documentKey : documentIdsWithContent.keySet()) {

				String documentContent = documentIdsWithContent.get(documentKey);
				Map<String, Object> documentPropertyMap = getDocumentPropetyMap(documentContent);
				documentPropertyMap.put("Id:", documentKey);
				documentPropertyMapList.add(documentPropertyMap);
			}

			JsonBuilder jsonBuilder = new JsonBuilder();
			String jsonResponse = jsonBuilder.getListAsJson(documentPropertyMapList);

			response.setStatus(HttpServletResponse.SC_OK);
			response.setHeader("Content-Type", "application/json");
			sendResponse(response, jsonResponse);
		}
	}

	private Map<String, Object> getDocumentPropetyMap(String xml) {

		Map<String, Object> metaData = new HashMap<>();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			StringReader stringReader = new StringReader(xml);
			InputSource inputSource = new InputSource(stringReader);
			Document document = builder.parse(inputSource);
			NodeList tokenRoot = document.getElementsByTagName("paragraph");
			NodeList childNodes = tokenRoot.item(0).getChildNodes();

			for (int i = 0; i < childNodes.getLength(); i++) {

				Element element = (Element) childNodes.item(i);
				String tokenType = element.getAttribute("tokenType");

				switch (tokenType) {
				case "formToken":
				case "urlFormToken":
				case "dateFormToken":
					String key = element.getAttribute("formTokenDescription");
					String value = element.getAttribute("formTokenInput");
					if (!metaData.containsKey(key) && !key.isEmpty())
						metaData.put(key, value);
					break;

				case "videoToken":
					key = "VideoUrl:";
					value = element.getAttribute("videoTokenUrl");
					if (!metaData.containsKey(key) && !key.isEmpty())
						metaData.put(key, value);
					break;

				case "tagToken":
					key = element.getAttribute("tagTokenDescription");
					value = element.getAttribute("tagTokenSelectedTags");
					if (!metaData.containsKey(key) && !key.isEmpty())
						metaData.put(key, value);
					break;

				case "signItemToken":
					Node signItemNode = element.getFirstChild();
					if (signItemNode != null) {

						Element signItemElement = (Element) signItemNode;
						String signItemUpperIdValue = signItemElement.getAttribute("upperId");
						String signItemLowerIdValue = signItemElement.getAttribute("lowerId");
						String signLocaleValue = signItemElement.getAttribute("region");
						String signSourceValue = signItemElement.getAttribute("source");
						SignLocale signLocale = SignLocale.valueOf(signLocaleValue);
						SignSource signSource = SignSource.valueOf(signSourceValue);
						Long signItemUpperId = Long.parseLong(signItemUpperIdValue);
						SignId signId = new SignId(signItemUpperId, signItemLowerIdValue, signLocale, signSource);
						List<String> symbolIds = signDb.getAllSymbolIdsForSignItem(signId);

						String signImageUrl = signImgBaseUrl + "/" + signImgApiUrl + "upperId=" + signItemUpperId
								+ "&lowerId=" + signItemLowerIdValue + "&signlocale=" + signLocale
								+ "&transparent=true";

						Map<String, Object> signWritingData = new HashMap<>();
						signWritingData.put("Url:", signImageUrl);
						signWritingData.put("SymbolIds:", symbolIds);
						metaData.put("Gebaerdenschrift:", signWritingData);
					}

					break;
				}
			}

		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}

		return metaData;
	}

	private boolean hasValidParameters(HttpServletRequest request) {
		assert request != null : "Precondition failed: request != null";

		String deepLink = request.getParameter(PARAMETER_DEEPLINK);

		if (deepLink != null)
			setFolderAndRoomTitle(deepLink, request);

		return areFolderAndRoomValid();
	}

	private void setFolderAndRoomTitle(String deepLink, HttpServletRequest request) {
		String moduleBaseURL = request.getRequestURL().substring(0,
				request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();

		if (deepLink.startsWith(moduleBaseURL)) {

			// +2 because of the "/#"
			String cleanLink = deepLink.substring(moduleBaseURL.length() + 2);
			String[] path = cleanLink.split("/");
			String roomName = path[0];
			String folderName = path[1];

			roomTitle = new FileTitle(roomName);
			folderTitle = new FileTitle(folderName);
		}
	}

	private boolean areFolderAndRoomValid() {

		boolean roomExists = documentDb.existsRoomWithTitle(roomTitle);
		Id roomId = documentDb.getFolderItemWithTitleInParentFolder(roomTitle, RoomItem.ROOT_FOLDER_ID).getId();
		boolean folderExistsInRoom = documentDb.existsFolderWithTitleInParentFolder(folderTitle, roomId);
		return roomExists && folderExistsInRoom;
	}
}
