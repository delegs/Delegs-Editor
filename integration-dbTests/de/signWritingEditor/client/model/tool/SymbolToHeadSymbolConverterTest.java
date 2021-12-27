package de.signWritingEditor.client.model.tool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.tool.general.HeadSymbolLayouter;
import de.signWritingEditor.server.communication.infrastructure.SignDataDecoder;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.EarsBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.MouthBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NeckBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.NoseBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HeadSymbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;
import de.signWritingEditor.shared.model.material.PositionedBreathSymbol;
import de.signWritingEditor.shared.model.material.PositionedCheekSymbol;
import de.signWritingEditor.shared.model.material.PositionedEarsSymbol;
import de.signWritingEditor.shared.model.material.PositionedExpressionSymbol;
import de.signWritingEditor.shared.model.material.PositionedEyeSymbol;
import de.signWritingEditor.shared.model.material.PositionedHairSymbol;
import de.signWritingEditor.shared.model.material.PositionedHeadPostureSymbol;
import de.signWritingEditor.shared.model.material.PositionedJawSymbol;
import de.signWritingEditor.shared.model.material.PositionedMouthSymbol;
import de.signWritingEditor.shared.model.material.PositionedNeckSymbol;
import de.signWritingEditor.shared.model.material.PositionedNoseSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbol;
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.SymbolFactory;
import de.signWritingEditor.shared.model.material.SymbolToHeadSymbolConverter;

public class SymbolToHeadSymbolConverterTest {
	private SignDataDecoder signDataDecoder;
	private DbConnector connector;
	private PositionedSymbolFactory positionedSymbolFactory;
	private SymbolToHeadSymbolConverter headSymbolConverter;

	@Before
	public void setUp() throws Exception {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		signDataDecoder = new SignDataDecoder(new SymbolFactory(new SymbolDB(connector).getAllSymbols()));
		positionedSymbolFactory = new PositionedSymbolFactory();
		headSymbolConverter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testConvertToHeadSymbols() {
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);

		String signSchreck = "s20500x48y79z14s20500x119y81z13s22a00x109y118z15s22a10x69y120z16s2f700x67y112z1s2f700x109y109z3s31a00x0y30z4s31a00x31y30z7s31a00x61y31z5s31a00x92y31z6s31a30x129y41z17s31a30x160y39z19s34500x61y31z0s34700x122y31z2s34710x11y53z20s35d04x153y32z18s35d14x44y50z21s35d14x105y52z22s36e00x67y70z8s14c02x92y87z9s14c09x58y86z10s14c51x97y135z11s14c59x58y138z12";
		List<PositionedSymbol> schreckPositionedSymbols = signDataDecoder.decodePositionedSymbols(signSchreck);

		List<PositionedSymbol> schreckPositionedSymbolsSorted = new ArrayList<PositionedSymbol>(
				schreckPositionedSymbols);
		Comparator<PositionedSymbol> symbolXComparator = new Comparator<PositionedSymbol>() {
			@Override
			public int compare(PositionedSymbol symbol1, PositionedSymbol symbol2) {
				return symbol1.getX() - symbol2.getX();
			}
		};
		Collections.sort(schreckPositionedSymbolsSorted, symbolXComparator);

		List<Symbol> schreckMouthSymbols = new ArrayList<Symbol>();
		for (PositionedSymbol positionedSymbol : schreckPositionedSymbolsSorted) {
			Symbol symbol = positionedSymbol.getSymbol();

			if (MouthBaseSymbol.isAnyMouthSymbol(symbol)) {
				schreckMouthSymbols.add(symbol);
			}
		}

		List<HeadSymbol> convertedHeadSymbols = converter.convertToHeadSymbols(schreckPositionedSymbols);

		assertEquals(6, convertedHeadSymbols.size());

		for (int i = 0, l = convertedHeadSymbols.size(); i < l; i++) {
			HeadSymbol headSymbol = convertedHeadSymbols.get(i);

			List<PositionedEyeSymbol> eyes = PositionedEyeSymbol
					.convertToValidEyeSymbols(EyesBaseSymbol.EYES_WIDE_OPEN.getIswaSymbol());
			assertTrue("Not all eyes are included in the head", headSymbol.getPositionedEyeSymbols().containsAll(eyes));
			assertEquals(eyes.size(), headSymbol.getPositionedEyeSymbols().size());
			// Compare ISAW ids since there are differences in fill parameter
			// (with or without circle)
			assertEquals(schreckMouthSymbols.get(i).getIswaId().substring(0, 13),
					headSymbol.getPositionedMouthSymbol().getSymbol().getIswaId().substring(0, 13));
		}

		String onlyVisemes = "s34700x28y29z1s35d00x0y30z0s35d00x119y28z3s36100x89y29z2s00000x57y30z0";
		List<PositionedSymbol> onlyVisemesPositionedSymbols = signDataDecoder.decodePositionedSymbols(onlyVisemes);

		List<HeadSymbol> onlyVisemesExpectedHeadSymbols = new ArrayList<HeadSymbol>();
		onlyVisemesExpectedHeadSymbols.add(
				positionedSymbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 0,
						30, 0, positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 1, 5, 2, 1, 36, 35))));
		onlyVisemesExpectedHeadSymbols.add(
				positionedSymbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 28,
						29, 1, positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 4, 5, 1, 2, 1, 36, 35))));
		onlyVisemesExpectedHeadSymbols.add(
				positionedSymbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getEmptyHeadPostureSymbol(), 57,
						30, 0, positionedSymbolFactory.createPositionedSymbol(MouthBaseSymbol.NONE.getIswaSymbol())));
		onlyVisemesExpectedHeadSymbols.add(
				positionedSymbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 89,
						29, 2, positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 5, 1, 2, 1, 36, 35))));
		onlyVisemesExpectedHeadSymbols.add(positionedSymbolFactory.createHeadSymbol(
				PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(), 119, 28, 3,
				positionedSymbolFactory.createPositionedSymbol(new Symbol(4, 5, 1, 5, 2, 1, 36, 35))));

		assertEquals(onlyVisemesExpectedHeadSymbols, converter.convertToHeadSymbols(onlyVisemesPositionedSymbols));
	}

	@Test
	public void testConvertJawSymbolToHeadSymbol() {
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);
		ArrayList<PositionedSymbol> posSymbols = new ArrayList<PositionedSymbol>();

		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol(),
				-32, 30, 2));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol(),
				-2, 30, 1));

		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.LEFT, -33, 60, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol(),
				Location.BOTH, -21, 59, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.RIGHT, -2, 60, 3));

		List<HeadSymbol> convertToHeadSymbols = converter.convertToHeadSymbols(posSymbols);
		assertEquals(2, convertToHeadSymbols.size());

		HeadSymbol headSymbolOne = convertToHeadSymbols.get(0);
		HeadSymbol headSymbolTwo = convertToHeadSymbols.get(1);

		List<PositionedJawSymbol> positionedJawSymbols = headSymbolOne.getPositionedJawSymbols();
		assertEquals(3, positionedJawSymbols.size());
		assertEquals(0, headSymbolTwo.getPositionedJawSymbols().size());

		ArrayList<Symbol> jawSymbols = new ArrayList<Symbol>();

		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());

		for (PositionedJawSymbol positionedJawSymbol : positionedJawSymbols) {

			assertTrue(jawSymbols.contains(positionedJawSymbol.getSymbol()));
			jawSymbols.remove(positionedJawSymbol.getSymbol());

		}
		assertEquals(0, jawSymbols.size());

	}

	@Test
	public void testConvertMultipleJawSymbolsToHeadSymbols() {
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);
		ArrayList<PositionedSymbol> posSymbols = new ArrayList<PositionedSymbol>();

		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol(),
				-33, 30, 2));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol(),
				-3, 30, 1));

		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.LEFT, -34, 60, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol(),
				Location.BOTH, -22, 59, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.RIGHT, -3, 60, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.LEFT, -4, 60, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol(),
				Location.BOTH, 8, 59, 3));
		posSymbols.add(positionedSymbolFactory.createPositionedSymbol(
				JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.RIGHT, 27, 60, 3));

		List<HeadSymbol> convertToHeadSymbols = converter.convertToHeadSymbols(posSymbols);
		assertEquals(2, convertToHeadSymbols.size());

		HeadSymbol headSymbolOne = convertToHeadSymbols.get(0);
		HeadSymbol headSymbolTwo = convertToHeadSymbols.get(1);

		List<PositionedJawSymbol> positionedJawSymbolsHeadOne = headSymbolOne.getPositionedJawSymbols();
		assertEquals(3, positionedJawSymbolsHeadOne.size());
		assertEquals(3, headSymbolTwo.getPositionedJawSymbols().size());

		ArrayList<Symbol> jawSymbols = new ArrayList<Symbol>();

		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());

		for (PositionedJawSymbol positionedJawSymbol : positionedJawSymbolsHeadOne) {

			assertTrue(jawSymbols.contains(positionedJawSymbol.getSymbol()));
			jawSymbols.remove(positionedJawSymbol.getSymbol());

		}
		assertEquals(0, jawSymbols.size());

		List<PositionedJawSymbol> positionedJawSymbolsHeadTwo = headSymbolOne.getPositionedJawSymbols();
		assertEquals(3, positionedJawSymbolsHeadTwo.size());

		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol());
		jawSymbols.add(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol());

		for (PositionedJawSymbol positionedJawSymbol : positionedJawSymbolsHeadTwo) {

			assertTrue(jawSymbols.contains(positionedJawSymbol.getSymbol()));
			jawSymbols.remove(positionedJawSymbol.getSymbol());

		}
		assertEquals(0, jawSymbols.size());

	}

	@Test
	public void testConvertPositionedSymbolsToOneHeadSymbolWithMouthAndHair() {
		// Prepare
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);

		PositionedHairSymbol hair = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol());
		PositionedMouthSymbol mouth = (PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_CLOSED_CONTACT.getIswaSymbol());
		HeadSymbol expectedHeadSymbol = createEmptyHead();
		expectedHeadSymbol.setMouthSymbol(mouth);
		expectedHeadSymbol.setHairSymbol(hair);
		List<PositionedSymbol> sourceSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				expectedHeadSymbol, expectedHeadSymbol.getX(), expectedHeadSymbol.getY(), expectedHeadSymbol.getZ());

		List<HeadSymbol> allConvertedHeadSymbols;
		HeadSymbol actualHeadSymbol;

		// Action
		allConvertedHeadSymbols = converter.convertToHeadSymbols(sourceSymbols);

		// Check
		assertEquals(1, allConvertedHeadSymbols.size());
		actualHeadSymbol = allConvertedHeadSymbols.get(0);

		assertEquals(expectedHeadSymbol, actualHeadSymbol);

	}

	@Test
	public void testConvertPositionedSymbolsToOneHeadSymbolWithHair() {
		// Prepare
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);

		PositionedHairSymbol hair = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol());
		HeadSymbol expectedHeadSymbol = createEmptyHead();
		expectedHeadSymbol.setHairSymbol(hair);
		List<PositionedSymbol> sourceSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				expectedHeadSymbol, expectedHeadSymbol.getX(), expectedHeadSymbol.getY(), expectedHeadSymbol.getZ());

		List<HeadSymbol> allConvertedHeadSymbols;
		HeadSymbol actualHeadSymbol;

		// Action
		allConvertedHeadSymbols = converter.convertToHeadSymbols(sourceSymbols);

		// Check
		assertEquals(1, allConvertedHeadSymbols.size());
		actualHeadSymbol = allConvertedHeadSymbols.get(0);

		assertEquals(expectedHeadSymbol, actualHeadSymbol);
	}

	@Test
	public void testConvertHeadSybolToPositionedSymbols() {
		// Prepare
		HeadSymbol headSymbol = createEmptyHead();
		headSymbol.setMouthSymbol((PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_CLOSED_CONTACT.getIswaSymbol()));

		// Action
		List<PositionedSymbol> headSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol,
				0, 0, 1);

		// Check
		assertEquals(2, headSymbols.size());
		assertFalse("PositionedSymbol-types are not supposed to be equal.",
				headSymbols.get(0).getClass().equals(headSymbols.get(1).getClass()));

		for (PositionedSymbol positionedSymbol : headSymbols) {
			if (positionedSymbol instanceof PositionedHeadPostureSymbol) {
				assertEquals(0, positionedSymbol.getX());
				assertEquals(0, positionedSymbol.getY());
				assertEquals(1, positionedSymbol.getZ());
			} else if (positionedSymbol instanceof PositionedMouthSymbol) {
				int[] relativeMouthPosition = headSymbol.getRelativeMouthSymbolPosition(positionedSymbol.getWidth(),
						positionedSymbol.getHeight());
				int[] relativeHeadCenterPosition = headSymbol.getRelativeHeadCenterPosition();
				int[] absoluteMouthPosition = new int[] { //
						relativeMouthPosition[0] + relativeHeadCenterPosition[0] + headSymbol.getX(), //
						relativeMouthPosition[1] + relativeHeadCenterPosition[1] + headSymbol.getY(), //
						relativeMouthPosition[2] + relativeHeadCenterPosition[2] + headSymbol.getZ(), };

				assertEquals(absoluteMouthPosition[0], positionedSymbol.getX());
				assertEquals(absoluteMouthPosition[1], positionedSymbol.getY());
				assertEquals(absoluteMouthPosition[2], positionedSymbol.getZ());

			} else {
				fail("Unexpected PositionedSymbol type.");
			}
		}
	}

	@Test
	public void testConvertPositionedSymbolsToOneHeadSymbolWithMouth() {
		// Prepare
		SymbolToHeadSymbolConverter converter = new SymbolToHeadSymbolConverter(positionedSymbolFactory);

		PositionedMouthSymbol mouth = (PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_CLOSED_CONTACT.getIswaSymbol());
		HeadSymbol expectedHeadSymbol = createEmptyHead();
		expectedHeadSymbol.setMouthSymbol(mouth);
		List<PositionedSymbol> sourceSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				expectedHeadSymbol, expectedHeadSymbol.getX(), expectedHeadSymbol.getY(), expectedHeadSymbol.getZ());
		List<HeadSymbol> allConvertedHeadSymbols;
		HeadSymbol actualHeadSymbol;

		// Action
		allConvertedHeadSymbols = converter.convertToHeadSymbols(sourceSymbols);

		// Check
		assertEquals(1, allConvertedHeadSymbols.size());
		actualHeadSymbol = allConvertedHeadSymbols.get(0);

		assertEquals(expectedHeadSymbol, actualHeadSymbol);

	}

	@Test
	public void testGetPositionedSymbolsForEmptySymbol() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(1, positionedSymbols.size());
		PositionedSymbol emptySymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 99, 999, 99, 1, 1, 36, 35), 0, 0, 1);
		assertEquals(emptySymbol, positionedSymbols.get(0));
	}

	@Test
	public void testGetPositionedSymbolsForStandardHeadPosture() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(1, positionedSymbols.size());
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		assertEquals(expectedHeadPosture, positionedSymbols.get(0));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndDoubleEyes() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol
				.setEyeSymbols(PositionedEyeSymbol.convertToValidEyeSymbols(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(3, positionedSymbols.size());
		PositionedSymbol expectedLeftEye = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 8, 4), Location.LEFT, 8, 8, 2);
		PositionedSymbol expectedRightEye = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 8, 4), Location.RIGHT, 20, 8, 2);
		assertTrue(positionedSymbols.contains(expectedLeftEye));
		assertTrue(positionedSymbols.contains(expectedRightEye));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndSingleEye() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		// EyesBaseSymbol.FOREHEAD_NEUTRAL is a special case where only the left
		// eye is displayed, because one symbol stands for both eyes
		List<PositionedEyeSymbol> eyeSymbol = new ArrayList<PositionedEyeSymbol>();
		eyeSymbol.add((PositionedEyeSymbol) positionedSymbolFactory
				.createPositionedSymbol((EyesBaseSymbol.FOREHEAD_NEUTRAL.getIswaSymbol()), Location.BOTH));
		emptyHeadSymbol.setEyeSymbols(eyeSymbol);

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedEye = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 3, 1, 2, 1, 12, 2), Location.BOTH, 12, 9, 2);
		assertTrue(positionedSymbols.contains(expectedEye));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndEyesExtra() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		// EyesBaseSymbol.EYE_BLINK_SINGLE is a special case where two EYES_OPEN
		// need to be added
		emptyHeadSymbol.setEyeSymbols(
				PositionedEyeSymbol.convertToValidEyeSymbols(EyesBaseSymbol.EYE_BLINK_SINGLE.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(5, positionedSymbols.size());
		PositionedSymbol expectedLeftEye = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 4, 5, 1, 11, 4), Location.LEFT, 5, 11, 2);
		PositionedSymbol expectedLeftEyeExtra = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 8, 4), Location.LEFT, 8, 5, 2);
		PositionedSymbol expectedRightEye = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 4, 4, 1, 11, 4), Location.RIGHT, 20, 11, 2);
		PositionedSymbol expectedRightEyeExtra = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 4, 1, 5, 1, 8, 4), Location.RIGHT, 20, 5, 2);
		assertTrue(positionedSymbols.contains(expectedLeftEye));
		assertTrue(positionedSymbols.contains(expectedLeftEyeExtra));
		assertTrue(positionedSymbols.contains(expectedRightEye));
		assertTrue(positionedSymbols.contains(expectedRightEyeExtra));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndMouth() {
		// Prepare
		HeadSymbol headSymbol = createEmptyHead();
		headSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		headSymbol.setMouthSymbol((PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter
				.getPositionedSymbolsForHeadSymbol(headSymbol, headSymbol.getX(), headSymbol.getY(), headSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedMouth = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 4, 5, 1, 2, 1, 14, 6), 11, 22, 2);
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol(), 0, 0, 1);
		assertTrue(positionedSymbols.contains(expectedMouth));
		assertTrue(positionedSymbols.contains(expectedHeadPosture));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndBreath() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		List<PositionedBreathSymbol> breathSymbols = new ArrayList<PositionedBreathSymbol>();
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getLeftBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.LEFT));
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getRightBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.RIGHT));

		emptyHeadSymbol.setBreathSymbols(breathSymbols);

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(3, positionedSymbols.size());
		PositionedSymbol expectedLeftBreath = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 6, 1, 17, 22), Location.LEFT, 0, 13, 2);
		PositionedSymbol expectedRightBreath = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 5, 1, 17, 22), Location.RIGHT, 31, 13, 2);

		assertTrue(positionedSymbols.contains(expectedLeftBreath));
		assertTrue(positionedSymbols.contains(expectedRightBreath));
	}

	@Test
	public void testGetPositionedSymbolsForHeadAndCheeks() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol.setCheekSymbols(
				PositionedCheekSymbol.convertToValidCheeksSymbol(CheeksBaseSymbol.CHEEKS_PUFFED.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(3, positionedSymbols.size());
		PositionedSymbol expectedLeftCheek = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 1, 4, 1, 9, 15), Location.LEFT, 0, 10, 2);
		PositionedSymbol expectedRightCheek = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 1, 5, 1, 9, 15), Location.RIGHT, 27, 10, 2);

		assertTrue(positionedSymbols.contains(expectedLeftCheek));
		assertTrue(positionedSymbols.contains(expectedRightCheek));

	}

	@Test
	public void testGetPositionedSymbolsForHeadAndNeck() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol.setNeckSymbol((PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(NeckBaseSymbol.NECK.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		PositionedSymbol expectedNeckSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 11, 1, 2, 1, 20, 13), 8, 33, 2);

		assertTrue(positionedSymbols.contains(expectedHeadSymbol));
		assertTrue(positionedSymbols.contains(expectedNeckSymbol));

	}

	@Test
	public void testGetPositionedSymbolsForHeadAndHair() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol.setHairSymbol((PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 0, 1, 1);
		PositionedSymbol expectedHairSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 12, 1, 2, 1, 36, 36), 0, 0, 2);

		assertTrue(positionedSymbols.contains(expectedHeadSymbol));
		assertTrue(positionedSymbols.contains(expectedHairSymbol));

	}

	@Test
	public void testGetPositionedSymbolsForHeadAndExpression() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 5, 6, 1);
		PositionedSymbol expectedExpressionSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 13, 1, 2, 1, 47, 47), 0, 0, 2);

		assertTrue(positionedSymbols.contains(expectedHeadSymbol));
		assertTrue(positionedSymbols.contains(expectedExpressionSymbol));

	}

	@Test
	public void testGetPositionedSymbolsForHeadPostureAndExpression() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol((PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.HEAD_MOVEMENT_STRAIGHT_WALL_PLANE.getIswaSymbol()));
		emptyHeadSymbol.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 3, 1, 1, 1, 36, 46), 5, 0, 1);
		PositionedSymbol expectedExpressionSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 13, 1, 2, 1, 47, 47), 0, 5, 2);

		assertTrue(positionedSymbols.contains(expectedHeadPosture));
		assertTrue(positionedSymbols.contains(expectedExpressionSymbol));

	}

	@Test
	public void testGetPositionedSymbolsForHeadAndEars() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		List<PositionedEarsSymbol> earsSymbol = new ArrayList<PositionedEarsSymbol>();
		earsSymbol.add((PositionedEarsSymbol) positionedSymbolFactory.createPositionedSymbol(
				EarsBaseSymbol.getRightEarFor(EarsBaseSymbol.EARS.getIswaSymbol()), Location.RIGHT));
		emptyHeadSymbol.setEarSymbols(earsSymbol);

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		PositionedSymbol expectedEarsSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 4, 1, 10, 14), Location.RIGHT, 32, 10, 2);

		assertTrue(positionedSymbols.contains(expectedHeadPosture));
		assertTrue(positionedSymbols.contains(expectedEarsSymbol));

	}

	@Test
	public void testGetPositionedSymbolForEarsAndExpression() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		List<PositionedEarsSymbol> earsSymbol = new ArrayList<PositionedEarsSymbol>();
		earsSymbol.addAll(PositionedEarsSymbol.convertToValidEarsSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35)));
		emptyHeadSymbol.setEarSymbols(earsSymbol);
		emptyHeadSymbol.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(4, positionedSymbols.size());
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 6, 6, 1);
		PositionedSymbol expectedLeftEarSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 5, 1, 10, 14), Location.LEFT, 0, 16, 2);
		PositionedSymbol expectedRightEarSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 4, 1, 10, 14), Location.RIGHT, 38, 16, 2);
		PositionedSymbol expectedExpressionSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 13, 1, 2, 1, 47, 47), 1, 0, 2);

		assertTrue(positionedSymbols.contains(expectedHeadPosture));
		assertTrue(positionedSymbols.contains(expectedLeftEarSymbol));
		assertTrue(positionedSymbols.contains(expectedRightEarSymbol));
		assertTrue(positionedSymbols.contains(expectedExpressionSymbol));

	}

	@Test
	public void testGetPositionedSymbolsForHeadAndNose() {
		// Prepare
		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());
		emptyHeadSymbol.setNoseSymbol((PositionedNoseSymbol) positionedSymbolFactory
				.createPositionedSymbol(NoseBaseSymbol.NOSE_CONTACT.getIswaSymbol()));

		// Action
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(
				emptyHeadSymbol, emptyHeadSymbol.getX(), emptyHeadSymbol.getY(), emptyHeadSymbol.getZ());

		// Check
		assertNotNull(positionedSymbols);
		assertEquals(2, positionedSymbols.size());
		PositionedSymbol expectedHeadPosture = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 1, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		PositionedSymbol expectedNoseSymbol = positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 4, 2, 2, 1, 10, 13), 13, 11, 2);

		assertTrue(positionedSymbols.contains(expectedHeadPosture));
		assertTrue(positionedSymbols.contains(expectedNoseSymbol));

	}

	@Test
	public void testConvertLegacyEyeSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols1 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol1 = new PositionedSymbol(new Symbol(4, 2, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		positionedSymbols1.add(positionedSymbol1);

		List<PositionedSymbol> positionedSymbols2 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol2 = new PositionedSymbol(new Symbol(4, 2, 1, 1, 2, 1, 36, 35), 0, 0, 1);
		positionedSymbols2.add(positionedSymbol2);

		List<PositionedSymbol> positionedSymbols3 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol3 = new PositionedSymbol(new Symbol(4, 2, 1, 1, 3, 1, 36, 35), 0, 0, 1);
		positionedSymbols3.add(positionedSymbol3);

		List<PositionedSymbol> positionedSymbols4 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol4 = new PositionedSymbol(new Symbol(4, 2, 1, 1, 4, 1, 23, 10), 0, 0, 1);
		positionedSymbols4.add(positionedSymbol4);

		// Action

		List<HeadSymbol> headSymbol1 = headSymbolConverter.convertToHeadSymbols(positionedSymbols1);
		List<HeadSymbol> headSymbol2 = headSymbolConverter.convertToHeadSymbols(positionedSymbols2);
		List<HeadSymbol> headSymbol3 = headSymbolConverter.convertToHeadSymbols(positionedSymbols3);
		List<HeadSymbol> headSymbol4 = headSymbolConverter.convertToHeadSymbols(positionedSymbols4);

		// Check
		HeadSymbol headSymbol = null;
		PositionedEyeSymbol expectedLeftEye = (PositionedEyeSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 1, 1, 6, 1, 10, 10), Location.LEFT);
		PositionedEyeSymbol expectedRightEye = (PositionedEyeSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 2, 1, 1, 5, 1, 10, 10), Location.RIGHT);

		assertEquals(1, headSymbol1.size());
		headSymbol = headSymbol1.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedEyeSymbols().size());
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedLeftEye));
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedRightEye));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol2.size());
		headSymbol = headSymbol2.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedEyeSymbols().size());
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedRightEye));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol3.size());
		headSymbol = headSymbol3.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedEyeSymbols().size());
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedLeftEye));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol4.size());
		headSymbol = headSymbol4.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedEyeSymbols().size());
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedLeftEye));
		assertTrue(headSymbol.getPositionedEyeSymbols().contains(expectedRightEye));
		assertEquals(-6, headSymbol.getX());
		assertEquals(-5, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyMouthSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(4, 4, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		positionedSymbols.add(positionedSymbol);

		// Action
		List<HeadSymbol> headSymbolList = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		HeadSymbol headSymbol = null;
		PositionedMouthSymbol expectedMouthSymbol = (PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 4, 1, 1, 2, 1, 14, 2));

		assertEquals(1, headSymbolList.size());
		headSymbol = headSymbolList.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(expectedMouthSymbol, headSymbol.getPositionedMouthSymbol());
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyNoseSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(4, 3, 4, 1, 1, 1, 36, 35), 0, 0, 1);
		positionedSymbols.add(positionedSymbol);

		// Action
		List<HeadSymbol> headSymbolList = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		HeadSymbol headSymbol = null;
		PositionedNoseSymbol expectedNoseSymbol = (PositionedNoseSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 4, 1, 2, 1, 2, 12));

		assertEquals(1, headSymbolList.size());
		headSymbol = headSymbolList.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(expectedNoseSymbol, headSymbol.getPositionedNoseSymbol());
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyNeckSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(4, 5, 11, 1, 1, 1, 36, 46), 0, 0, 1);
		positionedSymbols.add(positionedSymbol);

		// Action
		List<HeadSymbol> headSymbolList = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		HeadSymbol headSymbol = null;
		PositionedNeckSymbol expectedNeckSymbol = (PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 11, 1, 2, 1, 20, 13));

		assertEquals(1, headSymbolList.size());
		headSymbol = headSymbolList.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(expectedNeckSymbol, headSymbol.getPositionedNeckSymbol());
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyHairSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(4, 5, 12, 1, 1, 1, 36, 36), 0, 0, 1);
		positionedSymbols.add(positionedSymbol);

		// Action
		List<HeadSymbol> headSymbolList = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		HeadSymbol headSymbol = null;
		PositionedHairSymbol expectedHairSymbol = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 12, 1, 2, 1, 36, 36));

		assertEquals(1, headSymbolList.size());
		headSymbol = headSymbolList.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(expectedHairSymbol, headSymbol.getPositionedHairSymbol());
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyExpressionSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol = new PositionedSymbol(new Symbol(4, 5, 13, 1, 1, 1, 47, 47), 0, 0, 1);
		positionedSymbols.add(positionedSymbol);

		// Action
		List<HeadSymbol> headSymbolList = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		HeadSymbol headSymbol = null;
		PositionedExpressionSymbol expectedExpressionSymbol = (PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 13, 1, 2, 1, 47, 47));

		assertEquals(1, headSymbolList.size());
		headSymbol = headSymbolList.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(expectedExpressionSymbol, headSymbol.getPositionedExpressionSymbol());
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyCheekSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols1 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol1 = new PositionedSymbol(new Symbol(4, 3, 1, 1, 1, 1, 36, 35), 0, 0, 1);
		positionedSymbols1.add(positionedSymbol1);

		List<PositionedSymbol> positionedSymbols2 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol2 = new PositionedSymbol(new Symbol(4, 3, 1, 1, 2, 1, 36, 35), 0, 0, 1);
		positionedSymbols2.add(positionedSymbol2);

		List<PositionedSymbol> positionedSymbols3 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol3 = new PositionedSymbol(new Symbol(4, 3, 1, 1, 3, 1, 36, 35), 0, 0, 1);
		positionedSymbols3.add(positionedSymbol3);

		// Action
		List<HeadSymbol> headSymbol1 = headSymbolConverter.convertToHeadSymbols(positionedSymbols1);
		List<HeadSymbol> headSymbol2 = headSymbolConverter.convertToHeadSymbols(positionedSymbols2);
		List<HeadSymbol> headSymbol3 = headSymbolConverter.convertToHeadSymbols(positionedSymbols3);

		// Check
		HeadSymbol headSymbol = null;
		PositionedCheekSymbol expectedLeftCheek = (PositionedCheekSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 1, 4, 1, 9, 15), Location.LEFT);
		PositionedCheekSymbol expectedRightCheek = (PositionedCheekSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 1, 1, 5, 1, 9, 15), Location.RIGHT);

		assertEquals(1, headSymbol1.size());
		headSymbol = headSymbol1.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedCheekSymbols().size());
		assertTrue(headSymbol.getPositionedCheekSymbols().contains(expectedLeftCheek));
		assertTrue(headSymbol.getPositionedCheekSymbols().contains(expectedRightCheek));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol2.size());
		headSymbol = headSymbol2.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedCheekSymbols().size());
		assertTrue(headSymbol.getPositionedCheekSymbols().contains(expectedRightCheek));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol3.size());
		headSymbol = headSymbol3.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedCheekSymbols().size());
		assertTrue(headSymbol.getPositionedCheekSymbols().contains(expectedLeftCheek));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyEarsSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols1 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol1 = new PositionedSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35), 0, 0, 1);
		positionedSymbols1.add(positionedSymbol1);

		List<PositionedSymbol> positionedSymbols2 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol2 = new PositionedSymbol(new Symbol(4, 3, 3, 1, 2, 1, 42, 35), 0, 0, 1);
		positionedSymbols2.add(positionedSymbol2);

		List<PositionedSymbol> positionedSymbols3 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol3 = new PositionedSymbol(new Symbol(4, 3, 3, 1, 3, 1, 42, 35), 0, 0, 1);
		positionedSymbols3.add(positionedSymbol3);

		// Action
		List<HeadSymbol> headSymbol1 = headSymbolConverter.convertToHeadSymbols(positionedSymbols1);
		List<HeadSymbol> headSymbol2 = headSymbolConverter.convertToHeadSymbols(positionedSymbols2);
		List<HeadSymbol> headSymbol3 = headSymbolConverter.convertToHeadSymbols(positionedSymbols3);

		// Check
		HeadSymbol headSymbol = null;
		PositionedEarsSymbol expectedLeftEar = (PositionedEarsSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 5, 1, 10, 14), Location.LEFT);
		PositionedEarsSymbol expectedRightEar = (PositionedEarsSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 3, 1, 4, 1, 10, 14), Location.RIGHT);

		assertEquals(1, headSymbol1.size());
		headSymbol = headSymbol1.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedEarSymbols().size());
		assertTrue(headSymbol.getPositionedEarSymbols().contains(expectedLeftEar));
		assertTrue(headSymbol.getPositionedEarSymbols().contains(expectedRightEar));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol2.size());
		headSymbol = headSymbol2.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedEarSymbols().size());
		assertTrue(headSymbol.getPositionedEarSymbols().contains(expectedRightEar));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol3.size());
		headSymbol = headSymbol3.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedEarSymbols().size());
		assertTrue(headSymbol.getPositionedEarSymbols().contains(expectedLeftEar));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyBreathSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols1 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol1 = new PositionedSymbol(new Symbol(4, 3, 5, 1, 1, 1, 48, 35), 0, 0, 1);
		positionedSymbols1.add(positionedSymbol1);

		List<PositionedSymbol> positionedSymbols2 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol2 = new PositionedSymbol(new Symbol(4, 3, 5, 1, 2, 1, 42, 35), 0, 0, 1);
		positionedSymbols2.add(positionedSymbol2);

		List<PositionedSymbol> positionedSymbols3 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol3 = new PositionedSymbol(new Symbol(4, 3, 5, 1, 3, 1, 42, 35), 0, 0, 1);
		positionedSymbols3.add(positionedSymbol3);

		List<PositionedSymbol> positionedSymbols4 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol4 = new PositionedSymbol(new Symbol(4, 3, 5, 1, 4, 1, 48, 22), 0, 0, 1);
		positionedSymbols4.add(positionedSymbol4);

		// Action
		List<HeadSymbol> headSymbol1 = headSymbolConverter.convertToHeadSymbols(positionedSymbols1);
		List<HeadSymbol> headSymbol2 = headSymbolConverter.convertToHeadSymbols(positionedSymbols2);
		List<HeadSymbol> headSymbol3 = headSymbolConverter.convertToHeadSymbols(positionedSymbols3);
		List<HeadSymbol> headSymbol4 = headSymbolConverter.convertToHeadSymbols(positionedSymbols4);

		// Check
		HeadSymbol headSymbol = null;
		PositionedBreathSymbol expectedLeftBreath = (PositionedBreathSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 6, 1, 17, 22), Location.LEFT);
		PositionedBreathSymbol expectedRightBreath = (PositionedBreathSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 3, 5, 1, 5, 1, 17, 22), Location.RIGHT);

		assertEquals(1, headSymbol1.size());
		headSymbol = headSymbol1.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedBreathSymbols().size());
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedLeftBreath));
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedRightBreath));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol2.size());
		headSymbol = headSymbol2.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedBreathSymbols().size());
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedRightBreath));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol3.size());
		headSymbol = headSymbol3.get(0);
		assertEquals(2, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(1, headSymbol.getPositionedBreathSymbols().size());
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedLeftBreath));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());

		assertEquals(1, headSymbol4.size());
		headSymbol = headSymbol4.get(0);
		assertEquals(3, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(2, headSymbol.getPositionedBreathSymbols().size());
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedLeftBreath));
		assertTrue(headSymbol.getPositionedBreathSymbols().contains(expectedRightBreath));
		assertEquals(0, headSymbol.getX());
		assertEquals(-13, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testConvertLegacyJawSymbols() {
		// Prepare
		List<PositionedSymbol> positionedSymbols1 = new ArrayList<PositionedSymbol>();
		PositionedSymbol positionedSymbol1 = new PositionedSymbol(new Symbol(4, 5, 9, 1, 1, 1, 42, 38), 0, 0, 1);
		positionedSymbols1.add(positionedSymbol1);

		// Action
		List<HeadSymbol> headSymbol1 = headSymbolConverter.convertToHeadSymbols(positionedSymbols1);

		// Check
		HeadSymbol headSymbol = null;
		PositionedJawSymbol expectedLeftJaw = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 9, 1, 2, 1, 8, 9), Location.LEFT);
		PositionedJawSymbol expectedRightJaw = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(new Symbol(4, 5, 9, 1, 2, 1, 8, 9), Location.RIGHT);
		PositionedJawSymbol expectedCenterJaw = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(Symbol.JAW_PART_HEAD_RIM, Location.BOTH);

		assertEquals(1, headSymbol1.size());
		headSymbol = headSymbol1.get(0);
		assertEquals(4, headSymbol.getAllPositionedSymbols().size());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				headSymbol.getPositionedHeadPostureSymbol());
		assertEquals(3, headSymbol.getPositionedJawSymbols().size());
		assertTrue(headSymbol.getPositionedJawSymbols().contains(expectedLeftJaw));
		assertTrue(headSymbol.getPositionedJawSymbols().contains(expectedRightJaw));
		assertTrue(headSymbol.getPositionedJawSymbols().contains(expectedCenterJaw));
		assertEquals(0, headSymbol.getX());
		assertEquals(0, headSymbol.getY());
		assertEquals(1, headSymbol.getZ());
	}

	@Test
	public void testChangeColorOfPositionedSymbols() {
		// Prepare
		PositionedHeadPostureSymbol headPosture = (PositionedHeadPostureSymbol) positionedSymbolFactory
				.createPositionedSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol());
		PositionedHairSymbol hair = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol());
		PositionedEyeSymbol eye = (PositionedEyeSymbol) positionedSymbolFactory
				.createPositionedSymbol(EyesBaseSymbol.DREAMY_EYEBROWS_NEUTRAL_DOWN.getIswaSymbol(), Location.RIGHT);
		PositionedCheekSymbol cheek = (PositionedCheekSymbol) positionedSymbolFactory
				.createPositionedSymbol(CheeksBaseSymbol.CHEEKS_NEUTRAL.getIswaSymbol(), Location.RIGHT);
		PositionedEarsSymbol ear = (PositionedEarsSymbol) positionedSymbolFactory
				.createPositionedSymbol(EarsBaseSymbol.EARS.getIswaSymbol(), Location.LEFT);
		PositionedMouthSymbol mouth = (PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_CLOSED_CONTACT.getIswaSymbol());
		PositionedBreathSymbol breath = (PositionedBreathSymbol) positionedSymbolFactory
				.createPositionedSymbol(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol(), Location.LEFT);
		PositionedJawSymbol jawLeft = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.LEFT);
		PositionedJawSymbol jawRight = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), Location.RIGHT);
		PositionedJawSymbol jawCenter = (PositionedJawSymbol) positionedSymbolFactory
				.createPositionedSymbol(JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol(), Location.BOTH);
		PositionedNeckSymbol neck = (PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(NeckBaseSymbol.NECK.getIswaSymbol());
		PositionedExpressionSymbol expression = (PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol());

		ArrayList<PositionedEyeSymbol> eyeList = new ArrayList<PositionedEyeSymbol>();
		eyeList.add(eye);

		HeadSymbol headSymbol = positionedSymbolFactory.createHeadSymbol(headPosture, hair, eye, cheek, ear, mouth,
				breath, jawLeft, jawRight, jawCenter, neck, expression);

		// Action
		headSymbol.setLineColor(Color.makeFromRGB(255, 0, 0));

		// Check
		List<PositionedSymbol> positionedSymbols = SymbolToHeadSymbolConverter
				.getPositionedSymbolsForHeadSymbol(headSymbol, 0, 0, 0);
		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			assertEquals("#FF0000", positionedSymbol.getLineColor().getCssValue());
		}
	}

	@Test
	public void testConvertKomplexEyesSymbols() {
		// Prepare
		Symbol headCircleSymbol = new Symbol(4, 1, 1, 1, 1, 1, 36, 35);
		Symbol rightEyeSymbol = new Symbol(4, 2, 8, 1, 3, 2, 7, 7);
		Symbol leftEyeSymbol = new Symbol(4, 2, 8, 1, 3, 2, 7, 7);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(headCircleSymbol, 0, 0, 1));
		symbolsToConvert.add(new PositionedSymbol(leftEyeSymbol, 9, 9, 1));
		symbolsToConvert.add(new PositionedSymbol(rightEyeSymbol, 20, 9, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);
		List<PositionedEyeSymbol> positionedEyeSymbols = resultOfConversion.get(0).getPositionedEyeSymbols();
		PositionedEyeSymbol firstEye = positionedEyeSymbols.get(0);
		PositionedEyeSymbol secondEye = positionedEyeSymbols.get(1);

		// Check
		assertEquals(2, positionedEyeSymbols.size());
		assertTrue(firstEye.getLocation() == Location.LEFT || secondEye.getLocation() == Location.LEFT);
		assertTrue(firstEye.getLocation() == Location.RIGHT || secondEye.getLocation() == Location.RIGHT);

	}

	@Test
	public void testConvertFalsePositionedLeftCheekSymbols() {
		// Prepare
		Symbol headCircleSymbol = new Symbol(4, 1, 1, 1, 1, 1, 36, 35);
		Symbol leftCheekSymbol = new Symbol(4, 3, 1, 1, 5, 1, 9, 15);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(headCircleSymbol, 0, 0, 1));
		symbolsToConvert.add(new PositionedSymbol(leftCheekSymbol, 27, 10, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);
		PositionedCheekSymbol cheekSymbol = resultOfConversion.get(0).getPositionedCheekSymbols().get(0);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(cheekSymbol.getLocation() == Location.RIGHT);
		assertEquals(0, cheekSymbol.getX());
		assertTrue(CheeksBaseSymbol.isRightCheek(cheekSymbol.getSymbol()));
	}

	@Test
	public void testConvertFalsePositionedRightCheekSymbols() {
		// Prepare
		Symbol headCircleSymbol = new Symbol(4, 1, 1, 1, 1, 1, 36, 35);
		Symbol rightCheekSymbol = new Symbol(4, 3, 1, 1, 4, 1, 9, 15);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(headCircleSymbol, 0, 0, 1));
		symbolsToConvert.add(new PositionedSymbol(rightCheekSymbol, 0, 10, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);
		PositionedCheekSymbol cheekSymbol = resultOfConversion.get(0).getPositionedCheekSymbols().get(0);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(cheekSymbol.getLocation() == Location.LEFT);
		assertEquals(0, cheekSymbol.getX());
		assertTrue(CheeksBaseSymbol.isLeftCheek(cheekSymbol.getSymbol()));
	}

	@Test
	public void testConvertRightBreathSymbolWithHead() {
		// Prepare
		Symbol rightBreathSymbolsWithHead = new Symbol(4, 3, 5, 2, 2, 1, 42, 35);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(rightBreathSymbolsWithHead, 0, 0, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);
		PositionedBreathSymbol breathSymbol = resultOfConversion.get(0).getPositionedBreathSymbols().get(0);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(resultOfConversion.get(0).hasBreath());
		assertEquals(1, resultOfConversion.get(0).getPositionedBreathSymbols().size());
		assertTrue(breathSymbol.getLocation() == Location.RIGHT);
	}

	@Test
	public void testConvertLeftBreathSymbolWithHead() {
		// Prepare
		Symbol leftBreathSymbolsWithHead = new Symbol(4, 3, 5, 2, 3, 1, 42, 35);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(leftBreathSymbolsWithHead, 0, 0, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);
		PositionedBreathSymbol breathSymbol = resultOfConversion.get(0).getPositionedBreathSymbols().get(0);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(resultOfConversion.get(0).hasBreath());
		assertEquals(1, resultOfConversion.get(0).getPositionedBreathSymbols().size());
		assertTrue(breathSymbol.getLocation() == Location.LEFT);
	}

	@Test
	public void testConvertBothBreathSymbolsWithHeadSymbols() {
		// Prepare
		Symbol bothBreathSymbolsWithHead = new Symbol(4, 3, 5, 2, 1, 1, 48, 35);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(bothBreathSymbolsWithHead, 0, 0, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);

		PositionedBreathSymbol breathSymbol_1 = resultOfConversion.get(0).getPositionedBreathSymbols().get(0);
		PositionedBreathSymbol breathSymbol_2 = resultOfConversion.get(0).getPositionedBreathSymbols().get(1);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(resultOfConversion.get(0).hasBreath());
		assertEquals(2, resultOfConversion.get(0).getPositionedBreathSymbols().size());
		assertTrue(breathSymbol_1.getLocation() == Location.LEFT || breathSymbol_2.getLocation() == Location.LEFT);
		assertTrue(breathSymbol_1.getLocation() == Location.RIGHT || breathSymbol_2.getLocation() == Location.RIGHT);
	}

	@Test
	public void testConvertBothBreathSymbolsWithoutHeadSymbols() {
		// Prepare
		Symbol bothBreathSymbolsWithoutHead = new Symbol(4, 3, 5, 2, 4, 1, 48, 22);
		List<PositionedSymbol> symbolsToConvert = new ArrayList<PositionedSymbol>();

		// Action
		symbolsToConvert.add(new PositionedSymbol(bothBreathSymbolsWithoutHead, 0, 0, 1));
		List<HeadSymbol> resultOfConversion = headSymbolConverter.convertToHeadSymbols(symbolsToConvert);

		PositionedBreathSymbol breathSymbol_1 = resultOfConversion.get(0).getPositionedBreathSymbols().get(0);
		PositionedBreathSymbol breathSymbol_2 = resultOfConversion.get(0).getPositionedBreathSymbols().get(1);

		// Check
		assertEquals(1, resultOfConversion.size());
		assertTrue(resultOfConversion.get(0).hasBreath());
		assertEquals(2, resultOfConversion.get(0).getPositionedBreathSymbols().size());
		assertTrue(breathSymbol_1.getLocation() == Location.LEFT || breathSymbol_2.getLocation() == Location.LEFT);
		assertTrue(breathSymbol_1.getLocation() == Location.RIGHT || breathSymbol_2.getLocation() == Location.RIGHT);
	}

	@Test
	public void testConvertSingleHeadSymbolToArrangedHeadSymbol() {
		// Prepare
		int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;
		List<HeadSymbol> headSymbolsToConvert = new ArrayList<HeadSymbol>();
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		headSymbolsToConvert.add(emptyHeadSymbol);

		List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbolsToConvert,
				0);

		for (int i = 0; i < xPositionsForHeadSymbols.size(); i++) {
			HeadSymbol currentHeadSymbol = headSymbolsToConvert.get(i);
			int yValue = headSymbolsBottom - currentHeadSymbol.getHeight() + currentHeadSymbol.getLowerExtension();

			currentHeadSymbol.setX(xPositionsForHeadSymbols.get(i));
			currentHeadSymbol.setY(yValue);

			positionedSymbols.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(currentHeadSymbol,
					currentHeadSymbol.getX(), currentHeadSymbol.getY(), currentHeadSymbol.getZ()));
		}

		// Action
		List<HeadSymbol> resultingHeads = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		assertEquals(1, resultingHeads.size());
		assertFalse(resultingHeads.get(0).isFreePositionable());
	}

	@Test
	public void testConvertSingleHeadSymbolToDisarrangedHeadSymbol() {
		// Prepare
		int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;
		List<HeadSymbol> headSymbolsToConvert = new ArrayList<HeadSymbol>();
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		headSymbolsToConvert.add(emptyHeadSymbol);

		List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbolsToConvert,
				0);

		for (int i = 0; i < xPositionsForHeadSymbols.size(); i++) {
			HeadSymbol currentHeadSymbol = headSymbolsToConvert.get(i);
			int yValue = headSymbolsBottom - currentHeadSymbol.getHeight() + currentHeadSymbol.getLowerExtension();

			currentHeadSymbol.setX(xPositionsForHeadSymbols.get(i) - 10);
			currentHeadSymbol.setY(yValue);

			positionedSymbols.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(currentHeadSymbol,
					currentHeadSymbol.getX(), currentHeadSymbol.getY(), currentHeadSymbol.getZ()));
		}

		// Action
		List<HeadSymbol> resultingHeads = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		assertEquals(1, resultingHeads.size());
		assertTrue(resultingHeads.get(0).isFreePositionable());
	}

	@Test
	public void testConvertHeadSymbolsToArrangedHeadSymbols() {
		// Prepare
		int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;
		List<HeadSymbol> headSymbolsToConvert = new ArrayList<HeadSymbol>();
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		HeadSymbol headSymbolWithEyesAndMouth = createEmptyHead();
		headSymbolWithEyesAndMouth
				.setEyeSymbols(PositionedEyeSymbol.convertToValidEyeSymbols(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()));
		headSymbolWithEyesAndMouth.setMouthSymbol((PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL.getIswaSymbol()));

		HeadSymbol headSymbolWithEars = createEmptyHead();
		List<PositionedEarsSymbol> earsSymbol = new ArrayList<PositionedEarsSymbol>();
		earsSymbol.addAll(PositionedEarsSymbol.convertToValidEarsSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35)));
		headSymbolWithEars.setEarSymbols(earsSymbol);

		HeadSymbol headSymbolWithExpression = createEmptyHead();
		headSymbolWithExpression.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));

		HeadSymbol headSymbolWithBreath = createEmptyHead();
		List<PositionedBreathSymbol> breathSymbols = new ArrayList<PositionedBreathSymbol>();
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getLeftBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.LEFT));
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getRightBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.RIGHT));
		headSymbolWithBreath.setBreathSymbols(breathSymbols);

		HeadSymbol headSymbolWithHair = createEmptyHead();
		PositionedHairSymbol hair = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol());
		headSymbolWithHair.setHairSymbol(hair);

		HeadSymbol headSymbolWithNeck = createEmptyHead();
		headSymbolWithNeck.setNeckSymbol((PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(NeckBaseSymbol.NECK.getIswaSymbol()));

		headSymbolsToConvert.add(emptyHeadSymbol);
		headSymbolsToConvert.add(headSymbolWithEars);
		headSymbolsToConvert.add(headSymbolWithEyesAndMouth);
		headSymbolsToConvert.add(headSymbolWithExpression);
		headSymbolsToConvert.add(headSymbolWithBreath);
		headSymbolsToConvert.add(headSymbolWithHair);
		headSymbolsToConvert.add(headSymbolWithNeck);

		List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbolsToConvert,
				0);

		for (int i = 0; i < xPositionsForHeadSymbols.size(); i++) {
			HeadSymbol currentHeadSymbol = headSymbolsToConvert.get(i);
			int yValue = headSymbolsBottom - currentHeadSymbol.getHeight() + currentHeadSymbol.getLowerExtension();

			currentHeadSymbol.setX(xPositionsForHeadSymbols.get(i));
			currentHeadSymbol.setY(yValue);

			positionedSymbols.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(currentHeadSymbol,
					currentHeadSymbol.getX(), currentHeadSymbol.getY(), currentHeadSymbol.getZ()));
		}

		// Action
		List<HeadSymbol> resultingHeads = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
        for (int i = 0; i < resultingHeads.size(); i++) {
			assertFalse("HeadSymbol at position " + i + " is not arranged!",
					resultingHeads.get(0).isFreePositionable());
		}
	}

	@Test
	public void testConvertHeadSymbolsToDisarrangedHeadSymbols() {
		// Prepare
		int headSymbolsBottom = SimpleSign.HEAD_OFFSET + HeadSymbol.HEAD_CIRCLE_HEIGHT;
		List<HeadSymbol> headSymbolsToConvert = new ArrayList<HeadSymbol>();
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol emptyHeadSymbol = createEmptyHead();
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		HeadSymbol headSymbolWithEyesAndMouth = createEmptyHead();
		headSymbolWithEyesAndMouth
				.setEyeSymbols(PositionedEyeSymbol.convertToValidEyeSymbols(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()));
		headSymbolWithEyesAndMouth.setMouthSymbol((PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_OPEN_OVAL.getIswaSymbol()));

		HeadSymbol headSymbolWithEars = createEmptyHead();
		List<PositionedEarsSymbol> earsSymbol = new ArrayList<PositionedEarsSymbol>();
		earsSymbol.addAll(PositionedEarsSymbol.convertToValidEarsSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35)));
		headSymbolWithEars.setEarSymbols(earsSymbol);

		HeadSymbol headSymbolWithExpression = createEmptyHead();
		headSymbolWithExpression.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));

		HeadSymbol headSymbolWithBreath = createEmptyHead();
		List<PositionedBreathSymbol> breathSymbols = new ArrayList<PositionedBreathSymbol>();
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getLeftBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.LEFT));
		breathSymbols.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getRightBreathSymbolFor(BreathBaseSymbol.AIR_BLOWING_OUT.getIswaSymbol()),
				Location.RIGHT));
		headSymbolWithBreath.setBreathSymbols(breathSymbols);

		HeadSymbol headSymbolWithHair = createEmptyHead();
		PositionedHairSymbol hair = (PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol());
		headSymbolWithHair.setHairSymbol(hair);

		HeadSymbol headSymbolWithNeck = createEmptyHead();
		headSymbolWithNeck.setNeckSymbol((PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(NeckBaseSymbol.NECK.getIswaSymbol()));

		headSymbolsToConvert.add(emptyHeadSymbol);
		headSymbolsToConvert.add(headSymbolWithEyesAndMouth);
		headSymbolsToConvert.add(headSymbolWithEars);
		headSymbolsToConvert.add(headSymbolWithExpression);
		headSymbolsToConvert.add(headSymbolWithBreath);
		headSymbolsToConvert.add(headSymbolWithHair);
		headSymbolsToConvert.add(headSymbolWithNeck);

		List<Integer> xPositionsForHeadSymbols = HeadSymbolLayouter.getXPositionsForHeadSymbols(headSymbolsToConvert,
				0);

		for (int i = 0; i < xPositionsForHeadSymbols.size(); i++) {
			HeadSymbol currentHeadSymbol = headSymbolsToConvert.get(i);
			int yValue = headSymbolsBottom - currentHeadSymbol.getHeight() + currentHeadSymbol.getLowerExtension();

			currentHeadSymbol.setX(xPositionsForHeadSymbols.get(i) + 10);
			currentHeadSymbol.setY(yValue);

			positionedSymbols.addAll(SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(currentHeadSymbol,
					currentHeadSymbol.getX(), currentHeadSymbol.getY(), currentHeadSymbol.getZ()));
		}

		// Action
		List<HeadSymbol> resultingHeads = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		assertEquals(7, resultingHeads.size());
		for (int i = 0; i < resultingHeads.size(); i++) {
			assertTrue("HeadSymbol at position " + i + " is not free positionable!",
					resultingHeads.get(0).isFreePositionable());
		}
	}

	@Test
	public void testConvertHeadPostureWithUpperExtension() {
		// Prepare
		List<HeadSymbol> headSymbolsToConvert = new ArrayList<HeadSymbol>();
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol headSymbol = createEmptyHead();
		headSymbol.setHeadPostureSymbol(new PositionedHeadPostureSymbol(new Symbol(4, 1, 3, 1, 3, 3, 36, 48)));
		headSymbol.setMouthSymbol(new PositionedMouthSymbol(new Symbol(4, 4, 6, 3, 2, 1, 6, 10)));
		positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol, headSymbol.getX(),
				headSymbol.getY(), headSymbol.getZ());

		// Action
		headSymbolsToConvert = headSymbolConverter.convertToHeadSymbols(positionedSymbols);

		// Check
		assertEquals(1, headSymbolsToConvert.size());
		HeadSymbol convertedHeadSymbol = headSymbolsToConvert.get(0);
		assertEquals(headSymbol, convertedHeadSymbol);
		assertEquals(headSymbol.getPositionedHeadPostureSymbol().getX(),
				convertedHeadSymbol.getPositionedHeadPostureSymbol().getX());
		assertEquals(headSymbol.getPositionedHeadPostureSymbol().getY(),
				convertedHeadSymbol.getPositionedHeadPostureSymbol().getY());

		assertEquals(headSymbol.getPositionedMouthSymbol().getX(),
				convertedHeadSymbol.getPositionedMouthSymbol().getX());
		assertEquals(headSymbol.getPositionedMouthSymbol().getY(),
				convertedHeadSymbol.getPositionedMouthSymbol().getY());

	}

	@Test
	public void testConvertHeadPostureWithLeftOverhead() {
		// Prepare
		List<PositionedSymbol> positionedSymbols = new ArrayList<PositionedSymbol>();

		HeadSymbol headSymbol = createEmptyHead();
		headSymbol.setHeadPostureSymbol(new PositionedHeadPostureSymbol(new Symbol(4, 1, 3, 1, 3, 6, 44, 43)));
		headSymbol.setMouthSymbol(new PositionedMouthSymbol(new Symbol(4, 5, 1, 5, 2, 5, 10, 10)));

		// Action
		positionedSymbols = SymbolToHeadSymbolConverter.getPositionedSymbolsForHeadSymbol(headSymbol, 0, 0, 1);

		// Check
		assertEquals(2, positionedSymbols.size());

		PositionedHeadPostureSymbol headPostureSymbol = null;
		PositionedMouthSymbol mouthSymbol = null;
		for (PositionedSymbol positionedSymbol : positionedSymbols) {
			if (positionedSymbol instanceof PositionedHeadPostureSymbol) {
				headPostureSymbol = (PositionedHeadPostureSymbol) positionedSymbol;
			} else if (positionedSymbol instanceof PositionedMouthSymbol) {
				mouthSymbol = (PositionedMouthSymbol) positionedSymbol;
			} else {
				fail("Unexpected PositionedSymbol");
			}
		}
		assertNotNull(headPostureSymbol);
		assertNotNull(mouthSymbol);

		assertEquals(21, mouthSymbol.getX());
		assertEquals(29, mouthSymbol.getY(), 1);
		assertEquals(2, mouthSymbol.getZ());

		assertEquals(0, headPostureSymbol.getX());
		assertEquals(0, headPostureSymbol.getY());
		assertEquals(1, headPostureSymbol.getZ());

	}

	private HeadSymbol createEmptyHead() {
		return positionedSymbolFactory.createHeadSymbol(PositionedHeadPostureSymbol.getEmptyHeadPostureSymbol());
	}

}
