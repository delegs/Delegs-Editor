package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SymbolColorChangerPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SymbolColorChangerPanel.SymbolColorChangeListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.shared.model.domainValue.Color;

public class SymbolEditor extends SidebarEditor {

	private final SymbolEditorListener symbolEditorListener;
	private ToolBarButton rotateClockwiseButton;
	private ToolBarButton rotateCounterClockwiseButton;
	private ToolBarButton rollButton;
	private ToolBarButton mirrorButton;
	private ToolBarButton mirrorVerticallyButton;
	private ToolBarButton pitchButton;
	private ToolBarButton duplicateButton;
	private ToolBarButton removeButton;
	private ToolBarButton increaseButton;
	private ToolBarButton decreaseButton;
	private ToolBarButton switchArrowHeadButton;
	private ToolBarButton increaseZIndexButton;
	private ToolBarButton decreaseZIndexButton;
	private ToolBarButton switchToAlternatingArrowsButton;
	private ToolBarButton switchToNormalArrowsButton;
	private ToolBarButton switchStartingPointButton;
	private ToolBarButton switchSizeButton;
	private ToolBarButton switchPlaneButton;
	private SymbolColorChangerPanel symbolColorChangerPanel;

	public SymbolEditor(final SymbolEditorListener listener) {
		super(I18N.getEditSymbol());
		assert listener != null : "Precondition failed: listener != null";

		addStyleName("handEditor");
		this.symbolEditorListener = listener;

		addIncreaseZIndexButton();

		addDecreaseZIndexButton();

		addDuplicateButton();

		addRemoveButton();

		addLineBreak();

		addRotateButtons();

		addRollButton();

		addPitchButton();

		addLineBreak();

		addMirrorButton();

		addMirrorVerticallyButton();

		addIncreaseButton();

		addDecreaseButton();

		addSwitchSizeButton();

		addLineBreak();

		addSwitchArrowHeadButton();

		addSwitchToAlternatingArrowsButton();

		addSwitchToNormalArrowsButton();

		addSwitchStartingPointButton();

		addSwitchPlaneButton();

		addLineBreak();

		addSymbolColorChangePanel();

	}

	private void addSymbolColorChangePanel() {
		symbolColorChangerPanel = new SymbolColorChangerPanel(symbolEditorListener);
		addContent(symbolColorChangerPanel);
	}

	private void addSwitchArrowHeadButton() {
		switchArrowHeadButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchHandSymbol()),
				new Image(RESOURCE.getIconSwitchHandSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchArrowHead();
					}
				});
		switchArrowHeadButton.addStyleName("button");
		addContent(switchArrowHeadButton);
		showSwitchArrowHeadButton(false);

	}

	private void addIncreaseZIndexButton() {
		increaseZIndexButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseZIndexSymbol()),
				new Image(RESOURCE.getIconIncreaseZIndexSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onIncreaseZIndex();
					}
				});
		increaseZIndexButton.addStyleName("button");
		addContent(increaseZIndexButton);
	}

	private void addDecreaseZIndexButton() {
		decreaseZIndexButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseZIndexSymbol()),
				new Image(RESOURCE.getIconDecreaseZIndexSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onDecreaseZIndex();
					}
				});
		decreaseZIndexButton.addStyleName("button");
		addContent(decreaseZIndexButton);
	}

	private void addIncreaseButton() {
		increaseButton = new ToolBarButton(new Image(RESOURCE.getIconIncreaseSymbol()),
				new Image(RESOURCE.getIconIncreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onIncreaseSymbolQuantity();
					}
				});
		increaseButton.addStyleName("button");
		addContent(increaseButton);
		showIncreaseButton(false);
	}

	private void addDecreaseButton() {
		decreaseButton = new ToolBarButton(new Image(RESOURCE.getIconDecreaseSymbol()),
				new Image(RESOURCE.getIconDecreaseSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onDecreaseSymbolQuantity();
					}
				});
		decreaseButton.addStyleName("button");
		addContent(decreaseButton);
		showDecreaseButton(false);
	}

	private void addPitchButton() {
		pitchButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolPitch()),
				new Image(RESOURCE.getIconHandSymbolPitchDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onPitchSymbol();
					}
				});
		pitchButton.addStyleName("button");
		addContent(pitchButton);
		showPitchButton(false);
	}

	private void addRollButton() {
		rollButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRoll()),
				new Image(RESOURCE.getIconHandSymbolRollDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onRollSymbol();
					}
				});
		rollButton.addStyleName("button");
		addContent(rollButton);
		showRollButton(false);
	}

	private void addMirrorButton() {
		mirrorButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolMirror()),
				new Image(RESOURCE.getIconHandSymbolMirrorDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onMirrorSymbol();
					}
				});
		mirrorButton.addStyleName("button");
		addContent(mirrorButton);
		showMirrorButton(false);
	}

	private void addMirrorVerticallyButton() {
		mirrorVerticallyButton = new ToolBarButton(new Image(RESOURCE.getIconSymbolMirrorVertically()),
				new Image(RESOURCE.getIconSymbolMirrorVerticallyDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onMirrorVertically();
					}
				});
		mirrorVerticallyButton.addStyleName("button");
		addContent(mirrorVerticallyButton);
		showMirrorVerticallyButton(false);
	}

	private void addDuplicateButton() {
		duplicateButton = new ToolBarButton(new Image(RESOURCE.getIconDuplicateSymbol()),
				new Image(RESOURCE.getIconDuplicateSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onDuplicateSymbol();
					}
				});
		duplicateButton.addStyleName("button");
		addContent(duplicateButton);
	}

	private void addRemoveButton() {
		removeButton = new ToolBarButton(new Image(RESOURCE.getIconRemoveSymbol()),
				new Image(RESOURCE.getIconRemoveSymbolDisabled()), "", new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onRemoveSymbol();
					}
				});
		removeButton.addStyleName("button");
		addContent(removeButton);
	}

	private void addRotateButtons() {
		addRotateClockwiseButton();
		addRotateCounterClockwiseButton();
		showRotateButtons(false);
	}

	private void addRotateCounterClockwiseButton() {
		rotateCounterClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateCounterClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateCounterClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onRotateSymbolCounterClockwise();
					}
				});
		rotateCounterClockwiseButton.addStyleName("button");
		addContent(rotateCounterClockwiseButton);
	}

	private void addRotateClockwiseButton() {
		rotateClockwiseButton = new ToolBarButton(new Image(RESOURCE.getIconHandSymbolRotateClockwise()),
				new Image(RESOURCE.getIconHandSymbolRotateClockwiseDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onRotateSymbolClockwise();
					}
				});
		rotateClockwiseButton.addStyleName("button");
		addContent(rotateClockwiseButton);
	}

	private void addSwitchSizeButton() {
		switchSizeButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchSizeSymbol()),
				new Image(RESOURCE.getIconSwitchSizeSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchSize();
					}
				});
		switchSizeButton.addStyleName("button");
		addContent(switchSizeButton);
		showSwitchSizeButton(false);
	}

	private void addSwitchToAlternatingArrowsButton() {
		switchToAlternatingArrowsButton = new ToolBarButton(
				new Image(RESOURCE.getIconSwitchToAlternatingArrowsSymbol()),
				new Image(RESOURCE.getIconSwitchToAlternatingArrowsSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchToAlternatingArrows();
					}
				});
		switchToAlternatingArrowsButton.addStyleName("button");
		addContent(switchToAlternatingArrowsButton);
		showSwitchToAlternatingArrowsButton(false);
	}

	private void addSwitchToNormalArrowsButton() {
		switchToNormalArrowsButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchToNormalArrowsSymbol()),
				new Image(RESOURCE.getIconSwitchToNormalArrowsSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchToNormalArrows();
					}
				});
		switchToNormalArrowsButton.addStyleName("button");
		addContent(switchToNormalArrowsButton);
		showSwitchToNormalArrowsButton(false);
	}

	private void addSwitchStartingPointButton() {
		switchStartingPointButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchStartingPointSymbol()),
				new Image(RESOURCE.getIconSwitchStartingPointSymbolDisabled()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchStartingPoint();
					}
				});
		switchStartingPointButton.addStyleName("button");
		addContent(switchStartingPointButton);
		showSwitchStartingPointButton(false);
	}

	private void addSwitchPlaneButton() {
		switchPlaneButton = new ToolBarButton(new Image(RESOURCE.getIconSwitchPlane()),
				new Image(RESOURCE.getIconSwitchPlaneDis()), "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						symbolEditorListener.onSwitchPlane();
					}
				});
		switchPlaneButton.addStyleName("button");
		addContent(switchPlaneButton);
		showSwitchPlaneButton(false);
	}

	public void showRotateButtons(boolean show) {
		rotateClockwiseButton.setEnabled(show);
		rotateCounterClockwiseButton.setEnabled(show);
	}

	public void showRollButton(boolean show) {
		rollButton.setEnabled(show);
	}

	public void showPitchButton(boolean show) {
		pitchButton.setEnabled(show);
	}

	public void showMirrorButton(boolean show) {
		mirrorButton.setEnabled(show);
	}

	public void showMirrorVerticallyButton(boolean show) {
		mirrorVerticallyButton.setEnabled(show);
	}

	public void showIncreaseButton(boolean show) {
		increaseButton.setEnabled(show);
	}

	public void showDecreaseButton(boolean show) {
		decreaseButton.setEnabled(show);
	}

	public void showSwitchArrowHeadButton(boolean show) {
		switchArrowHeadButton.setEnabled(show);
	}

	public void showSwitchSizeButton(boolean show) {
		switchSizeButton.setEnabled(show);
	}

	public void showSwitchToAlternatingArrowsButton(boolean show) {
		switchToAlternatingArrowsButton.setEnabled(show);
	}

	public void showSwitchToNormalArrowsButton(boolean show) {
		switchToNormalArrowsButton.setEnabled(show);
	}

	public void showSwitchStartingPointButton(boolean show) {
		switchStartingPointButton.setEnabled(show);
	}

	public void showSwitchPlaneButton(boolean show) {
		switchPlaneButton.setEnabled(show);
	}

	public void showIncreaseZIndexButton(boolean show) {
		increaseZIndexButton.setEnabled(show);
	}

	public void showDecreaseZIndexButton(boolean show) {
		decreaseZIndexButton.setEnabled(show);
	}

	public void showDuplicateButton(boolean show) {
		duplicateButton.setEnabled(show);
	}

	public void showRemoveButton(boolean show) {
		removeButton.setEnabled(show);
	}

	public void enableColorChanger(boolean enable) {
		symbolColorChangerPanel.enable(enable);
	}

	public void setSelectedColor(boolean selectAColorForFormerBlack, boolean selectAColorForFormerWhite,
			Color colorForFormerBlack, Color colorForFormerWhite) {
		this.symbolColorChangerPanel.setSelectedColor(selectAColorForFormerBlack, selectAColorForFormerWhite,
				colorForFormerBlack, colorForFormerWhite);
	}

	private void addLineBreak() {
		addContent(new HTMLPanel("<div style=\"margin-top: 5px;\"></div>"));
	}

	public interface SymbolEditorListener extends SymbolColorChangeListener {
		void onRotateSymbolClockwise();

		void onSwitchPlane();

		void onSwitchSize();

		void onMirrorVertically();

		void onSwitchToAlternatingArrows();

		void onSwitchToNormalArrows();

		void onIncreaseZIndex();

		void onDecreaseZIndex();

		void onSwitchArrowHead();

		void onIncreaseSymbolQuantity();

		void onDecreaseSymbolQuantity();

		void onRotateSymbolCounterClockwise();

		void onRollSymbol();

		void onPitchSymbol();

		void onMirrorSymbol();

		void onDuplicateSymbol();

		void onRemoveSymbol();

		void onSwitchStartingPoint();
	}

	@Override
	public void resetSidebar() {
		showRotateButtons(false);
		showPitchButton(false);
		showRollButton(false);
		showMirrorButton(false);
		showMirrorVerticallyButton(false);
		showIncreaseButton(false);
		showDecreaseButton(false);
		showSwitchArrowHeadButton(false);
		showSwitchToAlternatingArrowsButton(false);
		showSwitchToNormalArrowsButton(false);
		showSwitchStartingPointButton(false);
		showSwitchSizeButton(false);
		showSwitchPlaneButton(false);
		showIncreaseZIndexButton(false);
		showDecreaseZIndexButton(false);
		showDuplicateButton(false);
		showRemoveButton(false);

		enableColorChanger(false);

	}
}
