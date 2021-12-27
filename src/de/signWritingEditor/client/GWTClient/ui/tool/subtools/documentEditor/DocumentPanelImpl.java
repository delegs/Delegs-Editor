package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorMacImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.TokenBox;

public class DocumentPanelImpl extends Composite implements DocumentPanel {
	private static final int FOOTER_TEXT_LABEL_INDEX = 1;
	private static final int FOOTER_PAGE_NUMBER_LABEL_INDEX = 2;
	protected static final int SCROLL_PAGE_MARGIN_TOP = 100;

	private SimplePanel simplePanel;
	private FlowPanel pagesPanel;

	protected DocumentUiListener documentUiListener;
	private QuickSaveListener quickSaveListener;

	private boolean isInDragMode;
	private String underLineStyleName;
	private String footerText;

	protected EventTranslatorStandardImpl eventTranslator;
	protected URLConverter urlConverter;
	protected FontSizeService fontSizeService;
	protected TokenBoxWidgetFactory tokenBoxWidgetFactory;
	protected VisibilityToolTip visibilityToolTip;
	protected DocumentPanelListener documentPanelListener;

	@Override
	public void init() {
		footerText = "";
		underLineStyleName = "underlined";

		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		} else {
			eventTranslator = GWT.create(EventTranslatorStandardImpl.class);
		}

		setInDragMode(false);

		simplePanel = new SimplePanel();

		pagesPanel = new FlowPanel();
		pagesPanel.getElement().setAttribute("align", "center");

		SimplePanel contentPanel = new SimplePanel(pagesPanel);
		contentPanel.setStyleName("toolPanel");
		simplePanel.add(contentPanel);
		simplePanel.addStyleName("documentPanel");

		visibilityToolTip = new VisibilityToolTip(false, 59);
		visibilityToolTip.setVisibleCustom(false);
		visibilityToolTip.getElement().getStyle().setZIndex(50);
		RootPanel.get().add(visibilityToolTip, -100, -100);

		documentPanelListener = new DocumentPanelListener() {

			@Override
			public void onActivateDragMode(MouseDownEvent event) {
				activateDragMode(event);
			}

			@Override
			public void setInDragMode(boolean dragMode) {
				DocumentPanelImpl.this.setInDragMode(dragMode);
			}

			@Override
			public void onMouseDragged(Event event) {
				if (isInDragMode) {
					handleMouseDragged(event);
				}
			}
		};

		initWidget(simplePanel);

		this.sinkEvents(Event.ONKEYDOWN | Event.ONMOUSEDOWN | Event.ONMOUSEUP | Event.ONMOUSEMOVE);
	}

	public void setDocumentUiListener(DocumentUiListener documentUiListener) {
		assert documentUiListener != null : "Precondition failed: documentUiListener != null";
		this.documentUiListener = documentUiListener;
	}

	@Override
	public void setFontSizeService(FontSizeService fontSizeService) {
		this.fontSizeService = fontSizeService;
	}

	public void setSaveListener(QuickSaveListener quickSaveListener) {
		this.quickSaveListener = quickSaveListener;
	}

	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		handleBrowserEvent(event);
	}

	public void copyToSystemClipboard(String text, final CopyToClipboardCompletionListener completionHandler) {
		assert text != null : "Precondition failed: text != null";
		assert completionHandler != null : "Precondition failed: completionHandler != null";
		// Copy text into invisible text area so it gets copied by the
		// browser
		final InvisibleTextArea copyTextArea = new InvisibleTextArea(getEventTranslator(), fontSizeService);
		RootPanel.get().add(copyTextArea);
		copyTextArea.setText(text);

		// Remove invisible text area and refocus the correct token
		copyTextArea.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				RootPanel.get().remove(copyTextArea);
				completionHandler.onCopyToClipboardCompleted();
			}
		});
		// Default behaviour copies selected text to system clipboard
		copyTextArea.setFocus(true);
		copyTextArea.setSelectionRange(0, text.length());
	}

	public int getPageCount() {
		return pagesPanel.getWidgetCount();
	}

	public FlowPanel getPage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		AbsolutePanel outerPagePanel = (AbsolutePanel) pagesPanel.getWidget(pageIndex);

		FlowPanel result = (FlowPanel) outerPagePanel.getWidget(0);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public void insertNewPage(int pageIndex, PageFormat pageFormat) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex <= getPageCount() : "Precondition failed: pageIndex <= getPageCount()";
		assert pageFormat != null : "Precondition failed: pageFormat != null";

		PagePanel outerPagePanel = new PagePanel(pageFormat, footerText);
		insertNewPage(pageIndex, outerPagePanel);
	}

	public void insertNewCollage(int pageIndex, PageFormat pageFormat, Id collageId, boolean showCollageGrid) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex <= getPageCount() : "Precondition failed: pageIndex <= getPageCount()";
		assert pageFormat != null : "Precondition failed: pageFormat != null";

		CollagePanel outerPagePanel = new CollagePanel(pageFormat, footerText, collageId, documentUiListener,
				getEventTranslator(), fontSizeService);
		insertNewPage(pageIndex, outerPagePanel);
		outerPagePanel.showCollageGrid(showCollageGrid);
	}

	private void insertNewPage(int pageIndex, PagePanel pagePanel) {
		pagesPanel.insert(pagePanel, pageIndex);
		updateFooterPageNumbers();
	}

	public void removePage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		pagesPanel.remove(pageIndex);

		updateFooterPageNumbers();
	}

	public int getLineCount(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert !isCollage(pageIndex) : "Precondition failed: !isCollage(pageIndex)";
		return getPage(pageIndex).getWidgetCount();
	}

	public int getLineCount(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: pageIndex >= 0";
		assert lineIndexObject.getPageIndex() < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		return getLineParent(lineIndexObject).getWidgetCount();
	}

	public int getSnippetCount(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert isCollage(pageIndex) : "Precondition failed: isCollage(pageIndex)";

		return getPage(pageIndex).getWidgetCount();
	}

	public void insertNewLine(LineIndex lineIndexObject, Orientation pageOrientation) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() <= getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() <= getLineCount(lineIndexObject))";
		assert pageOrientation != null : "Precondition failed: pageOrientation != null";

		Orientation lineOrientation = pageOrientation.toggle();

		FlowPanel newLine = new OrientedFlowPanel(lineOrientation);

		if (lineOrientation == Orientation.VERTICAL) {
			newLine.setHeight("100%");
		} else {
			newLine.setWidth("100%");
		}

		getLineParent(lineIndexObject).insert(newLine, lineIndexObject.getLineIndex());
	}

	private FlowPanel getLineParent(LineIndex lineIndexObject) {
		assert lineIndexObject != null : "Precondition failed: lineIndexObject != null";
		assert isCollage(lineIndexObject.getPageIndex()) == lineIndexObject
				.isCollageLineIndex() : "Precondition failed: isCollage(lineIndexObject.getPageIndex())==lineIndexObject.isCollageLineIndex()";

		FlowPanel result = null;

		FlowPanel pagePanel = getPage(lineIndexObject.getPageIndex());
		if (lineIndexObject.isCollageLineIndex()) {
			result = (FlowPanel) pagePanel.getWidget(lineIndexObject.getSnippetIndex());
		} else {
			result = pagePanel;
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public void removeLine(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		// Make sure the visibility tooltip does not refer to an invalid tokenid
		visibilityToolTip.setVisibleCustom(false);

		getLineParent(lineIndexObject).remove(lineIndexObject.getLineIndex());
	}

	public int getIdBoxWidgetCount(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		return getLine(lineIndexObject).getWidgetCount();
	}

	public AbstractTokenBoxWidget getTokenBoxWidget(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		AbstractTokenBoxWidget result = (AbstractTokenBoxWidget) getLine(boxIndexObject.getLineIndexObject())
				.getWidget(boxIndexObject.getBoxIndex());
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public FreeTextTokenBoxWidget getFreeTextLineWidget(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		Widget widget = getLine(boxIndexObject.getLineIndexObject()).getWidget(boxIndexObject.getBoxIndex());

		assert widget instanceof FreeTextTokenBoxWidget : "Assertion failed: widget instanceof FreeTextLineWidget";

		return (FreeTextTokenBoxWidget) widget;
	}

	public CursorPosition getCursorPositionInLineAt(LineIndex lineIndexObject, int left) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";
		assert left >= 0 : "Precondition failed: left >= 0";

		int boxIndex = getIdBoxWidgetIndexAt(lineIndexObject, left);

		CursorPosition result;

		// if no cursor position is found, return most left cursor position in
		// line
		if (boxIndex == -1) {
			result = new CursorPosition(getTokenBoxWidget(new BoxIndex(lineIndexObject, 0)).getId(), 0);
		} else {
			AbstractTokenBoxWidget tokenBoxWidget = getTokenBoxWidget(new BoxIndex(lineIndexObject, boxIndex));
			Id tokenId = tokenBoxWidget.getId();
			if (tokenBoxWidget instanceof TextContainer) {
				TextContainer textContainer = (TextContainer) tokenBoxWidget;
				int cursorPositionInToken = textContainer
						.getCursorPositionAt(left + getAbsoluteLeft() - tokenBoxWidget.getAbsoluteLeft());
				result = new CursorPosition(tokenId, cursorPositionInToken);
			} else {
				result = new CursorPosition(tokenId, 0);
			}
		}

		assert result != null : "Postcondition failed: result != null";

		return result;
	}

	public void insertTokenBoxWidget(TokenBox tokenBox, BoxIndex boxIndexObject) {
		assert tokenBox != null : "Precondition failed: tokenBox != null";
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		AbstractTokenBoxWidget widget = getTokenBoxWidgetFactory().create(tokenBox);

		assert widget != null : "Postcondition failed widget!=null";
		insertWidget(widget, boxIndexObject);
	}

	protected TokenBoxWidgetFactory getTokenBoxWidgetFactory() {
		if (tokenBoxWidgetFactory == null) {
			tokenBoxWidgetFactory = new TokenBoxWidgetFactory(false, urlConverter, eventTranslator, fontSizeService,
					visibilityToolTip, documentUiListener, documentPanelListener);
		}
		assert tokenBoxWidgetFactory != null : "Precondition failed: tokenBoxWidgetFactory != null";

		return tokenBoxWidgetFactory;
	}

	public void insertWidget(AbstractTokenBoxWidget widget, BoxIndex boxIndexObject) {
		assert widget != null : "Precondition failed: widget != null";
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		OrientedFlowPanel line = (OrientedFlowPanel) getLine(boxIndexObject.getLineIndexObject());

		if (!boxIndexObject.isCollageBoxIndex() && !widget.getTokenBox().isLockedLayout()) {
			line.addStyleName("tokenBoxUnderline");
			line.addStyleName(underLineStyleName);
		} else {
			line.addStyleName("tokenBoxMargin");
			line.addStyleName(underLineStyleName);
		}

		line.insert(widget, boxIndexObject.getBoxIndex());
	}

	public void removeTokenBoxWidget(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		getLine(boxIndexObject.getLineIndexObject()).remove(boxIndexObject.getBoxIndex());
	}

	public void movePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength) {
		assert fromLineIndexObject.getPageIndex() >= 0 : "Precondition failed: fromLineIndexObject.getPageIndex() >= 0";
		assert fromLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: fromLineIndexObject.getPageIndex() < getPageCount()";
		assert fromLineIndexObject.getLineIndex() >= 0 : "Precondition failed: fromLineIndexObject.getLineIndex() >= 0";
		assert fromLineIndexObject.getLineIndex() <= getLineCount(
				fromLineIndexObject) : "Precondition failed: fromLineIndexObject.getLineIndex() <= getLineCount(fromLineIndexObject))";

		assert toLineIndexObject.getPageIndex() >= 0 : "Precondition failed: toLineIndexObject.getPageIndex() >= 0";
		assert toLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: toLineIndexObject.getPageIndex() < getPageCount()";
		assert toLineIndexObject.getLineIndex() >= 0 : "Precondition failed: toLineIndexObject.getLineIndex() >= 0";
		assert toLineIndexObject.getLineIndex() <= getLineCount(
				toLineIndexObject) : "Precondition failed: toLineIndexObject.getLineIndex() <= getLineCount(toLineIndexObject))";
		assert segmentLength >= 0 : "Precondition failed: segmentLength >= 0";

		FlowPanel fromLineContainer = getLineParent(fromLineIndexObject);
		FlowPanel toLineContainer = getLineParent(toLineIndexObject);

		for (int i = 0; i < segmentLength; i++) {
			Widget line = fromLineContainer.getWidget(fromLineIndexObject.getLineIndex());
			toLineContainer.insert(line, toLineIndexObject.getLineIndex() + i);
		}
	}

	public void moveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength) {
		assert fromBoxIndexObject.getPageIndex() >= 0 : "Precondition failed: fromBoxIndexObject.getPageIndex() >= 0";
		assert fromBoxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: fromBoxIndexObject.getPageIndex() < getPageCount()";
		assert fromBoxIndexObject.getLineIndex() >= 0 : "Precondition failed: fromBoxIndexObject.getLineIndex() >= 0";
		assert fromBoxIndexObject.getLineIndex() < getLineCount(fromBoxIndexObject
				.getLineIndexObject()) : "Precondition failed: fromBoxIndexObject.getLineIndex() < getLineCount(fromBoxIndexObject.getLineIndexObject())";
		assert fromBoxIndexObject.getBoxIndex() >= 0 : "Precondition failed: fromBoxIndexObject.getBoxIndex() >= 0";
		assert fromBoxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(fromBoxIndexObject
				.getLineIndexObject()) : "Precondition failed: fromBoxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(fromBoxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";
		assert toBoxIndexObject.getPageIndex() >= 0 : "Precondition failed: toBoxIndexObject.getPageIndex() >= 0";
		assert toBoxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: toBoxIndexObject.getPageIndex() < getPageCount()";
		assert toBoxIndexObject.getLineIndex() >= 0 : "Precondition failed: toBoxIndexObject.getLineIndex() >= 0";
		assert toBoxIndexObject.getLineIndex() < getLineCount(toBoxIndexObject
				.getLineIndexObject()) : "Precondition failed: toBoxIndexObject.getLineIndex() < getLineCount(toBoxIndexObject.getLineIndexObject())";
		assert toBoxIndexObject.getBoxIndex() >= 0 : "Precondition failed: toBoxIndexObject.getBoxIndex() >= 0";
		assert toBoxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(toBoxIndexObject
				.getLineIndexObject()) : "Precondition failed: toBoxIndexObject.getBoxIndex() <= getIdBoxWidgetCount(toBoxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		assert segmentLength >= 0 : "Precondition failed: segmentLength >= 0";

		FlowPanel fromLine = getLine(fromBoxIndexObject.getLineIndexObject());

		for (int i = 0; i < segmentLength; i++) {
			AbstractTokenBoxWidget widget = (AbstractTokenBoxWidget) fromLine
					.getWidget(fromBoxIndexObject.getBoxIndex());
			insertWidget(widget,
					new BoxIndex(toBoxIndexObject.getLineIndexObject(), toBoxIndexObject.getBoxIndex() + i));
		}
	}

	public void moveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject) {
		assert fromLineIndexObject.getPageIndex() >= 0 : "Precondition failed: fromLineIndexObject.getPageIndex() >= 0";
		assert fromLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: fromLineIndexObject.getPageIndex() < getPageCount()";
		assert fromLineIndexObject.getLineIndex() >= 0 : "Precondition failed: fromLineIndexObject.getLineIndex() >= 0";
		assert fromLineIndexObject.getLineIndex() < getLineCount(
				fromLineIndexObject) : "Precondition failed: fromLineIndexObject.getLineIndex() < getLineCount(fromLineIndexObject))";

		assert toLineIndexObject.getPageIndex() >= 0 : "Precondition failed: toLineIndexObject.getPageIndex() >= 0";
		assert toLineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: toLineIndexObject.getPageIndex() < getPageCount()";
		assert toLineIndexObject.getLineIndex() >= 0 : "Precondition failed: toLineIndexObject.getLineIndex() >= 0";
		assert toLineIndexObject.getLineIndex() < getLineCount(toLineIndexObject
				.getPageIndex()) : "Precondition failed: toLineIndexObject.getLineIndex() < getLineCount(toLineIndexObject.getPageIndex()))";

		FlowPanel fromLineContainer = getLineParent(fromLineIndexObject);
		FlowPanel toLineContainer = getLineParent(toLineIndexObject);
		FlowPanel moveLine = (FlowPanel) fromLineContainer.getWidget(fromLineIndexObject.getLineIndex());

		// FIXME muss moveLine nicht auch aus fromLineContainer entfernt werden?
		toLineContainer.insert(moveLine, toLineIndexObject.getLineIndex());

		assert getLine(toLineIndexObject) == moveLine : "Postcondition failed: getLine(toLineIndexObject) == moveLine";
	}

	public void setCursorPositionAndFocus(BoxIndex boxIndexObject, int cursorIndex) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";
		assert cursorIndex >= -1 : "Precondition failed: cursorIndex >= -1";
		assert getTokenBoxWidget(
				boxIndexObject) instanceof AbstractTextbasedTokenBoxWidget : "Precondition failed: getTokenBoxWidget(boxIndexObject) instanceof AbstractTextbasedTokenBoxWidget";
		assert cursorIndex <= ((AbstractTextbasedTokenBoxWidget) getTokenBoxWidget(boxIndexObject)).getText()
				.length() : "Precondition failed: cursorIndex <= getTokenBox(boxIndexObject).getText().length()";

		((AbstractTextbasedTokenBoxWidget) getTokenBoxWidget(boxIndexObject)).setCursorPositionAndFocus(cursorIndex);
	}

	public void focusIdBoxWidget(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		AbstractTokenBoxWidget widget = getTokenBoxWidget(boxIndexObject);
		widget.focus();
	}

	public void centerWidget(BoxIndex boxIndexObject) {
		final AbstractTokenBoxWidget widget = getTokenBoxWidget(boxIndexObject);

		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				ScrollPanel bigScrollPanel = (ScrollPanel) simplePanel.getParent().getParent();
				bigScrollPanel.ensureVisible(widget);
				if (bigScrollPanel.getVerticalScrollPosition() > 0) {
					int newVerticalScrollPosition = bigScrollPanel.getVerticalScrollPosition()
							+ widget.getOffsetHeight() / 2;
					bigScrollPanel.setVerticalScrollPosition(newVerticalScrollPosition);
				}
			}
		});
	}

	public int getCursorLeft(BoxIndex boxIndexObject) {
		AbstractTokenBoxWidget tokenBoxWidget = getTokenBoxWidget(boxIndexObject);
		return tokenBoxWidget.getCursorLeft() + ((Widget) tokenBoxWidget).getElement().getAbsoluteLeft()
				- getAbsoluteLeft();
	}

	public int getCursorPosition(BoxIndex boxIndexObject) {
		TextContainer tokenBoxWidget = (TextContainer) getTokenBoxWidget(boxIndexObject);
		return tokenBoxWidget.getCursorPosition();
	}

	public boolean isLastIndex(BoxIndex boxIndexObject) {

		if (boxIndexObject.isCollageBoxIndex()) {

			SelectedFlowPanel snippet = (SelectedFlowPanel) getLine(boxIndexObject.getLineIndexObject());

			return boxIndexObject.getPageIndex() == getPageCount() - 1
					&& boxIndexObject.getSnippetIndex() == getSnippetCount(boxIndexObject.getPageIndex()) - 1
					&& boxIndexObject.getLineIndex() == snippet.getWidgetCount() - 1
					&& boxIndexObject.getBoxIndex() == getIdBoxWidgetCount(boxIndexObject.getLineIndexObject()) - 1;
		} else {
			return boxIndexObject.getPageIndex() == getPageCount() - 1
					&& boxIndexObject.getLineIndex() == getLineCount(boxIndexObject.getPageIndex()) - 1
					&& boxIndexObject.getBoxIndex() == getIdBoxWidgetCount(boxIndexObject.getLineIndexObject()) - 1;
		}

	}

	public boolean isFirstIndex(BoxIndex boxIndexObject) {
		return boxIndexObject.getPageIndex() == 0 && boxIndexObject.getLineIndex() == 0
				&& boxIndexObject.getBoxIndex() == 0;
	}

	public void toggleTokenBoxWidgetSelection(BoxIndex boxIndexObject) {
		assert boxIndexObject.getPageIndex() >= 0 : "Precondition failed: boxIndexObject.getPageIndex() >= 0";
		assert boxIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: boxIndexObject.getPageIndex() < getPageCount()";
		assert boxIndexObject.getLineIndex() >= 0 : "Precondition failed: boxIndexObject.getLineIndex() >= 0";
		assert boxIndexObject.getLineIndex() < getLineCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getLineIndex() < getLineCount(boxIndexObject.getLineIndexObject())";
		assert boxIndexObject.getBoxIndex() >= 0 : "Precondition failed: boxIndexObject.getBoxIndex() >= 0";
		assert boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject
				.getLineIndexObject()) : "Precondition failed: boxIndexObject.getBoxIndex() < getIdBoxWidgetCount(boxIndexObject.getPageIndex(), boxIndexObject.getLineIndex())";

		getTokenBoxWidget(boxIndexObject).toggleSelection();
	}

	public boolean isFrameSelected(BoxIndex boxIndexObject) {
		boolean result = false;
		if (getTokenBoxWidget(boxIndexObject) instanceof FrameTokenBoxWidget) {
			result = ((FrameTokenBoxWidget) getTokenBoxWidget(boxIndexObject)).isSelected();
		}
		return result;
	}

	public void setInDragMode(boolean isInDragMode) {
		this.isInDragMode = isInDragMode;
	}

	public boolean isInDragMode() {
		return isInDragMode;
	}

	public void setFooterText(String newText) {
		assert newText != null : "Precondition failed: newText != null";

		this.footerText = newText;
		updateFooterText();
	}

	public void setUnderlineVisibility(boolean visible) {
		underLineStyleName = visible ? "underlined" : "notUnderlined";
		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount; pageIndex++) {
			if (!isCollage(pageIndex)) {
				for (int lineIndex = 0, lineCount = getLineCount(pageIndex); lineIndex < lineCount; lineIndex++) {
					LineIndex lineIndexObject = new LineIndex(pageIndex, lineIndex);

					if (!visible) {
						getLine(lineIndexObject).removeStyleName("underlined");
						getLine(lineIndexObject).addStyleName("notUnderlined");
					} else {
						getLine(lineIndexObject).removeStyleName("notUnderlined");
						getLine(lineIndexObject).addStyleName("underlined");
					}
				}
			}
		}
	}

	public boolean isCollage(int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		return getPage(pageIndex).getParent() instanceof CollagePanel;
	}

	public String getFooterText() {
		return footerText;
	}

	public void scrollToPage(final int pageIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";

		Widget currentBox = getPage(pageIndex);
		ScrollPanel bigScrollPanel = (ScrollPanel) simplePanel.getParent().getParent();
		bigScrollPanel.setVerticalScrollPosition(
				bigScrollPanel.getVerticalScrollPosition() + currentBox.getAbsoluteTop() - SCROLL_PAGE_MARGIN_TOP);
	}

	private void updateFooterText() {
		for (Widget widget : pagesPanel) {
			AbsolutePanel outerPagePanel = (AbsolutePanel) widget;
			// Assume that second widget is the label containing the footer
			// text:
			Label footerTextLabel = (Label) outerPagePanel.getWidget(FOOTER_TEXT_LABEL_INDEX);
			footerTextLabel.setText(footerText);
		}
	}

	private void updateFooterPageNumbers() {
		for (int pageIndex = 0, pageCount = getPageCount(); pageIndex < pageCount; pageIndex++) {
			AbsolutePanel outerPagePanel = (AbsolutePanel) pagesPanel.getWidget(pageIndex);
			// Assume that third widget is the label containing the page
			// numbers:
			if (outerPagePanel instanceof PagePanel) {
				((PagePanel) outerPagePanel).updateFooterPageNumbers(pageIndex, pageCount);
			} else {
				Label footerPageNumberLabel = (Label) outerPagePanel.getWidget(FOOTER_PAGE_NUMBER_LABEL_INDEX);
				footerPageNumberLabel.setText((pageIndex + 1) + "/" + pageCount);
			}
		}
	}

	private void handleBrowserEvent(Event event) {
		assert event != null : "Precondition failed: event != null";

		switch (event.getTypeInt()) {
		case Event.ONMOUSEDOWN:
			boolean deactivate = event.getCtrlKey() || event.getShiftKey();
			documentUiListener.onDeselection(deactivate);
			checkPreventDefault(event);
			event.stopPropagation();
			break;

		case Event.ONMOUSEUP:
			setInDragMode(false);
			checkPreventDefault(event);
			break;

		case Event.ONMOUSEMOVE:
			if (isInDragMode()) {
				handleMouseDragged(event);
			}
			checkPreventDefault(event);
			break;
		}

		int keyCode = event.getKeyCode();
		if (keyCode == (int) 'S') {
			if (event.getCtrlKey() || event.getMetaKey()) {
				quickSaveListener.onDocumentQuickSave();
				checkPreventDefault(event);
			}
		}
		if (keyCode == (int) 'E') {
			if (event.getCtrlKey() || event.getMetaKey()) {
				documentUiListener.onToggleUnderlineVisibility();
				checkPreventDefault(event);
			}
		}
	}

	/**
	 * Document panel prevents passing native browser events to children. Thereby default browser functionality such as
	 * the context menu on right click are disabled. By setting the id (ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR) an
	 * element can be identified that does not rely on the prevent default action. Many widgets add the functionality
	 * (such as the context menu) again after disabled by preventDefault call in the document panel. In future, all
	 * widgets should receive all native browser event.
	 */
	private void checkPreventDefault(Event event) {
		Element element = event.getEventTarget().cast();
		if (!ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR.equals(element.getId())) {
			event.preventDefault();
		}
	}

	private void handleMouseDragged(Event event) {
		assert event != null : "Precondition failed: event != null";
		int clientX = event.getClientX();
		int clientY = event.getClientY();

		if (clientX >= 0 && clientY >= 0) {
			LineIndex lineIndexAtMousePos = getLineIndexAtMousePos(clientX, clientY);
			if (lineIndexAtMousePos != null) {

				AbstractTokenBoxWidget tokenBoxWidget = null;
				boolean selectBoxCompletely = true;

				int boxIndex = -2; // -1 bedeutet, man befindet sich zwischen
									// Zeilen
				if (isCollage(lineIndexAtMousePos.getPageIndex())) {
					boxIndex = getIdBoxWidgetIndexAt(lineIndexAtMousePos, clientX - getAbsoluteLeft(),
							clientY - getAbsoluteTop());
				} else {
					boxIndex = getIdBoxWidgetIndexAt(lineIndexAtMousePos, clientX - getAbsoluteLeft());
				}
				assert boxIndex >= -1 : "Postcondition failed: boxIndex >= 0";

				int cursorBoxIndex = boxIndex == -1 ? 0 : boxIndex;

				tokenBoxWidget = getTokenBoxWidget(new BoxIndex(lineIndexAtMousePos, cursorBoxIndex));
				if (tokenBoxWidget instanceof AbstractTextbasedTokenBoxWidget) {
					AbstractTextbasedTokenBoxWidget textBasedTokenBoxWidget = (AbstractTextbasedTokenBoxWidget) tokenBoxWidget;
					selectBoxCompletely = textBasedTokenBoxWidget.isWholeTextSelected();
				}
				documentUiListener.onSelectToken(tokenBoxWidget.getId(), true, selectBoxCompletely);
			}
		}
	}

	private int getIdBoxWidgetIndexAt(LineIndex lineIndexObject, int x, int y) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";
		assert x >= 0 : "Precondition failed: x >= 0";
		assert y >= 0 : "Precondition failed: y >= 0";

		FlowPanel line = getLine(lineIndexObject);
		int absoluteLeft = x + getAbsoluteLeft();
		int absoluteTop = y + getAbsoluteTop();

		int idBoxWidgetIndex = -1;
		int widgetCount = line.getWidgetCount();

		for (int i = 0; i < widgetCount; i++) {
			Widget widget = line.getWidget(i);

			boolean isWidgetUnderCursor = isWidgetLeftOfCursor(widget, absoluteLeft)
					&& isCursorLeftOfRightBorderOfWidget(widget, absoluteLeft)
					&& isCursorBetweenUpperAndLowerWidgetBorder(widget, absoluteTop);
			if (isWidgetUnderCursor) {
				idBoxWidgetIndex = i;
				break;
			}
		}

		if (idBoxWidgetIndex == -1 && isWidgetLeftOfCursor(line.getWidget(widgetCount - 1), absoluteLeft)) {
			idBoxWidgetIndex = widgetCount - 1;
		}

		assert idBoxWidgetIndex >= -1 : "Postcondition failed: result >= -1";
		return idBoxWidgetIndex;
	}

	private boolean isCursorBetweenUpperAndLowerWidgetBorder(Widget widget, int absoluteTop) {
		boolean isWidgetAboveOfCursor = absoluteTop >= widget.getAbsoluteTop();
		boolean isWidgetBelowOfCursor = absoluteTop <= widget.getAbsoluteTop() + widget.getOffsetHeight()
				+ PageFormat.SNIPPET_LINE_DISTANCE;
		return isWidgetAboveOfCursor && isWidgetBelowOfCursor;
	}

	private FlowPanel getLine(LineIndex lineIndexObject) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";

		FlowPanel result;

		result = (FlowPanel) getLineParent(lineIndexObject).getWidget(lineIndexObject.getLineIndex());

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public SelectedFlowPanel getSnippet(int pageIndex, int snippetIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";

		SelectedFlowPanel result = (SelectedFlowPanel) getPage(pageIndex).getWidget(snippetIndex);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public boolean isEmptyLine(LineIndex lineIndexObject) {
		assert getLine(lineIndexObject) != null;
		return getLine(lineIndexObject).getWidgetCount() == 0;
	}

	private LineIndex getLineIndexAtMousePos(int left, int top) {
		LineIndex result = null;

		int pageIndex = getPageIndexAtMousePos(top);

		LineIndex lineParentIndex = null;
		if (!isCollage(pageIndex)) {
			lineParentIndex = new LineIndex(pageIndex, 0);
		} else {
			lineParentIndex = getSnippetIndexAtMousePosition(pageIndex, left, top);
		}

		if (lineParentIndex != null) {
			LineIndex lineIndex = null;

			for (int i = 0, n = getLineCount(lineParentIndex); result == null && i < n; i++) {
				lineIndex = new LineIndex( //
						lineParentIndex.getPageIndex(), //
						lineParentIndex.getSnippetIndex(), //
						i);

				// is mouse pos above lower boundary of line?
				Widget line = getLine(lineIndex);
				if (top < line.getAbsoluteTop() + line.getOffsetHeight()) {
					result = lineIndex;
				}
			}

			if (result == null) {
				result = lineIndex; // last line as default
			}
		}

		return result;
	}

	private LineIndex getSnippetIndexAtMousePosition(int pageIndex, int left, int top) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert isCollage(pageIndex) : "Precondition failed: isCollage(pageIndex)";

		LineIndex result = null;

		int zIndex = Integer.MIN_VALUE;
		for (int snippetIndex = 0; snippetIndex < getSnippetCount(pageIndex); snippetIndex++) {
			SelectedFlowPanel snippet = getSnippet(pageIndex, snippetIndex);

			if (snippet.getZIndex() >= zIndex //
					&& left >= snippet.getAbsoluteLeft() //
					&& left < snippet.getAbsoluteLeft() + snippet.getOffsetWidth() //
					&& top >= snippet.getAbsoluteTop() //
					&& top < snippet.getAbsoluteTop() + snippet.getOffsetHeight()) {
				zIndex = snippet.getZIndex();

				result = new LineIndex(pageIndex, snippetIndex, 0);
			}
		}

		return result;
	}

	private int getPageIndexAtMousePos(int top) {
		int result = 0;

		while (result < getPageCount() - 1 //
				&& top >= getPage(result).getAbsoluteTop() + getPage(result).getOffsetHeight()) {
			result++;
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		assert result < getPageCount() : "Postcondition failed: result < getPageCount()";
		return result;
	}

	private int getIdBoxWidgetIndexAt(LineIndex lineIndexObject, int left) {
		assert lineIndexObject.getPageIndex() >= 0 : "Precondition failed: lineIndexObject.getPageIndex() >= 0";
		assert lineIndexObject
				.getPageIndex() < getPageCount() : "Precondition failed: lineIndexObject.getPageIndex() < getPageCount()";
		assert lineIndexObject.getLineIndex() >= 0 : "Precondition failed: lineIndexObject.getLineIndex() >= 0";
		assert lineIndexObject.getLineIndex() < getLineCount(
				lineIndexObject) : "Precondition failed: lineIndexObject.getLineIndex() < getLineCount(lineIndexObject))";
		assert left >= 0 : "Precondition failed: left >= 0";

		FlowPanel line = getLine(lineIndexObject);
		int absoluteLeft = left + getAbsoluteLeft();

		int idBoxWidgetIndex = -1;
		int widgetCount = line.getWidgetCount();

		for (int i = 0; i < widgetCount; i++) {
			Widget widget = line.getWidget(i);

			boolean isWidgetUnderCursor = isWidgetLeftOfCursor(widget, absoluteLeft)
					&& isCursorLeftOfRightBorderOfWidget(widget, absoluteLeft);
			if (isWidgetUnderCursor) {
				idBoxWidgetIndex = i;
				break;
			}
		}

		if (idBoxWidgetIndex == -1 && isWidgetLeftOfCursor(line.getWidget(widgetCount - 1), absoluteLeft)) {
			idBoxWidgetIndex = widgetCount - 1;
		}

		assert idBoxWidgetIndex >= -1 : "Postcondition failed: result >= -1";
		return idBoxWidgetIndex;
	}

	private boolean isCursorLeftOfRightBorderOfWidget(Widget widget, int absoluteLeft) {
		return widget.getAbsoluteLeft() + widget.getOffsetWidth() > absoluteLeft;
	}

	private boolean isWidgetLeftOfCursor(Widget widget, int cursorLeft) {
		return cursorLeft - widget.getAbsoluteLeft() >= 0;
	}

	private void activateDragMode(MouseDownEvent event) {
		setInDragMode(true);
		event.stopPropagation();
	}

	protected DocumentUiListener getDocumentUiListener() {
		return documentUiListener;
	}

	public void changeBackgroundColor(BoxIndex boxIndexObject, Color color) {

		this.getTokenBoxWidget(boxIndexObject).setBackgroundColor(color);
	}

	public void changeTextBackgroundColor(BoxIndex boxIndexObject, Color color) {
		AbstractTokenBoxWidget widget = this.getTokenBoxWidget(boxIndexObject);
		assert widget instanceof AbstractTextbasedTokenBoxWidget : "Precondition failed: widget instanceof AbstractTokenBoxWidget";

		((AbstractTextbasedTokenBoxWidget) widget).setTextBoxBackgroundColor(color);
	}

	public void insertNewSnippet(Id id, int pageIndex, int pageWidth, int pageHeight, int x, int y, int width,
			int zIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex <= getPageCount() : "Precondition failed: pageIndex <= getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";

		FlowPanel pagePanel = getPage(pageIndex);

		SelectedFlowPanel newSnippet = new SelectedFlowPanel(id, x, y, width, pageWidth, pageHeight, zIndex,
				documentUiListener, getEventTranslator(), fontSizeService);
		pagePanel.add(newSnippet);
		newSnippet.snapToGrid();
	}

	public void setDrawSnippetMode(boolean enabled) {
		for (int i = 0; i < pagesPanel.getWidgetCount(); i++) {
			Widget widget = pagesPanel.getWidget(i);
			if (widget instanceof CollagePanel) {
				((CollagePanel) widget).setInDrawParagraphMode(enabled);
			}
		}
	}

	@Override
	public void setDeleteCollageMode(boolean enabled) {
		for (int i = 0; i < pagesPanel.getWidgetCount(); i++) {
			Widget widget = pagesPanel.getWidget(i);
			if (widget instanceof CollagePanel) {
				((CollagePanel) widget).setInDeleteMode(enabled);
			}
		}
	}

	public void setSnippetAutomaticResizeActive(int pageIndex, int snippetIndex, boolean active) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).setAutomaticResizeActive(active);
	}

	public void setSnippetPosition(int pageIndex, int snippetIndex, int x, int y) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).updatePosition(x, y, false);
	}

	public void setSnippetSelection(int pageIndex, int snippetIndex, boolean selection) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).setSelection(selection);
	}

	public void setSnippetAutomaticResize(int pageIndex, int snippetIndex, boolean automaticResize) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).setAutomaticResizeActive(automaticResize);
	}

	@Override
	public void setSnippetZIndex(int pageIndex, int snippetIndex, int zIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).setZIndex(zIndex);
	}

	public void reloadVideoToken(BoxIndex index) {
		VideoTokenBoxWidget videoTokenBoxWidget = getVideoTokenForBoxIndex(index);
		videoTokenBoxWidget.reload();
	}

	public void loadVideoNotFoundInVideoToken(BoxIndex index) {
		VideoTokenBoxWidget videoTokenBoxWidget = getVideoTokenForBoxIndex(index);
		videoTokenBoxWidget.noVideoFound();
	}

	public void setVideoToConvertingTillLoaded(BoxIndex index) {
		VideoTokenBoxWidget videoTokenBoxWidget = getVideoTokenForBoxIndex(index);
		videoTokenBoxWidget.setVideoPosterToConvertingAndRetry();
	}

	private VideoTokenBoxWidget getVideoTokenForBoxIndex(BoxIndex boxIndexObject) {
		assert boxIndexObject != null : "Precondition failed: index != null";
		assert getTokenBoxWidget(
				boxIndexObject) instanceof VideoTokenBoxWidget : "Precondition failed: getTokenBoxWidget(boxIndexObject) instanceof VideoTokenBoxWidget";
		VideoTokenBoxWidget videoTokenBoxWidget = (VideoTokenBoxWidget) getTokenBoxWidget(boxIndexObject);
		return videoTokenBoxWidget;
	}

	@Override
	public void setBox(Box box, BoxIndex boxIndexObject) {
		assert getTokenBoxWidget(
				boxIndexObject) != null : "Precondition failed: getTokenBoxWidget(boxIndexObject)!= null";

		AbstractTokenBoxWidget tokenBoxWidget = getTokenBoxWidget(boxIndexObject);
		tokenBoxWidget.setTokenBox((TokenBox) box);
	}

	public void updateLineHeight(LineIndex lineIndexObject, int height) {
		getLine(lineIndexObject).setHeight(height + "px");
	}

	public EventTranslatorStandardImpl getEventTranslator() {
		return eventTranslator;
	}

	@Override
	public void setUrlConverter(URLConverter urlConverter) {
		this.urlConverter = urlConverter;
	}

	@Override
	public void changeCollageGridVisibility(int pageIndex, boolean visible) {
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		CollagePanel collagePanel = (CollagePanel) getPage(pageIndex).getParent();
		collagePanel.showCollageGrid(visible);
	}

	@Override
	public void updateSnippetHeight(int pageIndex, int snippetIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		getSnippet(pageIndex, snippetIndex).updateSnippetSelection();
	}

	@Override
	public void removeSnippet(int pageIndex, int snippetIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert pageIndex < getPageCount() : "Precondition failed: pageIndex < getPageCount()";
		assert getPage(pageIndex)
				.getParent() instanceof CollagePanel : "Precondition failed: getPage(pageIndex) instanceof CollagePanel";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert snippetIndex < getPage(pageIndex)
				.getWidgetCount() : "Precondition failed: snippetIndex < getPage(pageIndex).getWidgetCount()";

		if (getPage(pageIndex).getWidget(snippetIndex) instanceof SelectedFlowPanel) {
			setSnippetSelection(pageIndex, snippetIndex, false);
		}

		// delete paragraph selection border
		getPage(pageIndex).remove(snippetIndex);
	}
}