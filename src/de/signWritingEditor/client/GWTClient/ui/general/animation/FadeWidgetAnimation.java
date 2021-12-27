package de.signWritingEditor.client.GWTClient.ui.general.animation;

import com.google.gwt.user.client.ui.Widget;

public class FadeWidgetAnimation extends Animation {

	private Widget widget;

	private double startOpacity;
	private double endOpacity;

	private boolean isAlwaysVisible;

	/**
	 * @param widget
	 * @param endOpacity
	 * @param isAlwaysVisible
	 *            fully transparent but not invisible, if opacity is zero
	 * @param stepCount
	 * @param stepDelay
	 * @param optionalListener
	 * @require widget != null
	 * @require endOpacity >= 0d && endOpacity <= 1d
	 * @require stepCount >= 0
	 * @require stepDelay >= 0
	 * @ensure getWidget() == widget
	 * @ensure getStepCount() == stepCount
	 */
	public FadeWidgetAnimation(Widget widget, double endOpacity, boolean isAlwaysVisible, int stepCount, int stepDelay,
			Animation.Listener optionalListener) {
		super(stepCount, stepDelay, optionalListener);

		assert widget != null : "Precondition failed: widget != null";
		assert endOpacity >= 0d && endOpacity <= 1d : "Precondition failed: endOpacity >= 0d && endOpacity <= 1d";
		assert stepCount >= 0 : "Precondition failed: stepCount >= 0";

		this.widget = widget;

		String opacityStr = widget.getElement().getStyle().getOpacity();
		this.startOpacity = 1d;
		if (opacityStr != null && !opacityStr.equals(""))
			this.startOpacity = Double.parseDouble(opacityStr);

		this.endOpacity = endOpacity;
		this.isAlwaysVisible = isAlwaysVisible;

		assert getWidget() == widget : "Postcondition failed: getWidget() == widget";
		assert getStepCount() == stepCount : "Postcondition failed: getStepCount() == stepCount";
	}

	public Widget getWidget() {
		assert widget != null : "Postcondition failed: @result != null";
		return widget;
	}

	// protected interface

	protected void doStep() {
		double opacity = getStepFactor();
		if (opacity < 0.01d) {
			opacity = 0d;
		} else if (opacity > 0.99d) {
			opacity = 1d;
		}

		if (startOpacity < endOpacity) {
			if (opacity < startOpacity) {
				opacity = startOpacity;
			} else if (opacity > endOpacity) {
				opacity = endOpacity;
			}
		} else {
			opacity = 1d - opacity;

			if (opacity > startOpacity) {
				opacity = startOpacity;
			} else if (opacity < endOpacity) {
				opacity = endOpacity;
			}
		}

		UiUtil.setOpacity(widget, opacity, isAlwaysVisible);
	}
}