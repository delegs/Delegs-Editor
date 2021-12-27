package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.material.TagToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.Token;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class TagTokenTest {

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
	public void testIsLayoutLocked() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		assertFalse(token.isLayoutLocked());

		token.lockLayout(true);
		assertTrue(token.isLayoutLocked());
	}

	@Test
	public void testIsContentLocked() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		assertFalse(token.isContentLocked());

		token.lockContent(true);
		assertTrue(token.isContentLocked());
	}

	@Test
	public void testId() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		assertEquals(token.getId().toString(), "0:1");
	}

	@Test
	public void testHashCode() {
		Token token1 = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		Token token2 = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		assertFalse(token1.getId() == token2.getId());
	}

	@Test
	public void testIsEmpty() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		assertFalse(token.isEmpty());
	}

	@Test
	public void testBackgroundColor() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		token.setBackgroundColor(Color.BLACK);
		assertEquals(token.getBackgroundColor(), Color.BLACK);
	}

	@Test
	public void testWidth() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		TagToken tagToken = new TagToken(token.getId(), textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());

		tagToken.setWidth(0);
		assertEquals(tagToken.getWidth(), 0);
	}

	@Test
	public void testItemList() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		TagToken tagToken = new TagToken(token.getId(), textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		tagToken.setItemList(list);
		assertEquals(tagToken.getItemList(), list);
	}

	@Test
	public void testSelectedItemList() {
		Token token = tokenFactory.createTagToken(textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		TagToken tagToken = new TagToken(token.getId(), textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle());
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		tagToken.setSelectedItemList(list);
		assertEquals(tagToken.getSelectedItemList(), list);
	}

}
