package de.signWritingEditor.infrastructure;

import org.junit.Before;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentLayouter;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.PageFormat;

public abstract class LayoutTestCase extends UnitTestCase {

	private GWTDocumentLayouter layouter;
	private IdFactory idFactory;
	private FontSizeService fontSizeService;

	@Before
	public void setUp() throws Exception {
		fontSizeService = new FontSizeServiceImpl();
		fontSizeService.setMetric(new FontMetricMock());

		DocumentPanel documentPanel = new DocumentPanelMock();
		TokenBoxFactory tokenBoxFactory = new TokenBoxFactory(fontSizeService);
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
		layouter = new GWTDocumentLayouter(documentPanel, tokenBoxFactory);
		idFactory = new IdFactory(System.currentTimeMillis());
	}

	public FontSizeService getFontSizeService() {
		return fontSizeService;
	}

	protected GWTDocumentLayouter getDocumentLayouter() {
		return layouter;
	}

	protected IdFactory getIdFactory() {
		return idFactory;
	}

}
