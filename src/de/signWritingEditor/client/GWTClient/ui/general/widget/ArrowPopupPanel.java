package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ArrowPopupPanel extends ArrowPanel {
	private HandlerRegistration clickHandlerRegistration;
	private final ArrowAlignment alignment;
	private HandlerRegistration attachHandlerRegistration;
	private Widget widgetAbove;

	public ArrowPopupPanel() {
		this(ArrowAlignment.ALIGN_LEFT);
	}

	public ArrowPopupPanel(ArrowAlignment alignment) {
		super(ArrowDirection.UP, alignment);
		this.alignment = alignment;
		getElement().getStyle().setZIndex(100000);
	}

	public void displayBelow(final Widget widget) {
		assert widget != null : "Precondition failed: widget != null";
		assert widget.isAttached() : "Precondition failed: widget.isAttached()";
		assert !isAttached() : "Precondition failed: !isAttached()";

		final RootPanel rootPanel = RootPanel.get();

		clickHandlerRegistration = rootPanel.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Element e = Element.as(event.getNativeEvent().getEventTarget());
				if (ArrowPopupPanel.this.getElement() == null || !ArrowPopupPanel.this.getElement().isOrHasChild(e)) {
					close();
				}
			}
		}, ClickEvent.getType());
		rootPanel.sinkEvents(Event.ONCLICK);

		attachHandlerRegistration = this.addAttachHandler(new AttachEvent.Handler() {
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				handleWidgetAttached(widget);
			}
		});

		rootPanel.add(this, widget.getAbsoluteLeft(), widget.getAbsoluteTop() + widget.getOffsetHeight() + 3);
		widgetAbove = widget;

		this.addStyleName("arrowPopupPanel");
	}

	public void displayInCenter() {
		assert !isAttached() : "Precondition failed: !isAttached()";

		final RootPanel rootPanel = RootPanel.get();

		clickHandlerRegistration = rootPanel.addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				close();
			}
		}, ClickEvent.getType());
		rootPanel.sinkEvents(Event.ONCLICK);

		rootPanel.add(this, (rootPanel.getOffsetWidth() - this.getOffsetWidth()) / 2,
				(rootPanel.getOffsetHeight() - this.getOffsetHeight()) / 2);

		this.addStyleName("FindMeFast");
	}

	public Widget getWidgetAbove() {
		assert isAttached() : "Precondition failed: isAttached()";
		return widgetAbove;
	}

	public void close() {
		RootPanel.get().remove(ArrowPopupPanel.this);
		widgetAbove = null;
		clickHandlerRegistration.removeHandler();
	}

	protected void handleWidgetAttached(final Widget widget) {
		double leftPos;
		if (alignment == ArrowAlignment.ALIGN_LEFT) {
			leftPos = widget.getAbsoluteLeft();
		} else if (alignment == ArrowAlignment.ALIGN_RIGHT) {
			leftPos = widget.getAbsoluteLeft() - ArrowPopupPanel.this.getOffsetWidth()
					+ (widget.getOffsetWidth() / 2.0);
			leftPos += 11.5; // 8.5 == arrowImage size / 2 ; 10 == this margin
								// right ; -7 == button padding left
		} else {
			leftPos = widget.getAbsoluteLeft()
					- (ArrowPopupPanel.this.getOffsetWidth() + widget.getOffsetWidth()) / 2.0;
		}

		RootPanel.get().setWidgetPosition(ArrowPopupPanel.this, (int) Math.round(leftPos),
				widget.getAbsoluteTop() + widget.getOffsetHeight() + 3);

		attachHandlerRegistration.removeHandler();
	}
}
