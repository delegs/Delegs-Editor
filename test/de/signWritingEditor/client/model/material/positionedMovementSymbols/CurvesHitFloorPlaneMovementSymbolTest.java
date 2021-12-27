package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class CurvesHitFloorPlaneMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	private PositionedMovementSymbol curveHitsCeilingSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallEmptyArrowhead;
	private PositionedMovementSymbol curveHitsCeilingSmallSchemaArrowhead;
	private PositionedMovementSymbol curveHitsCeilingSmallMirrored;
	private PositionedMovementSymbol curveHitsCeilingSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveHitsCeilingSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveHitsCeilingSmallSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallEmptyArrowheadSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallSchemaArrowheadSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallMirroredSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallEmptyArrowheadMirroredSmall;
	private PositionedMovementSymbol curveHitsCeilingSmallSchemaArrowheadMirroredSmall;

	private PositionedMovementSymbol curveHitsCeilingLarge;
	private PositionedMovementSymbol curveHitsCeilingLargeEmptyArrowhead;
	private PositionedMovementSymbol curveHitsCeilingLargeSchemaArrowhead;
	private PositionedMovementSymbol curveHitsCeilingLargeMirrored;
	private PositionedMovementSymbol curveHitsCeilingLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveHitsCeilingLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveHitsCeilingLargeSmall;
	private PositionedMovementSymbol curveHitsCeilingLargeEmptyArrowheadSmall;
	private PositionedMovementSymbol curveHitsCeilingLargeSchemaArrowheadSmall;
	private PositionedMovementSymbol curveHitsCeilingLargeMirroredSmall;
	private PositionedMovementSymbol curveHitsCeilingLargeEmptyArrowheadMirroredSmall;
	private PositionedMovementSymbol curveHitsCeilingLargeSchemaArrowheadMirroredSmall;

	private PositionedMovementSymbol humpHitsCeiling2HumpsSmall;
	private PositionedMovementSymbol humpHitsCeiling2HumpsSmallEmptyArrowhead;
	private PositionedMovementSymbol humpHitsCeiling2HumpsSmallSchemaArrowhead;
	private PositionedMovementSymbol humpHitsCeiling2HumpsSmallMirrored;
	private PositionedMovementSymbol humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsCeiling2HumpsLarge;
	private PositionedMovementSymbol humpHitsCeiling2HumpsLargeEmptyArrowhead;
	private PositionedMovementSymbol humpHitsCeiling2HumpsLargeSchemaArrowhead;
	private PositionedMovementSymbol humpHitsCeiling2HumpsLargeMirrored;
	private PositionedMovementSymbol humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsCeiling3HumpsSmall;
	private PositionedMovementSymbol humpHitsCeiling3HumpsSmallEmptyArrowhead;
	private PositionedMovementSymbol humpHitsCeiling3HumpsSmallSchemaArrowhead;
	private PositionedMovementSymbol humpHitsCeiling3HumpsSmallMirrored;
	private PositionedMovementSymbol humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsCeiling3HumpsLarge;
	private PositionedMovementSymbol humpHitsCeiling3HumpsLargeEmptyArrowhead;
	private PositionedMovementSymbol humpHitsCeiling3HumpsLargeSchemaArrowhead;
	private PositionedMovementSymbol humpHitsCeiling3HumpsLargeMirrored;
	private PositionedMovementSymbol humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsCeilingSmallSingle;
	private PositionedMovementSymbol loopHitsCeilingSmallSingleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsCeilingSmallSingleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsCeilingSmallSingleMirrored;
	private PositionedMovementSymbol loopHitsCeilingSmallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsCeilingSmallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsCeilingLargeSingle;
	private PositionedMovementSymbol loopHitsCeilingLargeSingleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsCeilingLargeSingleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsCeilingLargeSingleMirrored;
	private PositionedMovementSymbol loopHitsCeilingLargeSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsCeilingLargeSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsCeilingSmallDouble;
	private PositionedMovementSymbol loopHitsCeilingSmallDoubleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsCeilingSmallDoubleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsCeilingSmallDoubleMirrored;
	private PositionedMovementSymbol loopHitsCeilingSmallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsCeilingSmallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsCeilingLargeDouble;
	private PositionedMovementSymbol loopHitsCeilingLargeDoubleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsCeilingLargeDoubleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsCeilingLargeDoubleMirrored;
	private PositionedMovementSymbol loopHitsCeilingLargeDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsCeilingLargeDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveHitsCeilingSmall;
	private PositionedMovementSymbol waveHitsCeilingSmallEmptyArrowhead;
	private PositionedMovementSymbol waveHitsCeilingSmallSchemaArrowhead;
	private PositionedMovementSymbol waveHitsCeilingSmallMirrored;
	private PositionedMovementSymbol waveHitsCeilingSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveHitsCeilingSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveHitsCeilingLarge;
	private PositionedMovementSymbol waveHitsCeilingLargeEmptyArrowhead;
	private PositionedMovementSymbol waveHitsCeilingLargeSchemaArrowhead;
	private PositionedMovementSymbol waveHitsCeilingLargeMirrored;
	private PositionedMovementSymbol waveHitsCeilingLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveHitsCeilingLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationSingleHitsCeiling;
	private PositionedMovementSymbol rotationSingleHitsCeilingEmptyArrowhead;
	private PositionedMovementSymbol rotationSingleHitsCeilingSchemaArrowhead;
	private PositionedMovementSymbol rotationSingleHitsCeilingMirrored;
	private PositionedMovementSymbol rotationSingleHitsCeilingEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationSingleHitsCeilingSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationDoubleHitsCeiling;
	private PositionedMovementSymbol rotationDoubleHitsCeilingEmptyArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsCeilingSchemaArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsCeilingMirrored;
	private PositionedMovementSymbol rotationDoubleHitsCeilingEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationDoubleHitsCeilingSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationAlternatingHitsCeiling;
	private PositionedMovementSymbol rotationAlternatingHitsCeilingEmptyArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsCeilingSchemaArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsCeilingMirrored;
	private PositionedMovementSymbol rotationAlternatingHitsCeilingEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationAlternatingHitsCeilingSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveHitsFloorSmall;
	private PositionedMovementSymbol curveHitsFloorSmallEmptyArrowhead;
	private PositionedMovementSymbol curveHitsFloorSmallSchemaArrowhead;
	private PositionedMovementSymbol curveHitsFloorSmallMirrored;
	private PositionedMovementSymbol curveHitsFloorSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveHitsFloorSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveHitsFloorSmallSmall;
	private PositionedMovementSymbol curveHitsFloorSmallEmptyArrowheadSmall;
	private PositionedMovementSymbol curveHitsFloorSmallSchemaArrowheadSmall;
	private PositionedMovementSymbol curveHitsFloorSmallMirroredSmall;
	private PositionedMovementSymbol curveHitsFloorSmallEmptyArrowheadMirroredSmall;
	private PositionedMovementSymbol curveHitsFloorSmallSchemaArrowheadMirroredSmall;

	private PositionedMovementSymbol curveHitsFloorLarge;
	private PositionedMovementSymbol curveHitsFloorLargeEmptyArrowhead;
	private PositionedMovementSymbol curveHitsFloorLargeSchemaArrowhead;
	private PositionedMovementSymbol curveHitsFloorLargeMirrored;
	private PositionedMovementSymbol curveHitsFloorLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveHitsFloorLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveHitsFloorLargeSmall;
	private PositionedMovementSymbol curveHitsFloorLargeEmptyArrowheadSmall;
	private PositionedMovementSymbol curveHitsFloorLargeSchemaArrowheadSmall;
	private PositionedMovementSymbol curveHitsFloorLargeMirroredSmall;
	private PositionedMovementSymbol curveHitsFloorLargeEmptyArrowheadMirroredSmall;
	private PositionedMovementSymbol curveHitsFloorLargeSchemaArrowheadMirroredSmall;

	private PositionedMovementSymbol humpHitsFloor2HumpsSmall;
	private PositionedMovementSymbol humpHitsFloor2HumpsSmallEmptyArrowhead;
	private PositionedMovementSymbol humpHitsFloor2HumpsSmallSchemaArrowhead;
	private PositionedMovementSymbol humpHitsFloor2HumpsSmallMirrored;
	private PositionedMovementSymbol humpHitsFloor2HumpsSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsFloor2HumpsSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsFloor2HumpsLarge;
	private PositionedMovementSymbol humpHitsFloor2HumpsLargeEmptyArrowhead;
	private PositionedMovementSymbol humpHitsFloor2HumpsLargeSchemaArrowhead;
	private PositionedMovementSymbol humpHitsFloor2HumpsLargeMirrored;
	private PositionedMovementSymbol humpHitsFloor2HumpsLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsFloor2HumpsLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsFloor3HumpsSmall;
	private PositionedMovementSymbol humpHitsFloor3HumpsSmallEmptyArrowhead;
	private PositionedMovementSymbol humpHitsFloor3HumpsSmallSchemaArrowhead;
	private PositionedMovementSymbol humpHitsFloor3HumpsSmallMirrored;
	private PositionedMovementSymbol humpHitsFloor3HumpsSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsFloor3HumpsSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpHitsFloor3HumpsLarge;
	private PositionedMovementSymbol humpHitsFloor3HumpsLargeEmptyArrowhead;
	private PositionedMovementSymbol humpHitsFloor3HumpsLargeSchemaArrowhead;
	private PositionedMovementSymbol humpHitsFloor3HumpsLargeMirrored;
	private PositionedMovementSymbol humpHitsFloor3HumpsLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpHitsFloor3HumpsLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsFloorSmallSingle;
	private PositionedMovementSymbol loopHitsFloorSmallSingleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsFloorSmallSingleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsFloorSmallSingleMirrored;
	private PositionedMovementSymbol loopHitsFloorSmallSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsFloorSmallSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsFloorLargeSingle;
	private PositionedMovementSymbol loopHitsFloorLargeSingleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsFloorLargeSingleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsFloorLargeSingleMirrored;
	private PositionedMovementSymbol loopHitsFloorLargeSingleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsFloorLargeSingleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsFloorSmallDouble;
	private PositionedMovementSymbol loopHitsFloorSmallDoubleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsFloorSmallDoubleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsFloorSmallDoubleMirrored;
	private PositionedMovementSymbol loopHitsFloorSmallDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsFloorSmallDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopHitsFloorLargeDouble;
	private PositionedMovementSymbol loopHitsFloorLargeDoubleEmptyArrowhead;
	private PositionedMovementSymbol loopHitsFloorLargeDoubleSchemaArrowhead;
	private PositionedMovementSymbol loopHitsFloorLargeDoubleMirrored;
	private PositionedMovementSymbol loopHitsFloorLargeDoubleEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopHitsFloorLargeDoubleSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveHitsFloorSmall;
	private PositionedMovementSymbol waveHitsFloorSmallEmptyArrowhead;
	private PositionedMovementSymbol waveHitsFloorSmallSchemaArrowhead;
	private PositionedMovementSymbol waveHitsFloorSmallMirrored;
	private PositionedMovementSymbol waveHitsFloorSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveHitsFloorSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveHitsFloorLarge;
	private PositionedMovementSymbol waveHitsFloorLargeEmptyArrowhead;
	private PositionedMovementSymbol waveHitsFloorLargeSchemaArrowhead;
	private PositionedMovementSymbol waveHitsFloorLargeMirrored;
	private PositionedMovementSymbol waveHitsFloorLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveHitsFloorLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationSingleHitsFloor;
	private PositionedMovementSymbol rotationSingleHitsFloorEmptyArrowhead;
	private PositionedMovementSymbol rotationSingleHitsFloorSchemaArrowhead;
	private PositionedMovementSymbol rotationSingleHitsFloorMirrored;
	private PositionedMovementSymbol rotationSingleHitsFloorEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationSingleHitsFloorSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationDoubleHitsFloor;
	private PositionedMovementSymbol rotationDoubleHitsFloorEmptyArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsFloorSchemaArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsFloorMirrored;
	private PositionedMovementSymbol rotationDoubleHitsFloorEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationDoubleHitsFloorSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationAlternatingHitsFloor;
	private PositionedMovementSymbol rotationAlternatingHitsFloorEmptyArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsFloorSchemaArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsFloorMirrored;
	private PositionedMovementSymbol rotationAlternatingHitsFloorEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationAlternatingHitsFloorSchemaArrowheadMirrored;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {
		this.symbolFactory = symbolFactory;

		curveHitsCeilingSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsCeilingSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-001-01-02-01");
		curveHitsCeilingSmallEmptyArrowhead = new PositionedMovementSymbol(curveHitsCeilingSmallEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-001-01-03-01");
		curveHitsCeilingSmallSchemaArrowhead = new PositionedMovementSymbol(curveHitsCeilingSmallSchemaArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallMirroredSymbol = symbolFactory.createSymbol("02-08-001-01-01-02");
		curveHitsCeilingSmallMirrored = new PositionedMovementSymbol(curveHitsCeilingSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingSmallMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-001-01-02-02");
		curveHitsCeilingSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsCeilingSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-001-01-03-02");
		curveHitsCeilingSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsCeilingSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol curveHitsCeilingSmallSmallSymbol = symbolFactory.createSymbol("02-08-001-01-04-01");
		curveHitsCeilingSmallSmall = new PositionedMovementSymbol(curveHitsCeilingSmallSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingSmallSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallEmptyArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-001-01-05-01");
		curveHitsCeilingSmallEmptyArrowheadSmall = new PositionedMovementSymbol(
				curveHitsCeilingSmallEmptyArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingSmallEmptyArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallSchemaArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-001-01-06-01");
		curveHitsCeilingSmallSchemaArrowheadSmall = new PositionedMovementSymbol(
				curveHitsCeilingSmallSchemaArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingSmallSchemaArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallMirroredSmallSymbol = symbolFactory.createSymbol("02-08-001-01-04-02");
		curveHitsCeilingSmallMirroredSmall = new PositionedMovementSymbol(curveHitsCeilingSmallMirroredSmallSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingSmallMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallEmptyArrowheadMirroredSmallSymbol = symbolFactory
				.createSymbol("02-08-001-01-05-02");
		curveHitsCeilingSmallEmptyArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsCeilingSmallEmptyArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingSmallEmptyArrowheadMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingSmallSchemaArrowheadMirroredSmallSymbol = symbolFactory
				.createSymbol("02-08-001-01-06-02");
		curveHitsCeilingSmallSchemaArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsCeilingSmallSchemaArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingSmallSchemaArrowheadMirroredSmallSymbol.getBaseSymbol()));

		curveHitsCeilingLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsCeilingLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-001-02-02-01");
		curveHitsCeilingLargeEmptyArrowhead = new PositionedMovementSymbol(curveHitsCeilingLargeEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-001-02-03-01");
		curveHitsCeilingLargeSchemaArrowhead = new PositionedMovementSymbol(curveHitsCeilingLargeSchemaArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeMirroredSymbol = symbolFactory.createSymbol("02-08-001-02-01-02");
		curveHitsCeilingLargeMirrored = new PositionedMovementSymbol(curveHitsCeilingLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingLargeMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-001-02-02-02");
		curveHitsCeilingLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsCeilingLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-001-02-03-02");
		curveHitsCeilingLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsCeilingLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol curveHitsCeilingLargeSmallSymbol = symbolFactory.createSymbol("02-08-001-02-04-01");
		curveHitsCeilingLargeSmall = new PositionedMovementSymbol(curveHitsCeilingLargeSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingLargeSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeEmptyArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-001-02-05-01");
		curveHitsCeilingLargeEmptyArrowheadSmall = new PositionedMovementSymbol(
				curveHitsCeilingLargeEmptyArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingLargeEmptyArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeSchemaArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-001-02-06-01");
		curveHitsCeilingLargeSchemaArrowheadSmall = new PositionedMovementSymbol(
				curveHitsCeilingLargeSchemaArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsCeilingLargeSchemaArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeMirroredSmallSymbol = symbolFactory.createSymbol("02-08-001-02-04-02");
		curveHitsCeilingLargeMirroredSmall = new PositionedMovementSymbol(curveHitsCeilingLargeMirroredSmallSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsCeilingLargeMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeEmptyArrowheadMirroredSmallSymbol = symbolFactory
				.createSymbol("02-08-001-02-05-02");
		curveHitsCeilingLargeEmptyArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsCeilingLargeEmptyArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingLargeEmptyArrowheadMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsCeilingLargeSchemaArrowheadMirroredSmallSymbol = symbolFactory
				.createSymbol("02-08-001-02-06-02");
		curveHitsCeilingLargeSchemaArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsCeilingLargeSchemaArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsCeilingLargeSchemaArrowheadMirroredSmallSymbol.getBaseSymbol()));

		humpHitsCeiling2HumpsSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-002-01-02-01");
		humpHitsCeiling2HumpsSmallEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsSmallEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-002-01-03-01");
		humpHitsCeiling2HumpsSmallSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsSmallMirroredSymbol = symbolFactory.createSymbol("02-08-002-01-01-02");
		humpHitsCeiling2HumpsSmallMirrored = new PositionedMovementSymbol(humpHitsCeiling2HumpsSmallMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsSmallMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsSmallEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-01-02-02");
		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling2HumpsSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsSmallSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-01-03-02");
		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling2HumpsSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsCeiling2HumpsLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_CEILING_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-002-02-02-01");
		humpHitsCeiling2HumpsLargeEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsLargeEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-002-02-03-01");
		humpHitsCeiling2HumpsLargeSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsLargeMirroredSymbol = symbolFactory.createSymbol("02-08-002-02-01-02");
		humpHitsCeiling2HumpsLargeMirrored = new PositionedMovementSymbol(humpHitsCeiling2HumpsLargeMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsCeiling2HumpsLargeMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsLargeEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-02-02-02");
		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling2HumpsLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling2HumpsLargeSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-02-03-02");
		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling2HumpsLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsCeiling3HumpsSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-002-03-02-01");
		humpHitsCeiling3HumpsSmallEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsSmallEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-002-03-03-01");
		humpHitsCeiling3HumpsSmallSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsSmallMirroredSymbol = symbolFactory.createSymbol("02-08-002-03-01-02");
		humpHitsCeiling3HumpsSmallMirrored = new PositionedMovementSymbol(humpHitsCeiling3HumpsSmallMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsSmallMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsSmallEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-03-02-02");
		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling3HumpsSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsSmallSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-03-03-02");
		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling3HumpsSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsCeiling3HumpsLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_CEILING_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-002-04-02-01");
		humpHitsCeiling3HumpsLargeEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsLargeEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-002-04-03-01");
		humpHitsCeiling3HumpsLargeSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsLargeMirroredSymbol = symbolFactory.createSymbol("02-08-002-04-01-02");
		humpHitsCeiling3HumpsLargeMirrored = new PositionedMovementSymbol(humpHitsCeiling3HumpsLargeMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsCeiling3HumpsLargeMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsLargeEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-04-02-02");
		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling3HumpsLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsCeiling3HumpsLargeSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-002-04-03-02");
		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsCeiling3HumpsLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsCeilingSmallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsCeilingSmallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-003-01-02-01");
		loopHitsCeilingSmallSingleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingSmallSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingSmallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-003-01-03-01");
		loopHitsCeilingSmallSingleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingSmallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingSmallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallSingleMirroredSymbol = symbolFactory.createSymbol("02-08-003-01-01-02");
		loopHitsCeilingSmallSingleMirrored = new PositionedMovementSymbol(loopHitsCeilingSmallSingleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsCeilingSmallSingleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-01-02-02");
		loopHitsCeilingSmallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingSmallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingSmallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-01-03-02");
		loopHitsCeilingSmallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingSmallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingSmallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsCeilingLargeSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsCeilingLargeSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-003-02-02-01");
		loopHitsCeilingLargeSingleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingLargeSingleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingLargeSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-003-02-03-01");
		loopHitsCeilingLargeSingleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingLargeSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingLargeSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeSingleMirroredSymbol = symbolFactory.createSymbol("02-08-003-02-01-02");
		loopHitsCeilingLargeSingleMirrored = new PositionedMovementSymbol(loopHitsCeilingLargeSingleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsCeilingLargeSingleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeSingleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-02-02-02");
		loopHitsCeilingLargeSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingLargeSingleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingLargeSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeSingleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-02-03-02");
		loopHitsCeilingLargeSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingLargeSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingLargeSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsCeilingSmallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_CEILING_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsCeilingSmallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-003-03-02-01");
		loopHitsCeilingSmallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingSmallDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingSmallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-003-03-03-01");
		loopHitsCeilingSmallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingSmallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingSmallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallDoubleMirroredSymbol = symbolFactory.createSymbol("02-08-003-03-01-02");
		loopHitsCeilingSmallDoubleMirrored = new PositionedMovementSymbol(loopHitsCeilingSmallDoubleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsCeilingSmallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-03-02-02");
		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingSmallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingSmallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingSmallDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-03-03-02");
		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingSmallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingSmallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsCeilingLargeDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_CEILING_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsCeilingLargeDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-003-04-02-01");
		loopHitsCeilingLargeDoubleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingLargeDoubleEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingLargeDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-003-04-03-01");
		loopHitsCeilingLargeDoubleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsCeilingLargeDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsCeilingLargeDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeDoubleMirroredSymbol = symbolFactory.createSymbol("02-08-003-04-01-02");
		loopHitsCeilingLargeDoubleMirrored = new PositionedMovementSymbol(loopHitsCeilingLargeDoubleMirroredSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsCeilingLargeDoubleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeDoubleEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-04-02-02");
		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingLargeDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingLargeDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsCeilingLargeDoubleSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-003-04-03-02");
		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsCeilingLargeDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsCeilingLargeDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveHitsCeilingSmall = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_CEILING_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsCeilingSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-004-01-02-01");
		waveHitsCeilingSmallEmptyArrowhead = new PositionedMovementSymbol(waveHitsCeilingSmallEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-004-01-03-01");
		waveHitsCeilingSmallSchemaArrowhead = new PositionedMovementSymbol(waveHitsCeilingSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingSmallMirroredSymbol = symbolFactory.createSymbol("02-08-004-01-01-02");
		waveHitsCeilingSmallMirrored = new PositionedMovementSymbol(waveHitsCeilingSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingSmallMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-004-01-02-02");
		waveHitsCeilingSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsCeilingSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsCeilingSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-004-01-03-02");
		waveHitsCeilingSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsCeilingSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsCeilingSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveHitsCeilingLarge = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_CEILING_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsCeilingLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-004-02-02-01");
		waveHitsCeilingLargeEmptyArrowhead = new PositionedMovementSymbol(waveHitsCeilingLargeEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-004-02-03-01");
		waveHitsCeilingLargeSchemaArrowhead = new PositionedMovementSymbol(waveHitsCeilingLargeSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingLargeMirroredSymbol = symbolFactory.createSymbol("02-08-004-02-01-02");
		waveHitsCeilingLargeMirrored = new PositionedMovementSymbol(waveHitsCeilingLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsCeilingLargeMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-004-02-02-02");
		waveHitsCeilingLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsCeilingLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsCeilingLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsCeilingLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-004-02-03-02");
		waveHitsCeilingLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsCeilingLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsCeilingLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationSingleHitsCeiling = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_SINGLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()));
		Symbol rotationSingleHitsCeilingEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-005-01-02-01");
		rotationSingleHitsCeilingEmptyArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsCeilingEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationSingleHitsCeilingEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsCeilingSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-005-01-03-01");
		rotationSingleHitsCeilingSchemaArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsCeilingSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationSingleHitsCeilingSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsCeilingMirroredSymbol = symbolFactory.createSymbol("02-08-005-01-01-02");
		rotationSingleHitsCeilingMirrored = new PositionedMovementSymbol(rotationSingleHitsCeilingMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsCeilingMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsCeilingEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-005-01-02-02");
		rotationSingleHitsCeilingEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleHitsCeilingEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleHitsCeilingEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsCeilingSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-005-01-03-02");
		rotationSingleHitsCeilingSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleHitsCeilingSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleHitsCeilingSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationDoubleHitsCeiling = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_DOUBLE_HITS_CEILING.getIswaSymbol().getBaseSymbol()));
		Symbol rotationDoubleHitsCeilingEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-006-01-02-01");
		rotationDoubleHitsCeilingEmptyArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsCeilingEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationDoubleHitsCeilingEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsCeilingSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-006-01-03-01");
		rotationDoubleHitsCeilingSchemaArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsCeilingSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationDoubleHitsCeilingSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsCeilingMirroredSymbol = symbolFactory.createSymbol("02-08-006-01-01-02");
		rotationDoubleHitsCeilingMirrored = new PositionedMovementSymbol(rotationDoubleHitsCeilingMirroredSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsCeilingMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsCeilingEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-006-01-02-02");
		rotationDoubleHitsCeilingEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleHitsCeilingEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleHitsCeilingEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsCeilingSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-006-01-03-02");
		rotationDoubleHitsCeilingSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleHitsCeilingSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleHitsCeilingSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationAlternatingHitsCeiling = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_ALTERNATING_HITS_CEILING.getIswaSymbol().getBaseSymbol()));
		Symbol rotationAlternatingHitsCeilingEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-007-01-02-01");
		rotationAlternatingHitsCeilingEmptyArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsCeilingEmptyArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsCeilingEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsCeilingSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-007-01-03-01");
		rotationAlternatingHitsCeilingSchemaArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsCeilingSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsCeilingSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsCeilingMirroredSymbol = symbolFactory.createSymbol("02-08-007-01-01-02");
		rotationAlternatingHitsCeilingMirrored = new PositionedMovementSymbol(
				rotationAlternatingHitsCeilingMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationAlternatingHitsCeilingMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsCeilingEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-007-01-02-02");
		rotationAlternatingHitsCeilingEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingHitsCeilingEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsCeilingEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsCeilingSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-007-01-03-02");
		rotationAlternatingHitsCeilingSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingHitsCeilingSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsCeilingSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		curveHitsFloorSmall = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsFloorSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-008-01-02-01");
		curveHitsFloorSmallEmptyArrowhead = new PositionedMovementSymbol(curveHitsFloorSmallEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-008-01-03-01");
		curveHitsFloorSmallSchemaArrowhead = new PositionedMovementSymbol(curveHitsFloorSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallMirroredSymbol = symbolFactory.createSymbol("02-08-008-01-01-02");
		curveHitsFloorSmallMirrored = new PositionedMovementSymbol(curveHitsFloorSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-008-01-02-02");
		curveHitsFloorSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsFloorSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-008-01-03-02");
		curveHitsFloorSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsFloorSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol curveHitsFloorSmallSmallSymbol = symbolFactory.createSymbol("02-08-008-01-04-01");
		curveHitsFloorSmallSmall = new PositionedMovementSymbol(curveHitsFloorSmallSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallEmptyArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-008-01-05-01");
		curveHitsFloorSmallEmptyArrowheadSmall = new PositionedMovementSymbol(
				curveHitsFloorSmallEmptyArrowheadSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallEmptyArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallSchemaArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-008-01-06-01");
		curveHitsFloorSmallSchemaArrowheadSmall = new PositionedMovementSymbol(
				curveHitsFloorSmallSchemaArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorSmallSchemaArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-01-04-02");
		curveHitsFloorSmallMirroredSmall = new PositionedMovementSymbol(curveHitsFloorSmallMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorSmallMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallEmptyArrowheadMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-01-05-02");
		curveHitsFloorSmallEmptyArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsFloorSmallEmptyArrowheadMirroredSmallSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveHitsFloorSmallEmptyArrowheadMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorSmallSchemaArrowheadMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-01-06-02");
		curveHitsFloorSmallSchemaArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsFloorSmallSchemaArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsFloorSmallSchemaArrowheadMirroredSmallSymbol.getBaseSymbol()));

		curveHitsFloorLarge = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsFloorLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-008-02-02-01");
		curveHitsFloorLargeEmptyArrowhead = new PositionedMovementSymbol(curveHitsFloorLargeEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-008-02-03-01");
		curveHitsFloorLargeSchemaArrowhead = new PositionedMovementSymbol(curveHitsFloorLargeSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeMirroredSymbol = symbolFactory.createSymbol("02-08-008-02-01-02");
		curveHitsFloorLargeMirrored = new PositionedMovementSymbol(curveHitsFloorLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-008-02-02-02");
		curveHitsFloorLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsFloorLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-008-02-03-02");
		curveHitsFloorLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveHitsFloorLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		Symbol curveHitsFloorLargeSmallSymbol = symbolFactory.createSymbol("02-08-008-02-04-01");
		curveHitsFloorLargeSmall = new PositionedMovementSymbol(curveHitsFloorLargeSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeEmptyArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-008-02-05-01");
		curveHitsFloorLargeEmptyArrowheadSmall = new PositionedMovementSymbol(
				curveHitsFloorLargeEmptyArrowheadSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeEmptyArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeSchemaArrowheadSmallSymbol = symbolFactory.createSymbol("02-08-008-02-06-01");
		curveHitsFloorLargeSchemaArrowheadSmall = new PositionedMovementSymbol(
				curveHitsFloorLargeSchemaArrowheadSmallSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveHitsFloorLargeSchemaArrowheadSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-02-04-02");
		curveHitsFloorLargeMirroredSmall = new PositionedMovementSymbol(curveHitsFloorLargeMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFloorLargeMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeEmptyArrowheadMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-02-05-02");
		curveHitsFloorLargeEmptyArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsFloorLargeEmptyArrowheadMirroredSmallSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveHitsFloorLargeEmptyArrowheadMirroredSmallSymbol.getBaseSymbol()));
		Symbol curveHitsFloorLargeSchemaArrowheadMirroredSmallSymbol = symbolFactory.createSymbol("02-08-008-02-06-02");
		curveHitsFloorLargeSchemaArrowheadMirroredSmall = new PositionedMovementSymbol(
				curveHitsFloorLargeSchemaArrowheadMirroredSmallSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						curveHitsFloorLargeSchemaArrowheadMirroredSmallSymbol.getBaseSymbol()));

		humpHitsFloor2HumpsSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsFloor2HumpsSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-009-01-02-01");
		humpHitsFloor2HumpsSmallEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsFloor2HumpsSmallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor2HumpsSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-009-01-03-01");
		humpHitsFloor2HumpsSmallSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsFloor2HumpsSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsFloor2HumpsSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsSmallMirroredSymbol = symbolFactory.createSymbol("02-08-009-01-01-02");
		humpHitsFloor2HumpsSmallMirrored = new PositionedMovementSymbol(humpHitsFloor2HumpsSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor2HumpsSmallMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-01-02-02");
		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor2HumpsSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor2HumpsSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-01-03-02");
		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor2HumpsSmallSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor2HumpsSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsFloor2HumpsLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_FLOOR_2_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsFloor2HumpsLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-009-02-02-01");
		humpHitsFloor2HumpsLargeEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsFloor2HumpsLargeEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor2HumpsLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-009-02-03-01");
		humpHitsFloor2HumpsLargeSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsFloor2HumpsLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsFloor2HumpsLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsLargeMirroredSymbol = symbolFactory.createSymbol("02-08-009-02-01-02");
		humpHitsFloor2HumpsLargeMirrored = new PositionedMovementSymbol(humpHitsFloor2HumpsLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor2HumpsLargeMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-02-02-02");
		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor2HumpsLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor2HumpsLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor2HumpsLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-02-03-02");
		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor2HumpsLargeSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor2HumpsLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsFloor3HumpsSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsFloor3HumpsSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-009-03-02-01");
		humpHitsFloor3HumpsSmallEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsFloor3HumpsSmallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor3HumpsSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-009-03-03-01");
		humpHitsFloor3HumpsSmallSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsFloor3HumpsSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsFloor3HumpsSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsSmallMirroredSymbol = symbolFactory.createSymbol("02-08-009-03-01-02");
		humpHitsFloor3HumpsSmallMirrored = new PositionedMovementSymbol(humpHitsFloor3HumpsSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor3HumpsSmallMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-03-02-02");
		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor3HumpsSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor3HumpsSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-03-03-02");
		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor3HumpsSmallSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor3HumpsSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpHitsFloor3HumpsLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_FLOOR_3_HUMPS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsFloor3HumpsLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-009-04-02-01");
		humpHitsFloor3HumpsLargeEmptyArrowhead = new PositionedMovementSymbol(
				humpHitsFloor3HumpsLargeEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor3HumpsLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-009-04-03-01");
		humpHitsFloor3HumpsLargeSchemaArrowhead = new PositionedMovementSymbol(
				humpHitsFloor3HumpsLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpHitsFloor3HumpsLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsLargeMirroredSymbol = symbolFactory.createSymbol("02-08-009-04-01-02");
		humpHitsFloor3HumpsLargeMirrored = new PositionedMovementSymbol(humpHitsFloor3HumpsLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFloor3HumpsLargeMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-04-02-02");
		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor3HumpsLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor3HumpsLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpHitsFloor3HumpsLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-009-04-03-02");
		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpHitsFloor3HumpsLargeSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						humpHitsFloor3HumpsLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsFloorSmallSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsFloorSmallSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-010-01-02-01");
		loopHitsFloorSmallSingleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsFloorSmallSingleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorSmallSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-010-01-03-01");
		loopHitsFloorSmallSingleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsFloorSmallSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsFloorSmallSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallSingleMirroredSymbol = symbolFactory.createSymbol("02-08-010-01-01-02");
		loopHitsFloorSmallSingleMirrored = new PositionedMovementSymbol(loopHitsFloorSmallSingleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorSmallSingleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallSingleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-01-02-02");
		loopHitsFloorSmallSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorSmallSingleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorSmallSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallSingleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-01-03-02");
		loopHitsFloorSmallSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorSmallSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorSmallSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsFloorLargeSingle = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_SINGLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsFloorLargeSingleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-010-02-02-01");
		loopHitsFloorLargeSingleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsFloorLargeSingleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorLargeSingleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeSingleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-010-02-03-01");
		loopHitsFloorLargeSingleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsFloorLargeSingleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsFloorLargeSingleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeSingleMirroredSymbol = symbolFactory.createSymbol("02-08-010-02-01-02");
		loopHitsFloorLargeSingleMirrored = new PositionedMovementSymbol(loopHitsFloorLargeSingleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorLargeSingleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeSingleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-02-02-02");
		loopHitsFloorLargeSingleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorLargeSingleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorLargeSingleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeSingleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-02-03-02");
		loopHitsFloorLargeSingleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorLargeSingleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorLargeSingleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsFloorSmallDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_FLOOR_SMALL_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsFloorSmallDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-010-03-02-01");
		loopHitsFloorSmallDoubleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsFloorSmallDoubleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorSmallDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-010-03-03-01");
		loopHitsFloorSmallDoubleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsFloorSmallDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsFloorSmallDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallDoubleMirroredSymbol = symbolFactory.createSymbol("02-08-010-03-01-02");
		loopHitsFloorSmallDoubleMirrored = new PositionedMovementSymbol(loopHitsFloorSmallDoubleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorSmallDoubleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallDoubleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-03-02-02");
		loopHitsFloorSmallDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorSmallDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorSmallDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorSmallDoubleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-03-03-02");
		loopHitsFloorSmallDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorSmallDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorSmallDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopHitsFloorLargeDouble = new PositionedMovementSymbol(
				MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_FLOOR_LARGE_DOUBLE.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsFloorLargeDoubleEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-010-04-02-01");
		loopHitsFloorLargeDoubleEmptyArrowhead = new PositionedMovementSymbol(
				loopHitsFloorLargeDoubleEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorLargeDoubleEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeDoubleSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-010-04-03-01");
		loopHitsFloorLargeDoubleSchemaArrowhead = new PositionedMovementSymbol(
				loopHitsFloorLargeDoubleSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopHitsFloorLargeDoubleSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeDoubleMirroredSymbol = symbolFactory.createSymbol("02-08-010-04-01-02");
		loopHitsFloorLargeDoubleMirrored = new PositionedMovementSymbol(loopHitsFloorLargeDoubleMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFloorLargeDoubleMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeDoubleEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-04-02-02");
		loopHitsFloorLargeDoubleEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorLargeDoubleEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorLargeDoubleEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopHitsFloorLargeDoubleSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-010-04-03-02");
		loopHitsFloorLargeDoubleSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopHitsFloorLargeDoubleSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						loopHitsFloorLargeDoubleSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveHitsFloorSmall = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_FLOOR_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsFloorSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-011-01-02-01");
		waveHitsFloorSmallEmptyArrowhead = new PositionedMovementSymbol(waveHitsFloorSmallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsFloorSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-011-01-03-01");
		waveHitsFloorSmallSchemaArrowhead = new PositionedMovementSymbol(waveHitsFloorSmallSchemaArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsFloorSmallMirroredSymbol = symbolFactory.createSymbol("02-08-011-01-01-02");
		waveHitsFloorSmallMirrored = new PositionedMovementSymbol(waveHitsFloorSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorSmallMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsFloorSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-011-01-02-02");
		waveHitsFloorSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsFloorSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsFloorSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsFloorSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-011-01-03-02");
		waveHitsFloorSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsFloorSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsFloorSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveHitsFloorLarge = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_FLOOR_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsFloorLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-011-02-02-01");
		waveHitsFloorLargeEmptyArrowhead = new PositionedMovementSymbol(waveHitsFloorLargeEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsFloorLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-011-02-03-01");
		waveHitsFloorLargeSchemaArrowhead = new PositionedMovementSymbol(waveHitsFloorLargeSchemaArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsFloorLargeMirroredSymbol = symbolFactory.createSymbol("02-08-011-02-01-02");
		waveHitsFloorLargeMirrored = new PositionedMovementSymbol(waveHitsFloorLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFloorLargeMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsFloorLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-011-02-02-02");
		waveHitsFloorLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsFloorLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsFloorLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveHitsFloorLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-011-02-03-02");
		waveHitsFloorLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveHitsFloorLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveHitsFloorLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationSingleHitsFloor = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_SINGLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()));
		Symbol rotationSingleHitsFloorEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-012-01-02-01");
		rotationSingleHitsFloorEmptyArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsFloorEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsFloorEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsFloorSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-012-01-03-01");
		rotationSingleHitsFloorSchemaArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsFloorSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsFloorSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsFloorMirroredSymbol = symbolFactory.createSymbol("02-08-012-01-01-02");
		rotationSingleHitsFloorMirrored = new PositionedMovementSymbol(rotationSingleHitsFloorMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsFloorMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsFloorEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-012-01-02-02");
		rotationSingleHitsFloorEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleHitsFloorEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleHitsFloorEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsFloorSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-012-01-03-02");
		rotationSingleHitsFloorSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleHitsFloorSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleHitsFloorSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationDoubleHitsFloor = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_DOUBLE_HITS_FLOOR.getIswaSymbol().getBaseSymbol()));
		Symbol rotationDoubleHitsFloorEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-013-01-02-01");
		rotationDoubleHitsFloorEmptyArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsFloorEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsFloorEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsFloorSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-013-01-03-01");
		rotationDoubleHitsFloorSchemaArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsFloorSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsFloorSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsFloorMirroredSymbol = symbolFactory.createSymbol("02-08-013-01-01-02");
		rotationDoubleHitsFloorMirrored = new PositionedMovementSymbol(rotationDoubleHitsFloorMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsFloorMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsFloorEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-013-01-02-02");
		rotationDoubleHitsFloorEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleHitsFloorEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleHitsFloorEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsFloorSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-08-013-01-03-02");
		rotationDoubleHitsFloorSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleHitsFloorSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleHitsFloorSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationAlternatingHitsFloor = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FLOOR.getIswaSymbol().getBaseSymbol()));
		Symbol rotationAlternatingHitsFloorEmptyArrowheadSymbol = symbolFactory.createSymbol("02-08-014-01-02-01");
		rotationAlternatingHitsFloorEmptyArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsFloorEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationAlternatingHitsFloorEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsFloorSchemaArrowheadSymbol = symbolFactory.createSymbol("02-08-014-01-03-01");
		rotationAlternatingHitsFloorSchemaArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsFloorSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationAlternatingHitsFloorSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsFloorMirroredSymbol = symbolFactory.createSymbol("02-08-014-01-01-02");
		rotationAlternatingHitsFloorMirrored = new PositionedMovementSymbol(rotationAlternatingHitsFloorMirroredSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationAlternatingHitsFloorMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsFloorEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-014-01-02-02");
		rotationAlternatingHitsFloorEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingHitsFloorEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsFloorEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsFloorSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-08-014-01-03-02");
		rotationAlternatingHitsFloorSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingHitsFloorSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsFloorSchemaArrowheadMirroredSymbol.getBaseSymbol()));

	}

	@Override
	public void testCanIncrease() {

		assertFalse(curveHitsCeilingSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canIncrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canIncrease());
		assertFalse(curveHitsCeilingSmallMirrored.canIncrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveHitsCeilingSmallSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canIncrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canIncrease());

		assertFalse(curveHitsCeilingLarge.canIncrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canIncrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canIncrease());
		assertFalse(curveHitsCeilingLargeMirrored.canIncrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveHitsCeilingLargeSmall.canIncrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canIncrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canIncrease());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canIncrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canIncrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canIncrease());

		assertFalse(humpHitsCeiling2HumpsSmall.canIncrease());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canIncrease());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canIncrease());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canIncrease());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsCeiling2HumpsLarge.canIncrease());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canIncrease());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canIncrease());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canIncrease());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsCeiling3HumpsSmall.canIncrease());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canIncrease());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canIncrease());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canIncrease());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsCeiling3HumpsLarge.canIncrease());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canIncrease());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canIncrease());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canIncrease());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsCeilingSmallSingle.canIncrease());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canIncrease());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsCeilingLargeSingle.canIncrease());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canIncrease());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsCeilingSmallDouble.canIncrease());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canIncrease());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsCeilingLargeDouble.canIncrease());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canIncrease());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveHitsCeilingSmall.canIncrease());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canIncrease());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canIncrease());
		assertFalse(waveHitsCeilingSmallMirrored.canIncrease());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveHitsCeilingLarge.canIncrease());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canIncrease());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canIncrease());
		assertFalse(waveHitsCeilingLargeMirrored.canIncrease());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canIncrease());

		assertTrue(rotationSingleHitsCeiling.canIncrease());
		assertTrue(rotationSingleHitsCeilingEmptyArrowhead.canIncrease());
		assertTrue(rotationSingleHitsCeilingSchemaArrowhead.canIncrease());
		assertTrue(rotationSingleHitsCeilingMirrored.canIncrease());
		assertTrue(rotationSingleHitsCeilingEmptyArrowheadMirrored.canIncrease());
		assertTrue(rotationSingleHitsCeilingSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationDoubleHitsCeiling.canIncrease());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsCeilingMirrored.canIncrease());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationAlternatingHitsCeiling.canIncrease());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canIncrease());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveHitsFloorSmall.canIncrease());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canIncrease());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canIncrease());
		assertFalse(curveHitsFloorSmallMirrored.canIncrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveHitsFloorSmallSmall.canIncrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canIncrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canIncrease());
		assertFalse(curveHitsFloorSmallMirroredSmall.canIncrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canIncrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canIncrease());

		assertFalse(curveHitsFloorLarge.canIncrease());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canIncrease());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canIncrease());
		assertFalse(curveHitsFloorLargeMirrored.canIncrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveHitsFloorLargeSmall.canIncrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canIncrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canIncrease());
		assertFalse(curveHitsFloorLargeMirroredSmall.canIncrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canIncrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canIncrease());

		assertFalse(humpHitsFloor2HumpsSmall.canIncrease());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canIncrease());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canIncrease());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canIncrease());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsFloor2HumpsLarge.canIncrease());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canIncrease());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canIncrease());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canIncrease());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsFloor3HumpsSmall.canIncrease());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canIncrease());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canIncrease());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canIncrease());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpHitsFloor3HumpsLarge.canIncrease());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canIncrease());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canIncrease());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canIncrease());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsFloorSmallSingle.canIncrease());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsFloorSmallSingleMirrored.canIncrease());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsFloorLargeSingle.canIncrease());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsFloorLargeSingleMirrored.canIncrease());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsFloorSmallDouble.canIncrease());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canIncrease());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopHitsFloorLargeDouble.canIncrease());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canIncrease());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canIncrease());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canIncrease());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveHitsFloorSmall.canIncrease());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canIncrease());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canIncrease());
		assertFalse(waveHitsFloorSmallMirrored.canIncrease());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveHitsFloorLarge.canIncrease());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canIncrease());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canIncrease());
		assertFalse(waveHitsFloorLargeMirrored.canIncrease());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canIncrease());

		assertTrue(rotationSingleHitsFloor.canIncrease());
		assertTrue(rotationSingleHitsFloorEmptyArrowhead.canIncrease());
		assertTrue(rotationSingleHitsFloorSchemaArrowhead.canIncrease());
		assertTrue(rotationSingleHitsFloorMirrored.canIncrease());
		assertTrue(rotationSingleHitsFloorEmptyArrowheadMirrored.canIncrease());
		assertTrue(rotationSingleHitsFloorSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationDoubleHitsFloor.canIncrease());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsFloorMirrored.canIncrease());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationAlternatingHitsFloor.canIncrease());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsFloorMirrored.canIncrease());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canIncrease());

	}

	@Override
	public void testIncrease() {

		rotationSingleHitsCeiling.increase();
		assertEquals(rotationDoubleHitsCeiling.getSymbol(), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.increase();
		assertEquals(rotationDoubleHitsCeilingEmptyArrowhead.getSymbol(),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.increase();
		assertEquals(rotationDoubleHitsCeilingSchemaArrowhead.getSymbol(),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingMirrored.increase();
		assertEquals(rotationDoubleHitsCeilingMirrored.getSymbol(), rotationSingleHitsCeilingMirrored.getSymbol());
		rotationSingleHitsCeilingEmptyArrowheadMirrored.increase();
		assertEquals(rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol(),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingSchemaArrowheadMirrored.increase();
		assertEquals(rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol(),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsFloor.increase();
		assertEquals(rotationDoubleHitsFloor.getSymbol(), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.increase();
		assertEquals(rotationDoubleHitsFloorEmptyArrowhead.getSymbol(),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.increase();
		assertEquals(rotationDoubleHitsFloorSchemaArrowhead.getSymbol(),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorMirrored.increase();
		assertEquals(rotationDoubleHitsFloorMirrored.getSymbol(), rotationSingleHitsFloorMirrored.getSymbol());
		rotationSingleHitsFloorEmptyArrowheadMirrored.increase();
		assertEquals(rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol(),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorSchemaArrowheadMirrored.increase();
		assertEquals(rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol(),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanDecrease() {

		assertFalse(curveHitsCeilingSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canDecrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canDecrease());
		assertFalse(curveHitsCeilingSmallMirrored.canDecrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveHitsCeilingSmallSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canDecrease());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canDecrease());

		assertFalse(curveHitsCeilingLarge.canDecrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canDecrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canDecrease());
		assertFalse(curveHitsCeilingLargeMirrored.canDecrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveHitsCeilingLargeSmall.canDecrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canDecrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canDecrease());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canDecrease());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canDecrease());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canDecrease());

		assertFalse(humpHitsCeiling2HumpsSmall.canDecrease());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canDecrease());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canDecrease());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canDecrease());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsCeiling2HumpsLarge.canDecrease());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canDecrease());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canDecrease());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canDecrease());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsCeiling3HumpsSmall.canDecrease());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canDecrease());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canDecrease());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canDecrease());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsCeiling3HumpsLarge.canDecrease());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canDecrease());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canDecrease());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canDecrease());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsCeilingSmallSingle.canDecrease());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canDecrease());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsCeilingLargeSingle.canDecrease());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canDecrease());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsCeilingSmallDouble.canDecrease());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canDecrease());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsCeilingLargeDouble.canDecrease());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canDecrease());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveHitsCeilingSmall.canDecrease());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canDecrease());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canDecrease());
		assertFalse(waveHitsCeilingSmallMirrored.canDecrease());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveHitsCeilingLarge.canDecrease());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canDecrease());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canDecrease());
		assertFalse(waveHitsCeilingLargeMirrored.canDecrease());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationSingleHitsCeiling.canDecrease());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canDecrease());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canDecrease());
		assertFalse(rotationSingleHitsCeilingMirrored.canDecrease());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canDecrease());

		assertTrue(rotationDoubleHitsCeiling.canDecrease());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsCeilingMirrored.canDecrease());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canDecrease());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationAlternatingHitsCeiling.canDecrease());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canDecrease());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveHitsFloorSmall.canDecrease());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canDecrease());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canDecrease());
		assertFalse(curveHitsFloorSmallMirrored.canDecrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveHitsFloorSmallSmall.canDecrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canDecrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canDecrease());
		assertFalse(curveHitsFloorSmallMirroredSmall.canDecrease());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canDecrease());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canDecrease());

		assertFalse(curveHitsFloorLarge.canDecrease());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canDecrease());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canDecrease());
		assertFalse(curveHitsFloorLargeMirrored.canDecrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveHitsFloorLargeSmall.canDecrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canDecrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canDecrease());
		assertFalse(curveHitsFloorLargeMirroredSmall.canDecrease());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canDecrease());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canDecrease());

		assertFalse(humpHitsFloor2HumpsSmall.canDecrease());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canDecrease());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canDecrease());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canDecrease());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsFloor2HumpsLarge.canDecrease());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canDecrease());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canDecrease());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canDecrease());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsFloor3HumpsSmall.canDecrease());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canDecrease());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canDecrease());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canDecrease());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpHitsFloor3HumpsLarge.canDecrease());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canDecrease());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canDecrease());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canDecrease());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsFloorSmallSingle.canDecrease());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsFloorSmallSingleMirrored.canDecrease());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsFloorLargeSingle.canDecrease());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsFloorLargeSingleMirrored.canDecrease());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsFloorSmallDouble.canDecrease());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canDecrease());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopHitsFloorLargeDouble.canDecrease());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canDecrease());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canDecrease());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canDecrease());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveHitsFloorSmall.canDecrease());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canDecrease());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canDecrease());
		assertFalse(waveHitsFloorSmallMirrored.canDecrease());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveHitsFloorLarge.canDecrease());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canDecrease());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canDecrease());
		assertFalse(waveHitsFloorLargeMirrored.canDecrease());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationSingleHitsFloor.canDecrease());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canDecrease());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canDecrease());
		assertFalse(rotationSingleHitsFloorMirrored.canDecrease());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canDecrease());

		assertTrue(rotationDoubleHitsFloor.canDecrease());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsFloorMirrored.canDecrease());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canDecrease());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationAlternatingHitsFloor.canDecrease());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsFloorMirrored.canDecrease());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canDecrease());
	}

	@Override
	public void testDecrease() {

		rotationDoubleHitsCeiling.decrease();
		assertEquals(rotationSingleHitsCeiling.getSymbol(), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.decrease();
		assertEquals(rotationSingleHitsCeilingEmptyArrowhead.getSymbol(),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.decrease();
		assertEquals(rotationSingleHitsCeilingSchemaArrowhead.getSymbol(),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingMirrored.decrease();
		assertEquals(rotationSingleHitsCeilingMirrored.getSymbol(), rotationDoubleHitsCeilingMirrored.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowheadMirrored.decrease();
		assertEquals(rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowheadMirrored.decrease();
		assertEquals(rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloor.decrease();
		assertEquals(rotationSingleHitsFloor.getSymbol(), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.decrease();
		assertEquals(rotationSingleHitsFloorEmptyArrowhead.getSymbol(),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.decrease();
		assertEquals(rotationSingleHitsFloorSchemaArrowhead.getSymbol(),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorMirrored.decrease();
		assertEquals(rotationSingleHitsFloorMirrored.getSymbol(), rotationDoubleHitsFloorMirrored.getSymbol());
		rotationDoubleHitsFloorEmptyArrowheadMirrored.decrease();
		assertEquals(rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorSchemaArrowheadMirrored.decrease();
		assertEquals(rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertTrue(curveHitsCeilingSmall.canRotate());
		assertTrue(curveHitsCeilingSmallEmptyArrowhead.canRotate());
		assertTrue(curveHitsCeilingSmallSchemaArrowhead.canRotate());
		assertTrue(curveHitsCeilingSmallMirrored.canRotate());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(curveHitsCeilingSmallSmall.canRotate());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadSmall.canRotate());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadSmall.canRotate());
		assertTrue(curveHitsCeilingSmallMirroredSmall.canRotate());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canRotate());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canRotate());

		assertTrue(curveHitsCeilingLarge.canRotate());
		assertTrue(curveHitsCeilingLargeEmptyArrowhead.canRotate());
		assertTrue(curveHitsCeilingLargeSchemaArrowhead.canRotate());
		assertTrue(curveHitsCeilingLargeMirrored.canRotate());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(curveHitsCeilingLargeSmall.canRotate());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadSmall.canRotate());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadSmall.canRotate());
		assertTrue(curveHitsCeilingLargeMirroredSmall.canRotate());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canRotate());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canRotate());

		assertTrue(humpHitsCeiling2HumpsSmall.canRotate());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowhead.canRotate());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowhead.canRotate());
		assertTrue(humpHitsCeiling2HumpsSmallMirrored.canRotate());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsCeiling2HumpsLarge.canRotate());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowhead.canRotate());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowhead.canRotate());
		assertTrue(humpHitsCeiling2HumpsLargeMirrored.canRotate());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsCeiling3HumpsSmall.canRotate());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowhead.canRotate());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowhead.canRotate());
		assertTrue(humpHitsCeiling3HumpsSmallMirrored.canRotate());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsCeiling3HumpsLarge.canRotate());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowhead.canRotate());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowhead.canRotate());
		assertTrue(humpHitsCeiling3HumpsLargeMirrored.canRotate());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsCeilingSmallSingle.canRotate());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowhead.canRotate());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowhead.canRotate());
		assertTrue(loopHitsCeilingSmallSingleMirrored.canRotate());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsCeilingLargeSingle.canRotate());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowhead.canRotate());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowhead.canRotate());
		assertTrue(loopHitsCeilingLargeSingleMirrored.canRotate());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsCeilingSmallDouble.canRotate());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowhead.canRotate());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowhead.canRotate());
		assertTrue(loopHitsCeilingSmallDoubleMirrored.canRotate());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsCeilingLargeDouble.canRotate());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowhead.canRotate());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowhead.canRotate());
		assertTrue(loopHitsCeilingLargeDoubleMirrored.canRotate());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(waveHitsCeilingSmall.canRotate());
		assertTrue(waveHitsCeilingSmallEmptyArrowhead.canRotate());
		assertTrue(waveHitsCeilingSmallSchemaArrowhead.canRotate());
		assertTrue(waveHitsCeilingSmallMirrored.canRotate());
		assertTrue(waveHitsCeilingSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(waveHitsCeilingSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(waveHitsCeilingLarge.canRotate());
		assertTrue(waveHitsCeilingLargeEmptyArrowhead.canRotate());
		assertTrue(waveHitsCeilingLargeSchemaArrowhead.canRotate());
		assertTrue(waveHitsCeilingLargeMirrored.canRotate());
		assertTrue(waveHitsCeilingLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(waveHitsCeilingLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationSingleHitsCeiling.canRotate());
		assertTrue(rotationSingleHitsCeilingEmptyArrowhead.canRotate());
		assertTrue(rotationSingleHitsCeilingSchemaArrowhead.canRotate());
		assertTrue(rotationSingleHitsCeilingMirrored.canRotate());
		assertTrue(rotationSingleHitsCeilingEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationSingleHitsCeilingSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationDoubleHitsCeiling.canRotate());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canRotate());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canRotate());
		assertTrue(rotationDoubleHitsCeilingMirrored.canRotate());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationAlternatingHitsCeiling.canRotate());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsCeilingMirrored.canRotate());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canRotate());

		assertTrue(curveHitsFloorSmall.canRotate());
		assertTrue(curveHitsFloorSmallEmptyArrowhead.canRotate());
		assertTrue(curveHitsFloorSmallSchemaArrowhead.canRotate());
		assertTrue(curveHitsFloorSmallMirrored.canRotate());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(curveHitsFloorSmallSmall.canRotate());
		assertTrue(curveHitsFloorSmallEmptyArrowheadSmall.canRotate());
		assertTrue(curveHitsFloorSmallSchemaArrowheadSmall.canRotate());
		assertTrue(curveHitsFloorSmallMirroredSmall.canRotate());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canRotate());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canRotate());

		assertTrue(curveHitsFloorLarge.canRotate());
		assertTrue(curveHitsFloorLargeEmptyArrowhead.canRotate());
		assertTrue(curveHitsFloorLargeSchemaArrowhead.canRotate());
		assertTrue(curveHitsFloorLargeMirrored.canRotate());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(curveHitsFloorLargeSmall.canRotate());
		assertTrue(curveHitsFloorLargeEmptyArrowheadSmall.canRotate());
		assertTrue(curveHitsFloorLargeSchemaArrowheadSmall.canRotate());
		assertTrue(curveHitsFloorLargeMirroredSmall.canRotate());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canRotate());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canRotate());

		assertTrue(humpHitsFloor2HumpsSmall.canRotate());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowhead.canRotate());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowhead.canRotate());
		assertTrue(humpHitsFloor2HumpsSmallMirrored.canRotate());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsFloor2HumpsLarge.canRotate());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowhead.canRotate());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowhead.canRotate());
		assertTrue(humpHitsFloor2HumpsLargeMirrored.canRotate());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsFloor3HumpsSmall.canRotate());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowhead.canRotate());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowhead.canRotate());
		assertTrue(humpHitsFloor3HumpsSmallMirrored.canRotate());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(humpHitsFloor3HumpsLarge.canRotate());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowhead.canRotate());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowhead.canRotate());
		assertTrue(humpHitsFloor3HumpsLargeMirrored.canRotate());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsFloorSmallSingle.canRotate());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowhead.canRotate());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowhead.canRotate());
		assertTrue(loopHitsFloorSmallSingleMirrored.canRotate());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsFloorLargeSingle.canRotate());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowhead.canRotate());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowhead.canRotate());
		assertTrue(loopHitsFloorLargeSingleMirrored.canRotate());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsFloorSmallDouble.canRotate());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowhead.canRotate());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowhead.canRotate());
		assertTrue(loopHitsFloorSmallDoubleMirrored.canRotate());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(loopHitsFloorLargeDouble.canRotate());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowhead.canRotate());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowhead.canRotate());
		assertTrue(loopHitsFloorLargeDoubleMirrored.canRotate());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canRotate());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canRotate());

		assertTrue(waveHitsFloorSmall.canRotate());
		assertTrue(waveHitsFloorSmallEmptyArrowhead.canRotate());
		assertTrue(waveHitsFloorSmallSchemaArrowhead.canRotate());
		assertTrue(waveHitsFloorSmallMirrored.canRotate());
		assertTrue(waveHitsFloorSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(waveHitsFloorSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(waveHitsFloorLarge.canRotate());
		assertTrue(waveHitsFloorLargeEmptyArrowhead.canRotate());
		assertTrue(waveHitsFloorLargeSchemaArrowhead.canRotate());
		assertTrue(waveHitsFloorLargeMirrored.canRotate());
		assertTrue(waveHitsFloorLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(waveHitsFloorLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationSingleHitsFloor.canRotate());
		assertTrue(rotationSingleHitsFloorEmptyArrowhead.canRotate());
		assertTrue(rotationSingleHitsFloorSchemaArrowhead.canRotate());
		assertTrue(rotationSingleHitsFloorMirrored.canRotate());
		assertTrue(rotationSingleHitsFloorEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationSingleHitsFloorSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationDoubleHitsFloor.canRotate());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canRotate());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canRotate());
		assertTrue(rotationDoubleHitsFloorMirrored.canRotate());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationAlternatingHitsFloor.canRotate());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsFloorMirrored.canRotate());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-08"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-07"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-06"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-05"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-04"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-03"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-08"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-07"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-06"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-05"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-04"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-03"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());

		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-08"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-07"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-06"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-05"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-04"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-03"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());

		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-08"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-07"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-06"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-05"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-04"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-03"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-08"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-07"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-06"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-05"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-04"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-03"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-08"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-07"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-06"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-05"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-04"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-03"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-08"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-07"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-06"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-05"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-04"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-03"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLarge.getSymbol());

		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-08"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-07"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-06"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-05"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-04"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-03"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());

		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-08"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-07"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-06"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-05"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-04"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-03"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());

		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-08"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-07"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-06"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-05"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-04"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-03"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-08"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-07"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-06"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-05"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-04"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-03"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-08"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-07"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-06"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-05"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-04"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-03"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());

		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-08"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-07"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-06"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-05"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-04"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-03"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmall.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-08"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-07"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-06"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-05"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-04"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-03"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-08"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-07"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-06"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-05"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-04"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-03"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-08"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-07"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-06"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-05"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-04"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-03"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLarge.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-08"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-07"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-06"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-05"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-04"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-03"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-08"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-07"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-06"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-05"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-04"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-03"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-08"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-07"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-06"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-05"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-04"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-03"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmall.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-08"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-07"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-06"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-05"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-04"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-03"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-08"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-07"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-06"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-05"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-04"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-03"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-08"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-07"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-06"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-05"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-04"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-03"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLarge.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-08"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-07"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-06"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-05"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-04"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-03"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-08"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-07"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-06"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-05"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-04"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-03"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-08"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-07"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-06"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-05"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-04"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-03"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingle.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-08"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-07"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-06"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-05"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-04"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-03"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-08"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-07"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-06"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-05"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-04"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-03"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-08"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-07"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-06"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-05"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-04"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-03"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingle.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-08"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-07"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-06"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-05"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-04"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-03"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-08"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-07"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-06"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-05"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-04"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-03"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-08"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-07"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-06"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-05"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-04"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-03"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDouble.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-08"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-07"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-06"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-05"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-04"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-03"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-08"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-07"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-06"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-05"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-04"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-03"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-08"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-07"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-06"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-05"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-04"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-03"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDouble.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-08"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-07"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-06"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-05"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-04"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-03"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-08"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-07"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-06"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-05"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-04"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-03"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());

		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-08"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-07"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-06"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-05"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-04"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-03"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmall.getSymbol());

		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-08"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-07"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-06"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-05"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-04"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-03"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());

		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-08"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-07"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-06"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-05"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-04"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-03"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());

		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-08"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-07"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-06"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-05"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-04"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-03"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLarge.getSymbol());

		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-08"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-07"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-06"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-05"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-04"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-03"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());

		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-08"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-07"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-06"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-05"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-04"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-03"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());

		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-08"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-07"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-06"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-05"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-04"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-03"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeiling.getSymbol());

		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-08"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-07"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-06"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-05"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-04"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-03"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());

		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-08"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-07"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-06"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-05"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-04"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-03"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-08"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-07"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-06"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-05"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-04"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-03"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-08"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-07"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-06"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-05"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-04"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-03"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-08"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-07"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-06"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-05"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-04"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-03"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-08"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-07"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-06"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-05"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-04"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-03"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-08"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-07"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-06"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-05"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-04"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-03"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-08"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-07"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-06"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-05"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-04"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-03"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-08"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-07"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-06"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-05"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-04"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-03"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-08"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-07"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-06"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-05"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-04"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-03"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());

		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-08"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-07"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-06"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-05"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-04"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-03"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());

		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-08"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-07"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-06"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-05"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-04"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-03"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"), curveHitsFloorSmallSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-08"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-07"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-06"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-05"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-04"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-03"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-08"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-07"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-06"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-05"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-04"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-03"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());

		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-08"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-07"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-06"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-05"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-04"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-03"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLarge.getSymbol());

		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-08"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-07"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-06"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-05"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-04"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-03"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());

		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-08"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-07"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-06"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-05"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-04"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-03"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());

		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-08"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-07"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-06"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-05"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-04"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-03"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"), curveHitsFloorLargeSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-08"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-07"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-06"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-05"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-04"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-03"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-08"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-07"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-06"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-05"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-04"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-03"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());

		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-08"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-07"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-06"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-05"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-04"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-03"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"), humpHitsFloor2HumpsSmall.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-08"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-07"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-06"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-05"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-04"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-03"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-08"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-07"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-06"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-05"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-04"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-03"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-08"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-07"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-06"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-05"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-04"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-03"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"), humpHitsFloor2HumpsLarge.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-08"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-07"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-06"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-05"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-04"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-03"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-08"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-07"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-06"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-05"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-04"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-03"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-08"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-07"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-06"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-05"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-04"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-03"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"), humpHitsFloor3HumpsSmall.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-08"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-07"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-06"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-05"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-04"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-03"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-08"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-07"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-06"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-05"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-04"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-03"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-08"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-07"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-06"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-05"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-04"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-03"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"), humpHitsFloor3HumpsLarge.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-08"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-07"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-06"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-05"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-04"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-03"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-08"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-07"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-06"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-05"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-04"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-03"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());

		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-08"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-07"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-06"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-05"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-04"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-03"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"), loopHitsFloorSmallSingle.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-08"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-07"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-06"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-05"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-04"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-03"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-08"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-07"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-06"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-05"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-04"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-03"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-08"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-07"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-06"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-05"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-04"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-03"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"), loopHitsFloorLargeSingle.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-08"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-07"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-06"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-05"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-04"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-03"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-08"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-07"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-06"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-05"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-04"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-03"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-08"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-07"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-06"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-05"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-04"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-03"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"), loopHitsFloorSmallDouble.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-08"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-07"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-06"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-05"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-04"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-03"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-08"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-07"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-06"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-05"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-04"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-03"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-08"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-07"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-06"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-05"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-04"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-03"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"), loopHitsFloorLargeDouble.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-08"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-07"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-06"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-05"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-04"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-03"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-08"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-07"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-06"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-05"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-04"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-03"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());

		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-08"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-07"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-06"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-05"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-04"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-03"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmall.getSymbol());

		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-08"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-07"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-06"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-05"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-04"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-03"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());

		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-08"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-07"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-06"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-05"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-04"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-03"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());

		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-08"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-07"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-06"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-05"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-04"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-03"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLarge.getSymbol());

		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-08"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-07"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-06"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-05"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-04"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-03"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());

		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-08"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-07"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-06"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-05"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-04"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-03"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());

		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-08"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-07"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-06"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-05"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-04"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-03"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"), rotationSingleHitsFloor.getSymbol());

		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-08"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-07"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-06"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-05"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-04"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-03"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());

		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-08"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-07"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-06"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-05"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-04"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-03"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());

		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-08"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-07"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-06"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-05"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-04"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-03"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"), rotationDoubleHitsFloor.getSymbol());

		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-08"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-07"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-06"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-05"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-04"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-03"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());

		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-08"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-07"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-06"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-05"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-04"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-03"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-08"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-07"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-06"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-05"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-04"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-03"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"), rotationAlternatingHitsFloor.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-08"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-07"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-06"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-05"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-04"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-03"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-08"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-07"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-06"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-05"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-04"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-03"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-03"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-04"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-05"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-06"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-07"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-08"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-03"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-04"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-05"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-06"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-07"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-08"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());

		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-03"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-04"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-05"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-06"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-07"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-08"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());

		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-03"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-04"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-05"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-06"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-07"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-08"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-03"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-04"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-05"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-06"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-07"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-08"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-03"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-04"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-05"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-06"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-07"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-08"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-03"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-04"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-05"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-06"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-07"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-08"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLarge.getSymbol());

		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-03"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-04"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-05"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-06"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-07"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-08"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());

		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-03"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-04"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-05"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-06"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-07"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-08"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());

		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-03"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-04"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-05"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-06"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-07"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-08"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-03"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-04"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-05"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-06"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-07"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-08"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-03"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-04"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-05"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-06"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-07"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-08"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());

		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-03"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-04"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-05"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-06"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-07"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-08"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmall.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-03"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-04"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-05"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-06"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-07"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-08"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-03"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-04"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-05"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-06"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-07"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-08"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-03"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-04"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-05"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-06"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-07"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-08"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLarge.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-03"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-04"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-05"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-06"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-07"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-08"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-03"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-04"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-05"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-06"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-07"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-08"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-03"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-04"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-05"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-06"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-07"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-08"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmall.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-03"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-04"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-05"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-06"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-07"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-08"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-03"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-04"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-05"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-06"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-07"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-08"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-03"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-04"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-05"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-06"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-07"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-08"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLarge.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-03"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-04"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-05"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-06"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-07"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-08"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-03"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-04"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-05"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-06"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-07"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-08"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-03"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-04"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-05"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-06"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-07"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-08"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingle.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-03"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-04"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-05"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-06"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-07"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-08"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-03"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-04"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-05"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-06"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-07"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-08"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-03"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-04"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-05"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-06"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-07"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-08"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingle.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-03"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-04"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-05"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-06"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-07"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-08"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-03"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-04"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-05"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-06"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-07"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-08"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-03"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-04"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-05"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-06"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-07"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-08"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDouble.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-03"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-04"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-05"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-06"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-07"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-08"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-03"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-04"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-05"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-06"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-07"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-08"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-03"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-04"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-05"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-06"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-07"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-08"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDouble.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-03"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-04"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-05"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-06"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-07"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-08"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-03"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-04"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-05"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-06"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-07"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-08"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());

		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-03"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-04"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-05"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-06"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-07"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-08"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmall.getSymbol());

		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-03"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-04"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-05"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-06"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-07"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-08"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());

		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-03"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-04"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-05"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-06"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-07"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-08"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());

		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-03"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-04"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-05"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-06"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-07"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-08"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLarge.getSymbol());

		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-03"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-04"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-05"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-06"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-07"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-08"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());

		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-03"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-04"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-05"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-06"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-07"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-08"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());

		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-03"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-04"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-05"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-06"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-07"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-08"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeiling.getSymbol());

		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-03"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-04"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-05"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-06"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-07"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-08"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());

		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-03"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-04"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-05"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-06"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-07"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-08"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-03"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-04"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-05"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-06"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-07"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-08"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-03"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-04"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-05"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-06"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-07"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-08"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-03"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-04"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-05"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-06"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-07"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-08"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-03"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-04"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-05"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-06"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-07"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-08"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-03"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-04"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-05"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-06"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-07"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-08"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-03"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-04"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-05"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-06"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-07"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-08"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-03"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-04"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-05"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-06"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-07"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-08"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-03"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-04"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-05"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-06"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-07"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-08"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());

		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-03"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-04"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-05"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-06"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-07"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-08"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());

		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-03"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-04"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-05"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-06"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-07"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-08"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"), curveHitsFloorSmallSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-03"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-04"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-05"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-06"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-07"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-08"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-03"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-04"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-05"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-06"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-07"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-08"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());

		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-03"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-04"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-05"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-06"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-07"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-08"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLarge.getSymbol());

		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-03"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-04"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-05"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-06"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-07"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-08"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());

		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-03"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-04"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-05"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-06"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-07"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-08"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());

		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-03"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-04"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-05"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-06"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-07"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-08"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"), curveHitsFloorLargeSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-03"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-04"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-05"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-06"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-07"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-08"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-03"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-04"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-05"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-06"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-07"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-08"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());

		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-03"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-04"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-05"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-06"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-07"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-08"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"), humpHitsFloor2HumpsSmall.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-03"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-04"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-05"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-06"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-07"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-08"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-03"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-04"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-05"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-06"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-07"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-08"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-03"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-04"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-05"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-06"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-07"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-08"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"), humpHitsFloor2HumpsLarge.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-03"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-04"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-05"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-06"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-07"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-08"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-03"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-04"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-05"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-06"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-07"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-08"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-03"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-04"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-05"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-06"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-07"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-08"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"), humpHitsFloor3HumpsSmall.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-03"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-04"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-05"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-06"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-07"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-08"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-03"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-04"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-05"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-06"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-07"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-08"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-03"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-04"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-05"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-06"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-07"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-08"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"), humpHitsFloor3HumpsLarge.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-03"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-04"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-05"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-06"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-07"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-08"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-03"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-04"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-05"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-06"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-07"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-08"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());

		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-03"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-04"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-05"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-06"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-07"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-08"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"), loopHitsFloorSmallSingle.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-03"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-04"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-05"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-06"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-07"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-08"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-03"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-04"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-05"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-06"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-07"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-08"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-03"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-04"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-05"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-06"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-07"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-08"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"), loopHitsFloorLargeSingle.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-03"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-04"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-05"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-06"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-07"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-08"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-03"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-04"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-05"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-06"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-07"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-08"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-03"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-04"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-05"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-06"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-07"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-08"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"), loopHitsFloorSmallDouble.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-03"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-04"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-05"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-06"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-07"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-08"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-03"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-04"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-05"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-06"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-07"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-08"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-03"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-04"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-05"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-06"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-07"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-08"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"), loopHitsFloorLargeDouble.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-03"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-04"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-05"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-06"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-07"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-08"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-03"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-04"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-05"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-06"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-07"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-08"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());

		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-03"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-04"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-05"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-06"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-07"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-08"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmall.getSymbol());

		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-03"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-04"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-05"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-06"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-07"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-08"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());

		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-03"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-04"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-05"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-06"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-07"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-08"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());

		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-03"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-04"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-05"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-06"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-07"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-08"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLarge.getSymbol());

		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-03"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-04"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-05"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-06"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-07"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-08"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());

		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-03"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-04"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-05"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-06"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-07"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-08"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());

		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-03"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-04"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-05"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-06"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-07"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-08"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"), rotationSingleHitsFloor.getSymbol());

		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-03"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-04"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-05"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-06"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-07"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-08"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());

		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-03"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-04"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-05"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-06"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-07"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-08"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());

		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-03"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-04"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-05"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-06"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-07"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-08"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"), rotationDoubleHitsFloor.getSymbol());

		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-03"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-04"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-05"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-06"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-07"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-08"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());

		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-03"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-04"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-05"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-06"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-07"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-08"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-03"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-04"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-05"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-06"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-07"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-08"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"), rotationAlternatingHitsFloor.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-03"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-04"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-05"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-06"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-07"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-08"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-03"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-04"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-05"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-06"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-07"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-08"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(curveHitsCeilingSmall.canMirror());
		assertTrue(curveHitsCeilingSmallEmptyArrowhead.canMirror());
		assertTrue(curveHitsCeilingSmallSchemaArrowhead.canMirror());
		assertTrue(curveHitsCeilingSmallMirrored.canMirror());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(curveHitsCeilingSmallSmall.canMirror());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadSmall.canMirror());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadSmall.canMirror());
		assertTrue(curveHitsCeilingSmallMirroredSmall.canMirror());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canMirror());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canMirror());

		assertTrue(curveHitsCeilingLarge.canMirror());
		assertTrue(curveHitsCeilingLargeEmptyArrowhead.canMirror());
		assertTrue(curveHitsCeilingLargeSchemaArrowhead.canMirror());
		assertTrue(curveHitsCeilingLargeMirrored.canMirror());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(curveHitsCeilingLargeSmall.canMirror());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadSmall.canMirror());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadSmall.canMirror());
		assertTrue(curveHitsCeilingLargeMirroredSmall.canMirror());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canMirror());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canMirror());

		assertTrue(humpHitsCeiling2HumpsSmall.canMirror());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowhead.canMirror());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowhead.canMirror());
		assertTrue(humpHitsCeiling2HumpsSmallMirrored.canMirror());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsCeiling2HumpsLarge.canMirror());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowhead.canMirror());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowhead.canMirror());
		assertTrue(humpHitsCeiling2HumpsLargeMirrored.canMirror());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsCeiling3HumpsSmall.canMirror());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowhead.canMirror());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowhead.canMirror());
		assertTrue(humpHitsCeiling3HumpsSmallMirrored.canMirror());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsCeiling3HumpsLarge.canMirror());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowhead.canMirror());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowhead.canMirror());
		assertTrue(humpHitsCeiling3HumpsLargeMirrored.canMirror());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsCeilingSmallSingle.canMirror());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowhead.canMirror());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowhead.canMirror());
		assertTrue(loopHitsCeilingSmallSingleMirrored.canMirror());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsCeilingLargeSingle.canMirror());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowhead.canMirror());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowhead.canMirror());
		assertTrue(loopHitsCeilingLargeSingleMirrored.canMirror());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsCeilingSmallDouble.canMirror());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowhead.canMirror());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowhead.canMirror());
		assertTrue(loopHitsCeilingSmallDoubleMirrored.canMirror());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsCeilingLargeDouble.canMirror());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowhead.canMirror());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowhead.canMirror());
		assertTrue(loopHitsCeilingLargeDoubleMirrored.canMirror());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(waveHitsCeilingSmall.canMirror());
		assertTrue(waveHitsCeilingSmallEmptyArrowhead.canMirror());
		assertTrue(waveHitsCeilingSmallSchemaArrowhead.canMirror());
		assertTrue(waveHitsCeilingSmallMirrored.canMirror());
		assertTrue(waveHitsCeilingSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(waveHitsCeilingSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(waveHitsCeilingLarge.canMirror());
		assertTrue(waveHitsCeilingLargeEmptyArrowhead.canMirror());
		assertTrue(waveHitsCeilingLargeSchemaArrowhead.canMirror());
		assertTrue(waveHitsCeilingLargeMirrored.canMirror());
		assertTrue(waveHitsCeilingLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(waveHitsCeilingLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationSingleHitsCeiling.canMirror());
		assertTrue(rotationSingleHitsCeilingEmptyArrowhead.canMirror());
		assertTrue(rotationSingleHitsCeilingSchemaArrowhead.canMirror());
		assertTrue(rotationSingleHitsCeilingMirrored.canMirror());
		assertTrue(rotationSingleHitsCeilingEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationSingleHitsCeilingSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationDoubleHitsCeiling.canMirror());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canMirror());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canMirror());
		assertTrue(rotationDoubleHitsCeilingMirrored.canMirror());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationAlternatingHitsCeiling.canMirror());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsCeilingMirrored.canMirror());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canMirror());

		assertTrue(curveHitsFloorSmall.canMirror());
		assertTrue(curveHitsFloorSmallEmptyArrowhead.canMirror());
		assertTrue(curveHitsFloorSmallSchemaArrowhead.canMirror());
		assertTrue(curveHitsFloorSmallMirrored.canMirror());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(curveHitsFloorSmallSmall.canMirror());
		assertTrue(curveHitsFloorSmallEmptyArrowheadSmall.canMirror());
		assertTrue(curveHitsFloorSmallSchemaArrowheadSmall.canMirror());
		assertTrue(curveHitsFloorSmallMirroredSmall.canMirror());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canMirror());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canMirror());

		assertTrue(curveHitsFloorLarge.canMirror());
		assertTrue(curveHitsFloorLargeEmptyArrowhead.canMirror());
		assertTrue(curveHitsFloorLargeSchemaArrowhead.canMirror());
		assertTrue(curveHitsFloorLargeMirrored.canMirror());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(curveHitsFloorLargeSmall.canMirror());
		assertTrue(curveHitsFloorLargeEmptyArrowheadSmall.canMirror());
		assertTrue(curveHitsFloorLargeSchemaArrowheadSmall.canMirror());
		assertTrue(curveHitsFloorLargeMirroredSmall.canMirror());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canMirror());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canMirror());

		assertTrue(humpHitsFloor2HumpsSmall.canMirror());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowhead.canMirror());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowhead.canMirror());
		assertTrue(humpHitsFloor2HumpsSmallMirrored.canMirror());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsFloor2HumpsLarge.canMirror());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowhead.canMirror());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowhead.canMirror());
		assertTrue(humpHitsFloor2HumpsLargeMirrored.canMirror());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsFloor3HumpsSmall.canMirror());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowhead.canMirror());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowhead.canMirror());
		assertTrue(humpHitsFloor3HumpsSmallMirrored.canMirror());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(humpHitsFloor3HumpsLarge.canMirror());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowhead.canMirror());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowhead.canMirror());
		assertTrue(humpHitsFloor3HumpsLargeMirrored.canMirror());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsFloorSmallSingle.canMirror());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowhead.canMirror());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowhead.canMirror());
		assertTrue(loopHitsFloorSmallSingleMirrored.canMirror());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsFloorLargeSingle.canMirror());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowhead.canMirror());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowhead.canMirror());
		assertTrue(loopHitsFloorLargeSingleMirrored.canMirror());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsFloorSmallDouble.canMirror());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowhead.canMirror());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowhead.canMirror());
		assertTrue(loopHitsFloorSmallDoubleMirrored.canMirror());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(loopHitsFloorLargeDouble.canMirror());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowhead.canMirror());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowhead.canMirror());
		assertTrue(loopHitsFloorLargeDoubleMirrored.canMirror());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canMirror());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canMirror());

		assertTrue(waveHitsFloorSmall.canMirror());
		assertTrue(waveHitsFloorSmallEmptyArrowhead.canMirror());
		assertTrue(waveHitsFloorSmallSchemaArrowhead.canMirror());
		assertTrue(waveHitsFloorSmallMirrored.canMirror());
		assertTrue(waveHitsFloorSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(waveHitsFloorSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(waveHitsFloorLarge.canMirror());
		assertTrue(waveHitsFloorLargeEmptyArrowhead.canMirror());
		assertTrue(waveHitsFloorLargeSchemaArrowhead.canMirror());
		assertTrue(waveHitsFloorLargeMirrored.canMirror());
		assertTrue(waveHitsFloorLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(waveHitsFloorLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationSingleHitsFloor.canMirror());
		assertTrue(rotationSingleHitsFloorEmptyArrowhead.canMirror());
		assertTrue(rotationSingleHitsFloorSchemaArrowhead.canMirror());
		assertTrue(rotationSingleHitsFloorMirrored.canMirror());
		assertTrue(rotationSingleHitsFloorEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationSingleHitsFloorSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationDoubleHitsFloor.canMirror());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canMirror());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canMirror());
		assertTrue(rotationDoubleHitsFloorMirrored.canMirror());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationAlternatingHitsFloor.canMirror());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsFloorMirrored.canMirror());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canMirror());

	}

	@Override
	public void testMirror() {

		curveHitsCeilingSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());

		curveHitsCeilingSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());

		curveHitsCeilingSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmallMirrored.getSymbol());
		curveHitsCeilingSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmallMirrored.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingSmallMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallMirroredSmall.getSymbol());
		curveHitsCeilingSmallMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallMirroredSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLarge.getSymbol());

		curveHitsCeilingLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());

		curveHitsCeilingLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());

		curveHitsCeilingLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLargeMirrored.getSymbol());
		curveHitsCeilingLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLargeMirrored.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingLargeMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeMirroredSmall.getSymbol());
		curveHitsCeilingLargeMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeMirroredSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());

		humpHitsCeiling2HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmall.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLarge.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmall.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLarge.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingle.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingleMirrored.getSymbol());
		loopHitsCeilingSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingleMirrored.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingle.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingleMirrored.getSymbol());
		loopHitsCeilingLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingleMirrored.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDouble.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDoubleMirrored.getSymbol());
		loopHitsCeilingSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDoubleMirrored.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDouble.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDoubleMirrored.getSymbol());
		loopHitsCeilingLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDoubleMirrored.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmall.getSymbol());

		waveHitsCeilingSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());

		waveHitsCeilingSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());

		waveHitsCeilingSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmallMirrored.getSymbol());
		waveHitsCeilingSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmallMirrored.getSymbol());

		waveHitsCeilingSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLarge.getSymbol());

		waveHitsCeilingLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());

		waveHitsCeilingLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());

		waveHitsCeilingLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLargeMirrored.getSymbol());
		waveHitsCeilingLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLargeMirrored.getSymbol());

		waveHitsCeilingLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeiling.getSymbol());

		rotationSingleHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());

		rotationSingleHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());

		rotationSingleHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeilingMirrored.getSymbol());
		rotationSingleHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeilingMirrored.getSymbol());

		rotationSingleHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationSingleHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeilingMirrored.getSymbol());
		rotationDoubleHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeilingMirrored.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());
		rotationAlternatingHitsCeilingMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());

		curveHitsFloorSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());

		curveHitsFloorSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmallMirrored.getSymbol());
		curveHitsFloorSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"), curveHitsFloorSmallMirrored.getSymbol());

		curveHitsFloorSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"),
				curveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"),
				curveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());

		curveHitsFloorSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"),
				curveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"),
				curveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorSmallSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"), curveHitsFloorSmallSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());

		curveHitsFloorSmallMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"), curveHitsFloorSmallMirroredSmall.getSymbol());
		curveHitsFloorSmallMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"), curveHitsFloorSmallMirroredSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallSchemaArrowheadMirroredSmall.getSymbol());

		curveHitsFloorLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLarge.getSymbol());

		curveHitsFloorLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());

		curveHitsFloorLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());

		curveHitsFloorLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLargeMirrored.getSymbol());
		curveHitsFloorLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"), curveHitsFloorLargeMirrored.getSymbol());

		curveHitsFloorLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"),
				curveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"),
				curveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());

		curveHitsFloorLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"),
				curveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"),
				curveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorLargeSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"), curveHitsFloorLargeSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());

		curveHitsFloorLargeMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"), curveHitsFloorLargeMirroredSmall.getSymbol());
		curveHitsFloorLargeMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"), curveHitsFloorLargeMirroredSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirroredSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeSchemaArrowheadMirroredSmall.getSymbol());

		humpHitsFloor2HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"), humpHitsFloor2HumpsSmall.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"), humpHitsFloor2HumpsSmallMirrored.getSymbol());
		humpHitsFloor2HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"), humpHitsFloor2HumpsSmallMirrored.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"), humpHitsFloor2HumpsLarge.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"), humpHitsFloor2HumpsLargeMirrored.getSymbol());
		humpHitsFloor2HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"), humpHitsFloor2HumpsLargeMirrored.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"), humpHitsFloor3HumpsSmall.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"), humpHitsFloor3HumpsSmallMirrored.getSymbol());
		humpHitsFloor3HumpsSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"), humpHitsFloor3HumpsSmallMirrored.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"), humpHitsFloor3HumpsLarge.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"), humpHitsFloor3HumpsLargeMirrored.getSymbol());
		humpHitsFloor3HumpsLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"), humpHitsFloor3HumpsLargeMirrored.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"), loopHitsFloorSmallSingle.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"), loopHitsFloorSmallSingleMirrored.getSymbol());
		loopHitsFloorSmallSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"), loopHitsFloorSmallSingleMirrored.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"), loopHitsFloorLargeSingle.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"), loopHitsFloorLargeSingleMirrored.getSymbol());
		loopHitsFloorLargeSingleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"), loopHitsFloorLargeSingleMirrored.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"), loopHitsFloorSmallDouble.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"), loopHitsFloorSmallDoubleMirrored.getSymbol());
		loopHitsFloorSmallDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"), loopHitsFloorSmallDoubleMirrored.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"), loopHitsFloorLargeDouble.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"), loopHitsFloorLargeDoubleMirrored.getSymbol());
		loopHitsFloorLargeDoubleMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"), loopHitsFloorLargeDoubleMirrored.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleSchemaArrowheadMirrored.getSymbol());

		waveHitsFloorSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmall.getSymbol());

		waveHitsFloorSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());

		waveHitsFloorSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());

		waveHitsFloorSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmallMirrored.getSymbol());
		waveHitsFloorSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"), waveHitsFloorSmallMirrored.getSymbol());

		waveHitsFloorSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"),
				waveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"),
				waveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());

		waveHitsFloorSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"),
				waveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"),
				waveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());

		waveHitsFloorLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLarge.getSymbol());

		waveHitsFloorLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());

		waveHitsFloorLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());

		waveHitsFloorLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLargeMirrored.getSymbol());
		waveHitsFloorLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"), waveHitsFloorLargeMirrored.getSymbol());

		waveHitsFloorLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"),
				waveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"),
				waveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());

		waveHitsFloorLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"),
				waveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"),
				waveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"), rotationSingleHitsFloor.getSymbol());

		rotationSingleHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());

		rotationSingleHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());

		rotationSingleHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"), rotationSingleHitsFloorMirrored.getSymbol());
		rotationSingleHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"), rotationSingleHitsFloorMirrored.getSymbol());

		rotationSingleHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationSingleHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"), rotationDoubleHitsFloor.getSymbol());

		rotationDoubleHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());

		rotationDoubleHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());

		rotationDoubleHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"), rotationDoubleHitsFloorMirrored.getSymbol());
		rotationDoubleHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"), rotationDoubleHitsFloorMirrored.getSymbol());

		rotationDoubleHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"), rotationAlternatingHitsFloor.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"),
				rotationAlternatingHitsFloorMirrored.getSymbol());
		rotationAlternatingHitsFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"),
				rotationAlternatingHitsFloorMirrored.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertTrue(curveHitsCeilingSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallMirrored.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveHitsCeilingSmallSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canMirrorVertically());

		assertTrue(curveHitsCeilingLarge.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeMirrored.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveHitsCeilingLargeSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canMirrorVertically());

		assertTrue(humpHitsCeiling2HumpsSmall.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsSmallMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsCeiling2HumpsLarge.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsLargeMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsCeiling3HumpsSmall.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsSmallMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsCeiling3HumpsLarge.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsLargeMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsCeilingSmallSingle.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallSingleMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsCeilingLargeSingle.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeSingleMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsCeilingSmallDouble.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallDoubleMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsCeilingLargeDouble.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeDoubleMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveHitsCeilingSmall.canMirrorVertically());
		assertTrue(waveHitsCeilingSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsCeilingSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(waveHitsCeilingSmallMirrored.canMirrorVertically());
		assertTrue(waveHitsCeilingSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveHitsCeilingSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveHitsCeilingLarge.canMirrorVertically());
		assertTrue(waveHitsCeilingLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsCeilingLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(waveHitsCeilingLargeMirrored.canMirrorVertically());
		assertTrue(waveHitsCeilingLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveHitsCeilingLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationSingleHitsCeiling.canMirrorVertically());
		assertTrue(rotationSingleHitsCeilingEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsCeilingSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsCeilingMirrored.canMirrorVertically());
		assertTrue(rotationSingleHitsCeilingEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationSingleHitsCeilingSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationDoubleHitsCeiling.canMirrorVertically());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsCeilingMirrored.canMirrorVertically());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationAlternatingHitsCeiling.canMirrorVertically());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsCeilingMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveHitsFloorSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsFloorSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(curveHitsFloorSmallMirrored.canMirrorVertically());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveHitsFloorSmallSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallEmptyArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallSchemaArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canMirrorVertically());

		assertTrue(curveHitsFloorLarge.canMirrorVertically());
		assertTrue(curveHitsFloorLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsFloorLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(curveHitsFloorLargeMirrored.canMirrorVertically());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveHitsFloorLargeSmall.canMirrorVertically());
		assertTrue(curveHitsFloorLargeEmptyArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsFloorLargeSchemaArrowheadSmall.canMirrorVertically());
		assertTrue(curveHitsFloorLargeMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canMirrorVertically());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canMirrorVertically());

		assertTrue(humpHitsFloor2HumpsSmall.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsSmallMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsFloor2HumpsLarge.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsLargeMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsFloor3HumpsSmall.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsSmallMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpHitsFloor3HumpsLarge.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsLargeMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsFloorSmallSingle.canMirrorVertically());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorSmallSingleMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsFloorLargeSingle.canMirrorVertically());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorLargeSingleMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsFloorSmallDouble.canMirrorVertically());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorSmallDoubleMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopHitsFloorLargeDouble.canMirrorVertically());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowhead.canMirrorVertically());
		assertTrue(loopHitsFloorLargeDoubleMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveHitsFloorSmall.canMirrorVertically());
		assertTrue(waveHitsFloorSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsFloorSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(waveHitsFloorSmallMirrored.canMirrorVertically());
		assertTrue(waveHitsFloorSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveHitsFloorSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveHitsFloorLarge.canMirrorVertically());
		assertTrue(waveHitsFloorLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsFloorLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(waveHitsFloorLargeMirrored.canMirrorVertically());
		assertTrue(waveHitsFloorLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveHitsFloorLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationSingleHitsFloor.canMirrorVertically());
		assertTrue(rotationSingleHitsFloorEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsFloorSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsFloorMirrored.canMirrorVertically());
		assertTrue(rotationSingleHitsFloorEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationSingleHitsFloorSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationDoubleHitsFloor.canMirrorVertically());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsFloorMirrored.canMirrorVertically());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationAlternatingHitsFloor.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFloorMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		curveHitsCeilingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-05"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-05"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());

		curveHitsCeilingSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-05"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());

		curveHitsCeilingSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-06"), curveHitsCeilingSmallMirrored.getSymbol());
		curveHitsCeilingSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmallMirrored.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-06"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-06"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-05"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-05"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-05"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingSmallMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-06"), curveHitsCeilingSmallMirroredSmall.getSymbol());
		curveHitsCeilingSmallMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallMirroredSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-06"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-06"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-05"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLarge.getSymbol());

		curveHitsCeilingLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-05"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());

		curveHitsCeilingLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-05"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());

		curveHitsCeilingLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-06"), curveHitsCeilingLargeMirrored.getSymbol());
		curveHitsCeilingLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLargeMirrored.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-06"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-06"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-05"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-05"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-05"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingLargeMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-06"), curveHitsCeilingLargeMirroredSmall.getSymbol());
		curveHitsCeilingLargeMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeMirroredSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-06"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-06"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());

		humpHitsCeiling2HumpsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-05"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmall.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-05"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-05"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-06"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-06"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-06"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-05"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLarge.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-05"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-05"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-06"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-06"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-06"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-05"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmall.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-05"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-05"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-06"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-06"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-06"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-05"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLarge.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-05"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-05"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-06"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-06"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-06"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingle.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-05"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingle.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-05"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-05"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallSingleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-06"), loopHitsCeilingSmallSingleMirrored.getSymbol());
		loopHitsCeilingSmallSingleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingleMirrored.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-06"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-06"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDouble.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-05"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDouble.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-05"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-05"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-06"), loopHitsCeilingSmallDoubleMirrored.getSymbol());
		loopHitsCeilingSmallDoubleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDoubleMirrored.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-06"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-06"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingle.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-05"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingle.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-05"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-05"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeSingleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-06"), loopHitsCeilingLargeSingleMirrored.getSymbol());
		loopHitsCeilingLargeSingleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingleMirrored.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-06"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-06"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDouble.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-05"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDouble.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-05"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-05"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-06"), loopHitsCeilingLargeDoubleMirrored.getSymbol());
		loopHitsCeilingLargeDoubleMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDoubleMirrored.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-06"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-06"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-05"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmall.getSymbol());

		waveHitsCeilingSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-05"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());

		waveHitsCeilingSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-05"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());

		waveHitsCeilingSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-06"), waveHitsCeilingSmallMirrored.getSymbol());
		waveHitsCeilingSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmallMirrored.getSymbol());

		waveHitsCeilingSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-06"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-06"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-05"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLarge.getSymbol());

		waveHitsCeilingLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-05"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());

		waveHitsCeilingLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-05"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());

		waveHitsCeilingLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-06"), waveHitsCeilingLargeMirrored.getSymbol());
		waveHitsCeilingLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLargeMirrored.getSymbol());

		waveHitsCeilingLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-06"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-06"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-05"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeiling.getSymbol());

		rotationSingleHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-05"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());

		rotationSingleHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-05"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());

		rotationSingleHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-06"), rotationSingleHitsCeilingMirrored.getSymbol());
		rotationSingleHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeilingMirrored.getSymbol());

		rotationSingleHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-06"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationSingleHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-06"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-05"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-05"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-05"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-06"), rotationDoubleHitsCeilingMirrored.getSymbol());
		rotationDoubleHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeilingMirrored.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-06"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-06"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-05"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-05"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-05"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-06"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());
		rotationAlternatingHitsCeilingMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-06"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-06"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorSmall.mirrorVertically();
		curveHitsFloorSmallEmptyArrowhead.mirrorVertically();
		curveHitsFloorSmallSchemaArrowhead.mirrorVertically();
		curveHitsFloorSmallMirrored.mirrorVertically();
		curveHitsFloorSmallEmptyArrowheadMirrored.mirrorVertically();
		curveHitsFloorSmallSchemaArrowheadMirrored.mirrorVertically();

		curveHitsFloorSmallSmall.mirrorVertically();
		curveHitsFloorSmallEmptyArrowheadSmall.mirrorVertically();
		curveHitsFloorSmallSchemaArrowheadSmall.mirrorVertically();
		curveHitsFloorSmallMirroredSmall.mirrorVertically();
		curveHitsFloorSmallEmptyArrowheadMirroredSmall.mirrorVertically();
		curveHitsFloorSmallSchemaArrowheadMirroredSmall.mirrorVertically();

		curveHitsFloorLarge.mirrorVertically();
		curveHitsFloorLargeEmptyArrowhead.mirrorVertically();
		curveHitsFloorLargeSchemaArrowhead.mirrorVertically();
		curveHitsFloorLargeMirrored.mirrorVertically();
		curveHitsFloorLargeEmptyArrowheadMirrored.mirrorVertically();
		curveHitsFloorLargeSchemaArrowheadMirrored.mirrorVertically();

		curveHitsFloorLargeSmall.mirrorVertically();
		curveHitsFloorLargeEmptyArrowheadSmall.mirrorVertically();
		curveHitsFloorLargeSchemaArrowheadSmall.mirrorVertically();
		curveHitsFloorLargeMirroredSmall.mirrorVertically();
		curveHitsFloorLargeEmptyArrowheadMirroredSmall.mirrorVertically();
		curveHitsFloorLargeSchemaArrowheadMirroredSmall.mirrorVertically();

		humpHitsFloor2HumpsSmall.mirrorVertically();
		humpHitsFloor2HumpsSmallEmptyArrowhead.mirrorVertically();
		humpHitsFloor2HumpsSmallSchemaArrowhead.mirrorVertically();
		humpHitsFloor2HumpsSmallMirrored.mirrorVertically();
		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.mirrorVertically();

		humpHitsFloor2HumpsLarge.mirrorVertically();
		humpHitsFloor2HumpsLargeEmptyArrowhead.mirrorVertically();
		humpHitsFloor2HumpsLargeSchemaArrowhead.mirrorVertically();
		humpHitsFloor2HumpsLargeMirrored.mirrorVertically();
		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.mirrorVertically();

		humpHitsFloor3HumpsSmall.mirrorVertically();
		humpHitsFloor3HumpsSmallEmptyArrowhead.mirrorVertically();
		humpHitsFloor3HumpsSmallSchemaArrowhead.mirrorVertically();
		humpHitsFloor3HumpsSmallMirrored.mirrorVertically();
		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.mirrorVertically();
		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.mirrorVertically();

		humpHitsFloor3HumpsLarge.mirrorVertically();
		humpHitsFloor3HumpsLargeEmptyArrowhead.mirrorVertically();
		humpHitsFloor3HumpsLargeSchemaArrowhead.mirrorVertically();
		humpHitsFloor3HumpsLargeMirrored.mirrorVertically();
		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.mirrorVertically();
		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.mirrorVertically();

		loopHitsFloorSmallSingle.mirrorVertically();
		loopHitsFloorSmallSingleEmptyArrowhead.mirrorVertically();
		loopHitsFloorSmallSingleSchemaArrowhead.mirrorVertically();
		loopHitsFloorSmallSingleMirrored.mirrorVertically();
		loopHitsFloorSmallSingleEmptyArrowheadMirrored.mirrorVertically();
		loopHitsFloorSmallSingleSchemaArrowheadMirrored.mirrorVertically();

		loopHitsFloorLargeSingle.mirrorVertically();
		loopHitsFloorLargeSingleEmptyArrowhead.mirrorVertically();
		loopHitsFloorLargeSingleSchemaArrowhead.mirrorVertically();
		loopHitsFloorLargeSingleMirrored.mirrorVertically();
		loopHitsFloorLargeSingleEmptyArrowheadMirrored.mirrorVertically();
		loopHitsFloorLargeSingleSchemaArrowheadMirrored.mirrorVertically();

		loopHitsFloorSmallDouble.mirrorVertically();
		loopHitsFloorSmallDoubleEmptyArrowhead.mirrorVertically();
		loopHitsFloorSmallDoubleSchemaArrowhead.mirrorVertically();
		loopHitsFloorSmallDoubleMirrored.mirrorVertically();
		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.mirrorVertically();
		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.mirrorVertically();

		loopHitsFloorLargeDouble.mirrorVertically();
		loopHitsFloorLargeDoubleEmptyArrowhead.mirrorVertically();
		loopHitsFloorLargeDoubleSchemaArrowhead.mirrorVertically();
		loopHitsFloorLargeDoubleMirrored.mirrorVertically();
		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.mirrorVertically();
		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.mirrorVertically();

		waveHitsFloorSmall.mirrorVertically();
		waveHitsFloorSmallEmptyArrowhead.mirrorVertically();
		waveHitsFloorSmallSchemaArrowhead.mirrorVertically();
		waveHitsFloorSmallMirrored.mirrorVertically();
		waveHitsFloorSmallEmptyArrowheadMirrored.mirrorVertically();
		waveHitsFloorSmallSchemaArrowheadMirrored.mirrorVertically();

		waveHitsFloorLarge.mirrorVertically();
		waveHitsFloorLargeEmptyArrowhead.mirrorVertically();
		waveHitsFloorLargeSchemaArrowhead.mirrorVertically();
		waveHitsFloorLargeMirrored.mirrorVertically();
		waveHitsFloorLargeEmptyArrowheadMirrored.mirrorVertically();
		waveHitsFloorLargeSchemaArrowheadMirrored.mirrorVertically();

		rotationSingleHitsFloor.mirrorVertically();
		rotationSingleHitsFloorEmptyArrowhead.mirrorVertically();
		rotationSingleHitsFloorSchemaArrowhead.mirrorVertically();
		rotationSingleHitsFloorMirrored.mirrorVertically();
		rotationSingleHitsFloorEmptyArrowheadMirrored.mirrorVertically();
		rotationSingleHitsFloorSchemaArrowheadMirrored.mirrorVertically();

		rotationDoubleHitsFloor.mirrorVertically();
		rotationDoubleHitsFloorEmptyArrowhead.mirrorVertically();
		rotationDoubleHitsFloorSchemaArrowhead.mirrorVertically();
		rotationDoubleHitsFloorMirrored.mirrorVertically();
		rotationDoubleHitsFloorEmptyArrowheadMirrored.mirrorVertically();
		rotationDoubleHitsFloorSchemaArrowheadMirrored.mirrorVertically();

		rotationAlternatingHitsFloor.mirrorVertically();
		rotationAlternatingHitsFloorEmptyArrowhead.mirrorVertically();
		rotationAlternatingHitsFloorSchemaArrowhead.mirrorVertically();
		rotationAlternatingHitsFloorMirrored.mirrorVertically();
		rotationAlternatingHitsFloorEmptyArrowheadMirrored.mirrorVertically();
		rotationAlternatingHitsFloorSchemaArrowheadMirrored.mirrorVertically();

	}

	@Override
	public void testCanPitch() {

		assertFalse(curveHitsCeilingSmall.canPitch());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canPitch());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canPitch());
		assertFalse(curveHitsCeilingSmallMirrored.canPitch());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(curveHitsCeilingSmallSmall.canPitch());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canPitch());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canPitch());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canPitch());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canPitch());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canPitch());

		assertFalse(curveHitsCeilingLarge.canPitch());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canPitch());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canPitch());
		assertFalse(curveHitsCeilingLargeMirrored.canPitch());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(curveHitsCeilingLargeSmall.canPitch());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canPitch());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canPitch());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canPitch());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canPitch());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canPitch());

		assertFalse(humpHitsCeiling2HumpsSmall.canPitch());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canPitch());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canPitch());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canPitch());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsCeiling2HumpsLarge.canPitch());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canPitch());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canPitch());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canPitch());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsCeiling3HumpsSmall.canPitch());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canPitch());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canPitch());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canPitch());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsCeiling3HumpsLarge.canPitch());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canPitch());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canPitch());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canPitch());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsCeilingSmallSingle.canPitch());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canPitch());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canPitch());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canPitch());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsCeilingLargeSingle.canPitch());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canPitch());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canPitch());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canPitch());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsCeilingSmallDouble.canPitch());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canPitch());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canPitch());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canPitch());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsCeilingLargeDouble.canPitch());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canPitch());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canPitch());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canPitch());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(waveHitsCeilingSmall.canPitch());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canPitch());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canPitch());
		assertFalse(waveHitsCeilingSmallMirrored.canPitch());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(waveHitsCeilingLarge.canPitch());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canPitch());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canPitch());
		assertFalse(waveHitsCeilingLargeMirrored.canPitch());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationSingleHitsCeiling.canPitch());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canPitch());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canPitch());
		assertFalse(rotationSingleHitsCeilingMirrored.canPitch());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationDoubleHitsCeiling.canPitch());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canPitch());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canPitch());
		assertFalse(rotationDoubleHitsCeilingMirrored.canPitch());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationAlternatingHitsCeiling.canPitch());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canPitch());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canPitch());

		assertFalse(curveHitsFloorSmall.canPitch());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canPitch());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canPitch());
		assertFalse(curveHitsFloorSmallMirrored.canPitch());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(curveHitsFloorSmallSmall.canPitch());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canPitch());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canPitch());
		assertFalse(curveHitsFloorSmallMirroredSmall.canPitch());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canPitch());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canPitch());

		assertFalse(curveHitsFloorLarge.canPitch());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canPitch());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canPitch());
		assertFalse(curveHitsFloorLargeMirrored.canPitch());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(curveHitsFloorLargeSmall.canPitch());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canPitch());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canPitch());
		assertFalse(curveHitsFloorLargeMirroredSmall.canPitch());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canPitch());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canPitch());

		assertFalse(humpHitsFloor2HumpsSmall.canPitch());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canPitch());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canPitch());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canPitch());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsFloor2HumpsLarge.canPitch());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canPitch());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canPitch());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canPitch());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsFloor3HumpsSmall.canPitch());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canPitch());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canPitch());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canPitch());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(humpHitsFloor3HumpsLarge.canPitch());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canPitch());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canPitch());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canPitch());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsFloorSmallSingle.canPitch());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canPitch());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canPitch());
		assertFalse(loopHitsFloorSmallSingleMirrored.canPitch());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsFloorLargeSingle.canPitch());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canPitch());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canPitch());
		assertFalse(loopHitsFloorLargeSingleMirrored.canPitch());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsFloorSmallDouble.canPitch());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canPitch());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canPitch());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canPitch());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(loopHitsFloorLargeDouble.canPitch());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canPitch());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canPitch());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canPitch());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canPitch());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canPitch());

		assertFalse(waveHitsFloorSmall.canPitch());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canPitch());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canPitch());
		assertFalse(waveHitsFloorSmallMirrored.canPitch());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(waveHitsFloorLarge.canPitch());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canPitch());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canPitch());
		assertFalse(waveHitsFloorLargeMirrored.canPitch());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationSingleHitsFloor.canPitch());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canPitch());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canPitch());
		assertFalse(rotationSingleHitsFloorMirrored.canPitch());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationDoubleHitsFloor.canPitch());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canPitch());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canPitch());
		assertFalse(rotationDoubleHitsFloorMirrored.canPitch());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationAlternatingHitsFloor.canPitch());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsFloorMirrored.canPitch());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(curveHitsCeilingSmall.canRoll());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canRoll());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canRoll());
		assertFalse(curveHitsCeilingSmallMirrored.canRoll());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(curveHitsCeilingSmallSmall.canRoll());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canRoll());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canRoll());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canRoll());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canRoll());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canRoll());

		assertFalse(curveHitsCeilingLarge.canRoll());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canRoll());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canRoll());
		assertFalse(curveHitsCeilingLargeMirrored.canRoll());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(curveHitsCeilingLargeSmall.canRoll());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canRoll());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canRoll());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canRoll());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canRoll());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canRoll());

		assertFalse(humpHitsCeiling2HumpsSmall.canRoll());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canRoll());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canRoll());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canRoll());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsCeiling2HumpsLarge.canRoll());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canRoll());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canRoll());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canRoll());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsCeiling3HumpsSmall.canRoll());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canRoll());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canRoll());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canRoll());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsCeiling3HumpsLarge.canRoll());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canRoll());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canRoll());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canRoll());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsCeilingSmallSingle.canRoll());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canRoll());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canRoll());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canRoll());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsCeilingLargeSingle.canRoll());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canRoll());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canRoll());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canRoll());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsCeilingSmallDouble.canRoll());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canRoll());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canRoll());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canRoll());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsCeilingLargeDouble.canRoll());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canRoll());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canRoll());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canRoll());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(waveHitsCeilingSmall.canRoll());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canRoll());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canRoll());
		assertFalse(waveHitsCeilingSmallMirrored.canRoll());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(waveHitsCeilingLarge.canRoll());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canRoll());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canRoll());
		assertFalse(waveHitsCeilingLargeMirrored.canRoll());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationSingleHitsCeiling.canRoll());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canRoll());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canRoll());
		assertFalse(rotationSingleHitsCeilingMirrored.canRoll());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationDoubleHitsCeiling.canRoll());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canRoll());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canRoll());
		assertFalse(rotationDoubleHitsCeilingMirrored.canRoll());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationAlternatingHitsCeiling.canRoll());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canRoll());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canRoll());

		assertFalse(curveHitsFloorSmall.canRoll());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canRoll());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canRoll());
		assertFalse(curveHitsFloorSmallMirrored.canRoll());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(curveHitsFloorSmallSmall.canRoll());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canRoll());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canRoll());
		assertFalse(curveHitsFloorSmallMirroredSmall.canRoll());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canRoll());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canRoll());

		assertFalse(curveHitsFloorLarge.canRoll());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canRoll());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canRoll());
		assertFalse(curveHitsFloorLargeMirrored.canRoll());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(curveHitsFloorLargeSmall.canRoll());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canRoll());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canRoll());
		assertFalse(curveHitsFloorLargeMirroredSmall.canRoll());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canRoll());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canRoll());

		assertFalse(humpHitsFloor2HumpsSmall.canRoll());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canRoll());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canRoll());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canRoll());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsFloor2HumpsLarge.canRoll());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canRoll());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canRoll());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canRoll());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsFloor3HumpsSmall.canRoll());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canRoll());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canRoll());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canRoll());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(humpHitsFloor3HumpsLarge.canRoll());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canRoll());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canRoll());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canRoll());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsFloorSmallSingle.canRoll());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canRoll());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canRoll());
		assertFalse(loopHitsFloorSmallSingleMirrored.canRoll());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsFloorLargeSingle.canRoll());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canRoll());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canRoll());
		assertFalse(loopHitsFloorLargeSingleMirrored.canRoll());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsFloorSmallDouble.canRoll());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canRoll());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canRoll());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canRoll());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(loopHitsFloorLargeDouble.canRoll());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canRoll());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canRoll());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canRoll());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canRoll());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canRoll());

		assertFalse(waveHitsFloorSmall.canRoll());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canRoll());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canRoll());
		assertFalse(waveHitsFloorSmallMirrored.canRoll());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(waveHitsFloorLarge.canRoll());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canRoll());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canRoll());
		assertFalse(waveHitsFloorLargeMirrored.canRoll());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationSingleHitsFloor.canRoll());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canRoll());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canRoll());
		assertFalse(rotationSingleHitsFloorMirrored.canRoll());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationDoubleHitsFloor.canRoll());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canRoll());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canRoll());
		assertFalse(rotationDoubleHitsFloorMirrored.canRoll());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationAlternatingHitsFloor.canRoll());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsFloorMirrored.canRoll());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertTrue(curveHitsCeilingSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallMirrored.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveHitsCeilingSmallSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canSwitchArrowHead());

		assertTrue(curveHitsCeilingLarge.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeMirrored.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveHitsCeilingLargeSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canSwitchArrowHead());

		assertTrue(humpHitsCeiling2HumpsSmall.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsSmallMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsCeiling2HumpsLarge.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsLargeMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsCeiling3HumpsSmall.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsSmallMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsCeiling3HumpsLarge.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsLargeMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsCeilingSmallSingle.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallSingleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsCeilingLargeSingle.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeSingleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsCeilingSmallDouble.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallDoubleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsCeilingLargeDouble.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeDoubleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveHitsCeilingSmall.canSwitchArrowHead());
		assertTrue(waveHitsCeilingSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsCeilingSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsCeilingSmallMirrored.canSwitchArrowHead());
		assertTrue(waveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveHitsCeilingLarge.canSwitchArrowHead());
		assertTrue(waveHitsCeilingLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsCeilingLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsCeilingLargeMirrored.canSwitchArrowHead());
		assertTrue(waveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationSingleHitsCeiling.canSwitchArrowHead());
		assertTrue(rotationSingleHitsCeilingEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsCeilingSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsCeilingMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleHitsCeilingEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleHitsCeilingSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationDoubleHitsCeiling.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsCeilingMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationAlternatingHitsCeiling.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsCeilingMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveHitsFloorSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallMirrored.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveHitsFloorSmallSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallEmptyArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallSchemaArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canSwitchArrowHead());

		assertTrue(curveHitsFloorLarge.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeMirrored.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveHitsFloorLargeSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeEmptyArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeSchemaArrowheadSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canSwitchArrowHead());
		assertTrue(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canSwitchArrowHead());

		assertTrue(humpHitsFloor2HumpsSmall.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsSmallMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsFloor2HumpsLarge.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsLargeMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsFloor3HumpsSmall.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsSmallMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpHitsFloor3HumpsLarge.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsLargeMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsFloorSmallSingle.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallSingleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsFloorLargeSingle.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeSingleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsFloorSmallDouble.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallDoubleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopHitsFloorLargeDouble.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeDoubleMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveHitsFloorSmall.canSwitchArrowHead());
		assertTrue(waveHitsFloorSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsFloorSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsFloorSmallMirrored.canSwitchArrowHead());
		assertTrue(waveHitsFloorSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveHitsFloorSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveHitsFloorLarge.canSwitchArrowHead());
		assertTrue(waveHitsFloorLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsFloorLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsFloorLargeMirrored.canSwitchArrowHead());
		assertTrue(waveHitsFloorLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveHitsFloorLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationSingleHitsFloor.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFloorEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFloorSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFloorMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFloorEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFloorSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationDoubleHitsFloor.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFloorMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationAlternatingHitsFloor.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFloorMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

		curveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"), curveHitsCeilingSmall.getSymbol());
		curveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());
		curveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"), curveHitsCeilingSmallEmptyArrowhead.getSymbol());

		curveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());
		curveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-01"),
				curveHitsCeilingSmallSchemaArrowhead.getSymbol());

		curveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"), curveHitsCeilingSmallMirrored.getSymbol());
		curveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"), curveHitsCeilingSmallMirrored.getSymbol());
		curveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"), curveHitsCeilingSmallMirrored.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"),
				curveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-01-02"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-02-02"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-03-02"),
				curveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"), curveHitsCeilingSmallSmall.getSymbol());
		curveHitsCeilingSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"), curveHitsCeilingSmallSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-01"),
				curveHitsCeilingSmallSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"), curveHitsCeilingSmallMirroredSmall.getSymbol());
		curveHitsCeilingSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"), curveHitsCeilingSmallMirroredSmall.getSymbol());
		curveHitsCeilingSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"), curveHitsCeilingSmallMirroredSmall.getSymbol());

		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-04-02"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-05-02"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-01-06-02"),
				curveHitsCeilingSmallSchemaArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"), curveHitsCeilingLarge.getSymbol());
		curveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLarge.getSymbol());

		curveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());
		curveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"), curveHitsCeilingLargeEmptyArrowhead.getSymbol());

		curveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());
		curveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-01"),
				curveHitsCeilingLargeSchemaArrowhead.getSymbol());

		curveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"), curveHitsCeilingLargeMirrored.getSymbol());
		curveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"), curveHitsCeilingLargeMirrored.getSymbol());
		curveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"), curveHitsCeilingLargeMirrored.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"),
				curveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-01-02"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-02-02"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-03-02"),
				curveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		curveHitsCeilingLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"), curveHitsCeilingLargeSmall.getSymbol());
		curveHitsCeilingLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"), curveHitsCeilingLargeSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeEmptyArrowheadSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-01"),
				curveHitsCeilingLargeSchemaArrowheadSmall.getSymbol());

		curveHitsCeilingLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"), curveHitsCeilingLargeMirroredSmall.getSymbol());
		curveHitsCeilingLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"), curveHitsCeilingLargeMirroredSmall.getSymbol());
		curveHitsCeilingLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"), curveHitsCeilingLargeMirroredSmall.getSymbol());

		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-04-02"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-05-02"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsCeilingLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-001-02-06-02"),
				curveHitsCeilingLargeSchemaArrowheadMirroredSmall.getSymbol());

		humpHitsCeiling2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"), humpHitsCeiling2HumpsSmall.getSymbol());
		humpHitsCeiling2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"), humpHitsCeiling2HumpsSmall.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-01"),
				humpHitsCeiling2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"), humpHitsCeiling2HumpsSmallMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-01-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-02-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-01-03-02"),
				humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"), humpHitsCeiling2HumpsLarge.getSymbol());
		humpHitsCeiling2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"), humpHitsCeiling2HumpsLarge.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-01"),
				humpHitsCeiling2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"), humpHitsCeiling2HumpsLargeMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-01-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-02-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-02-03-02"),
				humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"), humpHitsCeiling3HumpsSmall.getSymbol());
		humpHitsCeiling3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"), humpHitsCeiling3HumpsSmall.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-01"),
				humpHitsCeiling3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"), humpHitsCeiling3HumpsSmallMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-01-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-02-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-03-03-02"),
				humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"), humpHitsCeiling3HumpsLarge.getSymbol());
		humpHitsCeiling3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"), humpHitsCeiling3HumpsLarge.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-01"),
				humpHitsCeiling3HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsCeiling3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"), humpHitsCeiling3HumpsLargeMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-01-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-02-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-002-04-03-02"),
				humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"), loopHitsCeilingSmallSingle.getSymbol());
		loopHitsCeilingSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"), loopHitsCeilingSmallSingle.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-01"),
				loopHitsCeilingSmallSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"), loopHitsCeilingSmallSingleMirrored.getSymbol());
		loopHitsCeilingSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"), loopHitsCeilingSmallSingleMirrored.getSymbol());
		loopHitsCeilingSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"), loopHitsCeilingSmallSingleMirrored.getSymbol());

		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-01-02"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-02-02"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-01-03-02"),
				loopHitsCeilingSmallSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"), loopHitsCeilingLargeSingle.getSymbol());
		loopHitsCeilingLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"), loopHitsCeilingLargeSingle.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-01"),
				loopHitsCeilingLargeSingleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"), loopHitsCeilingLargeSingleMirrored.getSymbol());
		loopHitsCeilingLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"), loopHitsCeilingLargeSingleMirrored.getSymbol());
		loopHitsCeilingLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"), loopHitsCeilingLargeSingleMirrored.getSymbol());

		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-01-02"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-02-02"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-02-03-02"),
				loopHitsCeilingLargeSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"), loopHitsCeilingSmallDouble.getSymbol());
		loopHitsCeilingSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"), loopHitsCeilingSmallDouble.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-01"),
				loopHitsCeilingSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"), loopHitsCeilingSmallDoubleMirrored.getSymbol());
		loopHitsCeilingSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"), loopHitsCeilingSmallDoubleMirrored.getSymbol());
		loopHitsCeilingSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"), loopHitsCeilingSmallDoubleMirrored.getSymbol());

		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-01-02"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-02-02"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-03-03-02"),
				loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"), loopHitsCeilingLargeDouble.getSymbol());
		loopHitsCeilingLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"), loopHitsCeilingLargeDouble.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-01"),
				loopHitsCeilingLargeDoubleSchemaArrowhead.getSymbol());

		loopHitsCeilingLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"), loopHitsCeilingLargeDoubleMirrored.getSymbol());
		loopHitsCeilingLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"), loopHitsCeilingLargeDoubleMirrored.getSymbol());
		loopHitsCeilingLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"), loopHitsCeilingLargeDoubleMirrored.getSymbol());

		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-01-02"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-02-02"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-003-04-03-02"),
				loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmall.getSymbol());
		waveHitsCeilingSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmall.getSymbol());

		waveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());
		waveHitsCeilingSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallEmptyArrowhead.getSymbol());

		waveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());
		waveHitsCeilingSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-01"), waveHitsCeilingSmallSchemaArrowhead.getSymbol());

		waveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"), waveHitsCeilingSmallMirrored.getSymbol());
		waveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"), waveHitsCeilingSmallMirrored.getSymbol());
		waveHitsCeilingSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"), waveHitsCeilingSmallMirrored.getSymbol());

		waveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"),
				waveHitsCeilingSmallEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-01-02"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-02-02"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-01-03-02"),
				waveHitsCeilingSmallSchemaArrowheadMirrored.getSymbol());

		waveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLarge.getSymbol());
		waveHitsCeilingLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLarge.getSymbol());

		waveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());
		waveHitsCeilingLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeEmptyArrowhead.getSymbol());

		waveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());
		waveHitsCeilingLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-01"), waveHitsCeilingLargeSchemaArrowhead.getSymbol());

		waveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"), waveHitsCeilingLargeMirrored.getSymbol());
		waveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"), waveHitsCeilingLargeMirrored.getSymbol());
		waveHitsCeilingLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"), waveHitsCeilingLargeMirrored.getSymbol());

		waveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"),
				waveHitsCeilingLargeEmptyArrowheadMirrored.getSymbol());

		waveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-01-02"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-02-02"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsCeilingLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-004-02-03-02"),
				waveHitsCeilingLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"), rotationSingleHitsCeiling.getSymbol());
		rotationSingleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"), rotationSingleHitsCeiling.getSymbol());

		rotationSingleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());
		rotationSingleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingEmptyArrowhead.getSymbol());

		rotationSingleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());
		rotationSingleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-01"),
				rotationSingleHitsCeilingSchemaArrowhead.getSymbol());

		rotationSingleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"), rotationSingleHitsCeilingMirrored.getSymbol());
		rotationSingleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"), rotationSingleHitsCeilingMirrored.getSymbol());
		rotationSingleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"), rotationSingleHitsCeilingMirrored.getSymbol());

		rotationSingleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationSingleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-01-02"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-02-02"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-005-01-03-02"),
				rotationSingleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"), rotationDoubleHitsCeiling.getSymbol());
		rotationDoubleHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-01"),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"), rotationDoubleHitsCeilingMirrored.getSymbol());
		rotationDoubleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"), rotationDoubleHitsCeilingMirrored.getSymbol());
		rotationDoubleHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"), rotationDoubleHitsCeilingMirrored.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-01-02"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-02-02"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-006-01-03-02"),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"), rotationAlternatingHitsCeiling.getSymbol());
		rotationAlternatingHitsCeiling.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-01"),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());
		rotationAlternatingHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());
		rotationAlternatingHitsCeilingMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"),
				rotationAlternatingHitsCeilingMirrored.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-01-02"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-02-02"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-007-01-03-02"),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmall.getSymbol());
		curveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());
		curveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmallEmptyArrowhead.getSymbol());

		curveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());
		curveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-01"), curveHitsFloorSmallSchemaArrowhead.getSymbol());

		curveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"), curveHitsFloorSmallMirrored.getSymbol());
		curveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"), curveHitsFloorSmallMirrored.getSymbol());
		curveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"), curveHitsFloorSmallMirrored.getSymbol());

		curveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"),
				curveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"),
				curveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"),
				curveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());

		curveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-01-02"),
				curveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-02-02"),
				curveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-03-02"),
				curveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"), curveHitsFloorSmallSmall.getSymbol());
		curveHitsFloorSmallSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"), curveHitsFloorSmallSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallEmptyArrowheadSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-01"),
				curveHitsFloorSmallSchemaArrowheadSmall.getSymbol());

		curveHitsFloorSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"), curveHitsFloorSmallMirroredSmall.getSymbol());
		curveHitsFloorSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"), curveHitsFloorSmallMirroredSmall.getSymbol());
		curveHitsFloorSmallMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"), curveHitsFloorSmallMirroredSmall.getSymbol());

		curveHitsFloorSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"),
				curveHitsFloorSmallEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsFloorSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-04-02"),
				curveHitsFloorSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-05-02"),
				curveHitsFloorSmallSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorSmallSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-01-06-02"),
				curveHitsFloorSmallSchemaArrowheadMirroredSmall.getSymbol());

		curveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLarge.getSymbol());
		curveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLarge.getSymbol());

		curveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());
		curveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLargeEmptyArrowhead.getSymbol());

		curveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());
		curveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-01"), curveHitsFloorLargeSchemaArrowhead.getSymbol());

		curveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"), curveHitsFloorLargeMirrored.getSymbol());
		curveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"), curveHitsFloorLargeMirrored.getSymbol());
		curveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"), curveHitsFloorLargeMirrored.getSymbol());

		curveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"),
				curveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"),
				curveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"),
				curveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());

		curveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-01-02"),
				curveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-02-02"),
				curveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-03-02"),
				curveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());

		curveHitsFloorLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"), curveHitsFloorLargeSmall.getSymbol());
		curveHitsFloorLargeSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"), curveHitsFloorLargeSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeEmptyArrowheadSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-01"),
				curveHitsFloorLargeSchemaArrowheadSmall.getSymbol());

		curveHitsFloorLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"), curveHitsFloorLargeMirroredSmall.getSymbol());
		curveHitsFloorLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"), curveHitsFloorLargeMirroredSmall.getSymbol());
		curveHitsFloorLargeMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"), curveHitsFloorLargeMirroredSmall.getSymbol());

		curveHitsFloorLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"),
				curveHitsFloorLargeEmptyArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeEmptyArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeEmptyArrowheadMirroredSmall.getSymbol());

		curveHitsFloorLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-04-02"),
				curveHitsFloorLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-05-02"),
				curveHitsFloorLargeSchemaArrowheadMirroredSmall.getSymbol());
		curveHitsFloorLargeSchemaArrowheadMirroredSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-008-02-06-02"),
				curveHitsFloorLargeSchemaArrowheadMirroredSmall.getSymbol());

		humpHitsFloor2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"), humpHitsFloor2HumpsSmall.getSymbol());
		humpHitsFloor2HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"), humpHitsFloor2HumpsSmall.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-01"),
				humpHitsFloor2HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"), humpHitsFloor2HumpsSmallMirrored.getSymbol());
		humpHitsFloor2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"), humpHitsFloor2HumpsSmallMirrored.getSymbol());
		humpHitsFloor2HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"), humpHitsFloor2HumpsSmallMirrored.getSymbol());

		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"),
				humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-01-02"),
				humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-02-02"),
				humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-01-03-02"),
				humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"), humpHitsFloor2HumpsLarge.getSymbol());
		humpHitsFloor2HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"), humpHitsFloor2HumpsLarge.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-01"),
				humpHitsFloor2HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"), humpHitsFloor2HumpsLargeMirrored.getSymbol());
		humpHitsFloor2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"), humpHitsFloor2HumpsLargeMirrored.getSymbol());
		humpHitsFloor2HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"), humpHitsFloor2HumpsLargeMirrored.getSymbol());

		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"),
				humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-01-02"),
				humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-02-02"),
				humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-02-03-02"),
				humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"), humpHitsFloor3HumpsSmall.getSymbol());
		humpHitsFloor3HumpsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"), humpHitsFloor3HumpsSmall.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-01"),
				humpHitsFloor3HumpsSmallSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"), humpHitsFloor3HumpsSmallMirrored.getSymbol());
		humpHitsFloor3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"), humpHitsFloor3HumpsSmallMirrored.getSymbol());
		humpHitsFloor3HumpsSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"), humpHitsFloor3HumpsSmallMirrored.getSymbol());

		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"),
				humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-01-02"),
				humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-02-02"),
				humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-03-03-02"),
				humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"), humpHitsFloor3HumpsLarge.getSymbol());
		humpHitsFloor3HumpsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"), humpHitsFloor3HumpsLarge.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeEmptyArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-01"),
				humpHitsFloor3HumpsLargeSchemaArrowhead.getSymbol());

		humpHitsFloor3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"), humpHitsFloor3HumpsLargeMirrored.getSymbol());
		humpHitsFloor3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"), humpHitsFloor3HumpsLargeMirrored.getSymbol());
		humpHitsFloor3HumpsLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"), humpHitsFloor3HumpsLargeMirrored.getSymbol());

		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"),
				humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.getSymbol());

		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-01-02"),
				humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-02-02"),
				humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.getSymbol());
		humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-009-04-03-02"),
				humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"), loopHitsFloorSmallSingle.getSymbol());
		loopHitsFloorSmallSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"), loopHitsFloorSmallSingle.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-01"),
				loopHitsFloorSmallSingleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"), loopHitsFloorSmallSingleMirrored.getSymbol());
		loopHitsFloorSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"), loopHitsFloorSmallSingleMirrored.getSymbol());
		loopHitsFloorSmallSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"), loopHitsFloorSmallSingleMirrored.getSymbol());

		loopHitsFloorSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"),
				loopHitsFloorSmallSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-01-02"),
				loopHitsFloorSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-02-02"),
				loopHitsFloorSmallSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-01-03-02"),
				loopHitsFloorSmallSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"), loopHitsFloorLargeSingle.getSymbol());
		loopHitsFloorLargeSingle.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"), loopHitsFloorLargeSingle.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-01"),
				loopHitsFloorLargeSingleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"), loopHitsFloorLargeSingleMirrored.getSymbol());
		loopHitsFloorLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"), loopHitsFloorLargeSingleMirrored.getSymbol());
		loopHitsFloorLargeSingleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"), loopHitsFloorLargeSingleMirrored.getSymbol());

		loopHitsFloorLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"),
				loopHitsFloorLargeSingleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-01-02"),
				loopHitsFloorLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-02-02"),
				loopHitsFloorLargeSingleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeSingleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-02-03-02"),
				loopHitsFloorLargeSingleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"), loopHitsFloorSmallDouble.getSymbol());
		loopHitsFloorSmallDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"), loopHitsFloorSmallDouble.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-01"),
				loopHitsFloorSmallDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"), loopHitsFloorSmallDoubleMirrored.getSymbol());
		loopHitsFloorSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"), loopHitsFloorSmallDoubleMirrored.getSymbol());
		loopHitsFloorSmallDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"), loopHitsFloorSmallDoubleMirrored.getSymbol());

		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"),
				loopHitsFloorSmallDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-01-02"),
				loopHitsFloorSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-02-02"),
				loopHitsFloorSmallDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorSmallDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-03-03-02"),
				loopHitsFloorSmallDoubleSchemaArrowheadMirrored.getSymbol());

		loopHitsFloorLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"), loopHitsFloorLargeDouble.getSymbol());
		loopHitsFloorLargeDouble.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"), loopHitsFloorLargeDouble.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleEmptyArrowhead.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-01"),
				loopHitsFloorLargeDoubleSchemaArrowhead.getSymbol());

		loopHitsFloorLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"), loopHitsFloorLargeDoubleMirrored.getSymbol());
		loopHitsFloorLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"), loopHitsFloorLargeDoubleMirrored.getSymbol());
		loopHitsFloorLargeDoubleMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"), loopHitsFloorLargeDoubleMirrored.getSymbol());

		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"),
				loopHitsFloorLargeDoubleEmptyArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleEmptyArrowheadMirrored.getSymbol());

		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-01-02"),
				loopHitsFloorLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-02-02"),
				loopHitsFloorLargeDoubleSchemaArrowheadMirrored.getSymbol());
		loopHitsFloorLargeDoubleSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-010-04-03-02"),
				loopHitsFloorLargeDoubleSchemaArrowheadMirrored.getSymbol());

		waveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmall.getSymbol());
		waveHitsFloorSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmall.getSymbol());

		waveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());
		waveHitsFloorSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmallEmptyArrowhead.getSymbol());

		waveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());
		waveHitsFloorSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-01"), waveHitsFloorSmallSchemaArrowhead.getSymbol());

		waveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"), waveHitsFloorSmallMirrored.getSymbol());
		waveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"), waveHitsFloorSmallMirrored.getSymbol());
		waveHitsFloorSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"), waveHitsFloorSmallMirrored.getSymbol());

		waveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"),
				waveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"),
				waveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"),
				waveHitsFloorSmallEmptyArrowheadMirrored.getSymbol());

		waveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-01-02"),
				waveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-02-02"),
				waveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-01-03-02"),
				waveHitsFloorSmallSchemaArrowheadMirrored.getSymbol());

		waveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLarge.getSymbol());
		waveHitsFloorLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLarge.getSymbol());

		waveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());
		waveHitsFloorLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLargeEmptyArrowhead.getSymbol());

		waveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());
		waveHitsFloorLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-01"), waveHitsFloorLargeSchemaArrowhead.getSymbol());

		waveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"), waveHitsFloorLargeMirrored.getSymbol());
		waveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"), waveHitsFloorLargeMirrored.getSymbol());
		waveHitsFloorLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"), waveHitsFloorLargeMirrored.getSymbol());

		waveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"),
				waveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"),
				waveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());
		waveHitsFloorLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"),
				waveHitsFloorLargeEmptyArrowheadMirrored.getSymbol());

		waveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-01-02"),
				waveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-02-02"),
				waveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());
		waveHitsFloorLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-011-02-03-02"),
				waveHitsFloorLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"), rotationSingleHitsFloor.getSymbol());
		rotationSingleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"), rotationSingleHitsFloor.getSymbol());

		rotationSingleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());
		rotationSingleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorEmptyArrowhead.getSymbol());

		rotationSingleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());
		rotationSingleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-01"),
				rotationSingleHitsFloorSchemaArrowhead.getSymbol());

		rotationSingleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"), rotationSingleHitsFloorMirrored.getSymbol());
		rotationSingleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"), rotationSingleHitsFloorMirrored.getSymbol());
		rotationSingleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"), rotationSingleHitsFloorMirrored.getSymbol());

		rotationSingleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationSingleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-01-02"),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-02-02"),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationSingleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-012-01-03-02"),
				rotationSingleHitsFloorSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"), rotationDoubleHitsFloor.getSymbol());
		rotationDoubleHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"), rotationDoubleHitsFloor.getSymbol());

		rotationDoubleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());
		rotationDoubleHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());

		rotationDoubleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());
		rotationDoubleHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-01"),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());

		rotationDoubleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"), rotationDoubleHitsFloorMirrored.getSymbol());
		rotationDoubleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"), rotationDoubleHitsFloorMirrored.getSymbol());
		rotationDoubleHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"), rotationDoubleHitsFloorMirrored.getSymbol());

		rotationDoubleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-01-02"),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-02-02"),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationDoubleHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-013-01-03-02"),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"), rotationAlternatingHitsFloor.getSymbol());
		rotationAlternatingHitsFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"), rotationAlternatingHitsFloor.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-01"),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorMirrored.getSymbol());
		rotationAlternatingHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorMirrored.getSymbol());
		rotationAlternatingHitsFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"),
				rotationAlternatingHitsFloorMirrored.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-01-02"),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-02-02"),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingHitsFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-08-014-01-03-02"),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(curveHitsCeilingSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveHitsCeilingSmallSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canSwitchToNormalArrows());

		assertFalse(curveHitsCeilingLarge.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveHitsCeilingLargeSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canSwitchToNormalArrows());

		assertFalse(humpHitsCeiling2HumpsSmall.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsCeiling2HumpsLarge.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsCeiling3HumpsSmall.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsCeiling3HumpsLarge.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsCeilingSmallSingle.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsCeilingLargeSingle.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsCeilingSmallDouble.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsCeilingLargeDouble.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveHitsCeilingSmall.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingSmallMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveHitsCeilingLarge.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingLargeMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationSingleHitsCeiling.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsCeilingMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationDoubleHitsCeiling.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsCeilingMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertTrue(rotationAlternatingHitsCeiling.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsCeilingMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveHitsFloorSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveHitsFloorSmallSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canSwitchToNormalArrows());

		assertFalse(curveHitsFloorLarge.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveHitsFloorLargeSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canSwitchToNormalArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canSwitchToNormalArrows());

		assertFalse(humpHitsFloor2HumpsSmall.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsFloor2HumpsLarge.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsFloor3HumpsSmall.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpHitsFloor3HumpsLarge.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsFloorSmallSingle.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallSingleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsFloorLargeSingle.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeSingleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsFloorSmallDouble.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopHitsFloorLargeDouble.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveHitsFloorSmall.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorSmallMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveHitsFloorLarge.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorLargeMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationSingleHitsFloor.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFloorMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationDoubleHitsFloor.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFloorMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertTrue(rotationAlternatingHitsFloor.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFloorMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

		rotationAlternatingHitsCeiling.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeiling.getSymbol(), rotationAlternatingHitsCeiling.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeilingEmptyArrowhead.getSymbol(),
				rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeilingSchemaArrowhead.getSymbol(),
				rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol());

		rotationAlternatingHitsCeilingMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeilingMirrored.getSymbol(), rotationAlternatingHitsCeilingMirrored.getSymbol());

		rotationAlternatingHitsCeilingEmptyArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol(),
				rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsCeilingSchemaArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol(),
				rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloor.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloor.getSymbol(), rotationAlternatingHitsFloor.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloorEmptyArrowhead.getSymbol(),
				rotationAlternatingHitsFloorEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloorSchemaArrowhead.getSymbol(),
				rotationAlternatingHitsFloorSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFloorMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloorMirrored.getSymbol(), rotationAlternatingHitsFloorMirrored.getSymbol());

		rotationAlternatingHitsFloorEmptyArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol(),
				rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingHitsFloorSchemaArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol(),
				rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(curveHitsCeilingSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveHitsCeilingSmallSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canSwitchToAlternatingArrows());

		assertFalse(curveHitsCeilingLarge.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveHitsCeilingLargeSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canSwitchToAlternatingArrows());

		assertFalse(humpHitsCeiling2HumpsSmall.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsCeiling2HumpsLarge.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsCeiling3HumpsSmall.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsCeiling3HumpsLarge.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsCeilingSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsCeilingLargeSingle.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsCeilingSmallDouble.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsCeilingLargeDouble.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveHitsCeilingSmall.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveHitsCeilingLarge.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationSingleHitsCeiling.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsCeilingMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertTrue(rotationDoubleHitsCeiling.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsCeilingMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationAlternatingHitsCeiling.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveHitsFloorSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveHitsFloorSmallSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canSwitchToAlternatingArrows());

		assertFalse(curveHitsFloorLarge.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveHitsFloorLargeSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canSwitchToAlternatingArrows());

		assertFalse(humpHitsFloor2HumpsSmall.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsFloor2HumpsLarge.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsFloor3HumpsSmall.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpHitsFloor3HumpsLarge.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsFloorSmallSingle.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsFloorLargeSingle.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeSingleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsFloorSmallDouble.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopHitsFloorLargeDouble.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveHitsFloorSmall.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveHitsFloorLarge.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationSingleHitsFloor.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFloorMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertTrue(rotationDoubleHitsFloor.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFloorEmptyArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFloorSchemaArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFloorMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFloorEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFloorSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationAlternatingHitsFloor.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFloorMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

		rotationDoubleHitsCeiling.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeiling.getSymbol(), rotationDoubleHitsCeiling.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeilingEmptyArrowhead.getSymbol(),
				rotationDoubleHitsCeilingEmptyArrowhead.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeilingSchemaArrowhead.getSymbol(),
				rotationDoubleHitsCeilingSchemaArrowhead.getSymbol());

		rotationDoubleHitsCeilingMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeilingMirrored.getSymbol(), rotationDoubleHitsCeilingMirrored.getSymbol());

		rotationDoubleHitsCeilingEmptyArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleHitsCeilingEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsCeilingSchemaArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleHitsCeilingSchemaArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloor.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloor.getSymbol(), rotationDoubleHitsFloor.getSymbol());

		rotationDoubleHitsFloorEmptyArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloorEmptyArrowhead.getSymbol(),
				rotationDoubleHitsFloorEmptyArrowhead.getSymbol());

		rotationDoubleHitsFloorSchemaArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloorSchemaArrowhead.getSymbol(),
				rotationDoubleHitsFloorSchemaArrowhead.getSymbol());

		rotationDoubleHitsFloorMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloorMirrored.getSymbol(), rotationDoubleHitsFloorMirrored.getSymbol());

		rotationDoubleHitsFloorEmptyArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloorEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleHitsFloorEmptyArrowheadMirrored.getSymbol());

		rotationDoubleHitsFloorSchemaArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFloorSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleHitsFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(curveHitsCeilingSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveHitsCeilingSmallSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canSwitchStartingPoint());

		assertFalse(curveHitsCeilingLarge.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveHitsCeilingLargeSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canSwitchStartingPoint());

		assertFalse(humpHitsCeiling2HumpsSmall.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsCeiling2HumpsLarge.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsCeiling3HumpsSmall.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsCeiling3HumpsLarge.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsCeilingSmallSingle.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsCeilingLargeSingle.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsCeilingSmallDouble.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsCeilingLargeDouble.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveHitsCeilingSmall.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingSmallMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveHitsCeilingLarge.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingLargeMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationSingleHitsCeiling.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsCeilingMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationDoubleHitsCeiling.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsCeilingMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationAlternatingHitsCeiling.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveHitsFloorSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveHitsFloorSmallSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canSwitchStartingPoint());

		assertFalse(curveHitsFloorLarge.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveHitsFloorLargeSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canSwitchStartingPoint());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canSwitchStartingPoint());

		assertFalse(humpHitsFloor2HumpsSmall.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsFloor2HumpsLarge.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsFloor3HumpsSmall.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpHitsFloor3HumpsLarge.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsFloorSmallSingle.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallSingleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsFloorLargeSingle.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeSingleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsFloorSmallDouble.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopHitsFloorLargeDouble.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveHitsFloorSmall.canSwitchStartingPoint());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsFloorSmallMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveHitsFloorLarge.canSwitchStartingPoint());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsFloorLargeMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationSingleHitsFloor.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFloorMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationDoubleHitsFloor.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFloorMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationAlternatingHitsFloor.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFloorMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {

		assertFalse(curveHitsCeilingSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallMirrored.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveHitsCeilingSmallSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallEmptyArrowheadMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingSmallSchemaArrowheadMirroredSmall.canSwitchPlane());

		assertFalse(curveHitsCeilingLarge.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeMirrored.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveHitsCeilingLargeSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeEmptyArrowheadMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsCeilingLargeSchemaArrowheadMirroredSmall.canSwitchPlane());

		assertFalse(humpHitsCeiling2HumpsSmall.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsSmallMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsCeiling2HumpsLarge.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsLargeMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling2HumpsLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsCeiling3HumpsSmall.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsSmallMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsCeiling3HumpsLarge.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsLargeMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsCeiling3HumpsLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsCeilingSmallSingle.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallSingleMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsCeilingLargeSingle.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeSingleMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsCeilingSmallDouble.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallDoubleMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingSmallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsCeilingLargeDouble.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeDoubleMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsCeilingLargeDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveHitsCeilingSmall.canSwitchPlane());
		assertFalse(waveHitsCeilingSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(waveHitsCeilingSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(waveHitsCeilingSmallMirrored.canSwitchPlane());
		assertFalse(waveHitsCeilingSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveHitsCeilingSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveHitsCeilingLarge.canSwitchPlane());
		assertFalse(waveHitsCeilingLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(waveHitsCeilingLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(waveHitsCeilingLargeMirrored.canSwitchPlane());
		assertFalse(waveHitsCeilingLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveHitsCeilingLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationSingleHitsCeiling.canSwitchPlane());
		assertFalse(rotationSingleHitsCeilingEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsCeilingSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsCeilingMirrored.canSwitchPlane());
		assertFalse(rotationSingleHitsCeilingEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationSingleHitsCeilingSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationDoubleHitsCeiling.canSwitchPlane());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsCeilingMirrored.canSwitchPlane());
		assertFalse(rotationDoubleHitsCeilingEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationDoubleHitsCeilingSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationAlternatingHitsCeiling.canSwitchPlane());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsCeilingMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingHitsCeilingEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingHitsCeilingSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveHitsFloorSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(curveHitsFloorSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(curveHitsFloorSmallMirrored.canSwitchPlane());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveHitsFloorSmallSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallEmptyArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallSchemaArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallEmptyArrowheadMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsFloorSmallSchemaArrowheadMirroredSmall.canSwitchPlane());

		assertFalse(curveHitsFloorLarge.canSwitchPlane());
		assertFalse(curveHitsFloorLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(curveHitsFloorLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(curveHitsFloorLargeMirrored.canSwitchPlane());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveHitsFloorLargeSmall.canSwitchPlane());
		assertFalse(curveHitsFloorLargeEmptyArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsFloorLargeSchemaArrowheadSmall.canSwitchPlane());
		assertFalse(curveHitsFloorLargeMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsFloorLargeEmptyArrowheadMirroredSmall.canSwitchPlane());
		assertFalse(curveHitsFloorLargeSchemaArrowheadMirroredSmall.canSwitchPlane());

		assertFalse(humpHitsFloor2HumpsSmall.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsSmallMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsFloor2HumpsLarge.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsLargeMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor2HumpsLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsFloor3HumpsSmall.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsSmallMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(humpHitsFloor3HumpsLarge.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsLargeMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(humpHitsFloor3HumpsLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsFloorSmallSingle.canSwitchPlane());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorSmallSingleMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorSmallSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorSmallSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsFloorLargeSingle.canSwitchPlane());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorLargeSingleMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorLargeSingleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorLargeSingleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsFloorSmallDouble.canSwitchPlane());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorSmallDoubleMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorSmallDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorSmallDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(loopHitsFloorLargeDouble.canSwitchPlane());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowhead.canSwitchPlane());
		assertFalse(loopHitsFloorLargeDoubleMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorLargeDoubleEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(loopHitsFloorLargeDoubleSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveHitsFloorSmall.canSwitchPlane());
		assertFalse(waveHitsFloorSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(waveHitsFloorSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(waveHitsFloorSmallMirrored.canSwitchPlane());
		assertFalse(waveHitsFloorSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveHitsFloorSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveHitsFloorLarge.canSwitchPlane());
		assertFalse(waveHitsFloorLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(waveHitsFloorLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(waveHitsFloorLargeMirrored.canSwitchPlane());
		assertFalse(waveHitsFloorLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveHitsFloorLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationSingleHitsFloor.canSwitchPlane());
		assertFalse(rotationSingleHitsFloorEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsFloorSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsFloorMirrored.canSwitchPlane());
		assertFalse(rotationSingleHitsFloorEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationSingleHitsFloorSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationDoubleHitsFloor.canSwitchPlane());
		assertFalse(rotationDoubleHitsFloorEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsFloorSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsFloorMirrored.canSwitchPlane());
		assertFalse(rotationDoubleHitsFloorEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationDoubleHitsFloorSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationAlternatingHitsFloor.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFloorMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFloorEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFloorSchemaArrowheadMirrored.canSwitchPlane());
	}

	@Override
	public void testSwitchPlane() {

	}

}
