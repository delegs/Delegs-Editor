package de.signWritingEditor.test.layout.compensate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.OverflowListLayout;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class CompensateTest extends LayoutTestCase {

	private static final PageFormat testFormat = new PageFormat("test", Orientation.VERTICAL, 10, 500, 500, 10, 10, 20,
			20);
	private TokenFactory tokenFactory;
	private TokenBoxFactory tokenBoxFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		getFontSizeService().setFontMetrics(fontMetricGenerationService.getFontMetrics());
		tokenFactory = new TokenFactory(getIdFactory());
		tokenBoxFactory = new TokenBoxFactory(getFontSizeService());
		tokenBoxFactory.setPageHeight(PageFormat.A4_PORTRAIT.getPixelInnerHeight());
		getDocumentLayouter().clear();
		getDocumentLayouter().addPage(testFormat);
		getDocumentLayouter().addNewLine();
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	public TokenFactory getTokenFactory() {
		return tokenFactory;
	}

	public TokenBoxFactory getTokenBoxFactory() {
		return tokenBoxFactory;
	}

	@Test
	public void testOnlySignItemTokensToLineBreak() {
		Token newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		assertEquals(100,
				getTokenBoxFactory().create(newToken, true, true, testFormat.getPixelInnerWidth()).getWidth_PX(), 0);

		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testOnlyFreeTextTokenToLineBreak() {
		// FreeTextTokenBox width = 120
		Token newToken = getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		assertEquals(121,
				getTokenBoxFactory().create(newToken, true, true, testFormat.getPixelInnerWidth()).getWidth_PX(), 0);

		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testOnlyFrameTokenToLineBreak() {
		// FramTokenBox width = 172
		Token newToken = getTokenFactory().createFrameToken();
		assertEquals(172,
				getTokenBoxFactory().create(newToken, true, true, testFormat.getPixelInnerWidth()).getWidth_PX(), 0);

		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFrameToken();
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createFrameToken();
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testOnlyVideoTokenToLineBreak() {
		// videoTokenBox width = 225

		Token newToken = getTokenFactory().createVideoToken();
		assertEquals(225,
				getTokenBoxFactory().create(newToken, true, true, testFormat.getPixelInnerWidth()).getWidth_PX(), 0);

		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createVideoToken();
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createVideoToken();
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testOnlyFormTokenToLineBreak() {
		// Prepare
		FormToken newToken = getTokenFactory()
				.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), "Test" + 1);
		// Check 1
		assertEquals(469,
				getTokenBoxFactory().create(newToken, true, true, testFormat.getPixelInnerWidth()).getWidth_PX(), 0);

		// Action 1
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test" + 2);
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test" + 3);
		getDocumentLayouter().addToken(newToken, true, true);

		// Check 2
		assertEquals(3, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		// Action 2
		newToken = getTokenFactory().createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test" + 4);
		getDocumentLayouter().addToken(newToken, true, true);

		// Check 3
		assertEquals(4, getDocumentLayouter().getLineCount(0));
	}

	@Test
	public void testSignItemTokenAndFreeTextTokenToLineBreak() {

		Token newToken = getTokenFactory()
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testSmallRealisticDocument() {
		createSmallDummyDocument();

		Token newToken = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().insertTokenAfter(((TokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getId(),
				newToken, true, true);

		assertEquals(3, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getLineCount(1));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(1, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 2)));
	}

	@Test
	public void testCanRemoveFreeTextLineAfterSignItem() {
		Token newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);
		newToken = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		getDocumentLayouter().removeTokenBox(newToken.getId());
	}

	private Box getBoxFromToken(Token token) {
		BoxIndex boxIndex = getDocumentLayouter().getIdBoxIndex(token.getId());
		return getDocumentLayouter().getBox(boxIndex);
	}

	@Test
	public void testOnlyOneLineRemainsAfterRemovingFreeTextLine() {
		Token firstToken = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(firstToken, true, true);
		Token secondToken = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(secondToken, true, true);
		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		OverflowListLayout firstLine = getDocumentLayouter().getLine(new LineIndex(0, 0));

		String debugMessage = String.format("The freetextline width [%spx] must equal the line width [%spx]",
				((FreeTextTokenBox) getBoxFromToken(firstToken)).getWidth_PX(), testFormat.getPixelInnerWidth());
		assertEquals(debugMessage, 0, firstLine.getOverflow(), 0);

		getDocumentLayouter().removeTokenBox(secondToken.getId());

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(
				"Line count differs. Hint: Method compensateLineUnderflow() was expected to remove the second line.", 1,
				getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
	}

	// -------------------
	// SIT SIT FTT
	// FTL
	// SIT VIT
	// ------------------
	// FT
	// -------------------
	// FT = FrameTokenBox, SIT= SignItemTokenBox, VIT = VideoTokenBox, FTT=
	// FreeTextTokenBox, FTL= FreeTextLine
	private void createSmallDummyDocument() {
		Token newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));

		newToken = getTokenFactory().createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory()
				.createFreeTextLineToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));

		newToken = getTokenFactory().createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createVideoToken();
		getDocumentLayouter().addToken(newToken, true, true);

		newToken = getTokenFactory().createFrameToken();
		getDocumentLayouter().addToken(newToken, true, true);

		assertEquals(3, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getLineCount(1));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
	}
}
