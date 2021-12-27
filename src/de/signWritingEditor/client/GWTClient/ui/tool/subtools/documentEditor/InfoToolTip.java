package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowAlignment;
import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPanel.ArrowDirection;

public class InfoToolTip extends Composite {

	private static final String BACKGROUND_COLOR = "#E4E4E4";
	private SimplePanel toolTipWrapperPanel;
	private HTML infoHtmlLabel;

	public InfoToolTip() {
		toolTipWrapperPanel = new SimplePanel();
		toolTipWrapperPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);

		ArrowPanel toolTipPanel = new ArrowPanel(ArrowDirection.RIGHT, ArrowAlignment.ALIGN_CENTER);
		toolTipWrapperPanel.add(toolTipPanel);

		infoHtmlLabel = new HTML("");
		toolTipPanel.add(infoHtmlLabel);

		initWidget(toolTipWrapperPanel);

		this.getElement().getStyle().setProperty("zIndex", "1001");
		infoHtmlLabel.getElement().getStyle().setProperty("minHeight", "37px");
		infoHtmlLabel.getElement().getStyle().setProperty("display", "flex");
		infoHtmlLabel.getElement().getStyle().setProperty("alignItems", "center");
		infoHtmlLabel.getElement().getStyle().setProperty("backgroundColor", BACKGROUND_COLOR);
	}

	public void setSize(String width, String height) {
		toolTipWrapperPanel.setSize(width, height);
	}

	public void setPosition(int left, int top) {
		RootPanel.get().setWidgetPosition(this, left, top);
	}

	public void setVisible(boolean visible) {
		toolTipWrapperPanel.setVisible(visible);
	}

	public void setText(String text) {
		infoHtmlLabel.setHTML(text);
	}
}
