package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractCursorImpl extends Composite
		implements Focusable, HasAllFocusHandlers, HasAllKeyHandlers {

	private TextArea textBox;
	private CursorListener cursorListener;
	private Set<CursorPasteHandler> pasteHandlers;

	public AbstractCursorImpl() {
		pasteHandlers = new HashSet<AbstractCursorImpl.CursorPasteHandler>();
		textBox = new TextArea() {
			@Override
			public void onBrowserEvent(Event event) {
				super.onBrowserEvent(event);

				if (event.getTypeInt() == Event.ONPASTE) {
					firePasteEvent();
				}
			}
		};
		textBox.sinkEvents(Event.ONPASTE);
		initWidget(createCursor(textBox));
		DOM.setElementAttribute(textBox.getElement(), "id", "textBoxId");
	}

	private void firePasteEvent() {
		for (CursorPasteHandler pasteHandler : pasteHandlers) {
			pasteHandler.onPaste();
		}
	}

	protected abstract Widget createCursor(TextArea textBox);

	public String getText() {
		return textBox.getText();
	}

	public void setText(String text) {
		textBox.setText(text);
	}

	@Override
	public void onBrowserEvent(Event event) {
		if (cursorListener != null) {
			cursorListener.onBrowserEvent(event);
		}
		super.onBrowserEvent(event);
	}

	@Override
	public void setFocus(boolean focused) {
		textBox.setFocus(focused);
	}

	@Override
	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
		return textBox.addKeyUpHandler(handler);
	}

	@Override
	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return textBox.addKeyDownHandler(handler);
	}

	@Override
	public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
		return textBox.addKeyPressHandler(handler);
	}

	@Override
	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return textBox.addFocusHandler(handler);
	}

	@Override
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return textBox.addBlurHandler(handler);
	}

	public HandlerRegistration addPasteHandler(final CursorPasteHandler handler) {
		pasteHandlers.add(handler);

		HandlerRegistration result = new HandlerRegistration() {
			@Override
			public void removeHandler() {
				pasteHandlers.remove(handler);
			}
		};

		return result;
	}

	public void setCursorListener(CursorListener cursorListener) {
		assert cursorListener != null : "Precondition failed: cursorListener != null";

		sinkEvents(Event.ONCLICK | Event.ONMOUSEDOWN | Event.ONMOUSEUP | Event.ONMOUSEMOVE);
		this.cursorListener = cursorListener;
	}

	@Override
	public int getTabIndex() {
		return -1;
	}

	@Override
	public void setAccessKey(char key) {
	}

	@Override
	public void setTabIndex(int index) {
	}

	public static class SpanPanel extends SimplePanel {
		public SpanPanel() {
			super(DOM.createSpan());
		}
	}

	public interface CursorListener {
		void onBrowserEvent(Event event);
	}

	public interface CursorPasteHandler {
		public void onPaste();
	}

}
