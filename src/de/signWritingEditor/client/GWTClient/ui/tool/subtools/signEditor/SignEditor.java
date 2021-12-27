package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.touch.client.Point;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.BorderSlideableArrowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.BorderSlideableArrowPanel.BorderSlideableArrowPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.HeadSymbolLayouter;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DictionaryListbox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DictionarySelectionListbox.DictionarySelectionListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.AddSignsSidebarEditor.AddSignsSidebarEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.HeadEditor.HeadEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditorButtonBar.SignEditorButtonBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignHistoryItemBrowser.SignHistoryItemBrowserListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignSavePopupPanel.SignSavePopupListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SymbolEditor.SymbolEditorListener;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.HistoryService;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.SignEditorHistoryState;
import de.signWritingEditor.client.service.SymbolGroupAnalyzer;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol;
import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CardinalDirection;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.PersistenceLocation;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignItemEditor;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.PositionedBreathSymbol;
import de.signWritingEditor.shared.model.material.PositionedCheekSymbol;
import de.signWritingEditor.shared.model.material.PositionedEarsSymbol;
import de.signWritingEditor.shared.model.material.PositionedExpressionSymbol;
import de.signWritingEditor.shared.model.material.PositionedEyeSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedHairSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedJawSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedNeckSymbol;
import de.signWritingEditor.shared.model.material.PositionedNoseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.Sign;
import de.signWritingEditor.shared.model.material.SignHistoryItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;
import de.signWritingEditor.shared.model.material.User;

public class SignEditor implements Tool {
	private static final int SIDEBAR_WIDTH = 290;
	private static final int HISTORY_ITEM_BROWSER_BORDER = 2;
	private static final int PADDING_OF_WORK_SURFACE_PANEL = 50;
	private static final int HISTORY_ITEM_BROWSER_HEIGHT = 190;
	private static final int HISTORY_ITEM_BROWSER_WIDTH = 700;
	private static final int SIGN_EDIT_PANEL_HEIGHT = 500;
	private static final double SCALE_FACTOR = 3.0;
	protected static final double FREE_X_POSITIONABLE_REATH_OFFSET = 5;
	protected static final double FREE_Y_POSITIONABLE_BREATH_OFFSET = 0;
	private static final double HEAD_TOP_OFFSET = 10.5;

	private static final int FINGER_ALPHABET_Y_OFFSET = 125;
	private static final int FINGER_ALPHABET_DISTANCE = 5;

	private DictionaryServiceAsync dictionaryService;
	private SymbolServiceAsync symbolService;
	private SymbolImageUrlService symbolImageUrlService;

	private SignModifiedListener signModifiedListener;

	private SimpleSign sign;
	private int center;
	private SimpleSign savedPreviousSign;

	private static final SimpleSign SIGNDUMMY = new SimpleSign(SignId.emptySignId, User.getUnknownUser(),
			SignLocale.ASL, new Date(0), "Dummi for beeing replacet by Servercallback");

	private Map<PositionedSymbol, Image> symbolImageMap;
	private Map<PositionedSymbol, Point> differenceMap;
	private SymbolToHeadSymbolConverter symbolToHeadSymbolConverter;

	private boolean isInDragMode;
	private boolean isSymbolPressed;

	private SignEditorButtonBar signEditorButtonBar;

	private FocusPanel focusPanel;

	private AbsolutePanel signEditPanel;
	private AbsolutePanel workSurfacePanel;

	private SimplePanel verticalSignBorderLineLeft;
	private SimplePanel verticalSignBorderLineRight;
	private SignSavePopupPanel signSavePopupPanel;

	// Side bar widgets
	private SimplePanel sidebarEditorPanel;
	private SimplePanel sidebarExtraPanel;
	private SymbolEditor symbolEditor;

	private AddSignsSidebarEditor signsAddEditor;
	private HeadEditor headEditor;

	private HistoryService historyService;
	private InlineLabel searchWordLabel;
	private InlineLabel signsLastAuthorLabel;
	private InlineLabel signsSignBookLabel;
	private InlineLabel signsModificationDateLabel;
	private LocalSessionService localSessionService;
	private boolean saveOnlyLocal;
	private SignEditorListener signEditorListener;
	private SignHistoryItemBrowser signHistoryItemBrowser;
	private boolean signHistoryItemBrowserWasOpenedBefore;
	private boolean showSignHistory;
	private BorderSlideableArrowPanel signHistoryBorderSlideableArrowPanel;
	private AbsolutePanel signHistoryItemBrowserHolder;
	private AbsolutePanel mainPanel;
	private String searchWord;
	private PositionedSymbolFactory positionedSymbolFactory;

	private PositionedSymbolModifier increase;
	private PositionedSymbolModifier rotateCounterClockwise;
	private PositionedSymbolModifier rotateClockwise;
	private PositionedSymbolModifier decrease;
	private PositionedSymbolModifier mirrorVertical;
	private PositionedSymbolModifier mirrorHorizontal;
	private SelectionTool<PositionedSymbol> selectionTool;
	private BadgeServiceClient badgeService;
	private TextBox searchWordTextBox;
	private DictionaryListbox dictionaryListbox;

	public void init(DictionaryServiceAsync dictionaryService, SymbolServiceAsync symbolService,
			HistoryService historyService, BadgeServiceClient badgeService, LocalSessionService localSessionService,
			SignEditorListener changeToolBarListener) {
		this.historyService = historyService;
		assert dictionaryService != null : "Precondition failed: dictionaryService != null";
		assert symbolService != null : "Precondition failed: symbolService != null";
		assert badgeService != null : "Precondition failed: badgeService != null";
		assert localSessionService != null : "Precondition failed: localSessionService != null";

		this.badgeService = badgeService;
		this.dictionaryService = dictionaryService;
		this.symbolService = symbolService;
		this.localSessionService = localSessionService;

		this.positionedSymbolFactory = new PositionedSymbolFactory();
		symbolImageUrlService = new SymbolImageUrlService();

		this.signEditorListener = changeToolBarListener;
		selectionTool = new SelectionTool<>();

		differenceMap = new IdentityHashMap<>();
		symbolImageMap = new IdentityHashMap<>();

		isSymbolPressed = false;
		isInDragMode = false;

		symbolToHeadSymbolConverter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);

		mainPanel = new AbsolutePanel();
		mainPanel.setStyleName("signEditor");

		focusPanel = new FocusPanel();
		mainPanel.add(focusPanel);

		mainPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.preventDefault();
				}
			}
		}, KeyDownEvent.getType());
		mainPanel.sinkEvents(Event.ONKEYDOWN);

		focusPanel.addStyleName("contentPanel");
		focusPanel.addStyleName("toolPanel");
		focusPanel.getElement().setAttribute("align", "center");

		focusPanel.addHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDown(event);
			}
		}, KeyDownEvent.getType());
		focusPanel.sinkEvents(Event.ONKEYDOWN);

		FlowPanel contentPanel = new FlowPanel();
		contentPanel.setHeight("100%");
		focusPanel.add(contentPanel);

		// History
		signHistoryItemBrowser = GWT.create(SignHistoryItemBrowser.class);
		signHistoryItemBrowser.initWithScrollPanel(localSessionService, dictionaryService, HISTORY_ITEM_BROWSER_WIDTH,
				HISTORY_ITEM_BROWSER_HEIGHT, new SignHistoryItemBrowserListener() {

					@Override
					public void onOpenSignHistoryItem(SignHistoryItem signHistoryItem) {
						handleOnOpenSignHistoryItem(signHistoryItem);
					}

					@Override
					public void onOpenLatestSign() {
						handleOnOpenLatestSign();
					}

					@Override
					public void onOpenEditedSign() {
						handleOnOpenEditedSign();

					}

					@Override
					public void onSelectSignHistoryItemChanged(SignHistoryItem selectedSignHistoryItem) {
						signHistoryBorderSlideableArrowPanel.resize();
					}

					@Override
					public void onWidgetKeyDownEvent(KeyDownEvent event) {
						if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_BACKSPACE
								|| event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DELETE) {
							removeSelectedSymbols();
						}

					}

				});
		signHistoryItemBrowserHolder = new AbsolutePanel();
		signHistoryItemBrowserHolder.add(signHistoryItemBrowser);
		signHistoryItemBrowserHolder.getElement().setAttribute("style", "position:relative");
		signHistoryItemBrowserHolder.setStyleName("historyItemBrowserHolder");

		signHistoryItemBrowserWasOpenedBefore = false;
		signHistoryBorderSlideableArrowPanel = new BorderSlideableArrowPanel(mainPanel, "Sign History",
				CardinalDirection.SOUTH, new BorderSlideableArrowPanelListener() {

					@Override
					public void onOpen() {
						if (!signHistoryItemBrowserWasOpenedBefore) {
							signHistoryItemBrowserWasOpenedBefore = true;
							signHistoryItemBrowser.openedWithNewSign(sign);
						}
					}
				});
		signHistoryBorderSlideableArrowPanel.setPosition(
				Window.getClientWidth()
						- (2 * PADDING_OF_WORK_SURFACE_PANEL + SIDEBAR_WIDTH + HISTORY_ITEM_BROWSER_BORDER),
				PADDING_OF_WORK_SURFACE_PANEL);
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				signHistoryBorderSlideableArrowPanel.setPosition(
						Window.getClientWidth()
								- (2 * PADDING_OF_WORK_SURFACE_PANEL + SIDEBAR_WIDTH + HISTORY_ITEM_BROWSER_BORDER),
						PADDING_OF_WORK_SURFACE_PANEL);
				signHistoryBorderSlideableArrowPanel.resize();
			}
		});
		signHistoryBorderSlideableArrowPanel.addContent(signHistoryItemBrowserHolder);

		// Sidebar
		contentPanel.add(createSidebar());
		EditorsListener editorsListener = createEditorsListener();
		signsAddEditor = new AddSignsSidebarEditor(symbolImageUrlService, editorsListener, positionedSymbolFactory);
		headEditor = new HeadEditor(symbolImageUrlService, selectionTool, editorsListener, positionedSymbolFactory);
		symbolEditor = createSymbolEditor();

		// Content
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("scrollPanel");
		contentPanel.add(scrollPanel);

		FlowPanel scrollContentPanel = new FlowPanel();
		scrollPanel.add(scrollContentPanel);

		AbsolutePanel searchWordContainer = new AbsolutePanel();
		searchWordContainer.addStyleName("signInfoContainer");

		AbsolutePanel signInfoContainer = new AbsolutePanel();
		signInfoContainer.addStyleName("signInfoContainer");

		searchWord = "";

		searchWordLabel = new InlineLabel(I18N.getSearchWord() + ": ");
		searchWordLabel.addStyleName("signInfoLabel");
		searchWordLabel.addStyleName("searchWordLabel");
		searchWordContainer.add(searchWordLabel);

		searchWordTextBox = new TextBox();
		searchWordTextBox.addStyleName("searchWordTextBox");
		searchWordTextBox.setText(searchWord);
		searchWordTextBox.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				event.stopPropagation();
			}
		});
		searchWordContainer.add(searchWordTextBox);

		dictionaryListbox = new DictionaryListbox(new DictionarySelectionListener() {

			@Override
			public void onChangeLocale(SignLocale locale) {
				updateSignLocale(locale);
			}
		});

		dictionaryListbox.getElement().getStyle().setProperty("float", "right");

		Label dictionaryLabel = new Label(I18N.getSelectDictionary() + ":");
		dictionaryLabel.getElement().getStyle().setProperty("float", "right");
		dictionaryLabel.getElement().getStyle().setProperty("marginTop", "11px");
		dictionaryLabel.getElement().getStyle().setProperty("marginRight", "10px");

		searchWordContainer.add(dictionaryListbox);
		searchWordContainer.add(dictionaryLabel);

		signsLastAuthorLabel = new InlineLabel();
		signsLastAuthorLabel.getElement().setId("signsLastAuthorLabel");
		signsLastAuthorLabel.addStyleName("signInfoLabel");
		signInfoContainer.add(signsLastAuthorLabel);

		signsModificationDateLabel = new InlineLabel();
		signsModificationDateLabel.getElement().setId("signsModificationDateLabel");
		signsModificationDateLabel.addStyleName("signInfoLabel");
		signInfoContainer.add(signsModificationDateLabel);

		signsSignBookLabel = new InlineLabel();
		signsSignBookLabel.getElement().setId("signsSignBookLabel");
		signsSignBookLabel.addStyleName("signInfoLabel");
		signInfoContainer.add(signsSignBookLabel);

		scrollContentPanel.add(searchWordContainer);
		scrollContentPanel.add(signInfoContainer);

		// Wrap signEditPanel with a workSurfacePanel to avoid offset
		// calculation for centering
		workSurfacePanel = new AbsolutePanel();
		workSurfacePanel.setHeight(SIGN_EDIT_PANEL_HEIGHT + "px");
		workSurfacePanel.setStyleName("workSurfacePanel");
		workSurfacePanel.addStyleName("pagePanel");
		workSurfacePanel.getElement().setAttribute("align", "center");
		scrollContentPanel.add(workSurfacePanel);
		workSurfacePanel.getElement().getStyle().setOverflow(Overflow.AUTO);

		// Ledger lines
		SimplePanel dashedUpperLine = new SimplePanel();
		dashedUpperLine.setStyleName("dashedLineHorizontal");
		workSurfacePanel.add(dashedUpperLine, 0, (int) (SimpleSign.HEAD_OFFSET * SCALE_FACTOR));

		SimplePanel dashedLowerLine = new SimplePanel();
		dashedLowerLine.setStyleName("dashedLineHorizontal");
		workSurfacePanel.add(dashedLowerLine, 0,
				(int) ((SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT) * SCALE_FACTOR));

		SimplePanel dashedSymmetryLine = new SimplePanel();
		dashedSymmetryLine.setStyleName("dashedLineVertical");
		dashedSymmetryLine.getElement().getStyle().setLeft(50, Unit.PCT);
		dashedSymmetryLine.getElement().getStyle().setPosition(Position.ABSOLUTE);
		workSurfacePanel.add(dashedSymmetryLine);

		signEditPanel = new AbsolutePanel();
		signEditPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		workSurfacePanel.add(signEditPanel);

		verticalSignBorderLineLeft = new SimplePanel();
		verticalSignBorderLineLeft.setStyleName("verticalSignBorderLine");
		verticalSignBorderLineLeft.getElement().getStyle().setLeft(0, Unit.PX);
		verticalSignBorderLineLeft.getElement().getStyle().setPosition(Position.ABSOLUTE);
		verticalSignBorderLineLeft.getElement().getStyle().setMarginLeft(-18, Unit.PX);
		signEditPanel.add(verticalSignBorderLineLeft);

		verticalSignBorderLineRight = new SimplePanel();
		verticalSignBorderLineRight.setStyleName("verticalSignBorderLine");
		verticalSignBorderLineRight.getElement().getStyle().setLeft(0, Unit.PX);
		verticalSignBorderLineRight.getElement().getStyle().setPosition(Position.ABSOLUTE);
		verticalSignBorderLineRight.getElement().getStyle().setMarginLeft(15, Unit.PX);
		signEditPanel.add(verticalSignBorderLineRight);

		workSurfacePanel.addHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				handleMouseMoveOnWorkSurfacePanel(event);
			}
		}, MouseMoveEvent.getType());
		workSurfacePanel.sinkEvents(Event.ONMOUSEMOVE);

		workSurfacePanel.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				deselectAllSymbols();
			}
		}, ClickEvent.getType());
		workSurfacePanel.sinkEvents(Event.ONCLICK);

		workSurfacePanel.addHandler(new MouseUpHandler() {
			@Override
			public void onMouseUp(MouseUpEvent event) {
				if (!isInDragMode) {
					// MouseUp while isInDragMode is handled separately inside a
					// PreviewHandler
					handlePressEnd();
				}
			}
		}, MouseUpEvent.getType());
		workSurfacePanel.sinkEvents(Event.ONMOUSEUP);

		workSurfacePanel.addHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.preventDefault();
				event.stopPropagation();
			}
		}, MouseDownEvent.getType());
		workSurfacePanel.sinkEvents(Event.ONMOUSEDOWN);

		signSavePopupPanel = new SignSavePopupPanel(new SignSavePopupListener() {

			@Override
			public void onSave() {
				handleSave();
			}

			@Override
			public void onSaveAs() {
				handleSaveAs();
			}

		});

		// ButtonBar
		signEditorButtonBar = new SignEditorButtonBar(signSavePopupPanel, new SignEditorButtonBarListener() {

			@Override
			public void onDelete() {
				handleOnDeleteSign();
			}

			@Override
			public void onShowSaveAsDialogue() {
				handleShowSaveAsDialogue();
			}

			public void onShowSaveDialogue() {
				handleShowSaveDialogue();
			}
		});

		Event.addNativePreviewHandler(new NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				if (isInDragMode && event.getTypeInt() == Event.ONMOUSEUP) {
					handlePressEnd();
					event.cancel();
				}
			}
		});

		handleSelectionChanged();
		createPositionedSymbolModifiers();
	}

	protected void updateSignLocale(SignLocale locale) {
		sign.setRegion(locale);
		updateSaveButton();
	}

	private boolean isLocaleChanged() {
		return !savedPreviousSign.getSignLocale().equals(sign.getSignLocale());
	}

	public void onLogin() {
		if (isSignEditorActive()) {
			updateSignEditorButtonBar();
			updateShowSignHistory();
		}
	}

	private void createPositionedSymbolModifiers() {
		increase = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.increase();
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canIncrease();
			}
		};

		decrease = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.decrease();
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canDecrease();
			}
		};

		mirrorHorizontal = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.mirror();
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canMirror();
			}
		};

		mirrorVertical = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.mirrorVertically();
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canMirrorVertically();
			}
		};
		rotateCounterClockwise = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.rotateCounterClockwise();
				;
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canRotate();
			}
		};

		rotateClockwise = new PositionedSymbolModifier() {

			@Override
			protected void doIt(PositionedSymbol specificPositionedSymbol) {
				specificPositionedSymbol.rotateClockwise();
				;
			}

			@Override
			protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
				return specificPositionedSymbol.canRotate();
			}
		};

	}

	private void handleOnOpenSignHistoryItem(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: signHistoryItem != null";
		if (signHistoryItem.getRevision() >= 0) {

			updateSaveButton();
			dictionaryService.getSignFromHistory(signHistoryItem, new AsyncCallback<SimpleSign>() {
				@Override
				public void onSuccess(SimpleSign result) {
					displayNewSign(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}
			});
		}
	}

	private void handleOnOpenEditedSign() {
		displayNewSign(signHistoryItemBrowser.getLatestEditedSign());
		updateSaveButton();
	}

	private void handleOnOpenLatestSign() {
		displayNewSign(signHistoryItemBrowser.getLatestSavedSign());
		updateSaveButton();
	}

	private void updateSaveButton() {
		boolean a = !isLocaleChanged();
		boolean b = localSessionService.getCurrentUser().isAuthor() || hasUnsavedChanges();
		boolean c = isValidSearchWord();
		boolean d = !savedPreviousSign.getSignId().getLowerIdPart().equals(SignId.EMPTY_SIGN_LOWER_ID);
		signEditorButtonBar.setSaveSignButtonEnabled(a && b && c && d);
	}

	private void handleOnDeleteSign() {

		if (isLocalSign()) {
			deleteLocalSign();
			signEditorListener.onChangeTool(sign);
		} else {
			deleteGlobalSign();
		}

	}

	private void deleteGlobalSign() {
		if (localSessionService.getCurrentUser().isAuthor()) {
			new YesNoDialogBox(I18N.getDelete(), I18N.getDeleteAskForConfirmationMessage()) {
				@Override
				public void onYes() {
					dictionaryService.hideSign(sign, localSessionService.getSessionKey(), new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							if (caught instanceof InvalidSessionException) {
								handleInvalidSession();
							} else if (caught instanceof AccessDeniedException) {
								handleMissingAuthorization(I18N.getDeleteSignNotAllowed());
							}
						}

						@Override
						public void onSuccess(Void result) {
							signEditorListener.onChangeTool(sign);
						}
					});
				}

				@Override
				public void onNo() {
				}
			}.center();
		} else {
			assert false : "Button should not be active for non authors.";
		}

	}

	private void deleteLocalSign() {
		signModifiedListener.onDeleteLocalSign(sign);
	}

	private void handleShowSaveAsDialogue() {
		signSavePopupPanel.setToSaveAsDialogue(localSessionService.getCurrentUser().isAuthor(), getSearchWord());
	}

	private void handleShowSaveDialogue() {
		signSavePopupPanel.setToSaveDialogue(localSessionService.getCurrentUser().isAuthor(), isLocalSign());
	}

	private void handleSaveAs() {
		setSaveOnlyLocal(signSavePopupPanel.isLocalSaveModeEnabled());

		String comment = getChangeCommentForSave();
		handleSaveWithArbitraryText(new SavingFinishedListener() {
			@Override
			public void onSavingFinished() {
				signSavePopupPanel.close();
				updatesAfterSignHasChanged();
			}
		}, signSavePopupPanel.getSearchWordBoxText(), comment);
	}

	private void handleSave() {
		boolean saveLocally = !localSessionService.getCurrentUser().isAuthor() || isLocalSign();
		setSaveOnlyLocal(saveLocally);
		String comment = getChangeCommentForSave();
		boolean replaceLocalSign = isLocalSign() && saveLocally;
		boolean saveGlobalSignLocally = !isLocalSign() && saveLocally
				&& !localSessionService.getCurrentUser().isAuthor();
		boolean replaceGlobalSign = !saveLocally && !isLocalSign();
		if (replaceLocalSign || saveGlobalSignLocally || replaceGlobalSign) {
			handleSaveOrReplace(saveLocally, comment);
		}
	}

	private SymbolEditor createSymbolEditor() {
		SymbolEditor symbolEditor = new SymbolEditor(new SymbolEditorListener() {
			@Override
			public void onRotateSymbolCounterClockwise() {
				handleRotateSymbolCounterClockwise();
			}

			@Override
			public void onRotateSymbolClockwise() {
				handleRotateSymbolClockwise();
			}

			@Override
			public void onRollSymbol() {
				handleRollSymbol();
			}

			@Override
			public void onPitchSymbol() {
				handlePitchSymbol();
			}

			@Override
			public void onMirrorSymbol() {
				handleMirrorSymbol();
			}

			@Override
			public void onMirrorVertically() {
				handleMirrorSymbolVertically();
			}

			@Override
			public void onDuplicateSymbol() {
				handleDuplicateSymbol();
			}

			@Override
			public void onRemoveSymbol() {
				handleRemoveSymbol();
			}

			@Override
			public void onIncreaseSymbolQuantity() {
				handleIncreaseSymbolQuantity();
			}

			@Override
			public void onDecreaseSymbolQuantity() {
				handleDecreaseSymbolQuantity();
			}

			@Override
			public void onSwitchArrowHead() {
				handleSwitchArrowHead();
			}

			@Override
			public void onIncreaseZIndex() {
				handleIncreaseZIndex();
			}

			@Override
			public void onDecreaseZIndex() {
				handleDecreaseZIndex();
			}

			@Override
			public void onSwitchToAlternatingArrows() {
				handleSwitchToAlternatingArrows();
			}

			@Override
			public void onSwitchToNormalArrows() {
				handleSwitchToNormalArrows();

			}

			@Override
			public void onSwitchStartingPoint() {
				handleSwitchStartingPointOfMovementSymbol();
			}

			@Override
			public void onSwitchSize() {
				handleSwitchSize();
			}

			@Override
			public void onSwitchPlane() {
				handleSwitchPlane();
			}

			@Override
			public void onSwitchColor(Color colorCode, boolean changeColorForFormerBlack) {
				handleSwitchColor(colorCode, changeColorForFormerBlack);
			}

		});

		assert symbolEditor != null : "Postcondition failed: symbolEditor != null";
		return symbolEditor;
	}

	@Override
	public Widget getPanel() {
		return mainPanel;
	}

	@Override
	public ButtonBar getButtonBar() {
		return signEditorButtonBar;
	}

	@Override
	public int getButtonBarPosition() {
		return 1; // after changeTool and before undo and redo buttons
	}

	@Override
	public String getTitle() {
		return I18N.getSignEditor();
	}

	@Override
	public boolean hasUnsavedChanges() {
		convertLegacyHeadSymbols(savedPreviousSign);
		SimpleSign clone = sign.clone();
		convertLegacyHeadSymbols(clone);

		return !savedPreviousSign.contentBasedEquals(clone);
	}

	public boolean isValidSearchWord() {
		return searchWord != null && !searchWord.isEmpty();
	}

	@Override
	public void open() {
		if (isSignEditorActive()) {
			signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
			signsAddEditor.getFingerAlphabetEditor()
					.setFingerAlphabetKeysFor(getFingerAlphabeSymbolsSortedByImagePositions());

			dictionaryListbox.setNewLocale(sign.getSignLocale());
		}
		signsAddEditor.getVisemeEditor().setButtonAndTextBoxStatus(sign.hasDisarrangedHeadSymbols());

		deselectAllSymbols();

		savedPreviousSign = savedPreviousSign != null ? savedPreviousSign : SIGNDUMMY;
		updateSignEditorButtonBar();

		badgeService.userOpenedSignEditor();
	}

	@Override
	public void close() {
		signHistoryItemBrowserWasOpenedBefore = false;
		signHistoryBorderSlideableArrowPanel.close();
		signHistoryItemBrowser.resetSignHistroyItemBrowser();
		resetSignEditor();
	}

	private void handleSaveOrReplace(boolean saveLocally, String comment) {
		assert sign.getSignId().getLowerIdPart()
				.equals(searchWord) : "Precondition failed: sign.getSignId().getLowerIdPart().equals(searchWord)";

		SignSource oldSource = sign.getSignId().getSignSource();
		SignSource source = oldSource;
		if (sign.getSignId().getSignSource().equals(SignSource.IMPORTED)) {
			source = SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS;
		} else if (sign.getSignId().getSignSource().equals(SignSource.UNKNOWN)) {
			source = SignSource.IMPORTED_BUT_OVERWRITTEN_IN_DELEGS;
		}
		sign.setSignId(new SignId(sign.getSignId().getUpperIdPart(), sign.getSignId().getLowerIdPart(),
				sign.getSignLocale(), source));
		sign.setAuthor(localSessionService.getCurrentUser());
		sign.setModificationDate(new Date());

		if (saveLocally) {
			signModifiedListener.onSaveOrReplaceLocally(sign);
			signModifiedListener.onSignLocallyModified(sign);
			updatesAfterSignHasChanged();
		} else {

			sign.setComment(comment);
			if (oldSource.equals(source)) {
				dictionaryService.updateSign(sign, localSessionService.getSessionKey(), new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {
						signModifiedListener.onSignModified(sign);
						updatesAfterSignHasChanged();
						badgeService.userUpdatedGlobalSign();
					}

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSession();
						} else if (caught instanceof AccessDeniedException) {
							handleMissingAuthorization(I18N.getSaveSignNotAllowed());
						}
					}
				});

			} else {
				dictionaryService.saveSign(sign.getSignId().getLowerIdPart(), sign, localSessionService.getSessionKey(),
						new AsyncCallback<Void>() {

							@Override
							public void onFailure(Throwable caught) {
								if (caught instanceof InvalidSessionException) {
									handleInvalidSession();
								} else if (caught instanceof AccessDeniedException) {
									handleMissingAuthorization(I18N.getSaveSignNotAllowed());
								}
							}

							@Override
							public void onSuccess(Void result) {
								signModifiedListener.onSignModified(sign);
								updatesAfterSignHasChanged();
								// this is actually an update of an imported
								// sign
								badgeService.userUpdatedGlobalSign();
							}

						});
			}

		}
	}

	@Override
	public void handleSave(final SavingFinishedListener listener) {
		// nothing to do but inform workbench to close tool
		listener.onSavingFinished();
	}

	private void handleSaveWithArbitraryText(final SavingFinishedListener listener, final String word,
			final String comment) {
		sign.setAuthor(localSessionService.getCurrentUser());
		final SignId oldId = sign.getSignId();

		if (word.equals("") || word.equals(SignId.EMPTY_SIGN_LOWER_ID) || word.contains(" ")) {
			Window.alert(I18N.getInvalidSearchWord());
		} else if (sign.getPlainSymbols().isEmpty()) {
			Window.alert(I18N.getInvalidEmptySign());
		} else if (this.signModifiedListener != null
				&& (hasUnsavedChanges() || isLocalSign() || !word.equals(oldId.getLowerIdPart()))
				&& !isSaveOnlyLocal()) {
			final boolean isSavingLocalSignToSignBookWithoutChanges = !hasUnsavedChanges() && isLocalSign()
					&& word.equals(oldId.getLowerIdPart());

			final SignSource newSource = SignSource.DELEGS;

			dictionaryService.getNewSignUpperId(sign.getSignLocale(), new AsyncCallback<Long>() {

				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				@Override
				public void onSuccess(Long result) {

					sign.setSignId(new SignId(result, word, sign.getSignLocale(), newSource));

					sign.setComment(comment);
					dictionaryService.saveSign(word, sign, localSessionService.getSessionKey(),
							new AsyncCallback<Void>() {

								@Override
								public void onSuccess(Void result) {
									sign.setPersistenceLocation(PersistenceLocation.GLOBAL_DICTIONARY);
									sign.setModificationDate(new Date());
									if (isSavingLocalSignToSignBookWithoutChanges) {
										SignId id = savedPreviousSign.getSignId();
										savedPreviousSign.setSignId(oldId);
										signModifiedListener.onSignSavedInSignBook(savedPreviousSign);
										savedPreviousSign.setSignId(id);
									}
									signModifiedListener.onSignModified(sign);
									listener.onSavingFinished();
									reloadSignAfterSave();
									badgeService.userCreatedGlobalSign();
									updateDeleteSignButton();
									assert !isLocalSign() : "Fail is not local Sign";
								}

								@Override
								public void onFailure(Throwable caught) {
									if (caught instanceof InvalidSessionException) {
										handleInvalidSession();
									} else if (caught instanceof AccessDeniedException) {
										handleMissingAuthorization(I18N.getSaveSignNotAllowed());
									}
								}
							});
				}
			});

		} else if (isSaveOnlyLocal() || hasUnsavedChanges() || isLocalSign()) {
			SignSource source = SignSource.DELEGS_LOCAL;
			Date date = new Date();
			long newUpperId = date.getTime();
			SignId newId = new SignId(newUpperId, word, sign.getSignLocale(), source);
			sign.setSignId(newId);
			sign.setModificationDate(new Date());
			this.signModifiedListener.onSignLocallyModified(sign);
			listener.onSavingFinished();
			reloadSignAfterSave();
		}
	}

	private void handleInvalidSession() {
		new MessageDialogBox(I18N.getInvalidSessionTitle(), I18N.getInvalidSessionLoginMessage()).center();
		signEditorListener.onInvalidSessionExceptionCaught();
	}

	private void handleMissingAuthorization(String message) {
		signEditorListener.onMissingAuthorizationExceptionCaught(message);
	}

	private void reloadSignAfterSave() {
		SimpleSign signToLoad = sign.clone();
		sign = null;
		resetSignEditor();
		handleSignLoaded(signToLoad);
		displayNewSign(sign);
		signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
	}

	@Override
	public Image getIcon() {
		return new Image(RESOURCE.getToolBarIconEmpty());
	}

	private void handleSignHasChanged() {
		updateSaveButton();
		if (showSignHistory) {
			signHistoryItemBrowser.updateEditedSign(sign, false);
		}
	}

	public void openSign(final SignItemEditor signItem, final SignLocale signLocale, String searchWord,
			SignModifiedListener signModifiedListener) {
		assert signItem != null : "Precondition failed: signItem != null";
		assert signModifiedListener != null : "Precondition failed: signModifiedListener != null";
		assert signLocale != null : "Precondition failed: signLocale != null";

		resetSignEditor();

		this.signModifiedListener = signModifiedListener;

		if (signItem.hasLocalSign()) {
			handleSignLoaded(signItem);
			sign.setRegion(signLocale);
			displayNewSign(sign);
			signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
			signsAddEditor.getFingerAlphabetEditor()
					.setFingerAlphabetKeysFor(getFingerAlphabeSymbolsSortedByImagePositions());
			initHistory();
		} else {
			dictionaryService.getSign(signItem.getSignId(),
					new SignWritingCallback<SimpleSign>(I18N.getErrorLoadingSign()) {
						@Override
						public void onSuccess(SimpleSign result) {
							handleSignLoaded(new SignItemEditor(result.clone(), signItem.getSearchWord()));
							sign.setRegion(signLocale);
							displayNewSign(sign);
							signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
							initHistory();
						}
					});
			sign = SIGNDUMMY;
		}
		if (signItem.getSignId().getLowerIdPart().equals(SignId.EMPTY_SIGN_LOWER_ID)) {
			searchWordTextBox.setText(searchWord);
		}

	}

	public void openSignFromHistory(final SignEditorHistoryState historyState) {
		resetSignEditor();
		handleSignLoaded(historyState.getCurrentSign().clone());
		this.savedPreviousSign = historyState.getSavedPreviousSign().clone();

		updateSignBorderLines();

		updateSign(sign);

		signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
	}

	@Override
	public boolean hasHistorySupport() {
		return true;
	}

	public String getChangeCommentForSave() {
		String comment = "";
		if (signSavePopupPanel.isCommentPanelVisible() && localSessionService.getCurrentUser().isAuthor()) {
			comment = signSavePopupPanel.getCommentText();
		}
		return comment;
	}

	public SignId getIdOfSignToReplace() {
		String word = searchWord;
		if (word.equals("")) {
			word = SignId.EMPTY_SIGN_LOWER_ID;
		}
		return new SignId(sign.getSignId().getUpperIdPart(), word, sign.getSignLocale(),
				sign.getSignId().getSignSource());
	}

	private void resetSignEditor() {
		removeAllSymbolImages();
		this.isInDragMode = false;
		sign = null;
		updateSignBorderLines();

		symbolEditor.resetSidebar();
		signsAddEditor.resetSidebar();
		headEditor.resetSidebar();
	}

	protected Image createSymbolImage(final PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		String imageUrl;

		if (symbol instanceof HeadSymbol) {
			imageUrl = symbolImageUrlService.getHeadSymbolImageUrl((HeadSymbol) symbol, SCALE_FACTOR, true);
		} else {
			PositionedSymbol positionedSymbol = (PositionedSymbol) symbol;

			imageUrl = symbolImageUrlService.getSymbolImageUrl(positionedSymbol, SCALE_FACTOR);
		}

		final Image symbolImage = new Image(imageUrl);
		symbolImage.setStyleName("symbolImage");

		symbolImage.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				handleMouseDownOnSymbol(symbol, event);
			}
		});

		symbolImage.addMouseUpHandler(new MouseUpHandler() {
			@Override
			public void onMouseUp(MouseUpEvent event) {
				handleMouseUpInSymbolImage(symbol, event);
			}
		});

		symbolImage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
			}
		});

		return symbolImage;
	}

	protected void handleMoveSymbols(Point mouseDragPosition) {
		assert mouseDragPosition != null : "Precondition failed: mouseDragPosition != null";

		double invalidMinYDifference = 0;
		double invalidMaxYDifference = 0;
		// Check for invalid (out of bounds) y-positions of symbols
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			assert differenceMap
					.containsKey(selectedSymbol) : "Precondition failed: differenceMap.containsKey(selectedSymbol)";
			if (differenceMap.get(selectedSymbol) != null) {
				Point selectedSymbolDifference = differenceMap.get(selectedSymbol);
				double newY = (mouseDragPosition.getY() - selectedSymbolDifference.getY()) / SCALE_FACTOR;
				if (newY < 0) {
					invalidMinYDifference = Math.min(invalidMinYDifference, newY);
				}
				if (newY + selectedSymbol.getHeight() > SimpleSign.SIGN_HEIGHT_PX) {
					invalidMaxYDifference = Math.max(invalidMaxYDifference,
							newY + selectedSymbol.getHeight() - SimpleSign.SIGN_HEIGHT_PX);
				}
			}
		}

		// Set new positions for symbols
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			assert differenceMap
					.containsKey(selectedSymbol) : "Precondition failed: differenceMap.containsKey(selectedSymbol)";
			if (differenceMap.get(selectedSymbol) != null) {
				Point selectedSymbolDifference = differenceMap.get(selectedSymbol);
				double newX = mouseDragPosition.getX() - selectedSymbolDifference.getX();
				double newY = mouseDragPosition.getY() - selectedSymbolDifference.getY();

				newX = adjustAbsolutePositionToScaledPosition(newX);

				newY = adjustAbsolutePositionToScaledPosition(newY);

				// Compensate out of bounds y-positions
				newY -= (invalidMaxYDifference + invalidMinYDifference) * SCALE_FACTOR;

				setSymbolImagePosition(selectedSymbol, (int) newX, (int) newY);

				selectedSymbol.setX((int) (newX / SCALE_FACTOR));
				selectedSymbol.setY((int) (newY / SCALE_FACTOR));
			}
		}

		updateSignBorderLines();
		rearrangeHeadSymbolsToSymbolImages(true);
		updateFingerAlphabetTextToMatch();
	}

	private double adjustAbsolutePositionToScaledPosition(double absoluteValue) {
		double scaledValue = absoluteValue;
		double positiveAbsoluteValue = Math.abs(absoluteValue);
		double absoluteValueSign = Math.signum(absoluteValue);

		if (positiveAbsoluteValue % SCALE_FACTOR > SCALE_FACTOR / 2) {
			scaledValue = absoluteValue + (absoluteValueSign * (SCALE_FACTOR - (positiveAbsoluteValue % SCALE_FACTOR)));
		} else {
			scaledValue = absoluteValue - (absoluteValueSign * (positiveAbsoluteValue % SCALE_FACTOR));
		}
		return scaledValue;
	}

	protected void handlePressEnd() {
		isSymbolPressed = false;

		rearrangeHeadSymbolsToSymbolImages(false);
		updateSignBorderLines();

		registerHistoryEvent();
		isInDragMode = false; // Mouse up always ends dragging
	}

	protected void handleDragStartOnSymbol(PositionedSymbol symbol, boolean multiSelectMode, Point dragStartPosition) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert dragStartPosition != null : "Precondition failed: dragStartPosition != null";

		focusPanel.setFocus(true);

		isSymbolPressed = true;

		if (!selectionTool.isSelected(symbol) && !multiSelectMode) {
			deselectAllSymbols();
			selectSymbol(symbol);
		}

		for (Entry<PositionedSymbol, Point> entry : differenceMap.entrySet()) {
			Image symbolImage = symbolImageMap.get(entry.getKey());
			int widgetLeft = signEditPanel.getWidgetLeft(symbolImage);
			int widgetTop = signEditPanel.getWidgetTop(symbolImage);
			entry.setValue(new Point(dragStartPosition.getX() - widgetLeft, dragStartPosition.getY() - widgetTop));
		}
	}

	protected boolean hasSymbolImage(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return symbolImageMap.containsKey(symbol);
	}

	protected AbsolutePanel getSignEditPanel() {
		return signEditPanel;
	}

	protected AbsolutePanel getWorkSurfacePanel() {
		return workSurfacePanel;
	}

	protected boolean isSymbolPressed() {
		return isSymbolPressed;
	}

	protected void deselectAllSymbols() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			symbolImageMap.get(selectedSymbol).removeStyleDependentName("selected");
		}

		selectionTool.clearSelection();
		differenceMap.clear();

		handleSelectionChanged();
	}

	private Widget createSidebar() {
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("sidebar");

		sidebarEditorPanel = new SimplePanel();
		sidebarEditorPanel.addStyleName("sidebarEditorPanel");
		flowPanel.add(sidebarEditorPanel);

		sidebarExtraPanel = new SimplePanel();
		sidebarExtraPanel.addStyleName("sidebarExtraPanel");
		flowPanel.add(sidebarExtraPanel);

		assert flowPanel != null : "Postcondition failed: result != null";
		return flowPanel;
	}

	private EditorsListener createEditorsListener() {
		return new EditorsListener() {
			@Override
			public void onHeadSymbolsChanged(List<HeadSymbol> newHeadSymbols, int cursorPosition) {
				handleHeadSymbolsChanged(newHeadSymbols, cursorPosition);
			}

			@Override
			public void onFocusKeyTextBox() {
				handleFocusKeyTextBox();
			}

			@Override
			public void onDeleteOldHeadSymbols() {
				handleDeleteOldHeadSymbols();
			}

			@Override
			public void onArrangeHeadSymbols() {
				handleArrangeVisemes();
			}

			@Override
			public void onAddFreePositionedHeadSymbol(HeadSymbol newHeadSymbol) {
				addFreePositionedHeadSymbol(newHeadSymbol);
			}

			@Override
			public void onEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
				handleEyeSymbolChanged(eyeSymbols);
			}

			@Override
			public void onHeadPostureChanged(PositionedHeadPostureSymbol headPosture) {
				handleHeadPostureChanged(headPosture);
			}

			@Override
			public void onAddSymbol(Symbol symbol, int xOffset, int yOffset) {
				handleAddSymbol(symbol, xOffset, yOffset);
			}

			@Override
			public void onMouthSymbolChanged(PositionedMouthSymbol mouthSymbol) {
				handleMouthSymbolChanged(mouthSymbol);
			}

			@Override
			public void onCheeksSymbolChanged(List<PositionedCheekSymbol> cheekSymbols) {
				handleCheekSymbolChanged(cheekSymbols);
			}

			@Override
			public void onJawSymbolChanged(List<PositionedJawSymbol> jawSymbols) {
				handleJawSymbolChanged(jawSymbols);
			}

			@Override
			public void onBreathSymbolChanged(List<PositionedBreathSymbol> breathBaseSymbols) {
				handleBreathSymbolChanged(breathBaseSymbols);
			}

			@Override
			public void onRotateMouthSymbolClockwise() {
				handleModifyPositionedSymbol(rotateClockwise, PositionedMouthSymbol.class);
			}

			@Override
			public void onRotateMouthSymbolCounterClockwise() {
				handleModifyPositionedSymbol(rotateCounterClockwise, PositionedMouthSymbol.class);
			}

			@Override
			public void onDecreaseMouthSymbol() {
				handleModifyPositionedSymbol(decrease, PositionedMouthSymbol.class);
			}

			@Override
			public void onIncreaseMouthSymbol() {
				handleModifyPositionedSymbol(increase, PositionedMouthSymbol.class);
			}

			@Override
			public void onMirrorMouthSymbolHorizontally() {
				handleModifyPositionedSymbol(mirrorHorizontal, PositionedMouthSymbol.class);
			}

			@Override
			public void onChangeColorOfType(boolean changeBlackToNewColor, Color colorCode,
					Class<? extends PositionedSymbol> classType) {
				handleColorChanged(changeBlackToNewColor, colorCode, classType);
			}

			@Override
			public void onRotateEyesSymbolClockwise() {
				handleModifyPositionedSymbol(rotateClockwise, PositionedEyeSymbol.class);
			}

			@Override
			public void onRotateEyesSymbolCounterClockwise() {
				handleModifyPositionedSymbol(rotateCounterClockwise, PositionedEyeSymbol.class);
			}

			@Override
			public void onMirrorEyesSymbol() {
				handleModifyPositionedSymbol(mirrorVertical, PositionedEyeSymbol.class);
			}

			@Override
			public void onIncreaseEyeSymbols() {
				handleModifyPositionedSymbol(increase, PositionedEyeSymbol.class);
			}

			@Override
			public void onDecreaseEyeSymbols() {
				handleModifyPositionedSymbol(decrease, PositionedEyeSymbol.class);
			}

			@Override
			public void onRotatHeadPostureCounterClockwise() {
				handleModifyPositionedSymbol(rotateCounterClockwise, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onRotateHeadPostureClockwise() {
				handleModifyPositionedSymbol(rotateClockwise, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onDecreaseHeadPosture() {
				handleModifyPositionedSymbol(decrease, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onIncreaseHeadPosture() {
				handleModifyPositionedSymbol(increase, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onMirrorHeadPostureVertical() {
				handleModifyPositionedSymbol(mirrorVertical, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onMirrorHeadPostureHorizontal() {
				handleModifyPositionedSymbol(mirrorHorizontal, PositionedHeadPostureSymbol.class);
			}

			@Override
			public void onHairSymbolChanged(PositionedHairSymbol hairSymbol) {
				handleHairSymbolChanged(hairSymbol);
			}

			@Override
			public void onExpressionSymbolChanged(ExpressionBaseSymbol expressionSymbol) {
				handleExpressionSymbolChanged(expressionSymbol);
			}

			@Override
			public void onNeckSymbolChanged(NeckBaseSymbol neckSymbol) {
				handleNeckSymbolChanged(neckSymbol);
			}

			@Override
			public void onNoseSymbolChanged(NoseBaseSymbol noseSymbol) {
				handleNoseSymbolChanged(noseSymbol);
			}

			@Override
			public void onEarsSymbolChanged(List<PositionedEarsSymbol> earSymbols) {
				handleEarsSymbolChanged(earSymbols);
			}

			@Override
			public void onSwitchHeadPostureSymbolToNormalArrows() {
				handleSwitchHeadPostureSymbolToNormalArrows();
			}

			@Override
			public void onSwitchHeadPostureSymbolToAlternatingArrows() {
				handleSwitchHeadPostureSymbolToAlternatingArrows();
			}

			@Override
			public void onToggleRightEarButton() {
				handleToggleRightEarSymbol();
			}

			@Override
			public void onToggleLeftEarButton() {
				handleToggleLeftEarSymbol();
			}

			@Override
			public void onLeftCheekStatusChanged(boolean active) {
				handleToggleLeftCheekSymbol(active);
			}

			@Override
			public void onRightCheekStatusChanged(boolean active) {
				handleToggleRightCheekSymbol(active);
			}

			@Override
			public void onRightBreathStatusChanged(boolean active) {
				handleToggleRightBreathSymbol(active);
			}

			@Override
			public void onLeftBreathStatusChanged(boolean active) {
				handleToggleLeftBreathSymbol(active);
			}

			@Override
			public void onDecreaseNeckButton() {
				handleModifyPositionedSymbol(decrease, PositionedNeckSymbol.class);
			}

			@Override
			public void onIncreaseNeckButton() {
				handleModifyPositionedSymbol(increase, PositionedNeckSymbol.class);
			}

			@Override
			public void onRotateJawCounterClockwiseButton() {
				handleModifyPositionedSymbol(rotateCounterClockwise, PositionedJawSymbol.class);
			}

			@Override
			public void onRotateJawClockwiseButton() {
				handleModifyPositionedSymbol(rotateClockwise, PositionedJawSymbol.class);
			}

			@Override
			public void onLeftEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
				handleLeftEyeSymbolChanged(eyeSymbols);
			}

			@Override
			public void onRightEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
				handleRightEyeSymbolChanged(eyeSymbols);
			}

			@Override
			public void addFreePositionedBreathSymbol(Symbol symbol) {

				double xPosPixel = FREE_X_POSITIONABLE_REATH_OFFSET;
				double yPosPixel = FREE_Y_POSITIONABLE_BREATH_OFFSET;

				List<PositionedSymbol> newSymbols = new ArrayList<PositionedSymbol>();

				for (PositionedSymbol positionableSymbol : selectionTool.getSelectedItems()) {
					xPosPixel = positionableSymbol.getX() + positionableSymbol.getWidth()
							+ FREE_X_POSITIONABLE_REATH_OFFSET;
					yPosPixel = positionableSymbol.getY();
					final Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
							symbol.getVariation(), symbol.getFill(), symbol.getRotation(), symbol.getWidth(),
							symbol.getHeight());
					final PositionedSymbol positionedSymbol = new PositionedSymbol(newSymbol,
							(int) Math.ceil(xPosPixel), (int) Math.ceil(yPosPixel), sign.getMaxZ() + 1);
					sign.addSymbol(positionedSymbol);

					addSymbolImage(positionedSymbol);
					updateSignBorderLines();

					newSymbols.add(positionedSymbol);
				}
				for (PositionedSymbol symbolToSelect : newSymbols) {
					selectSymbol(symbolToSelect);
				}
			}

			@Override
			public void onFreePositionHeadSymbols() {
				handleFreePositionVisemes();
			}

			@Override
			public void onAddFingerAlphabetSymbols(PositionedFingerAlphabetSymbol symbols) {
				handleAddFingerAlphabetSymbols(symbols);
			}

			@Override
			public void onArrangeFingerAlphabet() {
				handleArrangeFingerAlphabet();
			}

			@Override
			public String onSpellSearchWord() {
				return handleSpellSearchWord();
			}

			@Override
			public void onHistoryEvent() {
				registerHistoryEvent();
			}
		};
	}

	private String handleSpellSearchWord() {
		deselectAllSymbols();
		List<PositionedFingerAlphabetSymbol> fingerAlphabetSymbols = new ArrayList<PositionedFingerAlphabetSymbol>();
		fingerAlphabetSymbols.addAll(sign.getFingerAlphabetSymbols());
		for (PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol : fingerAlphabetSymbols) {
			removeSymbol(positionedFingerAlphabetSymbol, sign);
		}
		return getSearchWord();
	}

	private String getSearchWord() {
		return this.searchWordTextBox.getText().toUpperCase();
	}

	protected void handleAddFingerAlphabetSymbols(PositionedFingerAlphabetSymbol symbol) {

		List<PositionedFingerAlphabetSymbol> fingerAlphabetSymbols = sign.getFingerAlphabetSymbols();
		int xBase = 0;
		if (!fingerAlphabetSymbols.isEmpty()) {
			PositionedSymbol lastPositionedSymbol = fingerAlphabetSymbols.get(fingerAlphabetSymbols.size() - 1);
			int lastXPosition = lastPositionedSymbol.getX() + lastPositionedSymbol.getWidth();
			if (fingerAlphabetSymbols.size() > 1) {
				PositionedSymbol priorToLastPositionedSymbol = fingerAlphabetSymbols
						.get(fingerAlphabetSymbols.size() - 2);

				int priorLastXPosition = priorToLastPositionedSymbol.getX() + priorToLastPositionedSymbol.getWidth();
				xBase = Math.max(lastXPosition, priorLastXPosition);
			} else {
				xBase = lastXPosition;
			}
		}

		symbol.setY(symbol.getY() + FINGER_ALPHABET_Y_OFFSET - symbol.getHeight());
		symbol.setX(xBase + FINGER_ALPHABET_DISTANCE);

		this.sign.addFingerAlphabetSymbol(symbol);

		addSymbolImage(symbol);

		selectSymbol(symbol);

		updateSignBorderLines();

	}

	private void handleColorChanged(boolean changeLineColor, Color colorCode,
			Class<? extends PositionedSymbol> classType) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;
				List<PositionedSymbol> positionedSymbols = selectedHeadSymbol
						.getPostionedSymbolsForClassType(classType);

				for (PositionedSymbol positionedSymbol : positionedSymbols) {
					if (changeLineColor) {
						positionedSymbol.setLineColor(colorCode);
					} else {
						positionedSymbol.setFillColor(colorCode);
					}
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleSwitchArrowHead() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchArrowHead();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchArrowHead();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();
			}
		}
	}

	private void handleSwitchStartingPointOfMovementSymbol() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchStartingPoint();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchStartingPoint();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();
			}
		}
	}

	private void handleSwitchSize() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchSize();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchSize();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}
	}

	private void handleSwitchPlane() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchPlane();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchPlane();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}
	}

	private void handleSwitchColor(Color colorCode, boolean changeLineColor) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof HeadSymbol) {
				if (changeLineColor) {
					selectedSymbol.setLineColor(colorCode);
				} else {
					selectedSymbol.setFillColor(colorCode);
				}
				updateHeadSymbolImage((HeadSymbol) selectedSymbol);
			} else if (selectedSymbol instanceof PositionedSymbol) {
				if (changeLineColor) {
					selectedSymbol.setLineColor(colorCode);
				} else {
					selectedSymbol.setFillColor(colorCode);
				}
				updateSymbolImage(selectedSymbol,
						symbolImageUrlService.getSymbolImageUrl(selectedSymbol, SCALE_FACTOR));
			}
		}
		updateSidebar();
	}

	private void handleMouthSymbolChanged(PositionedMouthSymbol mouthSymbol) {
		assert mouthSymbol != null : "Precondition failed: mouthSymbol != null";

		Set<PositionedSymbol> selectedSymbols = selectionTool.getSelectedItems();
		for (PositionedSymbol positionable : selectedSymbols) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;
				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setMouthSymbol(mouthSymbol);
					updateHeadSymbolImage(selectedHeadSymbol);
				}

			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleHeadPostureChanged(PositionedHeadPostureSymbol headPosture) {
		assert headPosture != null : "Precondition failed: headPosture != null";

		Set<PositionedSymbol> selectedSymbols = selectionTool.getSelectedItems();
		for (PositionedSymbol positionable : selectedSymbols) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setHeadPostureSymbol(headPosture.clone());
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
		assert eyeSymbols != null : "Precondition failed: eyeSymbols != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setEyeSymbols(eyeSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleLeftEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
		assert eyeSymbols != null : "Precondition failed: eyeSymbols != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				List<PositionedEyeSymbol> newSymbols = new ArrayList<PositionedEyeSymbol>();
				newSymbols.addAll(eyeSymbols);
				List<PositionedEyeSymbol> oldSymbol = selectedHeadSymbol.getPositionedEyeSymbols();

				for (PositionedEyeSymbol positionedEyesSymbol : oldSymbol) {
					if (positionedEyesSymbol.isRightEye()) {
						newSymbols.add(positionedEyesSymbol);
					}
				}

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setEyeSymbols(newSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
	}

	private void handleRightEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols) {
		assert eyeSymbols != null : "Precondition failed: eyeSymbols != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				List<PositionedEyeSymbol> newSymbols = new ArrayList<PositionedEyeSymbol>();
				newSymbols.addAll(eyeSymbols);
				List<PositionedEyeSymbol> oldSymbol = selectedHeadSymbol.getPositionedEyeSymbols();

				for (PositionedEyeSymbol positionedEyesSymbol : oldSymbol) {
					if (positionedEyesSymbol.isLeftEye()) {
						newSymbols.add(positionedEyesSymbol);
					}
				}

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setEyeSymbols(newSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
	}

	private void handleCheekSymbolChanged(List<PositionedCheekSymbol> cheekSymbols) {
		assert cheekSymbols != null : "Precondition failed: cheekSymbols != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setCheekSymbols(cheekSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleJawSymbolChanged(List<PositionedJawSymbol> jawSymbols) {
		assert jawSymbols != null : "Precondition failed: jawSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setJawSymbol(jawSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleBreathSymbolChanged(List<PositionedBreathSymbol> breathBaseSymbols) {
		assert breathBaseSymbols != null : "Precondition failed: breathBaseSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setBreathSymbols(breathBaseSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleHairSymbolChanged(PositionedHairSymbol hairSymbol) {
		assert hairSymbol != null : "Precondition failed: hairSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setHairSymbol(hairSymbol);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleExpressionSymbolChanged(ExpressionBaseSymbol expressionSymbol) {
		assert expressionSymbol != null : "Precondition failed: expressionSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol
							.setExpressionSymbol(new PositionedExpressionSymbol(expressionSymbol.getIswaSymbol()));
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleNeckSymbolChanged(NeckBaseSymbol neckSymbol) {
		assert neckSymbol != null : "Precondition failed: neckSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setNeckSymbol(new PositionedNeckSymbol(neckSymbol.getIswaSymbol()));
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleNoseSymbolChanged(NoseBaseSymbol noseSymbol) {
		assert noseSymbol != null : "Precondition failed: noseSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setNoseSymbol(new PositionedNoseSymbol(noseSymbol.getIswaSymbol()));
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleEarsSymbolChanged(List<PositionedEarsSymbol> earSymbols) {
		assert earSymbols != null : "Precondition failed: earsSymbol != null";

		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					selectedHeadSymbol.setEarSymbols(earSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleToggleLeftCheekSymbol(boolean active) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				List<PositionedCheekSymbol> cheeks = new ArrayList<PositionedCheekSymbol>();
				cheeks.addAll(selectedHeadSymbol.getPositionedCheekSymbols());
				assert cheeks.size() <= 2 : "Precondition failed cheeks.size() <= 2";

				boolean hadLeftCheek = false;
				for (int i = 0; i < cheeks.size(); i++) {
					if (cheeks.get(i).isLeftCheek()) {
						if (!active) {
							cheeks.remove(i);
						}
						hadLeftCheek = true;
					}
				}
				if (!hadLeftCheek && cheeks.size() > 0) {
					cheeks.add((PositionedCheekSymbol) positionedSymbolFactory.createPositionedSymbol(
							CheeksBaseSymbol.getLeftCheekFor(cheeks.get(0).getSymbol().getBaseSymbol()),
							Location.LEFT));
				}
				selectedHeadSymbol.setCheekSymbols(cheeks);

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleToggleRightCheekSymbol(boolean active) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				List<PositionedCheekSymbol> cheeks = new ArrayList<PositionedCheekSymbol>();
				cheeks.addAll(selectedHeadSymbol.getPositionedCheekSymbols());
				assert cheeks.size() <= 2 : "Precondition failed ears.size() <= 2";

				boolean hadRightCheek = false;
				for (int i = 0; i < cheeks.size(); i++) {
					if (cheeks.get(i).isRightCheek()) {
						if (!active) {
							cheeks.remove(i);
						}
						hadRightCheek = true;
					}
				}
				if (!hadRightCheek && cheeks.size() > 0) {
					cheeks.add((PositionedCheekSymbol) positionedSymbolFactory.createPositionedSymbol(
							CheeksBaseSymbol.getRightCheekFor(cheeks.get(0).getSymbol().getBaseSymbol()),
							Location.RIGHT));
				}
				selectedHeadSymbol.setCheekSymbols(cheeks);

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleToggleLeftBreathSymbol(boolean active) {
		for (PositionedSymbol positionable : selectionTool.getSelectedItems()) {
			if (positionable instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) positionable;

				if (!selectedHeadSymbol.isPlaceholder()) {
					List<PositionedBreathSymbol> newPositionedBreathSymbols = new ArrayList<PositionedBreathSymbol>();
					for (PositionedBreathSymbol breath : selectedHeadSymbol.getPositionedBreathSymbols()) {

						if (breath.isRightBreathSymbol()) {
							if (active && !breath.getSymbol().equals(BreathBaseSymbol.NONE.getIswaSymbol())) {
								newPositionedBreathSymbols.add(new PositionedBreathSymbol(
										BreathBaseSymbol.getLeftBreathSymbolFor(breath.getSymbol()), Location.LEFT));
							}
							newPositionedBreathSymbols.add(breath);
						}
					}
					selectedHeadSymbol.setBreathSymbols(newPositionedBreathSymbols);
					updateHeadSymbolImage(selectedHeadSymbol);
				}
			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleToggleRightBreathSymbol(boolean active) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				List<PositionedBreathSymbol> breathSymbols = new ArrayList<PositionedBreathSymbol>();
				breathSymbols.addAll(selectedHeadSymbol.getPositionedBreathSymbols());
				assert breathSymbols.size() <= 2 : "Precondition failed ears.size() <= 2";

				boolean hadRightBreath = false;
				for (int i = 0; i < breathSymbols.size(); i++) {
					if (breathSymbols.get(i).isRightBreathSymbol()) {
						if (!active) {
							breathSymbols.remove(i);
						}
						hadRightBreath = true;
					}
				}
				if (!hadRightBreath && breathSymbols.size() > 0) {
					breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
							BreathBaseSymbol.getRightBreathSymbolFor(breathSymbols.get(0).getSymbol()),
							Location.RIGHT));
				}
				selectedHeadSymbol.setBreathSymbols(breathSymbols);

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void selectSymbol(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		selectionTool.select(symbol);
		differenceMap.put(symbol, null);

		Image symbolImage = symbolImageMap.get(symbol);

		assert symbolImage != null : "Assertion failed: symbolImage != null";

		symbolImage.addStyleDependentName("selected");

		handleSelectionChanged();
	}

	private void deselectSymbol(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert selectionTool.isSelected(symbol) : "Precondition failed:  selectionTool.isSelected(symbol)";

		symbolImageMap.get(symbol).removeStyleDependentName("selected");

		differenceMap.remove(symbol);
		selectionTool.deselect(symbol);

		handleSelectionChanged();
	}

	private void handleSelectionChanged() {
		// Update deferred since selection my change multiple times during the
		// handling of one event
		Scheduler.get().scheduleFinally(new ScheduledCommand() {
			@Override
			public void execute() {
				updateSidebar();
			}
		});
	}

	public void updateSignEditorButtonBar() {
		updateDeleteSignButton();
		updateSaveButton();
	}

	private void updateDeleteSignButton() {
		if (localSessionService.getCurrentUser().isAuthor() && !isLocalSign()
				&& !sign.getSignId().equals(Sign.emptySign.getSignId())) {
			signEditorButtonBar.setDeleteSignButtonEnabled(true);
		} else if (isLocalSign()) {
			signEditorButtonBar.setDeleteSignButtonEnabled(true);
		} else {
			signEditorButtonBar.setDeleteSignButtonEnabled(false);
		}

	}

	private void updateSidebar() {
		updateSidebarForAnySelection();

		if (areOnlyHeadSymbolsAndLegacyHeadSymbolsSelected()) {
			headEditor.updateSidebar();
			displaySidebarExtraPanel(headEditor);
		} else {
			displaySidebarExtraPanel(signsAddEditor);
			if (isSignEditorActive()) {
				signsAddEditor.getVisemeEditor().setVisemeKeysFor(sign.getHeadSymbols());
			}
		}
	}

	private void updateSidebarForAnySelection() {
		Color selectedSymbolColorForFormerBlack = null;
		Color selectedSymbolColorForFormerWhite = null;
		boolean selectAColorForFormerBlack = true;
		boolean selectAColorForFormerWhite = true;

		symbolEditor.showRotateButtons(false);
		symbolEditor.showPitchButton(false);
		symbolEditor.showRollButton(false);
		symbolEditor.showMirrorButton(false);
		symbolEditor.showMirrorVerticallyButton(false);
		symbolEditor.showIncreaseButton(false);
		symbolEditor.showDecreaseButton(false);
		symbolEditor.showSwitchArrowHeadButton(false);
		symbolEditor.showSwitchToAlternatingArrowsButton(false);
		symbolEditor.showSwitchToNormalArrowsButton(false);
		symbolEditor.showSwitchStartingPointButton(false);
		symbolEditor.showSwitchSizeButton(false);
		symbolEditor.showSwitchPlaneButton(false);
		symbolEditor.showIncreaseZIndexButton(false);
		symbolEditor.showDecreaseZIndexButton(false);
		symbolEditor.showRemoveButton(false);
		symbolEditor.showDuplicateButton(false);
		symbolEditor.enableColorChanger(false);

		if (selectionTool.hasAnySelection()) {
			sidebarExtraPanel.clear();

			symbolEditor.showIncreaseZIndexButton(true);
			symbolEditor.showDecreaseZIndexButton(true);
			symbolEditor.showRemoveButton(true);
			symbolEditor.showDuplicateButton(true);
			symbolEditor.enableColorChanger(true);
			for (PositionedSymbol positionableSymbol : selectionTool.getSelectedItems()) {
				if (selectedSymbolColorForFormerBlack == null || selectedSymbolColorForFormerWhite == null) {
					selectedSymbolColorForFormerBlack = positionableSymbol.getLineColor();
					selectedSymbolColorForFormerWhite = positionableSymbol.getFillColor();
				}
				if (selectAColorForFormerBlack
						&& !positionableSymbol.getLineColor().equals(selectedSymbolColorForFormerBlack)) {
					selectAColorForFormerBlack = false;
				}
				if (selectAColorForFormerWhite
						&& !positionableSymbol.getFillColor().equals(selectedSymbolColorForFormerWhite)) {
					selectAColorForFormerWhite = false;
				}

				if (positionableSymbol instanceof PositionedSymbol) {
					PositionedSymbol pSymbol = (PositionedSymbol) positionableSymbol;

					symbolService.createPositionedSymbol(pSymbol.getSymbol(), pSymbol.getX(), pSymbol.getY(),
							pSymbol.getZ(), new AsyncCallback<PositionedSymbol>() {

								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
								}

								@Override
								public void onSuccess(PositionedSymbol result) {
									assert result != null : "Precondition failed: result != null";

									PositionedSymbol symbolManipulator = (PositionedSymbol) result;
									if (symbolManipulator.canRotate()) {
										symbolEditor.showRotateButtons(true);
									}
									if (symbolManipulator.canPitch()) {
										symbolEditor.showPitchButton(true);
									}
									if (symbolManipulator.canRoll()) {
										symbolEditor.showRollButton(true);
									}
									boolean headSymbolsSelected = isHeadSymbolSelected();
									if (headSymbolsSelected || symbolManipulator.canMirror()) {
										symbolEditor.showMirrorButton(true);
									}
									if (headSymbolsSelected || symbolManipulator.canMirrorVertically()) {
										symbolEditor.showMirrorVerticallyButton(true);
									}
									if (symbolManipulator.canIncrease()) {
										symbolEditor.showIncreaseButton(true);
									}
									if (symbolManipulator.canDecrease()) {
										symbolEditor.showDecreaseButton(true);

									}
									if (symbolManipulator.canSwitchArrowHead()) {
										symbolEditor.showSwitchArrowHeadButton(true);

									}
									if (symbolManipulator.canSwitchToAlternatingArrows()) {
										symbolEditor.showSwitchToAlternatingArrowsButton(true);

									}
									if (symbolManipulator.canSwitchToNormalArrows()) {
										symbolEditor.showSwitchToNormalArrowsButton(true);

									}
									if (symbolManipulator.canSwitchStartingPoint()) {
										symbolEditor.showSwitchStartingPointButton(true);

									}
									if (symbolManipulator.canSwitchSize()) {
										symbolEditor.showSwitchSizeButton(true);

									}
									if (symbolManipulator.canSwitchPlane()) {
										symbolEditor.showSwitchPlaneButton(true);

									}

								}
							});
				}
			}

			symbolEditor.setSelectedColor(selectAColorForFormerBlack, selectAColorForFormerWhite,
					selectedSymbolColorForFormerBlack, selectedSymbolColorForFormerWhite);

			displaySidebarEditor(symbolEditor);
		}
	}

	private boolean areOnlyHeadSymbolsAndLegacyHeadSymbolsSelected() {
		return SymbolGroupAnalyzer.containsOnlyHeadSymbolsAndLegacyHeadSymbols(selectionTool.getSelectedItems());
	}

	private void displaySidebarEditor(SidebarEditor sidebarEditor) {
		assert sidebarEditor != null : "Precondition failed: sidebarEditor != null";

		if (!sidebarEditor.equals(sidebarEditorPanel.getWidget())) {
			sidebarEditorPanel.setWidget(sidebarEditor);
		}
	}

	private void displaySidebarExtraPanel(SidebarEditor sidebarEditor) {
		assert sidebarEditor != null : "Precondition failed: sidebarEditor != null";

		if (!sidebarEditor.equals(sidebarEditorPanel.getWidget())) {
			sidebarExtraPanel.setWidget(sidebarEditor);
		}
	}

	private void displayNewSign(SimpleSign sign) {
		signEditPanel.setSize("0px", "100%");
		center = 0;
		updateSign(sign);
	}

	private void handleIncreaseZIndex() {
		Set<PositionedSymbol> notSelectedSymbols = getNotSelectedSymbols();
		if (!notSelectedSymbols.isEmpty()) {
			int highestNotSelectedZIndex = getHighestZIndex(notSelectedSymbols);
			int lowestSelectedZIndex = getLowestZIndex(selectionTool.getSelectedItems());

			List<PositionedSymbol> previouslySelectedSymbols = new ArrayList<PositionedSymbol>(
					selectionTool.getSelectedItems());

			if (lowestSelectedZIndex < highestNotSelectedZIndex) {
				int offset = highestNotSelectedZIndex - lowestSelectedZIndex + 1;
				for (PositionedSymbol positionedSymbol : selectionTool.getSelectedItems()) {
					positionedSymbol.setZ(positionedSymbol.getZ() + offset);
				}
			}
			updateSign(sign);
			for (PositionedSymbol symbolToSelect : previouslySelectedSymbols) {
				selectSymbol(symbolToSelect);
			}
		}
	}

	private int getHighestZIndex(Collection<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols.size() > 0 : "Precondition failed: positionedSymbols.size() > 0";
		int highestZIndex = Integer.MIN_VALUE;
		for (PositionedSymbol symbol : positionedSymbols) {
			if (symbol.getZ() > highestZIndex) {
				highestZIndex = symbol.getZ();
			}
		}
		assert highestZIndex >= 0 : "Postcondition failed: highestZIndex >= 0";
		return highestZIndex;
	}

	private void handleDecreaseZIndex() {

		Set<PositionedSymbol> notSelectedSymbols = getNotSelectedSymbols();
		List<PositionedSymbol> selectedSymbols = new ArrayList<PositionedSymbol>(selectionTool.getSelectedItems());
		int lowestSelectedZIndex = getLowestZIndex(selectedSymbols);
		int highestSelectedZIndex = getHighestZIndex(selectedSymbols);

		for (PositionedSymbol positionedSymbol : selectedSymbols) {
			positionedSymbol.setZ(positionedSymbol.getZ() - lowestSelectedZIndex);
		}

		int lowestNewNonSelectedZIndex = highestSelectedZIndex - lowestSelectedZIndex + 1;
		for (PositionedSymbol positionedSymbol : notSelectedSymbols) {
			positionedSymbol.setZ(lowestNewNonSelectedZIndex + positionedSymbol.getZ());
		}

		updateSign(sign);
		for (PositionedSymbol symbolToSelect : selectedSymbols) {
			selectSymbol(symbolToSelect);
		}
	}

	private int getLowestZIndex(Collection<PositionedSymbol> positionedSymbols) {
		assert positionedSymbols.size() > 0 : "Precondition failed: positionedSymbols.size() > 0";
		int smallestZIndex = Integer.MAX_VALUE;
		for (PositionedSymbol selectedSymbol : positionedSymbols) {
			if (selectedSymbol.getZ() < smallestZIndex) {
				smallestZIndex = selectedSymbol.getZ();
			}
		}
		return smallestZIndex;
	}

	private void handleSwitchToAlternatingArrows() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchToAlternatingArrows();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchToAlternatingArrows();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
						registerHistoryEvent();
					}
				}.execute();
			}
		}
	}

	private void handleSwitchToNormalArrows() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canSwitchToNormalArrows();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.switchToNormalArrows();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
						registerHistoryEvent();
					}
				}.execute();
			}
		}
	}

	private void updateSign(SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		List<PositionedSymbol> symbols = new ArrayList<PositionedSymbol>();
		symbols.addAll(sign.getAllSymbols());

		sortZIndexAscending(symbols);

		removeAllSymbolImages();

		for (PositionedSymbol symbol : symbols) {
			addSymbolImage(symbol);
		}

		this.sign = sign;
		updateSignBorderLines();
	}

	private void sortZIndexAscending(List<PositionedSymbol> symbols) {
		Comparator<PositionedSymbol> zComparator = new Comparator<PositionedSymbol>() {
			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getZ() - symbol2.getZ();
			}
		};
		Collections.sort(symbols, zComparator);
	}

	private void addSymbolImage(PositionedSymbol positionable) {
		assert positionable != null : "Precondition failed: positionable != null";
		assert !hasSymbolImage(positionable) : "Precondition failed: !hasSymbolImage(positionable)";

		Image symbolImage = createSymbolImage(positionable);

		symbolImageMap.put(positionable, symbolImage);

		symbolImage.ensureDebugId("signEditor-signImage-" + signEditPanel.getWidgetCount());
		signEditPanel.add(symbolImage, (int) (positionable.getX() * SCALE_FACTOR),
				(int) (positionable.getY() * SCALE_FACTOR));
	}

	private void handleFocusKeyTextBox() {
		deselectAllSymbols();
	}

	private void handleMouseUpInSymbolImage(PositionedSymbol symbol, MouseUpEvent event) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert event != null : "Precondition failed: event != null";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		event.preventDefault();

		boolean isMultiSelectMode = event.isControlKeyDown() || event.isShiftKeyDown();

		if (selectionTool.isSelected(symbol) && isMultiSelectMode) {
			deselectSymbol(symbol);
		} else if (selectionTool.isSelected(symbol) && !isMultiSelectMode && !isInDragMode) {
			deselectAllSymbols();
			selectSymbol(symbol);
		} else if (isMultiSelectMode) {
			selectSymbol(symbol);
		}

		isInDragMode = false;
	}

	private void handleMouseDownOnSymbol(PositionedSymbol symbol, MouseDownEvent event) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert event != null : "Precondition failed: event != null";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		event.preventDefault();

		Point mouseDownPosition = new Point(event.getRelativeX(signEditPanel.getElement()),
				event.getRelativeY(signEditPanel.getElement()));

		handleDragStartOnSymbol(symbol, event.isControlKeyDown() || event.isShiftKeyDown(), mouseDownPosition);
	}

	private void handleMouseMoveOnWorkSurfacePanel(MouseMoveEvent event) {
		assert event != null : "Precondition failed: event != null";

		if (isSymbolPressed) {
			isInDragMode = true;

			int relativeX = event.getRelativeX(signEditPanel.getElement());
			int relativeY = event.getRelativeY(signEditPanel.getElement());
			Point mouseDragPosition = new Point(relativeX, relativeY);

			handleMoveSymbols(mouseDragPosition);
		}
	}

	private void handleHeadSymbolsChanged(List<HeadSymbol> headSymbolsToDisplay, int cursorPositionAfterChange) {
		assert headSymbolsToDisplay != null : "Precondition failed: newHeadSymbols != null";
		assert cursorPositionAfterChange >= 0 : "Precondition failed: cursorPositionAfterChange >= 0";
		assert cursorPositionAfterChange <= headSymbolsToDisplay
				.size() : "Precondition failed: cursorPositionAfterChange <= newHeadSymbols.size()";

		deselectAllSymbols();

		ArrayList<HeadSymbol> oldHeadSymbols = new ArrayList<HeadSymbol>(sign.getHeadSymbols());

		// Remove old visemes
		for (HeadSymbol headSymbol : oldHeadSymbols) {
			removeHeadSymbol(headSymbol);
		}

		// Keep old eyes and head posture on right hand side of cursor
		int maxIndexFromRight = headSymbolsToDisplay.size() - cursorPositionAfterChange;
		for (int indexFromRight = 0; indexFromRight < maxIndexFromRight; indexFromRight++) {
			int newHeadSymbolsIndexFromLeft = headSymbolsToDisplay.size() - indexFromRight - 1;
			int oldHeadSymbolsIndexFromLeft = oldHeadSymbols.size() - indexFromRight - 1;

			HeadSymbol newHeadSymbol = headSymbolsToDisplay.get(newHeadSymbolsIndexFromLeft);
			HeadSymbol oldHeadSymbol = oldHeadSymbols.get(oldHeadSymbolsIndexFromLeft);

			newHeadSymbol.setLineColor(oldHeadSymbol.getLineColor());
			newHeadSymbol.setFillColor(oldHeadSymbol.getFillColor());
			newHeadSymbol.setMouthSymbol(oldHeadSymbol.getPositionedMouthSymbol());
			newHeadSymbol.setEyeSymbols(oldHeadSymbol.getPositionedEyeSymbols());
			newHeadSymbol.setHeadPostureSymbol(oldHeadSymbol.getPositionedHeadPostureSymbol());
			newHeadSymbol.setBreathSymbols(oldHeadSymbol.getPositionedBreathSymbols());
			newHeadSymbol.setCheekSymbols(oldHeadSymbol.getPositionedCheekSymbols());
			newHeadSymbol.setEarSymbols(oldHeadSymbol.getPositionedEarSymbols());
			newHeadSymbol.setExpressionSymbol(oldHeadSymbol.getPositionedExpressionSymbol());
			newHeadSymbol.setHairSymbol(oldHeadSymbol.getPositionedHairSymbol());
			newHeadSymbol.setJawSymbol(oldHeadSymbol.getPositionedJawSymbols());
			newHeadSymbol.setNeckSymbol(oldHeadSymbol.getPositionedNeckSymbol());
			newHeadSymbol.setNoseSymbol(oldHeadSymbol.getPositionedNoseSymbol());
		}

		// Keep old eyes and head posture on left hand side of cursor for
		// matching symbols

		int maxIndexFromLeft = headSymbolsToDisplay.size() > oldHeadSymbols.size() ? cursorPositionAfterChange - 1
				: cursorPositionAfterChange;

		for (int indexFromLeft = 0; indexFromLeft < maxIndexFromLeft && indexFromLeft < oldHeadSymbols.size()
				&& indexFromLeft < headSymbolsToDisplay.size(); indexFromLeft++) {
			HeadSymbol newHeadSymbol = headSymbolsToDisplay.get(indexFromLeft);
			HeadSymbol oldHeadSymbol = oldHeadSymbols.get(indexFromLeft);

			if (newHeadSymbol.getPositionedMouthSymbol().equals(oldHeadSymbol.getPositionedMouthSymbol())) {
				newHeadSymbol.setLineColor(oldHeadSymbol.getLineColor());
				newHeadSymbol.setFillColor(oldHeadSymbol.getFillColor());
				newHeadSymbol.setMouthSymbol(oldHeadSymbol.getPositionedMouthSymbol());
				newHeadSymbol.setEyeSymbols(oldHeadSymbol.getPositionedEyeSymbols());
				newHeadSymbol.setHeadPostureSymbol(oldHeadSymbol.getPositionedHeadPostureSymbol());
				newHeadSymbol.setBreathSymbols(oldHeadSymbol.getPositionedBreathSymbols());
				newHeadSymbol.setCheekSymbols(oldHeadSymbol.getPositionedCheekSymbols());
				newHeadSymbol.setEarSymbols(oldHeadSymbol.getPositionedEarSymbols());
				newHeadSymbol.setExpressionSymbol(oldHeadSymbol.getPositionedExpressionSymbol());
				newHeadSymbol.setHairSymbol(oldHeadSymbol.getPositionedHairSymbol());
				newHeadSymbol.setJawSymbol(oldHeadSymbol.getPositionedJawSymbols());
				newHeadSymbol.setNeckSymbol(oldHeadSymbol.getPositionedNeckSymbol());
				newHeadSymbol.setNoseSymbol(oldHeadSymbol.getPositionedNoseSymbol());
			} else {
				break;
			}
		}

		// Add new visemes
		for (HeadSymbol headSymbol : headSymbolsToDisplay) {
			addHeadSymbolToSign(headSymbol);
		}

		rearrangeHeadSymbols();
		updateSignBorderLines();

	}

	private void handleAddSymbol(Symbol symbol, int xOffset, int yOffset) {
		assert symbol != null : "Precondition failed: symbol != null";

		// positioning in the workSurfacePanel has its vertical start at the top
		// and horizontal start at the center

		double xPosPixel = ((((double) workSurfacePanel.getElement().getClientWidth()) + xOffset) / 2.0)
				- ((double) symbol.getWidth() * SCALE_FACTOR);
		double yPosPixel = ((((double) workSurfacePanel.getElement().getClientHeight()) + yOffset) / 2.0)
				- ((double) symbol.getHeight() * SCALE_FACTOR / 2.0);

		int yPos = (int) (yPosPixel / SCALE_FACTOR);
		int xPos = (int) (xPosPixel / SCALE_FACTOR);

		PositionedSymbol positionedSymbol = new PositionedSymbol(symbol, xPos, yPos, sign.getMaxZ() + 1);

		sign.addSymbol(positionedSymbol);

		addSymbolImage(positionedSymbol);
		updateSignBorderLines();

		deselectAllSymbols();

		selectSymbol(positionedSymbol);
	}

	private void addFreePositionedHeadSymbol(HeadSymbol newHeadSymbol) {
		assert newHeadSymbol != null : "Precondition failed: newHeadSymbol != null";
		assert signsAddEditor.getVisemeEditor()
				.isInFreePositionableMode() == true : "Precondition failed: signsAddEditor.getVisemeEditor().isInFreePositionableMode() == true";

		newHeadSymbol.setFreePositionable(true);
		double xPosPixel = (((double) workSurfacePanel.getElement().getClientWidth()) / 2)
				- ((double) newHeadSymbol.getWidth() * SCALE_FACTOR);
		int xPos = (int) (xPosPixel / SCALE_FACTOR);
		double yPos = HEAD_TOP_OFFSET;

		newHeadSymbol.setX(xPos);
		newHeadSymbol.setY(((int) (yPos * SCALE_FACTOR)));

		int newVisemeIndex = getNewHeadSymbolIndex();

		insertHeadSymbol(newVisemeIndex, newHeadSymbol);

		deselectAllSymbols();

		// Not all HeadSymbols have corresponding keys, so the text box can
		// contain less keys than HeadSymbols in sign
		int newVisemeKeyIndex = Math.min(signsAddEditor.getVisemeEditor().getVisemeKeyCount(), newVisemeIndex);

		signsAddEditor.getVisemeEditor().insertVisemeKeyAt(newVisemeKeyIndex, newHeadSymbol.getPositionedMouthSymbol());

		rearrangeHeadSymbols();
		updateSignBorderLines();
		selectSymbol(newHeadSymbol);
		registerHistoryEvent();
	}

	private void handleKeyDown(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		int charCode = event.getNativeKeyCode();
		if (charCode == KeyCodes.KEY_BACKSPACE || charCode == KeyCodes.KEY_DELETE) {
			removeSelectedSymbols();

			// To cancel browser back button on backspace key
			event.preventDefault();
		} else if (charCode == KeyCodes.KEY_LEFT) {
			// To cancel browser back button on MacOS
			event.preventDefault();
			if (event.isControlKeyDown() || event.isMetaKeyDown()) {
				moveSelectedSymbols(-1, 0);
			} else {
				moveSelectedSymbols(-10, 0);
			}
		} else if (charCode == KeyCodes.KEY_RIGHT) {
			if (event.isControlKeyDown() || event.isMetaKeyDown()) {
				moveSelectedSymbols(1, 0);
			} else {
				moveSelectedSymbols(10, 0);
			}
		} else if (charCode == KeyCodes.KEY_UP) {
			if (event.isControlKeyDown() || event.isMetaKeyDown()) {
				moveSelectedSymbols(0, -1);
			} else {
				moveSelectedSymbols(0, -10);
			}
		} else if (charCode == KeyCodes.KEY_DOWN) {
			if (event.isControlKeyDown() || event.isMetaKeyDown()) {
				moveSelectedSymbols(0, 1);
			} else {
				moveSelectedSymbols(0, 10);
			}
		}
	}

	private void handleArrangeVisemes() {
		deselectAllSymbols();

		List<HeadSymbol> newHeadSymbols = new ArrayList<HeadSymbol>(sign.getHeadSymbols());

		// Remove old HeadSymbols
		for (HeadSymbol headSymbol : newHeadSymbols) {
			removeHeadSymbol(headSymbol);
		}

		newHeadSymbols.addAll(sign.getDisarrangedHeadSymbols());

		// Remove old disarranged HeadSymbols
		List<HeadSymbol> oldDisarrangedHeadSymbols = new ArrayList<HeadSymbol>(sign.getDisarrangedHeadSymbols());
		for (HeadSymbol headSymbol : oldDisarrangedHeadSymbols) {
			removeDisarrangedHeadSymbol(headSymbol, sign);
		}

		List<PositionedSymbol> otherSignSymbols = new ArrayList<PositionedSymbol>(sign.getOtherSymbols());

		// Remove symbols that can be converted to HeadSymbols
		for (PositionedSymbol positionedSymbol : symbolToHeadSymbolConverter.getConvertableSymbols(otherSignSymbols)) {
			removePositionedSymbol(positionedSymbol, sign);
		}

		// Add converted HeadSymbols
		newHeadSymbols.addAll(symbolToHeadSymbolConverter.convertToHeadSymbols(otherSignSymbols));

		Collections.sort(newHeadSymbols, new Comparator<PositionedSymbol>() {
			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getX() - symbol2.getX();
			}
		});

		for (HeadSymbol headSymbol : newHeadSymbols) {
			headSymbol.setFreePositionable(false);
			addHeadSymbolToSign(headSymbol);
		}

		signsAddEditor.getVisemeEditor().setVisemeKeysFor(newHeadSymbols);

		rearrangeHeadSymbols();
		updateSignBorderLines();
	}

	private void handleFreePositionVisemes() {
		for (HeadSymbol headSymbol : sign.getHeadSymbols()) {
			headSymbol.setFreePositionable(true);
		}
	}

	private void handleArrangeFingerAlphabet() {
		deselectAllSymbols();
		rearrangeFingerAlphabetSymbols();
		updateSignBorderLines();
	}

	private void handleSignLoaded(final SimpleSign sign) {
		assert sign != null : "Precondition failed: sign != null";

		this.sign = sign;
		updatesAfterSignHasChanged();
	}

	private void handleSignLoaded(final SignItemEditor sign) {
		assert sign != null : "Precondition failed: sign != null";

		this.sign = sign.getLocalSign().clone();
		updatesAfterSignHasChanged(sign.getSearchWord());
	}

	public void updatesAfterSignHasChanged() {
		updatesAfterSignHasChanged(sign.getSignId().getLowerIdPart());
	}

	public void updatesAfterSignHasChanged(String word) {
		this.savedPreviousSign = sign.clone();
		if (word.equals(SignId.EMPTY_SIGN_LOWER_ID)) {
			searchWord = "";
			this.signsModificationDateLabel.setText(I18N.getEditedOn() + ":");
		} else {
			if (sign.getSignId().getLowerIdPart() != SignId.EMPTY_SIGN_LOWER_ID) {
				searchWord = sign.getSignId().getLowerIdPart();
			} else {
				searchWord = word;
			}
			this.signsModificationDateLabel.setText(I18N.getEditedOn() + ": "
					+ DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(sign.getModificationDate()));
		}

		this.searchWordTextBox.setText(searchWord);
		this.signsLastAuthorLabel.setText(I18N.getCreatedBy() + ": " + sign.getAuthor().getDisplayUsername());

		if (searchWord.equals("")) {
			this.signsSignBookLabel.setText("");
		} else if (isLocalSign()) {
			this.signsSignBookLabel.setText(I18N.getLocalSign());
		} else if (sign.getPersistenceLocation() == PersistenceLocation.GLOBAL_DICTIONARY) {
			this.signsSignBookLabel.setText(I18N.getGlobalSign());
		} else {
			this.signsSignBookLabel.setText("unknown persistence location");
		}
		convertLegacyHeadSymbols(sign);
		updateShowSignHistory();
		if (!isLocalSign()) {
			signHistoryItemBrowser.loadSignHistory(sign);
		}
		updateSignBorderLines();
		updateSaveButton();
	}

	public boolean isLocalSign() {
		return sign.getPersistenceLocation() == PersistenceLocation.LOCAL_DICTIONARY;
	}

	private void updateShowSignHistory() {
		showSignHistory = !isLocalSign() && localSessionService.getCurrentUser().isAuthor();
		signHistoryBorderSlideableArrowPanel.setActive(showSignHistory);
	}

	private void convertLegacyHeadSymbols(SimpleSign signToBeConverted) {
		if (signToBeConverted == sign) {
			deselectAllSymbols();
		}
		List<HeadSymbol> newHeadSymbols = new ArrayList<HeadSymbol>(signToBeConverted.getDisarrangedHeadSymbols());

		// Remove old disarrangedHeadSymbols
		for (HeadSymbol headSymbol : newHeadSymbols) {
			removeDisarrangedHeadSymbol(headSymbol, signToBeConverted);
		}

		List<PositionedSymbol> otherSignSymbols = new ArrayList<PositionedSymbol>(signToBeConverted.getOtherSymbols());

		// Remove symbols that can be converted to HeadSymbols
		for (PositionedSymbol positionedSymbol : symbolToHeadSymbolConverter.getConvertableSymbols(otherSignSymbols)) {
			removePositionedSymbol(positionedSymbol, signToBeConverted);
		}

		// Add converted HeadSymbols
		newHeadSymbols.addAll(symbolToHeadSymbolConverter.convertToHeadSymbols(otherSignSymbols));

		Collections.sort(newHeadSymbols, new Comparator<PositionedSymbol>() {
			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getX() - symbol2.getX();
			}
		});
		if (sign == signToBeConverted) {
			for (HeadSymbol headSymbol : newHeadSymbols) {
				if (headSymbol.isFreePositionable()) {
					addDisarrangedHeadSymbol(headSymbol, signToBeConverted);
				} else {
					addArrangedHeadSymbol(headSymbol, signToBeConverted);
				}
			}
		} else {
			for (HeadSymbol headSymbol : newHeadSymbols) {
				if (headSymbol.isFreePositionable()) {
					signToBeConverted.addDisarrangedHeadSymbol(headSymbol);
				} else {
					signToBeConverted.addHeadSymbol(headSymbol);
				}
			}
		}
		updateSignBorderLines();
	}

	private void handleRollSymbol() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canRoll();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.roll();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();
			}
		}
	}

	private void handlePitchSymbol() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canPitch();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.pitch();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();
			}
		}
	}

	private void handleDuplicateSymbol() {
		duplicateSelectedSymbols();
	}

	private void handleRemoveSymbol() {
		removeSelectedSymbols();
	}

	private void handleIncreaseSymbolQuantity() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canIncrease();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.increase();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}
	}

	private void handleDecreaseSymbolQuantity() {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canDecrease();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.decrease();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}
	}

	private void handleMirrorSymbol() {
		final boolean multipleSymbolsSelected = selectionTool.getSelectedItems().size() > 1;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		if (multipleSymbolsSelected) {
			for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
				if (selectedSymbol.getX() < minX) {
					minX = selectedSymbol.getX();
				}
				if (selectedSymbol.getX() + selectedSymbol.getWidth() > maxX) {
					maxX = selectedSymbol.getX() + selectedSymbol.getWidth();
				}
			}
		}
		final double mirrorAxis = (maxX + minX) / 2.0;

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canMirror();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.mirror();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();

				if (multipleSymbolsSelected) {
					moveSymbol(oldSymbol, (int) Math.round(2 * (mirrorAxis - oldSymbol.getX()) - oldSymbol.getWidth()),
							0);
				}
			}
		}
	}

	private void handleMirrorSymbolVertically() {
		final boolean multipleSymbolsSelected = selectionTool.getSelectedItems().size() > 1;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		if (multipleSymbolsSelected) {
			for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
				if (selectedSymbol.getY() < minY) {
					minY = selectedSymbol.getY();
				}
				if (selectedSymbol.getY() + selectedSymbol.getHeight() > maxY) {
					maxY = selectedSymbol.getY() + selectedSymbol.getHeight();
				}
			}
		}
		final double mirrorAxis = (maxY + minY) / 2.0;

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canMirrorVertically();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.mirrorVertically();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
					}
				}.execute();

				if (multipleSymbolsSelected) {
					moveSymbol(oldSymbol, 0,
							(int) Math.round(2 * (mirrorAxis - oldSymbol.getY()) - oldSymbol.getHeight()));
				}
			}
		}
	}

	private void handleRotateSymbolClockwise() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canRotate();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.rotateClockwise();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}

	}

	private void handleSwitchHeadPostureSymbolToNormalArrows() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				selectedHeadSymbol.switchHeadPostureToNormalArrows();

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleSwitchHeadPostureSymbolToAlternatingArrows() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				selectedHeadSymbol.switchHeadPostureToAlternatingArrows();

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleToggleLeftEarSymbol() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				List<PositionedEarsSymbol> ears = new ArrayList<PositionedEarsSymbol>();
				ears.addAll(selectedHeadSymbol.getPositionedEarSymbols());
				assert ears.size() <= 2 : "Precondition failed ears.size() <= 2";

				boolean hadLeftEar = false;
				for (int i = 0; i < ears.size(); i++) {
					if (ears.get(i).isLeftEar()) {
						ears.remove(i);
						hadLeftEar = true;
					}
				}
				if (!hadLeftEar && ears.size() > 0) {
					BaseSymbol baseSymbol = ears.get(0).getBaseSymbol();
					ears.add((PositionedEarsSymbol) positionedSymbolFactory.createPositionedSymbol(
							EarsBaseSymbol.getLeftEarFor(EarsBaseSymbol.getEarsBaseSymbol(baseSymbol).getIswaSymbol()),
							Location.LEFT));
				}
				selectedHeadSymbol.setEarSymbols(ears);

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleToggleRightEarSymbol() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;

				List<PositionedEarsSymbol> ears = new ArrayList<PositionedEarsSymbol>();
				ears.addAll(selectedHeadSymbol.getPositionedEarSymbols());
				assert ears.size() <= 2 : "Precondition failed ears.size() <= 2";

				boolean hadRightEar = false;
				for (int i = 0; i < ears.size(); i++) {
					if (ears.get(i).isRightEar()) {
						ears.remove(i);
						hadRightEar = true;
					}
				}
				if (!hadRightEar && ears.size() > 0) {
					Symbol ear = EarsBaseSymbol.getEarsBaseSymbol(ears.get(0).getSymbol().getBaseSymbol())
							.getIswaSymbol();
					ears.add((PositionedEarsSymbol) positionedSymbolFactory.createPositionedSymbol(
							EarsBaseSymbol.getRightEarFor(ear),
							de.signWritingEditor.shared.model.material.Locatable.Location.RIGHT));
				}
				selectedHeadSymbol.setEarSymbols(ears);

				updateHeadSymbolImage(selectedHeadSymbol);

			}
		}
		updateSidebar();
		registerHistoryEvent();
	}

	private void handleModifyPositionedSymbol(PositionedSymbolModifier modifier,
			Class<? extends PositionedSymbol> classType) {
		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {

			if (selectedSymbol instanceof HeadSymbol) {
				HeadSymbol selectedHeadSymbol = (HeadSymbol) selectedSymbol;
				List<PositionedSymbol> positionedSymbols = selectedHeadSymbol
						.getPostionedSymbolsForClassType(classType);

				for (PositionedSymbol positionedSymbol : positionedSymbols) {
					if (modifier.canDo(positionedSymbol)) {
						modifier.doIt(positionedSymbol);
						updateHeadSymbolImage(selectedHeadSymbol);
					}
				}

			}
		}
		registerHistoryEvent();
		updateSidebar();
	}

	private void handleRotateSymbolCounterClockwise() {

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof PositionedSymbol) {
				final PositionedSymbol oldSymbol = ((PositionedSymbol) selectedSymbol);

				new SymbolicAction(((PositionedSymbol) selectedSymbol).clone()) {

					@Override
					protected boolean canDo(PositionedSymbol specificPositionedSymbol) {
						return specificPositionedSymbol.canRotate();
					}

					@Override
					protected void doIt(PositionedSymbol specificPositionedSymbol) {
						specificPositionedSymbol.rotateCounterClockwise();
						oldSymbol.setSymbol(((PositionedSymbol) specificPositionedSymbol).getSymbol());
						updateSymbolImage(oldSymbol, symbolImageUrlService
								.getSymbolImageUrl(((PositionedSymbol) specificPositionedSymbol), SCALE_FACTOR));
						updateSidebar();
					}
				}.execute();
			}
		}
	}

	private void handleDeleteOldHeadSymbols() {
		// List must be copied since it is modified during the loop
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>(sign.getOtherSymbols());

		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			if (SymbolGroupAnalyzer.isHeadSymbol(positionedSymbol.getSymbol())) {
				removePositionedSymbol(positionedSymbol, sign);
			}
		}
	}

	private void setSymbolImagePosition(PositionedSymbol symbol, int newX, int newY) {
		assert symbol != null : "Precondition failed: symbol != null";

		signEditPanel.setWidgetPosition(symbolImageMap.get(symbol), newX, newY);
	}

	private void updateHeadSymbolImage(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert hasSymbolImage(headSymbol) : "Precondition failed: hasSymbolImage(headSymbol)";

		updateSymbolImage(headSymbol, symbolImageUrlService.getHeadSymbolImageUrl(headSymbol, SCALE_FACTOR, true));

		// HeadSymbol's height can change, so rearrange them
		rearrangeHeadSymbols();
	}

	private void updateSymbolImage(PositionedSymbol symbol, String newImageUrl) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert newImageUrl != null : "Precondition failed: newImageUrl != null";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		Image image = symbolImageMap.get(symbol);
		image.setUrl(newImageUrl);
		image.setPixelSize((int) (symbol.getWidth() * SCALE_FACTOR), (int) (symbol.getHeight() * SCALE_FACTOR));
	}

	private Set<PositionedSymbol> getNotSelectedSymbols() {
		Set<PositionedSymbol> symbols = new HashSet<PositionedSymbol>(sign.getAllSymbols());
		symbols.removeAll(selectionTool.getSelectedItems());
		return symbols;
	}

	private int getNewHeadSymbolIndex() {
		int highestSelectedHeadSymbolIndex = -1;

		for (PositionedSymbol selectedSymbol : selectionTool.getSelectedItems()) {
			if (selectedSymbol instanceof HeadSymbol) {
				int headSymbolIndex = sign.getHeadSymbolIndex((HeadSymbol) selectedSymbol);

				if (headSymbolIndex > highestSelectedHeadSymbolIndex) {
					highestSelectedHeadSymbolIndex = headSymbolIndex;
				}
			}
		}

		int result = highestSelectedHeadSymbolIndex >= 0 ? highestSelectedHeadSymbolIndex + 1
				: sign.getHeadSymbolCount();

		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	private void removeSelectedSymbols() {
		Set<PositionedSymbol> selectedSymbols = new HashSet<PositionedSymbol>();
		selectedSymbols.addAll(selectionTool.getSelectedItems());

		deselectAllSymbols();

		for (PositionedSymbol selectedSymbol : selectedSymbols) {
			removeSymbol(selectedSymbol, sign);
		}

		signsAddEditor.getFingerAlphabetEditor().setFingerAlphabetTextFor(sign.getFingerAlphabetSymbols());

		rearrangeFingerAlphabetSymbols();
		rearrangeHeadSymbols();
		updateSignBorderLines();
	}

	private void duplicateSelectedSymbols() {
		Set<PositionedSymbol> selectedSymbols = new HashSet<PositionedSymbol>();
		selectedSymbols.addAll(selectionTool.getSelectedItems());
		List<PositionedSymbol> previouslyAvailableSymbols = new ArrayList<PositionedSymbol>();
		previouslyAvailableSymbols = sign.getAllSymbols();

		deselectAllSymbols();

		int xMax = Integer.MIN_VALUE;
		boolean multipleSymbolsSelected = selectedSymbols.size() > 1;

		for (PositionedSymbol selectedSymbol : selectedSymbols) {
			if (selectedSymbol.getX() + selectedSymbol.getWidth() > xMax) {
				xMax = selectedSymbol.getX() + selectedSymbol.getWidth();
			}
		}

		for (PositionedSymbol selectedSymbol : selectedSymbols) {
			duplicateSymbol(selectedSymbol, multipleSymbolsSelected,
					xMax - (selectedSymbol.getX() + selectedSymbol.getWidth()));
		}

		for (PositionedSymbol currentSymbol : sign.getAllSymbols()) {
			if (!previouslyAvailableSymbols.contains(currentSymbol)) {
				selectSymbol(currentSymbol);
			}
		}

		rearrangeHeadSymbols();
		updateSignBorderLines();
	}

	private void removeSymbol(PositionedSymbol symbol, SimpleSign signToRemove) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert signToRemove.hasSymbol(symbol) : "Precondition failed: sign.hasSymbol(symbol)";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		if (symbol instanceof HeadSymbol) {
			HeadSymbol headSymbol = (HeadSymbol) symbol;

			// Not all HeadSymbols have a corresponding key in viseme key text
			// box

			if (signToRemove.hasHeadSymbol(headSymbol)
					&& signsAddEditor.getVisemeEditor().hasViseme(headSymbol.getPositionedMouthSymbol())) {
				signsAddEditor.getVisemeEditor().removeVisemeKeyAt(
						signsAddEditor.getVisemeEditor().getVisemeIndex(signToRemove.getHeadSymbols(), headSymbol));
			}
			removeHeadSymbol(headSymbol);
		} else if (symbol instanceof PositionedSymbol) {
			removePositionedSymbol((PositionedSymbol) symbol, signToRemove);
		}
		registerHistoryEvent();
	}

	private void duplicateSymbol(PositionedSymbol symbol, boolean multipleSymbolsDuplicated, int xOffset) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert sign.hasSymbol(symbol) : "Precondition failed: sign.hasSymbol(symbol)";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		if (symbol instanceof HeadSymbol) {
			HeadSymbol headSymbol = ((HeadSymbol) symbol).clone();
			// positioning in the workSurfacePanel has its vertical start at the
			// top and horizontal start at the center

			double yPosPixel = (((double) workSurfacePanel.getElement().getClientHeight()) / 2.0)
					- ((double) headSymbol.getHeight() * SCALE_FACTOR / 2.0);

			int yPos = (int) (yPosPixel / SCALE_FACTOR);
			headSymbol.setX(0);
			headSymbol.setY(yPos);
			headSymbol.setZ(sign.getMaxZ() + 1);

			addHeadSymbolToSign(headSymbol);
			handleArrangeVisemes();
		} else if (SymbolGroupAnalyzer.isHandOrMovementOrDynamicOrBodySymbol(symbol)) {

			PositionedSymbol pSymbol = (PositionedSymbol) symbol;
			// positioning in the workSurfacePanel has its vertical start at the
			// top and horizontal start at the center

			double xPosPixel = (((double) workSurfacePanel.getElement().getClientWidth()) / 2.0)
					- ((double) pSymbol.getWidth() * SCALE_FACTOR);
			double yPosPixel = (((double) workSurfacePanel.getElement().getClientHeight()) / 2.0)
					- ((double) pSymbol.getHeight() * SCALE_FACTOR / 2.0);

			int yPos = multipleSymbolsDuplicated ? pSymbol.getY() : (int) ((yPosPixel) / SCALE_FACTOR);
			int xPos = (int) (Math.round((xPosPixel - (xOffset * SCALE_FACTOR)) / SCALE_FACTOR));
			int zPos = sign.getMaxZ() + 1;
			PositionedSymbol newPositionableSymbol = new PositionedSymbol(pSymbol.getSymbol(), xPos, yPos, zPos);

			sign.addSymbol(newPositionableSymbol);
			if (!hasSymbolImage(newPositionableSymbol)) {
				addSymbolImage(newPositionableSymbol);
			}
		}
	}

	private void removePositionedSymbol(PositionedSymbol positionedSymbol, SimpleSign signToBeConverted) {
		assert positionedSymbol != null : "Precondition failed: positionedSymbol != null";

		signToBeConverted.removeSymbol(positionedSymbol);

		if (hasSymbolImage(positionedSymbol)) {
			removeSymbolImage(positionedSymbol);
		}
	}

	private void removeHeadSymbol(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert sign.hasHeadSymbol(headSymbol) || sign.hasDisarrangedHeadSymbol(
				headSymbol) : "Precondition failed: sign.hasHeadSymbol(headSymbol) || sign.hasDisarrangedHeadSymbol(headSymbol)";

		if (sign.hasHeadSymbol(headSymbol)) {
			sign.removeHeadSymbol(headSymbol);
		} else if (sign.hasDisarrangedHeadSymbol(headSymbol)) {
			sign.removeDisarrangedHeadSymbol(headSymbol);
		}

		if (hasSymbolImage(headSymbol)) {
			removeSymbolImage(headSymbol);
		}

		assert !hasSymbolImage(headSymbol) : "Postcondition failed: !hasSymbolImage(headSymbol)";
	}

	private void removeDisarrangedHeadSymbol(HeadSymbol headSymbol, SimpleSign signToBeConverted) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert signToBeConverted.hasDisarrangedHeadSymbol(
				headSymbol) : "Precondition failed: signToBeConverted.hasHeadSymbol(headSymbol)";

		signToBeConverted.removeDisarrangedHeadSymbol(headSymbol);

		if (hasSymbolImage(headSymbol)) {
			removeSymbolImage(headSymbol);
		}

		assert !hasSymbolImage(headSymbol) : "Postcondition failed: !hasSymbolImage(headSymbol)";
	}

	private void removeAllSymbolImages() {
		deselectAllSymbols();

		Set<PositionedSymbol> allSymbols = new HashSet<PositionedSymbol>();
		allSymbols.addAll(symbolImageMap.keySet());

		for (PositionedSymbol symbol : allSymbols) {
			removeSymbolImage(symbol);
		}
	}

	private void removeSymbolImage(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert hasSymbolImage(symbol) : "Precondition failed: hasSymbolImage(symbol)";

		signEditPanel.remove(symbolImageMap.get(symbol));
		symbolImageMap.remove(symbol);
	}

	private void addHeadSymbolToSign(HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		sign.addHeadSymbol(headSymbol);
		addSymbolImage(headSymbol);

		assert sign.hasHeadSymbol(headSymbol) : "Postcondition failed: sign.hasHeadSymbol(headSymbol)";
		assert hasSymbolImage(headSymbol) : "Postcondition failed: hasSymbolImage(headSymbol)";
	}

	private void addDisarrangedHeadSymbol(HeadSymbol headSymbol, SimpleSign signToBeConverted) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		signToBeConverted.addDisarrangedHeadSymbol(headSymbol);
		addSymbolImage(headSymbol);

		assert signToBeConverted.hasDisarrangedHeadSymbol(
				headSymbol) : "Postcondition failed: sign.hasDisarrangedHeadSymbol(headSymbol)";
		assert hasSymbolImage(headSymbol) : "Postcondition failed: hasSymbolImage(headSymbol)";
	}

	private void addArrangedHeadSymbol(HeadSymbol headSymbol, SimpleSign signToBeConverted) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";

		signToBeConverted.addHeadSymbol(headSymbol);
		addSymbolImage(headSymbol);

		assert signToBeConverted.hasHeadSymbol(headSymbol) : "Postcondition failed: sign.hasHeadSymbol(headSymbol)";
		assert hasSymbolImage(headSymbol) : "Postcondition failed: hasSymbolImage(headSymbol)";
	}

	private void insertHeadSymbol(int index, HeadSymbol headSymbol) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= sign.getHeadSymbolCount() : "Precondition failed: index [" + index
				+ "] <= sign.getHeadSymbolCount() [" + sign.getHeadSymbolCount() + "]";

		sign.insertHeadSymbol(index, headSymbol);

		addSymbolImage(headSymbol);
	}

	private void rearrangeHeadSymbolsToSymbolImages(boolean ignoreSelectedHeadSymbolImages) {
		assert isSignEditorActive() : "Precondition failed: sign != null";
		if (sign.hasHeadSymbols()) {
			List<HeadSymbol> headSymbols = getHeadSymbolsSortedByImagePositions();
			int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;

			List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbols,
					center);

			for (int index = 0; index < headSymbols.size(); index++) {
				HeadSymbol headSymbol = headSymbols.get(index);
				if (!headSymbol.isFreePositionable()) {
					int y = headSymbolsBottom - headSymbol.getHeight() + headSymbol.getLowerExtension();

					Integer headSymbolXPos = xPositionsForHeadSymbols.get(index);
					headSymbol.setX(headSymbolXPos);
					headSymbol.setY(y);

					if (!ignoreSelectedHeadSymbolImages || !selectionTool.isSelected(headSymbol)) {
						setSymbolImagePosition(headSymbol, (int) (headSymbolXPos * SCALE_FACTOR),
								(int) (y * SCALE_FACTOR));
					}
				}
			}

			// Update viseme textbox
			signsAddEditor.getVisemeEditor().setVisemeKeysFor(headSymbols);

			// Update material
			sign.removeAllHeadSymbols();
			for (HeadSymbol headSymbol : headSymbols) {
				sign.addHeadSymbol(headSymbol);
			}
		} else {
			// Clear viseme textbox
			signsAddEditor.getVisemeEditor().setVisemeKeysFor(Collections.<HeadSymbol>emptyList());
		}
	}

	private void rearrangeHeadSymbols() {
		if (sign.hasHeadSymbols()) {
			List<HeadSymbol> headSymbols = sign.getHeadSymbols();
			int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;

			List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbols,
					center);

			for (int index = 0; index < headSymbols.size(); index++) {
				HeadSymbol headSymbol = headSymbols.get(index);

				if (!headSymbol.isFreePositionable()) {

					int y = headSymbolsBottom - headSymbol.getHeight() + headSymbol.getLowerExtension();

					int headSymbolXPos = xPositionsForHeadSymbols.get(index);
					headSymbol.setX(headSymbolXPos);
					headSymbol.setY(y);

					setSymbolImagePosition(headSymbol, (int) (headSymbolXPos * SCALE_FACTOR), (int) (y * SCALE_FACTOR));
				}
			}
		}
	}

	private void updateFingerAlphabetTextToMatch() {
		List<PositionedFingerAlphabetSymbol> fingerAlphabeSymbolsSortedByImagePositions = getFingerAlphabeSymbolsSortedByImagePositions();
		signsAddEditor.getHandEditor().getFingerAlphabetEditor()
				.setFingerAlphabetTextFor(fingerAlphabeSymbolsSortedByImagePositions);
	}

	private void rearrangeFingerAlphabetSymbols() {
		if (sign.hasFingerAlphabetSymbols()) {

			sign.sortFingerAlphabetSymbols();

			List<PositionedFingerAlphabetSymbol> fingerAlphabetSymbols = sign.getFingerAlphabetSymbols();

			int maxWidth = 0;
			for (PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol : fingerAlphabetSymbols) {
				maxWidth += positionedFingerAlphabetSymbol.getWidth() + FINGER_ALPHABET_DISTANCE;
			}

			int currentXPosition = -maxWidth / 2;
			for (PositionedFingerAlphabetSymbol currentFingerAlphabetSymbol : fingerAlphabetSymbols) {

				int currentYPosition = FINGER_ALPHABET_Y_OFFSET - currentFingerAlphabetSymbol.getHeight();
				currentFingerAlphabetSymbol.setX(currentXPosition);
				currentFingerAlphabetSymbol.setY(currentYPosition);

				currentXPosition += currentFingerAlphabetSymbol.getWidth() + FINGER_ALPHABET_DISTANCE;

				setSymbolImagePosition(currentFingerAlphabetSymbol,
						(int) (currentFingerAlphabetSymbol.getX() * SCALE_FACTOR),
						(int) (currentFingerAlphabetSymbol.getY() * SCALE_FACTOR));
			}

		}
	}

	private List<HeadSymbol> getHeadSymbolsSortedByImagePositions() {
		List<HeadSymbol> result = new ArrayList<HeadSymbol>(sign.getHeadSymbols());

		Collections.sort(result, new Comparator<HeadSymbol>() {
			@Override
			public int compare(HeadSymbol headSymbol1, HeadSymbol headSymbol2) {
				Image symbolImage1 = symbolImageMap.get(headSymbol1);
				Image symbolImage2 = symbolImageMap.get(headSymbol2);

				return symbolImage1.getAbsoluteLeft() - symbolImage2.getAbsoluteLeft();
			}
		});

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private List<PositionedFingerAlphabetSymbol> getFingerAlphabeSymbolsSortedByImagePositions() {
		List<PositionedFingerAlphabetSymbol> result = new ArrayList<PositionedFingerAlphabetSymbol>(
				sign.getFingerAlphabetSymbols());

		Collections.sort(result, new Comparator<PositionedFingerAlphabetSymbol>() {
			@Override
			public int compare(PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol1,
					PositionedFingerAlphabetSymbol positionedFingerAlphabetSymbol2) {
				Image symbolImage1 = symbolImageMap.get(positionedFingerAlphabetSymbol1);
				Image symbolImage2 = symbolImageMap.get(positionedFingerAlphabetSymbol2);

				return symbolImage1.getAbsoluteLeft() - symbolImage2.getAbsoluteLeft();
			}
		});

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private void updateSignBorderLines() {
		double minX = Integer.MAX_VALUE;
		double maxX = Integer.MIN_VALUE;

		if (sign == null) {
			minX = 0;
			maxX = 0;
		} else {
			for (PositionedSymbol positionedSymbol : sign.getPlainSymbols()) {
				double symbolLeft = positionedSymbol.getX() * SCALE_FACTOR;
				double symbolRight = (positionedSymbol.getX() + positionedSymbol.getWidth()) * SCALE_FACTOR;

				if (symbolLeft < minX) {
					minX = symbolLeft;
				}

				if (symbolRight > maxX) {
					maxX = symbolRight;
				}
			}
		}

		verticalSignBorderLineLeft.getElement().getStyle().setLeft(minX, Unit.PX);
		verticalSignBorderLineRight.getElement().getStyle().setLeft(maxX, Unit.PX);
	}

	public interface SignModifiedListener {
		void onSignLocallyModified(SimpleSign modifiedSign);

		void onSignModified(SimpleSign modifiedSign);

		void onSignSavedInSignBook(SimpleSign savedSign);

		void onSaveOrReplaceLocally(SimpleSign modifiedSign);

		void onDeleteLocalSign(SimpleSign sign);

	}

	private void registerHistoryEvent() {
		assert isSignEditorActive() : "Precondition failed: sign != null";
		assert savedPreviousSign != null : "Precondition failed: savedPreviousSign != null";

		Map<PositionedSymbol, Point> differenceMapClone = new IdentityHashMap<PositionedSymbol, Point>();
		differenceMapClone.putAll(differenceMap);

		historyService.registerHistoryEvent(
				new SignEditorHistoryState(savedPreviousSign.clone(), sign.clone(), differenceMapClone));
		handleSignHasChanged();
	}

	private void initHistory() {
		historyService.clearHistory();
		registerHistoryEvent();
	}

	public boolean isSaveOnlyLocal() {
		return saveOnlyLocal;
	}

	public void setSaveOnlyLocal(boolean saveOnlyLocal) {
		this.saveOnlyLocal = saveOnlyLocal;
	}

	private abstract class PositionedSymbolModifier {
		protected abstract boolean canDo(PositionedSymbol specificPositionedSymbol);

		protected abstract void doIt(PositionedSymbol specificPositionedSymbol);
	}

	private abstract class SymbolicAction extends SymbolManipulationAction<PositionedSymbol> {
		public SymbolicAction(PositionedSymbol positionedSymbol) {
			super(positionedSymbol);
		}
	}

	private abstract class SymbolManipulationAction<SMA extends PositionedSymbol> {

		private final PositionedSymbol positionedSymbol;

		protected SymbolManipulationAction(PositionedSymbol positionedSymbol) {
			this.positionedSymbol = positionedSymbol;
		}

		public final void execute() {

			symbolService.createPositionedSymbol(positionedSymbol.getSymbol(), positionedSymbol.getX(),
					positionedSymbol.getY(), positionedSymbol.getZ(), new AsyncCallback<PositionedSymbol>() {

						@Override
						public void onFailure(Throwable caught) {
							

						}

						@Override
						public void onSuccess(PositionedSymbol result) {
							result.setLineColor(positionedSymbol.getLineColor());
							result.setFillColor(positionedSymbol.getFillColor());
							@SuppressWarnings("unchecked")
							SMA symbolManipulationAction = (SMA) result;
							if (canDo(symbolManipulationAction)) {
								doIt(symbolManipulationAction);
							}
						}
					});

			registerHistoryEvent();
		}

		protected abstract boolean canDo(SMA specificPositionedSymbol);

		protected abstract void doIt(SMA specificPositionedSymbol);
	}

	private interface EditorsListener extends AddSignsSidebarEditorListener, HeadEditorListener {
	}

	public interface SignEditorListener {
		void onChangeTool(SimpleSign sign);

		void onInvalidSessionExceptionCaught();

		void onMissingAuthorizationExceptionCaught(String message);

	}

	private boolean isSignEditorActive() {
		// sign is not null, if the user is currently in the sign eidtor tool
		return sign != null && sign != SIGNDUMMY;
	}

	@Override
	public void logout() {
		updateSignEditorButtonBar();
		updateShowSignHistory();
	}

	private void moveSelectedSymbols(int xModifier, int yModifier) {
		for (PositionedSymbol symbol : selectionTool.getSelectedItems()) {
			moveSymbol(symbol, xModifier, yModifier);
		}
		updateSignBorderLines();
	}

	private void moveSymbol(PositionedSymbol symbol, int xModifier, int yModifier) {
		double newX = (symbol.getX() + xModifier) * SCALE_FACTOR;
		double newY = (symbol.getY() + yModifier) * SCALE_FACTOR;

		setSymbolImagePosition(symbol, (int) Math.round(newX), (int) Math.round(newY));
		symbol.setX((int) Math.round(newX / SCALE_FACTOR));
		symbol.setY((int) Math.round(newY / SCALE_FACTOR));
	}

	private boolean isHeadSymbolSelected() {
		boolean result = false;
		for (PositionedSymbol symbol : selectionTool.getSelectedItems()) {
			if (symbol instanceof HeadSymbol) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void discardChanges() {
		// Unused
	}
}