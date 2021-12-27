package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Font;
import de.signWritingEditor.shared.model.domainValue.FontSize;
import de.signWritingEditor.shared.model.domainValue.FontStyle;
import de.signWritingEditor.shared.model.domainValue.FontWeight;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.FormToken;
import de.signWritingEditor.shared.model.material.ReadOnlyTextbasedTokenStyle;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FormTokenTest {

	private TokenFactory tokenFactory;
	private IdFactory idFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;

	@Before
	public void setUp() {
		idFactory = new IdFactory(0);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();
		tokenFactory = new TokenFactory(idFactory);
	}

	@Test
	public void testHashCode() {
		// Prepare
		Token token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		Token token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");
		// Check
		assertFalse(token1.hashCode() == token2.hashCode());
		assertFalse(token1.getId().equals(token2.getId()));
	}

	@Test
	public void testEquals() {
		// Prepare
		Token token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), "");
		Token token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), "");
		// Check
		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId().equals(token2.getId()));
	}

	@Test
	public void testBackgroundColor() {
		// Prepare
		Token token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		Token token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");
		Color bg1 = Color.WHITE;
		Color bg2 = Color.RED;

		// Action
		token1.setBackgroundColor(bg1);
		token2.setBackgroundColor(bg2);

		// Check
		assertEquals(bg1, token1.getBackgroundColor());
		assertEquals(bg2, token2.getBackgroundColor());

		assertFalse(token1.getBackgroundColor().equals(token2.getBackgroundColor()));
	}

	@Test
	public void testIsEmpty() {
		// Prepare
		Token token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		Token token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");

		// Check
		assertFalse(token1.isEmpty());
		assertFalse(token2.isEmpty());
	}

	@Test
	public void testWidth() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		FormToken token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");
		int newDescriptionWidth = 40;
		int newInputWidth = 200;
		int newWidth = newDescriptionWidth + newInputWidth;

		// Action
		token1.setDescriptionWidth(newDescriptionWidth);
		token1.setInputWidth(newInputWidth);

		// Check
		assertFalse(token1.getWidthPx() == token2.getWidthPx());
		assertFalse(token1.getDescriptionWidthPx() == token2.getDescriptionWidthPx());
		assertFalse(token1.getInputWidthPx() == token2.getInputWidthPx());

		assertEquals(newDescriptionWidth, token1.getDescriptionWidthPx());
		assertEquals(newInputWidth, token1.getInputWidthPx());
		assertEquals(newWidth, token1.getWidthPx());

		assertEquals(135, token2.getDescriptionWidthPx());
		assertEquals(334, token2.getInputWidthPx());
		assertEquals(334 + 135, token2.getWidthPx());
	}

	@Test
	public void testText() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		FormToken token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");
		String testText1 = "Dies ist ein Test.";
		String testText2 = "Ein anderer Testtext.";

		// Action
		token1.setText(testText1);
		token2.setInputContent(testText2);

		// Check
		assertFalse(token1.getDescription().equals(token2.getDescription()));
		assertFalse(token1.getText().equals(token2.getText()));
		assertFalse(token2.getInputContent().equals(token1.getInputContent()));

		assertEquals(testText1, token1.getText());
		assertEquals(testText1, token1.getInputContent());
		assertEquals("Test1", token1.getDescription());
		assertEquals(testText2, token2.getText());
		assertEquals(testText2, token2.getInputContent());
		assertEquals("Test2", token2.getDescription());

		assertFalse(token1.getText().equals(testText2));
		assertFalse(token1.getInputContent().equals(testText2));
		assertFalse(token2.getText().equals(testText1));
		assertFalse(token2.getInputContent().equals(testText1));
	}

	@Test
	public void testIsLayoutLocked() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		FormToken token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");

		// Action
		token1.lockLayout(false);
		token2.lockLayout(true);

		// Check
		assertEquals(true, token1.isLayoutLocked());
		assertEquals(true, token2.isLayoutLocked());
	}

	@Test
	public void testIsContentLocked() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		FormToken token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");

		// Action
		token1.lockContent(false);
		token2.lockContent(true);

		// Check
		assertEquals(false, token1.isContentLocked());
		assertEquals(false, token2.isContentLocked());
	}

	@Test
	public void testTextbasedTokenStyle() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		ReadOnlyTextbasedTokenStyle testStyle = textbasedTokenStyleFactory.createTextbasedTokenStyle(FontSize.SIZE_10,
				Color.GOLDENYELLOW, Color.DARK_BLUE, FontStyle.ITALIC, FontWeight.BOLD, Font.TIMES_NEW_ROMAN);
		FormToken token2 = tokenFactory.createFormToken(testStyle, "Test2");

		// Check
		assertFalse(token1.getTokenStyle().equals(testStyle));
		assertFalse(token1.getTokenStyle().equals(token2.getTokenStyle()));
		assertFalse(token2.getTokenStyle().equals(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle()));

		assertEquals(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), token1.getTokenStyle());
		assertEquals(testStyle, token2.getTokenStyle());

	}

	@Test
	public void testPattern() {
		// Prepare
		FormToken token1 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test1");
		FormToken token2 = tokenFactory.createFormToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(),
				"Test2");

		String testString1 = "123234";
		String testString2 = "Hallo";
		String testString3 = "Hey Ihr 3";

		// Action1
		token1.setPattern("[0-9]*");
		token2.setPattern("H[a-z]*");

		// Check1
		assertFalse(token1.getPattern().equals(token1.getDefaultPattern()));
		assertTrue(testString1.matches(token1.getPattern()));
		assertFalse(testString2.matches(token1.getPattern()));
		assertFalse(testString3.matches(token1.getPattern()));
		assertFalse(token2.getPattern().equals(token2.getDefaultPattern()));
		assertFalse(testString1.matches(token2.getPattern()));
		assertTrue(testString2.matches(token2.getPattern()));
		assertFalse(testString3.matches(token2.getPattern()));
		assertFalse(token1.getPattern().equals(token2.getPattern()));

		// Action2
		token2.setPattern("");

		// Check2
		assertTrue(token2.getPattern().equals(token2.getDefaultPattern()));
		assertTrue(testString1.matches(token2.getPattern()));
		assertTrue(testString2.matches(token2.getPattern()));
		assertTrue(testString3.matches(token2.getPattern()));
		assertFalse(token1.getPattern().equals(token2.getPattern()));

		// Action3
		token1.setPattern(null);

		// Check3
		assertTrue(token1.getPattern().equals(token1.getDefaultPattern()));
		assertTrue(token1.getPattern().equals(token2.getPattern()));
	}
}
