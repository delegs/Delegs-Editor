package de.signWritingEditor.infrastructure;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget;
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

public class DocumentPanelMock implements DocumentPanel {

	public DocumentPanelMock() {
	}

	@Override
	public void init() {
	}

	@Override
	public void setDocumentUiListener(DocumentUiListener documentUiListener) {
	}

	@Override
	public void setSaveListener(QuickSaveListener quickSaveListener) {
	}

	@Override
	public void onBrowserEvent(Event event) {
	}

	@Override
	public void copyToSystemClipboard(String text, CopyToClipboardCompletionListener completionHandler) {
	}

	@Override
	public int getPageCount() {
		return 0;
	}

	@Override
	public FlowPanel getPage(int pageIndex) {
		return null;
	}

	@Override
	public void insertNewPage(int pageIndex, PageFormat pageFormat) {
	}

	@Override
	public void removePage(int pageIndex) {
	}

	@Override
	public int getLineCount(int pageIndex) {
		return 0;
	}

	@Override
	public void insertNewLine(LineIndex lineIndexObject, Orientation pageOrientation) {
	}

	@Override
	public void removeLine(LineIndex lineIndexObject) {
	}

	@Override
	public int getIdBoxWidgetCount(LineIndex lineIndexObject) {
		return 0;
	}

	@Override
	public AbstractTokenBoxWidget getTokenBoxWidget(BoxIndex boxIndexObject) {
		return null;
	}

	@Override
	public FreeTextTokenBoxWidget getFreeTextLineWidget(BoxIndex boxIndexObject) {
		return null;
	}

	@Override
	public CursorPosition getCursorPositionInLineAt(LineIndex lineIndexObject, int left) {
		return null;
	}

	@Override
	public void insertTokenBoxWidget(TokenBox tokenBox, BoxIndex boxIndexObject) {
	}

	@Override
	public void removeTokenBoxWidget(BoxIndex boxIndexObject) {
	}

	@Override
	public void movePageSegment(LineIndex fromLineIndexObject, LineIndex toLineIndexObject, int segmentLength) {
	}

	@Override
	public void moveLineSegment(BoxIndex fromBoxIndexObject, BoxIndex toBoxIndexObject, int segmentLength) {
	}

	@Override
	public void moveLine(LineIndex fromLineIndexObject, LineIndex toLineIndexObject) {
	}

	@Override
	public void setCursorPositionAndFocus(BoxIndex boxIndexObject, int cursorIndex) {
	}

	@Override
	public void focusIdBoxWidget(BoxIndex boxIndexObject) {
	}

	@Override
	public int getCursorLeft(BoxIndex boxIndexObject) {
		return 0;
	}

	@Override
	public int getCursorPosition(BoxIndex boxIndexObject) {
		return 0;
	}

	@Override
	public void toggleTokenBoxWidgetSelection(BoxIndex boxIndexObject) {
	}

	@Override
	public boolean isFrameSelected(BoxIndex boxIndexObject) {
		return false;
	}

	@Override
	public void setFooterText(String newText) {
	}

	@Override
	public void setUnderlineVisibility(boolean visible) {
	}

	@Override
	public String getFooterText() {
		return null;
	}

	@Override
	public void changeBackgroundColor(BoxIndex boxIndexObject, Color color) {
	}

	@Override
	public void changeTextBackgroundColor(BoxIndex boxIndexObject, Color color) {
	}

	@Override
	public void insertNewSnippet(Id id, int pageNo, int pageWidth, int pageHeight, int x, int y, int width,
			int zIndex) {
	}

	@Override
	public void setDrawSnippetMode(boolean enabled) {
	}

	@Override
	public void setSnippetAutomaticResizeActive(int pageIndex, int lineIndex, boolean active) {
	}

	@Override
	public void setSnippetPosition(int pageIndex, int lineIndex, int x, int y) {
	}

	@Override
	public void setSnippetSelection(int pageIndex, int lineIndex, boolean selection) {
	}

	@Override
	public void setSnippetAutomaticResize(int pageIndex, int lineIndex, boolean automaticResize) {
	}

	@Override
	public void claimElement(Element element) {
	}

	@Override
	public HandlerRegistration addAttachHandler(Handler handler) {
		return null;
	}

	@Override
	public Widget asWidget() {
		return null;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
	}

	@Override
	public Object getLayoutData() {
		return null;
	}

	@Override
	public Widget getParent() {
		return null;
	}

	@Override
	public void addStyleDependentName(String styleSuffix) {
	}

	@Override
	public void addStyleName(String style) {
	}

	@Override
	public int getAbsoluteLeft() {
		return 0;
	}

	@Override
	public int getAbsoluteTop() {
		return 0;
	}

	@Override
	public int getOffsetHeight() {
		return 0;
	}

	@Override
	public int getOffsetWidth() {
		return 0;
	}

	@Override
	public String getStyleName() {
		return null;
	}

	@Override
	public void removeStyleDependentName(String styleSuffix) {
	}

	@Override
	public void setStyleName(String style, boolean add) {
	}

	@Override
	public void setStyleName(String style) {
	}

	@Override
	public void setTitle(String title) {
	}

	@Override
	public void setVisible(boolean visible) {
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void unsinkEvents(int eventBitsToRemove) {
	}

	@Override
	public void setSnippetZIndex(int pageIndex, int lineIndex, int maxZIndex) {
	}

	@Override
	public void reloadVideoToken(BoxIndex index) {
	}

	@Override
	public void setBox(Box box, BoxIndex boxIndexObject) {
	}

	@Override
	public void updateLineHeight(LineIndex lineIndexObject, int height) {
	}

	@Override
	public void insertNewCollage(int pageIndex, PageFormat pageFormat, Id collageId, boolean showGrid) {
	}

	@Override
	public void setUrlConverter(URLConverter urlConverter) {
	}

	@Override
	public void changeCollageGridVisibility(int pageIndex, boolean visible) {
	}

	@Override
	public void setFontSizeService(FontSizeService fontSizeService) {
	}

	@Override
	public void setDeleteCollageMode(boolean enabled) {
	}

	@Override
	public void scrollToPage(int pageIndex) {
	}

	@Override
	public void updateSnippetHeight(int pageIndex, int lineIndex) {
	}

	@Override
	public void loadVideoNotFoundInVideoToken(BoxIndex index) {
	}

	@Override
	public void removeSnippet(int pageIndex, int snippetIndex) {

	}

	@Override
	public int getSnippetCount(int pageIndex) {
		return 0;
	}

	@Override
	public SelectedFlowPanel getSnippet(int pageIndex, int snippetIndex) {
		return null;
	}

	@Override
	public boolean isCollage(int pageIndex) {
		return false;
	}

	@Override
	public int getLineCount(LineIndex lineIndex) {
		return 0;
	}

	@Override
	public void centerWidget(BoxIndex boxIndexObject) {
	}

	@Override
	public void setVideoToConvertingTillLoaded(BoxIndex index) {

	}
}
