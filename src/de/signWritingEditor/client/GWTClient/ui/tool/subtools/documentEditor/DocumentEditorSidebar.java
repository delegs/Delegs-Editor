package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ActiveImageAndTextToggleButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageAndTextButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ImageAndTextToggleButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SeparatorPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ToggleHandler;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.VideoRecorderDialogBox.VideoRecorderListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ColorPicker.ColorPickerListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DictionarySelectionListbox.DictionarySelectionListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SidebarEditor;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;

public class DocumentEditorSidebar extends SidebarEditor {
	public static final String SIDEBAR_BUTTON_WIDTH = "50%";
	public static final String SIDEBAR_BUTTON_HEIGHT = "35px";
	public static final String ICON_SIZE = "33px";
	public static final String GREEN_CHECK_ICON_SIZE = "23px";
	public static final String GREEN_CHECK_BUTTON_SIZE = "25px";

	private static final int HIGH_DISTANCE = 20;
	private static final double MEDIUM_DISTANCE = 10;
	private static final int TOGGLE_SIDEBAR_BUTTON_WIDTH = 35;
	private static final double TOGGLE_SIDEBAR_BUTTON_SIDE_MARGIN = 10;
	private static final double SIDEBAR_WIDTH = 290;
	private static final double SIDEBAR_CONTENT_WIDTH = SIDEBAR_WIDTH - (2 * TOGGLE_SIDEBAR_BUTTON_SIDE_MARGIN)
			- TOGGLE_SIDEBAR_BUTTON_WIDTH;
	private static final String SMALL_ICON_SIZE = "22px";
	private static final String FONT_NAMES_DROPDOWN_WIDTH = "100px";
	private static final double CLOSED_SIDEBAR_WIDTH = TOGGLE_SIDEBAR_BUTTON_WIDTH;

	private static final String SIDEBAR_EDITOR_PANEL = "sidebarEditorPanel";
	private static final String URL_LABEL_STYLE = "urlLabel";
	private static final String URL_BOX_SIDEBAR_STYLE = "urlBoxSidebar";
	private static final String URL_PANEL_STYLE = "urlPanel";
	public static final float MAX_VIDEO_DURATION = 6.0f;

	public static String videoSupplierUrl;

	private final DocumentEditorSideBarListener documentEditorSideBarListener;

	private DictionarySelectionListbox dictionarySelection;

	private FlowPanel openedSidebar;
	private FlowPanel closedSidebar;

	private ColorPicker textColorPicker;
	private ColorPicker signBoxBackgroundColorPicker;
	private ColorPicker textBoxBackgroundColorPicker;

	private ImageAndTextToggleButton boldFontButton;
	private ImageAndTextToggleButton italicFontButton;

	private ListBox fontSizeListBox;
	private ListBox fontNameListBox;

	private ActiveImageAndTextToggleButton addSnippetToggle;
	private ImageAndTextToggleButton deleteCollageButton;
	private ImageAndTextToggleButton gridVisibilityToggleButton;

	private List<Widget> authorOnlyWidgets = new ArrayList<Widget>();
	private Tab collageTab;
	private Tab addElementsTab;
	private TabPanel sidebarTabPanel;
	private Tab editLayoutTab;
	private HandlerRegistration nativePreviewHandler = null;
	private final LocalSessionService localSessionService;
	private final UserServiceAsync userService;
	private final MediaUrlServiceAsync mediaUrlService;
	private Tab editVideoTab;
	private Tab editImageTab;
	private Label urlLabel;
	private TextBox urlTextBox;

	private boolean hasAuthorPermission;
	private boolean isSign;
	private boolean lockedLayout;

	private static FormPanel videoForm;

	public DocumentEditorSidebar(UserServiceAsync userService, MediaUrlServiceAsync mediaUrlService,
			LocalSessionService localSessionService, DocumentEditorSideBarListener listener, boolean hasCollage) {
		super(I18N.getDocumentEditorSidebarName());
		this.localSessionService = localSessionService;
		this.userService = userService;
		this.mediaUrlService = mediaUrlService;
		this.setStyleName("documentEditorSidebar");

		this.documentEditorSideBarListener = listener;
		this.openedSidebar = new FlowPanel();
		this.closedSidebar = new FlowPanel();

		this.isSign = true;
		this.lockedLayout = false;
		mediaUrlService.getMediaUrl(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(String result) {
				videoSupplierUrl = result;
			}
		});
		videoForm = new FormPanel();

		Grid sidebarGrid = new Grid(1, 2);
		SimplePanel closeSidebarButton = new SimplePanel();
		closeSidebarButton.addStyleName("sidebarToggleButton");
		closeSidebarButton
				.add(new ToolBarButton(new Image(Resources.RESOURCE.getToolBarIconRight()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						showSidebar(false);
					}
				}));

		sidebarTabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				if (selectedTabContent == addElementsTab.getTabContent()) {
					setHeaderLabelText(I18N.getAddNewElement());
				} else if (selectedTabContent == editLayoutTab.getTabContent()) {
					setHeaderLabelText(I18N.getEditLayout());
				} else if (selectedTabContent == collageTab.getTabContent()) {
					setHeaderLabelText(I18N.getEditCollage());
				} else if (editVideoTab != null && selectedTabContent == editVideoTab.getTabContent()) {
					setHeaderLabelText(I18N.getEditVideoToken());
				} else if (selectedTabContent == editImageTab.getTabContent()) {
					setHeaderLabelText(I18N.getEditImageToken());
				}
			}
		});
		sidebarTabPanel.addStyleName("sidebarTabPanel");

		sidebarGrid.setWidget(0, 0, closeSidebarButton);
		sidebarGrid.setWidget(0, 1, sidebarTabPanel);
		sidebarGrid.getColumnFormatter().getElement(0).getStyle().setWidth(TOGGLE_SIDEBAR_BUTTON_WIDTH, Unit.PX);

		openedSidebar.addStyleName("openSideBar");
		this.openedSidebar.add(sidebarGrid);
		this.addContent(openedSidebar);
		this.addContent(closedSidebar);

		addElementsTab = createAddElementsTab();
		sidebarTabPanel.addTab(addElementsTab);
		editLayoutTab = createEditLayoutTab();
		sidebarTabPanel.addTab(editLayoutTab);
		collageTab = createCollagePropertiesTab(hasCollage);
		sidebarTabPanel.addTab(collageTab);
		// Setting the initial arrow position manually since it won't be
		// rendered in time to be done automatically
		sidebarTabPanel.setInitialArrowPositionDeferred(17);

		SimplePanel openSidebarButton = new SimplePanel();
		openSidebarButton.addStyleName("sidebarToggleButton");
		openSidebarButton
				.add(new ToolBarButton(new Image(Resources.RESOURCE.getToolBarIconLeft()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						showSidebar(true);
						if (!addElementsTab.getEnabled()) {
							sidebarTabPanel.selectTab(editLayoutTab);
						}
					}
				}));

		this.closedSidebar.add(openSidebarButton);

		showSidebar(true);
		closedSidebar.getElement().getStyle().setWidth(CLOSED_SIDEBAR_WIDTH, Unit.PX);

		openedSidebar.getElement().getStyle().setWidth(SIDEBAR_WIDTH, Unit.PX);
		openedSidebar.getElement().getStyle().setMarginTop(HIGH_DISTANCE, Unit.PX);

		urlTextBox = new TextBox(); // pseudo initialization, will be set later

		urlLabel = new Label(I18N.getUrlLabel());
		urlLabel.setStyleName(URL_LABEL_STYLE);

		onUserChanged();

		addSnippetToggle.setEnabled(false);
	}

	public void setDrawParagraphMode(boolean state) {
		addSnippetToggle.setToggleStateManually(state);
	}

	public void setDeleteCollageMode(boolean state) {
		deleteCollageButton.setToggleStateManually(state);
	}

	public void updateSidebarForTextbasedToken(ReadOnlyTextbasedTokenStyle textbasedTokenStyle, SignLocale signLocale,
			Color tokenBackgroundColor, boolean fireStyleChangedEvent) {

		setNewLocale(signLocale);

		updateFontSettings(textbasedTokenStyle.getFont(), textbasedTokenStyle.getFontSize().getSize(),
				textbasedTokenStyle.getFontStyle(), textbasedTokenStyle.getFontWeight(), fireStyleChangedEvent);
		updateColorSettings(tokenBackgroundColor, textbasedTokenStyle.getTextBackgroundColor(),
				textbasedTokenStyle.getFontColor());
		if (!addElementsTab.getEnabled()) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		}
	}

	public void updateSidebarForNonTextbasedToken(Color tokenBackgroundColor) {
		updateColorSettings(tokenBackgroundColor, null, null);
		if (!addElementsTab.getEnabled()) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		}
	}

	public void updateSidebarForVideoToken(VideoTokenBoxWidget widget) {
		showSidebar(true);
		sidebarTabPanel.clearTabs();
		sidebarTabPanel.addTab(addElementsTab);
		editVideoTab = createEditVideoTab(widget);
		sidebarTabPanel.addTab(editVideoTab);
		sidebarTabPanel.addTab(collageTab);
		sidebarTabPanel.selectTab(editVideoTab);
		if (!addElementsTab.getEnabled()) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		}
	}

	public void updateSidebarForImageToken(ImageTokenBoxWidget widget) {
		sidebarTabPanel.clearTabs();
		sidebarTabPanel.addTab(addElementsTab);
		editImageTab = createEditImageTab(widget);
		sidebarTabPanel.addTab(editImageTab);
		sidebarTabPanel.addTab(collageTab);
		sidebarTabPanel.selectTab(editImageTab);
		if (!addElementsTab.getEnabled()) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		}
	}

	public void updateSidebarForNonVideoToken(AbstractTokenBoxWidget widget) {
		this.lockedLayout = widget.getTokenBox().isLockedLayout();
		if (widget instanceof SignItemTokenBoxWidgetBase) {
			this.isSign = true;
		} else {
			this.isSign = false;
		}
		editLayoutTab = createEditLayoutTab();
		sidebarTabPanel.clearTabs();
		sidebarTabPanel.addTab(addElementsTab);
		sidebarTabPanel.addTab(editLayoutTab);
		sidebarTabPanel.addTab(collageTab);
		sidebarTabPanel.selectTab(editLayoutTab);
		if (!addElementsTab.getEnabled()) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		}
	}

	public void setNewLocale(SignLocale newLocale) {
		this.dictionarySelection.setNewLocale(newLocale);
	}

	public SignLocale getSelectedLocale() {
		return this.dictionarySelection.getSelectedSignLocale();
	}

	private void updateFontSettings(Font font, int fontSize, FontStyle fontStyle, FontWeight fontWeight,
			boolean fireStyleChangedEvent) {
		if (fireStyleChangedEvent) {
			boolean isItalic = fontStyle.equals(FontStyle.ITALIC);
			boolean isBold = fontWeight.equals(FontWeight.BOLD);
			boldFontButton.setToggleStateManually(isBold);
			italicFontButton.setToggleStateManually(isItalic);
		}

		if (fontSize != Integer.parseInt(fontSizeListBox.getItemText(fontSizeListBox.getSelectedIndex()))) {

			boolean itemFound = false;
			int index = -1;

			for (int i = 0; i < fontSizeListBox.getItemCount() && !itemFound; ++i) {
				if (Integer.parseInt(fontSizeListBox.getItemText(i)) == fontSize) {
					index = i;
					itemFound = true;
				}
			}
			if (itemFound) {
				this.fontSizeListBox.setSelectedIndex(index);
			}
		}
		if (font != Font.fromString(fontNameListBox.getItemText(fontNameListBox.getSelectedIndex()))) {
			boolean fontNameFound = false;
			int fontNameIndex = -1;
			for (int i = 0; i < fontNameListBox.getItemCount() && !fontNameFound; ++i) {
				if (font.equals(Font.fromString(fontNameListBox.getItemText(i)))) {
					fontNameIndex = i;
					fontNameFound = true;
				}
			}
			if (fontNameFound) {
				this.fontNameListBox.setSelectedIndex(fontNameIndex);
			}
		}
	}

	private void updateColorSettings(Color backgroundColor, Color textBackgroundColor, Color fontColor) {
		this.signBoxBackgroundColorPicker.selectColor(backgroundColor);
		if (textBackgroundColor != null) {
			this.textBoxBackgroundColorPicker.selectColor(textBackgroundColor);
		}
		if (fontColor != null) {
			textColorPicker.selectColor(fontColor);
		}
	}

	public void setShowCollageGridSizeValue(boolean value) {
		this.gridVisibilityToggleButton.setToggleStateManually(value);
	}

	public void updateCollageTab(boolean hasCollage) {
		collageTab.setEnabled(hasCollage);
		addSnippetToggle.setEnabled(hasCollage);
		if (!hasCollage && sidebarTabPanel.isTabSelected(collageTab)) {
			sidebarTabPanel.selectTab(addElementsTab);
		}
	}

	public void onUserChanged() {
		if (localSessionService.getUserSession() != null) {
			userService.hasVideoAndImagePermission(localSessionService.getSessionKey(), new AsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean result) {
					hasAuthorPermission = result;
					urlTextBox.setReadOnly(!result);
					updateButtonStylings();
				}

				@Override
				public void onFailure(Throwable caught) {
					hasAuthorPermission = false;
					urlTextBox.setReadOnly(true);
					updateButtonStylings();
				}
			});
		} else {
			hasAuthorPermission = false;
			urlTextBox.setReadOnly(true);
			updateButtonStylings();
		}
	}

	private void updateButtonStylings() {
		for (Widget widget : authorOnlyWidgets) {
			if (hasAuthorPermission) {
				widget.removeStyleName("disabledImageAndTextButton");
			} else {
				widget.addStyleName("disabledImageAndTextButton");
			}
		}
	}

	private Tab createAddElementsTab() {
		FlowPanel addElementPanel = new FlowPanel();
		addElementPanel.addStyleName(SIDEBAR_EDITOR_PANEL);
		addElementPanel.getElement().getStyle().setWidth(SIDEBAR_CONTENT_WIDTH, Unit.PX);

		Image tabIcon = new Image(Resources.RESOURCE.getIconAdd());
		tabIcon.setSize(ICON_SIZE, ICON_SIZE);

		Tab result = new Tab(tabIcon, addElementPanel);

		Image addFreeTextBoxButtonImage = new Image(Resources.RESOURCE.getIconInsertFreeTextBox());
		addFreeTextBoxButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addFreeTextBoxButton = new ImageAndTextButton(addFreeTextBoxButtonImage,
				I18N.getFreeTextBox(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onAddFreeTextBox();
					}
				});
		addFreeTextBoxButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addFreeTextBoxButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addFreeTextBoxButton);

		Image addFreeTextLineButtonImage = new Image(Resources.RESOURCE.getIconInsertFreeTextLine());
		addFreeTextLineButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addFreeTextLineButton = new ImageAndTextButton(addFreeTextLineButtonImage,
				I18N.getFreeTextLine(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onAddFreeTextLine();
					}
				});
		addFreeTextLineButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addFreeTextLineButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addFreeTextLineButton);

		Image addSignItemButtonImage = new Image(Resources.RESOURCE.getIconInsertSign());
		addSignItemButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addSignItemButton = new ImageAndTextButton(addSignItemButtonImage, I18N.getSignItem(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onAddSignItemToken();
					}
				});
		addSignItemButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addSignItemButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addSignItemButton);

		Image addFrameButtonImage = new Image(Resources.RESOURCE.getIconInsertFrame());
		addFrameButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addFrameButton = new ImageAndTextButton(addFrameButtonImage, I18N.getFrame(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onAddFrame();
					}
				});
		addFrameButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addFrameButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addFrameButton);

		ImageAndTextButton addVideoButton;
		Image addVideoButtonImage = new Image(Resources.RESOURCE.getIconInsertVideo());
		addVideoButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		addVideoButton = new ImageAndTextButton(addVideoButtonImage, I18N.getVideo(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (hasAuthorPermission) {
					documentEditorSideBarListener.onAddVideo();
				}
			}
		});
		addVideoButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addVideoButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addVideoButton.getElement().getStyle().setMarginBottom(HIGH_DISTANCE, Unit.PX);
		addVideoButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);

		addElementPanel.add(addVideoButton);
		authorOnlyWidgets.add(addVideoButton);
		Image addImageButtonImage = new Image(Resources.RESOURCE.getIconInsertImage());
		addImageButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addImageButton = new ImageAndTextButton(addImageButtonImage, I18N.getImage(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						if (hasAuthorPermission) {
							documentEditorSideBarListener.onAddImage();
						}
					}
				});
		addImageButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		addImageButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addImageButton.getElement().getStyle().setMarginBottom(HIGH_DISTANCE, Unit.PX);
		addImageButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		addElementPanel.add(addImageButton);
		authorOnlyWidgets.add(addImageButton);

		addElementPanel.add(new SeparatorPanel());

		Image addNormalPageImage = new Image(Resources.RESOURCE.getIconInsertPage());
		addNormalPageImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addNormalPage = new ImageAndTextButton(addNormalPageImage, I18N.getNormalPage(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onAddNormalPage();
					}
				});
		addNormalPage.setWidth(SIDEBAR_BUTTON_WIDTH);
		addNormalPage.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addNormalPage);

		Image addCollageImage = new Image(Resources.RESOURCE.getIconInsertCollage());
		addCollageImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton addCollage = new ImageAndTextButton(addCollageImage, I18N.getCollage(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				documentEditorSideBarListener.onAddCollage();
			}
		});
		addCollage.setWidth(SIDEBAR_BUTTON_WIDTH);
		addCollage.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addCollage);

		Image addSnippetToggleImage = new Image(Resources.RESOURCE.getIconInsertSnippet());
		addSnippetToggleImage.setSize(ICON_SIZE, ICON_SIZE);
		Image cancelToggelImage = new Image(Resources.RESOURCE.getIconCancel());
		cancelToggelImage.setSize(ICON_SIZE, ICON_SIZE);
		Image disabledSnippetImage = new Image(Resources.RESOURCE.getIconInsertSnippetDisabled());
		disabledSnippetImage.setSize(ICON_SIZE, ICON_SIZE);
		addSnippetToggle = new ActiveImageAndTextToggleButton(addSnippetToggleImage, cancelToggelImage,
				disabledSnippetImage, I18N.getSnippet(), I18N.getCancel(), new ToggleHandler() {
					@Override
					public void onToggle(boolean isActive) {
						documentEditorSideBarListener.onDrawSnippets(isActive);
					}
				});
		addSnippetToggle.setWidth(SIDEBAR_BUTTON_WIDTH);
		addSnippetToggle.setHeight(SIDEBAR_BUTTON_HEIGHT);
		addElementPanel.add(addSnippetToggle);

		return result;
	}

	private Tab createEditVideoTab(final VideoTokenBoxWidget widget) {
		final String widgetId = widget.getId().toString();
		FlowPanel editVideoPanel = new FlowPanel();
		editVideoPanel.addStyleName(SIDEBAR_EDITOR_PANEL);
		editVideoPanel.getElement().getStyle().setWidth(SIDEBAR_CONTENT_WIDTH, Unit.PX);

		Image tabIcon = new Image(Resources.RESOURCE.getEditButton());
		tabIcon.setSize(ICON_SIZE, ICON_SIZE);
		Tab result = new Tab(tabIcon, editVideoPanel);

		FlowPanel urlPanel = new FlowPanel();

		final TextBox urlTextBox = new TextBox();
		urlTextBox.getElement().setId(DocumentPanel.ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR);
		urlTextBox.setStyleName(URL_BOX_SIDEBAR_STYLE);
		urlTextBox.getElement().setAttribute("placeholder", I18N.getVideoUrlPlaceholder());
		urlTextBox.setText(widget.getUrl());

		urlTextBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					refreshSelectedVideoTokenBoxWidget(widget, urlTextBox.getText());
				}
			}
		});

		Image urlButtonIcon = new Image(Resources.RESOURCE.getCheckIcon());
		urlButtonIcon.setSize(GREEN_CHECK_ICON_SIZE, GREEN_CHECK_ICON_SIZE);
		ImageAndTextButton urlButton = new ImageAndTextButton(urlButtonIcon, "", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				refreshSelectedVideoTokenBoxWidget(widget, urlTextBox.getText());
			}
		});
		urlButton.setSize(GREEN_CHECK_BUTTON_SIZE, GREEN_CHECK_BUTTON_SIZE);

		urlPanel.add(urlLabel);
		urlPanel.add(urlTextBox);
		urlPanel.add(urlButton);
		urlPanel.setStyleName(URL_PANEL_STYLE);

		videoForm.clear();
		videoForm.setAction(videoSupplierUrl);
		videoForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		videoForm.setMethod(FormPanel.METHOD_POST);
		videoForm.getElement().setId("videoUploadForm_" + widgetId);

		final FileUpload fileUpload = new FileUpload();
		fileUpload.getElement().setAttribute("accept", "video/*");
		fileUpload.setName("video");
		fileUpload.setStyleName("fileUpload");
		fileUpload.getElement().setId("fileInput_" + widgetId);
		fileUpload.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				String fileName = fileUpload.getFilename();

				try {
					isVideo(fileName);
					handleVideoUpload(widget, urlTextBox, widgetId);
				} catch (Exception e) {
					if (e instanceof UserCancelUploadException) {
					} else if (e instanceof IOException) {
						Window.alert(e.getMessage());
					} else {
						GWT.log(e.toString());
					}
				}
			}

			private native void handleVideoUpload(VideoTokenBoxWidget widget, TextBox urlTextBox,
					String widgetId) /*-{
		var sidebar = this;
		var selectedFile = $doc.getElementById('fileInput_' + widgetId).files[0];
		var url = ($wnd.URL ? URL : webkitURL).createObjectURL(selectedFile);
		var MAX_VIDEO_DURATION = @de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::MAX_VIDEO_DURATION;
		var videoPlayer = $doc.createElement("VIDEO");

		videoPlayer.onloadedmetadata = function() {
			if (!isNaN(videoPlayer.duration) && videoPlayer.duration <= MAX_VIDEO_DURATION) {
				var videoForm = $doc.getElementById("videoUploadForm_" + widgetId);
				var formData = new FormData(videoForm);
				var xhr = new XMLHttpRequest();
				xhr
					.open(
						'POST',
						@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::videoSupplierUrl,
						true);

				//Upload progress
				xhr.upload
					.addEventListener(
						"progress",
						function(upload) {
							if (upload.lengthComputable) {
								var percentComplete = upload.loaded / upload.total;

								widget.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::updateUploadProgress(D)(percentComplete);
								widget.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::setProgressbarText(D)(percentComplete);
							}
						}, false);

				xhr.onreadystatechange = function() {
					// xhr.readyState == 4 -> Operation is done and response fully loaded
					if (xhr.readyState == 4 && xhr.status == 200) {
						urlTextBox.@com.google.gwt.user.client.ui.TextBox::setText(Ljava/lang/String;)(xhr.response + "");
						widget.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::setVideoTokenBoxUrl(Ljava/lang/String;)(xhr.response + "");
						widget.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget::checkVideoSource()();
					}
				};
				xhr.send(formData);

			} else {
				window
					.alert(@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::getI18NVideoMaxMessage(I)(MAX_VIDEO_DURATION));
			}
		};
		videoPlayer.src = url;

	}-*/;

			// throws IO-Exception if File-Format isn't supported
			public void isVideo(String name) throws IOException, UserCancelUploadException {
				if (name.isEmpty()) {
					throw new UserCancelUploadException();
				}
				String lowername = name.toLowerCase();
				if (!(lowername.endsWith(".mp4") || lowername.endsWith(".webm") || lowername.endsWith(".mov"))) {
					throw new IOException(I18N.getVideoFormatMessage());
				}
			}
		});
		videoForm.add(fileUpload);

		Image uploadIcon = new Image(Resources.RESOURCE.getUploadVideoIcon());
		uploadIcon.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton uploadButton = new ImageAndTextButton(uploadIcon, I18N.getUpload(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				fileUpload.click();
			}

		});
		uploadButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		uploadButton.setHeight(SIDEBAR_BUTTON_HEIGHT);

		Image reportIcon = new Image(Resources.RESOURCE.getReportIcon());
		reportIcon.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton reportButton = new ImageAndTextButton(reportIcon, I18N.getReportButtonTitle(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						widget.getVideoListener().onReport(widget.getUrl());
					}
				});
		reportButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		reportButton.setHeight(SIDEBAR_BUTTON_HEIGHT);

		final Image videoRecordIcon = new Image(Resources.RESOURCE.getIconInsertVideo());
		videoRecordIcon.setSize(ICON_SIZE, ICON_SIZE);
		final ImageAndTextButton videoRecorderButton = new ImageAndTextButton(videoRecordIcon, I18N.getVideoRecording(),
				null);
		videoRecorderButton.addDisablingClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				VideoRecorderListener videoRecorderListener = new VideoRecorderListener() {
					@Override
					public void onUploadComplete(String url) {
						urlTextBox.setText(url);
						refreshSelectedVideoTokenBoxWidget(widget, url);
						videoRecorderButton.setEnabled();
					}
					
					@Override
					public void beforeOnUploadComplete() {
						widget.setVideoPosterToConverting();
					}

					@Override
					public void onCloseRecording() {
						videoRecorderButton.setEnabled();
					}
				};
				handleOpenVideoRecorder(DocumentEditorSidebar.this, videoRecorderListener, videoRecorderButton);
			}
		});

		videoRecorderButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		videoRecorderButton.setHeight(SIDEBAR_BUTTON_HEIGHT);
		editVideoPanel.add(videoRecorderButton);
		editVideoPanel.add(uploadButton);
		editVideoPanel.add(urlPanel);
		addContent(videoForm);
		editVideoPanel.add(reportButton);

		updateButtonStylings();

		assert result != null : "editVideoTab was null";
		return result;
	}

	private void openVideoRecorder(VideoRecorderListener videoRecorderListener) {
		VideoRecorderDialogBox recorderDialogBox = new VideoRecorderDialogBox(videoRecorderListener);
		recorderDialogBox.show();
		recorderDialogBox.handleRecording();
		recorderDialogBox.center();
	}

	private String getI18NNoCameraMessage() {
		return I18N.getErrorNoCameraFound();
	}

	private String getI18NPermissionDeniedMessage() {
		return I18N.getCameraPermissionDenied();
	}

	private String getI18NCameraAlreadyInUseMessage() {
		return I18N.getCameraAlreadyInUse();
	}

	private native void handleOpenVideoRecorder(DocumentEditorSidebar sidebar,
			VideoRecorderListener videoRecorderListener, ImageAndTextButton videoRecorderButton)/*-{
		$wnd.navigator.mediaDevices.getUserMedia = $wnd.navigator.mediaDevices.getUserMedia
			|| $wnd.navigator.mediaDevices.mozGetUserMedia || $wnd.navigator.mediaDevices.webkitGetUserMedia
			|| $wnd.navigator.mediaDevices.oGetUserMedia || $wnd.navigator.mediaDevices.msGetUserMedia;
		$wnd.navigator.mediaDevices
			.getUserMedia({
				video : true,
				audio : false
			})
			.then(
				function(stream) {
					var tracks = stream.getTracks();
					tracks.forEach(function(track) {
						track.stop();
					});
					sidebar.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::openVideoRecorder(Lde/signWritingEditor/client/GWTClient/ui/tool/general/dialogBox/VideoRecorderDialogBox$VideoRecorderListener;)(videoRecorderListener);
				},
				function(err) {
					if (err.name == "NotFoundError" || err.name == "DevicesNotFoundError") {
						//required track is missing 
						$wnd
							.alert(sidebar.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::getI18NNoCameraMessage()());
					} else if (err.name == "NotReadableError" || err.name == "TrackStartError") {
						//webcam or mic are already in use 
						$wnd
							.alert(sidebar.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::getI18NCameraAlreadyInUseMessage()());
					} else if (err.name == "NotAllowedError" || err.name == "PermissionDeniedError") {
						//permission denied in browser 
						$wnd
							.alert(sidebar.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::getI18NPermissionDeniedMessage()());
					} else {
						//other errors 
						console.log(err);
					}
					videoRecorderButton.@de.signWritingEditor.client.GWTClient.ui.general.widget.ImageAndTextButton::setEnabled()();
				});
	}-*/;

	public static String getI18NVideoMaxMessage(int i) {
		return I18N.getMaxVideoLenghtMessage(i);
	}

	private Tab createEditImageTab(final ImageTokenBoxWidget widget) {
		FlowPanel editImagePanel = new FlowPanel();
		editImagePanel.addStyleName(SIDEBAR_EDITOR_PANEL);
		editImagePanel.getElement().getStyle().setWidth(SIDEBAR_CONTENT_WIDTH, Unit.PX);

		Image tabIcon = new Image(Resources.RESOURCE.getEditButton());
		tabIcon.setSize(ICON_SIZE, ICON_SIZE);
		Tab result = new Tab(tabIcon, editImagePanel);

		FlowPanel urlPanel = new FlowPanel();

		final TextBox urlTextBox = new TextBox();
		urlTextBox.getElement().setId(DocumentPanel.ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR);
		urlTextBox.setStyleName(URL_BOX_SIDEBAR_STYLE);
		urlTextBox.getElement().setAttribute("placeholder", I18N.getImageUrlPlaceholder());
		urlTextBox.setText(widget.getUrl());

		urlTextBox.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER && hasAuthorPermission) {
					widget.setUrl(urlTextBox.getText());
				}
			}
		});
		urlTextBox.setReadOnly(!hasAuthorPermission);
		authorOnlyWidgets.add(urlTextBox);

		Image urlButtonIcon = new Image(Resources.RESOURCE.getCheckIcon());
		urlButtonIcon.setSize(GREEN_CHECK_ICON_SIZE, GREEN_CHECK_ICON_SIZE);
		ImageAndTextButton urlButton = new ImageAndTextButton(urlButtonIcon, "", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (hasAuthorPermission) {
					widget.setUrl(urlTextBox.getText());
				}
			}
		});
		urlButton.setSize(GREEN_CHECK_BUTTON_SIZE, GREEN_CHECK_BUTTON_SIZE);

		authorOnlyWidgets.add(urlButton);

		urlPanel.add(urlLabel);
		urlPanel.add(urlTextBox);
		urlPanel.add(urlButton);
		urlPanel.setStyleName(URL_PANEL_STYLE);

		Image reportIcon = new Image(Resources.RESOURCE.getReportIcon());
		reportIcon.setSize(ICON_SIZE, ICON_SIZE);

		ImageAndTextButton reportButton = new ImageAndTextButton(reportIcon, I18N.getReportButtonTitle(),
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						widget.getImageListener().onReport(widget.getUrl());
					}
				});

		reportButton.setWidth(SIDEBAR_BUTTON_WIDTH);
		reportButton.setHeight(SIDEBAR_BUTTON_HEIGHT);

		editImagePanel.add(urlPanel);
		editImagePanel.add(reportButton);
		updateButtonStylings();

		assert result != null : "editImageTab was null";
		return result;
	}

	private void refreshSelectedVideoTokenBoxWidget(VideoTokenBoxWidget widget, String url) {
		widget.setVideoTokenBoxUrl(url);
		widget.checkVideoSource();
	}

	private Tab createEditLayoutTab() {
		FlowPanel editLayoutPanel = new FlowPanel();
		editLayoutPanel.addStyleName(SIDEBAR_EDITOR_PANEL);
		editLayoutPanel.getElement().getStyle().setWidth(SIDEBAR_CONTENT_WIDTH, Unit.PX);

		Image tabIcon = new Image(Resources.RESOURCE.getEditButton());
		tabIcon.setSize(ICON_SIZE, ICON_SIZE);

		Tab result = new Tab(tabIcon, editLayoutPanel);
		if (isSign) {

			editLayoutPanel.add(addSubHeader(I18N.getSelectDictionary()));

			dictionarySelection = new DictionarySelectionListbox(documentEditorSideBarListener);
			editLayoutPanel.add(dictionarySelection);

			editLayoutPanel.add(new SeparatorPanel());
		}
		if (!lockedLayout) {

			editLayoutPanel.add(addSubHeader(I18N.getEditFont()));

			fontNameListBox = new ListBox();

			for (Font font : Font.values()) {
				fontNameListBox.addItem(font.toString());
			}

			fontNameListBox.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					int index = fontNameListBox.getSelectedIndex();
					String result = fontNameListBox.getItemText(index);
					documentEditorSideBarListener.onFontChanged(Font.fromString(result));
				}
			});

			fontNameListBox.setWidth(FONT_NAMES_DROPDOWN_WIDTH);
			editLayoutPanel.add(fontNameListBox);

			fontSizeListBox = new ListBox();
			for (FontSize fontSize : FontSize.values()) {
				fontSizeListBox.addItem(Integer.toString(fontSize.getSize()));
			}
			fontSizeListBox.setSelectedIndex(5);

			fontSizeListBox.addChangeHandler(new ChangeHandler() {

				@Override
				public void onChange(ChangeEvent event) {
					int index = fontSizeListBox.getSelectedIndex();
					String result = fontSizeListBox.getItemText(index);
					int fontSizeInt = Integer.parseInt(result);
					FontSize fontSize = FontSize.valueOf(fontSizeInt);
					documentEditorSideBarListener.onFontSizeChanged(fontSize);
				}
			});

			fontSizeListBox.getElement().getStyle().setMarginLeft(MEDIUM_DISTANCE, Unit.PX);
			fontSizeListBox.getElement().getStyle().setMarginBottom(HIGH_DISTANCE, Unit.PX);
			editLayoutPanel.add(fontSizeListBox);

			Image boldFontImage = new Image(Resources.RESOURCE.getIconBoldFont());
			boldFontImage.setSize(SMALL_ICON_SIZE, SMALL_ICON_SIZE);
			boldFontButton = new ImageAndTextToggleButton(boldFontImage, "", new ToggleHandler() {
				@Override
				public void onToggle(boolean isDown) {
					if (isDown) {
						documentEditorSideBarListener.onFontWeightChanged(FontWeight.BOLD);
					} else {
						documentEditorSideBarListener.onFontWeightChanged(FontWeight.NORMAL);
					}
				}
			});
			boldFontButton.getElement().getStyle().setMarginLeft(MEDIUM_DISTANCE, Unit.PX);
			editLayoutPanel.add(boldFontButton);

			Image italicFontImage = new Image(Resources.RESOURCE.getIconItalicFont());
			italicFontImage.setSize(SMALL_ICON_SIZE, SMALL_ICON_SIZE);
			italicFontButton = new ImageAndTextToggleButton(italicFontImage, "", new ToggleHandler() {
				@Override
				public void onToggle(boolean isDown) {
					if (isDown) {
						documentEditorSideBarListener.onFontStyleChanged(FontStyle.ITALIC);
					} else {
						documentEditorSideBarListener.onFontStyleChanged(FontStyle.NORMAL);
					}
				}
			});
			italicFontButton.getElement().getStyle().setMarginLeft(MEDIUM_DISTANCE, Unit.PX);
			editLayoutPanel.add(italicFontButton);

			editLayoutPanel.add(new SeparatorPanel());
		}

		final Widget colorSubHeader = addSubHeader(I18N.getChooseTextColor());
		editLayoutPanel.add(colorSubHeader);

		textColorPicker = new ColorPicker(new ColorPickerListener() {

			@Override
			public void colorSelected(Color color) {
				documentEditorSideBarListener.onFontColorChanged(color);
			}
		});
		Image textColorTabIcon = new Image(Resources.RESOURCE.getIconChangeTextColor());
		textColorTabIcon.setSize(ICON_SIZE, ICON_SIZE);
		final Tab textColorTab = new Tab(textColorTabIcon, textColorPicker);

		signBoxBackgroundColorPicker = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				documentEditorSideBarListener.onChangeBackgroundColor(color);
			}
		});
		Image signBoxBackgroundColorTabIcon = new Image(Resources.RESOURCE.getIconChangeBackgroundColor());
		signBoxBackgroundColorTabIcon.setSize(ICON_SIZE, ICON_SIZE);
		final Tab signBoxBackgroundColorTab = new Tab(signBoxBackgroundColorTabIcon, signBoxBackgroundColorPicker);

		textBoxBackgroundColorPicker = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				documentEditorSideBarListener.onChangeTextBackgroundColor(color);
			}
		});
		Image textBoxBackgroundColorTabIcon = new Image(Resources.RESOURCE.getIconChangeTextBackgroundColor());
		textBoxBackgroundColorTabIcon.setSize(ICON_SIZE, ICON_SIZE);
		final Tab textBoxBackgroundColorTab = new Tab(textBoxBackgroundColorTabIcon, textBoxBackgroundColorPicker);

		TabPanel colorPickerTabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				if (selectedTabContent.equals(textColorTab.getTabContent())) {
					((Label) colorSubHeader).setText(I18N.getChooseTextColor());
				} else if (!lockedLayout && selectedTabContent.equals(signBoxBackgroundColorTab.getTabContent())) {
					((Label) colorSubHeader).setText(I18N.getChooseSignBoxBackgroundColor());
				} else if (selectedTabContent.equals(textBoxBackgroundColorTab.getTabContent())) {
					((Label) colorSubHeader).setText(I18N.getChooseTextBoxBackgroundColor());
				}
			}
		});

		colorPickerTabPanel.addTab(textColorTab);
		if (isSign) {
			colorPickerTabPanel.addTab(signBoxBackgroundColorTab);
		}
		colorPickerTabPanel.addTab(textBoxBackgroundColorTab);

		editLayoutPanel.add(colorPickerTabPanel);

		return result;
	}

	private Tab createCollagePropertiesTab(boolean hasCollage) {
		FlowPanel propertiesPanel = new FlowPanel();
		propertiesPanel.addStyleName(SIDEBAR_EDITOR_PANEL);
		propertiesPanel.getElement().getStyle().setWidth(SIDEBAR_CONTENT_WIDTH, Unit.PX);

		Image enabledIcon = new Image(Resources.RESOURCE.getIconEditCollage());
		enabledIcon.setSize(ICON_SIZE, ICON_SIZE);

		Image disabledIcon = new Image(Resources.RESOURCE.getIconEditCollageDisabled());
		disabledIcon.setSize(ICON_SIZE, ICON_SIZE);

		Tab result = new Tab(enabledIcon, disabledIcon, propertiesPanel);

		Image sendParagraphToFrontButtonImage = new Image(Resources.RESOURCE.getIconIncreaseSignZIndex());
		sendParagraphToFrontButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton sendParagraphToFrontButton = new ImageAndTextButton(sendParagraphToFrontButtonImage,
				I18N.getIncreaseZIndex(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onSendParagraphToFront();
					}
				});
		sendParagraphToFrontButton.setWidth("100%");
		sendParagraphToFrontButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		propertiesPanel.add(sendParagraphToFrontButton);

		Image sendParagraphToBackButtonImage = new Image(Resources.RESOURCE.getIconDecreaseSignZIndex());
		sendParagraphToBackButtonImage.setSize(ICON_SIZE, ICON_SIZE);
		ImageAndTextButton sendParagraphToBackButton = new ImageAndTextButton(sendParagraphToBackButtonImage,
				I18N.getDecreaseZIndex(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						documentEditorSideBarListener.onSendParagraphToBack();
					}
				});
		sendParagraphToBackButton.setWidth("100%");
		sendParagraphToBackButton.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		propertiesPanel.add(sendParagraphToBackButton);

		propertiesPanel.add(new SeparatorPanel());

		Image deletePageImage = new Image(Resources.RESOURCE.getIconDeleteCollage());
		deletePageImage.setSize(ICON_SIZE, ICON_SIZE);
		Image cancelImage = new Image(Resources.RESOURCE.getIconCancel());
		cancelImage.setSize(ICON_SIZE, ICON_SIZE);

		deleteCollageButton = new ImageAndTextToggleButton(deletePageImage, cancelImage, I18N.getDeleteCollage(),
				I18N.getCancel(), new ToggleHandler() {
					@Override
					public void onToggle(boolean isDown) {
						documentEditorSideBarListener.onDeleteCollageDeleteModeChanged(isDown);
						if (nativePreviewHandler == null) {
							registerNativePreviewHandler();
						} else {
							nativePreviewHandler.removeHandler();
							nativePreviewHandler = null;
						}
					}
				});

		deleteCollageButton.sinkEvents(Event.ONMOUSEDOWN);

		propertiesPanel.add(deleteCollageButton);

		propertiesPanel.add(new SeparatorPanel());

		Image showGridToggleImage = new Image(Resources.RESOURCE.getIconShowGrid());
		showGridToggleImage.setSize(ICON_SIZE, ICON_SIZE);

		Image hideGridToggelImage = new Image(Resources.RESOURCE.getIconHideGrid());
		hideGridToggelImage.setSize(ICON_SIZE, ICON_SIZE);

		gridVisibilityToggleButton = new ImageAndTextToggleButton(showGridToggleImage, hideGridToggelImage,
				I18N.getShowGrid(), I18N.getHideGrid(), new ToggleHandler() {
					@Override
					public void onToggle(boolean isDown) {
						documentEditorSideBarListener.onShowCollageGrid(isDown);
					}
				}, false);
		propertiesPanel.add(gridVisibilityToggleButton);

		result.setEnabled(hasCollage);
		return result;
	}

	private void registerNativePreviewHandler() {
		nativePreviewHandler = Event.addNativePreviewHandler(new NativePreviewHandler() {

			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {

				if (deleteCollageButton.getIsActive() && event.getTypeInt() == Event.ONMOUSEDOWN) {
					Element element = Element.as(event.getNativeEvent().getEventTarget());
					Boolean isCollage = element.getClassName().equals(CollagePanel.getStyleCollage());

					if (!isCollage) {
						documentEditorSideBarListener.onDeleteCollageDeleteModeChanged(false);
						deleteCollageButton.setToggleStateManually(false);
					}

				}
			}
		});
	}

	private Widget addSubHeader(String text) {
		Label subHeaderLabel = new Label(text);
		subHeaderLabel.setStyleName("subHeaderLabel");
		return subHeaderLabel;
	}

	private void showSidebar(boolean showSidebar) {
		openedSidebar.setVisible(showSidebar);
		closedSidebar.setVisible(!showSidebar);
		((FlowPanel) this.getWidget()).getWidget(0).setVisible(showSidebar);
		if (!showSidebar) {
			resetSidebar();
		}
	}

	public interface DocumentEditorSideBarListener extends DictionarySelectionListener {

		void onAddFreeTextBox();

		void onAddImage();

		void onShowCollageGrid(boolean value);

		void onAddNormalPage();

		void onChangeTextBackgroundColor(Color color);

		public void onDrawSnippets(boolean enabled);

		void onDeleteCollageDeleteModeChanged(boolean down);

		public void onAddCollage();

		void onChangeBackgroundColor(Color color);

		void onAddFreeTextLine();

		void onAddFrame();

		void onFontChanged(Font font);

		void onFontWeightChanged(FontWeight value);

		void onFontStyleChanged(FontStyle value);

		void onFontColorChanged(Color color);

		void onAddSignItemToken();

		void onFontSizeChanged(FontSize newSize);

		void onAddVideo();

		public void onSendParagraphToBack();

		public void onSendParagraphToFront();

	}

	@Override
	public void resetSidebar() {
		addSnippetToggle.setToggleStateManually(false);
		deleteCollageButton.setToggleStateManually(false);
	}

	public class UserCancelUploadException extends IOException {
		private static final long serialVersionUID = 1L;

		public UserCancelUploadException() {
			super();
		}

		public UserCancelUploadException(String message) {
			super(message);
		}

	}

	public void updateAddElemtensTab(boolean layoutLocked) {
		addElementsTab.setEnabled(!layoutLocked);
		if (layoutLocked) {
			addElementsTab.getTabIcon().addStyleName("disabledImageAndTextButton");
		} else {
			addElementsTab.getTabIcon().removeStyleName("disabledImageAndTextButton");
		}
		if (layoutLocked && sidebarTabPanel.isTabSelected(addElementsTab)) {
			sidebarTabPanel.selectTab(editLayoutTab);
		}
	}

	public void updateSidebarForMultipleTokens() {
		showSidebar(false);
	}

}
