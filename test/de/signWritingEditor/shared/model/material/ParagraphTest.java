package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class ParagraphTest {

	private IdFactory idFactory;
	private Paragraph paragraphUnderTest;
	private TextbasedTokenStyleFactory styleFactory;
	private TokenFactory tokenFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(7);
		styleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);
		paragraphUnderTest = new Paragraph(idFactory.createId());
	}

	@Test
	public void testGetFreeTextLineTokenAfter() {
		// arrange
		SignItemToken token1 = tokenFactory.createSignItemToken("Token1",
				styleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("Token2",
				styleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("Token3",
				styleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token4 = tokenFactory.createSignItemToken("Token4",
				styleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		FreeTextToken freeTextLineToken = tokenFactory
				.createFreeTextLineToken(styleFactory.createDefaultTextbasedTokenStyle());
		paragraphUnderTest.addToken(token1);
		paragraphUnderTest.addToken(token2);
		paragraphUnderTest.addToken(token3);
		paragraphUnderTest.addToken(freeTextLineToken);
		paragraphUnderTest.addToken(token4);

		// act
		FreeTextToken freeTextLineTokenResult1 = paragraphUnderTest.getFreeTextLineTokenAfter(token1);
		FreeTextToken freeTextLineTokenResult2 = paragraphUnderTest.getFreeTextLineTokenAfter(token2);
		FreeTextToken freeTextLineTokenResult3 = paragraphUnderTest.getFreeTextLineTokenAfter(token3);
		FreeTextToken freeTextLineTokenResult4 = paragraphUnderTest.getFreeTextLineTokenAfter(freeTextLineToken);
		FreeTextToken freeTextLineTokenResult5 = paragraphUnderTest.getFreeTextLineTokenAfter(token4);

		// assert
		assertEquals(freeTextLineToken, freeTextLineTokenResult1);
		assertEquals(freeTextLineToken, freeTextLineTokenResult2);
		assertEquals(freeTextLineToken, freeTextLineTokenResult3);
		assertNull(freeTextLineTokenResult4);
		assertNull(freeTextLineTokenResult5);
	}

	@Test
	public void testGetFreeTextLineTokenAfter_EmptyParagraph() {

		// arrange
		SignItemToken searchedToken = tokenFactory.createSignItemToken("Token1",
				styleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		// act
		FreeTextToken freeTextLineTokenResult1 = paragraphUnderTest.getFreeTextLineTokenAfter(searchedToken);

		// assert

		assertNull(freeTextLineTokenResult1);
	}

	@Test
	public void testGetFreeTextLineTokenAfter_OneFreeTextLine() {

		// arrange
		FreeTextToken freeTextLineToken = tokenFactory
				.createFreeTextLineToken(styleFactory.createDefaultTextbasedTokenStyle());
		paragraphUnderTest.addToken(freeTextLineToken);

		// act
		FreeTextToken freeTextLineTokenResult = paragraphUnderTest.getFreeTextLineTokenAfter(freeTextLineToken);

		// assert

		assertNull(freeTextLineTokenResult);
	}
}
