package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;
import de.signWritingEditor.shared.model.material.VideoToken;

public class VideoTokenTest {

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
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		Id testId1 = token1.getId();
		Id testId2 = token2.getId();
		String url = token1.getUrl();
		int width = token1.getWidth();
		int height = token1.getHeight();
		Color backgroundColor = token1.getBackgroundColor();
		boolean urlVisible = token1.isUrlVisible();

		// Check
		assertFalse(token1.hashCode() == token2.hashCode());
		assertEquals(Objects.hash(testId1, url, width, height, backgroundColor, urlVisible), token1.hashCode());
		assertEquals(Objects.hash(testId2, url, width, height, backgroundColor, urlVisible), token2.hashCode());
	}

	@Test
	public void testId() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Check
		assertFalse(token1.getId().equals(token2.getId()));
	}

	@Test
	public void testWidth() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Action 1
		token2.setWidth(300);
		token1.lockLayout(true);
		token1.setWidth(300);

		// Check 1
		assertFalse(token1.getWidth() == token2.getWidth());
		assertEquals(220, token1.getWidth());
		assertEquals(300, token2.getWidth());
	}

	@Test
	public void testHeight() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Action 1
		token2.setHeight(300);
		token1.lockLayout(true);
		token1.setHeight(300);

		// Check 1
		assertFalse(token1.getHeight() == token2.getHeight());
		assertEquals(207, token1.getHeight());
		assertEquals(300, token2.getHeight());
	}

	@Test
	public void testToString() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Check
		assertFalse(token1.toString().equals(token2.toString()));

		assertEquals("videoToken(id: " + token1.getId() + "\")", token1.toString());
		assertEquals("videoToken(id: " + token2.getId() + "\")", token2.toString());
	}

	@Test
	public void testBackgroundColor() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		Color testcolor = Color.GOLDENYELLOW;

		// Action
		token1.setBackgroundColor(testcolor);

		// Check
		assertFalse(token1.getBackgroundColor().equals(token2.getBackgroundColor()));
		assertEquals(testcolor, token1.getBackgroundColor());
		assertEquals(Color.LIGHT_GREY, token2.getBackgroundColor());
	}

	@Test
	public void testTextBackgroundColor() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		Color testcolor = Color.GOLDENYELLOW;

		// Action 1
		token1.lockLayout(true);
		token2.setTextBackgroundColor(testcolor);

		// Check 1
		assertFalse(token1.getTextBackgroundColor().equals(token2.getTextBackgroundColor()));
		assertEquals(testcolor, token2.getTextBackgroundColor());
		assertEquals(Color.WHITE, token1.getTextBackgroundColor());

		// Action 2
		token1.lockContent(true);
		token2.lockLayout(true);

		// Check 2
		assertFalse(token1.getTextBackgroundColor().equals(token2.getTextBackgroundColor()));
		assertEquals(Color.GREY, token1.getTextBackgroundColor());
		assertEquals(Color.WHITE, token2.getTextBackgroundColor());
	}

	@Test
	public void testUrl() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		String url = "https://media.spreadthesign.com/video/mp4/9/161459.mp4";
		// Spreadthesign --> Englisch

		// Action
		token1.setUrl(url);

		// Check
		assertFalse(token1.getUrl().equals(token2.getUrl()));
		assertEquals(url, token1.getUrl());
		assertEquals("", token2.getUrl());
	}

	@Test
	public void testIsEmpty() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		String url = "https://media.spreadthesign.com/video/mp4/9/161459.mp4";
		// Spreadthesign --> Englisch

		// Action
		token1.setUrl(url);

		// Check
		assertFalse(token1.isEmpty() == token2.isEmpty());
		assertEquals(false, token1.isEmpty());
		assertEquals(true, token2.isEmpty());
	}

	@Test
	public void testContentHashCode() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();
		String originalUrl = token1.getUrl();
		Color backgroundColor = token1.getBackgroundColor();
		boolean urlVisible = token1.isUrlVisible();
		String newUrl = "https://media.spreadthesign.com/video/mp4/9/161459.mp4";
		// Spreadthesign --> Englisch

		// Action
		token1.setUrl(newUrl);

		// Check
		assertFalse(token1.contentHashCode() == token2.contentHashCode());
		assertEquals(Objects.hash(newUrl, backgroundColor, urlVisible), token1.contentHashCode());
		assertEquals(Objects.hash(originalUrl, backgroundColor, urlVisible), token2.contentHashCode());
	}

	@Test
	public void testIsLayoutLocked() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Action
		token1.lockLayout(true);

		// Check
		assertFalse(token1.isLayoutLocked() == token2.isLayoutLocked());
		assertEquals(true, token1.isLayoutLocked());
		assertEquals(false, token2.isLayoutLocked());
	}

	@Test
	public void testIsContentLocked() {
		// Prepare
		VideoToken token1 = tokenFactory.createVideoToken();
		VideoToken token2 = tokenFactory.createVideoToken();

		// Action
		token1.lockContent(true);

		// Check
		assertFalse(token1.isContentLocked() == token2.isContentLocked());
		assertEquals(true, token1.isContentLocked());
		assertEquals(false, token2.isContentLocked());
	}

	@Test
	public void testEquals() {
		Token token1 = tokenFactory.createVideoToken();
		Token token2 = tokenFactory.createVideoToken();

		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId() == token2.getId());
	}

}
