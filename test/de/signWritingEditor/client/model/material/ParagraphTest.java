package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.Paragraph;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class ParagraphTest {

	private Paragraph paragraph;
	private SignItemToken token1;
	private SignItemToken token2;
	private SignItemToken token3;
	private IdFactory idFactory;
	private TextbasedTokenStyleFactory textbasedTokenStyleFactory;
	private TokenFactory tokenFactory;

	@Before
	public void setUp() throws Exception {
		idFactory = new IdFactory(9);
		paragraph = new Paragraph(idFactory.createId());
		tokenFactory = new TokenFactory(idFactory);
		textbasedTokenStyleFactory = new TextbasedTokenStyleFactory();

		SignItem sign = new SignItem(new SignId(1234, "test", SignLocale.DGS, SignSource.DELEGS), 30);
		token1 = tokenFactory.createSignItemToken("token1", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		token2 = tokenFactory.createSignItemToken("token2", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		token3 = tokenFactory.createSignItemToken("token3", sign,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

	}

	@Test
	public void testAddToken() throws Exception {
		assertTrue(paragraph.isEmpty());
		assertEquals(0, paragraph.getTokenCount());

		// run
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph.addToken(token3);

		// check
		assertFalse(paragraph.isEmpty());
		assertEquals(3, paragraph.getTokenCount());
		assertEquals(token1, paragraph.getToken(0));
		assertEquals(token2, paragraph.getToken(1));
		assertEquals(token3, paragraph.getToken(2));

	}

	@Test
	public void testInsertToken() throws Exception {
		assertTrue(paragraph.isEmpty());
		assertEquals(0, paragraph.getTokenCount());

		// setup
		paragraph.insertToken(token1, 0);
		paragraph.insertToken(token3, 1);

		// run
		paragraph.insertToken(token2, 1);

		// check
		assertFalse(paragraph.isEmpty());
		assertEquals(3, paragraph.getTokenCount());
		assertEquals(token1, paragraph.getToken(0));
		assertEquals(token2, paragraph.getToken(1));
		assertEquals(token3, paragraph.getToken(2));
	}

	@Test
	public void testRemoveTokenAtIndex() throws Exception {
		assertTrue(paragraph.isEmpty());
		assertEquals(0, paragraph.getTokenCount());

		// setup
		paragraph.addToken(token1);
		paragraph.addToken(token2);
		paragraph.addToken(token3);

		// run
		paragraph.removeToken(1);

		// check
		assertEquals(2, paragraph.getTokenCount());
		assertEquals(token1, paragraph.getToken(0));
		assertEquals(token3, paragraph.getToken(1));

		paragraph.removeToken(0);
		paragraph.removeToken(0);

		assertTrue(paragraph.isEmpty());
		assertEquals(0, paragraph.getTokenCount());
	}

	@Test
	public void testEquals() throws Exception {
		// setup
		Paragraph paragraph2 = new Paragraph(idFactory.createId());
		Paragraph paragraph3 = new Paragraph(idFactory.createId());

		paragraph.addToken(token1);
		paragraph2.addToken(token2);
		paragraph3.addToken(token2);
		paragraph2.setFreeTextLineVisible(false);
		paragraph3.setFreeTextLineVisible(false);
		paragraph2.setSearchWordLineVisible(true);
		paragraph3.setSearchWordLineVisible(true);

		// check
		assertFalse(paragraph.equals(paragraph2));
		assertTrue(paragraph3.equals(paragraph2));
	}

	@Test
	public void testMoveTokensToParagraph() {

		Id paragraphId1 = idFactory.createId();
		Id paragraphId2 = idFactory.createId();

		Paragraph paragraph1 = new Paragraph(paragraphId1);
		Paragraph paragraph2 = new Paragraph(paragraphId2);

		SignItemToken token1 = tokenFactory.createSignItemToken("token1",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("token2",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token3 = tokenFactory.createSignItemToken("token3",
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		paragraph1.addToken(token1);
		paragraph1.addToken(token2);
		paragraph1.addToken(token3);

		assertEquals(3, paragraph1.getTokenCount());
		assertTrue(paragraph2.isEmpty());

		paragraph1.moveTokensToParagraph(paragraph2, 1);

		assertEquals(1, paragraph1.getTokenCount());
		assertEquals(2, paragraph2.getTokenCount());

		assertEquals(token1, paragraph1.getToken(0));
		assertEquals(token2, paragraph2.getToken(0));
		assertEquals(token3, paragraph2.getToken(1));

		paragraph1.moveTokensToParagraph(paragraph2, 0);
		assertTrue(paragraph1.isEmpty());
		assertEquals(token1, paragraph2.getToken(0));
		assertEquals(token2, paragraph2.getToken(1));
		assertEquals(token3, paragraph2.getToken(2));

		// move all at once
		paragraph2.moveTokensToParagraph(paragraph1, 0);
		assertTrue(paragraph2.isEmpty());
		assertEquals(token1, paragraph1.getToken(0));
		assertEquals(token2, paragraph1.getToken(1));
		assertEquals(token3, paragraph1.getToken(2));

		// move 1 by 1
		paragraph1.moveTokensToParagraph(paragraph2, 2);
		paragraph1.moveTokensToParagraph(paragraph2, 1);
		paragraph1.moveTokensToParagraph(paragraph2, 0);
		assertTrue(paragraph1.isEmpty());
		assertEquals(token1, paragraph2.getToken(0));
		assertEquals(token2, paragraph2.getToken(1));
		assertEquals(token3, paragraph2.getToken(2));
	}
}
