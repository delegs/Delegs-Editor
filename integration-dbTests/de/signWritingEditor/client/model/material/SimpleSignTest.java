package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.SignId;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.SignSource;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.User;

public class SimpleSignTest {

	SymbolFactory symbolFactory;
	private SimpleSign sign;
	private PositionedSymbol positionedSymbol;
	private Date modificationDate;
	private int upperIdPart;
	private SignLocale signLocale;
	private SignSource signSource;
	private String word;
	private User author;
	private SignId signId;
	private String comment;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		author = new User("signTest", "Sign", "Test", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		comment = "test";
		signLocale = SignLocale.DGS;
		signSource = SignSource.DELEGS;
		upperIdPart = 12345;
		word = "signTest";
		signId = new SignId(upperIdPart, word, signLocale, signSource);
		modificationDate = new Date(1);
		sign = new SimpleSign(signId, author, signLocale, modificationDate, comment);
		positionedSymbol = new PositionedSymbol(symbolFactory.createSymbol("01-05-008-01-01-01"), 10, 10, 1);
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testAddSymbol() {

		assertTrue(sign.getPlainSymbols().isEmpty());

		sign.addSymbol(positionedSymbol);
		assertFalse(sign.hasOtherSymbol(positionedSymbol));
		assertTrue(sign.hasSymbol(positionedSymbol));
		assertTrue(sign.hasHandSymbol(positionedSymbol));
		assertTrue(sign.getPlainSymbols().contains(positionedSymbol));

	}

	@Test
	public void testRemoveSymbol() {

		sign.addSymbol(positionedSymbol);
		assertTrue(sign.getPlainSymbols().size() > 0);

		sign.removeSymbol(positionedSymbol);
		assertTrue(sign.getPlainSymbols().isEmpty());
		assertFalse(sign.hasSymbol(positionedSymbol));
		assertFalse(sign.hasHandSymbol(positionedSymbol));
		assertFalse(sign.hasOtherSymbol(positionedSymbol));
	}

	@Test
	public void testGetWidth() {

		int expectedWidth = 0;

		assertEquals(expectedWidth, sign.getWidth());

		{
			sign.addSymbol(positionedSymbol);
			assertTrue(sign.hasSymbol(positionedSymbol));

			expectedWidth = positionedSymbol.getSymbol().getWidth();
			assertEquals(expectedWidth, sign.getWidth());
		}

		{
			PositionedSymbol symbol = new PositionedSymbol(symbolFactory.createSymbol("01-05-008-01-01-01"),
					10 + expectedWidth, 10, 1);
			sign.addSymbol(symbol);
			assertTrue(sign.hasSymbol(symbol));

			expectedWidth += symbol.getSymbol().getWidth();
			assertEquals(expectedWidth, sign.getWidth());
		}

		{
			PositionedSymbol symbol = new PositionedSymbol(symbolFactory.createSymbol("01-05-008-01-01-01"), -10, 10,
					1);
			sign.addSymbol(symbol);
			assertTrue(sign.hasSymbol(symbol));

			expectedWidth = expectedWidth + 20;
			assertEquals(expectedWidth, sign.getWidth());
		}

		{
			PositionedSymbol symbol = new PositionedSymbol(symbolFactory.createSymbol("01-05-008-01-01-01"), 0, 10, 1);
			sign.addSymbol(symbol);
			assertTrue(sign.hasSymbol(symbol));

			assertEquals(expectedWidth, sign.getWidth());
		}

		{
			PositionedSymbol symbol = new PositionedSymbol(symbolFactory.createSymbol("02-05-008-01-01-01"), 5, 10, 1);
			sign.addSymbol(symbol);
			assertTrue(sign.hasSymbol(symbol));

			assertEquals(expectedWidth, sign.getWidth());
		}
	}

	@Test
	public void testContentBasedHashCode() {

		SimpleSign originalSign = sign;
		SimpleSign contentEqualsToOriginalSign1 = new SimpleSign(
				new SignId(upperIdPart + 1, word, signLocale, signSource), author, signLocale, modificationDate,
				comment);
		assertEquals(originalSign.contentBasedHashCode(), contentEqualsToOriginalSign1.contentBasedHashCode());

		User otherAuthor = new User("owner", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		SimpleSign notContentEqualsToOriginalSign1 = new SimpleSign(
				new SignId(upperIdPart + 2, word, signLocale, signSource), otherAuthor, signLocale, modificationDate,
				comment);
		assertFalse(notContentEqualsToOriginalSign1.contentBasedHashCode() == contentEqualsToOriginalSign1
				.contentBasedHashCode());

		SimpleSign notContentEqualsToOriginalSign2 = new SimpleSign(
				new SignId(upperIdPart + 3, word, SignLocale.ASL, signSource), otherAuthor, SignLocale.ASL,
				modificationDate, comment);
		assertFalse(notContentEqualsToOriginalSign2.contentBasedHashCode() == contentEqualsToOriginalSign1
				.contentBasedHashCode());
		assertFalse(notContentEqualsToOriginalSign2.contentBasedHashCode() == notContentEqualsToOriginalSign1
				.contentBasedHashCode());

		PositionedSymbol positionedSymbol = new PositionedSymbol(symbolFactory.createSymbol("02-05-005-01-01-01"), 0, 0,
				0);
		originalSign.addSymbol(positionedSymbol);
		assertFalse(originalSign.contentBasedHashCode() == contentEqualsToOriginalSign1.contentBasedHashCode());
		contentEqualsToOriginalSign1.addSymbol(positionedSymbol);
		assertEquals(originalSign.contentBasedHashCode(), contentEqualsToOriginalSign1.contentBasedHashCode());

		PositionedSymbol symbolA = new PositionedSymbol(symbolFactory.createSymbol("02-05-005-02-03-03"), 0, 0, 0);
		PositionedSymbol symbolB = new PositionedSymbol(symbolFactory.createSymbol("02-05-005-02-02-01"), 0, 0, 0);
		originalSign.addSymbol(symbolA);
		originalSign.addSymbol(symbolB);
		contentEqualsToOriginalSign1.addSymbol(symbolB);
		contentEqualsToOriginalSign1.addSymbol(symbolA);
		assertFalse(originalSign.contentBasedHashCode() == contentEqualsToOriginalSign1.contentBasedHashCode()); // Reihenfolge
																													// ist
																													// relevant!
	}

	@Test
	public void testModificationDate() {
		assertEquals(modificationDate, sign.getModificationDate());
	}

	@Test
	public void testEquals() {
		SimpleSign originalSign = sign;

		SimpleSign equalsToOriginalButWithOtherAuthor = new SimpleSign(signId, User.getUnknownUser(), signLocale,
				modificationDate, comment);
		assertEquals(originalSign, equalsToOriginalButWithOtherAuthor);
		SimpleSign equalsToOriginalButWithOtherLocale = new SimpleSign(signId, author, SignLocale.PJM, modificationDate,
				comment);
		assertEquals(originalSign, equalsToOriginalButWithOtherLocale);
		SimpleSign equalsToOriginalButWithOtherModificationDate = new SimpleSign(signId, author, signLocale,
				new Date(21), comment);
		assertEquals(originalSign, equalsToOriginalButWithOtherModificationDate);

		SimpleSign signWithDifferentSignUpperIdSign = new SimpleSign(
				new SignId(upperIdPart + 1, word, signLocale, signSource), author, signLocale, modificationDate,
				comment);
		assertFalse(originalSign.equals(signWithDifferentSignUpperIdSign));

		SimpleSign signWithDifferentLowerId = new SimpleSign(
				new SignId(upperIdPart, "EinAnderesWort", signLocale, signSource), author, signLocale, modificationDate,
				comment);
		assertFalse(originalSign.equals(signWithDifferentLowerId));

		SimpleSign signWithDifferentLocale = new SimpleSign(new SignId(upperIdPart, word, SignLocale.PJM, signSource),
				author, signLocale, modificationDate, comment);
		assertFalse(originalSign.equals(signWithDifferentLocale));

		SimpleSign signWithDifferentSource = new SimpleSign(
				new SignId(upperIdPart, word, signLocale, SignSource.IMPORTED), author, signLocale, modificationDate,
				comment);
		assertFalse(originalSign.equals(signWithDifferentSource));
	}
}
