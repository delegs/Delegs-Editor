package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.SignPuddleXmlParser.CoordinateEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.PositionedSymbolEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.SignEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.SignPuddleEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.SymbolEntry;
import de.signWritingEditor.server.service.SignPuddleXmlParser.TextTermEntry;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SignPuddleXmlParserTest {

	@Test
	public void testCoordinateEntryIsValid() {
		assertTrue(CoordinateEntry.isValid("123x456"));
		assertTrue(CoordinateEntry.isValid("9999x9999"));
		assertTrue(CoordinateEntry.isValid("80x20"));
		assertTrue(CoordinateEntry.isValid("0000x0000"));

		assertFalse(CoordinateEntry.isValid(null));
		assertFalse(CoordinateEntry.isValid(""));
		assertFalse(CoordinateEntry.isValid("80"));
		assertFalse(CoordinateEntry.isValid("x"));
		assertFalse(CoordinateEntry.isValid("x803"));
		assertFalse(CoordinateEntry.isValid("345x"));
		assertFalse(CoordinateEntry.isValid("34fx2ab"));
		assertFalse(CoordinateEntry.isValid("23445x23424"));
		assertFalse(CoordinateEntry.isValid("S12345"));
		assertFalse(CoordinateEntry.isValid("S33b0f"));
		assertFalse(CoordinateEntry.isValid("Sabcde"));
	}

	@Test
	public void testCoordinateEntryConstructor() {
		assertEquals(804, new CoordinateEntry("804x203").getX());
		assertEquals(203, new CoordinateEntry("804x203").getY());
		assertEquals(8023, new CoordinateEntry("8023x2043").getX());
		assertEquals(2043, new CoordinateEntry("8023x2043").getY());
	}

	@Test
	public void testTextTermEntryIsValid() {
		assertTrue(TextTermEntry.isValid("Haus"));
		assertTrue(TextTermEntry.isValid("Zaunkönig"));
		assertTrue(TextTermEntry.isValid("Cocktailparty"));
		assertTrue(TextTermEntry.isValid("ab cd"));
		assertTrue(TextTermEntry.isValid("ab   cd"));
		assertTrue(TextTermEntry.isValid("ab ef cd"));

		assertFalse(TextTermEntry.isValid(null));
		assertFalse(TextTermEntry.isValid(""));
		assertFalse(TextTermEntry.isValid(" "));
		assertFalse(TextTermEntry.isValid(" abcd"));
		assertFalse(TextTermEntry.isValid("abcd "));
	}

	@Test
	public void testTextTermEntryConstructor() {
		assertEquals("Haus", new TextTermEntry("Haus").getTextTermString());
		assertEquals("ab_cd", new TextTermEntry("ab cd").getTextTermString());
		assertEquals("ab___cd", new TextTermEntry("ab   cd").getTextTermString());
		assertEquals("ab_ef_cd", new TextTermEntry("ab ef cd").getTextTermString());
	}

	@Test
	public void testSymbolEntryIsValid() {
		assertTrue(SymbolEntry.isValid("S33b0f"));
		assertTrue(SymbolEntry.isValid("Sabcde"));
		assertTrue(SymbolEntry.isValid("S12345"));

		assertFalse(SymbolEntry.isValid(null));
		assertFalse(SymbolEntry.isValid(""));
		assertFalse(SymbolEntry.isValid("S"));
		assertFalse(SymbolEntry.isValid("S123456"));
		assertFalse(SymbolEntry.isValid("S1cd"));
		assertFalse(SymbolEntry.isValid("SACDEF"));
		assertFalse(SymbolEntry.isValid("S123x456"));
		assertFalse(SymbolEntry.isValid("452x123"));
		assertFalse(SymbolEntry.isValid("Sghijk"));
	}

	@Test
	public void testSymbolEntryConstructor() {
		SymbolEntry symbolEntry1 = new SymbolEntry("S33b0f");
		assertEquals(0x33b, symbolEntry1.getBaseSymbol());
		assertEquals(0x0, symbolEntry1.getFill());
		assertEquals(0xf, symbolEntry1.getRotation());
	}

	@Test
	public void testSignEntryIsValid() {
		assertTrue(SignEntry.isValid("S38800464x496"));
		assertTrue(SignEntry.isValid(
				"M571x610S10020429x558S2450a440x553S1ce40502x562S17648501x594S20500492x588S2942a527x581S36100437x482S34700467x482S34700527x482S35c00498x482"));
		assertTrue(SignEntry.isValid(
				"AS10010S26506S20500S20500S20500S30000S33b00S37a06M527x547S33b00482x482S30000482x482S10010468x452S20500487x471S20500501x471S20500516x472S26506492x456S37a06479x545"));
		assertTrue(SignEntry.isValid(
				"AS20352S26503S20500S15052S22a00S14c3aS2f900S35d00S34800S36500M556x604S35d00451x483S34800481x483S36500512x482S15052522x545S20500482x568S22a00532x526S26503501x540S20352480x548S14c3a525x575S2f900524x599"));
		assertTrue(SignEntry.isValid(
				"AS20f52M556x604S35d00451x483S34800481x483S36500512x482S15052522x545S20500482x568S22a00532x526S26503501x540S20352480x548S14c3a525x575S2f900524x599"));

		assertFalse(SignEntry.isValid(null));
		assertFalse(SignEntry.isValid(""));
		assertFalse(SignEntry.isValid("M"));
		assertFalse(SignEntry.isValid("M63x77"));
		assertFalse(SignEntry.isValid("MS12f4563x17"));
		assertFalse(SignEntry.isValid("M63x77S12f45"));
		assertFalse(SignEntry.isValid("A63x77S12f4563x17"));
		assertFalse(SignEntry.isValid("M63x77S12f45M63x17"));
		assertFalse(SignEntry.isValid("M63x77S1263x17"));
		assertFalse(SignEntry.isValid("M63x77S12f63x17"));
		assertFalse(SignEntry.isValid("A123a38x15"));
		assertFalse(SignEntry.isValid(
				"M518x523S36a00482x477 M500x500 M500x500 M500x500 M500x500 M513x520S14c11453x466S20500487x493"));
	}

	@Test
	public void testSignEntryConstructor() {
		SignEntry signEntry = new SignEntry("AS20f52M556x604S35d00451x483S34800481x483S36500512x482S15052522x545");

		assertEquals(556, signEntry.getOffset().getX());
		assertEquals(604, signEntry.getOffset().getY());

		assertEquals(4, signEntry.getPositionedSymbolEntries().size());

		PositionedSymbolEntry symbol1 = signEntry.getPositionedSymbolEntries().get(0);
		assertEquals(451, symbol1.getCoordinates().getX());
		assertEquals(483, symbol1.getCoordinates().getY());
		assertEquals(0x35d, symbol1.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol1.getSymbol().getFill());
		assertEquals(0x0, symbol1.getSymbol().getRotation());

		PositionedSymbolEntry symbol2 = signEntry.getPositionedSymbolEntries().get(1);
		assertEquals(481, symbol2.getCoordinates().getX());
		assertEquals(483, symbol2.getCoordinates().getY());
		assertEquals(0x348, symbol2.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol2.getSymbol().getFill());
		assertEquals(0x0, symbol2.getSymbol().getRotation());

		PositionedSymbolEntry symbol3 = signEntry.getPositionedSymbolEntries().get(2);
		assertEquals(512, symbol3.getCoordinates().getX());
		assertEquals(482, symbol3.getCoordinates().getY());
		assertEquals(0x365, symbol3.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol3.getSymbol().getFill());
		assertEquals(0x0, symbol3.getSymbol().getRotation());

		PositionedSymbolEntry symbol4 = signEntry.getPositionedSymbolEntries().get(3);
		assertEquals(522, symbol4.getCoordinates().getX());
		assertEquals(545, symbol4.getCoordinates().getY());
		assertEquals(0x150, symbol4.getSymbol().getBaseSymbol());
		assertEquals(0x5, symbol4.getSymbol().getFill());
		assertEquals(0x2, symbol4.getSymbol().getRotation());

		SignEntry signEntryWithoutOffset = new SignEntry("S38800464x496");

		assertEquals(0, signEntryWithoutOffset.getOffset().getX());
		assertEquals(0, signEntryWithoutOffset.getOffset().getY());

		assertEquals(1, signEntryWithoutOffset.getPositionedSymbolEntries().size());

		assertEquals(464, signEntryWithoutOffset.getPositionedSymbolEntries().get(0).getCoordinates().getX());
		assertEquals(496, signEntryWithoutOffset.getPositionedSymbolEntries().get(0).getCoordinates().getY());
		assertEquals(0x388, signEntryWithoutOffset.getPositionedSymbolEntries().get(0).getSymbol().getBaseSymbol());
		assertEquals(0x0, signEntryWithoutOffset.getPositionedSymbolEntries().get(0).getSymbol().getFill());
		assertEquals(0x0, signEntryWithoutOffset.getPositionedSymbolEntries().get(0).getSymbol().getRotation());
	}

	@Test
	public void testParsePuddleEntries() throws Exception {
		SignPuddleXmlParser signPuddleXmlParser = new SignPuddleXmlParser(null);

		String puddleXml = IOUtils.toString(SignPuddleXmlParserTest.class.getResourceAsStream("sign-export-test.spml"));
		List<SignPuddleEntry> signPuddleEntries = signPuddleXmlParser.parsePuddleEntries(puddleXml);

		// Zaunkönig is ignored
		assertEquals(3, signPuddleEntries.size());

		// First entry
		assertEquals(new Date(1175189257000L), signPuddleEntries.get(0).getCdt());
		assertEquals(new Date(1211101178000L), signPuddleEntries.get(0).getMdt());
		assertEquals(1000001272, signPuddleEntries.get(0).getSignId());
		assertEquals("SW", signPuddleEntries.get(0).getSrc());
		assertEquals("Prüfverfahren", signPuddleEntries.get(0).getText());
		assertEquals("", signPuddleEntries.get(0).getUsr());

		List<TextTermEntry> terms = signPuddleEntries.get(0).getTextTerms();
		assertEquals(1, terms.size());
		assertEquals("Test", terms.get(0).getTextTermString());

		SignEntry signEntry = signPuddleEntries.get(0).getSign();
		assertNotNull(signEntry);
		assertEquals(563, signEntry.getOffset().getX());
		assertEquals(577, signEntry.getOffset().getY());
		assertEquals(7, signEntry.getPositionedSymbolEntries().size());

		PositionedSymbolEntry symbol1 = signEntry.getPositionedSymbolEntries().get(0);
		assertEquals(437, symbol1.getCoordinates().getX());
		assertEquals(483, symbol1.getCoordinates().getY());
		assertEquals(0x35d, symbol1.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol1.getSymbol().getFill());
		assertEquals(0x0, symbol1.getSymbol().getRotation());

		PositionedSymbolEntry symbol2 = signEntry.getPositionedSymbolEntries().get(1);
		assertEquals(468, symbol2.getCoordinates().getX());
		assertEquals(483, symbol2.getCoordinates().getY());
		assertEquals(0x347, symbol2.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol2.getSymbol().getFill());
		assertEquals(0x0, symbol2.getSymbol().getRotation());

		PositionedSymbolEntry symbol3 = signEntry.getPositionedSymbolEntries().get(2);
		assertEquals(499, symbol3.getCoordinates().getX());
		assertEquals(482, symbol3.getCoordinates().getY());
		assertEquals(0x361, symbol3.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol3.getSymbol().getFill());
		assertEquals(0x0, symbol3.getSymbol().getRotation());

		PositionedSymbolEntry symbol4 = signEntry.getPositionedSymbolEntries().get(3);
		assertEquals(527, symbol4.getCoordinates().getX());
		assertEquals(483, symbol4.getCoordinates().getY());
		assertEquals(0x35d, symbol4.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol4.getSymbol().getFill());
		assertEquals(0x0, symbol4.getSymbol().getRotation());

		PositionedSymbolEntry symbol5 = signEntry.getPositionedSymbolEntries().get(4);
		assertEquals(464, symbol5.getCoordinates().getX());
		assertEquals(546, symbol5.getCoordinates().getY());
		assertEquals(0x14c, symbol5.getSymbol().getBaseSymbol());
		assertEquals(0x4, symbol5.getSymbol().getFill());
		assertEquals(0x8, symbol5.getSymbol().getRotation());

		PositionedSymbolEntry symbol6 = signEntry.getPositionedSymbolEntries().get(5);
		assertEquals(488, symbol6.getCoordinates().getX());
		assertEquals(552, symbol6.getCoordinates().getY());
		assertEquals(0x14c, symbol6.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol6.getSymbol().getFill());
		assertEquals(0x2, symbol6.getSymbol().getRotation());

		PositionedSymbolEntry symbol7 = signEntry.getPositionedSymbolEntries().get(6);
		assertEquals(481, symbol7.getCoordinates().getX());
		assertEquals(535, symbol7.getCoordinates().getY());
		assertEquals(0x206, symbol7.getSymbol().getBaseSymbol());
		assertEquals(0x0, symbol7.getSymbol().getFill());
		assertEquals(0x0, symbol7.getSymbol().getRotation());

		// Second entry: Cocktailparty
		assertEquals(1000003, signPuddleEntries.get(1).getSignId());
		assertNull(signPuddleEntries.get(1).getSrc());
		assertNull(signPuddleEntries.get(1).getText());
		assertEquals("Cocktailparty", signPuddleEntries.get(1).getTextTerms().get(0).getTextTermString());

		// Third entry: Doppelpunkt
		assertEquals(1000005764, signPuddleEntries.get(2).getSignId());
		assertEquals("SW", signPuddleEntries.get(2).getSrc());
		assertNull(signPuddleEntries.get(2).getText());
		assertEquals("Doppelpunkt", signPuddleEntries.get(2).getTextTerms().get(0).getTextTermString());
	}

	@Test
	public void testParsePuddleXml() throws Exception {
		DbConnector connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		SymbolFactory symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		SignPuddleXmlParser signPuddleXmlParser = new SignPuddleXmlParser(symbolFactory);

		String puddleXml = IOUtils.toString(SignPuddleXmlParserTest.class.getResourceAsStream("sign-export-test.spml"));
		List<DictionaryEntry> entries = signPuddleXmlParser.parsePuddleXml(puddleXml, SignLocale.DGS,
				KeepEveryWordUnchanged.INSTANCE);
		assertEquals(3, entries.size());

		assertEquals(7, entries.get(0).getSign().getPlainSymbols().size());

		for (DictionaryEntry dictionaryEntry : entries) {
			SimpleSign sign = dictionaryEntry.getSign();

			int minX = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;

			for (PositionedSymbol symbol : sign.getPlainSymbols()) {
				minX = symbol.getX() < minX ? symbol.getX() : minX;
				maxX = (symbol.getX() + symbol.getWidth()) > maxX ? (symbol.getX() + symbol.getWidth()) : maxX;
			}

			assertTrue(minX <= 0);
			assertTrue(maxX >= 0);

		}

		PositionedSymbol symbol1 = entries.get(0).getSign().getPlainSymbols().get(0);
		assertEquals("04-05-001-05-01-01", symbol1.getSymbol().getIswaId());

		assertEquals(10, entries.get(1).getSign().getPlainSymbols().size());
		PositionedSymbol symbol2 = entries.get(1).getSign().getPlainSymbols().get(0);
		assertEquals("02-05-006-01-02-07", symbol2.getSymbol().getIswaId());

		assertEquals(1, entries.get(2).getSign().getPlainSymbols().size());
		PositionedSymbol symbol3 = entries.get(2).getSign().getPlainSymbols().get(0);
		assertEquals("07-01-002-02-01-01", symbol3.getSymbol().getIswaId());
	}

}
