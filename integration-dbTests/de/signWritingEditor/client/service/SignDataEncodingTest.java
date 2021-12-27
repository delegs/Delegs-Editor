package de.signWritingEditor.client.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.communication.infrastructure.SignDataDecoder;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.infrastructure.SignDataEncoder;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SignDataEncodingTest {

	private SymbolFactory symbolFactory;
	private SignDataEncoder signDataEncoder;
	private SignDataDecoder signDataDecoder;
	private DbConnector connector;

	@Before
	public void setUp() throws Exception {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		SymbolDB symbolDB = new SymbolDB(connector);
		symbolFactory = new SymbolFactory(symbolDB.getAllSymbols());
		signDataEncoder = new SignDataEncoder();
		signDataDecoder = new SignDataDecoder(symbolFactory);
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testEnAndDecode() {
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		positionedSymbols.add(new PositionedSymbol(symbolFactory.createSymbol("01-01-001-01-02-02"), 10, 10, 1));
		positionedSymbols.add(new PositionedSymbol(symbolFactory.createSymbol("04-02-007-01-01-01"), 30, 30, 2));

		String signDataCode = signDataEncoder.encodePositionedSymbols(positionedSymbols);

		assertEquals("s10011x10y10z1r000000wFFFFFFs32100x30y30z2r000000wFFFFFF", signDataCode);
		assertEquals(positionedSymbols, signDataDecoder.decodePositionedSymbols(signDataCode));
	}

	@Test
	public void testIsValid() {
		assertTrue(signDataDecoder.isValidSignDataCode(""));
		assertTrue(signDataDecoder.isValidSignDataCode("s10011x10y10z1"));
		assertTrue(signDataDecoder.isValidSignDataCode("s10512x10y10z1s10041x30y30z2"));
		assertTrue(signDataDecoder
				.isValidSignDataCode("s10011x10y10z1s10011x30y30z2s10011x98764637y8272635165273z1827361524351727"));

		assertFalse(signDataDecoder.isValidSignDataCode(null));
		assertFalse(signDataDecoder.isValidSignDataCode("s"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10y10z1s10011x30y30z2s"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10y10z110011x30y30z2"));
		assertFalse(signDataDecoder.isValidSignDataCode("s1001x10y10z1"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011y10z1"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10z1"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10y10"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011xy10z1"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10yz1"));
		assertFalse(signDataDecoder.isValidSignDataCode("s10011x10y10z"));
	}

}
