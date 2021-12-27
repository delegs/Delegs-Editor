package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.service.FontSizeService;

public class InvisibleTextArea extends ExtendedRichTextArea {

	public InvisibleTextArea(EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		super(eventTranslator, fontSizeService);
		getElement().getStyle().setOpacity(0);
		setPixelSize(1, 1);
		getElement().getStyle().setPosition(Position.ABSOLUTE);
		sinkEvents(Event.ONPASTE);
	}

}