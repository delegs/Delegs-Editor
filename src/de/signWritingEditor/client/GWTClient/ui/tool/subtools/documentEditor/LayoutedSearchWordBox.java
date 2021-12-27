package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTextbasedTokenBoxWidget.TextbasedTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget.TokenBoxWidgetListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;

public class LayoutedSearchWordBox extends SearchWordBoxBase {

	private SearchWordBoxListener searchWordBoxListener;
	private SignItemTokenBox tokenBox;

	public LayoutedSearchWordBox(SignItemTokenBox tokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		super(tokenBox.getId(), eventTranslator, fontSizeService);
		this.tokenBox = tokenBox;
		addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDownEvent(event);
			}
		});

		addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				isFocused = true;
			}
		});

		addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				isFocused = false;
			}
		});

		addPasteHandler(new PasteHandler() {
			@Override
			public void onPaste(PasteEvent event) {
				handlePaste(event);
			}
		});

		sinkEvents(Event.ONCLICK | Event.ONMOUSEDOWN | Event.ONDBLCLICK);
	}

	protected void handlePaste(PasteEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event.getPastedText() != null : "Precondition failed: event.getPastedText()!= null";
		assert getText() != null : "Precondition failed: getText() != null";

		String pastedText = event.getPastedText();
		fireOnPaste(pastedText);
	}

	public void setSearchWordBoxListener(LayoutedSearchWordBox.SearchWordBoxListener searchWordBoxListener) {
		assert searchWordBoxListener != null : "Precondition failed: searchWordBoxListener != null";

		this.searchWordBoxListener = searchWordBoxListener;
	}

	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		handleBrowserEvent(event);
	}

	@Override
	protected void onAttach() {
		super.onAttach();

		// To prevent widget from loosing focus when moved to another panel:
		if (isFocused) {
			this.setFocus(true);
		}
	}

	private void handleKeyDownEvent(final KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		switch (event.getNativeKeyCode()) {
		// Since Ctrl/Meta is pressed slightly before V, C etc. when
		// pasting, copying etc. the first Ctrl/Meta event must be canceled
		case 91: // Meta-Key
		case 224: // Meta-Key in Firefox
		case KeyCodes.KEY_CTRL:
		case KeyCodes.KEY_SHIFT:
			break;
		case KeyCodes.KEY_BACKSPACE:
			handleKeyBackspaceEvent(event);
			break;
		case KeyCodes.KEY_DELETE:
			handleKeyDeleteEvent(event);
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
		case KeyCodes.KEY_SPACE:
			if (tokenBox.isLockedLayout()) {
				event.preventDefault();
				break;
			}
		default: {
			switch (this.getInteractionFromEvent(event)) {
			case COPY:
				handleCopyEvent(event);
				break;
			case CUT:
				handleCutEvent(event);
				break;
			case SELECT_ALL:
				handleSelectAllEvent(event);
				break;
			case RIGHT:
				handleKeyArrowRightEvent(event, Interaction.RIGHT);
				break;
			case NEXT_WORD:
				handleKeyArrowRightEvent(event, Interaction.NEXT_WORD);
				break;
			case LEFT:
				handleKeyArrowLeftEvent(event, Interaction.LEFT);
				break;
			case PREVIOUS_WORD:
				handleKeyArrowLeftEvent(event, Interaction.PREVIOUS_WORD);
				break;
			case PREVIOUS_PARAGRAPH:
				fireMoveCursorToPreviousParagraph(event.isShiftKeyDown());
				break;
			case UP:
				event.preventDefault();
				fireMoveCursorToLineUp(event.isShiftKeyDown());
				break;
			case NEXT_PARAGRAPH:
				fireMoveCursorToNextParagraph(event.isShiftKeyDown());
				break;
			case DOWN:
				event.preventDefault();
				fireMoveCursorToLineDown(event.isShiftKeyDown());
				break;
			case PAGE_BREAK:
				if (tokenBox.isLockedLayout()) {
					event.preventDefault();
				} else {
					handlePageBreak(event);
				}
				break;
			case LINE_BREAK:
				if (tokenBox.isLockedLayout()) {
					event.preventDefault();
					break;
				}
			case REDO:
			case UNDO:
			case NONE:
				scheduleTextChangedCheck(getText());
				break;
			case PASTE: // Paste is handled by onBrowserEvent
				break;
			case ADD_FREE_TEXT_LINE:
				searchWordBoxListener.onInsertFreeTextLineAfterToken(tokenId);
				break;
			default:
				break;
			}
		}
		}
	}

	private void scheduleTextChangedCheck(final String oldText) {
		assert oldText != null : "Precondition failed: oldText != null";

		if (isSelected) {
			setSelectionRange(0, getTextLength());
		}

		if (!checkingText) {
			checkingText = true;
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					String newText = getText();

					if (!oldText.equals(newText)) {
						firePreTextChange(tokenId, true);
						// Replace carriage returns
						newText = newText.replaceAll("\r\n", "\n");

						fireTextChanged(newText);
					}
					checkingText = false;
				}
			});
		}
	}

	private void handleBrowserEvent(Event event) {
		assert event != null : "Precondition failed: event != null";

		int typeInt = event.getTypeInt();
		if (typeInt == Event.ONMOUSEDOWN) {
			handleMouseDownEvent(event);
		} else if (typeInt == Event.ONDBLCLICK) {
			handleDoubleClickEvent(event);
		}
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

	private void handleSelectAllEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		fireMoveCursorToDocumentTop(false);
		fireMoveCursorToDocumentEnd(true);
	}

	private void handleDoubleClickEvent(Event event) {
		assert event != null : "Precondition failed: event != null";
		assert event.getTypeInt() == Event.ONDBLCLICK : "Precondition failed: event.getTypeInt() == Event.ONDBLCLICK";

		event.preventDefault();

		fireMoveCursorInBox(true, isWholeTextSelected());
	}

	private void handleCopyEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		fireOnCopy();
	}

	private void handleCutEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		boolean performDefaultHandling = fireOnCut();

		if (performDefaultHandling) {
			// Wait until TextBox has performed its own cut
			fireTextChangedDeferred();
		}
	}

	private void handleKeyPageDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEDOWN";

		fireMoveCursorToNextPage(event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleKeyPageUpEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_PAGEUP : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_PAGEUP";

		fireMoveCursorToPreviousPage(event.isShiftKeyDown());

		event.preventDefault();
	}

	private void handleKeyEndEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_END : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_END";

		if (event.isControlKeyDown()) {
			fireMoveCursorToDocumentEnd(event.isShiftKeyDown());
		} else {
			fireMoveCursorToLineEnd(event.isShiftKeyDown());
		}

		event.preventDefault();
	}

	private void handleKeyHomeEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_HOME : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_HOME";

		if (event.isControlKeyDown()) {
			fireMoveCursorToDocumentTop(event.isShiftKeyDown());
		} else {
			fireMoveCursorToLineStart(event.isShiftKeyDown());
		}

		event.preventDefault();
	}

	private void handleKeyDeleteEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_DELETE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_DELETE";

		boolean performDefault = firePreTextChange(tokenId, false);
		if (performDefault) {
			boolean notAtLastPosition = getCursorPosition() < getTextLength();

			if (notAtLastPosition || this.hasTextSelection()) {
				// TextBox handles event on its own and notifies listeners
				fireTextChangedDeferred();
			} else {
				event.preventDefault();
				fireDeleteNext();
			}
		}
	}

	private void handleKeyBackspaceEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE";

		boolean performDefault = firePreTextChange(tokenId, false);
		if (performDefault) {
			boolean notAtFirstPosition = getCursorPosition() > 0;

			if (notAtFirstPosition || this.hasTextSelection()) {
				// TextBox handles event on its own and notifies listeners
				fireTextChangedDeferred();
			} else {
				event.preventDefault();
				fireDeletePrevious();
			}
		}
	}

	private void handlePageBreak(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert this.getInteractionFromEvent(
				event) == Interaction.PAGE_BREAK : "Precondition failed: eventTranslator.get(event) == Interaction.PAGE_BREAK";

		event.preventDefault();

		String text = getText();
		int cursorPosition = getCursorPosition();
		setText(text.substring(0, cursorPosition) + Tokenizer.PAGE_BREAK
				+ text.substring(cursorPosition + getSelectionLength()));

		setCursorPos(cursorPosition + 1);

		scheduleTextChangedCheck(text);
	}

	private void handleKeyArrowLeftEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_LEFT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_LEFT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		final int oldCursorPosition = getCursorPosition();
		final int oldSelectionLength = getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the beginning of
				// the TextBox we check if selection length has changed
				boolean isCursorAtStart = oldCursorPosition == 0 && oldSelectionLength == getSelectionLength();

				if (isCursorAtStart || isSelected && shiftKeyDown) {
					fireMoveCursorToPreviousBox(action != Interaction.PREVIOUS_WORD, shiftKeyDown);
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
		final int oldSelectionLength = getSelectionLength();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				// Cursor is always on left side of selected text
				// To determine if real cursor position is at the end of the
				// TextBox we check if selection length has changed
				boolean isCursorAtEnd = oldCursorPosition == getTextLength()
						|| (hasTextSelection() && oldSelectionLength == getSelectionLength());

				if (isCursorAtEnd || action == Interaction.NEXT_WORD || isSelected && shiftKeyDown) {
					fireMoveCursorToNextBox(shiftKeyDown);
				} else {
					fireMoveCursorInBox(shiftKeyDown, isWholeTextSelected());
				}
			}
		});
	}

	private void handleKeyTabEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_TAB : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_TAB";

		boolean performDefaultHandling = false;
		if (event.isShiftKeyDown()) {
			searchWordBoxListener.onMoveCursorToPreviousBox(tokenId, false, false);
		} else {
			searchWordBoxListener.onMoveCursorToNextBox(tokenId, false);
		}
		// avoid default tab behavior, that brings you to the next
		// SimpleTextBox
		if (!performDefaultHandling) {
			event.preventDefault();
		}
	}

	private void fireOnCopy() {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onCopy();
		}
	}

	private boolean fireOnCut() {
		return searchWordBoxListener != null && searchWordBoxListener.onCut();
	}

	private void fireOnPaste(String pastedText) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onPaste(tokenId, pastedText, PasteTarget.TOKEN);
		}
	}

	private void fireDeleteNext() {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onDeleteNext(tokenId);
		}
	}

	private void fireDeletePrevious() {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onDeletePrevious(tokenId);
		}
	}

	private boolean firePreTextChange(Id firingTokenId, boolean textChanged) {
		return searchWordBoxListener != null
				&& searchWordBoxListener.handleForTokenSelection(firingTokenId, textChanged);
	}

	private void fireTextChanged() {
		fireTextChanged(getText());
	}

	private void fireTextChanged(String newText) {
		assert newText != null : "Precondition failed: newText != null";

		if (searchWordBoxListener != null) {
			searchWordBoxListener.onTextChanged(tokenId, newText, getInvertedCursorPosition());
		}
	}

	private void fireTextChangedDeferred() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				fireTextChanged();
			}
		});
	}

	private void fireMoveCursorToNextPage(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToNextPage(tokenId, select);
		}
	}

	private void fireMoveCursorToPreviousPage(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToPreviousPage(tokenId, select);
		}
	}

	private void fireMoveCursorToNextBox(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToNextBox(tokenId, select);
		}
	}

	private void fireMoveCursorToPreviousBox(boolean atEnd, boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToPreviousBox(tokenId, atEnd, select);
		}
	}

	private void fireMoveCursorToNextParagraph(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToNextParagraph(tokenId, select);
		}
	}

	private void fireMoveCursorToPreviousParagraph(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToPreviousParagraph(tokenId, select);
		}
	}

	private void fireMoveCursorInBox(boolean select, boolean isWholeWordSelected) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onSelectToken(tokenId, select, isWholeWordSelected);
		}
	}

	private void fireMoveCursorToLineDown(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorLineDown(tokenId, select);
		}
	}

	private void fireMoveCursorToLineUp(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorLineUp(tokenId, select);
		}
	}

	private void fireMoveCursorToLineEnd(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToLineEnd(tokenId, select);
		}
	}

	private void fireMoveCursorToLineStart(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToLineStart(tokenId, select);
		}
	}

	private void fireMoveCursorToDocumentEnd(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToDocumentEnd(tokenId, select);
		}
	}

	private void fireMoveCursorToDocumentTop(boolean select) {
		if (searchWordBoxListener != null) {
			searchWordBoxListener.onMoveCursorToDocumentTop(tokenId, select);
		}
	}

	public interface SearchWordBoxListener extends TokenBoxWidgetListener, TextbasedTokenBoxWidgetListener {

		void onTextChanged(Id tokenId, String newText, int invertedCursorPosition);
	}
}
