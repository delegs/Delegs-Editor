package de.signWritingEditor.server.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.badge.client.gwtService.BadgePersistenceService;
import de.badge.shared.model.domainValue.BadgeType;
import de.badge.shared.model.material.BadgeReport;
import de.badge.shared.model.material.JsonBadgesWithUsername;
import de.badge.shared.service.DataCouldNotBeStoredException;
import de.signWritingEditor.client.service.AuthenticationService;
import de.signWritingEditor.client.service.ContentReportService;
import de.signWritingEditor.client.service.DictionaryService;
import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.InvalidUsernameException;
import de.signWritingEditor.client.service.LoggingService;
import de.signWritingEditor.client.service.MediaUrlService;
import de.signWritingEditor.client.service.NotificationService;
import de.signWritingEditor.client.service.PdfService;
import de.signWritingEditor.client.service.QueryResult;
import de.signWritingEditor.client.service.RoomnameCollisionException;
import de.signWritingEditor.client.service.SignWritingService;
import de.signWritingEditor.client.service.SymbolService;
import de.signWritingEditor.client.service.UserService;
import de.signWritingEditor.client.service.VideoService;
import de.signWritingEditor.server.badge.service.BadgePersistenceServiceImpl;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.DocumentDb;
import de.signWritingEditor.server.persistence.DocumentXMLConverter;
import de.signWritingEditor.server.persistence.NotificationDb;
import de.signWritingEditor.server.persistence.SignDB;
import de.signWritingEditor.server.persistence.SignHistoryDB;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.pdfService.PdfServiceImpl;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.server.service.sessionService.SystemSessionService;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.DirectoryNotFoundException;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.exceptions.RecursiveDirectoryException;
import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.infrastructure.InitBundle;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.FolderContentAndPath;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.FontMetric;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.Notification;
import de.signWritingEditor.shared.model.material.PdfFileItem;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.RevisionedWordToSignsDictionaryEntries;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;
import nl.captcha.Captcha;

public class SignWritingServiceImpl extends RemoteServiceServlet implements SignWritingService {
	private static final long serialVersionUID = 6880158317813247334L;

	private static final String PROPERTY_BACKGROUNDIMAGE = "esf.backgroundimage";
	private static final String PROPERTY_VERSION = "esf.app.version";
	private static final String PROPERTY_PRIVACY_POLICY_VERSION = "esf.privacypolicy.version";

	private final ConfigurationService configurationService;
	private final AuthenticationService authenticationService;
	private final DictionaryService dictionaryService;
	private final DocumentDb documentDb;
	private final SystemDocumentService documentService;
	private final PdfService pdfService;
	private final VideoService videoService;
	private final MediaUrlService mediaUrlService;
	private final SymbolService symbolService;
	private final UserService userService;
	private final FontMetricGenerationService fontMetricGenerationService;
	private final LoggingService loggingService;
	private final BadgePersistenceService badgePersistenceService;
	private final ContentReportService contentReportService;
	private final NotificationService notificationService;
	private final UserDb userDb;

	private long lastIdSeed;

	private SystemSessionService sessionService;

	private DbConnector dbConnector;

	private FontSizeService fontSizeService;

	public SignWritingServiceImpl() throws Exception {
		this(new ConfigurationService());
	}

	public SignWritingServiceImpl(ConfigurationService configurationService) throws Exception {
		assert configurationService != null : "Precondition failed: configurationService != null";
		this.configurationService = configurationService;
		SendEmailService emailService = new SendEmailService(configurationService);
		PositionedSymbolFactory positionedSymbolFactory = new PositionedSymbolFactory();
		fontMetricGenerationService = new FontMetricGenerationServiceImpl(configurationService);
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setFontMetrics(fontMetricGenerationService.getFontMetrics());

		dbConnector = new DbConnector(configurationService);
		sessionService = new SessionServiceImpl(configurationService);

		userDb = new UserDb(dbConnector);
		SymbolDB symbolDb = new SymbolDB(dbConnector);
		SymbolFactory symbolFactory = new SymbolFactory(symbolDb.getAllSymbols());
		SignDB signDb = new SignDB(dbConnector, userDb, symbolFactory, configurationService);
		SignHistoryDB signHistoryDb = new SignHistoryDB(dbConnector, userDb, configurationService, symbolFactory);
		documentDb = new DocumentDb(dbConnector, configurationService);
		NotificationDb notificationDb = new NotificationDb(dbConnector);

		badgePersistenceService = new BadgePersistenceServiceImpl(dbConnector, sessionService);

		lastIdSeed = System.nanoTime();
		DocumentXMLConverter xmlConverter = new DocumentXMLConverter(userDb, signDb, symbolFactory,
				new TextbasedTokenStyleFactory(), positionedSymbolFactory, lastIdSeed);

		authenticationService = new AuthenticationServiceImpl(userDb, sessionService, emailService);
		documentService = new DocumentServiceImpl(sessionService, documentDb, userDb, xmlConverter);
		dictionaryService = new DictionaryServiceImpl(signDb, signHistoryDb);
		SignImageService signImageService = new SignImageService(configurationService, dictionaryService);
		videoService = new VideoServiceImpl(configurationService);
		mediaUrlService = new MediaUrlServiceImpl(configurationService);
		pdfService = new PdfServiceImpl(configurationService, signImageService, videoService, fontSizeService);
		symbolService = new SymbolServiceImpl(symbolFactory);
		userService = new UserServiceImpl(userDb, emailService);
		loggingService = new LoggingServiceImpl();
		contentReportService = new ContentReportServiceImpl(emailService);
		notificationService = new NotificationServiceImpl(notificationDb);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void saveSign(String word, SimpleSign sign, SessionKey sessionKey) throws Exception {
		assert word != null : "Precondition failed: word != null";
		assert sign != null : "Precondition failed: sign != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);
		if (!sessionService.getUser(sessionKey).getRoles().contains(UserRole.AUTHOR)) {
			throw new MissingAuthorizationException();
		}

		dictionaryService.saveSign(word, sign, sessionKey);
	}

	@Override
	public void deleteSign(SimpleSign sign) {
		assert sign != null : "sign != null";
		assert existsItem(sign.getSignId()) : "existsItem(sign.getSignId())";
		dictionaryService.deleteSign(sign);
	}

	@Override
	public boolean existsItem(SignId signId) {
		assert signId != null : "signId != null";

		return dictionaryService.existsItem(signId);
	}

	@Override
	public List<SignItem> findSigns(String word, SignLocale language) {
		assert word != null : "word != null";

		word = word.toLowerCase();
		List<SignItem> result = dictionaryService.findSigns(word, language);

		return result;
	}

	@Override
	public List<String> findSignWordsWithPrefix(String prefix, Integer count, SignLocale language) {
		assert prefix != null : "prefix != null";

		List<String> result = dictionaryService.findSignWordsWithPrefix(prefix, count, language);

		return result;
	}

	@Override
	public Map<String, List<SignItem>> findSigns(List<String> words, List<SignLocale> locales) {
		assert words != null : "Precondition failed: words != null";
		assert locales != null : "Precondition failed: words != null";
		assert words.size() == locales.size() : "Precondition failed: words.size() == locales.size()";

		Map<String, List<SignItem>> signsMap = dictionaryService.findSigns(words, locales);

		return signsMap;
	}

	@Override
	public void updateSign(SimpleSign sign, SessionKey sessionKey) throws Exception {
		assert sign != null : "sign != null";
		assert existsItem(sign.getSignId()) : "existsItem(sign.getSignId())";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);
		if (!sessionService.getUser(sessionKey).getRoles().contains(UserRole.AUTHOR)) {
			throw new MissingAuthorizationException();
		}

		dictionaryService.updateSign(sign, sessionKey);
	}

	@Override
	public InitBundle getInitBundle() {
		lastIdSeed++;
		String backgroundName = configurationService.getProperty(PROPERTY_BACKGROUNDIMAGE);
		VersionNumber versionNumber = new VersionNumber(configurationService.getProperty(PROPERTY_VERSION));
		int privacyPolicyVersionNumber = Integer
				.parseInt(configurationService.getProperty(PROPERTY_PRIVACY_POLICY_VERSION));
		return new InitBundle(lastIdSeed, getRootRoomItem(), backgroundName, versionNumber, privacyPolicyVersionNumber,
				fontMetricGenerationService.getFontMetrics());
	}

	@Override
	public String exportToPdf(Document document, I18N i18n) throws IOException {
		assert document != null : "Precondition failed: document != null";

		return pdfService.exportToPdf(document, i18n);
	}

	@Override
	public UserSession login(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		return authenticationService.login(username, password);
	}

	@Override
	public void updateAcceptedPrivacyPolicyVersion(User user, int newAcceptedPrivacyPolicyVersion) {
		assert user
				.getAcceptedPrivacyPolicyVersion() < newAcceptedPrivacyPolicyVersion : "Precondition failed: user.getAcceptedPrivacyPolicyVersion() < newAcceptedPrivacyPolicyVersion";

		authenticationService.updateAcceptedPrivacyPolicyVersion(user, newAcceptedPrivacyPolicyVersion);
	}

	@Override
	public void logout(SessionKey sessionKey) {
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		authenticationService.logout(sessionKey);
	}

	@Override
	public SimpleSign getSign(SignId signId) {
		assert signId != null : "Precondition failed: signId != null";
		assert existsItem(signId) : "Precondition failed: existsItem(signId)";

		return dictionaryService.getSign(signId);
	}

	public boolean existsDocumentTitle(SessionKey sessionKey, FileTitle documentTitle, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert documentTitle != null : "Precondition failed: documentTitle != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		User user = sessionService.getUser(sessionKey);
		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(user.getUsername())) {
			throw new AccessDeniedException();
		}
		return documentService.existsDocumentTitle(sessionKey, documentTitle, folderItem);
	}

	@Override
	public FolderContentAndPath getFolderContentAndPath(SessionKey sessionKey, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		return documentService.getFolderContentAndPath(sessionKey, folderItem);
	}

	@Override
	public Document loadDocument(SessionKey sessionKey, DocumentItem documentItem)
			throws InvalidSessionException, AccessDeniedException {
		assert documentItem != null : "Precondition failed: documentItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		User user = sessionService.getUser(sessionKey);
		if (!(documentItem instanceof PdfFileItem)
				&& !getRoomForFileItem(documentItem).isReadFilePermitted(user.getUsername(), documentItem)) {
			throw new AccessDeniedException();
		}

		return documentService.loadDocument(sessionKey, documentItem);
	}

	@Override
	public DocumentItem saveOrUpdateDocument(SessionKey sessionKey, Document document, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert document != null : "Precondition failed: document != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert folderItem != null : "Precondition failed: folderItem != null";

		checkSessionValidity(sessionKey);

		if (isPermissionToSaveDenied(sessionKey, document.getDocumentTitle(), folderItem)) {
			throw new AccessDeniedException();
		}

		return documentService.saveOrUpdateDocument(sessionKey, document, folderItem);
	}

	@Override
	public void deleteFiles(SessionKey sessionKey, FileItem... fileItems)
			throws AccessDeniedException, InvalidSessionException {
		assert fileItems != null : "fileItems != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";

		checkSessionValidity(sessionKey);

		for (FileItem fileItem : fileItems) {
			if (!getParentRoomForFileItem(fileItem)
					.isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(), fileItem)) {
				throw new AccessDeniedException();
			}
		}

		documentService.deleteFiles(sessionKey, fileItems);
	}

	@Override
	public void moveFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem... fileItems)
			throws AccessDeniedException, InvalidSessionException {
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert newFolderItem != null : "Precondition failed: newFolderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(newFolderItem)
				.isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		for (FileItem fileItem : fileItems) {
			if (!getParentRoomForFileItem(fileItem)
					.isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(), fileItem)) {
				throw new AccessDeniedException();
			}
		}

		documentService.moveFiles(sessionKey, newFolderItem, fileItems);
	}

	@Override
	public FileItem[] copyFiles(SessionKey sessionKey, FolderItem newFolderItem, FileItem... fileItems)
			throws AccessDeniedException, InvalidSessionException {
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert newFolderItem != null : "Precondition failed: newFolderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(newFolderItem)
				.isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		for (FileItem fileItem : fileItems) {
			if (!getParentRoomForFileItem(fileItem)
					.isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(), fileItem)) {
				throw new AccessDeniedException();
			}
		}

		return documentService.copyFiles(sessionKey, newFolderItem, fileItems);

	}

	@Override
	public void createNewFolder(SessionKey sessionKey, FileTitle newFolderName, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert newFolderName != null : "Precondition failed: newFolderName != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert !existsFolderTitle(sessionKey, newFolderName,
				folderItem) : "Precondition failed: !existsFolderTitle(newFolderName, folderItem, user)";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		documentService.createNewFolder(sessionKey, newFolderName, folderItem);

		assert existsFolderTitle(sessionKey, newFolderName,
				folderItem) : "Postcondition failed: existsFolderTitle(sessionKey, newFolderName, folderItem)";
	}

	@Override
	public void createNewRoom(SessionKey sessionKey, FileTitle name, List<String> owners, List<String> roomUsers,
			RoomPolicy roomPolicy, boolean isHidden, String roomDescription)
			throws InvalidSessionException, MissingAuthorizationException, AccessDeniedException {
		assert name != null : "Precondition failed: name != null";
		assert owners != null : "Precondition failed: owners != null";
		assert roomUsers != null : "Precondition failed: roomUsers != null";
		assert roomPolicy != null : "Precondition failed: roomPolicy != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert !owners.isEmpty() : "Precondition failed: !owners.isEmpty()";
		assert userService.existsUsers(owners) : "Precondition failed: userService.existsUsers(owners)";
		assert userService.existsUsers(roomUsers) : "Precondition failed: userService.existsUsers(roomUsers)";

		checkSessionValidity(sessionKey);

		if (!isHidden && !sessionService.getUser(sessionKey).isAdmin()) {
			throw new MissingAuthorizationException();
		}

		documentService.createNewRoom(sessionKey, name, owners, roomUsers, roomPolicy, isHidden, roomDescription);

		assert existsFolderTitle(sessionKey, name,
				getRootRoomItem()) : "Postcondition failed: existsFolderTitle(newFolderName, folderItem, user)";
	}

	public boolean existsFolderTitle(SessionKey sessionKey, FileTitle folderName, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert folderName != null : "Precondition failed: folderName != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		return documentService.existsFolderTitle(sessionKey, folderName, folderItem);
	}

	@Override
	public RoomItem getRootRoomItem() {
		return documentService.getRootRoomItem();
	}

	@Override
	public boolean existsFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		return documentService.existsFileItem(fileItem);
	}

	@Override
	public boolean existFileItems(FileItem... fileItems) {
		assert fileItems != null : "Precondition failed: fileItems != null";

		return documentService.existFileItems(fileItems);
	}

	@Override
	public DocumentItem getDocumentItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert existsDocumentTitle(sessionKey, fileTitle,
				folderItem) : "Precondition failed: existsDocumentTitle(sessionKey, fileTitle, folderItem)";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		DocumentItem documentItem = documentService.getDocumentItem(sessionKey, fileTitle, folderItem);

		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())
				|| !getRoomForFileItem(folderItem).isReadFilePermitted(sessionService.getUser(sessionKey).getUsername(),
						documentItem)) {
			throw new AccessDeniedException();
		}

		return documentItem;
	}

	@Override
	public FolderItem getFolderItem(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert existsFolderTitle(sessionKey, fileTitle,
				folderItem) : "Precondition failed: existsFolderTitle(sessionKey, fileTitle, folderItem)";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(folderItem).isRoomAccessPermitted(sessionService.getUser(sessionKey).getUsername())) {
			throw new AccessDeniedException();
		}

		return documentService.getFolderItem(sessionKey, fileTitle, folderItem);
	}

	@Override
	public void renameFile(SessionKey sessionKey, FileItem fileItem, FileTitle newFileTitle)
			throws AccessDeniedException, InvalidSessionException {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert newFileTitle != null : "Precondition failed: newFileTitle != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		checkSessionValidity(sessionKey);

		if (!getRoomForFileItem(fileItem).isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(),
				fileItem)) {
			throw new AccessDeniedException();
		}

		documentService.renameFile(sessionKey, fileItem, newFileTitle);
	}

	@Override
	public RoomItem getRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		RoomItem result = documentService.getRoomForFileItem(fileItem);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public RoomItem getParentRoomForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		RoomItem result = documentService.getParentRoomForFileItem(fileItem);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public Set<FileItem> getNonexistentFileItems(FileItem... fileItems) {
		assert fileItems != null : "Precondition failed: fileItems != null";

		return documentService.getNonexistentFileItems(fileItems);
	}

	@Override
	public RevisionedWordToSignsDictionaryEntries findEntries(SignLocale signLocale) {
		assert signLocale != null : "Precondition failed: signLocale != null";

		return dictionaryService.findEntries(signLocale);
	}

	@Override
	public RevisionedWordToSignsDictionaryEntries getEntriesSinceRevision(long revision, SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";

		return dictionaryService.getEntriesSinceRevision(revision, signLocale);
	}

	@Override
	public RevisionedWordToSignsDictionaryEntries getDeletedEntriesSinceRevision(long revision, SignLocale signLocale) {
		assert revision >= 0 : "Precondition failed: revision >= 0";
		assert signLocale != null : "Precondition failed: signLocale != null";

		return dictionaryService.getDeletedEntriesSinceRevision(revision, signLocale);
	}

	@Override
	public long getModificationDate(SignId signId) {
		return dictionaryService.getModificationDate(signId);
	}

	@Override
	public boolean isAdminUser(String username, SessionKey sessionKey) throws Exception {
		assert username != null : "Precondition failed: username != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		return authenticationService.isAdminUser(username, sessionKey);
	}

	@Override
	public void setColorLabel(FileItemColorLabel newColorLabel, FileItem... fileItems) {
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert existFileItems(fileItems) : "Precondition failed: existFileItems(fileItems)";

		documentService.setColorLabel(newColorLabel, fileItems);
	}

	@Override
	public User registerUser(String username, String firstName, String lastName, String password,
			EmailAddress emailAddress, int privacyPolicyVersionNumber) {
		assert username != null : "Precondition failed: username != null";
		assert firstName != null : "Precondition failed: firstName != null";
		assert lastName != null : "Precondition failed: lastName != null";
		assert password != null : "Precondition failed: password != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber >= 0";
		assert emailAddress != null : "Precondition failed: emailAddress != null";
		assert !username.isEmpty() : "Precondition failed: !username.isEmpty()";
		assert !firstName.isEmpty() : "Precondition failed: !firstName.isEmpty()";
		assert !lastName.isEmpty() : "Precondition failed: !lastName.isEmpty()";
		assert !password.isEmpty() : "Precondition failed: !password.isEmpty()";
		assert !existsUser(username, emailAddress)
				.getResult() : "Precondition failed: !existsUser(username, emailAddress).getResult()";

		User result = authenticationService.registerUser(username, firstName, lastName, password, emailAddress,
				privacyPolicyVersionNumber);

		List<String> userList = Arrays.asList(new String[] { result.getUsername() });

		documentDb.createNewRoomWithRecycleBin(new FileTitle(username), userList, userList,
				RoomPolicy.INDIVIDUAL_CONTENT, true, null);

		assert existsUser(username, emailAddress)
				.getResult() : "Postcondition failed: existsUser(username, emailAddress).getResult()";

		return result;
	}

	@Override
	public QueryResult<UserQueryResultReason> isUserActivated(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		return authenticationService.isUserActivated(username, password);
	}

	@Override
	public QueryResult<UserQueryResultReason> existsUser(String username, EmailAddress emailAddress) {
		assert username != null : "Precondition failed: username != null";

		return authenticationService.existsUser(username, emailAddress);
	}

	@Override
	public boolean validateCaptcha(String userCaptcha) {
		assert userCaptcha != null : "Precondition failed: userCaptcha != null";

		boolean result = false;

		HttpServletRequest servletRequest = getThreadLocalRequest();

		Captcha captcha = (Captcha) servletRequest.getSession().getAttribute(Captcha.NAME);

		if (captcha != null) {
			result = captcha.isCorrect(userCaptcha);
		}

		return result;
	}

	private boolean isPermissionToSaveDenied(SessionKey sessionKey, FileTitle fileTitle, FolderItem folderItem)
			throws AccessDeniedException, InvalidSessionException {
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert fileTitle != null : "Precondition failed: fileTitle != null";

		checkSessionValidity(sessionKey);

		return (existsDocumentTitle(sessionKey, fileTitle, folderItem) && !getRoomForFileItem(folderItem)
				.isModifyFilePermitted(sessionService.getUser(sessionKey).getUsername(),
						getDocumentItem(sessionKey, fileTitle, folderItem)))
				|| (!existsDocumentTitle(sessionKey, fileTitle, folderItem)
						&& !getRoomForFileItem(folderItem).isCreateFilePermitted(sessionService.getUser(sessionKey)));
	}

	@Override
	public List<DocumentItem> findDocumentsByTitle(SessionKey sessionKey, String searchString)
			throws InvalidSessionException {
		return documentService.findDocumentsByTitle(sessionKey, searchString);
	}

	@Override
	public FolderItem getParentFolder(FileItem fileItem) {
		return documentService.getParentFolder(fileItem);
	}

	@Override
	public List<FolderItem> getFilePath(FileItem fileItem) {
		return documentService.getFilePath(fileItem);
	}

	@Override
	public Long getNewSignUpperId(SignLocale locale) {
		return dictionaryService.getNewSignUpperId(locale);
	}

	@Override
	public boolean isSignReplacable(boolean saveLocally, SimpleSign sign, boolean isLoacallySaved) {
		return dictionaryService.isSignReplacable(saveLocally, sign, isLoacallySaved);
	}

	@Override
	public boolean sendPasswordForgottenEmail(String usernameOrMail) {
		return userService.sendPasswordForgottenEmail(usernameOrMail);
	}

	@Override
	public List<SignHistoryItem> getSignHistoryFor(SignId signId) {
		return dictionaryService.getSignHistoryFor(signId);
	}

	@Override
	public SimpleSign getSignFromHistory(SignHistoryItem signHistoryItem) {
		return dictionaryService.getSignFromHistory(signHistoryItem);
	}

	@Override
	public PositionedSymbol createPositionedSymbol(Symbol symbol, int x, int y, int z) {
		return symbolService.createPositionedSymbol(symbol, x, y, z);
	}

	@Override
	public User getUserFromUserName(String userName) {
		return userService.getUserFromUserName(userName);
	}

	@Override
	public boolean addUserToRoom(RoomItem room, String userName, SessionKey sessionKey) throws Exception {
		checkSessionValidity(sessionKey);
		if (!room.isResponsible(sessionService.getUser(sessionKey).getUsername())) {
			throw new MissingAuthorizationException();
		}
		return userService.addUserToRoom(room, userName, sessionKey);
	}

	@Override
	public boolean deleteUserFromRoom(RoomItem room, String userName, SessionKey sessionKey) throws Exception {
		checkSessionValidity(sessionKey);
		if (!sessionService.getUser(sessionKey).getUsername().equals(userName)
				&& !room.isResponsible(sessionService.getUser(sessionKey).getUsername())) {
			throw new MissingAuthorizationException();
		}

		return userService.deleteUserFromRoom(room, userName, sessionKey);
	}

	@Override
	public boolean addAdminToRoom(RoomItem room, String adminName, SessionKey sessionKey) throws Exception {
		checkSessionValidity(sessionKey);
		if (!room.isResponsible(sessionService.getUser(sessionKey).getUsername())) {
			throw new MissingAuthorizationException();
		}

		return userService.addAdminToRoom(room, adminName, sessionKey);
	}

	@Override
	public boolean deleteAdminFromRoom(RoomItem room, String adminName, SessionKey sessionKey) throws Exception {
		checkSessionValidity(sessionKey);
		if (!room.isResponsible(sessionService.getUser(sessionKey).getUsername())) {
			throw new MissingAuthorizationException();
		}

		return userService.deleteAdminFromRoom(room, adminName, sessionKey);
	}

	@Override
	public boolean changeRoomPolicy(RoomItem room, RoomPolicy selectedPolicy) {
		return documentService.changeRoomPolicy(room, selectedPolicy);
	}

	@Override
	public boolean loadVideoFromUrl(String url) {
		return videoService.loadVideoFromUrl(url);
	}

	@Override
	public String urlEncode(String url) {
		return videoService.urlEncode(url);
	}

	@Override
	public DocumentItem getDocumentItem(SessionKey sessionKey, String fileName, String[] folderNames)
			throws RecursiveDirectoryException, DirectoryNotFoundException, AccessDeniedException,
			DocumentNotFoundException, InvalidSessionException {
		return documentService.getDocumentItem(sessionKey, fileName, folderNames);
	}

	@Override
	public FolderItem getFolderItem(SessionKey sessionKey, String[] folderNames) throws RecursiveDirectoryException,
			DirectoryNotFoundException, AccessDeniedException, InvalidSessionException {
		return documentService.getFolderItem(sessionKey, folderNames);
	}

	@Override
	public void logMissingCharacter(char c, String documentName) {
		loggingService.logMissingCharacter(c, documentName);
	}

	@Override
	public Map<FontMetricSpecifier, FontMetric> getFontMetrics() {
		return fontMetricGenerationService.getFontMetrics();
	}

	@Override
	public RoomPolicy getRoomPolicy(String roomName) {
		return documentService.getRoomPolicy(roomName);
	}

	@Override
	public boolean isUserSessionValid(SessionKey sessionKey) {
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		return sessionService.isUserSessionValid(sessionKey);
	}

	// Method should not be called from outside
	@Deprecated
	@Override
	public boolean existsUsers(List<String> userNames) {
		return false;
	}

	@Override
	public void verifyRoomParameters(SessionKey sessionKey, String roomName, List<String> roomOwners,
			List<String> roomUsers)
			throws InvalidSessionException, RoomnameCollisionException, InvalidUsernameException {
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert roomName != null : "Precondition failed: roomName != null";
		if (sessionService.isUserSessionValid(sessionKey)) {
			if (userService.existsUsers(roomUsers) && userService.existsUsers(roomOwners)) {
				documentService.verifyRoomParameters(sessionKey, roomName, roomOwners, roomUsers);
			} else {
				throw new InvalidUsernameException();
			}
		} else {
			throw new InvalidSessionException();
		}
	}

	@Override
	public JsonBadgesWithUsername getBadgesForUser(User user, String badgeUsername, BadgeType[] badgeTypes,
			boolean readOnly) {
		if (user == null) {
			throw new RuntimeException("user not specified");
		}
		if (badgeUsername == null) {
			throw new RuntimeException("badge username not specified");
		}
		if (badgeTypes == null) {
			throw new RuntimeException("badge types not specified");
		}
		if (badgeTypes.length <= 0) {
			throw new RuntimeException("empty list of badge types");
		}
		if (!user.getUsername().equals(badgeUsername) && !user.isAdmin()) {
			throw new RuntimeException(
					user.getUsername() + " is not allowed to retrieve badges for the user " + badgeUsername);
		}
		return badgePersistenceService.getBadgesForUser(badgeUsername, badgeTypes, readOnly);
	}

	@Override
	public void updateBadgesForUser(User user, JsonBadgesWithUsername badges) throws DataCouldNotBeStoredException {
		if (user == null) {
			throw new RuntimeException("user not specified");
		}
		if (badges == null) {
			throw new RuntimeException("badges not specified");
		}
		if (!user.getUsername().equals(badges.getUsername()) && !user.isAdmin()) {
			throw new RuntimeException(
					user.getUsername() + " is not allowed to update badges for the user " + badges.getUsername());
		}
		badgePersistenceService.updateBadgesForUser(badges);
	}

	@Override
	public List<BadgeReport> getBadgeReportsSince(User user, Date date) {
		if (user == null) {
			throw new RuntimeException("user not specified");
		}
		if (!user.isAdmin()) {
			throw new RuntimeException(user.getUsername() + " is not allowed to retrieve badge reports");
		}
		return badgePersistenceService.getBadgeReportsSince(date);
	}

	@Override
	public void reportUrl(String reportingUserName, String documentOwnerName, Date reportingDate, Id documentId,
			FileTitle documentName, String url) {
		contentReportService.reportUrl(reportingUserName, documentOwnerName, reportingDate, documentId, documentName,
				url);
	}

	@Override
	public void hideSign(SimpleSign sign, SessionKey sessionKey) throws Exception {
		checkSessionValidity(sessionKey);

		if (!sessionService.getUser(sessionKey).isAuthor()) {
			throw new AccessDeniedException();
		}

		dictionaryService.hideSign(sign, sessionKey);
	}

	@Override
	public UserSession createUnknownUserSession() {
		return sessionService.createUnknownUserSession();
	}

	@Override
	public List<Notification> getNotifications(String username) {
		return notificationService.getNotifications(username);
	}

	@Override
	public int getNotificationCount(String username) {
		return notificationService.getNotificationCount(username);
	}

	@Override
	public void removeNotificationEntry(String username) {
		notificationService.removeNotificationEntry(username);
	}

	@Override
	public boolean hasVideoAndImagePermission(SessionKey sessionKey) throws InvalidSessionException {
		checkSessionValidity(sessionKey);

		return checkUserForImageAndVideoPermissons(sessionKey);
	}

	private boolean checkUserForImageAndVideoPermissons(SessionKey sessionKey) throws InvalidSessionException {
		User user = sessionService.getUser(sessionKey);
		return user.isAdmin() || user.isAuthor() || isFAWLecturer(user);
	}

	private boolean isFAWLecturer(User user) {
		switch (user.getUsername()) {
		case "annifaw":
		case "fawkay":
		case "katjafaw":
		case "katjakielfaw":
		case "Lutz.faw":
		case "michafaw":
			return true;
		default:
			return false;
		}
	}

	private void checkSessionValidity(SessionKey sessionKey) throws InvalidSessionException {
		if (!sessionService.isUserSessionValid(sessionKey)) {
			throw new InvalidSessionException();
		}
	}

	@Override
	public SignSource resolveLatestSource(long upperIdPart, String lowerIdPart, SignLocale signLocale) {
		return dictionaryService.resolveLatestSource(upperIdPart, lowerIdPart, signLocale);
	}

	@Override
	public String getMediaUrl() {
		return mediaUrlService.getMediaUrl();
	}

	@Override
	public List<FileItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String title,
			FolderItem currentFolder) {
		return documentService.findSortedDocumentsByTitleLike(sessionKey, title, currentFolder);
	}

	@Override
	public List<DocumentItem> findSortedDocumentsByTitleLike(SessionKey sessionKey, String searchString)
			throws InvalidSessionException {
		return documentService.findSortedDocumentsByTitleLike(sessionKey, searchString);
	}

	@Override
	public void setLastClosedDocument(FileTitle documentTitle, Id currentFolderId) {
		documentService.setLastClosedDocument(documentTitle, currentFolderId);
	}

	@Override
	public DocumentItem getLastClosedDocumentItem() {
		return documentService.getLastClosedDocumentItem();
	}

}
