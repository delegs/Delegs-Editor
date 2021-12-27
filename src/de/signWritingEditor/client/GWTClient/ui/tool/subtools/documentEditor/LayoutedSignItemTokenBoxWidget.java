package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.layout.SignItemTokenBox;

public class LayoutedSignItemTokenBoxWidget extends SignItemTokenBoxWidgetBase {

	private LayoutedSearchWordBox searchWordBox;

	public LayoutedSignItemTokenBoxWidget(SignItemTokenBox tokenBox, DocumentUiListener documentUiListener,
			SignDataEncoder signDataEncoder, ChangeAlternativeToolTip changeAlternativeToolTip,
			EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		super(tokenBox, documentUiListener, signDataEncoder, changeAlternativeToolTip, eventTranslator,
				fontSizeService);
		searchWordBox = new LayoutedSearchWordBox(tokenBox, eventTranslator, fontSizeService);
		searchWordBox.setText(tokenBox.getText());
		setSearchWordBoxBase(searchWordBox);
		searchWordBox.setSearchWordBoxListener(documentUiListener);
		sinkEvents(Event.ONKEYDOWN);

		if (tokenBox.isLockedLayout()) {
			searchWordBox.removeStyleName("searchWordBox");
			searchWordBox.addStyleName("freeTextLineTemplate");
			searchWordBox.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		}

		updateWidget();
	}

	@Override
	public void onBrowserEvent(Event event) {
		if (event.getTypeInt() == Event.ONKEYDOWN && signSelectorPanel.hasAlternativeSigns()) {
			switch (event.getKeyCode()) {
			case KeyCodes.KEY_ALT:
				signSelectorPanel.showToolTipPanelBriefly();
				// prevent default: jump into browser menu bar
				event.stopPropagation();
				break;
			case KeyCodes.KEY_UP:
				if (event.getAltKey()) {
					event.preventDefault();
					signSelectorPanel.onSelectNextSign();
					signSelectorPanel.showToolTipPanelBriefly();
				}
				break;
			case KeyCodes.KEY_DOWN:
				if (event.getAltKey()) {
					event.preventDefault();
					signSelectorPanel.onSelectPreviousSign();
					signSelectorPanel.showToolTipPanelBriefly();
				}
				break;
			}
		}
		super.onBrowserEvent(event);
		if (event.getKeyCode() == (int) 'S') {
			if (event.getCtrlKey() || event.getMetaKey()) {
				event.preventDefault();
			}
		}

	}

	public void addMouseOverSignHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
		assert mouseOverHandler != null : "Precondition failed: mouseOverHandler != null";
		assert mouseOutHandler != null : "Precondition failed: mouseOutHandler != null";

		signSelectorPanel.addHandler(mouseOverHandler, MouseOverEvent.getType());
		signSelectorPanel.addHandler(mouseOutHandler, MouseOutEvent.getType());
		signSelectorPanel.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	}

	@Override
	public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
		assert mouseOverHandler != null : "Precondition failed: mouseOverHandler != null";
		assert mouseOutHandler != null : "Precondition failed: mouseOutHandler != null";

		searchWordBox.addHandler(mouseOverHandler, MouseOverEvent.getType());
		searchWordBox.addHandler(mouseOutHandler, MouseOutEvent.getType());
		searchWordBox.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	}

	@Override
	public void setDragModeHandler(MouseDragListener listener) {
		searchWordBox.setMouseDragListener(listener);
	}
}
