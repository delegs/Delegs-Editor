package de.signWritingEditor.client.GWTClient.ui.general.widget;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ColorPicker;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ColorPicker.ColorPickerListener;
import de.signWritingEditor.shared.model.domainValue.Color;

public class SymbolColorChangerPanel extends Composite {

	private static final int TOOLBAR_BUTTON_EDGE_LENGTH = 22;
	private ToolBarButton toggleColorPickerButtonForFormerBlack;
	private ToolBarButton toggleColorPickerButtonForFormerWhite;
	private ColorPicker colorPickerForFormerBlack;
	private ColorPicker colorPickerForFormerWhite;

	public SymbolColorChangerPanel(final SymbolColorChangeListener symbolColorChangeListener) {
		assert symbolColorChangeListener != null : "Precondition failed: symbolColorChangeListener != null";

		FlowPanel mainPanel = new FlowPanel();
		initWidget(mainPanel);

		colorPickerForFormerBlack = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				symbolColorChangeListener.onSwitchColor(color, true);
			}
		});
		colorPickerForFormerBlack.setVisible(false);

		colorPickerForFormerWhite = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				symbolColorChangeListener.onSwitchColor(color, false);
			}
		});
		colorPickerForFormerWhite.setVisible(false);

		Image colorPickerImageForBlack = new Image(RESOURCE.getIconChangeColorFill());
		colorPickerImageForBlack.setPixelSize(TOOLBAR_BUTTON_EDGE_LENGTH, TOOLBAR_BUTTON_EDGE_LENGTH);
		Image colorPickerImageForBlackDisabled = new Image(RESOURCE.getIconChangeColorDisabled());
		colorPickerImageForBlackDisabled.setPixelSize(TOOLBAR_BUTTON_EDGE_LENGTH, TOOLBAR_BUTTON_EDGE_LENGTH);

		Image colorPickerImageForWhite = new Image(RESOURCE.getIconChangeColor());
		colorPickerImageForWhite.setPixelSize(TOOLBAR_BUTTON_EDGE_LENGTH, TOOLBAR_BUTTON_EDGE_LENGTH);
		Image colorPickerImageForWhiteDisabled = new Image(RESOURCE.getIconChangeColorDisabled());
		colorPickerImageForWhiteDisabled.setPixelSize(TOOLBAR_BUTTON_EDGE_LENGTH, TOOLBAR_BUTTON_EDGE_LENGTH);

		toggleColorPickerButtonForFormerBlack = new ToolBarButton(colorPickerImageForBlack,
				colorPickerImageForBlackDisabled, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						colorPickerForFormerBlack.setVisible(!colorPickerForFormerBlack.isVisible());
						toggleColorPickerButtonForFormerBlack.setPressed(colorPickerForFormerBlack.isVisible());
						if (colorPickerForFormerBlack.isVisible()) {
							colorPickerForFormerWhite.setVisible(false);
							toggleColorPickerButtonForFormerWhite.setPressed(false);
						}
					}
				});
		toggleColorPickerButtonForFormerBlack.addStyleName("button");
		toggleColorPickerButtonForFormerBlack.getElement().getStyle().setMarginTop(2, Unit.PX);

		toggleColorPickerButtonForFormerWhite = new ToolBarButton(colorPickerImageForWhite,
				colorPickerImageForWhiteDisabled, "", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						colorPickerForFormerWhite.setVisible(!colorPickerForFormerWhite.isVisible());
						toggleColorPickerButtonForFormerWhite.setPressed(colorPickerForFormerWhite.isVisible());
						if (colorPickerForFormerWhite.isVisible()) {
							colorPickerForFormerBlack.setVisible(false);
							toggleColorPickerButtonForFormerBlack.setPressed(false);
						}
					}
				});
		toggleColorPickerButtonForFormerWhite.addStyleName("button");
		toggleColorPickerButtonForFormerWhite.getElement().getStyle().setMarginTop(2, Unit.PX);

		mainPanel.add(toggleColorPickerButtonForFormerBlack);
		mainPanel.add(toggleColorPickerButtonForFormerWhite);
		mainPanel.add(colorPickerForFormerBlack);
		mainPanel.add(colorPickerForFormerWhite);
	}

	public void setSelectedColor(boolean selectAColorForFormerBlack, boolean selectAColorForFormerWhite,
			Color colorForFormerBlack, Color colorForFormerWhite) {
		if (selectAColorForFormerBlack) {
			colorPickerForFormerBlack.selectColor(colorForFormerBlack);
		} else {
			colorPickerForFormerBlack.deselectColor();
		}

		if (selectAColorForFormerWhite) {
			colorPickerForFormerWhite.selectColor(colorForFormerWhite);
		} else {
			colorPickerForFormerWhite.deselectColor();
		}

	}

	public void enable(boolean enable) {
		toggleColorPickerButtonForFormerBlack.setEnabled(enable);
		toggleColorPickerButtonForFormerWhite.setEnabled(enable);
	}

	public interface SymbolColorChangeListener {
		void onSwitchColor(Color colorCode, boolean changeColorForFormerBlack);
	}

}
