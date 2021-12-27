package de.signWritingEditor.client.GWTClient.ui.general.eventHandling;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;

public class EventTranslatorStandardImpl {

	public enum Interaction {

		NONE, CUT, COPY, SELECT_ALL, PASTE, PAGE_BREAK, LINE_BREAK, LEFT, RIGHT, PREVIOUS_WORD, NEXT_WORD, NEXT_PARAGRAPH, PREVIOUS_PARAGRAPH, DOWN, UP, UNDO, REDO, ADD_FREE_TEXT_LINE

	}

	public <E extends HasNativeEvent> Interaction get(E event) {
		return getInteractionFromEvent(event.getNativeEvent());
	}

	public <E extends NativeEvent> Interaction getInteractionFromEvent(E event) {
		Interaction result = Interaction.NONE;
		boolean ctrlKey = event.getCtrlKey();
		boolean altKey = event.getAltKey();
		boolean shiftKey = event.getShiftKey();

		switch (event.getKeyCode()) {
		case (int) 'C':
			if (ctrlKey) {
				result = Interaction.COPY;
			}
			break;
		case (int) 'X':
			if (ctrlKey) {
				result = Interaction.CUT;
			}
			break;
		case (int) 'A':
			if (ctrlKey) {
				result = Interaction.SELECT_ALL;
			}
			break;
		case (int) 'V':
			if (ctrlKey) {
				result = Interaction.PASTE;
			}
			break;
		case (int) 'Z':
			// Ctrl + Z is used to undo an action:
			if (ctrlKey) {
				result = Interaction.UNDO;
			}
			break;
		case (int) 'Y':
			// Ctrl + Y is used to redo an action:
			if (ctrlKey) {
				result = Interaction.REDO;
			}
			break;
		case KeyCodes.KEY_ENTER:
			if (ctrlKey) {
				result = Interaction.PAGE_BREAK;
			} else {
				result = Interaction.LINE_BREAK;
			}
			break;
		case KeyCodes.KEY_RIGHT:
			if (ctrlKey) {
				result = Interaction.NEXT_WORD;
			} else {
				result = Interaction.RIGHT;
			}
			break;
		case KeyCodes.KEY_LEFT:
			if (ctrlKey) {
				result = Interaction.PREVIOUS_WORD;
			} else {
				result = Interaction.LEFT;
			}
			break;
		case KeyCodes.KEY_DOWN:
			// Alt + arrow down is used for sign selection:
			if (!altKey) {
				if (ctrlKey) {
					result = Interaction.NEXT_PARAGRAPH;
				} else {
					result = Interaction.DOWN;
				}
			}
			break;
		case KeyCodes.KEY_UP:
			// Alt + arrow up is used for sign selection:
			if (!altKey) {
				if (ctrlKey) {
					result = Interaction.PREVIOUS_PARAGRAPH;
				} else {
					result = Interaction.UP;
				}
			}
			break;
		case KeyCodes.KEY_SPACE:
			// Shift + space for adding a freetextline
			if (shiftKey) {
				result = Interaction.ADD_FREE_TEXT_LINE;
			}
		}
		return result;
	}
}
