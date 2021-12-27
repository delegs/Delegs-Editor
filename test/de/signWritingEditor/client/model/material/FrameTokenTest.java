package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.FrameToken;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class FrameTokenTest {
	private TokenFactory tokenFactory;
	private IdFactory idFactory;

	@Before
	public void setUp() throws Exception {
		this.idFactory = new IdFactory(0);
		this.tokenFactory = new TokenFactory(idFactory);
	}

	@Test
	public void testHashCode() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		Id testId1 = token1.getId();
		Id testId2 = token2.getId();
		int borderWidth = 2;
		int width = 150;
		int height = 190;
		Color frameColor = Color.BLACK;
		Color testBGColor = Color.WHITE;

		// Check
		assertFalse(token1.hashCode() == token2.hashCode());
		assertEquals(Objects.hash(testId1, borderWidth, width, height, frameColor, testBGColor), token1.hashCode());
		assertEquals(Objects.hash(testId2, borderWidth, width, height, frameColor, testBGColor), token2.hashCode());
	}

	@Test
	public void testId() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();

		// Check
		assertFalse(token1.getId().equals(token2.getId()));
	}

	@Test
	public void testBorderWidth_PX() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();

		// Action
		token1.setBorderWidth(3);

		// Check
		assertFalse(token1.getBorderWidth_PX() == token2.getBorderWidth_PX());
		assertEquals(3, token1.getBorderWidth_PX());
		assertEquals(2, token2.getBorderWidth_PX());
	}

	@Test
	public void testFrameColor() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		Color testFrameColor = Color.GOLDENYELLOW;

		// Action
		token1.setFrameColor(testFrameColor);

		// Check
		assertFalse(token1.getFrameColor().equals(token2.getFrameColor()));

		assertEquals(testFrameColor, token1.getFrameColor());
		assertEquals(Color.BLACK, token2.getFrameColor());
	}

	@Test
	public void testWidth() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		int width = 300;

		// Action
		token1.setWidth(width);

		// Check
		assertFalse(token1.getWidth() == token2.getWidth());

		assertEquals(width, token1.getWidth());
		assertEquals(150, token2.getWidth());
	}

	@Test
	public void testHeight() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		int height = 300;

		// Action
		token1.setHeight(height);

		// Check
		assertFalse(token1.getHeight() == token2.getHeight());

		assertEquals(height, token1.getHeight());
		assertEquals(190, token2.getHeight());
	}

	@Test
	public void testToString() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		String expected1 = "frameToken(id: " + token1.getId() + "\")";
		String expected2 = "frameToken(id: " + token2.getId() + "\")";

		// Check
		assertFalse(token1.toString().equals(token2.toString()));
		assertEquals(expected1, token1.toString());
		assertEquals(expected2, token2.toString());
	}

	@Test
	public void testBackgroundColor() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		Color testBGColor = Color.GOLDENYELLOW;

		// Action
		token1.setBackgroundColor(testBGColor);

		// Check
		assertFalse(token1.getBackgroundColor().equals(token2.getBackgroundColor()));

		assertEquals(testBGColor, token1.getBackgroundColor());
		assertEquals(Color.WHITE, token2.getBackgroundColor());

	}

	@Test
	public void testIsEmpty() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		boolean isEmpty = true;

		// Check
		assertTrue(token1.isEmpty() == token2.isEmpty());
		assertEquals(isEmpty, token1.isEmpty());
		assertEquals(isEmpty, token2.isEmpty());
	}

	@Test
	public void testContentHashCode() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();
		int borderWidth = 2;
		Color frameColor = Color.BLACK;

		// Check
		assertTrue(token1.contentHashCode() == token2.contentHashCode());
		assertEquals(Objects.hash(frameColor, borderWidth), token1.contentHashCode());
		assertEquals(Objects.hash(frameColor, borderWidth), token1.contentHashCode());
	}

	@Test
	public void testEqualsObject() {
		Token token1 = tokenFactory.createFrameToken();
		Token token2 = tokenFactory.createFrameToken();

		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId() == token2.getId());
	}

	@Test
	public void testLayoutLocked() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();

		// Action
		token1.lockLayout(true);

		// Check
		assertFalse(token1.isLayoutLocked() == token2.isLayoutLocked());
		assertEquals(true, token1.isLayoutLocked());
		assertEquals(false, token2.isLayoutLocked());
	}

	@Test
	public void testContentLocked() {
		// Prepare
		FrameToken token1 = tokenFactory.createFrameToken();
		FrameToken token2 = tokenFactory.createFrameToken();

		// Action
		token1.lockContent(true);

		// Check
		assertFalse(token1.isContentLocked() == token2.isContentLocked());
		assertEquals(true, token1.isContentLocked());
		assertEquals(false, token2.isContentLocked());
	}

}
