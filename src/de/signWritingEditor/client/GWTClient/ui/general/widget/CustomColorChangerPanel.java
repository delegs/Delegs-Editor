package de.signWritingEditor.client.GWTClient.ui.general.widget;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;

import java.util.List;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.ModalDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ColorPicker;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ColorPicker.ColorPickerListener;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.material.PositionedSymbol;

public class CustomColorChangerPanel extends Composite {

	private ToolBarButton toggleColorPickerButtonForFormerBlack;
	private ToolBarButton toggleColorPickerButtonForFormerWhite;
	private ColorPicker colorPickerForFormerBlack;
	private ColorPicker colorPickerForFormerWhite;
	private ToolBarButton removeColorButton;
	private ToolBarButton addColorButton;
	private FlowPanel mainPanel;

	public CustomColorChangerPanel(final PositionedSymbolColorChangeListener symbolColorChangeListener,
			List<Color> colorsForFormerBlack, List<Color> colorsForFormerWhite,
			final Class<? extends PositionedSymbol> classType) {
		assert symbolColorChangeListener != null : "Precondition failed: symbolColorChangeListener != null";

		mainPanel = new FlowPanel();
		mainPanel.setStyleName("colorChangePanel");
		initWidget(mainPanel);

		colorPickerForFormerBlack = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				symbolColorChangeListener.onChangeColorOfType(true, color, classType);
			}
		}, colorsForFormerBlack);
		colorPickerForFormerBlack.setVisible(false);

		colorPickerForFormerWhite = new ColorPicker(new ColorPickerListener() {
			@Override
			public void colorSelected(Color color) {
				symbolColorChangeListener.onChangeColorOfType(false, color, classType);
			}
		}, colorsForFormerWhite);
		colorPickerForFormerWhite.setVisible(false);

		Image colorPickerImageForBlack = new Image(RESOURCE.getIconChangeColorFill());
		colorPickerImageForBlack.setSize("22px", "22px");
		Image colorPickerImageForWhite = new Image(RESOURCE.getIconChangeColor());
		colorPickerImageForWhite.setSize("22px", "22px");
		Image colorPickerImageDisabled = new Image(RESOURCE.getIconChangeColorDisabled());
		colorPickerImageDisabled.setSize("22px", "22px");

		toggleColorPickerButtonForFormerBlack = new ToolBarButton(colorPickerImageForBlack, colorPickerImageDisabled,
				"", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						colorPickerForFormerBlack.setVisible(!colorPickerForFormerBlack.isVisible());
						toggleColorPickerButtonForFormerBlack.setPressed(colorPickerForFormerBlack.isVisible());
						setAddAndRemoveColorButtonsVisible(
								colorPickerForFormerBlack.isVisible() || colorPickerForFormerWhite.isVisible());
						if (colorPickerForFormerBlack.isVisible()) {
							colorPickerForFormerWhite.setVisible(false);
							toggleColorPickerButtonForFormerWhite.setPressed(false);
						}
					}
				});
		toggleColorPickerButtonForFormerBlack.addStyleName("button");
		toggleColorPickerButtonForFormerBlack.getElement().getStyle().setMarginTop(2, Unit.PX);

		toggleColorPickerButtonForFormerWhite = new ToolBarButton(colorPickerImageForWhite, colorPickerImageDisabled,
				"", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						colorPickerForFormerWhite.setVisible(!colorPickerForFormerWhite.isVisible());
						toggleColorPickerButtonForFormerWhite.setPressed(colorPickerForFormerWhite.isVisible());
						setAddAndRemoveColorButtonsVisible(
								colorPickerForFormerBlack.isVisible() || colorPickerForFormerWhite.isVisible());
						if (colorPickerForFormerWhite.isVisible()) {
							colorPickerForFormerBlack.setVisible(false);
							toggleColorPickerButtonForFormerBlack.setPressed(false);
						}
					}

				});
		toggleColorPickerButtonForFormerWhite.addStyleName("button");
		toggleColorPickerButtonForFormerWhite.getElement().getStyle().setMarginTop(2, Unit.PX);

		Image addColorImage = new Image(RESOURCE.getIconAddColor());
		addColorImage.setSize("22px", "22px");
		addColorButton = new ToolBarButton(addColorImage, "", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ModalDialogBox popUp = new ModalDialogBox();
				popUp.show();
				// temporary color picker, to choose a color for the user
				// defined color picker
				ColorPicker standardColorPicker = new ColorPicker(new ColorPickerListener() {

					@Override
					public void colorSelected(Color color) {
						if (colorPickerForFormerWhite.isVisible()) {
							symbolColorChangeListener.onChangeColorOfType(false, color, classType);
							colorPickerForFormerWhite.addCustomColor(color);
						} else if (colorPickerForFormerBlack.isVisible()) {
							symbolColorChangeListener.onChangeColorOfType(true, color, classType);
							colorPickerForFormerBlack.addCustomColor(color);
						}
						popUp.hide();
					}
				});
				CloseButton closeButton = new CloseButton(new CloseListener() {
					@Override
					public void onClose() {
						popUp.hide();
						popUp.removeFromParent();
					}
				});
				closeButton.getElement().getStyle().setTop(-23, Unit.PX);
				closeButton.getElement().getStyle().setRight(-16, Unit.PX);
				AbsolutePanel popUpPanel = new AbsolutePanel();
				popUp.add(popUpPanel);
				popUpPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
				popUpPanel.add(closeButton);
				popUpPanel.add(standardColorPicker);
				popUp.center();
			}
		});
		addColorButton.setVisible(false);

		Image removeColorImage = new Image(RESOURCE.getIconRemoveColor());
		removeColorImage.setSize("22px", "22px");
		removeColorButton = new ToolBarButton(removeColorImage, "", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (colorPickerForFormerWhite.isVisible()) {
					colorPickerForFormerWhite.removeSelectedColor();
				} else if (colorPickerForFormerBlack.isVisible()) {
					colorPickerForFormerBlack.removeSelectedColor();
				}
			}
		});
		removeColorButton.setVisible(false);

		mainPanel.add(toggleColorPickerButtonForFormerBlack);
		mainPanel.add(toggleColorPickerButtonForFormerWhite);
		mainPanel.add(addColorButton);
		mainPanel.add(removeColorButton);
		mainPanel.add(colorPickerForFormerBlack);
		mainPanel.add(colorPickerForFormerWhite);
	}

	public void setEnabled(boolean showColorChanger) {
		toggleColorPickerButtonForFormerWhite.setVisible(false);
		toggleColorPickerButtonForFormerBlack.setEnabled(showColorChanger);
		if (!showColorChanger) {
			addColorButton.setVisible(false);
			removeColorButton.setVisible(false);
			colorPickerForFormerBlack.setVisible(false);
			colorPickerForFormerWhite.setVisible(false);
			toggleColorPickerButtonForFormerBlack.setPressed(false);
			toggleColorPickerButtonForFormerWhite.setPressed(false);
		}
	}

	public void setCorrectColors(Color symbolColorForFormerBlack, Color symbolColorForFormerWhite) {
		colorPickerForFormerBlack.selectColor(symbolColorForFormerBlack);
		colorPickerForFormerWhite.selectColor(symbolColorForFormerWhite);
	}

	private void setAddAndRemoveColorButtonsVisible(boolean visible) {
		removeColorButton.setVisible(visible);
		addColorButton.setVisible(visible);

	}

	public interface PositionedSymbolColorChangeListener {
		void onChangeColorOfType(boolean changeBlackToNewColor, Color colorCode,
				Class<? extends PositionedSymbol> classType);
	}
}
