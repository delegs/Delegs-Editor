package de.signWritingEditor.client.GWTClient.ui.general.animation;

public abstract class SimpleAnimation extends Animation {

	public SimpleAnimation(int stepCount, int stepDelay, Listener listener) {
		super(stepCount, stepDelay, listener);
	}

	@Override
	protected void doStep() {
	}

}
