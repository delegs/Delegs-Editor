package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.Section;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class SectionTest {

	private IdFactory idFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private TokenFactory tokenFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(5);
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
	}

	@Test
	public void testSection() {
		Section section = new Section();
		assertTrue(section.isEmpty());
		assertEquals(0, section.getParagraphCount());

		Paragraph paragraph0 = new Paragraph(idFactory.createId());
		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		section.addParagraph(paragraph0);
		section.addParagraph(paragraph1);
		section.addParagraph(paragraph2);
		assertEquals(paragraph0, section.getParagraph(0));
		assertEquals(paragraph1, section.getParagraph(1));
		assertEquals(paragraph2, section.getParagraph(2));

		Paragraph paragraph4 = new Paragraph(idFactory.createId());
		paragraph4.setFreeTextLineVisible(false);
		section.insertParagraph(paragraph4, 1);
		assertEquals(paragraph4, section.getParagraph(1));

		section.removeParagraph(1);
		assertFalse(paragraph4.equals(section.getParagraph(1)));
	}

	@Test
	public void testMoveParagraphsToSection() {
		Section section1 = new Section();
		Section section2 = new Section();
		Paragraph paragraph0 = new Paragraph(idFactory.createId());
		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		section1.addParagraph(paragraph0);
		section1.addParagraph(paragraph1);
		section1.addParagraph(paragraph2);

		section1.moveParagraphsToSection(section2, 1);
		assertEquals(1, section1.getParagraphCount());
		assertEquals(2, section2.getParagraphCount());

		assertEquals(paragraph0, section1.getParagraph(0));
		assertEquals(paragraph1, section2.getParagraph(0));
		assertEquals(paragraph2, section2.getParagraph(1));

		section1.moveParagraphsToSection(section2, 0);
		assertTrue(section1.isEmpty());
		assertEquals(paragraph0, section2.getParagraph(0));
		assertEquals(paragraph1, section2.getParagraph(1));
		assertEquals(paragraph2, section2.getParagraph(2));

		// move all at once
		section2.moveParagraphsToSection(section1, 0);
		assertTrue(section2.isEmpty());
		assertEquals(paragraph0, section1.getParagraph(0));
		assertEquals(paragraph1, section1.getParagraph(1));
		assertEquals(paragraph2, section1.getParagraph(2));

		// move 1 by 1
		section1.moveParagraphsToSection(section2, 2);
		section1.moveParagraphsToSection(section2, 1);
		section1.moveParagraphsToSection(section2, 0);
		assertTrue(section1.isEmpty());
		assertEquals(paragraph0, section2.getParagraph(0));
		assertEquals(paragraph1, section2.getParagraph(1));
		assertEquals(paragraph2, section2.getParagraph(2));
	}

	@Test
	public void testMergeParagraphWithNext() {
		Section section = new Section();
		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		Paragraph paragraph3 = new Paragraph(idFactory.createId());
		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token4 = tokenFactory.createSignItemToken("token4",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token5 = tokenFactory.createSignItemToken("token5",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		paragraph1.addToken(token1);
		paragraph1.addToken(token2);
		paragraph2.addToken(token3);
		paragraph2.addToken(token4);
		paragraph3.addToken(token5);
		section.addParagraph(paragraph1);
		section.addParagraph(paragraph2);
		section.addParagraph(paragraph3);
		assertEquals(3, section.getParagraphCount());
		section.mergeParagraphWithNext(0);
		section.mergeParagraphWithNext(0);
		assertEquals(1, section.getParagraphCount());
		assertEquals(token1, section.getParagraph(0).getToken(0));
		assertEquals(token2, section.getParagraph(0).getToken(1));
		assertEquals(token3, section.getParagraph(0).getToken(2));
		assertEquals(token4, section.getParagraph(0).getToken(3));
		assertEquals(token5, section.getParagraph(0).getToken(4));
	}

	@Test
	public void testInsertParagraph() {
		Section section = new Section();
		Paragraph firstParagraph = new Paragraph(idFactory.createId());
		section.addParagraph(firstParagraph);
		section.getParagraph(0).addToken(tokenFactory.createSignItemToken("word1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS));

		assertEquals(1, section.getParagraphCount());
		assertFalse(section.getParagraph(0).isEmpty());

		Paragraph secondParagraph = new Paragraph(idFactory.createId());
		section.insertParagraph(secondParagraph, 1);
		assertEquals(2, section.getParagraphCount());
		assertEquals(firstParagraph, section.getParagraph(0));
		assertEquals(secondParagraph, section.getParagraph(1));
		assertFalse(section.isEmpty());

		Paragraph middleParagraph = new Paragraph(idFactory.createId());
		section.insertParagraph(secondParagraph, 1);
		assertEquals(firstParagraph, section.getParagraph(0));
		assertEquals(middleParagraph, section.getParagraph(1));
		assertEquals(secondParagraph, section.getParagraph(2));

	}

	@Test
	public void testEquals() {
		Section section1 = new Section();
		Section section2 = new Section();
		assertEquals(section1, section2);
		assertTrue(section1.hashCode() == section2.hashCode());

		Paragraph paragraph1 = new Paragraph(idFactory.createId());
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		section1.addParagraph(paragraph1);
		section1.addParagraph(paragraph2);
		section2.addParagraph(paragraph1);

		assertFalse(section1.equals(section2));

		Section section3 = new Section();
		Paragraph otherParagraph1 = new Paragraph(idFactory.createId());
		Paragraph otherParagraph2 = new Paragraph(idFactory.createId());
		section3.addParagraph(otherParagraph1);
		section3.addParagraph(otherParagraph2);

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken otherToken1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken otherToken2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		paragraph1.addToken(token1);
		paragraph2.addToken(token2);

		assertFalse(section1.equals(section3));
		assertFalse(section3.equals(section1));

		otherParagraph1.addToken(otherToken1);
		otherParagraph2.addToken(otherToken2);

		testSectionContentEquality(section1, section3);

		assertFalse(section1.equals(null)); // null Pointer Test
		assertFalse(section1.equals(paragraph1)); // Class Test
	}

	private void testSectionContentEquality(Section expectedSection, Section actualSection) {
		assertEquals(expectedSection.getParagraphCount(), actualSection.getParagraphCount());

		List<Paragraph> expectedParagraphs = expectedSection.getParagraphs();
		List<Paragraph> actualParagraphs = actualSection.getParagraphs();

		for (int i = 0; i < actualParagraphs.size(); i++) {
			testParagrahContentEquality(expectedParagraphs.get(i), actualParagraphs.get(i));
		}
	}

	private void testParagrahContentEquality(Paragraph expectedParagraph, Paragraph actualParagraph) {
		assertEquals(expectedParagraph.getPositionX(), actualParagraph.getPositionX());
		assertEquals(expectedParagraph.getPositionY(), actualParagraph.getPositionY());
		assertEquals(expectedParagraph.getZIndex(), actualParagraph.getZIndex());
		assertEquals(expectedParagraph.getWidth(), actualParagraph.getWidth());
		assertEquals(expectedParagraph.getTokenCount(), actualParagraph.getTokenCount());

		List<Token> expectedTokens = expectedParagraph.getTokens();
		List<Token> actualTokens = actualParagraph.getTokens();

		for (int i = 0; i < actualTokens.size(); i++) {
			testTokensContentEquality(expectedTokens.get(i), actualTokens.get(i));
		}
	}

	private void testTokensContentEquality(Token expectedToken, Token actualToken) {
		assertTrue(expectedToken.getClass().equals(actualToken.getClass()));
		if (expectedToken instanceof SignItemToken) {
			compareSignItemTokens((SignItemToken) expectedToken, (SignItemToken) actualToken);
		} else {
			assertTrue("Token type not implemented", false);
		}
	}

	private void compareSignItemTokens(SignItemToken expectedToken, SignItemToken actualToken) {
		assertEquals(expectedToken.getBackgroundColor(), actualToken.getBackgroundColor());
		assertEquals(expectedToken.getLocale(), actualToken.getLocale());
		assertEquals(expectedToken.getSignItem(), actualToken.getSignItem());
		assertEquals(expectedToken.getSignHeight_PX(), actualToken.getSignHeight_PX());
		assertEquals(expectedToken.getText(), actualToken.getText());
		assertEquals(expectedToken.getStyle(), actualToken.getStyle());
	}
}
