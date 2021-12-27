package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.service.SymbolImageUrlService;
import de.signWritingEditor.shared.model.material.HeadSymbol;

public class HeadSymbolKeyboard extends SymbolKeyboard {

	public HeadSymbolKeyboard(SymbolImageUrlService symbolImageUrlService, boolean showLabels) {
		super(symbolImageUrlService, showLabels);

		assert symbolImageUrlService != null : "Precondition failed: symbolImageUrlService != null";

		this.addStyleName("headSymbolKeyboard");
	}

	public void addHeadSymbol(HeadSymbol headSymbol, String description, ClickHandler clickHandler, boolean enabled) {
		assert headSymbol != null : "Precondition failed: headSymbol != null";
		assert description != null : "Precondition failed: description != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		Image symbolImage = new Image(getSymbolImageUrlService().getHeadSymbolImageUrl(headSymbol, 1, true));

		Widget symbolButton = createSymbolButton(symbolImage, description);
		symbolButton.addHandler(clickHandler, ClickEvent.getType());
		symbolButton.sinkEvents(Event.ONCLICK);

		if (!enabled) {
			symbolButton.addStyleName("disabled");
		}

		getFlowPanel().add(symbolButton);
	}

	public void addHeadSymbol(HeadSymbol headSymbol, String description, ClickHandler clickHandler) {
		this.addHeadSymbol(headSymbol, description, clickHandler, true);
	}

	public void addEmptyField() {
		FlowPanel emptyField = new FlowPanel();
		emptyField.setStyleName("emptyField");
		getFlowPanel().add(emptyField);
	}

	public void addWidget(Widget widget) {
		getFlowPanel().add(widget);
	}

}
