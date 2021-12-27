package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RecycleBinItem;

public class FilePathWidget extends Composite {

	public static final int FILE_PATH_WIDGET_HEIGHT = 25;
	public static final int TOP_OFFSET = 2;

	private List<FolderItem> path;

	private final AbsolutePanel mainPanel;
	private final FilePathWidgetListener listener;

	public FilePathWidget(List<FolderItem> path, FilePathWidgetListener listener) {
		assert path != null : "Precondition failed: path != null";
		assert listener != null : "Precondition failed: listener != null";

		this.path = path;
		this.listener = listener;

		mainPanel = new AbsolutePanel();
		mainPanel.setHeight(FILE_PATH_WIDGET_HEIGHT + "px");
		initWidget(mainPanel);
		mainPanel.setStyleName("filePathWidget");
		refreshPathButtons();
	}

	public void refreshPathButtons() {
		mainPanel.clear();

		int leftOffset = 0;
		for (FolderItem folderItem : path) {
			leftOffset += this.addFolderButton(folderItem, leftOffset);
		}
	}

	public int addFolderButton(final FolderItem folderItem, int leftOffset) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert leftOffset >= 0 : "Precondition failed: leftOffset >= 0";

		final AbsolutePanel mainButtonPanel = new AbsolutePanel();
		mainButtonPanel.setStyleName("button");
		mainPanel.add(mainButtonPanel, leftOffset, 0);

		String fileTitleString;
		if (!(folderItem instanceof RecycleBinItem)) {
			fileTitleString = folderItem.getFileTitle().getDisplayTitleString();
		} else {
			// Change name for the recycle bin:
			fileTitleString = I18N.getRecycleBinName();
		}

		Label folderTitleLabel = new Label(fileTitleString);
		folderTitleLabel.setWordWrap(false);
		mainButtonPanel.add(folderTitleLabel, 0, 0);
		mainButtonPanel.ensureDebugId("filePathWidget-mainPanel-mainButtonPanel-" + fileTitleString);

		Style folderTitleLabelStyle = folderTitleLabel.getElement().getStyle();
		folderTitleLabelStyle.setPaddingLeft(14, Unit.PX);
		folderTitleLabelStyle.setPaddingRight(4, Unit.PX);
		folderTitleLabelStyle.setPaddingTop(4, Unit.PX);

		int offsetWidth = folderTitleLabel.getOffsetWidth();
		mainButtonPanel.setSize(offsetWidth + "px", FILE_PATH_WIDGET_HEIGHT + "px");

		final Image filePathWidgetArrow = new Image(RESOURCE.getFilePathWidgetRightArrow());
		mainButtonPanel.add(filePathWidgetArrow, offsetWidth, 0);

		mainButtonPanel.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onClickFolderItem(folderItem);
			}
		}, ClickEvent.getType());
		mainButtonPanel.sinkEvents(Event.ONCLICK);

		mainButtonPanel.addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				mainButtonPanel.addStyleDependentName("hover");
				filePathWidgetArrow.setResource(RESOURCE.getFilePathWidgetRightArrowHover());
			}
		}, MouseOverEvent.getType());
		mainButtonPanel.sinkEvents(Event.ONMOUSEOVER);

		mainButtonPanel.addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				mainButtonPanel.removeStyleDependentName("hover");
				filePathWidgetArrow.setResource(RESOURCE.getFilePathWidgetRightArrow());
			}
		}, MouseOutEvent.getType());
		mainButtonPanel.sinkEvents(Event.ONMOUSEOUT);

		mainButtonPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		mainButtonPanel.getElement().getStyle().setZIndex(path.size() - path.indexOf(folderItem));

		return offsetWidth;
	}

	public void setPath(List<FolderItem> path) {
		assert path != null : "Precondition failed: path != null";

		this.path = path;
	}

	public List<FolderItem> getPath() {
		return path;
	}

	public interface FilePathWidgetListener {
		void onClickFolderItem(FolderItem clickedFolderItem);
	}

}
