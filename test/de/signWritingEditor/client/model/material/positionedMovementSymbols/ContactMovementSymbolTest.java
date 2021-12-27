package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class ContactMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	private SymbolFactory symbolFactory;

	/**
	 * ContactMovementSymbols Group 02 SymbolId 01
	 */
	private PositionedMovementSymbol touchSingle;
	private PositionedMovementSymbol touchMultiple;
	private PositionedMovementSymbol touchMultipleIncreased;
	private PositionedMovementSymbol touchBetween;
	private PositionedMovementSymbol touchBetweenIncreased;

	private PositionedMovementSymbol graspSingle;
	private PositionedMovementSymbol graspMultiple;
	private PositionedMovementSymbol graspMultipleIncreased;
	private PositionedMovementSymbol graspBetween;
	private PositionedMovementSymbol graspBetweenIncreased;

	private PositionedMovementSymbol strikeSingle;
	private PositionedMovementSymbol strikeMultiple;
	private PositionedMovementSymbol strikeMultipleIncreased;
	private PositionedMovementSymbol strikeBetween;
	private PositionedMovementSymbol strikeBetweenIncreased;

	private PositionedMovementSymbol brushSingle;
	private PositionedMovementSymbol brushMultiple;
	private PositionedMovementSymbol brushMultipleIncreased;
	private PositionedMovementSymbol brushBetween;
	private PositionedMovementSymbol brushBetweenIncreased;

	private PositionedMovementSymbol rubSingle;
	private PositionedMovementSymbol rubMultiple;
	private PositionedMovementSymbol rubMultipleIncreased;
	private PositionedMovementSymbol rubBetween;
	private PositionedMovementSymbol rubBetweenIncreased;

	private PositionedMovementSymbol surfaceSymbols;
	private PositionedMovementSymbol surfaceSymbolsPitched;
	private PositionedMovementSymbol surfaceBetween;
	private PositionedMovementSymbol surfaceBetweenPitched;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		touchSingle = new PositionedMovementSymbol(MovementBaseSymbol.TOUCH_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.TOUCH_SINGLE.getIswaSymbol().getBaseSymbol()));

		touchMultiple = new PositionedMovementSymbol(MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.TOUCH_MULTIPE.getIswaSymbol().getBaseSymbol()));

		Symbol touchMultipleIncreasedSymbol = symbolFactory.createSymbol("02-01-002-01-02-01");
		touchMultipleIncreased = new PositionedMovementSymbol(touchMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(touchMultipleIncreasedSymbol.getBaseSymbol()));

		touchBetween = new PositionedMovementSymbol(MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.TOUCH_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol touchBetweenIncreasedSymbol = symbolFactory.createSymbol("02-01-003-01-02-01");
		touchBetweenIncreased = new PositionedMovementSymbol(touchBetweenIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(touchBetweenIncreasedSymbol.getBaseSymbol()));

		graspSingle = new PositionedMovementSymbol(MovementBaseSymbol.GRASP_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.GRASP_SINGLE.getIswaSymbol().getBaseSymbol()));

		graspMultiple = new PositionedMovementSymbol(MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.GRASP_MULTIPLE.getIswaSymbol().getBaseSymbol()));

		Symbol graspMultipleIncreasedSymbol = symbolFactory.createSymbol("02-01-005-01-02-01");
		graspMultipleIncreased = new PositionedMovementSymbol(graspMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(graspMultipleIncreasedSymbol.getBaseSymbol()));

		graspBetween = new PositionedMovementSymbol(MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.GRASP_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol graspBetweenIncreasedSymbol = symbolFactory.createSymbol("02-01-006-01-02-01");
		graspBetweenIncreased = new PositionedMovementSymbol(graspBetweenIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(graspBetweenIncreasedSymbol.getBaseSymbol()));

		strikeSingle = new PositionedMovementSymbol(MovementBaseSymbol.STRIKE_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.STRIKE_SINGLE.getIswaSymbol().getBaseSymbol()));

		strikeMultiple = new PositionedMovementSymbol(MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.STRIKE_MULTIPLE.getIswaSymbol().getBaseSymbol()));

		Symbol strikeMultipleIncreasedSymbol = symbolFactory.createSymbol("02-01-008-01-02-01");
		strikeMultipleIncreased = new PositionedMovementSymbol(strikeMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(strikeMultipleIncreasedSymbol.getBaseSymbol()));

		strikeBetween = new PositionedMovementSymbol(MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.STRIKE_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol strikeBetweenIncreasedSymbol = symbolFactory.createSymbol("02-01-009-01-02-01");
		strikeBetweenIncreased = new PositionedMovementSymbol(strikeBetweenIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(strikeBetweenIncreasedSymbol.getBaseSymbol()));

		brushSingle = new PositionedMovementSymbol(MovementBaseSymbol.BRUSH_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.BRUSH_SINGLE.getIswaSymbol().getBaseSymbol()));

		brushMultiple = new PositionedMovementSymbol(MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.BRUSH_MULTIPLE.getIswaSymbol().getBaseSymbol()));

		Symbol brushMultipleIncreasedSymbol = symbolFactory.createSymbol("02-01-011-01-02-01");
		brushMultipleIncreased = new PositionedMovementSymbol(brushMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(brushMultipleIncreasedSymbol.getBaseSymbol()));

		brushBetween = new PositionedMovementSymbol(MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.BRUSH_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol brushBetweenIncreasedSymbol = symbolFactory.createSymbol("02-01-012-01-02-01");
		brushBetweenIncreased = new PositionedMovementSymbol(brushBetweenIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(brushBetweenIncreasedSymbol.getBaseSymbol()));

		rubSingle = new PositionedMovementSymbol(MovementBaseSymbol.RUB_SINGLE.getIswaSymbol(), 0, 0, 2, symbolFactory
				.getAllRotationsAndFillsFor(MovementBaseSymbol.RUB_SINGLE.getIswaSymbol().getBaseSymbol()));

		rubMultiple = new PositionedMovementSymbol(MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(MovementBaseSymbol.RUB_MULTIPLE.getIswaSymbol().getBaseSymbol()));

		Symbol rubMultipleIncreasedSymbol = symbolFactory.createSymbol("02-01-014-01-02-01");
		rubMultipleIncreased = new PositionedMovementSymbol(rubMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rubMultipleIncreasedSymbol.getBaseSymbol()));

		rubBetween = new PositionedMovementSymbol(MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol(), 0, 0, 2, symbolFactory
				.getAllRotationsAndFillsFor(MovementBaseSymbol.RUB_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol rubBetweenIncreasedSymbol = symbolFactory.createSymbol("02-01-015-01-02-01");
		rubBetweenIncreased = new PositionedMovementSymbol(rubBetweenIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rubBetweenIncreasedSymbol.getBaseSymbol()));

		surfaceSymbols = new PositionedMovementSymbol(MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SURFACE_SYMBOLS.getIswaSymbol().getBaseSymbol()));

		Symbol surfaceSymbolsPitchSymbol = symbolFactory.createSymbol("02-01-016-01-02-01");
		surfaceSymbolsPitched = new PositionedMovementSymbol(surfaceSymbolsPitchSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(surfaceSymbolsPitchSymbol.getBaseSymbol()));

		surfaceBetween = new PositionedMovementSymbol(MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SURFACE_BETWEEN.getIswaSymbol().getBaseSymbol()));

		Symbol surfaceBetweenPitchedSymbol = symbolFactory.createSymbol("02-01-017-01-02-01");
		surfaceBetweenPitched = new PositionedMovementSymbol(surfaceBetweenPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(surfaceBetweenPitchedSymbol.getBaseSymbol()));

	}

	@Override
	public void testCanIncrease() {
		assertTrue(touchSingle.canIncrease());
		assertTrue(touchMultiple.canIncrease());
		assertTrue(touchBetween.canIncrease());

		assertFalse(touchMultipleIncreased.canIncrease());
		assertFalse(touchBetweenIncreased.canIncrease());

		assertTrue(graspSingle.canIncrease());
		assertTrue(graspMultiple.canIncrease());
		assertTrue(graspBetween.canIncrease());

		assertFalse(graspMultipleIncreased.canIncrease());
		assertFalse(graspBetweenIncreased.canIncrease());

		assertTrue(strikeSingle.canIncrease());
		assertTrue(strikeMultiple.canIncrease());
		assertTrue(strikeBetween.canIncrease());

		assertFalse(strikeMultipleIncreased.canIncrease());
		assertFalse(strikeBetweenIncreased.canIncrease());

		assertTrue(brushSingle.canIncrease());
		assertTrue(brushMultiple.canIncrease());
		assertTrue(brushBetween.canIncrease());

		assertFalse(brushMultipleIncreased.canIncrease());
		assertFalse(brushBetweenIncreased.canIncrease());

		assertTrue(rubSingle.canIncrease());
		assertTrue(rubMultiple.canIncrease());
		assertTrue(rubBetween.canIncrease());

		assertFalse(rubMultipleIncreased.canIncrease());
		assertFalse(rubBetweenIncreased.canIncrease());

		assertFalse(surfaceSymbols.canIncrease());
		assertFalse(surfaceBetween.canIncrease());
		assertFalse(surfaceSymbolsPitched.canIncrease());
		assertFalse(surfaceBetweenPitched.canIncrease());

	}

	@Override
	public void testIncrease() {

		touchSingle.increase();
		assertEquals(touchMultiple.getSymbol(), touchSingle.getSymbol());
		touchMultiple.increase();
		assertEquals(touchMultipleIncreased.getSymbol(), touchMultiple.getSymbol());

		touchBetween.increase();
		assertEquals(touchBetweenIncreased.getSymbol(), touchBetween.getSymbol());

		graspSingle.increase();
		assertEquals(graspMultiple.getSymbol(), graspSingle.getSymbol());
		graspMultiple.increase();
		assertEquals(graspMultipleIncreased.getSymbol(), graspMultiple.getSymbol());

		graspBetween.increase();
		assertEquals(graspBetweenIncreased.getSymbol(), graspBetween.getSymbol());

		strikeSingle.increase();
		assertEquals(strikeMultiple.getSymbol(), strikeSingle.getSymbol());
		strikeMultiple.increase();
		assertEquals(strikeMultipleIncreased.getSymbol(), strikeMultiple.getSymbol());

		strikeBetween.increase();
		assertEquals(strikeBetweenIncreased.getSymbol(), strikeBetween.getSymbol());

		brushSingle.increase();
		assertEquals(brushMultiple.getSymbol(), brushSingle.getSymbol());
		brushMultiple.increase();
		assertEquals(brushMultipleIncreased.getSymbol(), brushMultiple.getSymbol());

		brushBetween.increase();
		assertEquals(brushBetweenIncreased.getSymbol(), brushBetween.getSymbol());

		rubSingle.increase();
		assertEquals(rubMultiple.getSymbol(), rubSingle.getSymbol());
		rubMultiple.increase();
		assertEquals(rubMultipleIncreased.getSymbol(), rubMultiple.getSymbol());

		rubBetween.increase();
		assertEquals(rubBetweenIncreased.getSymbol(), rubBetween.getSymbol());

	}

	@Override
	public void testCanDecrease() {
		assertFalse(touchSingle.canDecrease());
		assertTrue(touchMultiple.canDecrease());
		assertTrue(touchMultipleIncreased.canDecrease());
		assertFalse(touchBetween.canDecrease());
		assertTrue(touchBetweenIncreased.canDecrease());

		assertFalse(graspSingle.canDecrease());
		assertTrue(graspMultiple.canDecrease());
		assertTrue(graspMultipleIncreased.canDecrease());
		assertFalse(graspBetween.canDecrease());
		assertTrue(graspBetweenIncreased.canDecrease());

		assertFalse(strikeSingle.canDecrease());
		assertTrue(strikeMultiple.canDecrease());
		assertTrue(strikeMultipleIncreased.canDecrease());
		assertFalse(strikeBetween.canDecrease());
		assertTrue(strikeBetweenIncreased.canDecrease());

		assertFalse(brushSingle.canDecrease());
		assertTrue(brushMultiple.canDecrease());
		assertTrue(brushMultipleIncreased.canDecrease());
		assertFalse(brushBetween.canDecrease());
		assertTrue(brushBetweenIncreased.canDecrease());

		assertFalse(rubSingle.canDecrease());
		assertTrue(rubMultiple.canDecrease());
		assertTrue(rubMultipleIncreased.canDecrease());
		assertFalse(rubBetween.canDecrease());
		assertTrue(rubBetweenIncreased.canDecrease());

		assertFalse(surfaceSymbols.canDecrease());
		assertFalse(surfaceSymbolsPitched.canDecrease());
		assertFalse(surfaceBetween.canDecrease());
		assertFalse(surfaceBetweenPitched.canDecrease());

	}

	@Override
	public void testDecrease() {

		touchMultipleIncreased.decrease();
		assertEquals(touchMultiple.getSymbol(), touchMultipleIncreased.getSymbol());
		touchMultiple.decrease();
		assertEquals(touchSingle.getSymbol(), touchMultiple.getSymbol());

		touchBetweenIncreased.decrease();
		assertEquals(touchBetween.getSymbol(), touchBetweenIncreased.getSymbol());

		graspMultipleIncreased.decrease();
		assertEquals(graspMultiple.getSymbol(), graspMultipleIncreased.getSymbol());
		graspMultiple.decrease();
		assertEquals(graspSingle.getSymbol(), graspMultiple.getSymbol());

		graspBetweenIncreased.decrease();
		assertEquals(graspBetween.getSymbol(), graspBetweenIncreased.getSymbol());

		strikeMultipleIncreased.decrease();
		assertEquals(strikeMultiple.getSymbol(), strikeMultipleIncreased.getSymbol());
		strikeMultiple.decrease();
		assertEquals(strikeSingle.getSymbol(), strikeMultiple.getSymbol());

		strikeBetweenIncreased.decrease();
		assertEquals(strikeBetween.getSymbol(), strikeBetweenIncreased.getSymbol());

		brushMultipleIncreased.decrease();
		assertEquals(brushMultiple.getSymbol(), brushMultipleIncreased.getSymbol());
		brushMultiple.decrease();
		assertEquals(brushSingle.getSymbol(), brushMultiple.getSymbol());

		brushBetweenIncreased.decrease();
		assertEquals(brushBetween.getSymbol(), brushBetweenIncreased.getSymbol());

		rubMultipleIncreased.decrease();
		assertEquals(rubMultiple.getSymbol(), rubMultipleIncreased.getSymbol());
		rubMultiple.decrease();
		assertEquals(rubSingle.getSymbol(), rubMultiple.getSymbol());

		rubBetweenIncreased.decrease();
		assertEquals(rubBetween.getSymbol(), rubBetweenIncreased.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertFalse(touchSingle.canRotate());
		assertTrue(touchMultiple.canRotate());
		assertTrue(touchMultipleIncreased.canRotate());
		assertTrue(touchBetween.canRotate());
		assertTrue(touchBetweenIncreased.canRotate());

		assertFalse(graspSingle.canRotate());
		assertTrue(graspMultiple.canRotate());
		assertTrue(graspMultipleIncreased.canRotate());
		assertTrue(graspBetween.canRotate());
		assertTrue(graspBetweenIncreased.canRotate());

		assertFalse(strikeSingle.canRotate());
		assertTrue(strikeMultiple.canRotate());
		assertTrue(strikeMultipleIncreased.canRotate());
		assertTrue(strikeBetween.canRotate());
		assertTrue(strikeBetweenIncreased.canRotate());

		assertFalse(brushSingle.canRotate());
		assertTrue(brushMultiple.canRotate());
		assertTrue(brushMultipleIncreased.canRotate());
		assertTrue(brushBetween.canRotate());
		assertTrue(brushBetweenIncreased.canRotate());

		assertFalse(rubSingle.canRotate());
		assertTrue(rubMultiple.canRotate());
		assertTrue(rubMultipleIncreased.canRotate());
		assertTrue(rubBetween.canRotate());
		assertTrue(rubBetweenIncreased.canRotate());

		assertTrue(surfaceSymbols.canRotate());
		assertTrue(surfaceSymbolsPitched.canRotate());
		assertTrue(surfaceBetween.canRotate());
		assertTrue(surfaceBetweenPitched.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		touchMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-04"), touchMultiple.getSymbol());
		touchMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-03"), touchMultiple.getSymbol());
		touchMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-02"), touchMultiple.getSymbol());
		touchMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-01"), touchMultiple.getSymbol());

		touchMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-04"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-03"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-02"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-01"), touchMultipleIncreased.getSymbol());

		touchBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-04"), touchBetween.getSymbol());
		touchBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-03"), touchBetween.getSymbol());
		touchBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-02"), touchBetween.getSymbol());
		touchBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-01"), touchBetween.getSymbol());

		touchBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-04"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-03"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-02"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-01"), touchBetweenIncreased.getSymbol());

		graspMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-04"), graspMultiple.getSymbol());
		graspMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-03"), graspMultiple.getSymbol());
		graspMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-02"), graspMultiple.getSymbol());
		graspMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-01"), graspMultiple.getSymbol());

		graspMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-04"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-03"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-02"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-01"), graspMultipleIncreased.getSymbol());

		graspBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-04"), graspBetween.getSymbol());
		graspBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-03"), graspBetween.getSymbol());
		graspBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-02"), graspBetween.getSymbol());
		graspBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-01"), graspBetween.getSymbol());

		graspBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-04"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-03"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-02"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-01"), graspBetweenIncreased.getSymbol());

		strikeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-04"), strikeMultiple.getSymbol());
		strikeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-03"), strikeMultiple.getSymbol());
		strikeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-02"), strikeMultiple.getSymbol());
		strikeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-01"), strikeMultiple.getSymbol());

		strikeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-04"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-03"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-02"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-01"), strikeMultipleIncreased.getSymbol());

		strikeBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-04"), strikeBetween.getSymbol());
		strikeBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-03"), strikeBetween.getSymbol());
		strikeBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-02"), strikeBetween.getSymbol());
		strikeBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-01"), strikeBetween.getSymbol());

		strikeBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-04"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-03"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-02"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-01"), strikeBetweenIncreased.getSymbol());

		brushMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-04"), brushMultiple.getSymbol());
		brushMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-03"), brushMultiple.getSymbol());
		brushMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-02"), brushMultiple.getSymbol());
		brushMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-01"), brushMultiple.getSymbol());

		brushMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-04"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-03"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-02"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-01"), brushMultipleIncreased.getSymbol());

		brushBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-04"), brushBetween.getSymbol());
		brushBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-03"), brushBetween.getSymbol());
		brushBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-02"), brushBetween.getSymbol());
		brushBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-01"), brushBetween.getSymbol());

		brushBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-04"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-03"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-02"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-01"), brushBetweenIncreased.getSymbol());

		rubMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-04"), rubMultiple.getSymbol());
		rubMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-03"), rubMultiple.getSymbol());
		rubMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-02"), rubMultiple.getSymbol());
		rubMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-01"), rubMultiple.getSymbol());

		rubMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-04"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-03"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-02"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-01"), rubMultipleIncreased.getSymbol());

		rubBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-04"), rubBetween.getSymbol());
		rubBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-03"), rubBetween.getSymbol());
		rubBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-02"), rubBetween.getSymbol());
		rubBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-01"), rubBetween.getSymbol());

		rubBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-04"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-03"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-02"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-01"), rubBetweenIncreased.getSymbol());

		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-08"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-07"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-06"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-05"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-04"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-03"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-02"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-01"), surfaceSymbols.getSymbol());

		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-08"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-07"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-06"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-05"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-04"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-03"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-02"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-01"), surfaceSymbolsPitched.getSymbol());

		surfaceBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-04"), surfaceBetween.getSymbol());
		surfaceBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-03"), surfaceBetween.getSymbol());
		surfaceBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-02"), surfaceBetween.getSymbol());
		surfaceBetween.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-01"), surfaceBetween.getSymbol());

		surfaceBetweenPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-04"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-03"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-02"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-01"), surfaceBetweenPitched.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		touchMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-02"), touchMultiple.getSymbol());
		touchMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-03"), touchMultiple.getSymbol());
		touchMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-04"), touchMultiple.getSymbol());
		touchMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-01"), touchMultiple.getSymbol());

		touchMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-02"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-03"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-04"), touchMultipleIncreased.getSymbol());
		touchMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-01"), touchMultipleIncreased.getSymbol());

		touchBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-02"), touchBetween.getSymbol());
		touchBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-03"), touchBetween.getSymbol());
		touchBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-04"), touchBetween.getSymbol());
		touchBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-01"), touchBetween.getSymbol());

		touchBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-02"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-03"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-04"), touchBetweenIncreased.getSymbol());
		touchBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-01"), touchBetweenIncreased.getSymbol());

		graspMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-02"), graspMultiple.getSymbol());
		graspMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-03"), graspMultiple.getSymbol());
		graspMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-04"), graspMultiple.getSymbol());
		graspMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-01"), graspMultiple.getSymbol());

		graspMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-02"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-03"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-04"), graspMultipleIncreased.getSymbol());
		graspMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-01"), graspMultipleIncreased.getSymbol());

		graspBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-02"), graspBetween.getSymbol());
		graspBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-03"), graspBetween.getSymbol());
		graspBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-04"), graspBetween.getSymbol());
		graspBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-01"), graspBetween.getSymbol());

		graspBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-02"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-03"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-04"), graspBetweenIncreased.getSymbol());
		graspBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-01"), graspBetweenIncreased.getSymbol());

		strikeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-02"), strikeMultiple.getSymbol());
		strikeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-03"), strikeMultiple.getSymbol());
		strikeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-04"), strikeMultiple.getSymbol());
		strikeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-01"), strikeMultiple.getSymbol());

		strikeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-02"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-03"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-04"), strikeMultipleIncreased.getSymbol());
		strikeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-01"), strikeMultipleIncreased.getSymbol());

		strikeBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-02"), strikeBetween.getSymbol());
		strikeBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-03"), strikeBetween.getSymbol());
		strikeBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-04"), strikeBetween.getSymbol());
		strikeBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-01"), strikeBetween.getSymbol());

		strikeBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-02"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-03"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-04"), strikeBetweenIncreased.getSymbol());
		strikeBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-01"), strikeBetweenIncreased.getSymbol());

		brushMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-02"), brushMultiple.getSymbol());
		brushMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-03"), brushMultiple.getSymbol());
		brushMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-04"), brushMultiple.getSymbol());
		brushMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-01"), brushMultiple.getSymbol());

		brushMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-02"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-03"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-04"), brushMultipleIncreased.getSymbol());
		brushMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-01"), brushMultipleIncreased.getSymbol());

		brushBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-02"), brushBetween.getSymbol());
		brushBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-03"), brushBetween.getSymbol());
		brushBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-04"), brushBetween.getSymbol());
		brushBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-01"), brushBetween.getSymbol());

		brushBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-02"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-03"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-04"), brushBetweenIncreased.getSymbol());
		brushBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-01"), brushBetweenIncreased.getSymbol());

		rubMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-02"), rubMultiple.getSymbol());
		rubMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-03"), rubMultiple.getSymbol());
		rubMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-04"), rubMultiple.getSymbol());
		rubMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-01"), rubMultiple.getSymbol());

		rubMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-02"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-03"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-04"), rubMultipleIncreased.getSymbol());
		rubMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-01"), rubMultipleIncreased.getSymbol());

		rubBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-02"), rubBetween.getSymbol());
		rubBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-03"), rubBetween.getSymbol());
		rubBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-04"), rubBetween.getSymbol());
		rubBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-01"), rubBetween.getSymbol());

		rubBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-02"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-03"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-04"), rubBetweenIncreased.getSymbol());
		rubBetweenIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-01"), rubBetweenIncreased.getSymbol());

		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-02"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-03"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-04"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-05"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-06"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-07"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-08"), surfaceSymbols.getSymbol());
		surfaceSymbols.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-01"), surfaceSymbols.getSymbol());

		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-02"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-03"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-04"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-05"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-06"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-07"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-08"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-01"), surfaceSymbolsPitched.getSymbol());

		surfaceBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-02"), surfaceBetween.getSymbol());
		surfaceBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-03"), surfaceBetween.getSymbol());
		surfaceBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-04"), surfaceBetween.getSymbol());
		surfaceBetween.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-01"), surfaceBetween.getSymbol());

		surfaceBetweenPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-02"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-03"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-04"), surfaceBetweenPitched.getSymbol());
		surfaceBetweenPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-01"), surfaceBetweenPitched.getSymbol());

	}

	@Override
	public void testCanMirror() {
		assertFalse(touchSingle.canMirror());

		assertTrue(touchBetween.canMirror());
		assertTrue(touchBetweenIncreased.canMirror());
		assertTrue(touchMultipleIncreased.canMirror());
		assertTrue(touchMultiple.canMirror());

		assertFalse(graspSingle.canMirror());

		assertTrue(graspMultiple.canMirror());
		assertTrue(graspMultipleIncreased.canMirror());
		assertTrue(graspBetween.canMirror());
		assertTrue(graspBetweenIncreased.canMirror());

		assertFalse(strikeSingle.canMirror());

		assertTrue(strikeMultiple.canMirror());
		assertTrue(strikeMultipleIncreased.canMirror());
		assertTrue(strikeBetween.canMirror());
		assertTrue(strikeBetweenIncreased.canMirror());

		assertFalse(brushSingle.canMirror());

		assertTrue(brushMultiple.canMirror());
		assertTrue(brushMultipleIncreased.canMirror());
		assertTrue(brushBetween.canMirror());
		assertTrue(brushBetweenIncreased.canMirror());

		assertFalse(rubSingle.canMirror());

		assertTrue(rubMultiple.canMirror());
		assertTrue(rubMultipleIncreased.canMirror());
		assertTrue(rubBetween.canMirror());
		assertTrue(rubBetweenIncreased.canMirror());

		assertTrue(surfaceSymbols.canMirror());
		assertTrue(surfaceSymbolsPitched.canMirror());
		assertTrue(surfaceBetween.canMirror());
		assertTrue(surfaceBetweenPitched.canMirror());

	}

	@Override
	public void testMirror() {

		touchBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-01"), touchBetween.getSymbol());
		touchBetweenIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-01"), touchBetweenIncreased.getSymbol());
		touchMultipleIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-01"), touchMultipleIncreased.getSymbol());
		touchMultiple.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-01"), touchMultiple.getSymbol());

		graspMultiple.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-01"), graspMultiple.getSymbol());
		graspMultipleIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-01"), graspMultipleIncreased.getSymbol());
		graspBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-01"), graspBetween.getSymbol());
		graspBetweenIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-01"), graspBetweenIncreased.getSymbol());

		strikeMultiple.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-01"), strikeMultiple.getSymbol());
		strikeMultipleIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-01"), strikeMultipleIncreased.getSymbol());
		strikeBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-01"), strikeBetween.getSymbol());
		strikeBetweenIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-01"), strikeBetweenIncreased.getSymbol());

		brushMultiple.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-01"), brushMultiple.getSymbol());
		brushMultipleIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-01"), brushMultipleIncreased.getSymbol());
		brushBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-01"), brushBetween.getSymbol());
		brushBetweenIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-01"), brushBetweenIncreased.getSymbol());

		rubMultiple.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-01"), rubMultiple.getSymbol());
		rubMultipleIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-01"), rubMultipleIncreased.getSymbol());
		rubBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-01"), rubBetween.getSymbol());
		rubBetweenIncreased.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-01"), rubBetweenIncreased.getSymbol());

		surfaceSymbols.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-01"), surfaceSymbols.getSymbol());
		surfaceSymbolsPitched.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-01"), surfaceSymbolsPitched.getSymbol());
		surfaceBetween.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-01"), surfaceBetween.getSymbol());
		surfaceBetweenPitched.mirror();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-01"), surfaceBetweenPitched.getSymbol());
	}

	@Override
	public void testCanMirrorVertically() {

		assertFalse(touchSingle.canMirrorVertically());
		assertTrue(touchMultiple.canMirrorVertically());
		assertTrue(touchMultipleIncreased.canMirrorVertically());
		assertTrue(touchBetween.canMirrorVertically());
		assertTrue(touchBetweenIncreased.canMirrorVertically());

		assertFalse(graspSingle.canMirrorVertically());
		assertTrue(graspMultiple.canMirrorVertically());
		assertTrue(graspMultipleIncreased.canMirrorVertically());
		assertTrue(graspBetween.canMirrorVertically());
		assertTrue(graspBetweenIncreased.canMirrorVertically());

		assertFalse(strikeSingle.canMirrorVertically());
		assertTrue(strikeMultiple.canMirrorVertically());
		assertTrue(strikeMultipleIncreased.canMirrorVertically());
		assertTrue(strikeBetween.canMirrorVertically());
		assertTrue(strikeBetweenIncreased.canMirrorVertically());

		assertFalse(brushSingle.canMirrorVertically());
		assertTrue(brushMultiple.canMirrorVertically());
		assertTrue(brushMultipleIncreased.canMirrorVertically());
		assertTrue(brushBetween.canMirrorVertically());
		assertTrue(brushBetweenIncreased.canMirrorVertically());

		assertFalse(rubSingle.canMirrorVertically());
		assertTrue(rubMultiple.canMirrorVertically());
		assertTrue(rubMultipleIncreased.canMirrorVertically());
		assertTrue(rubBetween.canMirrorVertically());
		assertTrue(rubBetweenIncreased.canMirrorVertically());

		assertTrue(surfaceSymbols.canMirrorVertically());
		assertTrue(surfaceSymbolsPitched.canMirrorVertically());

		assertTrue(surfaceBetween.canMirrorVertically());
		assertTrue(surfaceBetweenPitched.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		touchMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-01-01"), touchMultiple.getSymbol());
		touchMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-002-01-02-01"), touchMultipleIncreased.getSymbol());
		touchBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-01-01"), touchBetween.getSymbol());
		touchBetweenIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-003-01-02-01"), touchBetweenIncreased.getSymbol());

		graspMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-01-01"), graspMultiple.getSymbol());
		graspMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-005-01-02-01"), graspMultipleIncreased.getSymbol());
		graspBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-01-01"), graspBetween.getSymbol());
		graspBetweenIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-006-01-02-01"), graspBetweenIncreased.getSymbol());

		strikeMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-01-01"), strikeMultiple.getSymbol());
		strikeMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-008-01-02-01"), strikeMultipleIncreased.getSymbol());
		strikeBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-01-01"), strikeBetween.getSymbol());
		strikeBetweenIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-009-01-02-01"), strikeBetweenIncreased.getSymbol());

		brushMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-01-01"), brushMultiple.getSymbol());
		brushMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-011-01-02-01"), brushMultipleIncreased.getSymbol());
		brushBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-01-01"), brushBetween.getSymbol());
		brushBetweenIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-012-01-02-01"), brushBetweenIncreased.getSymbol());

		rubMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-01-01"), rubMultiple.getSymbol());
		rubMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-014-01-02-01"), rubMultipleIncreased.getSymbol());
		rubBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-01-01"), rubBetween.getSymbol());
		rubBetweenIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-015-01-02-01"), rubBetweenIncreased.getSymbol());

		surfaceSymbols.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-05"), surfaceSymbols.getSymbol());
		surfaceSymbols.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-01"), surfaceSymbols.getSymbol());

		surfaceSymbolsPitched.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-05"), surfaceSymbolsPitched.getSymbol());
		surfaceSymbolsPitched.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-01"), surfaceSymbolsPitched.getSymbol());

		surfaceBetween.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-01"), surfaceBetween.getSymbol());
		surfaceBetweenPitched.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-01"), surfaceBetweenPitched.getSymbol());
	}

	@Override
	public void testCanPitch() {

		assertFalse(touchSingle.canPitch());
		assertFalse(touchMultiple.canPitch());
		assertFalse(touchMultipleIncreased.canPitch());
		assertFalse(touchBetween.canPitch());
		assertFalse(touchBetweenIncreased.canPitch());

		assertFalse(graspMultiple.canPitch());
		assertFalse(graspSingle.canPitch());
		assertFalse(graspMultipleIncreased.canPitch());
		assertFalse(graspBetween.canPitch());
		assertFalse(graspBetweenIncreased.canPitch());

		assertFalse(strikeSingle.canPitch());
		assertFalse(strikeMultiple.canPitch());
		assertFalse(strikeMultipleIncreased.canPitch());
		assertFalse(strikeBetween.canPitch());
		assertFalse(strikeBetweenIncreased.canPitch());

		assertFalse(brushSingle.canPitch());
		assertFalse(brushMultiple.canPitch());
		assertFalse(brushMultipleIncreased.canPitch());
		assertFalse(brushBetween.canPitch());
		assertFalse(brushBetweenIncreased.canPitch());

		assertFalse(rubSingle.canPitch());
		assertFalse(rubMultiple.canPitch());
		assertFalse(rubMultipleIncreased.canPitch());
		assertFalse(rubBetween.canPitch());
		assertFalse(rubBetweenIncreased.canPitch());

		assertTrue(surfaceSymbols.canPitch());
		assertTrue(surfaceSymbolsPitched.canPitch());

		assertTrue(surfaceBetween.canPitch());
		assertTrue(surfaceBetweenPitched.canPitch());

	}

	@Override
	public void testPitch() {
		surfaceSymbols.pitch();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-02-01"), surfaceSymbols.getSymbol());
		surfaceSymbolsPitched.pitch();
		assertEquals(symbolFactory.createSymbol("02-01-016-01-01-01"), surfaceSymbolsPitched.getSymbol());

		surfaceBetween.pitch();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-02-01"), surfaceBetween.getSymbol());
		surfaceBetweenPitched.pitch();
		assertEquals(symbolFactory.createSymbol("02-01-017-01-01-01"), surfaceBetweenPitched.getSymbol());

	}

	@Override
	public void testCanRoll() {
		assertFalse(touchSingle.canRoll());
		assertFalse(touchMultiple.canRoll());
		assertFalse(touchMultipleIncreased.canRoll());
		assertFalse(touchBetween.canRoll());
		assertFalse(touchBetweenIncreased.canRoll());

		assertFalse(graspSingle.canRoll());
		assertFalse(graspMultiple.canRoll());
		assertFalse(graspMultipleIncreased.canRoll());
		assertFalse(graspBetween.canRoll());
		assertFalse(graspBetweenIncreased.canRoll());

		assertFalse(strikeSingle.canRoll());
		assertFalse(strikeMultiple.canRoll());
		assertFalse(strikeMultipleIncreased.canRoll());
		assertFalse(strikeBetween.canRoll());
		assertFalse(strikeBetweenIncreased.canRoll());

		assertFalse(brushSingle.canRoll());
		assertFalse(brushMultiple.canRoll());
		assertFalse(brushMultipleIncreased.canRoll());
		assertFalse(brushBetween.canRoll());
		assertFalse(brushBetweenIncreased.canRoll());

		assertFalse(rubSingle.canRoll());
		assertFalse(rubMultiple.canRoll());
		assertFalse(rubMultipleIncreased.canRoll());
		assertFalse(rubBetween.canRoll());
		assertFalse(rubBetweenIncreased.canRoll());

		assertFalse(surfaceSymbols.canRoll());
		assertFalse(surfaceSymbolsPitched.canRoll());
		assertFalse(surfaceBetween.canRoll());
		assertFalse(surfaceBetweenPitched.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertFalse(touchSingle.canSwitchArrowHead());
		assertFalse(touchMultiple.canSwitchArrowHead());
		assertFalse(touchMultipleIncreased.canSwitchArrowHead());
		assertFalse(touchBetween.canSwitchArrowHead());
		assertFalse(touchBetweenIncreased.canSwitchArrowHead());

		assertFalse(graspSingle.canSwitchArrowHead());
		assertFalse(graspMultiple.canSwitchArrowHead());
		assertFalse(graspMultipleIncreased.canSwitchArrowHead());
		assertFalse(graspBetween.canSwitchArrowHead());
		assertFalse(graspBetweenIncreased.canSwitchArrowHead());

		assertFalse(strikeSingle.canSwitchArrowHead());
		assertFalse(strikeMultiple.canSwitchArrowHead());
		assertFalse(strikeMultipleIncreased.canSwitchArrowHead());
		assertFalse(strikeBetween.canSwitchArrowHead());
		assertFalse(strikeBetweenIncreased.canSwitchArrowHead());

		assertFalse(brushSingle.canSwitchArrowHead());
		assertFalse(brushMultiple.canSwitchArrowHead());
		assertFalse(brushMultipleIncreased.canSwitchArrowHead());
		assertFalse(brushBetween.canSwitchArrowHead());
		assertFalse(brushBetweenIncreased.canSwitchArrowHead());

		assertFalse(rubSingle.canSwitchArrowHead());
		assertFalse(rubMultiple.canSwitchArrowHead());
		assertFalse(rubMultipleIncreased.canSwitchArrowHead());
		assertFalse(rubBetween.canSwitchArrowHead());
		assertFalse(rubBetweenIncreased.canSwitchArrowHead());

		assertFalse(surfaceSymbols.canSwitchArrowHead());
		assertFalse(surfaceSymbolsPitched.canSwitchArrowHead());
		assertFalse(surfaceBetween.canSwitchArrowHead());
		assertFalse(surfaceBetweenPitched.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

	}

	@Override
	public void testCanSwitchToNormalArrows() {
		assertFalse(touchSingle.canSwitchToNormalArrows());
		assertFalse(touchMultiple.canSwitchToNormalArrows());
		assertFalse(touchMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(touchBetween.canSwitchToNormalArrows());
		assertFalse(touchBetweenIncreased.canSwitchToNormalArrows());

		assertFalse(graspSingle.canSwitchToNormalArrows());
		assertFalse(graspMultiple.canSwitchToNormalArrows());
		assertFalse(graspMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(graspBetween.canSwitchToNormalArrows());
		assertFalse(graspBetweenIncreased.canSwitchToNormalArrows());

		assertFalse(strikeSingle.canSwitchToNormalArrows());
		assertFalse(strikeMultiple.canSwitchToNormalArrows());
		assertFalse(strikeMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(strikeBetween.canSwitchToNormalArrows());
		assertFalse(strikeBetweenIncreased.canSwitchToNormalArrows());

		assertFalse(brushSingle.canSwitchToNormalArrows());
		assertFalse(brushMultiple.canSwitchToNormalArrows());
		assertFalse(brushMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(brushBetween.canSwitchToNormalArrows());
		assertFalse(brushBetweenIncreased.canSwitchToNormalArrows());

		assertFalse(rubSingle.canSwitchToNormalArrows());
		assertFalse(rubMultiple.canSwitchToNormalArrows());
		assertFalse(rubMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(rubBetween.canSwitchToNormalArrows());
		assertFalse(rubBetweenIncreased.canSwitchToNormalArrows());

		assertFalse(surfaceSymbols.canSwitchToNormalArrows());
		assertFalse(surfaceSymbolsPitched.canSwitchToNormalArrows());
		assertFalse(surfaceBetween.canSwitchToNormalArrows());
		assertFalse(surfaceBetweenPitched.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(touchSingle.canSwitchToAlternatingArrows());
		assertFalse(touchMultiple.canSwitchToAlternatingArrows());
		assertFalse(touchMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(touchBetween.canSwitchToAlternatingArrows());
		assertFalse(touchBetweenIncreased.canSwitchToAlternatingArrows());

		assertFalse(graspSingle.canSwitchToAlternatingArrows());
		assertFalse(graspMultiple.canSwitchToAlternatingArrows());
		assertFalse(graspMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(graspBetween.canSwitchToAlternatingArrows());
		assertFalse(graspBetweenIncreased.canSwitchToAlternatingArrows());

		assertFalse(strikeSingle.canSwitchToAlternatingArrows());
		assertFalse(strikeMultiple.canSwitchToAlternatingArrows());
		assertFalse(strikeMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(strikeBetween.canSwitchToAlternatingArrows());
		assertFalse(strikeBetweenIncreased.canSwitchToAlternatingArrows());

		assertFalse(brushSingle.canSwitchToAlternatingArrows());
		assertFalse(brushMultiple.canSwitchToAlternatingArrows());
		assertFalse(brushMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(brushBetween.canSwitchToAlternatingArrows());
		assertFalse(brushBetweenIncreased.canSwitchToAlternatingArrows());

		assertFalse(rubSingle.canSwitchToAlternatingArrows());
		assertFalse(rubMultiple.canSwitchToAlternatingArrows());
		assertFalse(rubMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(rubBetween.canSwitchToAlternatingArrows());
		assertFalse(rubBetweenIncreased.canSwitchToAlternatingArrows());

		assertFalse(surfaceSymbols.canSwitchToAlternatingArrows());
		assertFalse(surfaceSymbolsPitched.canSwitchToAlternatingArrows());
		assertFalse(surfaceBetween.canSwitchToAlternatingArrows());
		assertFalse(surfaceBetweenPitched.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

	}

	@Override
	public void testCanSwitchStartingPoint() {
		assertFalse(touchSingle.canSwitchStartingPoint());
		assertFalse(touchMultiple.canSwitchStartingPoint());
		assertFalse(touchMultipleIncreased.canSwitchStartingPoint());
		assertFalse(touchBetween.canSwitchStartingPoint());
		assertFalse(touchBetweenIncreased.canSwitchStartingPoint());

		assertFalse(graspSingle.canSwitchStartingPoint());
		assertFalse(graspMultiple.canSwitchStartingPoint());
		assertFalse(graspMultipleIncreased.canSwitchStartingPoint());
		assertFalse(graspBetween.canSwitchStartingPoint());
		assertFalse(graspBetweenIncreased.canSwitchStartingPoint());

		assertFalse(strikeSingle.canSwitchStartingPoint());
		assertFalse(strikeMultiple.canSwitchStartingPoint());
		assertFalse(strikeMultipleIncreased.canSwitchStartingPoint());
		assertFalse(strikeBetween.canSwitchStartingPoint());
		assertFalse(strikeBetweenIncreased.canSwitchStartingPoint());

		assertFalse(brushSingle.canSwitchStartingPoint());
		assertFalse(brushMultiple.canSwitchStartingPoint());
		assertFalse(brushMultipleIncreased.canSwitchStartingPoint());
		assertFalse(brushBetween.canSwitchStartingPoint());
		assertFalse(brushBetweenIncreased.canSwitchStartingPoint());

		assertFalse(rubSingle.canSwitchStartingPoint());
		assertFalse(rubMultiple.canSwitchStartingPoint());
		assertFalse(rubMultipleIncreased.canSwitchStartingPoint());
		assertFalse(rubBetween.canSwitchStartingPoint());
		assertFalse(rubBetweenIncreased.canSwitchStartingPoint());

		assertFalse(surfaceSymbols.canSwitchStartingPoint());
		assertFalse(surfaceSymbolsPitched.canSwitchStartingPoint());
		assertFalse(surfaceBetween.canSwitchStartingPoint());
		assertFalse(surfaceBetweenPitched.canSwitchStartingPoint());
	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {

		assertFalse(touchSingle.canSwitchPlane());
		assertFalse(touchMultiple.canSwitchPlane());
		assertFalse(touchMultipleIncreased.canSwitchPlane());
		assertFalse(touchBetween.canSwitchPlane());
		assertFalse(touchBetweenIncreased.canSwitchPlane());

		assertFalse(graspSingle.canSwitchPlane());
		assertFalse(graspMultiple.canSwitchPlane());
		assertFalse(graspMultipleIncreased.canSwitchPlane());
		assertFalse(graspBetween.canSwitchPlane());
		assertFalse(graspBetweenIncreased.canSwitchPlane());

		assertFalse(strikeSingle.canSwitchPlane());
		assertFalse(strikeMultiple.canSwitchPlane());
		assertFalse(strikeMultipleIncreased.canSwitchPlane());
		assertFalse(strikeBetween.canSwitchPlane());
		assertFalse(strikeBetweenIncreased.canSwitchPlane());

		assertFalse(brushSingle.canSwitchPlane());
		assertFalse(brushMultiple.canSwitchPlane());
		assertFalse(brushMultipleIncreased.canSwitchPlane());
		assertFalse(brushBetween.canSwitchPlane());
		assertFalse(brushBetweenIncreased.canSwitchPlane());

		assertFalse(rubSingle.canSwitchPlane());
		assertFalse(rubMultiple.canSwitchPlane());
		assertFalse(rubMultipleIncreased.canSwitchPlane());
		assertFalse(rubBetween.canSwitchPlane());
		assertFalse(rubBetweenIncreased.canSwitchPlane());

		assertFalse(surfaceSymbols.canSwitchPlane());
		assertFalse(surfaceSymbolsPitched.canSwitchPlane());
		assertFalse(surfaceBetween.canSwitchPlane());
		assertFalse(surfaceBetweenPitched.canSwitchPlane());

	}

	@Override
	public void testSwitchPlane() {

	}

}
