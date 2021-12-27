package de.signWritingEditor.shared.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.HeadPostureBaseSymbol;
import de.signWritingEditor.shared.model.material.BodyBaseSymbol;
import de.signWritingEditor.shared.model.material.DynamicsBaseSymbol;
import de.signWritingEditor.shared.model.material.HandBaseSymbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PunctuationBaseSymbol;

public class SymbolCategoryAnalyzerTest {

	@Test
	public void testIsBodySymbol() {
		assertTrue(SymbolCategoryAnalyzer.isBodySymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isBodySymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isBodySymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isBodySymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isBodySymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isBodySymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
	}

	@Test
	public void testIsHeadSymbol() {
		assertTrue(SymbolCategoryAnalyzer.isHeadSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
	}

	@Test
	public void testIsMovementSymbol() {
		assertTrue(SymbolCategoryAnalyzer.isMovementSymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isMovementSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isMovementSymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isMovementSymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isMovementSymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isMovementSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
	}

	@Test
	public void testIsHandSymbol() {
		assertTrue(SymbolCategoryAnalyzer.isHandSymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHandSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHandSymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHandSymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHandSymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHandSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
	}

	@Test
	public void testIsPunctuationSymbol() {
		assertTrue(SymbolCategoryAnalyzer.isPunctuationSymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isPunctuationSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isPunctuationSymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(
				SymbolCategoryAnalyzer.isPunctuationSymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isPunctuationSymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isPunctuationSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
	}

	@Test
	public void testIsDynamicsSymbol() {
		assertTrue(SymbolCategoryAnalyzer.isDynamicsSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isDynamicsSymbol(HeadPostureBaseSymbol.STANDARD.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isDynamicsSymbol(BodyBaseSymbol.LIMB_LENGTH_1.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isDynamicsSymbol(MovementBaseSymbol.BOX_FLOOR_PLANE_LARGE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isDynamicsSymbol(HandBaseSymbol.BABY_DOWN_OTHERS_CIRCLE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isDynamicsSymbol(PunctuationBaseSymbol.COLON.getIswaSymbol()));
	}

	@Test
	public void testAirRelatedBodySymbols() {
		assertTrue(SymbolCategoryAnalyzer.isBodySymbol(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol()));
		assertTrue(SymbolCategoryAnalyzer.isBodySymbol(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(BodyBaseSymbol.BREATH_EXHALE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(BodyBaseSymbol.BREATH_INHALE.getIswaSymbol()));
	}

	@Test
	public void testBodySymbolsFromHeadCategory() {
		assertTrue(SymbolCategoryAnalyzer.isBodySymbol(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol()));
		assertFalse(SymbolCategoryAnalyzer.isHeadSymbol(BodyBaseSymbol.HEAD_WITH_SHOULDERS_OR_NOSE.getIswaSymbol()));
	}
}
