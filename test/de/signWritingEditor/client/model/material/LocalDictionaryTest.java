package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.LocalDictionary;
import de.signWritingEditor.shared.model.material.SignItem;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.User;

public class LocalDictionaryTest {

	@Test
	public void testDictionary() {
		LocalDictionary dictionary = new LocalDictionary();

		SimpleSign sign1 = new SimpleSign(new SignId(1234, "test1", SignLocale.DGS, SignSource.IMPORTED),
				new User("test", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1), SignLocale.DGS,
				new Date(), "");

		SimpleSign sign2 = new SimpleSign(new SignId(1235, "test2", SignLocale.DGS, SignSource.IMPORTED),
				new User("test", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1), SignLocale.DGS,
				new Date(), "");

		assertFalse(dictionary.contains(sign1.getSignId()));
		assertFalse(dictionary.contains(sign2.getSignId()));

		dictionary.save(sign1);

		assertTrue(dictionary.contains(sign1.getSignId()));
		assertFalse(dictionary.contains(sign2.getSignId()));
		SignItem sign1Item = new SignItem(sign1.getSignId(), sign1.getWidth());
		sign1Item.setLocalSign(sign1);
		assertTrue(dictionary.findSignsIgnoreCase("test1").contains(sign1Item));
		assertTrue(dictionary.findSignsIgnoreCase("foo").size() == 0);

		dictionary.save(sign2);

		assertTrue(dictionary.contains(sign2.getSignId()));
		SignItem sign2Item = new SignItem(sign2.getSignId(), sign2.getWidth());
		sign2Item.setLocalSign(sign2);
		assertTrue(dictionary.findSignsIgnoreCase("test2").contains(sign2Item));

		dictionary.remove(sign1.getSignId());

		assertFalse(dictionary.contains(sign1.getSignId()));
	}

	@Test
	public void testCapitalAndLowerCase() {
		LocalDictionary dictionary = new LocalDictionary();
		User author = new User("test", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		SimpleSign sign1 = new SimpleSign(new SignId(1234, "Hallo", SignLocale.DGS, SignSource.DELEGS), author,
				SignLocale.DGS, new Date(), "");

		SimpleSign sign2 = new SimpleSign(new SignId(1235, "hallo", SignLocale.DGS, SignSource.DELEGS), author,
				SignLocale.DGS, new Date(), "");

		assertFalse(sign1.equals(sign2));

		assertFalse(dictionary.contains(sign1.getSignId()));
		assertFalse(dictionary.contains(sign2.getSignId()));

		dictionary.save(sign1);
		assertTrue(dictionary.contains(sign1.getSignId()));
		assertFalse(dictionary.contains(sign2.getSignId()));
		SignItem sign1Item = new SignItem(sign1.getSignId(), sign1.getWidth());
		sign1Item.setLocalSign(sign1);
		assertTrue(dictionary.findSignsIgnoreCase("Hallo").contains(sign1Item));
		assertEquals(dictionary.findSignsIgnoreCase("hallo").size(), 1);

		dictionary.save(sign2);
		assertTrue(dictionary.contains(sign2.getSignId()));
		SignItem sign2Item = new SignItem(sign2.getSignId(), sign2.getWidth());
		sign2Item.setLocalSign(sign2);
		assertTrue(dictionary.findSignsIgnoreCase("hallo").contains(sign2Item));
		assertEquals(dictionary.findSignsIgnoreCase("hallo").size(), 2);

		assertEquals(dictionary.findSignsIgnoreCase("hallo").size(), dictionary.findSignsIgnoreCase("Hallo").size());
		assertEquals(dictionary.findSignsIgnoreCase("hAllO").size(), dictionary.findSignsIgnoreCase("haLLo").size());

		dictionary.remove(sign1.getSignId());
		assertFalse(dictionary.contains(sign1.getSignId()));
	}

	@Test
	public void testInsertIdTwice() {

		LocalDictionary dictionary = new LocalDictionary();
		User author = new User("test", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		SignId id = new SignId(1337, "Test", SignLocale.DGS, SignSource.DELEGS_LOCAL);

		String comment1 = "Empty1";
		SimpleSign sign1 = new SimpleSign(id, author, SignLocale.DGS, new Date(), comment1);
		String comment2 = "Empty2";
		SimpleSign sign2 = new SimpleSign(id, author, SignLocale.DGS, new Date(), comment2);

		boolean caughtException = false;
		// Action
		dictionary.save(sign1);
		try {
			dictionary.save(sign2);
			fail("Failed to throw a correckt exception");
		} catch (AssertionError e) {
			// Test
			caughtException = true;
		}

		assertTrue("Failed to throw an Exception", caughtException);
		assertEquals(sign1, dictionary.getSign(id));
		assertEquals(comment1, dictionary.getSign(id).getComment());
		assertEquals(1, dictionary.findSignsIgnoreCase("Test").size());
	}

	@Test
	public void testEqualOperation() {
		LocalDictionary dictonary1 = new LocalDictionary();
		LocalDictionary dictionary2 = new LocalDictionary();

		User author = new User("test", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		SignId id1 = new SignId(1337, "Test1", SignLocale.DGS, SignSource.DELEGS_LOCAL);
		SignId id2 = new SignId(1338, "Test2", SignLocale.DGS, SignSource.DELEGS_LOCAL);

		String comment1 = "Empty1";
		SimpleSign sign1 = new SimpleSign(id1, author, SignLocale.DGS, new Date(), comment1);
		String comment2 = "Empty2";
		SimpleSign sign2 = new SimpleSign(id2, author, SignLocale.DGS, new Date(), comment2);

		dictionary2.save(sign2);
		dictionary2.save(sign1);

		dictonary1.save(sign1);

		assertFalse(dictionary2.equals(dictonary1));

		dictonary1.save(sign2);

		assertTrue(dictionary2.equals(dictonary1));
	}

}
