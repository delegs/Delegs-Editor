package de.signWritingEditor.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.Tokenizer;

public class TokenizerTest {

	@Test
	public void testTokenize() {
		Tokenizer tokenizer = new Tokenizer();

		List<String> tokenStrings = tokenizer.tokenize("");

		assertNotNull(tokenStrings);

		List<String> expectedTokenStrings = new ArrayList<String>();
		expectedTokenStrings.add("");

		testLists(tokenStrings, expectedTokenStrings);

		List<String> tokenStrings2 = tokenizer
				.tokenize(" wort1 \nwort2! wort3.;,?! wort4  !wort5\n\n wort6\fwort7\f\fwort8 ");

		assertNotNull(tokenStrings2);

		List<String> expectedTokenStrings2 = new ArrayList<String>();
		expectedTokenStrings2.add("");
		expectedTokenStrings2.add("wort1");
		expectedTokenStrings2.add("\n");
		expectedTokenStrings2.add("wort2");
		expectedTokenStrings2.add("!");
		expectedTokenStrings2.add("wort3");
		expectedTokenStrings2.add(".");
		expectedTokenStrings2.add(";");
		expectedTokenStrings2.add(",");
		expectedTokenStrings2.add("?");
		expectedTokenStrings2.add("!");
		expectedTokenStrings2.add("wort4");
		expectedTokenStrings2.add("");
		expectedTokenStrings2.add("!");
		expectedTokenStrings2.add("wort5");
		expectedTokenStrings2.add("\n");
		expectedTokenStrings2.add("");
		expectedTokenStrings2.add("\n");
		expectedTokenStrings2.add("");
		expectedTokenStrings2.add("wort6");
		expectedTokenStrings2.add("\f");
		expectedTokenStrings2.add("wort7");
		expectedTokenStrings2.add("\f");
		expectedTokenStrings2.add("");
		expectedTokenStrings2.add("\f");
		expectedTokenStrings2.add("wort8");
		expectedTokenStrings2.add("");

		testLists(expectedTokenStrings2, tokenStrings2);

		List<String> tokenStrings3 = tokenizer.tokenize("\nwort\n");

		assertNotNull(tokenStrings3);

		List<String> expectedTokenStrings3 = new ArrayList<String>();
		expectedTokenStrings3.add("");
		expectedTokenStrings3.add("\n");
		expectedTokenStrings3.add("wort");
		expectedTokenStrings3.add("\n");
		expectedTokenStrings3.add("");

		testLists(tokenStrings3, expectedTokenStrings3);
	}

	private void testLists(List<String> expectedTokens, List<String> tokenStrings) {
		assertEquals(expectedTokens.size(), tokenStrings.size());

		for (int i = 0; i < tokenStrings.size(); i++) {
			assertEquals(expectedTokens.get(i), tokenStrings.get(i));
		}
	}

	@Test
	public void testTokenizeStartingWithSpezialCharacter() {
		Tokenizer tokenizer = new Tokenizer();

		List<String> tokens = tokenizer.tokenize(", word ,");

		assertNotNull(tokens);

		List<String> expectedTokens = new ArrayList<String>();
		expectedTokens.add(",");
		expectedTokens.add("word");
		expectedTokens.add(",");

		testLists(tokens, expectedTokens);
	}

	@Test
	public void testIsVisibleSpecialCharacter() {
		assertTrue(Tokenizer.isVisibleSpecialCharacter(','));
		assertTrue(Tokenizer.isVisibleSpecialCharacter(';'));
		assertTrue(Tokenizer.isVisibleSpecialCharacter('.'));
		assertTrue(Tokenizer.isVisibleSpecialCharacter('?'));

		assertFalse(Tokenizer.isVisibleSpecialCharacter(' '));
		assertFalse(Tokenizer.isVisibleSpecialCharacter('\n'));
		assertFalse(Tokenizer.isVisibleSpecialCharacter('\f'));
	}

	@Test
	public void testIsInvisibleSpecialCharacter() {
		assertFalse(Tokenizer.isInvisibleSpecialCharacter(','));
		assertFalse(Tokenizer.isInvisibleSpecialCharacter(';'));
		assertFalse(Tokenizer.isInvisibleSpecialCharacter('.'));
		assertFalse(Tokenizer.isInvisibleSpecialCharacter('?'));

		assertTrue(Tokenizer.isInvisibleSpecialCharacter('\n'));
		assertTrue(Tokenizer.isInvisibleSpecialCharacter('\f'));
		assertTrue(Tokenizer.isInvisibleSpecialCharacter(' '));
	}
}
