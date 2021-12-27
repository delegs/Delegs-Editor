package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;

public class SeparatorPanel extends SimplePanel {

	private static final int MARGIN_BOTTOM = 20;

	public SeparatorPanel() {
		super();
		this.getElement().getStyle().setProperty("borderTop", "1px solid #CCCCCC");
		this.getElement().getStyle().setMarginBottom(MARGIN_BOTTOM, Unit.PX);
	}

}
