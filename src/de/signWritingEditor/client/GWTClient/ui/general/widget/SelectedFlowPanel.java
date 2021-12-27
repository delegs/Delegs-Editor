package de.signWritingEditor.client.GWTClient.ui.general.widget;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.CopyPasteListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.InvisibleTextArea;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Pair;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.PasteEvent;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.PasteHandler;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.PasteTarget;

public class SelectedFlowPanel extends OrientedFlowPanel {

	private static final String SNIPPET_SELECTION_STYLE = "snippetSelection";
	private static final String STYLE_NAME = "snippet";
	private static final int MOUSE_OFFSET = 2;
	protected static final String RESIZE_BUTTON_SIZE = "10px";
	private static final int PAGE_BORDER_WIDTH = 1;

	private static final int FREE_POSITIONED_TOKEN_MARGIN_BOTTOM = 5;
	protected static final int FREE_POSITIONED_PARAGRAPH_BORDER_WIDTH = 3;
	protected static final int PADDING = 15;
	protected static final int DEFAULT_PARAGRAPH_WIDTH = 130;
	private static final int DEFAULT_PARAGRAPH_HEIGHT = 250;

	private static boolean isMouseDragging;

	private HandlerRegistration nativePreviewHandlerRegistration;
	private Button resizeButtonRight;
	private Button resizeButtonLeft;
	private boolean isAutomaticResizeActive;
	private InvisibleTextArea invisbleKeyHandlingTextArea;
	private boolean selected;
	private SimplePanel selectedBorderPanel;

	private FlowPanel linesPanel;
	private int x;
	private int y;
	private int width;
	private Id id;
	protected SnippetListener listener;
	protected int pageHeight;
	protected int pageWidth;

	public interface SelectableSnippetListener extends SnippetListener, CopyPasteListener {
		void onToggleSnippetSelection(Id paragraphId, boolean addToExistingSelection);

		void onDeselection(boolean deactivate);

		void onDeleteSnippet();
	}

	public interface SnippetListener {
		void onSnippetPositionChanged(Id id, int x, int y, boolean snapedToGrid, int deltaX, int deltaY);

		void onSnippetWidthChanged(Id id, int width, boolean automatic);
	}

	public static int getMinSnippetWidth() {
		return DEFAULT_PARAGRAPH_WIDTH + PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH;
	}

	protected SelectedFlowPanel() {
		super(Orientation.HORIZONTAL);
	}

	public SelectedFlowPanel(Id id, int x, int y, int width, int pageWidth, int pageHeight, int zIndex,
			SelectableSnippetListener documentUiListener, EventTranslatorStandardImpl eventTranslator,
			FontSizeService fontSizeService) {
		this();

		this.id = id;
		this.listener = documentUiListener;
		this.pageWidth = pageWidth;
		this.pageHeight = pageHeight;
		getElement().getStyle().setPosition(Position.ABSOLUTE);
		getElement().getStyle().clearWidth();
		getElement().getStyle().clearHeight();
		getElement().setAttribute("align", "left");

		linesPanel = new FlowPanel();
		super.add(linesPanel);
		Style style = linesPanel.getElement().getStyle();
		style.setPosition(Position.RELATIVE);
		style.clearTop();
		style.clearLeft();

		updatePosition(x, y, false);

		OrientedFlowPanel firstLine = new OrientedFlowPanel(Orientation.HORIZONTAL);
		add(firstLine);

		this.invisbleKeyHandlingTextArea = new InvisibleTextArea(eventTranslator, fontSizeService);

		super.add(invisbleKeyHandlingTextArea);

		invisbleKeyHandlingTextArea.addPasteHandler(new PasteHandler() {

			@Override
			public void onPaste(PasteEvent event) {
				handlePaste(event.getPastedText());
			}
		});

		addHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				getElement().getStyle().setCursor(Cursor.DEFAULT);
			}
		}, MouseOverEvent.getType());
		sinkEvents(Event.ONMOUSEOVER);

		addHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				getElement().getStyle().setCursor(Cursor.MOVE);
			}
		}, MouseOutEvent.getType());
		sinkEvents(Event.ONMOUSEOUT);

		setStyleName(STYLE_NAME);
		getElement().getStyle().setPadding(PADDING, Unit.PX);

		createResizeButtons();

		addSelectionHandlers();

		addKeyDownHandler();

		this.setWidth(width);
		isAutomaticResizeActive = true;
		selected = false;

		this.setZIndex(zIndex);

		selectedBorderPanel = new SimplePanel();
		selectedBorderPanel.setStyleName(SNIPPET_SELECTION_STYLE);

	}

	protected void handlePaste(String pastedText) {
		((SelectableSnippetListener) listener).onPaste(getId(), pastedText, PasteTarget.FP_PARAGRAPH);
	}

	private void addKeyDownHandler() {

		invisbleKeyHandlingTextArea.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (listener instanceof SelectableSnippetListener) {
					final SelectableSnippetListener selectableSnippetListener = (SelectableSnippetListener) listener;

					invisbleKeyHandlingTextArea.setText("");

					switch (event.getNativeKeyCode()) {
					case KeyCodes.KEY_BACKSPACE:
					case KeyCodes.KEY_DELETE:
						event.preventDefault();
						selectableSnippetListener.onDeleteSnippet();
						break;
					case KeyCodes.KEY_S:
						if (event.isControlKeyDown() || event.isMetaKeyDown()) {
							event.preventDefault();
						}
						break;
					default:
						switch (invisbleKeyHandlingTextArea.getInteractionFromEvent(event)) {
						case COPY:
							handleCopy();
							break;
						case CUT:
							break;
						default:
							break;
						}
					}
				}
			}
		});
	}

	private void handleCopy() {
		((SelectableSnippetListener) listener).onCopy();
	}

	private void addSelectionHandlers() {
		addHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				if (!isMouseDragging) {
					getElement().getStyle().setCursor(Cursor.MOVE);
					resizeButtonRight.setVisible(true);
					resizeButtonLeft.setVisible(true);

					if (!selected) {
						handleShowSelectionBorder();
					}
				}
			}
		}, MouseOverEvent.getType());

		sinkEvents(Event.ONMOUSEOVER);

		addHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				resizeButtonRight.setVisible(false);
				resizeButtonLeft.setVisible(false);
				getElement().getStyle().clearCursor();
				if (!selected) {
					handleHideSelectionBorder();
				}
			}
		}, MouseOutEvent.getType());
		sinkEvents(Event.ONMOUSEOUT);

		addHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				boolean isAdditiveSelection = event.getNativeEvent().getCtrlKey()
						|| event.getNativeEvent().getShiftKey();
				handleSelectSnippet(isAdditiveSelection);

				isMouseDragging = true;

				event.preventDefault();
				event.stopPropagation();

				final int offsetX = getAbsoluteLeft() - event.getClientX();
				final int offsetY = getAbsoluteTop() - event.getClientY();

				if (nativePreviewHandlerRegistration != null) {
					nativePreviewHandlerRegistration.removeHandler();
				}
				nativePreviewHandlerRegistration = Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

					@Override
					public void onPreviewNativeEvent(NativePreviewEvent event) {

						if (event.getTypeInt() == Event.ONMOUSEMOVE) {
							NativeEvent nativeEvent = event.getNativeEvent();

							int x = nativeEvent.getClientX() - getParent().getAbsoluteLeft();
							int y = nativeEvent.getClientY() - getParent().getAbsoluteTop();

							handlePositionChanged(offsetX, offsetY, x, y);
						} else if (event.getTypeInt() == Event.ONMOUSEUP) {
							nativePreviewHandlerRegistration.removeHandler();
							event.getNativeEvent().stopPropagation();
							isMouseDragging = false;
						}
					}
				});
			}
		}, MouseDownEvent.getType());

		addHandler(new MouseUpHandler() {

			@Override
			public void onMouseUp(MouseUpEvent event) {
				isMouseDragging = false;
			}

		}, MouseUpEvent.getType());

		sinkEvents(Event.ONMOUSEDOWN);
	}

	public void setSelection(boolean select) {
		this.selected = select;
		if (this.selected) {
			invisbleKeyHandlingTextArea.setFocus(true);
			handleShowSelectionBorder();
		} else {
			handleHideSelectionBorder();
		}
	}

	private void createResizeButtons() {
		resizeButtonRight = createResizeButton();
		resizeButtonRight.addStyleName("resizeButton-right");
		super.add(resizeButtonRight);

		resizeButtonRight.addHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();
				if (nativePreviewHandlerRegistration != null) {
					nativePreviewHandlerRegistration.removeHandler();
				}
				nativePreviewHandlerRegistration = Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

					@Override
					public void onPreviewNativeEvent(NativePreviewEvent event) {
						if (event.getTypeInt() == Event.ONMOUSEMOVE) {
							NativeEvent nativeEvent = event.getNativeEvent();
							handleResizeFromRight(nativeEvent.getClientX());
						} else if (event.getTypeInt() == Event.ONMOUSEUP) {
							nativePreviewHandlerRegistration.removeHandler();
							event.getNativeEvent().stopPropagation();
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
		}, MouseDownEvent.getType());
		resizeButtonRight.sinkEvents(Event.ONMOUSEDOWN);
		resizeButtonRight.setVisible(false);

		resizeButtonLeft = createResizeButton();
		resizeButtonLeft.addStyleName("resizeButton-left");
		super.add(resizeButtonLeft);

		resizeButtonLeft.addHandler(new MouseDownHandler() {

			@Override
			public void onMouseDown(MouseDownEvent event) {
				event.stopPropagation();
				if (nativePreviewHandlerRegistration != null) {
					nativePreviewHandlerRegistration.removeHandler();
				}
				nativePreviewHandlerRegistration = Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

					@Override
					public void onPreviewNativeEvent(NativePreviewEvent event) {

						if (event.getTypeInt() == Event.ONMOUSEMOVE) {
							NativeEvent nativeEvent = event.getNativeEvent();
							int deltaX = nativeEvent.getClientX() - getAbsoluteLeft();
							handleResizeFromLeft(deltaX);
						} else if (event.getTypeInt() == Event.ONMOUSEUP) {
							nativePreviewHandlerRegistration.removeHandler();
							event.getNativeEvent().stopPropagation();
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
		}, MouseDownEvent.getType());
		resizeButtonLeft.sinkEvents(Event.ONMOUSEDOWN);
		resizeButtonLeft.setVisible(false);
	}

	private Button createResizeButton() {
		Button button = new Button();
		button.addStyleName("resizeButton");
		button.getElement().getStyle().setCursor(Cursor.E_RESIZE);
		button.setVisible(false);
		return button;
	}

	protected void handleResizeFromRight(int eventX) {
		int newWidth = eventX - getAbsoluteLeft();

		int x = getXPositionRelativeToPage(eventX);

		if (x > pageWidth) {
			x = pageWidth;
			newWidth = x - getXPositionRelativeToPage(getAbsoluteLeft());
		}

		handleWidthChanged(newWidth, false);
		updateSelectionPosition();
	}

	protected void handleResizeFromLeft(int deltaX) {
		int adjustedWidthChange = getChangedWidthForResizeFromLeft(deltaX);
		int delta = move(adjustedWidthChange, 0);
		if (delta != 0) {
			resize(delta, false);
		}
	}

	private void resize(int deltaWidth, boolean automatic) {
		handleWidthChanged(getWidth() + deltaWidth, automatic);
		updateSelectionPosition();
	}

	@Override
	public void add(Widget widget) {
		widget.getElement().getStyle().setMarginTop(PageFormat.SNIPPET_LINE_DISTANCE, Unit.PX);
		widget.getElement().getStyle().setMarginBottom(SnippetLayout.getTokenMarginBottom(), Unit.PX);
		linesPanel.add(widget);

		if (isAttached()) {
			updateSelectionPosition();
		}
	}

	@Override
	public Widget getWidget(int index) {
		return linesPanel.getWidget(index);
	}

	@Override
	public int getWidgetCount() {
		return linesPanel.getWidgetCount();
	}

	private int getXPositionRelativeToPage(int xSegment) {
		int xPage = getParent().getAbsoluteLeft();
		int x = xSegment - xPage;
		return x;
	}

	@Override
	public void insert(Widget widget, int beforeIndex) {
		widget.getElement().getStyle().setMarginTop(PageFormat.SNIPPET_LINE_DISTANCE, Unit.PX);
		widget.getElement().getStyle().setMarginBottom(SnippetLayout.getTokenMarginBottom(), Unit.PX);

		linesPanel.insert(widget, beforeIndex);

		boolean isEmptyLine = widget instanceof OrientedFlowPanel && widget.getElement().getChildCount() == 0;
		boolean isFreeTextLine = widget instanceof FreeTextTokenBoxWidget
				? ((FreeTextTokenBoxWidget) widget).isFreeTextLine()
				: false;
		if (isAutomaticResizeActive() && !isFreeTextLine && !isEmptyLine) {
			resize(widget.getOffsetWidth(), true);
		}
	}

	@Override
	public boolean remove(Widget widget) {
		boolean remove = linesPanel.remove(widget);
		boolean isEmptyLine = widget instanceof OrientedFlowPanel && widget.getElement().getChildCount() == 0;
		boolean isFreeTextTokenBoxWidget = widget instanceof FreeTextTokenBoxWidget;
		boolean isFreeTextLine = isFreeTextTokenBoxWidget ? ((FreeTextTokenBoxWidget) widget).isFreeTextLine() : false;

		if (remove) {
			if (!isEmptyLine && !isFreeTextLine) {
				resize(-widget.getOffsetWidth(), true);
			}
		}
		return remove;
	}

	@Override
	public boolean remove(int index) {
		Widget panelToRemove = getWidget(index);
		return remove(panelToRemove);
	}

	public boolean isAutomaticResizeActive() {
		return isAutomaticResizeActive;
	}

	public void setAutomaticResizeActive(boolean isAutomaticResizeActive) {
		this.isAutomaticResizeActive = isAutomaticResizeActive;
	}

	private void handleSelectSnippet(boolean addToExistingSelection) {
		if (listener instanceof SelectableSnippetListener) {
			((SelectableSnippetListener) listener).onToggleSnippetSelection(this.getId(), addToExistingSelection);
		}
	}

	public int getZIndex() {
		int result = 0;
		try {
			result = Integer.parseInt(getElement().getStyle().getZIndex());
		} catch (NumberFormatException e) {
			// keep default
		}
		return result;
	}

	public void setZIndex(int zIndex) {
		getElement().getStyle().setZIndex(zIndex);
		assert getZIndex() == zIndex : "Postcondition failed: getZIndex() == zIndex";
	}

	private void handleShowSelectionBorder() {
		if (!selectedBorderPanel.isAttached()) {
			((Panel) getOuterPagePanel()).add(selectedBorderPanel);
		}
		updateSelectionPosition();
	}

	private void updateSelectionPosition() {
		assert this.isAttached() : "Precondition failed: this.isAttached()";

		int absolutePositionLeft = this.getAbsoluteLeft() - getOuterPagePanel().getAbsoluteLeft() - PAGE_BORDER_WIDTH;
		int absolutePositionRight = this.getAbsoluteTop() - getOuterPagePanel().getAbsoluteTop() - PAGE_BORDER_WIDTH;
		selectedBorderPanel.getElement().getStyle().setLeft(absolutePositionLeft, Unit.PX);
		selectedBorderPanel.getElement().getStyle().setTop(absolutePositionRight, Unit.PX);
		selectedBorderPanel.setWidth(this.getOffsetWidth() + "px");
		selectedBorderPanel.setHeight(this.getOffsetHeight() + "px");
	}

	private Widget getOuterPagePanel() {
		return this.getParent().getParent();
	}

	private void handleHideSelectionBorder() {
		((Panel) getOuterPagePanel()).remove(selectedBorderPanel);
	}

	private void handlePositionChanged(final int offsetX, final int offsetY, int x, int y) {
		updatePosition(x - MOUSE_OFFSET + offsetX, y - 2 * MOUSE_OFFSET + offsetY);
		updateSelectionPosition();
	}

	public Pair<Integer, Integer> getParagraphCenter() {
		int x = getAbsoluteLeft() + getOffsetWidth() / 2;
		int y = getAbsoluteTop() + getOffsetHeight() / 2;
		Pair<Integer, Integer> result = new Pair<Integer, Integer>(x, y);
		return result;
	}

	public void updateSnippetSelection() {
		if (isAttached()) {
			updateSelectionPosition();
		}
	}

	public void updatePosition(int x, int y) {

		// Die Margin muss extra eingerechnet werden, da getClientHeigth diese
		// ignoriert
		int height = linesPanel.getElement().getClientHeight()
				+ linesPanel.getWidgetCount() * SnippetLayout.getTokenMarginBottom();

		x = Math.max(x, 0);
		y = Math.max(y, 0);

		if (x > 0) {
			x = Math.min(x, pageWidth - getWidth());
		}
		if (y > 0) {
			y = Math.min(y, pageHeight - height);
		}

		int deltaX = 0;
		int deltaY = 0;

		boolean snapped = false;
		if (x >= 0) {
			deltaX = adjustSnappingOnToAchsis(x);
		}
		if (y >= 0) {
			deltaY = adjustSnappingOnToAchsis(y);
		}

		// Right snapping
		if (deltaX == 0 && (x % PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH != 0)) {
			deltaX = adjustSnappingOnToAchsis(x + getOffsetWidth());
		}

		if (deltaX != 0 || deltaY != 0) {
			snapped = true;
		}
		x = x - deltaX;
		y = y - deltaY;
		updatePosition(x, y, true, snapped, deltaX, deltaY);
	}

	private int adjustSnappingOnToAchsis(int position) {
		int delta = 0;
		int temp = Math.abs(position + PageFormat.COLLAGE_GRID_SNAP_DISTANCE_MARGIN);
		if (temp % PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH <= 2 * PageFormat.COLLAGE_GRID_SNAP_DISTANCE_MARGIN) {
			delta = (temp % PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH) - PageFormat.COLLAGE_GRID_SNAP_DISTANCE_MARGIN;
		}
		return delta;
	}

	public void updatePosition(int x, int y, boolean fireNotification) {
		this.x = x;
		this.y = y;

		getElement().getStyle().setLeft(x, Unit.PX);
		getElement().getStyle().setTop(y, Unit.PX);

		if (fireNotification) {
			listener.onSnippetPositionChanged(getId(), x, y, false, 0, 0);
		}

		if (isAttached()) {
			updateSelectionPosition();
		}
	}

	private void updatePosition(int x, int y, boolean fireNotification, boolean snapedToGrid, int deltaX, int deltaY) {
		this.x = x;
		this.y = y;

		getElement().getStyle().setLeft(x, Unit.PX);
		getElement().getStyle().setTop(y, Unit.PX);

		if (fireNotification) {
			listener.onSnippetPositionChanged(getId(), x, y, snapedToGrid, deltaX, deltaY);
		}
	}

	protected int move(int deltaX, int deltaY) {
		int oldX = x;
		updatePosition(x + deltaX, y + deltaY);
		return oldX - x;
	}

	public void snapToGrid() {
		updatePosition(this.x, this.y);
	}

	protected int getChangedWidthForResizeFromLeft(int deltaX) {
		int result = deltaX;
		int newValueAdjustment = adjustSnappingOnToAchsis(x + deltaX);
		int oldValueAdjustment = adjustSnappingOnToAchsis(x + width);
		if (deltaX - newValueAdjustment > width - DEFAULT_PARAGRAPH_WIDTH - oldValueAdjustment
				- PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH) {
			result = width - DEFAULT_PARAGRAPH_WIDTH - oldValueAdjustment - PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH;
		}
		return result;
	}

	protected void handleWidthChanged(int width, boolean automatic) {
		width = width >= DEFAULT_PARAGRAPH_WIDTH ? width : DEFAULT_PARAGRAPH_WIDTH;
		int delta = adjustSnappingOnToAchsis(x + width - FREE_POSITIONED_PARAGRAPH_BORDER_WIDTH);
		if (delta <= 0) {
			width -= delta;
		} else {
			width += (PageFormat.COLLAGE_GRID_TILE_EDGE_LENGTH - delta);
		}

		if (width > pageWidth) {
			width = pageWidth;
		}

		setWidth(width);

		listener.onSnippetWidthChanged(getId(), width, automatic);
	}

	public int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
		getElement().getStyle().setWidth(width - 2 * PADDING, Unit.PX);
	}

	protected Id getId() {
		return id;
	}

}
