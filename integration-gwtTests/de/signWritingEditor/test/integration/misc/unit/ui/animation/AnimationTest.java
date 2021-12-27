package de.signWritingEditor.test.integration.misc.unit.ui.animation;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

import de.signWritingEditor.client.GWTClient.ui.general.animation.Animation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.Animator;

public abstract class AnimationTest extends GWTTestCase {

	private static final int INTERMEDIATE_STEPS_COUNT = 30;
	private static final int ANIMATION_DELAY = 2;

	private Animation.Listener animationListener;

	@Test
	@Ignore
	// TO enable rename test to testAnimation and remove abstract modifier from
	// AnimationTest
	public void ignoretestAnimation() {
		animationListener = new Animation.Listener() {
			private int testListenerStepCounter = 0;

			@Override
			public void onStep(int index, int count) {
				assertEquals(testListenerStepCounter, index);
				testListenerStepCounter += 1;
			}

			@Override
			public void onDone() {
				assertEquals(INTERMEDIATE_STEPS_COUNT + 1, testListenerStepCounter);
				finishTest();
			}
		};

		Animation testAnimation = new Animation(INTERMEDIATE_STEPS_COUNT, ANIMATION_DELAY, animationListener) {
			int testAnimationStepCount = 0;

			@Override
			protected void doStep() {
				assertTrue(
						"Too many animation steps: " + testAnimationStepCount + " <= " + INTERMEDIATE_STEPS_COUNT + 1,
						testAnimationStepCount <= INTERMEDIATE_STEPS_COUNT + 1);
				testAnimationStepCount++;
			}
		};

		assertEquals(ANIMATION_DELAY, testAnimation.getStepDelay());
		assertEquals(-ANIMATION_DELAY, testAnimation.getStepIndex());
		assertEquals(INTERMEDIATE_STEPS_COUNT, testAnimation.getStepCount());

		Animator.getInstance().addAnimation(testAnimation);
		delayTestFinish(30000); // wait up to 30 seconds for animation to finish
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}
}
