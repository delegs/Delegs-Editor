package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class FingerMovementMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	/**
	 * FingerMovementMovementSymbols Group 02 SymbolId 02
	 */
	private PositionedMovementSymbol squeezeLargeSingle;
	private PositionedMovementSymbol squeezeSmallSingle;
	private PositionedMovementSymbol squeezeLargeMultiple;
	private PositionedMovementSymbol squeezeLargeMultipleIncreased;
	private PositionedMovementSymbol squeezeSmallMultiple;
	private PositionedMovementSymbol squeezeSmallMultipleIncreased;
	private PositionedMovementSymbol squeezeSequential;
	private PositionedMovementSymbol squeezeSequentialIncreasedI;
	private PositionedMovementSymbol squeezeSequentialIncreasedII;
	private PositionedMovementSymbol squeezeSequentialIncreasedIII;
	private PositionedMovementSymbol squeezeSequentialMirrored;
	private PositionedMovementSymbol squeezeSequentialMirroredIncreasedI;
	private PositionedMovementSymbol squeezeSequentialMirroredIncreasedII;
	private PositionedMovementSymbol squeezeSequentialMirroredIncreasedIII;

	private PositionedMovementSymbol flickLargeSingle;
	private PositionedMovementSymbol flickSmallSingle;
	private PositionedMovementSymbol flickLargeMultiple;
	private PositionedMovementSymbol flickLargeMultipleIncreased;
	private PositionedMovementSymbol flickSmallMultiple;
	private PositionedMovementSymbol flickSmallMultipleIncreased;
	private PositionedMovementSymbol flickSequential;
	private PositionedMovementSymbol flickSequentialIncreasedI;
	private PositionedMovementSymbol flickSequentialIncreasedII;
	private PositionedMovementSymbol flickSequentialIncreasedIII;
	private PositionedMovementSymbol flickSequentialMirrored;
	private PositionedMovementSymbol flickSequentialMirroredIncreasedI;
	private PositionedMovementSymbol flickSequentialMirroredIncreasedII;
	private PositionedMovementSymbol flickSequentialMirroredIncreasedIII;

	private PositionedMovementSymbol squeezeFlickAlternating;

	private PositionedMovementSymbol hingeMovementUpDownLarge;
	private PositionedMovementSymbol hingeMovementUpDownLargeIncreasedI;
	private PositionedMovementSymbol hingeMovementUpDownLargeIncreasedII;
	private PositionedMovementSymbol hingeMovementUpDownLargeIncreasedIII;
	private PositionedMovementSymbol hingeMovementUpDownLargeIncreasedIV;

	private PositionedMovementSymbol hingeMovementUpDownSmall;
	private PositionedMovementSymbol hingeMovementUpDownSmallIncreasedI;
	private PositionedMovementSymbol hingeMovementUpDownSmallIncreasedII;
	private PositionedMovementSymbol hingeMovementUpDownSmallIncreasedIII;
	private PositionedMovementSymbol hingeMovementUpDownSmallIncreasedIV;

	private PositionedMovementSymbol hingeMovementUpSequential;
	private PositionedMovementSymbol hingeMovementUpSequentialIncreasedI;
	private PositionedMovementSymbol hingeMovementUpSequentialIncreasedII;
	private PositionedMovementSymbol hingeMovementUpSequentialIncreasedIII;
	private PositionedMovementSymbol hingeMovementUpSequentialMirrored;
	private PositionedMovementSymbol hingeMovementUpSequentialMirroredIncreasedI;
	private PositionedMovementSymbol hingeMovementUpSequentialMirroredIncreasedII;
	private PositionedMovementSymbol hingeMovementUpSequentialMirroredIncreasedIII;

	private PositionedMovementSymbol hingeMovementDownSequential;
	private PositionedMovementSymbol hingeMovementDownSequentialIncreasedI;
	private PositionedMovementSymbol hingeMovementDownSequentialIncreasedII;
	private PositionedMovementSymbol hingeMovementDownSequentialIncreasedIII;
	private PositionedMovementSymbol hingeMovementDownSequentialMirrored;
	private PositionedMovementSymbol hingeMovementDownSequentialMirroredIncreasedI;
	private PositionedMovementSymbol hingeMovementDownSequentialMirroredIncreasedII;
	private PositionedMovementSymbol hingeMovementDownSequentialMirroredIncreasedIII;

	private PositionedMovementSymbol hingeMovementUpDownAlternatingLarge;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingLargeIncreasedI;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingLargeIncreasedII;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingLargeIncreasedIII;

	private PositionedMovementSymbol hingeMovementUpDownAlternatingSmall;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingSmallIncreasedI;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingSmallIncreasedII;
	private PositionedMovementSymbol hingeMovementUpDownAlternatingSmallIncreasedIII;

	private PositionedMovementSymbol hingeMovementSideToSideScissors;
	private PositionedMovementSymbol hingeMovementSideToSideScissorsIncreasedI;
	private PositionedMovementSymbol hingeMovementSideToSideScissorsIncreasedII;
	private PositionedMovementSymbol hingeMovementSideToSideScissorsIncreasedIII;

	private PositionedMovementSymbol fingerContactMovementWallPlane;
	private PositionedMovementSymbol fingerContactMovementWallPlaneIncreasedI;
	private PositionedMovementSymbol fingerContactMovementWallPlaneIncreasedII;
	private PositionedMovementSymbol fingerContactMovementWallPlaneAlternatingArrows;
	private PositionedMovementSymbol fingerContactMovementWallPlaneAlternatingArrowsIncreased;

	private PositionedMovementSymbol fingerContactMovementFloorPlane;
	private PositionedMovementSymbol fingerContactMovementFloorPlaneIncreasedI;
	private PositionedMovementSymbol fingerContactMovementFloorPlaneIncreasedII;
	private PositionedMovementSymbol fingerContactMovementFloorPlaneAlternatingArrows;
	private PositionedMovementSymbol fingerContactMovementFloorPlaneAlternatingArrowsIncreased;

	private SymbolFactory symbolFactory;

	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		squeezeLargeSingle = new PositionedMovementSymbol(MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()));
		squeezeSmallSingle = new PositionedMovementSymbol(MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		squeezeLargeMultiple = new PositionedMovementSymbol(MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol()));
		squeezeSmallMultiple = new PositionedMovementSymbol(MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol()));
		squeezeSequential = new PositionedMovementSymbol(MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol().getBaseSymbol()));

		Symbol squeezeLargeMultipleIncreasedSymbol = symbolFactory.createSymbol("02-02-002-01-02-01");
		squeezeLargeMultipleIncreased = new PositionedMovementSymbol(squeezeLargeMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeLargeMultipleIncreasedSymbol.getBaseSymbol()));
		Symbol squeezeSmallMultipleIncreasedSymbol = symbolFactory.createSymbol("02-02-002-02-02-01");
		squeezeSmallMultipleIncreased = new PositionedMovementSymbol(squeezeSmallMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSmallMultipleIncreasedSymbol.getBaseSymbol()));
		Symbol squeezeSequentialIncreasedISymbol = symbolFactory.createSymbol("02-02-003-01-02-01");
		squeezeSequentialIncreasedI = new PositionedMovementSymbol(squeezeSequentialIncreasedISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialIncreasedISymbol.getBaseSymbol()));
		Symbol squeezeSequentialIncreasedIISymbol = symbolFactory.createSymbol("02-02-003-01-03-01");
		squeezeSequentialIncreasedII = new PositionedMovementSymbol(squeezeSequentialIncreasedIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialIncreasedIISymbol.getBaseSymbol()));
		Symbol squeezeSequentialIncreasedIIISymbol = symbolFactory.createSymbol("02-02-003-01-04-01");
		squeezeSequentialIncreasedIII = new PositionedMovementSymbol(squeezeSequentialIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialIncreasedIIISymbol.getBaseSymbol()));

		Symbol squeezeSequentialMirroredSymbol = symbolFactory.createSymbol("02-02-003-01-01-09");
		squeezeSequentialMirrored = new PositionedMovementSymbol(squeezeSequentialMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialMirroredSymbol.getBaseSymbol()));
		Symbol squeezeSequentialMirroredIncreasedISymbol = symbolFactory.createSymbol("02-02-003-01-02-09");
		squeezeSequentialMirroredIncreasedI = new PositionedMovementSymbol(squeezeSequentialMirroredIncreasedISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialMirroredIncreasedISymbol.getBaseSymbol()));
		Symbol squeezeSequentialMirroredIncreasedIISymbol = symbolFactory.createSymbol("02-02-003-01-03-09");
		squeezeSequentialMirroredIncreasedII = new PositionedMovementSymbol(squeezeSequentialMirroredIncreasedIISymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialMirroredIncreasedIISymbol.getBaseSymbol()));
		Symbol squeezeSequentialMirroredIncreasedIIISymbol = symbolFactory.createSymbol("02-02-003-01-04-09");
		squeezeSequentialMirroredIncreasedIII = new PositionedMovementSymbol(
				squeezeSequentialMirroredIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(squeezeSequentialMirroredIncreasedIIISymbol.getBaseSymbol()));

		flickLargeSingle = new PositionedMovementSymbol(MovementBaseSymbol.FLICK_LARGE_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FLICK_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()));
		flickSmallSingle = new PositionedMovementSymbol(MovementBaseSymbol.FLICK_SMALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FLICK_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		flickLargeMultiple = new PositionedMovementSymbol(MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FLICK_LARGE_MULTIPLE.getIswaSymbol().getBaseSymbol()));
		flickSmallMultiple = new PositionedMovementSymbol(MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FLICK_SMALL_MULTIPLE.getIswaSymbol().getBaseSymbol()));
		flickSequential = new PositionedMovementSymbol(MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol().getBaseSymbol()));

		Symbol flickLargeMultipleIncreasedSymbol = symbolFactory.createSymbol("02-02-005-01-02-01");
		flickLargeMultipleIncreased = new PositionedMovementSymbol(flickLargeMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickLargeMultipleIncreasedSymbol.getBaseSymbol()));
		Symbol flickSmallMultipleIncreasedSymbol = symbolFactory.createSymbol("02-02-005-02-02-01");
		flickSmallMultipleIncreased = new PositionedMovementSymbol(flickSmallMultipleIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSmallMultipleIncreasedSymbol.getBaseSymbol()));
		Symbol flickSequentialIncreasedISymbol = symbolFactory.createSymbol("02-02-006-01-02-01");
		flickSequentialIncreasedI = new PositionedMovementSymbol(flickSequentialIncreasedISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialIncreasedISymbol.getBaseSymbol()));
		Symbol flickSequentialIncreasedIISymbol = symbolFactory.createSymbol("02-02-006-01-03-01");
		flickSequentialIncreasedII = new PositionedMovementSymbol(flickSequentialIncreasedIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialIncreasedIISymbol.getBaseSymbol()));
		Symbol flickSequentialIncreasedIIISymbol = symbolFactory.createSymbol("02-02-006-01-04-01");
		flickSequentialIncreasedIII = new PositionedMovementSymbol(flickSequentialIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialIncreasedIIISymbol.getBaseSymbol()));

		Symbol flickSequentialMirroredSymbol = symbolFactory.createSymbol("02-02-006-01-01-09");
		flickSequentialMirrored = new PositionedMovementSymbol(flickSequentialMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialMirroredSymbol.getBaseSymbol()));
		Symbol flickSequentialMirroredIncreasedISymbol = symbolFactory.createSymbol("02-02-006-01-02-09");
		flickSequentialMirroredIncreasedI = new PositionedMovementSymbol(flickSequentialMirroredIncreasedISymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(flickSequentialMirroredIncreasedISymbol.getBaseSymbol()));
		Symbol flickSequentialMirroredIncreasedIISymbol = symbolFactory.createSymbol("02-02-006-01-03-09");
		flickSequentialMirroredIncreasedII = new PositionedMovementSymbol(flickSequentialMirroredIncreasedIISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialMirroredIncreasedIISymbol.getBaseSymbol()));
		Symbol flickSequentialMirroredIncreasedIIISymbol = symbolFactory.createSymbol("02-02-006-01-04-09");
		flickSequentialMirroredIncreasedIII = new PositionedMovementSymbol(flickSequentialMirroredIncreasedIIISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(flickSequentialMirroredIncreasedIIISymbol.getBaseSymbol()));

		squeezeFlickAlternating = new PositionedMovementSymbol(
				MovementBaseSymbol.SQUEEZE_FLICK_ALTERNATING.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SQUEEZE_FLICK_ALTERNATING.getIswaSymbol().getBaseSymbol()));

		hingeMovementUpDownLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_LARGE.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementUpDownLargeIncreasedISymbol = symbolFactory.createSymbol("02-02-008-01-02-01");
		hingeMovementUpDownLargeIncreasedI = new PositionedMovementSymbol(hingeMovementUpDownLargeIncreasedISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownLargeIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownLargeIncreasedIISymbol = symbolFactory.createSymbol("02-02-008-01-03-01");
		hingeMovementUpDownLargeIncreasedII = new PositionedMovementSymbol(hingeMovementUpDownLargeIncreasedIISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownLargeIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownLargeIncreasedIIISymbol = symbolFactory.createSymbol("02-02-008-01-04-01");
		hingeMovementUpDownLargeIncreasedIII = new PositionedMovementSymbol(hingeMovementUpDownLargeIncreasedIIISymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownLargeIncreasedIIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownLargeIncreasedIVSymbol = symbolFactory.createSymbol("02-02-008-01-05-01");
		hingeMovementUpDownLargeIncreasedIV = new PositionedMovementSymbol(hingeMovementUpDownLargeIncreasedIVSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownLargeIncreasedIVSymbol.getBaseSymbol()));

		hingeMovementUpDownSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_SMALL.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementUpDownSmallIncreasedISymbol = symbolFactory.createSymbol("02-02-008-02-02-01");
		hingeMovementUpDownSmallIncreasedI = new PositionedMovementSymbol(hingeMovementUpDownSmallIncreasedISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownSmallIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownSmallIncreasedIISymbol = symbolFactory.createSymbol("02-02-008-02-03-01");
		hingeMovementUpDownSmallIncreasedII = new PositionedMovementSymbol(hingeMovementUpDownSmallIncreasedIISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownSmallIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownSmallIncreasedIIISymbol = symbolFactory.createSymbol("02-02-008-02-04-01");
		hingeMovementUpDownSmallIncreasedIII = new PositionedMovementSymbol(hingeMovementUpDownSmallIncreasedIIISymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownSmallIncreasedIIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownSmallIncreasedIVSymbol = symbolFactory.createSymbol("02-02-008-02-05-01");
		hingeMovementUpDownSmallIncreasedIV = new PositionedMovementSymbol(hingeMovementUpDownSmallIncreasedIVSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpDownSmallIncreasedIVSymbol.getBaseSymbol()));

		hingeMovementUpSequential = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_UP_SEQUENTIAL.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementUpSequentialIncreasedISymbol = symbolFactory.createSymbol("02-02-009-01-02-01");
		hingeMovementUpSequentialIncreasedI = new PositionedMovementSymbol(hingeMovementUpSequentialIncreasedISymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpSequentialIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpSequentialIncreasedIISymbol = symbolFactory.createSymbol("02-02-009-01-03-01");
		hingeMovementUpSequentialIncreasedII = new PositionedMovementSymbol(hingeMovementUpSequentialIncreasedIISymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpSequentialIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpSequentialIncreasedIIISymbol = symbolFactory.createSymbol("02-02-009-01-04-01");
		hingeMovementUpSequentialIncreasedIII = new PositionedMovementSymbol(
				hingeMovementUpSequentialIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpSequentialIncreasedIIISymbol.getBaseSymbol()));

		Symbol hingeMovementUpSequentialMirroredSymbol = symbolFactory.createSymbol("02-02-009-01-01-09");
		hingeMovementUpSequentialMirrored = new PositionedMovementSymbol(hingeMovementUpSequentialMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(hingeMovementUpSequentialMirroredSymbol.getBaseSymbol()));
		Symbol hingeMovementUpSequentialMirroresIncreasedISymbol = symbolFactory.createSymbol("02-02-009-01-02-09");
		hingeMovementUpSequentialMirroredIncreasedI = new PositionedMovementSymbol(
				hingeMovementUpSequentialMirroresIncreasedISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(hingeMovementUpSequentialMirroresIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpSequentialMirroredIncreasedIISymbol = symbolFactory.createSymbol("02-02-009-01-03-09");
		hingeMovementUpSequentialMirroredIncreasedII = new PositionedMovementSymbol(
				hingeMovementUpSequentialMirroredIncreasedIISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpSequentialMirroredIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpSequentialMirroredIncreasedIIISymbol = symbolFactory.createSymbol("02-02-009-01-04-09");
		hingeMovementUpSequentialMirroredIncreasedIII = new PositionedMovementSymbol(
				hingeMovementUpSequentialMirroredIncreasedIIISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpSequentialMirroredIncreasedIIISymbol.getBaseSymbol()));

		hingeMovementDownSequential = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_DOWN_SEQUENTIAL.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementDownSequentialIncreasedISymbol = symbolFactory.createSymbol("02-02-009-02-02-01");
		hingeMovementDownSequentialIncreasedI = new PositionedMovementSymbol(
				hingeMovementDownSequentialIncreasedISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementDownSequentialIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementDownSequentialIncreasedIISymbol = symbolFactory.createSymbol("02-02-009-02-03-01");
		hingeMovementDownSequentialIncreasedII = new PositionedMovementSymbol(
				hingeMovementDownSequentialIncreasedIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementDownSequentialIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementDownSequentialIncreasedIIISymbol = symbolFactory.createSymbol("02-02-009-02-04-01");
		hingeMovementDownSequentialIncreasedIII = new PositionedMovementSymbol(
				hingeMovementDownSequentialIncreasedIIISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(hingeMovementDownSequentialIncreasedIIISymbol.getBaseSymbol()));

		Symbol hingeMovementDownSequentialMirroredSymbol = symbolFactory.createSymbol("02-02-009-02-01-09");
		hingeMovementDownSequentialMirrored = new PositionedMovementSymbol(hingeMovementDownSequentialMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(hingeMovementDownSequentialMirroredSymbol.getBaseSymbol()));
		Symbol hingeMovementDownSequentialMirroresIncreasedISymbol = symbolFactory.createSymbol("02-02-009-02-02-09");
		hingeMovementDownSequentialMirroredIncreasedI = new PositionedMovementSymbol(
				hingeMovementDownSequentialMirroresIncreasedISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementDownSequentialMirroresIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementDownSequentialMirroredIncreasedIISymbol = symbolFactory.createSymbol("02-02-009-02-03-09");
		hingeMovementDownSequentialMirroredIncreasedII = new PositionedMovementSymbol(
				hingeMovementDownSequentialMirroredIncreasedIISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementDownSequentialMirroredIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementDownSequentialMirroredIncreasedIIISymbol = symbolFactory.createSymbol("02-02-009-02-04-09");
		hingeMovementDownSequentialMirroredIncreasedIII = new PositionedMovementSymbol(
				hingeMovementDownSequentialMirroredIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementDownSequentialMirroredIncreasedIIISymbol.getBaseSymbol()));

		hingeMovementUpDownAlternatingLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_LARGE.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementUpDownAlternatingLargeIncreasedISymbol = symbolFactory.createSymbol("02-02-010-01-02-01");
		hingeMovementUpDownAlternatingLargeIncreasedI = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingLargeIncreasedISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingLargeIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownAlternatingLargeIncreasedIISymbol = symbolFactory.createSymbol("02-02-010-01-03-01");
		hingeMovementUpDownAlternatingLargeIncreasedII = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingLargeIncreasedIISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingLargeIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownAlternatingLargeIncreasedIIISymbol = symbolFactory.createSymbol("02-02-010-01-04-01");
		hingeMovementUpDownAlternatingLargeIncreasedIII = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingLargeIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingLargeIncreasedIIISymbol.getBaseSymbol()));

		hingeMovementUpDownAlternatingSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_UP_DOWN_ALTERNATING_SMALL.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementUpDownAlternatingSmallIncreasedISymbol = symbolFactory.createSymbol("02-02-010-02-02-01");
		hingeMovementUpDownAlternatingSmallIncreasedI = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingSmallIncreasedISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingSmallIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownAlternatingSmallIncreasedIISymbol = symbolFactory.createSymbol("02-02-010-02-03-01");
		hingeMovementUpDownAlternatingSmallIncreasedII = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingSmallIncreasedIISymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingSmallIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementUpDownAlternatingSmallIncreasedIIISymbol = symbolFactory.createSymbol("02-02-010-02-04-01");
		hingeMovementUpDownAlternatingSmallIncreasedIII = new PositionedMovementSymbol(
				hingeMovementUpDownAlternatingSmallIncreasedIIISymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						hingeMovementUpDownAlternatingSmallIncreasedIIISymbol.getBaseSymbol()));

		hingeMovementSideToSideScissors = new PositionedMovementSymbol(
				MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HINGE_MOVEMENT_SIDE_TO_SIDE_SCISSORS.getIswaSymbol().getBaseSymbol()));

		Symbol hingeMovementSideToSideScissorsIncreasedISymbol = symbolFactory.createSymbol("02-02-011-01-02-01");
		hingeMovementSideToSideScissorsIncreasedI = new PositionedMovementSymbol(
				hingeMovementSideToSideScissorsIncreasedISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(hingeMovementSideToSideScissorsIncreasedISymbol.getBaseSymbol()));
		Symbol hingeMovementSideToSideScissorsIncreasedIISymbol = symbolFactory.createSymbol("02-02-011-01-03-01");
		hingeMovementSideToSideScissorsIncreasedII = new PositionedMovementSymbol(
				hingeMovementSideToSideScissorsIncreasedIISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(hingeMovementSideToSideScissorsIncreasedIISymbol.getBaseSymbol()));
		Symbol hingeMovementSideToSideScissorsIncreasedIIISymbol = symbolFactory.createSymbol("02-02-011-01-04-01");
		hingeMovementSideToSideScissorsIncreasedIII = new PositionedMovementSymbol(
				hingeMovementSideToSideScissorsIncreasedIIISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(hingeMovementSideToSideScissorsIncreasedIIISymbol.getBaseSymbol()));

		fingerContactMovementWallPlane = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_WALL_PLANE.getIswaSymbol().getBaseSymbol()));

		Symbol fingerContactMovementWallPlaneIncreasedISymbol = symbolFactory.createSymbol("02-02-012-01-02-01");
		fingerContactMovementWallPlaneIncreasedI = new PositionedMovementSymbol(
				fingerContactMovementWallPlaneIncreasedISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerContactMovementWallPlaneIncreasedISymbol.getBaseSymbol()));
		Symbol fingerContactMovementWallPlaneIncreasedIISymbol = symbolFactory.createSymbol("02-02-012-01-04-01");
		fingerContactMovementWallPlaneIncreasedII = new PositionedMovementSymbol(
				fingerContactMovementWallPlaneIncreasedIISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerContactMovementWallPlaneIncreasedIISymbol.getBaseSymbol()));
		Symbol fingerConatctMovementWallPlaneAlternatingArrowsSymbol = symbolFactory.createSymbol("02-02-012-01-03-01");
		fingerContactMovementWallPlaneAlternatingArrows = new PositionedMovementSymbol(
				fingerConatctMovementWallPlaneAlternatingArrowsSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						fingerConatctMovementWallPlaneAlternatingArrowsSymbol.getBaseSymbol()));
		Symbol fingerConatctMovementWallPlaneAlternatingArrowsIncreasedSymbol = symbolFactory
				.createSymbol("02-02-012-01-05-01");
		fingerContactMovementWallPlaneAlternatingArrowsIncreased = new PositionedMovementSymbol(
				fingerConatctMovementWallPlaneAlternatingArrowsIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						fingerConatctMovementWallPlaneAlternatingArrowsIncreasedSymbol.getBaseSymbol()));

		fingerContactMovementFloorPlane = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CONTACT_MOVEMENT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()));

		Symbol fingerContactMovementFloorPlaneIncreasedISymbol = symbolFactory.createSymbol("02-02-013-01-02-01");
		fingerContactMovementFloorPlaneIncreasedI = new PositionedMovementSymbol(
				fingerContactMovementFloorPlaneIncreasedISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerContactMovementFloorPlaneIncreasedISymbol.getBaseSymbol()));
		Symbol fingerContactMovementFloorPlaneIncreasedIISymbol = symbolFactory.createSymbol("02-02-013-01-04-01");
		fingerContactMovementFloorPlaneIncreasedII = new PositionedMovementSymbol(
				fingerContactMovementFloorPlaneIncreasedIISymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerContactMovementFloorPlaneIncreasedIISymbol.getBaseSymbol()));
		Symbol fingerConatctMovementFloorPlaneAlternatingArrowsSymbol = symbolFactory
				.createSymbol("02-02-013-01-03-01");
		fingerContactMovementFloorPlaneAlternatingArrows = new PositionedMovementSymbol(
				fingerConatctMovementFloorPlaneAlternatingArrowsSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						fingerConatctMovementFloorPlaneAlternatingArrowsSymbol.getBaseSymbol()));
		Symbol fingerConatctMovementFloorPlaneAlternatingArrowsIncreasedSymbol = symbolFactory
				.createSymbol("02-02-013-01-05-01");
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased = new PositionedMovementSymbol(
				fingerConatctMovementFloorPlaneAlternatingArrowsIncreasedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						fingerConatctMovementFloorPlaneAlternatingArrowsIncreasedSymbol.getBaseSymbol()));

	}

	/**
	 * Part of the test canIncrease for PositionedMovementSymbols
	 */
	public void testCanIncrease() {
		assertTrue(squeezeLargeSingle.canIncrease());
		assertTrue(squeezeLargeMultiple.canIncrease());

		assertFalse(squeezeLargeMultipleIncreased.canIncrease());

		assertTrue(squeezeSmallSingle.canIncrease());
		assertTrue(squeezeSmallMultiple.canIncrease());

		assertFalse(squeezeSmallMultipleIncreased.canIncrease());

		assertTrue(squeezeSequential.canIncrease());
		assertTrue(squeezeSequentialIncreasedI.canIncrease());
		assertTrue(squeezeSequentialIncreasedII.canIncrease());
		assertTrue(squeezeSequentialMirrored.canIncrease());
		assertTrue(squeezeSequentialMirroredIncreasedI.canIncrease());
		assertTrue(squeezeSequentialMirroredIncreasedII.canIncrease());

		assertFalse(squeezeSequentialIncreasedIII.canIncrease());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canIncrease());

		assertTrue(flickLargeSingle.canIncrease());
		assertTrue(flickLargeMultiple.canIncrease());

		assertFalse(flickLargeMultipleIncreased.canIncrease());

		assertTrue(flickSmallSingle.canIncrease());
		assertTrue(flickSmallMultiple.canIncrease());

		assertFalse(flickSmallMultipleIncreased.canIncrease());

		assertTrue(flickSequential.canIncrease());
		assertTrue(flickSequentialIncreasedI.canIncrease());
		assertTrue(flickSequentialIncreasedII.canIncrease());
		assertTrue(flickSequentialMirrored.canIncrease());
		assertTrue(flickSequentialMirroredIncreasedI.canIncrease());
		assertTrue(flickSequentialMirroredIncreasedII.canIncrease());

		assertFalse(flickSequentialIncreasedIII.canIncrease());
		assertFalse(flickSequentialMirroredIncreasedIII.canIncrease());

		assertFalse(squeezeFlickAlternating.canIncrease());

		assertTrue(hingeMovementUpDownLarge.canIncrease());
		assertTrue(hingeMovementUpDownLargeIncreasedI.canIncrease());
		assertTrue(hingeMovementUpDownLargeIncreasedII.canIncrease());
		assertTrue(hingeMovementUpDownLargeIncreasedIII.canIncrease());

		assertFalse(hingeMovementUpDownLargeIncreasedIV.canIncrease());

		assertTrue(hingeMovementUpDownSmall.canIncrease());
		assertTrue(hingeMovementUpDownSmallIncreasedI.canIncrease());
		assertTrue(hingeMovementUpDownSmallIncreasedII.canIncrease());
		assertTrue(hingeMovementUpDownSmallIncreasedIII.canIncrease());

		assertFalse(hingeMovementUpDownSmallIncreasedIV.canIncrease());

		assertTrue(hingeMovementUpSequential.canIncrease());
		assertTrue(hingeMovementUpSequentialIncreasedI.canIncrease());
		assertTrue(hingeMovementUpSequentialIncreasedII.canIncrease());
		assertTrue(hingeMovementUpSequentialMirrored.canIncrease());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedI.canIncrease());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedII.canIncrease());

		assertFalse(hingeMovementUpSequentialIncreasedIII.canIncrease());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canIncrease());

		assertTrue(hingeMovementDownSequential.canIncrease());
		assertTrue(hingeMovementDownSequentialIncreasedI.canIncrease());
		assertTrue(hingeMovementDownSequentialIncreasedII.canIncrease());
		assertTrue(hingeMovementDownSequentialMirrored.canIncrease());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedI.canIncrease());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedII.canIncrease());

		assertFalse(hingeMovementDownSequentialIncreasedIII.canIncrease());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canIncrease());

		assertTrue(hingeMovementUpDownAlternatingLarge.canIncrease());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedI.canIncrease());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedII.canIncrease());

		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canIncrease());

		assertTrue(hingeMovementUpDownAlternatingSmall.canIncrease());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedI.canIncrease());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedII.canIncrease());

		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canIncrease());

		assertTrue(hingeMovementSideToSideScissors.canIncrease());
		assertTrue(hingeMovementSideToSideScissorsIncreasedI.canIncrease());
		assertTrue(hingeMovementSideToSideScissorsIncreasedII.canIncrease());

		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canIncrease());

		assertTrue(fingerContactMovementWallPlane.canIncrease());
		assertTrue(fingerContactMovementWallPlaneIncreasedI.canIncrease());

		assertFalse(fingerContactMovementWallPlaneIncreasedII.canIncrease());

		assertTrue(fingerContactMovementWallPlaneAlternatingArrows.canIncrease());

		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canIncrease());

		assertTrue(fingerContactMovementFloorPlane.canIncrease());
		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canIncrease());

		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canIncrease());

		assertTrue(fingerContactMovementFloorPlaneAlternatingArrows.canIncrease());

		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canIncrease());

	}

	@Override
	public void testIncrease() {
		squeezeLargeSingle.increase();
		assertEquals(squeezeLargeMultiple.getSymbol(), squeezeLargeSingle.getSymbol());

		squeezeLargeMultiple.increase();
		assertEquals(squeezeLargeMultipleIncreased.getSymbol(), squeezeLargeMultiple.getSymbol());

		squeezeSmallSingle.increase();
		assertEquals(squeezeSmallMultiple.getSymbol(), squeezeSmallSingle.getSymbol());

		squeezeSmallMultiple.increase();
		assertEquals(squeezeSmallMultipleIncreased.getSymbol(), squeezeSmallMultiple.getSymbol());

		squeezeSequential.increase();
		assertEquals(squeezeSequentialIncreasedI.getSymbol(), squeezeSequential.getSymbol());
		squeezeSequentialIncreasedI.increase();
		assertEquals(squeezeSequentialIncreasedII.getSymbol(), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedII.increase();
		assertEquals(squeezeSequentialIncreasedIII.getSymbol(), squeezeSequentialIncreasedII.getSymbol());

		squeezeSequentialMirrored.increase();
		assertEquals(squeezeSequentialMirroredIncreasedI.getSymbol(), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirroredIncreasedI.increase();
		assertEquals(squeezeSequentialMirroredIncreasedII.getSymbol(), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedII.increase();
		assertEquals(squeezeSequentialMirroredIncreasedIII.getSymbol(),
				squeezeSequentialMirroredIncreasedII.getSymbol());

		flickLargeSingle.increase();
		assertEquals(flickLargeMultiple.getSymbol(), flickLargeSingle.getSymbol());

		flickLargeMultiple.increase();
		assertEquals(flickLargeMultipleIncreased.getSymbol(), flickLargeMultiple.getSymbol());

		flickSmallSingle.increase();
		assertEquals(flickSmallMultiple.getSymbol(), flickSmallSingle.getSymbol());

		flickSmallMultiple.increase();
		assertEquals(flickSmallMultipleIncreased.getSymbol(), flickSmallMultiple.getSymbol());

		flickSequential.increase();
		assertEquals(flickSequentialIncreasedI.getSymbol(), flickSequential.getSymbol());
		flickSequentialIncreasedI.increase();
		assertEquals(flickSequentialIncreasedII.getSymbol(), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedII.increase();
		assertEquals(flickSequentialIncreasedIII.getSymbol(), flickSequentialIncreasedII.getSymbol());

		flickSequentialMirrored.increase();
		assertEquals(flickSequentialMirroredIncreasedI.getSymbol(), flickSequentialMirrored.getSymbol());
		flickSequentialMirroredIncreasedI.increase();
		assertEquals(flickSequentialMirroredIncreasedII.getSymbol(), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedII.increase();
		assertEquals(flickSequentialMirroredIncreasedIII.getSymbol(), flickSequentialMirroredIncreasedII.getSymbol());

		hingeMovementUpDownLarge.increase();
		assertEquals(hingeMovementUpDownLargeIncreasedI.getSymbol(), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLargeIncreasedI.increase();
		assertEquals(hingeMovementUpDownLargeIncreasedII.getSymbol(), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedII.increase();
		assertEquals(hingeMovementUpDownLargeIncreasedIII.getSymbol(), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.increase();
		assertEquals(hingeMovementUpDownLargeIncreasedIV.getSymbol(), hingeMovementUpDownLargeIncreasedIII.getSymbol());

		hingeMovementUpDownSmall.increase();
		assertEquals(hingeMovementUpDownSmallIncreasedI.getSymbol(), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmallIncreasedI.increase();
		assertEquals(hingeMovementUpDownSmallIncreasedII.getSymbol(), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedII.increase();
		assertEquals(hingeMovementUpDownSmallIncreasedIII.getSymbol(), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.increase();
		assertEquals(hingeMovementUpDownSmallIncreasedIV.getSymbol(), hingeMovementUpDownSmallIncreasedIII.getSymbol());

		hingeMovementUpSequential.increase();
		assertEquals(hingeMovementUpSequentialIncreasedI.getSymbol(), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequentialIncreasedI.increase();
		assertEquals(hingeMovementUpSequentialIncreasedII.getSymbol(), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedII.increase();
		assertEquals(hingeMovementUpSequentialIncreasedIII.getSymbol(),
				hingeMovementUpSequentialIncreasedII.getSymbol());

		hingeMovementUpSequentialMirrored.increase();
		assertEquals(hingeMovementUpSequentialMirroredIncreasedI.getSymbol(),
				hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.increase();
		assertEquals(hingeMovementUpSequentialMirroredIncreasedII.getSymbol(),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.increase();
		assertEquals(hingeMovementUpSequentialMirroredIncreasedIII.getSymbol(),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());

		hingeMovementDownSequential.increase();
		assertEquals(hingeMovementDownSequentialIncreasedI.getSymbol(), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequentialIncreasedI.increase();
		assertEquals(hingeMovementDownSequentialIncreasedII.getSymbol(),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedII.increase();
		assertEquals(hingeMovementDownSequentialIncreasedIII.getSymbol(),
				hingeMovementDownSequentialIncreasedII.getSymbol());

		hingeMovementDownSequentialMirrored.increase();
		assertEquals(hingeMovementDownSequentialMirroredIncreasedI.getSymbol(),
				hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.increase();
		assertEquals(hingeMovementDownSequentialMirroredIncreasedII.getSymbol(),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.increase();
		assertEquals(hingeMovementDownSequentialMirroredIncreasedIII.getSymbol(),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingLarge.increase();
		assertEquals(hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol(),
				hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.increase();
		assertEquals(hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol(),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.increase();
		assertEquals(hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol(),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingSmall.increase();
		assertEquals(hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol(),
				hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.increase();
		assertEquals(hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol(),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.increase();
		assertEquals(hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol(),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());

		hingeMovementSideToSideScissors.increase();
		assertEquals(hingeMovementSideToSideScissorsIncreasedI.getSymbol(),
				hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.increase();
		assertEquals(hingeMovementSideToSideScissorsIncreasedII.getSymbol(),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.increase();
		assertEquals(hingeMovementSideToSideScissorsIncreasedIII.getSymbol(),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());

		fingerContactMovementWallPlane.increase();
		assertEquals(fingerContactMovementWallPlaneIncreasedI.getSymbol(), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.increase();
		assertEquals(fingerContactMovementWallPlaneIncreasedII.getSymbol(),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrows.increase();
		assertEquals(fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol(),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());

		fingerContactMovementFloorPlane.increase();
		assertEquals(fingerContactMovementFloorPlaneIncreasedI.getSymbol(),
				fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.increase();
		assertEquals(fingerContactMovementFloorPlaneIncreasedII.getSymbol(),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrows.increase();
		assertEquals(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol(),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());

	}

	@Override
	public void testCanDecrease() {
		assertFalse(squeezeLargeSingle.canDecrease());

		assertTrue(squeezeLargeMultiple.canDecrease());
		assertTrue(squeezeLargeMultipleIncreased.canDecrease());

		assertFalse(squeezeSmallSingle.canDecrease());

		assertTrue(squeezeSmallMultiple.canDecrease());
		assertTrue(squeezeSmallMultipleIncreased.canDecrease());

		assertFalse(squeezeSequential.canDecrease());
		assertFalse(squeezeSequentialMirrored.canDecrease());

		assertTrue(squeezeSequentialIncreasedI.canDecrease());
		assertTrue(squeezeSequentialIncreasedII.canDecrease());
		assertTrue(squeezeSequentialIncreasedIII.canDecrease());
		assertTrue(squeezeSequentialMirroredIncreasedI.canDecrease());
		assertTrue(squeezeSequentialMirroredIncreasedII.canDecrease());
		assertTrue(squeezeSequentialMirroredIncreasedIII.canDecrease());

		assertFalse(flickLargeSingle.canDecrease());

		assertTrue(flickLargeMultiple.canDecrease());
		assertTrue(flickLargeMultipleIncreased.canDecrease());

		assertFalse(flickSmallSingle.canDecrease());

		assertTrue(flickSmallMultiple.canDecrease());
		assertTrue(flickSmallMultipleIncreased.canDecrease());

		assertFalse(flickSequential.canDecrease());
		assertFalse(flickSequentialMirrored.canDecrease());

		assertTrue(flickSequentialIncreasedI.canDecrease());
		assertTrue(flickSequentialIncreasedII.canDecrease());
		assertTrue(flickSequentialIncreasedIII.canDecrease());
		assertTrue(flickSequentialMirroredIncreasedI.canDecrease());
		assertTrue(flickSequentialMirroredIncreasedII.canDecrease());
		assertTrue(flickSequentialMirroredIncreasedIII.canDecrease());

		assertFalse(hingeMovementUpDownLarge.canDecrease());

		assertTrue(hingeMovementUpDownLargeIncreasedI.canDecrease());
		assertTrue(hingeMovementUpDownLargeIncreasedII.canDecrease());
		assertTrue(hingeMovementUpDownLargeIncreasedIII.canDecrease());
		assertTrue(hingeMovementUpDownLargeIncreasedIV.canDecrease());

		assertFalse(hingeMovementUpDownSmall.canDecrease());

		assertTrue(hingeMovementUpDownSmallIncreasedI.canDecrease());
		assertTrue(hingeMovementUpDownSmallIncreasedII.canDecrease());
		assertTrue(hingeMovementUpDownSmallIncreasedIII.canDecrease());
		assertTrue(hingeMovementUpDownSmallIncreasedIV.canDecrease());

		assertFalse(hingeMovementUpSequential.canDecrease());
		assertFalse(hingeMovementUpSequentialMirrored.canDecrease());

		assertTrue(hingeMovementUpSequentialIncreasedI.canDecrease());
		assertTrue(hingeMovementUpSequentialIncreasedII.canDecrease());
		assertTrue(hingeMovementUpSequentialIncreasedIII.canDecrease());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedI.canDecrease());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedII.canDecrease());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedIII.canDecrease());

		assertFalse(hingeMovementDownSequential.canDecrease());
		assertFalse(hingeMovementDownSequentialMirrored.canDecrease());

		assertTrue(hingeMovementDownSequentialIncreasedI.canDecrease());
		assertTrue(hingeMovementDownSequentialIncreasedII.canDecrease());
		assertTrue(hingeMovementDownSequentialIncreasedIII.canDecrease());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedI.canDecrease());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedII.canDecrease());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedIII.canDecrease());

		assertFalse(hingeMovementUpDownAlternatingLarge.canDecrease());

		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedI.canDecrease());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedII.canDecrease());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedIII.canDecrease());

		assertFalse(hingeMovementUpDownAlternatingSmall.canDecrease());

		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedI.canDecrease());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedII.canDecrease());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedIII.canDecrease());

		assertFalse(hingeMovementSideToSideScissors.canDecrease());

		assertTrue(hingeMovementSideToSideScissorsIncreasedI.canDecrease());
		assertTrue(hingeMovementSideToSideScissorsIncreasedII.canDecrease());
		assertTrue(hingeMovementSideToSideScissorsIncreasedIII.canDecrease());

		assertFalse(fingerContactMovementWallPlane.canDecrease());

		assertTrue(fingerContactMovementWallPlaneIncreasedI.canDecrease());
		assertTrue(fingerContactMovementWallPlaneIncreasedII.canDecrease());

		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canDecrease());

		assertTrue(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canDecrease());

		assertFalse(fingerContactMovementFloorPlane.canDecrease());

		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canDecrease());
		assertTrue(fingerContactMovementFloorPlaneIncreasedII.canDecrease());

		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canDecrease());

		assertTrue(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canDecrease());

	}

	@Override
	public void testDecrease() {
		squeezeLargeMultipleIncreased.decrease();
		assertEquals(squeezeLargeMultiple.getSymbol(), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultiple.decrease();
		assertEquals(squeezeLargeSingle.getSymbol(), squeezeLargeMultiple.getSymbol());

		squeezeSmallMultipleIncreased.decrease();
		assertEquals(squeezeSmallMultiple.getSymbol(), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultiple.decrease();
		assertEquals(squeezeSmallSingle.getSymbol(), squeezeSmallMultiple.getSymbol());

		squeezeSequentialIncreasedIII.decrease();
		assertEquals(squeezeSequentialIncreasedII.getSymbol(), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedII.decrease();
		assertEquals(squeezeSequentialIncreasedI.getSymbol(), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedI.decrease();
		assertEquals(squeezeSequential.getSymbol(), squeezeSequentialIncreasedI.getSymbol());

		squeezeSequentialMirroredIncreasedIII.decrease();
		assertEquals(squeezeSequentialMirroredIncreasedII.getSymbol(),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedII.decrease();
		assertEquals(squeezeSequentialMirroredIncreasedI.getSymbol(), squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedI.decrease();
		assertEquals(squeezeSequentialMirrored.getSymbol(), squeezeSequentialMirroredIncreasedI.getSymbol());

		flickLargeMultipleIncreased.decrease();
		assertEquals(flickLargeMultiple.getSymbol(), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultiple.decrease();
		assertEquals(flickLargeSingle.getSymbol(), flickLargeMultiple.getSymbol());

		flickSmallMultipleIncreased.decrease();
		assertEquals(flickSmallMultiple.getSymbol(), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultiple.decrease();
		assertEquals(flickSmallSingle.getSymbol(), flickSmallMultiple.getSymbol());

		flickSequentialIncreasedIII.decrease();
		assertEquals(flickSequentialIncreasedII.getSymbol(), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedII.decrease();
		assertEquals(flickSequentialIncreasedI.getSymbol(), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedI.decrease();
		assertEquals(flickSequential.getSymbol(), flickSequentialIncreasedI.getSymbol());

		flickSequentialMirroredIncreasedIII.decrease();
		assertEquals(flickSequentialMirroredIncreasedII.getSymbol(), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedII.decrease();
		assertEquals(flickSequentialMirroredIncreasedI.getSymbol(), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedI.decrease();
		assertEquals(flickSequentialMirrored.getSymbol(), flickSequentialMirroredIncreasedI.getSymbol());

		hingeMovementUpDownLargeIncreasedIV.decrease();
		assertEquals(hingeMovementUpDownLargeIncreasedIII.getSymbol(), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.decrease();
		assertEquals(hingeMovementUpDownLargeIncreasedII.getSymbol(), hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.decrease();
		assertEquals(hingeMovementUpDownLargeIncreasedI.getSymbol(), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedI.decrease();
		assertEquals(hingeMovementUpDownLarge.getSymbol(), hingeMovementUpDownLargeIncreasedI.getSymbol());

		hingeMovementUpDownSmallIncreasedIV.decrease();
		assertEquals(hingeMovementUpDownSmallIncreasedIII.getSymbol(), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.decrease();
		assertEquals(hingeMovementUpDownSmallIncreasedII.getSymbol(), hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.decrease();
		assertEquals(hingeMovementUpDownSmallIncreasedI.getSymbol(), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedI.decrease();
		assertEquals(hingeMovementUpDownSmall.getSymbol(), hingeMovementUpDownSmallIncreasedI.getSymbol());

		hingeMovementUpSequentialIncreasedIII.decrease();
		assertEquals(hingeMovementUpSequentialIncreasedII.getSymbol(),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedII.decrease();
		assertEquals(hingeMovementUpSequentialIncreasedI.getSymbol(), hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedI.decrease();
		assertEquals(hingeMovementUpSequential.getSymbol(), hingeMovementUpSequentialIncreasedI.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedIII.decrease();
		assertEquals(hingeMovementUpSequentialMirroredIncreasedII.getSymbol(),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.decrease();
		assertEquals(hingeMovementUpSequentialMirroredIncreasedI.getSymbol(),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.decrease();
		assertEquals(hingeMovementUpSequentialMirrored.getSymbol(),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());

		hingeMovementDownSequentialIncreasedIII.decrease();
		assertEquals(hingeMovementDownSequentialIncreasedII.getSymbol(),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedII.decrease();
		assertEquals(hingeMovementDownSequentialIncreasedI.getSymbol(),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedI.decrease();
		assertEquals(hingeMovementDownSequential.getSymbol(), hingeMovementDownSequentialIncreasedI.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedIII.decrease();
		assertEquals(hingeMovementDownSequentialMirroredIncreasedII.getSymbol(),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.decrease();
		assertEquals(hingeMovementDownSequentialMirroredIncreasedI.getSymbol(),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.decrease();
		assertEquals(hingeMovementDownSequentialMirrored.getSymbol(),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedIII.decrease();
		assertEquals(hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol(),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.decrease();
		assertEquals(hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol(),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.decrease();
		assertEquals(hingeMovementUpDownAlternatingLarge.getSymbol(),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedIII.decrease();
		assertEquals(hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol(),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.decrease();
		assertEquals(hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol(),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.decrease();
		assertEquals(hingeMovementUpDownAlternatingSmall.getSymbol(),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());

		hingeMovementSideToSideScissorsIncreasedIII.decrease();
		assertEquals(hingeMovementSideToSideScissorsIncreasedII.getSymbol(),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.decrease();
		assertEquals(hingeMovementSideToSideScissorsIncreasedI.getSymbol(),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.decrease();
		assertEquals(hingeMovementSideToSideScissors.getSymbol(),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());

		fingerContactMovementWallPlaneIncreasedII.decrease();
		assertEquals(fingerContactMovementWallPlaneIncreasedI.getSymbol(),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.decrease();
		assertEquals(fingerContactMovementWallPlane.getSymbol(), fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrowsIncreased.decrease();
		assertEquals(fingerContactMovementWallPlaneAlternatingArrows.getSymbol(),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());

		fingerContactMovementFloorPlaneIncreasedII.decrease();
		assertEquals(fingerContactMovementFloorPlaneIncreasedI.getSymbol(),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.decrease();
		assertEquals(fingerContactMovementFloorPlane.getSymbol(),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.decrease();
		assertEquals(fingerContactMovementFloorPlaneAlternatingArrows.getSymbol(),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertFalse(squeezeLargeSingle.canRotate());

		assertFalse(squeezeSmallSingle.canRotate());

		assertTrue(squeezeLargeMultiple.canRotate());
		assertTrue(squeezeLargeMultipleIncreased.canRotate());

		assertTrue(squeezeSmallMultiple.canRotate());
		assertTrue(squeezeSmallMultipleIncreased.canRotate());

		assertTrue(squeezeSequential.canRotate());
		assertTrue(squeezeSequentialIncreasedI.canRotate());
		assertTrue(squeezeSequentialIncreasedII.canRotate());
		assertTrue(squeezeSequentialIncreasedIII.canRotate());
		assertTrue(squeezeSequentialMirrored.canRotate());
		assertTrue(squeezeSequentialMirroredIncreasedI.canRotate());
		assertTrue(squeezeSequentialMirroredIncreasedII.canRotate());
		assertTrue(squeezeSequentialMirroredIncreasedIII.canRotate());

		assertFalse(flickLargeSingle.canRotate());

		assertFalse(flickSmallSingle.canRotate());

		assertTrue(flickLargeMultiple.canRotate());
		assertTrue(flickLargeMultipleIncreased.canRotate());

		assertTrue(flickSmallMultiple.canRotate());
		assertTrue(flickSmallMultipleIncreased.canRotate());

		assertTrue(flickSequential.canRotate());
		assertTrue(flickSequentialIncreasedI.canRotate());
		assertTrue(flickSequentialIncreasedII.canRotate());
		assertTrue(flickSequentialIncreasedIII.canRotate());
		assertTrue(flickSequentialMirrored.canRotate());
		assertTrue(flickSequentialMirroredIncreasedI.canRotate());
		assertTrue(flickSequentialMirroredIncreasedII.canRotate());
		assertTrue(flickSequentialMirroredIncreasedIII.canRotate());

		assertTrue(squeezeFlickAlternating.canRotate());

		assertTrue(hingeMovementUpDownLarge.canRotate());
		assertTrue(hingeMovementUpDownLargeIncreasedI.canRotate());
		assertTrue(hingeMovementUpDownLargeIncreasedII.canRotate());
		assertTrue(hingeMovementUpDownLargeIncreasedIII.canRotate());
		assertTrue(hingeMovementUpDownLargeIncreasedIV.canRotate());

		assertTrue(hingeMovementUpDownSmall.canRotate());
		assertTrue(hingeMovementUpDownSmallIncreasedI.canRotate());
		assertTrue(hingeMovementUpDownSmallIncreasedII.canRotate());
		assertTrue(hingeMovementUpDownSmallIncreasedIII.canRotate());
		assertTrue(hingeMovementUpDownSmallIncreasedIV.canRotate());

		assertTrue(hingeMovementUpSequential.canRotate());
		assertTrue(hingeMovementUpSequentialIncreasedI.canRotate());
		assertTrue(hingeMovementUpSequentialIncreasedII.canRotate());
		assertTrue(hingeMovementUpSequentialIncreasedIII.canRotate());
		assertTrue(hingeMovementUpSequentialMirrored.canRotate());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedI.canRotate());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedII.canRotate());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedIII.canRotate());

		assertTrue(hingeMovementDownSequential.canRotate());
		assertTrue(hingeMovementDownSequentialIncreasedI.canRotate());
		assertTrue(hingeMovementDownSequentialIncreasedII.canRotate());
		assertTrue(hingeMovementDownSequentialIncreasedIII.canRotate());
		assertTrue(hingeMovementDownSequentialMirrored.canRotate());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedI.canRotate());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedII.canRotate());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedIII.canRotate());

		assertTrue(hingeMovementUpDownAlternatingLarge.canRotate());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedI.canRotate());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedII.canRotate());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedIII.canRotate());

		assertTrue(hingeMovementUpDownAlternatingSmall.canRotate());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedI.canRotate());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedII.canRotate());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedIII.canRotate());

		assertTrue(hingeMovementSideToSideScissors.canRotate());
		assertTrue(hingeMovementSideToSideScissorsIncreasedI.canRotate());
		assertTrue(hingeMovementSideToSideScissorsIncreasedII.canRotate());
		assertTrue(hingeMovementSideToSideScissorsIncreasedIII.canRotate());

		assertTrue(fingerContactMovementWallPlane.canRotate());
		assertTrue(fingerContactMovementWallPlaneIncreasedI.canRotate());
		assertTrue(fingerContactMovementWallPlaneIncreasedII.canRotate());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrows.canRotate());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canRotate());

		assertTrue(fingerContactMovementFloorPlane.canRotate());
		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canRotate());
		assertTrue(fingerContactMovementFloorPlaneIncreasedII.canRotate());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrows.canRotate());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		squeezeLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-04"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-03"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-02"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-01"), squeezeLargeMultiple.getSymbol());

		squeezeLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-04"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-03"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-02"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-01"), squeezeLargeMultipleIncreased.getSymbol());

		squeezeSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-04"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-03"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-02"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-01"), squeezeSmallMultiple.getSymbol());

		squeezeSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-04"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-03"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-02"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-01"), squeezeSmallMultipleIncreased.getSymbol());

		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-08"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-07"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-06"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-05"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-04"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-03"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-02"), squeezeSequential.getSymbol());
		squeezeSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-01"), squeezeSequential.getSymbol());

		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-08"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-07"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-06"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-05"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-04"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-03"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-02"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-01"), squeezeSequentialIncreasedI.getSymbol());

		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-08"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-07"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-06"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-05"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-04"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-03"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-02"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-01"), squeezeSequentialIncreasedII.getSymbol());

		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-08"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-07"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-06"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-05"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-04"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-03"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-02"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-01"), squeezeSequentialIncreasedIII.getSymbol());

		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-10"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-11"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-12"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-13"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-14"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-15"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-16"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-09"), squeezeSequentialMirrored.getSymbol());

		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-10"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-11"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-12"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-13"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-14"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-15"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-16"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-09"), squeezeSequentialMirroredIncreasedI.getSymbol());

		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-10"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-11"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-12"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-13"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-14"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-15"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-16"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-09"),
				squeezeSequentialMirroredIncreasedII.getSymbol());

		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-10"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-11"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-12"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-13"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-14"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-15"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-16"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-09"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());

		flickLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-04"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-03"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-02"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-01"), flickLargeMultiple.getSymbol());

		flickLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-04"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-03"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-02"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-01"), flickLargeMultipleIncreased.getSymbol());

		flickSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-04"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-03"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-02"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-01"), flickSmallMultiple.getSymbol());

		flickSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-04"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-03"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-02"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-01"), flickSmallMultipleIncreased.getSymbol());

		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-08"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-07"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-06"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-05"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-04"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-03"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-02"), flickSequential.getSymbol());
		flickSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-01"), flickSequential.getSymbol());

		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-08"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-07"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-06"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-05"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-04"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-03"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-02"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-01"), flickSequentialIncreasedI.getSymbol());

		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-08"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-07"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-06"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-05"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-04"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-03"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-02"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-01"), flickSequentialIncreasedII.getSymbol());

		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-08"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-07"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-06"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-05"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-04"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-03"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-02"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-01"), flickSequentialIncreasedIII.getSymbol());

		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-10"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-11"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-12"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-13"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-14"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-15"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-16"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-09"), flickSequentialMirrored.getSymbol());

		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-10"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-11"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-12"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-13"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-14"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-15"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-16"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-09"), flickSequentialMirroredIncreasedI.getSymbol());

		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-10"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-11"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-12"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-13"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-14"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-15"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-16"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-09"), flickSequentialMirroredIncreasedII.getSymbol());

		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-10"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-11"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-12"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-13"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-14"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-15"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-16"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-09"), flickSequentialMirroredIncreasedIII.getSymbol());

		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-08"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-07"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-06"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-05"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-04"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-03"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-02"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-01"), squeezeFlickAlternating.getSymbol());

		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-08"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-07"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-06"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-05"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-04"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-03"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-02"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-01"), hingeMovementUpDownLarge.getSymbol());

		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-08"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-07"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-06"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-05"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-04"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-03"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-02"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-01"), hingeMovementUpDownLargeIncreasedI.getSymbol());

		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-08"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-07"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-06"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-05"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-04"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-03"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-02"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-01"), hingeMovementUpDownLargeIncreasedII.getSymbol());

		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-08"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-07"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-06"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-05"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-04"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-03"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-02"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-01"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());

		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-08"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-07"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-06"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-05"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-04"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-03"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-02"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-01"), hingeMovementUpDownLargeIncreasedIV.getSymbol());

		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-08"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-07"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-06"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-05"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-04"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-03"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-02"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-01"), hingeMovementUpDownSmall.getSymbol());

		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-08"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-07"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-06"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-05"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-04"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-03"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-02"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-01"), hingeMovementUpDownSmallIncreasedI.getSymbol());

		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-08"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-07"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-06"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-05"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-04"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-03"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-02"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-01"), hingeMovementUpDownSmallIncreasedII.getSymbol());

		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-08"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-07"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-06"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-05"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-04"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-03"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-02"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-01"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());

		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-08"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-07"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-06"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-05"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-04"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-03"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-02"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-01"), hingeMovementUpDownSmallIncreasedIV.getSymbol());

		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-08"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-07"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-06"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-05"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-04"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-03"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-02"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-01"), hingeMovementUpSequential.getSymbol());

		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-08"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-07"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-06"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-05"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-04"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-03"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-02"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-01"), hingeMovementUpSequentialIncreasedI.getSymbol());

		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-08"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-07"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-06"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-05"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-04"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-03"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-02"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-01"),
				hingeMovementUpSequentialIncreasedII.getSymbol());

		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-08"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-07"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-06"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-05"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-04"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-03"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-02"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-01"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());

		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-10"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-11"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-12"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-13"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-14"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-15"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-16"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-09"), hingeMovementUpSequentialMirrored.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-10"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-11"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-12"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-13"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-14"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-15"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-16"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-09"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-10"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-11"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-12"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-13"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-14"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-15"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-16"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-09"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-10"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-11"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-12"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-13"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-14"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-15"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-16"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-09"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-08"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-07"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-06"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-05"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-04"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-03"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-02"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-01"), hingeMovementDownSequential.getSymbol());

		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-08"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-07"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-06"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-05"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-04"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-03"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-02"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-01"),
				hingeMovementDownSequentialIncreasedI.getSymbol());

		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-08"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-07"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-06"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-05"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-04"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-03"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-02"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-01"),
				hingeMovementDownSequentialIncreasedII.getSymbol());

		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-08"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-07"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-06"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-05"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-04"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-03"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-02"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-01"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());

		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-10"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-11"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-12"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-13"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-14"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-15"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-16"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-09"), hingeMovementDownSequentialMirrored.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-10"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-11"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-12"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-13"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-14"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-15"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-16"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-09"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-10"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-11"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-12"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-13"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-14"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-15"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-16"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-09"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-10"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-11"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-12"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-13"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-14"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-15"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-16"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-09"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-08"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-07"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-06"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-05"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-04"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-03"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-02"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-01"), hingeMovementUpDownAlternatingLarge.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-08"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-07"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-06"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-05"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-04"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-03"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-02"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-01"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-08"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-07"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-06"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-05"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-04"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-03"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-02"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-01"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-08"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-07"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-06"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-05"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-04"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-03"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-02"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-01"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-08"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-07"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-06"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-05"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-04"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-03"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-02"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-01"), hingeMovementUpDownAlternatingSmall.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-08"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-07"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-06"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-05"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-04"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-03"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-02"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-01"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-08"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-07"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-06"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-05"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-04"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-03"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-02"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-01"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-08"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-07"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-06"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-05"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-04"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-03"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-02"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-01"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());

		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-08"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-07"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-06"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-05"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-04"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-03"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-02"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-01"), hingeMovementSideToSideScissors.getSymbol());

		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-08"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-07"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-06"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-05"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-04"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-03"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-02"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-01"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());

		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-08"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-07"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-06"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-05"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-04"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-03"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-02"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-01"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());

		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-08"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-07"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-06"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-05"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-04"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-03"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-02"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-01"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());

		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-08"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-07"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-06"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-05"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-04"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-03"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-02"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-01"), fingerContactMovementWallPlane.getSymbol());

		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-08"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-07"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-06"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-05"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-04"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-03"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-02"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-01"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-08"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-07"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-06"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-05"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-04"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-03"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-02"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-01"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-08"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-07"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-06"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-05"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-04"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-03"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-02"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-01"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-08"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-07"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-06"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-05"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-04"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-03"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-02"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-01"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());

		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-08"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-07"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-06"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-05"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-04"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-03"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-02"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-01"), fingerContactMovementFloorPlane.getSymbol());

		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-08"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-07"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-06"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-05"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-04"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-03"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-02"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-01"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-08"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-07"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-06"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-05"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-04"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-03"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-02"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-01"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-08"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-07"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-06"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-05"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-04"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-03"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-02"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-01"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-08"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-07"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-06"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-05"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-04"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-03"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-02"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-01"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {
		squeezeLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-02"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-03"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-04"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-01"), squeezeLargeMultiple.getSymbol());

		squeezeLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-02"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-03"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-04"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-01"), squeezeLargeMultipleIncreased.getSymbol());

		squeezeSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-02"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-03"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-04"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-01"), squeezeSmallMultiple.getSymbol());

		squeezeSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-02"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-03"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-04"), squeezeSmallMultipleIncreased.getSymbol());
		squeezeSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-01"), squeezeSmallMultipleIncreased.getSymbol());

		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-02"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-03"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-04"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-05"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-06"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-07"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-08"), squeezeSequential.getSymbol());
		squeezeSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-01"), squeezeSequential.getSymbol());

		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-02"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-03"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-04"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-05"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-06"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-07"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-08"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-01"), squeezeSequentialIncreasedI.getSymbol());

		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-02"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-03"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-04"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-05"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-06"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-07"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-08"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-01"), squeezeSequentialIncreasedII.getSymbol());

		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-02"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-03"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-04"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-05"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-06"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-07"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-08"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-01"), squeezeSequentialIncreasedIII.getSymbol());

		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-16"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-15"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-14"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-13"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-12"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-11"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-10"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-09"), squeezeSequentialMirrored.getSymbol());

		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-16"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-15"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-14"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-13"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-12"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-11"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-10"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-09"), squeezeSequentialMirroredIncreasedI.getSymbol());

		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-16"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-15"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-14"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-13"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-12"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-11"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-10"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-09"),
				squeezeSequentialMirroredIncreasedII.getSymbol());

		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-16"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-15"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-14"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-13"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-12"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-11"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-10"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-09"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());

		flickLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-02"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-03"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-04"), flickLargeMultiple.getSymbol());
		flickLargeMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-01"), flickLargeMultiple.getSymbol());

		flickLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-02"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-03"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-04"), flickLargeMultipleIncreased.getSymbol());
		flickLargeMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-01"), flickLargeMultipleIncreased.getSymbol());

		flickSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-02"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-03"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-04"), flickSmallMultiple.getSymbol());
		flickSmallMultiple.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-01"), flickSmallMultiple.getSymbol());

		flickSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-02"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-03"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-04"), flickSmallMultipleIncreased.getSymbol());
		flickSmallMultipleIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-01"), flickSmallMultipleIncreased.getSymbol());

		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-02"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-03"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-04"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-05"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-06"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-07"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-08"), flickSequential.getSymbol());
		flickSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-01"), flickSequential.getSymbol());

		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-02"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-03"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-04"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-05"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-06"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-07"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-08"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-01"), flickSequentialIncreasedI.getSymbol());

		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-02"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-03"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-04"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-05"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-06"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-07"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-08"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-01"), flickSequentialIncreasedII.getSymbol());

		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-02"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-03"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-04"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-05"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-06"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-07"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-08"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-01"), flickSequentialIncreasedIII.getSymbol());

		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-16"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-15"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-14"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-13"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-12"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-11"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-10"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-09"), flickSequentialMirrored.getSymbol());

		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-16"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-15"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-14"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-13"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-12"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-11"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-10"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-09"), flickSequentialMirroredIncreasedI.getSymbol());

		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-16"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-15"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-14"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-13"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-12"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-11"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-10"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-09"), flickSequentialMirroredIncreasedII.getSymbol());

		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-16"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-15"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-14"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-13"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-12"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-11"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-10"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-09"), flickSequentialMirroredIncreasedIII.getSymbol());

		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-02"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-03"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-04"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-05"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-06"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-07"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-08"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-01"), squeezeFlickAlternating.getSymbol());

		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-02"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-03"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-04"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-05"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-06"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-07"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-08"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-01"), hingeMovementUpDownLarge.getSymbol());

		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-02"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-03"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-04"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-05"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-06"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-07"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-08"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-01"), hingeMovementUpDownLargeIncreasedI.getSymbol());

		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-02"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-03"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-04"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-05"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-06"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-07"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-08"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-01"), hingeMovementUpDownLargeIncreasedII.getSymbol());

		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-02"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-03"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-04"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-05"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-06"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-07"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-08"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-01"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());

		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-02"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-03"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-04"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-05"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-06"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-07"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-08"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-01"), hingeMovementUpDownLargeIncreasedIV.getSymbol());

		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-02"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-03"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-04"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-05"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-06"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-07"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-08"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-01"), hingeMovementUpDownSmall.getSymbol());

		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-02"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-03"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-04"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-05"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-06"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-07"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-08"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-01"), hingeMovementUpDownSmallIncreasedI.getSymbol());

		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-02"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-03"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-04"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-05"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-06"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-07"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-08"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-01"), hingeMovementUpDownSmallIncreasedII.getSymbol());

		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-02"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-03"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-04"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-05"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-06"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-07"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-08"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-01"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());

		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-02"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-03"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-04"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-05"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-06"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-07"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-08"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-01"), hingeMovementUpDownSmallIncreasedIV.getSymbol());

		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-02"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-03"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-04"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-05"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-06"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-07"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-08"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-01"), hingeMovementUpSequential.getSymbol());

		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-02"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-03"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-04"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-05"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-06"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-07"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-08"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-01"), hingeMovementUpSequentialIncreasedI.getSymbol());

		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-02"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-03"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-04"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-05"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-06"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-07"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-08"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-01"),
				hingeMovementUpSequentialIncreasedII.getSymbol());

		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-02"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-03"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-04"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-05"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-06"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-07"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-08"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-01"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());

		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-16"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-15"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-14"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-13"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-12"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-11"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-10"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-09"), hingeMovementUpSequentialMirrored.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-16"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-15"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-14"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-13"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-12"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-11"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-10"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-09"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-16"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-15"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-14"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-13"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-12"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-11"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-10"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-09"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-16"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-15"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-14"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-13"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-12"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-11"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-10"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-09"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-02"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-03"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-04"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-05"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-06"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-07"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-08"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-01"), hingeMovementDownSequential.getSymbol());

		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-02"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-03"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-04"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-05"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-06"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-07"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-08"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-01"),
				hingeMovementDownSequentialIncreasedI.getSymbol());

		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-02"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-03"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-04"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-05"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-06"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-07"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-08"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-01"),
				hingeMovementDownSequentialIncreasedII.getSymbol());

		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-02"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-03"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-04"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-05"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-06"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-07"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-08"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-01"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());

		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-16"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-15"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-14"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-13"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-12"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-11"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-10"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-09"), hingeMovementDownSequentialMirrored.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-16"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-15"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-14"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-13"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-12"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-11"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-10"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-09"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-16"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-15"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-14"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-13"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-12"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-11"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-10"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-09"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-16"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-15"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-14"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-13"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-12"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-11"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-10"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-09"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-02"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-03"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-04"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-05"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-06"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-07"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-08"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-01"), hingeMovementUpDownAlternatingLarge.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-02"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-03"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-04"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-05"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-06"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-07"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-08"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-01"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-02"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-03"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-04"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-05"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-06"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-07"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-08"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-01"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-02"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-03"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-04"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-05"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-06"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-07"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-08"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-01"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-02"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-03"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-04"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-05"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-06"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-07"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-08"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-01"), hingeMovementUpDownAlternatingSmall.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-02"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-03"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-04"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-05"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-06"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-07"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-08"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-01"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-02"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-03"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-04"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-05"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-06"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-07"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-08"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-01"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-02"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-03"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-04"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-05"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-06"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-07"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-08"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-01"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());

		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-02"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-03"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-04"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-05"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-06"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-07"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-08"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-01"), hingeMovementSideToSideScissors.getSymbol());

		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-02"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-03"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-04"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-05"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-06"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-07"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-08"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-01"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());

		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-02"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-03"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-04"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-05"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-06"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-07"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-08"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-01"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());

		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-02"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-03"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-04"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-05"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-06"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-07"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-08"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-01"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());

		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-02"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-03"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-04"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-05"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-06"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-07"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-08"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-01"), fingerContactMovementWallPlane.getSymbol());

		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-02"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-03"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-04"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-05"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-06"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-07"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-08"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-01"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-02"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-03"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-04"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-05"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-06"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-07"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-08"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-01"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-02"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-03"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-04"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-05"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-06"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-07"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-08"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-01"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-02"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-03"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-04"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-05"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-06"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-07"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-08"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-01"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());

		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-02"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-03"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-04"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-05"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-06"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-07"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-08"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-01"), fingerContactMovementFloorPlane.getSymbol());

		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-02"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-03"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-04"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-05"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-06"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-07"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-08"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-01"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-02"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-03"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-04"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-05"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-06"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-07"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-08"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-01"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-02"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-03"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-04"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-05"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-06"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-07"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-08"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-01"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-02"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-03"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-04"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-05"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-06"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-07"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-08"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-01"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertFalse(squeezeLargeSingle.canMirror());

		assertTrue(squeezeLargeMultiple.canMirror());
		assertTrue(squeezeLargeMultipleIncreased.canMirror());

		assertFalse(squeezeSmallSingle.canMirror());

		assertTrue(squeezeSmallMultiple.canMirror());
		assertTrue(squeezeSmallMultipleIncreased.canMirror());

		assertTrue(squeezeSequential.canMirror());
		assertTrue(squeezeSequentialIncreasedI.canMirror());
		assertTrue(squeezeSequentialIncreasedII.canMirror());
		assertTrue(squeezeSequentialIncreasedIII.canMirror());
		assertTrue(squeezeSequentialMirrored.canMirror());
		assertTrue(squeezeSequentialMirroredIncreasedI.canMirror());
		assertTrue(squeezeSequentialMirroredIncreasedII.canMirror());
		assertTrue(squeezeSequentialMirroredIncreasedIII.canMirror());

		assertFalse(flickLargeSingle.canMirror());

		assertTrue(flickLargeMultiple.canMirror());
		assertTrue(flickLargeMultipleIncreased.canMirror());

		assertFalse(flickSmallSingle.canMirror());

		assertTrue(flickSmallMultiple.canMirror());
		assertTrue(flickSmallMultipleIncreased.canMirror());

		assertTrue(flickSequential.canMirror());
		assertTrue(flickSequentialIncreasedI.canMirror());
		assertTrue(flickSequentialIncreasedII.canMirror());
		assertTrue(flickSequentialIncreasedIII.canMirror());
		assertTrue(flickSequentialMirrored.canMirror());
		assertTrue(flickSequentialMirroredIncreasedI.canMirror());
		assertTrue(flickSequentialMirroredIncreasedII.canMirror());
		assertTrue(flickSequentialMirroredIncreasedIII.canMirror());

		assertTrue(squeezeFlickAlternating.canMirror());

		assertTrue(hingeMovementUpDownLarge.canMirror());
		assertTrue(hingeMovementUpDownLargeIncreasedI.canMirror());
		assertTrue(hingeMovementUpDownLargeIncreasedII.canMirror());
		assertTrue(hingeMovementUpDownLargeIncreasedIII.canMirror());
		assertTrue(hingeMovementUpDownLargeIncreasedIV.canMirror());

		assertTrue(hingeMovementUpDownSmall.canMirror());
		assertTrue(hingeMovementUpDownSmallIncreasedI.canMirror());
		assertTrue(hingeMovementUpDownSmallIncreasedII.canMirror());
		assertTrue(hingeMovementUpDownSmallIncreasedIII.canMirror());
		assertTrue(hingeMovementUpDownSmallIncreasedIV.canMirror());

		assertTrue(hingeMovementUpSequential.canMirror());
		assertTrue(hingeMovementUpSequentialIncreasedI.canMirror());
		assertTrue(hingeMovementUpSequentialIncreasedII.canMirror());
		assertTrue(hingeMovementUpSequentialIncreasedIII.canMirror());
		assertTrue(hingeMovementUpSequentialMirrored.canMirror());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedI.canMirror());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedII.canMirror());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedIII.canMirror());

		assertTrue(hingeMovementDownSequential.canMirror());
		assertTrue(hingeMovementDownSequentialIncreasedI.canMirror());
		assertTrue(hingeMovementDownSequentialIncreasedII.canMirror());
		assertTrue(hingeMovementDownSequentialIncreasedIII.canMirror());
		assertTrue(hingeMovementDownSequentialMirrored.canMirror());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedI.canMirror());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedII.canMirror());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedIII.canMirror());

		assertTrue(hingeMovementUpDownAlternatingLarge.canMirror());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedI.canMirror());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedII.canMirror());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedIII.canMirror());

		assertTrue(hingeMovementUpDownAlternatingSmall.canMirror());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedI.canMirror());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedII.canMirror());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedIII.canMirror());

		assertTrue(hingeMovementSideToSideScissors.canMirror());
		assertTrue(hingeMovementSideToSideScissorsIncreasedI.canMirror());
		assertTrue(hingeMovementSideToSideScissorsIncreasedII.canMirror());
		assertTrue(hingeMovementSideToSideScissorsIncreasedIII.canMirror());

		assertTrue(fingerContactMovementWallPlane.canMirror());
		assertTrue(fingerContactMovementWallPlaneIncreasedI.canMirror());
		assertTrue(fingerContactMovementWallPlaneIncreasedII.canMirror());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrows.canMirror());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canMirror());

		assertTrue(fingerContactMovementFloorPlane.canMirror());
		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canMirror());
		assertTrue(fingerContactMovementFloorPlaneIncreasedII.canMirror());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrows.canMirror());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canMirror());

	}

	@Override
	public void testMirror() {

		assertTrue(squeezeLargeMultiple.canMirror());
		assertTrue(squeezeLargeMultipleIncreased.canMirror());

		assertFalse(squeezeSmallSingle.canMirror());

		assertTrue(squeezeSmallMultiple.canMirror());
		assertTrue(squeezeSmallMultipleIncreased.canMirror());

		squeezeSequential.mirror();
		assertEquals(squeezeSequentialMirrored.getSymbol(), squeezeSequential.getSymbol());
		squeezeSequential.mirror();
		assertEquals(MovementBaseSymbol.SQUEEZE_SEQUENTIAL.getIswaSymbol(), squeezeSequential.getSymbol());

		squeezeSequentialIncreasedI.mirror();
		assertEquals(squeezeSequentialMirroredIncreasedI.getSymbol(), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-01"), squeezeSequentialIncreasedI.getSymbol());

		squeezeSequentialIncreasedII.mirror();
		assertEquals(squeezeSequentialMirroredIncreasedII.getSymbol(), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-01"), squeezeSequentialIncreasedII.getSymbol());

		squeezeSequentialIncreasedIII.mirror();
		assertEquals(squeezeSequentialMirroredIncreasedIII.getSymbol(), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-01"), squeezeSequentialIncreasedIII.getSymbol());

		squeezeSequentialMirrored.mirror();
		assertEquals(squeezeSequential.getSymbol(), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-09"), squeezeSequentialMirrored.getSymbol());

		squeezeSequentialMirroredIncreasedI.mirror();
		assertEquals(squeezeSequentialIncreasedI.getSymbol(), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-09"), squeezeSequentialMirroredIncreasedI.getSymbol());

		squeezeSequentialMirroredIncreasedII.mirror();
		assertEquals(squeezeSequentialIncreasedII.getSymbol(), squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-09"),
				squeezeSequentialMirroredIncreasedII.getSymbol());

		squeezeSequentialMirroredIncreasedIII.mirror();
		assertEquals(squeezeSequentialIncreasedIII.getSymbol(), squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-09"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());

		assertFalse(flickLargeSingle.canMirror());

		assertTrue(flickLargeMultiple.canMirror());
		assertTrue(flickLargeMultipleIncreased.canMirror());

		assertFalse(flickSmallSingle.canMirror());

		assertTrue(flickSmallMultiple.canMirror());
		assertTrue(flickSmallMultipleIncreased.canMirror());

		flickSequential.mirror();
		assertEquals(flickSequentialMirrored.getSymbol(), flickSequential.getSymbol());
		flickSequential.mirror();
		assertEquals(MovementBaseSymbol.FLICK_SEQUENTIAL.getIswaSymbol(), flickSequential.getSymbol());

		flickSequentialIncreasedI.mirror();
		assertEquals(flickSequentialMirroredIncreasedI.getSymbol(), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-01"), flickSequentialIncreasedI.getSymbol());

		flickSequentialIncreasedII.mirror();
		assertEquals(flickSequentialMirroredIncreasedII.getSymbol(), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-01"), flickSequentialIncreasedII.getSymbol());

		flickSequentialIncreasedIII.mirror();
		assertEquals(flickSequentialMirroredIncreasedIII.getSymbol(), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-01"), flickSequentialIncreasedIII.getSymbol());

		flickSequentialMirrored.mirror();
		assertEquals(flickSequential.getSymbol(), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-09"), flickSequentialMirrored.getSymbol());

		flickSequentialMirroredIncreasedI.mirror();
		assertEquals(flickSequentialIncreasedI.getSymbol(), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-09"), flickSequentialMirroredIncreasedI.getSymbol());

		flickSequentialMirroredIncreasedII.mirror();
		assertEquals(flickSequentialIncreasedII.getSymbol(), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-09"), flickSequentialMirroredIncreasedII.getSymbol());

		flickSequentialMirroredIncreasedIII.mirror();
		assertEquals(flickSequentialIncreasedIII.getSymbol(), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.mirror();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-09"), flickSequentialMirroredIncreasedIII.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertFalse(squeezeLargeSingle.canMirrorVertically());
		assertFalse(squeezeSmallSingle.canMirrorVertically());
		assertTrue(squeezeLargeMultiple.canMirrorVertically());
		assertTrue(squeezeLargeMultipleIncreased.canMirrorVertically());
		assertTrue(squeezeSmallMultiple.canMirrorVertically());
		assertTrue(squeezeSmallMultipleIncreased.canMirrorVertically());
		assertTrue(squeezeSequential.canMirrorVertically());
		assertTrue(squeezeSequentialIncreasedI.canMirrorVertically());
		assertTrue(squeezeSequentialIncreasedII.canMirrorVertically());
		assertTrue(squeezeSequentialIncreasedIII.canMirrorVertically());
		assertTrue(squeezeSequentialMirrored.canMirrorVertically());
		assertTrue(squeezeSequentialMirroredIncreasedI.canMirrorVertically());
		assertTrue(squeezeSequentialMirroredIncreasedII.canMirrorVertically());
		assertTrue(squeezeSequentialMirroredIncreasedIII.canMirrorVertically());

		assertFalse(flickLargeSingle.canMirrorVertically());
		assertFalse(flickSmallSingle.canMirrorVertically());
		assertTrue(flickLargeMultiple.canMirrorVertically());
		assertTrue(flickLargeMultipleIncreased.canMirrorVertically());
		assertTrue(flickSmallMultiple.canMirrorVertically());
		assertTrue(flickSmallMultipleIncreased.canMirrorVertically());
		assertTrue(flickSequential.canMirrorVertically());
		assertTrue(flickSequentialIncreasedI.canMirrorVertically());
		assertTrue(flickSequentialIncreasedII.canMirrorVertically());
		assertTrue(flickSequentialIncreasedIII.canMirrorVertically());
		assertTrue(flickSequentialMirrored.canMirrorVertically());
		assertTrue(flickSequentialMirroredIncreasedI.canMirrorVertically());
		assertTrue(flickSequentialMirroredIncreasedII.canMirrorVertically());
		assertTrue(flickSequentialMirroredIncreasedIII.canMirrorVertically());

		assertTrue(squeezeFlickAlternating.canMirrorVertically());

		assertTrue(hingeMovementUpDownLarge.canMirrorVertically());
		assertTrue(hingeMovementUpDownLargeIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpDownLargeIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpDownLargeIncreasedIII.canMirrorVertically());
		assertTrue(hingeMovementUpDownLargeIncreasedIV.canMirrorVertically());

		assertTrue(hingeMovementUpDownSmall.canMirrorVertically());
		assertTrue(hingeMovementUpDownSmallIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpDownSmallIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpDownSmallIncreasedIII.canMirrorVertically());
		assertTrue(hingeMovementUpDownSmallIncreasedIV.canMirrorVertically());

		assertTrue(hingeMovementUpSequential.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialIncreasedIII.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialMirrored.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpSequentialMirroredIncreasedIII.canMirrorVertically());

		assertTrue(hingeMovementDownSequential.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialIncreasedIII.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialMirrored.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementDownSequentialMirroredIncreasedIII.canMirrorVertically());

		assertTrue(hingeMovementUpDownAlternatingLarge.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingLargeIncreasedIII.canMirrorVertically());

		assertTrue(hingeMovementUpDownAlternatingSmall.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementUpDownAlternatingSmallIncreasedIII.canMirrorVertically());

		assertTrue(hingeMovementSideToSideScissors.canMirrorVertically());
		assertTrue(hingeMovementSideToSideScissorsIncreasedI.canMirrorVertically());
		assertTrue(hingeMovementSideToSideScissorsIncreasedII.canMirrorVertically());
		assertTrue(hingeMovementSideToSideScissorsIncreasedIII.canMirrorVertically());

		assertTrue(fingerContactMovementWallPlane.canMirrorVertically());
		assertTrue(fingerContactMovementWallPlaneIncreasedI.canMirrorVertically());
		assertTrue(fingerContactMovementWallPlaneIncreasedII.canMirrorVertically());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrows.canMirrorVertically());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canMirrorVertically());

		assertTrue(fingerContactMovementFloorPlane.canMirrorVertically());
		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canMirrorVertically());
		assertTrue(fingerContactMovementFloorPlaneIncreasedII.canMirrorVertically());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrows.canMirrorVertically());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		squeezeLargeMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-01-01"), squeezeLargeMultiple.getSymbol());
		squeezeLargeMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-002-01-02-01"), squeezeLargeMultipleIncreased.getSymbol());
		squeezeSmallMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-01-01"), squeezeSmallMultiple.getSymbol());
		squeezeSmallMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-002-02-02-01"), squeezeSmallMultipleIncreased.getSymbol());

		squeezeSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-13"), squeezeSequential.getSymbol());
		squeezeSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-01"), squeezeSequential.getSymbol());

		squeezeSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-13"), squeezeSequentialIncreasedI.getSymbol());
		squeezeSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-01"), squeezeSequentialIncreasedI.getSymbol());

		squeezeSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-13"), squeezeSequentialIncreasedII.getSymbol());
		squeezeSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-01"), squeezeSequentialIncreasedII.getSymbol());

		squeezeSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-13"), squeezeSequentialIncreasedIII.getSymbol());
		squeezeSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-01"), squeezeSequentialIncreasedIII.getSymbol());

		squeezeSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-05"), squeezeSequentialMirrored.getSymbol());
		squeezeSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-01-09"), squeezeSequentialMirrored.getSymbol());

		squeezeSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-05"), squeezeSequentialMirroredIncreasedI.getSymbol());
		squeezeSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-02-09"), squeezeSequentialMirroredIncreasedI.getSymbol());

		squeezeSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-05"),
				squeezeSequentialMirroredIncreasedII.getSymbol());
		squeezeSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-03-09"),
				squeezeSequentialMirroredIncreasedII.getSymbol());

		squeezeSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-05"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());
		squeezeSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-003-01-04-09"),
				squeezeSequentialMirroredIncreasedIII.getSymbol());

		flickLargeMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-01-01"), flickLargeMultiple.getSymbol());
		flickLargeMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-005-01-02-01"), flickLargeMultipleIncreased.getSymbol());
		flickSmallMultiple.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-01-01"), flickSmallMultiple.getSymbol());
		flickSmallMultipleIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-005-02-02-01"), flickSmallMultipleIncreased.getSymbol());

		flickSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-13"), flickSequential.getSymbol());
		flickSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-01"), flickSequential.getSymbol());

		flickSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-13"), flickSequentialIncreasedI.getSymbol());
		flickSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-01"), flickSequentialIncreasedI.getSymbol());

		flickSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-13"), flickSequentialIncreasedII.getSymbol());
		flickSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-01"), flickSequentialIncreasedII.getSymbol());

		flickSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-13"), flickSequentialIncreasedIII.getSymbol());
		flickSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-01"), flickSequentialIncreasedIII.getSymbol());

		flickSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-05"), flickSequentialMirrored.getSymbol());
		flickSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-01-09"), flickSequentialMirrored.getSymbol());

		flickSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-05"), flickSequentialMirroredIncreasedI.getSymbol());
		flickSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-02-09"), flickSequentialMirroredIncreasedI.getSymbol());

		flickSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-05"), flickSequentialMirroredIncreasedII.getSymbol());
		flickSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-03-09"), flickSequentialMirroredIncreasedII.getSymbol());

		flickSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-05"), flickSequentialMirroredIncreasedIII.getSymbol());
		flickSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-006-01-04-09"), flickSequentialMirroredIncreasedIII.getSymbol());

		squeezeFlickAlternating.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-05"), squeezeFlickAlternating.getSymbol());
		squeezeFlickAlternating.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-007-01-01-01"), squeezeFlickAlternating.getSymbol());

		hingeMovementUpDownLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-05"), hingeMovementUpDownLarge.getSymbol());
		hingeMovementUpDownLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-01-01"), hingeMovementUpDownLarge.getSymbol());

		hingeMovementUpDownLargeIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-05"), hingeMovementUpDownLargeIncreasedI.getSymbol());
		hingeMovementUpDownLargeIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-02-01"), hingeMovementUpDownLargeIncreasedI.getSymbol());

		hingeMovementUpDownLargeIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-05"), hingeMovementUpDownLargeIncreasedII.getSymbol());
		hingeMovementUpDownLargeIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-03-01"), hingeMovementUpDownLargeIncreasedII.getSymbol());

		hingeMovementUpDownLargeIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-05"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());
		hingeMovementUpDownLargeIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-04-01"),
				hingeMovementUpDownLargeIncreasedIII.getSymbol());

		hingeMovementUpDownLargeIncreasedIV.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-05"), hingeMovementUpDownLargeIncreasedIV.getSymbol());
		hingeMovementUpDownLargeIncreasedIV.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-01-05-01"), hingeMovementUpDownLargeIncreasedIV.getSymbol());

		hingeMovementUpDownSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-05"), hingeMovementUpDownSmall.getSymbol());
		hingeMovementUpDownSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-01-01"), hingeMovementUpDownSmall.getSymbol());

		hingeMovementUpDownSmallIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-05"), hingeMovementUpDownSmallIncreasedI.getSymbol());
		hingeMovementUpDownSmallIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-02-01"), hingeMovementUpDownSmallIncreasedI.getSymbol());

		hingeMovementUpDownSmallIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-05"), hingeMovementUpDownSmallIncreasedII.getSymbol());
		hingeMovementUpDownSmallIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-03-01"), hingeMovementUpDownSmallIncreasedII.getSymbol());

		hingeMovementUpDownSmallIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-05"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());
		hingeMovementUpDownSmallIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-04-01"),
				hingeMovementUpDownSmallIncreasedIII.getSymbol());

		hingeMovementUpDownSmallIncreasedIV.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-05"), hingeMovementUpDownSmallIncreasedIV.getSymbol());
		hingeMovementUpDownSmallIncreasedIV.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-008-02-05-01"), hingeMovementUpDownSmallIncreasedIV.getSymbol());

		hingeMovementUpSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-13"), hingeMovementUpSequential.getSymbol());
		hingeMovementUpSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-01"), hingeMovementUpSequential.getSymbol());

		hingeMovementUpSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-13"), hingeMovementUpSequentialIncreasedI.getSymbol());
		hingeMovementUpSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-01"), hingeMovementUpSequentialIncreasedI.getSymbol());

		hingeMovementUpSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-13"),
				hingeMovementUpSequentialIncreasedII.getSymbol());
		hingeMovementUpSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-01"),
				hingeMovementUpSequentialIncreasedII.getSymbol());

		hingeMovementUpSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-13"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());
		hingeMovementUpSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-01"),
				hingeMovementUpSequentialIncreasedIII.getSymbol());

		hingeMovementUpSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-05"), hingeMovementUpSequentialMirrored.getSymbol());
		hingeMovementUpSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-01-09"), hingeMovementUpSequentialMirrored.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-05"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-02-09"),
				hingeMovementUpSequentialMirroredIncreasedI.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-05"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-03-09"),
				hingeMovementUpSequentialMirroredIncreasedII.getSymbol());

		hingeMovementUpSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-05"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementUpSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-01-04-09"),
				hingeMovementUpSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementDownSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-13"), hingeMovementDownSequential.getSymbol());
		hingeMovementDownSequential.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-01"), hingeMovementDownSequential.getSymbol());

		hingeMovementDownSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-13"),
				hingeMovementDownSequentialIncreasedI.getSymbol());
		hingeMovementDownSequentialIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-01"),
				hingeMovementDownSequentialIncreasedI.getSymbol());

		hingeMovementDownSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-13"),
				hingeMovementDownSequentialIncreasedII.getSymbol());
		hingeMovementDownSequentialIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-01"),
				hingeMovementDownSequentialIncreasedII.getSymbol());

		hingeMovementDownSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-13"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());
		hingeMovementDownSequentialIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-01"),
				hingeMovementDownSequentialIncreasedIII.getSymbol());

		hingeMovementDownSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-05"), hingeMovementDownSequentialMirrored.getSymbol());
		hingeMovementDownSequentialMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-01-09"), hingeMovementDownSequentialMirrored.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-05"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-02-09"),
				hingeMovementDownSequentialMirroredIncreasedI.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-05"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-03-09"),
				hingeMovementDownSequentialMirroredIncreasedII.getSymbol());

		hingeMovementDownSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-05"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());
		hingeMovementDownSequentialMirroredIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-009-02-04-09"),
				hingeMovementDownSequentialMirroredIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-05"), hingeMovementUpDownAlternatingLarge.getSymbol());
		hingeMovementUpDownAlternatingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-01-01"), hingeMovementUpDownAlternatingLarge.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-05"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-02-01"),
				hingeMovementUpDownAlternatingLargeIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-05"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-03-01"),
				hingeMovementUpDownAlternatingLargeIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingLargeIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-05"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingLargeIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-01-04-01"),
				hingeMovementUpDownAlternatingLargeIncreasedIII.getSymbol());

		hingeMovementUpDownAlternatingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-05"), hingeMovementUpDownAlternatingSmall.getSymbol());
		hingeMovementUpDownAlternatingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-01-01"), hingeMovementUpDownAlternatingSmall.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-05"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-02-01"),
				hingeMovementUpDownAlternatingSmallIncreasedI.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-05"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-03-01"),
				hingeMovementUpDownAlternatingSmallIncreasedII.getSymbol());

		hingeMovementUpDownAlternatingSmallIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-05"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());
		hingeMovementUpDownAlternatingSmallIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-010-02-04-01"),
				hingeMovementUpDownAlternatingSmallIncreasedIII.getSymbol());

		hingeMovementSideToSideScissors.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-05"), hingeMovementSideToSideScissors.getSymbol());
		hingeMovementSideToSideScissors.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-01-01"), hingeMovementSideToSideScissors.getSymbol());

		hingeMovementSideToSideScissorsIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-05"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());
		hingeMovementSideToSideScissorsIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-02-01"),
				hingeMovementSideToSideScissorsIncreasedI.getSymbol());

		hingeMovementSideToSideScissorsIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-05"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-03-01"),
				hingeMovementSideToSideScissorsIncreasedII.getSymbol());

		hingeMovementSideToSideScissorsIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-05"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());
		hingeMovementSideToSideScissorsIncreasedIII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-011-01-04-01"),
				hingeMovementSideToSideScissorsIncreasedIII.getSymbol());

		fingerContactMovementWallPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-05"), fingerContactMovementWallPlane.getSymbol());
		fingerContactMovementWallPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-01-01"), fingerContactMovementWallPlane.getSymbol());

		fingerContactMovementWallPlaneIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-05"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());
		fingerContactMovementWallPlaneIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-02-01"),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-05"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());
		fingerContactMovementWallPlaneIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-04-01"),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrows.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-05"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrows.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-03-01"),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrowsIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-05"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementWallPlaneAlternatingArrowsIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-012-01-05-01"),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());

		fingerContactMovementFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-05"), fingerContactMovementFloorPlane.getSymbol());
		fingerContactMovementFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-01-01"), fingerContactMovementFloorPlane.getSymbol());

		fingerContactMovementFloorPlaneIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-05"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());
		fingerContactMovementFloorPlaneIncreasedI.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-02-01"),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-05"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());
		fingerContactMovementFloorPlaneIncreasedII.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-04-01"),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrows.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-05"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrows.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-03-01"),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-05"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-02-013-01-05-01"),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
	}

	@Override
	public void testCanPitch() {

		assertFalse(squeezeLargeSingle.canPitch());
		assertFalse(squeezeSmallSingle.canPitch());
		assertFalse(squeezeLargeMultiple.canPitch());
		assertFalse(squeezeLargeMultipleIncreased.canPitch());
		assertFalse(squeezeSmallMultiple.canPitch());
		assertFalse(squeezeSmallMultipleIncreased.canPitch());
		assertFalse(squeezeSequential.canPitch());
		assertFalse(squeezeSequentialIncreasedI.canPitch());
		assertFalse(squeezeSequentialIncreasedII.canPitch());
		assertFalse(squeezeSequentialIncreasedIII.canPitch());
		assertFalse(squeezeSequentialMirrored.canPitch());
		assertFalse(squeezeSequentialMirroredIncreasedI.canPitch());
		assertFalse(squeezeSequentialMirroredIncreasedII.canPitch());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canPitch());

		assertFalse(flickLargeSingle.canPitch());
		assertFalse(flickSmallSingle.canPitch());
		assertFalse(flickLargeMultiple.canPitch());
		assertFalse(flickLargeMultipleIncreased.canPitch());
		assertFalse(flickSmallMultiple.canPitch());
		assertFalse(flickSmallMultipleIncreased.canPitch());
		assertFalse(flickSequential.canPitch());
		assertFalse(flickSequentialIncreasedI.canPitch());
		assertFalse(flickSequentialIncreasedII.canPitch());
		assertFalse(flickSequentialIncreasedIII.canPitch());
		assertFalse(flickSequentialMirrored.canPitch());
		assertFalse(flickSequentialMirroredIncreasedI.canPitch());
		assertFalse(flickSequentialMirroredIncreasedII.canPitch());
		assertFalse(flickSequentialMirroredIncreasedIII.canPitch());

		assertFalse(squeezeFlickAlternating.canPitch());

		assertFalse(hingeMovementUpDownLarge.canPitch());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canPitch());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canPitch());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canPitch());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canPitch());

		assertFalse(hingeMovementUpDownSmall.canPitch());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canPitch());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canPitch());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canPitch());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canPitch());

		assertFalse(hingeMovementUpSequential.canPitch());
		assertFalse(hingeMovementUpSequentialIncreasedI.canPitch());
		assertFalse(hingeMovementUpSequentialIncreasedII.canPitch());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canPitch());
		assertFalse(hingeMovementUpSequentialMirrored.canPitch());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canPitch());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canPitch());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canPitch());

		assertFalse(hingeMovementDownSequential.canPitch());
		assertFalse(hingeMovementDownSequentialIncreasedI.canPitch());
		assertFalse(hingeMovementDownSequentialIncreasedII.canPitch());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canPitch());
		assertFalse(hingeMovementDownSequentialMirrored.canPitch());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canPitch());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canPitch());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canPitch());

		assertFalse(hingeMovementUpDownAlternatingLarge.canPitch());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canPitch());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canPitch());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canPitch());

		assertFalse(hingeMovementUpDownAlternatingSmall.canPitch());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canPitch());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canPitch());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canPitch());

		assertFalse(hingeMovementSideToSideScissors.canPitch());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canPitch());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canPitch());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canPitch());

		assertFalse(fingerContactMovementWallPlane.canPitch());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canPitch());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canPitch());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canPitch());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canPitch());

		assertFalse(fingerContactMovementFloorPlane.canPitch());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canPitch());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canPitch());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canPitch());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(squeezeLargeSingle.canRoll());
		assertFalse(squeezeSmallSingle.canRoll());
		assertFalse(squeezeLargeMultiple.canRoll());
		assertFalse(squeezeLargeMultipleIncreased.canRoll());
		assertFalse(squeezeSmallMultiple.canRoll());
		assertFalse(squeezeSmallMultipleIncreased.canRoll());
		assertFalse(squeezeSequential.canRoll());
		assertFalse(squeezeSequentialIncreasedI.canRoll());
		assertFalse(squeezeSequentialIncreasedII.canRoll());
		assertFalse(squeezeSequentialIncreasedIII.canRoll());
		assertFalse(squeezeSequentialMirrored.canRoll());
		assertFalse(squeezeSequentialMirroredIncreasedI.canRoll());
		assertFalse(squeezeSequentialMirroredIncreasedII.canRoll());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canRoll());

		assertFalse(flickLargeSingle.canRoll());
		assertFalse(flickSmallSingle.canRoll());
		assertFalse(flickLargeMultiple.canRoll());
		assertFalse(flickLargeMultipleIncreased.canRoll());
		assertFalse(flickSmallMultiple.canRoll());
		assertFalse(flickSmallMultipleIncreased.canRoll());
		assertFalse(flickSequential.canRoll());
		assertFalse(flickSequentialIncreasedI.canRoll());
		assertFalse(flickSequentialIncreasedII.canRoll());
		assertFalse(flickSequentialIncreasedIII.canRoll());
		assertFalse(flickSequentialMirrored.canRoll());
		assertFalse(flickSequentialMirroredIncreasedI.canRoll());
		assertFalse(flickSequentialMirroredIncreasedII.canRoll());
		assertFalse(flickSequentialMirroredIncreasedIII.canRoll());

		assertFalse(squeezeFlickAlternating.canRoll());

		assertFalse(hingeMovementUpDownLarge.canRoll());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canRoll());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canRoll());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canRoll());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canRoll());

		assertFalse(hingeMovementUpDownSmall.canRoll());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canRoll());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canRoll());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canRoll());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canRoll());

		assertFalse(hingeMovementUpSequential.canRoll());
		assertFalse(hingeMovementUpSequentialIncreasedI.canRoll());
		assertFalse(hingeMovementUpSequentialIncreasedII.canRoll());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canRoll());
		assertFalse(hingeMovementUpSequentialMirrored.canRoll());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canRoll());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canRoll());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canRoll());

		assertFalse(hingeMovementDownSequential.canRoll());
		assertFalse(hingeMovementDownSequentialIncreasedI.canRoll());
		assertFalse(hingeMovementDownSequentialIncreasedII.canRoll());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canRoll());
		assertFalse(hingeMovementDownSequentialMirrored.canRoll());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canRoll());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canRoll());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canRoll());

		assertFalse(hingeMovementUpDownAlternatingLarge.canRoll());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canRoll());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canRoll());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canRoll());

		assertFalse(hingeMovementUpDownAlternatingSmall.canRoll());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canRoll());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canRoll());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canRoll());

		assertFalse(hingeMovementSideToSideScissors.canRoll());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canRoll());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canRoll());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canRoll());

		assertFalse(fingerContactMovementWallPlane.canRoll());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canRoll());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canRoll());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canRoll());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canRoll());

		assertFalse(fingerContactMovementFloorPlane.canRoll());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canRoll());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canRoll());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canRoll());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertFalse(squeezeLargeSingle.canSwitchArrowHead());
		assertFalse(squeezeSmallSingle.canSwitchArrowHead());
		assertFalse(squeezeLargeMultiple.canSwitchArrowHead());
		assertFalse(squeezeLargeMultipleIncreased.canSwitchArrowHead());
		assertFalse(squeezeSmallMultiple.canSwitchArrowHead());
		assertFalse(squeezeSmallMultipleIncreased.canSwitchArrowHead());
		assertFalse(squeezeSequential.canSwitchArrowHead());
		assertFalse(squeezeSequentialIncreasedI.canSwitchArrowHead());
		assertFalse(squeezeSequentialIncreasedII.canSwitchArrowHead());
		assertFalse(squeezeSequentialIncreasedIII.canSwitchArrowHead());
		assertFalse(squeezeSequentialMirrored.canSwitchArrowHead());
		assertFalse(squeezeSequentialMirroredIncreasedI.canSwitchArrowHead());
		assertFalse(squeezeSequentialMirroredIncreasedII.canSwitchArrowHead());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canSwitchArrowHead());

		assertFalse(flickLargeSingle.canSwitchArrowHead());
		assertFalse(flickSmallSingle.canSwitchArrowHead());
		assertFalse(flickLargeMultiple.canSwitchArrowHead());
		assertFalse(flickLargeMultipleIncreased.canSwitchArrowHead());
		assertFalse(flickSmallMultiple.canSwitchArrowHead());
		assertFalse(flickSmallMultipleIncreased.canSwitchArrowHead());
		assertFalse(flickSequential.canSwitchArrowHead());
		assertFalse(flickSequentialIncreasedI.canSwitchArrowHead());
		assertFalse(flickSequentialIncreasedII.canSwitchArrowHead());
		assertFalse(flickSequentialIncreasedIII.canSwitchArrowHead());
		assertFalse(flickSequentialMirrored.canSwitchArrowHead());
		assertFalse(flickSequentialMirroredIncreasedI.canSwitchArrowHead());
		assertFalse(flickSequentialMirroredIncreasedII.canSwitchArrowHead());
		assertFalse(flickSequentialMirroredIncreasedIII.canSwitchArrowHead());

		assertFalse(squeezeFlickAlternating.canSwitchArrowHead());

		assertFalse(hingeMovementUpDownLarge.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canSwitchArrowHead());

		assertFalse(hingeMovementUpDownSmall.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canSwitchArrowHead());

		assertFalse(hingeMovementUpSequential.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialMirrored.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canSwitchArrowHead());

		assertFalse(hingeMovementDownSequential.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialMirrored.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canSwitchArrowHead());

		assertFalse(hingeMovementUpDownAlternatingLarge.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canSwitchArrowHead());

		assertFalse(hingeMovementUpDownAlternatingSmall.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canSwitchArrowHead());

		assertFalse(hingeMovementSideToSideScissors.canSwitchArrowHead());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canSwitchArrowHead());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canSwitchArrowHead());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canSwitchArrowHead());

		assertFalse(fingerContactMovementWallPlane.canSwitchArrowHead());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canSwitchArrowHead());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canSwitchArrowHead());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canSwitchArrowHead());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canSwitchArrowHead());

		assertFalse(fingerContactMovementFloorPlane.canSwitchArrowHead());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canSwitchArrowHead());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canSwitchArrowHead());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canSwitchArrowHead());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(squeezeLargeSingle.canSwitchToNormalArrows());
		assertFalse(squeezeSmallSingle.canSwitchToNormalArrows());
		assertFalse(squeezeLargeMultiple.canSwitchToNormalArrows());
		assertFalse(squeezeLargeMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(squeezeSmallMultiple.canSwitchToNormalArrows());
		assertFalse(squeezeSmallMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(squeezeSequential.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialIncreasedI.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialIncreasedII.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialIncreasedIII.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialMirrored.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialMirroredIncreasedI.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialMirroredIncreasedII.canSwitchToNormalArrows());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canSwitchToNormalArrows());

		assertFalse(flickLargeSingle.canSwitchToNormalArrows());
		assertFalse(flickSmallSingle.canSwitchToNormalArrows());
		assertFalse(flickLargeMultiple.canSwitchToNormalArrows());
		assertFalse(flickLargeMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(flickSmallMultiple.canSwitchToNormalArrows());
		assertFalse(flickSmallMultipleIncreased.canSwitchToNormalArrows());
		assertFalse(flickSequential.canSwitchToNormalArrows());
		assertFalse(flickSequentialIncreasedI.canSwitchToNormalArrows());
		assertFalse(flickSequentialIncreasedII.canSwitchToNormalArrows());
		assertFalse(flickSequentialIncreasedIII.canSwitchToNormalArrows());
		assertFalse(flickSequentialMirrored.canSwitchToNormalArrows());
		assertFalse(flickSequentialMirroredIncreasedI.canSwitchToNormalArrows());
		assertFalse(flickSequentialMirroredIncreasedII.canSwitchToNormalArrows());
		assertFalse(flickSequentialMirroredIncreasedIII.canSwitchToNormalArrows());

		assertFalse(squeezeFlickAlternating.canSwitchToNormalArrows());

		assertFalse(hingeMovementUpDownLarge.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canSwitchToNormalArrows());

		assertFalse(hingeMovementUpDownSmall.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canSwitchToNormalArrows());

		assertFalse(hingeMovementUpSequential.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialMirrored.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canSwitchToNormalArrows());

		assertFalse(hingeMovementDownSequential.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialMirrored.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canSwitchToNormalArrows());

		assertFalse(hingeMovementUpDownAlternatingLarge.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canSwitchToNormalArrows());

		assertFalse(hingeMovementUpDownAlternatingSmall.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canSwitchToNormalArrows());

		assertFalse(hingeMovementSideToSideScissors.canSwitchToNormalArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canSwitchToNormalArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canSwitchToNormalArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canSwitchToNormalArrows());

		assertFalse(fingerContactMovementWallPlane.canSwitchToNormalArrows());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canSwitchToNormalArrows());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canSwitchToNormalArrows());

		assertTrue(fingerContactMovementWallPlaneAlternatingArrows.canSwitchToNormalArrows());
		assertTrue(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canSwitchToNormalArrows());

		assertFalse(fingerContactMovementFloorPlane.canSwitchToNormalArrows());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canSwitchToNormalArrows());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canSwitchToNormalArrows());

		assertTrue(fingerContactMovementFloorPlaneAlternatingArrows.canSwitchToNormalArrows());
		assertTrue(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {
		fingerContactMovementWallPlaneAlternatingArrows.switchToNormalArrows();
		assertEquals(fingerContactMovementWallPlaneIncreasedI.getSymbol(),
				fingerContactMovementWallPlaneAlternatingArrows.getSymbol());

		fingerContactMovementWallPlaneAlternatingArrowsIncreased.switchToNormalArrows();
		assertEquals(fingerContactMovementWallPlaneIncreasedII.getSymbol(),
				fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrows.switchToNormalArrows();
		assertEquals(fingerContactMovementFloorPlaneIncreasedI.getSymbol(),
				fingerContactMovementFloorPlaneAlternatingArrows.getSymbol());

		fingerContactMovementFloorPlaneAlternatingArrowsIncreased.switchToNormalArrows();
		assertEquals(fingerContactMovementFloorPlaneIncreasedII.getSymbol(),
				fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol());
	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(squeezeLargeSingle.canSwitchToAlternatingArrows());
		assertFalse(squeezeSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(squeezeLargeMultiple.canSwitchToAlternatingArrows());
		assertFalse(squeezeLargeMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(squeezeSmallMultiple.canSwitchToAlternatingArrows());
		assertFalse(squeezeSmallMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequential.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialMirrored.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialMirroredIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialMirroredIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(flickLargeSingle.canSwitchToAlternatingArrows());
		assertFalse(flickSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(flickLargeMultiple.canSwitchToAlternatingArrows());
		assertFalse(flickLargeMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(flickSmallMultiple.canSwitchToAlternatingArrows());
		assertFalse(flickSmallMultipleIncreased.canSwitchToAlternatingArrows());
		assertFalse(flickSequential.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialMirrored.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialMirroredIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialMirroredIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(flickSequentialMirroredIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(squeezeFlickAlternating.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementUpDownLarge.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementUpDownSmall.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementUpSequential.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialMirrored.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementDownSequential.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialMirrored.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementUpDownAlternatingLarge.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementUpDownAlternatingSmall.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(hingeMovementSideToSideScissors.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canSwitchToAlternatingArrows());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canSwitchToAlternatingArrows());

		assertFalse(fingerContactMovementWallPlane.canSwitchToAlternatingArrows());

		assertTrue(fingerContactMovementWallPlaneIncreasedI.canSwitchToAlternatingArrows());
		assertTrue(fingerContactMovementWallPlaneIncreasedII.canSwitchToAlternatingArrows());

		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canSwitchToAlternatingArrows());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canSwitchToAlternatingArrows());

		assertFalse(fingerContactMovementFloorPlane.canSwitchToAlternatingArrows());

		assertTrue(fingerContactMovementFloorPlaneIncreasedI.canSwitchToAlternatingArrows());
		assertTrue(fingerContactMovementFloorPlaneIncreasedII.canSwitchToAlternatingArrows());

		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canSwitchToAlternatingArrows());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

		fingerContactMovementWallPlaneIncreasedI.switchToAlternatingArrows();
		assertEquals(fingerContactMovementWallPlaneAlternatingArrows.getSymbol(),
				fingerContactMovementWallPlaneIncreasedI.getSymbol());

		fingerContactMovementWallPlaneIncreasedII.switchToAlternatingArrows();
		assertEquals(fingerContactMovementWallPlaneAlternatingArrowsIncreased.getSymbol(),
				fingerContactMovementWallPlaneIncreasedII.getSymbol());

		fingerContactMovementFloorPlaneIncreasedI.switchToAlternatingArrows();
		assertEquals(fingerContactMovementFloorPlaneAlternatingArrows.getSymbol(),
				fingerContactMovementFloorPlaneIncreasedI.getSymbol());

		fingerContactMovementFloorPlaneIncreasedII.switchToAlternatingArrows();
		assertEquals(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.getSymbol(),
				fingerContactMovementFloorPlaneIncreasedII.getSymbol());

	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(squeezeLargeSingle.canSwitchStartingPoint());

		assertFalse(squeezeSmallSingle.canSwitchStartingPoint());

		assertFalse(squeezeLargeMultiple.canSwitchStartingPoint());
		assertFalse(squeezeLargeMultipleIncreased.canSwitchStartingPoint());

		assertFalse(squeezeSmallMultiple.canSwitchStartingPoint());
		assertFalse(squeezeSmallMultipleIncreased.canSwitchStartingPoint());

		assertFalse(squeezeSequential.canSwitchStartingPoint());
		assertFalse(squeezeSequentialIncreasedI.canSwitchStartingPoint());
		assertFalse(squeezeSequentialIncreasedII.canSwitchStartingPoint());
		assertFalse(squeezeSequentialIncreasedIII.canSwitchStartingPoint());
		assertFalse(squeezeSequentialMirrored.canSwitchStartingPoint());
		assertFalse(squeezeSequentialMirroredIncreasedI.canSwitchStartingPoint());
		assertFalse(squeezeSequentialMirroredIncreasedII.canSwitchStartingPoint());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canSwitchStartingPoint());

		assertFalse(flickLargeSingle.canSwitchStartingPoint());

		assertFalse(flickSmallSingle.canSwitchStartingPoint());

		assertFalse(flickLargeMultiple.canSwitchStartingPoint());
		assertFalse(flickLargeMultipleIncreased.canSwitchStartingPoint());

		assertFalse(flickSmallMultiple.canSwitchStartingPoint());
		assertFalse(flickSmallMultipleIncreased.canSwitchStartingPoint());

		assertFalse(flickSequential.canSwitchStartingPoint());
		assertFalse(flickSequentialIncreasedI.canSwitchStartingPoint());
		assertFalse(flickSequentialIncreasedII.canSwitchStartingPoint());
		assertFalse(flickSequentialIncreasedIII.canSwitchStartingPoint());
		assertFalse(flickSequentialMirrored.canSwitchStartingPoint());
		assertFalse(flickSequentialMirroredIncreasedI.canSwitchStartingPoint());
		assertFalse(flickSequentialMirroredIncreasedII.canSwitchStartingPoint());
		assertFalse(flickSequentialMirroredIncreasedIII.canSwitchStartingPoint());

		assertFalse(squeezeFlickAlternating.canSwitchStartingPoint());

		assertFalse(hingeMovementUpDownLarge.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canSwitchStartingPoint());

		assertFalse(hingeMovementUpDownSmall.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canSwitchStartingPoint());

		assertFalse(hingeMovementUpSequential.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialMirrored.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canSwitchStartingPoint());

		assertFalse(hingeMovementDownSequential.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialMirrored.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canSwitchStartingPoint());

		assertFalse(hingeMovementUpDownAlternatingLarge.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canSwitchStartingPoint());

		assertFalse(hingeMovementUpDownAlternatingSmall.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canSwitchStartingPoint());

		assertFalse(hingeMovementSideToSideScissors.canSwitchStartingPoint());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canSwitchStartingPoint());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canSwitchStartingPoint());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canSwitchStartingPoint());

		assertFalse(fingerContactMovementWallPlane.canSwitchStartingPoint());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canSwitchStartingPoint());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canSwitchStartingPoint());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canSwitchStartingPoint());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canSwitchStartingPoint());

		assertFalse(fingerContactMovementFloorPlane.canSwitchStartingPoint());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canSwitchStartingPoint());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canSwitchStartingPoint());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canSwitchStartingPoint());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {

		assertFalse(squeezeLargeSingle.canSwitchPlane());

		assertFalse(squeezeSmallSingle.canSwitchPlane());

		assertFalse(squeezeLargeMultiple.canSwitchPlane());
		assertFalse(squeezeLargeMultipleIncreased.canSwitchPlane());

		assertFalse(squeezeSmallMultiple.canSwitchPlane());
		assertFalse(squeezeSmallMultipleIncreased.canSwitchPlane());

		assertFalse(squeezeSequential.canSwitchPlane());
		assertFalse(squeezeSequentialIncreasedI.canSwitchPlane());
		assertFalse(squeezeSequentialIncreasedII.canSwitchPlane());
		assertFalse(squeezeSequentialIncreasedIII.canSwitchPlane());
		assertFalse(squeezeSequentialMirrored.canSwitchPlane());
		assertFalse(squeezeSequentialMirroredIncreasedI.canSwitchPlane());
		assertFalse(squeezeSequentialMirroredIncreasedII.canSwitchPlane());
		assertFalse(squeezeSequentialMirroredIncreasedIII.canSwitchPlane());

		assertFalse(flickLargeSingle.canSwitchPlane());

		assertFalse(flickSmallSingle.canSwitchPlane());

		assertFalse(flickLargeMultiple.canSwitchPlane());
		assertFalse(flickLargeMultipleIncreased.canSwitchPlane());

		assertFalse(flickSmallMultiple.canSwitchPlane());
		assertFalse(flickSmallMultipleIncreased.canSwitchPlane());

		assertFalse(flickSequential.canSwitchPlane());
		assertFalse(flickSequentialIncreasedI.canSwitchPlane());
		assertFalse(flickSequentialIncreasedII.canSwitchPlane());
		assertFalse(flickSequentialIncreasedIII.canSwitchPlane());
		assertFalse(flickSequentialMirrored.canSwitchPlane());
		assertFalse(flickSequentialMirroredIncreasedI.canSwitchPlane());
		assertFalse(flickSequentialMirroredIncreasedII.canSwitchPlane());
		assertFalse(flickSequentialMirroredIncreasedIII.canSwitchPlane());

		assertFalse(squeezeFlickAlternating.canSwitchPlane());

		assertFalse(hingeMovementUpDownLarge.canSwitchPlane());
		assertFalse(hingeMovementUpDownLargeIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpDownLargeIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpDownLargeIncreasedIII.canSwitchPlane());
		assertFalse(hingeMovementUpDownLargeIncreasedIV.canSwitchPlane());

		assertFalse(hingeMovementUpDownSmall.canSwitchPlane());
		assertFalse(hingeMovementUpDownSmallIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpDownSmallIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpDownSmallIncreasedIII.canSwitchPlane());
		assertFalse(hingeMovementUpDownSmallIncreasedIV.canSwitchPlane());

		assertFalse(hingeMovementUpSequential.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialIncreasedIII.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialMirrored.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpSequentialMirroredIncreasedIII.canSwitchPlane());

		assertFalse(hingeMovementDownSequential.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialIncreasedIII.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialMirrored.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementDownSequentialMirroredIncreasedIII.canSwitchPlane());

		assertFalse(hingeMovementUpDownAlternatingLarge.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingLargeIncreasedIII.canSwitchPlane());

		assertFalse(hingeMovementUpDownAlternatingSmall.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementUpDownAlternatingSmallIncreasedIII.canSwitchPlane());

		assertFalse(hingeMovementSideToSideScissors.canSwitchPlane());
		assertFalse(hingeMovementSideToSideScissorsIncreasedI.canSwitchPlane());
		assertFalse(hingeMovementSideToSideScissorsIncreasedII.canSwitchPlane());
		assertFalse(hingeMovementSideToSideScissorsIncreasedIII.canSwitchPlane());

		assertFalse(fingerContactMovementWallPlane.canSwitchPlane());
		assertFalse(fingerContactMovementWallPlaneIncreasedI.canSwitchPlane());
		assertFalse(fingerContactMovementWallPlaneIncreasedII.canSwitchPlane());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrows.canSwitchPlane());
		assertFalse(fingerContactMovementWallPlaneAlternatingArrowsIncreased.canSwitchPlane());

		assertFalse(fingerContactMovementFloorPlane.canSwitchPlane());
		assertFalse(fingerContactMovementFloorPlaneIncreasedI.canSwitchPlane());
		assertFalse(fingerContactMovementFloorPlaneIncreasedII.canSwitchPlane());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrows.canSwitchPlane());
		assertFalse(fingerContactMovementFloorPlaneAlternatingArrowsIncreased.canSwitchPlane());

	}

	@Override
	public void testSwitchPlane() {

	}

}
