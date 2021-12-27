package de.signWritingEditor.client.GWTClient.ui.general.lazyload;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.Composite;

public abstract class LayoutComposite extends Composite {

	public static interface Listener {
		void onWidgetsRearranged();
	}

	private Listener listener;

	private boolean isInvalidLayout;

	public LayoutComposite(Listener optionalListener) {
		this.listener = optionalListener;

		isInvalidLayout = false;
	}

	/**
	 * Trigger a (deferred) rearrangement of the widgets.
	 */
	public synchronized void invalidateLayout() {
		if (!isInvalidLayout) {
			isInvalidLayout = true;

			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					refreshLayout();
				}
			});
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		invalidateLayout();
	}

	// protected interface

	@Override
	protected void onLoad() {
		super.onLoad();

		invalidateLayout();
	}

	/**
	 * @require isVisible()
	 * @require isAttached()
	 */
	protected abstract void rearrangeWidgets();

	// private operations

	private synchronized void refreshLayout() {
		isInvalidLayout = false;
		if (isVisible() && isAttached()) {
			rearrangeWidgets();

			if (listener != null) {
				listener.onWidgetsRearranged();
			}
		}
	}

}
