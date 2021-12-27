package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.service.SymbolGroupAnalyzer;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;

public class MovementEditor extends SidebarEditor {
	private static final double ICON_SCALE_FACTOR = 1.25;

	private final SymbolImageUrlService symbolImageUrlService;
	private final MovementEditorListener listener;

	private TabPanel tabPanel;
	private Tab movementWallPlaneTab;
	private Tab movementFloorPlaneTab;
	private Tab movementDiagonalPlaneTab;
	private Tab curvesHitFloorPlaneTab;
	private Tab circlesTab;
	private Tab allMovementsTab;

	private SymbolKeyboard movementWallPlaneEditor;

	private SymbolKeyboard movementFloorPlaneEditor;

	private SymbolKeyboard movementDiagonalPlaneEditor;

	private SymbolKeyboard curvesHitFloorPlaneEditor;

	private SymbolKeyboard circlesEditor;

	private SymbolKeyboard allMovementsEditor;

	public MovementEditor(SymbolImageUrlService symbolImageUrlService, MovementEditorListener listener) {
		super(I18N.getEditMovement());

		assert listener != null : "Precondition failed: listener != null";

		this.listener = listener;
		this.symbolImageUrlService = symbolImageUrlService;

		addStyleName("movementEditor");

		Image movementWallPlaneTabIcon = new Image(symbolImageUrlService.getSymbolImageUrl(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image movementFloorPlaneTabIcon = new Image(symbolImageUrlService.getSymbolImageUrl(
				MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image movementDiagonalPlaneTabIcon = new Image(symbolImageUrlService
				.getSymbolImageUrl(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image curvesHitFloorPlaneTabIcon = new Image(symbolImageUrlService
				.getSymbolImageUrl(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image circlesTabIcon = new Image(symbolImageUrlService
				.getSymbolImageUrl(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol(), ICON_SCALE_FACTOR));
		Image allMovementsTabIcon = new Image(Resources.RESOURCE.getIconAllMovementSymbols());

		movementWallPlaneEditor = createMovementWallPlaneKeyboard();
		movementFloorPlaneEditor = createMovementFloorPlaneKeyboard();
		movementDiagonalPlaneEditor = createMovementDiagonalPlaneKeyboard();
		curvesHitFloorPlaneEditor = createCurvesHitFloorPlaneKeyboard();
		circlesEditor = createCirclesKeyboard();
		allMovementsEditor = createAllMovementsKeyboard();

		movementWallPlaneTab = new Tab(movementWallPlaneTabIcon, movementWallPlaneEditor);
		movementFloorPlaneTab = new Tab(movementFloorPlaneTabIcon, movementFloorPlaneEditor);
		movementDiagonalPlaneTab = new Tab(movementDiagonalPlaneTabIcon, movementDiagonalPlaneEditor);
		curvesHitFloorPlaneTab = new Tab(curvesHitFloorPlaneTabIcon, curvesHitFloorPlaneEditor);
		circlesTab = new Tab(circlesTabIcon, circlesEditor);
		allMovementsTab = new Tab(allMovementsTabIcon, allMovementsEditor);

		tabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				handleTabSelected(selectedTabContent);
			}
		});

		addContent(tabPanel);

		tabPanel.addTab(movementWallPlaneTab);
		tabPanel.addTab(movementFloorPlaneTab);
		tabPanel.addTab(movementDiagonalPlaneTab);
		tabPanel.addTab(curvesHitFloorPlaneTab);
		tabPanel.addTab(circlesTab);
		tabPanel.addTab(allMovementsTab);
	}

	private SymbolKeyboard createAllMovementsKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		for (MovementBaseSymbol movementSymbol : MovementBaseSymbol.values()) {
			final Symbol iswaSymbol = movementSymbol.getIswaSymbol();
			if (SymbolGroupAnalyzer.isArrowSymbol(iswaSymbol)) {
				result.addSymbol(iswaSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(iswaSymbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private SymbolKeyboard createCirclesKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		List<Symbol> symbolsToAdd = new ArrayList<Symbol>();
		symbolsToAdd.add(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol());
		for (final Symbol symbol : symbolsToAdd) {
			result.addSymbol(symbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(symbol, 0, 0);
				}
			});
		}

		return result;
	}

	private SymbolKeyboard createCurvesHitFloorPlaneKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		List<Symbol> symbolsToAdd = new ArrayList<Symbol>();
		symbolsToAdd.add(MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol());
		for (final Symbol symbol : symbolsToAdd) {
			result.addSymbol(symbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(symbol, 0, 0);
				}
			});
		}

		return result;
	}

	private SymbolKeyboard createMovementDiagonalPlaneKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		List<Symbol> symbolsToAdd = new ArrayList<Symbol>();
		symbolsToAdd.add(MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol());

		for (final Symbol symbol : symbolsToAdd) {
			result.addSymbol(symbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(symbol, 0, 0);
				}
			});
		}

		return result;
	}

	private SymbolKeyboard createMovementFloorPlaneKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		List<Symbol> symbolsToAdd = new ArrayList<Symbol>();
		symbolsToAdd.add(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.SINGLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DOUBLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CROSS_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRIPLE_STRAIGHT_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRIPLE_WRIST_FLEX_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.BENT_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CORNER_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CHECK_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.BOX_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ZIGZAG_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.PEAKS_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE_FILLED_ARROW.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE_FILLED_ARROW.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_SHAKING_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_FLOOR_PLANE_COMBINED.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_FLOOR_PLANE_SNAKE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol());

		for (final Symbol symbol : symbolsToAdd) {
			result.addSymbol(symbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(symbol, 0, 0);
				}
			});
		}

		return result;
	}

	private SymbolKeyboard createMovementWallPlaneKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("movementSymbols");
		List<Symbol> symbolsToAdd = new ArrayList<Symbol>();
		symbolsToAdd.add(MovementBaseSymbol.SINGLE_STRAIGHT_MOVEMENT_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.SINGLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DOUBLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.DOUBLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CROSS_MOVEMENT_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRIPPLE_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRIPPLE_WRIST_FLEX_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.BLEND_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CORNER_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CORNER_WALL_PLANE_WITH_ROTATION.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CHECK_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.BOX_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ZIGZAG_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.PEAKS_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_SHAKING_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_SINGLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.TRAVEL_ARM_SPIRAL_WALL_PLANE_TRIPLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_WALL_PLANE_QUARTER_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_WALL_PLANE_HALF_CIRCLE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_WALL_PLANE_3_QUARTER_CIRCLE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CORNER_WALL_PLANE_WITH_ROTATION.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.HUMP_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.LOOP_WALL_PLANE_SMALL_DOUBLE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_WALL_PLANE_2_CURVES_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.WAVE_WALL_PLANE_3_CURVES_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVE_THEN_STRAIGHT_MOVEMENT_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.CURVED_CROSS_MOVEMENT_WALL_SMALL.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.ROTATION_SINGLE_WALL_PLANE.getIswaSymbol());
		symbolsToAdd.add(MovementBaseSymbol.SHAKING_WALL_PLANE.getIswaSymbol());
		for (final Symbol symbol : symbolsToAdd) {
			result.addSymbol(symbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(symbol, 0, 0);
				}
			});
		}

		return result;
	}

	private void handleTabSelected(Widget selectedTabContent) {
		assert selectedTabContent != null : "Precondition failed: selectedTabContent != null";

		if (selectedTabContent == movementWallPlaneTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementWallPlaneSymbol());
		} else if (selectedTabContent == movementFloorPlaneTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementFloorPlaneSymbol());
		} else if (selectedTabContent == movementDiagonalPlaneTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementDiagonalPlaneSymbol());
		} else if (selectedTabContent == curvesHitFloorPlaneTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementCurvesHitFloorPlaneSymbol());
		} else if (selectedTabContent == circlesTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementCircleSymbol());
		} else if (selectedTabContent == allMovementsTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddMovementSymbol());
		}
	}

	public interface MovementEditorListener extends SymbolEditorListener {

	}

	@Override
	public void resetSidebar() {
		movementWallPlaneEditor.resetSymbolKeyboard();
		movementFloorPlaneEditor.resetSymbolKeyboard();
		movementDiagonalPlaneEditor.resetSymbolKeyboard();
		curvesHitFloorPlaneEditor.resetSymbolKeyboard();
		circlesEditor.resetSymbolKeyboard();
		allMovementsEditor.resetSymbolKeyboard();
	}
}
