package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class SidebarEditor extends Composite {
	private Label headerLabel;
	private FlowPanel mainPanel;

	public SidebarEditor(String headerLabelText) {
		assert headerLabelText != null : "Precondition failed: headerLabelText != null";

		mainPanel = new FlowPanel();
		initWidget(mainPanel);
		mainPanel.setStyleName("sidebarEditor");

		headerLabel = new Label(headerLabelText);
		mainPanel.add(headerLabel);
		headerLabel.setStyleName("headerLabel");
	}

	protected void setHeaderLabelText(String newText) {
		assert newText != null : "Precondition failed: newText != null";

		headerLabel.setText(newText);

		assert getHeaderLabelText().equals(newText) : "Postcondition failed: getHeaderLabelText().equals(newText)";
	}

	protected String getHeaderLabelText() {
		String result = headerLabel.getText();

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected void addContent(Widget content) {
		assert content != null : "Precondition failed: content != null";

		mainPanel.add(content);
	}

	protected void removeContent(Widget content) {
		assert content != null : "Precondition failed: content != null";

		mainPanel.remove(content);
	}

	public void updateSidebar() {
	}

	public abstract void resetSidebar();
}
