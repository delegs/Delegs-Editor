package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.BreathBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.CheeksBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.ExpressionBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.HairBaseSymbol;
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
import de.signWritingEditor.shared.model.material.PositionedSymbolFactory;

public class HeadSymbolTest {

	private HeadSymbol emptyHeadSymbol;
	private PositionedSymbolFactory positionedSymbolFactory;

	@Before
	public void setUp() {
		positionedSymbolFactory = new PositionedSymbolFactory();
		emptyHeadSymbol = positionedSymbolFactory
				.createHeadSymbol(PositionedHeadPostureSymbol.getEmptyHeadPostureSymbol());
	}

	@Test
	public void testChangeHeadPosture() {
		// Precondition
		assertFalse(emptyHeadSymbol.hasHeadPosture());

		// Action
		emptyHeadSymbol.setHeadPostureSymbol(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol());

		// Check
		assertTrue(emptyHeadSymbol.hasHeadPosture());
		assertEquals(PositionedHeadPostureSymbol.getStandardHeadPostureSymbol(),
				emptyHeadSymbol.getPositionedHeadPostureSymbol());
	}

	@Test
	public void testHasEyes() {
		assertFalse(emptyHeadSymbol.hasEyes());
		emptyHeadSymbol
				.setEyeSymbols(PositionedEyeSymbol.convertToValidEyeSymbols(EyesBaseSymbol.EYES_OPEN.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasEyes());
	}

	@Test
	public void testHasNose() {
		assertFalse(emptyHeadSymbol.hasNose());
		emptyHeadSymbol.setNoseSymbol((PositionedNoseSymbol) positionedSymbolFactory
				.createPositionedSymbol(NoseBaseSymbol.NOSE_NEUTRAL.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasNose());
	}

	@Test
	public void testHasCheeks() {
		assertFalse(emptyHeadSymbol.hasCheeks());

		emptyHeadSymbol.setCheekSymbols(
				PositionedCheekSymbol.convertToValidCheeksSymbol(CheeksBaseSymbol.CHEEKS_PUFFED.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasCheeks());
	}

	@Test
	public void testHasMouth() {
		assertFalse(emptyHeadSymbol.hasMouth());
		emptyHeadSymbol.setMouthSymbol((PositionedMouthSymbol) positionedSymbolFactory
				.createPositionedSymbol(MouthBaseSymbol.MOUTH_SMILE.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasMouth());
	}

	@Test
	public void testHasEars() {
		assertFalse(emptyHeadSymbol.hasEars());
		emptyHeadSymbol
				.setEarSymbols(PositionedEarsSymbol.convertToValidEarsSymbol(new Symbol(4, 3, 3, 1, 1, 1, 48, 35)));
		assertTrue(emptyHeadSymbol.hasEars());
	}

	@Test
	public void testHasBreath() {
		assertFalse(emptyHeadSymbol.hasBreath());
		List<PositionedBreathSymbol> breathSymbol = new ArrayList<PositionedBreathSymbol>();
		breathSymbol.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getLeftBreathSymbolFor(BreathBaseSymbol.AIR_SUCKING_IN.getIswaSymbol()),
				Location.LEFT));
		breathSymbol.add((PositionedBreathSymbol) positionedSymbolFactory.createPositionedSymbol(
				BreathBaseSymbol.getRightBreathSymbolFor(BreathBaseSymbol.AIR_SUCKING_IN.getIswaSymbol()),
				Location.RIGHT));
		emptyHeadSymbol.setBreathSymbols(breathSymbol);
		assertTrue(emptyHeadSymbol.hasBreath());
	}

	@Test
	public void testHasJaw() {
		assertFalse(emptyHeadSymbol.hasJaw());
		emptyHeadSymbol.setJawSymbol(
				PositionedJawSymbol.convertToValidJawSymbol(JawBaseSymbol.JAW_MOVEMENT_FLOOR_PLANE.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasJaw());
	}

	@Test
	public void testHasNeck() {
		assertFalse(emptyHeadSymbol.hasNeck());
		emptyHeadSymbol.setNeckSymbol((PositionedNeckSymbol) positionedSymbolFactory
				.createPositionedSymbol(NeckBaseSymbol.NECK.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasNeck());
	}

	@Test
	public void testHasExpression() {
		assertFalse(emptyHeadSymbol.hasExpression());
		emptyHeadSymbol.setExpressionSymbol((PositionedExpressionSymbol) positionedSymbolFactory
				.createPositionedSymbol(ExpressionBaseSymbol.EXCITEMENT.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasExpression());
	}

	@Test
	public void testHasHair() {
		assertFalse(emptyHeadSymbol.hasHair());
		emptyHeadSymbol.setHairSymbol((PositionedHairSymbol) positionedSymbolFactory
				.createPositionedSymbol(HairBaseSymbol.HAIR.getIswaSymbol()));
		assertTrue(emptyHeadSymbol.hasHair());
	}

}
