package de.signWritingEditor.client.GWTClient.ui.general.animation;

import com.google.gwt.user.client.ui.Widget;

public class ResizeToWidgetSizeAnimation extends Animation {

	private final Widget resizeWidget;
	private final Widget targetSizeWidget;

	/**
	 * @param resizeWidget
	 * @param targetSizeWidget
	 * @param stepCount
	 * @param stepDelay
	 * @param optionalListener
	 * @require resizeWidget != null
	 * @require targetSizeWidget != null
	 * @require stepCount >= 0
	 * @require stepDelay >= 0
	 * @ensure getResizeWidget() == resizeWidget
	 * @ensure getTargetSizeWidget() == targetSizeWidget
	 * @ensure getStepCount() == stepCount
	 */
	public ResizeToWidgetSizeAnimation(Widget resizeWidget, Widget targetSizeWidget, int stepCount, int stepDelay,
			Listener optionalListener) {
		super(stepCount, stepDelay, optionalListener);

		assert resizeWidget != null : "Precondition failed: resizeWidget != null";
		assert targetSizeWidget != null : "Precondition failed: targetSizeWidget != null";

		this.resizeWidget = resizeWidget;
		this.targetSizeWidget = targetSizeWidget;

		assert getResizeWidget() == resizeWidget : "Postcondition failed: getResizeWidget() == resizeWidget";
		assert getTargetSizeWidget() == targetSizeWidget : "Postcondition failed: getTargetSizeWidget() == targetSizeWidget";
	}

	/**
	 * @return the widget to resize
	 * @ensure result != null
	 */
	public Widget getResizeWidget() {
		assert resizeWidget != null : "Postcondition failed: result != null";
		return resizeWidget;
	}

	/**
	 * @return the widget defining the target size
	 * @ensure result != null
	 */
	private Widget getTargetSizeWidget() {
		assert targetSizeWidget != null : "Postcondition failed: result != null";
		return targetSizeWidget;
	}

	@Override
	protected void doStep() {
		int startWidth = resizeWidget.getOffsetWidth();
		int startHeight = resizeWidget.getOffsetHeight();

		int endWidth = targetSizeWidget.getOffsetWidth();
		int endHeight = targetSizeWidget.getOffsetHeight();

		int stepWidth = endWidth + 1;
		int stepHeight = endHeight + 1;
		if (getStepIndex() < getStepCount()) {
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
		UiUtil.setPixelSize(resizeWidget, stepWidth, stepHeight);
	}

}
