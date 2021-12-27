package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTextbasedTokenBoxWidget.MouseDragListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.material.FontMetricSpecifier;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;

public class ExtendedRichTextBox extends TextBox {

	protected boolean isSelected;
	protected Color backgroundColor;
	private EventTranslatorStandardImpl eventTranslator;
	private MouseDragListener mouseDragListener;
	private FontSizeService fontSizeService;

	private static final Color selectedBlendColor = Color.makeFromRGB(181, 214, 255);
	private static final Color selectedBlendColorChromeWin = Color.makeFromRGB(35, 142, 250);

	public ExtendedRichTextBox(EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		assert eventTranslator != null : "Precondition failed: eventTranslator != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.backgroundColor = TextbasedTokenStyleFactory.DEFAULT_TEXT_BACKGROUND_COLOR;
		this.fontSizeService = fontSizeService;
		this.isSelected = false;
		getElement().getStyle().setPaddingTop(1, Unit.PX);

		sinkEvents(Event.ONPASTE);
		this.eventTranslator = eventTranslator;

		this.addMouseDownHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				handleMouseDown(event);
			}

		});
	}

	private void handleMouseDown(MouseDownEvent event) {
		if (!event.getNativeEvent().getShiftKey()) {
			setCursorPos(getCursorPos());
			setFocus(true);
		}
		if (mouseDragListener != null) {
			mouseDragListener.setInDragMode(event);
		}
		event.stopPropagation();
	}

	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		handleBrowserEvent(event);
	}

	private void handleBrowserEvent(Event event) {
		assert event != null : "Precondition failed: event != null";

		String userAgent = Navigator.getUserAgent();

		boolean isOnOpera = userAgent != null && userAgent.toLowerCase().contains("opera");

		int typeInt = event.getTypeInt();
		if (!isOnOpera && typeInt == Event.ONPASTE) {
			handlePaste(event);
		} else if (isOnOpera && typeInt == Event.ONKEYDOWN) {
			if (eventTranslator.getInteractionFromEvent(event).equals(Interaction.PASTE)) {
				handlePaste(event);
			}
		}
	}

	private void handlePaste(Event event) {
		assert event != null : "Precondition failed: event != null";
		assert event.getTypeInt() == Event.ONPASTE || eventTranslator.getInteractionFromEvent(event).equals(
				Interaction.PASTE) : "Precondition failed: event.getTypeInt() == Event.ONPASTE || eventTranslator.getInteractionFromEvent(event).equals(Interaction.PASTE)";

		if (isSelected) {
			setText("");
			setCursorPos(0);
		}

		final int oldCursorPosition = getCursorPosition();

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				int newCursorPosition = getCursorPosition();
				String pastedText = getText().substring(oldCursorPosition, newCursorPosition);

				PasteEvent pasteEvent = new PasteEvent();
				pasteEvent.setPastedText(pastedText);
				pasteEvent.setPositionInToken(oldCursorPosition);
				fireEvent(pasteEvent);
			}
		});
	}

	public HandlerRegistration addPasteHandler(PasteHandler handler) {
		return addHandler(handler, PasteEvent.getType());
	}

	public <E extends HasNativeEvent> Interaction getInteractionFromEvent(E event) {
		return eventTranslator.get(event);
	}

	public int getCursorLeft(FontMetricSpecifier fontMetricSpecifier) {
		int wordWidth = fontSizeService.getPixelSize(fontSizeService.getStringWidth(getText(), fontMetricSpecifier));
		int offsetWidth = getElement().getOffsetWidth();

		int leftOffset = Math.max(0, (offsetWidth - wordWidth) / 2);

		int result = leftOffset + fontSizeService
				.getPixelSize(fontSizeService.getStringWidth(getText(0, getCursorPosition()), fontMetricSpecifier));

		return result;
	}

	public int getCursorAbsoluteLeft() {

		return 0;
	}

	public int getCursorAbsoluteRight() {

		return getText().length();
	}

	public int getCursorPosition() {
		return getCursorPos();
	}

	public int getCursorPositionAt(int left, FontMetricSpecifier fontMetricSpecifier) {
		assert left >= 0 : "Precondition failed: left >= 0";
		int wordWidth = fontSizeService.getPixelSize(fontSizeService.getStringWidth(getText(), fontMetricSpecifier));

		int offsetWidth = getElement().getOffsetWidth();
		int leftOffset = (offsetWidth - wordWidth) / 2;

		int result = 0;

		while (result < getTextLength()
				&& (leftOffset + fontSizeService.getStringWidth(getText(0, result), fontMetricSpecifier) < left)) {
			result++;
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		assert result <= getTextLength() : "Postcondition failed: result <= getTextLength()";
		return result;
	}

	public String getText(int from, int to) {
		assert from >= 0 : "Precondition failed: from >= 0";
		assert to >= from : "Precondition failed: to >= from";

		return getText().substring(from, to);
	}

	public int getTextLength() {
		return getText().length();
	}

	public boolean hasText() {
		return !getText().isEmpty();
	}

	public boolean isValidPosition(int cursorPosition) {
		return cursorPosition >= -1 && cursorPosition <= getText().length();
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelection(boolean select) {
		isSelected = select;
		Color selectedColor = getSelectedColor();

		if (isSelected) {
			this.getElement().getStyle().setBackgroundColor(selectedColor.getCssValue());
			setSelectionRange(0, getTextLength());
		} else {
			setSelectionRange(0, 0);
			// set color after selection
			this.getElement().getStyle().setBackgroundColor(backgroundColor.getCssValue());
		}
	}

	private Color getSelectedColor() {
		Color newColor;

		if (Navigator.getPlatform().toLowerCase().contains("win")
				&& Navigator.getUserAgent().toLowerCase().contains("chrome")) {
			newColor = Color.makeBlendColor(backgroundColor, selectedBlendColorChromeWin, 0.5);
		} else {
			newColor = Color.makeBlendColor(backgroundColor, selectedBlendColor, 0.5);
		}
		return newColor;
	}

	public void setTextColor(Color newColor) {
		this.getElement().getStyle().setColor(newColor.getCssValue());
	}

	public void setTextFontSize(float newSize) {
		this.getElement().getStyle().setFontSize(newSize, Unit.PT);
	}

	public void setTextFontStyle(de.signWritingEditor.shared.model.domainValue.FontStyle newStyle) {
		FontStyle fontStyle = getGWTFontStyle(newStyle);
		this.getElement().getStyle().setFontStyle(fontStyle);
	}

	public void setTextFontWeight(de.signWritingEditor.shared.model.domainValue.FontWeight newWeight) {
		FontWeight fontWeight = getGWTFontWeight(newWeight);
		this.getElement().getStyle().setFontWeight(fontWeight);
	}

	@Deprecated
	private String getGWTFontFallBackString(Font font) {
		String result;
		switch (font) {
		case COURIER:
			result = "Courier,sans-serif";
			break;
		case HELVETICA:
			result = "Helvetica,Arial,sans-serif";
			break;
		case TIMES_NEW_ROMAN:
			result = "\"Times New Roman\",Times,serif";
			break;
		default:
			result = font + ", Arial, sans-serif";
			break;
		}
		return result;
	}

	@Deprecated
	private FontStyle getGWTFontStyle(de.signWritingEditor.shared.model.domainValue.FontStyle fontStyle) {
		FontStyle result = null;
		switch (fontStyle) {
		case ITALIC:
			result = FontStyle.ITALIC;
			break;
		case NORMAL:
			result = FontStyle.NORMAL;
			break;
		default:
			break;
		}
		return result;
	}

	@Deprecated
	private FontWeight getGWTFontWeight(de.signWritingEditor.shared.model.domainValue.FontWeight fontWeight) {
		FontWeight result = null;
		switch (fontWeight) {
		case BOLD:
			result = FontWeight.BOLD;
			break;
		case NORMAL:
			result = FontWeight.NORMAL;
			break;
		default:
			break;
		}
		return result;
	}

	public void setFont(Font font) {
		String fontName = getGWTFontFallBackString(font);

		this.getElement().getStyle().setProperty("fontFamily", fontName);
	}

	public void setTextBackground(Color color) {
		assert color != null : "Precondition failed: color != null";
		backgroundColor = color;

		if (isSelected) {
			this.getElement().getStyle().setBackgroundColor(getSelectedColor().getCssValue());
		} else {
			this.getElement().getStyle().setBackgroundColor(color.getCssValue());
		}
	}

	public void setMouseDragListener(MouseDragListener listener) {
		mouseDragListener = listener;
	}

	public boolean hasTextSelection() {
		return this.getSelectionLength() > 0;
	}

}
