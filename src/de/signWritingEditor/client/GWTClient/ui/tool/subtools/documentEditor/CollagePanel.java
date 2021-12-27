package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;

public class CollagePanel extends PagePanel {

	private static final String STYLE_COLLAGE = "collage";
	private boolean isInDrawParagraphMode;
	private InvisibleTextArea invisibleTextArea;
	private CollageListener documentUiListener;
	private Id collageId;
	private FontSizeService fontSizeService;
	private boolean isInDeleteMode;

	public CollagePanel(PageFormat pageFormat, String footerText, Id collageId, CollageListener documentUiListener,
			EventTranslatorStandardImpl eventTranslator, FontSizeService fontSizeService) {
		super(pageFormat, footerText);
		this.collageId = collageId;
		this.documentUiListener = documentUiListener;
		this.fontSizeService = fontSizeService;
		final FlowPanel page = getInnerPagePanel();
		page.getElement().getStyle().setBackgroundImage("url('images/squared.png')");
		page.getElement().getStyle().setWidth(100, Unit.PCT);
		page.getElement().getStyle().setHeight(100, Unit.PCT);
		page.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		page.getParent().getElement().getStyle().clearPadding();
		page.addStyleName(STYLE_COLLAGE);
		page.getElement().getStyle().setZIndex(0);

		page.addHandler(new CollageMouseDownHandler(page, collageId, documentUiListener, new SelectionListener() {
			@Override
			public void onSelectBetween(int startX, int startY, int endX, int endY) {
				handleSelectBetween(startX, startY, endX, endY);
			}
		}), MouseDownEvent.getType());
		page.sinkEvents(Event.ONMOUSEDOWN);

		invisibleTextArea = new InvisibleTextArea(eventTranslator, fontSizeService);
		invisibleTextArea.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				handleKeyDownEvent(event);
			}
		});

		invisibleTextArea.addPasteHandler(new PasteHandler() {

			@Override
			public void onPaste(PasteEvent event) {
				CollagePanel.this.documentUiListener.onPaste(CollagePanel.this.collageId, event.getPastedText(),
						PasteTarget.FP_PAGE);
			}
		});
		this.add(invisibleTextArea);
	}

	protected void handleKeyDownEvent(KeyDownEvent event) {
		assert event != null : "Precondition failed: event != null";
		event.stopPropagation();
		switch (invisibleTextArea.getInteractionFromEvent(event)) {
		case COPY:
			handleCopy();
			break;
		default:
			break;
		}
	}

	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
	}

	private void handleCopy() {
		documentUiListener.onCopy();
	}

	private boolean isInDrawParagraphMode() {
		return isInDrawParagraphMode;
	}

	private boolean isInDeleteMode() {
		return isInDeleteMode;
	}

	public void setInDrawParagraphMode(boolean isInDrawParagraphMode) {
		this.isInDrawParagraphMode = isInDrawParagraphMode;
		if (isInDrawParagraphMode) {
			setCursorOnPage(Cursor.CROSSHAIR);
		} else {
			clearCursorOnPage();
		}
	}

	public void setInDeleteMode(boolean isInDeleteMode) {
		this.isInDeleteMode = isInDeleteMode;
		if (isInDeleteMode) {
			setCursorOnPage(Cursor.POINTER);
		} else {
			clearCursorOnPage();
		}
	}

	private class CollageMouseDownHandler implements MouseDownHandler {

		private static final int MAX_Z_INDEX = 999;
		HandlerRegistration reg;
		int x;
		int y;
		private FlowPanel page;
		private Id collageId;
		private CollageListener documentUiListener;
		private SelectionListener selectionListener;

		public CollageMouseDownHandler(FlowPanel page, Id collageId, CollageListener documentUiListener,
				SelectionListener selectionListener) {
			super();
			this.page = page;
			this.collageId = collageId;
			this.documentUiListener = documentUiListener;
			this.selectionListener = selectionListener;
		}

		@Override
		public void onMouseDown(MouseDownEvent event) {
			if (event.getNativeButton() == NativeEvent.BUTTON_LEFT) {
				handleMouseDownEvent(event.getClientX() - page.getAbsoluteLeft(),
						event.getClientY() - page.getAbsoluteTop());
			}
		}

		private void handleMouseDownEvent(int newX, int newY) {
			x = newX;
			y = newY;

			final SimplePanel boxPanel = new SimplePanel();
			boxPanel.getElement().getStyle().clearBackgroundColor();
			boxPanel.getElement().getStyle().setLeft(x, Unit.PX);
			boxPanel.getElement().getStyle().setTop(y, Unit.PX);
			boxPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
			// Allways on top
			boxPanel.getElement().getStyle().setZIndex(MAX_Z_INDEX);
			boxPanel.addStyleName("drawBox");
			page.add(boxPanel);

			if (isInDrawParagraphMode()) {
				setBorderStyleForParagraphCreation(boxPanel);
				reg = addSnippetNativePreviewHandler(collageId, page, boxPanel);
			} else if (isInDeleteMode()) {
				documentUiListener.onDeleteCollageModeChanged(false);
				documentUiListener.onDeleteCollage(collageId);
			} else {
				setBorderStyleForSelection(boxPanel);
				reg = addSelectionBoxDragHandler(collageId, page, boxPanel);
			}

			invisibleTextArea.getElement().getStyle().setTop(y, Unit.PX);
			invisibleTextArea.getElement().getStyle().setLeft(x, Unit.PX);
			invisibleTextArea.setFocus(true);
		}

		private void setBorderStyleForSelection(final SimplePanel boxPanel) {
			boxPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
			boxPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
			boxPanel.getElement().getStyle().setBackgroundColor("#EEEEEE");
			boxPanel.getElement().getStyle().setOpacity(0.7);
			boxPanel.getElement().getStyle().setBorderColor("black");
		}

		private void setBorderStyleForParagraphCreation(final SimplePanel boxPanel) {
			boxPanel.getElement().getStyle().setBorderStyle(BorderStyle.DOTTED);
			boxPanel.getElement().getStyle().setBorderWidth(2, Unit.PX);
			boxPanel.setPixelSize(100, 100);
		}

		private HandlerRegistration addSelectionBoxDragHandler(final Id collageId, final FlowPanel page,
				final SimplePanel boxPanel) {
			return Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

				@Override
				public void onPreviewNativeEvent(NativePreviewEvent event) {

					if (event.getTypeInt() == Event.ONMOUSEMOVE) {
						drawBoxOnScreen(page, boxPanel, event);
						selectionListener.onSelectBetween(boxPanel.getAbsoluteLeft(), boxPanel.getAbsoluteTop(),
								boxPanel.getAbsoluteLeft() + boxPanel.getOffsetWidth(),
								boxPanel.getAbsoluteTop() + boxPanel.getOffsetHeight());
					} else if (event.getTypeInt() == Event.ONMOUSEUP) {
						int newX = event.getNativeEvent().getClientX() - page.getAbsoluteLeft();
						int newY = event.getNativeEvent().getClientY() - page.getAbsoluteTop();
						int width = Math.abs(newX - x);
						int height = Math.abs(newY - y);
						page.remove(boxPanel);
						removePreviewHandler();
						boolean addToExistingSelection = event.getNativeEvent().getCtrlKey()
								|| event.getNativeEvent().getShiftKey();
						documentUiListener.onSelectSnippetsFromTo(collageId, x < newX ? x : newX, y < newY ? y : newY,
								width, height, addToExistingSelection);
					} else if (event.getTypeInt() == Event.ONMOUSEOVER) {
						event.getNativeEvent().stopPropagation();
						event.getNativeEvent().preventDefault();
					} else if (event.getTypeInt() == Event.ONMOUSEOUT) {
						event.getNativeEvent().stopPropagation();
						event.getNativeEvent().preventDefault();
					}
				}
			});
		}

		private HandlerRegistration addSnippetNativePreviewHandler(final Id collageId, final FlowPanel page,
				final SimplePanel boxPanel) {
			return Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

				@Override
				public void onPreviewNativeEvent(NativePreviewEvent event) {

					if (event.getTypeInt() == Event.ONMOUSEUP) {
						int newX = event.getNativeEvent().getClientX() - page.getAbsoluteLeft();
						int newY = event.getNativeEvent().getClientY() - page.getAbsoluteTop();
						removePreviewHandler();
						page.remove(boxPanel);
						boolean automatic = false;
						int width = newX - x;
						if (width < 0) {
							x = newX;
							width = -width;
						} else if (width > getElement().getClientWidth()) {
							x = 0;
							width = getElement().getClientWidth();
						}

						if (newY - y < 0) {
							y = newY;
						}

						if (width < 100) {
							width = 2 * PageFormat.COLLAGE_PADDING;
							automatic = true;

						}

						int paragraphWidth = width - 2 * PageFormat.COLLAGE_PADDING;
						if (paragraphWidth < SelectedFlowPanel.getMinSnippetWidth()) {
							paragraphWidth = SelectedFlowPanel.getMinSnippetWidth();
						}

						paragraphWidth = (paragraphWidth / PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH)
								* PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH;

						documentUiListener.addParagraph(collageId, x, y, paragraphWidth, automatic);
						documentUiListener.onDrawParagraphModeChanged(false);
						clearCursorOnPage();
					} else if (event.getTypeInt() == Event.ONMOUSEMOVE) {
						drawBoxOnScreen(page, boxPanel, event);
					} else if (event.getTypeInt() == Event.ONMOUSEOVER) {
						event.getNativeEvent().stopPropagation();
						event.getNativeEvent().preventDefault();
					} else if (event.getTypeInt() == Event.ONMOUSEOUT) {
						event.getNativeEvent().stopPropagation();
						event.getNativeEvent().preventDefault();
					}
				}
			});
		}

		void removePreviewHandler() {
			reg.removeHandler();
		}

		protected void drawBoxOnScreen(final FlowPanel page, final SimplePanel boxPanel, NativePreviewEvent event) {
			int newX = event.getNativeEvent().getClientX() - page.getAbsoluteLeft();
			int newY = event.getNativeEvent().getClientY() - page.getAbsoluteTop();

			int width = newX - x;
			if (width < 0) {
				width = -width;
				boxPanel.getElement().getStyle().setLeft(newX, Unit.PX);
			}

			int height = newY - y;

			if (height < 0) {
				height = -height;
				boxPanel.getElement().getStyle().setTop(newY, Unit.PX);
			}

			boxPanel.setPixelSize(width, height);
		}

	}

	public void showCollageGrid(boolean visible) {
		if (visible) {
			getInnerPagePanel().getElement().getStyle().setBackgroundImage("url('images/squared.png')");
		} else {
			getInnerPagePanel().getElement().getStyle().clearBackgroundImage();
		}
	}

	public void handleSelectBetween(int startX, int startY, int endX, int endY) {
		OrientedFlowPanel innerPagePanel = this.getInnerPagePanel();
		for (int i = 0; i < innerPagePanel.getWidgetCount(); i++) {
			Widget w = innerPagePanel.getWidget(i);
			if (w instanceof SelectedFlowPanel) {
				SelectedFlowPanel selectedFlowPanel = (SelectedFlowPanel) w;
				Pair<Integer, Integer> paragraphCenter = selectedFlowPanel.getParagraphCenter();
				int paragraphMiddleX = paragraphCenter.getA();
				int paragraphMiddleY = paragraphCenter.getB();
				if (paragraphMiddleX >= startX && paragraphMiddleX <= endX //
						&& paragraphMiddleY >= startY && paragraphMiddleY <= endY//
				) {
					selectedFlowPanel.setSelection(true);
				} else {
					selectedFlowPanel.setSelection(false);
				}
			}
		}
	}

	public void setCursorOnPage(Cursor cursor) {
		this.getElement().getStyle().setCursor(cursor);
	}

	public void clearCursorOnPage() {
		this.getElement().getStyle().clearCursor();
	}

	public static String getStyleCollage() {
		return STYLE_COLLAGE;
	}

	protected interface SelectionListener {
		void onSelectBetween(int startX, int startY, int endX, int endY);
	}

	public interface CollageListener extends CopyPasteListener {
		void addParagraph(Id collageId, int x, int y, int width, boolean automatic);

		void onDrawParagraphModeChanged(boolean b);

		void onDeleteCollageModeChanged(boolean b);

		void onSelectSnippetsFromTo(Id collageId, int x, int y, int width, int height, boolean addToExistingSelection);

		void onDeleteCollage(Id collageId);
	}
}
