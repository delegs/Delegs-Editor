package de.signWritingEditor.client.GWTClient.ui.general.animation;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

public class SlideWidgetAnimation extends Animation {

	private Widget widget;

	private double startX;
	private double startY;
	private double endX;
	private double endY;

	/**
	 * @param widget
	 * @param endX
	 * @param endY
	 * @param stepCount
	 * @param stepDelay
	 * @param optionalListener
	 * @require widget != null
	 * @require widget.getParent() != null
	 * @require widget.getParent() instanceof AbsolutePanel
	 * @require stepCount >= 0
	 * @require stepDelay >= 0
	 * @ensure getWidget() == widget
	 * @ensure getEndX() == endX
	 * @ensure getEndY() == endY
	 */
	public SlideWidgetAnimation(Widget widget, double endX, double endY, int stepCount, int stepDelay,
			Animation.Listener optionalListener) {
		super(stepCount, stepDelay, optionalListener);

		assert widget != null : "Precondition failed: widget != null";
		assert widget.getParent() != null : "Precondition failed: widget.getParent() != null";
		assert widget
				.getParent() instanceof AbsolutePanel : "Precondition failed: widget.getParent() instanceof AbsolutePanel";

		this.widget = widget;

		AbsolutePanel parent = (AbsolutePanel) widget.getParent();
		this.startX = parent.getWidgetLeft(widget);
		this.startY = parent.getWidgetTop(widget);
		this.endX = endX;
		this.endY = endY;

		assert getWidget() == widget : "Postcondition failed: getWidget() == widget";
		assert getEndX() == endX : "Postcondition failed: getEndX() == endX";
		assert getEndY() == endY : "Postcondition failed: getEndY() == endY";
	}

	public Widget getWidget() {
		assert widget != null : "Postcondition failed: @result != null";
		return widget;
	}

	public double getEndX() {
		return endX;
	}

	public double getEndY() {
		return endY;
	}

	// protected interface

	protected void doStep() {
		// skip, if widget was removed from absolute parent in the meantime
		if (widget.getParent() != null && widget.getParent() instanceof AbsolutePanel) {
			double x = (endX - startX) * getStepFactor() + startX;
			double y = (endY - startY) * getStepFactor() + startY;

			UiUtil.setPixelPos(widget, (int) x, (int) y);
		}
	}
}