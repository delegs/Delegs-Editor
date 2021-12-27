package de.signWritingEditor.test.integration.misc.unit.infrastructure;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentPanelListener;

public class DocumentPanelListenerMock implements DocumentPanelListener {

	@Override
	public void onActivateDragMode(MouseDownEvent event) {
	}

	@Override
	public void onMouseDragged(Event event) {
	}

	@Override
	public void setInDragMode(boolean dragMode) {
	}

}
