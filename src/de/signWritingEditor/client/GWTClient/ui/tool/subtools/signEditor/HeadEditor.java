package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CustomColorChangerPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CustomColorChangerPanel.PositionedSymbolColorChangeListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.Tab;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.TabPanel.TabPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.VisemeEditor.VisemeEditorListener;
import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.BodyBaseSymbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.PositionedBreathSymbol;
import de.signWritingEditor.shared.model.material.PositionedCheekSymbol;
import de.signWritingEditor.shared.model.material.PositionedEarsSymbol;
import de.signWritingEditor.shared.model.material.PositionedExpressionSymbol;
import de.signWritingEditor.shared.model.material.PositionedEyeSymbol;
import de.signWritingEditor.shared.model.material.PositionedHairSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedJawSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedNeckSymbol;
import de.signWritingEditor.shared.model.material.PositionedNoseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;

public class HeadEditor extends SidebarEditor {
	private static final double ICON_SCALE_FACTOR = 0.75;

	private final SymbolImageUrlService symbolImageUrlService;

	private final HeadEditorListener listener;

	private SelectionTool<PositionedSymbol> selectionTool;

	private VisemeEditor visemeEditor;
	private TabPanel tabPanel;
	private Tab eyeEditorTab;
	private Tab headPostureEditorTab;
	private Tab mouthEditorTab;
	private Tab cheekEditorTab;
	private Tab breathEditorTab;
	private Tab collectionEditorTab;

	private ToolBarButton rotateMouthSymbolCounterClockwiseButton;
	private ToolBarButton rotateMouthSymbolClockwiseButton;
	private ToolBarButton increaseMouthSymbolButton;
	private ToolBarButton decreaseMouthSymbolButton;
	private ToolBarButton mirrorMouthSymbolHorizontalButton;

	private ToolBarButton rotateEyesSymbolCounterClockwiseButton;
	private ToolBarButton rotateEyesSymbolClockwiseButton;
	private ToolBarButton eyesSymbolMirrorButton;
	private ToolBarButton increaseEyesSymbolButton;
	private ToolBarButton decreaseEyesSymbolButton;

	private ToolBarButton rotateHeadPostureClockwiseButton;
	private ToolBarButton rotateHeadPostureCounterClockwiseButton;
	private ToolBarButton increaseHeadPostureButton;
	private ToolBarButton decreaseHeadPostureButton;
	private ToolBarButton mirrorHeadPostureVerticalButton;
	private ToolBarButton mirrorHeadPostureHorizontalButton;
	private ToolBarButton switchToAlternatingArrowsButton;
	private ToolBarButton switchToNormalArrowsButton;

	private ToolBarButton toggleLeftEarButton;
	private ToolBarButton toggleRightEarButton;

	private ToolBarButton increaseNeckButton;
	private ToolBarButton decreaseNeckButton;

	private ToolBarButton rotateJawClockwiseButton;
	private ToolBarButton rotateJawCounterClockwiseButton;

	private HeadSymbolKeyboard cheeksHeadSymbolKeyboard;
	private ToolBarButton toggleLeftCheekButton;
	private ToolBarButton toggleRightCheekButton;
	private boolean leftCheekButtonEnabled;
	private boolean rightCheekButtonEnabled;

	private HeadSymbolKeyboard breathHeadSymbolKeyboard;
	private ToolBarButton toggleLeftBreathButton;
	private ToolBarButton toggleRightBreathButton;
	private boolean leftBreathButtonEnabled;
	private boolean rightBreathButtonEnabled;
	private PositionedSymbolFactory positionedSymbolFactory;

	private Map<Class<? extends PositionedSymbol>, CustomColorChangerPanel> colorChangerPanels;

	public HeadEditor(SymbolImageUrlService symbolImageUrlService, SelectionTool<PositionedSymbol> selectionTool,
			HeadEditorListener listener, PositionedSymbolFactory positionedSymbolFactory) {
		super(I18N.getEditViseme());

		assert listener != null : "Precondition failed: listener != null";
		assert symbolImageUrlService != null : "Precondition failed: symbolImageUrlService != null";
		assert positionedSymbolFactory != null : "Precondition failed: positionedSymbolFactory != null";
		assert selectionTool != null : "Precondition failed: selectionTool != null";

		this.listener = listener;
		this.symbolImageUrlService = symbolImageUrlService;
		this.positionedSymbolFactory = positionedSymbolFactory;
		this.selectionTool = selectionTool;
		this.colorChangerPanels = new HashMap<Class<? extends PositionedSymbol>, CustomColorChangerPanel>();

		addStyleName("headEditor");

		tabPanel = new TabPanel(new TabPanelListener() {
			@Override
			public void onTabSelected(Widget selectedTabContent) {
				handleTabSelected(selectedTabContent);
			}
		});
		addContent(tabPanel);

		createMouthEditTab();
		createEyesEditTab();
		createHeadPostureEditTab();
		createCheeksEditTab();
		createBreathEditTab();
		createCollectionEditTab();
	}

	private Widget createNoseManipulatorPanel() {
		FlowPanel noseSymbolManipulatorPanel = new FlowPanel();
		noseSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		List<Color> colorList = Color.getSkinColor();
		addSymbolColorChangePanel(PositionedNoseSymbol.class, noseSymbolManipulatorPanel, colorList);
		return noseSymbolManipulatorPanel;
	}

	private Widget createExpressionManipulatorPanel() {
		FlowPanel expressionSymbolManipulatorPanel = new FlowPanel();
		expressionSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		List<Color> colorList = Color.getExpressionColors();
		addSymbolColorChangePanel(PositionedExpressionSymbol.class, expressionSymbolManipulatorPanel, colorList);
		return expressionSymbolManipulatorPanel;
	}

	private Widget createHairManipulatorPanel() {
		FlowPanel hairSymbolManipulatorPanel = new FlowPanel();
		hairSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		List<Color> hairColors = Color.getHairColors();
		addSymbolColorChangePanel(PositionedHairSymbol.class, hairSymbolManipulatorPanel, hairColors);
		return hairSymbolManipulatorPanel;
	}

	private Widget createBreathManipulatorPanel() {
		FlowPanel breathSymbolManipulatorPanel = new FlowPanel();
		breathSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		toggleLeftBreathButton = new ToolBarButton(new Image(RESOURCE.getIconToggleLeftBreathSymbol()),
				new Image(RESOURCE.getIconToggleLeftBreathSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						enableLeftBreathHeadSymbolButton(!leftBreathButtonEnabled);
					}
				});
		toggleRightBreathButton = new ToolBarButton(new Image(RESOURCE.getIconToggleRightBreathSymbol()),
				new Image(RESOURCE.getIconToggleRightBreathSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						enableRightBreathHeadSymbolButton(!rightBreathButtonEnabled);
					}
				});

		List<Color> breathColors = Color.getBreathColors();
		breathSymbolManipulatorPanel.add(toggleLeftBreathButton);
		breathSymbolManipulatorPanel.add(toggleRightBreathButton);
		addSymbolColorChangePanel(PositionedBreathSymbol.class, breathSymbolManipulatorPanel, breathColors);

		return breathSymbolManipulatorPanel;
	}

	private Widget createCheekManipulatorPanel() {
		FlowPanel cheekSymbolManipulatorPanel = new FlowPanel();
		cheekSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		toggleLeftCheekButton = new ToolBarButton(new Image(RESOURCE.getIconToggleLeftCheekSymbol()),
				new Image(RESOURCE.getIconToggleLeftCheekSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						enableLeftCheekHeadSymbolButton(!leftCheekButtonEnabled);
					}
				});
		toggleRightCheekButton = new ToolBarButton(new Image(RESOURCE.getIconToggleRightCheekSymbol()),
				new Image(RESOURCE.getIconToggleRightCheekSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						enableRightCheekHeadSymbolButton(!rightCheekButtonEnabled);
					}
				});

		cheekSymbolManipulatorPanel.add(toggleLeftCheekButton);
		cheekSymbolManipulatorPanel.add(toggleRightCheekButton);
		List<Color> cheekColors = Color.getCheekColors();
		addSymbolColorChangePanel(PositionedCheekSymbol.class, cheekSymbolManipulatorPanel, cheekColors);

		return cheekSymbolManipulatorPanel;
	}

	private Widget createMouthSymbolManipulatorPanel() {
		FlowPanel mouthSymbolManipulatorPanel = new FlowPanel();
		mouthSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		rotateMouthSymbolCounterClockwiseButton = new ToolBarButton(
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateMouthSymbolCounterClockwise();
					}
				});
		mouthSymbolManipulatorPanel.add(rotateMouthSymbolCounterClockwiseButton);
		rotateMouthSymbolCounterClockwiseButton.setEnabled(false);

		rotateMouthSymbolClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateMouthSymbolClockwise();
					}
				});
		mouthSymbolManipulatorPanel.add(rotateMouthSymbolClockwiseButton);
		rotateMouthSymbolClockwiseButton.setEnabled(false);

		increaseMouthSymbolButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseSymbol()),
				new Image(RESOURCE.getIconIncreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onIncreaseMouthSymbol();
					}
				});
		mouthSymbolManipulatorPanel.add(increaseMouthSymbolButton);
		increaseMouthSymbolButton.setEnabled(false);

		decreaseMouthSymbolButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseSymbol()),
				new Image(RESOURCE.getIconDecreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onDecreaseMouthSymbol();
					}
				});
		mouthSymbolManipulatorPanel.add(decreaseMouthSymbolButton);
		decreaseMouthSymbolButton.setEnabled(false);

		mirrorMouthSymbolHorizontalButton = new ToolBarButton(new Image(RESOURCE.getIconSymbolMirrorVertically()),
				new Image(RESOURCE.getIconSymbolMirrorVerticallyDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onMirrorMouthSymbolHorizontally();
					}
				});
		mouthSymbolManipulatorPanel.add(mirrorMouthSymbolHorizontalButton);
		mirrorMouthSymbolHorizontalButton.setEnabled(false);

		List<Color> list = Color.getMouthColors();
		addSymbolColorChangePanel(PositionedMouthSymbol.class, mouthSymbolManipulatorPanel, list);

		return mouthSymbolManipulatorPanel;
	}

	private Widget createHeadPostureManipulationPanel() {
		FlowPanel headPostureManipulatorPanel = new FlowPanel();
		headPostureManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		rotateHeadPostureClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateHeadPostureClockwise();
					}
				});
		headPostureManipulatorPanel.add(rotateHeadPostureClockwiseButton);
		rotateHeadPostureClockwiseButton.setEnabled(false);

		switchToAlternatingArrowsButton = new ToolBarButton(
				new Image(RESOURCE.getIconSwitchToAlternatingArrowsSymbol()),
				new Image(RESOURCE.getIconSwitchToAlternatingArrowsSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onSwitchHeadPostureSymbolToAlternatingArrows();
					}
				});
		headPostureManipulatorPanel.add(switchToAlternatingArrowsButton);
		switchToAlternatingArrowsButton.setEnabled(false);

		switchToNormalArrowsButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchToNormalArrowsSymbol()),
				new Image(RESOURCE.getIconSwitchToNormalArrowsSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onSwitchHeadPostureSymbolToNormalArrows();
					}
				});
		headPostureManipulatorPanel.add(switchToNormalArrowsButton);
		switchToNormalArrowsButton.setEnabled(false);

		rotateHeadPostureCounterClockwiseButton = new ToolBarButton(
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotatHeadPostureCounterClockwise();
					}
				});
		headPostureManipulatorPanel.add(rotateHeadPostureCounterClockwiseButton);
		rotateHeadPostureCounterClockwiseButton.setEnabled(false);

		increaseHeadPostureButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseSymbol()),
				new Image(RESOURCE.getIconIncreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onIncreaseHeadPosture();
					}
				});
		headPostureManipulatorPanel.add(increaseHeadPostureButton);
		increaseHeadPostureButton.setEnabled(false);

		decreaseHeadPostureButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseSymbol()),
				new Image(RESOURCE.getIconDecreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onDecreaseHeadPosture();
					}
				});
		headPostureManipulatorPanel.add(decreaseHeadPostureButton);
		decreaseHeadPostureButton.setEnabled(false);

		mirrorHeadPostureVerticalButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolMirror()),
				new Image(RESOURCE.getIconHandSymbolMirrorDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onMirrorHeadPostureVertical();
					}
				});
		headPostureManipulatorPanel.add(mirrorHeadPostureVerticalButton);

		mirrorHeadPostureVerticalButton.setEnabled(false);
		mirrorHeadPostureHorizontalButton = new ToolBarButton(new Image(RESOURCE.getIconSymbolMirrorVertically()),
				new Image(RESOURCE.getIconSymbolMirrorVerticallyDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onMirrorHeadPostureHorizontal();
					}
				});
		headPostureManipulatorPanel.add(mirrorHeadPostureHorizontalButton);
		mirrorHeadPostureHorizontalButton.setEnabled(false);
		List<Color> skinColor = Color.getSkinColor();
		addSymbolColorChangePanel(PositionedHeadPostureSymbol.class, headPostureManipulatorPanel, skinColor);

		return headPostureManipulatorPanel;
	}

	private Widget createEarsManipulatorPanel() {
		FlowPanel earsManipulatorPanel = new FlowPanel();
		earsManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		toggleLeftEarButton = new ToolBarButton(new Image(RESOURCE.getIconToggleLeftEarSymbol()),
				new Image(RESOURCE.getIconToggleLeftEarSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onToggleLeftEarButton();
					}
				});
		earsManipulatorPanel.add(toggleLeftEarButton);

		toggleRightEarButton = new ToolBarButton(new Image(RESOURCE.getIconToggleRightEarSymbol()),
				new Image(RESOURCE.getIconToggleRightEarSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onToggleRightEarButton();
					}
				});
		earsManipulatorPanel.add(toggleRightEarButton);
		List<Color> skinColor = Color.getSkinColor();
		addSymbolColorChangePanel(PositionedEarsSymbol.class, earsManipulatorPanel, skinColor);

		return earsManipulatorPanel;
	}

	private Widget createNeckManipulatorPanel() {
		FlowPanel neckManipulatorPanel = new FlowPanel();
		neckManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		increaseNeckButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseSymbol()),
				new Image(RESOURCE.getIconIncreaseSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onIncreaseNeckButton();
					}
				});
		neckManipulatorPanel.add(increaseNeckButton);
		decreaseNeckButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseSymbol()),
				new Image(RESOURCE.getIconDecreaseSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onDecreaseNeckButton();
					}
				});
		neckManipulatorPanel.add(decreaseNeckButton);
		List<Color> skinColor = Color.getSkinColor();
		addSymbolColorChangePanel(PositionedNeckSymbol.class, neckManipulatorPanel, skinColor);

		return neckManipulatorPanel;
	}

	private Widget createJawManipulatorPanel() {
		FlowPanel jawManipulatorPanel = new FlowPanel();
		jawManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		rotateJawClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateJawClockwiseButton();
					}
				});
		jawManipulatorPanel.add(rotateJawClockwiseButton);

		rotateJawCounterClockwiseButton = new ToolBarButton(
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateJawCounterClockwiseButton();
					}
				});
		jawManipulatorPanel.add(rotateJawCounterClockwiseButton);
		List<Color> skinColor = Color.getSkinColor();
		addSymbolColorChangePanel(PositionedJawSymbol.class, jawManipulatorPanel, skinColor);

		return jawManipulatorPanel;
	}

	private Widget createEyesSymbolManipulatorPanel() {
		FlowPanel eyesSymbolManipulatorPanel = new FlowPanel();
		eyesSymbolManipulatorPanel.setStyleName("headComponentManipulatorPanel");

		rotateEyesSymbolCounterClockwiseButton = new ToolBarButton(
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateEyesSymbolCounterClockwise();
					}
				});
		eyesSymbolManipulatorPanel.add(rotateEyesSymbolCounterClockwiseButton);
		rotateEyesSymbolCounterClockwiseButton.setEnabled(false);

		rotateEyesSymbolClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRotateEyesSymbolClockwise();
					}
				});
		eyesSymbolManipulatorPanel.add(rotateEyesSymbolClockwiseButton);
		rotateEyesSymbolClockwiseButton.setEnabled(false);

		decreaseEyesSymbolButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseSymbol()),
				new Image(RESOURCE.getIconDecreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onDecreaseEyeSymbols();
					}
				});
		eyesSymbolManipulatorPanel.add(decreaseEyesSymbolButton);
		decreaseEyesSymbolButton.setEnabled(false);

		increaseEyesSymbolButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseSymbol()),
				new Image(RESOURCE.getIconIncreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onIncreaseEyeSymbols();
					}
				});
		eyesSymbolManipulatorPanel.add(increaseEyesSymbolButton);
		increaseEyesSymbolButton.setEnabled(false);

		eyesSymbolMirrorButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolMirror()),
				new Image(RESOURCE.getIconHandSymbolMirrorDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						listener.onMirrorEyesSymbol();
					}
				});
		eyesSymbolManipulatorPanel.add(eyesSymbolMirrorButton);
		eyesSymbolMirrorButton.setEnabled(false);
		List<Color> eyeColors = Color.getEyeColors();
		addSymbolColorChangePanel(PositionedEyeSymbol.class, eyesSymbolManipulatorPanel, eyeColors);

		return eyesSymbolManipulatorPanel;
	}

	@Override
	public void updateSidebar() {

		boolean enableMouthSymbolRotateButtons = true;
		boolean enableMouthSymbolIncreaseButton = true;
		boolean enableMouthSymbolDecreaseButton = true;
		boolean enableMirrorHorizontalSymbolButton = true;
		boolean enableEyesSymbolRotateButtons = true;
		boolean enableEyesSymbolMirrorButton = true;
		boolean enableEyesSymbolDecreaseButton = true;
		boolean enableEyesSymbolIncreaseButton = true;
		boolean enableHeadPostureRotateButtons = true;
		boolean enableHeadPostureIncreaseButton = true;
		boolean enableHeadPostureDecreaseButton = true;
		boolean enableHeadPostureMirrorVerticalButton = true;
		boolean enableHeadPostureMirrorHorizontalButton = true;
		boolean enableHeadPostureSwitchToAlternatingArrowsButton = true;
		boolean enableHeadPostureSwitchToNormalArrowsButton = true;
		boolean enableToggleLeftCheekButton = true;
		boolean enableToggleRightCheekButton = true;
		boolean enableToggleLeftEarButton = true;
		boolean enableToggleRightEarButton = true;
		boolean enableToggleRightBreathButton = true;
		boolean enableToggleLeftBreathButton = true;
		boolean enableIncreaseNeckButton = true;
		boolean enableDecreaseNeckButton = true;
		boolean enableJawRotateButtons = true;
		boolean showColorChangerForMouth = false;
		boolean showColorChangerForEyes = false;
		boolean showColorChangerForCheeks = false;
		boolean showColorChangerForBreath = false;
		boolean showColorChangerForHair = false;
		boolean showColorChangerForExpression = false;
		boolean showColorChangerForNose = false;
		boolean showColorChangerForNeck = false;
		boolean showColorChangerForEars = false;
		boolean showColorChangerForJaw = false;

		for (PositionedSymbol positionableSymbol : selectionTool.getSelectedItems()) {
			if (positionableSymbol instanceof HeadSymbol) {
				HeadSymbol headSymbol = (HeadSymbol) positionableSymbol;
				if (headSymbol.hasMouth()) {
					showColorChangerForMouth = true;
					showCorrectColorForSymbol(PositionedMouthSymbol.class,
							headSymbol.getPositionedMouthSymbol().getLineColor(),
							headSymbol.getPositionedMouthSymbol().getFillColor());
					enableMouthSymbolRotateButtons = enableMouthSymbolRotateButtons
							&& headSymbol.getPositionedMouthSymbol().canRotate();
					enableMouthSymbolIncreaseButton = enableMouthSymbolIncreaseButton
							&& headSymbol.getPositionedMouthSymbol().canIncrease();
					enableMouthSymbolDecreaseButton = enableMouthSymbolDecreaseButton
							&& headSymbol.getPositionedMouthSymbol().canDecrease();
					enableMirrorHorizontalSymbolButton = enableMirrorHorizontalSymbolButton
							&& headSymbol.getPositionedMouthSymbol().canMirror();
				} else {
					enableMouthSymbolRotateButtons = false;
					enableMouthSymbolIncreaseButton = false;
					enableMouthSymbolDecreaseButton = false;
					enableMirrorHorizontalSymbolButton = false;
				}

				if (headSymbol.hasEyes()) {
					showColorChangerForEyes = true;
					showCorrectColorForSymbol(PositionedEyeSymbol.class,
							headSymbol.getPositionedEyeSymbols().get(0).getLineColor(),
							headSymbol.getPositionedEyeSymbols().get(0).getFillColor());
					for (PositionedEyeSymbol positionedEyesSymbol : headSymbol.getPositionedEyeSymbols()) {
						enableEyesSymbolRotateButtons = enableEyesSymbolRotateButtons
								&& positionedEyesSymbol.canRotate();
						enableEyesSymbolMirrorButton = enableEyesSymbolMirrorButton
								&& positionedEyesSymbol.canMirrorVertically();
						enableEyesSymbolDecreaseButton = enableEyesSymbolDecreaseButton
								&& positionedEyesSymbol.canDecrease();
						enableEyesSymbolIncreaseButton = enableEyesSymbolIncreaseButton
								&& positionedEyesSymbol.canIncrease();
					}
				} else {
					enableEyesSymbolRotateButtons = false;
					enableEyesSymbolMirrorButton = false;
					enableEyesSymbolDecreaseButton = false;
					enableEyesSymbolIncreaseButton = false;
				}

				if (headSymbol.hasHeadPosture()) {
					enableHeadPostureRotateButtons = enableHeadPostureRotateButtons
							&& headSymbol.getPositionedHeadPostureSymbol().canRotate();
					enableHeadPostureIncreaseButton = enableHeadPostureIncreaseButton
							&& headSymbol.getPositionedHeadPostureSymbol().canIncrease();
					enableHeadPostureDecreaseButton = enableHeadPostureDecreaseButton
							&& headSymbol.getPositionedHeadPostureSymbol().canDecrease();
					enableHeadPostureMirrorVerticalButton = enableHeadPostureMirrorVerticalButton
							&& headSymbol.getPositionedHeadPostureSymbol().canMirrorVertically();
					enableHeadPostureMirrorHorizontalButton = enableHeadPostureMirrorHorizontalButton
							&& headSymbol.getPositionedHeadPostureSymbol().canMirror();
					enableHeadPostureSwitchToAlternatingArrowsButton = enableHeadPostureSwitchToAlternatingArrowsButton
							&& headSymbol.getPositionedHeadPostureSymbol().canSwitchToAlternatingArrows();
					enableHeadPostureSwitchToNormalArrowsButton = enableHeadPostureSwitchToNormalArrowsButton
							&& headSymbol.getPositionedHeadPostureSymbol().canSwitchToNormalArrows();
					showCorrectColorForSymbol(PositionedHeadPostureSymbol.class,
							headSymbol.getPositionedHeadPostureSymbol().getLineColor(),
							headSymbol.getPositionedHeadPostureSymbol().getFillColor());
				} else {
					enableHeadPostureRotateButtons = false;
					enableHeadPostureIncreaseButton = false;
					enableHeadPostureDecreaseButton = false;
					enableHeadPostureMirrorVerticalButton = false;
					enableHeadPostureMirrorHorizontalButton = false;
					enableHeadPostureSwitchToAlternatingArrowsButton = false;
					enableHeadPostureSwitchToNormalArrowsButton = false;
				}

				if (!headSymbol.hasCheeks()) {
					enableToggleLeftCheekButton = false;
					enableToggleRightCheekButton = false;
				} else {
					showColorChangerForCheeks = true;
					showCorrectColorForSymbol(PositionedCheekSymbol.class,
							headSymbol.getPositionedCheekSymbols().get(0).getLineColor(),
							headSymbol.getPositionedCheekSymbols().get(0).getFillColor());
				}

				if (!headSymbol.hasEars()) {
					enableToggleLeftEarButton = false;
					enableToggleRightEarButton = false;
				} else {
					showColorChangerForEars = true;
					showCorrectColorForSymbol(PositionedEarsSymbol.class,
							headSymbol.getPositionedEarSymbols().get(0).getLineColor(),
							headSymbol.getPositionedEarSymbols().get(0).getFillColor());
				}

				if (!headSymbol.hasBreath()) {
					enableToggleRightBreathButton = false;
					enableToggleLeftBreathButton = false;
				} else {
					showColorChangerForBreath = true;
					showCorrectColorForSymbol(PositionedBreathSymbol.class,
							headSymbol.getPositionedBreathSymbols().get(0).getLineColor(),
							headSymbol.getPositionedBreathSymbols().get(0).getFillColor());
				}

				if (headSymbol.hasNeck()) {
					showColorChangerForNeck = true;
					showCorrectColorForSymbol(PositionedNeckSymbol.class,
							headSymbol.getPositionedNeckSymbol().getLineColor(),
							headSymbol.getPositionedNeckSymbol().getFillColor());
				}

				if (!headSymbol.hasNeck() || !headSymbol.getPositionedNeckSymbol().canIncrease()) {
					enableIncreaseNeckButton = false;
				}

				if (!headSymbol.hasNeck() || !headSymbol.getPositionedNeckSymbol().canDecrease()) {
					enableDecreaseNeckButton = false;
				}

				if (headSymbol.hasJaw()) {
					showColorChangerForJaw = true;
					showCorrectColorForSymbol(PositionedJawSymbol.class,
							headSymbol.getPositionedJawSymbols().get(0).getLineColor(),
							headSymbol.getPositionedJawSymbols().get(0).getFillColor());
					for (PositionedJawSymbol jawSymbol : headSymbol.getPositionedJawSymbols()) {
						enableJawRotateButtons = enableJawRotateButtons && jawSymbol.canRotate();
					}
				} else {
					enableJawRotateButtons = false;
				}

				if (headSymbol.hasHair()) {
					showColorChangerForHair = true;
					showCorrectColorForSymbol(PositionedHairSymbol.class,
							headSymbol.getPositionedHairSymbol().getLineColor(),
							headSymbol.getPositionedHairSymbol().getFillColor());
				}

				if (headSymbol.hasExpression()) {
					showColorChangerForExpression = true;
					showCorrectColorForSymbol(PositionedExpressionSymbol.class,
							headSymbol.getPositionedExpressionSymbol().getLineColor(),
							headSymbol.getPositionedExpressionSymbol().getFillColor());
				}

				if (headSymbol.hasNose()) {
					showColorChangerForNose = true;
					showCorrectColorForSymbol(PositionedNoseSymbol.class,
							headSymbol.getPositionedNoseSymbol().getLineColor(),
							headSymbol.getPositionedNoseSymbol().getFillColor());
				}
			}

		}

		enableMouthSymbolRotateButtons(enableMouthSymbolRotateButtons);
		enableMouthSymbolIncreaseButton(enableMouthSymbolIncreaseButton);
		enableMouthSymbolDecreaseButton(enableMouthSymbolDecreaseButton);
		enableMirrorHorizontalSymbolButton(enableMirrorHorizontalSymbolButton);
		enableEyesSymbolRotateButtons(enableEyesSymbolRotateButtons);
		enableEyesSymbolMirrorButton(enableEyesSymbolMirrorButton);
		enableEyesSymbolDecreaseButton(enableEyesSymbolDecreaseButton);
		enableEyesSymbolIncreaseButton(enableEyesSymbolIncreaseButton);
		enableHeadPostureRotateButtons(enableHeadPostureRotateButtons);
		enableHeadPostureIncreaseButton(enableHeadPostureIncreaseButton);
		enableHeadPostureDecreaseButton(enableHeadPostureDecreaseButton);
		enableHeadPostureMirrorVerticalButton(enableHeadPostureMirrorVerticalButton);
		enableHeadPostureMirrorHorizontalButton(enableHeadPostureMirrorHorizontalButton);
		enableHeadPostureSwitchToAlternatingArrowsButton(enableHeadPostureSwitchToAlternatingArrowsButton);
		enableHeadPostureSwitchToNormalArrowsButton(enableHeadPostureSwitchToNormalArrowsButton);
		enableToggleLeftCheekButton(enableToggleLeftCheekButton);
		enableToggleRightCheekButton(enableToggleRightCheekButton);
		enableToggleLeftEarButton(enableToggleLeftEarButton);
		enableToggleRightEarButton(enableToggleRightEarButton);
		enableToggleRightBreathButton(enableToggleRightBreathButton);
		enableToggleLeftBreathButton(enableToggleLeftBreathButton);
		enableIncreaseNeckButton(enableIncreaseNeckButton);
		enableDecreaseNeckButton(enableDecreaseNeckButton);
		enableJawRotateButtons(enableJawRotateButtons);
		enableColorChangerForHeadSymbol(showColorChangerForMouth, showColorChangerForEyes, showColorChangerForCheeks,
				showColorChangerForBreath, showColorChangerForHair, showColorChangerForExpression,
				showColorChangerForNose, showColorChangerForNeck, showColorChangerForEars, showColorChangerForJaw);
	}

	private void handleTabSelected(Widget selectedTabContent) {
		assert selectedTabContent != null : "Precondition failed: selectedTabContent != null";

		if (selectedTabContent == mouthEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditViseme());
		} else if (selectedTabContent == eyeEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditEyes());
		} else if (selectedTabContent == headPostureEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditHead());
		} else if (selectedTabContent == cheekEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditCheeks());
		} else if (selectedTabContent == breathEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditBreath());
		} else if (selectedTabContent == collectionEditorTab.getTabContent()) {
			setHeaderLabelText(I18N.getEditCollection());
		}
	}

	public VisemeEditor getVisemeEditor() {
		return visemeEditor;
	}

	public void enableMouthSymbolRotateButtons(boolean enable) {
		rotateMouthSymbolClockwiseButton.setEnabled(enable);
		rotateMouthSymbolCounterClockwiseButton.setEnabled(enable);
	}

	public void enableHeadPostureRotateButtons(boolean enable) {
		rotateHeadPostureClockwiseButton.setEnabled(enable);
		rotateHeadPostureCounterClockwiseButton.setEnabled(enable);
	}

	public void enableJawRotateButtons(boolean enable) {
		rotateJawClockwiseButton.setEnabled(enable);
		rotateJawCounterClockwiseButton.setEnabled(enable);
	}

	public void enableHeadPostureSwitchToAlternatingArrowsButton(boolean enable) {
		switchToAlternatingArrowsButton.setEnabled(enable);
	}

	public void enableHeadPostureSwitchToNormalArrowsButton(boolean enable) {
		switchToNormalArrowsButton.setEnabled(enable);
	}

	public void enableEyesSymbolRotateButtons(boolean enable) {
		rotateEyesSymbolClockwiseButton.setEnabled(enable);
		rotateEyesSymbolCounterClockwiseButton.setEnabled(enable);
	}

	public void enableEyesSymbolMirrorButton(boolean enable) {
		eyesSymbolMirrorButton.setEnabled(enable);
	}

	public void enableMouthSymbolIncreaseButton(boolean enable) {
		increaseMouthSymbolButton.setEnabled(enable);
	}

	public void enableEyesSymbolIncreaseButton(boolean enable) {
		increaseEyesSymbolButton.setEnabled(enable);
	}

	public void enableHeadPostureIncreaseButton(boolean enable) {
		increaseHeadPostureButton.setEnabled(enable);
	}

	public void enableMouthSymbolDecreaseButton(boolean enable) {
		decreaseMouthSymbolButton.setEnabled(enable);
	}

	public void enableEyesSymbolDecreaseButton(boolean enable) {
		decreaseEyesSymbolButton.setEnabled(enable);
	}

	public void enableHeadPostureDecreaseButton(boolean enable) {
		decreaseHeadPostureButton.setEnabled(enable);
	}

	public void enableHeadPostureMirrorVerticalButton(boolean enable) {
		mirrorHeadPostureVerticalButton.setEnabled(enable);
	}

	public void enableHeadPostureMirrorHorizontalButton(boolean enable) {
		mirrorHeadPostureHorizontalButton.setEnabled(enable);
	}

	public void enableMirrorHorizontalSymbolButton(boolean enable) {
		mirrorMouthSymbolHorizontalButton.setEnabled(enable);
	}

	public void enableIncreaseNeckButton(boolean enable) {
		increaseNeckButton.setEnabled(enable);
	}

	public void enableDecreaseNeckButton(boolean enable) {
		decreaseNeckButton.setEnabled(enable);
	}

	public void enableToggleLeftEarButton(boolean enable) {
		toggleLeftEarButton.setEnabled(enable);
	}

	public void enableToggleRightEarButton(boolean enable) {
		toggleRightEarButton.setEnabled(enable);
	}

	public void enableToggleLeftCheekButton(boolean enable) {
		toggleLeftCheekButton.setEnabled(enable);
	}

	public void enableToggleRightCheekButton(boolean enable) {
		toggleRightCheekButton.setEnabled(enable);
	}

	public void enableToggleLeftBreathButton(boolean enable) {
		toggleLeftBreathButton.setEnabled(enable);
	}

	public void enableToggleRightBreathButton(boolean enable) {
		toggleRightBreathButton.setEnabled(enable);
	}

	private void enableLeftBreathHeadSymbolButton(boolean enable) {
		if (!enable) {
			leftBreathButtonEnabled = enable;
			listener.onLeftBreathStatusChanged(enable);
		} else {
			leftBreathButtonEnabled = enable;
			listener.onLeftBreathStatusChanged(enable);
		}
	}

	private void enableRightBreathHeadSymbolButton(boolean enable) {
		if (!enable) {
			rightBreathButtonEnabled = enable;
			listener.onRightBreathStatusChanged(enable);
		} else {
			rightBreathButtonEnabled = enable;
			listener.onRightBreathStatusChanged(enable);
		}
	}

	private void enableLeftCheekHeadSymbolButton(boolean enable) {
		if (!enable) {
			leftCheekButtonEnabled = enable;
			listener.onLeftCheekStatusChanged(enable);
		} else {
			leftCheekButtonEnabled = enable;
			listener.onLeftCheekStatusChanged(enable);
		}
	}

	private void enableRightCheekHeadSymbolButton(boolean enable) {
		if (!enable) {
			rightCheekButtonEnabled = enable;
			listener.onRightCheekStatusChanged(enable);
		} else {
			rightCheekButtonEnabled = enable;
			listener.onRightCheekStatusChanged(enable);
		}
	}

	private void showCorrectColorForSymbol(Class<? extends PositionedSymbol> clasz, Color symbolColorForFormerBlack,
			Color symbolColorForFormerWhite) {
		if (colorChangerPanels.get(clasz) != null) {
			colorChangerPanels.get(clasz).setCorrectColors(symbolColorForFormerBlack, symbolColorForFormerWhite);
		}
	}

	private void enableColorChangerForHeadSymbol(boolean showColorChangerForMouth, boolean showColorChangerForEyes,
			boolean showColorChangerForCheeks, boolean showColorChangerForBreath, boolean showColorChangerForHair,
			boolean showColorChangerForExpression, boolean showColorChangerForNose, boolean showColorChangerForNeck,
			boolean showColorChangerForEars, boolean showColorChangerForJaw) {

		if (colorChangerPanels.get(PositionedMouthSymbol.class) != null) {
			colorChangerPanels.get(PositionedMouthSymbol.class).setEnabled(showColorChangerForMouth);
		}
		if (colorChangerPanels.get(PositionedEyeSymbol.class) != null) {
			colorChangerPanels.get(PositionedEyeSymbol.class).setEnabled(showColorChangerForEyes);
		}
		if (colorChangerPanels.get(PositionedCheekSymbol.class) != null) {
			colorChangerPanels.get(PositionedCheekSymbol.class).setEnabled(showColorChangerForCheeks);
		}
		if (colorChangerPanels.get(PositionedBreathSymbol.class) != null) {
			colorChangerPanels.get(PositionedBreathSymbol.class).setEnabled(showColorChangerForBreath);
		}
		if (colorChangerPanels.get(PositionedHairSymbol.class) != null) {
			colorChangerPanels.get(PositionedHairSymbol.class).setEnabled(showColorChangerForHair);
		}
		if (colorChangerPanels.get(PositionedExpressionSymbol.class) != null) {
			colorChangerPanels.get(PositionedExpressionSymbol.class).setEnabled(showColorChangerForExpression);
		}
		if (colorChangerPanels.get(PositionedNoseSymbol.class) != null) {
			colorChangerPanels.get(PositionedNoseSymbol.class).setEnabled(showColorChangerForNose);
		}
		if (colorChangerPanels.get(PositionedNeckSymbol.class) != null) {
			colorChangerPanels.get(PositionedNeckSymbol.class).setEnabled(showColorChangerForNeck);
		}
		if (colorChangerPanels.get(PositionedEarsSymbol.class) != null) {
			colorChangerPanels.get(PositionedEarsSymbol.class).setEnabled(showColorChangerForEars);
		}
		if (colorChangerPanels.get(PositionedJawSymbol.class) != null) {
			colorChangerPanels.get(PositionedJawSymbol.class).setEnabled(showColorChangerForJaw);
		}
	}

	private void createMouthEditTab() {
		Image visemeEditorIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory.createHeadSymbol(
						positionedSymbolFactory.createPositionedSymbol(MouthBaseSymbol.TEETH.getIswaSymbol())),
				ICON_SCALE_FACTOR, true));

		FlowPanel mouthEditorFlowPanel = new FlowPanel();

		HeadSymbolKeyboard mouthEditor = new HeadSymbolKeyboard(symbolImageUrlService, false);
		mouthEditor.addStyleName("mouthSymbolEditor");
		mouthEditorFlowPanel.add(createMouthSymbolManipulatorPanel());
		mouthEditorFlowPanel.add(mouthEditor);

		mouthEditorTab = new Tab(visemeEditorIcon, mouthEditorFlowPanel);
		tabPanel.addTab(mouthEditorTab);

		for (final MouthBaseSymbol mouthBaseSymbol : MouthBaseSymbol.values()) {

			if (!mouthBaseSymbol.equals(MouthBaseSymbol.WHITESPACE)) {
				final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(
						positionedSymbolFactory.createPositionedSymbol(mouthBaseSymbol.getIswaSymbol()));

				mouthEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onMouthSymbolChanged(headSymbol.getPositionedMouthSymbol().clone());
					}
				});

				if (mouthBaseSymbol.equals(MouthBaseSymbol.TONGUE_CENTER_STICKS_OUT)) {

					final HeadSymbol extraHeadSymbol = positionedSymbolFactory.createHeadSymbol(
							positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 3, 1, 5, 1, 20, 10)));
					mouthEditor.addHeadSymbol(extraHeadSymbol, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onMouthSymbolChanged(extraHeadSymbol.getPositionedMouthSymbol().clone());
						}
					});

					final HeadSymbol extraHeadSymbol2 = positionedSymbolFactory.createHeadSymbol(
							positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 3, 1, 6, 1, 21, 15)));
					mouthEditor.addHeadSymbol(extraHeadSymbol2, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onMouthSymbolChanged(extraHeadSymbol2.getPositionedMouthSymbol().clone());
						}
					});

				}
			}
		}
	}

	private void createEyesEditTab() {
		PositionedSymbol leftEye = positionedSymbolFactory.createPositionedSymbol(
				EyesBaseSymbol.getLeftEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()), Location.LEFT);
		PositionedSymbol rightEye = positionedSymbolFactory.createPositionedSymbol(
				EyesBaseSymbol.getRightEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()), Location.RIGHT);

		Image eyesIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory.createHeadSymbol(leftEye, rightEye), ICON_SCALE_FACTOR, true));

		// Important do not reuse icons for tabs!!!!
		Image bothEyesIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory.createHeadSymbol(leftEye, rightEye), ICON_SCALE_FACTOR, true));

		Image leftEyesIcon = new Image(symbolImageUrlService
				.getHeadSymbolImageUrl(positionedSymbolFactory.createHeadSymbol(leftEye), ICON_SCALE_FACTOR, true));

		Image rightEyesIcon = new Image(symbolImageUrlService
				.getHeadSymbolImageUrl(positionedSymbolFactory.createHeadSymbol(rightEye), ICON_SCALE_FACTOR, true));

		FlowPanel eyesEditorFlowPanel = new FlowPanel();

		eyesEditorFlowPanel.add(createEyesSymbolManipulatorPanel());

		TabPanel eyeEditorTabPanel = new TabPanel(new TabPanelListener() {

			@Override
			public void onTabSelected(Widget selectedTabContent) {
				

			}
		});

		eyesEditorFlowPanel.add(eyeEditorTabPanel);
		eyeEditorTab = new Tab(eyesIcon, eyesEditorFlowPanel);
		tabPanel.addTab(eyeEditorTab);

		HeadSymbolKeyboard bothEyeEditorKeybord = new HeadSymbolKeyboard(symbolImageUrlService, false);
		HeadSymbolKeyboard leftEyeEditorKeybord = new HeadSymbolKeyboard(symbolImageUrlService, false);
		HeadSymbolKeyboard rightEyeEditorKeybord = new HeadSymbolKeyboard(symbolImageUrlService, false);

		bothEyeEditorKeybord.addStyleName("eyeSymbolEditor");
		rightEyeEditorKeybord.addStyleName("eyeSymbolEditor");
		leftEyeEditorKeybord.addStyleName("eyeSymbolEditor");

		createBothEyesSymbolKeyboard(bothEyeEditorKeybord);
		createLeftEyesSymbolKeyboard(leftEyeEditorKeybord);
		createRightEyesSymbolKeyboard(rightEyeEditorKeybord);

		eyeEditorTabPanel.addTab(new Tab(bothEyesIcon, bothEyeEditorKeybord));
		eyeEditorTabPanel.addTab(new Tab(leftEyesIcon, leftEyeEditorKeybord));
		eyeEditorTabPanel.addTab(new Tab(rightEyesIcon, rightEyeEditorKeybord));

	}

	private void createBothEyesSymbolKeyboard(HeadSymbolKeyboard bothEyeEditorKeybord) {
		for (final EyesBaseSymbol eyeSymbol : EyesBaseSymbol.values()) {

			List<PositionedSymbol> eyes = new ArrayList<PositionedSymbol>();

			if (eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_CONTACT) || eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_NEUTRAL)
					|| eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_WRINKLED)) {
				eyes.add(positionedSymbolFactory.createPositionedSymbol(eyeSymbol.getIswaSymbol(), Location.BOTH));
			} else if (eyeSymbol.equals(EyesBaseSymbol.EYE_BLINK_SINGLE)
					|| eyeSymbol.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE)) {
				// These are two eyes that need the EYES_OPEN Symbol
				// additionally
				eyes.addAll(PositionedEyeSymbol.convertToValidEyeSymbols(eyeSymbol.getIswaSymbol()));
			} else {
				eyes.add(positionedSymbolFactory.createPositionedSymbol(
						EyesBaseSymbol.getLeftEyeFor(eyeSymbol.getIswaSymbol()), Location.LEFT));
				eyes.add(positionedSymbolFactory.createPositionedSymbol(
						EyesBaseSymbol.getRightEyeFor(eyeSymbol.getIswaSymbol()), Location.RIGHT));
			}
			final HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(eyes.toArray(new PositionedSymbol[eyes.size()]));

			bothEyeEditorKeybord.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					List<PositionedEyeSymbol> newPositionedEyesSymbol = clonePositionedSymbols(
							headSymbol.getPositionedEyeSymbols());
					listener.onEyeSymbolChanged(newPositionedEyesSymbol);
				}

			});
		}
	}

	// Clone a List containing Positioned Symbols
	@SuppressWarnings("unchecked")
	private <T extends PositionedSymbol> List<T> clonePositionedSymbols(List<T> positionedEyesSymbol) {
		List<T> newPositionedEyesSymbol = new ArrayList<T>();
		for (T positionedSymbol : positionedEyesSymbol) {
			newPositionedEyesSymbol.add((T) positionedSymbol.clone());
		}
		return newPositionedEyesSymbol;
	}

	private List<PositionedSymbol> createSpecialEyeSymbol(final Symbol lowerEyeSymbol, final Symbol upperEyeSymbol,
			Location location) {
		int symbolDistance = 6;
		List<PositionedSymbol> result = new ArrayList<PositionedSymbol>();

		result.add(positionedSymbolFactory.createPositionedSymbol(upperEyeSymbol, location, 0, symbolDistance / 2, 0));
		result.add(positionedSymbolFactory.createPositionedSymbol(lowerEyeSymbol, location, 0, -symbolDistance / 2, 0));

		return result;
	}

	private void createLeftEyesSymbolKeyboard(HeadSymbolKeyboard leftEyeEditorKeybord) {
		for (EyesBaseSymbol eyeSymbol : EyesBaseSymbol.values()) {
			boolean enabled = true;
			List<PositionedSymbol> eyeSymbols = new ArrayList<PositionedSymbol>();
			if (eyeSymbol.equals(EyesBaseSymbol.EYE_BLINK_SINGLE)
					|| eyeSymbol.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE)) {
				// These are two eyes that need the EYES_OPEN Symbol
				// additionally

				Symbol lowerLeftEye = EyesBaseSymbol.getLeftEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				Symbol upperLeftEye = EyesBaseSymbol.getLeftEyeFor(eyeSymbol.getIswaSymbol());
				eyeSymbols.addAll(createSpecialEyeSymbol(lowerLeftEye, upperLeftEye, Location.LEFT));

			} else if (eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_CONTACT)
					|| eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_NEUTRAL)
					|| eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_WRINKLED)) {
				eyeSymbols
						.add(positionedSymbolFactory.createPositionedSymbol(eyeSymbol.getIswaSymbol(), Location.BOTH));
				enabled = false;
			} else {
				eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(
						EyesBaseSymbol.getLeftEyeFor(eyeSymbol.getIswaSymbol()), Location.LEFT));
			}
			final HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(eyeSymbols.toArray(new PositionedSymbol[eyeSymbols.size()]));

			ClickHandler clickHandler;
			// When only one Symbol is used for both eyes do not activate the
			// button for inserting a left eye
			if (enabled) {
				clickHandler = new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						List<PositionedEyeSymbol> positionedSymbols = clonePositionedSymbols(
								headSymbol.getPositionedEyeSymbols());
						listener.onLeftEyeSymbolChanged(positionedSymbols);
					}
				};
			} else {
				clickHandler = new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
					}

				};
			}

			leftEyeEditorKeybord.addHeadSymbol(headSymbol, "", clickHandler, enabled);
		}
	}

	private void createRightEyesSymbolKeyboard(HeadSymbolKeyboard rightEyeEditorKeybord) {
		for (EyesBaseSymbol eyeSymbol : EyesBaseSymbol.values()) {

			boolean enabled = true;
			List<PositionedSymbol> eyeSymbols = new ArrayList<PositionedSymbol>();
			if (eyeSymbol.equals(EyesBaseSymbol.EYE_BLINK_SINGLE)
					|| eyeSymbol.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE)) {
				// These are two eyes that need the EYES_OPEN Symbol
				// additionally

				Symbol lowerLeftEye = EyesBaseSymbol.getRightEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				Symbol upperLeftEye = EyesBaseSymbol.getRightEyeFor(eyeSymbol.getIswaSymbol());
				eyeSymbols.addAll(createSpecialEyeSymbol(lowerLeftEye, upperLeftEye, Location.RIGHT));

			} else if (eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_CONTACT)
					|| eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_NEUTRAL)
					|| eyeSymbol.equals(EyesBaseSymbol.FOREHEAD_WRINKLED)) {
				eyeSymbols
						.add(positionedSymbolFactory.createPositionedSymbol(eyeSymbol.getIswaSymbol(), Location.BOTH));
				enabled = false;
			} else {
				eyeSymbols.add(positionedSymbolFactory.createPositionedSymbol(
						EyesBaseSymbol.getRightEyeFor(eyeSymbol.getIswaSymbol()), Location.RIGHT));
			}
			final HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(eyeSymbols.toArray(new PositionedSymbol[eyeSymbols.size()]));

			ClickHandler clickHandler;
			// When only one Symbol is used for both eyes do not activate the
			// button for inserting a left eye
			if (enabled) {
				clickHandler = new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						List<PositionedEyeSymbol> positionedSymbols = clonePositionedSymbols(
								headSymbol.getPositionedEyeSymbols());
						listener.onRightEyeSymbolChanged(positionedSymbols);
					}
				};
			} else {
				clickHandler = new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
					}

				};
			}

			rightEyeEditorKeybord.addHeadSymbol(headSymbol, "", clickHandler, enabled);
		}
	}

	private void createHeadPostureEditTab() {
		Image headPostureIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory.createHeadSymbol(positionedSymbolFactory.createPositionedSymbol(
						HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol())),
				ICON_SCALE_FACTOR, true));

		FlowPanel headPostureEditorFlowPanel = new FlowPanel();
		HeadSymbolKeyboard headPostureEditor = new HeadSymbolKeyboard(symbolImageUrlService, false);
		headPostureEditor.addStyleName("headPostureSymbolEditor");

		headPostureEditorFlowPanel.add(createHeadPostureManipulationPanel());
		headPostureEditorFlowPanel.add(headPostureEditor);

		headPostureEditorTab = new Tab(headPostureIcon, headPostureEditorFlowPanel);
		tabPanel.addTab(headPostureEditorTab);

		for (final HeadPostureBaseSymbol headPostureSymbol : HeadPostureBaseSymbol.values()) {
			if (!HeadPostureBaseSymbol.NONE.equals(headPostureSymbol)) {
				final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(
						positionedSymbolFactory.createPositionedSymbol(headPostureSymbol.getIswaSymbol()));

				headPostureEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onHeadPostureChanged(headSymbol.getPositionedHeadPostureSymbol().clone());
					}
				});
				if (headPostureSymbol.getIswaSymbol().getBaseSymbol()
						.equals(HeadPostureBaseSymbol.TONGUE_MOVES_AGAINST_CHEEK_CHEEK_ITSELF.getIswaSymbol()
								.getBaseSymbol())) {
					final HeadSymbol tongueMovesAgainstCheekSymbolVariant2 = positionedSymbolFactory.createHeadSymbol(
							positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 2, 1, 1, 6, 39, 35)));

					headPostureEditor.addHeadSymbol(tongueMovesAgainstCheekSymbolVariant2, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onHeadPostureChanged(
									tongueMovesAgainstCheekSymbolVariant2.getPositionedHeadPostureSymbol().clone());
						}
					});

					final HeadSymbol tongueMovesAgainstCheekSymbolVariant3 = positionedSymbolFactory.createHeadSymbol(
							positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 2, 1, 2, 1, 39, 35)));

					headPostureEditor.addHeadSymbol(tongueMovesAgainstCheekSymbolVariant3, "", new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							listener.onHeadPostureChanged(
									tongueMovesAgainstCheekSymbolVariant3.getPositionedHeadPostureSymbol().clone());
						}
					});

				}
			}
		}
	}

	private void createCheeksEditTab() {
		PositionedSymbol leftCheek = positionedSymbolFactory.createPositionedSymbol(
				CheeksBaseSymbol.getLeftCheekFor(CheeksBaseSymbol.CHEEKS_PUFFED.getIswaSymbol().getBaseSymbol()),
				Location.LEFT);
		PositionedSymbol rightCheek = positionedSymbolFactory.createPositionedSymbol(
				CheeksBaseSymbol.getRightCheekFor(CheeksBaseSymbol.CHEEKS_PUFFED.getIswaSymbol().getBaseSymbol()),
				Location.RIGHT);
		HeadSymbol bothCheeksHeadSymbol = positionedSymbolFactory.createHeadSymbol(leftCheek, rightCheek);
		Image bothCheeksIcon = new Image(
				symbolImageUrlService.getHeadSymbolImageUrl(bothCheeksHeadSymbol, ICON_SCALE_FACTOR, true));

		FlowPanel cheekSwitchedContentFlowPanel = new FlowPanel();
		cheekSwitchedContentFlowPanel.add(createCheekManipulatorPanel());
		createCheeksHeadSymbolKeyboard();

		cheekSwitchedContentFlowPanel.add(cheeksHeadSymbolKeyboard);

		cheekEditorTab = new Tab(bothCheeksIcon, cheekSwitchedContentFlowPanel);
		tabPanel.addTab(cheekEditorTab);

	}

	private void createCheeksHeadSymbolKeyboard() {
		cheeksHeadSymbolKeyboard = new HeadSymbolKeyboard(symbolImageUrlService, false);
		cheeksHeadSymbolKeyboard.addStyleName("cheekSymbolEditor");
		for (final CheeksBaseSymbol cheekSymbol : CheeksBaseSymbol.values()) {

			int leftX = 0, y = 0, z = 0;
			int rightX = 0;

			if (CheeksBaseSymbol.TENSE_CHEEKS_LOW.equals(cheekSymbol)) {
				leftX += 3;
				rightX -= 3;
				y += 5;
			} else if (CheeksBaseSymbol.TENSE_CHEEKS_MIDDLE.equals(cheekSymbol)) {
				leftX += 3;
				rightX -= 3;
				y += 1;
			} else if (CheeksBaseSymbol.TENSE_CHEEKS_HIGH.equals(cheekSymbol)) {
				leftX += 3;
				rightX -= 3;
				y -= 2;
			}

			PositionedSymbol positionedLeftCheeksSymbol = positionedSymbolFactory.createPositionedSymbol(
					CheeksBaseSymbol.getLeftCheekFor(cheekSymbol.getIswaSymbol().getBaseSymbol()), Location.LEFT, leftX,
					y, z);
			PositionedSymbol positionedRightCheeksSymbol = positionedSymbolFactory.createPositionedSymbol(
					CheeksBaseSymbol.getRightCheekFor(cheekSymbol.getIswaSymbol().getBaseSymbol()), Location.RIGHT,
					rightX, y, z);

			final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(positionedLeftCheeksSymbol,
					positionedRightCheeksSymbol);

			cheeksHeadSymbolKeyboard.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {

					List<PositionedCheekSymbol> positionedSymbols = clonePositionedSymbols(
							headSymbol.getPositionedCheekSymbols());
					listener.onCheeksSymbolChanged(positionedSymbols);
					if (cheekSymbol.equals(CheeksBaseSymbol.NONE)) {
						enableLeftCheekHeadSymbolButton(false);
						enableRightCheekHeadSymbolButton(false);
					} else {
						enableLeftCheekHeadSymbolButton(true);
						enableRightCheekHeadSymbolButton(true);
					}
				}
			});
		}
	}

	private void createBreathEditTab() {

		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		positionedSymbols
				.add(positionedSymbolFactory.createPositionedSymbol(MouthBaseSymbol.MOUTH_OPEN_CIRCLE.getIswaSymbol()));
		positionedSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getLeftBreathSymbolFor(BreathBaseSymbol.AIR_SUCKING_IN.getIswaSymbol()),
				Location.LEFT));
		positionedSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getRightBreathSymbolFor(BreathBaseSymbol.AIR_SUCKING_IN.getIswaSymbol()),
				Location.RIGHT));

		Image breathIcon = new Image(symbolImageUrlService.getHeadSymbolImageUrl(
				positionedSymbolFactory
						.createHeadSymbol(positionedSymbols.toArray(new PositionedSymbol[positionedSymbols.size()])),
				ICON_SCALE_FACTOR, true));

		FlowPanel breathSwitchedContentFlowPanel = new FlowPanel();
		breathSwitchedContentFlowPanel.add(createBreathManipulatorPanel());

		createBreathHeadSymbolKeyboard();

		breathSwitchedContentFlowPanel.add(breathHeadSymbolKeyboard);

		breathEditorTab = new Tab(breathIcon, breathSwitchedContentFlowPanel);
		tabPanel.addTab(breathEditorTab);

	}

	private void createBreathHeadSymbolKeyboard() {
		breathHeadSymbolKeyboard = new HeadSymbolKeyboard(symbolImageUrlService, false);
		breathHeadSymbolKeyboard.addStyleName("breathSymbolEditor");
		for (final BreathBaseSymbol breathSymbol : BreathBaseSymbol.values()) {
			PositionedSymbol leftBreathSymbol = positionedSymbolFactory.createPositionedSymbol(
					BreathBaseSymbol.getLeftBreathSymbolFor(breathSymbol.getIswaSymbol()), Location.LEFT);
			PositionedSymbol rightBreathSymbol = positionedSymbolFactory.createPositionedSymbol(
					BreathBaseSymbol.getRightBreathSymbolFor(breathSymbol.getIswaSymbol()), Location.RIGHT);
			final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(leftBreathSymbol, rightBreathSymbol);

			breathHeadSymbolKeyboard.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					List<PositionedBreathSymbol> positionedSymbols = clonePositionedSymbols(
							headSymbol.getPositionedBreathSymbols());
					listener.onBreathSymbolChanged(positionedSymbols);
					if (breathSymbol.equals(BreathBaseSymbol.NONE)) {
						enableLeftBreathHeadSymbolButton(false);
						enableRightBreathHeadSymbolButton(false);
					} else {
						enableLeftBreathHeadSymbolButton(true);
						enableRightBreathHeadSymbolButton(true);
					}
				}
			});
		}

		breathHeadSymbolKeyboard.addSubHeader(I18N.getAirRelatedBodySymbols());
		for (final BodyBaseSymbol freePositionableBreathBaseSymbol : BodyBaseSymbol.values()) {
			if (BodyBaseSymbol
					.isAirRelatedBodySymbol(freePositionableBreathBaseSymbol.getIswaSymbol().getBaseSymbol())) {
				breathHeadSymbolKeyboard.addSymbol(freePositionableBreathBaseSymbol.getIswaSymbol(), "",
						new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								listener.addFreePositionedBreathSymbol(
										freePositionableBreathBaseSymbol.getIswaSymbol());
							}

						});
			}
		}
	}

	private void createCollectionEditTab() {
		Image collectionsIcon = new Image(symbolImageUrlService
				.getHeadSymbolImageUrl(
						positionedSymbolFactory.createHeadSymbol(
								positionedSymbolFactory
										.createPositionedSymbol(NoseBaseSymbol.NOSE_CONTACT.getIswaSymbol()),
								positionedSymbolFactory.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol())),
						ICON_SCALE_FACTOR, true));

		HeadSymbolKeyboard collectionsEditor = new HeadSymbolKeyboard(symbolImageUrlService, false);
		collectionsEditor.addStyleName("collectionsSymbolEditor");

		collectionEditorTab = new Tab(collectionsIcon, collectionsEditor);
		tabPanel.addTab(collectionEditorTab);

		// Hair
		int counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditHair());
		collectionsEditor.addWidget(createHairManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final HairBaseSymbol hairSymbol : HairBaseSymbol.values()) {

			final HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(positionedSymbolFactory.createPositionedSymbol(hairSymbol.getIswaSymbol()));

			counter++;
			collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onHairSymbolChanged(headSymbol.getPositionedHairSymbol().clone());
				}
			});
		}
		if (counter % 3 != 0) {
			collectionsEditor.addEmptyField();
		}

		// Expression
		counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditExpression());
		collectionsEditor.addWidget(createExpressionManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final ExpressionBaseSymbol expressionSymbol : ExpressionBaseSymbol.values()) {
			HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(positionedSymbolFactory.createPositionedSymbol(expressionSymbol.getIswaSymbol()));

			counter++;
			collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					listener.onExpressionSymbolChanged(expressionSymbol);
				}
			});
		}
		if (counter % 3 != 0) {
			collectionsEditor.addEmptyField();
		}

		// Neck
		counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditNeck());
		collectionsEditor.addWidget(createNeckManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final NeckBaseSymbol neckSymbol : NeckBaseSymbol.values()) {
			HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(positionedSymbolFactory.createPositionedSymbol(neckSymbol.getIswaSymbol()));

			counter++;
			collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					listener.onNeckSymbolChanged(neckSymbol);
				}
			});
		}
		if (counter % 3 != 0) {
			collectionsEditor.addEmptyField();
		}

		// Nose
		counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditNose());
		collectionsEditor.addWidget(createNoseManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final NoseBaseSymbol noseSymbol : NoseBaseSymbol.values()) {

			HeadSymbol headSymbol = positionedSymbolFactory
					.createHeadSymbol(positionedSymbolFactory.createPositionedSymbol(noseSymbol.getIswaSymbol()));

			counter++;
			collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					listener.onNoseSymbolChanged(noseSymbol);
				}
			});
		}
		if (counter % 3 != 0) {
			collectionsEditor.addEmptyField();
		}

		// Ears
		counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditEars());
		collectionsEditor.addWidget(createEarsManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final EarsBaseSymbol earsSymbol : EarsBaseSymbol.values()) {
			PositionedSymbol leftEar = positionedSymbolFactory
					.createPositionedSymbol(EarsBaseSymbol.getLeftEarFor(earsSymbol.getIswaSymbol()), Location.LEFT);
			PositionedSymbol rightEar = positionedSymbolFactory
					.createPositionedSymbol(EarsBaseSymbol.getRightEarFor(earsSymbol.getIswaSymbol()), Location.RIGHT);
			final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(leftEar, rightEar);

			counter++;
			collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					List<PositionedEarsSymbol> positionedSymbols = clonePositionedSymbols(
							headSymbol.getPositionedEarSymbols());
					listener.onEarsSymbolChanged(positionedSymbols);
				}
			});
		}

		counter = 0;
		collectionsEditor.addSubHeader(I18N.getEditJaw());
		collectionsEditor.addWidget(

				createJawManipulatorPanel());
		collectionsEditor.addEmptyField();
		for (final JawBaseSymbol jawSymbol : JawBaseSymbol.values()) {
			List<PositionedSymbol> positionedJawSymbols = new ArrayList<PositionedSymbol>();
			if (!JawBaseSymbol.JAW_PART_HEAD_RIM.equals(jawSymbol)) {
				if (!JawBaseSymbol.NONE.equals(jawSymbol)) {
					positionedJawSymbols.add(
							positionedSymbolFactory.createPositionedSymbol(jawSymbol.getIswaSymbol(), Location.LEFT));
					positionedJawSymbols.add(
							positionedSymbolFactory.createPositionedSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH));
					positionedJawSymbols.add(
							positionedSymbolFactory.createPositionedSymbol(jawSymbol.getIswaSymbol(), Location.RIGHT));
				}
				final HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(
						positionedJawSymbols.toArray(new PositionedSymbol[positionedJawSymbols.size()]));

				counter++;
				collectionsEditor.addHeadSymbol(headSymbol, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						List<PositionedJawSymbol> positionedSymbols = clonePositionedSymbols(
								headSymbol.getPositionedJawSymbols());
						listener.onJawSymbolChanged(positionedSymbols);
					}
				});
			}
		}
	}

	private void addSymbolColorChangePanel(final Class<? extends PositionedSymbol> classType, FlowPanel parent,
			final List<Color> colorList) {
		CustomColorChangerPanel customColorChangerPanel = new CustomColorChangerPanel(listener, colorList, colorList,
				classType);
		parent.add(customColorChangerPanel);
		colorChangerPanels.put(classType, customColorChangerPanel);
	}

	public interface HeadEditorListener extends VisemeEditorListener, PositionedSymbolColorChangeListener {
		void onEyeSymbolChanged(List<PositionedEyeSymbol> eyeSymbols);

		void addFreePositionedBreathSymbol(Symbol iswaSymbol);

		void onLeftEyeSymbolChanged(List<PositionedEyeSymbol> leftEye);

		void onRightEyeSymbolChanged(List<PositionedEyeSymbol> rightEye);

		void onRotateJawCounterClockwiseButton();

		void onRotateJawClockwiseButton();

		void onJawSymbolChanged(List<PositionedJawSymbol> jawSymbols);

		void onDecreaseNeckButton();

		void onIncreaseNeckButton();

		void onRightBreathStatusChanged(boolean enable);

		void onLeftBreathStatusChanged(boolean enable);

		void onCheeksSymbolChanged(List<PositionedCheekSymbol> cheekSymbols);

		void onToggleRightEarButton();

		void onToggleLeftEarButton();

		void onSwitchHeadPostureSymbolToNormalArrows();

		void onSwitchHeadPostureSymbolToAlternatingArrows();

		void onEarsSymbolChanged(List<PositionedEarsSymbol> earsSymbol);

		void onNoseSymbolChanged(NoseBaseSymbol noseSymbol);

		void onNeckSymbolChanged(NeckBaseSymbol neckSymbol);

		void onExpressionSymbolChanged(ExpressionBaseSymbol expressionSymbol);

		void onMirrorHeadPostureHorizontal();

		void onMirrorHeadPostureVertical();

		void onDecreaseHeadPosture();

		void onIncreaseHeadPosture();

		void onRotatHeadPostureCounterClockwise();

		void onRotateHeadPostureClockwise();

		void onBreathSymbolChanged(List<PositionedBreathSymbol> breathBaseSymbols);

		void onIncreaseEyeSymbols();

		void onDecreaseEyeSymbols();

		void onMirrorEyesSymbol();

		void onRotateEyesSymbolClockwise();

		void onRotateEyesSymbolCounterClockwise();

		void onHairSymbolChanged(PositionedHairSymbol hairSymbol);

		void onMouthSymbolChanged(PositionedMouthSymbol mouthSymbol);

		void onHeadPostureChanged(PositionedHeadPostureSymbol headPosture);

		void onRotateMouthSymbolClockwise();

		void onRotateMouthSymbolCounterClockwise();

		void onDecreaseMouthSymbol();

		void onIncreaseMouthSymbol();

		void onMirrorMouthSymbolHorizontally();

		void onLeftCheekStatusChanged(boolean active);

		void onRightCheekStatusChanged(boolean active);
	}

	@Override
	public void resetSidebar() {
		toggleLeftBreathButton.setPressed(false);
		toggleRightBreathButton.setPressed(false);

		toggleLeftCheekButton.setPressed(false);
		toggleRightCheekButton.setPressed(false);

		toggleLeftEarButton.setPressed(false);
		toggleRightEarButton.setPressed(false);
	}
}
