package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.shared.model.domainValue.Orientation;

public class OrientedFlowPanel extends FlowPanel {

	private Orientation orientation;

	public OrientedFlowPanel(Orientation orientation) {
		assert orientation != null : "Precondition failed: orientation != null";

		getElement().setAttribute("align", "left");
		this.setOrientation(orientation);
	}

	@Override
	public void insert(Widget widget, int beforeIndex) {
		assert widget != null : "Precondition failed: widget != null";
		assert beforeIndex >= 0 : "Precondition failed: beforeIndex [" + beforeIndex + "] >= 0";
		assert beforeIndex <= getWidgetCount() : "Precondition failed: beforeIndex [" + beforeIndex
				+ "] <= getWidgetCount() [" + getWidgetCount() + "]";

		setDisplayStyle(widget);

		super.insert(widget, beforeIndex);
	}

	@Override
	public void add(Widget widget) {
		assert widget != null : "Precondition failed: widget != null";

		setDisplayStyle(widget);
		super.add(widget);
	}

	private void setDisplayStyle(Widget widget) {
		if (getOrientation() == Orientation.HORIZONTAL) {
			widget.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		}
	}

	public void setOrientation(Orientation orientation) {
		assert orientation != null : "Precondition failed: orientation != null";

		this.orientation = orientation;
	}

	public Orientation getOrientation() {
		return orientation;
	}
}
