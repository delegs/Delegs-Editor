package de.signWritingEditor.client.GWTClient.ui.tool.subtools.mobileComponents;

import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.touch.client.Point;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.FileItemWidget.FileItemWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.LazyLoadingFileBrowser;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public class LazyLoadingFileBrowserMobile extends LazyLoadingFileBrowser {

	private Timer touchTimer;
	private Point startPoint;

	@Override
	protected void initializeContent(LocalSessionService localSessionService, RoomItem rootRoomItem,
			DocumentServiceAsync documentService, FontSizeService fontSizeService, boolean onlyFolders, int width,
			int height, final LazyLoadingFileBrowserListener listener) {
		super.initializeContent(localSessionService, rootRoomItem, documentService, fontSizeService, onlyFolders, width,
				height, listener);

		// Implementation for touch devices
		this.addHandler(new TouchStartHandler() {

			@Override
			public void onTouchStart(TouchStartEvent event) {
				handleTouchStart(event);
			}
		}, TouchStartEvent.getType());
		this.sinkEvents(Event.ONTOUCHSTART);

		this.addHandler(new TouchMoveHandler() {

			@Override
			public void onTouchMove(TouchMoveEvent event) {
				handleTouchMove(event);
			}
		}, TouchMoveEvent.getType());
		this.sinkEvents(Event.ONTOUCHMOVE);
	}

	private void handleTouchStart(TouchStartEvent event) {
		assert event != null : "Precondition failed: event != null";

		startPoint = new Point(event.getChangedTouches().get(0).getClientX(),
				event.getChangedTouches().get(0).getClientY());
	}

	private void handleTouchMove(TouchMoveEvent event) {
		assert event != null : "Precondition failed: event != null";

		Point endPoint = new Point(event.getChangedTouches().get(0).getClientX(),
				event.getChangedTouches().get(0).getClientY());
		double dy = startPoint.getY() - endPoint.getY();
		if (Math.abs(dy) > 20) {
			touchTimer.cancel();
		}
	}

	@Override
	protected FileItemWidgetListener createFileItemWidgetListener(final FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		return new FileItemWidgetListener() {

			@Override
			public void onDoubleClick() {
				activateFileItem(fileItem);
			}

			@Override
			public void onClick(boolean isShiftKeyDown, boolean isCtrlKeyDown, boolean isMetaKeyDown) {
				handleFileItemSelected(fileItem, isShiftKeyDown, isCtrlKeyDown, isMetaKeyDown);
			}

			@Override
			public void onKeyDown(boolean isShiftKeyDown) {
				if (getLastSelectedIndex() + 1 < getFileItems().size()) {
					handleFileItemSelected(getFileItems().get(getLastSelectedIndex() + 1), isShiftKeyDown, false,
							false);
				}
			}

			@Override
			public void onKeyUp(boolean isShiftKeyDown) {
				if (getLastSelectedIndex() > 0) {
					handleFileItemSelected(getFileItems().get(getLastSelectedIndex() - 1), isShiftKeyDown, false,
							false);
				}
			}

			@Override
			public void onKeyHome(boolean isShiftKeyDown) {
				handleFileItemSelected(getFileItems().get(0), isShiftKeyDown, false, false);
			}

			@Override
			public void onKeyEnd(boolean isShiftKeyDown) {
				handleFileItemSelected(getFileItems().get(getFileItems().size() - 1), isShiftKeyDown, false, false);
			}

			@Override
			public void onKeyEnter() {
				if (getSelectedFileItems().size() == 1) {
					activateFileItem(getSelectedFileItems().get(0));
				}
			}

			@Override
			public void onSelectAll() {
				handleFileItemSelected(getFileItems().get(0), false, false, false);
				handleFileItemSelected(getFileItems().get(getFileItems().size() - 1), true, false, false);
			}

			@Override
			public void onKeyDelete() {
				getFileBrowserListener().onDeletePressed();
			}

			@Override
			public void onTouchStart() {
				touchTimer = new Timer() {

					@Override
					public void run() {
						activateFileItem(fileItem);
					}
				};
				touchTimer.schedule(1000);
			}

			@Override
			public void onTouchEnd() {
				touchTimer.cancel();
			}
		};
	}
}
