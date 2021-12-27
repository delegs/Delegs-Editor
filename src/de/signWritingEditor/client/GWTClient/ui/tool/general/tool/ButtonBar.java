package de.signWritingEditor.client.GWTClient.ui.tool.general.tool;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.shared.model.domainValue.Orientation;

public abstract class ButtonBar extends Composite {

	protected FlowPanel orientedFlowPanel;

	public ButtonBar() {
		orientedFlowPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);

		initWidget(orientedFlowPanel);
	}

	public void addWidget(Widget button) {
		assert button != null : "Precondition failed: button != null";

		orientedFlowPanel.add(button);
	}
}
