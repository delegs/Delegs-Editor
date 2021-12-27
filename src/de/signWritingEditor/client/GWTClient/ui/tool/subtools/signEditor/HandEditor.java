package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.FingerAlphabetEditor.FingerAlphabetEditorListener;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HandBaseSymbol;

public class HandEditor extends SidebarEditor {

	private final SymbolImageUrlService symbolImageUrlService;
	private final HandEditorListener listener;

	private final TabPanel tabPanel;
	private final Tab squarePalmTab;
	private final Tab circlePalmTab;
	private final Tab flatPalmTab;
	private final Tab rectanglePalmTab;
	private final Tab nonOccuringHandSymbolTab;
	private final Tab allHandsTab;
	private FingerAlphabetEditor fingerAlphabetEditor;
	private Map<Symbol, String> symbolToSortMap;
	private final SymbolKeyboard squarePalmEditor;
	private final SymbolKeyboard circlePalmEditor;
	private final SymbolKeyboard flatPalmEditor;
	private final SymbolKeyboard rectanglePalmEditor;
	private final SymbolKeyboard nonOccurringHandSymbolEditor;
	private final SymbolKeyboard allHandsEditor;

	public HandEditor(SymbolImageUrlService symbolImageUrlService, HandEditorListener listener) {
		super(I18N.getEditHands());

		assert listener != null : "Precondition failed: listener != null";

		this.listener = listener;
		this.symbolImageUrlService = symbolImageUrlService;

		createOrderingMap();

		addStyleName("handEditor");

		Image squareHandsTabIconTabIcon = new Image(
				symbolImageUrlService.getSymbolImageUrl(new Symbol(1, 10, 15, 1, 1, 1, 0, 0), 1));
		Image circlePalmHandsTabIcon = new Image(
				symbolImageUrlService.getSymbolImageUrl(new Symbol(1, 5, 43, 1, 1, 1, 0, 0), 1));
		Image flatPalmHandsTabIcon = new Image(
				symbolImageUrlService.getSymbolImageUrl(new Symbol(1, 5, 15, 1, 1, 1, 0, 0), 1));
		Image rectanglePalmHandsTabIcon = new Image(Resources.RESOURCE.getIconRectangleHandSymbols());
		Image notOccuringHandsTabIcon = new Image(Resources.RESOURCE.getIconNotOccuringHandSymbols());
		Image allHandsTabIcon = new Image(Resources.RESOURCE.getIconAllHandSymbols());

		squarePalmEditor = createSquarePalmKeyboard();
		circlePalmEditor = createCirclePalmKeyboard();
		flatPalmEditor = createFlatPalmKeyboard();
		rectanglePalmEditor = createRectanglePalmKeyboard();
		nonOccurringHandSymbolEditor = createNonOccurringHandSymbolKeyboard();
		allHandsEditor = createAllHandsKeyboard();

		squarePalmTab = new Tab(squareHandsTabIconTabIcon, squarePalmEditor);
		circlePalmTab = new Tab(circlePalmHandsTabIcon, circlePalmEditor);
		flatPalmTab = new Tab(flatPalmHandsTabIcon, flatPalmEditor);
		rectanglePalmTab = new Tab(rectanglePalmHandsTabIcon, rectanglePalmEditor);
		nonOccuringHandSymbolTab = new Tab(notOccuringHandsTabIcon, nonOccurringHandSymbolEditor);
		allHandsTab = new Tab(allHandsTabIcon, allHandsEditor);

		tabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				handleTabSelected(selectedTabContent);
			}
		});

		addContent(tabPanel);

		tabPanel.addTab(squarePalmTab);
		tabPanel.addTab(circlePalmTab);
		tabPanel.addTab(flatPalmTab);
		tabPanel.addTab(rectanglePalmTab);
		tabPanel.addTab(nonOccuringHandSymbolTab);
		tabPanel.addTab(allHandsTab);

		createFingeralphabetTab();
	}

	private boolean isSymbolInThisGroup(String group, Symbol symbol) {
		boolean result = false;

		if (symbolToSortMap.containsKey(symbol)) {
			result = group.equals(symbolToSortMap.get(symbol));
		}

		return result;
	}

	private void createOrderingMap() {
		symbolToSortMap = new HashMap<Symbol, String>() {

			private static final long serialVersionUID = 1L;

			{
				put(HandBaseSymbol.INDEX.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.INDEX_ON_CUP.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.INDEX_ON_OVAL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.INDEX_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_ON_ANGLE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.INDEX_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_BENT_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_BENT_ON_FIRST_THUMB_UNDER.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RAISED_KNUCKLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_CUP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_HINGE_ON_FIST.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_HINGE_ON_FIST_LOW.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_HINGE_ON_CIRCLE.getIswaSymbol(), "None");

				put(HandBaseSymbol.INDEX_MIDDLE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_RAISED_KNUCKLES.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_UP_MIDDLE_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_HINGE_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_INDEX_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_MIDDLE_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_CUP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_CROSS.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_CROSS_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_BENT_OVER_INDEX.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_BENT_OVER_MIDDLE.getIswaSymbol(), "None");

				put(HandBaseSymbol.INDEX_MIDDLE_THUMB.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_STRAIGHT_THUMB_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_BENT_THUMB_STRAIGHT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_HINGE_SPREAD_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_UP_MIDDLE_HINGE_THUMB_SIDE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_UP_MIDDLE_HINGE_THUMB_UNIT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_HINGE_MIDDLE_UP_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UP_SPREAD_THUMB_FORWARD.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_CUP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_CIRCLE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_HOOK.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_BETWEEN_INDEX_MIDDLE_STRAIGHT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_THUMB_SIDE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_THUMB_SIDE_UNIT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_THUMB_SIDE_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_HOOK_INDEX_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_HOOK_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_HINGE_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_CROSS_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_THUMB_FORWARD.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_UNIT_CUP_THUMB_FORWARD.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_CUP_INDEX_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_CUP_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_CIRCLE_INDEX_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_CIRCLE_INDEX_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_ANGLE_OUT_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_ANGLE_IN_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_CIRCLE_MIDDLE_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_UNIT_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_ANGLE_OUT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_THUMB_ANGLE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.MIDDLE_THUMB_ANGLE_OUT_INDEX_UP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.MIDDLE_THUMB_ANGLE_OUT_INDEX_CROSSED.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_ANGLE_INDEX_UP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HOOK_MIDDLE_HINGE.getIswaSymbol(), "None");

				put(HandBaseSymbol.FOUR_FINGERS.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FOUR_FINGERS_BENT.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FOUR_FINGERS_HINGE.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FOUR_FINGERS_UNIT.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FOUR_FINGERS_UNIT_SPLIT.getIswaSymbol(), "None");
				put(HandBaseSymbol.FOUR_FINGERS_UNIT_CLAW.getIswaSymbol(), "None");
				put(HandBaseSymbol.FOUR_FINGERS_UNIT_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.FOUR_FINGERS_UNIT_HINGE.getIswaSymbol(), "Rectangle");

				put(HandBaseSymbol.FIVE_FINGERS_SPREAD.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_HEEL.getIswaSymbol(), "None");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_FOUR_BENT.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_FOUR_BENT_HEEL.getIswaSymbol(), "None");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_BENT.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_BENT_HEEL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_THUMB_FORWARD.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_CUP.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_CUP_OPEN.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_HINGE_OPEN.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_OVAL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_HINGE.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_HINGE_THUMB_SIDE.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FIVE_FINGERS_SPREAD_HINGE_NO_THUMB.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT_BETWEEN_PALM_FACINGS.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT_HEEL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.FLAT_THUMB_SIDE.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT_THUMB_SIDE_HEEL.getIswaSymbol(), "None");
				put(HandBaseSymbol.FLAT_THUMB_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.FLAT_THUMB_FORWARD.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT_SPLIT_INDEX_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.FLAT_SPLIT_CENTER.getIswaSymbol(), "Flat");
				put(HandBaseSymbol.FLAT_SPLIT_CENTER_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.FLAT_SPLIT_CENTER_THUMB_SID_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.FLAT_SPLIT_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.CLAW.getIswaSymbol(), "None");
				put(HandBaseSymbol.CLAW_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CLAW_NO_THUMB.getIswaSymbol(), "None");
				put(HandBaseSymbol.CLAW_THUMB_FORWARD.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HOOK_CURLICUE.getIswaSymbol(), "None");
				put(HandBaseSymbol.HOOK.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_OPEN.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_OPEN_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_OPEN_NO_THUMB.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_NO_THUMB.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_OPEN_THUMB_FORWARD.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CUP_THUMB_FORWARD.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.CURLICUE_OPEN.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.CURLICUE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.OVAL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.OVAL_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.OVAL_NO_THUMB.getIswaSymbol(), "None");
				put(HandBaseSymbol.OVAL_THUMB_FORWARD.getIswaSymbol(), "None");
				put(HandBaseSymbol.HINGE_OPEN.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_OPEN_THUMB_FORWARD.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_SMALL.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_OPEN_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_THUMB_SIDE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_OPEN_NO_THUMB.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_NO_THUMB.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_THUMB_SIDE_TOUCHES_INDEX.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.HINGE_THUMB_BETWEEN_MIDDLE_RING.getIswaSymbol(), "None");
				put(HandBaseSymbol.ANGLE.getIswaSymbol(), "Rectangle");

				put(HandBaseSymbol.INDEX_MIDDLE_RING.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_ON_ANGLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_UNIT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_MIDDLE_RING_UNIT_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_DOWN.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_DOWN_RIPPLE_STRAIGHT.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_DOWN_RIPPLE_CURVED.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_UP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_UP_ON_FIRST_THUMB_UNDER.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_UP_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_UP_ON_OVAL.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_UP_ON_ANGLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_RAISED_KNUCKLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_THOUCHES_THUMB.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_THUMB.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_THUMB_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_INDEX_THUMB.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_INDEX_THUMB_ON_HINGE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.BABY_INDEX_THUMB_INDEX_THUMB_ANGLE_OUT.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_INDEX_THUMB_INDEX_THUMB_ANGLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_INDEX.getIswaSymbol(), "Square");
				put(HandBaseSymbol.BABY_INDEX_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.BABY_INDEX_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.BABY_INDEX_ON_ANGLE.getIswaSymbol(), "None");

				put(HandBaseSymbol.INDEX_MIDDLE_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_BABY_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.INDEX_MIDDLE_BABY_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_BABY_ON_ANGLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_CROSS_WITH_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_MIDDLE_CROSS_WITH_BABY_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_DOWN.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_DOWN_INDEX_THUMB_HOOK_MIDDLE_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_DOWN_MIDDLE_THUMB_ANGLE_INDEX_CROSS.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_UP.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_RAISED_KNUCKLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_BABY_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_BABY_ON_OVAL.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_BABY_ON_ANGLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_MIDDLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_MIDDLE_UNIT.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_MIDDLE_RAISED_KNUCKLES.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_INDEX.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_THUMB.getIswaSymbol(), "None");
				put(HandBaseSymbol.RING_THUMB_HOOK.getIswaSymbol(), "None");

				put(HandBaseSymbol.INDEX_RING_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_CURLICUE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_HOOK_OUT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_HOOK_IN.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_HOOK_UNDER.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_CUP.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_HINGE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_ANGLE_OUT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_RING_BABY_ON_ANGLE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.MIDDLE_DOWN.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_HINGE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.MIDDLE_UP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.MIDDLE_UP_ON_CIRCLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RAISED_KNUCKLE.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_UP_THUMB_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_HOOK.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_THUMB_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_BABY.getIswaSymbol(), "None");

				put(HandBaseSymbol.MIDDLE_RING_BABY.getIswaSymbol(), "Square");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_CIRCLE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_CURLICUE.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_CUP.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_HINGE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_ANGLE_OUT.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_ANGLE_IN.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RING_BABY_ON_ANGLE.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_BENT.getIswaSymbol(), "Circle");
				put(HandBaseSymbol.MIDDLE_RING_BABY_UNIT_ON_CLAW.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RING_BABY_UNIT_ON_CLAW_SIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RING_BABY_UNIT_ON_HOOK_OUT.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RING_BABY_UNIT_ON_HOOK_IN.getIswaSymbol(), "None");
				put(HandBaseSymbol.MIDDLE_RING_BABY_UNIT_ON_HOOK.getIswaSymbol(), "Rectangle");
				put(HandBaseSymbol.INDEX_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_SIDE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_ON_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_THUMB_DIAGONAL.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_THUMB_UNIT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_THUMB_BENT.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_INDEX_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_BOTH_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_SIDE_INDEX_HINGE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_FORWARD_INDEX_STRAIGHT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_FORWARD_INDEX_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HOOK.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_CURLICUE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_CURVE_THUMB_INSIDE.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_CURVE_THUMB_INSIDE_ON_CLAW.getIswaSymbol(), "None");
				put(HandBaseSymbol.INDEX_THUMB_CURVE_THUMB_UNDER.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_CIRCLE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_CUP.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_CUP_OPEN.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HINGE_OPEN.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HINGE_LARGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HINGE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_HINGE_SMALL.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_ANGLE_OUT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_ANGLE_IN.getIswaSymbol(), "Square");
				put(HandBaseSymbol.INDEX_THUMB_ANGLE.getIswaSymbol(), "Square");

				put(HandBaseSymbol.THUMB.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_HEEL.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_SIDE_DIAGONAL.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_SIDE_UNIT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_SIDE_BENT.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_FORWARD.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_BETWEEN_INDEX_MIDDLE.getIswaSymbol(), "Square");
				put(HandBaseSymbol.THUMB_BETWEEN_MIDDLE_RING.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_BETWEEN_RING_BABY.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_UNDER_TWO_FINGERS.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_OVER_TWO_FINGERS.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_UNDER_THREE_FINGERS.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_UNDER_FOUR_FINGERS.getIswaSymbol(), "None");
				put(HandBaseSymbol.THUMB_OVER_FOUR_RAISED_KNUCKLES.getIswaSymbol(), "None");
				put(HandBaseSymbol.FIST.getIswaSymbol(), "Square");
				put(HandBaseSymbol.FIST_HEEL.getIswaSymbol(), "None");
			}
		};
	}

	private SymbolKeyboard createAllHandsKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handSymbol : HandBaseSymbol.values()) {
			final Symbol iswaSymbol = handSymbol.getIswaSymbol();
			result.addSymbol(iswaSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onAddSymbol(iswaSymbol, 0, 0);
				}
			});
		}

		return result;
	}

	private SymbolKeyboard createNonOccurringHandSymbolKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			final Symbol symbol = handBaseSymbol.getIswaSymbol();

			if (isSymbolInThisGroup("None", symbol)) {
				result.addSymbol(symbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(symbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private SymbolKeyboard createRectanglePalmKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			final Symbol symbol = handBaseSymbol.getIswaSymbol();

			if (isSymbolInThisGroup("Rectangle", symbol)) {
				result.addSymbol(symbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(symbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private SymbolKeyboard createFlatPalmKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			final Symbol symbol = handBaseSymbol.getIswaSymbol();

			if (isSymbolInThisGroup("Flat", symbol)) {
				result.addSymbol(symbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(symbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private SymbolKeyboard createCirclePalmKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			final Symbol symbol = handBaseSymbol.getIswaSymbol();

			if (isSymbolInThisGroup("Circle", symbol)) {
				result.addSymbol(symbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(symbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private SymbolKeyboard createSquarePalmKeyboard() {
		SymbolKeyboard result = new SymbolKeyboard(symbolImageUrlService, false);

		result.addStyleDependentName("handSymbols");
		for (HandBaseSymbol handBaseSymbol : HandBaseSymbol.values()) {
			final Symbol symbol = handBaseSymbol.getIswaSymbol();

			if (isSymbolInThisGroup("Square", symbol)) {
				result.addSymbol(symbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onAddSymbol(symbol, 0, 0);
					}
				});
			}
		}

		return result;
	}

	private void createFingeralphabetTab() {
		Image fingerAlphabetTabIcon = new Image(Resources.RESOURCE.getIconFingerAlphabet());
		fingerAlphabetEditor = new FingerAlphabetEditor(symbolImageUrlService, listener);
		if (isFingeralphabetEnabled()) {
			tabPanel.addTab(new Tab(fingerAlphabetTabIcon, fingerAlphabetEditor));
		}
	}

	private boolean isFingeralphabetEnabled() {
		return I18NLocale.DE.equals(I18N.getLocale());
	}

	private void handleTabSelected(Widget selectedTabContent) {
		assert selectedTabContent != null : "Precondition failed: selectedTabContent != null";

		if (selectedTabContent == squarePalmTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		} else if (selectedTabContent == circlePalmTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		} else if (selectedTabContent == flatPalmTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		} else if (selectedTabContent == rectanglePalmTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		} else if (selectedTabContent == nonOccuringHandSymbolTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		} else if (selectedTabContent == allHandsTab.getTabContent()) {
			setHeaderLabelText(I18N.getAddHandsSymbol());
		}
	}

	public interface HandEditorListener extends SymbolEditorListener, FingerAlphabetEditorListener {
	}

	public FingerAlphabetEditor getFingerAlphabetEditor() {
		return fingerAlphabetEditor;
	}

	@Override
	public void resetSidebar() {
		fingerAlphabetEditor.resetFingerAlphabetEditor();
		squarePalmEditor.resetSymbolKeyboard();
		circlePalmEditor.resetSymbolKeyboard();
		flatPalmEditor.resetSymbolKeyboard();
		rectanglePalmEditor.resetSymbolKeyboard();
		nonOccurringHandSymbolEditor.resetSymbolKeyboard();
		allHandsEditor.resetSymbolKeyboard();
	}
}
