package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

public class SearchWidget extends Composite {

	private final AbsolutePanel mainPanel;
	private final SearchWidgetListener listener;

	public static final int SEARCH_WIDGET_HEIGHT = 30;
	public static final int SEARCH_BOX_HEIGHT = 20;
	public static final int TOP_OFFSET = 2;
	private TextBox searchBox;
	private int width;

	public SearchWidget(int width, SearchWidgetListener listener) {
		this.width = width;
		this.listener = listener;

		mainPanel = new AbsolutePanel();
		mainPanel.setHeight(SEARCH_WIDGET_HEIGHT + "px");
		mainPanel.setWidth(width + "px");
		initWidget(mainPanel);
		mainPanel.setStyleName("searchWidget");
		addSearchBox();
	}

	private void addSearchBox() {
		searchBox = new TextBox();
		searchBox.setWidth(width - 10 + "px");
		searchBox.setHeight(SEARCH_BOX_HEIGHT + "px");
		searchBox.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {

				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					listener.onHitReturn(searchBox.getText());
				}
			}
		});
		searchBox.ensureDebugId("searchBox");

		mainPanel.add(searchBox);

	}

	public interface SearchWidgetListener {
		void onHitReturn(String searchString);
	}

	public void clearSearchBox() {
		searchBox.setText("");
	}

	public String getSearchText() {
		return searchBox.getText();
	}

	public void focusTextbox() {
		searchBox.setFocus(true);
	}

}
