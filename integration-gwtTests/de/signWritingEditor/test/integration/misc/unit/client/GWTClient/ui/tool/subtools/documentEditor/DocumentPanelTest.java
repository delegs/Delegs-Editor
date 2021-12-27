package de.signWritingEditor.test.integration.misc.unit.client.GWTClient.ui.tool.subtools.documentEditor;

import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;

import de.signWritingEditor.client.GWTClient.infrastructure.URLConverterClientImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.AbstractTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanelImpl;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.infrastructure.DocumentUiListenerMock;
import de.signWritingEditor.infrastructure.FontMetricMock;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.CursorPosition;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.test.integration.infrastructure.FontMetricGenerationServiceMock;

public class DocumentPanelTest extends GWTTestCase {

	private static final int PARAGRAPH_WIDTH = 1000;
	private DocumentPanel documentPanel;
	private TokenBoxFactory tokenBoxFactory;
	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		FontSizeService fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new FontMetricMock());
		fontSizeService.setFontMetrics(FontMetricGenerationServiceMock.getFontMetrics());

		documentPanel = GWT.create(DocumentPanelImpl.class);
		documentPanel.init();
		documentPanel.setFontSizeService(fontSizeService);
		documentPanel.setUrlConverter(new URLConverterClientImpl());
		documentPanel.setDocumentUiListener(new DocumentUiListenerMock());
		IdFactory idFactory = new IdFactory(2);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);
		tokenBoxFactory = new TokenBoxFactory(fontSizeService);
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
	}

	@Override
	public String getModuleName() {
		return "de.signWritingEditor.SignWritingEditor";
	}

	public DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	public TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	public TokenBoxFactory getTokenBoxFactory() {
		return tokenBoxFactory;
	}

	@Test
	public void testGetCursorPositionInLineAtForFrameToken() {
		// Prepare
		Token token = getTokenFactory().createFrameToken();
		AbstractTokenBoxWidget tokenBoxWidget = createTestPageWithOneLineAndOneWidget(token);

		// Action
		CursorPosition cursorPosition = getDocumentPanel().getCursorPositionInLineAt(new LineIndex(0, 0),
				tokenBoxWidget.getAbsoluteLeft());
		assertEquals(token.getId(), cursorPosition.getTokenId());
	}

	@Test
	public void testGetCursorPositionInLineAtForSignItemToken() {
		// Prepare
		Token token = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		AbstractTokenBoxWidget tokenBoxWidget = createTestPageWithOneLineAndOneWidget(token);

		// Action
		CursorPosition cursorPosition = getDocumentPanel().getCursorPositionInLineAt(new LineIndex(0, 0),
				tokenBoxWidget.getAbsoluteLeft());
		assertEquals(token.getId(), cursorPosition.getTokenId());
	}

	@Test
	public void testGetCursorPositionInLineAtForVideoToken() {
		// Prepare
		Token token = getTokenFactory().createVideoToken();
		AbstractTokenBoxWidget tokenBoxWidget = createTestPageWithOneLineAndOneWidget(token);

		// Action
		CursorPosition cursorPosition = getDocumentPanel().getCursorPositionInLineAt(new LineIndex(0, 0),
				tokenBoxWidget.getAbsoluteLeft());
		assertEquals(token.getId(), cursorPosition.getTokenId());
	}

	@Test
	public void testGetCursorPositionInLineAtForFreeTextToken() {
		// Prepare
		Token token = getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		AbstractTokenBoxWidget tokenBoxWidget = createTestPageWithOneLineAndOneWidget(token);

		// Action
		CursorPosition cursorPosition = getDocumentPanel().getCursorPositionInLineAt(new LineIndex(0, 0),
				tokenBoxWidget.getAbsoluteLeft());
		assertEquals(token.getId(), cursorPosition.getTokenId());
	}

	private AbstractTokenBoxWidget createTestPageWithOneLineAndOneWidget(Token token) {
		PageFormat a4Portrait = PageFormat.A4_PORTRAIT;
		getDocumentPanel().insertNewPage(0, a4Portrait);
		getDocumentPanel().insertNewLine(new LineIndex(0, 0), Orientation.VERTICAL);
		TokenBox tokenBox = getTokenBoxFactory().create(token, false, false, PARAGRAPH_WIDTH);
		getDocumentPanel().insertTokenBoxWidget(tokenBox, new BoxIndex(0, 0, 0));
		AbstractTokenBoxWidget tokenBoxWidget = getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 0));
		return tokenBoxWidget;
	}

}
