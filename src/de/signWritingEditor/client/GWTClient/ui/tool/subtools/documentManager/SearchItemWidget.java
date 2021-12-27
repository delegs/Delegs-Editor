package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.shared.model.material.FileItem;

public class SearchItemWidget extends Composite {
	public static final int HEIGHT = 20;
	private FocusPanel mainPanel;
	private Label documentTitleLabel;

	public void init(final FileItem fileItem, final SearchItemWidgetListener listener) {
		assert fileItem != null : "Precondition failed: documentItem != null";
		assert listener != null : "Precondition failed: listener != null";

		mainPanel = new FocusPanel();
		mainPanel.setStyleName("searchItemWidget");
		mainPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		initWidget(mainPanel);
		FlowPanel flowPanel = new FlowPanel();
		documentTitleLabel = new Label(fileItem.getFileTitle().getDisplayTitleString());
		documentTitleLabel.setStyleName("foundDocumentItemWidget");
		flowPanel.add(documentTitleLabel);
		flowPanel.getElement().getStyle().setPosition(Position.RELATIVE);

		mainPanel.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				listener.onDoubleClick(fileItem);

			}
		});
		mainPanel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				listener.onClick(fileItem);
			}
		});

		mainPanel.add(flowPanel);
	}

	public void setColored(boolean colored) {
		if (colored) {
			mainPanel.addStyleName("searchItemWidget-colored");
		}
	}

	public void setText(String text) {
		assert text != null : "Precondition failed: text != null";
		documentTitleLabel.setText(text);
	}

	public void setSelected(boolean selected) {
		setStyleDependentName("selected", selected);
		mainPanel.setFocus(selected);
	}

	public interface SearchItemWidgetListener {
		void onDoubleClick(FileItem fileItem);

		void onClick(FileItem fileItem);
	}

}
