package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.ImageToken;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class ImageTokenTest {
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
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();
		Id testId1 = token1.getId();
		Id testId2 = token2.getId();
		String url = "";
		int width = 220;
		int height = 207;
		Color backgroundColor = Color.LIGHT_GREY;

		// Check
		assertEquals(Objects.hash(testId1, backgroundColor, width, height, url), token1.hashCode());
		assertEquals(Objects.hash(testId2, backgroundColor, width, height, url), token2.hashCode());
	}

	@Test
	public void testId() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

		// Check
		assertFalse(token1.getId().equals(token2.getId()));
	}

	@Test
	public void testUrl() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();
		String url = "https://m.faz.net/media1/ppmedia/aktuell/1468006579/1.6357995/media_in_article_medium/61885990.jpg";
		// google -> darth vader

		// Action
		token1.setUrl(url);

		// Check
		assertFalse(token1.getUrl().equals(token2.getUrl()));
		assertEquals(url, token1.getUrl());
		assertEquals("", token2.getUrl());
	}

	@Test
	public void testWidth() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

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
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

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
	public void testBackgroundColor() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();
		Color testcolor = Color.GOLDENYELLOW;

		// Action
		token1.setBackgroundColor(testcolor);

		// Check
		assertFalse(token1.getBackgroundColor().equals(token2.getBackgroundColor()));
		assertEquals(testcolor, token1.getBackgroundColor());
		assertEquals(Color.LIGHT_GREY, token2.getBackgroundColor());
	}

	@Test
	public void testIsEmpty() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();
		String url = "https://m.faz.net/media1/ppmedia/aktuell/1468006579/1.6357995/media_in_article_medium/61885990.jpg";
		// google -> darth vader

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
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();
		String originalUrl = token1.getUrl();
		Color backgroundColor = token1.getBackgroundColor();
		String newUrl = "https://m.faz.net/media1/ppmedia/aktuell/1468006579/1.6357995/media_in_article_medium/61885990.jpg";
		// google -> darth vader

		// Action
		token1.setUrl(newUrl);

		// Check
		assertFalse(token1.contentHashCode() == token2.contentHashCode());
		assertEquals(Objects.hash(newUrl, backgroundColor), token1.contentHashCode());
		assertEquals(Objects.hash(originalUrl, backgroundColor), token2.contentHashCode());

	}

	@Test
	public void testEqualsObject() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

		// Check
		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId() == token2.getId());

	}

	@Test
	public void testLockLayout() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

		// Action
		token1.lockLayout(true);

		// Check
		assertFalse(token1.isLayoutLocked() == token2.isLayoutLocked());
		assertEquals(true, token1.isLayoutLocked());
		assertEquals(false, token2.isLayoutLocked());
	}

	@Test
	public void testIsLayoutLocked() {
		// Prepare
		ImageToken token1 = tokenFactory.createImageToken();
		ImageToken token2 = tokenFactory.createImageToken();

		// Action
		token1.lockContent(true);

		// Check
		assertFalse(token1.isContentLocked() == token2.isContentLocked());
		assertEquals(true, token1.isContentLocked());
		assertEquals(false, token2.isContentLocked());
	}

}
