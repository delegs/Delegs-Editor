package de.signWritingEditor.test.layout;

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
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FreeTextLayoutTest extends LayoutTestCase {

	private TokenFactory tokenFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tokenFactory = new TokenFactory(getIdFactory());
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		getFontSizeService().setFontMetrics(fontMetricGenerationService.getFontMetrics());
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	@After
	public void tearDown() throws Exception {
		getFontSizeService().setFontMetrics(null);
	}

	private TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	@Test
	public void testParagraphWidthWithFreeTextLine() {
		// Prepare
		int paragraphWidth = 100;
		PageFormat pageFormat = new PageFormat("A4 Hochformat", Orientation.VERTICAL, 1337, paragraphWidth, 1401, 0, 0,
				0, 0);
		getDocumentLayouter().addPage(pageFormat, false, null, false);
		getDocumentLayouter().addNewLine();
		Token freeTextLine = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		getDocumentLayouter().addToken(freeTextLine, true, true);

		// Check
		assertFalse(((FreeTextToken) freeTextLine).hasFixedWidth());
		assertEquals(-1, ((FreeTextToken) freeTextLine).getWidth());

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(freeTextLine.getId());
		Box box = getDocumentLayouter().getBox(boxIndex);
		assertTrue(box instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) box;
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals(paragraphWidth, freeTextTokenBox.getWidth_PX(), 0);
	}

	@Test
	public void testParagraphWidthFreeTextBox() {
		// Prepare
		int paragraphWidth = 1000;
		int freeTextTokenWidth = 200;
		PageFormat pageFormat = new PageFormat("A4 Hochformat", Orientation.VERTICAL, 1337, paragraphWidth, 1401, 0, 0,
				0, 0);
		getDocumentLayouter().addPage(pageFormat, false, null, false);
		getDocumentLayouter().addNewLine();
		Token freeTextToken = getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		((FreeTextToken) freeTextToken).setFixedWidth(true, freeTextTokenWidth);
		final int sliderWidth = FreeTextTokenBox.SLIDER_WIDTH;
		final int freeTextPaddingRight = FreeTextTokenBox.FREE_TEXT_TOKEN_BOX_MARGIN_RIGHT_PX;
		// Action
		getDocumentLayouter().addToken(freeTextToken, true, true);

		// Check
		assertEquals(freeTextTokenWidth, ((FreeTextToken) freeTextToken).getWidth());

		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(freeTextToken.getId());
		Box box = getDocumentLayouter().getBox(boxIndex);
		assertTrue(box instanceof FreeTextTokenBox);
		FreeTextTokenBox freeTextTokenBox = (FreeTextTokenBox) box;
		assertEquals(paragraphWidth, freeTextTokenBox.getParagraphWidth());
		assertEquals(freeTextTokenWidth + sliderWidth + freeTextPaddingRight, freeTextTokenBox.getWidth_PX(), 0);
	}
}
