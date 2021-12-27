package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.material.TokenBox;

public abstract class AbstractTokenBoxWidget extends Composite {

	private Button resizeButton;
	private HandlerRegistration resizeHandler;

	public AbstractTokenBoxWidget() {
		super();
		resizeButton = createResizeButton();
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		this.getElement().getStyle().setVerticalAlign(VerticalAlign.BOTTOM);
	}

	private Button createResizeButton() {
		Button resizeButton = new Button();
		resizeButton.getElement().getStyle().setHeight(2, Unit.PX);
		resizeButton.getElement().getStyle().setPadding(3, Unit.PX);
		resizeButton.getElement().getStyle().setBorderWidth(1, Unit.PX);
		resizeButton.getElement().getStyle().setPosition(Position.ABSOLUTE);
		resizeButton.getElement().getStyle().setBottom(0, Unit.PX);
		resizeButton.getElement().getStyle().setRight(0, Unit.PX);

		resizeButton.addMouseDownHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();

				if (resizeHandler == null && isResizeable()) {
					resizeHandler = Event.addNativePreviewHandler(new NativePreviewHandler() {

						@Override
						public void onPreviewNativeEvent(NativePreviewEvent event) {
							if (event.getTypeInt() == Event.ONMOUSEMOVE) {
								int width = event.getNativeEvent().getClientX();
								int left = AbstractTokenBoxWidget.this.getAbsoluteLeft();
								width = width - left;

								int top = AbstractTokenBoxWidget.this.getAbsoluteTop();
								int height = event.getNativeEvent().getClientY() - top;

								setTokenBoxSize(width, height);
								focus();
							} else if (event.getTypeInt() == Event.ONMOUSEUP) {
								resizeHandler.removeHandler();
								resizeHandler = null;
							}
						}
					});
				}
			}
		});

		return resizeButton;
	}

	protected void addResizeButtonToPanel(Panel panel) {
		panel.add(resizeButton);
	}

	protected abstract void setTokenBoxSize(int width, int height);

	protected abstract boolean isResizeable();

	public abstract Id getId();

	public abstract void focus();

	public abstract void toggleSelection();

	public abstract TokenBox getTokenBox();

	public abstract void setTokenBox(TokenBox tokenBox);

	public abstract int getCursorLeft();

	public void setBackgroundColor(Color color) {
		this.getElement().getFirstChildElement().getStyle().setBackgroundColor(color.getCssValue());
	}

	public interface TokenBoxWidgetListener extends CopyPasteListener {

		void onSelectToken(Id tokenId, boolean select);

		void onDeleteNext(Id id);

		void onDeletePrevious(Id id);

		boolean handleForTokenSelection(Id firingTokenId, boolean textChanged);

		void onMoveCursorToPreviousParagraph(Id tokenId, boolean select);

		void onMoveCursorToNextParagraph(Id tokenId, boolean select);

		void onMoveCursorLineUp(Id tokenId, boolean select);

		void onMoveCursorLineDown(Id tokenId, boolean select);

		void onMoveCursorToNextBox(Id tokenId, boolean select);

		void onMoveCursorToPreviousBox(Id tokenId, boolean interactionPreviousWord, boolean select);

		void onMoveCursorToDocumentEnd(Id tokenId, boolean select);

		void onMoveCursorToDocumentTop(Id tokenId, boolean select);

		void onMoveCursorToLineEnd(Id tokenId, boolean select);

		void onMoveCursorToLineStart(Id tokenId, boolean select);
	}

	public interface ResizableTokenBoxWidgetListener extends TokenBoxWidgetListener {

		void onResizeToken(Id tokenId);
	}
}