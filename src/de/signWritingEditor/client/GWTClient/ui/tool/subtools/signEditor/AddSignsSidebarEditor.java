package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.FingerAlphabetEditor.FingerAlphabetEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.HandEditor.HandEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.MovementEditor.MovementEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.VisemeEditor.VisemeEditorListener;
import de.signWritingEditor.client.service.SymbolGroupAnalyzer;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.BodyBaseSymbol;
import de.signWritingEditor.shared.model.material.DynamicsBaseSymbol;
import de.signWritingEditor.shared.model.material.HandBaseSymbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedFingerAlphabetSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;

public class AddSignsSidebarEditor extends SidebarEditor {
	private static final double ICON_SCALE_FACTOR = 1;

	private final TabPanel tabPanel;
	private final SymbolImageUrlService symbolImageUrlService;

	private VisemeEditor visemeEditor;

	private final AddSignsSidebarEditorListener listener;

	private PositionedSymbolFactory positionedSymbolFactory;

	private HandEditor handEditor;
	private MovementEditor movementEditor;
	private SymbolKeyboard touchEditor;
	private SymbolKeyboard fingerEditor;
	private SymbolKeyboard dynamicsEditor;
	private SymbolKeyboard bodyEditor;

	public AddSignsSidebarEditor(SymbolImageUrlService symbolImageUrlService, AddSignsSidebarEditorListener listener,
			PositionedSymbolFactory positionedSymbolFactory) {
		super(I18N.getInsertSymbols());
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";

		this.symbolImageUrlService = symbolImageUrlService;
		this.listener = listener;
		this.positionedSymbolFactory = positionedSymbolFactory;

		tabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				handleTabSelected(selectedTabContent);
			}

		});
		addContent(tabPanel);

		Image visemeEditorIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory.createHeadSymbol(
						positionedSymbolFactory.createPositionedSymbol(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol())),
				ICON_SCALE_FACTOR, true));
		Image handEditorIcon = new Image(
				symbolImageUrlService.getSymbolImageUrl(HandBaseSymbol.INDEX.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image touchEditorIcon = new Image(symbolImageUrlService
				.getSymbolImageUrl(MovementBaseSymbol.TOUCH_SINGLE.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image fingerMovementEditorIcon = new Image(symbolImageUrlService.getSymbolImageUrl(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image arrowEditorIcon = new Image(symbolImageUrlService.getSymbolImageUrl(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_MEDIUM.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image dynamicEditorIcon = new Image(
				symbolImageUrlService.getSymbolImageUrl(DynamicsBaseSymbol.SLOW.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image bodyEditorIcon = new Image(symbolImageUrlService
				.getSymbolImageUrl(BodyBaseSymbol.SHOULDER_HIP_POSITIONS.getIswaSymbol(), ICON_SCALE_FACTOR));

		this.visemeEditor = createVisemeEditor();
		this.handEditor = createHandsSymbolKeyboards();
		this.movementEditor = createMovementSymbolKeyboards();
		this.touchEditor = createTouchSymbolKeyboard();
		this.fingerEditor = createFingerMovementSymbolKeyboard();
		this.dynamicsEditor = createDynamicSymbolKeyboard();
		this.bodyEditor = createBodyEditWidget();

		tabPanel.addTab(new Tab(visemeEditorIcon, visemeEditor));
		tabPanel.addTab(new Tab(handEditorIcon, handEditor));
		tabPanel.addTab(new Tab(arrowEditorIcon, movementEditor));
		tabPanel.addTab(new Tab(touchEditorIcon, touchEditor));
		tabPanel.addTab(new Tab(fingerMovementEditorIcon, fingerEditor));
		tabPanel.addTab(new Tab(dynamicEditorIcon, dynamicsEditor));
		tabPanel.addTab(new Tab(bodyEditorIcon, bodyEditor));

	}

	public VisemeEditor getVisemeEditor() {
		return visemeEditor;
	}

	public HandEditor getHandEditor() {
		return handEditor;
	}

	public FingerAlphabetEditor getFingerAlphabetEditor() {
		return handEditor.getFingerAlphabetEditor();
	}

	private HandEditor createHandsSymbolKeyboards() {
		HandEditor handEditor = new HandEditor(symbolImageUrlService, new HandEditorListener() {

			@Override
			public void onAddSymbol(Symbol symbol, int xOffset, int yOffset) {
				listener.onAddSymbol(symbol, xOffset, yOffset);
			}

			@Override
			public void onAddFingerAlphabetSymbols(PositionedFingerAlphabetSymbol symbols) {
				listener.onAddFingerAlphabetSymbols(symbols);
			}

			@Override
			public void onArrangeFingerAlphabet() {
				listener.onArrangeFingerAlphabet();
			}

			@Override
			public String onSpellSearchWord() {
				return listener.onSpellSearchWord();
			}

			@Override
			public void onFocusKeyTextBox() {
				listener.onFocusKeyTextBox();

			}

			@Override
			public void onHistoryEvent() {
				listener.onHistoryEvent();
			}
		});
		return handEditor;
	}

	private MovementEditor createMovementSymbolKeyboards() {
		return new MovementEditor(symbolImageUrlService, new MovementEditorListener() {

			@Override
			public void onAddSymbol(Symbol symbol, int xOffset, int yOffset) {
				listener.onAddSymbol(symbol, xOffset, yOffset);
			}
		});
	}

	private SymbolKeyboard createTouchSymbolKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		for (MovementBaseSymbol movementSymbol : MovementBaseSymbol.values()) {
			final Symbol iswaSymbol = movementSymbol.getIswaSymbol();
			if (SymbolGroupAnalyzer.isTouchSymbol(iswaSymbol)) {
				if (!(movementSymbol.equals(MovementBaseSymbol.TOUCH_MULTIPE)
						|| movementSymbol.equals(MovementBaseSymbol.GRASP_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.STRIKE_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.BRUSH_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.RUB_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.SURFACE_SYMBOLS)
						|| movementSymbol.equals(MovementBaseSymbol.SURFACE_BETWEEN))) {
					result.addSymbol(iswaSymbol, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(iswaSymbol, 0, 0);
						}
					});
				}
			}
		}
		return result;
	}

	private SymbolKeyboard createFingerMovementSymbolKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		for (MovementBaseSymbol movementSymbol : MovementBaseSymbol.values()) {
			final Symbol iswaSymbol = movementSymbol.getIswaSymbol();
			if (SymbolGroupAnalyzer.isFingerMovementSymbol(iswaSymbol)) {
				if (!(movementSymbol.equals(MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.FLICK_LARGE_MULTIPLE)
						|| movementSymbol.equals(MovementBaseSymbol.FLICK_SMALL_MULTIPLE))) {
					result.addSymbol(iswaSymbol, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(iswaSymbol, 0, 0);
						}
					});
				}
			}
		}
		final Symbol surfaceSymbols = MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol();
		result.addSymbol(surfaceSymbols, "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onAddSymbol(surfaceSymbols, 0, 0);
			}
		});

		final Symbol surfaceBetween = MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol();
		result.addSymbol(surfaceBetween, "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onAddSymbol(surfaceBetween, 0, 0);
			}
		});

		return result;
	}

	private SymbolKeyboard createDynamicSymbolKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("dynamicSymbols");
		for (DynamicsBaseSymbol dynamicBaseSymbol : DynamicsBaseSymbol.values()) {
			final Symbol iswaSymbol = dynamicBaseSymbol.getIswaSymbol();
			result.addSymbol(iswaSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(iswaSymbol, 0, 0);
				}
			});
		}
		return result;
	}

	private SymbolKeyboard createBodyEditWidget() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("bodySymbols");
		result.addSubHeader(I18N.getShouldersAndHip());
		for (BodyBaseSymbol bodyBaseSymbol : BodyBaseSymbol.values()) {
			final Symbol shoulderAndHipSymbol = bodyBaseSymbol.getIswaSymbol();
			if (!(bodyBaseSymbol.equals(BodyBaseSymbol.FINGERS)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_COMBINATIONS)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_1)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_2)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_3)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_4)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_5)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_6)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_7)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.UPPER_BODY_TILTS)
					|| BodyBaseSymbol.isAirRelatedBodySymbol(bodyBaseSymbol.getIswaSymbol().getBaseSymbol()))) {
				result.addSymbol(shoulderAndHipSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(shoulderAndHipSymbol, 0, 0);
					}
				});

				if (bodyBaseSymbol.equals(BodyBaseSymbol.SHOULDER_HIP_POSITIONS)) {
					final Symbol shoulderHipPositionsVariant2 = new Symbol(5, 1, 2, 1, 2, 1, 40, 12);
					result.addSymbol(shoulderHipPositionsVariant2, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(shoulderHipPositionsVariant2, 0, 0);
						}
					});

					final Symbol shoulderHipPositionsVariant3 = new Symbol(5, 1, 2, 1, 4, 1, 46, 20);
					result.addSymbol(shoulderHipPositionsVariant3, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(shoulderHipPositionsVariant3, 0, 0);
						}
					});

					final Symbol rollSwitch = new Symbol(5, 1, 1, 1, 3, 3, 43, 39);
					result.addSymbol(rollSwitch, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(rollSwitch, 0, 0);
						}
					});

					final Symbol shoulderHipPositionsVariant4 = new Symbol(5, 1, 2, 1, 5, 1, 9, 12);
					result.addSymbol(shoulderHipPositionsVariant4, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(shoulderHipPositionsVariant4, 0, 0);
						}
					});

					final Symbol shoulderHipPositionsVariant5 = new Symbol(5, 1, 2, 1, 5, 3, 9, 6);
					result.addSymbol(shoulderHipPositionsVariant5, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(shoulderHipPositionsVariant5, 0, 0);
						}
					});
				}
			}
		}

		result.addSubHeader(I18N.getLegsAndArms());
		for (BodyBaseSymbol bodyBaseSymbol : BodyBaseSymbol.values()) {
			final Symbol iswaSymbol = bodyBaseSymbol.getIswaSymbol();
			if (bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_COMBINATIONS)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_1)) {
				result.addSymbol(iswaSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(iswaSymbol, 0, 0);
					}
				});

			}
		}

		result.addSubHeader(I18N.getFinger());
		for (BodyBaseSymbol bodyBaseSymbol : BodyBaseSymbol.values()) {
			final Symbol iswaSymbol = bodyBaseSymbol.getIswaSymbol();
			if (bodyBaseSymbol.equals(BodyBaseSymbol.FINGERS) || bodyBaseSymbol.equals(BodyBaseSymbol.LIMB_LENGTH_7)) {
				result.addSymbol(iswaSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(iswaSymbol, 0, 0);
					}
				});

			}
		}

		result.addSubHeader(I18N.getTopView());
		for (BodyBaseSymbol bodyBaseSymbol : BodyBaseSymbol.values()) {
			final Symbol iswaSymbol = bodyBaseSymbol.getIswaSymbol();
			if (bodyBaseSymbol.equals(BodyBaseSymbol.UPPER_BODY_TILTS)
					|| bodyBaseSymbol.equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE)) {
				result.addSymbol(iswaSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(iswaSymbol, 0, 0);
					}
				});

				if (bodyBaseSymbol.equals(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE)) {
					final Symbol headWithNose = new Symbol(4, 1, 1, 1, 4, 1, 37, 35);
					result.addSymbol(headWithNose, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onAddSymbol(headWithNose, 0, 0);
						}
					});

				}

			}
		}
		return result;
	}

	private void handleTabSelected(Widget selectedTabContent) {
	}

	private VisemeEditor createVisemeEditor() {
		return new VisemeEditor(symbolImageUrlService, listener, positionedSymbolFactory);
	}

	public interface AddSignsSidebarEditorListener
			extends VisemeEditorListener, SymbolEditorListener, FingerAlphabetEditorListener {
	}

	@Override
	public void resetSidebar() {
		visemeEditor.resetVisemeEditor();
		handEditor.resetSidebar();
		movementEditor.resetSidebar();
		touchEditor.resetSymbolKeyboard();
		fingerEditor.resetSymbolKeyboard();
		dynamicsEditor.resetSymbolKeyboard();
		bodyEditor.resetSymbolKeyboard();
	}
}