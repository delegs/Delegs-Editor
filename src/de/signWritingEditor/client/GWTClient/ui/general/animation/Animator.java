package de.signWritingEditor.client.GWTClient.ui.general.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.Scheduler;

/**
 * An <code>Animator</code> can take animation objects and fire animation step
 * events to them at the given rate.
 */
public class Animator {

	public static final int FPS = 20;

	private static Animator instance = null;

	private Map<Object, List<Animation>> animationsById;

	/**
	 * @return the animator singleton
	 * @ensure @result != null
	 */
	public static Animator getInstance() {
		if (instance == null) {
			instance = new Animator();
		}
		assert instance != null : "Postcondition failed: @result != null";
		return instance;
	}

	protected Animator() {
		animationsById = new HashMap<Object, List<Animation>>();
	}

	/**
	 * Return true, if an animation is currently running.
	 * 
	 * @return is currently an animation running?
	 */
	public boolean isAnimating() {
		return animationsById.size() > 0;
	}

	/**
	 * Returns true if the given Animation is being run by the Animator.
	 * 
	 * @param animation
	 * @return true if the given Animation is being run by the Animator.
	 * @require animation != null
	 */
	public boolean hasAnimation(Animation animation) {
		assert animation != null : "Precondition failed: animation != null";

		boolean result = false;
		for (Object id : animationsById.keySet()) {
			if (animationsById.get(id).contains(animation)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Returns true if any animations with the given id are currently run by the
	 * Animator.
	 * 
	 * @param id
	 * @return true if any animation width the given id is running
	 * @require id != null
	 */
	public boolean hasId(Object id) {
		assert id != null : "Precondition failed: id != null";
		return animationsById.containsKey(id);
	}

	/**
	 * Adds an Animation which will be processed immediately. The animation may
	 * be tagged with an optional id, which can be any object (e.g. the animated
	 * widget). The id is helpful to cancel a certain subset of the currently
	 * running animations.
	 * 
	 * @param optionalId
	 *            an optional object identifying the animation
	 * @param animation
	 * 
	 * @require animation != null
	 * @require !hasAnimation(animation)
	 * @ensure hasAnimation(animation)
	 */
	public synchronized void addAnimation(Object optionalId, Animation animation) {
		assert animation != null : "Precondition failed: animation != null";
		assert !hasAnimation(animation) : "Precondition failed: !hasAnimation(animation)";

		boolean isRunning = animationsById.size() > 0;

		List<Animation> animations = animationsById.get(optionalId);
		if (animations == null) {
			animations = new ArrayList<Animation>();
			animationsById.put(optionalId, animations);
		}
		animations.add(animation);

		if (!isRunning) {
			Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
				@Override
				public boolean execute() {
					return animate();
				}
			}, 1000 / FPS);
		}

		assert hasAnimation(animation) : "Postcondition failed: hasAnimation(animation)";
		assert optionalId == null
				|| hasId(optionalId) : "Postcondition failed: optionalId == null || hasId(optionalId)";
	}

	/**
	 * Adds an Animation that will be called while the Animator is animating.
	 * 
	 * @param animation
	 * @require animation != null
	 * @require !hasAnimation(animation)
	 * @ensure hasAnimation(animation)
	 */
	public synchronized void addAnimation(Animation animation) {
		addAnimation(null, animation);
	}

	/**
	 * Removes an Animation from the Animator.
	 * 
	 * @param animation
	 *            the animation to be removed.
	 * @require animation != null
	 * @ensure !hasAnimation(animation)
	 */
	public synchronized void stopAnimation(Animation animation) {
		assert animation != null : "Precondition failed: animation != null";
		for (List<Animation> animations : animationsById.values()) {
			animations.remove(animation);
		}
		assert !hasAnimation(animation) : "Postcondition failed: !hasAnimation(animation)";
	}

	/**
	 * Removes all animations of the given id from the Animator.
	 * 
	 * @param id
	 * @require id != null
	 * @ensure !hasId(id)
	 */
	public synchronized void removeAnimations(Object id) {
		assert id != null : "Precondition failed: id != null";
		animationsById.remove(id);
		assert !hasId(id) : "Postcondition failed: !hasId(id)";
	}

	// protected interface

	/**
	 * @return true if there are animations running
	 */
	protected synchronized boolean animate() {
		List<Object> idsToRemove = null;

		for (Object id : animationsById.keySet()) {
			List<Animation> animations = animationsById.get(id);
			for (int i = animations.size() - 1; i >= 0; i--) {
				Animation animation = animations.get(i);
				if (!animation.isDone()) {
					animation.step();
				} else {
					animations.remove(i);
				}
			}
			if (animations.size() == 0) {
				// can't delete directly because of concurrent modification
				// exception :-(
				if (idsToRemove == null) {
					idsToRemove = new ArrayList<>();
				}
				idsToRemove.add(id);
			}
		}

		if (idsToRemove != null) {
			for (Object id : idsToRemove) {
				animationsById.remove(id);
			}
		}

		return animationsById.size() > 0;
	}
}
