package de.badge.client.gwtService;

import com.google.gwt.user.client.Timer;

public abstract class LockingTimer extends Timer {

	private boolean isLocked = false;

	public LockingTimer() {
		super();
	}

	@Override
	public void run() {
		if (!isLocked) {
			isLocked = true;
			doRun();
		}
	}

	public abstract void doRun();

	public void finished(boolean success) {
		if (success) {
			this.cancel();
		}

		isLocked = false;
	}

}
