package de.signWritingEditor.shared.i18n;

import de.badge.shared.i18n.BadgeI18NProvider;

import java.io.Serializable;

public interface I18N extends BadgeI18NProvider, Serializable {

	I18NLocale getLocale();

	String getBadge();

	String getLocaleName();

	String getOwner();

	String getCancel();

	String getCheckUserNameAndPassword();

	String getCreatingPdf();

	String getCreationDate();

	String getDateTimeFormat();

	String getDateFormat();

	String getNewFile();

	String getDoChangeTitle();

	String getDoCreatePdf();

	String getDoDeleteDocument();

	String getDoLogin();

	String getDoLogout();

	String getDoOpenDocument();

	String getSaveAs();

	String getErrorOnCreatingPdf();

	String getErrorOnMoveFiles();

	String getErrorOnInitialisingIds();

	String getErrorOnDeletingDocument();

	String getErrorOnDeletingDocuments();

	String getErrorOnLoadingDocument();

	String getErrorOnLoadingDocumentNames();

	String getErrorOnLoadingRootFolderItem();

	String getErrorOnLoadingFolder();

	String getErrorOnLogin();

	String getErrorOnSavingDocument();

	String getDocumentName();

	String getName();

	String getHello();

	String getLoadingDocument();

	String getLoginFailed();

	String getModificationDate();

	String getNewDocument();

	String getNote();

	String getPassword();

	String getPleaseWait();

	String getTheDocument0CouldNotBeDeleted(Object param0);

	String getTheDocuments0CouldNotBeDeleted(Object param0);

	String getUserName();

	String getVersion();

	String getClose();

	String getPleaseEnterValidFileName();

	String getPleaseEnterValidRoomName();

	String getFileNameAlreadyTaken();

	String getSave();

	String getDocumentAlreadyExists();

	String getFolderAlreadyExists();

	String getCantMoveFolderIntoItself();

	String getOverwriteQuestion();

	String getYes();

	String getNo();

	String getAccept();

	String getDecline();

	String getConfirmDeleteItem();

	String getConfirmDeleteItems();

	String getConfirmDeletionTitle();

	String getConfirmMoveItemToRecycleBin();

	String getConfirmMoveItemsToRecycleBin();

	String getFreetextVisibility();

	String getGlossWriting();

	String getSearchWordLine();

	String getSignLocaleDescription();

	String getPageFormatDescription();

	String getNewFolder();

	String getFolderName();

	String getRoomDescription();

	String getNewFileTitle();

	String getErrorOnCreatingNewFolder();

	String getErrorOnRenamingFile();

	String getMoveFile();

	String getRenameFile();

	String getTypeName();

	String getRecycleBinName();

	String getAccessDeniedTitle();

	String getInvalidSessionTitle();

	String getInvalidSessionLoginMessage();

	String getErrorOnInitialisingDocumentManager();

	String getErrorOnSyncFilesWithServer();

	String getErrorLoadingSign();

	String getAccessDeniedOnDeletingFile();

	String getAccessDeniedOnDeletingFiles();

	String getAccessDeniedOnMovingFiles();

	String getAccessDeniedOnCreatingNewFolder();

	String getAccessDeniedOnOpeningFolder();

	String getAccessDeniedOnRenamingFile();

	String getAccessDeniedOnOpeningDocument();

	String getAccessDeniedOnLoadDocument();

	String getAccessDeniedOnEnteringRoom();

	String getRoomPolicyIndividualLongDescription();

	String getRoomPolicySharedLongDescription();

	String getRoomPolicyCollectiveLongDescription();

	String getRoomPolicyShowroomLongDescription();

	String getRoomPolicy();

	String getLeaveRoomForever();

	String getRoomUsers();

	String getResponsible();

	String getAllUsers();

	String getDocumentNotSaved();

	String getDoYouWantToSaveTheChanges();

	String getDocumentManager();

	String getErrorOnLoadingSigns();

	String getWhenYouLeavePageUnsavedChangesGetLost();

	String getDoDeleteSymbol();

	String getAccessDeniedOnSaveOrUpdateDocument();

	String getAccessDeniedOnOverwritingDocument();

	String getPaperSizeLandscape();

	String getPaperSizePortrait();

	String getUnknownUserName();

	String getPublicRoomName();

	String getRootFolderName();

	String getSignWritingLine();

	String getSignEditor();

	String getErrorLoadingSymbols();

	String getDeleteAllVisemes();

	String getArrangeVisemes();

	String getErrorOnLoadingHandSymbolVariations();

	String getErrorOnLoadingArrowSymbolVariations();

	String getEditSymbol();

	String getNewRoom();

	String getRoomnameCollision();

	String getRoomNameDuplicateWarning();

	String getRoomName();

	String getPrivateRoom();

	String getPleaseEnterValidUsernames();

	String getErrorOnLoadingUsers();

	String getErrorOnCreatingNewRoom();

	String getErrorOnChangingColorLabels();

	String getColorLabel();

	String getEditHead();

	String getEditViseme();

	String getEditEyes();

	String getEditMovement();

	String getUndo();

	String getRedo();

	String getDiscard();

	String getRegistrationInvalidUserName();

	String getRegistrationInvalidLastNameField();

	String getRegistrationInvalidFirstNameField();

	String getRegistrationInvalidMailAddress();

	String getRegistrationInvalidPassword();

	String getRegistrationPasswordMismatch();

	String getValidationEmailSubjectForUser();

	String getValidationEmailTextForUser(String userName, String validationUrlString);

	String getAccountValidationSuccessful();

	String getSearchButtonText();

	String getSearchWord();

	String getReplace();

	String getSaveNew();

	String getSaveInDocumentOnly();

	String getAccountNotActivated();

	String getRegistrationNotPossible();

	String getInvalidUsername();

	String getInvalidEmailAddress();

	String getRegistrationError();

	String getActivateAccount();

	String getUserNameNotAvailable();

	String getEmailAddressNotAvailable();

	String getRegistrationDialogueMessageTextForUser(String firstname, String lastname);

	String getUserNameOrEmailAddress();

	String getPasswordForgottenInputInvalid();

	String getServiceNotAvailable();

	String getPasswordForgottenNoEmailAddress();

	String getPasswordForgottenSubjectForUser();

	String getPasswordForgottenEmailTextForUser(String username, String link);

	String getPasswordForgotten();

	String getPasswordForgottenSentMail();

	String getTechnicalError();

	String getPasswordChanged();

	String getNewPassword();

	String getRepeatNewPassword();

	String getChangePassword();

	String getCopySymbol();

	String getDelete();

	String getDeleteAskForConfirmationMessage();

	String getNoDocumentsFound();

	String getChangeComment();

	String getInvalidCharacter();

	String getComment();

	String getAuthor();

	String getUnsavedSign();

	String getEditCheeks();

	String getEditBreath();

	String getEditHair();

	String getEditExpression();

	String getEditNeck();

	String getEditNose();

	String getEditCollection();

	String getEditEars();

	String getEditJaw();

	String getAddMovementWallPlaneSymbol();

	String getAddMovementFloorPlaneSymbol();

	String getAddMovementDiagonalPlaneSymbol();

	String getAddMovementCurvesHitFloorPlaneSymbol();

	String getAddMovementCircleSymbol();

	String getAddMovementSymbol();

	String getCopyFile();

	String getAccessDeniedOnCopyingFiles();

	String getInsert();

	String getInsertSymbols();

	String getShouldersAndHip();

	String getLegsAndArms();

	String getFinger();

	String getTopView();

	String getNewUser();

	String getRegister();

	String getFirstName();

	String getLastName();

	String getEmailAdress();

	String getInsertText();

	String getLoadNewText();

	String getContinue();

	String getAddNewElement();

	String getDocumentEditorSidebarName();

	String getFreeTextBox();

	String getSignItem();

	String getFontSize();

	String getFontStyleItalics();

	String getFontWeight();

	String getFontColor();

	String getStandardColors();

	String getDesignColors();

	String getInvalidSearchWord();

	String getFreeTextLine();

	String getAirRelatedBodySymbols();

	String getLoaded();

	String getSelectDictionary();

	String getAddUser();

	String getRoomManagement();

	String getDeleteUser();

	String getRoomPolicyCollective();

	String getRoomPolicyShared();

	String getRoomPolicyIndividual();

	String getRoomPolicyShowroom();

	String getUserAddedToRoomSuccessfully();

	String getFailMessageAddUserToRoom();

	String getFailMessageRemoveUserFromRoom();

	String getRemovedUserFromRoomSuccessfully();

	String getAdminAddedToRoomSuccessfully();

	String getFailMessageAddAdminToRoom();

	String getFailMessageRemoveAdminFromRoom();

	String getRemovedAdminFromRoomSuccessfully();

	String getRoomPolicyManagement();

	String getRoomUserManagement();

	String getRoomVisibilityManagement();

	String getRoomVisibilityInfo();

	String getRoomAdminManagement();

	String getAddAdmin();

	String getDeleteAdmin();

	String getFrame();

	String getFreePositionVisemes();

	String getAutomaticFreeTextLine();

	String getVideo();

	String getImage();

	String getEditHands();

	String getAddHandsSymbol();

	String getDoYouWantToSaveTheSignWithANewName();

	String getCreatedBy();

	String getEditedOn();

	String getLocalSign();

	String getGlobalSign();

	String getFreeLayout();

	String getCollage();

	String getSnippet();

	// Tutorial Strings

	String getSignUp();

	String getLogin();

	String getCreateNewDocument();

	String getSaveDocument();

	String getAddSignToken();

	String getChangeSignBackground();

	String getChangeSignwordVisibility();

	String getGlossWritingOnOff();

	String getAddNewPage();

	String getChangeLineVisibility();

	String getChangeFontStyle();

	String getToggleSearchWordVisibility();

	String getAddTextbox();

	String getChangeFontColor();

	String getChangeFontBackgroundColor();

	String getChangeSignVartiation();

	String getGlossWritingAndAutomaticFreeTextLine();

	String getCopyDocument();

	String getRenameDocument();

	String getChangeColorLabel();

	String getDeleteDocument();

	String getCreateNewFolder();

	String getSearchForDocument();

	String getInsertDeleteAndResizeToken();

	String getFontFormating();

	String getDocumentEditor();

	String getOpenSignEditor();

	String getAddHeadSymbol();

	String getPositionHeadSymbols();

	String getMirrorHands();

	String getAddHand();

	String getChangeLayer();

	String getCreateNameExample();

	String getDelegsCopyright();

	String getNormalPage();

	String getPrivacyPolicyAgreement();

	String getRegistrationNoPrivacyPolicyAgreement();

	String getAgeVerification();

	String getRegistrationNoAgeVerification();

	String getPrivacyPolicyUpdate();

	String getPrivacyPolicyUpdateMessage();

	String getPrivacyPolicy();

	String getPrivacyPolicyText();

	String getOpenPrivacyPolicy();

	String getImprint();

	String getImprintText();

	String getHelp();

	String getOperationInvalid();

	String getFailMessageDocumentNotFound();

	String getFailMessageFolderNotFound();

	String getFailMessageBrowserHistory();

	String getFailMessageBrowserHistoryLoadFailed();

	String getInvalidEmptySign();

	String getShowGrid();

	String getDeleteCollage();

	String getStayInEditor();

	String getDoYouWantToDiscardTheChanges();

	String getEditLayout();

	String getEditVideoToken();

	String getEditImageToken();

	String getEditFont();

	String getChooseTextColor();

	String getChooseSignBoxBackgroundColor();

	String getChooseTextBoxBackgroundColor();

	String getEditCollage();

	String getDecreaseZIndex();

	String getIncreaseZIndex();

	String getHideGrid();

	String getLoginRequired();

	String getSkinColors();

	String getFingerAlphabet();

	String getSpellSearchwordToFingerAlphabet();

	String getArrangeFingerAlphabet();

	String getTooltipRoomOwnerTextBox();

	String getDifferentDayLoginBadgeTitle();

	String getDifferentDayLoginBadgeDescription();

	String getDifferentDayLoginBadgeStatusForNone(long x);

	String getDifferentDayLoginBadgeStatusForBronze(long x);

	String getDifferentDayLoginBadgeStatusForSilver(long x);

	String getLocalSignCreatorBadgeTitle();

	String getLocalSignCreatorBadgeDescription();

	String getLocalSignCreatorBadgeStatusForNone(long x);

	String getLocalSignCreatorBadgeStatusForBronze(long x);

	String getLocalSignCreatorBadgeStatusForSilver(long x);

	String getLongTimeUserBadgeTitle();

	String getLongTimeUserBadgeDescription();

	String getLongTimeUserBadgeStatusForNone(long x);

	String getLongTimeUserBadgeStatusForBronze(long x);

	String getLongTimeUserBadgeStatusForSilver(long x);

	String getLoginStreakBadgeTitle();

	String getLoginStreakBadgeDescription();

	String getLoginStreakBadgeStatusForNone(long x);

	String getLoginStreakBadgeStatusForBronze(long x);

	String getLoginStreakBadgeStatusForSilver(long x);

	String getDocumentCreatorBadgeTitle();

	String getDocumentCreatorBadgeDescription();

	String getDocumentCreatorBadgeStatusForNone(long x);

	String getDocumentCreatorBadgeStatusForBronze(long x);

	String getDocumentCreatorBadgeStatusForSilver(long x);

	String getNoviceBadgeTitle();

	String getNoviceBadgeDescription();

	String getNoviceBadgeStatusForNone();

	String getNoviceBadgeStatusForBronze();

	String getNoviceBadgeStatusForSilver();

	String getBadgeStatusForHighestRank();

	String getCongratulationsForReceivingNewBadges();

	String getReportButtonTitle();

	String getOnReportContent();

	String getOnReportContentDesision();

	String getOnReportedContentSuccessfully();

	String getOnReportedContentFailed();

	String getRoomUserDeleteTitle();

	String getRoomUserDeleteMessage(String user);

	String getLeaveRoomForeverTitle();

	String getLeaveRoomForeverMessage();

	String getPermissionToSaveDeniedTitle();

	String getPermissionToSaveDeniedBecauseOfTooManyTokens();

	String getTokenCountInfoToolTipTextForUnknownUser();

	String getTokenCountInfoToolTipTextForRegisteredUser();

	String getTokenCountMaxElementsText();

	String getElements();

	String getInvalidSessionLoginDialogMessage();

	String getShowRoomName();

	String getMissingAuthorization();

	String getDeleteSignNotAllowed();

	String getSaveSignNotAllowed();

	String getAddUserToRoomNotAllowed();

	String getDeleteUserToRoomNotAllowed();

	String getAddAdminToRoomNotAllowed();

	String getDeleteAdminToRoomNotAllowed();

	String getPermissionForActionDenied();

	String getImageNotFound();

	String getImageTooLarge();

	String getWebsideNotSupported();

	String getNoVideoFound();

	String getVideoConverting();

	String getUpload();

	String getMaxVideoLenghtMessage(int i);

	String getVideoFormatMessage();

	String getVideoRecordInstructions();

	String getVideoRecorderCaption();

	String getStartVideoRecorder();

	String getStopVideoRecorder();

	String getVideoFileName();

	String getVideoRecordingCountDown(int counter);

	String getRecordingForXSeconds(int counter);

	String getVideoRecording();

	String getBrowserNotSupported();

	String getVideoRecordingSuccessfull();

	String getDefaultVideoFileName();

	String getErrorNoCameraFound();

	String getCameraPermissionDenied();

	String getCameraAlreadyInUse();

	String getReStartVideoRecorder();

	String getProgressBarTextAbove();

	String getProgressBarTextUnder();

	String getUrlLabel();

	String getVideoUrlPlaceholder();

	String getImageUrlPlaceholder();

	String getNoVideoLoaded();

	String getCLickCtrlLeftToOpen();

	String getPrevDocument();

	String getNextDocument();
}