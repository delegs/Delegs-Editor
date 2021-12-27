package de.signWritingEditor.test.layout.collage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FreeTextLayoutTest extends LayoutTestCase {

	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private ConfigurationService connector;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tokenFactory = new TokenFactory(getIdFactory());
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		getFontSizeService().setFontMetrics(fontMetricGenerationService.getFontMetrics());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		connector = new ConfigurationService("/ESFConfig_Junit.properties");
	}

	@After
	public void tearDown() throws Exception {
		getFontSizeService().setFontMetrics(null);
	}

	private TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	@Test
	public void testSnippetWidthFreeTextLine() {
		// Prepare
		int paragraphWidth = 500;
		int innerParagraphWidth = 470;
		Id collageId = getIdFactory().createId();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, collageId, true);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;
		getDocumentLayouter().removeFirstSnippet(pageIndex);
		getDocumentLayouter().addSnippetToCollagePage(collageId, pageIndex, 10, 10, paragraphWidth, 0);
		Token freeTextLine = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		getDocumentLayouter().addTokenToSnippet(pageIndex, 0, freeTextLine);

		// Check
		assertEquals(-1, ((FreeTextToken) freeTextLine).getWidth());

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(freeTextLine.getId());
		Box box = getDocumentLayouter().getBox(boxIndex);
		assertTrue(box instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) box;
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals(innerParagraphWidth, freeTextTokenBox.getWidth_PX(), 0);
	}

	@Test
	public void testSnippetWidthFreeTextBox() {
		// Prepare
		int paragraphWidth = 1000;
		int innerParagraphWidth = 970;
		int freeTextTokenWidth = 200;
		Id collageId = getIdFactory().createId();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, collageId, true);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;
		getDocumentLayouter().removeFirstSnippet(pageIndex);
		getDocumentLayouter().addSnippetToCollagePage(collageId, pageIndex, 10, 10, paragraphWidth, 0);
		Token freeTextToken = getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		((FreeTextToken) freeTextToken).setFixedWidth(true, freeTextTokenWidth);
		final int sliderWidth = FreeTextTokenBox.SLIDER_WIDTH;

		// Action
		getDocumentLayouter().addTokenToSnippet(pageIndex, 0, freeTextToken);

		// Check
		assertEquals(freeTextTokenWidth, ((FreeTextToken) freeTextToken).getWidth());

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		Box box = getDocumentLayouter().getBox(boxIndex);
		assertTrue(box instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) box;
		assertEquals(innerParagraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals(freeTextTokenWidth + sliderWidth + FreeTextTokenBox.FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX,
				freeTextTokenBox.getWidth_PX(), 0);
	}

	@Test
	public void testEnlargeSnippet() {
		// Prepare
		int paragraphWidth = 500;
		int freeTextTokenWidth = 200;
		int newParagraphWidth = 1000;
		int newInnerParagraphWidth = 970;
		int defaultTokenBoxWidth = 100;
		int sliderWidth = FreeTextTokenBox.SLIDER_WIDTH;
		int marginRight = FreeTextTokenBox.FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX;

		Id collageId = getIdFactory().createId();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, collageId, true);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;

		getDocumentLayouter().removeFirstSnippet(pageIndex);
		getDocumentLayouter().addSnippetToCollagePage(collageId, pageIndex, 10, 10, paragraphWidth, 0);

		FreeTextToken fixedWidthFreeTextToken = (FreeTextToken) getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		fixedWidthFreeTextToken.setFixedWidth(true, freeTextTokenWidth);
		getDocumentLayouter().addTokenToSnippet(pageIndex, 0, fixedWidthFreeTextToken);

		FreeTextToken freeTextLineToken = (FreeTextToken) getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().insertTokenAfter(fixedWidthFreeTextToken.getId(), freeTextLineToken, true, true);

		FreeTextToken variableWidthFreeTextToken = (FreeTextToken) getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().insertTokenAfter(fixedWidthFreeTextToken.getId(), variableWidthFreeTextToken, true, true);

		FreeTextTokenBox fixedWidthFreeTextTokenBox = getFreeTextTokenBoxForTokenId(fixedWidthFreeTextToken.getId());
		FreeTextTokenBox variableWidthFreeTextTokenBox = getFreeTextTokenBoxForTokenId(
				variableWidthFreeTextToken.getId());
		FreeTextTokenBox freeTextLineBox = getFreeTextTokenBoxForTokenId(freeTextLineToken.getId());

		// Action
		getDocumentLayouter().updateSnippetWidth(pageIndex, 0, newParagraphWidth, false);

		// Check
		assertEquals(newInnerParagraphWidth, fixedWidthFreeTextTokenBox.getParagraphWidth());
		assertEquals(newInnerParagraphWidth, variableWidthFreeTextTokenBox.getParagraphWidth());
		assertEquals(newInnerParagraphWidth, freeTextLineBox.getParagraphWidth());

		assertEquals(freeTextTokenWidth, fixedWidthFreeTextTokenBox.getMinWidth());
		assertEquals(defaultTokenBoxWidth, variableWidthFreeTextTokenBox.getMinWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth, freeTextLineBox.getMinWidth());

		assertEquals(freeTextTokenWidth, fixedWidthFreeTextTokenBox.getMaxWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth - marginRight, variableWidthFreeTextTokenBox.getMaxWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth, freeTextLineBox.getMaxWidth());

		assertEquals(freeTextTokenWidth + sliderWidth + marginRight, fixedWidthFreeTextTokenBox.getWidth_PX(), 0);
		assertEquals(defaultTokenBoxWidth + sliderWidth + marginRight, variableWidthFreeTextTokenBox.getWidth_PX(), 0);
		assertEquals(newInnerParagraphWidth, freeTextLineBox.getWidth_PX(), 0);
	}

	@Test
	public void testDecreaseSnippet() {
		int paragraphWidth = 1000;
		int freeTextTokenWidth = 200;
		int newParagraphWidth = 200;
		int newInnerParagraphWidth = 170;
		int defaultTokenBoxWidth = 100;
		int sliderWidth = FreeTextTokenBox.SLIDER_WIDTH;
		int marginRight = FreeTextTokenBox.FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX;

		Id collageId = getIdFactory().createId();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, collageId, true);
		int pageIndex = getDocumentLayouter().getPageCount() - 1;

		getDocumentLayouter().removeFirstSnippet(pageIndex);
		getDocumentLayouter().addSnippetToCollagePage(collageId, pageIndex, 10, 10, paragraphWidth, 0);

		FreeTextToken fixedWidthFreeTextToken = (FreeTextToken) getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		fixedWidthFreeTextToken.setFixedWidth(true, freeTextTokenWidth);
		getDocumentLayouter().addTokenToSnippet(pageIndex, 0, fixedWidthFreeTextToken);

		FreeTextToken freeTextLineToken = (FreeTextToken) getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().insertTokenAfter(fixedWidthFreeTextToken.getId(), freeTextLineToken, true, true);

		FreeTextToken variableWidthFreeTextToken = (FreeTextToken) getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().insertTokenAfter(fixedWidthFreeTextToken.getId(), variableWidthFreeTextToken, true, true);

		FreeTextTokenBox fixedWidthFreeTextTokenBox = getFreeTextTokenBoxForTokenId(fixedWidthFreeTextToken.getId());
		FreeTextTokenBox variableWidthFreeTextTokenBox = getFreeTextTokenBoxForTokenId(
				variableWidthFreeTextToken.getId());
		FreeTextTokenBox freeTextLineBox = getFreeTextTokenBoxForTokenId(freeTextLineToken.getId());

		// Action
		getDocumentLayouter().updateSnippetWidth(pageIndex, 0, newParagraphWidth, false);

		// Check
		assertEquals(newInnerParagraphWidth, fixedWidthFreeTextTokenBox.getParagraphWidth());
		assertEquals(newInnerParagraphWidth, variableWidthFreeTextTokenBox.getParagraphWidth());
		assertEquals(newInnerParagraphWidth, freeTextLineBox.getParagraphWidth());

		assertEquals(freeTextTokenWidth, fixedWidthFreeTextTokenBox.getMinWidth());
		assertEquals(defaultTokenBoxWidth, variableWidthFreeTextTokenBox.getMinWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth, freeTextLineBox.getMinWidth()); // FreeTextLine
																							// has
																							// no
																							// margin
																							// right

		assertEquals(freeTextTokenWidth, fixedWidthFreeTextTokenBox.getMaxWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth - marginRight, variableWidthFreeTextTokenBox.getMaxWidth());
		assertEquals(newInnerParagraphWidth - sliderWidth, freeTextLineBox.getMaxWidth()); // FreeTextLine
																							// has
																							// no
																							// margin
																							// right

		assertEquals(freeTextTokenWidth + sliderWidth + marginRight, fixedWidthFreeTextTokenBox.getWidth_PX(), 0);
		assertEquals(defaultTokenBoxWidth + sliderWidth + marginRight, variableWidthFreeTextTokenBox.getWidth_PX(), 0);
		assertEquals(newInnerParagraphWidth, freeTextLineBox.getWidth_PX(), 0);

		assertFalse(fixedWidthFreeTextTokenBox.isLine());
		assertFalse(variableWidthFreeTextTokenBox.isLine());
		assertTrue(freeTextLineBox.isLine());
	}

	private FreeTextTokenBox getFreeTextTokenBoxForTokenId(Id tokenId) {
		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(tokenId);
		return (FreeTextTokenBox) getDocumentLayouter().getBox(boxIndex);
	}

}
