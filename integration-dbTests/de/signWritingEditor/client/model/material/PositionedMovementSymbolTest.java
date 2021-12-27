package de.signWritingEditor.client.model.material;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.model.material.positionedMovementSymbols.CirclesMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.ContactMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.CurvesHitFloorPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.CurvesHitWallPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.CurvesParallelFloorPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.CurvesParallelWallPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.FingerMovementMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.PositionedMovementSymbolTestInterface;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.StraightDiagonalPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.StraightFloorPlaneMovementSymbolTest;
import de.signWritingEditor.client.model.material.positionedMovementSymbols.StraightWallPlaneMovementSymbolTest;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.SymbolDB;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class PositionedMovementSymbolTest {

	private SymbolFactory symbolFactory;

	private boolean classesCreated = false;

	private PositionedMovementSymbolTestInterface contactMoventSymbols;
	private PositionedMovementSymbolTestInterface fingerMovementMovementSymbols;
	private PositionedMovementSymbolTestInterface straightWallPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface straightDiagonalPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface straightFloorPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface curvesParallelWallPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface curvesHitWallPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface curvesHitFloorPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface curvesParallelFloorPlaneMovementSymbols;
	private PositionedMovementSymbolTestInterface circlesMovementSymbols;

	private DbConnector connector;

	@Before
	public void setUp() throws Exception {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		symbolFactory = new SymbolFactory(new SymbolDB(connector).getAllSymbols());
		if (!classesCreated) {
			contactMoventSymbols = new ContactMovementSymbolTest();
			fingerMovementMovementSymbols = new FingerMovementMovementSymbolTest();
			straightWallPlaneMovementSymbols = new StraightWallPlaneMovementSymbolTest();
			straightDiagonalPlaneMovementSymbols = new StraightDiagonalPlaneMovementSymbolTest();
			straightFloorPlaneMovementSymbols = new StraightFloorPlaneMovementSymbolTest();
			curvesParallelWallPlaneMovementSymbols = new CurvesParallelWallPlaneMovementSymbolTest();
			curvesHitWallPlaneMovementSymbols = new CurvesHitWallPlaneMovementSymbolTest();
			curvesHitFloorPlaneMovementSymbols = new CurvesHitFloorPlaneMovementSymbolTest();
			curvesParallelFloorPlaneMovementSymbols = new CurvesParallelFloorPlaneMovementSymbolTest();
			circlesMovementSymbols = new CirclesMovementSymbolTest();
			classesCreated = true;
		}
		// setUP all tests

		contactMoventSymbols.setUp(symbolFactory);
		fingerMovementMovementSymbols.setUp(symbolFactory);
		straightWallPlaneMovementSymbols.setUp(symbolFactory);
		straightDiagonalPlaneMovementSymbols.setUp(symbolFactory);
		straightFloorPlaneMovementSymbols.setUp(symbolFactory);
		curvesParallelWallPlaneMovementSymbols.setUp(symbolFactory);
		curvesHitWallPlaneMovementSymbols.setUp(symbolFactory);
		curvesHitFloorPlaneMovementSymbols.setUp(symbolFactory);
		curvesParallelFloorPlaneMovementSymbols.setUp(symbolFactory);
		circlesMovementSymbols.setUp(symbolFactory);

	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testCanIncrease() {
		contactMoventSymbols.testCanIncrease();
		fingerMovementMovementSymbols.testCanIncrease();
		straightWallPlaneMovementSymbols.testCanIncrease();
		straightDiagonalPlaneMovementSymbols.testCanIncrease();
		straightFloorPlaneMovementSymbols.testCanIncrease();
		curvesParallelWallPlaneMovementSymbols.testCanIncrease();
		curvesHitWallPlaneMovementSymbols.testCanIncrease();
		curvesHitFloorPlaneMovementSymbols.testCanIncrease();
		curvesParallelFloorPlaneMovementSymbols.testCanIncrease();
		circlesMovementSymbols.testCanIncrease();
	}

	@Test
	public void testIncrease() {
		contactMoventSymbols.testIncrease();
		fingerMovementMovementSymbols.testIncrease();
		straightWallPlaneMovementSymbols.testIncrease();
		straightDiagonalPlaneMovementSymbols.testIncrease();
		straightFloorPlaneMovementSymbols.testIncrease();
		curvesParallelWallPlaneMovementSymbols.testIncrease();
		curvesHitWallPlaneMovementSymbols.testIncrease();
		curvesHitFloorPlaneMovementSymbols.testIncrease();
		curvesParallelFloorPlaneMovementSymbols.testIncrease();
		circlesMovementSymbols.testIncrease();
	}

	@Test
	public void testCanDecrease() {
		contactMoventSymbols.testCanDecrease();
		fingerMovementMovementSymbols.testCanDecrease();
		straightWallPlaneMovementSymbols.testCanDecrease();
		straightDiagonalPlaneMovementSymbols.testCanDecrease();
		straightFloorPlaneMovementSymbols.testCanDecrease();
		curvesParallelWallPlaneMovementSymbols.testCanDecrease();
		curvesHitWallPlaneMovementSymbols.testCanDecrease();
		curvesHitFloorPlaneMovementSymbols.testCanDecrease();
		curvesParallelFloorPlaneMovementSymbols.testCanDecrease();
		circlesMovementSymbols.testCanDecrease();
	}

	@Test
	public void testDecrease() {
		contactMoventSymbols.testDecrease();
		fingerMovementMovementSymbols.testDecrease();
		straightWallPlaneMovementSymbols.testDecrease();
		straightDiagonalPlaneMovementSymbols.testDecrease();
		straightFloorPlaneMovementSymbols.testDecrease();
		curvesParallelWallPlaneMovementSymbols.testDecrease();
		curvesHitWallPlaneMovementSymbols.testDecrease();
		curvesHitFloorPlaneMovementSymbols.testDecrease();
		curvesParallelFloorPlaneMovementSymbols.testDecrease();
		circlesMovementSymbols.testDecrease();
	}

	@Test
	public void testCanRotate() {
		contactMoventSymbols.testCanRotate();
		fingerMovementMovementSymbols.testCanRotate();
		straightWallPlaneMovementSymbols.testCanRotate();
		straightDiagonalPlaneMovementSymbols.testCanRotate();
		straightFloorPlaneMovementSymbols.testCanRotate();
		curvesParallelWallPlaneMovementSymbols.testCanRotate();
		curvesHitWallPlaneMovementSymbols.testCanRotate();
		curvesHitFloorPlaneMovementSymbols.testCanRotate();
		curvesParallelFloorPlaneMovementSymbols.testCanRotate();
		circlesMovementSymbols.testCanRotate();
	}

	@Test
	public void testRotateClockwise() {
		contactMoventSymbols.testRotateClockwise();
		fingerMovementMovementSymbols.testRotateClockwise();
		straightWallPlaneMovementSymbols.testRotateClockwise();
		straightDiagonalPlaneMovementSymbols.testRotateClockwise();
		straightFloorPlaneMovementSymbols.testRotateClockwise();
		curvesParallelWallPlaneMovementSymbols.testRotateClockwise();
		curvesHitWallPlaneMovementSymbols.testRotateClockwise();
		curvesHitFloorPlaneMovementSymbols.testRotateClockwise();
		curvesParallelFloorPlaneMovementSymbols.testRotateClockwise();
		circlesMovementSymbols.testRotateClockwise();
	}

	@Test
	public void testRotateCounterClockwise() {
		contactMoventSymbols.testRotateCounterClockwise();
		fingerMovementMovementSymbols.testRotateCounterClockwise();
		straightWallPlaneMovementSymbols.testRotateCounterClockwise();
		straightDiagonalPlaneMovementSymbols.testRotateCounterClockwise();
		straightFloorPlaneMovementSymbols.testRotateCounterClockwise();
		curvesParallelWallPlaneMovementSymbols.testRotateCounterClockwise();
		curvesHitWallPlaneMovementSymbols.testRotateCounterClockwise();
		curvesHitFloorPlaneMovementSymbols.testRotateCounterClockwise();
		curvesParallelFloorPlaneMovementSymbols.testRotateCounterClockwise();
		circlesMovementSymbols.testRotateCounterClockwise();
	}

	@Test
	public void testCanMirror() {
		contactMoventSymbols.testCanMirror();
		fingerMovementMovementSymbols.testCanMirror();
		straightWallPlaneMovementSymbols.testCanMirror();
		straightDiagonalPlaneMovementSymbols.testCanMirror();
		straightFloorPlaneMovementSymbols.testCanMirror();
		curvesParallelWallPlaneMovementSymbols.testCanMirror();
		curvesHitWallPlaneMovementSymbols.testCanMirror();
		curvesHitFloorPlaneMovementSymbols.testCanMirror();
		curvesParallelFloorPlaneMovementSymbols.testCanMirror();
		circlesMovementSymbols.testCanMirror();
	}

	@Test
	public void testMirror() {
		contactMoventSymbols.testMirror();
		fingerMovementMovementSymbols.testMirror();
		straightWallPlaneMovementSymbols.testMirror();
		straightDiagonalPlaneMovementSymbols.testMirror();
		straightFloorPlaneMovementSymbols.testMirror();
		curvesParallelWallPlaneMovementSymbols.testMirror();
		curvesHitWallPlaneMovementSymbols.testMirror();
		curvesHitFloorPlaneMovementSymbols.testMirror();
		curvesParallelFloorPlaneMovementSymbols.testMirror();
		circlesMovementSymbols.testMirror();
	}

	@Test
	public void testCanMirrorVertically() {
		contactMoventSymbols.testCanMirrorVertically();
		fingerMovementMovementSymbols.testCanMirrorVertically();
		straightWallPlaneMovementSymbols.testCanMirrorVertically();
		straightDiagonalPlaneMovementSymbols.testCanMirrorVertically();
		straightFloorPlaneMovementSymbols.testCanMirrorVertically();
		curvesParallelWallPlaneMovementSymbols.testCanMirrorVertically();
		curvesHitWallPlaneMovementSymbols.testCanMirrorVertically();
		curvesHitFloorPlaneMovementSymbols.testCanMirrorVertically();
		curvesParallelFloorPlaneMovementSymbols.testCanMirrorVertically();
		circlesMovementSymbols.testCanMirrorVertically();
	}

	@Test
	public void testMirrorVertically() {
		contactMoventSymbols.testMirrorVertically();
		fingerMovementMovementSymbols.testMirrorVertically();
		straightWallPlaneMovementSymbols.testMirrorVertically();
		straightDiagonalPlaneMovementSymbols.testMirrorVertically();
		straightFloorPlaneMovementSymbols.testMirrorVertically();
		curvesParallelWallPlaneMovementSymbols.testMirrorVertically();
		curvesHitWallPlaneMovementSymbols.testMirrorVertically();
		curvesHitFloorPlaneMovementSymbols.testMirrorVertically();
		curvesParallelFloorPlaneMovementSymbols.testMirrorVertically();
		circlesMovementSymbols.testMirrorVertically();
	}

	@Test
	public void testCanPitch() {
		contactMoventSymbols.testCanPitch();
		fingerMovementMovementSymbols.testCanPitch();
		straightWallPlaneMovementSymbols.testCanPitch();
		straightDiagonalPlaneMovementSymbols.testCanPitch();
		straightFloorPlaneMovementSymbols.testCanPitch();
		curvesParallelWallPlaneMovementSymbols.testCanPitch();
		curvesHitWallPlaneMovementSymbols.testCanPitch();
		curvesHitFloorPlaneMovementSymbols.testCanPitch();
		curvesParallelFloorPlaneMovementSymbols.testCanPitch();
		circlesMovementSymbols.testCanPitch();
	}

	@Test
	public void testPitch() {
		contactMoventSymbols.testPitch();
		fingerMovementMovementSymbols.testPitch();
		straightWallPlaneMovementSymbols.testPitch();
		straightDiagonalPlaneMovementSymbols.testPitch();
		straightFloorPlaneMovementSymbols.testPitch();
		curvesParallelWallPlaneMovementSymbols.testPitch();
		curvesHitWallPlaneMovementSymbols.testPitch();
		curvesHitFloorPlaneMovementSymbols.testPitch();
		curvesParallelFloorPlaneMovementSymbols.testPitch();
		circlesMovementSymbols.testPitch();
	}

	@Test
	public void testCanRoll() {
		contactMoventSymbols.testCanRoll();
		fingerMovementMovementSymbols.testCanRoll();
		straightWallPlaneMovementSymbols.testCanRoll();
		straightDiagonalPlaneMovementSymbols.testCanRoll();
		straightFloorPlaneMovementSymbols.testCanRoll();
		curvesParallelWallPlaneMovementSymbols.testCanRoll();
		curvesHitWallPlaneMovementSymbols.testCanRoll();
		curvesHitFloorPlaneMovementSymbols.testCanRoll();
		curvesParallelFloorPlaneMovementSymbols.testCanRoll();
		circlesMovementSymbols.testCanRoll();
	}

	@Test
	public void testRoll() {
		contactMoventSymbols.testRoll();
		fingerMovementMovementSymbols.testRoll();
		straightWallPlaneMovementSymbols.testRoll();
		straightDiagonalPlaneMovementSymbols.testRoll();
		straightFloorPlaneMovementSymbols.testRoll();
		curvesParallelWallPlaneMovementSymbols.testRoll();
		curvesHitWallPlaneMovementSymbols.testRoll();
		curvesHitFloorPlaneMovementSymbols.testRoll();
		curvesParallelFloorPlaneMovementSymbols.testRoll();
		circlesMovementSymbols.testRoll();
	}

	@Test
	public void testCanSwitchArrowHead() {
		contactMoventSymbols.testCanSwitchArrowHead();
		fingerMovementMovementSymbols.testCanSwitchArrowHead();
		straightWallPlaneMovementSymbols.testCanSwitchArrowHead();
		straightDiagonalPlaneMovementSymbols.testCanSwitchArrowHead();
		straightFloorPlaneMovementSymbols.testCanSwitchArrowHead();
		curvesParallelWallPlaneMovementSymbols.testCanSwitchArrowHead();
		curvesHitWallPlaneMovementSymbols.testCanSwitchArrowHead();
		curvesHitFloorPlaneMovementSymbols.testCanSwitchArrowHead();
		curvesParallelFloorPlaneMovementSymbols.testCanSwitchArrowHead();
		circlesMovementSymbols.testCanSwitchArrowHead();
	}

	@Test
	public void testSwitchArrowHead() {
		contactMoventSymbols.testSwitchArrowHead();
		fingerMovementMovementSymbols.testSwitchArrowHead();
		straightWallPlaneMovementSymbols.testSwitchArrowHead();
		straightDiagonalPlaneMovementSymbols.testSwitchArrowHead();
		straightFloorPlaneMovementSymbols.testSwitchArrowHead();
		curvesParallelWallPlaneMovementSymbols.testSwitchArrowHead();
		curvesHitWallPlaneMovementSymbols.testSwitchArrowHead();
		curvesHitFloorPlaneMovementSymbols.testSwitchArrowHead();
		curvesParallelFloorPlaneMovementSymbols.testSwitchArrowHead();
		circlesMovementSymbols.testSwitchArrowHead();
	}

	@Test
	public void testCanSwitchToNormalArrows() {
		contactMoventSymbols.testCanSwitchToNormalArrows();
		fingerMovementMovementSymbols.testCanSwitchToNormalArrows();
		straightWallPlaneMovementSymbols.testCanSwitchToNormalArrows();
		straightDiagonalPlaneMovementSymbols.testCanSwitchToNormalArrows();
		straightFloorPlaneMovementSymbols.testCanSwitchToNormalArrows();
		curvesParallelWallPlaneMovementSymbols.testCanSwitchToNormalArrows();
		curvesHitWallPlaneMovementSymbols.testCanSwitchToNormalArrows();
		curvesHitFloorPlaneMovementSymbols.testCanSwitchToNormalArrows();
		curvesParallelFloorPlaneMovementSymbols.testCanSwitchToNormalArrows();
		circlesMovementSymbols.testCanSwitchToNormalArrows();
	}

	@Test
	public void testSwitchToNormalArrows() {
		contactMoventSymbols.testSwitchToNormalArrows();
		fingerMovementMovementSymbols.testSwitchToNormalArrows();
		straightWallPlaneMovementSymbols.testSwitchToNormalArrows();
		straightDiagonalPlaneMovementSymbols.testSwitchToNormalArrows();
		straightFloorPlaneMovementSymbols.testSwitchToNormalArrows();
		curvesParallelWallPlaneMovementSymbols.testSwitchToNormalArrows();
		curvesHitWallPlaneMovementSymbols.testSwitchToNormalArrows();
		curvesHitFloorPlaneMovementSymbols.testSwitchToNormalArrows();
		curvesParallelFloorPlaneMovementSymbols.testSwitchToNormalArrows();
		circlesMovementSymbols.testSwitchToNormalArrows();
	}

	@Test
	public void testCanSwitchToAlternatingArrows() {
		contactMoventSymbols.testCanSwitchToAlternatingArrows();
		fingerMovementMovementSymbols.testCanSwitchToAlternatingArrows();
		straightWallPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		straightDiagonalPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		straightFloorPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		curvesParallelWallPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		curvesHitWallPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		curvesHitFloorPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		curvesParallelFloorPlaneMovementSymbols.testCanSwitchToAlternatingArrows();
		circlesMovementSymbols.testCanSwitchToAlternatingArrows();
	}

	@Test
	public void testSwitchToAlternatingArrows() {
		contactMoventSymbols.testSwitchToAlternatingArrows();
		fingerMovementMovementSymbols.testSwitchToAlternatingArrows();
		straightWallPlaneMovementSymbols.testSwitchToAlternatingArrows();
		straightDiagonalPlaneMovementSymbols.testSwitchToAlternatingArrows();
		straightFloorPlaneMovementSymbols.testSwitchToAlternatingArrows();
		curvesParallelWallPlaneMovementSymbols.testSwitchToAlternatingArrows();
		curvesHitWallPlaneMovementSymbols.testSwitchToAlternatingArrows();
		curvesHitFloorPlaneMovementSymbols.testSwitchToAlternatingArrows();
		curvesParallelFloorPlaneMovementSymbols.testSwitchToAlternatingArrows();
		circlesMovementSymbols.testSwitchToAlternatingArrows();
	}

	@Test
	public void testCanSwitchStartingPoint() {

		contactMoventSymbols.testCanSwitchStartingPoint();
		fingerMovementMovementSymbols.testCanSwitchStartingPoint();
		straightWallPlaneMovementSymbols.testCanSwitchStartingPoint();
		straightDiagonalPlaneMovementSymbols.testCanSwitchStartingPoint();
		straightFloorPlaneMovementSymbols.testCanSwitchStartingPoint();
		curvesParallelWallPlaneMovementSymbols.testCanSwitchStartingPoint();
		curvesHitWallPlaneMovementSymbols.testCanSwitchStartingPoint();
		curvesHitFloorPlaneMovementSymbols.testCanSwitchStartingPoint();
		curvesParallelFloorPlaneMovementSymbols.testCanSwitchStartingPoint();
		circlesMovementSymbols.testCanSwitchStartingPoint();

	}

	@Test
	public void testSwitchStartingPoint() {

		contactMoventSymbols.testSwitchStartingPoint();
		fingerMovementMovementSymbols.testSwitchStartingPoint();
		straightWallPlaneMovementSymbols.testSwitchStartingPoint();
		straightDiagonalPlaneMovementSymbols.testSwitchStartingPoint();
		straightFloorPlaneMovementSymbols.testSwitchStartingPoint();
		curvesParallelWallPlaneMovementSymbols.testSwitchStartingPoint();
		curvesHitWallPlaneMovementSymbols.testSwitchStartingPoint();
		curvesHitFloorPlaneMovementSymbols.testSwitchStartingPoint();
		curvesParallelFloorPlaneMovementSymbols.testSwitchStartingPoint();
		circlesMovementSymbols.testSwitchStartingPoint();
	}

	@Test
	public void testCanSwitchPlane() {

		contactMoventSymbols.testCanSwitchPlane();
		fingerMovementMovementSymbols.testCanSwitchPlane();
		straightWallPlaneMovementSymbols.testCanSwitchPlane();
		straightDiagonalPlaneMovementSymbols.testCanSwitchPlane();
		straightFloorPlaneMovementSymbols.testCanSwitchPlane();
		curvesParallelWallPlaneMovementSymbols.testCanSwitchPlane();
		curvesHitWallPlaneMovementSymbols.testCanSwitchPlane();
		curvesHitFloorPlaneMovementSymbols.testCanSwitchPlane();
		curvesParallelFloorPlaneMovementSymbols.testCanSwitchPlane();
		circlesMovementSymbols.testCanSwitchPlane();
	}

	@Test
	public void testSwitchPlane() {

		contactMoventSymbols.testSwitchPlane();
		fingerMovementMovementSymbols.testSwitchPlane();
		straightWallPlaneMovementSymbols.testSwitchPlane();
		straightDiagonalPlaneMovementSymbols.testSwitchPlane();
		straightFloorPlaneMovementSymbols.testSwitchPlane();
		curvesParallelWallPlaneMovementSymbols.testSwitchPlane();
		curvesHitWallPlaneMovementSymbols.testSwitchPlane();
		curvesHitFloorPlaneMovementSymbols.testSwitchPlane();
		curvesParallelFloorPlaneMovementSymbols.testSwitchPlane();
		circlesMovementSymbols.testSwitchPlane();
	}
}
