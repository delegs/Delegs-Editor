package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.infrastructure.UnitTestCase;

public class TokenizerTest extends UnitTestCase {

	private Tokenizer tokenizer;

	@Before
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}

	@Test
	public void testTokenizeStringWithoutLineOrPageBreak() {
		String testString = "Cult of the Dead Cow";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		// Test
		assertEquals(5, tokens.size());
		assertEquals("Cult", tokens.get(0));
		assertEquals("of", tokens.get(1));
		assertEquals("the", tokens.get(2));
		assertEquals("Dead", tokens.get(3));
		assertEquals("Cow", tokens.get(4));
	}

	@Test
	public void testTokenizeStringWithLineBreak() {
		String testString = "Lächeln und winken Private" + '\n' + "Lächeln und winken";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		// Test
		assertEquals(8, tokens.size());
		assertEquals("Lächeln", tokens.get(0));
		assertEquals("und", tokens.get(1));
		assertEquals("winken", tokens.get(2));
		assertEquals("Private", tokens.get(3));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(4));
		assertEquals("Lächeln", tokens.get(5));
		assertEquals("und", tokens.get(6));
		assertEquals("winken", tokens.get(7));
	}

	@Test
	public void testTokenizeStringWithPageBreak() {
		String testString = "Lächeln und winken Private" + Tokenizer.PAGE_BREAK + "Lächeln und winken";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(8, tokens.size());
		assertEquals("Lächeln", tokens.get(0));
		assertEquals("und", tokens.get(1));
		assertEquals("winken", tokens.get(2));
		assertEquals("Private", tokens.get(3));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(4));
		assertEquals("Lächeln", tokens.get(5));
		assertEquals("und", tokens.get(6));
		assertEquals("winken", tokens.get(7));
	}

	@Test
	public void testTokenizeStringWithLineAndPageBreak() {
		String testString = "Lächeln und winken Private" + Tokenizer.PAGE_BREAK//
				+ "Lächeln und winken" + '\n' + "Neue Seite";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(11, tokens.size());
		assertEquals("Lächeln", tokens.get(0));
		assertEquals("und", tokens.get(1));
		assertEquals("winken", tokens.get(2));
		assertEquals("Private", tokens.get(3));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(4));
		assertEquals("Lächeln", tokens.get(5));
		assertEquals("und", tokens.get(6));
		assertEquals("winken", tokens.get(7));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(8));
		assertEquals("Neue", tokens.get(9));
		assertEquals("Seite", tokens.get(10));
	}

	@Test
	public void testTokenizeStringWithDoubelLineBreak() {
		String testString = "Line 1" + '\n' + '\n' + "Line 3";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(7, tokens.size());
		assertEquals("Line", tokens.get(0));
		assertEquals("1", tokens.get(1));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(2));
		assertEquals("", tokens.get(3));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(4));
		assertEquals("Line", tokens.get(5));
		assertEquals("3", tokens.get(6));
	}

	@Test
	public void testTokenizeStringWithDoubelPageBreak() {
		String testString = "Page 1" + Tokenizer.PAGE_BREAK + Tokenizer.PAGE_BREAK + "Page 3";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(7, tokens.size());
		assertEquals("Page", tokens.get(0));
		assertEquals("1", tokens.get(1));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(2));
		assertEquals("", tokens.get(3));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(4));
		assertEquals("Page", tokens.get(5));
		assertEquals("3", tokens.get(6));
	}

	@Test
	public void testTokenizeStringSpaceAtTheEnd() {
		String testString = "Test" + Tokenizer.BOX_BREAK;

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(2, tokens.size());
		assertEquals("Test", tokens.get(0));
		assertEquals("", tokens.get(1));
	}

	@Test
	public void testTokenizeStringLineBreakAtTheEnd() {
		String testString = "Test" + Tokenizer.LINE_BREAK;

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("Test", tokens.get(0));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(1));
		assertEquals("", tokens.get(2));
	}

	@Test
	public void testTokenizeStringPageBreakAtTheEnd() {
		String testString = "Test" + Tokenizer.PAGE_BREAK;

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("Test", tokens.get(0));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(1));
		assertEquals("", tokens.get(2));
	}

	@Test
	public void testTokenizeStringSpaceAtTheBegin() {
		String testString = Tokenizer.BOX_BREAK + "Test";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(2, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("Test", tokens.get(1));
	}

	@Test
	public void testTokenizeStringLineBreakAtTheBegin() {
		String testString = Tokenizer.LINE_BREAK + "Test";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(1));
		assertEquals("Test", tokens.get(2));
	}

	@Test
	public void testTokenizeStringPageBreakAtTheBegin() {
		String testString = Tokenizer.PAGE_BREAK + "Test";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(1));
		assertEquals("Test", tokens.get(2));
	}

	@Test
	public void testTokenizeStringOnlySpaceBreak() {
		String testString = " ";

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(2, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("", tokens.get(1));
	}

	@Test
	public void testTokenizeStringOnlyLineBreak() {
		String testString = "" + Tokenizer.LINE_BREAK;

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("" + Tokenizer.LINE_BREAK, tokens.get(1));
		assertEquals("", tokens.get(2));
	}

	@Test
	public void testTokenizeStringOnlyPageBreak() {
		String testString = "" + Tokenizer.PAGE_BREAK;

		// Action
		List<String> tokens = getTokenizer().tokenize(testString);

		assertEquals(3, tokens.size());
		assertEquals("", tokens.get(0));
		assertEquals("" + Tokenizer.PAGE_BREAK, tokens.get(1));
		assertEquals("", tokens.get(2));
	}

	public Tokenizer getTokenizer() {
		return tokenizer;
	}

}
