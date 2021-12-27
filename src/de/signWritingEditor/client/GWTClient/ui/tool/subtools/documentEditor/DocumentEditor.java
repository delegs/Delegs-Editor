package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.CopyToClipboardCompletionListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.DocumentPartsToCopyHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.ObjectFoundStorage;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.ObjectStorageImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.ObjectToClipboardTextHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.ParagraphFoundHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.ParagraphFoundStoreInListHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.SectionFoundHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.clipboard.TokenFoundHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor.SignModifiedListener;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.ParagraphIndex;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignItemEditor;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PdfFileItem;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignIdFactory;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.VideoToken;

public abstract class DocumentEditor {

	private final DictionaryServiceAsync dictionaryService;
	private final DocumentServiceAsync documentService;
	protected final VideoServiceAsync videoService;
	protected final MediaUrlServiceAsync mediaUrlService;
	protected final BrowserHistoryService browserHistoryService;
	private FontSizeService fontSizeService;
	private BadgeServiceClient badgeService;

	private GWTDocumentLayouter documentLayouter;
	protected TextbasedTokenStyleTool tokenStyleTool;

	protected Document document;
	protected RoomItem rootRoom;

	private final LocalSessionService localSessionService;

	private final Clipboard clipboard;

	private Tokenizer tokenizer;

	protected TokenFactory tokenFactory;
	private final IdFactory idFactory;
	private SignIdFactory localSignIdFactory;

	private DocumentItem documentItem;
	private long savedDocumentVersionHash;

	private RoomItem roomContainingDocument;
	private FolderItem folderItemOfDocument;

	protected List<DocumentItem> documentItemsInCurrentFolder;
	protected int currentDocumentIndex;

	private LinkedHashSet<Id> selectedParagraphIds;

	private Id currentCursorTokenId;
	private Id firstSelectedTokenId;
	private int cursorAbsoluteLeft;

	private final DocumentEditorListener documentEditorListener;
	private SignLocale currentSignLocale;
	private final SignLocale defaultSignLocale;

	static protected char[] nonCapitalizingCharacters = { 'ß' };
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	public DocumentEditor(DictionaryServiceAsync dictionaryService, DocumentServiceAsync documentService,
			VideoServiceAsync videoService, MediaUrlServiceAsync mediaUrlService,
			BrowserHistoryService browserHistoryService, FontSizeService fontSizeService,
			BadgeServiceClient badgeService, IdFactory idFactory, TextbasedTokenStyleFactory textbasedTokenStyleFactory,
			LocalSessionService localSessionService, RoomItem rootRoom, SignLocale defaultSignLocale,
			DocumentEditorListener listener) {
		assert dictionaryService != null : "Precondition failed: dictionaryService != null";
		assert documentService != null : "Precondition failed: documentService != null";
		assert idFactory != null : "Precondition failed: idFactory != null";
		assert localSessionService != null : "Precondition failed: localSessionService != null";
		assert rootRoom != null : "Precondition failed: rootRoom != null";
		assert listener != null : "Precondition failed: listener != null";
		assert browserHistoryService != null : "Precondition failed: browserHistoryService != null";
		assert defaultSignLocale != null : "Precondition failed: defaultSignLocale != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";
		assert badgeService != null : "Precondition failed: badgeService != null";
		assert textbasedTokenStyleFactory != null : "Precondition failed: textbasedTokenStyleFactory != null";
		assert mediaUrlService != null : "Precondition failed: mediaUrlService != null";

		this.selectedParagraphIds = new LinkedHashSet<Id>();

		this.badgeService = badgeService;
		this.fontSizeService = fontSizeService;
		this.documentEditorListener = listener;
		this.documentService = documentService;
		this.dictionaryService = dictionaryService;
		this.videoService = videoService;
		this.browserHistoryService = browserHistoryService;
		this.localSessionService = localSessionService;
		this.idFactory = idFactory;
		this.textbasedTokenStyleFactory = textbasedTokenStyleFactory;
		this.tokenFactory = new TokenFactory(idFactory);
		this.localSignIdFactory = new SignIdFactory();
		this.tokenizer = new Tokenizer();
		this.rootRoom = rootRoom;
		this.roomContainingDocument = rootRoom;
		this.folderItemOfDocument = rootRoom;
		this.clipboard = initClipboard();
		this.defaultSignLocale = defaultSignLocale;
		this.currentSignLocale = null;
		this.mediaUrlService = mediaUrlService;
	}

	public void openDocument(final DocumentItem documentItem, final FolderItem currentFolderItem,
			final RoomItem roomContainingDocument, final List<DocumentItem> documentItemsInCurrentFolder) {
		assert documentItem != null : "Precondition failed: documentItem != null";
		assert documentItemsInCurrentFolder != null : "Precondition failed: documentItemsInCurrentFolder != null";
		assert documentItemsInCurrentFolder
				.contains(documentItem) : "Precondition failed: documentItemsInCurrentFolder.contains(documentItem)";
		this.documentItemsInCurrentFolder = documentItemsInCurrentFolder;

		currentDocumentIndex = documentItemsInCurrentFolder.indexOf(documentItem);
		if (documentItem instanceof PdfFileItem) {
			documentEditorListener.onPdfLoaded((PdfFileItem) documentItem);
			return;
		}

		boolean isGivenDocumentLoaded = this.getDocumentItem() != null && this.getDocumentItem().equals(documentItem);

		if (!isGivenDocumentLoaded) {
			documentService.loadDocument(localSessionService.getSessionKey(), documentItem,
					new SignWritingCallback<Document>(I18N.getErrorOnLoadingDocument()) {
						@Override
						public void onSuccess(Document document) {
							openDocument(document, documentItem, currentFolderItem, roomContainingDocument);
							if (document.getAuthor().equals(localSessionService.getCurrentUser())) {
								badgeService.userOpenedOwnDocument();
							}
							documentEditorListener.onDocumentLoaded();
							assert DocumentEditor.this.getSavedDocumentVersionHash() == DocumentEditor.this.document
									.contentHashCode() : "Postcondition failed: Document was manipulated during the loading process calls onloading finished";
						}

						@Override
						public void onFailure(Throwable caught) {
							if (caught instanceof InvalidSessionException) {
								handleInvalidSessionException();
							} else {
								super.onFailure(caught);
							}
							documentEditorListener.onExceptionDuringDocumentLoaded();
						}
					});
		} else {
			this.getDocument().setDocumentTitle(documentItem.getFileTitle());
			this.folderItemOfDocument = currentFolderItem;
			browserHistoryService.createHistoryToken(documentItem);
			documentEditorListener.onDocumentLoaded();
		}

	}

	public void openDocument(Document document, DocumentItem optionalDocumentItem, FolderItem folderItemOfDocument,
			RoomItem roomContainingDocument) {
		assert document != null : "Precondition failed: document != null";
		assert !document.isEmpty() : "Precondition failed: !document.isEmpty()";
		assert folderItemOfDocument != null : "Precondition failed: folderItemOfDocument != null";
		assert roomContainingDocument != null : "Precondition failed: roomContainingDocument != null";

		this.roomContainingDocument = roomContainingDocument;
		this.folderItemOfDocument = folderItemOfDocument;
		this.document = document;
		this.tokenStyleTool = new TextbasedTokenStyleTool(getDocumentLayouter());
		this.setSavedDocumentVersionHash(document.contentHashCode());

		setDocumentItem(optionalDocumentItem);

		setFooterText(document.getDocumentTitle().getTitleString());

		setFirstSelectedTokenId(null);

		getDocumentLayouter().clear();

		currentSignLocale = document.getSignLocale();

		currentCursorTokenId = null;
		loadDocument(document);
		setSelectionAndCursorToAbsoluteLeft(getDocument().getToken(0, 0, 0).getId(), 0, false);

		// optionalDocumentItem is null if new document is opened
		if (optionalDocumentItem != null) {
			browserHistoryService.createHistoryToken(optionalDocumentItem);
		}
		assert this.getSavedDocumentVersionHash() == this.document
				.contentHashCode() : "Postcondition failed: Document was manipulated during the loading process";

	}

	private void loadDocument(Document document) {
		List<Token> tokensToUpdate = new ArrayList<Token>();
		for (int sectionIndex = 0; sectionIndex < document.getSectionCount(); sectionIndex++) {
			if (!document.getSection(sectionIndex).isCollage()) {
				loadNormalSection(document, tokensToUpdate, sectionIndex);
			} else {
				loadCollage(document, tokensToUpdate, sectionIndex);
			}
		}
		updateSigns(tokensToUpdate);
	}

	private void loadCollage(Document document, List<Token> tokensToUpdate, int sectionIndex) {
		Section section = document.getSection(sectionIndex);

		getDocumentLayouter().addPage(document.getPageFormat(), true, section.getCollageId(),
				document.showCollageGrid());
		int pageNo = getCollagePageIndex(sectionIndex);

		for (int i = 0; i < section.getParagraphCount(); i++) {
			Paragraph paragraph = section.getParagraph(i);
			getDocumentLayouter().addSnippetToCollagePage(paragraph.getParagraphId(), pageNo, paragraph.getPositionX(),
					paragraph.getPositionY(), paragraph.getWidth(), paragraph.getZIndex());

			getDocumentLayouter().updateSnippetWidth(pageNo, i, paragraph.getWidth(), paragraph.isAutomaticResize());
			Token token = paragraph.getToken(0);
			tokensToUpdate.add(token);
			getDocumentLayouter().setSnippetAutomaticResize(pageNo, i, false);
			getDocumentLayouter().addTokenToSnippet(pageNo, i, token);
			loadTokensToPage(document, tokensToUpdate, token.getId(), sectionIndex, i, paragraph);
			getDocumentLayouter().setSnippetAutomaticResize(pageNo, i, paragraph.isAutomaticResize());
		}
	}

	private void loadNormalSection(Document document, List<Token> tokensToUpdate, int sectionIndex) {
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >=0";
		assert document
				.getSection(sectionIndex) != null : "Precondition failed: document.getSection(sectionIndex) != null";
		assert !document.getSection(sectionIndex)
				.isEmpty() : "Precondition failed: !document.getSection(sectionIndex).isEmpty()";

		Token firstToken = document.getToken(sectionIndex, 0, 0);
		Paragraph firstParagraph = document.getSection(sectionIndex).getParagraph(0);

		getDocumentLayouter().addPage(document.getPageFormat());
		getDocumentLayouter().addNewLine();
		getDocumentLayouter().addToken(firstToken, firstParagraph.isSearchWordLineVisible(),
				firstParagraph.isSignLineVisible());

		Id firstTokenId = firstToken.getId();
		Id currentTokenId = firstTokenId;
		tokensToUpdate.add(firstToken);

		for (int paragraphIndex = 0; paragraphIndex < document.getParagraphCount(sectionIndex); paragraphIndex++) {
			Paragraph paragraph = document.getSection(sectionIndex).getParagraph(paragraphIndex);
			if (paragraphIndex > 0 && !paragraph.isEmpty()) {
				Token newToken = document.getToken(sectionIndex, paragraphIndex, 0);
				getDocumentLayouter().insertLineBreakAndTokenAfter(currentTokenId, paragraph.isSearchWordLineVisible(),
						paragraph.isSignLineVisible(), newToken);
				tokensToUpdate.add(newToken);

				currentTokenId = newToken.getId();
			}

			currentTokenId = loadTokensToPage(document, tokensToUpdate, currentTokenId, sectionIndex, paragraphIndex,
					paragraph);
		}
	}

	private Id loadTokensToPage(Document document, List<Token> tokensToUpdate, Id currentTokenId, int sectionIndex,
			int paragraphIndex, Paragraph paragraph) {
		for (int tokenIndex = 1; tokenIndex < document.getTokenCount(sectionIndex, paragraphIndex); tokenIndex++) {
			Token newToken = document.getToken(sectionIndex, paragraphIndex, tokenIndex);
			Id newTokenId = newToken.getId();
			getDocumentLayouter().insertTokenAfter(currentTokenId, newToken, paragraph.isSearchWordLineVisible(),
					paragraph.isSignLineVisible());
			tokensToUpdate.add(newToken);

			currentTokenId = newTokenId;
		}
		return currentTokenId;
	}

	protected void loadPartOfDocument(Document document, List<Token> tokensToUpdate, Id currentTokenId, Id firstTokenId,
			Id lastTokenId) {
		DocumentIndex firstTokenIndex = document.getDocumentIndex(firstTokenId);
		DocumentIndex lastTokenIndex = document.getDocumentIndex(lastTokenId);
		int paragraphIndex = firstTokenIndex.getParagraphIndex();
		int tokenIndex = firstTokenIndex.getTokenIndex();
		int lastParagraph = 0;
		int lastToken = 0;
		for (int sectionIndex = firstTokenIndex.getSectionIndex(); sectionIndex <= lastTokenIndex
				.getSectionIndex(); sectionIndex++) {
			if (sectionIndex > 0 && !document.getSection(sectionIndex).isEmpty()) {
				Token newToken = document.getToken(sectionIndex, paragraphIndex, tokenIndex);
				Id newTokenId = newToken.getId();

				Paragraph paragraph = document.getSection(sectionIndex).getParagraph(0);
				getDocumentLayouter().insertPageBreakAndTokenAfter(currentTokenId, paragraph.isFreeTextLineVisible(),
						paragraph.isSearchWordLineVisible(), paragraph.isSignLineVisible(), newToken);
				tokensToUpdate.add(newToken);

				currentTokenId = newTokenId;
				tokenIndex++;
			}

			if (sectionIndex == lastTokenIndex.getSectionIndex()) {
				lastParagraph = lastTokenIndex.getParagraphIndex() + 1;
			} else {
				lastParagraph = document.getParagraphCount(sectionIndex);
			}

			for (; paragraphIndex < lastParagraph; paragraphIndex++) {
				Paragraph paragraph = document.getSection(sectionIndex).getParagraph(paragraphIndex);
				if (paragraphIndex > 0 && !paragraph.isEmpty()) {
					Token newToken = document.getToken(sectionIndex, paragraphIndex, tokenIndex);
					Id newTokenId = newToken.getId();

					getDocumentLayouter().insertLineBreakAndTokenAfter(currentTokenId,
							paragraph.isSearchWordLineVisible(), paragraph.isSignLineVisible(), newToken);
					tokensToUpdate.add(newToken);

					currentTokenId = newTokenId;
					tokenIndex++;
				}

				if (sectionIndex == lastTokenIndex.getSectionIndex()
						&& paragraphIndex == lastTokenIndex.getParagraphIndex()) {
					lastToken = lastTokenIndex.getTokenIndex() + 1;
				} else {
					lastToken = document.getTokenCount(sectionIndex, paragraphIndex);
				}

				if (firstTokenId.equals(lastTokenId) && firstTokenId.equals(document.getToken(0, 0, 0).getId())) {
					break; // Document's first sign is always added separately
							// and therefore, does not need to be added again
				}

				for (; tokenIndex < lastToken; tokenIndex++) {
					Token newToken = document.getToken(sectionIndex, paragraphIndex, tokenIndex);
					Id newTokenId = newToken.getId();
					getDocumentLayouter().insertTokenAfter(currentTokenId, newToken,
							paragraph.isSearchWordLineVisible(), paragraph.isSignLineVisible());
					tokensToUpdate.add(newToken);

					currentTokenId = newTokenId;
				}
				tokenIndex = 0;
			}
			paragraphIndex = 0;
		}
		updateSigns(tokensToUpdate);
	}

	protected void updateTokensFromTo(Id from, Id to) {
		List<Token> tokenList = getDocument().getTokensFromTo(from, to);

		for (Token token : tokenList) {
			getDocumentLayouter().updateTokenBox(token.getId());
		}
	}

	public void updateAllTokensWithWord(String word) {
		assert word != null : "Precondition failed: word != null";

		for (int pageIndex = 0; pageIndex < getDocumentLayouter().getPageCount(); pageIndex++) {
			for (int lineIndex = 0; lineIndex < getDocumentLayouter().getLineCount(pageIndex); lineIndex++) {
				LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);

				for (int tokenIndex = 0; tokenIndex < getDocumentLayouter()
						.getBoxCount(lineIndexObject); tokenIndex++) {
					Token token = getDocument().getToken(
							((TokenBox) getDocumentLayouter().getBox(new BoxIndex(pageIndex, lineIndex, tokenIndex)))
									.getId());
					if (token instanceof SignItemToken) {
						if (((SignItemToken) token).getText().equalsIgnoreCase(word)) {
							updateSigns((SignItemToken) token);
						}
					}
				}
			}
		}
	}

	public boolean isAutomaticFreeTextLineEnabled() {
		return getDocument().isAutomaticFreeTextLineEnabled();
	}

	public void saveDocument(final Document document, final FolderItem folderItem, final FileTitle fileTitle,
			final Callback<DocumentItem, Throwable> listener) {
		documentService.saveOrUpdateDocument(localSessionService.getSessionKey(), document, folderItem,
				new SignWritingCallback<DocumentItem>(
						I18N.getErrorOnSavingDocument() + ": " + fileTitle.getTitleString()) {
					@Override
					public void onSuccess(DocumentItem result) {
						setDocumentItem(result);
						setSavedDocumentVersionHash(document.contentHashCode());
						browserHistoryService.createHistoryToken(result);
						listener.onSuccess(result);
						DocumentEditor.this.documentEditorListener.onDocumentSavedAs(folderItem);
					}

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSessionException();
						} else {
							super.onFailure(caught);
						}
						listener.onFailure(caught);
					}
				});
	}

	public void createNewDocument() {
		createNewDocument(new FileTitle(I18N.getNewDocument()), PageFormat.A4_PORTRAIT, defaultSignLocale, rootRoom,
				rootRoom);
	}

	public void createNewDocument(FileTitle fileTitle, PageFormat pageFormat, SignLocale signLocale,
			FolderItem currentFolder, RoomItem currentRoom) {
		assert fileTitle != null : "Precondition failed: documentTitle != null";
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert signLocale != null : "Precondition failed: signLocale != null";

		documentItemsInCurrentFolder = null;

		getDocumentLayouter().setPageFormat(pageFormat);
		Document newDocument = new Document(User.getUnknownUser(), signLocale, fileTitle, pageFormat);
		newDocument.addSection(new Section());
		newDocument.getSection(0).addParagraph(new Paragraph(idFactory.createId()));
		currentSignLocale = signLocale;
		newDocument.addToken(getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(), Color.WHITE,
				currentSignLocale));
		if (newDocument.isAutomaticFreeTextLineEnabled()) {
			newDocument.addToken(getTokenFactory().createFreeTextLineToken(getDefaultTextbasedTokenStyle()));
		}
		openDocument(newDocument, null, currentFolder, currentRoom);

		selectedParagraphIds.clear();
		browserHistoryService.createHistoryToken(getFolderItemOfDocument());
	}

	public void setDocumentItem(DocumentItem optionalDocumentItem) {
		this.documentItem = optionalDocumentItem;
	}

	public Document getDocument() {
		assert document != null : "Postcondition failed: document != null";

		return document;
	}

	@Deprecated
	// FontSizeService should only be accessed within DocumentEditor
	protected FontSizeService getFontSizeService() {
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		return fontSizeService;
	}

	@Deprecated
	// documentService should only be accessed within DocumentEditor
	protected DocumentServiceAsync getDocumentService() {
		assert documentService != null : "Precondition failed: documentService != null";

		return documentService;
	}

	public SignLocale getDefaultSignLocale() {
		assert defaultSignLocale != null : "Postcondition failed: result != null";
		return defaultSignLocale;
	}

	public boolean isDocumentNeverSaved() {
		return documentItem == null;
	}

	public boolean hasUnsavedChanges() {
		return this.getDocument().contentHashCode() != getSavedDocumentVersionHash();
	}

	public void toggleUnderlineVisibility() {
		boolean newVisibility = !getDocument().areUnderlinesVisible();
		setUnderlineVisibility(newVisibility);
		getDocument().setUnderlinesVisible(newVisibility);
	}

	public void setDocumentTitle(FileTitle fileTitle) {
		assert fileTitle != null : "Precondition failed: documentTitle != null";

		getDocument().setDocumentTitle(fileTitle);
		setFooterText(fileTitle.getTitleString());
	}

	public void updateLocallyModifiedSign(SimpleSign modifiedSign, Id tokenId) {
		assert modifiedSign != null : "Precondition failed: modifiedSign != null";
		assert tokenId != null : "Precondition failed: tokenId != null";

		SignItemToken token = (SignItemToken) getDocument().getToken(tokenId);
		String word = modifiedSign.getSignId().getLowerIdPart();

		LocalDictionary localDictionary = this.getDocument().getLocalDictionary();

		if (localDictionary.contains(modifiedSign.getSignId())) {
			// Override old sign in local dictionary
			updateSignInLocalDictionary(modifiedSign);
		} else {
			// Create a sign with new id
			modifiedSign.setSignId(localSignIdFactory.createNewSignIdFrom(modifiedSign.getSignId()));
			saveSignInLocalDictionary(modifiedSign);
		}

		token.setSignItem(new SignItem(modifiedSign));
		if (!word.toLowerCase().equals(token.getText().toLowerCase())) {
			token.setText(word);
		}

		getDocumentLayouter().updateTokenBox(token.getId());
		updateAllTokensWithWord(word);
	}

	/**
	 * Only call this method if sign was globally modified (not locally)!
	 * 
	 * @param modifiedSign sign modified
	 * @param tokenId old token
	 */
	public void updateModifiedSign(SimpleSign modifiedSign, Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert modifiedSign != null : "Precondition failed: modifiedSign != null";

		SignItemToken token = (SignItemToken) getDocument().getToken(tokenId);
		String word = modifiedSign.getSignId().getLowerIdPart();
		token.setSignItem(new SignItem(modifiedSign.getSignId(), modifiedSign.getWidth()));
		if (!word.toLowerCase().equals(token.getText().toLowerCase())) {
			token.setText(word);
		}

		getDocumentLayouter().updateTokenBox(token.getId());
		updateAllTokensWithWord(word);
	}

	public void updateSignInLocalDictionary(SimpleSign modifiedSign) {
		LocalDictionary localDictionary = getDocument().getLocalDictionary();
		if (!localDictionary.getSign(modifiedSign.getSignId()).contentBasedEquals(modifiedSign)) {
			localDictionary.update(modifiedSign);
			badgeService.userUpdatedLocalSign();
		}
	}

	public void saveSignInLocalDictionary(SimpleSign modifiedSign) {
		LocalDictionary localDictionary = getDocument().getLocalDictionary();
		localDictionary.save(modifiedSign);
		badgeService.userCreatedLocalSign();
	}

	protected Id getCurrentCursorTokenId() {
		return currentCursorTokenId;
	}

	protected void setCurrentCursorTokenId(Id id) {
		currentCursorTokenId = id;
	}

	protected TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	protected IdFactory getIdFactory() {
		return idFactory;
	}

	protected DocumentItem getDocumentItem() {
		return documentItem;
	}

	protected long getSavedDocumentVersionHash() {
		return savedDocumentVersionHash;
	}

	protected void setSavedDocumentVersionHash(long savedDocumentVersionHash) {
		this.savedDocumentVersionHash = savedDocumentVersionHash;
	}

	protected RoomItem getRoomContainingDocument() {
		return roomContainingDocument;
	}

	protected void setRoomContainingDocument(RoomItem roomContainingDocument) {
		this.roomContainingDocument = roomContainingDocument;
	}

	protected FolderItem getFolderItemOfDocument() {
		assert folderItemOfDocument != null : "Postcondition failed: result != null";

		return folderItemOfDocument;
	}

	protected void setFolderItemOfDocument(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		this.folderItemOfDocument = folderItem;
	}

	private Paragraph createEmptyParagraph() {
		Paragraph paragraph = new Paragraph(getIdFactory().createId());
		paragraph.setAutomaticResizeActive(true);
		paragraph.setFreeTextLineVisible(true);
		paragraph.setPositionX(10);
		paragraph.setPositionY(10);
		paragraph.setWidth(200);
		paragraph.setSearchWordLineVisible(true);
		paragraph.setSignLineVisible(true);
		paragraph.setZIndex(0);
		return paragraph;
	}

	private Paragraph cloneParagraph(Paragraph paragraph) {
		Paragraph result = createEmptyParagraph();
		result.setAutomaticResizeActive(paragraph.isAutomaticResize());
		result.setFreeTextLineVisible(paragraph.isFreeTextLineVisible());
		result.setSearchWordLineVisible(paragraph.isSearchWordLineVisible());
		result.setSignLineVisible(paragraph.isSignLineVisible());
		result.setPositionX(paragraph.getPositionX());
		result.setPositionY(paragraph.getPositionY());
		result.setZIndex(paragraph.getZIndex());
		result.setWidth(paragraph.getWidth());

		for (Token token : paragraph.getTokens()) {
			result.addToken(tokenFactory.createNewTokenFromToken(token));
		}

		return result;
	}

	protected void handlePreUpdateVideoSource(Id id, String url) {
		assert getDocument().getToken(
				id) instanceof VideoToken : "Precondition failed: getDocument().getToken(id) instanceof VideoToken";

		VideoToken videoToken = (VideoToken) getDocument().getToken(id);
		videoToken.setUrl(url);
	}

	protected void handleUpdateVideoSource(Id id, String url) {
		assert getDocument().getToken(
				id) instanceof VideoToken : "Precondition failed: getDocument().getToken(id) instanceof VideoToken";
		handlePreUpdateVideoSource(id, url);
		if (!"".equals(url)) {
			final VideoToken videoToken = (VideoToken) getDocument().getToken(id);
			videoService.loadVideoFromUrl(url, new AsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean result) {
					if (getDocument().containsToken(videoToken.getId())) {
						if (result.booleanValue()) {
							getDocumentLayouter().reloadVideoToken(videoToken.getId());
						} else {
							getDocumentLayouter().loadVideoNotFoundInVideoToken(videoToken.getId());
						}
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					if (getDocument().containsToken(videoToken.getId())) {
						getDocumentLayouter().setVideoToConvertingTillLoaded(videoToken.getId());
					}
				}
			});
		}
	}

	protected void handleImageUrlChanged(Id id, String newUrl) {
		assert id != null : "Precondition failed: id != null";
		assert newUrl != null : "Precondition failed: newUrl != null";

		Token token = getDocument().getToken(id);
		if (token instanceof ImageToken) {
			((ImageToken) token).setUrl(newUrl);
		} else {
			assert token instanceof ImageToken : "Precondition failed: token instanceof ImageToken";
		}

		getDocumentLayouter().updateTokenBox(id);
	}

	protected void handleDeleteSnippet() {
		for (Id id : selectedParagraphIds) {
			assert getDocument().containsParagraph(id) : "Precondition failed: document.containsParagraph(id)";
			ParagraphIndex paragraphIndex = getDocument().getParagraphIndex(id);

			Section section = getDocument().getSection(paragraphIndex.getSectionIndex());

			if (!section.isLayoutLocked()) {
				assert section.isCollage() : "Precondition failed: section.isCollage()";
				if (section.getParagraphCount() > 1) {
					handleRemoveSnippetFromDocument(id);
				} else {
					Id pageId = section.getCollageId();
					removeCollage(pageId);
				}
			}
		}
		selectedParagraphIds.clear();
	}

	protected void handleSnippetPositionChanged(Id id, int x, int y, boolean snapped, int distanceX, int distanceY) {
		assert getDocument().containsParagraph(id) : "Precondition failed: document.containsParagraph(id)";

		Paragraph paragraph = getDocument().getParagraph(id);

		if (!paragraph.isLayoutLocked()) {
			ParagraphIndex paragraphIndex = getDocument().getParagraphIndex(id);
			int firstPageIndex = getCollagePageIndex(paragraphIndex.getSectionIndex());
			getDocumentLayouter().updateSnippetPosition(firstPageIndex, paragraphIndex.getParagraphIndex(), x, y);

			if (selectedParagraphIds.size() > 0) {

				int deltaX = x - paragraph.getPositionX();
				int deltaY = y - paragraph.getPositionY();
				for (Id selectedId : selectedParagraphIds) {
					if (!selectedId.equals(id)) {
						assert getDocument().containsParagraph(
								id) : "Precondition failed: document.containsParagraph(id) - selectedId should only contain paragraph Ids.";
						Paragraph selectedParagraph = getDocument().getParagraph(selectedId);
						int newX = selectedParagraph.getPositionX() + deltaX;
						int newY = selectedParagraph.getPositionY() + deltaY;
						selectedParagraph.setPositionX(newX);
						selectedParagraph.setPositionY(newY);

						paragraphIndex = getDocument().getParagraphIndex(selectedId);
						int pageNumber = getCollagePageIndex(paragraphIndex.getSectionIndex());
						getDocumentLayouter().updateSnippetPosition(pageNumber, paragraphIndex.getParagraphIndex(),
								newX, newY);
					}
				}
			}
			paragraph.setPositionX(x);
			paragraph.setPositionY(y);
		}
	}

	protected void handleSelectSnippetsFromTo(Id collageId, int x, int y, int width, int height,
			boolean addToExistingSelection) {
		if (!addToExistingSelection) {
			clearParagraphSelection();
		}
		int sectionIndex = getDocument().getSectionIndexForCollageId(collageId);
		Section section = getDocument().getSection(sectionIndex);
		for (int i = 0; i < section.getParagraphCount(); i++) {
			Paragraph paragraph = section.getParagraph(i);
			boolean isPositionBelowUpperBopund = paragraph.getPositionX() <= x + width
					&& paragraph.getPositionY() <= y + height;
			boolean isPositionAboveLowerBound = paragraph.getPositionX() >= x && paragraph.getPositionY() >= y;
			if (isPositionAboveLowerBound && isPositionBelowUpperBopund) {
				handleToggleSnippetSelection(paragraph.getParagraphId(), true);
			}
		}
	}

	protected void handleDeselection(boolean deactivate) {
		if (!deactivate) {
			clearParagraphSelection();
		}
	}

	protected void handleToggleSnippetSelection(Id id, boolean addToExistingSelection) {

		if (getFirstSelectedTokenId() != null) {
			deselectTokens();
		}

		if (selectedParagraphIds.contains(id)) {
			if (addToExistingSelection) {
				selectedParagraphIds.remove(id);
				deselectParagraph(id);
			} else {
				selectedParagraphIds.remove(id);
				clearParagraphSelection();
				selectedParagraphIds.add(id);
				selectParagraph(id);
			}
		} else {
			if (selectedParagraphIds.isEmpty() || addToExistingSelection) {
				selectedParagraphIds.add(id);
				selectParagraph(id);
			} else {
				clearParagraphSelection();
				selectedParagraphIds.add(id);
				selectParagraph(id);
			}
		}
	}

	private void selectParagraph(Id selectId) {
		Paragraph paragraph = getDocument().getParagraph(selectId);
		BoxIndex idBoxIndex = getDocumentLayouter().getIdBoxIndex(paragraph.getToken(0).getId());
		getDocumentLayouter().setSnippetSelection(idBoxIndex.getPageIndex(), idBoxIndex.getSnippetIndex(), true);
	}

	private void deselectParagraph(Id deselectId) {
		Paragraph paragraph = getDocument().getParagraph(deselectId);
		BoxIndex idBoxIndex = getDocumentLayouter().getIdBoxIndex(paragraph.getToken(0).getId());
		getDocumentLayouter().setSnippetSelection(idBoxIndex.getPageIndex(), idBoxIndex.getSnippetIndex(), false);
	}

	protected void clearParagraphSelection() {
		for (Id id : selectedParagraphIds) {
			deselectParagraph(id);
		}
		selectedParagraphIds.clear();
	}

	protected void handleSnippetWidthChanged(Id id, int width, boolean automatic) {
		assert getDocument().containsParagraph(id) : "Precondition failed: document.containsParagraph(id)";
		assert getDocument().getSection(getDocument().getParagraphIndex(id).getSectionIndex())
				.isCollage() : "Precondition failed: Section is not free positionable";

		Paragraph paragraph = getDocument().getParagraph(id);

		if (!paragraph.isLayoutLocked()) {
			paragraph.setWidth(width);
			if (!automatic) {
				paragraph.setAutomaticResizeActive(false);
			}
			for (int i = 0; i < paragraph.getTokenCount(); i++) {
				Token token = paragraph.getToken(i);
				if (token instanceof FreeTextToken) {
					FreeTextToken freeTextToken = (FreeTextToken) token;
					if (freeTextToken.isFreeTextLine()) {
						freeTextToken.setWidth(width - PageFormat.COLLAGE_PADDING);
					}
				}
			}

			ParagraphIndex index = getDocument().getParagraphIndex(id);
			getDocumentLayouter().updateSnippetWidth(getCollagePageIndex(index.getSectionIndex()),
					index.getParagraphIndex(), width, automatic);

			if (paragraph.getTokenCount() != 0) {
				for (int i = paragraph.getTokenCount() - 1; i >= 0; i--) {
					Token token = paragraph.getToken(i);

					if (token instanceof ImageToken || token instanceof VideoToken) {
						documentLayouter.changeTokenBoxMaxWidthInSnippet(token.getId(), width);
					}
				}
			}
		}
	}

	protected void handleDrawParagraphModeChanged(boolean state) {
	}

	protected void handleDeleteCollageModeChanged(boolean state) {
	}

	protected void handleTokenWidthChanged(Id tokenId) {
		getDocumentLayouter().updateTokenBox(tokenId);
		updateTokenMargins();
	}

	protected GWTDocumentLayouter getDocumentLayouter() {
		if (this.documentLayouter == null) {
			initLayouter();
		}
		return documentLayouter;
	}

	protected void setDocumentLayouter(GWTDocumentLayouter documentLayouter) {
		this.documentLayouter = documentLayouter;
	}

	protected void deselectTokens() {
		assert hasTokenSelection() : "Precondition failed: hasTokenSelection()";
		toggleTokenBoxSelectionFromTo(currentCursorTokenId, getFirstSelectedTokenId());
		setFirstSelectedTokenId(null);
	}

	protected void handleInvalidSessionException() {
		documentEditorListener.onInvalidSessionExceptionCaught();
	}

	protected boolean hasTokenSelection() {
		return getFirstSelectedTokenId() != null;
	}

	public void openSignEditotr() {
		assert document.getFirstTokenInDocument() instanceof SignItemToken : "First Token isn't SignItemToken";

		handleEditSign((SignItem) document.getFirstTokenInDocument(), document.getFirstTokenInDocument().getId());
	}

	protected void handleEditSign(final SignItem signItem, final Id tokenId) {
		assert signItem != null : "Precondition failed: signItem != null";
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().getToken(
				tokenId) instanceof SignItemToken : "Precondition failed: getDocument().getToken(tokenId) instanceof SignItemToken";

		if (isValidCursorPosition(tokenId, 0)) {
			setSelectionAndCursorToAbsoluteLeft(tokenId, 0, false);
		}

		String searchWord = ((SignItemToken) getDocument().getToken(tokenId)).getText();
		SignItemToken signItemToken = ((SignItemToken) getDocument().getToken(tokenId));
		SignLocale signLocale = signItemToken.getLocale();
		SignItemEditor signItemEditor;
		if (signItem.hasLocalSign()) {
			signItemEditor = new SignItemEditor(signItem.getLocalSign(), signItemToken.getText());
		} else {
			signItemEditor = new SignItemEditor(signItem.getSignId(), signItem.getSignWidth(), signItemToken.getText());
		}

		documentEditorListener.onEditSign(signItemEditor, signLocale, searchWord, new SignModifiedListener() {
			@Override
			public void onSignLocallyModified(SimpleSign modifiedSign) {
				updateLocallyModifiedSign(modifiedSign, tokenId);
			}

			@Override
			public void onSignModified(SimpleSign modifiedSign) {
				updateModifiedSign(modifiedSign, tokenId);
			}

			@Override
			public void onSignSavedInSignBook(SimpleSign savedSign) {
				assert getDocument().getLocalDictionary()
						.contains(savedSign.getSignId()) : "Local dictionary does not contain the SimpleSign";
				if (getDocument().getLocalDictionary().contains(savedSign.getSignId())) {
					getDocument().getLocalDictionary().remove(savedSign.getSignId());
				}
			}

			@Override
			public void onSaveOrReplaceLocally(SimpleSign modifiedSign) {
				if (getDocument().getLocalDictionary().contains(modifiedSign.getSignId())) {
					updateSignInLocalDictionary(modifiedSign);
				} else {
					saveSignInLocalDictionary(modifiedSign);
				}
			}

			@Override
			public void onDeleteLocalSign(SimpleSign sign) {

				deleteSignFromLocalDictionary(sign);

			}

		});
	}

	protected void deleteSignFromLocalDictionary(SimpleSign sign) {
		getDocument().getLocalDictionary().remove(sign.getSignId());
	}

	protected void handleCopy() {
		CopyToClipboardCompletionListener completionHandler = new CopyToClipboardCompletionListener() {
			@Override
			public void onCopyToClipboardCompleted() {
				focusBoxInUi(currentCursorTokenId);
			}
		};
		copy(completionHandler);
	}

	private void copy(CopyToClipboardCompletionListener completionHandler) {
		clipboard.clear();
		List<ObjectFoundStorage<?>> callbacks = new LinkedList<ObjectFoundStorage<?>>();
		ObjectToClipboardTextHandler objectToClipboardTextHandler = new ObjectToClipboardTextHandler();
		callbacks.add(objectToClipboardTextHandler);
		DocumentPartsToCopyHandler documentPartsToCopyHandler = null;
		if (hasTokenSelection()) {
			Id leftTokenId = getFirstSelectedTokenId();
			Id rightTokenId = currentCursorTokenId;
			documentPartsToCopyHandler = new SectionFoundHandler();
			callbacks.add(documentPartsToCopyHandler);
			copySections(leftTokenId, rightTokenId, callbacks);
		} else if (!selectedParagraphIds.isEmpty()) {
			documentPartsToCopyHandler = new ParagraphFoundStoreInListHandler();
			callbacks.add(documentPartsToCopyHandler);
			copyParagraphs(selectedParagraphIds, callbacks);
		} else {
			return;
		}
		clipboard.setContent(documentPartsToCopyHandler.getResult());
		String textToCopyString = objectToClipboardTextHandler.getResult();
		copyToSystemClipboard(textToCopyString, completionHandler);
		clipboard.setText(textToCopyString);
	}

	protected void handlePaste(Id id, String pastedText, PasteTarget pasteTarget) {
		assert id != null : "Precondition failed: pageId, pastedText != null";
		assert pastedText != null : "Precondition failed: pageId, pastedText != null";
		assert !pastedText.isEmpty() : "Precondition failed: !pastedText.isEmpty()";

		if (!document.isLayoutLocked()) {
			if (!clipboard.isEmpty() && pastedText.equals(clipboard.getText())) {
				List<Object> result = clipboard.getContent();
				paste(id, result, pastedText, pasteTarget);
			} else {
				clipboard.clear();
				String checkedText = removeBreaksFromSnippetLayout(id, pastedText, pasteTarget);
				List<String> tokens = tokenizer.tokenize(checkedText);
				paste(id, tokens, checkedText, pasteTarget);
			}
		}
	}

	// Necessary because of one lined FP paragraphs, removes page and linebreaks
	private String removeBreaksFromSnippetLayout(Id id, String pastedText, PasteTarget pasteTarget) {
		String result = pastedText;
		boolean isTokenInCollage = false;
		if (pasteTarget == PasteTarget.TOKEN) {
			DocumentIndex documentIndex = getDocument().getDocumentIndex(id);
			Section section = getDocument().getSection(documentIndex.getSectionIndex());
			isTokenInCollage = section.isCollage();
		}
		if (pasteTarget == PasteTarget.FP_PAGE || pasteTarget == PasteTarget.FP_PARAGRAPH || isTokenInCollage) {
			result = result.replaceAll(Character.toString(Tokenizer.LINE_BREAK), " ");
			result = result.replaceAll(Character.toString(Tokenizer.PAGE_BREAK), " ");
		}
		return result;
	}

	private void paste(Id id, List<?> pastedTokens, String pastedText, PasteTarget pasteTarget) {
		if (!document.isLayoutLocked()) {
			boolean isAutomaticFreeTextLineEnabled = isAutomaticFreeTextLineEnabled();
			getDocument().setAutomaticFreeTextLineEnabled(false);
			switch (pasteTarget) {
			case FP_PAGE:
				pasteIntoCollage(id, pastedTokens);
				break;
			case FP_PARAGRAPH:
				pasteIntoSnippet(id, pastedTokens);
				break;
			case TOKEN:
				pasteIntoToken(id, pastedTokens, pastedText);
				break;
			default:
				assert false : "Unexpected target: " + pasteTarget;
				break;
			}
			getDocument().setAutomaticFreeTextLineEnabled(isAutomaticFreeTextLineEnabled);
		}
	}

	private void pasteIntoCollage(Id id, List<?> pastedContent) {
		assert id != null : "Precondition failed: id != null";
		assert pastedContent != null : "Precondition failed: pastedContent != null";
		assert pastedContent.size() > 0 : "Precondition failed: pastedContent.size()>0";

		if (!document.isLayoutLocked()) {
			Object firstObject = pastedContent.get(0);
			if (firstObject instanceof Paragraph) {
				// If FPPs are copied then Paragraph is first element otherwise
				// Token is the first element
				pasteParagraphsIntoSection(id, pastedContent);
			} else if (firstObject instanceof Section || firstObject instanceof String) {
				pasteIntoNewSnippet(id, pastedContent);
			}
		}
	}

	private void pasteParagraphsIntoSection(Id sectionId, List<?> pastedContent) {
		assert getDocument().getSectionIndexForCollageId(
				sectionId) >= 0 : "Precondition failed:  getDocument().getSectionIndexForCollageId(sectionId) >=0";

		int sectionIndex = getDocument().getSectionIndexForCollageId(sectionId);
		for (Object element : pastedContent) {
			assert element instanceof Paragraph : "Precondition failed paragraph instanceof Paragraph";
			Paragraph copiedParagraph = (Paragraph) element;
			Paragraph paragraph = cloneParagraph(copiedParagraph);
			paragraph.setPositionX(paragraph.getPositionX() + PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH);
			paragraph.setPositionY(paragraph.getPositionY() + PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH);
			addSnippetToDocument(sectionIndex, paragraph);
		}
	}

	private void pasteIntoNewSnippet(Id id, List<?> tokens) {
		assert getDocumentLayouter().getCollagePageNumber(
				id) > 0 : "Precondition failed: getGwtDocumentLayouter().getCollageNumber(pageId) > 0";
		int sectionIndex = getDocument().getSectionIndexForCollageId(id);
		Paragraph paragraph = createEmptyParagraph();

		pasteTokensIntoParagraphInSection(tokens, sectionIndex, paragraph);
	}

	private void pasteTokensIntoParagraphInSection(List<?> pastedTokens, int sectionIndex, Paragraph paragraph) {
		pasteIntoParagraph(pastedTokens, paragraph);
		pasteParagraphIntoSection(sectionIndex, paragraph);
	}

	private void pasteParagraphIntoSection(int sectionIndex, Paragraph paragraph) {
		addSnippetToDocument(sectionIndex, paragraph);

		Token lastToken = paragraph.getToken(paragraph.getTokenCount() - 1);
		setSelectionAndCursor(lastToken.getId(), 0, false);
	}

	private void pasteIntoSnippet(Id id, List<?> pastedTokens) {
		assert getDocument().containsParagraph(id) : "Precondition failed: document.containsParagraph(id)";
		int sectionIndex;
		Paragraph paragraph;
		Id paragraphId = id;
		paragraph = getDocument().getParagraph(paragraphId);
		while (paragraph.getTokenCount() > 0) {
			paragraph.removeToken(0);
		}
		ParagraphIndex paragraphIndex = getDocument().getParagraphIndex(paragraphId);
		sectionIndex = paragraphIndex.getSectionIndex();
		handleRemoveSnippetFromDocument(paragraphId);
		pasteTokensIntoParagraphInSection(pastedTokens, sectionIndex, paragraph);
	}

	private void pasteIntoParagraph(List<?> elements, Paragraph paragraph) {
		assert elements != null : "Precondition failed: elements != null";
		assert elements.size() > 0 : "Precondition failed: elements.size()>0";
		assert paragraph != null : "Precondition failed: paragraph != null";

		for (Object element : elements) {
			if (element instanceof Section) {
				Section section = (Section) element;
				List<Paragraph> paragraphs = section.getParagraphs();
				pasteIntoParagraph(paragraphs, paragraph);
			} else if (element instanceof Paragraph) {
				Paragraph pastedParagraph = (Paragraph) element;
				List<Token> tokens = new ArrayList<Token>();
				for (Token token : pastedParagraph.getTokens()) {
					tokens.add(tokenFactory.createNewTokenFromToken(token));
				}
				paragraph.insertTokens(tokens, paragraph.getTokenCount());
			} else if (element instanceof Token) {
				Token token = (Token) element;
				paragraph.addToken(token);
			} else if (element instanceof String) {
				String word = (String) element;
				Token token = getTokenFactory().createSignItemToken(word, getDefaultTextbasedTokenStyle(), Color.WHITE,
						currentSignLocale);
				paragraph.addToken(token);
			} else {
				assert false : "Unexpected object was copied";
			}
		}
	}

	private void pasteIntoToken(Id id, List<?> pastedContent, String pastedText) {
		assert getDocument().containsToken(id) : "Precondition failed: getDocument().containsToken(id)";
		assert pastedContent != null : "Precondition failed: pastedContent != null";
		assert pastedContent.size() > 0 : "Precondition failed: pastedContent.size()>0";
		assert pastedText != null : "Precondition failed: pastedText != null";

		boolean isAutomaticFreeTextLineEnabled = getDocument().isAutomaticFreeTextLineEnabled();
		getDocument().setAutomaticFreeTextLineEnabled(false);
		boolean isTokenSelected = isTokenSelected(id);
		Object firstObject = pastedContent.get(0);
		Token targetToken = getDocument().getToken(id);

		if (firstObject instanceof Section) {
			if (isTokenSelected) {
				if (targetToken instanceof TextbasedToken) {
					((TextbasedToken) targetToken).setText("");
				}
			}
			int pastedTextLength = pastedText.length();
			Id firstId = preparePaste(id, pastedTextLength);
			Id currentTokenId = firstId;

			currentTokenId = pasteSections(currentTokenId, pastedContent);

			updateTokensFromTo(firstId, currentTokenId);
			updateSignsFromTo(firstId, currentTokenId);
			cleanUpPaste(firstId, currentTokenId);
		} else if (firstObject instanceof String) {
			assert getDocument().containsToken(id) : "Precondition failed: getDocument().containsToken(id)";

			if (targetToken instanceof TextbasedToken) {
				String textOfTheToken = pastedText;
				int length = 0;
				int cursorPosition = getCursorPosition(id) - pastedText.length();
				length = ((TextbasedToken) targetToken).getText().length();
				String oldText = ((TextbasedToken) targetToken).getText();
				textOfTheToken = oldText.substring(0, cursorPosition) + pastedText + oldText.substring(cursorPosition);
				assert length - cursorPosition >= 0 : "Precondition failed length - cursorPosition >= 0";
				if (isTokenSelected) {
					handleTextChanged(id, pastedText, 0);
				} else {
					handleTextChanged(id, textOfTheToken, length - cursorPosition);
				}
			}
		} else {
			assert false : "Unexpected pastedContent type: " + firstObject;
		}
		getDocument().setAutomaticFreeTextLineEnabled(isAutomaticFreeTextLineEnabled);
	}

	private boolean isTokenSelected(Id id) {
		boolean result = false;
		if (getFirstSelectedTokenId() != null) {
			result = getDocument().isTokenBetween(id, getFirstSelectedTokenId(), currentCursorTokenId);
		}
		return result;
	}

	private Id pasteSections(Id currentTokenId, List<?> pastedContent) {
		for (int i = 0; i < pastedContent.size(); i++) {
			Object object = pastedContent.get(i);
			if (object instanceof Section) {
				Section section = (Section) object;
				boolean firstSection = i == 0;
				if (!section.isEmpty()) {
					currentTokenId = pasteSection(currentTokenId, section, firstSection);
				}
			} else {
				throw new RuntimeException("Invalid Paste Structure");
			}
		}
		return currentTokenId;
	}

	private void updateSignsFromTo(Id from, Id to) {
		List<Token> fromToTokenList = getDocument().getTokensFromTo(from, to);
		updateSigns(fromToTokenList);
	}

	private Id pasteSection(Id currentTokenId, Section section, boolean firstSection) {
		char breakCharOfFirstParagraph;
		char defaultBreakChar;
		Section currentSection = getDocument()
				.getSection(getDocument().getDocumentIndex(currentTokenId).getSectionIndex());
		if (currentSection.isCollage()) {
			breakCharOfFirstParagraph = Tokenizer.BOX_BREAK;
			defaultBreakChar = Tokenizer.BOX_BREAK;
		} else if (firstSection) {
			breakCharOfFirstParagraph = Tokenizer.BOX_BREAK;
			defaultBreakChar = Tokenizer.LINE_BREAK;
		} else {
			breakCharOfFirstParagraph = Tokenizer.PAGE_BREAK;
			defaultBreakChar = Tokenizer.LINE_BREAK;
		}
		return pasteParagraphs(currentTokenId, section.getParagraphs(), breakCharOfFirstParagraph, defaultBreakChar);
	}

	private Id pasteParagraphs(Id currentTokenId, List<Paragraph> paragraphs, char firstBreakChar,
			char defaultBreakChar) {
		Paragraph firstParagraph = paragraphs.get(0);
		Id newTokenId = pasteParagraph(currentTokenId, firstParagraph, firstBreakChar);

		for (int i = 1; i < paragraphs.size(); i++) {
			newTokenId = pasteParagraph(newTokenId, paragraphs.get(i), defaultBreakChar);
		}
		return newTokenId;
	}

	private Id pasteParagraph(Id currentTokenId, Paragraph paragraph, char breakChar) {
		return pasteTokens(currentTokenId, paragraph.getTokens(), breakChar);
	}

	private Id pasteTokens(Id currentTokenId, List<Token> tokens, char breakChar) {
		assert currentTokenId != null : "Precondition failed: currentTokenId != null";
		assert tokens != null : "Precondition failed: tokens != null";
		List<Token> tokensToPaste = new ArrayList<Token>();

		for (Token token : tokens) {
			Token newToken = tokenFactory.createNewTokenFromToken(token);
			if (newToken instanceof SignItemToken) {
				SignItemToken signItemToken = (SignItemToken) newToken;
				if (getDocument().isGlossWritingActive()) {
					String glossText = capitalizeText(signItemToken.getText());
					signItemToken.setText(glossText);
				}
				addNonExistingLocalSignsToDictionary(signItemToken);
			}
			tokensToPaste.add(newToken);
		}

		if (breakChar == Tokenizer.LINE_BREAK || breakChar == Tokenizer.PAGE_BREAK) {
			insertLineOrPageBreakAndTokensAfter(currentTokenId, breakChar, tokensToPaste);
		} else {
			insertTokensAfter(currentTokenId, tokensToPaste);
		}

		return tokensToPaste.get(tokensToPaste.size() - 1).getId();
	}

	@Deprecated
	private void addNonExistingLocalSignsToDictionary(SignItemToken token) {
		LocalDictionary localDictionary = getDocument().getLocalDictionary();
		SignItem signItem = token.getSignItem();
		if (signItem != null && signItem.hasLocalSign() && !localDictionary.contains(signItem.getSignId())) {
			localDictionary.save(signItem.getLocalSign());
		}
	}

	private Id preparePaste(Id id, int pastedTextLength) {
		assert id != null : "Precondition failed: id != null";

		Token token = getDocument().getToken(id);
		Id result = id;

		if (token instanceof TextbasedToken) {
			String text = ((TextbasedToken) token).getText();
			int cursorPosition = getCursorPosition(id) - pastedTextLength;
			int tokenTextLength = text.length();

			if (cursorPosition < tokenTextLength) {

				((TextbasedToken) token).setText(text.substring(cursorPosition));
				Token emptyTokenBeforeToken = getTokenFactory().createSignItemToken(text.substring(0, cursorPosition),
						getDefaultTextbasedTokenStyle(), Color.WHITE, currentSignLocale);

				DocumentIndex documentIndex = getDocument().getDocumentIndex(id);
				Paragraph paragraph = getDocument().getParagraph(documentIndex.getSectionIndex(),
						documentIndex.getParagraphIndex());

				insertTokenBefore(id, emptyTokenBeforeToken, paragraph.isSearchWordLineVisible(),
						paragraph.isSignLineVisible());

				result = emptyTokenBeforeToken.getId();
				updateSigns(token);
				updateTokensFromTo(id, id);
			}
		}
		return result;
	}

	private void cleanUpPaste(Id firstId, Id currentTokenId) {
		Token lastToken = getDocument().getToken(currentTokenId);
		int cursorPosition = 0;
		if (lastToken instanceof TextbasedToken) {
			TextbasedToken textBasedToken = (TextbasedToken) lastToken;
			cursorPosition = textBasedToken.getText().length();
		}
		setSelectionAndCursor(currentTokenId, cursorPosition, false);

		Token token = getDocument().getToken(firstId);
		if (token instanceof TextbasedToken) {
			removeTokenIfEmpty(token);
		}

	}

	protected void handleDeletePrevious(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);

		boolean isPreviousSectionCollage = documentIndex.getSectionIndex() > 0
				&& getDocument().getSection(documentIndex.getSectionIndex() - 1).isCollage();
		boolean isTokenFirstInParagraph = documentIndex.getTokenIndex() == 0 && documentIndex.getParagraphIndex() == 0;
		boolean isFirstTokenAfterCollage = isTokenFirstInParagraph && isPreviousSectionCollage;

		Token lastTokenInSection = getDocument().getSection(documentIndex.getSectionIndex()).getLastTokenInSection();
		Token firstTokenInSection = getDocument().getSection(documentIndex.getSectionIndex()).getFirstTokenInSection();

		boolean isLastTokenInSection;
		if (lastTokenInSection != null) {
			isLastTokenInSection = tokenId.equals(lastTokenInSection.getId());
		} else {
			isLastTokenInSection = false;
		}

		boolean isFirstTokenInSection;
		if (firstTokenInSection != null) {
			isFirstTokenInSection = tokenId.equals(firstTokenInSection.getId());
		} else {
			isFirstTokenInSection = false;
		}

		boolean isOnlyTokenInSection = isLastTokenInSection && isFirstTokenInSection;

		if (!getDocument().isFirstDocumentIndex(documentIndex) && !isFirstTokenAfterCollage) {
			int sectionIndex = documentIndex.getSectionIndex();
			int paragraphIndex = documentIndex.getParagraphIndex();
			int tokenIndex = documentIndex.getTokenIndex();

			boolean isCollage = isTokenInCollage(tokenId);

			if (isCollage) {
				handleDeleteTokenOnCollage(tokenId, sectionIndex, paragraphIndex, tokenIndex, true);
			} else {
				boolean isFirstTokenInParagraph = tokenIndex == 0;
				boolean isFirstParagraphInSection = paragraphIndex == 0;
				if (isFirstTokenInParagraph) {
					if (isFirstParagraphInSection) {
						sectionIndex--;
						assert sectionIndex >= 0 : "sectionIndex >= 0";

						int previousParagraphCount = getDocument().getParagraphCount(sectionIndex);
						getDocument().mergeSectionWithNext(sectionIndex);
						paragraphIndex += previousParagraphCount;
					}
					paragraphIndex--;
					assert paragraphIndex >= 0 : "paragraphIndex >= 0";

					int previousTokenCount = getDocument().getTokenCount(sectionIndex, paragraphIndex);
					getDocument().getSection(sectionIndex).mergeParagraphWithNext(paragraphIndex);
					tokenIndex += previousTokenCount;
				}
				removeLineBreakOrMergeLines(tokenId, sectionIndex, paragraphIndex, tokenIndex, isFirstTokenInParagraph);
			}
		} else if (!getDocument().isFirstDocumentIndex(documentIndex) && isFirstTokenAfterCollage
				&& isOnlyTokenInSection) {

			int sectionIndexOfPreviousCollage = documentIndex.getSectionIndex() - 1;
			int pageNumberToDelete = this.getCollagePageIndex(sectionIndexOfPreviousCollage) + 1;

			deletePageBetweenCollages(documentIndex, pageNumberToDelete);
		}
	}

	private void deletePageBetweenCollages(DocumentIndex documentIndex, int pageNumberToDelete) {
		int previousSectionIndex = getDocument().getPreviousDocumentIndex(documentIndex).getSectionIndex();
		Section previousSection = getDocument().getSection(previousSectionIndex);
		currentCursorTokenId = previousSection.getLastTokenInSection().getId();

		if (!(previousSection.isLayoutLocked() || document.isLayoutLocked())) {
			getDocumentLayouter().removePage(pageNumberToDelete);
			getDocument().removeSection(documentIndex.getSectionIndex());
		}
	}

	/**
	 * @param deletePreviousToken - if <b>true</b> deletes the previous token (backspace), <b>false</b> for deletion of
	 * the succeeding token (ENTF)
	 */
	protected void handleDeleteTokenOnCollage(Id tokenId, int sectionIndex, int paragraphIndex, int tokenIndex,
			boolean deletePreviousToken) {
		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);
		Section section = getDocument().getSection(documentIndex.getSectionIndex());
		boolean isTheOnlyTokenInParagraph = section.getParagraph(documentIndex.getParagraphIndex())
				.getTokenCount() == 1;
		boolean isTheOnlyParagraphInSection = section.getParagraphCount() == 1;
		Token token = getDocument().getToken(tokenId);

		if (!(section.isLayoutLocked() || token.isLayoutLocked() || document.isLayoutLocked())) {
			boolean isTokenEmpty = token instanceof TextbasedToken ? ((TextbasedToken) token).isEmpty() : true;

			if (isTheOnlyTokenInParagraph && isTokenEmpty) {
				DocumentIndex leftTokenIndex = getDocument().getPreviousDocumentIndex(documentIndex);
				Id leftTokenId = getDocument().getToken(leftTokenIndex).getId();
				setSelectionAndCursor(leftTokenId, 0, false);

				if (isTheOnlyParagraphInSection) {
					removeCollage(section.getCollageId());
				} else {
					handleRemoveSnippetFromDocument(section.getParagraph(paragraphIndex).getParagraphId());
				}
			} else {
				if (deletePreviousToken) {
					boolean hasPrevToken = tokenIndex > 0;
					if (hasPrevToken) {
						Id leftTokenId = getDocument().getSection(sectionIndex).getParagraph(paragraphIndex)
								.getToken(tokenIndex - 1).getId();
						mergeTokens(getDocument().getToken(leftTokenId), token, deletePreviousToken);
					}
				} else {
					if (!isTheOnlyTokenInParagraph) {
						boolean hasNextToken = tokenIndex < getDocument().getParagraph(sectionIndex, paragraphIndex)
								.getTokenCount() - 1;
						if (hasNextToken) {
							Id rightTokenId = getDocument().getSection(sectionIndex).getParagraph(paragraphIndex)
									.getToken(tokenIndex + 1).getId();
							mergeTokens(token, getDocument().getToken(rightTokenId), deletePreviousToken);
						}
					}
				}
			}
		}
	}

	private void removeToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: getDocument().containsToken(tokenId)";
		assert !getDocument().isOnlyTokenInParagraph(
				tokenId) : "Precondition failed: !getDocument().isOnlyTokenInParagraph(tokenId)";
		assert !tokenId.equals(currentCursorTokenId) : "Precondition failed: !tokenId.equals(currentCursorTokenId)";
		assert !tokenId
				.equals(getFirstSelectedTokenId()) : "Precondition failed: !tokenId.equals(firstSelectedTokenId)";

		if (!(document.isLayoutLocked() || getDocument().getToken(tokenId).isLayoutLocked())) {
			getDocument().removeToken(tokenId);
			getDocumentLayouter().removeTokenBox(tokenId);
			updateTokenMargins();
			assert !getDocument()
					.containsToken(tokenId) : "Postcondition failed: !getDocument().containsToken(tokenId)";
		}
	}

	private void removeLineBreakOrMergeLines(Id tokenId, int sectionIndex, int paragraphIndex, int tokenIndex,
			boolean shouldPreviousLineBreakBeHandled) {
		tokenIndex--;
		assert tokenIndex >= 0 : "tokenIndex >= 0";
		// Get length of previous text box before merging
		Token leftToken = getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex);
		Token rightToken = getDocument().getToken(tokenId);

		if (shouldPreviousLineBreakBeHandled) {
			Id leftTokenId = leftToken.getId();
			getDocumentLayouter().removeLineBreakAfter(leftTokenId);
		} else {
			mergeTokens(leftToken, rightToken, true);
		}
	}

	private void mergeTokens(Token leftToken, Token rightToken, boolean deletePreviousToken) {

		// Prepare to set cursor position: Get Textlength of previous/left Token
		int prevTokenTextLength = 0;
		if (deletePreviousToken) {
			if (leftToken instanceof TextbasedToken) {
				prevTokenTextLength = ((TextbasedToken) leftToken).getText().length();
			}
		} else {
			if (leftToken instanceof TextbasedToken && rightToken instanceof TextbasedToken) {
				prevTokenTextLength = ((TextbasedToken) leftToken).getText().length();
			}
		}

		if ((leftToken instanceof SignItemToken) && (rightToken instanceof SignItemToken)) {
			leftToken = mergeTwoSignItems((SignItemToken) leftToken);
			setSelectionAndCursorToAbsoluteLeft(leftToken.getId(), prevTokenTextLength, false);
		} else {
			if (deletePreviousToken) {
				removeTokenIfEmpty(rightToken);
				setSelectionAndCursorToAbsoluteLeft(leftToken.getId(), prevTokenTextLength, false);
			} else if (hasNextToken(leftToken.getId())) {
				// remove left token if it is empty, else move cursor
				removeTokenIfEmpty(leftToken);
				setSelectionAndCursorToAbsoluteLeft(rightToken.getId(), 0, false);
			}
		}
	}

	private void removeTokenIfEmpty(Token token) {
		boolean isTokenEmpty = true;
		if (token instanceof TextbasedToken) {
			isTokenEmpty = ((TextbasedToken) token).isEmpty();
		}

		if (isTokenEmpty && !token.isLayoutLocked()) {
			DocumentIndex documentIndex = getDocument().getDocumentIndex(token.getId());
			getDocument().removeToken(documentIndex);
			getDocumentLayouter().removeTokenBox(token.getId());
			updateTokenMargins();
		}
	}

	protected void handleDeleteNext(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);

		handleDeleteNext(tokenId, documentIndex);

	}

	private void handleDeleteNext(Id tokenId, DocumentIndex leftTokenDocumentIndex) {
		int sectionIndex = leftTokenDocumentIndex.getSectionIndex();
		int paragraphIndex = leftTokenDocumentIndex.getParagraphIndex();
		int tokenIndex = leftTokenDocumentIndex.getTokenIndex();

		Section section = getDocument().getSection(sectionIndex);
		Paragraph paragraph = section.getParagraph(paragraphIndex);

		// Remove line or page brake if necessary:
		boolean isLastParagraphInSection = paragraphIndex == getDocument().getParagraphCount(sectionIndex) - 1;
		boolean isLastTokenInParagraph = tokenIndex == getDocument().getTokenCount(sectionIndex, paragraphIndex) - 1;
		boolean isCollage = isTokenInCollage(tokenId);
		boolean isNextSectionCollage = false;

		Token lastTokenInSection = getDocument().getSection(leftTokenDocumentIndex.getSectionIndex())
				.getLastTokenInSection();
		Token firstTokenInSection = getDocument().getSection(leftTokenDocumentIndex.getSectionIndex())
				.getFirstTokenInSection();

		boolean isLastTokenInSection;
		if (lastTokenInSection != null) {
			isLastTokenInSection = tokenId.equals(lastTokenInSection.getId());
		} else {
			isLastTokenInSection = false;
		}

		boolean isFirstTokenInSection;
		if (firstTokenInSection != null) {
			isFirstTokenInSection = tokenId.equals(firstTokenInSection.getId());
		} else {
			isFirstTokenInSection = false;
		}

		boolean isOnlyTokenInSection = isLastTokenInSection && isFirstTokenInSection;

		if (getDocument().getSectionCount() > sectionIndex + 1) {
			isNextSectionCollage = getDocument().getSection(sectionIndex + 1).isCollage();
		}

		if (isCollage) {
			handleDeleteTokenOnCollage(tokenId, sectionIndex, paragraphIndex, tokenIndex, false);
		} else {
			if (isLastTokenInParagraph) {
				if (!(isLastParagraphInSection && isNextSectionCollage)) {
					if (isLastParagraphInSection) {
						getDocument().mergeSectionWithNext(sectionIndex);
					}
					assert paragraphIndex < section.getParagraphCount()
							- 1 : "paragraphIndex < section.getParagraphCount() - 1";

					section.mergeParagraphWithNext(paragraphIndex);

					getDocumentLayouter().removeLineBreakAfter(tokenId);
				} else if (!getDocument().isFirstDocumentIndex(leftTokenDocumentIndex) && isOnlyTokenInSection
						&& isNextSectionCollage) {
					int sectionIndexOfNextCollage = leftTokenDocumentIndex.getSectionIndex() + 1;
					int pageNumberToDelete = this.getCollagePageIndex(sectionIndexOfNextCollage) - 1;

					deletePageBetweenCollages(leftTokenDocumentIndex, pageNumberToDelete);
				}
			} else {
				Token leftToken = paragraph.getToken(tokenIndex);
				Id rightTokenId = getDocument().getSection(sectionIndex).getParagraph(paragraphIndex)
						.getToken(tokenIndex + 1).getId();
				Token rightToken = getDocument().getToken(rightTokenId);
				mergeTokens(leftToken, rightToken, false);
			}
		}
	}

	private SignItemToken mergeTwoSignItems(SignItemToken leftSignItemToken) {
		SignItemToken mergedSignItemToken = leftSignItemToken;
		Id leftTokenId = leftSignItemToken.getId();
		DocumentIndex tokenIndex = getDocument().getDocumentIndex(leftTokenId);

		boolean mergedSignItemsSuccessfully = tryMergeSignItemTokenWithNext(leftTokenId);
		if (mergedSignItemsSuccessfully) {
			mergedSignItemToken = (SignItemToken) getDocument().getToken(tokenIndex);
			getDocumentLayouter().updateTokenBox(mergedSignItemToken.getId());
			updateSigns(mergedSignItemToken);
		}
		assert getDocument().containsToken(mergedSignItemToken
				.getId()) : "Postcondition failed: getDocument().containsToken(mergedSignItemToken.getId())";
		return mergedSignItemToken;
	}

	private boolean tryMergeSignItemTokenWithNext(Id leftTokenId) {
		assert getDocument().containsToken(leftTokenId) : "Precondition failed: getDocument().containsToken(tokenId)";
		assert getDocument()
				.getToken(leftTokenId) instanceof SignItemToken : "Precondition failed: token instanceof SignItemToken";

		DocumentIndex leftTokenDocumentIndex = getDocument().getDocumentIndex(leftTokenId);
		DocumentIndex rightTokenDocumentIndex = getDocument().getNextDocumentIndex(leftTokenDocumentIndex);

		assert !leftTokenDocumentIndex.equals(
				rightTokenDocumentIndex) : "Precondition failed: !leftTokenDocumentIndex.equals(rightTokenDocumentIndex)";

		SignItemToken leftSignItemToken = (SignItemToken) getDocument().getToken(leftTokenId);
		Token rightToken = getDocument().getToken(rightTokenDocumentIndex);
		boolean canMerge = true;
		if (rightToken instanceof SignItemToken) {
			Id tokenToDeleteId = leftTokenId;

			boolean mergeIntoLeftToken = !leftSignItemToken.isEmpty();
			if (mergeIntoLeftToken) {
				SignItemToken rightSignItemToken = (SignItemToken) rightToken;

				String oldWord = leftSignItemToken.getText();
				String oldNextWord = rightSignItemToken.getText();
				String newWord = oldWord + oldNextWord;

				leftSignItemToken.setText(newWord);

				if (!newWord.equals(oldWord)) {
					leftSignItemToken.setSignItem(null);
				}

				tokenToDeleteId = rightSignItemToken.getId();
			}
			if (getCurrentCursorTokenId().equals(tokenToDeleteId)) {
				setCurrentCursorTokenId(mergeIntoLeftToken ? leftTokenId : rightToken.getId());
			}
			removeToken(tokenToDeleteId);
		} else {
			canMerge = false;
		}

		return canMerge;
	}

	private boolean hasNextToken(Id tokenId) {
		DocumentIndex index = getDocument().getDocumentIndex(tokenId);

		boolean result = index.getTokenIndex() + 1 < getDocument().getTokenCount(index.getSectionIndex(),
				index.getParagraphIndex());
		return result;
	}

	protected void handleTextChangedEvent(Id tokenId, String newText, int invertedCursorPosition) {
		if (isTokenInCollage(tokenId)) {
			Token token = getDocument().getToken(tokenId);
			if (token instanceof SignItemToken) {
				newText = newText.replaceAll(Character.toString(Tokenizer.LINE_BREAK), "");
				newText = newText.replaceAll(Character.toString(Tokenizer.PAGE_BREAK), "");
			}
		}
		handleTextChanged(tokenId, newText, invertedCursorPosition);
	}

	protected void handleTextChanged(Id tokenId, String newText, int invertedCursorPosition) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert newText != null : "Precondition failed: newText != null";
		assert invertedCursorPosition >= 0 : "Precondition failed: invertedCursorPosition >= 0";
		assert getDocument()
				.getToken(tokenId) instanceof TextbasedToken : "Precondition failed: token instanceof TextbasedToken";
		// Due to GWT scheduler token could be deleted by the time this handler
		// gets called
		if (getDocument().containsToken(tokenId)) {
			if (getDocument().isGlossWritingActive()) {
				newText = capitalizeText(newText);
			}
			List<String> tokenStrings = tokenizer.tokenize(newText);

			DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);
			Section section = getDocument().getSection(documentIndex.getSectionIndex());
			if (section.isCollage() && (tokenStrings.contains(Character.toString(Tokenizer.LINE_BREAK))
					|| tokenStrings.contains(Character.toString(Tokenizer.PAGE_BREAK)))) {
				return;
			}

			// Collect changed tokens to perform updateSigns in one step
			// (performance)
			List<Token> changedTokens = new ArrayList<Token>();

			// Update first token
			String firstTokenString = tokenStrings.get(0);
			DocumentIndex firstTokenIndex = getDocument().getDocumentIndex(tokenId);
			Token token = getDocument().getToken(firstTokenIndex.getSectionIndex(), firstTokenIndex.getParagraphIndex(),
					firstTokenIndex.getTokenIndex());

			SignItem firstTokenSignItem = null;
			List<Token> tokensToInsert = new ArrayList<Token>();

			if (!(token instanceof SignItemToken))
				return;

			firstTokenSignItem = ((SignItemToken) token).getSignItem();

			SignItemToken firstToken = (SignItemToken) token;
			firstToken.setText(firstTokenString);
			getDocumentLayouter().updateTokenBox(tokenId);
			changedTokens.add(firstToken);

			// Keep SignItem in first token to preserve selected sign
			// alternative
			// when hitting space at the beginning of a text box

			// Insert tokens in blocks that reach from line/page break or first
			// token to next line/page break or last token
			Token lastInsertedToken = token;
			int lastLineOrPageBreakIndex = -1;
			for (int i = 1, tokenStringCount = tokenStrings.size(); i <= tokenStringCount; i++) {
				if (i == tokenStringCount || tokenStrings.get(i).equals(Character.toString(Tokenizer.LINE_BREAK))
						|| tokenStrings.get(i).equals(Character.toString(Tokenizer.PAGE_BREAK))) {
					if (lastLineOrPageBreakIndex > -1) {

						// Exceptional handling to prevent surplus tokens in the
						// document
						// cache the document indices
						DocumentIndex currentIndex = getDocument().getDocumentIndex(lastInsertedToken.getId());
						DocumentIndex previousIndex = currentIndex;
						if (!getDocument().isFirstDocumentIndex(currentIndex)) {
							previousIndex = getDocument().getPreviousDocumentIndex(currentIndex);
						}

						insertLineOrPageBreakAndTokensAfter(lastInsertedToken.getId(),
								tokenStrings.get(lastLineOrPageBreakIndex).charAt(0), tokensToInsert);

						// Exceptional handling to prevent surplus tokens in the
						// document
						// select correct token to move the cursor to
						DocumentIndex index = null;
						if (getDocument().containsToken(lastInsertedToken.getId())) {
							index = getDocument().getNextDocumentIndex(currentIndex);
						} else {
							index = getDocument().getNextDocumentIndex(previousIndex);
						}

						lastInsertedToken = (Token) getDocument().getToken(index.getSectionIndex(),
								index.getParagraphIndex(), index.getTokenIndex());

					} else if (!tokensToInsert.isEmpty()) {
						insertTokensAfter(lastInsertedToken.getId(), tokensToInsert);
					}

					changedTokens.addAll(tokensToInsert);
					if (tokensToInsert.size() > 0 && changedTokens.size() > 0) {
						lastInsertedToken = (Token) changedTokens.get(changedTokens.size() - 1);
					}

					tokensToInsert = new ArrayList<Token>();

					lastLineOrPageBreakIndex = i;
				} else if (token instanceof SignItemToken) {
					if (!token.isLayoutLocked()) {
						// Set SignItem from first token to preserve selected
						// sign
						// alternative when hitting space at the beginning of a
						// text
						// box
						// (will be changed later in other cases)
						tokensToInsert.add(tokenFactory.createSignItemToken(tokenStrings.get(i), firstTokenSignItem,
								((SignItemToken) token).getStyle(), ((SignItemToken) token).getBackgroundColor(),
								currentSignLocale));
					}
				}
			}

			updateSigns(changedTokens);
			if (lastInsertedToken instanceof FreeTextToken) {
				setSelectionAndCursor(lastInsertedToken.getId(), 0, false);
			} else if (lastInsertedToken instanceof SignItemToken) {
				setSelectionAndCursor(lastInsertedToken.getId(),
						((SignItemToken) lastInsertedToken).getText().length() - invertedCursorPosition, false);
			}
		}
	}

	protected ReadOnlyTextbasedTokenStyle getDefaultTextbasedTokenStyle() {
		return textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle();
	}

	protected Color getDefaultBackgroundColor() {
		return Color.WHITE;
	}

	protected TextbasedTokenStyleFactory getTextbasedTokenStyleFactory() {
		return textbasedTokenStyleFactory;
	}

	protected void insertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		if (!isTokenInCollage(tokenId)) {
			boolean automaticFreeTextLineEnabled = isAutomaticFreeTextLineEnabled();

			List<Token> tokenAfterLineBreak = new ArrayList<Token>();

			ReadOnlyTextbasedTokenStyle currentTokenStyle = getTextBasedTokenStyle(tokenId);
			TextbasedTokenStyleFactory tokenStyleFactory = new TextbasedTokenStyleFactory();

			Color backgroundColor = Color.WHITE;
			Token currentToken = getDocument().getToken(tokenId);
			if (currentToken instanceof SignItemToken) {
				backgroundColor = currentToken.getBackgroundColor();
			}
			SignItemToken emptySignItemToken = getTokenFactory().createEmptySignItemToken(
					tokenStyleFactory.createTextbasedTokenStyleFromStyle(currentTokenStyle), backgroundColor,
					currentSignLocale);
			tokenAfterLineBreak.add(emptySignItemToken);
			if (automaticFreeTextLineEnabled) {
				tokenAfterLineBreak.add(getTokenFactory().createFreeTextLineToken(
						tokenStyleFactory.createTextbasedTokenStyleFromStyle(currentTokenStyle)));
				// Disable to ensure correct addition of the new Freetextline by
				// disabling automatic addition of freetextline
				getDocument().setAutomaticFreeTextLineEnabled(false);
			}
			insertLineOrPageBreakAndTokensAfter(tokenId, breakCharacter, tokenAfterLineBreak);
			// resetting the correct value
			getDocument().setAutomaticFreeTextLineEnabled(automaticFreeTextLineEnabled);

			DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);
			DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);
			Token nextToken = getDocument().getToken(nextDocumentIndex.getSectionIndex(),
					nextDocumentIndex.getParagraphIndex(), nextDocumentIndex.getTokenIndex());
			setSelectionAndCursor(nextToken.getId(), 0, false);
		}
	}

	protected ReadOnlyTextbasedTokenStyle getTextBasedTokenStyle(Id tokenId) {
		Token currentToken = getDocument().getToken(tokenId);
		TextbasedToken textbasedToken = (TextbasedToken) currentToken;
		return textbasedToken.getStyle();
	}

	protected void toggleGlossWritingInDocument() {
		Token firstTokenInDocument = document.getFirstTokenInDocument();
		Token lastTokenInDocument = document.getLastTokenInDocument();

		Id firstTokenInDocumentId = firstTokenInDocument.getId();
		Id lastTokenInDocumentId = lastTokenInDocument.getId();

		for (Token token : document.getTokensFromTo(firstTokenInDocumentId, lastTokenInDocumentId)) {

			if (token instanceof SignItemToken) {
				SignItemToken signItemToken = (SignItemToken) token;
				String oldText = signItemToken.getText();
				String toggledText = getDocument().isGlossWritingActive() ? capitalizeText(oldText)
						: oldText.toLowerCase();

				if (!oldText.equals(toggledText)) {
					signItemToken.setText(toggledText);
					getDocumentLayouter().updateTokenBox(token.getId());
				}
			}
		}

		Token token = getDocument().getToken(currentCursorTokenId);
		if (token instanceof SignItemToken) {
			SignItemToken signItemToken = (SignItemToken) token;
			setSelectionAndCursor(currentCursorTokenId, signItemToken.getText().length(), false);
		}
	}

	private String capitalizeText(String textToCapitalize) {

		boolean containsNonCapitalisableChar = false;

		for (char nonCapitalizingChar : nonCapitalizingCharacters) {
			if (textToCapitalize.contains("" + nonCapitalizingChar)) {
				containsNonCapitalisableChar = true;
				break;
			}
		}

		if (!containsNonCapitalisableChar) {
			textToCapitalize = textToCapitalize.toUpperCase();
		} else {
			char newTextAsChars[] = textToCapitalize.toCharArray();

			for (int i = 0; i < newTextAsChars.length; ++i) {
				boolean characterCanBeCapitalised = true;
				for (char nonCapitalizingChar : nonCapitalizingCharacters) {
					if (nonCapitalizingChar == newTextAsChars[i]) {
						characterCanBeCapitalised = false;
						break;
					}
				}
				if (characterCanBeCapitalised) {
					newTextAsChars[i] = Character.toUpperCase(newTextAsChars[i]);
				}
			}
			textToCapitalize = String.valueOf(newTextAsChars);
		}
		return textToCapitalize;
	}

	protected void insertTokensAfter(Id tokenId, List<Token> tokensToInsert) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert tokensToInsert != null : "Precondition failed: tokensToInsert != null";
		assert !tokensToInsert.isEmpty() : "Precondition failed: !tokensToInsert.isEmpty()";

		if (!getDocument().isLayoutLocked()) {
			DocumentIndex tokenIndex = getDocument().getDocumentIndex(tokenId);
			Paragraph paragraph = getDocument().getSection(tokenIndex.getSectionIndex())
					.getParagraph(tokenIndex.getParagraphIndex());

			// Insert tokens backwards
			for (int i = tokensToInsert.size() - 1; i >= 0; i--) {
				insertTokenAfter(tokenId, tokensToInsert.get(i), paragraph.isSearchWordLineVisible(),
						paragraph.isSignLineVisible());
			}
		}
	}

	private void insertTokenAfter(Id tokenId, Token token, boolean seachWordVisible, boolean signsVisible) {
		getDocument().insertTokenAfter(tokenId, token);
		getDocumentLayouter().insertTokenAfter(tokenId, token, seachWordVisible, signsVisible);
		updateTokenMargins();
	}

	protected void updateTokenMargins() {
		List<Token> tokenList = document.getTokensFromTo(document.getFirstTokenInDocument().getId(),
				document.getLastTokenInDocument().getId());
		for (Token t : tokenList) {
			getDocumentLayouter().updateTokenBoxMargin(t.getId());
		}
	}

	protected void insertTokensBefore(Id tokenId, List<Token> tokensToInsert) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert tokensToInsert != null : "Precondition failed: tokensToInsert != null";
		assert !tokensToInsert.isEmpty() : "Precondition failed: !tokensToInsert.isEmpty()";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);
		Paragraph paragraph = getDocument().getParagraph(documentIndex.getSectionIndex(),
				documentIndex.getParagraphIndex());
		// Insert tokens backwards
		for (int i = tokensToInsert.size() - 1; i >= 0; i--) {
			Token newToken = tokensToInsert.get(i);
			insertTokenBefore(tokenId, newToken, paragraph.isSearchWordLineVisible(), paragraph.isSignLineVisible());
		}
	}

	private void insertTokenBefore(Id tokenId, Token newToken, boolean seachWordVisible, boolean signsVisible) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert newToken != null : "Precondition failed: newToken!= null";

		// Insert token into document
		getDocument().insertTokenBefore(newToken, tokenId);

		// Insert token into layout/ui
		getDocumentLayouter().insertTokenBefore(tokenId, newToken, seachWordVisible, signsVisible);
	}

	private void insertLineOrPageBreakAndTokensAfter(Id tokenId, char breakChar, List<Token> tokensToInsert) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert tokensToInsert != null : "Precondition failed: tokensToInsert != null";
		assert !tokensToInsert.isEmpty() : "Precondition failed: !tokensToInsert.isEmpty()";
		assert breakChar == Tokenizer.LINE_BREAK
				|| breakChar == Tokenizer.PAGE_BREAK : "Precondition failed: breakChar == Tokenizer.LINE_BREAK || breakChar == Tokenizer.PAGE_BREAK";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);
		Section section = getDocument().getSection(documentIndex.getSectionIndex());
		Paragraph paragraph = getDocument().findParagraphForToken(tokenId);
		boolean isLastTokenIdInParagraph = documentIndex.getTokenIndex() == paragraph.getTokenCount() - 1;

		FreeTextToken oldFreeTextLine = null;
		Token lastTokenInParagraph = paragraph.getToken(paragraph.getTokenCount() - 1);
		if (lastTokenInParagraph instanceof FreeTextToken) {
			oldFreeTextLine = (FreeTextToken) lastTokenInParagraph;
			oldFreeTextLine = oldFreeTextLine.isFreeTextLine() ? oldFreeTextLine : null;
		}

		if (!(isLastTokenIdInParagraph && tokensToInsert.isEmpty())) {
			insertTokensAfter(tokenId, tokensToInsert);

			Paragraph newParagraph = new Paragraph(idFactory.createId());
			paragraph.moveTokensToParagraph(newParagraph, documentIndex.getTokenIndex() + 1);
			section.insertParagraph(newParagraph, documentIndex.getParagraphIndex() + 1);
			switch (breakChar) {
			case Tokenizer.LINE_BREAK:
				getDocumentLayouter().insertLineBreakAfter(tokenId);
				break;
			case Tokenizer.PAGE_BREAK:
				Section newSection = new Section();
				section.moveParagraphsToSection(newSection, documentIndex.getParagraphIndex() + 1);
				getDocument().insertSection(newSection, documentIndex.getSectionIndex() + 1);
				getDocumentLayouter().insertPageBreakAfter(tokenId);
				break;
			default:
				throw new RuntimeException("Unexpected Line/PageBreak Characker");
			}
			if (isAutomaticFreeTextLineEnabled()) {
				Token token = getDocument().getToken(tokenId);
				if (!(token instanceof FreeTextToken && ((FreeTextToken) token).isFreeTextLine())) {
					ReadOnlyTextbasedTokenStyle textbasedTokenStyle = getTextBasedTokenStyleOfNextFreeTextLineToken(
							paragraph, token);
					Token freeTextLineToken = getTokenFactory().createFreeTextLineToken(textbasedTokenStyle);
					insertTokenAfter(tokenId, freeTextLineToken, paragraph.isSearchWordLineVisible(),
							paragraph.isSignLineVisible());
					if (oldFreeTextLine != null) {
						copyFreeTextLineToNewFreeTextLine((FreeTextToken) freeTextLineToken, oldFreeTextLine);
						clearFreeTextLineStyleAndText(oldFreeTextLine);
					}
				}
			}
		}
	}

	protected ReadOnlyTextbasedTokenStyle getTextBasedTokenStyleOfNextFreeTextLineToken(Paragraph concernedParagraph,
			Token afterThisToken) {
		FreeTextToken nextFreeTextLineToken = concernedParagraph.getFreeTextLineTokenAfter(afterThisToken);
		ReadOnlyTextbasedTokenStyle defaultStyle = getDefaultTextbasedTokenStyle();
		if (nextFreeTextLineToken != null) {
			defaultStyle = nextFreeTextLineToken.getStyle();
		}
		return defaultStyle;
	}

	private void clearFreeTextLineStyleAndText(FreeTextToken oldFreeTextLine) {

		oldFreeTextLine.setText("");
		oldFreeTextLine.setBackgroundColor(oldFreeTextLine.getBackgroundColor());
		Color fontColor = oldFreeTextLine.getFontColor();

		ReadOnlyTextbasedTokenStyle createDefaultTextbasedTokenStyle = textbasedTokenStyleFactory
				.createDefaultTextbasedTokenStyle();
		tokenStyleTool.copyTextbasedStyleToToken(createDefaultTextbasedTokenStyle, oldFreeTextLine);

		tokenStyleTool.changeFontColorTo(fontColor, oldFreeTextLine);

		getDocumentLayouter().updateTokenBox(oldFreeTextLine.getId());
	}

	private void copyFreeTextLineToNewFreeTextLine(FreeTextToken newFreeTextLine, FreeTextToken oldFreeTextLine) {
		assert newFreeTextLine != null : "Precondition failed: newFreeTextLine != null";
		assert oldFreeTextLine != null : "Precondition failed: oldFreeTextLine != null";
		assert document.containsToken(
				newFreeTextLine.getId()) : "Precondition failed: document.containsToken(newFreeTextLine.getId())";
		assert document.containsToken(
				oldFreeTextLine.getId()) : "Precondition failed: document.containsToken(newFreeTextLine.getId())";

		ReadOnlyTextbasedTokenStyle style = oldFreeTextLine.getStyle();

		newFreeTextLine.setBackgroundColor(oldFreeTextLine.getBackgroundColor());
		newFreeTextLine.setText(oldFreeTextLine.getText());
		tokenStyleTool.changeFontColorTo(oldFreeTextLine.getFontColor(), newFreeTextLine);
		tokenStyleTool.changeFontTo(style.getFont(), newFreeTextLine);
		tokenStyleTool.changeFontStyleTo(style.getFontStyle(), newFreeTextLine);
		tokenStyleTool.changeFontWeightTo(style.getFontWeight(), newFreeTextLine);
		tokenStyleTool.changeFontSizeTo(style.getFontSize(), newFreeTextLine);

		getDocumentLayouter().updateTokenBox(newFreeTextLine.getId());
	}

	private Section insertNewSectionAndMoveParagraphsAfter(DocumentIndex tokenIndex, int nextParagraphIndex) {
		Section newSection = new Section();
		Section section = getDocument().getSection(tokenIndex.getSectionIndex());
		getDocument().insertSection(newSection, tokenIndex.getSectionIndex() + 1);

		// Move paragraphs to new section if it's not the last paragraph:
		if (tokenIndex.getParagraphIndex() < section.getParagraphCount() - 1) {
			section.moveParagraphsToSection(newSection, nextParagraphIndex);
		}

		// Continue with new section and new paragraph index:
		section = newSection;
		return section;
	}

	private FreeTextToken createAutomaticFreeTextLine(Token insertAfter, boolean fromFreeText) {
		FreeTextToken freeTextToken = (FreeTextToken) getTokenFactory()
				.createFreeTextLineToken(getDefaultTextbasedTokenStyle());
		if (fromFreeText) {
			getDocument().insertTokenAfter(insertAfter.getId(), freeTextToken);
			getDocumentLayouter().insertTokenAfter(insertAfter.getId(), freeTextToken, true, true);
		} else {
			DocumentIndex tokenIndex = getDocument().getDocumentIndex(insertAfter.getId());
			Section section = getDocument().getSection(tokenIndex.getSectionIndex());
			Paragraph paragraph = section.getParagraph(tokenIndex.getParagraphIndex());
			if (paragraph.getToken(paragraph.getTokenCount() - 1) instanceof FreeTextToken) {
				FreeTextToken oldFreeTextToken = (FreeTextToken) paragraph.getToken(paragraph.getTokenCount() - 1);
				freeTextToken.setText(oldFreeTextToken.getText());
				tokenStyleTool.copyTextbasedTokenStyleFromTokenToToken(oldFreeTextToken, freeTextToken);
				oldFreeTextToken.setText("");
				getDocumentLayouter().updateTokenBox(oldFreeTextToken.getId());
			}

			getDocument().insertTokenAfter(insertAfter.getId(), freeTextToken);
			getDocumentLayouter().insertTokenAfter(insertAfter.getId(), freeTextToken, true, true);
		}
		return freeTextToken;
	}

	protected void handleSignAlternativeChanged(Id tokenId, SignItem signItem, int selectedSignIndex) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		Token token = getDocument().getToken(tokenId);
		assert token instanceof SignItemToken : "Precondition failed: token instanceof SignItemToken";

		((SignItemToken) token).setSignItem(signItem);

		getDocumentLayouter().changeSignAlternativeFor(tokenId, selectedSignIndex);
	}

	protected void handleFreeTextVisibilityChanged(Id freeTextTokenId, boolean visible) {
		assert freeTextTokenId != null : "Precondition failed: paragraphId != null";

		getDocument().findParagraphForToken(freeTextTokenId).setFreeTextLineVisible(visible);
		getDocumentLayouter().setFreeTextBoxVisibility(freeTextTokenId, visible);

		onFreeTextVisibilityChanged();
	}

	protected void handleVideoURLVisibilityChanged(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: videoTokenId != null";

		getDocumentLayouter().setVideoTokenBoxVisibility(tokenId, visible);
	}

	protected void handleFreeTextChanged(Id tokenId, String freeText, int cursorPosition) {
		assert tokenId != null : "Precondition failed: paragraphId != null";
		assert freeText != null : "Precondition failed: freeText != null";
		assert getDocument()
				.getToken(tokenId) instanceof FreeTextToken : "Precondition failed : token instanceof FreeTextToken";

		FreeTextToken freeTextToken = (FreeTextToken) getDocument().getToken(tokenId);
		freeTextToken.setText(freeText);
		getDocumentLayouter().updateTokenBox(tokenId);
		setSelectionAndCursor(tokenId, cursorPosition, false);
	}

	protected void handleFormInputChanged(Id tokenId, String inputContent, int cursorPosition) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert inputContent != null : "Precondition failed: inputContent != null";
		assert getDocument()
				.getToken(tokenId) instanceof FormToken : "Precondition failed : token instanceof FormToken";

		FormToken formToken = (FormToken) getDocument().getToken(tokenId);
		formToken.setText(inputContent);
		getDocumentLayouter().updateTokenBox(tokenId);
		setSelectionAndCursor(tokenId, cursorPosition, false);
	}

	protected void handleSuggestBoxHeightChanged(Id tokenId, int newHeight) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().getToken(tokenId) instanceof TagToken : "Precondition failed : token instanceof TagToken";

		TagToken tagToken = (TagToken) getDocument().getToken(tokenId);
		tagToken.setHeight(newHeight);
		getDocumentLayouter().updateTokenBox(tokenId);
	}

	protected void handleSearchWordVisibilityChanged(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		getDocumentLayouter().setSearchWordVisibility(tokenId, visible);

		onSearchWordVisibilityChanged();
	}

	void handleSignVisibilityChanged(Id tokenId, boolean visible) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		getDocumentLayouter().setSignVisibility(tokenId, visible);

		onSignVisibilityChanged();
	}

	protected void handleMoveCursorToNextBox(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);

		if (!getDocument().isLastDocumentIndex(documentIndex)) {
			DocumentIndex nextDocumentIndex = getDocument().getNextDocumentIndex(documentIndex);

			setSelectionAndCursorToAbsoluteLeft(getDocument().getToken(nextDocumentIndex.getSectionIndex(),
					nextDocumentIndex.getParagraphIndex(), nextDocumentIndex.getTokenIndex()).getId(), 0, select);
		}
	}

	protected void handleMoveCursorToPreviousBox(Id tokenId, boolean interactionPreviousWord, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenId);

		if (!getDocument().isFirstDocumentIndex(documentIndex)) {
			DocumentIndex previousDocumentIndex = getDocument().getPreviousDocumentIndex(documentIndex);
			Token previousToken = getDocument().getToken(previousDocumentIndex.getSectionIndex(),
					previousDocumentIndex.getParagraphIndex(), previousDocumentIndex.getTokenIndex());

			int cursorPositionInToken = 0;
			if (interactionPreviousWord) {
				if (previousToken instanceof TextbasedToken) {
					cursorPositionInToken = ((TextbasedToken) previousToken).getText().length();
				}
			} else {
				if (previousToken instanceof FreeTextToken) {
					String freeText = ((FreeTextToken) previousToken).getText();
					int lastIndexOfSpaceChar = freeText.lastIndexOf(' ');
					int lastIndexOfLineBreakChar = freeText.lastIndexOf('\n');
					int lastPositionOfWhiteSpace = lastIndexOfSpaceChar > lastIndexOfLineBreakChar
							? lastIndexOfSpaceChar
							: lastIndexOfLineBreakChar;
					cursorPositionInToken = lastPositionOfWhiteSpace >= 0 ? lastPositionOfWhiteSpace + 1 : 0;
				}
			}
			setSelectionAndCursorToAbsoluteLeft(previousToken.getId(), cursorPositionInToken, select);
		}
	}

	protected void handleMoveCursorLineDown(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		cursorAbsoluteLeft = getCursorLeft(tokenId);

		boolean isCurrentTokenInCollage = getDocument()
				.getSection(getDocument().getDocumentIndex(tokenId).getSectionIndex()).isCollage();

		if (!getDocumentLayouter().isInLastTokenBoxLine(tokenId)) {
			CursorPosition cursorPositionBelow = getDocumentLayouter().getCursorPositionBelow(tokenId,
					cursorAbsoluteLeft);
			Id tokenIdBelow = cursorPositionBelow.getTokenId();
			int positionInTokenBelow = cursorPositionBelow.getPositionInToken();

			setSelectionAndCursor(tokenIdBelow, positionInTokenBelow, select);
		}
	}

	protected void handleMoveCursorLineUp(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		cursorAbsoluteLeft = getCursorLeft(tokenId);

		boolean isCurrentTokenInCollage = getDocument()
				.getSection(getDocument().getDocumentIndex(tokenId).getSectionIndex()).isCollage();

		if (!getDocumentLayouter().isInFirstTokenBoxLine(tokenId)) {
			CursorPosition cursorPositionAbove = getDocumentLayouter().getCursorPositionAbove(tokenId,
					cursorAbsoluteLeft);
			Id tokenIdAbove = cursorPositionAbove.getTokenId();
			int positionInTokenAbove = cursorPositionAbove.getPositionInToken();

			setSelectionAndCursor(tokenIdAbove, positionInTokenAbove, select);
		}
	}

	protected void handleMoveCursorToLineStart(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		Id firstTokenIdInLine = getDocumentLayouter().getFirstTokenIdInLine(tokenId);
		int newCursorPosition = 0;

		setSelectionAndCursorToAbsoluteLeft(firstTokenIdInLine, newCursorPosition, select);
	}

	protected void handleMoveCursorToLineEnd(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		Id lastTokenIdInLine = getDocumentLayouter().getLastTokenIdInLine(tokenId);
		Token token = getDocument().getToken(lastTokenIdInLine);

		int cursorPosition = 0;

		if (token instanceof TextbasedToken) {
			cursorPosition = ((TextbasedToken) token).getText().length();
		} else if (token instanceof VideoToken) {
			cursorPosition = ((VideoToken) token).getUrl().length();
		} else if (token instanceof ImageToken) {
			cursorPosition = ((ImageToken) token).getUrl().length();
		}

		setSelectionAndCursorToAbsoluteLeft(lastTokenIdInLine, cursorPosition, select);
	}

	protected void handleMoveCursorToNextPage(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		if (!getDocumentLayouter().isOnLastPageWithTokenBoxes(tokenId)) {
			setSelectionAndCursorToAbsoluteLeft(getDocumentLayouter().getNextTokenIdNotOnThisPage(tokenId), 0, select);
		}
	}

	protected void handleMoveCursorToPreviousPage(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		if (!getDocumentLayouter().isOnFirstPageWithTokenBoxes(tokenId)) {
			setSelectionAndCursorToAbsoluteLeft(getDocumentLayouter().getFirstTokenIdFromPreviousPage(tokenId), 0,
					select);
		}
	}

	protected void handleMoveCursorToNextParagraph(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		ParagraphIndex paragraphIndex = getDocument().getDocumentIndex(tokenId).getParagraphIndexObject();

		Paragraph currentParagraph = getDocument().getParagraph(paragraphIndex);
		Token tokenInParagraph = currentParagraph.getToken(currentParagraph.getTokenCount() - 1);
		Id tokenIdInParagraph = tokenInParagraph.getId();

		int cursorIndex = 0;
		if (tokenInParagraph instanceof SignItemToken) {
			cursorIndex = ((SignItemToken) tokenInParagraph).getText().length();
		}

		if (!getDocument().isLastParagraphIndex(paragraphIndex)) {
			ParagraphIndex nextParagraphIndex = getDocument().getNextParagraphIndex(paragraphIndex);

			if (getDocument().getSection(nextParagraphIndex.getSectionIndex()).isCollage()) {
				tokenIdInParagraph = currentParagraph.getLastTokenInParagraph().getId();
			} else {
				Paragraph paragraph = getDocument().getParagraph(nextParagraphIndex);
				tokenIdInParagraph = paragraph.getToken(0).getId();
			}
			cursorIndex = 0;
		}
		setSelectionAndCursorToAbsoluteLeft(tokenIdInParagraph, cursorIndex, select);
	}

	protected void handleMoveCursorToDocumentTop(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		setSelectionAndCursorToAbsoluteLeft(getDocument().getSection(0).getParagraph(0).getToken(0).getId(), 0, select);
	}

	protected void handleMoveCursorToDocumentEnd(Id tokenId, boolean select) {
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		int sectionIndex = getDocument().getSectionCount();
		Section lastSection = null;
		do {
			sectionIndex--;
			lastSection = getDocument().getSection(sectionIndex);
		} while (lastSection.isEmpty());
		Paragraph lastParagraph = lastSection.getParagraph(lastSection.getParagraphCount() - 1);
		Token lastToken = lastParagraph.getToken(lastParagraph.getTokenCount() - 1);

		int cursorIndex = 0;
		if (lastToken instanceof TextbasedToken) {
			cursorIndex = ((TextbasedToken) lastToken).getText().length();
		}

		setSelectionAndCursorToAbsoluteLeft(lastToken.getId(), cursorIndex, select);
	}

	protected boolean handleMoveCursorToPreviousParagraph(Id tokenId, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		ParagraphIndex paragraphIndex = getDocument().getDocumentIndex(tokenId).getParagraphIndexObject();
		boolean isFirstParagraphIndex = getDocument().isFirstParagraphIndex(paragraphIndex);

		// Move cursor to first token of current paragraph if we are in first
		// paragraph:
		Id tokenInParagraphId = getDocument().getParagraph(paragraphIndex).getToken(0).getId();

		if (!isFirstParagraphIndex) {
			ParagraphIndex previousParagraphIndex = getDocument().getPreviousParagraphIndex(paragraphIndex);
			tokenInParagraphId = getDocument().getParagraph(previousParagraphIndex).getToken(0).getId();
		}

		setSelectionAndCursorToAbsoluteLeft(tokenInParagraphId, 0, select);
		return isFirstParagraphIndex;
	}

	protected boolean handleEventForTokenSelection(Id tokenId, boolean textChanged) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		boolean performDefaultHandling = true;

		if (hasTokenSelection()) {
			// If selection made via keyboard, swap first and focused token to
			// keep event firing token

			if (!tokenId.equals(getFirstSelectedTokenId())) {
				Id temp = getFirstSelectedTokenId();
				setFirstSelectedTokenId(currentCursorTokenId);
				currentCursorTokenId = temp;
			}

			performDefaultHandling = false;
			removeSelectedTokens(textChanged);
		}
		return performDefaultHandling;
	}

	private boolean isTokenInCollage(Id tokenID) {
		DocumentIndex documentIndex = getDocument().getDocumentIndex(tokenID);
		Section section = getDocument().getSection(documentIndex.getSectionIndex());

		return section.isCollage();
	}

	protected boolean handleCut() {
		boolean performDefaultHandling = true;
		if (hasTokenSelection()) {
			CopyToClipboardCompletionListener copyToClipboardCompletionListener = new CopyToClipboardCompletionListener() {
				@Override
				public void onCopyToClipboardCompleted() {
					removeSelectedTokens(true);
					focusBoxInUi(currentCursorTokenId);
				}
			};
			copy(copyToClipboardCompletionListener);
			performDefaultHandling = false;
		}
		return performDefaultHandling;
	}

	protected void updateSigns(final List<Token> tokens) {
		assert tokens != null : "Precondition failed: tokens != null";

		List<String> words = new ArrayList<String>();
		List<SignLocale> locales = new ArrayList<SignLocale>();
		final List<SignItemToken> signItemTokens = new ArrayList<SignItemToken>();
		for (Token token : tokens) {
			if (token instanceof SignItemToken) {
				SignItemToken signItemToken = (SignItemToken) token;
				SignLocale locale = signItemToken.getLocale();
				String tokenWord = signItemToken.getText().toLowerCase();

				int indexOfWord = words.indexOf(tokenWord);

				if (indexOfWord == -1 || locales.get(indexOfWord) != locale) {
					words.add(tokenWord);
					locales.add(locale);
				}
				signItemTokens.add(signItemToken);
			}
		}
		if (!words.isEmpty()) {
			dictionaryService.findSigns(words, locales,
					new SignWritingCallback<Map<String, List<SignItem>>>(I18N.getErrorOnLoadingSigns()) {
						@Override
						public void onSuccess(Map<String, List<SignItem>> result) {
							for (SignItemToken token : signItemTokens) {
								String word = token.getText();
								List<SignItem> signItemsForWord = new ArrayList<SignItem>();
								int selectedSignIndex = 0;

								// Check if word became empty and did not change
								// while
								// processing server call
								if (!word.isEmpty() && result.containsKey(word.toLowerCase())) {
									List<SignItem> resultSignItems = new ArrayList<SignItem>(
											result.get(word.toLowerCase()));

									for (SignItem signItem : resultSignItems) {
										if (token.getLocale().equals(signItem.getSignId().getSignLocale())) {
											signItemsForWord.add(signItem);
										}
									}

								} else if (token.getSignItem() == null || !token.getSignItem().hasLocalSign()) {
									// Empty word doesn't contain signs
									token.setSignItem(null);
								}

								// Local Dictionary request
								signItemsForWord.addAll(getDocument().getLocalDictionary().findSignsIgnoreCase(word));
								selectedSignIndex = findIndexForSignIdInToken(token, signItemsForWord);

								if (getDocumentLayouter().containsTokenBox(token.getId())) {
									getDocumentLayouter().updateSignsInTokenBox(token.getId(), signItemsForWord,
											selectedSignIndex);
									getDocumentLayouter().updateTokenBoxMargin(token.getId());
								}
							}
						}

					});
		}
	}

	protected void updateSigns(final Token token) {
		assert token != null : "Precondition failed: token != null";

		ArrayList<Token> list = new ArrayList<Token>();
		list.add(token);
		updateSigns(list);
	}

	protected void setCursorAbsoluteLeft(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";
		assert getDocument()
				.getToken(tokenId) instanceof TextbasedToken : "Precondition failed : token instanceof TextbasedToken";

		cursorAbsoluteLeft = getCursorLeft(tokenId);
	}

	private void select(Id originTokenId, Id targetTokenId) {
		DocumentIndex originDocumentIndex = getDocument().getDocumentIndex(originTokenId);
		DocumentIndex targetDocumentIndex = getDocument().getDocumentIndex(targetTokenId);

		int originSectionIndex = originDocumentIndex.getSectionIndex();
		int targetSectionIndex = targetDocumentIndex.getSectionIndex();
		int originParagraphIndex = originDocumentIndex.getParagraphIndex();
		int targetParagraphIndex = targetDocumentIndex.getParagraphIndex();

		boolean isOriginSectionCollage = getDocument().getSection(originSectionIndex).isCollage();
		boolean isTargetSectionCollage = getDocument().getSection(targetSectionIndex).isCollage();
		boolean areTokensInSameSection = originSectionIndex == targetSectionIndex;
		boolean areTokensInSameParagraph = originParagraphIndex == targetParagraphIndex && areTokensInSameSection;

		if (isOriginSectionCollage && isTargetSectionCollage && !areTokensInSameParagraph) {
			setSelectionInCollages(originDocumentIndex, targetDocumentIndex);
		} else if (isOriginSectionCollage && !isTargetSectionCollage) {
			selectSnippet(originDocumentIndex);
		} else if (!isOriginSectionCollage && isTargetSectionCollage) {
			// allow selecting collages and normal Sections when Ctrl+A
			// is pressed
			if (getDocument().isFirstDocumentIndex(originDocumentIndex)
					&& getDocument().isLastDocumentIndex(targetDocumentIndex)) {
				selectTokensFromTo(originTokenId, targetTokenId);
			} else {
				if (targetSectionIndex > originSectionIndex) {
					Id lastTokenIdInOriginSection = getDocument().getSection(originSectionIndex).getLastTokenInSection()
							.getId();
					selectTokensFromTo(originTokenId, lastTokenIdInOriginSection);

				} else {
					Id firstTokenIdInOriginSection = getDocument().getSection(originSectionIndex)
							.getFirstTokenInSection().getId();
					selectTokensFromTo(originTokenId, firstTokenIdInOriginSection);
				}

			}
		}
		// either they are in the same paragraph or they are not in a free
		// positioned section
		else {
			selectTokensFromTo(originTokenId, targetTokenId);
		}
	}

	private void setSelectionInCollages(DocumentIndex fromDocumentIndex, DocumentIndex toDocumentIndex) {
		if (hasTokenSelection()) {
			deselectTokens();
		}

		int fromSectionIndex = fromDocumentIndex.getSectionIndex();
		int fromParagraphIndex = fromDocumentIndex.getParagraphIndex();
		int toSectionIndex = toDocumentIndex.getSectionIndex();
		int toParagraphIndex = toDocumentIndex.getParagraphIndex();

		Paragraph fromParagraph = getDocument().getParagraph(fromSectionIndex, fromParagraphIndex);
		Paragraph toParagraph = getDocument().getParagraph(toSectionIndex, toParagraphIndex);
		handleToggleSnippetSelection(fromParagraph.getParagraphId(), false);
		handleToggleSnippetSelection(toParagraph.getParagraphId(), true);
	}

	private void selectSnippet(DocumentIndex documentIndex) {
		if (hasTokenSelection()) {
			deselectTokens();
		}

		int sectionIndex = documentIndex.getSectionIndex();
		int paragraphIndex = documentIndex.getParagraphIndex();

		Paragraph paragraph = getDocument().getParagraph(sectionIndex, paragraphIndex);
		handleToggleSnippetSelection(paragraph.getParagraphId(), false);
	}

	private void selectTokensFromTo(Id fromTokenId, Id toTokenId) {
		if (hasTokenSelection()) {
			deselectTokens();
		}

		currentCursorTokenId = fromTokenId;
		setSelectionAndCursor2(toTokenId, 0, true);
	}

	private void setSelectionAndCursor(Id tokenId, int positionInToken, boolean select) {
		if (select) {
			Id fromTokenId = null;
			if (hasTokenSelection()) {
				fromTokenId = getFirstSelectedTokenId();
			} else {
				fromTokenId = currentCursorTokenId;
			}
			select(fromTokenId, tokenId);
		} else {
			setSelectionAndCursor2(tokenId, positionInToken, select);
		}
	}

	// wenn select gesetzt ist wird selektriert, sonst wird deselektiert
	private void setSelectionAndCursor2(Id tokenId, int positionInToken, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: getDocument().containsToken(tokenId)";

		Id oldCursorId = currentCursorTokenId;

		// wenn bereits etwas selektiert war deselektiere es
		if (hasTokenSelection()) {
			toggleTokenBoxSelectionFromTo(getFirstSelectedTokenId(), oldCursorId);
		}
		if (select) {
			if (!hasTokenSelection()) {
				setFirstSelectedTokenId(oldCursorId);

				if (getDocument().getToken(oldCursorId) instanceof FrameToken) {
					toggleTokenBoxSelection(oldCursorId);
				}
			}

			currentCursorTokenId = tokenId;
			toggleTokenBoxSelectionFromTo(getFirstSelectedTokenId(), tokenId);
			focusBoxInUi(tokenId);
		}
		// deselect
		else {
			// wenn FrameToken selektiert ist
			if (oldCursorId != null && getDocument().containsToken(oldCursorId)
					&& getDocument().getToken(oldCursorId) instanceof FrameToken && isFrameSelected(oldCursorId)) {
				toggleTokenBoxSelection(oldCursorId);
			}
			currentCursorTokenId = tokenId;

			if (getDocument().getToken(tokenId) instanceof TextbasedToken) {
				assert isValidCursorPosition(tokenId,
						positionInToken) : "Precondition failed: isValidCursorPosition(tokenId, positionInToken)";
				setCursorPositionInUi(tokenId, positionInToken);
			} else if (getDocument().getToken(tokenId) instanceof FrameToken && !isFrameSelected(tokenId)) {
				toggleTokenBoxSelection(tokenId);
			} else if (getDocument().getToken(tokenId) instanceof VideoToken
					|| getDocument().getToken(tokenId) instanceof ImageToken) {
				focusBoxInUi(tokenId);
			}

			if (hasTokenSelection()) {
				setFirstSelectedTokenId(null);
			}
		}
		cursorAbsoluteLeft = getCursorLeft(currentCursorTokenId);
	}

	protected void setSelectionAndCursorToAbsoluteLeft(Id tokenId, int positionInToken, boolean select) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: getDocument().containsToken(tokenId)";

		setSelectionAndCursor(tokenId, positionInToken, select);
		if (getDocument().getToken(tokenId) instanceof TextbasedToken) {
			setCursorAbsoluteLeft(tokenId);
		}

	}

	private void copySections(Id leftTokenId, Id rightTokenId, List<ObjectFoundStorage<?>> sectionFoundHandlers) {
		DocumentIndex leftDocumentIndex = getDocument().getDocumentIndex(leftTokenId);
		DocumentIndex rightDocumentIndex = getDocument().getDocumentIndex(rightTokenId);

		// Swap ids and indexes if necessary:
		int compareResult = leftDocumentIndex.compareTo(rightDocumentIndex);
		if (compareResult > 0) {
			// Swap indexes:
			DocumentIndex tempIndex = rightDocumentIndex;
			rightDocumentIndex = leftDocumentIndex;
			leftDocumentIndex = tempIndex;
			// Swap ids:
			Id tempId = rightTokenId;
			rightTokenId = leftTokenId;
			leftTokenId = tempId;
		}

		int leftSectionIndex = leftDocumentIndex.getSectionIndex();
		int leftParagraphIndex = leftDocumentIndex.getParagraphIndex();
		int leftTokenIndex = leftDocumentIndex.getTokenIndex();

		int rightTokenIndex = rightDocumentIndex.getTokenIndex();
		int rightParagraphIndex = rightDocumentIndex.getParagraphIndex();
		int rightSectionIndex = rightDocumentIndex.getSectionIndex();

		// Build Structure to Store TokensAndParagraphs
		for (int sectionIndex = leftSectionIndex; sectionIndex <= rightSectionIndex; sectionIndex++) {
			Section sourceSection = getDocument().getSection(sectionIndex);
			Section targetSection = null;
			ParagraphFoundHandler paragraphFoundHandler = null;
			if (leftSectionIndex < sectionIndex && rightSectionIndex > sectionIndex) {
				targetSection = sourceSection;
			} else if (sectionIndex == leftSectionIndex && sectionIndex < rightSectionIndex) {
				paragraphFoundHandler = new ParagraphFoundHandler();
				sectionFoundHandlers.add(paragraphFoundHandler);
				Paragraph lastParagraphInLeftSection = getDocument().getParagraph(leftSectionIndex,
						sourceSection.getParagraphCount() - 1);
				copyParagraphs(leftParagraphIndex, sourceSection.getParagraphCount() - 1, leftTokenIndex,
						lastParagraphInLeftSection.getTokenCount() - 1, sourceSection, sectionFoundHandlers);
				targetSection = paragraphFoundHandler.getResult();
			} else if (sectionIndex == leftSectionIndex && sectionIndex == rightSectionIndex) {
				paragraphFoundHandler = new ParagraphFoundHandler();
				sectionFoundHandlers.add(paragraphFoundHandler);
				copyParagraphs(leftParagraphIndex, rightParagraphIndex, leftTokenIndex, rightTokenIndex, sourceSection,
						sectionFoundHandlers);
				targetSection = paragraphFoundHandler.getResult();
			} else if (sectionIndex == rightSectionIndex && sectionIndex > leftSectionIndex) {
				paragraphFoundHandler = new ParagraphFoundHandler();
				sectionFoundHandlers.add(paragraphFoundHandler);
				copyParagraphs(0, rightParagraphIndex, 0, rightTokenIndex, sourceSection, sectionFoundHandlers);
				targetSection = paragraphFoundHandler.getResult();
			} else {
				throw new RuntimeException("Invalid copy structure: leftSectionIndex=" + leftSectionIndex
						+ ", rightSectionIndex=" + rightSectionIndex + ", sectionIndex=" + sectionIndex);
			}
			if (paragraphFoundHandler != null) {
				sectionFoundHandlers.remove(paragraphFoundHandler);
			}
			ObjectStorageImpl.fireObjectFound(sectionFoundHandlers, targetSection, sectionIndex < rightSectionIndex);
		}
	}

	private void copyParagraphs(int leftParagraphIndex, int rightParagraphIndex, int startTokenIndex,
			int rightTokenIndex, Section sourceSection, List<ObjectFoundStorage<?>> paragraphFoundHandler) {
		for (int paragraphIndex = leftParagraphIndex; paragraphIndex <= rightParagraphIndex; paragraphIndex++) {
			Paragraph paragraph = sourceSection.getParagraph(paragraphIndex);
			Paragraph targetParagraph = null;
			ObjectFoundStorage<Paragraph> tokenFoundHandler = null;
			if (leftParagraphIndex < paragraphIndex && rightParagraphIndex > paragraphIndex) {
				tokenFoundHandler = new TokenFoundHandler(idFactory);
				paragraphFoundHandler.add(tokenFoundHandler);
				copyTokens(startTokenIndex, paragraph.getTokenCount() - 1, paragraph, paragraphFoundHandler);
				targetParagraph = tokenFoundHandler.getResult();
			} else if (paragraphIndex == leftParagraphIndex && rightParagraphIndex > paragraphIndex) {
				tokenFoundHandler = new TokenFoundHandler(idFactory);
				paragraphFoundHandler.add(tokenFoundHandler);
				copyTokens(startTokenIndex, paragraph.getTokenCount() - 1, paragraph, paragraphFoundHandler);
				targetParagraph = tokenFoundHandler.getResult();
			} else if (paragraphIndex == leftParagraphIndex && rightParagraphIndex == paragraphIndex) {
				tokenFoundHandler = new TokenFoundHandler(idFactory);
				paragraphFoundHandler.add(tokenFoundHandler);
				copyTokens(startTokenIndex, rightTokenIndex, paragraph, paragraphFoundHandler);
				targetParagraph = tokenFoundHandler.getResult();
			} else if (paragraphIndex == rightParagraphIndex && leftParagraphIndex < paragraphIndex) {
				tokenFoundHandler = new TokenFoundHandler(idFactory);
				paragraphFoundHandler.add(tokenFoundHandler);
				copyTokens(startTokenIndex, rightTokenIndex, paragraph, paragraphFoundHandler);
				targetParagraph = tokenFoundHandler.getResult();
			} else {
				throw new RuntimeException("Invalid copy structure. ");
			}
			startTokenIndex = 0;
			if (tokenFoundHandler != null) {
				paragraphFoundHandler.remove(tokenFoundHandler);
			}
			ObjectStorageImpl.fireObjectFound(paragraphFoundHandler, targetParagraph,
					paragraphIndex < rightParagraphIndex);
		}
	}

	private void copyParagraphs(Set<Id> ids, List<ObjectFoundStorage<?>> paragraphFoundCallbacks) {
		List<Paragraph> paragraphs = new ArrayList<Paragraph>();
		for (Iterator<Id> iterator = ids.iterator(); iterator.hasNext();) {
			Paragraph paragraph = getDocument().getParagraph(iterator.next());
			paragraphs.add(paragraph);
		}

		Collections.sort(paragraphs, new ParagraphComparator());
		for (Iterator<Paragraph> iterator = paragraphs.iterator(); iterator.hasNext();) {
			Paragraph paragraph = iterator.next();
			copyTokens(0, paragraph.getTokenCount() - 1, paragraph, paragraphFoundCallbacks);
			ObjectStorageImpl.fireObjectFound(paragraphFoundCallbacks, paragraph, iterator.hasNext());
		}
	}

	private class ParagraphComparator implements Comparator<Paragraph> {
		@Override
		public int compare(Paragraph o1, Paragraph o2) {
			int result = 0;

			ParagraphIndex paragraphIndex1 = getDocument().getParagraphIndex(o1.getParagraphId());
			ParagraphIndex paragraphIndex2 = getDocument().getParagraphIndex(o2.getParagraphId());
			result = Integer.compare(paragraphIndex1.getSectionIndex(), paragraphIndex2.getSectionIndex());
			if (result == 0) {
				result = Integer.compare(o1.getPositionY(), o2.getPositionY());
				if (result == 0) {
					result = Integer.compare(o1.getPositionX(), o2.getPositionX());
					if (result == 0) {
						result = Integer.compare(o1.getZIndex(), o2.getZIndex());
						if (result == 0) {
							result = Integer.compare(paragraphIndex1.getParagraphIndex(),
									paragraphIndex2.getParagraphIndex());
						}
					}
				}
			}
			return result;
		}
	}

	private void copyTokens(int leftTokenIndex, int rightTokenIndex, Paragraph paragraph,
			List<ObjectFoundStorage<?>> tokenFoundCallbacks) {
		for (int tokenIndex = leftTokenIndex; tokenIndex <= rightTokenIndex; tokenIndex++) {
			Token token = paragraph.getToken(tokenIndex);
			ObjectStorageImpl.fireObjectFound(tokenFoundCallbacks, token, tokenIndex < rightTokenIndex);
		}
	}

	private void removeSelectedTokens(boolean textChanged) {
		DocumentIndex cursorTokenDocumentIndex = getDocument().getDocumentIndex(currentCursorTokenId);
		DocumentIndex firstSelectedTokenDocumentIndex = getDocument().getDocumentIndex(getFirstSelectedTokenId());

		if (!getDocument().isLayoutLocked()) {
			// Order tokens/indexes:
			Id leftTokenId = getFirstSelectedTokenId();
			Id rightTokenId = currentCursorTokenId;
			DocumentIndex leftDocumentIndex = firstSelectedTokenDocumentIndex;
			DocumentIndex rightDocumentIndex = cursorTokenDocumentIndex;
			// Swap ids and indexes if necessary:
			boolean isSelectedFromRightToLeft = leftDocumentIndex.compareTo(rightDocumentIndex) > 0;
			if (isSelectedFromRightToLeft) {
				// Swap indexes:
				leftDocumentIndex = cursorTokenDocumentIndex;
				rightDocumentIndex = firstSelectedTokenDocumentIndex;
				// Swap ids:
				leftTokenId = currentCursorTokenId;
				rightTokenId = getFirstSelectedTokenId();
			}

			int leftSectionIndex = leftDocumentIndex.getSectionIndex();
			int leftParagraphIndex = leftDocumentIndex.getParagraphIndex();
			int leftTokenIndex = leftDocumentIndex.getTokenIndex();

			int rightTokenIndex = rightDocumentIndex.getTokenIndex();
			int rightParagraphIndex = rightDocumentIndex.getParagraphIndex();
			int rightSectionIndex = rightDocumentIndex.getSectionIndex();

			Section leftSection = getDocument().getSection(leftSectionIndex);
			Paragraph leftParagraph = leftSection.getParagraph(leftParagraphIndex);

			if (leftSectionIndex < rightSectionIndex) {
				// Remove intermediate sections:
				int nextSectionIndex = leftSectionIndex + 1;
				Section nextSection = getDocument().getSection(nextSectionIndex);
				Section rightSection = getDocument().getSection(rightSectionIndex);

				while (nextSection != rightSection) {
					getDocument().removeSection(nextSectionIndex);
					nextSection = getDocument().getSection(nextSectionIndex);
				}
				// Merge sections:
				rightParagraphIndex += leftSection.getParagraphCount();
				getDocument().mergeSectionWithNext(leftSectionIndex);
			}

			if (leftParagraphIndex < rightParagraphIndex) {
				// Remove intermediate paragraphs:
				int nextParagraphIndex = leftParagraphIndex + 1;
				Paragraph nextParagraph = leftSection.getParagraph(nextParagraphIndex);
				Paragraph rightParagraph = leftSection.getParagraph(rightParagraphIndex);

				while (nextParagraph != rightParagraph) {
					leftSection.removeParagraph(nextParagraphIndex);
					nextParagraph = leftSection.getParagraph(nextParagraphIndex);
				}
				// Merge paragraphs:
				rightTokenIndex += leftParagraph.getTokenCount();
				leftSection.mergeParagraphWithNext(leftParagraphIndex);

			}
			Id lastTokenId = leftTokenId;
			if (leftTokenIndex < rightTokenIndex) {
				int nextTokenIndex = leftTokenIndex + 1;
				Token rightToken = leftParagraph.getToken(rightTokenIndex);
				Token nextToken = leftParagraph.getToken(nextTokenIndex);

				// Remove intermediate tokens:
				while (nextToken != rightToken) {
					leftParagraph.removeToken(nextTokenIndex);
					nextToken = leftParagraph.getToken(nextTokenIndex);
				}
				rightTokenIndex = nextTokenIndex;

				// Delete cursor token (and thus keep first selected token):
				if (rightTokenId.equals(currentCursorTokenId)) {
					leftParagraph.removeToken(rightTokenIndex);
				} else {
					leftParagraph.removeToken(leftTokenIndex);
					lastTokenId = rightTokenId;
				}

				// Remove boxes in UI:
				getDocumentLayouter().removeBoxesBetween(leftTokenId, rightTokenId);
				getDocumentLayouter().removeTokenBox(currentCursorTokenId);

			}

			// Cursor token is now the left token:
			Token cursorToken = leftParagraph.getToken(leftTokenIndex);

			if (textChanged
					|| (leftSection.getParagraphCount() == 1 && leftSection.getParagraph(0).getTokenCount() == 1)) {
				currentCursorTokenId = cursorToken.getId();
				if (cursorToken instanceof TextbasedToken) {
					String cursorTokenText = "";
					((TextbasedToken) cursorToken).setText(cursorTokenText);
					getDocumentLayouter().updateTokenBox(currentCursorTokenId);
				}
				if (cursorToken instanceof SignItemToken) {
					updateSigns((SignItemToken) cursorToken);
				}

				toggleTokenBoxSelection(currentCursorTokenId);

			} else {
				leftDocumentIndex = getDocument().getDocumentIndex(leftParagraph.getToken(leftTokenIndex).getId());

				DocumentIndex nextDocumentIndex = getDocument().isLastDocumentIndex(leftDocumentIndex) ? null
						: getDocument().getNextDocumentIndex(leftDocumentIndex);
				DocumentIndex previousDocumentIndex = getDocument().isFirstDocumentIndex(leftDocumentIndex) ? null
						: getDocument().getPreviousDocumentIndex(leftDocumentIndex);

				leftParagraph.removeToken(leftTokenIndex);
				getDocumentLayouter().removeTokenBox(lastTokenId);

				if (leftParagraph.getTokenCount() > leftTokenIndex) {
					cursorToken = getDocument().getToken(leftDocumentIndex);
				} else if (!isSelectedFromRightToLeft) {
					if (previousDocumentIndex != null) {
						cursorToken = getDocument().getToken(previousDocumentIndex);
					} else {
						cursorToken = getDocument().getToken(nextDocumentIndex);
					}
				} else {
					if (nextDocumentIndex != null) {
						cursorToken = getDocument().getToken(nextDocumentIndex);
					} else {
						cursorToken = getDocument().getToken(previousDocumentIndex);
					}
				}

				if (leftParagraph.isEmpty()) {
					leftSection.removeParagraph(leftParagraphIndex);

					if (!getDocument().isFirstDocumentIndex(leftDocumentIndex)) {
						DocumentIndex previousTokenDocumentIndex = getDocument()
								.getPreviousDocumentIndex(leftDocumentIndex);

						Id previousTokenId = getDocument().getToken(previousTokenDocumentIndex).getId();
						getDocumentLayouter().removeLineBreakAfter(previousTokenId);

					} else {
						LineIndex lineIndexObject = new LineIndex(leftSectionIndex, 0);
						getDocumentLayouter().removeLine(lineIndexObject);
					}

				}

				currentCursorTokenId = cursorToken.getId();

			}
			// Remove selection:
			setFirstSelectedTokenId(null);
			setSelectionAndCursorToAbsoluteLeft(currentCursorTokenId, 0, false);
		}
	}

	private boolean isValidCursorPosition(Id tokenId, int cursorPosition) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument()
				.getToken(tokenId) instanceof TextbasedToken : "Precondition failed : token instanceof TextbasedToken";

		Token token = getDocument().getToken(tokenId);
		if (token instanceof SignItemToken) {
			return getDocument().containsToken(tokenId) && -1 <= cursorPosition
					&& cursorPosition <= ((SignItemToken) token).getText().length();
		}
		return getDocument().containsToken(tokenId);

	}

	private void toggleTokenBoxSelectionFromTo(Id fromTokenId, Id toTokenId) {
		assert fromTokenId != null : "Precondition failed: fromTokenId != null";
		assert toTokenId != null : "Precondition failed: toTokenId != null";
		assert getDocument().containsToken(fromTokenId) : "Precondition failed: containsTokenBox(fromTokenId)";
		assert getDocument().containsToken(toTokenId) : "Precondition failed: containsTokenBox(toTokenId)";

		for (Token token : getTokensBetweenInklusive(fromTokenId, toTokenId)) {
			toggleTokenBoxSelection(token.getId());
		}
	}

	protected List<Token> getTokensBetweenInklusive(Id fromTokenId, Id toTokenId) {
		assert fromTokenId != null : "Precondition failed: fromTokenId != null";
		assert toTokenId != null : "Precondition failed: toTokenId != null";
		assert getDocument().containsToken(fromTokenId) : "Precondition failed: containsTokenBox(fromTokenId)";
		assert getDocument().containsToken(toTokenId) : "Precondition failed: containsTokenBox(toTokenId)";

		DocumentIndex fromDocumentIndex = getDocument().getDocumentIndex(fromTokenId);
		DocumentIndex toDocumentIndex = getDocument().getDocumentIndex(toTokenId);

		int compareValue = toDocumentIndex.compareTo(fromDocumentIndex);
		if (compareValue < 0) {
			DocumentIndex tempDocumentIndex = fromDocumentIndex;
			fromDocumentIndex = toDocumentIndex;
			toDocumentIndex = tempDocumentIndex;
		}

		int startParagraphIndex = fromDocumentIndex.getParagraphIndex();
		int startTokenIndex = fromDocumentIndex.getTokenIndex();
		boolean endReached = false;
		List<Token> tokenList = new ArrayList<Token>();
		for (int sectionIndex = fromDocumentIndex.getSectionIndex(); sectionIndex <= toDocumentIndex.getSectionIndex()
				&& !endReached; sectionIndex++) {
			for (int paragraphIndex = startParagraphIndex; paragraphIndex < getDocument()
					.getParagraphCount(sectionIndex) && !endReached; paragraphIndex++) {
				for (int tokenIndex = startTokenIndex; tokenIndex < getDocument().getTokenCount(sectionIndex,
						paragraphIndex) && !endReached; tokenIndex++) {

					boolean toSectionReached = sectionIndex == toDocumentIndex.getSectionIndex();
					boolean toParagraphReached = paragraphIndex == toDocumentIndex.getParagraphIndex();
					boolean toTokenReached = tokenIndex == toDocumentIndex.getTokenIndex();
					endReached = toSectionReached && toParagraphReached && toTokenReached;
					tokenList.add(getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex));
				}
				startTokenIndex = 0;
			}
			startParagraphIndex = 0;
		}
		return tokenList;
	}

	private int findIndexForSignIdInToken(SignItemToken token, List<SignItem> signItemsForWord) {
		assert token != null : "Precondition failed: token != null";
		assert signItemsForWord != null : "Precondition failed: signItemsForWord != null";

		// Determine index in query result to make sure
		// choice for sign alternative is preserved:
		int selectedSignIndex = signItemsForWord.indexOf(token.getSignItem());

		if (signItemsForWord.isEmpty()) {
			token.setSignItem(null);
		} else if (selectedSignIndex == -1) {
			// using short circuit evaluation for empty tokens
			if (token != null && token.getSignItem() != null && token.getSignItem().getSignId() != null
					&& token.getSignItem().getSignId().getSignSource() != null) {
				if (SignSource.IMPORTED.equals(token.getSignItem().getSignId().getSignSource())) {
					// It might be that the sign was imported but got
					// overwritten such that its source has changed
					SignId tokenId = token.getSignItem().getSignId();
					SignId overwrittenSignId = new SignId(tokenId.getUpperIdPart(), tokenId.getLowerIdPart(),
							tokenId.getSignLocale(), SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
					SignItem overwrittenSignItem = new SignItem(overwrittenSignId, token.getSignItem().getSignWidth());

					if (token.getSignItem().getLocalSign() != null) {
						overwrittenSignItem.setLocalSign(token.getSignItem().getLocalSign());
					}

					selectedSignIndex = signItemsForWord.indexOf(overwrittenSignItem);
					if (selectedSignIndex == -1) {
						selectedSignIndex = 0;
					}
					token.setSignItem(signItemsForWord.get(selectedSignIndex));
				} else if (SignSource.UNKNOWN.equals(token.getSignItem().getSignId().getSignSource())) {

					// If the signSource is unknown its highly likable that it
					// is IMPORTED_BUT_OVERWRITTEN_IN_DELGES or IMPORTED
					SignId tokenId = token.getSignItem().getSignId();
					SignId tokenIdImported = new SignId(tokenId.getUpperIdPart(), tokenId.getLowerIdPart(),
							tokenId.getSignLocale(), SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS);
					SignItem importedSignItem = new SignItem(tokenIdImported, token.getSignItem().getSignWidth());

					if (token.getSignItem().getLocalSign() != null) {
						importedSignItem.setLocalSign(token.getSignItem().getLocalSign());
					}

					selectedSignIndex = signItemsForWord.indexOf(importedSignItem);
					if (selectedSignIndex == -1) {
						// If we do not find an alternative that is
						// IMPORTED_BUT_OVERWRITTEN_IN_DELEGS, then we will try
						// IMPORTED
						SignId tokenIdImportedButOverwritten = new SignId(tokenId.getUpperIdPart(),
								tokenId.getLowerIdPart(), tokenId.getSignLocale(), SignSource.IMPORTED);
						SignItem importedButOverwrittenSignItem = new SignItem(tokenIdImportedButOverwritten,
								token.getSignItem().getSignWidth());

						if (token.getSignItem().getLocalSign() != null) {
							importedButOverwrittenSignItem.setLocalSign(token.getSignItem().getLocalSign());
						}

						selectedSignIndex = signItemsForWord.indexOf(importedButOverwrittenSignItem);
						if (selectedSignIndex == -1) {

							// If we do not find an alternative that is
							// imported, then we will try DELEGS
							SignId tokenIdDelegs = new SignId(tokenId.getUpperIdPart(), tokenId.getLowerIdPart(),
									tokenId.getSignLocale(), SignSource.DELEGS);
							SignItem delegsSignItem = new SignItem(tokenIdDelegs, token.getSignItem().getSignWidth());

							if (token.getSignItem().getLocalSign() != null) {
								delegsSignItem.setLocalSign(token.getSignItem().getLocalSign());
							}

							selectedSignIndex = signItemsForWord.indexOf(delegsSignItem);
							if (selectedSignIndex == -1) {
								selectedSignIndex = 0;
							}
						}
					}
				} else {
					// Sign in token was not in dictionary
					// (unknown sign
					// or translation of old word):

					selectedSignIndex = 0;
					token.setSignItem(signItemsForWord.get(selectedSignIndex));
				}
			} else {
				selectedSignIndex = 0;
				token.setSignItem(signItemsForWord.get(selectedSignIndex));
			}
		}
		return selectedSignIndex;
	}

	/**
	 * This method is responsible for initializing instance variable selectableDocumentLayout
	 */
	protected abstract void initLayouter();

	protected abstract Clipboard initClipboard();

	protected abstract void onFreeTextVisibilityChanged();

	protected abstract void onSearchWordVisibilityChanged();

	protected abstract void onSignVisibilityChanged();

	protected abstract void onGlossWritingToggled();

	abstract protected void setCursorPositionInUi(Id tokenId, int cursorPosition);

	protected abstract void focusBoxInUi(Id tokenId);

	abstract protected int getCursorLeft(Id tokenId);

	abstract protected int getCursorPosition(Id tokenId);

	abstract protected void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler);

	abstract protected void toggleTokenBoxSelection(Id tokenId);

	abstract protected boolean isFrameSelected(Id tokenId);

	abstract protected void setUnderlineVisibility(boolean visible);

	abstract protected void setFooterText(String newText);

	public interface DocumentEditorListener {

		public void onInvalidSessionExceptionCaught();

		public void onPdfLoaded(PdfFileItem documentItem);

		public void onDocumentLoaded();

		public void onDocumentSavedAs(FolderItem folder);

		public void onExceptionDuringDocumentLoaded();

		void onEditSign(SignItemEditor signItem, SignLocale signLocale, String searchWord,
				SignModifiedListener signModifiedListener);
	}

	private void insertTokenRelatedToCurrentToken(Token newToken) {
		Id relatedTokenId = currentCursorTokenId;
		insertTokenRelatedToToken(newToken, relatedTokenId);
	}

	private void insertTokenRelatedToToken(Token newToken, Id relatedTokenId) {
		List<Token> tokensToInsert = new ArrayList<Token>();
		tokensToInsert.add(newToken);
		Token currentToken = getDocument().getToken(relatedTokenId);
		if (currentToken instanceof TextbasedToken) {
			if (((TextbasedToken) currentToken).getText().isEmpty() || getCursorPosition(relatedTokenId) != 0) {
				this.insertTokensAfter(relatedTokenId, tokensToInsert);
			} else {
				this.insertTokensBefore(relatedTokenId, tokensToInsert);
			}
		} else {
			this.insertTokensAfter(relatedTokenId, tokensToInsert);
		}
		setSelectionAndCursor(newToken.getId(), 0, false);
	}

	protected void insertSignItemTokenAfterCurrentToken() {
		// Add empty Sign Item Token
		if (getSelectedTokens().get(0) instanceof SignItemToken) {
			insertTokenRelatedToCurrentToken(
					getTokenFactory().createEmptySignItemToken(getTextBasedTokenStyle(currentCursorTokenId),
							getSelectedTokens().get(0).getBackgroundColor(), currentSignLocale));
			getDocumentLayouter().updateTokenBox(currentCursorTokenId);

		} else {
			insertTokenRelatedToCurrentToken(getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(),
					getDefaultBackgroundColor(), currentSignLocale));
		}
	}

	protected void insertFreeTextTokenAfterCurrentToken(boolean isLine) {
		insertFreeTextTokenAfterToken(getCurrentCursorTokenId(), isLine);
	}

	protected void insertFreeTextTokenAfterToken(Id tokenBeforeNewTokenId, boolean isLine) {
		Token token = null;
		Token currentToken = getDocument().getToken(tokenBeforeNewTokenId);
		ReadOnlyTextbasedTokenStyle style = getDefaultTextbasedTokenStyle();
		if (currentToken instanceof FreeTextToken) {
			style = ((FreeTextToken) currentToken).getStyle();
		}
		if (isLine) {
			token = getTokenFactory().createFreeTextLineToken(style);
		} else {
			token = getTokenFactory().createFreeTextToken(style);
		}
		insertTokenRelatedToToken(token, tokenBeforeNewTokenId);
	}

	protected void insertFrameTokenAfterCurrentToken() {
		insertTokenRelatedToCurrentToken(getTokenFactory().createFrameToken());
	}

	protected void insertVideoTokenAfterCurrentToken() {
		insertTokenRelatedToCurrentToken(getTokenFactory().createVideoToken());
	}

	protected void insertImageTokenAfterCurrentToken() {
		insertTokenRelatedToCurrentToken(getTokenFactory().createImageToken());
	}

	protected List<Token> getSelectedTokens() {
		List<Token> selectedTokenIds = new ArrayList<Token>();
		if (getFirstSelectedTokenId() != null && currentCursorTokenId != null) {
			DocumentIndex fromDocumentIndex = document.getDocumentIndex(getFirstSelectedTokenId());
			DocumentIndex toDocumentIndex = document.getDocumentIndex(currentCursorTokenId);

			DocumentIndex tempDocumentIndex = fromDocumentIndex;
			int compareValue = toDocumentIndex.compareTo(fromDocumentIndex);
			if (compareValue < 0) {
				fromDocumentIndex = toDocumentIndex;
				toDocumentIndex = tempDocumentIndex;
			}

			int startParagraphIndex = fromDocumentIndex.getParagraphIndex();
			int startTokenIndex = fromDocumentIndex.getTokenIndex();
			boolean end = false;

			for (int sectionIndex = fromDocumentIndex.getSectionIndex(); sectionIndex <= toDocumentIndex
					.getSectionIndex() && !end; sectionIndex++) {
				for (int paragraphIndex = startParagraphIndex; paragraphIndex < document.getParagraphCount(sectionIndex)
						&& !end; paragraphIndex++) {
					for (int tokenIndex = startTokenIndex; tokenIndex < document.getTokenCount(sectionIndex,
							paragraphIndex) && !end; tokenIndex++) {
						end = sectionIndex == toDocumentIndex.getSectionIndex()
								&& paragraphIndex == toDocumentIndex.getParagraphIndex()
								&& tokenIndex == toDocumentIndex.getTokenIndex();
						selectedTokenIds.add(document.getToken(sectionIndex, paragraphIndex, tokenIndex));

					}
					startTokenIndex = 0;
				}
				startParagraphIndex = 0;
			}
		} else if (currentCursorTokenId != null) {
			selectedTokenIds.add(document.getToken(currentCursorTokenId));
		}

		assert !selectedTokenIds.isEmpty() : "Postcondition failed: !selectedTokenIds.isEmpty()";

		return selectedTokenIds;
	}

	protected void handleLocaleChanged(SignLocale newLanguage) {
		this.getDocument().setRegion(newLanguage);

		for (Token token : getSelectedTokens()) {
			if (token instanceof SignItemToken) {
				((SignItemToken) token).setSignLocale(newLanguage);
				updateSigns(token);
			}
		}
		currentSignLocale = newLanguage;
	}

	protected void handleChangeTokenBackgroundColor(Color textBackgroundColor) {
		List<Token> selectedTokens = getSelectedTokens();
		for (Token token : selectedTokens) {
			token.setBackgroundColor(textBackgroundColor);
			getDocumentLayouter().setBackgroundOfToken(token.getId(), textBackgroundColor);
		}
	}

	protected void handleFontColorChanged(Color fontColor) {
		for (Token token : getSelectedTokens()) {
			tokenStyleTool.changeFontColorTo(fontColor, (TextbasedToken) token);
		}
	}

	protected void handleFontSizeChanged(FontSize fontSize) {
		for (Token token : getSelectedTokens()) {
			tokenStyleTool.changeFontSizeTo(fontSize, (TextbasedToken) token);
		}
		updateTokenMargins();
	}

	protected void handleFontWeightChanged(FontWeight fontWeight) {
		for (Token token : getSelectedTokens()) {
			tokenStyleTool.changeFontWeightTo(fontWeight, (TextbasedToken) token);
		}
	}

	protected void handleFontStyleChanged(FontStyle fontStyle) {
		for (Token token : getSelectedTokens()) {
			tokenStyleTool.changeFontStyleTo(fontStyle, (TextbasedToken) token);
		}
	}

	protected void handleFontChanged(Font font) {
		for (Token token : getSelectedTokens()) {
			tokenStyleTool.changeFontTo(font, (TextbasedToken) token);
		}
	}

	protected void handleChangeTextBoxBackgroundColor(Color color) {
		if (hasTokenSelection()) {
			DocumentIndex fromDocumentIndex = getDocument().getDocumentIndex(getFirstSelectedTokenId());
			DocumentIndex toDocumentIndex = getDocument().getDocumentIndex(currentCursorTokenId);

			DocumentIndex tempDocumentIndex = fromDocumentIndex;
			int compareValue = toDocumentIndex.compareTo(fromDocumentIndex);
			if (compareValue < 0) {
				fromDocumentIndex = toDocumentIndex;
				toDocumentIndex = tempDocumentIndex;
			}

			int startParagraphIndex = fromDocumentIndex.getParagraphIndex();
			int startTokenIndex = fromDocumentIndex.getTokenIndex();
			boolean end = false;

			for (int sectionIndex = fromDocumentIndex.getSectionIndex(); sectionIndex <= toDocumentIndex
					.getSectionIndex() && !end; sectionIndex++) {
				for (int paragraphIndex = startParagraphIndex; paragraphIndex < getDocument()
						.getParagraphCount(sectionIndex) && !end; paragraphIndex++) {
					for (int tokenIndex = startTokenIndex; tokenIndex < getDocument().getTokenCount(sectionIndex,
							paragraphIndex) && !end; tokenIndex++) {
						end = sectionIndex == toDocumentIndex.getSectionIndex()
								&& paragraphIndex == toDocumentIndex.getParagraphIndex()
								&& tokenIndex == toDocumentIndex.getTokenIndex();
						Token token = getDocument().getToken(sectionIndex, paragraphIndex, tokenIndex);
						if (token instanceof TextbasedToken) {
							tokenStyleTool.changeTextBackgroundColorTo(color, ((TextbasedToken) token));
							getDocumentLayouter().setTextBackgroundOfToken(token.getId(), color);
						}
					}
					startTokenIndex = 0;
				}
				startParagraphIndex = 0;
			}

		} else {
			Token token = getDocument().getToken(currentCursorTokenId);
			if (token instanceof TextbasedToken) {
				tokenStyleTool.changeTextBackgroundColorTo(color, ((TextbasedToken) token));
				getDocumentLayouter().setTextBackgroundOfToken(currentCursorTokenId, color);
			}
		}

	}

	protected void handleAddNormalPage() {
		insertNormalPage(currentCursorTokenId);
	}

	private void insertNormalPage(Id id) {
		DocumentIndex di = getDocument().getDocumentIndex(id);

		if (getDocument().getSection(di.getSectionIndex()).isCollage()) {
			int pageIndex = getCollagePageIndex(di.getSectionIndex());

			Section newSection = new Section();
			int newSectionIndex = di.getSectionIndex() + 1;
			getDocument().insertSection(newSection, newSectionIndex);
			Paragraph paragraph = new Paragraph(idFactory.createId());
			Token newToken = getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(), Color.WHITE,
					currentSignLocale);
			paragraph.addToken(newToken);
			newSection.addParagraph(paragraph);

			getDocumentLayouter().insertNewPageAfterPage(id, pageIndex, newToken);

			if (isAutomaticFreeTextLineEnabled()) {
				createAutomaticFreeTextLine(newToken, false);
			}
		} else {
			ArrayList<Token> tokensToInsert = new ArrayList<Token>();
			SignItemToken newEmptyToken = getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(),
					Color.WHITE, currentSignLocale);
			tokensToInsert.add(newEmptyToken);
			if (isAutomaticFreeTextLineEnabled()) {
				Token token = getDocument().getToken(id);
				if ((token instanceof FreeTextToken && ((FreeTextToken) token).isFreeTextLine())) {
					Token freeTextLineToken = getTokenFactory()
							.createFreeTextLineToken(getDefaultTextbasedTokenStyle());
					tokensToInsert.add(freeTextLineToken);
				}
			}
			insertLineOrPageBreakAndTokensAfter(id, Tokenizer.PAGE_BREAK, tokensToInsert);
		}

	}

	protected void insertCollage() {
		DocumentIndex di = getDocument().getDocumentIndex(currentCursorTokenId);
		Id collageId = idFactory.createId();
		int pageIndex = -1;
		boolean showCollageGrid = getDocument().showCollageGrid();
		if (getDocument().getSection(di.getSectionIndex()).isCollage()) {
			Section newCollage = new Section();
			newCollage.setIsCollage(true, collageId);
			int newCollageIndex = di.getSectionIndex() + 1;
			getDocument().insertSection(newCollage, newCollageIndex);
			pageIndex = getCollagePageIndex(newCollageIndex - 1);
			pageIndex++;
			getDocumentLayouter().insertCollageAtPage(pageIndex, collageId, showCollageGrid);
		} else if (isLastTokenInSection(currentCursorTokenId, di)) {
			Section newCollage = new Section();
			newCollage.setIsCollage(true, collageId);
			int newCollageIndex = di.getSectionIndex() + 1;
			getDocument().insertSection(newCollage, newCollageIndex);

			getDocumentLayouter().insertPageBreakAfterPage(currentCursorTokenId, true, collageId, showCollageGrid);
			pageIndex = getDocumentLayouter().getCollagePageNumber(collageId);
		} else {
			ArrayList<Token> tokenToInsert = new ArrayList<Token>();
			tokenToInsert.add(getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(), Color.WHITE,
					currentSignLocale));
			insertLineOrPageBreakAndTokensAfter(currentCursorTokenId, Tokenizer.PAGE_BREAK, tokenToInsert);

			Paragraph paragraph = getDocument().getParagraph(di.getSectionIndex(), di.getParagraphIndex());
			Id newId = paragraph.getToken(paragraph.getTokenCount() - 1).getId();
			DocumentIndex documentIndex = getDocument().getDocumentIndex(newId);

			Section section = insertNewSectionAndMoveParagraphsAfter(documentIndex, di.getParagraphIndex() + 1);
			section.setIsCollage(true, collageId);

			getDocumentLayouter().insertPageBreakAfter(newId, true, collageId, getDocument().showCollageGrid());

			pageIndex = getDocumentLayouter().getCollagePageNumber(collageId);

			// compensate next continuous page, if present
			int nextPageIndex = pageIndex + 1;
			if (nextPageIndex < getDocumentLayouter().getPageCount() //
					&& !getDocumentLayouter().isCollage(nextPageIndex) //
					&& getDocumentLayouter().getLineCount(nextPageIndex) > 0) {
				getDocumentLayouter().compensate(new LineIndex(nextPageIndex, 0));
			}
		}
		getDocumentLayouter().removeFirstSnippet(pageIndex);
		getDocumentLayouter().scrollToTopOfPageWithNumber(pageIndex);
	}

	protected boolean hasCollage() {
		return document.hasCollage();
	}

	private boolean isLastTokenInSection(Id id, DocumentIndex di) {
		Section section = getDocument().getSection(di.getSectionIndex());
		Paragraph paragraph = section.getParagraph(di.getParagraphIndex());
		boolean isInLastParagraph = di.getParagraphIndex() == section.getParagraphCount() - 1;
		boolean isLastTokenInSection = di.getTokenIndex() == paragraph.getTokenCount() - 1;
		boolean isLastTokenBeforeAutomaticFreeTextLine = isAutomaticFreeTextLineEnabled()
				&& di.getTokenIndex() == paragraph.getTokenCount() - 2;
		return isInLastParagraph && (isLastTokenInSection || isLastTokenBeforeAutomaticFreeTextLine);
	}

	protected void removeCollage(Id pageId) {
		int collageIndex = getDocument().getSectionIndexForCollageId(pageId);
		int collageNumber = this.getCollagePageIndex(collageIndex);

		if (firstSelectedTokenId != null) {
			deselectTokens();
		}

		if (collageIndex > 0) {
			DocumentIndex previousDocumentIndex = getDocument()
					.getPreviousDocumentIndex(new DocumentIndex(collageIndex, 0, 0));
			currentCursorTokenId = getDocument().getToken(previousDocumentIndex).getId();
		} else if (getDocument().getSectionCount() > 1) {
			Section collage = getDocument().getSection(collageIndex);
			Token lastTokenInSection = collage.getLastTokenInSection();
			if (lastTokenInSection != null) {
				DocumentIndex nextDocumentIndex = getDocument()
						.getNextDocumentIndex(getDocument().getDocumentIndex(lastTokenInSection.getId()));
				currentCursorTokenId = getDocument().getToken(nextDocumentIndex).getId();
			}
		} else {
			return;
		}

		getDocumentLayouter().removePage(collageNumber);
		getDocument().removeSection(collageIndex);
		setSelectionAndCursorToAbsoluteLeft(currentCursorTokenId, 0, false);
	}

	protected void handleAddSnippetToDocument(Id collageId, int x, int y, int width, boolean automaticallyResize) {
		if (firstSelectedTokenId != null) {
			deselectTokens();
		}
		Id newID = idFactory.createId();
		int sectionIndex = getDocument().getSectionIndexForCollageId(collageId);
		int maxZIndex = getMaxZIndex(sectionIndex) + 1;
		Paragraph newParagraph = new Paragraph(newID, width, x, y, maxZIndex);
		newParagraph.setAutomaticResizeActive(automaticallyResize);
		newParagraph.addToken(getTokenFactory().createEmptySignItemToken(getDefaultTextbasedTokenStyle(), Color.WHITE,
				currentSignLocale));
		addSnippetToDocument(sectionIndex, newParagraph);
		setSelectionAndCursor(newParagraph.getToken(0).getId(), 0, false);
	}

	protected void addSnippetToDocument(int sectionIndex, Paragraph paragraph) {
		getDocument().getSection(sectionIndex).addParagraph(paragraph);

		int pageIndex = getCollagePageIndex(sectionIndex);
		int snippetCount = getDocumentLayouter().getSnippetCount(pageIndex);
		boolean isAutomaticResize = paragraph.isAutomaticResize();
		boolean paragraphHasWidth = paragraph.getWidth() > 0;

		getDocumentLayouter().addSnippetToCollagePage(paragraph.getParagraphId(), pageIndex, paragraph.getPositionX(),
				paragraph.getPositionY(), paragraph.getWidth(), paragraph.getZIndex());

		if (paragraphHasWidth) {
			paragraph.setAutomaticResizeActive(false);
			getDocumentLayouter().setSnippetAutomaticResize(pageIndex, snippetCount, false);
		}
		for (Token token : paragraph.getTokens()) {
			getDocumentLayouter().addTokenToSnippet(pageIndex, snippetCount, token);
		}

		if (isAutomaticFreeTextLineEnabled()) {
			Token lastToken = paragraph.getToken(paragraph.getTokenCount() - 1);
			insertTokenAfter(lastToken.getId(),
					getTokenFactory().createFreeTextLineToken(getDefaultTextbasedTokenStyle()),
					paragraph.isSearchWordLineVisible(), paragraph.isSignLineVisible());
		}

		getDocumentLayouter().updateSnippetWidth(pageIndex, snippetCount, paragraph.getWidth(),
				paragraph.isAutomaticResize());
		if (paragraphHasWidth) {
			paragraph.setAutomaticResizeActive(isAutomaticResize);
			getDocumentLayouter().setSnippetAutomaticResize(pageIndex, snippetCount, isAutomaticResize);
		}

		updateSigns(paragraph.getTokens());
	}

	private void handleRemoveSnippetFromDocument(Id id) {
		ParagraphIndex paragraphIndex = getDocument().getParagraphIndex(id);

		getDocumentLayouter().removeSnippet(getCollagePageIndex(paragraphIndex.getSectionIndex()),
				paragraphIndex.getParagraphIndex());

		DocumentIndex previousDocumentIndex = getDocument().getPreviousDocumentIndex(
				new DocumentIndex(paragraphIndex.getSectionIndex(), paragraphIndex.getParagraphIndex(), 0));
		Token previousToken = getDocument().getToken(previousDocumentIndex.getSectionIndex(),
				previousDocumentIndex.getParagraphIndex(), previousDocumentIndex.getTokenIndex());

		getDocument().getSection(paragraphIndex.getSectionIndex()).removeParagraph(paragraphIndex.getParagraphIndex());
		currentCursorTokenId = previousToken.getId();
	}

	protected void handleSendParagraphToFront() {

		if (!selectedParagraphIds.isEmpty()) {
			sendSelectedParagraphsToFront();
		} else if (hasTokenSelection()) {
			sendParagraphsToFrontForTokenSelection();
		} else {
			sendOneParagraphToFrontForCursorInToken();
		}

	}

	private void sendOneParagraphToFrontForCursorInToken() {
		int maxZIndex;
		DocumentIndex documentIndex = getDocument().getDocumentIndex(currentCursorTokenId);
		maxZIndex = findLowestParagraphZIndex(documentIndex.getSectionIndex());
		// z-index of fp page is 0, therefore fpp should not have a lower or
		// same z-index
		maxZIndex++;
		getDocument().getParagraph(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex())
				.setZIndex(maxZIndex);

		getDocumentLayouter().updateSnippetZPosition(getCollagePageIndex(documentIndex.getSectionIndex()),
				documentIndex.getParagraphIndex(), maxZIndex);
	}

	private void sendParagraphsToFrontForTokenSelection() {
		int maxZIndex;
		DocumentIndex index1 = getDocument().getDocumentIndex(getFirstSelectedTokenId());
		DocumentIndex index2 = getDocument().getDocumentIndex(currentCursorTokenId);

		if (index1.compareTo(index2) >= 1) {
			DocumentIndex temp = index1;
			index1 = index2;
			index2 = temp;
		}

		int startParagraphIndex = index1.getParagraphIndex();
		int endParagraphIndex = index1.getSectionIndex() == index2.getSectionIndex() ? index2.getParagraphIndex()
				: getDocument().getParagraphCount(index1.getSectionIndex());

		for (int i = index1.getSectionIndex(); i <= index2.getSectionIndex(); i++) {
			maxZIndex = findLowestParagraphZIndex(i);

			for (int j = startParagraphIndex; j < endParagraphIndex; j++) {
				maxZIndex++;
				getDocument().getParagraph(i, j).setZIndex(maxZIndex);

				getDocumentLayouter().updateSnippetZPosition(getCollagePageIndex(i), j, maxZIndex);
			}

			startParagraphIndex = 0;
			endParagraphIndex = i == index2.getSectionIndex() ? index2.getParagraphIndex()
					: getDocument().getParagraphCount(index1.getSectionIndex());
		}
	}

	private void sendSelectedParagraphsToFront() {
		if (!selectedParagraphIds.isEmpty()) {
			int sectionIndex = getSectionIndexFromSelectedIds();
			Section selectedSection = getDocument().getSection(sectionIndex);
			selectedSection.sendSelectedParagraphsToFront(selectedParagraphIds);

			updateParagraphs(selectedSection);
		}
	}

	private void sendSelectedParagraphsToBack() {
		if (!selectedParagraphIds.isEmpty()) {
			int sectionIndex = getSectionIndexFromSelectedIds();
			Section selectedSection = getDocument().getSection(sectionIndex);
			selectedSection.sendSelectedParagraphsToBack(selectedParagraphIds);

			updateParagraphs(selectedSection);
		}
	}

	// Zurzeit wird nur der Z Index der Paragraphen geupdatet.
	// Hier können jedoch in Zukunft auch alle anderen Werte geupdatet werden.
	private void updateParagraphs(Section selectedSection) {
		for (Paragraph paragraph : selectedSection.getParagraphs()) {
			ParagraphIndex paragraphIndex = getDocument().getParagraphIndex(paragraph.getParagraphId());
			getDocumentLayouter().updateSnippetZPosition(getCollagePageIndex(paragraphIndex.getSectionIndex()),
					paragraphIndex.getParagraphIndex(), paragraph.getZIndex());
		}
	}

	private int getSectionIndexFromSelectedIds() {
		assert !selectedParagraphIds.isEmpty() : "Precondition failed: !selectedIds.isEmpty()";
		return getDocument().getParagraphIndex(selectedParagraphIds.iterator().next()).getSectionIndex();
	}

	private int getMaxZIndex(int sectionIndex) {
		int maxZIndex = 0;
		for (int i = 0; i < getDocument().getParagraphCount(sectionIndex); ++i) {
			int zIndex = getDocument().getParagraph(sectionIndex, i).getZIndex();
			maxZIndex = maxZIndex > zIndex ? maxZIndex : zIndex;
		}
		return maxZIndex;
	}

	protected void handleSendParagraphToBack() {
		if (!selectedParagraphIds.isEmpty()) {
			sendSelectedParagraphsToBack();
		} else if (hasTokenSelection()) {
			sendParagraphsToBackForTokenSelection();
		} else {
			sendOneParagraphToBackForCursorInToken();
		}
	}

	private void sendOneParagraphToBackForCursorInToken() {
		DocumentIndex documentIndex = getDocument().getDocumentIndex(currentCursorTokenId);
		sendParagraphToBack(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex());
	}

	private void sendParagraphsToBackForTokenSelection() {
		DocumentIndex index1 = getDocument().getDocumentIndex(getFirstSelectedTokenId());
		DocumentIndex index2 = getDocument().getDocumentIndex(currentCursorTokenId);

		if (index1.compareTo(index2) >= 1) {
			DocumentIndex temp = index1;
			index1 = index2;
			index2 = temp;
		}

		int startParagraphIndex = index1.getParagraphIndex();
		int endParagraphIndex = index1.getSectionIndex() == index2.getSectionIndex() ? index2.getParagraphIndex()
				: getDocument().getParagraphCount(index1.getSectionIndex()) - 1;

		for (int i = index1.getSectionIndex(); i <= index2.getSectionIndex(); i++) {
			for (int j = startParagraphIndex; j <= endParagraphIndex; j++) {
				sendParagraphToBack(i, j);
			}
			startParagraphIndex = 0;
			endParagraphIndex = i == index2.getSectionIndex() - 1 ? index2.getParagraphIndex()
					: getDocument().getParagraphCount(index1.getSectionIndex()) - 1;
		}
	}

	private void sendParagraphToBack(int sectionIndex, int paragraphIndex) {
		Paragraph paragraph = getDocument().getParagraph(sectionIndex, paragraphIndex);
		int minZIndex = findLowestParagraphZIndex(sectionIndex);
		// z-index of fp page is 0, therefore fpp should not have a lower or
		// same z-index
		if (minZIndex != paragraph.getZIndex()) {
			paragraph.setZIndex(minZIndex);
			for (Paragraph paragraphInSection : getDocument().getSection(sectionIndex).getParagraphs()) {
				if (!paragraphInSection.equals(paragraph)) {
					int zIndex = paragraphInSection.getZIndex() + 1;
					paragraphInSection.setZIndex(zIndex);
				}
				getDocumentLayouter().updateSnippetZPosition(getCollagePageIndex(sectionIndex),
						getDocument().getParagraphIndex(paragraphInSection.getParagraphId()).getParagraphIndex(),
						paragraphInSection.getZIndex());
			}
		}
	}

	private int findLowestParagraphZIndex(int sectionIndex) {
		int minZIndex = Integer.MAX_VALUE;
		for (int i = 0; i < getDocument().getParagraphCount(sectionIndex); ++i) {
			int zIndex = getDocument().getParagraph(sectionIndex, i).getZIndex();
			minZIndex = minZIndex < zIndex ? minZIndex : zIndex;
		}
		return minZIndex;
	}

	private int getCollagePageIndex(int sectionIndex) {
		Id collageId = getDocument().getSection(sectionIndex).getCollageId();
		return getDocumentLayouter().getCollagePageNumber(collageId);
	}

	protected void closeDocument() {
		this.documentItem = null;
		this.currentSignLocale = null;
	}

	protected Id getFirstSelectedTokenId() {
		return firstSelectedTokenId;
	}

	private void setFirstSelectedTokenId(Id firstSelectedTokenId) {
		this.firstSelectedTokenId = firstSelectedTokenId;
	}

	protected LocalSessionService getLocalSessionService() {
		return localSessionService;
	}

	protected BoxIndex getTokenBoxIndex(Id id) {
		return documentLayouter.getIdBoxIndex(id);
	}

}