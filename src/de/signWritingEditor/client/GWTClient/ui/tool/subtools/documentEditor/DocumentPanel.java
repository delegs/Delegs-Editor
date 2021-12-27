package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel.SelectableSnippetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget.ResizableTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.CollagePanel.CollageListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FormTokenBoxWidget.FormTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FrameTokenBoxWidget.FrameTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget.FreeTextTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget.ImageTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.LayoutedSearchWordBox.SearchWordBoxListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.SignSelectorPanel.SignSelectorPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.TagTokenBoxWidget.TagTokenBoxWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.VideoTokenBoxWidget.VideoListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.TokenBox;

public interface DocumentPanel {
	String ELEMENT_WITH_DEFAULT_BROWSER_BEHAVIOUR = "defaultBrowserEventBehaviour";

	interface DocumentUiListener extends ResizableTokenBoxWidgetListener, SearchWordBoxListener,
			SignSelectorPanelListener, FreeTextTokenBoxWidgetListener, FrameTokenBoxWidgetListener, VideoListener,
			ImageTokenBoxWidgetListener, SelectableSnippetListener, VisibilityListener, CopyPasteListener,
			CollageListener, FormTokenBoxWidgetListener, TagTokenBoxWidgetListener {
	}

	interface DocumentPanelListener extends DragModeListener {

	}

	interface CopyToClipboardCompletionListener {
		void onCopyToClipboardCompleted();
	}

	interface QuickSaveListener {
		void onDocumentQuickSave();
	}

	interface VisibilityListener {
		void onSearchWordVisibilityChanged(Id tokenId, boolean visible);

		void onFreeTextVisibilityChanged(Id tokenId, boolean visible);

		void onToggleUnderlineVisibility();

		void onSignVisibilityChanged(Id tokenId, boolean visible);

		void onVideoURLVisibilityChanged(Id tokenId, boolean visible);
	}

	interface VisibilityToolTipListener {
		void onVisibilityChanged(Id id, boolean visible);
	}

	interface DragModeListener {
		void onActivateDragMode(MouseDownEvent event);

		void onMouseDragged(Event event);

		void setInDragMode(boolean dragMode);
	}

	void init();

	void setSaveListener(QuickSaveListener quickSaveListener);

	void setFontSizeService(FontSizeService fontSizeService);

	void setDocumentUiListener(DocumentUiListener createDocumentUiListener);

	void insertNewPage(int pageIndex, PageFormat pageFormat);

	void insertNewCollage(int pageIndex, PageFormat pageFormat, Id collageId, boolean showGrid);

	void changeCollageGridVisibility(int pageIndex, boolean visible);

	void setDrawSnippetMode(boolean enabled);

	void setDeleteCollageMode(boolean enabled);

	CursorPosition getCursorPositionInLineAt(LineIndex lineIndexObject, int left);

	void removeLine(LineIndex lineIndexObject);

	void removeTokenBoxWidget(BoxIndex boxIndexObject);

	void insertTokenBoxWidget(TokenBox box, BoxIndex boxIndexObject);

	AbstractTokenBoxWidget getTokenBoxWidget(BoxIndex boxIndexObject);

	FreeTextTokenBoxWidget getFreeTextLineWidget(BoxIndex boxIndexObject);

	void setSnippetPosition(int pageIndex, int snippetIndex, int x, int y);

	void setSnippetSelection(int pageIndex, int snippetIndex, boolean selection);

	void setSnippetAutomaticResize(int pageNo, int lineNo, boolean automaticResize);

	void setSnippetAutomaticResizeActive(int pageIndex, int snippetIndex, boolean b);

	void insertNewSnippet(Id id, int pageNo, int pageWidth, int pageHeight, int x, int y, int width, int zIndex);

	void removePage(int pageIndex);

	void insertNewLine(LineIndex lineIndexObject, Orientation pageOrientation);

	void focusIdBoxWidget(BoxIndex boxIndexObject);

	void centerWidget(BoxIndex boxIndexObject);

	void setCursorPositionAndFocus(BoxIndex boxIndexObject, int cursorPosition);

	void setUnderlineVisibility(boolean visible);

	boolean isFrameSelected(BoxIndex boxIndexObject);

	void toggleTokenBoxWidgetSelection(BoxIndex boxIndexObject);

	void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler);

	void changeTextBackgroundColor(BoxIndex boxIndexObject, Color color);

	void changeBackgroundColor(BoxIndex boxIndexObject, Color color);

	void moveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject);

	void moveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength);

	void movePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength);

	int getPageCount();

	FlowPanel getPage(int pageIndex);

	String getFooterText();

	void onBrowserEvent(Event event);

	void scrollToPage(int pageIndex);

	void setFooterText(String newText);

	int getCursorLeft(BoxIndex boxIndexObject);

	int getCursorPosition(BoxIndex boxIndexObject);

	int getLineCount(int pageIndex);

	int getLineCount(LineIndex lineIndex);

	void unsinkEvents(int eventBitsToRemove);

	void setTitle(String title);

	void setStyleName(String style, boolean add);

	HandlerRegistration addAttachHandler(Handler handler);

	void addStyleDependentName(String styleSuffix);

	void claimElement(com.google.gwt.dom.client.Element element);

	Widget asWidget();

	void fireEvent(GwtEvent<?> event);

	void removeStyleDependentName(String styleSuffix);

	void setStyleName(String style);

	void setVisible(boolean visible);

	int getAbsoluteTop();

	int getAbsoluteLeft();

	int getOffsetHeight();

	int getOffsetWidth();

	String getStyleName();

	Widget getParent();

	int getIdBoxWidgetCount(LineIndex lineIndexObject);

	Object getLayoutData();

	void addStyleName(String style);

	void setSnippetZIndex(int pageIndex, int snippetIndex, int zIndex);

	void reloadVideoToken(BoxIndex index);

	void loadVideoNotFoundInVideoToken(BoxIndex index);

	void setVideoToConvertingTillLoaded(BoxIndex index);

	void setBox(Box box, BoxIndex boxIndexObject);

	void updateLineHeight(LineIndex lineIndexObject, int height);

	void setUrlConverter(URLConverter urlConverter);

	void updateSnippetHeight(int pageIndex, int snippetIndex);

	void removeSnippet(int pageIndex, int snippetIndex);

	int getSnippetCount(int pageIndex);

	SelectedFlowPanel getSnippet(int pageIndex, int snippetIndex);

	boolean isCollage(int pageIndex);
}
