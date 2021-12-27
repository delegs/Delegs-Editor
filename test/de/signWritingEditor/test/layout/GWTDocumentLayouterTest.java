package de.signWritingEditor.test.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import de.signWritingEditor.client.service.FontMetricGenerationService;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.infrastructure.LayoutTestCase;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.server.service.FontMetricGenerationServiceImpl;
import de.signWritingEditor.shared.layout.Box;
import de.signWritingEditor.shared.layout.ContinuousPageLayout;
import de.signWritingEditor.shared.layout.FreeTextTokenBox;
import de.signWritingEditor.shared.layout.SignItemTokenBox;
import de.signWritingEditor.shared.layout.SnippetLayout;
import de.signWritingEditor.shared.model.domainValue.BoxIndex;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.LineIndex;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenBox;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class GWTDocumentLayouterTest extends LayoutTestCase {

	private TokenFactory tokenFactory;

	private static final FontSize DEFAULT_FONT_SIZE = FontSizeService.STANDARD_FONT_SIZE;
	private static final Color DEFAULT_FONT_COLOR = Color.BLACK;
	private static final Color DEFAULT_TEXT_BACKGROUND_COLOR = Color.GREY;
	private static final FontStyle DEFAULT_FONT_STYLE = FontStyle.NORMAL;
	private static final FontWeight DEFAULT_FONT_WEIGHT = FontWeight.NORMAL;
	private static final Font DEFAULT_FONT = Font.HELVETICA;

	private static final ReadOnlyTextbasedTokenStyle DEFAULT_TEXTBASED_TOKEN_STYLE = new TextbasedTokenStyle(
			DEFAULT_FONT_SIZE, DEFAULT_FONT_COLOR, DEFAULT_TEXT_BACKGROUND_COLOR, DEFAULT_FONT_STYLE,
			DEFAULT_FONT_WEIGHT, DEFAULT_FONT);

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tokenFactory = new TokenFactory(getIdFactory());
		FontMetricGenerationService fontMetricGenerationService = new FontMetricGenerationServiceImpl(
				new ConfigurationService("/ESFConfig_Junit.properties"));
		getFontSizeService().setFontMetrics(fontMetricGenerationService.getFontMetrics());
	}

	@After
	public void tearDown() throws Exception {
		getFontSizeService().setFontMetrics(null);
	}

	@Test
	public void testPageAddAndLineAdd() {
		assertEquals(0, getDocumentLayouter().getPageCount());
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		assertEquals(1, getDocumentLayouter().getPageCount());

		// Test adding lines
		assertEquals(0, getDocumentLayouter().getLineCount(0));
		getDocumentLayouter().addNewLine();
		assertEquals(1, getDocumentLayouter().getLineCount(0));
		getDocumentLayouter().addNewLine();
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getLineCount(1));

		getDocumentLayouter().removePage(0);
		getDocumentLayouter().removePage(0);
		assertEquals(0, getDocumentLayouter().getPageCount());
		try {
			getDocumentLayouter().removePage(0);
			fail("Can't remove page when none exists");
		} catch (AssertionError | IndexOutOfBoundsException e) {
			assertTrue(true);
		}
    }

	@Test
	public void testAddTokens() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		String token2Word = "token2";

		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().addToken(token1, true, true);
		try {
			getDocumentLayouter().addToken(token1, true, true);
			fail("Can't add same token twice");
		} catch (AssertionError e) {
		}
		getDocumentLayouter().addToken(token2, true, true);

		BoxIndex box1Index = getDocumentLayouter().getIdBoxIndex(token1.getId());
		SignItemTokenBox tokenBox1 = (SignItemTokenBox) getDocumentLayouter().getBox(box1Index);
		assertEquals(token1.getText(), tokenBox1.getText());
		assertEquals(token1.getId(), tokenBox1.getId());

		BoxIndex box2Index = getDocumentLayouter().getIdBoxIndex(token2.getId());
		SignItemTokenBox tokenBox2 = (SignItemTokenBox) getDocumentLayouter().getBox(box2Index);
		assertEquals(token2.getText(), tokenBox2.getText());
		assertEquals(token2.getId(), tokenBox2.getId());

		BoxIndex previousBox2Index = new BoxIndex(box2Index.getPageIndex(), box2Index.getLineIndex(),
				box2Index.getBoxIndex() - 1);
		SignItemTokenBox previousTokenBox = (SignItemTokenBox) getDocumentLayouter().getBox(previousBox2Index);

		assertEquals(tokenBox1, previousTokenBox);

		// Make sure token is inserted at the correct position
		SignItemToken tokenInTheMiddle = tokenFactory.createSignItemToken("tokenInTheMiddle", getDefaultTokenStyle(),
				Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().insertTokenAfter(token1.getId(), tokenInTheMiddle, true, true);
		BoxIndex tokenBoxInTheMiddleIndex = getDocumentLayouter().getIdBoxIndex(tokenInTheMiddle.getId());
		assertEquals(box1Index.getBoxIndex() + 1, tokenBoxInTheMiddleIndex.getBoxIndex());
		assertTrue(getDocumentLayouter().containsTokenBox(tokenInTheMiddle.getId()));
		boolean insertAfterSucceded = false;
		try {
			getDocumentLayouter().insertTokenAfter(tokenInTheMiddle.getId(), tokenInTheMiddle, true, true);
			insertAfterSucceded = true;
		} catch (AssertionError e) {
		}
		assertFalse("Can't insert token after itself", insertAfterSucceded);
		getDocumentLayouter().removeBox(tokenBoxInTheMiddleIndex);
		assertFalse(getDocumentLayouter().containsTokenBox(tokenInTheMiddle.getId()));

		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
	}

	private ReadOnlyTextbasedTokenStyle getDefaultTokenStyle() {
		return DEFAULT_TEXTBASED_TOKEN_STYLE;
	}

	@Test
	public void testSearchWordVisibility() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		String token2Word = "token2";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);
		getDocumentLayouter().addToken(token2, true, true);

		BoxIndex box1Index = getDocumentLayouter().getIdBoxIndex(token1.getId());
		SignItemTokenBox token1Box = (SignItemTokenBox) getDocumentLayouter().getBox(box1Index);
		BoxIndex box2Index = getDocumentLayouter().getIdBoxIndex(token2.getId());
		SignItemTokenBox token2Box = (SignItemTokenBox) getDocumentLayouter().getBox(box2Index);
		assertTrue(token1Box.isSearchWordVisible());
		assertTrue(token2Box.isSearchWordVisible());
		getDocumentLayouter().setSearchWordVisibility(token1.getId(), false);
		assertFalse(token1Box.isSearchWordVisible());
		assertTrue(token2Box.isSearchWordVisible());
		getDocumentLayouter().setSearchWordVisibility(token1.getId(), true);
		getDocumentLayouter().setSearchWordVisibility(token2.getId(), false);
		assertTrue(token1Box.isSearchWordVisible());
		assertFalse(token2Box.isSearchWordVisible());
	}

	@Test
	public void testGetTokenIdBelow() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);

		String token2Word = "token2";
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertLineBreakAndTokenAfter(token1.getId(), true, true, token2);

		assertTrue(getDocumentLayouter().isInLastTokenBoxLine(token2.getId()));
		assertFalse(getDocumentLayouter().isInLastTokenBoxLine(token1.getId()));

	}

	@Test
	public void testInsertPageBreakAfter() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);
		String freeText1 = "first free text";
		insertFreeTextLineAfter(token1.getId(), getIdFactory().createId(), freeText1, true);

		String token2Word = "token2";
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		String freeText2 = "second free text";
		getDocumentLayouter().insertPageBreakAndTokenAfter(token1.getId(), true, true, true, token2);
		insertFreeTextLineAfter(token2.getId(), getIdFactory().createId(), freeText2, true);

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getLineCount(1));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertEquals(token1.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getId());
		assertEquals(token1.getText(),
				((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertEquals(token2.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token2.getText(),
				((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getText());

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 0)) instanceof FreeTextTokenBox);
		assertEquals(freeText2, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 0))).getText());

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 2, 0)) instanceof FreeTextTokenBox);
		assertEquals(freeText1, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 2, 0))).getText());
	}

	@Test
	public void testInsertLineBreakAfter() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);
		String freeText1 = "first free text";
		insertFreeTextLineAfter(token1.getId(), getIdFactory().createId(), freeText1, true);

		String token3Word = "token3";
		SignItemToken token3 = tokenFactory.createSignItemToken(token3Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		String freeText3 = "third free text";
		getDocumentLayouter().insertLineBreakAndTokenAfter(token1.getId(), true, true, token3);
		insertFreeTextLineAfter(token3.getId(), getIdFactory().createId(), freeText3, true);
		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(4, getDocumentLayouter().getLineCount(0));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof SignItemTokenBox);
		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getId());
		assertEquals(token3.getText(),
				((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 0)) instanceof FreeTextTokenBox);
		assertEquals(freeText3, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 0))).getText());

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 3, 0)) instanceof FreeTextTokenBox);
		assertEquals(freeText1, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 0))).getText());
	}

	@Test
	public void testRemoveLineBreakAfterToRemovePageBreak() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);
		String freeText1 = "first free text";
		Id idFreeTextLine = getIdFactory().createId();
		insertFreeTextLineAfter(token1.getId(), idFreeTextLine, freeText1, true);

		SignItemToken token3 = tokenFactory.createSignItemToken("token3", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().insertPageBreakAndTokenAfter(idFreeTextLine, true, true, true, token3);

		SignItemToken token4 = tokenFactory.createSignItemToken("token4", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertTokenAfter(token3.getId(), token4, true, true);

		SignItemToken token5 = tokenFactory.createSignItemToken("token5", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertTokenAfter(token4.getId(), token5, true, true);

		Id freeTextLineId2 = getIdFactory().createId();
		String freeText2 = "FreeText 2";
		insertFreeTextLineAfter(token5.getId(), freeTextLineId2, freeText2, true);

		getDocumentLayouter().removeLineBreakAfter(idFreeTextLine);

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(4, getDocumentLayouter().getLineCount(0));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 3)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 2)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 3, 0)) instanceof FreeTextTokenBox);

		assertEquals(token1.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getId());
		assertEquals(freeText1, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 1))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 2))).getId());

		assertEquals(freeText2, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 0))).getText());

		SignItemToken token6 = tokenFactory.createSignItemToken("token6", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, token6);

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(5, getDocumentLayouter().getLineCount(0));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 3, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 3, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 4, 0)) instanceof FreeTextTokenBox);

		assertEquals(token1.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getId());
		assertEquals(freeText1, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 0))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 1))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 2))).getId());

		assertEquals(freeText2, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 4, 0))).getText());

		getDocumentLayouter().removeLineBreakAfter(token3.getId());

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(4, getDocumentLayouter().getLineCount(0));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(0, 2)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 3)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 2, 2)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 3, 0)) instanceof FreeTextTokenBox);

		assertEquals(token1.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getId());
		assertEquals(freeText1, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 0))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 1))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 2))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 2, 3))).getId());

		assertEquals(freeText2, ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 3, 0))).getText());
	}

	public void testRemoveLineBreakAfter() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);

		String freeText1 = "first free text";
		Id freeTextId1 = getIdFactory().createId();
		insertFreeTextLineAfter(token1.getId(), freeTextId1, freeText1, true);

		SignItemToken token3 = tokenFactory.createSignItemToken("token3", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().insertPageBreakAndTokenAfter(freeTextId1, true, true, true, token3);

		SignItemToken token4 = tokenFactory.createSignItemToken("token4", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertTokenAfter(token3.getId(), token4, true, true);

		SignItemToken token5 = tokenFactory.createSignItemToken("token5", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().insertLineBreakAndTokenAfter(token4.getId(), true, true, token5);

		SignItemToken token6 = tokenFactory.createSignItemToken("token6", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertTokenAfter(token5.getId(), token6, true, true);

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getLineCount(1));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(1, 1)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 1)) instanceof SignItemTokenBox);

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 1))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 0))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 1))).getId());

		getDocumentLayouter().removeLineBreakAfter(token4.getId());

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getLineCount(1));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 2)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 3)) instanceof SignItemTokenBox);

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 1))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 2))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 3))).getId());

		SignItemToken token7 = tokenFactory.createSignItemToken("token7", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().insertLineBreakAndTokenAfter(token3.getId(), true, true, token7);

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getLineCount(1));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
		assertEquals(4, getDocumentLayouter().getBoxCount(new LineIndex(1, 1)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 2)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 3)) instanceof SignItemTokenBox);

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token7.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 1))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 2))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 3))).getId());

		getDocumentLayouter().removeLineBreakAfter(token3.getId());

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(1, getDocumentLayouter().getLineCount(1));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(5, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 1)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 2)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 3)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 4)) instanceof SignItemTokenBox);

		assertEquals(token3.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token7.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 1))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 2))).getId());
		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 3))).getId());
		assertEquals(token6.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 4))).getId());

	}

	@Test
	public void testClear() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token1, true, true);
		String freeText1 = "first free text";
		insertFreeTextLineAfter(token1.getId(), getIdFactory().createId(), freeText1, true);

		String token2Word = "token2";
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		String freeText2 = "second free text";
		getDocumentLayouter().insertPageBreakAndTokenAfter(token1.getId(), true, true, true, token2);
		insertFreeTextLineAfter(token2.getId(), getIdFactory().createId(), freeText2, true);

		String token3Word = "token3";
		SignItemToken token3 = tokenFactory.createSignItemToken(token3Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		String freeText3 = "third free text";
		getDocumentLayouter().insertLineBreakAndTokenAfter(token1.getId(), true, true, token3);
		insertFreeTextLineAfter(token3.getId(), getIdFactory().createId(), freeText3, true);

		String token4Word = "token4";
		SignItemToken token4 = tokenFactory.createSignItemToken(token4Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		String token5Word = "token5";
		SignItemToken token5 = tokenFactory.createSignItemToken(token5Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().insertTokenAfter(token1.getId(), token4, true, true);
		String freeText4 = "fourth free text";
		getDocumentLayouter().insertPageBreakAndTokenAfter(token1.getId(), true, true, true, token5);
		insertFreeTextLineAfter(token5.getId(), getIdFactory().createId(), freeText4, true);

		assertEquals(3, getDocumentLayouter().getPageCount());
		assertEquals(1, getDocumentLayouter().getLineCount(0));
		assertEquals(5, getDocumentLayouter().getLineCount(1));
		assertEquals(3, getDocumentLayouter().getLineCount(2));

		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 2)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 3)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 4)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(2, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(2, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(2, 2)));

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 0, 0)) instanceof SignItemTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 0)) instanceof FreeTextTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 2, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 3, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 4, 0)) instanceof FreeTextTokenBox);

		assertTrue(getDocumentLayouter().getBox(new BoxIndex(2, 0, 0)) instanceof SignItemTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(2, 1, 0)) instanceof FreeTextTokenBox);
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(2, 2, 0)) instanceof FreeTextTokenBox);

		assertEquals(token5.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getId());
		assertEquals(token4.getId(), ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 2, 0))).getId());

		getDocumentLayouter().clear();

		assertEquals(0, getDocumentLayouter().getPageCount());
	}

	@Test
	public void testFindTokenBoxesInPages() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();

		List<Id> tokenIdsOnFirstPage = new ArrayList<Id>();
		for (int i = 0; i < 4; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIdsOnFirstPage.add(token.getId());
		}
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();

		List<Id> tokenIdsOnSecondPage = new ArrayList<Id>();
		for (int i = 4; i < 8; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIdsOnSecondPage.add(token.getId());
		}
		SignItemToken lastToken = tokenFactory.createSignItemToken("token 5", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(lastToken, true, true);
		insertFreeTextLineAfter(lastToken.getId(), getIdFactory().createId(),
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.  Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.   Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.   Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.   Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis.   At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum. sanctus sea sed takimata ut vero voluptua. est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.   Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus.    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.    Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.    Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo"
						+ "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.  Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.   Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.   Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.   Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis.   At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt justo labore Stet clita ea et gubergren, kasd magna no rebum. sanctus sea sed takimata ut vero voluptua. est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.   Consetetur ",
				true);
		assertTrue(getDocumentLayouter().isOnLastPageWithTokenBoxes(lastToken.getId()));
		assertFalse(getDocumentLayouter().isOnFirstPageWithTokenBoxes(lastToken.getId()));
		for (Id tokenId : tokenIdsOnFirstPage) {
			assertTrue(getDocumentLayouter().isOnFirstPageWithTokenBoxes(tokenId));
			assertFalse(getDocumentLayouter().isOnLastPageWithTokenBoxes(tokenId));
		}
		for (Id tokenId : tokenIdsOnSecondPage) {
			assertFalse(getDocumentLayouter().isOnFirstPageWithTokenBoxes(tokenId));
			assertTrue(getDocumentLayouter().isOnLastPageWithTokenBoxes(tokenId));
		}

		assertEquals(tokenIdsOnFirstPage.get(0),
				getDocumentLayouter().getFirstTokenIdFromPreviousPage(tokenIdsOnSecondPage.get(0)));
		assertEquals(tokenIdsOnSecondPage.get(0),
				getDocumentLayouter().getNextTokenIdNotOnThisPage(tokenIdsOnFirstPage.get(0)));
	}

	@Test
	public void testRemoveBoxesBetweenWholeLine() {
		// Remove whole line

		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();

		List<Id> tokenIds = new ArrayList<Id>();
		for (int i = 0; i < 4; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIds.add(token.getId());
		}
		SignItemToken lastToken = tokenFactory.createSignItemToken("token 5", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(lastToken, true, true);
		insertFreeTextLineAfter(lastToken.getId(), getIdFactory().createId(), "free text", true);

		getDocumentLayouter().removeBoxesBetween(tokenIds.get(0), lastToken.getId());
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals("token 0", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());
		assertEquals("token 5", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());
	}

	@Test
	public void testRemoveBoxesBetweenOverMultiplePages() {
		List<Id> tokenIds;
		getDocumentLayouter().addPage(
				new PageFormat("Testformat", Orientation.VERTICAL, PageFormat.DEFAULT_DPI, 990, 1401, 30, 30, 50, 30));
		getDocumentLayouter().addNewLine();

		tokenIds = new ArrayList<Id>();
		for (int i = 0; i < 10; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIds.add(token.getId());
		}
		insertFreeTextLineAfter(tokenIds.get(tokenIds.size() - 1), getIdFactory().createId(), "free text 1", true);
		SignItemToken firstTokenOnPage2 = tokenFactory.createSignItemToken("token " + tokenIds.size(),
				getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS);

		getDocumentLayouter().insertPageBreakAndTokenAfter(tokenIds.get(tokenIds.size() - 1), true, true, true,
				firstTokenOnPage2);
		insertFreeTextLineAfter(firstTokenOnPage2.getId(), getIdFactory().createId(), "free text 2", true);
		tokenIds.add(firstTokenOnPage2.getId());
		for (int i = 11; i < 20; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIds.add(token.getId());
		}
		insertFreeTextLineAfter(tokenIds.get(tokenIds.size() - 1), getIdFactory().createId(), "free text 3", true);

		assertEquals(20, tokenIds.size());

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(5, getDocumentLayouter().getLineCount(1));

		// Page 0, Line 0
		assertEquals("token 0", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());
		assertEquals("token 1", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());
		assertEquals("token 2", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 2))).getText());
		assertEquals("token 3", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 3))).getText());
		assertEquals("token 4", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 4))).getText());
		assertEquals("token 5", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 5))).getText());
		assertEquals("token 6", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 6))).getText());
		assertEquals("token 7", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 7))).getText());
		assertEquals("token 8", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 8))).getText());

		// Page 0, Line 1
		assertEquals("token 9", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		// Page 0, Line 2
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 4, 0)) instanceof FreeTextTokenBox);
		assertEquals("free text 3", ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 4, 0))).getText());

		// Page 1, Line 0
		assertEquals("token 10", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 0, 0))).getText());

		// Page 1, Line 1
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 2, 0)) instanceof FreeTextTokenBox);
		assertEquals("free text 1", ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 2, 0))).getText());

		// Page 1, Line 2
		assertEquals("token 11", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 0))).getText());
		assertEquals("token 12", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 1))).getText());
		assertEquals("token 13", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 2))).getText());
		assertEquals("token 14", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 3))).getText());
		assertEquals("token 15", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 4))).getText());
		assertEquals("token 16", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 5))).getText());
		assertEquals("token 17", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 6))).getText());
		assertEquals("token 18", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 7))).getText());
		assertEquals("token 19", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 3, 8))).getText());

		// Page 1, Line 3
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(1, 1, 0)) instanceof FreeTextTokenBox);
		assertEquals("free text 2", ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(1, 1, 0))).getText());

		assertEquals(2, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(5, getDocumentLayouter().getLineCount(1));
		assertEquals(9, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 1)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 2)));
		assertEquals(9, getDocumentLayouter().getBoxCount(new LineIndex(1, 3)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(1, 4)));

		getDocumentLayouter().removeBoxesBetween(tokenIds.get(3), tokenIds.get(17));

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(7, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));

		assertEquals("token 0", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());
		assertEquals("token 1", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());
		assertEquals("token 2", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 2))).getText());
		assertEquals("token 3", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 3))).getText());
		assertEquals("token 17", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 4))).getText());
		assertEquals("token 18", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 5))).getText());
		assertEquals("token 19", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 6))).getText());
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);
		assertEquals("free text 3", ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		// Remove remaining token boxes except for first and last
		getDocumentLayouter().removeBoxesBetween(tokenIds.get(0), tokenIds.get(tokenIds.size() - 1));

		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals("token 0", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());
		assertEquals("token 19", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());
		assertTrue(getDocumentLayouter().getBox(new BoxIndex(0, 1, 0)) instanceof FreeTextTokenBox);
		assertEquals("free text 3", ((FreeTextTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 1, 0))).getText());

		Id idToRemove = getIdFactory().createId();
		SignItemToken tokenToRemove = tokenFactory.createSignItemToken("newToken", null, idToRemove,
				getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS, false, false);
		getDocumentLayouter().insertBox(new SignItemTokenBox(tokenToRemove, true, true, getFontSizeService()),
				new BoxIndex(0, 0, 1));
		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(3, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
		assertEquals("newToken", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());

		getDocumentLayouter().removeTokenBox(idToRemove);
		assertEquals(1, getDocumentLayouter().getPageCount());
		assertEquals(2, getDocumentLayouter().getLineCount(0));
		assertEquals(2, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals(1, getDocumentLayouter().getBoxCount(new LineIndex(0, 1)));
	}

	@Test
	public void testRemoveBoxesBetweenOverMultipleLines() {
		List<Id> tokenIds;
		SignItemToken lastToken;
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();

		tokenIds = new ArrayList<Id>();
		for (int i = 0; i < 10; i++) {
			String tokenWord = "token " + i;
			SignItemToken token = tokenFactory.createSignItemToken(tokenWord, getDefaultTokenStyle(), Color.WHITE,
					SignLocale.DGS);
			getDocumentLayouter().addToken(token, true, true);
			tokenIds.add(token.getId());
		}
		lastToken = tokenFactory.createSignItemToken("token 10", getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addToken(lastToken, true, true);
		insertFreeTextLineAfter(lastToken.getId(), getIdFactory().createId(), "free text", true);

		getDocumentLayouter().removeBoxesBetween(tokenIds.get(3), tokenIds.get(8));
		assertEquals(7, getDocumentLayouter().getBoxCount(new LineIndex(0, 0)));
		assertEquals("token 0", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0))).getText());
		assertEquals("token 1", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 1))).getText());
		assertEquals("token 2", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 2))).getText());
		assertEquals("token 3", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 3))).getText());
		assertEquals("token 8", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 4))).getText());
		assertEquals("token 9", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 5))).getText());
		assertEquals("token 10", ((SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 6))).getText());
	}

	@Test
	public void testElementPositions() {

		SignItemToken token1 = tokenFactory.createSignItemToken("token1", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token4 = tokenFactory.createSignItemToken("token4", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token5 = tokenFactory.createSignItemToken("token5", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token6 = tokenFactory.createSignItemToken("token6", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token7 = tokenFactory.createSignItemToken("token7", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token8 = tokenFactory.createSignItemToken("token8", getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		getDocumentLayouter().addToken(token1, true, true);
		String freeText1 = "first free text";
		Id freeText1Id = getIdFactory().createId();
		insertFreeTextLineAfter(token1.getId(), freeText1Id, freeText1, true);

		String freeText2 = "second free text";
		getDocumentLayouter().insertPageBreakAndTokenAfter(token1.getId(), true, true, true, token2);
		insertFreeTextLineAfter(token2.getId(), getIdFactory().createId(), freeText2, true);

		String freeText3 = "third free text";
		getDocumentLayouter().insertLineBreakAndTokenAfter(token1.getId(), true, true, token3);
		insertFreeTextLineAfter(token3.getId(), getIdFactory().createId(), freeText3, true);

		getDocumentLayouter().insertTokenAfter(token1.getId(), token4, true, true);
		String freeText4 = "fourth free text";
		getDocumentLayouter().insertPageBreakAndTokenAfter(token1.getId(), true, true, true, token5);
		insertFreeTextLineAfter(token5.getId(), getIdFactory().createId(), freeText4, true);

		assertTrue(getDocumentLayouter().isInFirstTokenBoxLine(token1.getId()));
		assertFalse(getDocumentLayouter().isInFirstTokenBoxLine(token2.getId()));
		assertFalse(getDocumentLayouter().isInFirstTokenBoxLine(token3.getId()));
		assertFalse(getDocumentLayouter().isInFirstTokenBoxLine(token4.getId()));

		assertTrue(getDocumentLayouter().isInLastTokenBoxLine(freeText1Id));
		assertFalse(getDocumentLayouter().isInLastTokenBoxLine(token2.getId()));
		assertFalse(getDocumentLayouter().isInLastTokenBoxLine(token1.getId()));
		assertFalse(getDocumentLayouter().isInLastTokenBoxLine(token3.getId()));
		assertFalse(getDocumentLayouter().isInLastTokenBoxLine(token4.getId()));

		assertEquals(token1.getId(), getDocumentLayouter().getFirstTokenIdInLine(token1.getId()));
		assertEquals(token1.getId(), getDocumentLayouter().getLastTokenIdInLine(token1.getId()));

		assertEquals(token5.getId(), getDocumentLayouter().getFirstTokenIdInLine(token5.getId()));
		assertEquals(token4.getId(), getDocumentLayouter().getFirstTokenIdInLine(token4.getId()));
		assertEquals(token5.getId(), getDocumentLayouter().getLastTokenIdInLine(token5.getId()));
		assertEquals(token4.getId(), getDocumentLayouter().getLastTokenIdInLine(token4.getId()));

		getDocumentLayouter().insertTokenAfter(token4.getId(), token6, true, true);
		getDocumentLayouter().insertTokenAfter(token3.getId(), token7, true, true);
		getDocumentLayouter().insertTokenAfter(token3.getId(), token8, true, true);
	}

	@Test
	public void testSignRelatedOperations() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		String token2Word = "token2";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().addToken(token1, true, true);
		getDocumentLayouter().addToken(token2, true, true);

		SignItem sign1 = new SignItem(new SignId(1, "sign1", SignLocale.DGS, SignSource.DELEGS), 70);
		SignItem sign2 = new SignItem(new SignId(2, "sign2", SignLocale.DGS, SignSource.DELEGS), 89);
		ArrayList<SignItem> signItems = new ArrayList<SignItem>();
		signItems.add(sign1);
		signItems.add(sign2);

		getDocumentLayouter().updateSignsInTokenBox(token1.getId(), signItems, 0);

		SignItemTokenBox firstTokenBox = (SignItemTokenBox) getDocumentLayouter().getBox(new BoxIndex(0, 0, 0));
		assertEquals(signItems, firstTokenBox.getSignItems());
		assertEquals(0, firstTokenBox.getSelectedSignIndex());
		assertEquals(sign1, firstTokenBox.getSelectedSign());

		getDocumentLayouter().changeSignAlternativeFor(token1.getId(), 1);
		assertEquals(signItems, firstTokenBox.getSignItems());
		assertEquals(1, firstTokenBox.getSelectedSignIndex());
		assertEquals(sign2, firstTokenBox.getSelectedSign());
	}

	@Test
	public void testFreeTextBox() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		String token2Word = "token2";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().addToken(token1, true, true);
		getDocumentLayouter().addToken(token2, true, true);

		Id paragraphId = getIdFactory().createId();
		String freeText = "My free text";
		insertFreeTextLineAfter(token2.getId(), paragraphId, freeText, false);
		BoxIndex freeTextBoxIndex = getDocumentLayouter().getIdBoxIndex(paragraphId);
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) getDocumentLayouter().getBox(freeTextBoxIndex);
		getDocumentLayouter().setFreeTextBoxVisibility(paragraphId, false);
		assertFalse(freeTextBox.isVisible());

		getDocumentLayouter().setFreeTextBoxVisibility(paragraphId, true);
		assertTrue(freeTextBox.isVisible());

		getDocumentLayouter().setFreeTextBoxVisibility(paragraphId, false);
		assertFalse(freeTextBox.isVisible());

		assertEquals(freeText, freeTextBox.getText());

		String token3Word = "token3";
		SignItemToken token3 = tokenFactory.createSignItemToken(token3Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		getDocumentLayouter().addToken(token3, true, true);
		Id nextParagraphId = getIdFactory().createId();
		String nextFreeText = "next free text";
		insertFreeTextLineAfter(token3.getId(), nextParagraphId, nextFreeText, true);
	}

	@Test
	@Ignore
	public void testMergeFreeTextLines() {
		// Removed due to removal of function
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		String token1Word = "token1";
		String token2Word = "token2";
		SignItemToken token1 = tokenFactory.createSignItemToken(token1Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken(token2Word, getDefaultTokenStyle(), Color.WHITE,
				SignLocale.DGS);

		getDocumentLayouter().addToken(token1, true, true);
		getDocumentLayouter().addToken(token2, true, true);

		Id paragraphId = getIdFactory().createId();
		String freeText = "My free text";
		insertFreeTextLineAfter(token1.getId(), paragraphId, freeText, false);

		Id paragraphId2 = getIdFactory().createId();
		String freeText2 = "My free text";
		insertFreeTextLineAfter(token2.getId(), paragraphId2, freeText2, false);

		getDocumentLayouter().removeTokenBox(token2.getId());

		BoxIndex freeTextBoxIndex = getDocumentLayouter().getIdBoxIndex(paragraphId);
		FreeTextTokenBox freeTextBox = (FreeTextTokenBox) getDocumentLayouter().getBox(freeTextBoxIndex);
		assertEquals(freeText + freeText2, freeTextBox.getText());
	}

	@Test
	public void testUpdateSnippetPosition() {
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		getDocumentLayouter().addNewLine();
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT, true, getIdFactory().createId(), true);
		getDocumentLayouter().insertSnippet(1, 0, 10, 10, 0, 100);

		assertEquals(10, ((SnippetLayout) getDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(10, ((SnippetLayout) getDocumentLayouter().getSnippet(1, 0)).getY_PX());

		getDocumentLayouter().updateSnippetPosition(1, 0, 100, 100);

		assertEquals(100, ((SnippetLayout) getDocumentLayouter().getSnippet(1, 0)).getX_PX());
		assertEquals(100, ((SnippetLayout) getDocumentLayouter().getSnippet(1, 0)).getY_PX());
	}

	@Test
	public void testUpdateTokenBox() {
		// prepare
		getDocumentLayouter().addPage(PageFormat.A4_PORTRAIT);
		for (int i = 0; i < 6; i++) {
			getDocumentLayouter().addNewLine();
			getDocumentLayouter().addToken(
					tokenFactory.createEmptySignItemToken(getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS), true,
					true);
		}
		Token lastToken = tokenFactory.createEmptySignItemToken(getDefaultTokenStyle(), Color.WHITE, SignLocale.DGS);
		getDocumentLayouter().addNewLine();
		getDocumentLayouter().addToken(lastToken, true, true);

		// action
		getDocumentLayouter().updateTokenBox(lastToken.getId());

		// check
		assertEquals(2, getDocumentLayouter().getPageCount());

		ContinuousPageLayout page = (ContinuousPageLayout) getDocumentLayouter().getPage(1);
		assertEquals(1, page.getLineCount());
		assertEquals(1, page.getLine(0).getBoxCount());
		Box box = page.getLine(0).getBox(0);
		assertTrue(box instanceof TokenBox);
		assertEquals(lastToken.getId(), ((TokenBox) box).getId());
	}

	private void insertFreeTextLineAfter(Id previousToken, Id freeTextLineId, String freeText, boolean visibile) {

		FreeTextToken freeTextToken = tokenFactory.createFreeTextToken(freeTextLineId, getDefaultTokenStyle());
		freeTextToken.setText(freeText);
		BoxIndex index = getDocumentLayouter().getIdBoxIndex(previousToken);
		int width = getDocumentLayouter().getPage(index.getPageIndex()).getMaxWidth();
		freeTextToken.setWidth(width);
		freeTextToken.setIsFreeTextLine(true);
		getDocumentLayouter().insertTokenAfter(previousToken, freeTextToken, visibile, visibile);
	}

}
