package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.RootPanel;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.Id;

public class FreeTextTokenBoxWidget extends FreeTextTokenBoxWidgetBase {

	private HandlerRegistration resizeHandlerRegistration;
	private boolean isResizing;

	private FreeTextTokenBoxWidgetListener freeTextTokenBoxWidgetListener;

	public FreeTextTokenBoxWidget(final FreeTextTokenBox freeTextBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		super(freeTextBox, eventTranslator, fontSizeService);
		assert freeTextBox != null : "Precondition failed: freeTextBox != null";

		resizeHandlerRegistration = null;
		isResizing = false;

		sliderPanel.addHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				setCursorPositionAndFocus(textArea.getCursorAbsoluteRight());

				event.stopPropagation();
				event.preventDefault();

				if (!getTokenBox().isLockedLayout()) {
					RootPanel.get().add(fullScreenWidget);
					resizeHandlerRegistration = Event.addNativePreviewHandler(new NativePreviewHandler() {

						@Override
						public void onPreviewNativeEvent(NativePreviewEvent event) {
							if (event.getTypeInt() == Event.ONMOUSEMOVE) {
								// workaround for gwt bug: getClientX and
								// getAbsoluteLeft might not return int
								int x = Math.round((float) event.getNativeEvent().getClientX());
								int y = Math.round((float) textArea.getAbsoluteLeft());
								x = x - y;

								if (isResizing && x >= 40) {
									setFixedFreeTextBoxSize(x);
								}
							} else if (event.getTypeInt() == Event.ONMOUSEUP) {
								RootPanel.get().remove(fullScreenWidget);
								removePreviewHandler();
							}
						}
					});
					isResizing = true;
					updateWidth();
					updateHeight(freeTextBox);
				}
			}

		}, MouseDownEvent.getType());

		sliderPanel.sinkEvents(Event.MOUSEEVENTS);

		if (!freeTextBox.isContentLocked()) {
			textArea = new ExtendedRichTextArea(eventTranslator, fontSizeService) {
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

			textArea.addKeyDownHandler(new KeyDownHandler() {

				@Override
				public void onKeyDown(KeyDownEvent event) {
					handleKeyDownEvent(event);
				}
			});

			textArea.addPasteHandler(new PasteHandler() {
				@Override
				public void onPaste(PasteEvent event) {
					handleTextAreaKeyUpAndPaste();
				}
			});

			textArea.sinkEvents(Event.ONKEYDOWN);
			textArea.sinkEvents(Event.ONKEYUP);
			textArea.sinkEvents(Event.ONMOUSEMOVE);

			if (!freeTextBox.isLockedLayout()) {
				textArea.addDoubleClickHandler(new DoubleClickHandler() {
					@Override
					public void onDoubleClick(DoubleClickEvent event) {
						assert event != null : "Precondition failed: event != null";
						freeTextTokenBoxWidgetListener.onSelectToken(getId(), true);
					}
				});
			}
		}

		if (freeTextBox.isLockedLayout() && !freeTextBox.isContentLocked()) {
			textArea.addStyleName("freeTextLineTemplate");
		} else {
			textArea.addStyleName("freeTextLine");
		}

		textArea.getElement().getStyle().setPaddingLeft(this.freeTextTokenBox.getPaddingLeft_PX(), Unit.PX);
		textArea.getElement().getStyle().setPaddingRight(this.freeTextTokenBox.getPaddingRight_PX(), Unit.PX);

		contentPanel.sinkEvents(Event.ONMOUSEOVER);
		contentPanel.sinkEvents(Event.ONMOUSEOUT);

		textAreaPanel.insert(textArea, 0);
		contentPanel.add(textAreaPanel);
		contentPanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);

		initWidget(contentPanel);

		setTokenBox(freeTextBox);
		updateHeight(freeTextBox);
		updateWidth();
	}

	protected void setFixedFreeTextBoxSize(int width) {
		freeTextTokenBox.setFixedWidthWithoutMargin(width);
		updateWidth();
		setTokenBox(freeTextTokenBox);
		freeTextTokenBoxWidgetListener.onResizeToken(getId());
	}

	public void addFreeTextTokenBoxWidgetListener(FreeTextTokenBoxWidgetListener freeTextLineWidgetListener) {
		assert freeTextLineWidgetListener != null : "Precondition failed: freeTextLineWidgetListener != null";

		this.freeTextTokenBoxWidgetListener = freeTextLineWidgetListener;
	}

	public void addDragHandlingToTextArea(MouseDownHandler handler, MouseMoveHandler mouseMoveHandler) {
		textArea.addHandler(handler, MouseDownEvent.getType());
		textArea.addHandler(mouseMoveHandler, MouseMoveEvent.getType());
		textArea.sinkEvents(Event.ONMOUSEDOWN);
		textArea.sinkEvents(Event.ONMOUSEMOVE);
	}

	private void handleTextAreaKeyUpAndPaste() {
		// Replace \r\n and \r with \n (IE replaces \n with \r\n):
		String textWithOnlyBackslashN = textArea.getText().replaceAll("\r\n?", "\n");
		if (!textWithOnlyBackslashN.equals(FreeTextTokenBoxWidget.this.freeTextTokenBox.getText())
				&& freeTextTokenBoxWidgetListener != null) {
			freeTextTokenBoxWidgetListener.onFreeTextChanged(freeTextTokenBox.getId(), textWithOnlyBackslashN,
					getCursorPosition());
		}
	}

	private void handleKeyDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		int fontSize = freeTextTokenBox.getFontMetricSpecifier().getFontSize().getSize();
		if (contentPanel.getOffsetWidth() + fontSize < contentPanel.getParent().getOffsetWidth()) {
			contentPanel.setWidth(contentPanel.getOffsetWidth() + fontSize + "px");
		}

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
			handleKeyBackspace(event);
			break;
		case KeyCodes.KEY_DELETE:
			handleKeyDelete(event);
			break;
		default: {
			switch (textArea.getInteractionFromEvent(event)) {
			case COPY:
				handleCopyToken();
				break;
			case CUT:
				freeTextTokenBoxWidgetListener.onCut();
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
			case NEXT_WORD:
				handleKeyArrowRightEvent(event, Interaction.NEXT_WORD);
				break;
			case PREVIOUS_WORD:
				handleKeyArrowLeftEvent(event, Interaction.PREVIOUS_WORD);
				break;
			case PREVIOUS_PARAGRAPH:
				fireMoveCursorToPreviousParagraph(event.isShiftKeyDown());
				break;
			case NEXT_PARAGRAPH:
				fireMoveCursorToNextParagraph(event.isShiftKeyDown());
				break;
			case UP:
				handleKeyArrowUpEvent(event, event.getNativeEvent().getShiftKey());
				break;
			case DOWN:
				handleKeyArrowDownEvent(event, event.getNativeEvent().getShiftKey());
				break;
			case LINE_BREAK:
				if (event.getNativeEvent().getShiftKey()) {
					freeTextTokenBoxWidgetListener.onInsertLineOrPageBreakAfterFreeTextToken(getId(), '\n');
					event.preventDefault();
				}
				break;
			case PAGE_BREAK:
				freeTextTokenBoxWidgetListener.onInsertLineOrPageBreakAfterFreeTextToken(getId(), '\f');
			case PASTE: // Paste is handled by onBrowserEvent
				break;
			case ADD_FREE_TEXT_LINE:
				freeTextTokenBoxWidgetListener.onInsertFreeTextLineAfterToken(getId());
				break;
			default:
				break;
			}
		}
		}

		final String oldText = textArea.getText();
		final boolean isWholeTextSelected = isWholeTextSelected();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				String newText = textArea.getText();
				if (!oldText.equals(newText)) {
					int cursorPosition = getCursorPosition();
					if (isWholeTextSelected) {
						if (newText.startsWith(oldText)) {
							newText = newText.substring(oldText.length());
						} else if (newText.endsWith(oldText)) {
							newText = newText.substring(0, newText.length() - oldText.length());
						}
						cursorPosition = newText.length();
					}
					freeTextTokenBoxWidgetListener.handleForTokenSelection(getId(), true);
					freeTextTokenBoxWidgetListener.onFreeTextChanged(freeTextTokenBox.getId(), newText, cursorPosition);
				}
				updateWidth();
			}
		});
	}

	private void handleKeyTabEvent(KeyDownEvent event) {
		boolean performDefaultHandling = false;
		if (event.isShiftKeyDown()) {
			freeTextTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), false, false);
		} else {
			freeTextTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), false);
		}

		// avoid default tab behavior, that brings you to the next
		// SimpleTextBox
		if (!performDefaultHandling) {
			event.preventDefault();
		}
	}

	private void handleKeyArrowDownEvent(KeyDownEvent event, boolean select) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_DOWN : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_UP";

		boolean isCursorAtLastPosition = getCursorPosition() == textArea.getTextLength();

		if (isCursorAtLastPosition || isWholeTextSelected()) {
			freeTextTokenBoxWidgetListener.onMoveCursorLineDown(getId(), select);
			event.preventDefault();
		}
	}

	private void handleKeyArrowUpEvent(KeyDownEvent event, boolean select) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_UP : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_UP";

		boolean isCursorAtFirstPosition = getCursorPosition() == 0;

		if (isCursorAtFirstPosition || isWholeTextSelected()) {
			freeTextTokenBoxWidgetListener.onMoveCursorLineUp(getId(), select);
			event.preventDefault();
		}

	}

	private void handleKeyDelete(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_DELETE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_DELETE";
		if (!freeTextTokenBox.isLockedLayout()) {
			boolean performDefault = freeTextTokenBoxWidgetListener.handleForTokenSelection(getId(), false);
			if (performDefault) {

				if ((getCursorPosition() == textArea.getTextLength()) && textArea.getSelectionLength() == 0) {
					freeTextTokenBoxWidgetListener.onDeleteNext(getId());
					event.preventDefault();
				}
			}
		}
	}

	private void handleKeyBackspace(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE";

		if (!freeTextTokenBox.isLockedLayout()) {
			boolean handleEvent = freeTextTokenBoxWidgetListener.handleForTokenSelection(getId(), false);
			if (handleEvent) {
				if ((getCursorPosition() == 0) && textArea.getSelectionLength() == 0) {
					freeTextTokenBoxWidgetListener.onDeletePrevious(getId());
					event.preventDefault();
				}
			}
		}
	}

	private void handleKeyArrowLeftEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_LEFT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_LEFT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		final int oldCursorPosition = getCursorPosition();
		final int oldSelectionLength = textArea.getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the beginning of
				// the TextBox we check if selection length has changed
				boolean isCursorAtStart = oldCursorPosition == 0 && oldSelectionLength == textArea.getSelectionLength();

				if (isCursorAtStart || textArea.isSelected && shiftKeyDown) {
					freeTextTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(),
							action != Interaction.PREVIOUS_WORD, shiftKeyDown);
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
		final int oldSelectionLength = textArea.getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the end of the
				// TextBox we check if selection length has changed
				boolean isCursorAtEnd = oldCursorPosition == textArea.getTextLength()
						|| ((textArea.getSelectionLength() > 0) && oldSelectionLength == textArea.getSelectionLength());

				if (isCursorAtEnd || textArea.isSelected && shiftKeyDown) {
					freeTextTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), shiftKeyDown);
				} else {
					fireMoveCursorInBox(shiftKeyDown, isWholeTextSelected());
				}
			}
		});
	}

	private void handleCopyToken() {
		freeTextTokenBoxWidgetListener.onCopy();
	}

	public interface FreeTextTokenBoxWidgetListener
			extends ResizableTokenBoxWidgetListener, TextbasedTokenBoxWidgetListener {
		void onFreeTextChanged(Id tokenId, String freeLineText, int cursorPosition);

		void onInsertLineOrPageBreakAfterFreeTextToken(Id tokenId, char breakCharacter);
	}

	private void handleMouseDownEvent(final Event event) {
		assert event != null : "Precondition failed: event != null";
		assert event.getTypeInt() == Event.ONMOUSEDOWN : "Precondition failed: event.getTypeInt() == Event.ONMOUSEDOWN";

		// Call fireMoveCurosorInBox() deferred since text box changes its
		// cursor position after event is fired:
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				fireMoveCursorInBox(event.getShiftKey(), isWholeTextSelected());
			}
		});
	}

	private void fireMoveCursorToNextParagraph(boolean select) {
		if (freeTextTokenBoxWidgetListener != null) {
			freeTextTokenBoxWidgetListener.onMoveCursorToNextParagraph(this.getId(), select);
		}
	}

	private void fireMoveCursorToPreviousParagraph(boolean select) {
		if (freeTextTokenBoxWidgetListener != null) {
			freeTextTokenBoxWidgetListener.onMoveCursorToPreviousParagraph(this.getId(), select);
		}
	}

	private void fireMoveCursorInBox(boolean select, boolean isWholeWordSelected) {
		if (freeTextTokenBoxWidgetListener != null) {
			freeTextTokenBoxWidgetListener.onSelectToken(this.getId(), select, isWholeWordSelected);
		}
	}

	private void removePreviewHandler() {
		if (resizeHandlerRegistration != null) {
			resizeHandlerRegistration.removeHandler();
			isResizing = false;
			updateWidth();
		}
	}

	private void handleKeyEndEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_END : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_END";

		if (event.isControlKeyDown()) {
			freeTextTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), event.isShiftKeyDown());
		} else {
			freeTextTokenBoxWidgetListener.onMoveCursorToLineEnd(getId(), event.isShiftKeyDown());
		}

		event.preventDefault();
	}

	private void handleKeyHomeEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_HOME : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_HOME";

		if (event.isControlKeyDown()) {
			freeTextTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), event.isShiftKeyDown());
		} else {
			freeTextTokenBoxWidgetListener.onMoveCursorToLineStart(getId(), event.isShiftKeyDown());
		}

		event.preventDefault();
	}

	private void handleKeyPageDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN";

		freeTextTokenBoxWidgetListener.onMoveCursorToNextPage(getId(), event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleKeyPageUpEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEUP : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEUP";

		freeTextTokenBoxWidgetListener.onMoveCursorToPreviousPage(getId(), event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleSelectAllEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		freeTextTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), false);
		freeTextTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), true);
	}

	@Override
	public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
		assert mouseOverHandler != null : "Precondition failed: mouseOverHandler != null";
		assert mouseOutHandler != null : "Precondition failed: mouseOutHandler != null";

		contentPanel.addHandler(mouseOverHandler, MouseOverEvent.getType());
		contentPanel.addHandler(mouseOutHandler, MouseOutEvent.getType());
		contentPanel.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	}

	@Override
	public void setDragModeHandler(MouseDragListener listener) {
		textArea.setMouseDragListener(listener);
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		// Is not resizeable see isResizeable
	}

	@Override
	protected boolean isResizeable() {
		return false;
	}

}
