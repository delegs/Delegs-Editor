package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.shared.model.material.SignHistoryItem;

public class SignHistoryItemWidget extends Composite {
	public static final int HEIGHT = 26;
	public static final int LEFT_OFFSET = 15;
	public static final int RIGHT_OFFSET = 10;
	public static final int TOP_OFFSET = 5;
	public static final int DATE_COLUMN_WIDTH = 160;
	public static final int AUTHOR_COLUMN_WIDTH = 160;
	public static final int COMMENT_COLUMN_WIDTH = 380;

	private SignHistoryItemWidgetListener listener;

	private SignHistoryItem signHistoryItem;

	private FocusPanel mainPanel;
	private AbsolutePanel insetPanel;
	private Label authorLabel;
	private Label dateLabel;
	private Label commentLabel;

	public void init(SignHistoryItem signHistoryItem, int width) {
		this.signHistoryItem = signHistoryItem;

		mainPanel = new FocusPanel();
		mainPanel.setStyleName("signHistoryItemWidget");
		initWidget(mainPanel);

		AbsolutePanel absolutePanel = new AbsolutePanel();

		insetPanel = new AbsolutePanel();
		insetPanel.setStyleName("inset");
		insetPanel.setSize("100%", HEIGHT + "px");
		absolutePanel.add(insetPanel);

		authorLabel = new Label(signHistoryItem.getAuthorname());
		authorLabel.setStyleName("label");
		authorLabel.setWordWrap(false);
		authorLabel.setWidth(AUTHOR_COLUMN_WIDTH + "px");
		insetPanel.add(authorLabel, LEFT_OFFSET, TOP_OFFSET);

		dateLabel = new Label(DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(signHistoryItem.getDate()));
		dateLabel.setStyleName("label");
		dateLabel.setWordWrap(false);
		dateLabel.setWidth(DATE_COLUMN_WIDTH + "px");
		insetPanel.add(dateLabel, LEFT_OFFSET + AUTHOR_COLUMN_WIDTH, TOP_OFFSET);

		String comment = "";
		if (signHistoryItem.getComment().length() <= I18N.getUnsavedSign().length()) {
			comment = signHistoryItem.getComment();
		} else {
			comment = signHistoryItem.getComment().substring(0, I18N.getUnsavedSign().length() - 1) + " ...";
		}
		commentLabel = new Label(comment);

		commentLabel.setStyleName("label");
		commentLabel.setWordWrap(false);
		commentLabel.setWidth(COMMENT_COLUMN_WIDTH + "px");
		insetPanel.add(commentLabel, LEFT_OFFSET + AUTHOR_COLUMN_WIDTH + DATE_COLUMN_WIDTH, TOP_OFFSET);

		mainPanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (listener != null) {
					listener.onClick();
				}
				event.preventDefault();
			}
		});

		mainPanel.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				listener.onKeyDown(event);
			}
		});

		mainPanel.add(absolutePanel);
	}

	public void setColored(boolean colored) {
		setStyleDependentName("colored", colored);
	}

	public void overwriteDateLabel(String dateLabel) {
		String newLabel = "";
		if (dateLabel != null) {
			newLabel = dateLabel;
		}
		this.dateLabel.setText(newLabel);
	}

	public void updateWithSignHistoryItem(SignHistoryItem signHistoryItem) {
		assert signHistoryItem != null : "Precondition failed: signHistoryItem != null";

		this.signHistoryItem = signHistoryItem;

		authorLabel.setText(signHistoryItem.getAuthorname());
		dateLabel.setText(DateTimeFormat.getFormat(I18N.getDateTimeFormat()).format(signHistoryItem.getDate()));
		commentLabel.setText(this.signHistoryItem.getComment());

	}

	public void setListener(SignHistoryItemWidgetListener signHistoryItemWidgetListener) {
		assert signHistoryItemWidgetListener != null : "Precondition failed: signHistoryItemWidgetListener != null";

		listener = signHistoryItemWidgetListener;
	}

	public void markAsUnsaved(boolean unsaved) {
		setStyleDependentName("unsaved", unsaved);
	}

	public void setSelected(boolean selected, boolean focus) {
		setStyleDependentName("selected", selected);
		mainPanel.setFocus(focus);
	}

	public interface SignHistoryItemWidgetListener {
		void onClick();

		void onKeyDown(KeyDownEvent event);
	}
}
