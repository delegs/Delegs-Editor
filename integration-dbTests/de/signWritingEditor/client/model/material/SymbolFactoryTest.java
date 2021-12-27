package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.BaseSymbol.SymbolCategory;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class SymbolFactoryTest {

	private SymbolFactory symbolFactory;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testValueOf() throws Exception {
		int category = 1;
		int group = 3;
		int symbol = 7;
		int variation = 1;
		int fill = 1;
		int rotation = 1;

		Symbol testSymbol = symbolFactory.createSymbol(category, group, symbol, variation, fill, rotation);

		assertEquals(category, testSymbol.getCategory());
		assertEquals(group, testSymbol.getGroup());
		assertEquals(symbol, testSymbol.getSymbol());
		assertEquals(variation, testSymbol.getVariation());
		assertEquals(fill, testSymbol.getFill());
		assertEquals(rotation, testSymbol.getRotation());
	}

	@Test
	public void testValueOfStrings() throws Exception {
		int category = 1;
		int group = 3;
		int symbol = 7;
		int variation = 1;
		int fill = 1;
		int rotation = 1;

		Symbol testSymbol = symbolFactory.createSymbol(category, group, symbol, variation, fill, rotation);

		assertEquals(category, testSymbol.getCategory());
		assertEquals(group, testSymbol.getGroup());
		assertEquals(symbol, testSymbol.getSymbol());
		assertEquals(variation, testSymbol.getVariation());
		assertEquals(fill, testSymbol.getFill());
		assertEquals(rotation, testSymbol.getRotation());
	}

	@Test
	public void testIsInValid() throws Exception {
		assertTrue(symbolFactory.isValidSymbol(1, 3, 7, 1, 1, 1));
		assertTrue(symbolFactory.isValidSymbol(2, 8, 14, 1, 1, 1));

		assertFalse(symbolFactory.isValidSymbol(8, 1, 1, 1, 1, 1));
	}

	@Test
	public void testIsInValidStrings() throws Exception {
		assertTrue(symbolFactory.isValidSymbol("1", "3", "7", "1", "1", "1"));
		assertTrue(symbolFactory.isValidSymbol("2", "8", "14", "1", "1", "1"));

		assertFalse(symbolFactory.isValidSymbol("8", "1", "1", "1", "1", "1"));
	}

	@Test
	public void testIsValidCodeRepresentation() throws IOException {
		assertFalse(SymbolFactory.isValidIswaId(""));
		assertFalse(SymbolFactory.isValidIswaId("0"));
		assertFalse(SymbolFactory.isValidIswaId("0-0-0-0-0"));
		assertFalse(SymbolFactory.isValidIswaId("00-00-00-00-00-00"));
		assertFalse(SymbolFactory.isValidIswaId("00-00-000-00-00-00"));
		assertTrue(SymbolFactory.isValidIswaId("01-01-001-01-01-01"));
		assertTrue(SymbolFactory.isValidIswaId("99-99-999-99-06-16"));
		assertFalse(SymbolFactory.isValidIswaId("99-99-999-99-07-16"));
		assertFalse(SymbolFactory.isValidIswaId("99-99-999-99-06-17"));
	}

	@Test
	public void testParseSymbolIdRepresentation() throws IOException {
		String symbolId1 = "01-01-001-01-01-01";
		assertEquals(symbolId1, symbolFactory.createSymbol(symbolId1).getIswaId());
	}

	@Test
	public void testGetAllVariationsFor() {
		Symbol handSymbolWithAllFillsAndRotations = symbolFactory.createSymbol(SymbolCategory.HAND.getCategoryNumber(),
				1, 5, 1, 1, 1);

		Set<Symbol> allVariationsForHandSymbolWithAllFillsAndRotations = symbolFactory
				.getAllRotationsAndFillsFor(handSymbolWithAllFillsAndRotations.getBaseSymbol());

		assertEquals(96, allVariationsForHandSymbolWithAllFillsAndRotations.size());

		assertTrue(allVariationsForHandSymbolWithAllFillsAndRotations.contains(handSymbolWithAllFillsAndRotations));

		List<Integer> allFills = new ArrayList<Integer>();
		allFills.add(1);
		allFills.add(2);
		allFills.add(3);
		allFills.add(4);
		allFills.add(5);
		allFills.add(6);

		List<Integer> allRotations = new ArrayList<Integer>();
		allRotations.add(1);
		allRotations.add(2);
		allRotations.add(3);
		allRotations.add(4);
		allRotations.add(5);
		allRotations.add(6);
		allRotations.add(7);
		allRotations.add(8);

		List<Integer> allMirroredRotations = new ArrayList<Integer>();
		allMirroredRotations.add(9);
		allMirroredRotations.add(10);
		allMirroredRotations.add(11);
		allMirroredRotations.add(12);
		allMirroredRotations.add(13);
		allMirroredRotations.add(14);
		allMirroredRotations.add(15);
		allMirroredRotations.add(16);

		for (int rotation : allRotations) {
			for (int fill : allFills) {
				assertTrue(allVariationsForHandSymbolWithAllFillsAndRotations.contains(symbolFactory.createSymbol(
						SymbolCategory.HAND.getCategoryNumber(), handSymbolWithAllFillsAndRotations.getGroup(),
						handSymbolWithAllFillsAndRotations.getSymbol(),
						handSymbolWithAllFillsAndRotations.getVariation(), fill, rotation)));
			}
		}

		for (int rotation : allMirroredRotations) {
			for (int fill : allFills) {
				assertTrue(allVariationsForHandSymbolWithAllFillsAndRotations.contains(symbolFactory.createSymbol(
						SymbolCategory.HAND.getCategoryNumber(), handSymbolWithAllFillsAndRotations.getGroup(),
						handSymbolWithAllFillsAndRotations.getSymbol(),
						handSymbolWithAllFillsAndRotations.getVariation(), fill, rotation)));
			}
		}

		Symbol sameHandSymbolWithDifferentRotation = symbolFactory.createSymbol(SymbolCategory.HAND.getCategoryNumber(),
				1, 5, 1, 1, 2);

		Set<Symbol> allVariationsForSameHandSymbolWithDifferentRotation = symbolFactory
				.getAllRotationsAndFillsFor(sameHandSymbolWithDifferentRotation.getBaseSymbol());

		assertEquals(allVariationsForHandSymbolWithAllFillsAndRotations.size(),
				allVariationsForSameHandSymbolWithDifferentRotation.size());

		for (Symbol handSymbol : allVariationsForSameHandSymbolWithDifferentRotation) {
			assertTrue(allVariationsForHandSymbolWithAllFillsAndRotations.contains(handSymbol));
		}

		Symbol mirroredHandSymbolWithAllRotations = symbolFactory.createSymbol(SymbolCategory.HAND.getCategoryNumber(),
				1, 5, 1, 1, 11);

		Set<Symbol> allVariationsForMirroredHandSymbolWithAllRotations = symbolFactory
				.getAllRotationsAndFillsFor(mirroredHandSymbolWithAllRotations.getBaseSymbol());

		for (int rotation : allRotations) {
			for (int fill : allFills) {
				assertTrue(allVariationsForMirroredHandSymbolWithAllRotations.contains(symbolFactory.createSymbol(
						SymbolCategory.HAND.getCategoryNumber(), mirroredHandSymbolWithAllRotations.getGroup(),
						mirroredHandSymbolWithAllRotations.getSymbol(),
						mirroredHandSymbolWithAllRotations.getVariation(), fill, rotation)));
			}
		}

		for (int rotation : allMirroredRotations) {
			for (int fill : allFills) {
				assertTrue(allVariationsForMirroredHandSymbolWithAllRotations.contains(symbolFactory.createSymbol(
						SymbolCategory.HAND.getCategoryNumber(), mirroredHandSymbolWithAllRotations.getGroup(),
						mirroredHandSymbolWithAllRotations.getSymbol(),
						mirroredHandSymbolWithAllRotations.getVariation(), fill, rotation)));
			}
		}

		Symbol sameHandSymbolWithDifferentFill = symbolFactory.createSymbol(SymbolCategory.HAND.getCategoryNumber(), 1,
				5, 1, 2, 1);

		Set<Symbol> allVariationsForSameSymbolWithDifferentFill = symbolFactory
				.getAllRotationsAndFillsFor(sameHandSymbolWithDifferentFill.getBaseSymbol());

		assertEquals(allVariationsForHandSymbolWithAllFillsAndRotations.size(),
				allVariationsForSameSymbolWithDifferentFill.size());

		for (Symbol handSymbol : allVariationsForSameSymbolWithDifferentFill) {
			assertTrue(allVariationsForHandSymbolWithAllFillsAndRotations.contains(handSymbol));
		}

		Symbol handSymbolWithOneFill = symbolFactory.createSymbol(SymbolCategory.HAND.getCategoryNumber(), 5, 4, 1, 2,
				1);

		Set<Symbol> allVariationsForSymbolWithOneFill = symbolFactory
				.getAllRotationsAndFillsFor(handSymbolWithOneFill.getBaseSymbol());

		assertEquals(16, allVariationsForSymbolWithOneFill.size());

		for (int rotation : allRotations) {
			assertTrue(allVariationsForSymbolWithOneFill.contains(symbolFactory.createSymbol(
					SymbolCategory.HAND.getCategoryNumber(), handSymbolWithOneFill.getGroup(),
					handSymbolWithOneFill.getSymbol(), handSymbolWithOneFill.getVariation(), 2, rotation)));
		}
	}

	@Test
	public void testHeadPosturePlaceHolderSymbol() {
		Symbol headPosturePlaceholderSymbol = Symbol.HEAD_POSTURE_PLACEHOLDER_SYMBOL;
		assertTrue(symbolFactory.isValidSymbol(headPosturePlaceholderSymbol.getCategory(),
				headPosturePlaceholderSymbol.getGroup(), headPosturePlaceholderSymbol.getSymbol(),
				headPosturePlaceholderSymbol.getVariation(), headPosturePlaceholderSymbol.getFill(),
				headPosturePlaceholderSymbol.getFill()));
	}

	@Test
	public void testHeadComponentPlaceholderSymbol() {
		Symbol headComponentPlaceholderSymbol = Symbol.HEAD_COMPONENT_PLACEHOLDER_SYMBOL;
		assertTrue(symbolFactory.isValidSymbol(headComponentPlaceholderSymbol.getCategory(),
				headComponentPlaceholderSymbol.getGroup(), headComponentPlaceholderSymbol.getSymbol(),
				headComponentPlaceholderSymbol.getVariation(), headComponentPlaceholderSymbol.getFill(),
				headComponentPlaceholderSymbol.getFill()));
	}
}
