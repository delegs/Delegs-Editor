package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FormTokenBox;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

public class FormTokenBoxWidget extends AbstractTextbasedTokenBoxWidget {

	protected FormTokenBox formTokenBox;
	private FormTokenBoxWidgetListener formTokenBoxWidgetListener;

	private FlowPanel mainPanel;
	private Label descriptionLabel;
	private FlowPanel inputPanel;
	protected volatile ExtendedRichTextBox inputTextBox;
	private Label contentExplanationLabel;
	private FontSizeService fontSizeService;

	public FormTokenBoxWidget(FormTokenBox formTokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		assert formTokenBox != null : "Precondition failed: formTokenBox != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";
		this.formTokenBox = formTokenBox;
		this.fontSizeService = fontSizeService;

		mainPanel = new FlowPanel();
		descriptionLabel = new Label(formTokenBox.getDescription());
		inputPanel = new FlowPanel();
		inputTextBox = new ExtendedRichTextBox(eventTranslator, fontSizeService) {
			@Override
			public void onBrowserEvent(Event event) {
				super.onBrowserEvent(event);
				switch (event.getTypeInt()) {
				case Event.ONKEYUP:
					handleTextAreaKeyUpAndPaste();
					break;
				case Event.ONMOUSEDOWN:
					handleMouseDownEvent(event);
					break;
				case Event.ONMOUSEMOVE:
					// Propagation needs to be stopped, because
					// DocumentPanel would prevent default behavior and
					// selection (only in IE)
					event.stopPropagation();
					break;
				}
			}
		};

		inputTextBox.sinkEvents(Event.ONKEYDOWN);
		inputTextBox.sinkEvents(Event.ONKEYUP);
		inputTextBox.sinkEvents(Event.ONMOUSEMOVE);

		descriptionLabel.setHeight(formTokenBox.getHeight_PX() + "px");
		descriptionLabel.setWidth(formTokenBox.getDescriptionWidth_PX() + "px");
		descriptionLabel.addStyleName("formDescriptionLabel");
		descriptionLabel.addStyleName("textAreaHover");

		inputTextBox.setWidth(formTokenBox.getInputWidth_PX() + "px");
		inputTextBox.setHeight(formTokenBox.getHeight_PX() + "px");
		inputTextBox.getElement().setPropertyString("pattern", formTokenBox.getPattern());
		inputTextBox.getElement().getStyle().setWhiteSpace(WhiteSpace.NOWRAP);
		inputTextBox.getElement().getStyle().setPaddingLeft(formTokenBox.getPaddingLeft(), Unit.PX);
		inputTextBox.addStyleName("freeTextLineTemplate");

		inputTextBox.addKeyDownHandler(event -> handleKeyDownEvent(event));
		inputTextBox.addPasteHandler(event -> handleTextAreaKeyUpAndPaste());

		contentExplanationLabel = new Label(formTokenBox.getContentExplanation());
		contentExplanationLabel.addStyleName("contentExplanationLabel");

		inputPanel.add(inputTextBox);
		inputPanel.add(contentExplanationLabel);
		inputPanel.addStyleName("formTokenInput");

		mainPanel.add(descriptionLabel);
		mainPanel.add(inputPanel);
		mainPanel.addStyleName("formTokenWidget");

		initWidget(mainPanel);

		setTokenBox(formTokenBox);
	}

	public void addFormTokenBoxWidgetListener(FormTokenBoxWidgetListener formTokenBoxWidgetListener) {
		assert formTokenBoxWidgetListener != null : "Precondition failed: formTokenBoxWidgetListener != null";
		this.formTokenBoxWidgetListener = formTokenBoxWidgetListener;
	}

	private void handleMouseDownEvent(Event event) {
		assert event != null : "Precondition failed: event != null";
		assert event.getTypeInt() == Event.ONMOUSEDOWN : "Precondition failed: event.getTypeInt() == Event.ONMOUSEDOWN";
		final Event currentEvent = event;
		// Call fireMoveCurosorInBox() deferred since text box changes its
		// cursor position after event is fired:
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				fireMoveCursorInBox(currentEvent.getShiftKey(), isWholeTextSelected());
			}
		});
	}

	protected void fireMoveCursorInBox(boolean select, boolean isWholeWordSelected) {
		if (formTokenBoxWidgetListener != null) {
			formTokenBoxWidgetListener.onSelectToken(this.getId(), select, isWholeWordSelected);
		}
	}

	private void handleTextAreaKeyUpAndPaste() {
		String textWithOnlyBackslashN = inputTextBox.getText().replaceAll("\\s+", " ");
		if (!textWithOnlyBackslashN.equals(FormTokenBoxWidget.this.formTokenBox.getInputContent())
				&& formTokenBoxWidgetListener != null) {
			formTokenBoxWidgetListener.onInputContentChanged(formTokenBox.getId(), textWithOnlyBackslashN,
					getCursorPosition());
		}
	}

	protected void handleKeyDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		switch (event.getNativeKeyCode()) {
		// Since Ctrl/Meta is pressed slightly before V, C etc. when
		// pasting, copying etc. the first Ctrl/Meta event must be canceled
		case 91: // Meta-Key
		case 224: // Meta-Key in Firefox
		case KeyCodes.KEY_CTRL:
		case KeyCodes.KEY_SHIFT:
			break;
		case KeyCodes.KEY_END:
			handleKeyEndEvent(event);
			break;
		case KeyCodes.KEY_HOME:
			handleKeyHomeEvent(event);
			break;
		case KeyCodes.KEY_PAGEUP:
			handleKeyPageUpEvent(event);
			break;
		case KeyCodes.KEY_PAGEDOWN:
			handleKeyPageDownEvent(event);
			break;
		case KeyCodes.KEY_TAB:
			handleKeyTabEvent(event);
			break;
		case KeyCodes.KEY_BACKSPACE:
			break;
		case KeyCodes.KEY_DELETE:
			break;
		default: {
			switch (inputTextBox.getInteractionFromEvent(event)) {
			case COPY:
				handleCopyToken();
				break;
			case CUT:
				formTokenBoxWidgetListener.onCut();
				break;
			case SELECT_ALL:
				handleSelectAllEvent(event);
				break;
			case LEFT:
				handleKeyArrowLeftEvent(event, Interaction.LEFT);
				break;
			case RIGHT:
				handleKeyArrowRightEvent(event, Interaction.RIGHT);
				break;
			case UP:
				handleKeyArrowUpEvent(event, event.getNativeEvent().getShiftKey());
				break;
			case DOWN:
				handleKeyArrowDownEvent(event, event.getNativeEvent().getShiftKey());
				break;
			case PREVIOUS_WORD:
				handleKeyArrowLeftEvent(event, Interaction.PREVIOUS_WORD);
				break;
			case NEXT_WORD:
				handleKeyArrowRightEvent(event, Interaction.NEXT_WORD);
				break;
			case PREVIOUS_PARAGRAPH:
				fireMoveCursorToPreviousParagraph(event.isShiftKeyDown());
				break;
			case NEXT_PARAGRAPH:
				fireMoveCursorToNextParagraph(event.isShiftKeyDown());
				break;
			case LINE_BREAK:
				handleKeyTabEvent(event);
				break;
			case PAGE_BREAK:
				handleKeyTabEvent(event);
				break;
			case PASTE: // Paste is handled by onBrowserEvent
				break;
			default:
				break;
			}
		}
		}
	}

	private void handleKeyEndEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_END : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_END";

		if (event.isControlKeyDown()) {
			formTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), event.isShiftKeyDown());
		} else {
			formTokenBoxWidgetListener.onMoveCursorToLineEnd(getId(), event.isShiftKeyDown());
		}

		event.preventDefault();

	}

	private void handleKeyHomeEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_HOME : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_HOME";

		if (event.isControlKeyDown()) {
			formTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), event.isShiftKeyDown());
		} else {
			formTokenBoxWidgetListener.onMoveCursorToLineStart(getId(), event.isShiftKeyDown());
		}

		event.preventDefault();
	}

	private void handleKeyPageUpEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEUP : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEUP";

		formTokenBoxWidgetListener.onMoveCursorToPreviousPage(getId(), event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleKeyPageDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN";

		formTokenBoxWidgetListener.onMoveCursorToNextPage(getId(), event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleKeyTabEvent(KeyDownEvent event) {
		boolean performDefaultHandling = false;
		if (event.isShiftKeyDown()) {
			formTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), false, false);
		} else {
			formTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), false);
		}

		// avoid default tab behavior, that brings you to the next
		// SimpleTextBox
		if (!performDefaultHandling) {
			event.preventDefault();
		}
	}

	private void handleCopyToken() {
		formTokenBoxWidgetListener.onCopy();
	}

	private void handleSelectAllEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		formTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), false);
		formTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), true);
	}

	private void handleKeyArrowLeftEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_LEFT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_LEFT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		final int oldCursorPosition = getCursorPosition();
		final int oldSelectionLength = inputTextBox.getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the beginning of
				// the TextBox we check if selection length has changed
				boolean isCursorAtStart = oldCursorPosition == 0
						&& oldSelectionLength == inputTextBox.getSelectionLength();

				if (isCursorAtStart || inputTextBox.isSelected && shiftKeyDown) {
					formTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), action != Interaction.PREVIOUS_WORD,
							shiftKeyDown);
				} else {
					fireMoveCursorInBox(shiftKeyDown, isWholeTextSelected());
				}
			}
		});
	}

	private void handleKeyArrowRightEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_RIGHT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_RIGHT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		final int oldCursorPosition = getCursorPosition();
		final int oldSelectionLength = inputTextBox.getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the end of the
				// TextBox we check if selection length has changed
				boolean isCursorAtEnd = oldCursorPosition == inputTextBox.getTextLength()
						|| ((inputTextBox.getSelectionLength() > 0)
								&& oldSelectionLength == inputTextBox.getSelectionLength());

				if (isCursorAtEnd || inputTextBox.isSelected && shiftKeyDown) {
					formTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), shiftKeyDown);
				} else {
					fireMoveCursorInBox(shiftKeyDown, isWholeTextSelected());
				}
			}
		});
	}

	private void fireMoveCursorToPreviousParagraph(boolean select) {
		if (formTokenBoxWidgetListener != null) {
			formTokenBoxWidgetListener.onMoveCursorToPreviousParagraph(this.getId(), select);
		}
	}

	private void fireMoveCursorToNextParagraph(boolean select) {
		if (formTokenBoxWidgetListener != null) {
			formTokenBoxWidgetListener.onMoveCursorToNextParagraph(this.getId(), select);
		}
	}

	private void handleKeyArrowUpEvent(KeyDownEvent event, boolean select) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_UP : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_UP";

		boolean isCursorAtFirstPosition = getCursorPosition() == 0;

		if (isCursorAtFirstPosition || isWholeTextSelected()) {
			formTokenBoxWidgetListener.onMoveCursorLineUp(getId(), select);
			event.preventDefault();
		}
	}

	private void handleKeyArrowDownEvent(KeyDownEvent event, boolean select) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_DOWN : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_UP";

		boolean isCursorAtLastPosition = getCursorPosition() == inputTextBox.getTextLength();

		if (isCursorAtLastPosition || isWholeTextSelected()) {
			formTokenBoxWidgetListener.onMoveCursorLineDown(getId(), select);
			event.preventDefault();
		}
	}

	@Override
	public int getCursorLeft() {
		return this.inputTextBox.getCursorLeft(formTokenBox.getFontMetricSpecifier());
	}

	@Override
	public void setCursorPositionAndFocus(int cursorPosition) {
		this.inputTextBox.setCursorPos(cursorPosition);
		this.inputTextBox.setFocus(true);
	}

	public String getDescription() {
		return formTokenBox.getDescription();
	}

	public void setInputContent(String content) {
		formTokenBox.setInputContent(content);
		inputTextBox.setText(content);
	}

	@Override
	public int getCursorPosition() {
		return this.inputTextBox.getCursorPosition();
	}

	@Override
	public int getCursorPositionAt(int left) {
		return this.inputTextBox.getCursorPositionAt(left, formTokenBox.getFontMetricSpecifier());
	}

	@Override
	public boolean isValidCursorPosition(int cursorPosition) {
		return this.inputTextBox.isValidPosition(cursorPosition);
	}

	@Override
	public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
	}

	@Override
	public String getText() {
		return inputTextBox.getText();
	}

	@Override
	public void setDragModeHandler(MouseDragListener listener) {
		inputTextBox.setMouseDragListener(listener);
	}

	@Override
	public void setTextBoxBackgroundColor(Color color) {
		inputTextBox.setTextBackground(color);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		// Is not resizeable see isResizeable
	}

	@Override
	protected boolean isResizeable() {
		return false;
	}

	@Override
	public Id getId() {
		return formTokenBox.getId();
	}

	@Override
	public void focus() {
		this.inputTextBox.setFocus(true);
		this.inputTextBox.getElement().scrollIntoView();
	}

	@Override
	public void toggleSelection() {
		this.inputTextBox.setSelection(!this.inputTextBox.isSelected());
	}

	public boolean isWholeTextSelected() {
		return inputTextBox.getSelectionLength() == inputTextBox.getTextLength();
	}

	@Override
	public TokenBox getTokenBox() {
		return formTokenBox;
	}

	@Override
	public void setTokenBox(TokenBox tokenBox) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert tokenBox instanceof FormTokenBox : "Precondition failed: tokenBox instanceof FormTokenBox";

		this.formTokenBox = (FormTokenBox) tokenBox;
		String newText = formTokenBox.getInputContent();
		if (!newText.equals(inputTextBox.getText())) {
			int tempCursorPos = inputTextBox.getCursorPos();
			setCursorPositionAndFocus(tempCursorPos);
			inputTextBox.setText(newText);
		}

		descriptionLabel.getElement().getStyle().setProperty("fontFamily",
				formTokenBox.getFontMetricSpecifier().getFont().toString());
		descriptionLabel.getElement().getStyle().setProperty("fontStyle",
				formTokenBox.getFontMetricSpecifier().getFontStyle().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontWeight",
				formTokenBox.getFontMetricSpecifier().getFontWeight().name().toLowerCase());
		descriptionLabel.getElement().getStyle().setProperty("fontSize",
				formTokenBox.getFontMetricSpecifier().getFontSize().getSize() + "px");
		descriptionLabel.getElement().getStyle().setColor(formTokenBox.getColor().getCssValue());

		inputTextBox.setFont(formTokenBox.getFontMetricSpecifier().getFont());
		inputTextBox.setTextFontStyle(formTokenBox.getFontMetricSpecifier().getFontStyle());
		inputTextBox.setTextFontWeight(formTokenBox.getFontMetricSpecifier().getFontWeight());
		inputTextBox.setTextFontSize(
				fontSizeService.getActualFontSize(formTokenBox.getFontMetricSpecifier().getFontSize()));
		inputTextBox.setTextColor(formTokenBox.getColor());

		setTextBoxBackgroundColor(formTokenBox.getTextBackgroundColor());
	}

	public interface FormTokenBoxWidgetListener
			extends ResizableTokenBoxWidgetListener, TextbasedTokenBoxWidgetListener {
		void onInputContentChanged(Id tokenId, String inputContent, int cursorPosition);

		void onInsertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter);
	}

}
