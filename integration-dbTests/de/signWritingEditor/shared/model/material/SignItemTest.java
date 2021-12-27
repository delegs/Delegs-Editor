package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
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

public class SignItemTest {

	private static final SignLocale DGS = SignLocale.DGS;
	private static final SignLocale ASL = SignLocale.ASL;

	private SignItem signItem1;
	private SignItem signItem2;
	private SimpleSign sign1;
	private SimpleSign sign2;
	private SimpleSign signWithAsl;

	private SignId signId1;
	private SignId signId2;
	private int signWidth1 = 10;
	private int signWidth2 = 20;
	private SymbolFactory symbolFactory;
	private PositionedSymbol symbol;
	private String comment;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		comment = "test";

		symbol = new PositionedSymbol(symbolFactory.createSymbol(1, 1, 1, 1, 1, 1), 0, 0, 1);

		// sign1
		signId1 = new SignId(12345, "ein_Test_ohne_Sign", DGS, SignSource.DELEGS);
		sign1 = new SimpleSign(signId1, User.getUnknownUser(), DGS, new Date(), comment);
		sign1.addSymbol(symbol);
		signItem1 = new SignItem(sign1.getSignId(), signWidth1);

		// sign2
		signId2 = new SignId(12346, "ein_Test_mit_Sign", DGS, SignSource.DELEGS);
		sign2 = new SimpleSign(signId2, User.getUnknownUser(), DGS, new Date(), comment);
		sign2.addSymbol(symbol);
		signItem2 = new SignItem(sign2);

		// a sign with ASL
		signWithAsl = new SimpleSign(new SignId(10000, "asl", ASL, SignSource.DELEGS), User.getUnknownUser(), ASL,
				new Date(), comment);

	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testAll() {
		// signItem's id
		assertEquals(signId1, signItem1.getSignId());
		assertEquals(signId2, signItem2.getSignId());

		// signItem's width
		assertEquals(signWidth1, signItem1.getSignWidth());
		assertEquals(symbol.getSymbol().getWidth(), signItem2.getSignWidth());
		assertFalse(signItem1.getSignWidth() == symbol.getSymbol().getWidth());
		assertFalse(signItem2.getSignWidth() == signWidth1);

		signItem1.setSignWidth(100);
		signItem2.setSignWidth(6);
		assertEquals(100, signItem1.getSignWidth());
		assertEquals(6, signItem2.getSignWidth());

		signItem1.setSignWidth(signWidth1);
		signItem2.setSignWidth(signWidth2);
		assertEquals(signWidth1, signItem1.getSignWidth());
		assertEquals(signWidth2, signItem2.getSignWidth());

		// signItem's local sign
		assertFalse(signItem1.hasLocalSign());
		assertTrue(signItem1.getLocalSign() == null);
		assertTrue(signItem2.hasLocalSign());
		assertTrue(signItem2.getLocalSign().equals(sign2));

		signItem1.setLocalSign(sign1);
		assertTrue(signItem1.hasLocalSign());
		assertEquals(sign1, signItem1.getLocalSign());

		signItem1.setLocalSign(signWithAsl);
		assertTrue(signItem1.hasLocalSign());
		assertEquals(signWithAsl, signItem1.getLocalSign());

		// signItem equal
		assertFalse(signItem1.equals(signItem2));
		SignItem newSignItem = new SignItem(signId1, signWidth1);
		newSignItem.setLocalSign(signWithAsl);
		assertTrue(signItem1.equals(newSignItem));

	}
}
