package de.signWritingEditor.client.GWTClient.ui.tool.general.tool;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ToolBarButton extends Composite
		implements HasClickHandlers, HasMouseOverHandlers, HasMouseOutHandlers, HasMouseDownHandlers, HasBlurHandlers {
	private FocusPanel mainPanel;
	private FlowPanel flowPanel;

	private Image enabledImage;
	private Image disabledImage;

	private boolean isEnabled;
	private boolean isDown;
	private boolean isPressed;

	private HandlerRegistration handlerRegister;

	private ClickHandler enabledClickHandler;

	private String tempDisplayStyle; // To preserve display style when hiding
										// with display: none

	public ToolBarButton(Image image, String text, ClickHandler clickHandler) {
		this(image, null, text, clickHandler);
	}

	public ToolBarButton(Image enabledImage, Image disabledImage, String text, ClickHandler clickHandler) {
		assert enabledImage != null : "Precondition failed: enabledImage != null";
		assert text != null : "Precondition failed: text != null";
		assert clickHandler != null : "Precondition failed: clickHandler != null";

		this.enabledImage = enabledImage;
		this.disabledImage = disabledImage;

		isEnabled = true;
		isDown = false;
		enabledClickHandler = clickHandler;

		mainPanel = new FocusPanel();
		initWidget(mainPanel);
		setStylePrimaryName("toolBarButton");

		flowPanel = new FlowPanel();
		mainPanel.add(flowPanel);

		flowPanel.add(enabledImage);

		Label label = new Label(text);
		label.setStyleName("label");
		flowPanel.add(label);

		handlerRegister = mainPanel.addClickHandler(clickHandler);

		// Change shape on click:
		Event.addNativePreviewHandler(new NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				// recognize mouse up event even if it occurs outside the button
				if (event.getTypeInt() == Event.ONMOUSEUP) {
					isDown = false;
				}
			}
		});

		mainPanel.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				if (ToolBarButton.this.isEnabled) {
					setDown(true);
					removeStyleName("toolBarButton-hover");
					isDown = true;
				}
				// Prevent text selection:
				event.preventDefault();
			}
		});

		mainPanel.addMouseUpHandler(new MouseUpHandler() {
			@Override
			public void onMouseUp(MouseUpEvent event) {
				if (!isPressed()) {
					setDown(false);
				}
			}
		});

		mainPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if (ToolBarButton.this.isEnabled && !isPressed()) {
					if (isDown()) {
						setDown(true);
					} else {
						addStyleName("toolBarButton-hover");
					}
				}
			}
		});

		mainPanel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				if (!isPressed()) {
					setDown(false);
				}
				removeStyleName("toolBarButton-hover");
			}
		});

		mainPanel.addMouseMoveHandler(new MouseMoveHandler() {
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				// Prevent text selection:
				event.preventDefault();
			}
		});
	}

	private boolean isDown() {
		return isDown;
	}

	private boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean pressed) {
		this.isPressed = pressed;
		setDown(pressed);
	}

	private void setDown(boolean isDown) {
		if (isDown) {
			addStyleName("toolBarButton-down");
		} else {
			removeStyleName("toolBarButton-down");
		}
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return mainPanel.addClickHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return mainPanel.addMouseOverHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return mainPanel.addMouseOutHandler(handler);
	}

	@Override
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return mainPanel.addMouseDownHandler(handler);
	}

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return mainPanel.addBlurHandler(handler);
	}

	public void setEnabledImage(Image image) {
		assert image != null : "Precondition failed: image != null";

		int imageIndex = flowPanel.getWidgetIndex(enabledImage);
		flowPanel.remove(enabledImage);

		enabledImage = image;

		flowPanel.insert(image, imageIndex);
	}

	public void setEnabled(boolean enabled) {
		if (!(enabled && this.isEnabled)) {
			if (!enabled) {
				this.addStyleName("toolBarButtonDisabled");
				flowPanel.remove(enabledImage);
				flowPanel.add(disabledImage);
				// don't remove unregistered handler
				if (this.isEnabled) {
					handlerRegister.removeHandler();
				}
			} else {
				this.removeStyleName("toolBarButtonDisabled");
				flowPanel.remove(disabledImage);
				flowPanel.add(enabledImage);
				handlerRegister = mainPanel.addClickHandler(enabledClickHandler);
			}

			this.isEnabled = enabled;
		}
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	@Override
	public void setVisible(boolean visible) {
		// Make sure old the old display value is preserved
		if (visible && tempDisplayStyle != null) {
			getElement().getStyle().setProperty("display", tempDisplayStyle);
		} else {
			String display = getElement().getStyle().getDisplay();
			if (!display.equals("none")) {
				tempDisplayStyle = display;
				getElement().getStyle().setProperty("display", "none");
			}
		}
	}
}
