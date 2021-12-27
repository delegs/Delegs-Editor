package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.dom.client.Style.Clear;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.shared.model.domainValue.Color;

public class ColorPicker extends FlowPanel {

	enum STANDARD_COLORS {
		DARK_RED(0, 100, 75), RED(0, 100, 100), ORANGE(45, 100, 100), YELLOW(60, 100, 100), LIGHT_GREEN(89, 61, 81), //
		GREEN(147, 100, 69), LIGHT_BLUE(196, 100, 94), BLUE(205, 100, 75), DARK_BLUE(220, 100, 37), PURPLE(274, 70, 62);

		private double hue, stauration, value;

		private STANDARD_COLORS(double hue, double saturation, double value) {
			this.hue = hue;
			this.stauration = saturation;
			this.value = value;
		}

		public double getHue() {
			return hue;
		}

		public double getSaturation() {
			return stauration;
		}

		public double getValue() {
			return value;
		}
	}

	enum DESIGN_COLOR {
		WHITE(0, 0, 100), BLACK(0, 0, 0), GREY(0, 0, 93.4), NAVIBLUE(215, 75, 50), SKYBLUE(210, 60, 75), OLDPINK(0, 60,
				75), GRASSGREEN(80, 55, 75), LAVENDER(265, 35, 65), CYAN(190, 65, 75), GOLDENYELLOW(25, 70, 95);

		private double hue, stauration, value;

		private DESIGN_COLOR(double hue, double saturation, double value) {
			this.hue = hue;
			this.stauration = saturation;
			this.value = value;
		}

		public double getHue() {
			return hue;
		}

		public double getSaturation() {
			return stauration;
		}

		public double getValue() {
			return value;
		}
	}

	private static List<STANDARD_COLORS> standardColorList;
	private static List<DESIGN_COLOR> designColorList;
	private FlowPanel standardColorPanel;
	private FlowPanel skinColorPanel;
	private FlowPanel designColorPanel;
	private Grid colorTable;
	private ColorPickerListener listener;
	private Map<Color, SimplePanel> colorToPanelMap;
	int hueValue;
	int saturationValue;
	int value;

	public SimplePanel colorChooserPanel;
	private SimplePanel currentlySelectedPanel;
	private FlowPanel customPanel;

	public ColorPicker(ColorPickerListener listener) {
		super();
		this.setStyleName("colorPicker");
		this.setVisible(true);
		this.listener = listener;
		colorToPanelMap = new HashMap<Color, SimplePanel>();

		createColorChooserPanel();
	}

	public ColorPicker(ColorPickerListener listener, List<Color> colors) {
		super();
		this.setStyleName("colorPicker");
		this.setVisible(true);
		this.listener = listener;
		colorToPanelMap = new HashMap<Color, SimplePanel>();

		customPanel = new FlowPanel();
		customPanel.getElement().getStyle().setClear(Clear.BOTH);
		customPanel.addStyleName("colorPanelRow");
		for (Color color : colors) {
			createColorPanelElement(customPanel, color);
		}
		this.add(customPanel);
	}

	public void addCustomColor(Color color) {
		createColorPanelElement(customPanel, color);
	}

	public void removeSelectedColor() {
		List<Color> keyToRemove = new ArrayList<Color>();
		if (currentlySelectedPanel != null) {
			for (Entry<Color, SimplePanel> entry : colorToPanelMap.entrySet()) {
				if (entry.getValue().equals(currentlySelectedPanel)) {
					keyToRemove.add(entry.getKey());
				}
			}
		}
		for (Color color : keyToRemove) {
			colorToPanelMap.remove(color);
		}
		customPanel.remove(currentlySelectedPanel);
	}

	public void selectColor(Color selectedColor) {
		SimplePanel panel = colorToPanelMap.get(selectedColor);
		deselectColor();
		if (panel != null) {
			currentlySelectedPanel = panel;
			currentlySelectedPanel.addStyleDependentName("selected");
		}
	}

	public void deselectColor() {
		if (currentlySelectedPanel != null) {
			currentlySelectedPanel.removeStyleDependentName("selected");
		}

	}

	private void createColorPanelElement(FlowPanel panel, final Color color) {
		SimplePanel pane = new SimplePanel();
		pane.setStyleName("colorChooserElement");
		pane.getElement().getStyle().setBackgroundColor(color.getCssValue());
		final SimplePanel colorPanel = pane;
		colorPanel.sinkEvents(Event.ONCLICK);
		colorToPanelMap.put(color, colorPanel);
		colorPanel.addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onValueChanged(color, colorPanel);
			}

		}, ClickEvent.getType());
		panel.add(colorPanel);
	}

	private void createColorChooserPanel() {
		this.add(addSubHeader(I18N.getStandardColors()));
		createStandardColorPanel(standardColorPanel);

		this.add(addSubHeader(I18N.getSkinColors()));
		createSkinColorPanel(skinColorPanel);

		this.add(addSubHeader(I18N.getDesignColors()));
		createDesignColorPanel(designColorPanel);

		createColorTable(colorTable);
	}

	private void createStandardColorPanel(FlowPanel panel) {
		panel = new FlowPanel();
		panel.addStyleName("colorPanelRow");
		for (STANDARD_COLORS color : standardColorList) {
			createColorPanelElement(panel, color.getHue(), color.getSaturation(), color.getValue());
		}

		this.add(panel);
	}

	private void createSkinColorPanel(FlowPanel panel) {
		panel = new FlowPanel();
		panel.addStyleName("colorPanelRow");
		for (Color color : Color.getSkinColor()) {
			createColorPanelElement(panel, color);
		}

		this.add(panel);
	}

	private void createDesignColorPanel(FlowPanel panel) {
		panel = new FlowPanel();
		panel.addStyleName("colorPanelRow");
		for (DESIGN_COLOR color : designColorList) {
			createColorPanelElement(panel, color.getHue(), color.getSaturation(), color.getValue());
		}

		this.add(panel);
	}

	private void createColorPanelElement(FlowPanel panel, double hue, double saturation, double value) {
		SimplePanel pane = new SimplePanel();
		final Color paneColor = Color.makeFromHSV(hue, saturation, value);
		pane.setStyleName("colorChooserElement");
		pane.getElement().getStyle().setBackgroundColor(paneColor.getCssValue());
		final SimplePanel colorPanel = pane;
		colorPanel.sinkEvents(Event.ONCLICK);
		colorToPanelMap.put(paneColor, colorPanel);
		colorPanel.addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onValueChanged(paneColor, colorPanel);
			}

		}, ClickEvent.getType());
		panel.add(colorPanel);
	}

	private void createColorTable(Grid grid) {
		grid = new Grid(1, 10);
		grid.addStyleName("colorChooserTable");
		int position = 0;
		for (DESIGN_COLOR baseColor : designColorList) {
			FlowPanel panel = new FlowPanel();

			panel.setStyleName("colorTableCell");
			panel.getElement().getStyle().setWidth(20, Unit.PX);

			createGridCell(panel, baseColor);
			grid.setWidget(0, position, panel);
			position++;
		}

		this.add(grid);
	}

	private void createGridCell(FlowPanel panel, DESIGN_COLOR baseColor) {

		if (baseColor.equals(DESIGN_COLOR.BLACK)) {
			createBlackColorCell(panel);
		} else if (baseColor.equals(DESIGN_COLOR.WHITE)) {
			createWhiteColorCell(panel);
		} else if (baseColor.equals(DESIGN_COLOR.GREY)) {
			createBeigeColorCell(panel);
		} else if (baseColor.equals(DESIGN_COLOR.NAVIBLUE) || baseColor.equals(DESIGN_COLOR.LAVENDER)
				|| baseColor.equals(DESIGN_COLOR.GOLDENYELLOW)) {
			createNonStandardColorCell(panel, baseColor);
		} else {
			createStandardColorCell(panel, baseColor);
		}
	}

	private void createNonStandardColorCell(FlowPanel panel, DESIGN_COLOR baseColor) {
		double hue = 0, saturation = 0, value = 0;
		hue = baseColor.getHue();
		double stepSizeSaturation = 0;
		double stepSizeValue = 0;
		if (baseColor.equals(DESIGN_COLOR.NAVIBLUE)) {
			saturation = 15;
			value = 95;
			stepSizeSaturation = 20;
			stepSizeValue = -5;
		} else if (baseColor.equals(DESIGN_COLOR.LAVENDER)) {
			saturation = 5;
			value = 95;
			stepSizeSaturation = 5;
			stepSizeValue = -5;
		} else if (baseColor.equals(DESIGN_COLOR.GOLDENYELLOW)) {
			saturation = 15;
			value = 100;
			stepSizeSaturation = 15;
			stepSizeValue = 0;
		}

		for (int i = 0; i <= 2; i++) {
			createColorPanelElement(panel, hue, saturation, value);

			saturation += stepSizeSaturation;
			value += stepSizeValue;

		}

		if (baseColor.equals(DESIGN_COLOR.NAVIBLUE)) {
			saturation = 75;
			value = 35;
			stepSizeValue = -10;
		} else if (baseColor.equals(DESIGN_COLOR.LAVENDER)) {
			saturation = 40;
			value = 45;
			stepSizeValue = -15;
		} else if (baseColor.equals(DESIGN_COLOR.GOLDENYELLOW)) {
			saturation = 95;
			value = 90;
			stepSizeValue = -30;
		}

		for (int i = 3; i < 5; i++) {
			createColorPanelElement(panel, hue, saturation, value);

			value += stepSizeValue;

		}
	}

	private void createBeigeColorCell(FlowPanel panel) {
		int hue = 50, saturation = 0, value = 95;

		for (int i = 0; i < 5; i++) {
			if (i <= 1) {
				saturation = saturation + 10;
				value = value - 10;
			} else {
				saturation = 45;
				value = value - 20;
			}
			createColorPanelElement(panel, hue, saturation, value);
		}
	}

	private void createBlackColorCell(FlowPanel panel) {
		int hue = 0, saturation = 0, value = 50;

		for (int i = 0; i < 5; i++) {
			createColorPanelElement(panel, hue, saturation, value);

			if (i >= 1) {
				value = value - 10;
			} else {
				value = value - 15;
			}
		}
	}

	private void createWhiteColorCell(FlowPanel panel) {
		int hue = 0, saturation = 0, value = 105;

		for (int i = 0; i < 5; i++) {
			if (i < 4) {
				value = value - 10;
			} else {
				value = value - 15;
			}
			createColorPanelElement(panel, hue, saturation, value);
		}
	}

	private void createStandardColorCell(FlowPanel panel, DESIGN_COLOR baseColor) {

		for (int i = 0; i < 5; i++) {
			double hue, saturation, value;
			hue = baseColor.getHue();
			if (i < 3) {
				saturation = baseColor.getSaturation() - 30 - 10 * (2 - i);
				value = baseColor.getValue() + 10 + 5 * (2 - i);
			} else {
				saturation = baseColor.getSaturation() + 5;
				value = baseColor.getValue() - 20 * (i - 2);
			}
			createColorPanelElement(panel, hue, saturation, value);
		}
	}

	private void onValueChanged(Color paneColor, SimplePanel selectedPanel) {

		if (currentlySelectedPanel != null) {
			currentlySelectedPanel.removeStyleDependentName("selected");
		}

		selectedPanel.addStyleDependentName("selected");
		currentlySelectedPanel = selectedPanel;
		listener.colorSelected(paneColor);
	}

	private Widget addSubHeader(String text) {
		Label subHeaderLabel = new Label(text);
		subHeaderLabel.setStyleName("subHeaderLabel");
		return subHeaderLabel;
	}

	static {
		standardColorList = new ArrayList<ColorPicker.STANDARD_COLORS>() {
			{
				add(STANDARD_COLORS.DARK_RED);
				add(STANDARD_COLORS.RED);
				add(STANDARD_COLORS.ORANGE);
				add(STANDARD_COLORS.YELLOW);
				add(STANDARD_COLORS.LIGHT_GREEN);
				add(STANDARD_COLORS.GREEN);
				add(STANDARD_COLORS.LIGHT_BLUE);
				add(STANDARD_COLORS.BLUE);
				add(STANDARD_COLORS.DARK_BLUE);
				add(STANDARD_COLORS.PURPLE);
			}
		};

		designColorList = new ArrayList<ColorPicker.DESIGN_COLOR>() {
			{
				add(DESIGN_COLOR.WHITE);
				add(DESIGN_COLOR.BLACK);
				add(DESIGN_COLOR.GREY);
				add(DESIGN_COLOR.NAVIBLUE);
				add(DESIGN_COLOR.SKYBLUE);
				add(DESIGN_COLOR.OLDPINK);
				add(DESIGN_COLOR.GRASSGREEN);
				add(DESIGN_COLOR.LAVENDER);
				add(DESIGN_COLOR.CYAN);
				add(DESIGN_COLOR.GOLDENYELLOW);
			}
		};
	}

	public interface ColorPickerListener {
		public void colorSelected(Color color);
	}

}
