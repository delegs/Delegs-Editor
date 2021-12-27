package de.signWritingEditor.test.integration.ui.tokenBoxWidget;

import org.junit.Test;

import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.FreeTextTokenBoxWidgetBase;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.SignItemTokenBoxWidgetBase;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.ImageTokenBox;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.material.Document;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.test.integration.infrastructure.IntegrationTestCase;

public class ImageTokenBoxWidgetTest extends IntegrationTestCase {

	private DocumentPanel documentPanel;

	@Override
	public void gwtSetUp() {
		super.gwtSetUp();
		documentPanel = (DocumentPanel) getPanel(getGwtDocumentEditor());
	}

	protected DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	private Document getDocument() {
		return getGwtDocumentEditor().getDocument();
	}

	@Test
	public void testAddImageToken() {
		// Prepare
		Token signItemToken = getDocument().getToken(0, 0, 0);
		Token freeTextToken = getDocument().getToken(0, 0, 1);

		assertTrue(signItemToken instanceof SignItemToken);
		assertEquals(signItemToken.getId(), getCurrentCursorTokenId(getGwtDocumentEditor()));
		assertTrue(freeTextToken instanceof FreeTextToken);

		assertEquals(1, getGwtDocumentLayouter().getPageCount());
		assertEquals(2, getGwtDocumentLayouter().getPage(0).getBoxCount());
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));

		TokenBox tokenBox1 = (TokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 0));
		TokenBox tokenBox2 = (TokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 1, 0));

		assertTrue(tokenBox1 instanceof SignItemTokenBox);
		assertTrue(tokenBox2 instanceof FreeTextTokenBox);

		assertEquals(1, getDocumentPanel().getPageCount());
		assertEquals(2, getDocumentPanel().getLineCount(0));
		assertEquals(1, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(0, 1)));

		Widget widget1 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 0));
		Widget widget2 = getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 1, 0));

		assertTrue(widget1 instanceof SignItemTokenBoxWidgetBase);
		assertTrue(widget2 instanceof FreeTextTokenBoxWidgetBase);

		// Action
		getDocumentEditorSidebarListener().onAddImage();

		// Check
		Token imageToken = getDocument().getToken(0, 0, 1);

		assertEquals(3, getDocument().getTokenCount(0, 0));
		assertEquals(signItemToken, getDocument().getToken(0, 0, 0));
		assertEquals(freeTextToken, getDocument().getToken(0, 0, 2));
		assertTrue(imageToken instanceof ImageToken);
		assertEquals(imageToken.getId(), getCurrentCursorTokenId(getGwtDocumentEditor()));

		assertEquals(2, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getGwtDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(tokenBox1, getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 0)));
		assertEquals(tokenBox2, getGwtDocumentLayouter().getBox(new BoxIndex(0, 1, 0)));
		assertTrue(getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1)) instanceof ImageTokenBox);

		assertEquals(2, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentPanel().getIdBoxWidgetCount(new LineIndex(0, 1)));
		assertEquals(widget1, getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 0)));
		assertEquals(widget2, getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 1, 0)));
		assertTrue(getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)) instanceof ImageTokenBoxWidget);
	}

	@Test
	public void testTokenBoxWidth() {
		// Action
		getDocumentEditorSidebarListener().onAddImage();

		// Check
		ImageTokenBox box = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));
		ImageToken token = (ImageToken) getDocument().getToken(0, 0, 1);

		assertEquals(5, box.getMarginRight());
		assertEquals(225.0f, box.getWidth_PX());
		assertEquals((int) box.getWidth_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetWidth() + box.getMarginRight());
		assertEquals((int) box.getWidth_PX(), token.getWidth() + box.getMarginRight());
	}

	@Test
	public void testTokenBoxHeight() {
		// Action
		getDocumentEditorSidebarListener().onAddImage();

		// Check
		ImageTokenBox box = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));
		ImageToken token = (ImageToken) getDocument().getToken(0, 0, 1);

		assertEquals(207, box.getHeight_PX());
		assertEquals(box.getHeight_PX(), getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetHeight());
		assertEquals(box.getHeight_PX(), token.getHeight());
	}

	@Test
	public void testTokenBoxResize() {
		// Prepare
		getDocumentEditorSidebarListener().onAddImage();
		ImageToken imageToken = (ImageToken) getDocument().getToken(0, 0, 1);
		ImageTokenBoxWidget imageTokenBoxWidget = (ImageTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		ImageTokenBox imageTokenBox = (ImageTokenBox) imageTokenBoxWidget.getTokenBox();
		ImageTokenBox imageTokenBox2 = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));
		int newImageheight = 400;
		int newImageWidth = 300;
		int heightWithUrlBoxHeight = newImageheight + imageTokenBox.getURLBoxHeight_PX();
		int widthWithRightMargin = newImageWidth + imageTokenBox.getMarginRight();

		// Action
		resizeImageTokenBoxWidget(imageTokenBoxWidget, newImageWidth, newImageheight);

		// Check
		assertEquals(imageTokenBox, imageTokenBox2);
		assertEquals(widthWithRightMargin, (int) imageTokenBox.getWidth_PX());
		assertEquals((int) imageTokenBox.getWidth_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetWidth()
						+ imageTokenBox.getMarginRight());
		assertEquals((int) imageTokenBox.getWidth_PX(), imageToken.getWidth() + imageTokenBox.getMarginRight());
		assertEquals(heightWithUrlBoxHeight, imageTokenBox.getHeight_PX());
		assertEquals(imageTokenBox.getHeight_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetHeight());
		assertEquals(imageTokenBox.getHeight_PX(), imageToken.getHeight());
	}

	@Test
	public void testTokenBoxResizeMinHeight() {
		// Prepare
		getDocumentEditorSidebarListener().onAddImage();
		ImageToken imageToken = (ImageToken) getDocument().getToken(0, 0, 1);
		ImageTokenBoxWidget imageTokenBoxWidget = (ImageTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		ImageTokenBox imageTokenBox = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));

		// Action
		resizeImageTokenBoxWidget(imageTokenBoxWidget, 300, 1);

		// Check
		assertEquals(110, imageTokenBox.getHeight_PX());
		assertEquals(imageTokenBox.getHeight_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetHeight());
		assertEquals(imageTokenBox.getHeight_PX(), imageToken.getHeight());
	}

	@Test
	public void testTokenBoxResizeMinWidth() {
		// Prepare
		getDocumentEditorSidebarListener().onAddImage();
		ImageToken imageToken = (ImageToken) getDocument().getToken(0, 0, 1);
		ImageTokenBoxWidget imageTokenBoxWidget = (ImageTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		ImageTokenBox imageTokenBox = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));

		// Action
		resizeImageTokenBoxWidget(imageTokenBoxWidget, 1, 400);

		// Check
		assertEquals(105.0f, imageTokenBox.getWidth_PX());
		assertEquals((int) imageTokenBox.getWidth_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 0, 1)).getOffsetWidth()
						+ imageTokenBox.getMarginRight());
		assertEquals((int) imageTokenBox.getWidth_PX(), imageToken.getWidth() + imageTokenBox.getMarginRight());
	}

	@Test
	public void testTokenBoxResizeMaxWidth() {
		// Prepare
		getDocumentEditorSidebarListener().onAddImage();
		ImageToken imageToken = (ImageToken) getDocument().getToken(0, 0, 1);
		ImageTokenBoxWidget imageTokenBoxWidget = (ImageTokenBoxWidget) getDocumentPanel()
				.getTokenBoxWidget(new BoxIndex(0, 0, 1));
		ImageTokenBox imageTokenBox = (ImageTokenBox) getGwtDocumentLayouter().getBox(new BoxIndex(0, 0, 1));

		// Action
		resizeImageTokenBoxWidget(imageTokenBoxWidget,
				getGwtDocumentLayouter().getPage(0).getPageDimension().getPixelInnerWidth() + 100, 400);

		// Check
		assertEquals(getGwtDocumentLayouter().getPage(0).getPageDimension().getPixelInnerWidth(),
				(int) imageTokenBox.getWidth_PX());
		assertEquals((int) imageTokenBox.getWidth_PX(),
				getDocumentPanel().getTokenBoxWidget(new BoxIndex(0, 1, 0)).getOffsetWidth()
						+ imageTokenBox.getMarginRight());
		assertEquals((int) imageTokenBox.getWidth_PX(), imageToken.getWidth() + imageTokenBox.getMarginRight());
	}

	private native void resizeImageTokenBoxWidget(Object o, int i, int j)/*-{
		o.@de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.ImageTokenBoxWidget::setTokenBoxSize(II)(i,j);
	}-*/;
}
