package de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

import de.badge.client.gwtClient.ui.resources.BadgeImageProvider;

public interface Resources extends ClientBundle, BadgeImageProvider {
	public static final Resources RESOURCE = GWT.create(Resources.class);

	@Source("icon-pdf-document.png")
	ImageResource getIconPDF();

	@Source("uploadVideo.png")
	ImageResource getUploadVideoIcon();

	@Source("report.png")
	ImageResource getReportIcon();

	@Source("check.png")
	ImageResource getCheckIcon();

	@Source("icon-file.png")
	ImageResource getFileIcon();

	@Source("icon-template.png")
	ImageResource getTemplateIcon();

	@Source("icon-template-invalid.png")
	ImageResource getTemplateInvalidIcon();

	@Source("icon-folder.png")
	ImageResource getFolderIcon();

	@Source("icon-room.png")
	ImageResource getRoomIcon();

	@Source("icon-room_locked.png")
	ImageResource getRoomIconLocked();

	@Source("icon-recycle-bin.png")
	ImageResource getRecycleBinIcon();

	@Source("up.png")
	ImageResource getToolBarIconUp();

	@Source("down.png")
	ImageResource getToolBarIconDown();

	@Source("left.png")
	ImageResource getToolBarIconLeft();

	@Source("icon-empty.png")
	ImageResource getToolBarIconEmpty();

	@Source("right.png")
	ImageResource getToolBarIconRight();

	@Source("icon-home-back.png")
	ImageResource getToolBarIconDocumentManager();

	@Source("icon-document-back.png")
	ImageResource getToolBarIconDocumentEditor();

	@Source("icon-document-next.png")
	ImageResource getToolBarIconNextDocument();

	@Source("icon-document-previous-active.png")
	ImageResource getToolBarIconPreviousDocumentActive();

	@Source("icon-document-next-active.png")
	ImageResource getToolBarIconNextDocumentActive();

	@Source("icon-new-document.png")
	ImageResource getToolBarIconNewDocument();

	@Source("icon-new-folder.png")
	ImageResource getToolBarIconNewFolder();

	@Source("icon-new-folder_disabled.png")
	ImageResource getToolBarIconNewFolderDis();

	@Source("icon-new-room.png")
	ImageResource getToolBarIconNewRoom();

	@Source("icon-new-room_disabled.png")
	ImageResource getToolBarIconNewRoomDis();

	@Source("icon-delete-document.png")
	ImageResource getToolBarIconDeleteDocument();

	@Source("icon-delete-document_disabled.png")
	ImageResource getToolBarIconDeleteDocumentDis();

	@Source("icon-delete-symbol.png")
	ImageResource getToolBarIconDeleteSymbol();

	@Source("icon-handsymbol-rotate_clockwise.png")
	ImageResource getIconMovementSymbolRotateClockwise();

	@Source("icon-handsymbol-rotate_counterclockwise.png")
	ImageResource getIconMovementSymbolRotateCounterClockwise();

	@Source("icon-handsymbol-rotate_clockwise.png")
	ImageResource getIconHandSymbolRotateClockwise();

	@Source("icon-handsymbol-rotate_clockwise_disabled.png")
	ImageResource getIconHandSymbolRotateClockwiseDis();

	@Source("icon-handsymbol-rotate_counterclockwise.png")
	ImageResource getIconHandSymbolRotateCounterClockwise();

	@Source("icon-handsymbol-rotate_counterclockwise_disabled.png")
	ImageResource getIconHandSymbolRotateCounterClockwiseDis();

	@Source("icon-handsymbol-pitch.png")
	ImageResource getIconHandSymbolPitch();

	@Source("icon-handsymbol-pitch-disabled.png")
	ImageResource getIconHandSymbolPitchDisabled();

	@Source("icon-handsymbol-roll.png")
	ImageResource getIconHandSymbolRoll();

	@Source("icon-handsymbol-roll-disabled.png")
	ImageResource getIconHandSymbolRollDisabled();

	@Source("icon-handsymbol-mirror.png")
	ImageResource getIconHandSymbolMirror();

	@Source("icon-handsymbol-mirror-disabled.png")
	ImageResource getIconHandSymbolMirrorDisabled();

	@Source("icon-mirror-vertically-symbol.png")
	ImageResource getIconSymbolMirrorVertically();

	@Source("icon-mirror-vertically-symbol-disabled.png")
	ImageResource getIconSymbolMirrorVerticallyDisabled();

	@Source("icon-switch-hand-symbol.png")
	ImageResource getIconSwitchHandSymbol();

	@Source("icon-switch-hand-symbol-disabled.png")
	ImageResource getIconSwitchHandSymbolDisabled();

	@Source("icon-increase-z-index-symbol.png")
	ImageResource getIconIncreaseZIndexSymbol();

	@Source("icon-increase-z-index-symbol-disabled.png")
	ImageResource getIconIncreaseZIndexSymbolDisabled();

	@Source("icon-decrease-z-index-symbol.png")
	ImageResource getIconDecreaseZIndexSymbol();

	@Source("icon-decrease-z-index-symbol-disabled.png")
	ImageResource getIconDecreaseZIndexSymbolDisabled();

	@Source("icon-remove-symbol.png")
	ImageResource getIconRemoveSymbol();

	@Source("icon-remove-symbol-disabled.png")
	ImageResource getIconRemoveSymbolDisabled();

	@Source("icon-duplicate-symbol.png")
	ImageResource getIconDuplicateSymbol();

	@Source("icon-duplicate-symbol-disabled.png")
	ImageResource getIconDuplicateSymbolDisabled();

	@Source("icon-delete-symbol_disabled.png")
	ImageResource getToolBarIconDeleteSymbolDis();

	@Source("icon-open-document.png")
	ImageResource getToolBarIconOpen();

	@Source("icon-open-document_disabled.png")
	ImageResource getToolBarIconOpenDis();

	@Source("icon-pdf-print-document.png")
	ImageResource getToolBarIconPDF();

	@Source("icon-save-document.png")
	ImageResource getToolBarIconSave();

	@Source("icon-save-document_disabled.png")
	ImageResource getToolBarIconSaveDis();

	@Source("icon-save-as-document.png")
	ImageResource getToolBarIconSaveAs();

	@Source("icon-save-as-document-disabled.png")
	ImageResource getToolBarIconSaveAsDis();

	@Source("icon-rename-folder_disabled.png")
	ImageResource getToolBarIconRenameDis();

	@Source("icon-rename-folder.png")
	ImageResource getToolBarIconRename();

	@Source("icon-move_disabled.png")
	ImageResource getToolBarIconMoveDis();

	@Source("icon-move.png")
	ImageResource getToolBarIconMove();

	@Source("icon-copy-document-disabled.png")
	ImageResource getToolBarIconCopyDis();

	@Source("icon-copy-document.png")
	ImageResource getToolBarIconCopy();

	@Source("icon-login.png")
	ImageResource getToolBarIconLogin();

	@Source("icon-logout.png")
	ImageResource getToolBarIconLogout();

	@Source("icon-color-label.png")
	ImageResource getToolBarIconColorLabel();

	@Source("icon-color-label_disabled.png")
	ImageResource getToolBarIconColorLabelDis();

	@Source("wps-logo.png")
	ImageResource getWpsLogo();

	@Source("button-up.png")
	ImageResource getToolTipButtonUp();

	@Source("button-down.png")
	ImageResource getToolTipButtonDown();

	@Source("Edit.png")
	ImageResource getSignEditButton();

	@Source("icon-help.png")
	ImageResource getToolbarHelpIcon();

	@Source("icon-close.png")
	ImageResource getCloseButtonIcon();

	@Source("filepath_widget_arrow_right.png")
	ImageResource getFilePathWidgetRightArrow();

	@Source("filepath_widget_arrow_right_hover.png")
	ImageResource getFilePathWidgetRightArrowHover();

	@Source("icon-room_big.png")
	ImageResource getIconRoomBig();

	@Source("icon-home_big.png")
	ImageResource getIconHomeBig();

	@Source("collectiveContent.png")
	ImageResource getCollectiveRoomPolicyImage();

	@Source("sharedContent.png")
	ImageResource getSharedRoomPolicyImage();

	@Source("individualContent.png")
	ImageResource getIndividualRoomPolicyImage();

	@Source("showroom.png")
	ImageResource getShowroomPolicyImage();

	@Source("loader.gif")
	ImageResource getLoadingImage();

	@Source("user_icon.png")
	ImageResource getUserIconImage();

	@Source("icon-head-placeholder.png")
	ImageResource getIconHeadPlaceholderImage();

	@Source("icon-search.png")
	ImageResource getToolBarIconSearch();

	@Source("icon-search-disabled.png")
	ImageResource getToolBarIconSearchDis();

	@Source("icon-search-big.png")
	ImageResource getIconSearchBig();

	@Source("icon-increase-symbol.png")
	ImageResource getIconIncreaseSymbol();

	@Source("icon-increase-symbol-disabled.png")
	ImageResource getIconIncreaseSymbolDisabled();

	@Source("icon-decrease-symbol.png")
	ImageResource getIconDecreaseSymbol();

	@Source("icon-decrease-symbol-disabled.png")
	ImageResource getIconDecreaseSymbolDisabled();

	@Source("icon-to-alternating-arrows.png")
	ImageResource getIconSwitchToAlternatingArrowsSymbol();

	@Source("icon-to-alternating-arrows-disabled.png")
	ImageResource getIconSwitchToAlternatingArrowsSymbolDisabled();

	@Source("icon-to-normal-arrows.png")
	ImageResource getIconSwitchToNormalArrowsSymbol();

	@Source("icon-to-normal-arrows-disabled.png")
	ImageResource getIconSwitchToNormalArrowsSymbolDisabled();

	@Source("icon-switch-size-symbol.png")
	ImageResource getIconSwitchSizeSymbol();

	@Source("icon-switch-size-symbol-disabled.png")
	ImageResource getIconSwitchSizeSymbolDisabled();

	@Source("icon-toggle-left-symbol.png")
	ImageResource getIconToggleLeftEarSymbol();

	@Source("icon-toggle-left-symbol-disabled.png")
	ImageResource getIconToggleLeftEarSymbolDisabled();

	@Source("icon-toggle-right-symbol.png")
	ImageResource getIconToggleRightEarSymbol();

	@Source("icon-toggle-right-symbol-disabled.png")
	ImageResource getIconToggleRightEarSymbolDisabled();

	@Source("icon-switch-starting-point.png")
	ImageResource getIconSwitchStartingPointSymbol();

	@Source("icon-switch-starting-point-disabled.png")
	ImageResource getIconSwitchStartingPointSymbolDisabled();

	@Source("icon-toggle-left-symbol.png")
	ImageResource getIconToggleLeftCheekSymbol();

	@Source("icon-toggle-left-symbol-disabled.png")
	ImageResource getIconToggleLeftCheekSymbolDisabled();

	@Source("icon-toggle-right-symbol.png")
	ImageResource getIconToggleRightCheekSymbol();

	@Source("icon-toggle-right-symbol-disabled.png")
	ImageResource getIconToggleRightCheekSymbolDisabled();

	@Source("icon-toggle-left-symbol.png")
	ImageResource getIconToggleLeftBreathSymbol();

	@Source("icon-toggle-left-symbol-disabled.png")
	ImageResource getIconToggleLeftBreathSymbolDisabled();

	@Source("icon-toggle-right-symbol.png")
	ImageResource getIconToggleRightBreathSymbol();

	@Source("icon-toggle-right-symbol-disabled.png")
	ImageResource getIconToggleRightBreathSymbolDisabled();

	@Source("icon-all-movement-symbols.png")
	ImageResource getIconAllMovementSymbols();

	@Source("icon-switch-plane.png")
	ImageResource getIconSwitchPlane();

	@Source("icon-switch-plane-disabled.png")
	ImageResource getIconSwitchPlaneDis();

	@Source("icon-rectangle-hand-symbols.png")
	ImageResource getIconRectangleHandSymbols();

	@Source("icon-not-occuring-hand-symbols.png")
	ImageResource getIconNotOccuringHandSymbols();

	@Source("icon-all-hand-symbols.png")
	ImageResource getIconAllHandSymbols();

	@Source("resize-button.png")
	ImageResource getResizeButton();

	@Source("icon-addUser.png")
	ImageResource getToolBarIconAddUser();

	@Source("icon-deleteUser.png")
	ImageResource getToolBarIconDeleteUser();

	@Source("icon-germany-flag.png")
	ImageResource getGermanFlag();

	@Source("icon-usa-flag.png")
	ImageResource getUSAFlag();

	@Source("icon-uk-flag.png")
	ImageResource getUKFlag();

	@Source("icon-brazil-flag.png")
	ImageResource getBrazilianFlag();

	@Source("icon-spain-flag.png")
	ImageResource getSpanishFlag();

	@Source("icon-france-flag.png")
	ImageResource getFrenchFlag();

	@Source("icon-belgium-flag.png")
	ImageResource getBelgianFlag();

	@Source("icon-tunisia-flag.png")
	ImageResource getTunisianFlag();

	@Source("icon-swiss-flag.png")
	ImageResource getSwissFlag();

	@Source("info-icon.png")
	ImageResource getInfoIcon();

	@Source("info-icon_hover.png")
	ImageResource getInfoIconHover();

	@Source("icon-mexico-flag.png")
	ImageResource getMexicanFlag();

	@Source("icon-canada-flag.png")
	ImageResource getCanadianFlag();

	@Source("icon-poland-flag.png")
	ImageResource getPolishFlag();

	@Source("icon-slovenia-flag.png")
	ImageResource getSlovenianFlag();

	@Source("icon-int-flag.png")
	ImageResource getSign8Flag();

	@Source("icon-background-color-changing.png")
	ImageResource getIconChangeBackgroundColor();

	@Source("icon-text-color-changing.png")
	ImageResource getIconChangeTextColor();

	@Source("icon-text-background-color-changing.png")
	ImageResource getIconChangeTextBackgroundColor();

	@Source("icon-edit-collage.png")
	ImageResource getIconEditCollage();

	@Source("icon-edit-collage-disabled.png")
	ImageResource getIconEditCollageDisabled();

	@Source("icon-insert-collage.png")
	ImageResource getIconInsertCollage();

	@Source("icon-insert-snippet.png")
	ImageResource getIconInsertSnippet();

	@Source("icon-insert-snippet-disabled.png")
	ImageResource getIconInsertSnippetDisabled();

	@Source("icon-insert-frame.png")
	ImageResource getIconInsertFrame();

	@Source("icon-insert-free-text-line.png")
	ImageResource getIconInsertFreeTextLine();

	@Source("icon-insert-page.png")
	ImageResource getIconInsertPage();

	@Source("icon-insert-sign.png")
	ImageResource getIconInsertSign();

	@Source("icon-insert-text-box.png")
	ImageResource getIconInsertFreeTextBox();

	@Source("icon-insert-video.png")
	ImageResource getIconInsertVideo();

	@Source("icon-insert-picture.png")
	ImageResource getIconInsertImage();

	@Source("icon-bold.png")
	ImageResource getIconBoldFont();

	@Source("icon-italic.png")
	ImageResource getIconItalicFont();

	@Source("icon-increase-sign-z-index.png")
	ImageResource getIconIncreaseSignZIndex();

	@Source("icon-decrease-sign-z-index.png")
	ImageResource getIconDecreaseSignZIndex();

	@Source("icon-delete-collage.png")
	ImageResource getIconDeleteCollage();

	@Source("icon-add.png")
	ImageResource getIconAdd();

	@Source("icon-edit.png")
	ImageResource getEditButton();

	@Source("icon-show-grid.png")
	ImageResource getIconShowGrid();

	@Source("icon-hide-grid.png")
	ImageResource getIconHideGrid();

	@Source("icon-cancel.png")
	ImageResource getIconCancel();

	@Source("icon-gear.png")
	ImageResource getIconGear();

	@Source("icon-change-color.png")
	ImageResource getIconChangeColor();

	@Source("icon-change-color-fill.png")
	ImageResource getIconChangeColorFill();

	@Source("icon-change-color-disabled.png")
	ImageResource getIconChangeColorDisabled();

	@Source("icon-add-color.png")
	ImageResource getIconAddColor();

	@Source("icon-remove-color.png")
	ImageResource getIconRemoveColor();

	@Source("icon-fingeralphabet.png")
	ImageResource getIconFingerAlphabet();

	@Source("icon-searchword-to-fingeralphabet.png")
	ImageResource getIconSearchwordToFingeralphabet();

	@Source("icon-arrange-fingeralphabet.png")
	ImageResource getIconArrangeFingeralphabet();

	@Source("icon-delete-all.png")
	ImageResource IconDeleteAll();

	@Source("icon-position.png")
	ImageResource getIconArrangeVisemes();

	@Source("icon-free-position.png")
	ImageResource getIconFreePositionVisemes();

	@Source("germany-flag.png")
	ImageResource getGermanFlagIcon();

	@Source("england-flag.png")
	ImageResource getEnglandFlagIcon();

	@Source("brazil-flag.png")
	ImageResource getBrazilFlagIcon();

	@Source("france-flag.png")
	ImageResource getFranceFlagIcon();

	@Source("spain-flag.png")
	ImageResource getSpainFlagIcon();

	@Source("germany-flag-round.png")
	ImageResource getGermanFlagIconRound();

	@Source("germany-flag-round-hover.png")
	ImageResource getGermanFlagIconRoundHover();

	@Source("germany-flag-round-active.png")
	ImageResource getGermanFlagIconRoundActive();

	@Source("england-flag-round.png")
	ImageResource getEnglandFlagIconRound();

	@Source("england-flag-round-hover.png")
	ImageResource getEnglandFlagIconRoundHover();

	@Source("england-flag-round-active.png")
	ImageResource getEnglandFlagIconRoundActive();

	@Source("brazil-flag-round.png")
	ImageResource getBrazilFlagIconRound();

	@Source("brazil-flag-round-hover.png")
	ImageResource getBrazilFlagIconRoundHover();

	@Source("brazil-flag-round-active.png")
	ImageResource getBrazilFlagIconRoundActive();

	@Source("france-flag-round.png")
	ImageResource getFranceFlagIconRound();

	@Source("france-flag-round-hover.png")
	ImageResource getFranceFlagIconRoundHover();

	@Source("france-flag-round-active.png")
	ImageResource getFranceFlagIconRoundActive();

	@Source("spain-flag-round.png")
	ImageResource getSpainFlagIconRound();

	@Source("spain-flag-round-hover.png")
	ImageResource getSpainFlagIconRoundHover();

	@Source("spain-flag-round-active.png")
	ImageResource getSpainFlagIconRoundActive();

	@Source("notification.png")
	ImageResource getNotificationIcon();

	@Source("videoRecord.png")
	ImageResource getVideoRecordIcon();

	@Source("videoRecordStart.png")
	ImageResource getVideoRecordStart();

	@Source("videoRecordStop.png")
	ImageResource getVideoRecordStop();

	@Source("videoProcessingDE.gif")
	ImageResource getProcessingImageDE();

	@Source("videoProcessingEN.gif")
	ImageResource getProcessingImageEN();

}