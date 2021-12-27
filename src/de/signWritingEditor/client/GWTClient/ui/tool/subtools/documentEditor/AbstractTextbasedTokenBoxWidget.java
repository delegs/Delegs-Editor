package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Window.Location;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public abstract class AbstractTextbasedTokenBoxWidget extends AbstractTokenBoxWidget implements TextContainer {
	protected String generateErrorImageURL(String errorMessage) {
		String fullUrl = "/signwritingeditor/errorImage?error-message=" + errorMessage;

		// workaround because infrastructure
		if (Location.getHref().contains("delegseditor") || Location.getHref().contains("delegseditortest")) {
			fullUrl = Location.getPath() + fullUrl.substring(0);
		}

		return fullUrl;
	}

	public AbstractTextbasedTokenBoxWidget() {
	}

	public abstract void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler);

	public abstract void setCursorPositionAndFocus(int cursorPosition);

	public abstract String getText();

	public boolean isWholeTextSelected() {
		return true;
	}

	public abstract void setDragModeHandler(MouseDragListener listener);

	public interface TextbasedTokenBoxWidgetListener extends TokenBoxWidgetListener {
		void onSelectToken(Id tokenId, boolean isShiftPressed, boolean selectWholeBox);

		void onInsertFreeTextLineAfterToken(Id id);

		void onMoveCursorToPreviousPage(Id tokenId, boolean select);

		void onMoveCursorToNextPage(Id tokenId, boolean select);

		void onMoveCursorToPreviousBox(Id tokenId, boolean interactionPreviousWord, boolean select);
	}

	public interface MouseDragListener {
		public void setInDragMode(MouseDownEvent event);
	}

	public abstract void setTextBoxBackgroundColor(Color color);
}
