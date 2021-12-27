package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.material.DynamicsBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedDynamicsSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class PositionedDynamicsSymbolTest {

	private SymbolFactory symbolFactory;
	private PositionedDynamicsSymbol fast;
	private PositionedDynamicsSymbol slow;
	private PositionedDynamicsSymbol tense;
	private PositionedDynamicsSymbol relaxed;
	private PositionedDynamicsSymbol sameTime;
	private PositionedDynamicsSymbol sameTimeAlternating;
	private PositionedDynamicsSymbol everyOtherTime;
	private PositionedDynamicsSymbol gradual;
	private PositionedDynamicsSymbol doubleFast;
	private PositionedDynamicsSymbol doubleTense;
	private PositionedDynamicsSymbol doubleRelaxed;
	private DbConnector connector;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());

		fast = new PositionedDynamicsSymbol(DynamicsBaseSymbol.FAST.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.FAST.getIswaSymbol().getBaseSymbol()));

		slow = new PositionedDynamicsSymbol(DynamicsBaseSymbol.SLOW.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.SLOW.getIswaSymbol().getBaseSymbol()));

		tense = new PositionedDynamicsSymbol(DynamicsBaseSymbol.TENSE.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.TENSE.getIswaSymbol().getBaseSymbol()));

		relaxed = new PositionedDynamicsSymbol(DynamicsBaseSymbol.RELAXED.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.RELAXED.getIswaSymbol().getBaseSymbol()));

		sameTime = new PositionedDynamicsSymbol(DynamicsBaseSymbol.SAME_TIME.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.SAME_TIME.getIswaSymbol().getBaseSymbol()));

		sameTimeAlternating = new PositionedDynamicsSymbol(DynamicsBaseSymbol.SAME_TIME_ALTERNATING.getIswaSymbol(), 34,
				32, 1, symbolFactory.getAllRotationsAndFillsFor(
						DynamicsBaseSymbol.SAME_TIME_ALTERNATING.getIswaSymbol().getBaseSymbol()));

		everyOtherTime = new PositionedDynamicsSymbol(DynamicsBaseSymbol.EVERY_OTHER_TIME.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(
						DynamicsBaseSymbol.EVERY_OTHER_TIME.getIswaSymbol().getBaseSymbol()));

		gradual = new PositionedDynamicsSymbol(DynamicsBaseSymbol.GRADUAL.getIswaSymbol(), 34, 32, 1,
				symbolFactory.getAllRotationsAndFillsFor(DynamicsBaseSymbol.GRADUAL.getIswaSymbol().getBaseSymbol()));

		doubleFast = new PositionedDynamicsSymbol(symbolFactory.createSymbol("03-01-001-01-03-01"), 12, 23, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(symbolFactory.createSymbol("03-01-001-01-03-01").getBaseSymbol()));

		doubleTense = new PositionedDynamicsSymbol(symbolFactory.createSymbol("03-01-003-01-03-01"), 12, 23, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(symbolFactory.createSymbol("03-01-003-01-03-01").getBaseSymbol()));

		doubleRelaxed = new PositionedDynamicsSymbol(symbolFactory.createSymbol("03-01-003-02-03-01"), 12, 23, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(symbolFactory.createSymbol("03-01-003-02-03-01").getBaseSymbol()));

	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testCanRotate() {
		assertFalse(fast.canRotate());
		assertTrue(slow.canRotate());
		assertFalse(tense.canRotate());
		assertFalse(relaxed.canRotate());
		assertTrue(sameTime.canRotate());
		assertTrue(sameTimeAlternating.canRotate());
		assertTrue(everyOtherTime.canRotate());
		assertTrue(gradual.canRotate());
	}

	@Test
	public void testCanManipulate() {
		assertTrue(fast.canManipulate());
		assertTrue(slow.canManipulate());
		assertTrue(tense.canManipulate());
		assertTrue(relaxed.canManipulate());
		assertTrue(sameTime.canManipulate());
		assertTrue(sameTimeAlternating.canManipulate());
		assertTrue(everyOtherTime.canManipulate());
		assertTrue(gradual.canManipulate());
	}

	@Test
	public void testCanRoll() {
		assertFalse(fast.canRoll());
		assertFalse(slow.canRoll());
		assertFalse(tense.canRoll());
		assertFalse(relaxed.canRoll());
		assertFalse(sameTime.canRoll());
		assertFalse(sameTimeAlternating.canRoll());
		assertFalse(everyOtherTime.canRoll());
		assertFalse(gradual.canRoll());
	}

	@Test
	public void testCanPitch() {
		assertFalse(fast.canPitch());
		assertFalse(slow.canPitch());
		assertFalse(tense.canPitch());
		assertFalse(relaxed.canPitch());
		assertFalse(sameTime.canPitch());
		assertFalse(sameTimeAlternating.canPitch());
		assertFalse(everyOtherTime.canPitch());
		assertFalse(gradual.canPitch());
	}

	@Test
	public void testCanMirror() {
		assertTrue(fast.canMirror());
		assertTrue(slow.canMirror());
		assertTrue(tense.canMirror());
		assertTrue(relaxed.canMirror());
		assertTrue(sameTime.canMirror());
		assertTrue(sameTimeAlternating.canMirror());
		assertTrue(everyOtherTime.canMirror());
		assertTrue(gradual.canMirror());
	}

	@Test
	public void testCanIncrease() {
		assertTrue(fast.canIncrease());
		assertFalse(slow.canIncrease());
		assertTrue(tense.canIncrease());
		assertTrue(relaxed.canIncrease());
		assertFalse(sameTime.canIncrease());
		assertFalse(sameTimeAlternating.canIncrease());
		assertFalse(everyOtherTime.canIncrease());
		assertFalse(gradual.canIncrease());
	}

	@Test
	public void testCanDecrease() {
		assertTrue(doubleFast.canDecrease());
		assertTrue(doubleTense.canDecrease());
		assertTrue(doubleRelaxed.canDecrease());

		assertFalse(fast.canDecrease());
		assertFalse(slow.canDecrease());
		assertFalse(tense.canDecrease());
		assertFalse(relaxed.canDecrease());
		assertFalse(sameTime.canDecrease());
		assertFalse(sameTimeAlternating.canDecrease());
		assertFalse(everyOtherTime.canDecrease());
		assertFalse(gradual.canDecrease());
	}

	@Test
	public void testRotateClockwise() {
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-01"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-08"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-07"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-06"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-05"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-04"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-03"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-02"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-01"), slow.getSymbol());
		slow.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-08"), slow.getSymbol());
	}

	@Test
	public void testRotateCounterClockwise() {
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-01"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-02"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-03"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-04"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-05"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-06"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-07"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-08"), slow.getSymbol());
		slow.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("03-01-002-01-01-01"), slow.getSymbol());
	}

	@Test
	public void testMirror() {
		fast.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-001-01-02-01"), fast.getSymbol());
		fast.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-001-01-01-01"), fast.getSymbol());

		tense.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-01-02-01"), tense.getSymbol());
		tense.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-01-01-01"), tense.getSymbol());

		relaxed.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-02-02-01"), relaxed.getSymbol());
		relaxed.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-02-01-01"), relaxed.getSymbol());

		doubleFast.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-001-01-04-01"), doubleFast.getSymbol());
		doubleFast.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-001-01-03-01"), doubleFast.getSymbol());

		doubleTense.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-01-04-01"), doubleTense.getSymbol());
		doubleTense.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-01-03-01"), doubleTense.getSymbol());

		doubleRelaxed.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-02-04-01"), doubleRelaxed.getSymbol());
		doubleRelaxed.mirror();
		assertEquals(symbolFactory.createSymbol("03-01-003-02-03-01"), doubleRelaxed.getSymbol());
	}

	@Test
	public void testIncrease() {
		fast.increase();
		assertEquals(doubleFast.getSymbol(), fast.getSymbol());
		tense.increase();
		assertEquals(doubleTense.getSymbol(), tense.getSymbol());
		relaxed.increase();
		assertEquals(doubleRelaxed.getSymbol(), relaxed.getSymbol());
	}

	@Test
	public void testIncreaseMirrored() {
		fast.mirror();
		doubleFast.mirror();
		fast.increase();
		assertEquals(doubleFast.getSymbol(), fast.getSymbol());

		tense.mirror();
		doubleTense.mirror();
		tense.increase();
		assertEquals(doubleTense.getSymbol(), tense.getSymbol());

		relaxed.mirror();
		doubleRelaxed.mirror();
		relaxed.increase();
		assertEquals(doubleRelaxed.getSymbol(), relaxed.getSymbol());
	}

	@Test
	public void testDecrease() {
		doubleFast.decrease();
		assertEquals(fast.getSymbol(), doubleFast.getSymbol());

		doubleTense.decrease();
		assertEquals(tense.getSymbol(), doubleTense.getSymbol());

		doubleRelaxed.decrease();
		assertEquals(relaxed.getSymbol(), doubleRelaxed.getSymbol());
	}

	@Test
	public void testDecreaseMirrored() {
		doubleFast.mirror();
		fast.mirror();
		doubleFast.decrease();
		assertEquals(fast.getSymbol(), doubleFast.getSymbol());

		doubleTense.mirror();
		tense.mirror();
		doubleTense.decrease();
		assertEquals(tense.getSymbol(), doubleTense.getSymbol());

		doubleRelaxed.mirror();
		relaxed.mirror();
		doubleRelaxed.decrease();
		assertEquals(relaxed.getSymbol(), doubleRelaxed.getSymbol());

	}

}
