package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ImageAndTextButton extends FlowPanel {
	private static final int MARGIN_BOTTOM = 10;
	private Image image;
	private Label label;
	private boolean enabled;

	public ImageAndTextButton(Image buttonImage, String title, ClickHandler clickHandler) {
		init(buttonImage, title, clickHandler);
		enabled = true;
	}

	public void addDisablingClickHandler(final ClickHandler handler) {
		final ClickHandler handlerWrapper = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (enabled) {
					enabled = false;
					handler.onClick(event);
					addStyleName("disabledImageAndTextButton");
				}
			}
		};
		this.addDomHandler(handlerWrapper, ClickEvent.getType());
	}

	public void setEnabled() {
		enabled = true;
		removeStyleName("disabledImageAndTextButton");
	}

	private final void init(Image buttonImage, String title, ClickHandler clickHandler) {
		setImage(buttonImage);
		setText(title);
		if (clickHandler != null) {
			this.addDomHandler(clickHandler, ClickEvent.getType());
		}
		getElement().getStyle().setProperty("BorderRadius", "3px 3px 3px 3px");
		getElement().getStyle().setProperty("MozBoxSizing", "border-box");
		getElement().getStyle().setProperty("WebkitBoxSizing", "border-box");
		getElement().getStyle().setProperty("boxSizing", "border-box");
		getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		getElement().getStyle().setPadding(1, Unit.PX);

		this.addHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				markButton();
			}

		}, MouseOverEvent.getType());
		sinkEvents(Event.ONMOUSEOVER);

		this.addHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				removeMarkUp();
			}

		}, MouseOutEvent.getType());
		sinkEvents(Event.ONMOUSEOUT);
		this.addStyleName("imageAndTextButton");
		this.getElement().getStyle().setMarginBottom(MARGIN_BOTTOM, Unit.PX);
		this.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
	}

	protected void markButton() {
		getElement().getStyle().clearPadding();
		getElement().getStyle().setBackgroundColor("rgba(197, 234, 255, 0.2)");
		getElement().getStyle().setBorderColor("#B5C1FF");
		getElement().getStyle().setBorderWidth(1, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setCursor(Cursor.POINTER);
	}

	protected void removeMarkUp() {
		getElement().getStyle().setProperty("background", "none repeat scroll 0 0 rgba(0, 0, 0, 0)");
		getElement().getStyle().setProperty("border", "none");
		getElement().getStyle().setPadding(1, Unit.PX);
	}

	protected final void setText(String title) {
		if (this.label != null) {
			this.remove(this.label);
		}
		if (title != null) {
			this.label = new HTML(title);
			this.label.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
			this.label.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
			this.insert(this.label, 1);
		}
	}

	protected final void setImage(Image image) {
		if (this.image != null) {
			this.remove(this.image);
		}
		this.image = image;
		this.image.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
		this.insert(this.image, 0);
	}

	public void setEnabled(boolean enabled) {
		if (enabled) {
			getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		} else {
			getElement().getStyle().setDisplay(Display.NONE);
		}
	}

}
