package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class SymbolKeyboard extends Composite {

	private static final int ICON_SCALE_FACTOR = 1;
	private final FlowPanel flowPanel;
	private final SymbolImageUrlService symbolImageUrlService;

	public SymbolKeyboard(SymbolImageUrlService symbolImageUrlService, boolean showLabels) {
		assert symbolImageUrlService != null : "Precondition failed: symbolImageUrlService != null";
		this.symbolImageUrlService = symbolImageUrlService;

		flowPanel = new FlowPanel();
		initWidget(flowPanel);

		this.setStyleName("symbolKeyboard");
		this.setStyleDependentName("showLabels", showLabels);
	}

	protected SymbolImageUrlService getSymbolImageUrlService() {
		return symbolImageUrlService;
	}

	protected FlowPanel getFlowPanel() {
		return flowPanel;
	}

	public void addSymbol(Symbol symbol, String description, ClickHandler clickHandler) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert description != null : "Precondition failed: description != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		Image symbolImage = new Image(getSymbolImageUrlService().getSymbolImageUrl(symbol, ICON_SCALE_FACTOR));

		addSymbol(symbolImage, description, clickHandler);
	}

	public void addSymbol(Image symbol, String description, ClickHandler clickHandler) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert description != null : "Precondition failed: description != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		Widget symbolButton = createSymbolButton(symbol, description);
		symbolButton.addHandler(clickHandler, ClickEvent.getType());
		symbolButton.sinkEvents(Event.ONCLICK);

		getFlowPanel().add(symbolButton);
	}

	protected Widget createSymbolButton(Image image, String labelText) {
		assert image != null : "Precondition failed: image != null";
		assert labelText != null : "Precondition failed: labelText != null";

		FlowPanel result = new FlowPanel();
		result.setStyleName("symbolButton");

		FlowPanel imageContainer = new FlowPanel();
		imageContainer.setStyleName("imageContainer");
		result.add(imageContainer);

		image.setAltText(labelText);
		image.setStyleName("image");
		imageContainer.add(image);

		Label keyLabel = new Label(labelText);
		keyLabel.setStyleName("label");
		result.add(keyLabel);

		return result;
	}

	public void addSubHeader(String text) {
		Label subHeaderLabel = new Label(text);
		subHeaderLabel.setStyleName("subHeaderLabel");
		getFlowPanel().add(subHeaderLabel);
	}

	public void resetSymbolKeyboard() {
		// nothing to do here
	}
}
