package de.signWritingEditor.client.GWTClient.ui.tool.general.signTooltip;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.animation.Animator;
import de.signWritingEditor.client.GWTClient.ui.general.animation.FadeWidgetAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.ResizeWidgetAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.SimpleAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.SlideWidgetAnimation;
import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.i18n.I18NAccess;

public class SignTooltip extends Composite {

	public static enum ArrowDirection {
		UP("Up"), RIGHT("Right"), DOWN("Down"), LEFT("Left");

		private String styleDependentName;

		private ArrowDirection(String styleDependentName) {
			assert styleDependentName != null : "Precondition failed: styleDependentName != null";
			this.styleDependentName = styleDependentName;
			assert getStyleDependentName().equals(
					styleDependentName) : "Postcondition failed: getStyleDependentName().equals(styleDependentName)";
		}

		public String getStyleDependentName() {
			assert styleDependentName != null : "Postcondition failed: result != null";
			return styleDependentName;
		}
	}

	private int x;
	private int y;

	private int arrOffsX;
	private int arrOffsY;
	private ArrowDirection arrowDirection;

	private int imgPaddX;
	private int imgPaddY;
	private int imgWidth;
	private int imgHeight;
	private String imageName;

	private AbsolutePanel mainPanel;
	private AbsolutePanel imagePanel;
	private Image image;
	private AbsolutePanel arrowPanel;

	private VisibilityTimer visibilityTimer;

	public SignTooltip() {
		x = 0;
		y = 0;

		arrOffsX = 0;
		arrOffsY = 0;
		arrowDirection = ArrowDirection.LEFT;

		imgPaddX = 0;
		imgPaddY = 0;
		imgWidth = 0;
		imgHeight = 0;
		imageName = null;

		mainPanel = new AbsolutePanel();
		initWidget(mainPanel);

		imagePanel = new AbsolutePanel();
		imagePanel.setStylePrimaryName("signTooltip-Image");
		mainPanel.add(imagePanel);

		image = new Image();
		image.ensureDebugId("signToolTip-image");
		image.setPixelSize(0, 0);
		imagePanel.add(image);

		arrowPanel = new AbsolutePanel();
		arrowPanel.setStylePrimaryName("signTooltip-Arrow");
		mainPanel.add(arrowPanel);

		setVisible(false);
		visibilityTimer = new VisibilityTimer() {
			@Override
			public void run() {
				if (isVisible()) {
					showImmediately(getX(), getY(), getArrowDirection(), getImageName(), getImageWidth(),
							getImageHeight());
				} else {
					hideImmediately();
				}
			}
		};
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ArrowDirection getArrowDirection() {
		assert arrowDirection != null : "Postcondition failed: result != null";
		return arrowDirection;
	}

	public String getImageName() {
		return imageName;
	}

	public int getImageWidth() {
		assert imgWidth >= 0 : "Postcondition failed: result >= 0";
		return imgWidth;
	}

	public int getImageHeight() {
		assert imgHeight >= 0 : "Postcondition failed: result >= 0";
		return imgHeight;
	}

	public void show(int x, int y, ArrowDirection arrowDirection, String imageName, int imageWidth, int imageHeight) {
		assert arrowDirection != null : "Precondition failed: arrowDirection != null";
		assert imageName != null : "Precondition failed: imageName != null";
		assert imageWidth >= 0 : "Precondition failed: imageWidth >= 0";
		assert imageHeight >= 0 : "Precondition failed: imageHeight >= 0";

		Animator.getInstance().removeAnimations(this);
		visibilityTimer.cancel();
		visibilityTimer.scheduleShowing(x, y, arrowDirection, imageName, imageWidth, imageHeight);
	}

	public void hide() {
		Animator.getInstance().removeAnimations(this);
		visibilityTimer.cancel();
		visibilityTimer.scheduleHiding();
	}

	public void showImmediately(int x, int y, ArrowDirection arrowDirection, String imageName, int imageWidth,
			int imageHeight) {
		assert getParent() != null
				&& getParent() instanceof AbsolutePanel : "Precondition failed: getParent() != null && getParent() instanceof AbsolutePanel";
		assert arrowDirection != null : "Precondition failed: arrowDirection != null";
		assert imageName != null : "Precondition failed: imageName != null";
		assert imageWidth >= 0 : "Precondition failed: imageWidth >= 0";
		assert imageHeight >= 0 : "Precondition failed: imageHeight >= 0";

		boolean isGerman = true;

		for (I18N i18nOption : I18NAccess.I18N_OPTIONS) {
			if ("de".equalsIgnoreCase(Location.getParameter("locale"))) {
				break;
			} else if (i18nOption.getLocale().name().equalsIgnoreCase(Location.getParameter("locale"))) {
				isGerman = false;
				break;
			}
		}

		if (isGerman) {

			Animator.getInstance().removeAnimations(this);
			visibilityTimer.cancel();

			final int actualWidth = arrOffsX + arrOffsX + imageWidth + imgPaddX - 2;
			final int actualHeight = arrOffsY + arrOffsY + imageHeight + imgPaddY - 2;

			final int actualX;
			final int actualY;
			final int arrX;
			final int arrY;
			if (ArrowDirection.UP.equals(arrowDirection)) {
				actualX = x - arrOffsX;
				actualY = y;
				arrX = arrOffsX;
				arrY = 0;
			} else if (ArrowDirection.RIGHT.equals(arrowDirection)) {
				actualX = x - actualWidth;
				actualY = y - arrOffsY;
				arrX = arrOffsX + imageWidth + imgPaddX - 1;
				arrY = arrOffsY;
			} else if (ArrowDirection.DOWN.equals(arrowDirection)) {
				actualX = x - arrOffsX;
				actualY = y - actualHeight;
				arrX = arrOffsX;
				arrY = arrOffsY + imageHeight + imgPaddY - 1;
			} else {
				actualX = x;
				actualY = y - arrOffsY;
				arrX = 0;
				arrY = arrOffsY;
			}

			if ((this.x == x || this.y == y) && isVisible()) {
				slide(this.arrowDirection, arrowDirection, actualX, actualY, actualWidth, actualHeight, arrX, arrY,
						imageName, imageWidth, imageHeight);
			} else {
				fadeOutAndIn(this.arrowDirection, arrowDirection, actualX, actualY, actualWidth, actualHeight, arrX,
						arrY, imageName, imageWidth, imageHeight);
			}

			this.x = x;
			this.y = y;

			this.arrowDirection = arrowDirection;

			this.imageName = imageName;
			this.imgWidth = imageWidth;
			this.imgHeight = imageHeight;

			assert getX() == x : "Postcondition failed: getLeft() == left";
			assert getY() == y : "Postcondition failed: getTop() == top";
			assert getArrowDirection()
					.equals(arrowDirection) : "Postcondition failed: getPointingDirection().equals(pointingDirection)";
			assert getImageName() != null : "Postcondition failed: getImageUrl() != null";
		}
	}

	public void hideImmediately() {
		Animator.getInstance().removeAnimations(this);
		visibilityTimer.cancel();
		setVisible(false);
	}

	// protected interface

	@Override
	protected void onLoad() {
		super.onLoad();

		// arrowPanel size can only be determined when added to the DOM
		arrOffsX = 23;
		arrOffsY = 23;

		// imagePanel size can only be determined when added to the DOM
		imgPaddX = 12;
		imgPaddY = 12;

		mainPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		mainPanel.setWidgetPosition(imagePanel, arrOffsX, arrOffsY);
		mainPanel.setWidgetPosition(arrowPanel, 0, arrOffsY);
	}

	protected void fadeOutAndIn(final ArrowDirection oldArrowDirection, final ArrowDirection arrowDirection,
			final int actualX, final int actualY, final int actualWidth, final int actualHeight, final int arrX,
			final int arrY, final String imageName, final int imageWidth, final int imageHeight) {
		assert getParent() instanceof AbsolutePanel : "Precondition failed: getParent() instanceof AbsolutePanel";
		assert oldArrowDirection != null : "Precondition failed: oldArrowDirection != null";
		assert arrowDirection != null : "Precondition failed: arrowDirection != null";
		assert actualWidth >= 0 : "Precondition failed: actualWidth >= 0";
		assert actualHeight >= 0 : "Precondition failed: actualHeight >= 0";
		assert imageName != null : "Precondition failed: imageName != null";
		assert imageWidth >= 0 : "Precondition failed: imageWidth >= 0";
		assert imageHeight >= 0 : "Precondition failed: imageHeight >= 0";

		int delay = isVisible() ? 5 : 0;
		Animator.getInstance().addAnimation(this, new SimpleAnimation(1, delay, null) {
			@Override
			protected void doStep() {
				setPixelSize(actualWidth, actualHeight);

				arrowPanel.removeStyleDependentName(oldArrowDirection.getStyleDependentName());
				arrowPanel.addStyleDependentName(arrowDirection.getStyleDependentName());
				mainPanel.setWidgetPosition(arrowPanel, arrX, arrY);

				imagePanel.setPixelSize(imageWidth + imgPaddX, imageHeight + imgPaddY);
				((AbsolutePanel) getParent()).setWidgetPosition(SignTooltip.this, actualX, actualY);

				image.setPixelSize(imageWidth, imageHeight);
				image.setUrl(imageName);
			}
		});
		if (isVisible()) {
			Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(this, 0d, false, 4, 0, null));
		} else {
			getElement().getStyle().setOpacity(0.0);
		}
		Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(this, 1d, false, 9 - delay, delay + 1, null));
	}

	protected void slide(final ArrowDirection oldArrowDirection, final ArrowDirection arrowDirection, final int actualX,
			final int actualY, final int actualWidth, final int actualHeight, final int arrX, final int arrY,
			final String imageName, final int imageWidth, final int imageHeight) {
		assert oldArrowDirection != null : "Precondition failed: oldArrowDirection != null";
		assert arrowDirection != null : "Precondition failed: arrowDirection != null";
		assert actualWidth >= 0 : "Precondition failed: actualWidth >= 0";
		assert actualHeight >= 0 : "Precondition failed: actualHeight >= 0";
		assert imageName != null : "Precondition failed: imageName != null";
		assert imageWidth >= 0 : "Precondition failed: imageWidth >= 0";
		assert imageHeight >= 0 : "Precondition failed: imageHeight >= 0";

		Animator.getInstance().addAnimation(this, new SimpleAnimation(1, 5, null) {
			@Override
			protected void doStep() {
				arrowPanel.removeStyleDependentName(oldArrowDirection.getStyleDependentName());
				arrowPanel.addStyleDependentName(arrowDirection.getStyleDependentName());
				mainPanel.setWidgetPosition(arrowPanel, arrX, arrY);

				image.setPixelSize(imageWidth, imageHeight);
				image.setUrl(imageName);
			}
		});
		Animator.getInstance().addAnimation(this,
				new ResizeWidgetAnimation(this, actualWidth, actualHeight, 10, 0, null));
		Animator.getInstance().addAnimation(this,
				new ResizeWidgetAnimation(imagePanel, imageWidth + imgPaddX, imageHeight + imgPaddY, 10, 0, null));
		Animator.getInstance().addAnimation(this, new SlideWidgetAnimation(this, actualX, actualY, 10, 0, null));
		Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(image, 0d, false, 4, 0, null));
		Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(image, 1d, false, 4, 6, null));
		if (!oldArrowDirection.equals(arrowDirection)) {
			Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(arrowPanel, 0d, false, 4, 0, null));
			Animator.getInstance().addAnimation(this, new FadeWidgetAnimation(arrowPanel, 1d, false, 4, 6, null));
		}
	}

	// inner classes

	private abstract static class VisibilityTimer extends Timer {

		private boolean isVisible;
		private int x;
		private int y;
		private ArrowDirection arrowDirection;
		private String imageName;
		private int imageWidth;
		private int imageHeight;

		public synchronized void scheduleShowing(int x, int y, ArrowDirection arrowDirection, String imageName,
				int imageWidth, int imageHeight) {
			this.isVisible = true;

			this.x = x;
			this.y = y;
			this.arrowDirection = arrowDirection;
			this.imageName = imageName;
			this.imageWidth = imageWidth;
			this.imageHeight = imageHeight;

			schedule(250);
		}

		public synchronized void scheduleHiding() {
			this.isVisible = false;

			schedule(250);
		}

		public synchronized boolean isVisible() {
			return isVisible;
		}

		public synchronized int getX() {
			assert isVisible() : "Precondition failed: isVisible()";
			return x;
		}

		public synchronized int getY() {
			assert isVisible() : "Precondition failed: isVisible()";
			return y;
		}

		public synchronized ArrowDirection getArrowDirection() {
			assert isVisible() : "Precondition failed: isVisible()";
			return arrowDirection;
		}

		public synchronized String getImageName() {
			assert isVisible() : "Precondition failed: isVisible()";
			return imageName;
		}

		public synchronized int getImageWidth() {
			assert isVisible() : "Precondition failed: isVisible()";
			return imageWidth;
		}

		public synchronized int getImageHeight() {
			assert isVisible() : "Precondition failed: isVisible()";
			return imageHeight;
		}
	}

}
