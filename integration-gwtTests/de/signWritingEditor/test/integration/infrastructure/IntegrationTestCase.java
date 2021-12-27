package de.signWritingEditor.test.integration.infrastructure;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.GWTClient.infrastructure.URLConverterClientImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar.DocumentEditorSideBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentLayouter;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.ContentReportServiceAsyncMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.LoggingServiceAsyncMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.UserServiceAsyncMock;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.layout.GWTFontMetric;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public abstract class IntegrationTestCase extends GWTTestCase {

	private GWTDocumentLayouter layouter;
	private IdFactory idFactory;
	private GWTDocumentEditor gwtDocumentEditor;
	private DocumentEditorSideBarListener documentEditorSidebarListener;
	private DocumentUiListener documentUiListener;
	private RoomItem dummyRootRoom;
	private FontSizeService fontSizeService;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void gwtSetUp() {
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new GWTFontMetric());
		fontSizeService.setFontMetrics(FontMetricGenerationServiceMock.getFontMetrics());
		idFactory = new IdFactory(System.currentTimeMillis());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);

		dummyRootRoom = createDummyRoot();
		TokenBoxFactory tokenBoxFactory = new TokenBoxFactory(fontSizeService);

		gwtDocumentEditor = new GWTDocumentEditor(new UserServiceAsyncMock(), new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(idFactory), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new LoggingServiceAsyncMock(), new BrowserHistoryServiceMock(),
				new BadgeServiceMock(), new ContentReportServiceAsyncMock(), new URLConverterClientImpl(), idFactory,
				textbasedTokenStyleFactory, "Test app", new LocalSessionServiceForUnknownUserMock(), dummyRootRoom,
				true, SignLocale.DGS, new DocumentEditorListenerMock(), tokenBoxFactory, fontSizeService);

		DocumentEditorSidebar sidebar = (DocumentEditorSidebar) getDocumentEditorSidebar(getGwtDocumentEditor());
		documentEditorSidebarListener = (DocumentEditorSideBarListener) getDocumentEditorSidebarListener(sidebar);

		DocumentPanel documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());

		documentUiListener = (DocumentUiListener) getDocumentUiListener(documentPanel);

		layouter = getGwtDocumentEditor().getLayouter();
		layouter.clear();
		initDefaultDocument();
	}

	protected TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	protected void initDefaultDocument() {
		getGwtDocumentEditor().createNewDocument(new FileTitle("Test Dokument"), PageFormat.A4_PORTRAIT, SignLocale.DGS,
				dummyRootRoom, dummyRootRoom);
	}

	protected RoomItem createDummyRoot() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}

	public FontSizeService getFontSizeService() {
		return fontSizeService;
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}

	protected native Object getDocumentUiListener(Object o) /*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl::documentUiListener;
	}-*/;

	protected native Object getDocumentEditorSidebarListener(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorSidebar::documentEditorSideBarListener;
	}-*/;

	protected native Object getDocumentEditorSidebar(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor::documentEditorSidebar;
	}-*/;

	protected native Object getDocumentEditorButtonBar(Object o)/*-{
		return p.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor::buttonBar;
	}-*/;

	protected native Object getDocumentEditorButtonBarListener(Object o)/*-{
		return p.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditorButtonBar::listener;
	}-*/;

	protected native Object getSelectedIDsFromDocumentEditor(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor::selectedParagraphIds;
	}-*/;

	protected native Object getIDFromSelectedFlowPanel(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::id;
	}-*/;

	protected native Object invokeHandleWidthChangedOnSelectedFlowPanel(Object o, int newWidth,
			boolean automatic)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::handleWidthChanged(IZ)(newWidth, automatic);
	}-*/;

	protected native Object invokeResizeOnSelectedFlowPanel(Object o, int deltaX, boolean automatic)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::resize(IZ)(deltaX, automatic);
	}-*/;

	protected native int invokeMoveOnSelectedFlowPanel(Object o, int deltaX, int deltaY)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::move(II)(deltaX,deltaY);
	}-*/;

	protected native void setFixedFreeTextBoxSize(Object o, int newWidth)/*-{
		o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidget::setFixedFreeTextBoxSize(I)(newWidth);
	}-*/;

	protected native int getFreeTextTokenBoxSliderWidth()/*-{
		return @de.signWritingEditor.shared.layout.FreeTextTokenBox::SLIDER_WIDTH;
	}-*/;

	protected native int getFreeTextBoxMarginRight()/*-{
		return @de.signWritingEditor.shared.layout.FreeTextTokenBox::FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX;
	}-*/;

	protected native int getDefaultParagraphWidth()/*-{
		return @de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::DEFAULT_PARAGRAPH_WIDTH;
	}-*/;

	protected native int getDefaultParagraphHeight()/*-{
		return @de.signWritingEditor.client.GWTClient.ui.general.widget.SelectedFlowPanel::DEFAULT_PARAGRAPH_HEIGHT;
	}-*/;

	protected native void turnOfAutomaticFreeTextLine(Object o)/*-{
		o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor::handleAutomaticFreeTextLine(Z)(false);
	}-*/;

	protected native Id getCurrentCursorTokenId(Object o)/*-{
		return o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor::currentCursorTokenId;
	}-*/;

	protected native void loadCss(String url)/*-{
		var fileref = document.createElement("link");
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", url);
		$doc.getElementsByTagName("head")[0].appendChild(fileref);
	}-*/;

	protected Widget getPanel(GWTDocumentEditor documentEditor) {
		return ((ScrollPanel) ((FlowPanel) documentEditor.getPanel()).getWidget(1)).getWidget();
	}

	protected GWTDocumentEditor getGwtDocumentEditor() {
		return gwtDocumentEditor;
	}

	protected void turnAutomaticFreeTextLineOf() {
		turnOfAutomaticFreeTextLine(gwtDocumentEditor);
	}

	protected DocumentEditorSideBarListener getDocumentEditorSidebarListener() {
		return documentEditorSidebarListener;
	}

	protected DocumentUiListener getDocumentUiListener() {
		return documentUiListener;
	}

	protected GWTDocumentLayouter getGwtDocumentLayouter() {
		return layouter;
	}

	protected IdFactory getIdFactory() {
		return idFactory;
	}

	protected TextbasedTokenStyleFactory getTextbasedTokenStyleFactory() {
		return textbasedTokenStyleFactory;
	}

}
