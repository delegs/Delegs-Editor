package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorMacImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.User;

public class FileItemWidget extends Composite {
	public static final int NAME_COLUMN_MARGIN = 10;
	public static final int HEIGHT = 26;
	public static final int LEFT_OFFSET = 15;
	public static final int RIGHT_OFFSET = 10;
	public static final int TOP_OFFSET = 5;
	public static final int DATE_COLUMN_WIDTH = 140;
	public static final int CHANGE_DATE_COLUMN_WIDTH = 140;
	public static final int AUTHOR_COLUMN_WIDTH = 100;
	public static final int COLOR_COLUMN_WIDTH = 100;
	public static final int ICON_COLUMN_WIDTH = 40;

	private int NAME_COLUMN_WIDTH;

	private Label fileNameLabel;
	private FileItemWidgetListener listener;

	private FocusPanel mainPanel;
	private AbsolutePanel insetPanel;

	private EventTranslatorStandardImpl eventTranslator = GWT.create(EventTranslatorStandardImpl.class);
	private SimplePanel iconPanel;
	private Label toolTipLabel;
	private Label authorLabel;
	private Label creationDateLabel;
	private Label changeDateLabel;
	private String fileTitleString;

	public void init(FileItem fileItem, int width, Image icon, final FontSizeService fontSizeService) {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert width > LEFT_OFFSET + 2 * DATE_COLUMN_WIDTH + AUTHOR_COLUMN_WIDTH + ICON_COLUMN_WIDTH
				+ RIGHT_OFFSET : "Precondition failed: width > LEFT_OFFSET + 2*DATE_COLUMN_WIDTH + AUTHOR_COLUMN_WIDTH + ICON_COLUMN_WIDTH + RIGHT_OFFSET";
		assert icon != null : "Precondition failed: icon != null";

		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		}

		NAME_COLUMN_WIDTH = width - (LEFT_OFFSET + DATE_COLUMN_WIDTH + AUTHOR_COLUMN_WIDTH + ICON_COLUMN_WIDTH
				+ CHANGE_DATE_COLUMN_WIDTH + COLOR_COLUMN_WIDTH + RIGHT_OFFSET + NAME_COLUMN_MARGIN);

		setFileTitleString(fileItem);

		mainPanel = new FocusPanel();
		mainPanel.setStyleName("fileItemWidget");
		initWidget(mainPanel);

		insetPanel = new AbsolutePanel();
		insetPanel.setStyleName("inset");
		insetPanel.setSize("100%", HEIGHT + "px");
		mainPanel.add(insetPanel);

		iconPanel = new SimplePanel(icon);
		iconPanel.setHeight("100%");
		iconPanel.setWidth(ICON_COLUMN_WIDTH + "px");
		insetPanel.add(iconPanel, LEFT_OFFSET, TOP_OFFSET);

		toolTipLabel = new Label(fileTitleString);
		toolTipLabel.addStyleName("toolTip");
		toolTipLabel.setVisible(false);
		toolTipLabel.getElement().getStyle().setZIndex(100);
		toolTipLabel.getElement().getStyle().setCursor(Cursor.DEFAULT);
		insetPanel.add(toolTipLabel, LEFT_OFFSET + ICON_COLUMN_WIDTH, TOP_OFFSET);

		final Timer tooltipDelayTimer = new Timer() {
			@Override
			public void run() {
				toolTipLabel.setVisible(true);
			}
		};

		fileNameLabel = new Label(this.fileTitleString);
		fileNameLabel.setStyleName("label");
		fileNameLabel.setWordWrap(false);
		fileNameLabel.setWidth(NAME_COLUMN_WIDTH + "px");
		insetPanel.add(fileNameLabel, LEFT_OFFSET + ICON_COLUMN_WIDTH, TOP_OFFSET);

		authorLabel = new Label(getUsernameForDisplay(fileItem.getOwner()));
		authorLabel.setStyleName("label");
		authorLabel.setWidth(AUTHOR_COLUMN_WIDTH + "px");
		insetPanel.add(authorLabel, LEFT_OFFSET + ICON_COLUMN_WIDTH + NAME_COLUMN_WIDTH + NAME_COLUMN_MARGIN,
				TOP_OFFSET);

		creationDateLabel = new Label(
				DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(fileItem.getCreationDate()));
		creationDateLabel.setStyleName("label");
		creationDateLabel.setWidth(DATE_COLUMN_WIDTH + "px");
		insetPanel.add(creationDateLabel,
				LEFT_OFFSET + ICON_COLUMN_WIDTH + NAME_COLUMN_WIDTH + NAME_COLUMN_MARGIN + AUTHOR_COLUMN_WIDTH,
				TOP_OFFSET);

		changeDateLabel = new Label(
				DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(fileItem.getChangeDate()));
		changeDateLabel.setStyleName("label");
		changeDateLabel.setWidth(DATE_COLUMN_WIDTH + "px");
		insetPanel.add(changeDateLabel, LEFT_OFFSET + ICON_COLUMN_WIDTH + NAME_COLUMN_WIDTH + NAME_COLUMN_MARGIN
				+ AUTHOR_COLUMN_WIDTH + DATE_COLUMN_WIDTH, TOP_OFFSET);

		mainPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				FontMetricSpecifier fontMetricSpecifier = new FontMetricSpecifier(Font.HELVETICA, FontStyle.NORMAL,
						FontSizeService.STANDARD_FONT_SIZE, FontWeight.NORMAL);
				if (fontSizeService.getStringWidth(fileTitleString, fontMetricSpecifier) > NAME_COLUMN_WIDTH
						&& !toolTipLabel.isVisible()) {
					tooltipDelayTimer.schedule(800);
					event.preventDefault();
				}
			}
		});

		mainPanel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				tooltipDelayTimer.cancel();
				toolTipLabel.setVisible(false);
				event.preventDefault();
			}
		});

		mainPanel.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				toolTipLabel.setVisible(false);
				fireDoubleClick();
				event.preventDefault();
			}
		});

		mainPanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				fireClick(event.isShiftKeyDown(), event.isControlKeyDown(), event.isMetaKeyDown());
				event.preventDefault();
			}
		});

		mainPanel.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_DOWN) {
					listener.onKeyDown(event.isShiftKeyDown());
					event.stopPropagation();
					event.preventDefault();
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_UP) {
					listener.onKeyUp(event.isShiftKeyDown());
					event.stopPropagation();
					event.preventDefault();
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_HOME) {
					listener.onKeyHome(event.isShiftKeyDown());
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_END) {
					listener.onKeyEnd(event.isShiftKeyDown());
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					listener.onKeyEnter();
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_DELETE) {
					listener.onKeyDelete();
				} else if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					listener.onKeyDelete();
					event.preventDefault();
				} else if (eventTranslator.get(event) == Interaction.SELECT_ALL) {
					listener.onSelectAll();
					event.stopPropagation();
					event.preventDefault();
				}
			}
		});

		setColorLabel(fileItem.getColorLabel());
	}

	private String getUsernameForDisplay(String username) {
		return User.getUnknownUser().getUsername().equals(username) ? I18N.getUnknownUserName() : username;
	}

	public void updateWithFileItem(FileItem fileItem, Image icon) {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert icon != null : "Precondition failed: icon != null";

		setFileTitleString(fileItem);

		toolTipLabel.setText(fileTitleString);
		iconPanel.setWidget(icon);
		fileNameLabel.setText(fileTitleString);
		authorLabel.setText(getUsernameForDisplay(fileItem.getOwner()));
		creationDateLabel
				.setText(DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(fileItem.getCreationDate()));
		changeDateLabel.setText(DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(fileItem.getChangeDate()));

		setColorLabel(fileItem.getColorLabel());
	}

	public void setListener(FileItemWidgetListener fileItemWidgetListener) {
		assert fileItemWidgetListener != null : "Precondition failed: fileItemWidgetListener != null";

		listener = fileItemWidgetListener;
	}

	public void setSelected(boolean selected) {
		setStyleDependentName("selected", selected);
		mainPanel.setFocus(selected);
	}

	public void setColored(boolean colored) {
		setStyleDependentName("colored", colored);
	}

	protected FileItemWidgetListener getFileItemWidgetListener() {
		return listener;
	}

	private void setFileTitleString(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		if (!(fileItem instanceof RecycleBinItem)) {
			fileTitleString = fileItem.getFileTitle().getDisplayTitleString();
		} else {
			// Change name for the recycle bin:
			fileTitleString = I18N.getRecycleBinName();
		}
	}

	private void fireClick(boolean shiftKeyPressed, boolean ctrlKeyPressed, boolean metaKeyPressed) {
		if (listener != null) {
			listener.onClick(shiftKeyPressed, ctrlKeyPressed, metaKeyPressed);
		}
	}

	private void fireDoubleClick() {
		if (listener != null) {
			listener.onDoubleClick();
		}
	}

	private void setColorLabel(FileItemColorLabel newColorLabel) {
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";

		for (FileItemColorLabel colorLabel : FileItemColorLabel.values()) {
			insetPanel.removeStyleName(colorLabel.getStyleName());
		}

		insetPanel.addStyleName(newColorLabel.getStyleName());
	}

	public interface FileItemWidgetListener {
		void onClick(boolean isShiftKeyDown, boolean isCtrlKeyDown, boolean isMetaKeyDown);

		void onDoubleClick();

		void onKeyDown(boolean shiftDown);

		void onKeyUp(boolean shiftDown);

		void onKeyHome(boolean shiftDown);

		void onKeyEnd(boolean shiftDown);

		void onKeyEnter();

		void onKeyDelete();

		void onSelectAll();

		void onTouchStart();

		void onTouchEnd();
	}
}
