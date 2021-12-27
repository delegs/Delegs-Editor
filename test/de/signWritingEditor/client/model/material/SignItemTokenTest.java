package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SignItemToken;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;
import de.signWritingEditor.shared.model.material.TokenFactory;

public class SignItemTokenTest {

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
	public void testConstructor() {
		Id id1 = idFactory.createId();
		SignItemToken token1 = tokenFactory.createSignItemToken("", null, id1,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		assertEquals("", token1.getText());
		assertNull(token1.getSignItem());
		assertEquals(id1, token1.getId());

		SignItem signItem = new SignItem(new SignId(1234, "a", SignLocale.DGS, SignSource.DELEGS), 60);
		Id id2 = idFactory.createId();
		SignItemToken token2 = tokenFactory.createSignItemToken("", signItem, id2,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		assertEquals("", token2.getText());
		assertEquals(signItem, token2.getSignItem());
		assertEquals(id2, token2.getId());
	}

	@Test
	public void testGetterSetter() {
		SignItemToken token = tokenFactory.createEmptySignItemToken(
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		token.setText("word");
		assertEquals("word", token.getText());

		SignItem signItem = new SignItem(new SignId(12342, "a", SignLocale.DGS, SignSource.DELEGS), 50);
		token.setSignItem(signItem);
		assertEquals(signItem, token.getSignItem());
	}

	@Test
	public void testHashCode() {
		SignItemToken token1 = tokenFactory.createSignItemToken("a",
				new SignItem(new SignId(12345, "a", SignLocale.DGS, SignSource.DELEGS), 50),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("a",
				new SignItem(new SignId(12346, "a", SignLocale.DGS, SignSource.DELEGS), 50),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		assertFalse(token1.hashCode() == token2.hashCode());
		assertFalse(token1.getId() == token2.getId());

		Id id = idFactory.createId();

		SignItemToken token3 = tokenFactory.createSignItemToken("", null, id,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		SignItemToken token4 = tokenFactory.createSignItemToken("word", null, id,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		assertFalse(token3.hashCode() == token4.hashCode());

		token4.setSignItem(new SignItem(new SignId(12347, "b", SignLocale.DGS, SignSource.DELEGS), 70));
		assertFalse(token3.hashCode() == token4.hashCode());
	}

	@Test
	public void testEquals() {
		SignItemToken token1 = tokenFactory.createSignItemToken("a",
				new SignItem(new SignId(12345, "a", SignLocale.DGS, SignSource.DELEGS), 80),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);
		SignItemToken token2 = tokenFactory.createSignItemToken("a",
				new SignItem(new SignId(12346, "a", SignLocale.DGS, SignSource.DELEGS), 90),
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS);

		assertFalse(token1.equals(new Object()));
		assertFalse(token1.equals(null));

		assertEquals(token1, token1);

		assertFalse(token1.equals(token2));
		assertFalse(token1.getId() == token2.getId());

		Id id = idFactory.createId();

		SignItemToken token3 = tokenFactory.createSignItemToken("", null, id,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		SignItemToken token4 = tokenFactory.createSignItemToken("word", null, id,
				textbasedTokenStyleFactory.createDefaultTextbasedTokenStyle(), Color.WHITE, SignLocale.DGS, false,
				false);
		assertFalse(token3.equals(token4));

		token4.setSignItem(new SignItem(new SignId(12348, "a", SignLocale.DGS, SignSource.DELEGS), 50));
		assertFalse(token3.equals(token4));
	}

}
