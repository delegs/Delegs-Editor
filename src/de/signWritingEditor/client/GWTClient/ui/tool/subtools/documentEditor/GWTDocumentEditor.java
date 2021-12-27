
package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.infrastructure.ClipboardFactory;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoadingDialog;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoCancelDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorButtonBar.DocumentEditorButtonBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar.DocumentEditorSideBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.CopyToClipboardCompletionListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.QuickSaveListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.NewDocumentDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.SaveDocumentDialogBox;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.ContentReportServiceAsync;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeService.LoggingListener;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LoggingServiceAsync;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Clipboard;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TextbasedToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.VideoToken;

public class GWTDocumentEditor extends DocumentEditor implements Tool {

	protected final int MAX_TOKEN_COUNT_FOR_UNKNOWN_USER = 1000;

	private DocumentPanel documentPanel;
	private DocumentEditorButtonBar buttonBar;
	private final String applicationTitle;
	private TokenBoxFactory tokenBoxFactory;

	protected DocumentEditorSidebar documentEditorSidebar;

	private final PdfServiceAsync pdfService;

	private Widget toolPanel;
	private BadgeServiceClient badgeService;
	private ContentReportServiceAsync contentReportService;

	private TokenCountPanel tokenCountPanel;

	public GWTDocumentEditor(UserServiceAsync userService, DictionaryServiceAsync dictionaryService,
			DocumentServiceAsync documentService, PdfServiceAsync pdfService, VideoServiceAsync videoService,
			MediaUrlServiceAsync mediaUrlService, final LoggingServiceAsync loggingService,
			BrowserHistoryService browserHistoryService, BadgeServiceClient badgeService,
			ContentReportServiceAsync contentReportService, URLConverter urlConverter, IdFactory idFactory,
			TextbasedTokenStyleFactory textbasedTokenStyleFactory, String applicationTitle,
			LocalSessionService localSessionService, RoomItem rootRoom, boolean createNewDocument,
			SignLocale defaultSignLocale, DocumentEditorListener listener, TokenBoxFactory tokenBoxFactory,
			FontSizeService fontSizeService) {
		super(dictionaryService, documentService, videoService, mediaUrlService, browserHistoryService, fontSizeService,
				badgeService, idFactory, textbasedTokenStyleFactory, localSessionService, rootRoom, defaultSignLocale,
				listener);
		assert applicationTitle != null : "Precondition failed: applicationTitle != null";
		assert tokenBoxFactory != null : "Precondition failed: tokenBoxFactory != null";

		this.applicationTitle = applicationTitle;
		this.tokenBoxFactory = tokenBoxFactory;
		this.pdfService = pdfService;
		this.badgeService = badgeService;
		this.contentReportService = contentReportService;
		this.tokenCountPanel = new TokenCountPanel(getMaxTokenCountForUnknownUser(), getLocalSessionService());

		setDocumentPanel((DocumentPanel) GWT.create(DocumentPanelImpl.class));
		getDocumentPanel().init();

		fontSizeService.addLoggingListener(new LoggingListener() {

			@Override
			public void logMissingCharacter(char c) {
				loggingService.logMissingCharacter(c, getDocument().getDocumentTitle().getTitleString(),
						new AsyncCallback<Void>() {

							@Override
							public void onSuccess(Void result) {
							}

							@Override
							public void onFailure(Throwable caught) {

							}
						});
			}
		});

		getDocumentPanel().setFontSizeService(fontSizeService);

		getDocumentPanel().setDocumentUiListener(createDocumentUiListener());
		getDocumentPanel().setSaveListener(new QuickSaveListener() {
			@Override
			public void onDocumentQuickSave() {
				handleSaveDocument();
			}
		});
		getDocumentPanel().setUrlConverter(urlConverter);

		this.toolPanel = createToolPanel(userService, mediaUrlService);

		buttonBar = new DocumentEditorButtonBar(tokenCountPanel, createDocumentEditorButtonBarListener());

		if (createNewDocument) {
			createNewDocument();
		}
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	private void setDocumentPanel(DocumentPanel documentPanel) {
		this.documentPanel = documentPanel;
	}

	public GWTDocumentLayouter getLayouter() {
		return getDocumentLayouter();
	}

	@Override
	public Widget getPanel() {
		assert this.toolPanel != null : "Postcondition failed: toolPanel != null";
		return this.toolPanel;
	}

	@Override
	public ButtonBar getButtonBar() {
		return buttonBar;
	}

	@Override
	public int getButtonBarPosition() {
		return 3; // standard position is 3 = after changeTool, undo and redo
	}

	@Override
	public String getTitle() {
		return document.getDocumentTitle().getTitleString();
	}

	@Override
	public void openDocument(Document document, DocumentItem optionalDocumentItem, FolderItem folderItem,
			RoomItem roomContainingDocument) {
		assert document != null : "Precondition failed: document != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert roomContainingDocument != null : "Precondition failed: roomContainingDocument != null";
		getLayouter().setPageFormat(document.getPageFormat());
		super.openDocument(document, optionalDocumentItem, folderItem, roomContainingDocument);

		updateTokenCountPanel();
		updateWindowTitle(document.getDocumentTitle());

		if (documentItemsInCurrentFolder != null && !documentItemsInCurrentFolder.isEmpty()) {

			buttonBar.setPreviousButtonEnabled(true);
			buttonBar.setNextButtonEnabled(true);

			if (currentDocumentIndex == 0) {
				buttonBar.setPreviousButtonEnabled(false);
			}

			if (currentDocumentIndex == documentItemsInCurrentFolder.size() - 1) {
				buttonBar.setNextButtonEnabled(false);
			}
		} else {
			buttonBar.setPreviousButtonEnabled(false);
			buttonBar.setNextButtonEnabled(false);
		}

		buttonBar.setSaveButtonEnabled(optionalDocumentItem == null ? false
				: roomContainingDocument.isModifyFilePermitted(getLocalSessionService().getCurrentUser().getUsername(),
						optionalDocumentItem));
		buttonBar.setSearchWordLineVisibilityCheckboxValue(document.areAllSearchWordLinesVisible());
		buttonBar.setSignVisibilityCheckboxValue(document.areAllSignLinesVisible());
		buttonBar.setFreetextLineVisibilityCheckboxValue(document.areAllFreeTextLinesVisible());
		buttonBar.setGlossWritingCheckBoxValue(document.isGlossWritingActive());
		buttonBar.setAutomaticFreeTextLineCheckBoxValue(document.isAutomaticFreeTextLineEnabled());
		documentEditorSidebar.setNewLocale(document.getSignLocale());
		documentEditorSidebar.updateAddElemtensTab(document.isLayoutLocked());
		documentEditorSidebar.setShowCollageGridSizeValue(getDocument().showCollageGrid());
		documentEditorSidebar.onUserChanged();
		documentEditorSidebar.updateCollageTab(hasCollage());
		Token firstChangeableToken = getFirstChangeableToken(document);
		setCurrentCursorTokenId(firstChangeableToken.getId());
		updateDocumentEditorSidebarForCurrentSelectedToken();

		assert !hasUnsavedChanges() : "Postcondition failed: Document has changed during loading";
	}

	private Token getFirstChangeableToken(Document document) {
		assert document != null : "Precondition failed: document != null";

		List<Token> tokens = document.getTokensFromTo(document.getFirstTokenInDocument().getId(),
				document.getLastTokenInDocument().getId());
		for (Token token : tokens) {
			if (!token.isContentLocked()) {
				return token;
			}
		}
		return null;

	}

	@Override
	public void open() {
		Id currentTokenId = getCurrentCursorTokenId();

		if (documentEditorSidebar != null) {
			documentEditorSidebar.onUserChanged();
		}

		if (currentTokenId != null) {
			focusBoxInUi(currentTokenId);
			centerBoxInUi(currentTokenId);
		}
	}

	private void handleAddCollage() {
		insertCollage();
		documentEditorSidebar.updateCollageTab(hasCollage());
	}

	@Override
	protected void handleDeleteTokenOnCollage(Id tokenId, int sectionIndex, int paragraphIndex, int tokenIndex,
			boolean deletePreviousToken) {
		super.handleDeleteTokenOnCollage(tokenId, sectionIndex, paragraphIndex, tokenIndex, deletePreviousToken);
		documentEditorSidebar.updateCollageTab(hasCollage());
	}

	private void handleDeleteCollage(Id collageId) {
		removeCollage(collageId);
		documentEditorSidebar.updateCollageTab(hasCollage());
	}

	protected void handleDeleteSnippet() {
		super.handleDeleteSnippet();
		documentEditorSidebar.updateCollageTab(hasCollage());
	}

	@Override
	public void handleSave(final SavingFinishedListener listener) {
		assert listener != null : "Precondition failed: listener != null";

		if (hasUnsavedChanges()) {

			handleSaveDocument(new DocumentSaveSuccessListener() {
				@Override
				public void onSaveSuccess() {
					listener.onSavingFinished();
				}
			});
		} else {
			listener.onSavingFinished();
		}
	}

	@Override
	public void close() {
		documentEditorSidebar.resetSidebar();
	}

	@Override
	public Image getIcon() {
		return new Image(RESOURCE.getToolBarIconDocumentEditor());
	}

	@Override
	public int getCursorLeft(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocumentLayouter().containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		return getDocumentPanel().getCursorLeft(boxIndex);
	}

	@Override
	public int getCursorPosition(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocumentLayouter().containsTokenBox(tokenId) : "Precondition failed: containsTokenBox(tokenId)";

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		return getDocumentPanel().getCursorPosition(boxIndex);
	}

	@Override
	public void setFooterText(String newText) {
		assert newText != null : "Precondition failed: newText != null";

		getDocumentPanel().setFooterText(newText);
	}

	@Override
	public void setCursorPositionInUi(Id tokenId, int cursorPosition) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocumentLayouter().containsIdBox(tokenId) : "Precondition failed: containsIdBox(tokenId)";
		assert cursorPosition >= -1 : "Precondition failed: cursorPosition >= -1";

		BoxIndex tokenBoxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(tokenBoxIndex);
		if ((tokenBoxWidget instanceof AbstractTextbasedTokenBoxWidget)
				&& cursorPosition <= ((AbstractTextbasedTokenBoxWidget) tokenBoxWidget).getText().length()) {
			getDocumentPanel().setCursorPositionAndFocus(tokenBoxIndex, cursorPosition);
		} else {
			tokenBoxWidget.focus();
		}
	}

	@Override
	public boolean hasHistorySupport() {
		return false;
	}

	@Override
	protected void focusBoxInUi(Id boxId) {
		assert boxId != null : "Precondition failed: boxId != null";
		assert getDocumentLayouter().containsIdBox(boxId) : "Precondition failed: containsIdBox(boxId)";

		BoxIndex tokenBoxIndex = getDocumentLayouter().getIdBoxIndex(boxId);
		getDocumentPanel().focusIdBoxWidget(tokenBoxIndex);
	}

	private void centerBoxInUi(Id boxId) {
		assert boxId != null : "Precondition failed: boxId != null";
		assert getDocumentLayouter().containsIdBox(boxId) : "Precondition failed: containsIdBox(boxId)";

		BoxIndex tokenBoxIndex = getDocumentLayouter().getIdBoxIndex(boxId);
		getDocumentPanel().centerWidget(tokenBoxIndex);
	}

	@Override
	protected void handleInvalidSessionException() {
		new MessageDialogBox(I18N.getInvalidSessionTitle(), I18N.getInvalidSessionLoginMessage()).center();
		super.handleInvalidSessionException();
	}

	protected void handleSaveDocument() {
		this.handleSaveDocument(new DocumentSaveSuccessListener() {
			@Override
			public void onSaveSuccess() {
			}
		});
	}

	protected void handleSaveAs() {
		if (unknownUserHasTooManyTokens()) {
			openPermissionToSaveDeniedDialogBox();
		} else {
			openSaveDocumentDialogBox(getDocument().getDocumentTitle());
		}
	}

	protected void handleSaveDocument(final DocumentSaveSuccessListener listener) {
		assert listener != null : "Precondition failed: listener != null";

		final Document document = getDocument();
		final FileTitle fileTitle = document.getDocumentTitle();

		if (unknownUserHasTooManyTokens()) {
			openPermissionToSaveDeniedDialogBox();
		} else if (isDocumentNeverSaved() || !getRoomContainingDocument()
				.isModifyFilePermitted(getLocalSessionService().getCurrentUser().getUsername(), getDocumentItem())) {
			openSaveDocumentDialogBox(fileTitle, listener);
		} else {
			final LoadingDialog loadingDialog = new LoadingDialog("Bitte warten", "Dokument wird gespeichert");
			loadingDialog.center();
			FolderItem folderItem = getFolderItemOfDocument();
			saveDocument(document, folderItem, fileTitle, new Callback<DocumentItem, Throwable>() {

				@Override
				public void onSuccess(DocumentItem result) {
					loadingDialog.hide();
					listener.onSaveSuccess();
					// updated a document
					badgeService.userUpdatedDocument();
				}

				@Override
				public void onFailure(Throwable reason) {
					loadingDialog.hide();
				}
			});
		}
	}

	private boolean unknownUserHasTooManyTokens() {
		return getLocalSessionService().isCurrentUserUnknown()
				&& getDocument().getTokenCount() > getMaxTokenCountForUnknownUser();
	}

	protected void openSaveDocumentDialogBox(FileTitle fileTitle) {
		this.openSaveDocumentDialogBox(fileTitle, new DocumentSaveSuccessListener() {

			@Override
			public void onSaveSuccess() {
			}
		});
	}

	protected void handleSaveDocumentAs(final FileTitle fileTitle, FolderItem folderItem,
			final DocumentSaveSuccessListener listener) {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert listener != null : "Precondition failed: listener != null";

		final Document document = getDocument();
		final FileTitle oldDocumentTitle = document.getDocumentTitle();

		setDocumentTitle(fileTitle);
		updateWindowTitle(fileTitle);
		setFolderItemOfDocument(folderItem);
		document.setAuthor(getLocalSessionService().getCurrentUser());

		saveDocument(document, folderItem, fileTitle, new Callback<DocumentItem, Throwable>() {

			@Override
			public void onSuccess(DocumentItem result) {
				buttonBar.setSaveButtonEnabled(true);
				buttonBar.setPreviousButtonEnabled(false);
				buttonBar.setNextButtonEnabled(false);
				listener.onSaveSuccess();
				// saved new document oder saved existing document to new
				// location
				badgeService.userCreatedDocument();
			}

			@Override
			public void onFailure(Throwable reason) {
				setDocumentTitle(oldDocumentTitle);
				updateWindowTitle(oldDocumentTitle);
			}
		});
	}

	protected void openPermissionToSaveDeniedDialogBox() {
		MessageDialogBox permissionDeniedDialogBox = new MessageDialogBox(I18N.getPermissionToSaveDeniedTitle(),
				I18N.getPermissionToSaveDeniedBecauseOfTooManyTokens());
		permissionDeniedDialogBox.center();
		permissionDeniedDialogBox.show();
	}

	protected void openSaveDocumentDialogBox(FileTitle fileTitle, final DocumentSaveSuccessListener listener) {
		assert fileTitle != null : "Precondition failed: fileTitle != null";

		FolderItem browseStartFolder = getFolderItemOfDocument();
		if (getDocumentItem() != null && !getRoomContainingDocument()
				.isModifyFilePermitted(getLocalSessionService().getCurrentUser().getUsername(), getDocumentItem())) {
			browseStartFolder = rootRoom;
		}

		final SaveDocumentDialogBox saveDocumentDialogBox = new SaveDocumentDialogBox(getLocalSessionService(),
				getFontSizeService(), getDocumentService(), browseStartFolder, rootRoom, fileTitle) {

			@Override
			protected void save(FileTitle selectedDocumentTitle, FolderItem folderItem, RoomItem roomContainingFolder) {
				assert selectedDocumentTitle != null : "Precondition failed: selectedDocumentTitle != null";
				assert folderItem != null : "Precondition failed: folderItem != null";
				assert roomContainingFolder != null : "Precondition failed: roomContainingFolder != null";

				setRoomContainingDocument(roomContainingFolder);
				handleSaveDocumentAs(selectedDocumentTitle, folderItem, listener);
			}

			@Override
			protected void onInvalidSessionExceptionCaught() {
				handleInvalidSessionException();
			}
		};

		saveDocumentDialogBox.center();
	}

	@Override
	protected void initLayouter() {
		setDocumentLayouter(new GWTDocumentLayouter(this.getDocumentPanel(), this.tokenBoxFactory));
	}

	protected void handleOpenNewDocument() {
		if (hasUnsavedChanges()) {
			openDocumentUnsavedDialogBox(new DocumentUnsavedQuestionListener() {
				@Override
				public void onQuestionHandled() {
					openNewDocumentDialogBox();
				}
			});
		} else {
			openNewDocumentDialogBox();
		}
	}

	protected void handleCreatePdf() {
		final LoadingDialog loadingDialog = new LoadingDialog(I18N.getPleaseWait(), I18N.getCreatingPdf());
		loadingDialog.center();

		pdfService.exportToPdf(getDocument(), I18NAccess.I18N,
				new SignWritingCallback<String>(I18N.getErrorOnCreatingPdf()) {
					@Override
					public void onSuccess(String result) {
						Window.open(GWT.getModuleBaseURL().replaceAll(GWT.getModuleName() + "/", "") + result, "PDF",
								"");
						loadingDialog.hide();
					}

					@Override
					public void onFailure(Throwable caught) {
						super.onFailure(caught);
						loadingDialog.hide();
					}
				});
	}

	protected void handleToggleSearchWordVisibilty(boolean visible) {
		Document document = getDocument();

		for (int sectionIndex = 0, sectionCount = document
				.getSectionCount(); sectionIndex < sectionCount; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = document
					.getParagraphCount(sectionIndex); paragraphIndex < paragraphCount; paragraphIndex++) {
				Paragraph paragraph = document.getParagraph(sectionIndex, paragraphIndex);
				paragraph.setSearchWordLineVisible(visible);
				for (int tokenIndex = 0, tokenCount = document.getTokenCount(sectionIndex,
						paragraphIndex); tokenIndex < tokenCount; tokenIndex++) {
					Id tokenId = document.getToken(sectionIndex, paragraphIndex, tokenIndex).getId();
					if (getDocumentLayouter().containsIdBox(tokenId)) {
						getDocumentLayouter().setSearchWordVisibility(tokenId, visible);
					}
				}
			}
		}
	}

	protected void handleToggleSignVisibility(boolean visible) {
		Document document = getDocument();

		for (int sectionIndex = 0, sectionCount = document
				.getSectionCount(); sectionIndex < sectionCount; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = document
					.getParagraphCount(sectionIndex); paragraphIndex < paragraphCount; paragraphIndex++) {
				Paragraph paragraph = document.getParagraph(sectionIndex, paragraphIndex);
				paragraph.setSignLineVisible(visible);
				for (int tokenIndex = 0, tokenCount = document.getTokenCount(sectionIndex,
						paragraphIndex); tokenIndex < tokenCount; tokenIndex++) {
					Id tokenId = document.getToken(sectionIndex, paragraphIndex, tokenIndex).getId();
					if (getDocumentLayouter().containsIdBox(tokenId)) {
						getDocumentLayouter().setSignVisibility(tokenId, visible);
					}
				}
			}
		}
	}

	protected void handleToggleFreetextLineVisibility(boolean visible) {
		Document document = getDocument();

		for (int sectionIndex = 0, sectionCount = document
				.getSectionCount(); sectionIndex < sectionCount; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = document
					.getParagraphCount(sectionIndex); paragraphIndex < paragraphCount; paragraphIndex++) {
				Paragraph paragraph = document.getParagraph(sectionIndex, paragraphIndex);
				paragraph.setFreeTextLineVisible(visible);
				for (int tokenIndex = 0; tokenIndex < paragraph.getTokenCount(); tokenIndex++) {
					Token token = paragraph.getToken(tokenIndex);
					if (token instanceof FreeTextToken) {
						Id tokenId = token.getId();
						if (getDocumentLayouter().containsIdBox(tokenId) && ((FreeTextToken) token).isFreeTextLine()) {
							getDocumentLayouter().setFreeTextBoxVisibility(tokenId, visible);
						}
					}
				}
			}
		}
	}

	protected void handleGlossWritingToggled(boolean usingGlossWriting) {
		document.setGlossWritingActive(usingGlossWriting);
		toggleGlossWritingInDocument();
	}

	protected DocumentEditorButtonBarListener createDocumentEditorButtonBarListener() {
		return new DocumentEditorButtonBarListener() {
			@Override
			public void onSaveDocument() {
				handleSaveDocument();
			}

			@Override
			public void onSaveAsDocument() {
				handleSaveAs();
			}

			@Override
			public void onOpenNewDocument() {
				handleOpenNewDocument();
			}

			@Override
			public void onCreatePdf() {
				handleCreatePdf();
			}

			@Override
			public void onPreviousDocument() {
				handlePreviousDocument();
			}

			@Override
			public void onNextDocument() {
				handleNextDocument();
			}

			@Override
			public void onToggleSearchWordVisibility(boolean visible) {
				handleToggleSearchWordVisibilty(visible);
			}

			@Override
			public void onToggleFreetextLineVisibility(boolean visible) {
				handleToggleFreetextLineVisibility(visible);
			}

			@Override
			public void onToggleSignVisibility(boolean visible) {
				handleToggleSignVisibility(visible);
			}

			@Override
			public void onToggleGlossWriting(boolean usingGlossWriting) {
				handleGlossWritingToggled(usingGlossWriting);
			}

			@Override
			public void onToggleAutomaticFreeTextLine(boolean useAutomaticFreeTextLine) {
				handleAutomaticFreeTextLine(useAutomaticFreeTextLine);
			}

		};
	}

	private enum NavigationDirection {
		PREVIOUS, NEXT
	};

	protected void handlePreviousDocument() {
		handleUnsavedChangesBeforeDocumentNavigation(NavigationDirection.PREVIOUS);
	}

	private void updateForPreviousDocument() {
		currentDocumentIndex--;

		if (currentDocumentIndex == 0) {
			buttonBar.setPreviousButtonEnabled(false);
			buttonBar.setNextButtonEnabled(true);
		} else {
			buttonBar.setPreviousButtonEnabled(true);
			buttonBar.setNextButtonEnabled(true);
		}
	}

	protected void handleNextDocument() {
		handleUnsavedChangesBeforeDocumentNavigation(NavigationDirection.NEXT);
	}

	private void updateForNextDocument() {
		currentDocumentIndex++;

		if (currentDocumentIndex == documentItemsInCurrentFolder.size() - 1) {
			buttonBar.setNextButtonEnabled(false);
			buttonBar.setPreviousButtonEnabled(true);
		} else {
			buttonBar.setNextButtonEnabled(true);
			buttonBar.setPreviousButtonEnabled(true);
		}
	}

	private void handleUnsavedChangesBeforeDocumentNavigation(NavigationDirection direction) {
		assert direction != null : "Precondition failed: direction != null";

		if (hasUnsavedChanges()) {
			openDocumentUnsavedDialogBox(new DocumentUnsavedQuestionListener() {
				@Override
				public void onQuestionHandled() {
					updateAndNavigateTo(direction);
				}
			});
		} else {
			updateAndNavigateTo(direction);
		}
	}

	private void updateAndNavigateTo(NavigationDirection direction) {
		assert direction != null : "Precondition failed: direction != null";

		if (NavigationDirection.NEXT.equals(direction)) {
			updateForNextDocument();
		} else if (NavigationDirection.PREVIOUS.equals(direction)) {
			updateForPreviousDocument();
		}

		DocumentItem documentItem = documentItemsInCurrentFolder.get(currentDocumentIndex);
		openDocument(documentItem, getFolderItemOfDocument(), getRoomContainingDocument(),
				documentItemsInCurrentFolder);
	}

	protected void handleAutomaticFreeTextLine(boolean useAutomaticFreeTextLine) {
		document.setAutomaticFreeTextLineEnabled(useAutomaticFreeTextLine);
	}

	private DocumentEditorSideBarListener createDocumentEditorSidebarListener() {
		return new DocumentEditorSideBarListener() {

			@Override
			public void onAddFreeTextBox() {
				handleAddFreeTextToken();
				updateTokenCountPanel();
			}

			@Override
			public void onAddSignItemToken() {
				handleAddSignItem();
				updateTokenCountPanel();
			}

			@Override
			public void onAddFrame() {
				handleAddFrame();
				updateTokenCountPanel();
			}

			@Override
			public void onFontColorChanged(Color fontColor) {
				handleFontColorChanged(fontColor);
			}

			@Override
			public void onFontSizeChanged(FontSize fontSize) {
				handleFontSizeChanged(fontSize);
			}

			@Override
			public void onFontWeightChanged(FontWeight fontWeight) {
				handleFontWeightChanged(fontWeight);
			}

			@Override
			public void onFontStyleChanged(FontStyle fontStyle) {
				handleFontStyleChanged(fontStyle);
			}

			@Override
			public void onFontChanged(Font font) {
				handleFontChanged(font);
			}

			@Override
			public void onAddFreeTextLine() {
				handleAddFreeTextLine();
				updateTokenCountPanel();
			}

			@Override
			public void onChangeLocale(SignLocale locale) {
				handleLocaleChanged(locale);
			}

			@Override
			public void onChangeBackgroundColor(Color color) {
				handleChangeTokenBackgroundColor(color);
			}

			@Override
			public void onChangeTextBackgroundColor(Color color) {
				handleChangeTextBoxBackgroundColor(color);
			}

			@Override
			public void onAddVideo() {
				handleAddVideo();
				updateTokenCountPanel();
			}

			@Override
			public void onAddCollage() {
				handleAddCollage();
			}

			@Override
			public void onDrawSnippets(boolean enabled) {
				getDocumentPanel().setDrawSnippetMode(enabled);
				updateTokenCountPanel();
			}

			@Override
			public void onSendParagraphToFront() {
				handleSendParagraphToFront();
			}

			@Override
			public void onSendParagraphToBack() {
				handleSendParagraphToBack();
			}

			@Override
			public void onAddNormalPage() {
				handleAddNormalPage();
				updateTokenCountPanel();
			}

			@Override
			public void onShowCollageGrid(boolean showGrid) {
				handleShowCollageGrid(showGrid);
			}

			@Override
			public void onDeleteCollageDeleteModeChanged(boolean enabled) {
				getDocumentPanel().setDeleteCollageMode(enabled);
			}

			@Override
			public void onAddImage() {
				handleAddImage();
				updateTokenCountPanel();
			}

		};
	}

	protected void handleShowCollageGrid(boolean showGrid) {
		getDocument().setCollageGridVisibility(showGrid);
		List<Id> collageIds = getDocument().getAllCollageIds();
		getDocumentLayouter().changeCollageGridVisibility(collageIds, showGrid);
	}

	protected void handleAddFreeTextLine() {
		insertFreeTextTokenAfterCurrentToken(true);
	}

	private void handleAddSignItem() {
		insertSignItemTokenAfterCurrentToken();
	}

	protected void handleAddFrame() {
		insertFrameTokenAfterCurrentToken();
	}

	protected void handleAddVideo() {
		insertVideoTokenAfterCurrentToken();
	}

	protected void handleAddImage() {
		insertImageTokenAfterCurrentToken();
	}

	private void handleAddFreeTextToken() {
		insertFreeTextTokenAfterCurrentToken(false);
	}

	protected Widget createToolPanel(UserServiceAsync userService, MediaUrlServiceAsync mediaUrlService) {
		assert this.getDocumentPanel() != null : "Postcondition failed: result != null";

		final ScrollPanel documentPanelView = new ScrollPanel();
		documentPanelView.addStyleName("documentContainer");
		documentPanelView.add((DocumentPanelImpl) this.getDocumentPanel());
		documentPanelView.setHeight("100%");

		FlowPanel contentPanel = new FlowPanel();
		contentPanel.addStyleName("documentEditor");
		contentPanel.add(createSidebar(userService, mediaUrlService));
		contentPanel.add(documentPanelView);

		contentPanel.setWidth("100%");
		return contentPanel;
	}

	private Widget createSidebar(UserServiceAsync userService, MediaUrlServiceAsync mediaUrlService) {
		documentEditorSidebar = new DocumentEditorSidebar(userService, mediaUrlService, getLocalSessionService(),
				createDocumentEditorSidebarListener(), false);
		this.documentEditorSidebar.updateSidebarForTextbasedToken(getDefaultTextbasedTokenStyle(),
				getDefaultSignLocale(), getDefaultBackgroundColor(), true);

		return documentEditorSidebar;
	}

	@Override
	protected void onFreeTextVisibilityChanged() {
		buttonBar.setFreetextLineVisibilityCheckboxValue(getDocument().areAllFreeTextLinesVisible());
	}

	@Override
	protected void onSearchWordVisibilityChanged() {
		buttonBar.setSearchWordLineVisibilityCheckboxValue(getDocument().areAllSearchWordLinesVisible());
	}

	@Override
	protected void onSignVisibilityChanged() {
		buttonBar.setSignVisibilityCheckboxValue(getDocument().areAllSignLinesVisible());
	}

	@Override
	protected void onGlossWritingToggled() {
		buttonBar.setGlossWritingCheckBoxValue(document.isGlossWritingActive());
	}

	@Override
	protected void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler) {
		assert text != null : "Precondition failed: text != null";
		assert completionHandler != null : "Precondition failed: completionHandler != null";

		getDocumentPanel().copyToSystemClipboard(text, completionHandler);
	}

	@Override
	protected void toggleTokenBoxSelection(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocumentLayouter()
				.containsTokenBox(tokenId) : "Precondition failed: getGwtDocumentLayouter().containsTokenBox(tokenId)";

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		getDocumentPanel().toggleTokenBoxWidgetSelection(boxIndex);
	}

	protected boolean isFrameSelected(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert document.getToken(tokenId) instanceof FrameToken : "Precondition failed: token instanceof FrameToken";
		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		return getDocumentPanel().isFrameSelected(boxIndex);
	}

	@Override
	protected void setUnderlineVisibility(boolean visible) {
		getDocumentPanel().setUnderlineVisibility(visible);
	}

	private void openNewDocumentDialogBox() {
		final NewDocumentDialogBox newDocumentDialogBox = new NewDocumentDialogBox(getDefaultSignLocale()) {
			@Override
			protected void handleNewDocument(FileTitle fileTitle, PageFormat pageFormat, SignLocale signLocale) {
				createNewDocument(fileTitle, pageFormat, signLocale, getFolderItemOfDocument(),
						getRoomContainingDocument());
				updateWindowTitle(fileTitle);
			}
		};
		newDocumentDialogBox.center();
	}

	private void openDocumentUnsavedDialogBox(final DocumentUnsavedQuestionListener documentUnsavedQuestionListener) {
		assert documentUnsavedQuestionListener != null : "Precondition failed: documentUnsavedQuestionListener != null";

		YesNoCancelDialogBox yesNoCancelDialogBox = new YesNoCancelDialogBox(I18N.getDocumentNotSaved(),
				I18N.getDoYouWantToSaveTheChanges()) {
			@Override
			public void onYes() {
				handleSaveDocument(new DocumentSaveSuccessListener() {
					@Override
					public void onSaveSuccess() {
						documentUnsavedQuestionListener.onQuestionHandled();
					}
				});
			}

			@Override
			public void onNo() {
				documentUnsavedQuestionListener.onQuestionHandled();
			}
		};
		yesNoCancelDialogBox.center();
	}

	private void updateWindowTitle(FileTitle fileTitle) {
		assert fileTitle != null : "Precondition failed: documentTitle != null";

		Window.setTitle(fileTitle.getTitleString() + " - " + applicationTitle);
	}

	@Override
	public void createNewDocument(FileTitle fileTitle, PageFormat pageFormat, SignLocale signLocale,
			FolderItem currentFolder, RoomItem currentRoom) {

		super.createNewDocument(fileTitle, pageFormat, signLocale, currentFolder, currentRoom);
		buttonBar.setPreviousButtonEnabled(false);
		buttonBar.setNextButtonEnabled(false);
	}

	public interface DocumentSaveSuccessListener {
		void onSaveSuccess();
	}

	public interface DocumentUnsavedQuestionListener {
		void onQuestionHandled();
	}

	@Override
	protected Clipboard initClipboard() {
		ClipboardFactory clipboardFactory = new ClipboardFactory(getIdFactory(), getTokenFactory(),
				getTextbasedTokenStyleFactory(), new PositionedSymbolFactory());
		return clipboardFactory.getClipboard();
	}

	public void onLogin() {
		documentEditorSidebar.onUserChanged();
		DocumentItem documentItem = getDocumentItem();
		buttonBar.setSaveButtonEnabled(documentItem == null ? false
				: getRoomContainingDocument()
						.isModifyFilePermitted(getLocalSessionService().getCurrentUser().getUsername(), documentItem));
		tokenCountPanel.switchToLoggedInMode();
		updateTokenCountPanel();
	}

	@Override
	public void logout() {
		documentEditorSidebar.onUserChanged();
		tokenCountPanel.switchToUnknownMode();
		updateTokenCountPanel();
	}

	@Override
	protected void handleDrawParagraphModeChanged(boolean state) {
		documentEditorSidebar.setDrawParagraphMode(state);
		getDocumentPanel().setDrawSnippetMode(state);
	}

	@Override
	protected void handleDeleteCollageModeChanged(boolean state) {
		documentEditorSidebar.setDeleteCollageMode(state);
		getDocumentPanel().setDeleteCollageMode(state);
	}

	@Override
	public boolean hasUnsavedChanges() {
		return super.hasUnsavedChanges();
	}

	protected void handleSelectBox(Id tokenId, boolean shiftKeyPressed, boolean selectWholeBox,
			boolean selectSignImage) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert getDocument().containsToken(tokenId) : "Precondition failed: document.containsToken(tokenId)";

		clearParagraphSelection();

		if (shiftKeyPressed) {
			if (selectWholeBox || !isCurserInToken(tokenId)) {
				setSelectionAndCursorToAbsoluteLeft(tokenId, 0, true);
			}
		} else {
			Id oldTokenId = getCurrentCursorTokenId();
			if (hasTokenSelection()) {
				deselectTokens();
			} else if (getDocument().getToken(oldTokenId) instanceof FrameToken && !oldTokenId.equals(tokenId)) {
				toggleTokenBoxSelection(oldTokenId);
			}

			// select new token
			setCurrentCursorTokenId(tokenId);
			Token token = getDocument().getToken(tokenId);
			if ((token instanceof FrameToken && !isFrameSelected(tokenId))) {
				toggleTokenBoxSelection(tokenId);
			} else if (selectWholeBox && selectSignImage) {
				setSelectionAndCursorToAbsoluteLeft(tokenId, 0, true);
			}
			if (!selectSignImage) {
				setCurrentCursorTokenId(tokenId);
			}
			if (token instanceof TextbasedToken) {
				setCursorAbsoluteLeft(tokenId);
			}
		}

	}

	private boolean isCurserInToken(Id tokenId) {
		return tokenId.equals(getCurrentCursorTokenId());
	}

	protected DocumentUiListener createDocumentUiListener() {
		return new DocumentUiListener() {

			@Override
			public boolean handleForTokenSelection(Id tokenId, boolean textChanged) {
				boolean handleEventForTokenSelection = handleEventForTokenSelection(tokenId, textChanged);
				updateTokenCountPanel();
				return handleEventForTokenSelection;
			}

			@Override
			public void onMoveCursorToNextBox(Id tokenId, boolean select) {
				handleMoveCursorToNextBox(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onDeletePrevious(Id tokenId) {
				handleDeletePrevious(tokenId);
				updateDocumentEditorSidebarForCurrentSelectedToken();
				updateTokenCountPanel();
			}

			@Override
			public void onDeleteNext(Id tokenId) {
				handleDeleteNext(tokenId);
				updateDocumentEditorSidebarForCurrentSelectedToken();
				updateTokenCountPanel();
			}

			@Override
			public void onSignAlternativeChanged(Id tokenId, SignItem signItem, int selectedSignIndex) {
				handleSignAlternativeChanged(tokenId, signItem, selectedSignIndex);
			}

			@Override
			public void onFreeTextChanged(Id paragraphId, String freeText, int cursorPosition) {
				handleFreeTextChanged(paragraphId, freeText, cursorPosition);
			}

			@Override
			public void onFreeTextVisibilityChanged(Id freeTextBoxId, boolean visible) {
				handleFreeTextVisibilityChanged(freeTextBoxId, visible);
			}

			@Override
			public void onSearchWordVisibilityChanged(Id tokenId, boolean visible) {
				handleSearchWordVisibilityChanged(tokenId, visible);
			}

			@Override
			public void onSignVisibilityChanged(Id tokenId, boolean visible) {
				handleSignVisibilityChanged(tokenId, visible);
			}

			@Override
			public void onMoveCursorToDocumentEnd(Id tokenId, boolean select) {
				handleMoveCursorToDocumentEnd(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToDocumentTop(Id tokenId, boolean select) {
				handleMoveCursorToDocumentTop(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToPreviousParagraph(Id tokenId, boolean select) {
				handleMoveCursorToPreviousParagraph(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToNextParagraph(Id tokenId, boolean select) {
				handleMoveCursorToNextParagraph(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToPreviousPage(Id tokenId, boolean select) {
				handleMoveCursorToPreviousPage(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToNextPage(Id tokenId, boolean select) {
				handleMoveCursorToNextPage(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToPreviousBox(Id tokenId, boolean interactionPreviousWord, boolean select) {
				handleMoveCursorToPreviousBox(tokenId, interactionPreviousWord, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorLineUp(Id tokenId, boolean select) {
				handleMoveCursorLineUp(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorLineDown(Id tokenId, boolean select) {
				handleMoveCursorLineDown(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToLineEnd(Id tokenId, boolean select) {
				handleMoveCursorToLineEnd(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onMoveCursorToLineStart(Id tokenId, boolean select) {
				handleMoveCursorToLineStart(tokenId, select);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onCopy() {
				handleCopy();
			}

			@Override
			public void onPaste(Id id, String pastedText, PasteTarget pasteTarget) {
				handlePaste(id, pastedText, pasteTarget);
				updateTokenCountPanel();
			}

			@Override
			public boolean onCut() {
				boolean cut = handleCut();
				updateTokenCountPanel();
				return cut;
			}

			@Override
			public void onToggleUnderlineVisibility() {
				toggleUnderlineVisibility();
			}

			@Override
			public void onEditSign(SignItem signItem, final Id tokenId) {
				handleEditSign(signItem, tokenId);
			}

			@Override
			public void onTextChanged(Id tokenId, String newText, int invertedCursorPosition) {
				handleTextChangedEvent(tokenId, newText, invertedCursorPosition);
				updateTokenCountPanel();
			}

			@Override
			public void onResizeToken(Id tokenId) {
				handleTokenWidthChanged(tokenId);
			}

			@Override
			public void onSelectToken(Id tokenId, boolean select) {
				handleSelectBox(tokenId, select, true, false);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onSelectToken(Id tokenId, boolean isShiftPressed, boolean selectWholeBox) {
				handleSelectBox(tokenId, isShiftPressed, selectWholeBox, false);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onInsertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter) {
				insertLineOrPageBreakAfterFreeTextToken(tokenId, breakCharacter);
				updateTokenCountPanel();
			}

			@Override
			public void onUpdateVideoSource(Id id, String url) {
				handleUpdateVideoSource(id, url);
			}

			@Override
			public void onPreUpdateVideoSource(Id id, String url) {
				handlePreUpdateVideoSource(id, url);
			}

			@Override
			public void onVideoURLVisibilityChanged(Id tokenId, boolean visible) {
				handleVideoURLVisibilityChanged(tokenId, visible);
			}

			@Override
			public void addParagraph(Id collageId, int x, int y, int width, boolean automaticallyResize) {
				handleAddSnippetToDocument(collageId, x, y, width, automaticallyResize);
				updateTokenCountPanel();
			}

			@Override
			public void onSnippetPositionChanged(Id id, int x, int y, boolean snapped, int deltaX, int deltaY) {
				handleSnippetPositionChanged(id, x, y, snapped, deltaX, deltaY);
			}

			@Override
			public void onDrawParagraphModeChanged(boolean state) {
				handleDrawParagraphModeChanged(state);
			}

			@Override
			public void onDeleteCollageModeChanged(boolean state) {
				handleDeleteCollageModeChanged(state);
			}

			@Override
			public void onSnippetWidthChanged(Id id, int width, boolean automatic) {
				handleSnippetWidthChanged(id, width, automatic);
			}

			@Override
			public void onToggleSnippetSelection(Id id, boolean addToExistingSelection) {
				handleToggleSnippetSelection(id, addToExistingSelection);
			}

			@Override
			public void onDeleteSnippet() {
				handleDeleteSnippet();
				updateTokenCountPanel();
			}

			@Override
			public void onDeselection(boolean deactivate) {
				handleDeselection(deactivate);
			}

			@Override
			public void onSelectSnippetsFromTo(Id collageId, int x, int y, int width, int height,
					boolean addToExistingSelection) {
				handleSelectSnippetsFromTo(collageId, x, y, width, height, addToExistingSelection);
			}

			@Override
			public void onDeleteCollage(Id collageId) {
				handleDeleteCollage(collageId);
				updateTokenCountPanel();
			}

			@Override
			public void onImageUrlChanged(Id id, String newUrl) {
				handleImageUrlChanged(id, newUrl);
			}

			@Override
			public void onSelectSearchWord(Id tokenId, boolean isShiftPressed) {
				handleSelectSearchWord(tokenId, isShiftPressed);
				updateDocumentEditorSidebarForCurrentSelectedToken();
			}

			@Override
			public void onInsertFreeTextLineAfterToken(Id id) {
				handleInsertFreeTextLineAfterToken(id);
				updateTokenCountPanel();
			}

			@Override
			public void onReport(String url) {
				handleReportContent(url);
			}

			@Override
			public void onInputContentChanged(Id tokenId, String inputContent, int cursorPosition) {
				handleFormInputChanged(tokenId, inputContent, cursorPosition);

			}

			@Override
			public void onSuggestBoxHeightChanged(Id tokenId, int newHeight) {
				handleSuggestBoxHeightChanged(tokenId, newHeight);

			}
		};
	}

	private void handleReportContent(final String url) {
		YesNoDialogBox yesNoDialogBox = new YesNoDialogBox(I18N.getOnReportContent(),
				I18N.getOnReportContentDesision()) {

			@Override
			public void onYes() {
				Id documentId = null;
				if (getDocumentItem() != null) {
					documentId = getDocumentItem().getId();
				}
				contentReportService.reportUrl(getLocalSessionService().getCurrentUser().getUsername(),
						getDocument().getAuthor().getUsername(), new Date(), documentId,
						getDocument().getDocumentTitle(), url,
						new SignWritingCallback<Void>(I18N.getOnReportedContentFailed()) {
							@Override
							public void onSuccess(Void result) {
								Window.alert(I18N.getOnReportedContentSuccessfully());
							}
						});
			}

			@Override
			public void onNo() {
				// No!
			}
		};
		yesNoDialogBox.center();
		yesNoDialogBox.show();
	}

	private void handleInsertFreeTextLineAfterToken(Id id) {
		insertFreeTextTokenAfterToken(id, true);
	}

	private void updateDocumentEditorSidebarForCurrentSelectedToken() {
		Token token = getDocument().getToken(getCurrentCursorTokenId());
		SignLocale locale = documentEditorSidebar.getSelectedLocale();
		if (token instanceof SignItemToken) {
			locale = ((SignItemToken) token).getLocale();
		}
		boolean hasMultipleTokenSelection = false;
		if (hasTokenSelection()) {
			hasMultipleTokenSelection = getTokensBetweenInklusive(getFirstSelectedTokenId(), getCurrentCursorTokenId())
					.size() > 1;
		}
		BoxIndex index = getDocumentLayouter().getIdBoxIndex(getCurrentCursorTokenId());
		AbstractTokenBoxWidget widget = documentPanel.getTokenBoxWidget(index);
		if (hasMultipleTokenSelection == false) {
			if (token instanceof VideoToken) {
				documentEditorSidebar.updateSidebarForVideoToken((VideoTokenBoxWidget) widget);
			} else if (token instanceof ImageToken) {
				documentEditorSidebar.updateSidebarForImageToken((ImageTokenBoxWidget) widget);
			} else if (token instanceof TagToken) {
				documentEditorSidebar.updateSidebarForNonVideoToken(widget);
				documentEditorSidebar.updateSidebarForTextbasedToken(((TextbasedToken) token).getStyle(), locale,
						token.getBackgroundColor(), !hasMultipleTokenSelection);
			} else if (token instanceof SignItemToken) {
				documentEditorSidebar.updateSidebarForNonVideoToken(widget);
				documentEditorSidebar.updateSidebarForTextbasedToken(((TextbasedToken) token).getStyle(), locale,
						token.getBackgroundColor(), !hasMultipleTokenSelection);
			} else if (token instanceof FormToken) {
				documentEditorSidebar.updateSidebarForNonVideoToken(widget);
				documentEditorSidebar.updateSidebarForTextbasedToken(((TextbasedToken) token).getStyle(), locale,
						token.getBackgroundColor(), !hasMultipleTokenSelection);
			} else if (token instanceof FreeTextToken) {
				documentEditorSidebar.updateSidebarForNonVideoToken(widget);
				documentEditorSidebar.updateSidebarForTextbasedToken(((TextbasedToken) token).getStyle(), locale,
						token.getBackgroundColor(), !hasMultipleTokenSelection);
			} else {
				documentEditorSidebar.updateSidebarForNonTextbasedToken(token.getBackgroundColor());
			}
		} else {
			documentEditorSidebar.updateSidebarForMultipleTokens();
		}
	}

	protected void handleSelectSearchWord(Id tokenId, boolean isShiftPressed) {
		handleSelectBox(tokenId, isShiftPressed, true, true);
	}

	@Override
	public void discardChanges() {
		closeDocument();
	}

	private void updateTokenCountPanel() {
		if (getDocument() != null) {
			tokenCountPanel.setTokenCount(getDocument().getTokenCount());
		}
	}

	protected int getMaxTokenCountForUnknownUser() {
		return MAX_TOKEN_COUNT_FOR_UNKNOWN_USER;
	}
}
