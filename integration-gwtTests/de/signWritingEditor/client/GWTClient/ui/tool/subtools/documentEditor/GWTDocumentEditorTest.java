package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.infrastructure.LocalSessionServiceForUnknownUserMock;
import de.signWritingEditor.client.GWTClient.infrastructure.URLConverterClientImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorMacImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentPanelListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel.DocumentUiListener;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.infrastructure.BadgeServiceMock;
import de.signWritingEditor.infrastructure.ContentReportServiceAsyncMock;
import de.signWritingEditor.infrastructure.DictionaryServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentEditorListenerMock;
import de.signWritingEditor.infrastructure.DocumentPanelMock;
import de.signWritingEditor.infrastructure.DocumentServiceAsyncMock;
import de.signWritingEditor.infrastructure.DocumentUiListenerMock;
import de.signWritingEditor.infrastructure.FontMetricMock;
import de.signWritingEditor.infrastructure.GWTDocumentLayouterMock;
import de.signWritingEditor.infrastructure.LoggingServiceAsyncMock;
import de.signWritingEditor.infrastructure.MediaUrlServiceAsyncMock;
import de.signWritingEditor.infrastructure.PdfServiceAsyncMock;
import de.signWritingEditor.infrastructure.UserServiceAsyncMock;
import de.signWritingEditor.infrastructure.VideoServiceAsyncMock;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.test.integration.infrastructure.BrowserHistoryServiceMock;
import de.signWritingEditor.test.integration.infrastructure.FontMetricGenerationServiceMock;
import de.signWritingEditor.test.integration.misc.unit.infrastructure.DocumentPanelListenerMock;

public class GWTDocumentEditorTest extends GWTTestCase {
	private static final FontSize DEFAULT_FONT_SIZE = FontSizeService.STANDARD_FONT_SIZE;
	private static final Color DEFAULT_FONT_COLOR = Color.BLACK;
	private static final Color DEFAULT_TEXT_BACKGROUND_COLOR = Color.GREY;
	private static final FontStyle DEFAULT_FONT_STYLE = FontStyle.NORMAL;
	private static final FontWeight DEFAULT_FONT_WEIGHT = FontWeight.NORMAL;
	private static final Font DEFAULT_FONT = Font.HELVETICA;
	private static final ReadOnlyTextbasedTokenStyle DEFAULT_TEXTBASED_TOKEN_STYLE = new TextbasedTokenStyle(
			DEFAULT_FONT_SIZE, DEFAULT_FONT_COLOR, DEFAULT_TEXT_BACKGROUND_COLOR, DEFAULT_FONT_STYLE,
			DEFAULT_FONT_WEIGHT, DEFAULT_FONT);
	private static final int PARAGRAPH_WIDTH = 1000;

	GWTDocumentEditor documentEditor;
	private TokenFactory tokenFactory;
	private TokenBoxFactory tokenBoxFactory;
	private FontSizeService fontSizeService;
	private TokenBoxWidgetFactory tokenBoxWidgetFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		IdFactory idFactory = new IdFactory(2);
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new FontMetricMock());
		fontSizeService.setFontMetrics(FontMetricGenerationServiceMock.getFontMetrics());
		tokenBoxFactory = new TokenBoxFactory(fontSizeService);
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		LocalSessionServiceForUnknownUserMock localSessionServiceForUnknownUserSessionMock = new LocalSessionServiceForUnknownUserMock();
		documentEditor = new GWTDocumentEditor(new UserServiceAsyncMock(), new DictionaryServiceAsyncMock(),
				new DocumentServiceAsyncMock(idFactory), new PdfServiceAsyncMock(), new VideoServiceAsyncMock(),
				new MediaUrlServiceAsyncMock(), new LoggingServiceAsyncMock(), new BrowserHistoryServiceMock(),
				new BadgeServiceMock(), new ContentReportServiceAsyncMock(), new URLConverterClientImpl(), idFactory,
				textbasedTokenStyleFactory, "Test app", localSessionServiceForUnknownUserSessionMock, createDummyRoot(),
				true, SignLocale.DGS, new DocumentEditorListenerMock(), tokenBoxFactory, fontSizeService) {
			@Override
			protected void initLayouter() {
				setDocumentLayouter(new SetCursorPositionGWTDocumentLayouterMock());
			}

			@Override
			protected Widget createToolPanel(UserServiceAsync userService, MediaUrlServiceAsync mediaUrlService) {
				documentEditorSidebar = new DocumentEditorSidebarMock(userService, mediaUrlService,
						this.getLocalSessionService());
				return null;
			}

			@Override
			public void openDocument(Document document, DocumentItem optionalDocumentItem, FolderItem folderItem,
					RoomItem roomContainingDocument) {
			}

		};

		tokenFactory = new TokenFactory(idFactory);
		URLConverter urlConverter = new URLConverterClientImpl();
		DocumentPanelListener documentPanelListener = new DocumentPanelListenerMock();
		EventTranslatorStandardImpl eventTranslator = null;
		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		} else {
			eventTranslator = GWT.create(EventTranslatorStandardImpl.class);
		}
		DocumentUiListener documentUiListener = new DocumentUiListenerMock();
		VisibilityToolTip visibilityToolTip = new VisibilityToolTip(true, 0);
		tokenBoxWidgetFactory = new TokenBoxWidgetFactory(false, urlConverter, eventTranslator, fontSizeService,
				visibilityToolTip, documentUiListener, documentPanelListener);
	}

	private ReadOnlyTextbasedTokenStyle getDefaultTokenStyle() {
		return DEFAULT_TEXTBASED_TOKEN_STYLE;
	}

	public TokenBoxFactory getTokenBoxFactory() {
		return tokenBoxFactory;
	}

	class TestDocumentPanelMock extends DocumentPanelMock {
		private Token token;
		private AbstractTokenBoxWidget widget;

		public TestDocumentPanelMock(Token token) {
			this.token = token;
			widget = createTestPageWithOneLineAndOneWidget(this, token);
		}

		@Override
		public AbstractTokenBoxWidget getTokenBoxWidget(BoxIndex boxIndexObject) {
			if (token != null) {
				return widget;
			} else {
				return new AbstractTextbasedTokenBoxWidgetMock();
			}
		}

		@Override
		public void insertTokenBoxWidget(TokenBox tokenBox, BoxIndex boxIndexObject) {
		}

	};

	protected native void setDocumentPanel(Object editor, TestDocumentPanelMock panel)/*-{
		editor.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor::setDocumentPanel(Lde/signWritingEditor/client/GWTClient/ui/tool/subtools/documentEditor/DocumentPanel;)(panel);
	}-*/;

	protected RoomItem createDummyRoot() {
		return new RoomItem(RoomItem.ROOT_FOLDER_ID, "user", new ArrayList<String>(), new ArrayList<String>(),
				new FileTitle("/"), new Date(), new Date(), RoomPolicy.SHARED_CONTENT);
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}

	public GWTDocumentEditor getDocumentEditor() {
		return documentEditor;
	}

	private AbstractTokenBoxWidget createTestPageWithOneLineAndOneWidget(DocumentPanel documentPanel, Token token) {
		PageFormat a4Portrait = PageFormat.A4_PORTRAIT;
		documentPanel.insertNewPage(0, a4Portrait);
		documentPanel.insertNewLine(new LineIndex(0, 0), Orientation.VERTICAL);
		TokenBox tokenBox = getTokenBoxFactory().create(token, false, false, PARAGRAPH_WIDTH);

		AbstractTokenBoxWidget tokenBoxWidget = tokenBoxWidgetFactory.create(tokenBox);
		return tokenBoxWidget;
	}

	public void testSetCursorPositionInUiToSignItemToken() {
		// Prepare
		final Token token = tokenFactory.createSignItemToken("", getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS);
		setDocumentPanel(documentEditor, new TestDocumentPanelMock(token));

		// Action
		getDocumentEditor().setCursorPositionInUi(token.getId(), 0);

		// Check
		assertTrue("No exception expected.", true);
	}

	public void testSetCursorPositionInUiToFrameToken() {
		// Prepare
		final Token token = tokenFactory.createFrameToken();
		setDocumentPanel(documentEditor, new TestDocumentPanelMock(token));

		// Action
		getDocumentEditor().setCursorPositionInUi(token.getId(), 0);

		// Check
		assertTrue("No exception expected.", true);
	}

	public void testSetCursorPositionInUiToVideoToken() {
		// Prepare
		final Token token = tokenFactory.createVideoToken();
		setDocumentPanel(documentEditor, new TestDocumentPanelMock(token));

		// Action
		getDocumentEditor().setCursorPositionInUi(token.getId(), 0);

		// Check
		assertTrue("No exception expected.", true);
	}

	public void testSetCursorPositionInUiToFreeTextToken() {
		// Prepare
		final Token token = tokenFactory.createFreeTextToken(getDefaultTokenStyle());
		setDocumentPanel(documentEditor, new TestDocumentPanelMock(token));

		// Action
		getDocumentEditor().setCursorPositionInUi(token.getId(), 0);

		// Check
		assertTrue("No exception expected.", true);
	}

	private class SetCursorPositionGWTDocumentLayouterMock extends GWTDocumentLayouterMock {
		@Override
		public boolean containsIdBox(Id id) {
			return true;
		}

		@Override
		public BoxIndex getIdBoxIndex(Id id) {
			return new BoxIndex(0, 0, 0);
		}

		public void setPageFormat(PageFormat format) {
			//
		}
	}

	private class AbstractTextbasedTokenBoxWidgetMock extends AbstractTextbasedTokenBoxWidget {
		public AbstractTextbasedTokenBoxWidgetMock() {
		}

		@Override
		public boolean isValidCursorPosition(int cursorPosition) {
			return false;
		}

		@Override
		public int getCursorPositionAt(int left) {
			return 0;
		}

		@Override
		public int getCursorPosition() {
			return 0;
		}

		@Override
		public void toggleSelection() {
		}

		@Override
		public void setTokenBox(TokenBox tokenBox) {
		}

		@Override
		public TokenBox getTokenBox() {
			return null;
		}

		@Override
		public Id getId() {
			return null;
		}

		@Override
		public int getCursorLeft() {
			return 0;
		}

		@Override
		public String getText() {
			return null;
		}

		@Override
		public void addTextMouseOverHandlers(MouseOverHandler mouseOverHandler, MouseOutHandler mouseOutHandler) {
		}

		@Override
		public void setCursorPositionAndFocus(int cursorPosition) {

		}

		@Override
		public void setTextBoxBackgroundColor(Color color) {

		}

		@Override
		public void focus() {

		}

		@Override
		public void setDragModeHandler(MouseDragListener listener) {
		}

		@Override
		protected void setTokenBoxSize(int width, int height) {
		}

		@Override
		protected boolean isResizeable() {
			return false;
		}
	}

	public class ChangeAlternativeToolTipMock extends ChangeAlternativeToolTip {

		public ChangeAlternativeToolTipMock() {
			super(false);
		}

		public ChangeAlternativeToolTipMock(boolean mobile) {
			super(mobile);
		}

	}

	public class DocumentEditorSidebarMock extends DocumentEditorSidebar {

		public DocumentEditorSidebarMock(UserServiceAsync userService, MediaUrlServiceAsync mediaUrlService,
				LocalSessionService localSessionService) {
			super(userService, mediaUrlService, localSessionService, null, false);
		}
	}

}
