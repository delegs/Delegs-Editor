package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.model.material.positionedHandSymbols.IndexHandSymbolTest;
import de.signWritingEditor.client.model.material.positionedHandSymbols.IndexMiddleHandSymbolTest;
import de.signWritingEditor.client.model.material.positionedHandSymbols.IndexMiddleThumbHandSymbolTest;
import de.signWritingEditor.client.model.material.positionedHandSymbols.PositionedHandSymbolTestInterface;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.PositionedHandSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class PositionedHandSymbolTest {

	private SymbolFactory symbolFactory;
	private PositionedHandSymbol positionedRightHandSymbol;
	private PositionedHandSymbol positionedLeftHandSymbol;

	private PositionedHandSymbolTestInterface indexHandSymbolTests;
	private PositionedHandSymbolTestInterface indexMiddleHandSymbolTests;
	private PositionedHandSymbolTestInterface indexMiddleThumbHandSymbolTests;

	private boolean classesCreated = false;

	private DbConnector connector;

	private ArrayList<PositionedHandSymbolTestInterface> tests;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		if (!classesCreated) {

			indexHandSymbolTests = new IndexHandSymbolTest();
			indexMiddleHandSymbolTests = new IndexMiddleHandSymbolTest();
			indexMiddleThumbHandSymbolTests = new IndexMiddleThumbHandSymbolTest();

            classesCreated = true;
		}

		this.tests = new ArrayList<PositionedHandSymbolTestInterface>() {
			{
				add(indexHandSymbolTests);
				add(indexMiddleHandSymbolTests);
				add(indexMiddleThumbHandSymbolTests);
            }
		};

		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.setUp(symbolFactory);
		}

		Symbol rightHandSymbol = symbolFactory.createSymbol("01-01-001-01-01-01");
		Symbol leftHandSymbol = symbolFactory.createSymbol("01-01-001-01-01-09");
		positionedRightHandSymbol = new PositionedHandSymbol(rightHandSymbol, 2, 1, 2,
				symbolFactory.getAllRotationsAndFillsFor(rightHandSymbol.getBaseSymbol()));
		positionedLeftHandSymbol = new PositionedHandSymbol(leftHandSymbol, 45, 56, 2,
				symbolFactory.getAllRotationsAndFillsFor(leftHandSymbol.getBaseSymbol()));

	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testIsLeftHand() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testIsLeftHand();
		}
	}

	@Test
	public void testIsRightHand() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testIsRightHand();
		}
	}

	@Test
	public void testCanIncrease() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanIncrease();
		}
	}

	@Test
	public void testIncrease() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testIncrease();
		}
	}

	@Test
	public void testCanDecrease() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanDecrease();
		}
	}

	@Test
	public void testDecrease() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testDecrease();
		}
	}

	@Test
	public void testCanRotate() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanRotate();
		}
	}

	@Test
	public void testRotateClockwise() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testRotateClockwise();
		}
	}

	@Test
	public void testRotateCounterClockwise() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testRotateCounterClockwise();
		}
	}

	@Test
	public void testCanMirror() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanMirror();
		}
	}

	@Test
	public void testMirror() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testMirror();
		}
	}

	@Test
	public void testCanMirrorVertically() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanMirrorVertically();
		}
	}

	@Test
	public void testMirrorVertically() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testMirrorVertically();
		}
	}

	@Test
	public void testCanPitch() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanPitch();
		}
	}

	@Test
	public void testPitch() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testPitch();
		}
	}

	@Test
	public void testCanRoll() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanRoll();
		}
	}

	@Test
	public void testRoll() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testRoll();
		}
	}

	@Test
	public void testCanSwitchArrowHead() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanSwitchArrowHead();
		}
	}

	@Test
	public void testSwitchArrowHead() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testSwitchArrowHead();
		}
	}

	@Test
	public void testCanSwitchToNormalArrows() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanSwitchToNormalArrows();
		}
	}

	@Test
	public void testSwitchToNormalArrows() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testSwitchToNormalArrows();
		}
	}

	@Test
	public void testCanSwitchToAlternatingArrows() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanSwitchToAlternatingArrows();
		}
	}

	@Test
	public void testSwitchToAlternatingArrows() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testSwitchToAlternatingArrows();
		}
	}

	@Test
	public void testCanSwitchStartingPoint() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testCanSwitchStartingPoint();
		}
	}

	@Test
	public void testSwitchStartingPoint() {
		for (PositionedHandSymbolTestInterface test : this.tests) {
			test.testSwitchStartingPoint();
		}
	}

	@Test
	public void testIsValidFill() {
		for (int i = 1; i <= 6; ++i) {
			assertTrue(positionedLeftHandSymbol.isValidFill(i));
			assertTrue(positionedRightHandSymbol.isValidFill(i));
		}
	}

	@Test
	public void testIsValidRotation() {
		for (int i = 1; i <= 16; ++i) {
			assertTrue(positionedLeftHandSymbol.isValidRotation(i));
			assertTrue(positionedRightHandSymbol.isValidRotation(i));
		}
	}

}