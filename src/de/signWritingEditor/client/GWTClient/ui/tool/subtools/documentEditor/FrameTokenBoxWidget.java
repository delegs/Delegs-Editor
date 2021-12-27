package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.FrameTokenBox;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;

public class FrameTokenBoxWidget extends FrameTokenBoxWidgetBase {

	private FrameTokenBoxWidgetListener frameTokenBoxWidgetListener;

	public FrameTokenBoxWidget(FrameTokenBox tokenBox, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		super(tokenBox, eventTranslator, fontSizeService);
		assert tokenBox != null : "Precondition failed: tokenBox != null";

		framePanel.addHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				handleSelectFrameToken(event.getNativeEvent().getShiftKey());
			}
		}, ClickEvent.getType());
		framePanel.sinkEvents(Event.ONCLICK);

		invisbleKeyHandlingTextArea.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				invisbleKeyHandlingTextArea.setText("");
				switch (event.getNativeKeyCode()) {
				// Since Ctrl/Meta is pressed slightly before V, C etc. when
				// pasting, copying etc. the first Ctrl/Meta event must be
				// canceled
				case 91: // Meta-Key
				case 224: // Meta-Key in Firefox
				case KeyCodes.KEY_CTRL:
				case KeyCodes.KEY_SHIFT:
					break;
				case KeyCodes.KEY_TAB:
					handleKeyTabEvent(event);
					break;
				case KeyCodes.KEY_BACKSPACE:
					handleKeyBackspaceEvent(event);
					break;
				case KeyCodes.KEY_DELETE:
					handleKeyDeleteEvent(event);
					break;
				case KeyCodes.KEY_HOME:
					handleKeyHomeEvent(event);
					break;
				case KeyCodes.KEY_END:
					handleKeyEndEvent(event);
					break;
				default: {
					switch (invisbleKeyHandlingTextArea.getInteractionFromEvent(event)) {
					case COPY:
						frameTokenBoxWidgetListener.onCopy();
						break;
					case CUT:
						frameTokenBoxWidgetListener.onCut();
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
						fireMoveCursorToLineUp(event.isShiftKeyDown());
						break;
					case NEXT_PARAGRAPH:
						fireMoveCursorToNextParagraph(event.isShiftKeyDown());
						break;
					case DOWN:
						fireMoveCursorToLineDown(event.isShiftKeyDown());
						break;
					case SELECT_ALL:
						handleSelectAllEvent(event);
						break;
					default:
						break;
					}
				}
				}
			}
		});

		invisbleKeyHandlingTextArea.addPasteHandler(new PasteHandler() {

			@Override
			public void onPaste(PasteEvent event) {
				frameTokenBoxWidgetListener.onPaste(getId(), invisbleKeyHandlingTextArea.getText(), PasteTarget.TOKEN);
				invisbleKeyHandlingTextArea.setText("");
			}
		});
	}

	protected void handleKeyEndEvent(KeyDownEvent event) {
		if (event.isControlKeyDown()) {
			this.frameTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), event.isShiftKeyDown());
		} else {
			this.frameTokenBoxWidgetListener.onMoveCursorToLineEnd(getId(), event.isShiftKeyDown());
		}
	}

	protected void handleKeyHomeEvent(KeyDownEvent event) {
		if (event.isControlKeyDown()) {
			this.frameTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), event.isShiftKeyDown());
		} else {
			this.frameTokenBoxWidgetListener.onMoveCursorToLineStart(getId(), event.isShiftKeyDown());
		}
	}

	private void handleSelectFrameToken(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onSelectToken(this.getId(), select);
		}
	}

	public void addFrameTokenBoxWidgetListener(FrameTokenBoxWidgetListener frameTokenBoxWidgetListener) {
		assert frameTokenBoxWidgetListener != null : "Precondition failed: frameTokenBoxWidgetListener != null";

		this.frameTokenBoxWidgetListener = frameTokenBoxWidgetListener;
	}

	private void handleKeyArrowLeftEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_LEFT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_LEFT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {

				fireMoveCursorToPreviousBox(action != Interaction.PREVIOUS_WORD, shiftKeyDown);
			}
		});
	}

	private void handleKeyArrowRightEvent(KeyDownEvent event, final Interaction action) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_RIGHT : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_RIGHT";

		final boolean shiftKeyDown = event.isShiftKeyDown();

		// Wait until cursor and selection are changed
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				fireMoveCursorToNextBox(shiftKeyDown);
			}
		});
	}

	private void handleSelectAllEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";

		fireMoveCursorToDocumentTop(false);
		fireMoveCursorToDocumentEnd(true);
	}

	private void handleKeyTabEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_TAB : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_TAB";

		boolean performDefaultHandling = false;
		if (event.isShiftKeyDown()) {
			frameTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), false, false);
		} else {
			frameTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), false);
		}
		// avoid default tab behavior, that brings you to the next
		// SimpleTextBox
		if (!performDefaultHandling) {
			event.preventDefault();
		}
	}

	private void handleKeyDeleteEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_DELETE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_DELETE";

		boolean performDefault = frameTokenBoxWidgetListener.handleForTokenSelection(getId(), false);
		if (performDefault) {
			frameTokenBoxWidgetListener.onDeleteNext(getId());
			event.preventDefault();
		}
	}

	private void handleKeyBackspaceEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		assert event
				.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE : "Precondition failed: event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE";

		boolean performDefault = frameTokenBoxWidgetListener.handleForTokenSelection(getId(), false);
		if (performDefault) {
			frameTokenBoxWidgetListener.onDeletePrevious(getId());
			event.preventDefault();
		}
	}

	private void fireMoveCursorToNextBox(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToNextBox(getId(), select);
		}
	}

	private void fireMoveCursorToPreviousBox(boolean atEnd, boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToPreviousBox(getId(), atEnd, select);
		}
	}

	private void fireMoveCursorToNextParagraph(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToNextParagraph(getId(), select);
		}
	}

	private void fireMoveCursorToPreviousParagraph(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToPreviousParagraph(getId(), select);
		}
	}

	private void fireMoveCursorToLineDown(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorLineDown(getId(), select);
		}
	}

	private void fireMoveCursorToLineUp(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorLineUp(getId(), select);
		}
	}

	private void fireMoveCursorToDocumentEnd(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToDocumentEnd(getId(), select);
		}
	}

	private void fireMoveCursorToDocumentTop(boolean select) {
		if (frameTokenBoxWidgetListener != null) {
			frameTokenBoxWidgetListener.onMoveCursorToDocumentTop(getId(), select);
		}
	}

	public interface FrameTokenBoxWidgetListener extends ResizableTokenBoxWidgetListener {

	}

	@Override
	public int getCursorLeft() {
		return 0;
	}

	@Override
	protected void setTokenBoxSize(int width, int height) {
		super.setTokenBoxSize(width, height);
		frameTokenBoxWidgetListener.onResizeToken(getId());
	}
}
