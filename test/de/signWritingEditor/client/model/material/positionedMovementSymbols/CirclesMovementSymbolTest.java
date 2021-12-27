package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class CirclesMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	private PositionedMovementSymbol armCircleWallSmallSingle;
	private PositionedMovementSymbol armCircleWallSmallSingleEmptyArrowhead;
	private PositionedMovementSymbol armCircleWallSmallSingleSchemaArrowhead;
	private PositionedMovementSymbol armCircleWallSmallSingleMirrored;
	private PositionedMovementSymbol armCircleWallSmallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleWallSmallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleWallMediumSingle;
	private PositionedMovementSymbol armCircleWallMediumSingleEmptyArrowhead;
	private PositionedMovementSymbol armCircleWallMediumSingleSchemaArrowhead;
	private PositionedMovementSymbol armCircleWallMediumSingleMirrored;
	private PositionedMovementSymbol armCircleWallMediumSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleWallMediumSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleWallSmallDouble;
	private PositionedMovementSymbol armCircleWallSmallDoubleEmptyArrowhead;
	private PositionedMovementSymbol armCircleWallSmallDoubleSchemaArrowhead;
	private PositionedMovementSymbol armCircleWallSmallDoubleMirrored;
	private PositionedMovementSymbol armCircleWallSmallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleWallSmallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleWallMediumDouble;
	private PositionedMovementSymbol armCircleWallMediumDoubleEmptyArrowhead;
	private PositionedMovementSymbol armCircleWallMediumDoubleSchemaArrowhead;
	private PositionedMovementSymbol armCircleWallMediumDoubleMirrored;
	private PositionedMovementSymbol armCircleWallMediumDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleWallMediumDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallSmallSingle;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallMediumSingle;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallLargeSingle;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallSmallDouble;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallMediumDouble;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallLargeDouble;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBack;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBackMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored;
	private PositionedMovementSymbol armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored;

	private PositionedMovementSymbol wristCircleFrontWallSingle;
	private PositionedMovementSymbol wristCircleFrontWallSingleEmptyArrowhead;
	private PositionedMovementSymbol wristCircleFrontWallSingleSchemaArrowhead;
	private PositionedMovementSymbol wristCircleFrontWallSingleMirrored;
	private PositionedMovementSymbol wristCircleFrontWallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol wristCircleFrontWallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol wristCircleFrontWallDouble;
	private PositionedMovementSymbol wristCircleFrontWallDoubleEmptyArrowhead;
	private PositionedMovementSymbol wristCircleFrontWallDoubleSchemaArrowhead;
	private PositionedMovementSymbol wristCircleFrontWallDoubleMirrored;
	private PositionedMovementSymbol wristCircleFrontWallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol wristCircleFrontWallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol wristCircleHitsWallSingle;
	private PositionedMovementSymbol wristCircleHitsWallSingleEmptyArrowhead;
	private PositionedMovementSymbol wristCircleHitsWallSingleSchemaArrowhead;
	private PositionedMovementSymbol wristCircleHitsWallSingleMirrored;
	private PositionedMovementSymbol wristCircleHitsWallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol wristCircleHitsWallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol wristCircleHitsWallDouble;
	private PositionedMovementSymbol wristCircleHitsWallDoubleEmptyArrowhead;
	private PositionedMovementSymbol wristCircleHitsWallDoubleSchemaArrowhead;
	private PositionedMovementSymbol wristCircleHitsWallDoubleMirrored;
	private PositionedMovementSymbol wristCircleHitsWallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol wristCircleHitsWallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol fingerCirclesWallSingle;
	private PositionedMovementSymbol fingerCirclesWallSingleHalfCircle;
	private PositionedMovementSymbol fingerCirclesWallSingleMirrored;
	private PositionedMovementSymbol fingerCirclesWallSingleHalfCircleMirrored;

	private PositionedMovementSymbol fingerCirclesWallDouble;
	private PositionedMovementSymbol fingerCirclesWallDoubleHalfCircle;
	private PositionedMovementSymbol fingerCirclesWallDoubleMirrored;
	private PositionedMovementSymbol fingerCirclesWallDoubleHalfCircleMirrored;

	private PositionedMovementSymbol fingerCirclesHitsWallSingle;
	private PositionedMovementSymbol fingerCirclesHitsWallSingleHalfCircle;

	private PositionedMovementSymbol fingerCirclesHitsWallDouble;
	private PositionedMovementSymbol fingerCirclesHitsWallDoubleHalfCircle;

	private PositionedMovementSymbol arrowheadsSmall;
	private PositionedMovementSymbol arrowheadsSmallEmptyArrowhead;
	private PositionedMovementSymbol arrowheadsSmallSchemaArrowhead;

	private PositionedMovementSymbol arrowheadsLarge;
	private PositionedMovementSymbol arrowheadsLargeEmptyArrowhead;
	private PositionedMovementSymbol arrowheadsLargeSchemaArrowhead;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		armCircleWallSmallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleWallSmallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-001-01-02-01");
		armCircleWallSmallSingleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleWallSmallSingleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleWallSmallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-001-01-03-01");
		armCircleWallSmallSingleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleWallSmallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallSmallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallSingleMirroredSymbol = symbolFactory.createSymbol("02-10-001-01-01-09");
		armCircleWallSmallSingleMirrored = new PositionedMovementSymbol(armCircleWallSmallSingleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleWallSmallSingleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallSingleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-001-01-02-09");
		armCircleWallSmallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallSmallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallSmallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallSingleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-001-01-03-09");
		armCircleWallSmallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallSmallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallSmallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleWallMediumSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleWallMediumSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-001-02-02-01");
		armCircleWallMediumSingleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleWallMediumSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallMediumSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-001-02-03-01");
		armCircleWallMediumSingleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleWallMediumSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallMediumSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumSingleMirroredSymbol = symbolFactory.createSymbol("02-10-001-02-01-09");
		armCircleWallMediumSingleMirrored = new PositionedMovementSymbol(armCircleWallMediumSingleMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(armCircleWallMediumSingleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumSingleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-001-02-02-09");
		armCircleWallMediumSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallMediumSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallMediumSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-001-02-03-09");
		armCircleWallMediumSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallMediumSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallMediumSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleWallSmallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleWallSmallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-002-01-02-01");
		armCircleWallSmallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleWallSmallDoubleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleWallSmallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-002-01-03-01");
		armCircleWallSmallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleWallSmallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallSmallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-002-01-01-09");
		armCircleWallSmallDoubleMirrored = new PositionedMovementSymbol(armCircleWallSmallDoubleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleWallSmallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallDoubleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-002-01-02-09");
		armCircleWallSmallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallSmallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallSmallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallSmallDoubleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-002-01-03-09");
		armCircleWallSmallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallSmallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallSmallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleWallMediumDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleWallMediumDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-002-02-02-01");
		armCircleWallMediumDoubleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleWallMediumDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallMediumDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-002-02-03-01");
		armCircleWallMediumDoubleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleWallMediumDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleWallMediumDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-002-02-01-09");
		armCircleWallMediumDoubleMirrored = new PositionedMovementSymbol(armCircleWallMediumDoubleMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(armCircleWallMediumDoubleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumDoubleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-002-02-02-09");
		armCircleWallMediumDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallMediumDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallMediumDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleWallMediumDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-002-02-03-09");
		armCircleWallMediumDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleWallMediumDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleWallMediumDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallSmallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-003-01-02-01");
		armCircleHitsWallSmallSingleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-003-01-03-01");
		armCircleHitsWallSmallSingleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleMirroredSymbol = symbolFactory.createSymbol("02-10-003-01-01-09");
		armCircleHitsWallSmallSingleMirrored = new PositionedMovementSymbol(armCircleHitsWallSmallSingleMirroredSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallSmallSingleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-01-02-09");
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-01-03-09");
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallSmallSingleStartingBackSymbol = symbolFactory.createSymbol("02-10-003-01-04-01");
		armCircleHitsWallSmallSingleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallSingleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-01-05-01");
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-01-06-01");
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-01-04-09");
		armCircleHitsWallSmallSingleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-01-05-09");
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-01-06-09");
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallMediumSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-003-02-02-01");
		armCircleHitsWallMediumSingleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallMediumSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-003-02-03-01");
		armCircleHitsWallMediumSingleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleMirroredSymbol = symbolFactory.createSymbol("02-10-003-02-01-09");
		armCircleHitsWallMediumSingleMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallMediumSingleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-02-02-09");
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-02-03-09");
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallMediumSingleStartingBackSymbol = symbolFactory.createSymbol("02-10-003-02-04-01");
		armCircleHitsWallMediumSingleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallMediumSingleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-02-05-01");
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-02-06-01");
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-02-04-09");
		armCircleHitsWallMediumSingleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-02-05-09");
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-02-06-09");
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallLargeSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-003-03-02-01");
		armCircleHitsWallLargeSingleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-003-03-03-01");
		armCircleHitsWallLargeSingleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleMirroredSymbol = symbolFactory.createSymbol("02-10-003-03-01-09");
		armCircleHitsWallLargeSingleMirrored = new PositionedMovementSymbol(armCircleHitsWallLargeSingleMirroredSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallLargeSingleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-03-02-09");
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-03-03-09");
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallLargeSingleStartingBackSymbol = symbolFactory.createSymbol("02-10-003-03-04-01");
		armCircleHitsWallLargeSingleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeSingleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-03-05-01");
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-003-03-06-01");
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-03-04-09");
		armCircleHitsWallLargeSingleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-03-05-09");
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-003-03-06-09");
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallSmallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-004-01-02-01");
		armCircleHitsWallSmallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-004-01-03-01");
		armCircleHitsWallSmallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-004-01-01-09");
		armCircleHitsWallSmallDoubleMirrored = new PositionedMovementSymbol(armCircleHitsWallSmallDoubleMirroredSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallSmallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-01-02-09");
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-01-03-09");
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallSmallDoubleStartingBackSymbol = symbolFactory.createSymbol("02-10-004-01-04-01");
		armCircleHitsWallSmallDoubleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallSmallDoubleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-01-05-01");
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-01-06-01");
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-01-04-09");
		armCircleHitsWallSmallDoubleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-01-05-09");
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-01-06-09");
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallMediumDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_MEDIUM_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-004-02-02-01");
		armCircleHitsWallMediumDoubleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallMediumDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-004-02-03-01");
		armCircleHitsWallMediumDoubleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-004-02-01-09");
		armCircleHitsWallMediumDoubleMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallMediumDoubleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-02-02-09");
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-02-03-09");
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallMediumDoubleStartingBackSymbol = symbolFactory.createSymbol("02-10-004-02-04-01");
		armCircleHitsWallMediumDoubleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallMediumDoubleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-02-05-01");
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-02-06-01");
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-02-04-09");
		armCircleHitsWallMediumDoubleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-02-05-09");
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-02-06-09");
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		armCircleHitsWallLargeDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARM_CIRCLE_HITS_WALL_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-004-03-02-01");
		armCircleHitsWallLargeDoubleEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-004-03-03-01");
		armCircleHitsWallLargeDoubleSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-004-03-01-09");
		armCircleHitsWallLargeDoubleMirrored = new PositionedMovementSymbol(armCircleHitsWallLargeDoubleMirroredSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(armCircleHitsWallLargeDoubleMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-03-02-09");
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-03-03-09");
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol armCircleHitsWallLargeDoubleStartingBackSymbol = symbolFactory.createSymbol("02-10-004-03-04-01");
		armCircleHitsWallLargeDoubleStartingBack = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(armCircleHitsWallLargeDoubleStartingBackSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-03-05-01");
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-10-004-03-06-01");
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleStartingBackMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-03-04-09");
		armCircleHitsWallLargeDoubleStartingBackMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleStartingBackMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-03-05-09");
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-004-03-06-09");
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored = new PositionedMovementSymbol(
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		wristCircleFrontWallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol wristCircleFrontWallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-005-01-02-01");
		wristCircleFrontWallSingleEmptyArrowhead = new PositionedMovementSymbol(
				wristCircleFrontWallSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleFrontWallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-005-01-03-01");
		wristCircleFrontWallSingleSchemaArrowhead = new PositionedMovementSymbol(
				wristCircleFrontWallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleFrontWallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallSingleMirroredSymbol = symbolFactory.createSymbol("02-10-005-01-01-09");
		wristCircleFrontWallSingleMirrored = new PositionedMovementSymbol(wristCircleFrontWallSingleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(wristCircleFrontWallSingleMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-005-01-02-09");
		wristCircleFrontWallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleFrontWallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleFrontWallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-005-01-03-09");
		wristCircleFrontWallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleFrontWallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleFrontWallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		wristCircleFrontWallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WRIST_CIRCLE_FRONT_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol wristCircleFrontWallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-005-02-02-01");
		wristCircleFrontWallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				wristCircleFrontWallDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleFrontWallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-005-02-03-01");
		wristCircleFrontWallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				wristCircleFrontWallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleFrontWallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-005-02-01-09");
		wristCircleFrontWallDoubleMirrored = new PositionedMovementSymbol(wristCircleFrontWallDoubleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(wristCircleFrontWallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-005-02-02-09");
		wristCircleFrontWallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleFrontWallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleFrontWallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleFrontWallDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-005-02-03-09");
		wristCircleFrontWallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleFrontWallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleFrontWallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		wristCircleHitsWallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol wristCircleHitsWallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-006-01-02-01");
		wristCircleHitsWallSingleEmptyArrowhead = new PositionedMovementSymbol(
				wristCircleHitsWallSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleHitsWallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-006-01-03-01");
		wristCircleHitsWallSingleSchemaArrowhead = new PositionedMovementSymbol(
				wristCircleHitsWallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleHitsWallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallSingleMirroredSymbol = symbolFactory.createSymbol("02-10-006-01-01-02");
		wristCircleHitsWallSingleMirrored = new PositionedMovementSymbol(wristCircleHitsWallSingleMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(wristCircleHitsWallSingleMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallSingleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-006-01-02-02");
		wristCircleHitsWallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleHitsWallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-006-01-03-02");
		wristCircleHitsWallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleHitsWallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		wristCircleHitsWallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WRIST_CIRCLE_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol wristCircleHitsWallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-006-02-02-01");
		wristCircleHitsWallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleHitsWallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-006-02-03-01");
		wristCircleHitsWallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(wristCircleHitsWallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-006-02-01-02");
		wristCircleHitsWallDoubleMirrored = new PositionedMovementSymbol(wristCircleHitsWallDoubleMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(wristCircleHitsWallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallDoubleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-10-006-02-02-02");
		wristCircleHitsWallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol wristCircleHitsWallDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-10-006-02-03-02");
		wristCircleHitsWallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		fingerCirclesWallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CIRCLES_WALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol fingerCirclesWallSingleHalfCircleSymbol = symbolFactory.createSymbol("02-10-007-01-02-01");
		fingerCirclesWallSingleHalfCircle = new PositionedMovementSymbol(fingerCirclesWallSingleHalfCircleSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(fingerCirclesWallSingleHalfCircleSymbol.getBaseSymbol()));
		Symbol fingerCirclesWallSingleMirroredSymbol = symbolFactory.createSymbol("02-10-007-01-01-05");
		fingerCirclesWallSingleMirrored = new PositionedMovementSymbol(fingerCirclesWallSingleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(fingerCirclesWallSingleMirroredSymbol.getBaseSymbol()));
		Symbol fingerCirclesWallSingleHalfCircleMirroredSymbol = symbolFactory.createSymbol("02-10-007-01-02-05");
		fingerCirclesWallSingleHalfCircleMirrored = new PositionedMovementSymbol(
				fingerCirclesWallSingleHalfCircleMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerCirclesWallSingleHalfCircleMirroredSymbol.getBaseSymbol()));

		fingerCirclesWallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CIRCLES_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol fingerCirclesWallDoubleHalfCircleSymbol = symbolFactory.createSymbol("02-10-007-02-02-01");
		fingerCirclesWallDoubleHalfCircle = new PositionedMovementSymbol(fingerCirclesWallDoubleHalfCircleSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(fingerCirclesWallDoubleHalfCircleSymbol.getBaseSymbol()));
		Symbol fingerCirclesWallDoubleMirroredSymbol = symbolFactory.createSymbol("02-10-007-02-01-05");
		fingerCirclesWallDoubleMirrored = new PositionedMovementSymbol(fingerCirclesWallDoubleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(fingerCirclesWallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol fingerCirclesWallDoubleHalfCircleMirroredSymbol = symbolFactory.createSymbol("02-10-007-02-02-05");
		fingerCirclesWallDoubleHalfCircleMirrored = new PositionedMovementSymbol(
				fingerCirclesWallDoubleHalfCircleMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(fingerCirclesWallDoubleHalfCircleMirroredSymbol.getBaseSymbol()));

		fingerCirclesHitsWallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol fingerCirclesHitsWallSingleHalfCircleSymbol = symbolFactory.createSymbol("02-10-007-03-02-01");
		fingerCirclesHitsWallSingleHalfCircle = new PositionedMovementSymbol(
				fingerCirclesHitsWallSingleHalfCircleSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(fingerCirclesHitsWallSingleHalfCircleSymbol.getBaseSymbol()));

		fingerCirclesHitsWallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.FINGER_CIRCLES_HITS_WALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol fingerCirclesHitsWallDoubleHalfCircleSymbol = symbolFactory.createSymbol("02-10-007-04-02-01");
		fingerCirclesHitsWallDoubleHalfCircle = new PositionedMovementSymbol(
				fingerCirclesHitsWallDoubleHalfCircleSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(fingerCirclesHitsWallDoubleHalfCircleSymbol.getBaseSymbol()));

		arrowheadsSmall = new PositionedMovementSymbol(MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARROWHEADS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol arrowheadsSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-008-01-02-01");
		arrowheadsSmallEmptyArrowhead = new PositionedMovementSymbol(arrowheadsSmallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(arrowheadsSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol arrowheadsSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-008-01-03-01");
		arrowheadsSmallSchemaArrowhead = new PositionedMovementSymbol(arrowheadsSmallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(arrowheadsSmallSchemaArrowheadSymbol.getBaseSymbol()));

		arrowheadsLarge = new PositionedMovementSymbol(MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ARROWHEADS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol arrowheadsLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-10-008-02-02-01");
		arrowheadsLargeEmptyArrowhead = new PositionedMovementSymbol(arrowheadsLargeEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(arrowheadsLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol arrowheadsLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-10-008-02-03-01");
		arrowheadsLargeSchemaArrowhead = new PositionedMovementSymbol(arrowheadsLargeSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(arrowheadsLargeSchemaArrowheadSymbol.getBaseSymbol()));

	}

	@Override
	public void testCanIncrease() {

		assertTrue(armCircleWallSmallSingle.canIncrease());
		assertTrue(armCircleWallSmallSingleEmptyArrowhead.canIncrease());
		assertTrue(armCircleWallSmallSingleSchemaArrowhead.canIncrease());
		assertTrue(armCircleWallSmallSingleMirrored.canIncrease());
		assertTrue(armCircleWallSmallSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleWallSmallSingleSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleWallMediumSingle.canIncrease());
		assertTrue(armCircleWallMediumSingleEmptyArrowhead.canIncrease());
		assertTrue(armCircleWallMediumSingleSchemaArrowhead.canIncrease());
		assertTrue(armCircleWallMediumSingleMirrored.canIncrease());
		assertTrue(armCircleWallMediumSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleWallMediumSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleWallSmallDouble.canIncrease());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canIncrease());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canIncrease());
		assertFalse(armCircleWallSmallDoubleMirrored.canIncrease());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleWallMediumDouble.canIncrease());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canIncrease());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canIncrease());
		assertFalse(armCircleWallMediumDoubleMirrored.canIncrease());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallSmallSingle.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallMediumSingle.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallLargeSingle.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canIncrease());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallSmallDouble.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallMediumDouble.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallLargeDouble.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canIncrease());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canIncrease());

		assertTrue(wristCircleFrontWallSingle.canIncrease());
		assertTrue(wristCircleFrontWallSingleEmptyArrowhead.canIncrease());
		assertTrue(wristCircleFrontWallSingleSchemaArrowhead.canIncrease());
		assertTrue(wristCircleFrontWallSingleMirrored.canIncrease());
		assertTrue(wristCircleFrontWallSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(wristCircleFrontWallSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(wristCircleFrontWallDouble.canIncrease());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canIncrease());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canIncrease());
		assertFalse(wristCircleFrontWallDoubleMirrored.canIncrease());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canIncrease());

		assertTrue(wristCircleHitsWallSingle.canIncrease());
		assertTrue(wristCircleHitsWallSingleEmptyArrowhead.canIncrease());
		assertTrue(wristCircleHitsWallSingleSchemaArrowhead.canIncrease());
		assertTrue(wristCircleHitsWallSingleMirrored.canIncrease());
		assertTrue(wristCircleHitsWallSingleEmptyArrowheadMirrored.canIncrease());
		assertTrue(wristCircleHitsWallSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(wristCircleHitsWallDouble.canIncrease());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canIncrease());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canIncrease());
		assertFalse(wristCircleHitsWallDoubleMirrored.canIncrease());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canIncrease());

		assertTrue(fingerCirclesWallSingle.canIncrease());
		assertTrue(fingerCirclesWallSingleHalfCircle.canIncrease());
		assertTrue(fingerCirclesWallSingleMirrored.canIncrease());
		assertTrue(fingerCirclesWallSingleHalfCircleMirrored.canIncrease());

		assertFalse(fingerCirclesWallDouble.canIncrease());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canIncrease());
		assertFalse(fingerCirclesWallDoubleMirrored.canIncrease());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canIncrease());

		assertTrue(fingerCirclesHitsWallSingle.canIncrease());
		assertTrue(fingerCirclesHitsWallSingleHalfCircle.canIncrease());

		assertFalse(fingerCirclesHitsWallDouble.canIncrease());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canIncrease());

		assertFalse(arrowheadsSmall.canIncrease());
		assertFalse(arrowheadsSmallEmptyArrowhead.canIncrease());
		assertFalse(arrowheadsSmallSchemaArrowhead.canIncrease());

		assertFalse(arrowheadsLarge.canIncrease());
		assertFalse(arrowheadsLargeEmptyArrowhead.canIncrease());
		assertFalse(arrowheadsLargeSchemaArrowhead.canIncrease());

	}

	@Override
	public void testIncrease() {

		armCircleWallSmallSingle.increase();
		assertEquals(armCircleWallSmallDouble.getSymbol(), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.increase();
		assertEquals(armCircleWallSmallDoubleEmptyArrowhead.getSymbol(),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.increase();
		assertEquals(armCircleWallSmallDoubleSchemaArrowhead.getSymbol(),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleMirrored.increase();
		assertEquals(armCircleWallSmallDoubleMirrored.getSymbol(), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.increase();
		assertEquals(armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol(),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.increase();
		assertEquals(armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol(),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumSingle.increase();
		assertEquals(armCircleWallMediumDouble.getSymbol(), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.increase();
		assertEquals(armCircleWallMediumDoubleEmptyArrowhead.getSymbol(),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.increase();
		assertEquals(armCircleWallMediumDoubleSchemaArrowhead.getSymbol(),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleMirrored.increase();
		assertEquals(armCircleWallMediumDoubleMirrored.getSymbol(), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.increase();
		assertEquals(armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol(),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.increase();
		assertEquals(armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol(),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingle.increase();
		assertEquals(armCircleHitsWallSmallDouble.getSymbol(), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol(),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol(),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleMirrored.getSymbol(),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBack.getSymbol(),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol(),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.increase();
		assertEquals(armCircleHitsWallMediumDouble.getSymbol(), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol(),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol(),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleMirrored.getSymbol(),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBack.getSymbol(),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol(),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.increase();
		assertEquals(armCircleHitsWallLargeDouble.getSymbol(), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol(),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol(),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleMirrored.getSymbol(),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBack.getSymbol(),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol(),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.increase();
		assertEquals(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingle.increase();
		assertEquals(wristCircleFrontWallDouble.getSymbol(), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.increase();
		assertEquals(wristCircleFrontWallDoubleEmptyArrowhead.getSymbol(),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.increase();
		assertEquals(wristCircleFrontWallDoubleSchemaArrowhead.getSymbol(),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleMirrored.increase();
		assertEquals(wristCircleFrontWallDoubleMirrored.getSymbol(), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.increase();
		assertEquals(wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol(),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.increase();
		assertEquals(wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol(),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingle.increase();
		assertEquals(wristCircleHitsWallDouble.getSymbol(), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.increase();
		assertEquals(wristCircleHitsWallDoubleEmptyArrowhead.getSymbol(),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.increase();
		assertEquals(wristCircleHitsWallDoubleSchemaArrowhead.getSymbol(),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleMirrored.increase();
		assertEquals(wristCircleHitsWallDoubleMirrored.getSymbol(), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.increase();
		assertEquals(wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol(),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.increase();
		assertEquals(wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol(),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());

		fingerCirclesWallSingle.increase();
		assertEquals(fingerCirclesWallDouble.getSymbol(), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingleHalfCircle.increase();
		assertEquals(fingerCirclesWallDoubleHalfCircle.getSymbol(), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleMirrored.increase();
		assertEquals(fingerCirclesWallDoubleMirrored.getSymbol(), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.increase();
		assertEquals(fingerCirclesWallDoubleHalfCircleMirrored.getSymbol(),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());

		fingerCirclesHitsWallSingle.increase();
		assertEquals(fingerCirclesHitsWallDouble.getSymbol(), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.increase();
		assertEquals(fingerCirclesHitsWallDoubleHalfCircle.getSymbol(),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());

	}

	@Override
	public void testCanDecrease() {

		assertFalse(armCircleWallSmallSingle.canDecrease());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canDecrease());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canDecrease());
		assertFalse(armCircleWallSmallSingleMirrored.canDecrease());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleWallMediumSingle.canDecrease());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canDecrease());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canDecrease());
		assertFalse(armCircleWallMediumSingleMirrored.canDecrease());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleWallSmallDouble.canDecrease());
		assertTrue(armCircleWallSmallDoubleEmptyArrowhead.canDecrease());
		assertTrue(armCircleWallSmallDoubleSchemaArrowhead.canDecrease());
		assertTrue(armCircleWallSmallDoubleMirrored.canDecrease());
		assertTrue(armCircleWallSmallDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleWallSmallDoubleSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleWallMediumDouble.canDecrease());
		assertTrue(armCircleWallMediumDoubleEmptyArrowhead.canDecrease());
		assertTrue(armCircleWallMediumDoubleSchemaArrowhead.canDecrease());
		assertTrue(armCircleWallMediumDoubleMirrored.canDecrease());
		assertTrue(armCircleWallMediumDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleWallMediumDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallSmallSingle.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallMediumSingle.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallLargeSingle.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallSmallDouble.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallMediumDouble.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallLargeDouble.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canDecrease());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canDecrease());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canDecrease());

		assertFalse(wristCircleFrontWallSingle.canDecrease());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canDecrease());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canDecrease());
		assertFalse(wristCircleFrontWallSingleMirrored.canDecrease());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canDecrease());

		assertTrue(wristCircleFrontWallDouble.canDecrease());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowhead.canDecrease());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowhead.canDecrease());
		assertTrue(wristCircleFrontWallDoubleMirrored.canDecrease());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(wristCircleHitsWallSingle.canDecrease());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canDecrease());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canDecrease());
		assertFalse(wristCircleHitsWallSingleMirrored.canDecrease());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canDecrease());

		assertTrue(wristCircleHitsWallDouble.canDecrease());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowhead.canDecrease());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowhead.canDecrease());
		assertTrue(wristCircleHitsWallDoubleMirrored.canDecrease());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canDecrease());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(fingerCirclesWallSingle.canDecrease());
		assertFalse(fingerCirclesWallSingleHalfCircle.canDecrease());
		assertFalse(fingerCirclesWallSingleMirrored.canDecrease());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canDecrease());

		assertTrue(fingerCirclesWallDouble.canDecrease());
		assertTrue(fingerCirclesWallDoubleHalfCircle.canDecrease());
		assertTrue(fingerCirclesWallDoubleMirrored.canDecrease());
		assertTrue(fingerCirclesWallDoubleHalfCircleMirrored.canDecrease());

		assertFalse(fingerCirclesHitsWallSingle.canDecrease());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canDecrease());

		assertTrue(fingerCirclesHitsWallDouble.canDecrease());
		assertTrue(fingerCirclesHitsWallDoubleHalfCircle.canDecrease());

		assertFalse(arrowheadsSmall.canDecrease());
		assertFalse(arrowheadsSmallEmptyArrowhead.canDecrease());
		assertFalse(arrowheadsSmallSchemaArrowhead.canDecrease());

		assertFalse(arrowheadsLarge.canDecrease());
		assertFalse(arrowheadsLargeEmptyArrowhead.canDecrease());
		assertFalse(arrowheadsLargeSchemaArrowhead.canDecrease());

	}

	@Override
	public void testDecrease() {

		armCircleWallSmallDouble.decrease();
		assertEquals(armCircleWallSmallSingle.getSymbol(), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.decrease();
		assertEquals(armCircleWallSmallSingleEmptyArrowhead.getSymbol(),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.decrease();
		assertEquals(armCircleWallSmallSingleSchemaArrowhead.getSymbol(),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleMirrored.decrease();
		assertEquals(armCircleWallSmallSingleMirrored.getSymbol(), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol(),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol(),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumDouble.decrease();
		assertEquals(armCircleWallMediumSingle.getSymbol(), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.decrease();
		assertEquals(armCircleWallMediumSingleEmptyArrowhead.getSymbol(),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.decrease();
		assertEquals(armCircleWallMediumSingleSchemaArrowhead.getSymbol(),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleMirrored.decrease();
		assertEquals(armCircleWallMediumSingleMirrored.getSymbol(), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol(),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol(),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.decrease();
		assertEquals(armCircleHitsWallSmallSingle.getSymbol(), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol(),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol(),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBack.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.decrease();
		assertEquals(armCircleHitsWallMediumSingle.getSymbol(), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol(),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol(),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBack.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.decrease();
		assertEquals(armCircleHitsWallLargeSingle.getSymbol(), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol(),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol(),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBack.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.decrease();
		assertEquals(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol(),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallDouble.decrease();
		assertEquals(wristCircleFrontWallSingle.getSymbol(), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.decrease();
		assertEquals(wristCircleFrontWallSingleEmptyArrowhead.getSymbol(),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.decrease();
		assertEquals(wristCircleFrontWallSingleSchemaArrowhead.getSymbol(),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleMirrored.decrease();
		assertEquals(wristCircleFrontWallSingleMirrored.getSymbol(), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol(),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol(),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallDouble.decrease();
		assertEquals(wristCircleHitsWallSingle.getSymbol(), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.decrease();
		assertEquals(wristCircleHitsWallSingleEmptyArrowhead.getSymbol(),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.decrease();
		assertEquals(wristCircleHitsWallSingleSchemaArrowhead.getSymbol(),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleMirrored.decrease();
		assertEquals(wristCircleHitsWallSingleMirrored.getSymbol(), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.decrease();
		assertEquals(wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol(),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.decrease();
		assertEquals(wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol(),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());

		fingerCirclesWallDouble.decrease();
		assertEquals(fingerCirclesWallSingle.getSymbol(), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDoubleHalfCircle.decrease();
		assertEquals(fingerCirclesWallSingleHalfCircle.getSymbol(), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleMirrored.decrease();
		assertEquals(fingerCirclesWallSingleMirrored.getSymbol(), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.decrease();
		assertEquals(fingerCirclesWallSingleHalfCircleMirrored.getSymbol(),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());

		fingerCirclesHitsWallDouble.decrease();
		assertEquals(fingerCirclesHitsWallSingle.getSymbol(), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.decrease();
		assertEquals(fingerCirclesHitsWallSingleHalfCircle.getSymbol(),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertTrue(armCircleWallSmallSingle.canRotate());
		assertTrue(armCircleWallSmallSingleEmptyArrowhead.canRotate());
		assertTrue(armCircleWallSmallSingleSchemaArrowhead.canRotate());
		assertTrue(armCircleWallSmallSingleMirrored.canRotate());
		assertTrue(armCircleWallSmallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleWallSmallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleWallMediumSingle.canRotate());
		assertTrue(armCircleWallMediumSingleEmptyArrowhead.canRotate());
		assertTrue(armCircleWallMediumSingleSchemaArrowhead.canRotate());
		assertTrue(armCircleWallMediumSingleMirrored.canRotate());
		assertTrue(armCircleWallMediumSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleWallMediumSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleWallSmallDouble.canRotate());
		assertTrue(armCircleWallSmallDoubleEmptyArrowhead.canRotate());
		assertTrue(armCircleWallSmallDoubleSchemaArrowhead.canRotate());
		assertTrue(armCircleWallSmallDoubleMirrored.canRotate());
		assertTrue(armCircleWallSmallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleWallSmallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleWallMediumDouble.canRotate());
		assertTrue(armCircleWallMediumDoubleEmptyArrowhead.canRotate());
		assertTrue(armCircleWallMediumDoubleSchemaArrowhead.canRotate());
		assertTrue(armCircleWallMediumDoubleMirrored.canRotate());
		assertTrue(armCircleWallMediumDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleWallMediumDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallSmallSingle.canRotate());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canRotate());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallMediumSingle.canRotate());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canRotate());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallLargeSingle.canRotate());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canRotate());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallSmallDouble.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallMediumDouble.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallLargeDouble.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canRotate());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canRotate());

		assertTrue(wristCircleFrontWallSingle.canRotate());
		assertTrue(wristCircleFrontWallSingleEmptyArrowhead.canRotate());
		assertTrue(wristCircleFrontWallSingleSchemaArrowhead.canRotate());
		assertTrue(wristCircleFrontWallSingleMirrored.canRotate());
		assertTrue(wristCircleFrontWallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(wristCircleFrontWallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(wristCircleFrontWallDouble.canRotate());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowhead.canRotate());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowhead.canRotate());
		assertTrue(wristCircleFrontWallDoubleMirrored.canRotate());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(wristCircleHitsWallSingle.canRotate());
		assertTrue(wristCircleHitsWallSingleEmptyArrowhead.canRotate());
		assertTrue(wristCircleHitsWallSingleSchemaArrowhead.canRotate());
		assertTrue(wristCircleHitsWallSingleMirrored.canRotate());
		assertTrue(wristCircleHitsWallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(wristCircleHitsWallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(wristCircleHitsWallDouble.canRotate());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowhead.canRotate());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowhead.canRotate());
		assertTrue(wristCircleHitsWallDoubleMirrored.canRotate());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(fingerCirclesWallSingle.canRotate());
		assertTrue(fingerCirclesWallSingleHalfCircle.canRotate());
		assertTrue(fingerCirclesWallSingleMirrored.canRotate());
		assertTrue(fingerCirclesWallSingleHalfCircleMirrored.canRotate());

		assertTrue(fingerCirclesWallDouble.canRotate());
		assertTrue(fingerCirclesWallDoubleHalfCircle.canRotate());
		assertTrue(fingerCirclesWallDoubleMirrored.canRotate());
		assertTrue(fingerCirclesWallDoubleHalfCircleMirrored.canRotate());

		assertTrue(fingerCirclesHitsWallSingle.canRotate());
		assertTrue(fingerCirclesHitsWallSingleHalfCircle.canRotate());

		assertTrue(fingerCirclesHitsWallDouble.canRotate());
		assertTrue(fingerCirclesHitsWallDoubleHalfCircle.canRotate());

		assertTrue(arrowheadsSmall.canRotate());
		assertTrue(arrowheadsSmallEmptyArrowhead.canRotate());
		assertTrue(arrowheadsSmallSchemaArrowhead.canRotate());

		assertTrue(arrowheadsLarge.canRotate());
		assertTrue(arrowheadsLargeEmptyArrowhead.canRotate());
		assertTrue(arrowheadsLargeSchemaArrowhead.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-08"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-07"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-06"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-05"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-04"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-03"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-02"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"), armCircleWallSmallSingle.getSymbol());

		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-08"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-07"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-06"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-05"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-04"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-03"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-02"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-08"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-07"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-06"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-05"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-04"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-03"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-02"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-10"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-11"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-12"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-13"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-14"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-15"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-16"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"), armCircleWallSmallSingleMirrored.getSymbol());

		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-10"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-11"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-12"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-13"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-14"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-15"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-16"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-10"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-11"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-12"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-13"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-14"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-15"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-16"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-08"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-07"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-06"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-05"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-04"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-03"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-02"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"), armCircleWallMediumSingle.getSymbol());

		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-08"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-07"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-06"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-05"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-04"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-03"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-02"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-08"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-07"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-06"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-05"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-04"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-03"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-02"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-10"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-11"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-12"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-13"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-14"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-15"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-16"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"), armCircleWallMediumSingleMirrored.getSymbol());

		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-10"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-11"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-12"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-13"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-14"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-15"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-16"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-10"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-11"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-12"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-13"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-14"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-15"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-16"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-08"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-07"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-06"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-05"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-04"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-03"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-02"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"), armCircleWallSmallDouble.getSymbol());

		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-08"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-07"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-06"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-05"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-04"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-03"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-02"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-08"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-07"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-06"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-05"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-04"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-03"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-02"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-10"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-11"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-12"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-13"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-14"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-15"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-16"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"), armCircleWallSmallDoubleMirrored.getSymbol());

		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-10"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-11"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-12"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-13"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-14"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-15"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-16"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-10"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-11"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-12"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-13"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-14"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-15"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-16"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-08"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-07"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-06"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-05"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-04"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-03"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-02"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"), armCircleWallMediumDouble.getSymbol());

		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-08"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-07"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-06"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-05"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-04"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-03"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-02"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-08"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-07"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-06"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-05"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-04"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-03"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-02"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-10"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-11"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-12"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-13"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-14"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-15"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-16"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"), armCircleWallMediumDoubleMirrored.getSymbol());

		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-10"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-11"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-12"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-13"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-14"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-15"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-16"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-10"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-11"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-12"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-13"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-14"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-15"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-16"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-08"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-07"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-06"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-05"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-04"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-03"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-02"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"), armCircleHitsWallSmallSingle.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-08"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-07"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-06"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-05"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-04"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-03"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-02"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-08"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-07"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-06"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-05"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-04"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-03"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-02"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-10"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-11"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-12"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-13"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-14"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-15"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-16"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-10"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-11"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-12"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-13"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-14"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-15"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-16"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-10"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-11"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-12"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-13"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-14"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-15"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-16"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-08"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-07"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-06"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-05"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-04"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-03"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-02"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-08"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-07"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-06"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-05"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-04"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-03"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-02"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-08"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-07"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-06"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-05"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-04"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-03"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-02"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-10"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-11"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-12"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-13"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-14"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-15"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-16"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-10"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-11"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-12"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-13"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-14"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-15"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-16"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-10"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-11"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-12"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-13"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-14"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-15"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-16"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-08"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-07"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-06"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-05"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-04"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-03"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-02"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"), armCircleHitsWallMediumSingle.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-08"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-07"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-06"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-05"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-04"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-03"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-02"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-08"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-07"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-06"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-05"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-04"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-03"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-02"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-10"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-11"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-12"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-13"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-14"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-15"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-16"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-10"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-11"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-12"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-13"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-14"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-15"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-16"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-10"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-11"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-12"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-13"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-14"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-15"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-16"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-08"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-07"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-06"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-05"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-04"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-03"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-02"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-08"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-07"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-06"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-05"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-04"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-03"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-02"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-08"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-07"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-06"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-05"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-04"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-03"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-02"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-10"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-11"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-12"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-13"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-14"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-15"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-16"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-10"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-11"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-12"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-13"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-14"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-15"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-16"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-10"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-11"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-12"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-13"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-14"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-15"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-16"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-08"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-07"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-06"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-05"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-04"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-03"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-02"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"), armCircleHitsWallLargeSingle.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-08"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-07"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-06"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-05"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-04"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-03"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-02"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-08"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-07"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-06"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-05"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-04"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-03"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-02"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-10"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-11"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-12"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-13"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-14"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-15"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-16"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-10"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-11"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-12"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-13"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-14"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-15"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-16"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-10"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-11"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-12"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-13"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-14"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-15"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-16"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-08"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-07"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-06"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-05"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-04"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-03"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-02"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-08"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-07"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-06"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-05"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-04"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-03"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-02"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-08"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-07"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-06"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-05"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-04"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-03"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-02"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-10"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-11"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-12"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-13"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-14"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-15"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-16"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-10"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-11"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-12"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-13"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-14"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-15"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-16"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-10"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-11"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-12"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-13"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-14"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-15"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-16"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-08"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-07"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-06"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-05"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-04"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-03"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-02"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"), armCircleHitsWallSmallDouble.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-08"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-07"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-06"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-05"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-04"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-03"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-02"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-08"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-07"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-06"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-05"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-04"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-03"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-02"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-10"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-11"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-12"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-13"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-14"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-15"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-16"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-10"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-11"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-12"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-13"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-14"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-15"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-16"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-10"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-11"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-12"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-13"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-14"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-15"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-16"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-08"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-07"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-06"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-05"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-04"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-03"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-02"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-08"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-07"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-06"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-05"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-04"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-03"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-02"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-08"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-07"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-06"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-05"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-04"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-03"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-02"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-10"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-11"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-12"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-13"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-14"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-15"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-16"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-10"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-11"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-12"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-13"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-14"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-15"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-16"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-10"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-11"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-12"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-13"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-14"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-15"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-16"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-08"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-07"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-06"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-05"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-04"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-03"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-02"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"), armCircleHitsWallMediumDouble.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-08"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-07"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-06"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-05"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-04"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-03"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-02"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-08"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-07"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-06"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-05"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-04"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-03"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-02"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-10"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-11"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-12"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-13"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-14"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-15"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-16"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-10"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-11"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-12"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-13"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-14"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-15"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-16"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-10"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-11"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-12"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-13"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-14"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-15"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-16"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-08"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-07"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-06"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-05"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-04"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-03"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-02"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-08"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-07"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-06"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-05"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-04"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-03"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-02"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-08"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-07"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-06"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-05"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-04"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-03"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-02"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-10"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-11"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-12"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-13"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-14"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-15"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-16"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-10"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-11"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-12"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-13"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-14"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-15"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-16"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-10"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-11"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-12"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-13"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-14"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-15"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-16"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-08"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-07"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-06"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-05"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-04"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-03"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-02"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"), armCircleHitsWallLargeDouble.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-08"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-07"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-06"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-05"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-04"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-03"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-02"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-08"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-07"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-06"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-05"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-04"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-03"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-02"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-10"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-11"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-12"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-13"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-14"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-15"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-16"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-10"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-11"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-12"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-13"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-14"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-15"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-16"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-10"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-11"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-12"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-13"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-14"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-15"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-16"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-08"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-07"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-06"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-05"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-04"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-03"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-02"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-08"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-07"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-06"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-05"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-04"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-03"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-02"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-08"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-07"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-06"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-05"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-04"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-03"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-02"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-10"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-11"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-12"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-13"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-14"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-15"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-16"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-10"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-11"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-12"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-13"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-14"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-15"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-16"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-10"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-11"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-12"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-13"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-14"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-15"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-16"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-08"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-07"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-06"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-05"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-04"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-03"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-02"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"), wristCircleFrontWallSingle.getSymbol());

		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-08"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-07"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-06"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-05"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-04"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-03"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-02"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());

		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-08"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-07"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-06"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-05"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-04"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-03"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-02"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());

		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-10"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-11"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-12"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-13"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-14"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-15"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-16"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"), wristCircleFrontWallSingleMirrored.getSymbol());

		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-10"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-11"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-12"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-13"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-14"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-15"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-16"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-10"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-11"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-12"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-13"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-14"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-15"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-16"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-08"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-07"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-06"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-05"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-04"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-03"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-02"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"), wristCircleFrontWallDouble.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-08"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-07"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-06"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-05"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-04"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-03"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-02"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-08"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-07"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-06"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-05"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-04"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-03"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-02"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());

		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-10"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-11"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-12"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-13"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-14"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-15"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-16"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"), wristCircleFrontWallDoubleMirrored.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-10"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-11"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-12"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-13"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-14"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-15"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-16"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-10"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-11"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-12"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-13"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-14"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-15"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-16"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-06"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-05"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-04"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-03"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateClockwise();

		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-06"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-05"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-04"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-03"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());

		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-06"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-05"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-04"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-03"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());

		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-06"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-05"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-04"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-03"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingleMirrored.getSymbol());

		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-06"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-05"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-04"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-03"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-06"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-05"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-04"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-03"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-06"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-05"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-04"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-03"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateClockwise();

		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-06"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-05"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-04"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-03"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-06"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-05"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-04"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-03"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());

		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-06"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-05"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-04"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-03"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDoubleMirrored.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-06"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-05"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-04"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-03"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-06"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-05"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-04"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-03"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());

		fingerCirclesWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-04"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-03"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-02"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-01"), fingerCirclesWallSingle.getSymbol());

		fingerCirclesWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-04"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-03"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-02"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-01"), fingerCirclesWallSingleHalfCircle.getSymbol());

		fingerCirclesWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-06"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-07"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-08"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-05"), fingerCirclesWallSingleMirrored.getSymbol());

		fingerCirclesWallSingleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-06"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-07"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-08"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-05"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());

		fingerCirclesWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-04"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-03"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-02"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-01"), fingerCirclesWallDouble.getSymbol());

		fingerCirclesWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-04"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-03"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-02"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-01"), fingerCirclesWallDoubleHalfCircle.getSymbol());

		fingerCirclesWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-06"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-07"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-08"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-05"), fingerCirclesWallDoubleMirrored.getSymbol());

		fingerCirclesWallDoubleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-06"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-07"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-08"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-05"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());

		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-08"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-07"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-06"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-05"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-04"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-03"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-02"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-01"), fingerCirclesHitsWallSingle.getSymbol());

		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-08"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-07"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-06"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-05"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-04"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-03"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-02"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-01"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());

		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-08"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-07"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-06"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-05"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-04"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-03"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-02"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-01"), fingerCirclesHitsWallDouble.getSymbol());

		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-08"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-07"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-06"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-05"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-04"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-03"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-02"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-01"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());

		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-08"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-07"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-06"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-05"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-04"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-03"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-02"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmall.getSymbol());

		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-08"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-07"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-06"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-05"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-04"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-03"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-02"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmallEmptyArrowhead.getSymbol());

		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-08"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-07"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-06"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-05"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-04"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-03"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-02"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmallSchemaArrowhead.getSymbol());

		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-08"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-07"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-06"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-05"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-04"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-03"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-02"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLarge.getSymbol());

		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-08"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-07"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-06"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-05"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-04"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-03"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-02"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLargeEmptyArrowhead.getSymbol());

		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-08"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-07"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-06"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-05"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-04"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-03"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-02"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLargeSchemaArrowhead.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-02"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-03"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-04"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-05"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-06"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-07"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-08"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"), armCircleWallSmallSingle.getSymbol());

		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-02"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-03"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-04"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-05"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-06"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-07"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-08"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-02"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-03"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-04"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-05"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-06"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-07"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-08"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-16"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-15"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-14"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-13"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-12"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-11"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-10"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"), armCircleWallSmallSingleMirrored.getSymbol());

		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-16"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-15"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-14"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-13"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-12"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-11"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-10"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-16"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-15"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-14"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-13"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-12"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-11"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-10"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-02"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-03"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-04"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-05"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-06"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-07"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-08"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"), armCircleWallMediumSingle.getSymbol());

		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-02"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-03"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-04"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-05"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-06"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-07"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-08"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-02"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-03"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-04"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-05"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-06"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-07"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-08"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-16"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-15"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-14"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-13"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-12"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-11"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-10"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"), armCircleWallMediumSingleMirrored.getSymbol());

		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-16"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-15"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-14"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-13"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-12"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-11"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-10"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-16"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-15"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-14"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-13"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-12"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-11"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-10"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-02"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-03"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-04"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-05"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-06"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-07"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-08"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"), armCircleWallSmallDouble.getSymbol());

		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-02"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-03"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-04"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-05"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-06"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-07"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-08"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-02"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-03"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-04"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-05"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-06"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-07"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-08"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-16"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-15"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-14"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-13"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-12"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-11"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-10"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"), armCircleWallSmallDoubleMirrored.getSymbol());

		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-16"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-15"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-14"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-13"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-12"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-11"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-10"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-16"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-15"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-14"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-13"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-12"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-11"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-10"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-02"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-03"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-04"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-05"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-06"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-07"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-08"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"), armCircleWallMediumDouble.getSymbol());

		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-02"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-03"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-04"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-05"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-06"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-07"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-08"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-02"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-03"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-04"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-05"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-06"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-07"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-08"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-16"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-15"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-14"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-13"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-12"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-11"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-10"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"), armCircleWallMediumDoubleMirrored.getSymbol());

		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-16"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-15"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-14"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-13"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-12"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-11"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-10"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-16"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-15"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-14"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-13"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-12"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-11"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-10"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-02"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-03"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-04"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-05"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-06"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-07"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-08"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"), armCircleHitsWallSmallSingle.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-02"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-03"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-04"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-05"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-06"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-07"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-08"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-02"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-03"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-04"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-05"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-06"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-07"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-08"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-16"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-15"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-14"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-13"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-12"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-11"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-10"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-16"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-15"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-14"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-13"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-12"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-11"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-10"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-16"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-15"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-14"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-13"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-12"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-11"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-10"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-02"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-03"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-04"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-05"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-06"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-07"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-08"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-02"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-03"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-04"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-05"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-06"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-07"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-08"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-02"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-03"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-04"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-05"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-06"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-07"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-08"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-16"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-15"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-14"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-13"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-12"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-11"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-10"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-16"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-15"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-14"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-13"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-12"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-11"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-10"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-16"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-15"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-14"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-13"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-12"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-11"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-10"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-02"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-03"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-04"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-05"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-06"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-07"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-08"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"), armCircleHitsWallMediumSingle.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-02"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-03"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-04"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-05"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-06"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-07"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-08"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-02"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-03"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-04"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-05"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-06"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-07"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-08"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-16"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-15"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-14"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-13"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-12"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-11"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-10"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-16"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-15"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-14"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-13"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-12"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-11"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-10"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-16"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-15"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-14"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-13"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-12"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-11"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-10"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-02"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-03"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-04"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-05"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-06"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-07"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-08"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-02"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-03"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-04"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-05"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-06"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-07"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-08"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-02"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-03"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-04"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-05"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-06"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-07"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-08"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-16"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-15"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-14"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-13"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-12"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-11"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-10"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-16"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-15"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-14"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-13"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-12"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-11"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-10"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-16"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-15"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-14"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-13"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-12"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-11"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-10"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-02"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-03"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-04"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-05"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-06"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-07"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-08"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"), armCircleHitsWallLargeSingle.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-02"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-03"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-04"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-05"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-06"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-07"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-08"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-02"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-03"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-04"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-05"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-06"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-07"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-08"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-16"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-15"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-14"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-13"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-12"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-11"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-10"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-16"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-15"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-14"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-13"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-12"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-11"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-10"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-16"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-15"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-14"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-13"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-12"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-11"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-10"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-02"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-03"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-04"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-05"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-06"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-07"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-08"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-02"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-03"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-04"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-05"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-06"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-07"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-08"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-02"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-03"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-04"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-05"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-06"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-07"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-08"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-16"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-15"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-14"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-13"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-12"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-11"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-10"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-16"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-15"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-14"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-13"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-12"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-11"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-10"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-16"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-15"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-14"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-13"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-12"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-11"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-10"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-02"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-03"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-04"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-05"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-06"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-07"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-08"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"), armCircleHitsWallSmallDouble.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-02"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-03"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-04"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-05"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-06"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-07"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-08"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-02"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-03"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-04"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-05"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-06"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-07"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-08"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-16"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-15"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-14"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-13"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-12"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-11"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-10"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-16"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-15"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-14"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-13"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-12"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-11"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-10"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-16"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-15"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-14"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-13"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-12"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-11"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-10"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-02"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-03"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-04"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-05"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-06"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-07"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-08"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-02"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-03"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-04"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-05"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-06"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-07"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-08"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-02"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-03"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-04"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-05"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-06"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-07"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-08"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-16"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-15"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-14"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-13"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-12"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-11"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-10"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-16"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-15"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-14"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-13"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-12"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-11"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-10"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-16"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-15"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-14"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-13"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-12"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-11"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-10"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-02"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-03"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-04"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-05"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-06"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-07"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-08"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"), armCircleHitsWallMediumDouble.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-02"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-03"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-04"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-05"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-06"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-07"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-08"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-02"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-03"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-04"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-05"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-06"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-07"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-08"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-16"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-15"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-14"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-13"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-12"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-11"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-10"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-16"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-15"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-14"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-13"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-12"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-11"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-10"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-16"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-15"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-14"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-13"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-12"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-11"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-10"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-02"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-03"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-04"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-05"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-06"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-07"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-08"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-02"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-03"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-04"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-05"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-06"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-07"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-08"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-02"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-03"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-04"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-05"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-06"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-07"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-08"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-16"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-15"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-14"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-13"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-12"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-11"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-10"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-16"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-15"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-14"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-13"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-12"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-11"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-10"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-16"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-15"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-14"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-13"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-12"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-11"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-10"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-02"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-03"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-04"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-05"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-06"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-07"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-08"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"), armCircleHitsWallLargeDouble.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-02"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-03"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-04"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-05"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-06"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-07"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-08"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-02"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-03"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-04"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-05"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-06"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-07"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-08"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-16"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-15"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-14"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-13"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-12"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-11"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-10"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-16"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-15"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-14"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-13"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-12"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-11"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-10"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-16"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-15"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-14"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-13"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-12"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-11"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-10"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-02"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-03"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-04"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-05"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-06"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-07"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-08"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-02"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-03"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-04"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-05"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-06"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-07"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-08"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-02"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-03"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-04"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-05"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-06"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-07"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-08"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-16"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-15"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-14"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-13"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-12"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-11"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-10"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-16"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-15"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-14"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-13"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-12"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-11"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-10"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-16"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-15"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-14"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-13"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-12"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-11"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-10"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-02"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-03"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-04"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-05"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-06"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-07"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-08"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"), wristCircleFrontWallSingle.getSymbol());

		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-02"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-03"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-04"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-05"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-06"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-07"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-08"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());

		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-02"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-03"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-04"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-05"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-06"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-07"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-08"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());

		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-16"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-15"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-14"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-13"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-12"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-11"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-10"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"), wristCircleFrontWallSingleMirrored.getSymbol());

		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-16"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-15"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-14"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-13"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-12"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-11"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-10"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-16"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-15"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-14"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-13"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-12"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-11"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-10"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-02"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-03"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-04"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-05"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-06"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-07"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-08"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"), wristCircleFrontWallDouble.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-02"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-03"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-04"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-05"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-06"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-07"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-08"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-02"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-03"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-04"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-05"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-06"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-07"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-08"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());

		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-16"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-15"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-14"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-13"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-12"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-11"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-10"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"), wristCircleFrontWallDoubleMirrored.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-16"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-15"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-14"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-13"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-12"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-11"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-10"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-16"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-15"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-14"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-13"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-12"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-11"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-10"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-03"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-04"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-05"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-06"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.rotateCounterClockwise();

		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-03"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-04"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-05"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-06"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());

		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-03"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-04"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-05"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-06"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());

		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-03"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-04"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-05"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-06"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingleMirrored.getSymbol());

		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-03"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-04"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-05"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-06"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-03"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-04"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-05"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-06"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-03"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-04"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-05"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-06"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.rotateCounterClockwise();

		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-03"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-04"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-05"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-06"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-03"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-04"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-05"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-06"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());

		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-03"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-04"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-05"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-06"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDoubleMirrored.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-03"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-04"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-05"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-06"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-03"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-04"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-05"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-06"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());

		fingerCirclesWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-02"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-03"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-04"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-01"), fingerCirclesWallSingle.getSymbol());

		fingerCirclesWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-02"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-03"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-04"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-01"), fingerCirclesWallSingleHalfCircle.getSymbol());

		fingerCirclesWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-08"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-07"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-06"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-05"), fingerCirclesWallSingleMirrored.getSymbol());

		fingerCirclesWallSingleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-08"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-07"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-06"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-05"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());

		fingerCirclesWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-02"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-03"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-04"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-01"), fingerCirclesWallDouble.getSymbol());

		fingerCirclesWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-02"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-03"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-04"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-01"), fingerCirclesWallDoubleHalfCircle.getSymbol());

		fingerCirclesWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-08"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-07"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-06"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-05"), fingerCirclesWallDoubleMirrored.getSymbol());

		fingerCirclesWallDoubleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-08"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-07"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-06"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-05"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());

		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-02"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-03"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-04"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-05"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-06"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-07"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-08"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-01"), fingerCirclesHitsWallSingle.getSymbol());

		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-02"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-03"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-04"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-05"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-06"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-07"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-08"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-01"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());

		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-02"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-03"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-04"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-05"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-06"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-07"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-08"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-01"), fingerCirclesHitsWallDouble.getSymbol());

		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-02"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-03"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-04"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-05"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-06"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-07"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-08"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-01"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());

		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-02"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-03"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-04"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-05"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-06"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-07"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-08"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmall.getSymbol());

		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-02"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-03"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-04"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-05"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-06"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-07"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-08"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmallEmptyArrowhead.getSymbol());

		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-02"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-03"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-04"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-05"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-06"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-07"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-08"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmallSchemaArrowhead.getSymbol());

		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-02"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-03"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-04"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-05"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-06"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-07"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-08"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLarge.getSymbol());

		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-02"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-03"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-04"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-05"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-06"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-07"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-08"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLargeEmptyArrowhead.getSymbol());

		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-02"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-03"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-04"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-05"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-06"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-07"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-08"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLargeSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(armCircleWallSmallSingle.canMirror());
		assertTrue(armCircleWallSmallSingleEmptyArrowhead.canMirror());
		assertTrue(armCircleWallSmallSingleSchemaArrowhead.canMirror());
		assertTrue(armCircleWallSmallSingleMirrored.canMirror());
		assertTrue(armCircleWallSmallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleWallSmallSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleWallMediumSingle.canMirror());
		assertTrue(armCircleWallMediumSingleEmptyArrowhead.canMirror());
		assertTrue(armCircleWallMediumSingleSchemaArrowhead.canMirror());
		assertTrue(armCircleWallMediumSingleMirrored.canMirror());
		assertTrue(armCircleWallMediumSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleWallMediumSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleWallSmallDouble.canMirror());
		assertTrue(armCircleWallSmallDoubleEmptyArrowhead.canMirror());
		assertTrue(armCircleWallSmallDoubleSchemaArrowhead.canMirror());
		assertTrue(armCircleWallSmallDoubleMirrored.canMirror());
		assertTrue(armCircleWallSmallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleWallSmallDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleWallMediumDouble.canMirror());
		assertTrue(armCircleWallMediumDoubleEmptyArrowhead.canMirror());
		assertTrue(armCircleWallMediumDoubleSchemaArrowhead.canMirror());
		assertTrue(armCircleWallMediumDoubleMirrored.canMirror());
		assertTrue(armCircleWallMediumDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleWallMediumDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallSmallSingle.canMirror());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canMirror());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallMediumSingle.canMirror());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canMirror());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallLargeSingle.canMirror());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canMirror());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallSmallDouble.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallMediumDouble.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallLargeDouble.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canMirror());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canMirror());

		assertTrue(wristCircleFrontWallSingle.canMirror());
		assertTrue(wristCircleFrontWallSingleEmptyArrowhead.canMirror());
		assertTrue(wristCircleFrontWallSingleSchemaArrowhead.canMirror());
		assertTrue(wristCircleFrontWallSingleMirrored.canMirror());
		assertTrue(wristCircleFrontWallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(wristCircleFrontWallSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(wristCircleFrontWallDouble.canMirror());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowhead.canMirror());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowhead.canMirror());
		assertTrue(wristCircleFrontWallDoubleMirrored.canMirror());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(wristCircleHitsWallSingle.canMirror());
		assertTrue(wristCircleHitsWallSingleEmptyArrowhead.canMirror());
		assertTrue(wristCircleHitsWallSingleSchemaArrowhead.canMirror());
		assertTrue(wristCircleHitsWallSingleMirrored.canMirror());
		assertTrue(wristCircleHitsWallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(wristCircleHitsWallSingleSchemaArrowheadMirrored.canMirror());

		Symbol wristCircleHitsWallSingleUnMirrorableSymbol1Symbol = symbolFactory.createSymbol("02-10-006-01-01-05");
		Symbol wristCircleHitsWallSingleUnMirrorableSymbol2Symbol = symbolFactory.createSymbol("02-10-006-01-01-06");
		PositionedMovementSymbol wristCircleHitsWallSingleUnMirrorableSymbol1 = new PositionedMovementSymbol(
				wristCircleHitsWallSingleUnMirrorableSymbol1Symbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallSingleUnMirrorableSymbol1Symbol.getBaseSymbol()));
		PositionedMovementSymbol wristCircleHitsWallSingleUnMirrorableSymbol2 = new PositionedMovementSymbol(
				wristCircleHitsWallSingleUnMirrorableSymbol2Symbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallSingleUnMirrorableSymbol2Symbol.getBaseSymbol()));

		assertFalse(wristCircleHitsWallSingleUnMirrorableSymbol1.canMirror());
		assertFalse(wristCircleHitsWallSingleUnMirrorableSymbol2.canMirror());

		assertTrue(wristCircleHitsWallDouble.canMirror());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowhead.canMirror());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowhead.canMirror());
		assertTrue(wristCircleHitsWallDoubleMirrored.canMirror());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canMirror());

		Symbol wristCircleHitsWallDoubleUnMirrorableSymbol1Symbol = symbolFactory.createSymbol("02-10-006-02-01-05");
		Symbol wristCircleHitsWallDoubleUnMirrorableSymbol2Symbol = symbolFactory.createSymbol("02-10-006-02-01-06");
		PositionedMovementSymbol wristCircleHitsWallDoubleUnMirrorableSymbol1 = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleUnMirrorableSymbol1Symbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallDoubleUnMirrorableSymbol1Symbol.getBaseSymbol()));
		PositionedMovementSymbol wristCircleHitsWallDoubleUnMirrorableSymbol2 = new PositionedMovementSymbol(
				wristCircleHitsWallDoubleUnMirrorableSymbol2Symbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						wristCircleHitsWallDoubleUnMirrorableSymbol2Symbol.getBaseSymbol()));

		assertFalse(wristCircleHitsWallDoubleUnMirrorableSymbol1.canMirror());
		assertFalse(wristCircleHitsWallDoubleUnMirrorableSymbol2.canMirror());

		assertTrue(fingerCirclesWallSingle.canMirror());
		assertTrue(fingerCirclesWallSingleHalfCircle.canMirror());
		assertTrue(fingerCirclesWallSingleMirrored.canMirror());
		assertTrue(fingerCirclesWallSingleHalfCircleMirrored.canMirror());

		assertTrue(fingerCirclesWallDouble.canMirror());
		assertTrue(fingerCirclesWallDoubleHalfCircle.canMirror());
		assertTrue(fingerCirclesWallDoubleMirrored.canMirror());
		assertTrue(fingerCirclesWallDoubleHalfCircleMirrored.canMirror());

		assertTrue(fingerCirclesHitsWallSingle.canMirror());
		assertTrue(fingerCirclesHitsWallSingleHalfCircle.canMirror());

		assertTrue(fingerCirclesHitsWallDouble.canMirror());
		assertTrue(fingerCirclesHitsWallDoubleHalfCircle.canMirror());

		assertTrue(arrowheadsSmall.canMirror());
		assertTrue(arrowheadsSmallEmptyArrowhead.canMirror());
		assertTrue(arrowheadsSmallSchemaArrowhead.canMirror());

		assertTrue(arrowheadsLarge.canMirror());
		assertTrue(arrowheadsLargeEmptyArrowhead.canMirror());
		assertTrue(arrowheadsLargeSchemaArrowhead.canMirror());

	}

	@Override
	public void testMirror() {

		armCircleWallSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"), armCircleWallSmallSingle.getSymbol());

		armCircleWallSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleWallSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleWallSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"), armCircleWallSmallSingleMirrored.getSymbol());

		armCircleWallSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"), armCircleWallMediumSingle.getSymbol());

		armCircleWallMediumSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleWallMediumSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleWallMediumSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"), armCircleWallMediumSingleMirrored.getSymbol());

		armCircleWallMediumSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"), armCircleWallSmallDouble.getSymbol());

		armCircleWallSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleWallSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleWallSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"), armCircleWallSmallDoubleMirrored.getSymbol());

		armCircleWallSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"), armCircleWallMediumDouble.getSymbol());

		armCircleWallMediumDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleWallMediumDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleWallMediumDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"), armCircleWallMediumDoubleMirrored.getSymbol());

		armCircleWallMediumDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"), armCircleHitsWallSmallSingle.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"), armCircleHitsWallMediumSingle.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"), armCircleHitsWallLargeSingle.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"), armCircleHitsWallSmallDouble.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"), armCircleHitsWallMediumDouble.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"), armCircleHitsWallLargeDouble.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"), wristCircleFrontWallSingle.getSymbol());

		wristCircleFrontWallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());

		wristCircleFrontWallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());

		wristCircleFrontWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"), wristCircleFrontWallSingleMirrored.getSymbol());

		wristCircleFrontWallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"), wristCircleFrontWallDouble.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());

		wristCircleFrontWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"), wristCircleFrontWallDoubleMirrored.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingle.getSymbol());

		wristCircleHitsWallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());

		wristCircleHitsWallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());

		wristCircleHitsWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingleMirrored.getSymbol());

		wristCircleHitsWallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDouble.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());

		wristCircleHitsWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDoubleMirrored.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());

		fingerCirclesWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-05"), fingerCirclesWallSingle.getSymbol());
		fingerCirclesWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-01"), fingerCirclesWallSingle.getSymbol());

		fingerCirclesWallSingleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-05"), fingerCirclesWallSingleHalfCircle.getSymbol());
		fingerCirclesWallSingleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-01"), fingerCirclesWallSingleHalfCircle.getSymbol());

		fingerCirclesWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-01"), fingerCirclesWallSingleMirrored.getSymbol());
		fingerCirclesWallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-01-05"), fingerCirclesWallSingleMirrored.getSymbol());

		fingerCirclesWallSingleHalfCircleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-01"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());
		fingerCirclesWallSingleHalfCircleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-01-02-05"),
				fingerCirclesWallSingleHalfCircleMirrored.getSymbol());

		fingerCirclesWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-05"), fingerCirclesWallDouble.getSymbol());
		fingerCirclesWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-01"), fingerCirclesWallDouble.getSymbol());

		fingerCirclesWallDoubleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-05"), fingerCirclesWallDoubleHalfCircle.getSymbol());
		fingerCirclesWallDoubleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-01"), fingerCirclesWallDoubleHalfCircle.getSymbol());

		fingerCirclesWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-01"), fingerCirclesWallDoubleMirrored.getSymbol());
		fingerCirclesWallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-01-05"), fingerCirclesWallDoubleMirrored.getSymbol());

		fingerCirclesWallDoubleHalfCircleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-01"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());
		fingerCirclesWallDoubleHalfCircleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-02-02-05"),
				fingerCirclesWallDoubleHalfCircleMirrored.getSymbol());

		fingerCirclesHitsWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-03"), fingerCirclesHitsWallSingle.getSymbol());
		fingerCirclesHitsWallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-01-01"), fingerCirclesHitsWallSingle.getSymbol());

		fingerCirclesHitsWallSingleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-03"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());
		fingerCirclesHitsWallSingleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-03-02-01"),
				fingerCirclesHitsWallSingleHalfCircle.getSymbol());

		fingerCirclesHitsWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-03"), fingerCirclesHitsWallDouble.getSymbol());
		fingerCirclesHitsWallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-01-01"), fingerCirclesHitsWallDouble.getSymbol());

		fingerCirclesHitsWallDoubleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-03"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());
		fingerCirclesHitsWallDoubleHalfCircle.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-007-04-02-01"),
				fingerCirclesHitsWallDoubleHalfCircle.getSymbol());

		arrowheadsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmall.getSymbol());
		arrowheadsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmallSchemaArrowhead.getSymbol());

		arrowheadsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLarge.getSymbol());
		arrowheadsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLargeSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertTrue(armCircleWallSmallSingle.canMirrorVertically());
		assertTrue(armCircleWallSmallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleWallSmallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleWallSmallSingleMirrored.canMirrorVertically());
		assertTrue(armCircleWallSmallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleWallSmallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleWallMediumSingle.canMirrorVertically());
		assertTrue(armCircleWallMediumSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleWallMediumSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleWallMediumSingleMirrored.canMirrorVertically());
		assertTrue(armCircleWallMediumSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleWallMediumSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleWallSmallDouble.canMirrorVertically());
		assertTrue(armCircleWallSmallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleWallSmallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleWallSmallDoubleMirrored.canMirrorVertically());
		assertTrue(armCircleWallSmallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleWallSmallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleWallMediumDouble.canMirrorVertically());
		assertTrue(armCircleWallMediumDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleWallMediumDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleWallMediumDoubleMirrored.canMirrorVertically());
		assertTrue(armCircleWallMediumDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleWallMediumDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallSmallSingle.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallMediumSingle.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallLargeSingle.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallSmallDouble.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallMediumDouble.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallLargeDouble.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(wristCircleFrontWallSingle.canMirrorVertically());
		assertTrue(wristCircleFrontWallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(wristCircleFrontWallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(wristCircleFrontWallSingleMirrored.canMirrorVertically());
		assertTrue(wristCircleFrontWallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(wristCircleFrontWallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(wristCircleFrontWallDouble.canMirrorVertically());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(wristCircleFrontWallDoubleMirrored.canMirrorVertically());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(wristCircleHitsWallSingle.canMirrorVertically());
		assertTrue(wristCircleHitsWallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(wristCircleHitsWallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(wristCircleHitsWallSingleMirrored.canMirrorVertically());
		assertTrue(wristCircleHitsWallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(wristCircleHitsWallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(wristCircleHitsWallDouble.canMirrorVertically());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(wristCircleHitsWallDoubleMirrored.canMirrorVertically());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(fingerCirclesWallSingle.canMirrorVertically());
		assertTrue(fingerCirclesWallSingleHalfCircle.canMirrorVertically());
		assertTrue(fingerCirclesWallSingleMirrored.canMirrorVertically());
		assertTrue(fingerCirclesWallSingleHalfCircleMirrored.canMirrorVertically());

		assertTrue(fingerCirclesWallDouble.canMirrorVertically());
		assertTrue(fingerCirclesWallDoubleHalfCircle.canMirrorVertically());
		assertTrue(fingerCirclesWallDoubleMirrored.canMirrorVertically());
		assertTrue(fingerCirclesWallDoubleHalfCircleMirrored.canMirrorVertically());

		assertTrue(fingerCirclesHitsWallSingle.canMirrorVertically());
		assertTrue(fingerCirclesHitsWallSingleHalfCircle.canMirrorVertically());

		assertTrue(fingerCirclesHitsWallDouble.canMirrorVertically());
		assertTrue(fingerCirclesHitsWallDoubleHalfCircle.canMirrorVertically());

		assertTrue(arrowheadsSmall.canMirrorVertically());
		assertTrue(arrowheadsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(arrowheadsSmallSchemaArrowhead.canMirrorVertically());

		assertTrue(arrowheadsLarge.canMirrorVertically());
		assertTrue(arrowheadsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(arrowheadsLargeSchemaArrowhead.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

	}

	@Override
	public void testCanPitch() {

		assertFalse(armCircleWallSmallSingle.canPitch());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canPitch());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canPitch());
		assertFalse(armCircleWallSmallSingleMirrored.canPitch());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleWallMediumSingle.canPitch());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canPitch());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canPitch());
		assertFalse(armCircleWallMediumSingleMirrored.canPitch());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleWallSmallDouble.canPitch());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canPitch());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canPitch());
		assertFalse(armCircleWallSmallDoubleMirrored.canPitch());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleWallMediumDouble.canPitch());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canPitch());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canPitch());
		assertFalse(armCircleWallMediumDoubleMirrored.canPitch());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallSmallSingle.canPitch());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canPitch());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallMediumSingle.canPitch());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canPitch());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallLargeSingle.canPitch());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canPitch());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallSmallDouble.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallMediumDouble.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallLargeDouble.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canPitch());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canPitch());

		assertFalse(wristCircleFrontWallSingle.canPitch());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canPitch());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canPitch());
		assertFalse(wristCircleFrontWallSingleMirrored.canPitch());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(wristCircleFrontWallDouble.canPitch());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canPitch());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canPitch());
		assertFalse(wristCircleFrontWallDoubleMirrored.canPitch());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(wristCircleHitsWallSingle.canPitch());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canPitch());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canPitch());
		assertFalse(wristCircleHitsWallSingleMirrored.canPitch());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(wristCircleHitsWallDouble.canPitch());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canPitch());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canPitch());
		assertFalse(wristCircleHitsWallDoubleMirrored.canPitch());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(fingerCirclesWallSingle.canPitch());
		assertFalse(fingerCirclesWallSingleHalfCircle.canPitch());
		assertFalse(fingerCirclesWallSingleMirrored.canPitch());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canPitch());

		assertFalse(fingerCirclesWallDouble.canPitch());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canPitch());
		assertFalse(fingerCirclesWallDoubleMirrored.canPitch());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canPitch());

		assertFalse(fingerCirclesHitsWallSingle.canPitch());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canPitch());

		assertFalse(fingerCirclesHitsWallDouble.canPitch());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canPitch());

		assertFalse(arrowheadsSmall.canPitch());
		assertFalse(arrowheadsSmallEmptyArrowhead.canPitch());
		assertFalse(arrowheadsSmallSchemaArrowhead.canPitch());

		assertFalse(arrowheadsLarge.canPitch());
		assertFalse(arrowheadsLargeEmptyArrowhead.canPitch());
		assertFalse(arrowheadsLargeSchemaArrowhead.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(armCircleWallSmallSingle.canRoll());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canRoll());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canRoll());
		assertFalse(armCircleWallSmallSingleMirrored.canRoll());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleWallMediumSingle.canRoll());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canRoll());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canRoll());
		assertFalse(armCircleWallMediumSingleMirrored.canRoll());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleWallSmallDouble.canRoll());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canRoll());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canRoll());
		assertFalse(armCircleWallSmallDoubleMirrored.canRoll());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleWallMediumDouble.canRoll());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canRoll());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canRoll());
		assertFalse(armCircleWallMediumDoubleMirrored.canRoll());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallSmallSingle.canRoll());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canRoll());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallMediumSingle.canRoll());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canRoll());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallLargeSingle.canRoll());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canRoll());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallSmallDouble.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallMediumDouble.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallLargeDouble.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canRoll());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canRoll());

		assertFalse(wristCircleFrontWallSingle.canRoll());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canRoll());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canRoll());
		assertFalse(wristCircleFrontWallSingleMirrored.canRoll());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(wristCircleFrontWallDouble.canRoll());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canRoll());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canRoll());
		assertFalse(wristCircleFrontWallDoubleMirrored.canRoll());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(wristCircleHitsWallSingle.canRoll());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canRoll());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canRoll());
		assertFalse(wristCircleHitsWallSingleMirrored.canRoll());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(wristCircleHitsWallDouble.canRoll());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canRoll());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canRoll());
		assertFalse(wristCircleHitsWallDoubleMirrored.canRoll());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(fingerCirclesWallSingle.canRoll());
		assertFalse(fingerCirclesWallSingleHalfCircle.canRoll());
		assertFalse(fingerCirclesWallSingleMirrored.canRoll());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canRoll());

		assertFalse(fingerCirclesWallDouble.canRoll());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canRoll());
		assertFalse(fingerCirclesWallDoubleMirrored.canRoll());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canRoll());

		assertFalse(fingerCirclesHitsWallSingle.canRoll());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canRoll());

		assertFalse(fingerCirclesHitsWallDouble.canRoll());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canRoll());

		assertFalse(arrowheadsSmall.canRoll());
		assertFalse(arrowheadsSmallEmptyArrowhead.canRoll());
		assertFalse(arrowheadsSmallSchemaArrowhead.canRoll());

		assertFalse(arrowheadsLarge.canRoll());
		assertFalse(arrowheadsLargeEmptyArrowhead.canRoll());
		assertFalse(arrowheadsLargeSchemaArrowhead.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertTrue(armCircleWallSmallSingle.canSwitchArrowHead());
		assertTrue(armCircleWallSmallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallSmallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallSmallSingleMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallSmallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallSmallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleWallMediumSingle.canSwitchArrowHead());
		assertTrue(armCircleWallMediumSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallMediumSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallMediumSingleMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallMediumSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallMediumSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleWallSmallDouble.canSwitchArrowHead());
		assertTrue(armCircleWallSmallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallSmallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallSmallDoubleMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallSmallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallSmallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleWallMediumDouble.canSwitchArrowHead());
		assertTrue(armCircleWallMediumDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallMediumDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleWallMediumDoubleMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallMediumDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleWallMediumDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallSmallSingle.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallMediumSingle.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallLargeSingle.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallSmallDouble.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallMediumDouble.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallLargeDouble.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(wristCircleFrontWallSingle.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallSingleMirrored.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(wristCircleFrontWallDouble.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallDoubleMirrored.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(wristCircleHitsWallSingle.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallSingleMirrored.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(wristCircleHitsWallDouble.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallDoubleMirrored.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertFalse(fingerCirclesWallSingle.canSwitchArrowHead());
		assertFalse(fingerCirclesWallSingleHalfCircle.canSwitchArrowHead());
		assertFalse(fingerCirclesWallSingleMirrored.canSwitchArrowHead());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canSwitchArrowHead());

		assertFalse(fingerCirclesWallDouble.canSwitchArrowHead());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canSwitchArrowHead());
		assertFalse(fingerCirclesWallDoubleMirrored.canSwitchArrowHead());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canSwitchArrowHead());

		assertFalse(fingerCirclesHitsWallSingle.canSwitchArrowHead());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canSwitchArrowHead());

		assertFalse(fingerCirclesHitsWallDouble.canSwitchArrowHead());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canSwitchArrowHead());

		assertTrue(arrowheadsSmall.canSwitchArrowHead());
		assertTrue(arrowheadsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(arrowheadsSmallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(arrowheadsLarge.canSwitchArrowHead());
		assertTrue(arrowheadsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(arrowheadsLargeSchemaArrowhead.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

		armCircleWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"), armCircleWallSmallSingle.getSymbol());
		armCircleWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"), armCircleWallSmallSingle.getSymbol());

		armCircleWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-01"),
				armCircleWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"), armCircleWallSmallSingleMirrored.getSymbol());
		armCircleWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"), armCircleWallSmallSingleMirrored.getSymbol());

		armCircleWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-01-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-02-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-01-03-09"),
				armCircleWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"), armCircleWallMediumSingle.getSymbol());
		armCircleWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"), armCircleWallMediumSingle.getSymbol());

		armCircleWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-01"),
				armCircleWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"), armCircleWallMediumSingleMirrored.getSymbol());
		armCircleWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"), armCircleWallMediumSingleMirrored.getSymbol());

		armCircleWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-01-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-02-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-001-02-03-09"),
				armCircleWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"), armCircleWallSmallDouble.getSymbol());
		armCircleWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"), armCircleWallSmallDouble.getSymbol());

		armCircleWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-01"),
				armCircleWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"), armCircleWallSmallDoubleMirrored.getSymbol());
		armCircleWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"), armCircleWallSmallDoubleMirrored.getSymbol());

		armCircleWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-01-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-02-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-01-03-09"),
				armCircleWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"), armCircleWallMediumDouble.getSymbol());
		armCircleWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"), armCircleWallMediumDouble.getSymbol());

		armCircleWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-01"),
				armCircleWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"), armCircleWallMediumDoubleMirrored.getSymbol());
		armCircleWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"), armCircleWallMediumDoubleMirrored.getSymbol());

		armCircleWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-01-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-02-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-002-02-03-09"),
				armCircleWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"), armCircleHitsWallSmallSingle.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"), armCircleHitsWallMediumSingle.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"), armCircleHitsWallLargeSingle.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"), armCircleHitsWallSmallDouble.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"), armCircleHitsWallMediumDouble.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"), armCircleHitsWallLargeDouble.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"), wristCircleFrontWallSingle.getSymbol());
		wristCircleFrontWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"), wristCircleFrontWallSingle.getSymbol());

		wristCircleFrontWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());
		wristCircleFrontWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleEmptyArrowhead.getSymbol());

		wristCircleFrontWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());
		wristCircleFrontWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-01"),
				wristCircleFrontWallSingleSchemaArrowhead.getSymbol());

		wristCircleFrontWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"), wristCircleFrontWallSingleMirrored.getSymbol());
		wristCircleFrontWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"), wristCircleFrontWallSingleMirrored.getSymbol());

		wristCircleFrontWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-01-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-02-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-01-03-09"),
				wristCircleFrontWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleFrontWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"), wristCircleFrontWallDouble.getSymbol());
		wristCircleFrontWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"), wristCircleFrontWallDouble.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleEmptyArrowhead.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-01"),
				wristCircleFrontWallDoubleSchemaArrowhead.getSymbol());

		wristCircleFrontWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"), wristCircleFrontWallDoubleMirrored.getSymbol());
		wristCircleFrontWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"), wristCircleFrontWallDoubleMirrored.getSymbol());

		wristCircleFrontWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleFrontWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-01-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-02-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleFrontWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-005-02-03-09"),
				wristCircleFrontWallDoubleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"), wristCircleHitsWallSingle.getSymbol());
		wristCircleHitsWallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"), wristCircleHitsWallSingle.getSymbol());

		wristCircleHitsWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());
		wristCircleHitsWallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleEmptyArrowhead.getSymbol());

		wristCircleHitsWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());
		wristCircleHitsWallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-01"),
				wristCircleHitsWallSingleSchemaArrowhead.getSymbol());

		wristCircleHitsWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"), wristCircleHitsWallSingleMirrored.getSymbol());
		wristCircleHitsWallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"), wristCircleHitsWallSingleMirrored.getSymbol());

		wristCircleHitsWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-01-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-02-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-01-03-02"),
				wristCircleHitsWallSingleSchemaArrowheadMirrored.getSymbol());

		wristCircleHitsWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"), wristCircleHitsWallDouble.getSymbol());
		wristCircleHitsWallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"), wristCircleHitsWallDouble.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleEmptyArrowhead.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-01"),
				wristCircleHitsWallDoubleSchemaArrowhead.getSymbol());

		wristCircleHitsWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"), wristCircleHitsWallDoubleMirrored.getSymbol());
		wristCircleHitsWallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"), wristCircleHitsWallDoubleMirrored.getSymbol());

		wristCircleHitsWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleEmptyArrowheadMirrored.getSymbol());

		wristCircleHitsWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-01-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-02-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());
		wristCircleHitsWallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-006-02-03-02"),
				wristCircleHitsWallDoubleSchemaArrowheadMirrored.getSymbol());

		arrowheadsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmall.getSymbol());
		arrowheadsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmall.getSymbol());

		arrowheadsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmallEmptyArrowhead.getSymbol());
		arrowheadsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmallEmptyArrowhead.getSymbol());

		arrowheadsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-01-01"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-02-01"), arrowheadsSmallSchemaArrowhead.getSymbol());
		arrowheadsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-01-03-01"), arrowheadsSmallSchemaArrowhead.getSymbol());

		arrowheadsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLarge.getSymbol());
		arrowheadsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLarge.getSymbol());

		arrowheadsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLargeEmptyArrowhead.getSymbol());
		arrowheadsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLargeEmptyArrowhead.getSymbol());

		arrowheadsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-01-01"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-02-01"), arrowheadsLargeSchemaArrowhead.getSymbol());
		arrowheadsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-10-008-02-03-01"), arrowheadsLargeSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(armCircleWallSmallSingle.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleWallMediumSingle.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumSingleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleWallSmallDouble.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleWallMediumDouble.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallSmallSingle.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallMediumSingle.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallLargeSingle.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallSmallDouble.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallMediumDouble.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallLargeDouble.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(wristCircleFrontWallSingle.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(wristCircleFrontWallDouble.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(wristCircleHitsWallSingle.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(wristCircleHitsWallDouble.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(fingerCirclesWallSingle.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallSingleHalfCircle.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canSwitchToNormalArrows());

		assertFalse(fingerCirclesWallDouble.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canSwitchToNormalArrows());

		assertFalse(fingerCirclesHitsWallSingle.canSwitchToNormalArrows());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canSwitchToNormalArrows());

		assertFalse(fingerCirclesHitsWallDouble.canSwitchToNormalArrows());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canSwitchToNormalArrows());

		assertFalse(arrowheadsSmall.canSwitchToNormalArrows());
		assertFalse(arrowheadsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(arrowheadsSmallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(arrowheadsLarge.canSwitchToNormalArrows());
		assertFalse(arrowheadsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(arrowheadsLargeSchemaArrowhead.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(armCircleWallSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleWallMediumSingle.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleWallSmallDouble.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleWallMediumDouble.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallMediumSingle.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallLargeSingle.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallSmallDouble.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallMediumDouble.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallLargeDouble.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(wristCircleFrontWallSingle.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(wristCircleFrontWallDouble.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(wristCircleHitsWallSingle.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(wristCircleHitsWallDouble.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(fingerCirclesWallSingle.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallSingleHalfCircle.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canSwitchToAlternatingArrows());

		assertFalse(fingerCirclesWallDouble.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canSwitchToAlternatingArrows());

		assertFalse(fingerCirclesHitsWallSingle.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canSwitchToAlternatingArrows());

		assertFalse(fingerCirclesHitsWallDouble.canSwitchToAlternatingArrows());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canSwitchToAlternatingArrows());

		assertFalse(arrowheadsSmall.canSwitchToAlternatingArrows());
		assertFalse(arrowheadsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(arrowheadsSmallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(arrowheadsLarge.canSwitchToAlternatingArrows());
		assertFalse(arrowheadsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(arrowheadsLargeSchemaArrowhead.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

	}

	@Override
	public void testCanSwitchStartingPoint() {
		assertFalse(armCircleWallSmallSingle.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallSingleMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(armCircleWallMediumSingle.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumSingleMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(armCircleWallSmallDouble.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(armCircleWallMediumDouble.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumDoubleMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallSmallSingle.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallSmallSingleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallMediumSingle.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallMediumSingleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallLargeSingle.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallLargeSingleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallSmallDouble.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallSmallDoubleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallMediumDouble.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallMediumDoubleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallLargeDouble.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertTrue(armCircleHitsWallLargeDoubleStartingBack.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertTrue(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(wristCircleFrontWallSingle.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallSingleMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(wristCircleFrontWallDouble.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(wristCircleHitsWallSingle.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallSingleMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(wristCircleHitsWallDouble.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(fingerCirclesWallSingle.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallSingleHalfCircle.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallSingleMirrored.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canSwitchStartingPoint());

		assertFalse(fingerCirclesWallDouble.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canSwitchStartingPoint());

		assertFalse(fingerCirclesHitsWallSingle.canSwitchStartingPoint());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canSwitchStartingPoint());

		assertFalse(fingerCirclesHitsWallDouble.canSwitchStartingPoint());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canSwitchStartingPoint());

		assertFalse(arrowheadsSmall.canSwitchStartingPoint());
		assertFalse(arrowheadsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(arrowheadsSmallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(arrowheadsLarge.canSwitchStartingPoint());
		assertFalse(arrowheadsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(arrowheadsLargeSchemaArrowhead.canSwitchStartingPoint());
	}

	@Override
	public void testSwitchStartingPoint() {

		armCircleHitsWallSmallSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"), armCircleHitsWallSmallSingle.getSymbol());
		armCircleHitsWallSmallSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"), armCircleHitsWallSmallSingle.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());
		armCircleHitsWallSmallSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleMirrored.getSymbol());

		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());
		armCircleHitsWallSmallSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-01"),
				armCircleHitsWallSmallSingleStartingBack.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-01"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-01"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-01-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-04-09"),
				armCircleHitsWallSmallSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-02-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-05-09"),
				armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-03-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-01-06-09"),
				armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"), armCircleHitsWallMediumSingle.getSymbol());
		armCircleHitsWallMediumSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"), armCircleHitsWallMediumSingle.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());
		armCircleHitsWallMediumSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleMirrored.getSymbol());

		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());
		armCircleHitsWallMediumSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-01"),
				armCircleHitsWallMediumSingleStartingBack.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-01"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-01"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-01-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-04-09"),
				armCircleHitsWallMediumSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-02-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-05-09"),
				armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-03-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-02-06-09"),
				armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"), armCircleHitsWallLargeSingle.getSymbol());
		armCircleHitsWallLargeSingle.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"), armCircleHitsWallLargeSingle.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());
		armCircleHitsWallLargeSingleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleMirrored.getSymbol());

		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());
		armCircleHitsWallLargeSingleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-01"),
				armCircleHitsWallLargeSingleStartingBack.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-01"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-01"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-01-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-04-09"),
				armCircleHitsWallLargeSingleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-02-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-05-09"),
				armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-03-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-003-03-06-09"),
				armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"), armCircleHitsWallSmallDouble.getSymbol());
		armCircleHitsWallSmallDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"), armCircleHitsWallSmallDouble.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());
		armCircleHitsWallSmallDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleMirrored.getSymbol());

		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());
		armCircleHitsWallSmallDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-01"),
				armCircleHitsWallSmallDoubleStartingBack.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-01"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-01"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-01-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-04-09"),
				armCircleHitsWallSmallDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-02-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-05-09"),
				armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-03-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-01-06-09"),
				armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"), armCircleHitsWallMediumDouble.getSymbol());
		armCircleHitsWallMediumDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"), armCircleHitsWallMediumDouble.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());
		armCircleHitsWallMediumDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleMirrored.getSymbol());

		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());
		armCircleHitsWallMediumDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-01"),
				armCircleHitsWallMediumDoubleStartingBack.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-01"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-01"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-01-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-04-09"),
				armCircleHitsWallMediumDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-02-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-05-09"),
				armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-03-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-02-06-09"),
				armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"), armCircleHitsWallLargeDouble.getSymbol());
		armCircleHitsWallLargeDouble.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"), armCircleHitsWallLargeDouble.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());
		armCircleHitsWallLargeDoubleMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleMirrored.getSymbol());

		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());
		armCircleHitsWallLargeDoubleStartingBack.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-01"),
				armCircleHitsWallLargeDoubleStartingBack.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-01"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-01"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-01-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-04-09"),
				armCircleHitsWallLargeDoubleStartingBackMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-02-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-05-09"),
				armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.getSymbol());

		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-03-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());
		armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.switchStartingPoint();
		assertEquals(symbolFactory.createSymbol("02-10-004-03-06-09"),
				armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchPlane() {

		assertFalse(armCircleWallSmallSingle.canSwitchPlane());
		assertFalse(armCircleWallSmallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleWallSmallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleWallSmallSingleMirrored.canSwitchPlane());
		assertFalse(armCircleWallSmallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleWallSmallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleWallMediumSingle.canSwitchPlane());
		assertFalse(armCircleWallMediumSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleWallMediumSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleWallMediumSingleMirrored.canSwitchPlane());
		assertFalse(armCircleWallMediumSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleWallMediumSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleWallSmallDouble.canSwitchPlane());
		assertFalse(armCircleWallSmallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleWallSmallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleWallSmallDoubleMirrored.canSwitchPlane());
		assertFalse(armCircleWallSmallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleWallSmallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleWallMediumDouble.canSwitchPlane());
		assertFalse(armCircleWallMediumDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleWallMediumDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleWallMediumDoubleMirrored.canSwitchPlane());
		assertFalse(armCircleWallMediumDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleWallMediumDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallSmallSingle.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallSmallSingleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallSingleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallMediumSingle.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallMediumSingleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumSingleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallLargeSingle.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallLargeSingleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeSingleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallSmallDouble.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallSmallDoubleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallSmallDoubleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallMediumDouble.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallMediumDoubleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallMediumDoubleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallLargeDouble.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(armCircleHitsWallLargeDoubleStartingBack.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowhead.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(armCircleHitsWallLargeDoubleStartingBackSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(wristCircleFrontWallSingle.canSwitchPlane());
		assertFalse(wristCircleFrontWallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(wristCircleFrontWallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(wristCircleFrontWallSingleMirrored.canSwitchPlane());
		assertFalse(wristCircleFrontWallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(wristCircleFrontWallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(wristCircleFrontWallDouble.canSwitchPlane());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(wristCircleFrontWallDoubleMirrored.canSwitchPlane());
		assertFalse(wristCircleFrontWallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(wristCircleFrontWallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(wristCircleHitsWallSingle.canSwitchPlane());
		assertFalse(wristCircleHitsWallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(wristCircleHitsWallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(wristCircleHitsWallSingleMirrored.canSwitchPlane());
		assertFalse(wristCircleHitsWallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(wristCircleHitsWallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(wristCircleHitsWallDouble.canSwitchPlane());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(wristCircleHitsWallDoubleMirrored.canSwitchPlane());
		assertFalse(wristCircleHitsWallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(wristCircleHitsWallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(fingerCirclesWallSingle.canSwitchPlane());
		assertFalse(fingerCirclesWallSingleHalfCircle.canSwitchPlane());
		assertFalse(fingerCirclesWallSingleMirrored.canSwitchPlane());
		assertFalse(fingerCirclesWallSingleHalfCircleMirrored.canSwitchPlane());

		assertFalse(fingerCirclesWallDouble.canSwitchPlane());
		assertFalse(fingerCirclesWallDoubleHalfCircle.canSwitchPlane());
		assertFalse(fingerCirclesWallDoubleMirrored.canSwitchPlane());
		assertFalse(fingerCirclesWallDoubleHalfCircleMirrored.canSwitchPlane());

		assertFalse(fingerCirclesHitsWallSingle.canSwitchPlane());
		assertFalse(fingerCirclesHitsWallSingleHalfCircle.canSwitchPlane());

		assertFalse(fingerCirclesHitsWallDouble.canSwitchPlane());
		assertFalse(fingerCirclesHitsWallDoubleHalfCircle.canSwitchPlane());

		assertFalse(arrowheadsSmall.canSwitchPlane());
		assertFalse(arrowheadsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(arrowheadsSmallSchemaArrowhead.canSwitchPlane());

		assertFalse(arrowheadsLarge.canSwitchPlane());
		assertFalse(arrowheadsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(arrowheadsLargeSchemaArrowhead.canSwitchPlane());

	}

	@Override
	public void testSwitchPlane() {

	}

}
