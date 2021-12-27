package de.signWritingEditor.client.GWTClient.ui.tool.subtools.mobileComponents;

import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.FileItemWidget;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.material.FileItem;

public class FileItemWidgetMobile extends FileItemWidget {
	@Override
	public void init(FileItem fileItem, int width, Image icon, FontSizeService fontSizeService) {
		super.init(fileItem, width, icon, fontSizeService);

		addHandler(new TouchStartHandler() {
			@Override
			public void onTouchStart(TouchStartEvent event) {
				fireTouchStart();
			}
		}, TouchStartEvent.getType());
		sinkEvents(Event.ONTOUCHSTART);

		addHandler(new TouchEndHandler() {
			@Override
			public void onTouchEnd(TouchEndEvent event) {
				fireTouchEnd();
			}
		}, TouchEndEvent.getType());
		sinkEvents(Event.ONTOUCHEND);
	}

	private void fireTouchStart() {
		if (getFileItemWidgetListener() != null) {
			getFileItemWidgetListener().onTouchStart();
		}
	}

	private void fireTouchEnd() {
		if (getFileItemWidgetListener() != null) {
			getFileItemWidgetListener().onTouchEnd();
		}
	}

}
