package de.signWritingEditor.client.GWTClient.ui.general.animation;

import com.google.gwt.user.client.ui.Widget;

public class ResizeWidgetAnimation extends Animation {

	private Widget widget;

	private int startWidth;
	private int startHeight;

	private int endWidth;
	private int endHeight;

	/**
	 * @param widget
	 * @param endWidth
	 * @param endHeight
	 * @param stepCount
	 * @param stepDelay
	 * @param optionalListener
	 * @require widget != null
	 * @require endWidth >= 0
	 * @require endHeight >= 0
	 * @require stepCount >= 0
	 * @require stepDelay >= 0
	 * @ensure getWidget() == widget
	 * @ensure getEndWidth() == endWidth
	 * @ensure getEndHeight() == endHeight
	 */
	public ResizeWidgetAnimation(Widget widget, int endWidth, int endHeight, int stepCount, int stepDelay,
			Animation.Listener optionalListener) {
		super(stepCount, stepDelay, optionalListener);

		assert widget != null : "Precondition failed: widget != null";
		assert endWidth >= 0 : "Precondition failed: endWidth >= 0";
		assert endHeight >= 0 : "Precondition failed: endHeight >= 0";

		this.widget = widget;

		this.startWidth = widget.getOffsetWidth();
		this.startHeight = widget.getOffsetHeight();

		this.endWidth = endWidth;
		this.endHeight = endHeight;

		assert getWidget() == widget : "Postcondition failed: getWidget() == widget";
		assert getEndWidth() == endWidth : "Postcondition failed: getEndWidth() == endWidth";
		assert getEndHeight() == endHeight : "Postcondition failed: getEndHeight() == endHeight";
	}

	public Widget getWidget() {
		assert widget != null : "Postcondition failed: @result != null";
		return widget;
	}

	public int getEndWidth() {
		assert endWidth >= 0 : "Postcondition failed: @result >= 0";
		return endWidth;
	}

	public int getEndHeight() {
		assert endHeight >= 0 : "Postcondition failed: @result >= 0";
		return endHeight;
	}

	// protected interface

	protected void doStep() {
		int stepWidth;
		int stepHeight;
		if (getStepIndex() == getStepCount()) {
			stepWidth = endWidth + 1;
			stepHeight = endHeight + 1;
		} else {
			if (startWidth < endWidth) {
				stepWidth = Math.min(startWidth + (endWidth - startWidth) * getStepIndex() / getStepCount(), endWidth);
			} else {
				stepWidth = Math.max(startWidth + (endWidth - startWidth) * getStepIndex() / getStepCount(), endWidth);
			}
			if (startHeight < endHeight) {
				stepHeight = Math.min(startHeight + (endHeight - startHeight) * getStepIndex() / getStepCount(),
						endHeight);
			} else {
				stepHeight = Math.max(startHeight + (endHeight - startHeight) * getStepIndex() / getStepCount(),
						endHeight);
			}
		}
		UiUtil.setPixelSize(widget, stepWidth, stepHeight);
	}
}