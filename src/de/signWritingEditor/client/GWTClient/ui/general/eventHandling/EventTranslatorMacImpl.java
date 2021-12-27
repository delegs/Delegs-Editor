package de.signWritingEditor.client.GWTClient.ui.general.eventHandling;

import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;

public class EventTranslatorMacImpl extends EventTranslatorStandardImpl {

	@Override
	public <E extends HasNativeEvent> Interaction get(E event) {
		Interaction result = Interaction.NONE;
		boolean altKey = event.getNativeEvent().getAltKey();
		boolean metaKey = event.getNativeEvent().getMetaKey();
		boolean shiftKey = event.getNativeEvent().getShiftKey();

		switch (event.getNativeEvent().getKeyCode()) {
		case (int) 'C':
			if (metaKey) {
				result = Interaction.COPY;
			}
			break;
		case (int) 'X':
			if (metaKey) {
				result = Interaction.CUT;
			}
			break;
		case (int) 'A':
			if (metaKey) {
				result = Interaction.SELECT_ALL;
			}
			break;
		case (int) 'V':
			if (metaKey) {
				result = Interaction.PASTE;
			}
			break;
		case (int) 'Z':
			if (metaKey) {
				if (shiftKey) {
					// CMD + SHIFT + Z is used to redo an action:
					result = Interaction.REDO;
				} else {
					// CMD + Z is used to undo an action:
					result = Interaction.UNDO;
				}
			}
			break;
		case KeyCodes.KEY_ENTER:
			if (metaKey) {
				result = Interaction.PAGE_BREAK;
			} else {
				result = Interaction.LINE_BREAK;
			}
			break;
		case KeyCodes.KEY_RIGHT:
			if (altKey) {
				result = Interaction.NEXT_WORD;
			} else {
				result = Interaction.RIGHT;
			}
			break;
		case KeyCodes.KEY_LEFT:
			if (altKey) {
				result = Interaction.PREVIOUS_WORD;
			} else {
				result = Interaction.LEFT;
			}
			break;
		case KeyCodes.KEY_DOWN:
			// Alt + arrow down is used for sign selection:
			if (!altKey) {
				if (metaKey) {
					result = Interaction.NEXT_PARAGRAPH;
				} else {
					result = Interaction.DOWN;
				}
			}
			break;
		case KeyCodes.KEY_UP:
			// Alt + arrow up is used for sign selection:
			if (!altKey) {
				if (metaKey) {
					result = Interaction.PREVIOUS_PARAGRAPH;
				} else {
					result = Interaction.UP;
				}
			}
			break;
		}

		return result;
	}
}
