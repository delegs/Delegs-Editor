package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.FreeTextToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FreeTextTokenTest {

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
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		int width = 200;

		// Action
		token1.setWidth(width);

		// Check
		assertFalse(token1.hashCode() == token2.hashCode());
		assertFalse(token1.getId() == token2.getId());
		assertFalse(token1.getWidth() == token2.getWidth());
	}

	@Test
	public void testToString() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		String token1String = "token[id=" + token1.getId() + ", style=" + token1.getStyle() + ", FreeText:\""
				+ token1.getText() + "\"]";
		String token2String = "token[id=" + token2.getId() + ", style=" + token2.getStyle() + ", FreeText:\""
				+ token2.getText() + "\"]";

		// Check
		assertFalse(token1.toString().equals(token2.toString()));

		assertEquals(token1String, token1.toString());
		assertEquals(token2String, token2.toString());
	}

	@Test
	public void testText() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		String testText = "Dies ist ein Test.";

		// Action
		token1.setText(testText);
		token2.lockContent(true);
		token2.setText(testText);

		// Check
		assertFalse(token1.getText().equals(token2.getText()));

		assertEquals(testText, token1.getText());
		assertEquals("", token2.getText());
	}

	@Test
	public void testWidth() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		int width = 200;
		int negWidth = -1;
		boolean isLayoutLocked = true;

		// Action
		token1.setWidth(width);
		token2.lockLayout(isLayoutLocked);
		token2.setWidth(width);

		// Check
		assertFalse(token1.getWidth() == token2.getWidth());

		assertEquals(width, token1.getWidth());
		assertEquals(negWidth, token2.getWidth());
	}

	@Test
	public void testFixedWidth() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		int width = 200;
		int negWidth = -1;
		boolean fixedWidth = true;

		// Action 1
		token1.setFixedWidth(fixedWidth, width);

		// Check 1
		assertFalse(token1.getWidth() == token2.getWidth());

		assertEquals(width, token1.getWidth());
		assertTrue(token1.hasFixedWidth());
		assertEquals(negWidth, token2.getWidth());
		assertFalse(token2.hasFixedWidth());

		// Action 2
		token1.setWidth(negWidth);

		// Check 2
		assertEquals(width, token1.getWidth());
	}

	@Test
	public void testIsEmpty() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		String testText = "Test";

		// Action
		token2.setText(testText);

		// Check
		assertFalse(token1.isEmpty() == token2.isEmpty());

		assertEquals(true, token1.isEmpty());
		assertEquals(false, token2.isEmpty());
	}

	@Test
	public void testVisible() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		token1.setVisible(false);

		// Check
		assertFalse(token1.isVisible() == token2.isVisible());

		assertEquals(false, token1.isVisible());
		assertEquals(true, token2.isVisible());
	}

	@Test
	public void testFreeTextLine() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		token1.setIsFreeTextLine(true);
		token2.lockContent(true);
		token2.setIsFreeTextLine(true);

		// Check
		assertFalse(token1.isFreeTextLine() == token2.isFreeTextLine());

		assertEquals(true, token1.isFreeTextLine());
		assertEquals(false, token2.isFreeTextLine());
	}

	@Test
	public void testBackgroundColor() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
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
	public void testContentHashCode() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		String testText = "Test";

		// Action
		token1.setText(testText);

		// Check
		assertFalse(token1.contentHashCode() == token2.contentHashCode());
		assertFalse(token1.getId() == token2.getId());
		assertFalse(token1.getText().equals(token2.getText()));
	}

	@Test
	public void testEquals() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Check
		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId() == token2.getId());
	}

	@Test
	public void testlockLayout() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		token1.lockLayout(true);

		// Check
		assertEquals(true, token1.isLayoutLocked());
		assertEquals(false, token2.isLayoutLocked());
	}

	@Test
	public void testlockContent() {
		// Prepare
		FreeTextToken token1 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		FreeTextToken token2 = tokenFactory
				.createFreeTextToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		// Action
		token1.lockContent(true);

		// Check
		assertEquals(true, token1.isContentLocked());
		assertEquals(false, token2.isContentLocked());
	}

}
