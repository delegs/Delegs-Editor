package de.signWritingEditor.client.GWTClient.ui.general.animation;

public abstract class Animation {

	private Listener listener;

	private int stepIndex;
	private int stepCount;
	private int stepDelay;

	public Animation(int stepCount) {
		this(stepCount, 0);
	}

	public Animation(int stepCount, int stepDelay) {
		this(stepCount, stepDelay, null);
	}

	/**
	 * @param stepCount
	 *            number of intermediate steps
	 * @param optionalListener
	 * @require stepCount >= 0
	 * @require stepDelay >= 0
	 * @ensure getStepCount() == stepCount
	 * @ensure getStepDelay() == stepDelay
	 */
	public Animation(int stepCount, int stepDelay, Listener optionalListener) {
		assert stepCount >= 0 : "Precondition failed: stepCount >= 0";
		assert stepDelay >= 0 : "Precondition failed: stepDelay >= 0";

		this.stepIndex = -stepDelay;
		this.stepCount = stepCount;
		this.stepDelay = stepDelay;

		this.listener = optionalListener;

		assert getStepCount() == stepCount : "Postcondition failed: getStepCount() == stepCount";
		assert getStepDelay() == stepDelay : "Postcondition failed: getStepDelay() == stepDelay";
	}

	/**
	 * @return the number of intermediate steps of the animation
	 * @ensure @result >= 0
	 */
	public final int getStepCount() {
		assert stepCount >= 0 : "Postcondition failed: @result >= 0";
		return stepCount;
	}

	/**
	 * @return the number of steps before the animation starts
	 * @ensure @result >= 0
	 */
	public final int getStepDelay() {
		assert stepDelay >= 0 : "Postcondition failed: @result >= 0";
		return stepDelay;
	}

	/**
	 * @return
	 * @require !isDone()
	 * @ensure @result >= -getStepDelay()
	 * @ensure @result <= getStepCount()
	 */
	public synchronized final int getStepIndex() {
		assert !isDone() : "Precondition failed: !isDone()";
		assert stepIndex >= -getStepDelay() : "Postcondition failed: @result >= -getStepDelay()";
		assert stepIndex <= getStepCount() : "Postcondition failed: @result <= getStepCount()";
		return stepIndex;
	}

	/**
	 * If the animation is enabled, any animator that the animation is added to
	 * will call this method for each animation step.
	 * 
	 * @require !isDone()
	 */
	public synchronized final void step() {
		assert !isDone() : "Precondition failed: !isDone()";

		if (stepIndex >= 0) {
			doStep();

			if (listener != null) {
				listener.onStep(stepIndex, stepCount);
			}
		}

		stepIndex++;

		if (listener != null && isDone()) {
			listener.onDone();
		}
	}

	/**
	 * @return has the animation started yet?
	 */
	public synchronized final boolean hasStarted() {
		return stepIndex >= 0;
	}

	/**
	 * @return is the animation done?
	 */
	public synchronized final boolean isDone() {
		return stepIndex > stepCount;
	}

	// protected interface

	/**
	 * @return a factor between 0.0 (step 0) to 1.0 (done) that corresponds to
	 *         the current step
	 * @ensure result >= 0d
	 * @ensure result <= 1d
	 */
	protected synchronized double getStepFactor() {
		double result = (double) getStepIndex() / getStepCount();
		assert result >= 0d : "Postcondition failed: result >= 0d";
		assert result <= 1d : "Postcondition failed: result <= 1d";
		return result;
	}

	/**
	 * @require hasStarted()
	 * @require !isDone()
	 */
	protected abstract void doStep();

	// listener class

	public static abstract class Listener {
		/**
		 * @require index >= 0
		 * @require index <= count
		 * @require count >= 0
		 */
		public void onStep(int index, int count) {
			// nothing by default
		}

		public void onDone() {
			// nothing by default
		}
	}
}
